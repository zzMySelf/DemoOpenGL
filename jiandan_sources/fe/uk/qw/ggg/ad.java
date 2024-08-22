package fe.uk.qw.ggg;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.Key;
import fe.uk.qw.vvv.i;
import java.security.MessageDigest;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public final class ad implements Key {

    /* renamed from: ad  reason: collision with root package name */
    public final Object f5614ad;

    public ad(@NonNull Object obj) {
        i.fe(obj);
        this.f5614ad = obj;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ad) {
            return this.f5614ad.equals(((ad) obj).f5614ad);
        }
        return false;
    }

    public int hashCode() {
        return this.f5614ad.hashCode();
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f5614ad.toString().getBytes(Key.qw));
    }

    public String toString() {
        return "ObjectKey{object=" + this.f5614ad + ExtendedMessageFormat.END_FE;
    }
}
