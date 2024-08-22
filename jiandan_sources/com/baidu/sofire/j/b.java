package com.baidu.sofire.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sofire.a.a;
import com.baidu.sofire.l.t;
import java.util.Set;

public class b implements SharedPreferences.Editor {
    public SharedPreferences.Editor a;
    public Context b;
    public int c;
    public String d;
    public boolean e;
    public String f;

    public b(Context context, SharedPreferences.Editor editor, String str, boolean z, int i2, String str2) {
        this.b = context;
        this.a = editor;
        this.c = i2;
        this.d = str;
        this.e = z;
        this.f = str2;
    }

    public final Bundle a(Bundle bundle) {
        try {
            bundle.putString("pref_name", this.d);
            if (!this.e) {
                return t.a(this.b, "CallPreferences", bundle, "sofire");
            }
            if (TextUtils.isEmpty(this.f)) {
                return t.a(this.b, "CallPreferences", bundle, "sofire");
            }
            return t.a(this.b, "CallPreferences", bundle, this.f);
        } catch (Throwable unused) {
            int i2 = a.a;
            return null;
        }
    }

    public void apply() {
        SharedPreferences.Editor editor;
        if (this.c != 1) {
            return;
        }
        if ((!this.e || TextUtils.isEmpty(this.f)) && (editor = this.a) != null) {
            editor.apply();
        }
    }

    public SharedPreferences.Editor clear() {
        throw new RuntimeException("This editor not allow to call clear.");
    }

    public boolean commit() {
        SharedPreferences.Editor editor;
        if (this.c != 1 || ((this.e && !TextUtils.isEmpty(this.f)) || (editor = this.a) == null)) {
            return true;
        }
        return editor.commit();
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        try {
            if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.f))) {
                Bundle bundle = new Bundle();
                bundle.putString("operation", "putBoolean");
                bundle.putString("key", str);
                bundle.putBoolean("value", z);
                a(bundle);
                return this;
            }
            SharedPreferences.Editor editor = this.a;
            if (!(editor == null || editor == null)) {
                editor.putBoolean(str, z);
            }
            return this;
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public SharedPreferences.Editor putFloat(String str, float f2) {
        try {
            if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.f))) {
                Bundle bundle = new Bundle();
                bundle.putString("operation", "putFloat");
                bundle.putString("key", str);
                bundle.putFloat("value", f2);
                a(bundle);
                return this;
            }
            SharedPreferences.Editor editor = this.a;
            if (!(editor == null || editor == null)) {
                editor.putFloat(str, f2);
            }
            return this;
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public SharedPreferences.Editor putInt(String str, int i2) {
        try {
            if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.f))) {
                Bundle bundle = new Bundle();
                bundle.putString("operation", "putInt");
                bundle.putString("key", str);
                bundle.putInt("value", i2);
                a(bundle);
                return this;
            }
            SharedPreferences.Editor editor = this.a;
            if (!(editor == null || editor == null)) {
                editor.putInt(str, i2);
            }
            return this;
        } catch (Throwable unused) {
            int i3 = a.a;
        }
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        try {
            if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.f))) {
                Bundle bundle = new Bundle();
                bundle.putString("operation", "putLong");
                bundle.putString("key", str);
                bundle.putLong("value", j);
                a(bundle);
                return this;
            }
            SharedPreferences.Editor editor = this.a;
            if (!(editor == null || editor == null)) {
                editor.putLong(str, j);
            }
            return this;
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public SharedPreferences.Editor putString(String str, String str2) {
        try {
            if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.f))) {
                Bundle bundle = new Bundle();
                bundle.putString("operation", "putString");
                bundle.putString("key", str);
                bundle.putString("value", str2);
                a(bundle);
                return this;
            }
            SharedPreferences.Editor editor = this.a;
            if (!(editor == null || editor == null)) {
                editor.putString(str, str2);
            }
            return this;
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        throw new RuntimeException("This editor not allow to call putStringSet.");
    }

    public SharedPreferences.Editor remove(String str) {
        throw new RuntimeException("This editor not allow to call remove.");
    }
}
