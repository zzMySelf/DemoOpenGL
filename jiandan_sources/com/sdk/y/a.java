package com.sdk.y;

import android.content.Context;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.sdk.p.f;
import com.sdk.r.b;
import org.json.JSONObject;

public class a implements com.sdk.e.a<T> {
    public final /* synthetic */ b a;

    public a(b bVar) {
        this.a = bVar;
    }

    public void a(int i2, int i3, String str) {
        this.a.b.a(i2, i3, str);
        String str2 = f.a;
        "onFailure: " + i2;
    }

    public void onSuccess(int i2, String str, int i3, T t, String str2) {
        b.b(this.a.b.e);
        if (i2 == 0) {
            com.sdk.b.a.a(this.a.b.e, this.a.a, com.sdk.b.a.a(t, str2), f.b.b.a());
            try {
                Context unused = this.a.b.e;
                t = com.sdk.u.a.a(String.valueOf(t));
                if (t == null) {
                    this.a.b.a(1, "SDK解密异常", 302001, t, str2);
                    return;
                }
                JSONObject jSONObject = new JSONObject(t);
                if (this.a.a == 1) {
                    jSONObject.remove(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                    t = jSONObject.toString();
                }
            } catch (Exception unused2) {
            }
        }
        this.a.b.a(i2, str, i3, t, str2);
    }
}
