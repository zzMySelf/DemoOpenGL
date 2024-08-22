package com.baidu.poly.a.b;

import android.text.TextUtils;
import com.baidu.poly.controller.event.LifeEventController;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SearchBox */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f16632a;

    public static a a() {
        if (f16632a == null) {
            synchronized (a.class) {
                if (f16632a == null) {
                    f16632a = new a();
                }
            }
        }
        return f16632a;
    }

    public void b() {
        com.baidu.poly.a.j.a.a().a(20, 0, (JSONObject) null);
    }

    public void c() {
        com.baidu.poly.a.j.a.a().a(30, 0, (JSONObject) null);
    }

    public void b(Throwable th2, int i2, String str) {
        int i3 = 119502 == i2 ? 3 : 119503 == i2 ? 4 : 2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", i2);
            if (th2 != null) {
                str = th2.getMessage();
            } else if (TextUtils.isEmpty(str)) {
                str = "";
            }
            jSONObject.put("errMsg", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.baidu.poly.a.j.a.a().a(30, i3, jSONObject);
    }

    public void a(String str, String str2) {
        int payPanelType = LifeEventController.getInstance().getPayPanelType(str, str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("payPanelType", payPanelType);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.baidu.poly.a.j.a.a().a(10, 0, jSONObject);
    }

    public void a(Throwable th2, int i2, String str) {
        int i3 = 119502 == i2 ? 3 : 119503 == i2 ? 4 : 2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", i2);
            if (th2 != null) {
                str = th2.getMessage();
            } else if (TextUtils.isEmpty(str)) {
                str = "";
            }
            jSONObject.put("errMsg", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.baidu.poly.a.j.a.a().a(20, i3, jSONObject);
    }
}
