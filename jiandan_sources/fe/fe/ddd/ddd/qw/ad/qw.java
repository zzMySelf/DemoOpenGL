package fe.fe.ddd.ddd.qw.ad;

import com.baidu.searchbox.cloudcommand.processor.ICloudCommandObserver;
import org.json.JSONObject;

public class qw implements ICloudCommandObserver {
    public String ad() {
        return "fetch_log_notice";
    }

    public void qw(JSONObject jSONObject) {
        if (jSONObject != null) {
            fe.fe.ddd.ddd.qw.qw.fe().de(jSONObject);
        }
    }
}
