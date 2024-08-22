package fe.fe.ddd.when.rg;

import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import fe.fe.ddd.p001switch.de;
import fe.fe.ddd.p001switch.p002if.i;
import fe.fe.ddd.when.qw.yj.ad;
import fe.fe.ddd.when.qw.yj.yj;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

public class qw extends ad {
    public yj ad(String str, File file, Map<String, String> map) {
        boolean z;
        i.qw vvv = de.mmm(fe.fe.ddd.i.qw.qw.qw()).vvv();
        vvv.th(3);
        vvv.uk(str);
        for (Map.Entry next : map.entrySet()) {
            vvv.qw((String) next.getKey(), (String) next.getValue());
        }
        String str2 = null;
        try {
            vvv.m82if(file);
            Response rg2 = vvv.ad().rg();
            if (rg2 != null) {
                ResponseBody body = rg2.body();
                if (body != null) {
                    str2 = body.string();
                }
                if (rg2.isSuccessful() && !TextUtils.isEmpty(str2)) {
                    try {
                        if (new JSONObject(str2).optInt(SapiUtils.KEY_QR_LOGIN_ERROR, -1) == 0) {
                            z = true;
                            return new yj(z, str2);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            z = false;
            return new yj(z, str2);
        } catch (IOException e2) {
            e2.printStackTrace();
            return new yj(false);
        }
    }
}
