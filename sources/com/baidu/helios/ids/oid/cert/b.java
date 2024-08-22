package com.baidu.helios.ids.oid.cert;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.helios.ids.oid.cert.d;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f13403a = "https://mbd.baidu.com";

    /* renamed from: b  reason: collision with root package name */
    public static final String f13404b = "http://cloudcontrol.bcc-szth.baidu.com:8089";

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f13405c = false;

    /* renamed from: d  reason: collision with root package name */
    private static final String f13406d = "CertificateRequester";

    public static String a() {
        return String.format("%s/ccs/v1/oaid/certificatesync", new Object[]{"https://mbd.baidu.com"});
    }

    public static String a(CertificateInfo certificateInfo) {
        if (certificateInfo == null || TextUtils.isEmpty(certificateInfo.md5)) {
            return "-1";
        }
        return certificateInfo.md5;
    }

    public static void a(String str, String str2, d.a aVar) {
        d dVar = new d();
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str, str2);
            jSONObject.put(a.f13390e, jSONObject2);
            dVar.a(a(), "POST", (Map<String, String>) null, jSONObject, aVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static CertificateInfo a(String str, String str2, Context context) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str)) {
            a(1003, str2);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("errno") != 0) {
                a(1002, str2);
                return null;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (!(optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject(a.f13390e)) == null)) {
                CertificateInfo createFromJson = CertificateInfo.createFromJson(optJSONObject.optJSONObject(context.getApplicationContext().getPackageName()));
                if (createFromJson != null && !TextUtils.isEmpty(createFromJson.md5) && !TextUtils.isEmpty(createFromJson.expiration_time) && !TextUtils.isEmpty(createFromJson.contents)) {
                    if (!TextUtils.isEmpty(createFromJson.update_time)) {
                        return createFromJson;
                    }
                }
                a(1005, str2);
                return null;
            }
            a(1003, str2);
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(int i2, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errorCode", i2);
            jSONObject.put("md5", str);
            OAIDRuntime.getOAIDRuntime().doStatistic(a.f13386a, jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
