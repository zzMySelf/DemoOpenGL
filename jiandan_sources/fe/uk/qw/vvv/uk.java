package fe.uk.qw.vvv;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class uk {

    /* renamed from: ad  reason: collision with root package name */
    public Class<?> f6057ad;

    /* renamed from: de  reason: collision with root package name */
    public Class<?> f6058de;
    public Class<?> qw;

    public uk() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || uk.class != obj.getClass()) {
            return false;
        }
        uk ukVar = (uk) obj;
        return this.qw.equals(ukVar.qw) && this.f6057ad.equals(ukVar.f6057ad) && o.de(this.f6058de, ukVar.f6058de);
    }

    public int hashCode() {
        int hashCode = ((this.qw.hashCode() * 31) + this.f6057ad.hashCode()) * 31;
        Class<?> cls = this.f6058de;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public void qw(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.qw = cls;
        this.f6057ad = cls2;
        this.f6058de = cls3;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.qw + ", second=" + this.f6057ad + ExtendedMessageFormat.END_FE;
    }

    public uk(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        qw(cls, cls2, cls3);
    }
}
