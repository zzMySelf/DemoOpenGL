package com.sdk.y;

import android.content.Context;
import com.sdk.e.a;

public class e implements a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f5592a;

    public e(f fVar) {
        this.f5592a = fVar;
    }

    public void a(int i2, int i3, String str) {
        this.f5592a.a(i2, i3, str);
    }

    public void onSuccess(int i2, String str, int i3, T t, String str2) {
        T t2;
        if (i2 == 0) {
            Context unused = this.f5592a.f5597e;
            T a2 = com.sdk.u.a.a(String.valueOf(t));
            if (a2 == null) {
                this.f5592a.a(1, "SDK解密异常", 302001, a2, str2);
                return;
            }
            t2 = a2;
        } else {
            t2 = t;
        }
        this.f5592a.a(i2, str, i3, t2, str2);
    }
}
