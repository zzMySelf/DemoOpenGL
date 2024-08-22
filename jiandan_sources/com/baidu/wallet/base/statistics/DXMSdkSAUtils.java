package com.baidu.wallet.base.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.apollon.restnet.a;
import com.baidu.apollon.restnet.b;
import com.baidu.apollon.restnet.http.b;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.UAFilterUtil;
import dxm.sasdk.DxmSdkSensorsDataAPI;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class DXMSdkSAUtils implements a.b {
    public static final String SDK_EVENT = "DXMSDK";
    public static final String SDK_EVENT_CLICK = "DXMSDK_CLICK";
    public static final String SDK_EVENT_SHOW = "DXMSDK_SHOW";
    public static final String a = "DXMSdkSAUtils";
    public static final String b = "/sa?project=production";
    public static final DxmSdkSensorsDataAPI.DebugMode c = DxmSdkSensorsDataAPI.DebugMode.DEBUG_OFF;

    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            a a2 = a.a();
            jSONObject.put("UserAgent", UAFilterUtil.getInstance().getTrueUA(context));
            jSONObject.put("cuid", PhoneUtils.getCUID(context));
            jSONObject.put("cuid2", PhoneUtils.getCUID2(context));
            jSONObject.put("op", a2.d(context));
            jSONObject.put("sdk_version", BeanConstants.VERSION_NO);
            jSONObject.put("channel_id", BeanConstants.CHANNEL_ID);
            if (context != null) {
                jSONObject.put("app_uniqueID", context.getPackageName());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.d(a, "commonParams = " + jSONObject.toString());
        return jSONObject;
    }

    public static void initSensorStat(Context context) {
        LogUtil.d(a, "initSensorStat" + DomainConfig.getInstance().getSensorhost(new Boolean[]{Boolean.FALSE}));
        DxmSdkSensorsDataAPI.k(context, DomainConfig.getInstance().getSensorhost(new Boolean[]{Boolean.FALSE}) + b, c);
        onChangeProperties(a(context));
    }

    public static boolean isPropertyExist(JSONObject jSONObject, String str) {
        return jSONObject.has(str);
    }

    public static void onChangeProperties(JSONObject jSONObject) {
        try {
            DxmSdkSensorsDataAPI.h().e(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void onClickEvent(String str, Collection<String> collection) {
        onEventWithValues(SDK_EVENT_CLICK, str, collection);
    }

    public static void onEvent(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            onEventWithValues(str, str2, Arrays.asList(new String[]{""}));
        }
    }

    public static void onEventEnd(String str, String str2, int i2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            refreshUnionIDProperty();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event_key", str2);
                jSONObject.put("value0", String.valueOf(i2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            DxmSdkSensorsDataAPI.h().q(str, jSONObject);
        }
    }

    public static void onEventEndWithValues(String str, String str2, int i2, Collection<String> collection) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event_key", str2);
                jSONObject.put("value0", String.valueOf(i2));
                JSONArray jSONArray = null;
                if (collection != null && collection.size() > 0) {
                    jSONArray = new JSONArray();
                    for (String a2 : collection) {
                        jSONArray.put(a(a2));
                    }
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    if (jSONArray.length() > 0) {
                        jSONObject.put("value1", jSONArray.get(0));
                    }
                    if (jSONArray.length() > 1) {
                        jSONObject.put("value2", jSONArray.get(1));
                    }
                    if (jSONArray.length() > 2) {
                        jSONObject.put("value3", jSONArray.get(2));
                    }
                    if (jSONArray.length() > 3) {
                        jSONObject.put("value4", jSONArray.get(3));
                    }
                    if (jSONArray.length() > 4) {
                        jSONObject.put("value5", jSONArray.get(4));
                    }
                    if (jSONArray.length() > 5) {
                        jSONObject.put("value6", jSONArray.get(5));
                    }
                    if (jSONArray.length() > 6) {
                        jSONObject.put("value7", jSONArray.get(6));
                    }
                    if (jSONArray.length() > 7) {
                        jSONObject.put("value8", jSONArray.get(7));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            refreshUnionIDProperty();
            DxmSdkSensorsDataAPI.h().q(str, jSONObject);
        }
    }

    public static void onEventStart(String str) {
        LogUtil.d(a, "onEventStart. id = " + str);
        if (!TextUtils.isEmpty(str)) {
            refreshUnionIDProperty();
            DxmSdkSensorsDataAPI.h().r(str);
        }
    }

    public static void onEventWithValues(String str, String str2, Collection<String> collection) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_key", str2);
                JSONArray jSONArray = null;
                if (collection != null && collection.size() > 0) {
                    jSONArray = new JSONArray();
                    for (String a2 : collection) {
                        jSONArray.put(a(a2));
                    }
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    if (jSONArray.length() > 0) {
                        jSONObject.put("value0", jSONArray.get(0));
                    }
                    if (jSONArray.length() > 1) {
                        jSONObject.put("value1", jSONArray.get(1));
                    }
                    if (jSONArray.length() > 2) {
                        jSONObject.put("value2", jSONArray.get(2));
                    }
                    if (jSONArray.length() > 3) {
                        jSONObject.put("value3", jSONArray.get(3));
                    }
                    if (jSONArray.length() > 4) {
                        jSONObject.put("value4", jSONArray.get(4));
                    }
                    if (jSONArray.length() > 5) {
                        jSONObject.put("value5", jSONArray.get(5));
                    }
                    if (jSONArray.length() > 6) {
                        jSONObject.put("value6", jSONArray.get(6));
                    }
                    if (jSONArray.length() > 7) {
                        jSONObject.put("value7", jSONArray.get(7));
                    }
                    if (jSONArray.length() > 8) {
                        jSONObject.put("value8", jSONArray.get(8));
                    }
                }
                refreshUnionIDProperty();
                DxmSdkSensorsDataAPI.h().n(str, jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void onShowEvent(String str, Collection<String> collection) {
        onEventWithValues(SDK_EVENT_SHOW, str, collection);
    }

    public static void refreshUnionIDProperty() {
        String unionId = WalletLoginHelper.getInstance().getUnionId();
        LogUtil.d(a, "refreshUnionIDProperty union_id = " + unionId);
        if (!TextUtils.isEmpty(unionId)) {
            DxmSdkSensorsDataAPI.h().c(unionId);
        } else {
            DxmSdkSensorsDataAPI.h().d();
        }
    }

    public static void registerProperties(JSONObject jSONObject) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                Object opt = jSONObject.opt(obj);
                if (opt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) opt;
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        if (jSONArray.get(i2) == null || String.valueOf(jSONArray.get(i2)) == StringUtil.NULL_STRING) {
                            jSONArray.put(i2, "");
                        }
                    }
                    jSONObject.put(obj, jSONArray);
                }
            }
            DxmSdkSensorsDataAPI.h().e(jSONObject);
        } catch (Exception e) {
            onEventWithValues("register_error", Arrays.asList(new String[]{e.toString()}));
            e.printStackTrace();
        }
    }

    public void send(b bVar) {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_key", "network_stat");
            jSONObject.put("host", bVar.a());
            jSONObject.put("$url_path", bVar.b());
            jSONObject.put("totalTime", bVar.d());
            String str3 = "1";
            jSONObject.put("value0", bVar.e() ? str3 : "0");
            if (bVar.f()) {
                str = str3;
            } else {
                str = "0";
            }
            jSONObject.put("value1", str);
            jSONObject.put("value2", bVar.h());
            jSONObject.put("value3", bVar.i());
            if (bVar.g()) {
                str2 = str3;
            } else {
                str2 = "0";
            }
            jSONObject.put("value4", str2);
            if (!bVar.j()) {
                str3 = "0";
            }
            jSONObject.put("value5", str3);
            jSONObject.put("value6", String.valueOf(bVar.k()));
            jSONObject.put("value7", bVar.c());
            LogUtil.d("okhttp", "network_stat: " + jSONObject.toString());
            refreshUnionIDProperty();
            DxmSdkSensorsDataAPI.h().n(SDK_EVENT, jSONObject);
        } catch (JSONException unused) {
        }
    }

    public static void onEvent(String str) {
        onEvent(SDK_EVENT, str);
    }

    public static void onEventEnd(String str, int i2) {
        LogUtil.d(a, "onEventEnd. id = " + str + " , retCode = " + i2);
        onEventEnd(SDK_EVENT, str, i2);
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 2048) {
            return str.substring(0, 2048);
        }
        return str;
    }

    public void send(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("event_key", "network_metrics").put("host", jSONObject.optString("host")).put("$url_path", jSONObject.optString("path")).put("value0", jSONObject.optString(b.c.f707i)).put("value1", jSONObject.optString(b.c.m)).put("value2", jSONObject.optString("protocol")).put("value3", jSONObject.optString(b.c.j)).put("value4", jSONObject.optString(b.c.l)).put("value5", jSONObject.optString(b.c.n)).put("value6", jSONObject.optString(b.c.h)).put(b.c.a, jSONObject.optLong(b.c.a)).put(b.c.b, jSONObject.optLong(b.c.b)).put(b.c.c, jSONObject.optLong(b.c.c)).put(b.c.d, jSONObject.optLong(b.c.d)).put(b.c.e, jSONObject.optLong(b.c.e));
            LogUtil.d("okhttp", "network_metrics: " + jSONObject2.toString());
            refreshUnionIDProperty();
            DxmSdkSensorsDataAPI.h().n(SDK_EVENT, jSONObject2);
        } catch (JSONException unused) {
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        LogUtil.d(a, "onEventEndWithValues. id = " + str + " , retCode = " + i2 + " , values = " + collection);
        onEventEndWithValues(SDK_EVENT, str, i2, collection);
    }

    public static void onEventWithValues(String str, Collection<String> collection) {
        LogUtil.d(a, "onEventWithValues. id = " + str + ", values = " + collection);
        onEventWithValues(SDK_EVENT, str, collection);
    }
}
