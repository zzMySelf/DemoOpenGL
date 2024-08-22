package fe.mmm.qw.m.ggg.rg;

import android.net.Uri;
import android.text.TextUtils;
import com.tera.scan.webview.hybrid.parser.IParamParse;
import java.util.List;

public class ad implements IParamParse<fe.mmm.qw.m.ggg.fe.ad> {
    public fe.mmm.qw.m.ggg.fe.ad qw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        fe.mmm.qw.m.ggg.fe.ad adVar = new fe.mmm.qw.m.ggg.fe.ad();
        Uri parse = Uri.parse(str);
        adVar.qw = new qw().qw(parse.getAuthority());
        List<String> pathSegments = parse.getPathSegments();
        if (pathSegments.size() > 0) {
            adVar.f8045ad = pathSegments.get(0);
        }
        if (pathSegments.size() > 1) {
            adVar.f8046de = pathSegments.get(1);
        }
        adVar.f8047fe = parse.getQueryParameter("params");
        return adVar;
    }
}
