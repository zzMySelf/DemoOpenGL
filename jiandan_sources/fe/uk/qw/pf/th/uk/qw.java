package fe.uk.qw.pf.th.uk;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.dlife.ctaccountapi.x;
import com.dxmbumptech.glide.gifdecoder.GifDecoder;
import com.dxmbumptech.glide.load.DecodeFormat;
import com.dxmbumptech.glide.load.ImageHeaderParser;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.dxmbumptech.glide.load.resource.gif.GifDrawable;
import fe.uk.qw.o.de;
import fe.uk.qw.o.fe;
import fe.uk.qw.vvv.o;
import fe.uk.qw.vvv.rg;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class qw implements ResourceDecoder<ByteBuffer, GifDrawable> {

    /* renamed from: th  reason: collision with root package name */
    public static final C0245qw f5996th = new C0245qw();

    /* renamed from: yj  reason: collision with root package name */
    public static final ad f5997yj = new ad();

    /* renamed from: ad  reason: collision with root package name */
    public final List<ImageHeaderParser> f5998ad;

    /* renamed from: de  reason: collision with root package name */
    public final ad f5999de;

    /* renamed from: fe  reason: collision with root package name */
    public final C0245qw f6000fe;
    public final Context qw;

    /* renamed from: rg  reason: collision with root package name */
    public final ad f6001rg;

    @VisibleForTesting
    public static class ad {
        public final Queue<de> qw = o.rg(0);

        public synchronized void ad(de deVar) {
            deVar.qw();
            this.qw.offer(deVar);
        }

        public synchronized de qw(ByteBuffer byteBuffer) {
            de poll;
            poll = this.qw.poll();
            if (poll == null) {
                poll = new de();
            }
            poll.ggg(byteBuffer);
            return poll;
        }
    }

    @VisibleForTesting
    /* renamed from: fe.uk.qw.pf.th.uk.qw$qw  reason: collision with other inner class name */
    public static class C0245qw {
        public GifDecoder qw(GifDecoder.BitmapProvider bitmapProvider, fe.uk.qw.o.ad adVar, ByteBuffer byteBuffer, int i2) {
            return new fe(bitmapProvider, adVar, byteBuffer, i2);
        }
    }

    public qw(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, f5997yj, f5996th);
    }

    public static int rg(fe.uk.qw.o.ad adVar, int i2, int i3) {
        int i4;
        int min = Math.min(adVar.qw() / i3, adVar.fe() / i2);
        if (min == 0) {
            i4 = 0;
        } else {
            i4 = Integer.highestOneBit(min);
        }
        int max = Math.max(1, i4);
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i2 + x.a + i3 + "], actual dimens: [" + adVar.fe() + x.a + adVar.qw() + "]";
        }
        return max;
    }

    @Nullable
    public final fe de(ByteBuffer byteBuffer, int i2, int i3, de deVar, fe.uk.qw.pf.ad adVar) {
        Bitmap.Config config;
        long ad2 = rg.ad();
        try {
            fe.uk.qw.o.ad de2 = deVar.de();
            if (de2.ad() > 0) {
                if (de2.de() == 0) {
                    if (adVar.de(yj.qw) == DecodeFormat.PREFER_RGB_565) {
                        config = Bitmap.Config.RGB_565;
                    } else {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    GifDecoder qw2 = this.f6000fe.qw(this.f6001rg, de2, byteBuffer, rg(de2, i2, i3));
                    qw2.fe(config);
                    qw2.ad();
                    Bitmap qw3 = qw2.qw();
                    if (qw3 == null) {
                        if (Log.isLoggable("BufferGifDecoder", 2)) {
                            "Decoded GIF from stream in " + rg.qw(ad2);
                        }
                        return null;
                    }
                    fe feVar = new fe(new GifDrawable(this.qw, qw2, fe.uk.qw.pf.th.de.de(), i2, i3, qw3));
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        "Decoded GIF from stream in " + rg.qw(ad2);
                    }
                    return feVar;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                "Decoded GIF from stream in " + rg.qw(ad2);
            }
        }
    }

    /* renamed from: fe */
    public fe ad(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull fe.uk.qw.pf.ad adVar) {
        de qw2 = this.f5999de.qw(byteBuffer);
        try {
            return de(byteBuffer, i2, i3, qw2, adVar);
        } finally {
            this.f5999de.ad(qw2);
        }
    }

    /* renamed from: th */
    public boolean qw(@NonNull ByteBuffer byteBuffer, @NonNull fe.uk.qw.pf.ad adVar) throws IOException {
        return !((Boolean) adVar.de(yj.f6005ad)).booleanValue() && fe.uk.qw.pf.qw.th(this.f5998ad, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    @VisibleForTesting
    public qw(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool, ad adVar, C0245qw qwVar) {
        this.qw = context.getApplicationContext();
        this.f5998ad = list;
        this.f6000fe = qwVar;
        this.f6001rg = new ad(bitmapPool, arrayPool);
        this.f5999de = adVar;
    }
}
