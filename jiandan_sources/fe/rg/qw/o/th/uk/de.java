package fe.rg.qw.o.th.uk;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import fe.rg.qw.o.ad;
import fe.rg.qw.o.th.de.fe;

public final class de implements ResourceTranscoder<Drawable, byte[]> {

    /* renamed from: ad  reason: collision with root package name */
    public final ResourceTranscoder<Bitmap, byte[]> f4987ad;

    /* renamed from: de  reason: collision with root package name */
    public final ResourceTranscoder<fe.rg.qw.o.th.yj.de, byte[]> f4988de;
    public final BitmapPool qw;

    public de(@NonNull BitmapPool bitmapPool, @NonNull ResourceTranscoder<Bitmap, byte[]> resourceTranscoder, @NonNull ResourceTranscoder<fe.rg.qw.o.th.yj.de, byte[]> resourceTranscoder2) {
        this.qw = bitmapPool;
        this.f4987ad = resourceTranscoder;
        this.f4988de = resourceTranscoder2;
    }

    @NonNull
    public static Resource<fe.rg.qw.o.th.yj.de> ad(@NonNull Resource<Drawable> resource) {
        return resource;
    }

    @Nullable
    public Resource<byte[]> qw(@NonNull Resource<Drawable> resource, @NonNull ad adVar) {
        Drawable drawable = resource.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f4987ad.qw(fe.fe(((BitmapDrawable) drawable).getBitmap(), this.qw), adVar);
        }
        if (!(drawable instanceof fe.rg.qw.o.th.yj.de)) {
            return null;
        }
        ResourceTranscoder<fe.rg.qw.o.th.yj.de, byte[]> resourceTranscoder = this.f4988de;
        ad(resource);
        return resourceTranscoder.qw(resource, adVar);
    }
}
