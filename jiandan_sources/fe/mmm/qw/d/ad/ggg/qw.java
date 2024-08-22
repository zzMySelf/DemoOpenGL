package fe.mmm.qw.d.ad.ggg;

import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import fe.mmm.qw.d.ad.Cif;
import fe.mmm.qw.d.ad.Cswitch;
import fe.mmm.qw.d.ad.ad;
import fe.mmm.qw.d.ad.de;
import fe.mmm.qw.d.ad.fe;
import fe.mmm.qw.d.ad.i;
import fe.mmm.qw.d.ad.o;
import fe.mmm.qw.d.ad.pf;
import fe.mmm.qw.d.ad.ppp;
import fe.mmm.qw.d.ad.rg;
import fe.mmm.qw.d.ad.th;
import fe.mmm.qw.d.ad.uk;
import fe.mmm.qw.d.ad.when;
import fe.mmm.qw.d.ad.yj;
import java.util.Map;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static Map<Integer, Pair<String, de>> f7687ad = new ArrayMap();
    public static Map<String, de> qw = new ArrayMap();

    static {
        qw.put(NotificationCompat.WearableExtender.KEY_BACKGROUND, new fe.mmm.qw.d.ad.qw());
        qw.put("textColor", new ppp());
        qw.put("src", new yj());
        qw.put("divider", new de());
        qw.put("dividerHeight", new fe());
        qw.put("paddingTop", new Cswitch());
        qw.put("paddingBottom", new o());
        qw.put("paddingRight", new Cif());
        qw.put("paddingLeft", new pf());
        qw.put("padding", new i());
        qw.put("fastScrollThumbDrawable", new th());
        qw.put("button", new ad());
        qw.put("drawableTop", new rg());
        qw.put("progressDrawable", new when());
        qw.put("indeterminateDrawable", new uk());
    }

    public static Map<Integer, Pair<String, de>> ad() {
        return f7687ad;
    }

    public static boolean de(String str) {
        return qw.containsKey(str);
    }

    public static de qw(String str, int i2, String str2, String str3) {
        de fe2 = qw.get(str).clone();
        if (fe2 == null) {
            return null;
        }
        fe2.f7682ad = str;
        fe2.f7683th = i2;
        fe2.f7685yj = str2;
        fe2.f7684uk = str3;
        return fe2;
    }
}
