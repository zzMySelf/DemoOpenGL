package com.baidu.wallet.api;

import android.app.Activity;
import android.content.Context;
import java.util.Map;

public interface WalletApiExtListener {

    public interface LoginstatuSyncListener {
        void onHandleWalletError(int i2);

        void onWebViewLogout(Context context);

        void syncLoginStatus(Context context, String str, SyncLoginStatusCb syncLoginStatusCb);
    }

    public interface SensorsAdapter {
        void sendPerformanceInfo(Map<String, String> map);
    }

    public interface SyncLoginStatusCb {

        public enum SyncResult {
            SUCCESS(0),
            FAIL(1),
            BDUSSEMPTY(2),
            BDUSSEXPIRED(3);
            
            public int val;

            /* access modifiers changed from: public */
            SyncResult(int i2) {
                this.val = i2;
            }

            public int getVal() {
                return this.val;
            }
        }

        void onResult(SyncResult syncResult);
    }

    public interface ThirdPartyLoginInterface {
        void callBindPhone(Activity activity, ThirdPartyLoginListener thirdPartyLoginListener);

        void callTuristNormalize(Activity activity, ThirdPartyLoginListener thirdPartyLoginListener);
    }

    public interface ThirdPartyLoginListener {
        void onCallFail(int i2, String str);

        void onCallSuccess(int i2, String str);
    }
}
