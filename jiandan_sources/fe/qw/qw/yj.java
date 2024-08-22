package fe.qw.qw;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class yj<V> {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public final Throwable f3537ad;
    @Nullable
    public final V qw;

    public yj(V v) {
        this.qw = v;
        this.f3537ad = null;
    }

    @Nullable
    public V ad() {
        return this.qw;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yj)) {
            return false;
        }
        yj yjVar = (yj) obj;
        if (ad() != null && ad().equals(yjVar.ad())) {
            return true;
        }
        if (qw() == null || yjVar.qw() == null) {
            return false;
        }
        return qw().toString().equals(qw().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{ad(), qw()});
    }

    @Nullable
    public Throwable qw() {
        return this.f3537ad;
    }

    public yj(Throwable th2) {
        this.f3537ad = th2;
        this.qw = null;
    }
}
