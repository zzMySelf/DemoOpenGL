package fe.qw.qw.p009switch;

import androidx.annotation.RestrictTo;
import fe.qw.qw.p009switch.i.i;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: fe.qw.qw.switch.de  reason: invalid package */
public class de {

    /* renamed from: ad  reason: collision with root package name */
    public final char f3434ad;

    /* renamed from: de  reason: collision with root package name */
    public final double f3435de;

    /* renamed from: fe  reason: collision with root package name */
    public final String f3436fe;
    public final List<i> qw;

    /* renamed from: rg  reason: collision with root package name */
    public final String f3437rg;

    public de(List<i> list, char c, double d, double d2, String str, String str2) {
        this.qw = list;
        this.f3434ad = c;
        this.f3435de = d2;
        this.f3436fe = str;
        this.f3437rg = str2;
    }

    public static int de(char c, String str, String str2) {
        return ((((0 + c) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public double ad() {
        return this.f3435de;
    }

    public int hashCode() {
        return de(this.f3434ad, this.f3437rg, this.f3436fe);
    }

    public List<i> qw() {
        return this.qw;
    }
}
