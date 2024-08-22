package fe.fe.vvv.ad.qw;

import android.util.Log;
import com.baidu.pyramid.runtime.multiprocess.IPCReporter;
import org.json.JSONException;
import org.json.JSONObject;

public class th {
    public static IPCReporter qw;

    public static void ad(Exception exc) {
        IPCReporter iPCReporter = qw;
        if (iPCReporter != null) {
            iPCReporter.qw(qw(exc).toString());
        }
    }

    public static void de(String str) {
        IPCReporter iPCReporter = qw;
        if (iPCReporter != null) {
            iPCReporter.qw(str);
        }
    }

    public static JSONObject qw(Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("process_name", qw.ad());
            jSONObject.put("stack_trace", Log.getStackTraceString(exc));
            jSONObject.put("process_info", qw.qw());
            jSONObject.put("report_time", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
