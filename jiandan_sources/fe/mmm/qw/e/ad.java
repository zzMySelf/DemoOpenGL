package fe.mmm.qw.e;

import android.text.TextUtils;
import com.baidu.ubc.UBCManager;
import fe.mmm.qw.i.qw;
import org.json.JSONException;
import org.json.JSONObject;

public class ad {
    public static void ad(String str, JSONObject jSONObject) {
        ((UBCManager) fe.fe.vvv.ad.ad.ad.qw(UBCManager.SERVICE_REFERENCE)).onEvent(str, jSONObject);
        qw.ad("UBCStatistics", "EventStatistics Successful");
    }

    public static void qw(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put("from", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put("type", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject2.put(UBCManager.CONTENT_KEY_PAGE, str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                jSONObject2.put("value", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                jSONObject2.put(UBCManager.CONTENT_KEY_SOURCE, str6);
            }
            if (jSONObject != null) {
                jSONObject2.put(UBCManager.CONTENT_KEY_EXT, jSONObject);
            }
            ad(str, jSONObject2);
        } catch (JSONException unused) {
            qw.rg("UBCStatistics", "onEventStatistics JSONException");
        }
    }
}
