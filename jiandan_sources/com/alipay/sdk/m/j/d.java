package com.alipay.sdk.m.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.u.n;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class d {
    public static final int a = 1010;
    public static a b;

    public interface a {
        void a(boolean z, JSONObject jSONObject, String str);
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, Context context) {
        return n.a(aVar, context, (List<a.b>) Collections.singletonList(new a.b("com.taobao.taobao", 0, "")), false);
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, Activity activity, int i2, String str, String str2, a aVar2) {
        try {
            com.alipay.sdk.m.k.a.a(aVar, b.l, b.u0);
            activity.startActivityForResult(new Intent(str2, Uri.parse(str)), i2);
            b = aVar2;
            return true;
        } catch (Throwable th2) {
            aVar2.a(false, (JSONObject) null, "UNKNOWN_ERROR");
            com.alipay.sdk.m.k.a.a(aVar, b.l, b.y0, th2);
            return false;
        }
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, int i2, int i3, Intent intent) {
        if (i2 != 1010 || intent == null) {
            return false;
        }
        a aVar2 = b;
        if (aVar2 == null) {
            return true;
        }
        b = null;
        if (i3 != -1) {
            String str = "";
            if (i3 != 0) {
                com.alipay.sdk.m.k.a.b(aVar, b.l, b.w0, str + i3);
            } else {
                if (intent != null) {
                    str = intent.toUri(1);
                }
                com.alipay.sdk.m.k.a.a(aVar, b.l, b.v0, str);
                aVar2.a(false, (JSONObject) null, "CANCELED");
            }
        } else {
            com.alipay.sdk.m.k.a.a(aVar, b.l, b.x0, intent.toUri(1));
            aVar2.a(true, n.a(intent), StatHelper.SENSOR_OK);
        }
        return true;
    }
}
