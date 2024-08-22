package fe.uk.qw.pf.fe;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.Key;
import java.security.MessageDigest;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public final class de implements Key {

    /* renamed from: ad  reason: collision with root package name */
    public final Key f5749ad;

    /* renamed from: de  reason: collision with root package name */
    public final Key f5750de;

    public de(Key key, Key key2) {
        this.f5749ad = key;
        this.f5750de = key2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof de)) {
            return false;
        }
        de deVar = (de) obj;
        if (!this.f5749ad.equals(deVar.f5749ad) || !this.f5750de.equals(deVar.f5750de)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f5749ad.hashCode() * 31) + this.f5750de.hashCode();
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        this.f5749ad.qw(messageDigest);
        this.f5750de.qw(messageDigest);
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f5749ad + ", signature=" + this.f5750de + ExtendedMessageFormat.END_FE;
    }
}
