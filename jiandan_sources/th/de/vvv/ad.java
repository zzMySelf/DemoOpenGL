package th.de.vvv;

import java.util.concurrent.TimeUnit;
import th.de.p039if.ad.qw;

public final class ad<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final long f11029ad;

    /* renamed from: de  reason: collision with root package name */
    public final TimeUnit f11030de;
    public final T qw;

    public ad(T t, long j, TimeUnit timeUnit) {
        this.qw = t;
        this.f11029ad = j;
        qw.rg(timeUnit, "unit is null");
        this.f11030de = timeUnit;
    }

    public T ad() {
        return this.qw;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ad)) {
            return false;
        }
        ad adVar = (ad) obj;
        if (!qw.de(this.qw, adVar.qw) || this.f11029ad != adVar.f11029ad || !qw.de(this.f11030de, adVar.f11030de)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        T t = this.qw;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.f11029ad;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 31)))) * 31) + this.f11030de.hashCode();
    }

    public long qw() {
        return this.f11029ad;
    }

    public String toString() {
        return "Timed[time=" + this.f11029ad + ", unit=" + this.f11030de + ", value=" + this.qw + "]";
    }
}
