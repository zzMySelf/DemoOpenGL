package fe.rg.qw.ppp;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import fe.rg.qw.ggg.uk;
import java.security.MessageDigest;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public final class de implements Key {

    /* renamed from: ad  reason: collision with root package name */
    public final Object f5021ad;

    public de(@NonNull Object obj) {
        uk.fe(obj);
        this.f5021ad = obj;
    }

    public boolean equals(Object obj) {
        if (obj instanceof de) {
            return this.f5021ad.equals(((de) obj).f5021ad);
        }
        return false;
    }

    public int hashCode() {
        return this.f5021ad.hashCode();
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f5021ad.toString().getBytes(Key.qw));
    }

    public String toString() {
        return "ObjectKey{object=" + this.f5021ad + ExtendedMessageFormat.END_FE;
    }
}
