package com.dxmpay.wallet.core.beans;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.widget.BdActionBar;
import com.dxmpay.wallet.base.widget.BdContextMenuView;
import com.dxmpay.wallet.base.widget.BdMenu;
import com.dxmpay.wallet.base.widget.BdMenuItem;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import java.util.List;

public abstract class BeanActivity extends BaseActivity implements IBeanResponseCallback {
    public static final String TAG = "BaseActivity";
    public BeanActivity mAct;
    public Handler mHandler = null;

    public class ActionBarMenu extends BdMenu {
        public static final int MENU_ITEM_INDEX_LOGOUT = 35;

        public ActionBarMenu(View view) {
            super(view);
            add(35, ResUtils.string(this.mContext, "dxm_wallet_logout"));
            setDismissOnClick(true);
        }

        public void ensureMenuLoaded(View view, List<BdMenuItem> list) {
            ((BdContextMenuView) view).layoutMenu(list);
        }

        public View getMenuView(Context context) {
            return new BdContextMenuView(context);
        }

        public void showMenu(PopupWindow popupWindow) {
            popupWindow.showAsDropDown(this.mViewToAttach);
        }
    }

    public class ad implements View.OnClickListener {
        public ad() {
        }

        public void onClick(View view) {
            GlobalUtils.hideKeyboard(BeanActivity.this.getActivity());
            BeanActivity.this.onBackPressed();
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f4247ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Object f4248th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ String f4250yj;

        public de(int i2, Object obj, String str) {
            this.f4247ad = i2;
            this.f4248th = obj;
            this.f4250yj = str;
        }

        public void run() {
            BeanActivity beanActivity = BeanActivity.this;
            if (beanActivity.mAct != null) {
                beanActivity.handleResponse(this.f4247ad, this.f4248th, this.f4250yj);
            }
        }
    }

    public class fe implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f4251ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f4252th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ String f4254yj;

        public fe(int i2, int i3, String str) {
            this.f4251ad = i2;
            this.f4252th = i3;
            this.f4254yj = str;
        }

        public void run() {
            BeanActivity beanActivity = BeanActivity.this;
            if (beanActivity.mAct != null) {
                beanActivity.handleFailure(this.f4251ad, this.f4252th, this.f4254yj);
            }
        }
    }

    public class qw implements View.OnClickListener {
        public qw() {
        }

        public void onClick(View view) {
            GlobalUtils.hideKeyboard(BeanActivity.this.getActivity());
            BeanActivity.this.onBackPressed();
        }
    }

    private Handler getHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(getMainLooper());
        }
        return this.mHandler;
    }

    public BdActionBar getBdActionBar() {
        return (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
    }

    public void handleFailure(int i2, int i3, String str) {
        if (i3 == 5003) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_wallet_base_please_login"));
            AccountManager.getInstance(getActivity()).logout();
            WalletLoginHelper.getInstance().logout(false);
        } else if (i3 == -2) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_fp_get_data_fail"));
        } else if (i3 == -3) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_fp_get_data_fail"));
        } else if (i3 == -4) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_fp_get_data_fail"));
        } else if (i3 == -8) {
            WalletGlobalUtils.safeShowDialog(this, 11, "");
        } else {
            this.mDialogMsg = str;
            if (TextUtils.isEmpty(str)) {
                this.mDialogMsg = ResUtils.getString(getActivity(), "dxm_fp_get_data_fail");
            }
            GlobalUtils.toast(getActivity(), this.mDialogMsg);
        }
    }

    public abstract void handleResponse(int i2, Object obj, String str);

    public void initActionBar(String str) {
        initActionBarWithActualTitleValue(ResUtils.getString(getActivity(), str));
    }

    public void initActionBarWithActualTitleValue(String str) {
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
        if (bdActionBar != null) {
            bdActionBar.setTitle(str);
            bdActionBar.setLeftZoneOnClickListener(new ad());
        }
    }

    public void initHomeActionBar(String str) {
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
        if (bdActionBar != null) {
            bdActionBar.setTitle(ResUtils.string(getActivity(), str));
            bdActionBar.setLeftZoneOnClickListener(new qw());
        }
    }

    public void onBeanExecFailure(int i2, int i3, String str) {
        "onBeanExecFailure. bean id = " + i2 + ", err code = " + i3 + ", err msg = " + str;
        getHandler().post(new fe(i2, i3, str));
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        handleFailure(i2, i3, str);
    }

    public void onBeanExecSuccess(int i2, Object obj, String str) {
        getHandler().post(new de(i2, obj, str));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAct = this;
    }

    public void onResume() {
        super.onResume();
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
    }
}
