package fe.rg.qw.o.th.de;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class uk extends rg {

    /* renamed from: ad  reason: collision with root package name */
    public static final byte[] f4974ad = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(Key.qw);

    public Bitmap de(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        return xxx.de(bitmapPool, bitmap, i2, i3);
    }

    public boolean equals(Object obj) {
        return obj instanceof uk;
    }

    public int hashCode() {
        return -670243078;
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f4974ad);
    }
}
