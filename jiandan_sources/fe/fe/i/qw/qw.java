package fe.fe.i.qw;

import android.content.Context;
import com.baidu.crashpad.ZeusLogUploader;
import com.baidu.crashpad.ZwCrashpad;
import fe.fe.ddd.when.fe.th;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public final class qw {
    public static void qw() {
        ZwCrashpad.setEnabled(true);
        File fe2 = th.ad().fe();
        Context qw = fe.fe.ddd.i.qw.qw.qw();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("clientDir", qw.getApplicationInfo().nativeLibraryDir);
            jSONObject.put("handlerDir", qw.getApplicationInfo().nativeLibraryDir);
            jSONObject.put("dumpCopyDir", fe2.getAbsolutePath());
        } catch (JSONException unused) {
        }
        if (jSONObject.length() != 0) {
            ZwCrashpad.doInitGeneric(qw, jSONObject.toString());
            ZeusLogUploader.pf(false);
        }
    }
}
