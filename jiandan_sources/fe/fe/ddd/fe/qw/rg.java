package fe.fe.ddd.fe.qw;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.activity.BindVerifyActivity;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class rg {

    public static class qw implements Comparator<Map.Entry<String, String>> {
        /* renamed from: qw */
        public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
            return entry.getKey().compareTo(entry2.getKey());
        }
    }

    public static String ad(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            jSONObject2.put("type", str);
            jSONObject2.put("timestamp", valueOf);
            jSONObject2.put("sign", th(jSONObject2));
            jSONObject.put("req", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static yj de(String str) {
        JSONObject optJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!"0".equals(jSONObject.optString("errno", "-1")) || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return null;
            }
            optJSONObject.put("localExpireAt", System.currentTimeMillis() + (optJSONObject.optLong("expire") * 1000));
            return rg(optJSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static yj fe(String str) {
        try {
            return rg(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean qw(yj yjVar) {
        if (yjVar == null || TextUtils.isEmpty(yjVar.qw) || TextUtils.isEmpty(yjVar.f1428ad) || TextUtils.isEmpty(yjVar.f1429de) || TextUtils.isEmpty(yjVar.f1431rg) || TextUtils.isEmpty(yjVar.f1432th) || TextUtils.isEmpty(yjVar.f1434yj)) {
            return false;
        }
        try {
            return yjVar.f1430fe >= System.currentTimeMillis();
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static yj rg(@NonNull JSONObject jSONObject) {
        yj yjVar = new yj(jSONObject.optString(BindVerifyActivity.f951o), jSONObject.optString("sk"), jSONObject.optString("token"), jSONObject.optLong("localExpireAt"), jSONObject.optString("expire"), jSONObject.optString("bucket"), jSONObject.optString("endpoint"));
        yjVar.ad(jSONObject.toString());
        return yjVar;
    }

    public static String th(JSONObject jSONObject) {
        if (jSONObject != null) {
            StringBuffer stringBuffer = new StringBuffer();
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    String string = jSONObject.getString(next);
                    if (!TextUtils.isEmpty(string)) {
                        hashMap.put(next, string);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            ArrayList<Map.Entry> arrayList = new ArrayList<>(hashMap.entrySet());
            Collections.sort(arrayList, new qw());
            for (Map.Entry entry : arrayList) {
                stringBuffer.append((String) entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append((String) entry.getValue());
            }
            stringBuffer.append("gettoken");
            try {
                return MD5Util.toMd5(stringBuffer.toString().getBytes("UTF-8"), false);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }
}
