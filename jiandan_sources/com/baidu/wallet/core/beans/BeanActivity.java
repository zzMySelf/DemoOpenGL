package com.baidu.wallet.core.beans;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.BdContextMenuView;
import com.baidu.wallet.base.widget.BdMenu;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import java.util.List;

public abstract class BeanActivity extends BaseActivity implements IBeanResponseCallback {
    public static final String TAG = "BaseActivity";
    public BeanActivity mAct;
    public Handler mHandler = null;

    public class ActionBarMenu extends BdMenu {
        public static final int MENU_ITEM_INDEX_LOGOUT = 35;

        public ActionBarMenu(View view) {
            super(view);
            add(35, ResUtils.string(this.mContext, "bd_wallet_logout"));
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
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "wallet_base_please_login"));
            AccountManager.getInstance(getActivity()).logout();
            WalletLoginHelper.getInstance().logout(false);
        } else if (i3 == -2) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "fp_get_data_fail"));
        } else if (i3 == -3) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "fp_get_data_fail"));
        } else if (i3 == -4) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "fp_get_data_fail"));
        } else if (i3 == -8) {
            WalletGlobalUtils.safeShowDialog(this, 11, "");
        } else {
            this.mDialogMsg = str;
            if (TextUtils.isEmpty(str)) {
                this.mDialogMsg = ResUtils.getString(getActivity(), "fp_get_data_fail");
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
            bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(BeanActivity.this.getActivity());
                    BeanActivity.this.onBackPressed();
                }
            });
        }
    }

    public void initHomeActionBar(String str) {
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
        if (bdActionBar != null) {
            bdActionBar.setTitle(ResUtils.string(getActivity(), str));
            bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(BeanActivity.this.getActivity());
                    BeanActivity.this.onBackPressed();
                }
            });
        }
    }

    public void onBeanExecFailure(final int i2, final int i3, final String str) {
        LogUtil.i("BeanActivity", "onBeanExecFailure. bean id = " + i2 + ", err code = " + i3 + ", err msg = " + str);
        getHandler().post(new Runnable() {
            public void run() {
                BeanActivity beanActivity = BeanActivity.this;
                if (beanActivity.mAct != null) {
                    beanActivity.handleFailure(i2, i3, str);
                }
            }
        });
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        handleFailure(i2, i3, str);
    }

    public void onBeanExecSuccess(final int i2, final Object obj, final String str) {
        getHandler().post(new Runnable() {
            public void run() {
                BeanActivity beanActivity = BeanActivity.this;
                if (beanActivity.mAct != null) {
                    beanActivity.handleResponse(i2, obj, str);
                }
            }
        });
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
