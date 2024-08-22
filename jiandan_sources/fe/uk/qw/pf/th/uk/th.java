package fe.uk.qw.pf.th.uk;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.gifdecoder.GifDecoder;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import fe.uk.qw.pf.ad;
import fe.uk.qw.pf.th.fe.rg;

public final class th implements ResourceDecoder<GifDecoder, Bitmap> {
    public final BitmapPool qw;

    public th(BitmapPool bitmapPool) {
        this.qw = bitmapPool;
    }

    /* renamed from: de */
    public Resource<Bitmap> ad(@NonNull GifDecoder gifDecoder, int i2, int i3, @NonNull ad adVar) {
        return rg.fe(gifDecoder.qw(), this.qw);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull GifDecoder gifDecoder, @NonNull ad adVar) {
        return true;
    }
}
