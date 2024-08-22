package fe.mmm.qw.de.qw.qw;

import android.net.Uri;
import android.text.TextUtils;
import com.dxmpay.wallet.core.Domains;

public class qw {
    public static boolean qw(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (!(parse == null || parse.getHost() == null)) {
                return parse.getHost().endsWith(Domains.BAIDU);
            }
        } catch (Exception e) {
            fe.mmm.qw.i.qw.de("CommonServerURL", e.getMessage(), e);
        }
        return false;
    }
}
