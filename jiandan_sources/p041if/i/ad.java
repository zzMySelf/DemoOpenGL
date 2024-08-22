package p041if.i;

/* renamed from: if.i.ad  reason: invalid package */
public final class ad<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final T f11127ad;
    public final long qw;

    public ad(long j, T t) {
        this.f11127ad = t;
        this.qw = j;
    }

    public T ad() {
        return this.f11127ad;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ad)) {
            return false;
        }
        ad adVar = (ad) obj;
        if (this.qw == adVar.qw) {
            T t = this.f11127ad;
            T t2 = adVar.f11127ad;
            if (t == t2) {
                return true;
            }
            if (t == null || !t.equals(t2)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.qw;
        int i2 = (((int) (j ^ (j >>> 32))) + 31) * 31;
        T t = this.f11127ad;
        return i2 + (t == null ? 0 : t.hashCode());
    }

    public long qw() {
        return this.qw;
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", new Object[]{Long.valueOf(this.qw), this.f11127ad.toString()});
    }
}
