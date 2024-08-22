package com.baidu.sofire.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sofire.a.a;
import com.baidu.sofire.l.t;
import java.util.Map;
import java.util.Set;

public class c implements SharedPreferences {
    public SharedPreferences a;
    public Context b;
    public int c;
    public SharedPreferences.Editor d;
    public boolean e;
    public String f;
    public String g;

    public c(Context context, SharedPreferences sharedPreferences, String str, boolean z, int i2) {
        this(context, sharedPreferences, str, z, i2, (String) null);
    }

    public final Bundle a(String str, String str2, String str3) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("operation", str);
            bundle.putString("pref_name", this.f);
            bundle.putString("key", str2);
            bundle.putString("defult_value", str3);
            if (!this.e) {
                return t.a(this.b, "CallPreferences", bundle, "sofire");
            }
            if (TextUtils.isEmpty(this.g)) {
                return t.a(this.b, "CallPreferences", bundle, "sofire");
            }
            return t.a(this.b, "CallPreferences", bundle, this.g);
        } catch (Throwable unused) {
            int i2 = a.a;
            return null;
        }
    }

    public boolean contains(String str) {
        throw new RuntimeException("This preference not allow to call contains.");
    }

    public SharedPreferences.Editor edit() {
        SharedPreferences.Editor editor = this.d;
        if (editor != null) {
            return editor;
        }
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null) {
            return sharedPreferences.edit();
        }
        return null;
    }

    public Map<String, ?> getAll() {
        throw new RuntimeException("This preference not allow to call getAll.");
    }

    public boolean getBoolean(String str, boolean z) {
        try {
            if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.g))) {
                Bundle a2 = a("getBoolean", str, String.valueOf(z));
                if (a2 != null) {
                    return a2.getBoolean("result", z);
                }
                return z;
            }
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                return z;
            }
            return sharedPreferences.getBoolean(str, z);
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public float getFloat(String str, float f2) {
        try {
            if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.g))) {
                Bundle a2 = a("getFloat", str, String.valueOf(f2));
                if (a2 != null) {
                    return a2.getFloat("result", f2);
                }
                return f2;
            }
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                return f2;
            }
            return sharedPreferences.getFloat(str, f2);
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public int getInt(String str, int i2) {
        try {
            if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.g))) {
                Bundle a2 = a("getInt", str, String.valueOf(i2));
                if (a2 != null) {
                    return a2.getInt("result", i2);
                }
                return i2;
            }
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                return i2;
            }
            return sharedPreferences.getInt(str, i2);
        } catch (Throwable unused) {
            int i3 = a.a;
        }
    }

    public long getLong(String str, long j) {
        try {
            if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.g))) {
                Bundle a2 = a("getLong", str, String.valueOf(j));
                if (a2 != null) {
                    return a2.getLong("result", j);
                }
                return j;
            }
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                return j;
            }
            return sharedPreferences.getLong(str, j);
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public String getString(String str, String str2) {
        try {
            if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.g))) {
                Bundle a2 = a("getString", str, str2);
                if (a2 != null) {
                    return a2.getString("result", str2);
                }
                return str2;
            }
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                return str2;
            }
            return sharedPreferences.getString(str, str2);
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        throw new RuntimeException("This preference not allow to call getStringSet.");
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        try {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences != null) {
                sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        try {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences != null) {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public c(Context context, SharedPreferences sharedPreferences, String str, boolean z, int i2, String str2) {
        this.b = context;
        this.c = i2;
        this.a = sharedPreferences;
        this.d = new b(context, sharedPreferences != null ? sharedPreferences.edit() : null, str, z, this.c, (String) null);
        this.e = z;
        this.f = str;
        this.g = null;
    }
}
