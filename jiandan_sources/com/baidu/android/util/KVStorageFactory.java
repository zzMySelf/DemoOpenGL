package com.baidu.android.util;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import fe.fe.ddd.i.qw.qw;

public class KVStorageFactory {
    public static final boolean DEBUG = false;
    public static final String PREFERENCE_SUFFIX = "preferences";
    public static final String TAG = "KVStorageFactory";
    public static boolean sIsKVInitSuccessfully = true;

    public static SharedPreferences getDefaultSharedPreferences() {
        return getSharedPreferences(qw.qw().getPackageName() + "_" + PREFERENCE_SUFFIX, 0);
    }

    public static SharedPreferences getSharedPreferences(String str) {
        return getSharedPreferences(str, 0);
    }

    public static boolean isKVStorageInitSuccess() {
        return sIsKVInitSuccessfully;
    }

    @SuppressLint({"LogConditional"})
    public static SharedPreferences getSharedPreferences(String str, int i2) {
        SharedPreferences proxy;
        try {
            if (!(KVStorageRuntime.getKVStorageControl().getKVStorageType() == 0 || (proxy = KVStorageRuntime.getKVStorageProxy().getProxy(str)) == null)) {
                return proxy;
            }
        } catch (UnsatisfiedLinkError unused) {
            sIsKVInitSuccessfully = false;
        } catch (NoClassDefFoundError unused2) {
            sIsKVInitSuccessfully = false;
        }
        return qw.qw().getSharedPreferences(str, i2);
    }
}
