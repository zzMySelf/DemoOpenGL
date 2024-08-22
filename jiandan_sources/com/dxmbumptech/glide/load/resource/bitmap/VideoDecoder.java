package com.dxmbumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.dxmbumptech.glide.load.Option;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {

    /* renamed from: fe  reason: collision with root package name */
    public static final Option<Long> f3904fe = Option.qw("com.dxmbumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new qw());

    /* renamed from: rg  reason: collision with root package name */
    public static final Option<Integer> f3905rg = Option.qw("com.dxmbumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new ad());

    /* renamed from: th  reason: collision with root package name */
    public static final rg f3906th = new rg();

    /* renamed from: ad  reason: collision with root package name */
    public final BitmapPool f3907ad;

    /* renamed from: de  reason: collision with root package name */
    public final rg f3908de;
    public final th<T> qw;

    public static final class VideoDecoderException extends RuntimeException {
        public static final long serialVersionUID = -2556382523004027815L;

        public VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

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

    public static final class de implements th<AssetFileDescriptor> {
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

    @RequiresApi(23)
    public static final class fe implements th<ByteBuffer> {

        public class qw extends MediaDataSource {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ ByteBuffer f3909ad;

            public qw(fe feVar, ByteBuffer byteBuffer) {
                this.f3909ad = byteBuffer;
            }

            public void close() {
            }

            public long getSize() {
                return (long) this.f3909ad.limit();
            }

            public int readAt(long j, byte[] bArr, int i2, int i3) {
                if (j >= ((long) this.f3909ad.limit())) {
                    return -1;
                }
                this.f3909ad.position((int) j);
                int min = Math.min(i3, this.f3909ad.remaining());
                this.f3909ad.get(bArr, i2, min);
                return min;
            }
        }

        /* renamed from: ad */
        public void qw(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new qw(this, byteBuffer));
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
    public static class rg {
        public MediaMetadataRetriever qw() {
            return new MediaMetadataRetriever();
        }
    }

    @VisibleForTesting
    public interface th<T> {
        void qw(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    public static final class yj implements th<ParcelFileDescriptor> {
        /* renamed from: ad */
        public void qw(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    public VideoDecoder(BitmapPool bitmapPool, th<T> thVar) {
        this(bitmapPool, thVar, f3906th);
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> de(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new de((qw) null));
    }

    @RequiresApi(api = 23)
    public static ResourceDecoder<ByteBuffer, Bitmap> fe(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new fe());
    }

    @Nullable
    public static Bitmap rg(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2, int i3, int i4, DownsampleStrategy downsampleStrategy) {
        Bitmap yj2 = (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f3884fe) ? null : yj(mediaMetadataRetriever, j, i2, i3, i4, downsampleStrategy);
        if (yj2 == null) {
            yj2 = th(mediaMetadataRetriever, j, i2);
        }
        if (yj2 != null) {
            return yj2;
        }
        throw new VideoDecoderException();
    }

    public static Bitmap th(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j, i2);
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> uk(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new yj());
    }

    @TargetApi(27)
    @Nullable
    public static Bitmap yj(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2, int i3, int i4, DownsampleStrategy downsampleStrategy) {
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

    /* JADX INFO: finally extract failed */
    public Resource<Bitmap> ad(@NonNull T t, int i2, int i3, @NonNull fe.uk.qw.pf.ad adVar) throws IOException {
        long longValue = ((Long) adVar.de(f3904fe)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) adVar.de(f3905rg);
            if (num == null) {
                num = 2;
            }
            DownsampleStrategy downsampleStrategy = (DownsampleStrategy) adVar.de(DownsampleStrategy.f3886th);
            if (downsampleStrategy == null) {
                downsampleStrategy = DownsampleStrategy.f3885rg;
            }
            DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
            MediaMetadataRetriever qw2 = this.f3908de.qw();
            try {
                this.qw.qw(qw2, t);
                Bitmap rg2 = rg(qw2, longValue, num.intValue(), i2, i3, downsampleStrategy2);
                qw2.release();
                return fe.uk.qw.pf.th.fe.rg.fe(rg2, this.f3907ad);
            } catch (Throwable th2) {
                qw2.release();
                throw th2;
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
    }

    public boolean qw(@NonNull T t, @NonNull fe.uk.qw.pf.ad adVar) {
        return true;
    }

    @VisibleForTesting
    public VideoDecoder(BitmapPool bitmapPool, th<T> thVar, rg rgVar) {
        this.f3907ad = bitmapPool;
        this.qw = thVar;
        this.f3908de = rgVar;
    }
}
