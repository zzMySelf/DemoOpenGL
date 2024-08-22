package com.baidu.wallet.passport;

import android.content.Context;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.wallet.api.WalletApiExtListener;

public class f implements WalletApiExtListener.LoginstatuSyncListener {
    public void onHandleWalletError(int i2) {
    }

    public void onWebViewLogout(Context context) {
    }

    public void syncLoginStatus(Context context, String str, final WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb) {
        SapiAccountManager.getInstance().getAccountService().web2NativeLogin((Web2NativeLoginCallback) new Web2NativeLoginCallback() {
            /* renamed from: a */
            public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
                WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb = syncLoginStatusCb;
                if (syncLoginStatusCb != null) {
                    syncLoginStatusCb.onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult.BDUSSEXPIRED);
                }
            }

            /* renamed from: b */
            public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb = syncLoginStatusCb;
                if (syncLoginStatusCb != null) {
                    syncLoginStatusCb.onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult.SUCCESS);
                }
            }

            /* renamed from: c */
            public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
                WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb = syncLoginStatusCb;
                if (syncLoginStatusCb != null) {
                    syncLoginStatusCb.onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult.FAIL);
                }
            }

            public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
                WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb = syncLoginStatusCb;
                if (syncLoginStatusCb != null) {
                    syncLoginStatusCb.onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult.BDUSSEMPTY);
                }
            }

            public void onFinish() {
            }

            public void onStart() {
            }
        }, true);
    }
}
