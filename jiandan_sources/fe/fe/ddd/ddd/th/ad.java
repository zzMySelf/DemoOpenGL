package fe.fe.ddd.ddd.th;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.idl.authority.BuildConfig;
import com.baidu.searchbox.config.AppConfig;
import fe.fe.ddd.p001switch.rg.qw;
import java.util.Map;
import org.json.JSONObject;

public abstract class ad {
    public static final boolean qw = AppConfig.rg();

    public abstract void ad(String str, String str2, Map<String, String> map, qw<JSONObject> qwVar);

    public String qw(String str) {
        String str2;
        String str3 = TextUtils.equals(str, "1") ? "/fetchlog/activeupload" : "/fetchlog/appupstream";
        boolean rg2 = fe.fe.ddd.ddd.de.de.fe.qw.ad().rg();
        if (!qw || !rg2) {
            str2 = "https://mbd.baidu.com" + str3;
        } else {
            str2 = "http://10.26.139.34:8092" + str3;
        }
        String uk2 = fe.fe.yj.de.ad.th().uk(str2);
        return (!qw || TextUtils.isEmpty(uk2)) ? uk2 : UrlUtil.addParam(uk2, BuildConfig.BUILD_TYPE, "1");
    }
}
