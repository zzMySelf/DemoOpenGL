package fe.uk.qw.pf.th.fe;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class i extends th {

    /* renamed from: ad  reason: collision with root package name */
    public static final byte[] f5958ad = "com.dxmbumptech.glide.load.resource.bitmap.CenterCrop".getBytes(Key.qw);

    public Bitmap de(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        return aaa.ad(bitmapPool, bitmap, i2, i3);
    }

    public boolean equals(Object obj) {
        return obj instanceof i;
    }

    public int hashCode() {
        return 2127893613;
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f5958ad);
    }
}
