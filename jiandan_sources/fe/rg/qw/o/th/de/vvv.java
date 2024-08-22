package fe.rg.qw.o.th.de;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import fe.rg.qw.ggg.de;
import fe.rg.qw.ggg.th;
import fe.rg.qw.o.ad;
import java.io.IOException;
import java.io.InputStream;

public class vvv implements ResourceDecoder<InputStream, Bitmap> {

    /* renamed from: ad  reason: collision with root package name */
    public final ArrayPool f4975ad;
    public final Downsampler qw;

    public static class qw implements Downsampler.DecodeCallbacks {

        /* renamed from: ad  reason: collision with root package name */
        public final de f4976ad;
        public final RecyclableBufferedInputStream qw;

        public qw(RecyclableBufferedInputStream recyclableBufferedInputStream, de deVar) {
            this.qw = recyclableBufferedInputStream;
            this.f4976ad = deVar;
        }

        public void ad(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
            IOException qw2 = this.f4976ad.qw();
            if (qw2 != null) {
                if (bitmap != null) {
                    bitmapPool.de(bitmap);
                }
                throw qw2;
            }
        }

        public void qw() {
            this.qw.de();
        }
    }

    public vvv(Downsampler downsampler, ArrayPool arrayPool) {
        this.qw = downsampler;
        this.f4975ad = arrayPool;
    }

    /* renamed from: de */
    public Resource<Bitmap> ad(@NonNull InputStream inputStream, int i2, int i3, @NonNull ad adVar) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f4975ad);
            z = true;
        }
        de de2 = de.de(recyclableBufferedInputStream);
        try {
            return this.qw.rg(new th(de2), i2, i3, adVar, new qw(recyclableBufferedInputStream, de2));
        } finally {
            de2.release();
            if (z) {
                recyclableBufferedInputStream.release();
            }
        }
    }

    /* renamed from: fe */
    public boolean qw(@NonNull InputStream inputStream, @NonNull ad adVar) {
        return this.qw.m250switch(inputStream);
    }
}
