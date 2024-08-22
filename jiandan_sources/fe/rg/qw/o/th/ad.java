package fe.rg.qw.o.th;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

public final class ad<T> implements Transformation<T> {

    /* renamed from: ad  reason: collision with root package name */
    public static final Transformation<?> f4954ad = new ad();

    @NonNull
    public static <T> ad<T> de() {
        return (ad) f4954ad;
    }

    @NonNull
    public Resource<T> ad(@NonNull Context context, @NonNull Resource<T> resource, int i2, int i3) {
        return resource;
    }

    public void qw(@NonNull MessageDigest messageDigest) {
    }
}
