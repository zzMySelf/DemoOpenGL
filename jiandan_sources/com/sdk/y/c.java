package com.sdk.y;

import android.content.Context;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.sdk.e.a;
import com.sdk.p.f;
import com.sdk.r.b;
import org.json.JSONObject;

public class c implements a<T> {
    public final /* synthetic */ int a;
    public final /* synthetic */ f b;

    public c(f fVar, int i2) {
        this.b = fVar;
        this.a = i2;
    }

    public void a(int i2, int i3, String str) {
        this.b.a(i2, i3, str);
        String str2 = f.a;
        "onFailure: " + i2;
    }

    public void onSuccess(int i2, String str, int i3, T t, String str2) {
        b.b(this.b.e);
        if (i2 == 0) {
            com.sdk.b.a.a(this.b.e, this.a, com.sdk.b.a.a(t, str2), f.b.b.a());
            try {
                Context unused = this.b.e;
                t = com.sdk.u.a.a(String.valueOf(t));
                if (t == null) {
                    this.b.a(1, "SDK解密异常", 302001, t, str2);
                    return;
                }
                JSONObject jSONObject = new JSONObject(t);
                if (this.a == 1) {
                    jSONObject.remove(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                    t = jSONObject.toString();
                }
            } catch (Exception unused2) {
            }
        }
        this.b.a(i2, str, i3, t, str2);
    }
}
