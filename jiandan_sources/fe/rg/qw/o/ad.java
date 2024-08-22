package fe.rg.qw.o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public final class ad implements Key {

    /* renamed from: ad  reason: collision with root package name */
    public final ArrayMap<Option<?>, Object> f4717ad = new CachedHashCodeArrayMap();

    public static <T> void th(@NonNull Option<T> option, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        option.yj(obj, messageDigest);
    }

    @Nullable
    public <T> T de(@NonNull Option<T> option) {
        return this.f4717ad.containsKey(option) ? this.f4717ad.get(option) : option.de();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ad) {
            return this.f4717ad.equals(((ad) obj).f4717ad);
        }
        return false;
    }

    public void fe(@NonNull ad adVar) {
        this.f4717ad.putAll(adVar.f4717ad);
    }

    public int hashCode() {
        return this.f4717ad.hashCode();
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.f4717ad.size(); i2++) {
            th(this.f4717ad.keyAt(i2), this.f4717ad.valueAt(i2), messageDigest);
        }
    }

    @NonNull
    public <T> ad rg(@NonNull Option<T> option, @NonNull T t) {
        this.f4717ad.put(option, t);
        return this;
    }

    public String toString() {
        return "Options{values=" + this.f4717ad + ExtendedMessageFormat.END_FE;
    }
}
