package pf;

import java.util.Comparator;
import okhttp3.CipherSuite;

/* compiled from: lambda */
public final /* synthetic */ class ad implements Comparator {

    /* renamed from: ad  reason: collision with root package name */
    public static final /* synthetic */ ad f11369ad = new ad();

    private /* synthetic */ ad() {
    }

    public final int compare(Object obj, Object obj2) {
        return CipherSuite.qw((String) obj, (String) obj2);
    }
}
