package com.baidu.android.util;

import android.content.SharedPreferences;

public interface IKVStorageProxy {
    public static final IKVStorageProxy EMPTY = new IKVStorageProxy() {
        public SharedPreferences getProxy(String str) {
            return null;
        }
    };

    SharedPreferences getProxy(String str);
}
