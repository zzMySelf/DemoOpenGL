package fe.mmm.qw.j;

import android.text.TextUtils;

public class qw {
    public static boolean qw(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("file:///android_asset/output/");
    }
}
