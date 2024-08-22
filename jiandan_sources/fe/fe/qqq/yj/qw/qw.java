package fe.fe.qqq.yj.qw;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ubcprocessor.UBCCloudConfigObserver;
import com.baidu.yalog.YaLogManager;
import fe.fe.vvv.ad.ad.ad;
import org.json.JSONException;
import org.json.JSONObject;

public class qw implements UBCCloudConfigObserver {
    public static final boolean qw = AppConfig.rg();

    public void qw(String str, JSONObject jSONObject) {
        String str2;
        if (qw) {
            "receive YaLog ID config data: " + str;
        }
        if (TextUtils.isEmpty(str)) {
            boolean z = qw;
            return;
        }
        if (jSONObject != null) {
            try {
                str2 = jSONObject.optString("version_asc");
            } catch (JSONException e) {
                if (qw) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        } else {
            str2 = "0";
        }
        ((YaLogManager) ad.qw(YaLogManager.qw)).qw(new JSONObject(str), !"0".equals(str2));
    }
}
