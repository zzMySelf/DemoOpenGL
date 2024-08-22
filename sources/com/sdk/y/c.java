package com.sdk.y;

import android.content.Context;
import android.util.Log;
import com.sdk.e.a;
import com.sdk.p.f;
import com.sdk.r.b;
import org.json.JSONObject;

public class c implements a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5589a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f5590b;

    public c(f fVar, int i2) {
        this.f5590b = fVar;
        this.f5589a = i2;
    }

    public void a(int i2, int i3, String str) {
        this.f5590b.a(i2, i3, str);
        Log.d(f.f5593a, "onFailure: " + i2);
    }

    public void onSuccess(int i2, String str, int i3, T t, String str2) {
        b.b(this.f5590b.f5597e);
        if (i2 == 0) {
            com.sdk.b.a.a(this.f5590b.f5597e, this.f5589a, com.sdk.b.a.a(t, str2), f.b.CUCC.a());
            try {
                Context unused = this.f5590b.f5597e;
                t = com.sdk.u.a.a(String.valueOf(t));
                if (t == null) {
                    this.f5590b.a(1, "SDK解密异常", 302001, t, str2);
                    return;
                }
                JSONObject jSONObject = new JSONObject(t);
                if (this.f5589a == 1) {
                    jSONObject.remove("fakeMobile");
                    t = jSONObject.toString();
                }
            } catch (Exception e2) {
            }
        }
        this.f5590b.a(i2, str, i3, t, str2);
    }
}
