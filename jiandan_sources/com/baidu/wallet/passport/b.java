package com.baidu.wallet.passport;

import android.content.Context;
import com.baidu.wallet.api.WalletApiExtListener;
import com.dxm.pass_basic.callback.IDxmWeb2NativeLoginCallback;
import com.dxm.pass_basic.result.DxmWeb2NativeLoginResult;
import com.dxm.pass_gate.DxmAccountManager;

public class b implements WalletApiExtListener.LoginstatuSyncListener {
    public WalletApiExtListener.LoginstatuSyncListener a;

    public void onHandleWalletError(int i2) {
    }

    public void onWebViewLogout(Context context) {
    }

    public void syncLoginStatus(Context context, String str, final WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb) {
        DxmAccountManager.getInstance().web2NativeLogin(new IDxmWeb2NativeLoginCallback() {
            /* renamed from: a */
            public void onSuccess(DxmWeb2NativeLoginResult dxmWeb2NativeLoginResult) {
                WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb = syncLoginStatusCb;
                if (syncLoginStatusCb != null) {
                    syncLoginStatusCb.onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult.SUCCESS);
                }
            }

            /* renamed from: b */
            public void onFailure(DxmWeb2NativeLoginResult dxmWeb2NativeLoginResult) {
                WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb = syncLoginStatusCb;
                if (syncLoginStatusCb != null) {
                    syncLoginStatusCb.onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult.FAIL);
                }
            }

            public void onBdussEmpty(DxmWeb2NativeLoginResult dxmWeb2NativeLoginResult) {
                WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb = syncLoginStatusCb;
                if (syncLoginStatusCb != null) {
                    syncLoginStatusCb.onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult.BDUSSEMPTY);
                }
            }

            public void onBdussExpired(DxmWeb2NativeLoginResult dxmWeb2NativeLoginResult) {
                WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb = syncLoginStatusCb;
                if (syncLoginStatusCb != null) {
                    syncLoginStatusCb.onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult.BDUSSEXPIRED);
                }
            }

            public void onFinish() {
            }

            public void onStart() {
            }
        }, true);
    }
}
