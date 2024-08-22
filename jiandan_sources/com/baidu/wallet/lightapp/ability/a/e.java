package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.android.common.util.DeviceId;
import com.baidu.apollon.restnet.http.b;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.core.utils.SecurityUtils;
import com.baidu.wallet.lightapp.ability.b;
import com.baidu.wallet.lightapp.ability.b.a;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.utils.NetUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends b {
    public String a() {
        return LightappBusinessClient.MTD_CALLPHONEINFO;
    }

    public void a(Activity activity, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        int i2;
        Activity activity2;
        ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
        if (iLightappInvokerCallback2 != null) {
            String str3 = null;
            JSONObject jSONObject = new JSONObject();
            boolean z = false;
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                if (!jSONObject2.has("all") || !"true".equals(jSONObject2.getString("all"))) {
                    activity2 = activity;
                } else {
                    String[] strArr = {"screenWidth", "screenHeight", "walletUserAgent", "cuid", "BAIDUCUID", b.c.j, "imei", "imsi", "simSerialNum", "localIp", "wifi", LightappBusinessClient.WCP, LightappBusinessClient.ROOT};
                    JSONObject jSONObject3 = new JSONObject();
                    for (int i3 = 0; i3 < 13; i3++) {
                        jSONObject3.put(strArr[i3], "1");
                    }
                    activity2 = activity;
                    jSONObject2 = jSONObject3;
                }
                str3 = a(activity2, jSONObject2);
                i2 = 0;
            } catch (Exception e) {
                try {
                    jSONObject.put("data", Base64Utils.encodeToString(new JSONObject().toString().getBytes()));
                    jSONObject.put("errCode", 1);
                    jSONObject.put("des", "exception." + e.getMessage());
                    str3 = a(1, jSONObject);
                    i2 = 1;
                } catch (Exception unused) {
                    i2 = 1;
                    z = true;
                }
            }
            if (z) {
                str3 = a(1, jSONObject);
            }
            iLightappInvokerCallback2.onResult(i2, str3);
        }
    }

    private String a(Context context, JSONObject jSONObject) throws Exception {
        if (context == null || jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject.has("screenWidth")) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            jSONObject2.put("screenWidth", displayMetrics.widthPixels + "");
        }
        if (jSONObject.has("screenHeight")) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            jSONObject2.put("screenHeight", displayMetrics2.heightPixels + "");
        }
        if (jSONObject.has("walletUserAgent")) {
            jSONObject2.put("walletUserAgent", BussinessUtils.getUA(context) + "");
        }
        if (jSONObject.has("cuid")) {
            jSONObject2.put("cuid", PhoneUtils.getCUID(context) + "");
        }
        if (jSONObject.has("BAIDUCUID")) {
            jSONObject2.put("BAIDUCUID", DeviceId.getCUID(context));
        }
        if (jSONObject.has(b.c.j)) {
            String gPSLocation = PhoneUtils.getGPSLocation(context);
            if (TextUtils.isEmpty(gPSLocation)) {
                jSONObject2.put(b.c.j, "");
            } else {
                String[] split = gPSLocation.split(":");
                if (split == null || 2 != split.length) {
                    jSONObject2.put(b.c.j, "");
                } else {
                    jSONObject2.put(b.c.j, "{\"longitude\":" + split[0] + ",\"latitude\":" + split[1] + "}");
                }
            }
        }
        if (jSONObject.has("localIp")) {
            jSONObject2.put("localIp", PhoneUtils.getIpInfo() + "");
        }
        if (jSONObject.has("wifi")) {
            jSONObject2.put("wifi", NetUtils.getWifiSig(context, PhoneUtils.getCUID(context)));
        }
        if (jSONObject.has(LightappBusinessClient.WCP)) {
            try {
                if (!jSONObject2.has("wime")) {
                    jSONObject2.put("wime", "");
                }
                if (!jSONObject2.has("cuid_1")) {
                    jSONObject2.put("cuid_1", PhoneUtils.getCUID(context));
                }
                if (!jSONObject2.has("cuid_2")) {
                    jSONObject2.put("cuid_2", PhoneUtils.getCUID2(context));
                }
                if (!jSONObject2.has("nettype")) {
                    jSONObject2.put("nettype", NetworkUtils.getNetworkType(context));
                }
                if (!jSONObject2.has("wloc")) {
                    jSONObject2.put("wloc", PhoneUtils.getGPSLocation(context));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (jSONObject.has(LightappBusinessClient.ROOT)) {
            try {
                if (!jSONObject2.has(LightappBusinessClient.ROOT)) {
                    jSONObject2.put(LightappBusinessClient.ROOT, SecurityUtils.isRoot());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Bundle a = a.a().a(context, Base64Utils.encodeToString(jSONObject2.toString().getBytes()));
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("data", (Object) null);
        jSONObject3.put("aesdata", a.getString("aesContent"));
        jSONObject3.put("aeskey", a.getString("aesKey"));
        jSONObject3.put("errCode", 0);
        jSONObject3.put("des", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
        return a(0, jSONObject3);
    }
}
