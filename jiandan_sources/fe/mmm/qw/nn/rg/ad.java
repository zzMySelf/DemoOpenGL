package fe.mmm.qw.nn.rg;

import android.text.TextUtils;
import fe.mmm.qw.nn.de.uk;

public class ad {
    public static String qw(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        uk ukVar = new uk(str);
        if (!TextUtils.isEmpty(str)) {
            str2 = "BDUSS=" + str;
        }
        return ukVar.qw(str2);
    }
}
