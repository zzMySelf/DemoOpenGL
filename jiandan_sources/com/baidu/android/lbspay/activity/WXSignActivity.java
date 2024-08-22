package com.baidu.android.lbspay.activity;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.aiscan.R;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.beans.LbsPayBeanFactory;
import com.baidu.android.lbspay.beans.SignResultBean;
import com.baidu.android.lbspay.datamodel.LBSOriginalPayBackManage;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.beans.BeanActivity;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.utils.StatHelper;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;

public class WXSignActivity extends BeanActivity {
    public static final String SIGN_REQUEST_URL = "sign_request_url";
    public static final String TAG = "com.baidu.android.lbspay.activity.WXSignActivity";
    public static final String WX_PRE_SIGN_ID = "pre_entrustweb_id";
    public AnimationDrawable mAnimationDrawable;
    public boolean mFromWX = false;
    public Handler mHandler = new Handler();
    public int mQueryCount = 0;

    private void polling() {
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                WXSignActivity.this.signResultQuery();
            }
        }, 50);
    }

    /* access modifiers changed from: private */
    public void signResultQuery() {
        this.mFromWX = false;
        SignResultBean signResultBean = (SignResultBean) LbsPayBeanFactory.getInstance().getBean((Context) this, 4, TAG);
        signResultBean.setUrl(getIntent().getStringExtra(SIGN_REQUEST_URL));
        signResultBean.setResponseCallback(this);
        signResultBean.execBean();
    }

    private void startWXSign(String str) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, (String) null);
        createWXAPI.registerApp(PayDataCache.getInstance().getmWxAppId());
        WXOpenBusinessWebview.Req req = new WXOpenBusinessWebview.Req();
        req.businessType = 12;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(WX_PRE_SIGN_ID, str);
        req.queryInfo = hashMap;
        if (!createWXAPI.isWXAppInstalled()) {
            StatHelper.signServiceEvent(PayStatServiceEvent.LBS_WX_API_RESULT, "-1", getString(R.string.lbspay_pay_no_instll_wx));
            LBSOriginalPayBackManage.getInstance().originalCallbackResult(PayChannelController.WXPAY_PAYCHANNEL, "3", getString(R.string.lbspay_pay_no_instll_wx));
            LBSPayResult.payResult((Context) null, 3, getString(R.string.lbspay_pay_no_instll_wx));
            finish();
        } else if (createWXAPI.sendReq(req)) {
            this.mFromWX = true;
            StatHelper.signServiceEvent(PayStatServiceEvent.LBS_WX_API_RESULT, "0", getString(R.string.lbspay_pay_wx_api_success));
        } else {
            StatHelper.signServiceEvent(PayStatServiceEvent.LBS_WX_API_RESULT, "-1", getString(R.string.lbspay_pay_wx_api_fail));
            LBSOriginalPayBackManage.getInstance().originalCallbackResult(PayChannelController.WXPAY_PAYCHANNEL, "3", getString(R.string.lbspay_pay_wx_api_fail));
            LBSPayResult.payResult((Context) null, 3, getString(R.string.lbspay_pay_wx_api_fail));
            finish();
        }
    }

    public void handleFailure(int i2, int i3, String str) {
        int i4 = this.mQueryCount + 1;
        this.mQueryCount = i4;
        if (i4 < 4) {
            polling();
            return;
        }
        hideLoading();
        LBSOriginalPayBackManage instance = LBSOriginalPayBackManage.getInstance();
        instance.originalCallbackResult(PayChannelController.WXPAY_PAYCHANNEL, i3 + "", str);
        StatHelper.signServiceEvent(PayStatServiceEvent.LBS_QUERY_SIGN_RESULT, "-1", str);
        LBSPayResult.payResult(this, 3, str);
        finish();
    }

    public void handleResponse(int i2, Object obj, String str) {
        hideLoading();
        LBSOriginalPayBackManage.getInstance().originalCallbackResult(PayChannelController.WXPAY_PAYCHANNEL, "0", getString(R.string.lbspay_pay_sign_result_query_success));
        StatHelper.signServiceEvent(PayStatServiceEvent.LBS_QUERY_SIGN_RESULT, "0", getString(R.string.lbspay_pay_sign_result_query_success));
        LBSPayResult.payResult(this, 0, getString(R.string.lbspay_pay_sign_result_query_success));
        finish();
    }

    public void hideLoading() {
        if (this.mAnimationDrawable == null) {
            this.mAnimationDrawable = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
        }
        this.mAnimationDrawable.stop();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResUtils.layout(getActivity(), "wallet_juhe_layout_loading"));
        this.mAnimationDrawable = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
    }

    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(TAG);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        AnimationDrawable animationDrawable = this.mAnimationDrawable;
        if (animationDrawable != null && animationDrawable.isRunning()) {
            this.mAnimationDrawable.stop();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.mFromWX) {
            showLoading();
            StatHelper.signServiceEvent(PayStatServiceEvent.LBS_QUERY_SIGN_ENTER, new String[0]);
            signResultQuery();
            return;
        }
        StatHelper.signServiceEvent(PayStatServiceEvent.LBS_WX_API_ENTER, new String[0]);
        startWXSign(getIntent().getStringExtra(WX_PRE_SIGN_ID));
    }

    public void setImmersiveActivityMargeinTop() {
        if (Build.VERSION.SDK_INT >= 19 && getActivity() != null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(getActivity(), "welcome_page"));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.setMargins(0, StatusBarUtils.getStatusBarHeight(getActivity()), 0, 0);
            linearLayout.setLayoutParams(layoutParams);
        }
    }

    public void showLoading() {
        if (this.mAnimationDrawable == null) {
            this.mAnimationDrawable = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
        }
        this.mAnimationDrawable.start();
        setImmersiveActivityMargeinTop();
    }
}
