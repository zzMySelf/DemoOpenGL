package com.baidu.wallet.passport;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;

public class PassLoginDialogUtil implements NoProguard {

    public static class a {
        public static PassLoginDialogUtil a = new PassLoginDialogUtil();
    }

    public static PassLoginDialogUtil getInstance() {
        return a.a;
    }

    public void showLoginTipDialog(Context context, final ILoginBackListener iLoginBackListener, int i2, String str) {
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            if (context != null) {
                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
            }
            if (iLoginBackListener instanceof LoginBackListenerProxy) {
                LoginBackListenerProxy loginBackListenerProxy = (LoginBackListenerProxy) iLoginBackListener;
                if (loginBackListenerProxy.getLoginBackListener() != null) {
                    loginBackListenerProxy.getLoginBackListener().onFail(i2, str);
                    return;
                }
                return;
            }
            return;
        }
        final PromptDialog promptDialog = new PromptDialog(context);
        promptDialog.setMessage((CharSequence) ResUtils.getString(context, "wallet_base_open_bduss_system_error"));
        final PromptDialog promptDialog2 = promptDialog;
        final ILoginBackListener iLoginBackListener2 = iLoginBackListener;
        final int i3 = i2;
        final String str2 = str;
        promptDialog.setNegativeBtn(ResUtils.getString(context, "wallet_base_open_bduss_system_error_retry"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    promptDialog2.dismiss();
                } catch (Exception e2) {
                    LogUtil.e("PassLoginDialog", "dialog Exception", e2);
                }
                ILoginBackListener iLoginBackListener = iLoginBackListener2;
                if ((iLoginBackListener instanceof LoginBackListenerProxy) && ((LoginBackListenerProxy) iLoginBackListener).getLoginBackListener() != null) {
                    ((LoginBackListenerProxy) iLoginBackListener2).getLoginBackListener().onFail(i3, str2);
                }
            }
        });
        promptDialog.setPositiveBtn(ResUtils.getString(context, "wallet_base_open_bduss_system_error_login"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    promptDialog.dismiss();
                } catch (Exception e) {
                    LogUtil.e("PassLoginDialog", "dialog Exception", e);
                }
                WalletLoginHelper.getInstance().onlyLogin(iLoginBackListener);
            }
        });
        promptDialog.show();
    }

    public PassLoginDialogUtil() {
    }
}
