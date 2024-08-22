package com.baidu.searchbox.util;

import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;

class BlcSharedPrefsWrapper extends SharedPrefsWrapper {
    private static final String SP_FILE_DEFAULT = "c3_aid_sp";

    private BlcSharedPrefsWrapper() {
        super(KVStorageFactory.getSharedPreferences(SP_FILE_DEFAULT));
    }

    public static BlcSharedPrefsWrapper getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static final BlcSharedPrefsWrapper INSTANCE = new BlcSharedPrefsWrapper();

        private Holder() {
        }
    }
}
