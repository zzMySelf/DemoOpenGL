package fe.qw.qw.p009switch;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: fe.qw.qw.switch.yj  reason: invalid package */
public class yj<T> {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public T f3511ad;
    @Nullable
    public T qw;

    public static boolean qw(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void ad(T t, T t2) {
        this.qw = t;
        this.f3511ad = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!qw(pair.first, this.qw) || !qw(pair.second, this.f3511ad)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        T t = this.qw;
        int i2 = 0;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f3511ad;
        if (t2 != null) {
            i2 = t2.hashCode();
        }
        return hashCode ^ i2;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.qw) + " " + String.valueOf(this.f3511ad) + "}";
    }
}
