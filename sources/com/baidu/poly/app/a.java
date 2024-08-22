package com.baidu.poly.app;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.poly.Cashier;
import com.baidu.poly.http.Forms;
import com.baidu.poly.http.Headers;
import com.baidu.poly.http.api.NetWorkApiKt;
import com.baidu.poly.runtime.i.IPolyExternalAbility;
import com.baidu.poly.statistics.ActionDescription;
import com.baidu.poly.statistics.StatisticsUtil;
import com.baidu.poly.statistics.b;
import com.baidu.poly.storage.PolySTokenCache;
import com.baidu.poly.util.HttpSigner;
import com.baidu.poly.util.Logger;
import com.baidu.poly.util.f;
import com.baidu.poly.util.m;
import com.baidu.poly.util.param.PolyParam;
import com.baidu.sapi2.result.LoginWithUCAuthResult;
import com.baidu.swan.apps.pay.panel.PaymentPanelManager;
import com.heytap.mcssdk.constant.IntentConstant;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SearchBox */
public class a {
    public static String a() {
        try {
            return b.a().getPackageManager().getPackageInfo(b.a().getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String b() {
        try {
            return b.a().getPackageManager().getPackageInfo(b.a().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String c() {
        return PaymentPanelManager.PARAM_VALUE_CHANNEL;
    }

    private static String d() {
        return PaymentPanelManager.PARAM_VALUE_DEVICE_TYPE;
    }

    public static String e() {
        String bduss = b.b().getBduss();
        return TextUtils.isEmpty(bduss) ? "" : bduss;
    }

    public static String f() {
        String cuid = b.b().getCuid();
        return TextUtils.isEmpty(cuid) ? "" : cuid;
    }

    private static String g() {
        IPolyExternalAbility polyExternalAbility;
        String a2 = m.a();
        if (a2.equals("-1")) {
            a2 = "unknown";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ntType", a2);
            if (a2.equals("wifi") && (polyExternalAbility = b.b().getPolyExternalAbility()) != null && polyExternalAbility.getScenePermissionState("location", "other")) {
                String b2 = m.b();
                if (!TextUtils.isEmpty(b2)) {
                    jSONObject.put("wfId", b2);
                }
            }
            return Base64.encodeToString(jSONObject.toString().getBytes(StandardCharsets.UTF_8), 2);
        } catch (Exception e2) {
            StatisticsUtil.a(new b("1").a("errMsg", new com.baidu.poly.a.n.a("PolyAppParamCreator#getNetType", e2).a()));
            e2.printStackTrace();
            return "";
        }
    }

    private static String h() {
        return PolySTokenCache.a();
    }

    public static String i() {
        return Cashier.SDK_VERSION;
    }

    public static String j() {
        String sofireZid = b.b().getSofireZid(4500);
        return TextUtils.isEmpty(sofireZid) ? "" : sofireZid;
    }

    public static String k() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static Forms l() {
        Forms forms = new Forms();
        String e2 = e();
        if (!TextUtils.isEmpty(e2)) {
            forms.put("bduss", e2);
        }
        String f2 = f();
        if (!TextUtils.isEmpty(f2)) {
            forms.put("cuid", f2);
        }
        forms.put("channel", c());
        forms.put(IntentConstant.SDK_VERSION, i());
        forms.put("sdkPgName", a());
        forms.put("appVersion", b());
        forms.put("timestamp", k());
        forms.put("deviceType", d());
        String h2 = h();
        if (!TextUtils.isEmpty(h2)) {
            forms.put(LoginWithUCAuthResult.KEY_DATA_STOKEN, h2);
        }
        String g2 = g();
        if (!TextUtils.isEmpty(g2)) {
            forms.put("nt", g2);
        }
        return forms;
    }

    public static String a(Forms forms) {
        Forms l = l();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        for (Map.Entry entry : forms.map().entrySet()) {
            try {
                jSONObject3.put((String) entry.getKey(), (String) entry.getValue());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        for (String str : l.getMap().keySet()) {
            try {
                jSONObject2.put(str, l.get(str));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        try {
            jSONObject.put("userParams", jSONObject3);
            jSONObject.put("sdkParams", jSONObject2);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject.toString();
    }

    private static JSONObject b(Forms forms) {
        JSONObject jSONObject = new JSONObject();
        if (!(forms == null || forms.map() == null)) {
            for (Map.Entry entry : forms.map().entrySet()) {
                try {
                    jSONObject.put((String) entry.getKey(), (String) entry.getValue());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    public static String a(PolyParam polyParam) {
        Forms l = l();
        JSONObject jSONObject = new JSONObject();
        JSONObject b2 = b(l);
        JSONObject b3 = b(a(polyParam.getUserParams()));
        JSONObject b4 = b(a(polyParam.getAppletParams()));
        try {
            jSONObject.put("userParams", b3);
            jSONObject.put("appletParams", b4);
            jSONObject.put("sdkParams", b2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static Headers a(String str) {
        Headers headers = new Headers();
        headers.put("sdkSign", com.baidu.poly.a.i.b.b(str + "key" + "=" + HttpSigner.a(NetWorkApiKt.a())));
        return headers;
    }

    public static String a(String str, boolean z, String str2) {
        if (z) {
            try {
                String a2 = com.baidu.poly.http.api.b.a(str);
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.optInt("errno", -1) == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    String optString = optJSONObject.optString("sign");
                    String optString2 = optJSONObject.optString("content");
                    long currentTimeMillis = System.currentTimeMillis();
                    String a3 = f.a(a2, optString2, f.a(a2, optString, HttpSigner.nativeGetRSAKey(NetWorkApiKt.a())));
                    long currentTimeMillis2 = System.currentTimeMillis();
                    StatisticsUtil.a(new b(ActionDescription.DECRYPT_CONSUME_TIME).a("expend", Long.valueOf(currentTimeMillis2 - currentTimeMillis)).a("path", a2));
                    jSONObject.put("data", new JSONObject(a3));
                    String jSONObject2 = jSONObject.toString();
                    Logger.info("path=" + a2 + ",jsonStr=" + jSONObject2);
                    return jSONObject2;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                StatisticsUtil.a(new b(ActionDescription.DECRYPT_FAIL).a("msg", e2.getMessage()).a("path", com.baidu.poly.http.api.b.a(str)));
            }
        }
        return str2;
    }

    public static Forms a(Bundle bundle) {
        Forms forms = new Forms();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                if (bundle.get(str) instanceof String) {
                    forms.put(str, bundle.get(str).toString());
                }
            }
        }
        return forms;
    }
}
