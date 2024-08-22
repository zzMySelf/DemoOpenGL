package fe.uk.qw.pf.th.fe;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class when extends th {

    /* renamed from: ad  reason: collision with root package name */
    public static final byte[] f5979ad = "com.dxmbumptech.glide.load.resource.bitmap.FitCenter".getBytes(Key.qw);

    public Bitmap de(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        return aaa.rg(bitmapPool, bitmap, i2, i3);
    }

    public boolean equals(Object obj) {
        return obj instanceof when;
    }

    public int hashCode() {
        return -1803367714;
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f5979ad);
    }
}
