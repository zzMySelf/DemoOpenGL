package fe.fe.ddd.ggg.qw.de;

import android.content.Context;
import android.util.Pair;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.v2.IUpdatePostDataFilter;
import fe.fe.ddd.ggg.qw.qw;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class de {
    public final Map<Pair<String, String>, qw> qw = new HashMap();

    public de() {
        fe();
    }

    public qw ad(String str, String str2) {
        return this.qw.get(de(str, str2));
    }

    public final Pair<String, String> de(String str, String str2) {
        return new Pair<>(str, str2);
    }

    public final void fe() {
    }

    public void qw(Context context, qw qwVar, IUpdatePostDataFilter iUpdatePostDataFilter) {
        for (Pair next : this.qw.keySet()) {
            if (iUpdatePostDataFilter == null || !iUpdatePostDataFilter.qw((String) next.first, (String) next.second)) {
                try {
                    qw ad2 = ad((String) next.first, (String) next.second);
                    JSONObject rg2 = qwVar.rg();
                    JSONObject de2 = qwVar.de();
                    JSONObject optJSONObject = rg2.optJSONObject((String) next.first);
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                        rg2.put((String) next.first, optJSONObject);
                    }
                    JSONObject optJSONObject2 = de2.optJSONObject((String) next.first);
                    if (optJSONObject2 == null) {
                        optJSONObject2 = new JSONObject();
                        de2.put((String) next.first, optJSONObject2);
                    }
                    ad2.qw(context, (String) next.first, (String) next.second, new qw(optJSONObject, optJSONObject2, qwVar.fe()));
                } catch (Exception e) {
                    e.printStackTrace();
                    if (AppConfig.rg()) {
                        "addPostData error " + e.getMessage();
                    }
                }
            }
        }
        qwVar.qw();
    }
}
