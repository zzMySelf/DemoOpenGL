package com.baidu.apollon.permission;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;

public final class a {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 3;
    public static final b d;

    /* renamed from: com.baidu.apollon.permission.a$a  reason: collision with other inner class name */
    public static class C0028a extends b {
        public C0028a() {
            super();
        }

        public String a(String str) {
            return b.a(str);
        }

        public int a(Context context, String str, int i2, String str2) {
            return b.a(context, str, i2, str2);
        }

        public int a(Context context, String str, String str2) {
            return b.a(context, str, str2);
        }
    }

    public static class b {
        public b() {
        }

        public int a(Context context, String str, int i2, String str2) {
            return 1;
        }

        public int a(Context context, String str, String str2) {
            return 1;
        }

        public String a(String str) {
            return null;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            d = new C0028a();
        } else {
            d = new b();
        }
    }

    public static String a(@NonNull String str) {
        return d.a(str);
    }

    public static int a(@NonNull Context context, @NonNull String str, int i2, @NonNull String str2) {
        return d.a(context, str, i2, str2);
    }

    public static int a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return d.a(context, str, str2);
    }
}
