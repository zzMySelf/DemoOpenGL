package fe.fe.ddd.yj.th;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.http.NetworkQuality;
import com.baidu.ubc.UBCManager;
import fe.fe.ddd.i.qw.qw;
import fe.fe.vvv.ad.ad.ad;
import org.json.JSONException;
import org.json.JSONObject;

public class de {
    public static void ad(String str, int i2, String str2, int i3, int i4, String str3, long j, long j2, long j3) {
        int i5 = i4;
        String qw = ConnectManager.qw(qw.qw());
        int qw2 = NetworkQuality.qw();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "stability");
            String str4 = str;
            jSONObject.put(UBCManager.CONTENT_KEY_SOURCE, str);
            int i6 = i2;
            jSONObject.put("value", i2);
            JSONObject jSONObject2 = new JSONObject();
            String str5 = str2;
            jSONObject2.put("traceid", str2);
            jSONObject2.put("network", qw);
            jSONObject2.put("networkQuality", String.valueOf(qw2));
            int i7 = i3;
            jSONObject2.put("responseCode", i3);
            long j4 = j;
            jSONObject2.put("duration", j);
            if (j2 != 0) {
                jSONObject2.put("length", String.valueOf(j2));
            }
            if (j3 != 0) {
                jSONObject2.put("postLength", String.valueOf(j3));
            }
            if (i5 != -100) {
                jSONObject2.put("errorCode", i4);
            }
            if (!TextUtils.isEmpty(str3)) {
                String str6 = str3;
                jSONObject2.put("errorMsg", str3);
            }
            jSONObject.put(UBCManager.CONTENT_KEY_EXT, jSONObject2);
            UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
            if (uBCManager != null) {
                uBCManager.onEvent("1928", jSONObject);
            }
            if (AppConfig.rg()) {
                "doResponseStatistics 1928:" + jSONObject.toString();
            }
        } catch (JSONException e) {
            if (AppConfig.rg()) {
                "doResponseStatistics error" + e.toString();
                e.printStackTrace();
            }
        }
    }

    public static void qw(String str, String str2, long j) {
        String qw = ConnectManager.qw(qw.qw());
        int qw2 = NetworkQuality.qw();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "stability");
            jSONObject.put(UBCManager.CONTENT_KEY_SOURCE, str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("traceid", str2);
            jSONObject2.put("network", qw);
            jSONObject2.put("networkQuality", String.valueOf(qw2));
            if (j != -1) {
                jSONObject2.put("length", String.valueOf(j));
            }
            jSONObject.put(UBCManager.CONTENT_KEY_EXT, jSONObject2);
            UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
            if (uBCManager != null) {
                uBCManager.onEvent("1929", jSONObject);
            }
            if (AppConfig.rg()) {
                "doRequestStatistics 1929:" + jSONObject.toString();
            }
        } catch (JSONException e) {
            if (AppConfig.rg()) {
                "doRequestStatistics error" + e.toString();
                e.printStackTrace();
            }
        }
    }
}
