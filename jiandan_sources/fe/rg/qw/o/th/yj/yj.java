package fe.rg.qw.o.th.yj;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import fe.rg.qw.o.ad;
import fe.rg.qw.o.th.de.fe;

public final class yj implements ResourceDecoder<GifDecoder, Bitmap> {
    public final BitmapPool qw;

    public yj(BitmapPool bitmapPool) {
        this.qw = bitmapPool;
    }

    /* renamed from: de */
    public Resource<Bitmap> ad(@NonNull GifDecoder gifDecoder, int i2, int i3, @NonNull ad adVar) {
        return fe.fe(gifDecoder.qw(), this.qw);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull GifDecoder gifDecoder, @NonNull ad adVar) {
        return true;
    }
}
