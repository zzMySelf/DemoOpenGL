package fe.rg.qw.o.fe;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public final class de implements Key {

    /* renamed from: ad  reason: collision with root package name */
    public final Key f4782ad;

    /* renamed from: de  reason: collision with root package name */
    public final Key f4783de;

    public de(Key key, Key key2) {
        this.f4782ad = key;
        this.f4783de = key2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof de)) {
            return false;
        }
        de deVar = (de) obj;
        if (!this.f4782ad.equals(deVar.f4782ad) || !this.f4783de.equals(deVar.f4783de)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f4782ad.hashCode() * 31) + this.f4783de.hashCode();
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        this.f4782ad.qw(messageDigest);
        this.f4783de.qw(messageDigest);
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f4782ad + ", signature=" + this.f4783de + ExtendedMessageFormat.END_FE;
    }
}
