package fe.when.ad.f.q2.ad;

import java.io.IOException;
import java.util.HashMap;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static final HashMap<String, fe> f9721ad = new HashMap<>();

    /* renamed from: de  reason: collision with root package name */
    public static final HashMap<String, de> f9722de = new HashMap<>();
    public static final HashMap<String, th> qw = new HashMap<>();

    static {
        new HashMap();
    }

    public static fe ad(String str) throws IOException {
        fe feVar;
        synchronized (f9721ad) {
            feVar = f9721ad.get(str);
        }
        if (feVar == null) {
            feVar = new fe();
            rg.qw(str, feVar, new yj());
            synchronized (f9721ad) {
                f9721ad.put(str, feVar);
            }
        }
        return feVar;
    }

    public static th de(String str) throws IOException {
        th thVar;
        synchronized (qw) {
            thVar = qw.get(str);
        }
        if (thVar == null) {
            thVar = new th();
            rg.qw(str, thVar, new yj());
            synchronized (qw) {
                qw.put(str, thVar);
            }
        }
        return thVar;
    }

    public static de qw(String str) throws IOException {
        de deVar;
        synchronized (f9722de) {
            deVar = f9722de.get(str);
        }
        if (deVar == null) {
            deVar = new de();
            rg.qw(str, deVar, new yj());
            synchronized (f9722de) {
                f9722de.put(str, deVar);
            }
        }
        return deVar;
    }
}
