package fe.uk.qw.pf.th.fe;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.engine.Initializable;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import fe.uk.qw.vvv.i;
import fe.uk.qw.vvv.o;

public class rg implements Resource<Bitmap>, Initializable {

    /* renamed from: ad  reason: collision with root package name */
    public final Bitmap f5977ad;

    /* renamed from: th  reason: collision with root package name */
    public final BitmapPool f5978th;

    public rg(@NonNull Bitmap bitmap, @NonNull BitmapPool bitmapPool) {
        i.rg(bitmap, "Bitmap must not be null");
        this.f5977ad = bitmap;
        i.rg(bitmapPool, "BitmapPool must not be null");
        this.f5978th = bitmapPool;
    }

    @Nullable
    public static rg fe(@Nullable Bitmap bitmap, @NonNull BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new rg(bitmap, bitmapPool);
    }

    @NonNull
    public Class<Bitmap> ad() {
        return Bitmap.class;
    }

    @NonNull
    /* renamed from: de */
    public Bitmap get() {
        return this.f5977ad;
    }

    public void initialize() {
        this.f5977ad.prepareToDraw();
    }

    public int qw() {
        return o.yj(this.f5977ad);
    }

    public void recycle() {
        this.f5978th.de(this.f5977ad);
    }
}
