package fe.mmm.qw.m.ggg.rg;

import android.text.TextUtils;
import com.tera.scan.webview.hybrid.parser.IParamParse;

public class qw implements IParamParse<fe.mmm.qw.m.ggg.fe.qw> {
    public fe.mmm.qw.m.ggg.fe.qw qw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        fe.mmm.qw.m.ggg.fe.qw qwVar = new fe.mmm.qw.m.ggg.fe.qw();
        qwVar.qw = str;
        String[] split = str.split("_");
        int length = split.length;
        if (length > 0) {
            String str2 = split[0];
        }
        if (length > 1) {
            String str3 = split[1];
        }
        if (length > 2) {
            String str4 = split[2];
        }
        return qwVar;
    }
}
