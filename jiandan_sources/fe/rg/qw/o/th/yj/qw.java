package fe.rg.qw.o.th.yj;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.dlife.ctaccountapi.x;
import fe.rg.qw.ggg.i;
import fe.rg.qw.i.de;
import fe.rg.qw.i.fe;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class qw implements ResourceDecoder<ByteBuffer, de> {

    /* renamed from: th  reason: collision with root package name */
    public static final C0214qw f5002th = new C0214qw();

    /* renamed from: yj  reason: collision with root package name */
    public static final ad f5003yj = new ad();

    /* renamed from: ad  reason: collision with root package name */
    public final List<ImageHeaderParser> f5004ad;

    /* renamed from: de  reason: collision with root package name */
    public final ad f5005de;

    /* renamed from: fe  reason: collision with root package name */
    public final C0214qw f5006fe;
    public final Context qw;

    /* renamed from: rg  reason: collision with root package name */
    public final ad f5007rg;

    @VisibleForTesting
    public static class ad {
        public final Queue<de> qw = i.rg(0);

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
    /* renamed from: fe.rg.qw.o.th.yj.qw$qw  reason: collision with other inner class name */
    public static class C0214qw {
        public GifDecoder qw(GifDecoder.BitmapProvider bitmapProvider, fe.rg.qw.i.ad adVar, ByteBuffer byteBuffer, int i2) {
            return new fe(bitmapProvider, adVar, byteBuffer, i2);
        }
    }

    public qw(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, f5003yj, f5002th);
    }

    public static int rg(fe.rg.qw.i.ad adVar, int i2, int i3) {
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
    public final rg de(ByteBuffer byteBuffer, int i2, int i3, de deVar, fe.rg.qw.o.ad adVar) {
        long ad2 = fe.rg.qw.ggg.fe.ad();
        try {
            fe.rg.qw.i.ad de2 = deVar.de();
            if (de2.ad() > 0) {
                if (de2.de() == 0) {
                    Bitmap.Config config = adVar.de(uk.qw) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                    GifDecoder qw2 = this.f5006fe.qw(this.f5007rg, de2, byteBuffer, rg(de2, i2, i3));
                    qw2.fe(config);
                    qw2.ad();
                    Bitmap qw3 = qw2.qw();
                    if (qw3 == null) {
                        if (Log.isLoggable("BufferGifDecoder", 2)) {
                            "Decoded GIF from stream in " + fe.rg.qw.ggg.fe.qw(ad2);
                        }
                        return null;
                    }
                    rg rgVar = new rg(new de(this.qw, qw2, fe.rg.qw.o.th.ad.de(), i2, i3, qw3));
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        "Decoded GIF from stream in " + fe.rg.qw.ggg.fe.qw(ad2);
                    }
                    return rgVar;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                "Decoded GIF from stream in " + fe.rg.qw.ggg.fe.qw(ad2);
            }
        }
    }

    /* renamed from: fe */
    public rg ad(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull fe.rg.qw.o.ad adVar) {
        de qw2 = this.f5005de.qw(byteBuffer);
        try {
            return de(byteBuffer, i2, i3, qw2, adVar);
        } finally {
            this.f5005de.ad(qw2);
        }
    }

    /* renamed from: th */
    public boolean qw(@NonNull ByteBuffer byteBuffer, @NonNull fe.rg.qw.o.ad adVar) throws IOException {
        return !((Boolean) adVar.de(uk.f5009ad)).booleanValue() && fe.rg.qw.o.qw.de(this.f5004ad, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    @VisibleForTesting
    public qw(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool, ad adVar, C0214qw qwVar) {
        this.qw = context.getApplicationContext();
        this.f5004ad = list;
        this.f5006fe = qwVar;
        this.f5007rg = new ad(bitmapPool, arrayPool);
        this.f5005de = adVar;
    }
}
