package com.hihonor.push.sdk;

import android.text.TextUtils;
import java.util.Arrays;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f4701a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4702b;

    public g(String str) {
        this.f4701a = str;
        this.f4702b = a(str);
    }

    public static g a(String str) {
        return new g(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this.f4701a, ((g) obj).f4701a);
    }

    public final int hashCode() {
        return this.f4702b;
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
