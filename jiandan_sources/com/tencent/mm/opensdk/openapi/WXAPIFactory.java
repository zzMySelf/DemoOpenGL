package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import com.tencent.mm.opensdk.utils.Log;

public class WXAPIFactory {
    public static final String TAG = "MicroMsg.PaySdk.WXFactory";

    public WXAPIFactory() {
        throw new RuntimeException(WXAPIFactory.class.getSimpleName() + " should not be instantiated");
    }

    public static IWXAPI createWXAPI(Context context, String str) {
        return createWXAPI(context, str, true);
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z) {
        Log.d(TAG, "createWXAPI, appId = " + str + ", checkSignature = " + z);
        return createWXAPI(context, str, z, 2);
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z, int i2) {
        Log.d(TAG, "createWXAPI, appId = " + str + ", checkSignature = " + z + ", launchMode = " + i2);
        return new WXApiImplV10(context, str, z, i2);
    }
}
