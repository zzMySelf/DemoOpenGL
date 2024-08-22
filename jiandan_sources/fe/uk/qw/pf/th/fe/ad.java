package fe.uk.qw.pf.th.fe;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.EncodeStrategy;
import com.dxmbumptech.glide.load.ResourceEncoder;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.File;

public class ad implements ResourceEncoder<BitmapDrawable> {

    /* renamed from: ad  reason: collision with root package name */
    public final ResourceEncoder<Bitmap> f5950ad;
    public final BitmapPool qw;

    public ad(BitmapPool bitmapPool, ResourceEncoder<Bitmap> resourceEncoder) {
        this.qw = bitmapPool;
        this.f5950ad = resourceEncoder;
    }

    @NonNull
    public EncodeStrategy ad(@NonNull fe.uk.qw.pf.ad adVar) {
        return this.f5950ad.ad(adVar);
    }

    /* renamed from: de */
    public boolean qw(@NonNull Resource<BitmapDrawable> resource, @NonNull File file, @NonNull fe.uk.qw.pf.ad adVar) {
        return this.f5950ad.qw(new rg(resource.get().getBitmap(), this.qw), file, adVar);
    }
}
