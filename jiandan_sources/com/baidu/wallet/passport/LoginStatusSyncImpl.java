package com.baidu.wallet.passport;

import android.content.Context;
import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.NoProguard;

public class LoginStatusSyncImpl implements WalletApiExtListener.LoginstatuSyncListener, NoProguard {
    public WalletApiExtListener.LoginstatuSyncListener mSyncListenerProxy;

    public LoginStatusSyncImpl() {
        if (WalletLoginHelper.getInstance().isDxmLogin()) {
            this.mSyncListenerProxy = new b();
        } else {
            this.mSyncListenerProxy = new f();
        }
    }

    public void onHandleWalletError(int i2) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener = this.mSyncListenerProxy;
        if (loginstatuSyncListener != null) {
            loginstatuSyncListener.onHandleWalletError(i2);
        }
    }

    public void onWebViewLogout(Context context) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener = this.mSyncListenerProxy;
        if (loginstatuSyncListener != null) {
            loginstatuSyncListener.onWebViewLogout(context);
        }
    }

    public void syncLoginStatus(Context context, String str, WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener = this.mSyncListenerProxy;
        if (loginstatuSyncListener != null) {
            loginstatuSyncListener.syncLoginStatus(context, str, syncLoginStatusCb);
        }
    }
}
