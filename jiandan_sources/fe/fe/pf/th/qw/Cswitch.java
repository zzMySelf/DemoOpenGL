package fe.fe.pf.th.qw;

import org.json.JSONObject;

/* renamed from: fe.fe.pf.th.qw.switch  reason: invalid class name */
public class Cswitch {
    public static boolean ad(String str) {
        int length;
        if (!(str == null || (length = str.length()) == 0)) {
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isWhitespace(str.charAt(i2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static JSONObject qw(String str) {
        if (ad(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
