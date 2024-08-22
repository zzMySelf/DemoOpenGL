package fe.p013if.de.qw;

import android.content.Context;
import com.github.moduth.blockcanary.BlockInterceptor;
import fe.p013if.de.qw.uk.qw;

/* renamed from: fe.if.de.qw.ad  reason: invalid package */
public class ad implements BlockInterceptor {

    /* renamed from: ad  reason: collision with root package name */
    public static ad f4595ad = null;

    /* renamed from: de  reason: collision with root package name */
    public static int f4596de = 2000;
    public static Context qw;

    public static ad de() {
        ad adVar = f4595ad;
        if (adVar != null) {
            return adVar;
        }
        throw new RuntimeException("BlockCanaryContext null");
    }

    public static void fe(Context context, ad adVar, int i2) {
        qw = context;
        f4595ad = adVar;
        f4596de = i2;
    }

    public abstract boolean ad();

    public String i() {
        return "/blockcanary/";
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m293if() {
        return true;
    }

    public String o() {
        return "unknown";
    }

    public String pf() {
        return "uid";
    }

    public void qw(Context context, qw qwVar) {
    }

    public int rg() {
        return f4596de;
    }

    public Context th() {
        return qw;
    }

    public String uk() {
        return "unknown";
    }

    public int yj() {
        return rg();
    }
}
