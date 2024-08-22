package com.baidu.wallet.paysdk.fingerprint.entrance;

import android.content.Context;
import com.baidu.wallet.router.RouterCallback;

public class DxmCheckFingerprint {

    public static class a {
        public static DxmCheckFingerprint a = new DxmCheckFingerprint();
    }

    public static DxmCheckFingerprint getInstance() {
        return a.a;
    }

    public void startCherkFingerprint(Context context, String str, RouterCallback routerCallback) {
        if (context == null || routerCallback == null) {
            throw new IllegalArgumentException(DxmCheckFingerprint.class.getSimpleName() + " please check params");
        }
        com.baidu.wallet.paysdk.fingerprint.a.a.a().a(context, str, routerCallback);
    }

    public DxmCheckFingerprint() {
    }
}
