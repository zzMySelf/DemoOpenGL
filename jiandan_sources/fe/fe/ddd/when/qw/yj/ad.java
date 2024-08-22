package fe.fe.ddd.when.qw.yj;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.idl.authority.BuildConfig;
import com.baidu.searchbox.config.AppConfig;
import com.baidubce.util.Mimetypes;
import fe.fe.ddd.when.qw.yj.i.de;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class ad {
    public abstract yj ad(@NonNull String str, @NonNull File file, @Nullable Map<String, String> map);

    public yj de(@NonNull File file) {
        String qw = qw();
        LinkedHashMap linkedHashMap = new LinkedHashMap(2);
        linkedHashMap.put("Content-type", Mimetypes.MIMETYPE_OCTET_STREAM);
        linkedHashMap.put("nb", "1");
        return ad(qw, file, linkedHashMap);
    }

    public final String qw() {
        String rg2 = de.de().rg(AppConfig.rg() ? "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=crash" : "https://tcbox.baidu.com/ztbox?action=crash");
        return (!AppConfig.rg() || TextUtils.isEmpty(rg2)) ? rg2 : UrlUtil.addParam(rg2, BuildConfig.BUILD_TYPE, "1");
    }
}
