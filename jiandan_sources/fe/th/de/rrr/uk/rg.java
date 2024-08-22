package fe.th.de.rrr.uk;

import androidx.browser.trusted.sharing.ShareTarget;

public final class rg {
    public static boolean ad(String str) {
        return !str.equals(ShareTarget.METHOD_GET) && !str.equals("HEAD");
    }

    public static boolean de(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean fe(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean qw(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean rg(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }
}
