package com.baidu.android.app.account;

import com.baidu.android.util.sp.SharedPrefsWrapper;

public final class LightFileCache extends SharedPrefsWrapper {
    private static final String SP_NAME = "light_download";

    public LightFileCache() {
        super(SP_NAME);
    }

    public String getChecksumByUrl(String key) {
        return super.getString(key, "");
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final LightFileCache INSTANCE = new LightFileCache();

        private Holder() {
        }
    }

    public static LightFileCache getInstance() {
        return Holder.INSTANCE;
    }
}
