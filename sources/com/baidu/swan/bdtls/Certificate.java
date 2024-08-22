package com.baidu.swan.bdtls;

import android.content.Context;

public class Certificate {
    private static native byte[] signature(Object obj);

    static {
        try {
            System.loadLibrary("bdtls");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static byte[] getSignature(Context context) {
        return signature(context);
    }
}
