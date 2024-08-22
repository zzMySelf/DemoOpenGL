package fe.fe.ddd.yj.th;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.UBCManager;
import fe.fe.ddd.yj.ad.rg;
import fe.fe.vvv.ad.ad.ad;
import org.json.JSONException;
import org.json.JSONObject;

public class qw {
    public void qw(rg rgVar) {
        if (rgVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UBCManager.CONTENT_KEY_SOURCE, rgVar.rg());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("logid", rgVar.fe());
                JSONObject th2 = rgVar.th();
                if (!(th2 == null || th2.length() == 0)) {
                    jSONObject2.put("service", th2);
                }
                JSONObject de2 = rgVar.de();
                if (!(de2 == null || de2.length() == 0)) {
                    jSONObject2.put("control", de2);
                }
                if (!TextUtils.isEmpty(rgVar.yj())) {
                    jSONObject2.put("traceid", rgVar.yj());
                }
                jSONObject.put(UBCManager.CONTENT_KEY_EXT, jSONObject2);
                UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.onEvent("944", jSONObject);
                }
                if (AppConfig.rg()) {
                    "cloud control ubc is 944:" + jSONObject.toString();
                }
            } catch (JSONException e) {
                if (AppConfig.rg()) {
                    "cloud control doStatistics error" + e.toString();
                    e.printStackTrace();
                }
            }
        }
    }
}
