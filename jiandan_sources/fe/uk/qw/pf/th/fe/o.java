package fe.uk.qw.pf.th.fe;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class o extends th {

    /* renamed from: ad  reason: collision with root package name */
    public static final byte[] f5964ad = "com.dxmbumptech.glide.load.resource.bitmap.CenterInside".getBytes(Key.qw);

    public Bitmap de(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        return aaa.de(bitmapPool, bitmap, i2, i3);
    }

    public boolean equals(Object obj) {
        return obj instanceof o;
    }

    public int hashCode() {
        return 669525657;
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f5964ad);
    }
}
