package fe.uk.qw.pf;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.Option;
import com.dxmbumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public final class ad implements Key {

    /* renamed from: ad  reason: collision with root package name */
    public final ArrayMap<Option<?>, Object> f5684ad = new CachedHashCodeArrayMap();

    public static <T> void th(@NonNull Option<T> option, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        option.yj(obj, messageDigest);
    }

    @Nullable
    public <T> T de(@NonNull Option<T> option) {
        return this.f5684ad.containsKey(option) ? this.f5684ad.get(option) : option.de();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ad) {
            return this.f5684ad.equals(((ad) obj).f5684ad);
        }
        return false;
    }

    public void fe(@NonNull ad adVar) {
        this.f5684ad.putAll(adVar.f5684ad);
    }

    public int hashCode() {
        return this.f5684ad.hashCode();
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.f5684ad.size(); i2++) {
            th(this.f5684ad.keyAt(i2), this.f5684ad.valueAt(i2), messageDigest);
        }
    }

    @NonNull
    public <T> ad rg(@NonNull Option<T> option, @NonNull T t) {
        this.f5684ad.put(option, t);
        return this;
    }

    public String toString() {
        return "Options{values=" + this.f5684ad + ExtendedMessageFormat.END_FE;
    }
}
