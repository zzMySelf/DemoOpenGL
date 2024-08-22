package com.baidu.android.util.sp;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import fe.fe.ddd.i.qw.qw;
import java.util.Map;
import java.util.Set;

public class SharedPrefsWrapper implements SharedPreferences {
    public static final boolean DEBUG = false;
    public static final String DEFAULT_SP_NAME = "default";
    public static final int MAX_STRING_LENGTH = 256;
    public SharedPreferences mSp;

    public SharedPrefsWrapper() {
        this.mSp = PreferenceManager.getDefaultSharedPreferences(qw.qw());
    }

    private void verifyAllLength(String str, Set<String> set) {
        if (set != null) {
            for (String verifyLength : set) {
                verifyLength(str, verifyLength);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    private void verifyLength(String str, String str2) {
        if (str2 != null && str2.length() > 256 && DEBUG) {
            throw new IllegalArgumentException(String.format("the value of %s is %d, over the limit of %d!", new Object[]{str, Integer.valueOf(str2.length()), 256}));
        }
    }

    public boolean contains(String str) {
        SharedPreferences sharedPreferences = this.mSp;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains(str);
    }

    public SharedPreferences.Editor edit() {
        SharedPreferences sharedPreferences = this.mSp;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.edit();
    }

    public Map<String, ?> getAll() {
        SharedPreferences sharedPreferences = this.mSp;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getAll();
    }

    public boolean getBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences = this.mSp;
        if (sharedPreferences == null) {
            return z;
        }
        return sharedPreferences.getBoolean(str, z);
    }

    public float getFloat(String str, float f) {
        SharedPreferences sharedPreferences = this.mSp;
        if (sharedPreferences == null) {
            return f;
        }
        return sharedPreferences.getFloat(str, f);
    }

    public int getInt(String str, int i2) {
        SharedPreferences sharedPreferences = this.mSp;
        if (sharedPreferences == null) {
            return i2;
        }
        return sharedPreferences.getInt(str, i2);
    }

    public long getLong(String str, long j) {
        SharedPreferences sharedPreferences = this.mSp;
        if (sharedPreferences == null) {
            return j;
        }
        return sharedPreferences.getLong(str, j);
    }

    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = this.mSp;
        if (sharedPreferences == null) {
            return str2;
        }
        return sharedPreferences.getString(str, str2);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        SharedPreferences sharedPreferences = this.mSp;
        if (sharedPreferences == null) {
            return set;
        }
        return sharedPreferences.getStringSet(str, set);
    }

    public void putBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences = this.mSp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z).apply();
        }
    }

    public void putFloat(String str, float f) {
        SharedPreferences sharedPreferences = this.mSp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putFloat(str, f).apply();
        }
    }

    public void putInt(String str, int i2) {
        SharedPreferences sharedPreferences = this.mSp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(str, i2).apply();
        }
    }

    public void putLong(String str, long j) {
        SharedPreferences sharedPreferences = this.mSp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(str, j).apply();
        }
    }

    public void putString(String str, String str2) {
        if (this.mSp != null) {
            verifyLength(str, str2);
            this.mSp.edit().putString(str, str2).apply();
        }
    }

    public void putStringSet(String str, Set<String> set) {
        if (this.mSp != null) {
            verifyAllLength(str, set);
            this.mSp.edit().putStringSet(str, set).apply();
        }
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SharedPreferences sharedPreferences = this.mSp;
        if (sharedPreferences != null) {
            sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    public void remove(String str) {
        SharedPreferences sharedPreferences = this.mSp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(str).apply();
        }
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SharedPreferences sharedPreferences = this.mSp;
        if (sharedPreferences != null) {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    public SharedPrefsWrapper(String str) {
        this(str, 0);
    }

    public SharedPrefsWrapper(String str, int i2) {
        if (TextUtils.isEmpty(str) || "default".equals(str)) {
            this.mSp = PreferenceManager.getDefaultSharedPreferences(qw.qw());
        } else {
            this.mSp = qw.qw().getSharedPreferences(str, i2);
        }
    }

    public SharedPrefsWrapper(SharedPreferences sharedPreferences) {
        this.mSp = sharedPreferences;
    }
}
