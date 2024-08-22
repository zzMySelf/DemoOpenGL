package fe.rg.qw.o.th.de;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class nn<T> implements ResourceDecoder<T, Bitmap> {

    /* renamed from: fe  reason: collision with root package name */
    public static final Option<Long> f4963fe = Option.qw("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new qw());

    /* renamed from: rg  reason: collision with root package name */
    public static final Option<Integer> f4964rg = Option.qw("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new ad());

    /* renamed from: th  reason: collision with root package name */
    public static final fe f4965th = new fe();

    /* renamed from: ad  reason: collision with root package name */
    public final BitmapPool f4966ad;

    /* renamed from: de  reason: collision with root package name */
    public final fe f4967de;
    public final rg<T> qw;

    public class ad implements Option.CacheKeyUpdater<Integer> {
        public final ByteBuffer qw = ByteBuffer.allocate(4);

        /* renamed from: ad */
        public void qw(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.qw) {
                    this.qw.position(0);
                    messageDigest.update(this.qw.putInt(num.intValue()).array());
                }
            }
        }
    }

    public static final class de implements rg<AssetFileDescriptor> {
        public de() {
        }

        /* renamed from: ad */
        public void qw(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        public /* synthetic */ de(qw qwVar) {
            this();
        }
    }

    @VisibleForTesting
    public static class fe {
        public MediaMetadataRetriever qw() {
            return new MediaMetadataRetriever();
        }
    }

    public class qw implements Option.CacheKeyUpdater<Long> {
        public final ByteBuffer qw = ByteBuffer.allocate(8);

        /* renamed from: ad */
        public void qw(@NonNull byte[] bArr, @NonNull Long l, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.qw) {
                this.qw.position(0);
                messageDigest.update(this.qw.putLong(l.longValue()).array());
            }
        }
    }

    @VisibleForTesting
    public interface rg<T> {
        void qw(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    public static final class th implements rg<ParcelFileDescriptor> {
        /* renamed from: ad */
        public void qw(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    public nn(BitmapPool bitmapPool, rg<T> rgVar) {
        this(bitmapPool, rgVar, f4965th);
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> de(BitmapPool bitmapPool) {
        return new nn(bitmapPool, new de((qw) null));
    }

    @Nullable
    public static Bitmap fe(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2, int i3, int i4, DownsampleStrategy downsampleStrategy) {
        Bitmap th2 = (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f3713fe) ? null : th(mediaMetadataRetriever, j, i2, i3, i4, downsampleStrategy);
        return th2 == null ? rg(mediaMetadataRetriever, j, i2) : th2;
    }

    public static Bitmap rg(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j, i2);
    }

    @TargetApi(27)
    public static Bitmap th(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2, int i3, int i4, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                int i5 = parseInt2;
                parseInt2 = parseInt;
                parseInt = i5;
            }
            float ad2 = downsampleStrategy.ad(parseInt, parseInt2, i3, i4);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i2, Math.round(((float) parseInt) * ad2), Math.round(ad2 * ((float) parseInt2)));
        } catch (Throwable unused) {
            boolean isLoggable = Log.isLoggable("VideoDecoder", 3);
            return null;
        }
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> yj(BitmapPool bitmapPool) {
        return new nn(bitmapPool, new th());
    }

    public Resource<Bitmap> ad(@NonNull T t, int i2, int i3, @NonNull fe.rg.qw.o.ad adVar) throws IOException {
        long longValue = ((Long) adVar.de(f4963fe)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) adVar.de(f4964rg);
            if (num == null) {
                num = 2;
            }
            DownsampleStrategy downsampleStrategy = (DownsampleStrategy) adVar.de(DownsampleStrategy.f3715th);
            if (downsampleStrategy == null) {
                downsampleStrategy = DownsampleStrategy.f3714rg;
            }
            DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
            MediaMetadataRetriever qw2 = this.f4967de.qw();
            try {
                this.qw.qw(qw2, t);
                Bitmap fe2 = fe(qw2, longValue, num.intValue(), i2, i3, downsampleStrategy2);
                qw2.release();
                return fe.fe(fe2, this.f4966ad);
            } catch (RuntimeException e) {
                throw new IOException(e);
            } catch (Throwable th2) {
                qw2.release();
                throw th2;
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
    }

    public boolean qw(@NonNull T t, @NonNull fe.rg.qw.o.ad adVar) {
        return true;
    }

    @VisibleForTesting
    public nn(BitmapPool bitmapPool, rg<T> rgVar, fe feVar) {
        this.f4966ad = bitmapPool;
        this.qw = rgVar;
        this.f4967de = feVar;
    }
}
