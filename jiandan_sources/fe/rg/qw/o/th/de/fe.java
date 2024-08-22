package fe.rg.qw.o.th.de;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import fe.rg.qw.ggg.i;
import fe.rg.qw.ggg.uk;

public class fe implements Resource<Bitmap>, Initializable {

    /* renamed from: ad  reason: collision with root package name */
    public final Bitmap f4959ad;

    /* renamed from: th  reason: collision with root package name */
    public final BitmapPool f4960th;

    public fe(@NonNull Bitmap bitmap, @NonNull BitmapPool bitmapPool) {
        uk.rg(bitmap, "Bitmap must not be null");
        this.f4959ad = bitmap;
        uk.rg(bitmapPool, "BitmapPool must not be null");
        this.f4960th = bitmapPool;
    }

    @Nullable
    public static fe fe(@Nullable Bitmap bitmap, @NonNull BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new fe(bitmap, bitmapPool);
    }

    @NonNull
    public Class<Bitmap> ad() {
        return Bitmap.class;
    }

    @NonNull
    /* renamed from: de */
    public Bitmap get() {
        return this.f4959ad;
    }

    public void initialize() {
        this.f4959ad.prepareToDraw();
    }

    public int qw() {
        return i.yj(this.f4959ad);
    }

    public void recycle() {
        this.f4960th.de(this.f4959ad);
    }
}
