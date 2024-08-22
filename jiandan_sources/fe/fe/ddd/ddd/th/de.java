package fe.fe.ddd.ddd.th;

import com.baidu.searchbox.config.AppConfig;
import fe.fe.ddd.p001switch.p002if.o;
import fe.fe.ddd.p001switch.rg.qw;
import java.util.Map;
import org.json.JSONObject;

public class de extends ad {
    static {
        AppConfig.rg();
    }

    public void ad(String str, String str2, Map<String, String> map, qw<JSONObject> qwVar) {
        o.qw xxx = fe.fe.ddd.p001switch.de.mmm(fe.fe.ddd.i.qw.qw.qw()).xxx();
        xxx.uk(qw(str));
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                xxx.qw((String) next.getKey(), (String) next.getValue());
            }
        }
        xxx.i("req", str2);
        xxx.de(fe.fe.ddd.p001switch.de.mmm(fe.fe.ddd.i.qw.qw.qw()).th(true, true));
        xxx.ad().fe(qwVar);
    }
}
