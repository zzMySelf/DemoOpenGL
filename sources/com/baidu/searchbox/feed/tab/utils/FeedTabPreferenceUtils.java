package com.baidu.searchbox.feed.tab.utils;

import android.content.SharedPreferences;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.config.QuickPersistConfig;

public final class FeedTabPreferenceUtils {
    private static final int TYPE_DEFAULT = 0;
    private static final int TYPE_LAUNCH = 1;

    private FeedTabPreferenceUtils() {
    }

    public static void putString(String key, String value) {
        getFeedPreference().putString(key, value);
    }

    public static String getString(String key, String defValue) {
        return getFeedPreference().getString(key, defValue);
    }

    public static void putBoolean(String key, boolean value) {
        getFeedPreference().putBoolean(key, value);
    }

    public static boolean getBoolean(String key, boolean defValue) {
        return getFeedPreference().getBoolean(key, defValue);
    }

    public static void putInt(String key, int value) {
        getFeedPreference().putInt(key, value);
    }

    public static int getInt(String key, int defValue) {
        return getFeedPreference().getInt(key, defValue);
    }

    public static void putLong(String key, long value) {
        getFeedPreference().putLong(key, value);
    }

    public static long getLong(String key, long defValue) {
        return getFeedPreference().getLong(key, defValue);
    }

    public static void putFloat(String key, float value) {
        getFeedPreference().putFloat(key, value);
    }

    public static float getFloat(String key, float defValue) {
        return getFeedPreference().getFloat(key, defValue);
    }

    public static void removeKey(String key) {
        getFeedPreference().remove(key);
    }

    public static void removeQuickKey(String key) {
        getFeedPreference(1).remove(key);
    }

    public static boolean containsKey(String key) {
        return getFeedPreference().contains(key);
    }

    public static void registerOnChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        getFeedPreference().registerOnSharedPreferenceChangeListener(listener);
    }

    public static void unregisterOnChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        getFeedPreference().unregisterOnSharedPreferenceChangeListener(listener);
    }

    public static void putQuickString(String key, String value) {
        getFeedPreference(1).putString(key, value);
    }

    public static String getQuickString(String key, String defValue) {
        return getFeedPreference(1).getString(key, defValue);
    }

    public static void putQuickBoolean(String key, boolean value) {
        getFeedPreference(1).putBoolean(key, value);
    }

    public static boolean getQuickBoolean(String key, boolean defValue) {
        return getFeedPreference(1).getBoolean(key, defValue);
    }

    public static void putQuickInt(String key, int value) {
        getFeedPreference(1).putInt(key, value);
    }

    public static int getQuickInt(String key, int defValue) {
        return getFeedPreference(1).getInt(key, defValue);
    }

    public static void putQuickLong(String key, long value) {
        getFeedPreference(1).putLong(key, value);
    }

    public static long getQuickLong(String key, long defValue) {
        return getFeedPreference(1).getLong(key, defValue);
    }

    public static void putQuickFloat(String key, float value) {
        getFeedPreference(1).putFloat(key, value);
    }

    public static float getQuickFloat(String key, float defValue) {
        return getFeedPreference(1).getFloat(key, defValue);
    }

    public static SharedPrefsWrapper getFeedPreference() {
        return getFeedPreference(0);
    }

    private static SharedPrefsWrapper getFeedPreference(int type) {
        switch (type) {
            case 1:
                return QuickPersistConfig.getInstance();
            default:
                return FeedPreferences.getInstance();
        }
    }

    private static class FeedPreferences extends SharedPrefsWrapper {
        static final String THEME_PREF_NAME = "com.baidu.searchbox.feed.pref";

        private FeedPreferences() {
            super(KVStorageFactory.getSharedPreferences(THEME_PREF_NAME));
        }

        private static final class Holder {
            /* access modifiers changed from: private */
            public static final FeedPreferences INSTANCE = new FeedPreferences();

            private Holder() {
            }
        }

        public static FeedPreferences getInstance() {
            return Holder.INSTANCE;
        }
    }
}
