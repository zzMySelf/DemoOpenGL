package com.sdk.y;

import android.content.Context;
import com.sdk.e.a;

public class e implements a<T> {
    public final /* synthetic */ f a;

    public e(f fVar) {
        this.a = fVar;
    }

    public void a(int i2, int i3, String str) {
        this.a.a(i2, i3, str);
    }

    public void onSuccess(int i2, String str, int i3, T t, String str2) {
        T t2;
        if (i2 == 0) {
            Context unused = this.a.e;
            T a2 = com.sdk.u.a.a(String.valueOf(t));
            if (a2 == null) {
                this.a.a(1, "SDK解密异常", 302001, a2, str2);
                return;
            }
            t2 = a2;
        } else {
            t2 = t;
        }
        this.a.a(i2, str, i3, t2, str2);
    }
}
