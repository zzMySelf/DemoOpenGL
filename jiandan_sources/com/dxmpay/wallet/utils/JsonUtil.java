package com.dxmpay.wallet.utils;

import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsonUtil {
    public static List<RestNameValuePair> json2KeyValuePairs(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                arrayList.add(new RestNameValuePair(next, jSONObject.optString(next)));
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void jsonStringToNameValuePairList(String str, List<PassNameValuePair> list) {
        if (!TextUtils.isEmpty(str) && list != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    list.add(new PassNameValuePair(next, jSONObject.optString(next)));
                }
            } catch (JSONException e) {
                e.getMessage();
            }
        }
    }

    public static String jsonToURLParams(JSONObject jSONObject, boolean z) throws JSONException {
        Object obj;
        Object obj2;
        StringBuilder sb = new StringBuilder();
        if (jSONObject != null) {
            JSONArray names = jSONObject.names();
            if (names == null) {
                return null;
            }
            for (int i2 = 0; i2 < names.length(); i2++) {
                if (names.get(i2) != null && (names.get(i2) instanceof String)) {
                    StringBuilder sb2 = new StringBuilder((String) names.get(i2));
                    if (!TextUtils.isEmpty(sb2)) {
                        if (jSONObject.get(sb2.toString()) instanceof JSONObject) {
                            jsonToURLParams(new JSONObject(sb2.toString()), z);
                        }
                        try {
                            StringBuilder sb3 = new StringBuilder(z ? URLEncoder.encode(sb2.toString(), BeanConstants.ENCODE_GB_18030) : sb2);
                            if (jSONObject.get(sb2.toString()) != null && (jSONObject.get(sb2.toString()) instanceof String)) {
                                if (i2 < names.length() - 1) {
                                    sb3.append("=");
                                    if (z) {
                                        obj2 = URLEncoder.encode(jSONObject.get(sb2.toString()).toString(), BeanConstants.ENCODE_GB_18030);
                                    } else {
                                        obj2 = jSONObject.get(sb2.toString());
                                    }
                                    sb3.append(obj2);
                                    sb3.append(a.n);
                                    sb.append(sb3);
                                } else {
                                    sb3.append("=");
                                    if (z) {
                                        obj = URLEncoder.encode(jSONObject.get(sb2.toString()).toString(), BeanConstants.ENCODE_GB_18030);
                                    } else {
                                        obj = jSONObject.get(sb2.toString());
                                    }
                                    sb3.append(obj);
                                    sb.append(sb3);
                                }
                            }
                        } catch (JSONException e) {
                            LogUtil.e("JsonUtil", e.getMessage(), e);
                        } catch (UnsupportedEncodingException e2) {
                            LogUtil.e("JsonUtil", e2.getMessage(), e2);
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
}
