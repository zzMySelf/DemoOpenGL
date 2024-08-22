package com.baidu.searchbox.fastopen;

import com.baidu.android.util.sp.SharedPrefsWrapper;

public final class FastOpenSharedPreferences extends SharedPrefsWrapper {
    public static final String SETTINGS_FAST_OPEN_SWITCH = "settings_fast_open_switch";
    public static final String SP_FILE_FAST_OPEN = "fast_open_sp";

    private FastOpenSharedPreferences() {
        super(SP_FILE_FAST_OPEN);
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static final FastOpenSharedPreferences INSTANCE = new FastOpenSharedPreferences();

        private Holder() {
        }
    }

    public static FastOpenSharedPreferences getInstance() {
        return Holder.INSTANCE;
    }
}
