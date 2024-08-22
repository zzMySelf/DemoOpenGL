package fe.fe.vvv.ad.ad;

import androidx.annotation.NonNull;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public final String f3159ad;
    public final String qw;

    public de(@NonNull String str, @NonNull String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("namespace & name can not be null");
        }
        this.qw = str;
        this.f3159ad = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || de.class != obj.getClass()) {
            return false;
        }
        de deVar = (de) obj;
        if (!this.qw.equals(deVar.qw)) {
            return false;
        }
        return this.f3159ad.equals(deVar.f3159ad);
    }

    public int hashCode() {
        return (this.qw.hashCode() * 31) + this.f3159ad.hashCode();
    }

    public String toString() {
        return "ServiceReference{mNameSpace='" + this.qw + ExtendedMessageFormat.QUOTE + ", mName='" + this.f3159ad + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
