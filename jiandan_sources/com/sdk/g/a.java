package com.sdk.g;

import androidx.core.graphics.drawable.IconCompat;
import com.sdk.a.h;
import com.sdk.e.b;
import org.json.JSONObject;

public class a extends b<String> {
    public final /* synthetic */ b b;

    public a(b bVar) {
        this.b = bVar;
    }

    public void a(h<String> hVar, String str) {
        String str2;
        int i2;
        if (hVar == null) {
            str2 = "";
        } else {
            str2 = (String) hVar.b;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int optInt = jSONObject.optInt("code");
            try {
                String optString = jSONObject.optString("msg");
                int optInt2 = jSONObject.optInt("status");
                String optString2 = jSONObject.optString(IconCompat.EXTRA_OBJ);
                String optString3 = jSONObject.optString("seq");
                if (!com.sdk.o.a.a(optString).booleanValue() || !com.sdk.o.a.a(optString3).booleanValue() || !com.sdk.o.a.a(optString2).booleanValue()) {
                    this.b.a(optInt, optString, optInt2, optString2, optString3);
                    return;
                }
                this.b.a(1, "服务端数据格式出错", 302003, null, com.sdk.o.b.a().c);
                com.sdk.o.a.a(b.a, "返回数据为空", Boolean.valueOf(b.b));
            } catch (Throwable th2) {
                th = th2;
                i2 = optInt;
                com.sdk.o.b.d(th.toString());
                this.b.a(i2, "服务端数据格式出错", 302003, null, com.sdk.o.b.a().c);
                String str3 = b.a;
                com.sdk.o.a.a(str3, "返回数据解析异常：" + th.toString(), Boolean.valueOf(b.b));
            }
        } catch (Throwable th3) {
            th = th3;
            i2 = 1;
            com.sdk.o.b.d(th.toString());
            this.b.a(i2, "服务端数据格式出错", 302003, null, com.sdk.o.b.a().c);
            String str32 = b.a;
            com.sdk.o.a.a(str32, "返回数据解析异常：" + th.toString(), Boolean.valueOf(b.b));
        }
    }
}
