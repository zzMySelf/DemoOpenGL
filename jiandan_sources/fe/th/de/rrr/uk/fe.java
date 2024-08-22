package fe.th.de.rrr.uk;

import com.duxiaoman.okhttp3.CookieJar;
import fe.th.de.Cif;
import fe.th.de.mmm;
import fe.th.de.pf;
import fe.th.de.uk;
import java.util.List;
import okio.ByteString;

public final class fe {
    static {
        ByteString.encodeUtf8("\"\\");
        ByteString.encodeUtf8("\t ,=");
    }

    public static long ad(mmm mmm) {
        return qw(mmm.pf());
    }

    public static boolean de(mmm mmm) {
        if (mmm.nn().th().equals("HEAD")) {
            return false;
        }
        int rg2 = mmm.rg();
        if (((rg2 >= 100 && rg2 < 200) || rg2 == 204 || rg2 == 304) && ad(mmm) == -1 && !"chunked".equalsIgnoreCase(mmm.yj("Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    public static int fe(String str, int i2) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public static long qw(pf pfVar) {
        return uk(pfVar.de("Content-Length"));
    }

    public static void rg(CookieJar cookieJar, Cif ifVar, pf pfVar) {
        if (cookieJar != CookieJar.qw) {
            List<uk> th2 = uk.th(ifVar, pfVar);
            if (!th2.isEmpty()) {
                cookieJar.ad(ifVar, th2);
            }
        }
    }

    public static int th(String str, int i2, String str2) {
        while (i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            i2++;
        }
        return i2;
    }

    public static long uk(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int yj(String str, int i2) {
        while (i2 < str.length() && ((r0 = str.charAt(i2)) == ' ' || r0 == 9)) {
            i2++;
        }
        return i2;
    }
}
