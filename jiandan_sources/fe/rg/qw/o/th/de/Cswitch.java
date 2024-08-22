package fe.rg.qw.o.th.de;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* renamed from: fe.rg.qw.o.th.de.switch  reason: invalid class name */
public class Cswitch extends rg {

    /* renamed from: ad  reason: collision with root package name */
    public static final byte[] f4973ad = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(Key.qw);

    public Bitmap de(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        return xxx.rg(bitmapPool, bitmap, i2, i3);
    }

    public boolean equals(Object obj) {
        return obj instanceof Cswitch;
    }

    public int hashCode() {
        return 1572326941;
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f4973ad);
    }
}
