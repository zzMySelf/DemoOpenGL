package fe.rg.qw.ggg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class yj {

    /* renamed from: ad  reason: collision with root package name */
    public Class<?> f4682ad;

    /* renamed from: de  reason: collision with root package name */
    public Class<?> f4683de;
    public Class<?> qw;

    public yj() {
    }

    public void ad(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.qw = cls;
        this.f4682ad = cls2;
        this.f4683de = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || yj.class != obj.getClass()) {
            return false;
        }
        yj yjVar = (yj) obj;
        return this.qw.equals(yjVar.qw) && this.f4682ad.equals(yjVar.f4682ad) && i.de(this.f4683de, yjVar.f4683de);
    }

    public int hashCode() {
        int hashCode = ((this.qw.hashCode() * 31) + this.f4682ad.hashCode()) * 31;
        Class<?> cls = this.f4683de;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public void qw(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        ad(cls, cls2, (Class<?>) null);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.qw + ", second=" + this.f4682ad + ExtendedMessageFormat.END_FE;
    }

    public yj(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        qw(cls, cls2);
    }

    public yj(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        ad(cls, cls2, cls3);
    }
}
