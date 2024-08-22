package fe.uk.qw.pf.th.i;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.dxmbumptech.glide.load.resource.gif.GifDrawable;
import com.dxmbumptech.glide.load.resource.transcode.ResourceTranscoder;
import fe.uk.qw.pf.ad;
import fe.uk.qw.pf.th.fe.rg;

public final class de implements ResourceTranscoder<Drawable, byte[]> {

    /* renamed from: ad  reason: collision with root package name */
    public final ResourceTranscoder<Bitmap, byte[]> f5982ad;

    /* renamed from: de  reason: collision with root package name */
    public final ResourceTranscoder<GifDrawable, byte[]> f5983de;
    public final BitmapPool qw;

    public de(@NonNull BitmapPool bitmapPool, @NonNull ResourceTranscoder<Bitmap, byte[]> resourceTranscoder, @NonNull ResourceTranscoder<GifDrawable, byte[]> resourceTranscoder2) {
        this.qw = bitmapPool;
        this.f5982ad = resourceTranscoder;
        this.f5983de = resourceTranscoder2;
    }

    @NonNull
    public static Resource<GifDrawable> ad(@NonNull Resource<Drawable> resource) {
        return resource;
    }

    @Nullable
    public Resource<byte[]> qw(@NonNull Resource<Drawable> resource, @NonNull ad adVar) {
        Drawable drawable = resource.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f5982ad.qw(rg.fe(((BitmapDrawable) drawable).getBitmap(), this.qw), adVar);
        }
        if (!(drawable instanceof GifDrawable)) {
            return null;
        }
        ResourceTranscoder<GifDrawable, byte[]> resourceTranscoder = this.f5983de;
        ad(resource);
        return resourceTranscoder.qw(resource, adVar);
    }
}
