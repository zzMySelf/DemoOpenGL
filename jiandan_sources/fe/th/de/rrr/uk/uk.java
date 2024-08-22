package fe.th.de.rrr.uk;

import com.google.common.base.Ascii;
import fe.th.de.Cif;
import fe.th.de.ddd;
import java.net.Proxy;

public final class uk {
    public static boolean ad(ddd ddd, Proxy.Type type) {
        return !ddd.rg() && type == Proxy.Type.HTTP;
    }

    public static String de(Cif ifVar) {
        String yj2 = ifVar.yj();
        String i2 = ifVar.i();
        if (i2 == null) {
            return yj2;
        }
        return yj2 + '?' + i2;
    }

    public static String qw(ddd ddd, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(ddd.th());
        sb.append(Ascii.CASE_MASK);
        if (ad(ddd, type)) {
            sb.append(ddd.uk());
        } else {
            sb.append(de(ddd.uk()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }
}
