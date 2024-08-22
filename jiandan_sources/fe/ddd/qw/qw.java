package fe.ddd.qw;

import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f7564ad;

    /* renamed from: de  reason: collision with root package name */
    public final boolean f7565de;
    public final String qw;

    public qw(String str, boolean z, boolean z2) {
        this.qw = str;
        this.f7564ad = z;
        this.f7565de = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || qw.class != obj.getClass()) {
            return false;
        }
        qw qwVar = (qw) obj;
        if (this.f7564ad == qwVar.f7564ad && this.f7565de == qwVar.f7565de) {
            return this.qw.equals(qwVar.qw);
        }
        return false;
    }

    public int hashCode() {
        return (((this.qw.hashCode() * 31) + (this.f7564ad ? 1 : 0)) * 31) + (this.f7565de ? 1 : 0);
    }

    public String toString() {
        return "Permission{name='" + this.qw + ExtendedMessageFormat.QUOTE + ", granted=" + this.f7564ad + ", shouldShowRequestPermissionRationale=" + this.f7565de + ExtendedMessageFormat.END_FE;
    }
}
