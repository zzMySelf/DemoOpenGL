package fe.uk.qw.pf.th.fe;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import fe.uk.qw.pf.ad;
import fe.uk.qw.pf.th.th.fe;

public class nn implements ResourceDecoder<Uri, Bitmap> {

    /* renamed from: ad  reason: collision with root package name */
    public final BitmapPool f5963ad;
    public final fe qw;

    public nn(fe feVar, BitmapPool bitmapPool) {
        this.qw = feVar;
        this.f5963ad = bitmapPool;
    }

    @Nullable
    /* renamed from: de */
    public Resource<Bitmap> ad(@NonNull Uri uri, int i2, int i3, @NonNull ad adVar) {
        Resource<Drawable> de2 = this.qw.ad(uri, i2, i3, adVar);
        if (de2 == null) {
            return null;
        }
        return pf.qw(this.f5963ad, de2.get(), i2, i3);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull Uri uri, @NonNull ad adVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
