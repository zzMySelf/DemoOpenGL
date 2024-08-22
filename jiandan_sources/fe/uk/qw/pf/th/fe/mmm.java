package fe.uk.qw.pf.th.fe;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.dxmbumptech.glide.load.resource.bitmap.Downsampler;
import com.dxmbumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import fe.uk.qw.pf.ad;
import fe.uk.qw.vvv.de;
import fe.uk.qw.vvv.yj;
import java.io.IOException;
import java.io.InputStream;

public class mmm implements ResourceDecoder<InputStream, Bitmap> {

    /* renamed from: ad  reason: collision with root package name */
    public final ArrayPool f5961ad;
    public final Downsampler qw;

    public static class qw implements Downsampler.DecodeCallbacks {

        /* renamed from: ad  reason: collision with root package name */
        public final de f5962ad;
        public final RecyclableBufferedInputStream qw;

        public qw(RecyclableBufferedInputStream recyclableBufferedInputStream, de deVar) {
            this.qw = recyclableBufferedInputStream;
            this.f5962ad = deVar;
        }

        public void ad(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
            IOException qw2 = this.f5962ad.qw();
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

    public mmm(Downsampler downsampler, ArrayPool arrayPool) {
        this.qw = downsampler;
        this.f5961ad = arrayPool;
    }

    /* renamed from: de */
    public Resource<Bitmap> ad(@NonNull InputStream inputStream, int i2, int i3, @NonNull ad adVar) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f5961ad);
            z = true;
        }
        de de2 = de.de(recyclableBufferedInputStream);
        try {
            return this.qw.yj(new yj(de2), i2, i3, adVar, new qw(recyclableBufferedInputStream, de2));
        } finally {
            de2.release();
            if (z) {
                recyclableBufferedInputStream.release();
            }
        }
    }

    /* renamed from: fe */
    public boolean qw(@NonNull InputStream inputStream, @NonNull ad adVar) {
        return this.qw.ggg(inputStream);
    }
}
