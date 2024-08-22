package fe.fe.ddd.ddd.de.de;

import com.alipay.sdk.m.s.a;
import com.baidu.searchbox.config.AppConfig;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class qw {
    public static JSONObject ad(File file, String str, String str2, String str3, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errno", str2);
            jSONObject.put("errmsg", str3);
            jSONObject.put("isFile", z ? "1" : "0");
            if (file != null && file.exists() && file.isFile()) {
                jSONObject.put("zipPath", str);
                jSONObject.put("size", String.valueOf(file.length()));
                jSONObject.put("createTime", file.lastModified());
                jSONObject.put("modifiedTime", file.lastModified());
            }
        } catch (Exception e) {
            if (AppConfig.rg()) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static JSONObject de(List<String> list) {
        JSONObject jSONObject = new JSONObject();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String append : list) {
                        sb.append(append);
                        sb.append(a.n);
                    }
                    jSONObject.put("space", sb.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static JSONObject qw(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("bosMessage", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
