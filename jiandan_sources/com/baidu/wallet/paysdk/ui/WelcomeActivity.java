package com.baidu.wallet.paysdk.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.sapi2.SapiAccount;
import com.baidu.wallet.newbindcard.b.b;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.api.BindCardEntry;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.presenter.g;
import com.baidu.wallet.paysdk.presenter.k;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.statusbar.ImmersiveOSUtils;
import com.dxmpay.apollon.statusbar.ImmersiveStatusBarManager;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.SDKBaseActivity;
import com.dxmpay.wallet.core.beans.BeanActivity;
import com.dxmpay.wallet.core.beans.BeanErrorContent;
import com.dxmpay.wallet.core.utils.PassUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;

@SuppressLint({"HandlerLeak"})
public class WelcomeActivity extends PayBaseBeanActivity {
    public k a;

    private void a() {
        setContentView(ResUtils.layout(getActivity(), "dxm_wallet_base_layout_loading"));
        AnimationDrawable animationDrawable = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
        animationDrawable.stop();
        animationDrawable.start();
        setImmersiveActivityMargeinTop();
    }

    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public void handleResponse(int i2, Object obj, String str) {
    }

    public boolean isSlidingEnable() {
        return false;
    }

    public void onBackPressed() {
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        k kVar = this.a;
        if (kVar != null) {
            kVar.a(i2, i3, str, obj);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFlagPaySdk();
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra(SapiAccount.SAPI_ACCOUNT_FROMTYPE, 0);
        if (4 == intExtra) {
            BindCardEntry.setLoadingUi(this);
            BindCardEntry.innerRun();
        } else {
            k a2 = g.a(intExtra, this);
            this.a = a2;
            if (a2 != null) {
                a2.d();
                if (!this.a.a(bundle)) {
                    return;
                }
            }
        }
        a();
        PassUtil.onCreate();
        if (this.a != null) {
            if (intExtra == 3) {
                this.a.a(intent.getStringExtra("orderExtraInfo"));
            }
            PrecashierCreateOrderResponse precashierCreateOrderResponse = (PrecashierCreateOrderResponse) intent.getSerializableExtra(BaiduPay.PRECASHIER_PAY_RESPONSE);
            if (precashierCreateOrderResponse != null) {
                this.a.a(precashierCreateOrderResponse);
            } else {
                this.a.a();
            }
            this.a.g();
        }
        if (PayDataCache.getInstance().isRemotePay()) {
            StatisticManager.onEvent("remoteEnterWelcomeActivity", "onCreate");
        } else {
            StatisticManager.onEvent("enterWelcomeActivity", "onCreate");
        }
        if (ImmersiveOSUtils.isSupportStatusBarDarkFont()) {
            ImmersiveStatusBarManager.setMiuiFlymeBarDark(this.mAct.getActivity(), true);
        }
    }

    public Dialog onCreateDialog(int i2) {
        k kVar = this.a;
        if (kVar != null) {
            return kVar.a(i2);
        }
        return super.onCreateDialog(i2);
    }

    public void onDestroy() {
        super.onDestroy();
        k kVar = this.a;
        if (kVar != null) {
            kVar.e();
            this.a = null;
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        k kVar;
        if (event != null) {
            if (event.mEventKey.equals("ev_bean_execut_err_content")) {
                Object obj = event.mEventObj;
                if (obj instanceof BeanErrorContent) {
                    BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
                    onBeanExecFailureWithErrContent(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg(), beanErrorContent.getErrContent());
                    EventBus.getInstance().removeStickyEvent("ev_bean_execut_err_content");
                    return;
                }
            }
            if (event.mEventKey.equals(DxmPayBeanConstants.EVENT_H5_RN_AUTH_RESULT)) {
                BaiduPay.getInstance().payRnAuthOnModuleEvent(event);
            } else if (DxmPayBeanConstants.EVENT_H5_AUTH_ADMIT_SUBMIT.equals(event.mEventKey) && (kVar = this.a) != null && (kVar instanceof b)) {
                ((b) kVar).a(event);
            }
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        k kVar = this.a;
        if (kVar != null) {
            kVar.a();
        }
        if (PayDataCache.getInstance().isRemotePay()) {
            StatisticManager.onEvent("remoteEnterWelcomeActivity", "onNewIntent");
        } else {
            StatisticManager.onEvent("enterWelcomeActivity", "onNewIntent");
        }
    }

    public void onPause() {
        super.onPause();
        EventBus.getInstance().unregister((Object) this, "ev_bean_execut_err_content");
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        k kVar = this.a;
        if (kVar != null) {
            kVar.a(i2, dialog);
        } else {
            super.onPrepareDialog(i2, dialog);
        }
    }

    public void onResume() {
        super.onResume();
        EventBus.getInstance().register((Object) this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
    }

    public void setImmersiveActivityMargeinTop() {
        BeanActivity beanActivity;
        if (Build.VERSION.SDK_INT >= 19 && (beanActivity = this.mAct) != null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(beanActivity, "welcome_page"));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.setMargins(0, StatusBarUtils.getStatusBarHeight(this.mAct), 0, 0);
            linearLayout.setLayoutParams(layoutParams);
        }
    }
}
