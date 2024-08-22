package fe.rg.qw.o.th.de;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import fe.rg.qw.o.ad;
import fe.rg.qw.o.th.rg.fe;

public class ggg implements ResourceDecoder<Uri, Bitmap> {

    /* renamed from: ad  reason: collision with root package name */
    public final BitmapPool f4961ad;
    public final fe qw;

    public ggg(fe feVar, BitmapPool bitmapPool) {
        this.qw = feVar;
        this.f4961ad = bitmapPool;
    }

    @Nullable
    /* renamed from: de */
    public Resource<Bitmap> ad(@NonNull Uri uri, int i2, int i3, @NonNull ad adVar) {
        Resource<Drawable> de2 = this.qw.ad(uri, i2, i3, adVar);
        if (de2 == null) {
            return null;
        }
        return o.qw(this.f4961ad, de2.get(), i2, i3);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull Uri uri, @NonNull ad adVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
