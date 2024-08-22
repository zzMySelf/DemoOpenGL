package com.baidu.searchbox.ugc.utils;

import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;

public final class UgcSpWrapper extends SharedPrefsWrapper {
    private static final String SP_FILE_DEFAULT = "ugc";

    private UgcSpWrapper() {
        super(KVStorageFactory.getSharedPreferences("ugc"));
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static final UgcSpWrapper INSTANCE = new UgcSpWrapper();

        private Holder() {
        }
    }

    public static UgcSpWrapper getInstance() {
        return Holder.INSTANCE;
    }
}
