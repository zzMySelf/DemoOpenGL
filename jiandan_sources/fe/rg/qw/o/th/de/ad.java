package fe.rg.qw.o.th.de;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.File;

public class ad implements ResourceEncoder<BitmapDrawable> {

    /* renamed from: ad  reason: collision with root package name */
    public final ResourceEncoder<Bitmap> f4955ad;
    public final BitmapPool qw;

    public ad(BitmapPool bitmapPool, ResourceEncoder<Bitmap> resourceEncoder) {
        this.qw = bitmapPool;
        this.f4955ad = resourceEncoder;
    }

    @NonNull
    public EncodeStrategy ad(@NonNull fe.rg.qw.o.ad adVar) {
        return this.f4955ad.ad(adVar);
    }

    /* renamed from: de */
    public boolean qw(@NonNull Resource<BitmapDrawable> resource, @NonNull File file, @NonNull fe.rg.qw.o.ad adVar) {
        return this.f4955ad.qw(new fe(resource.get().getBitmap(), this.qw), file, adVar);
    }
}
