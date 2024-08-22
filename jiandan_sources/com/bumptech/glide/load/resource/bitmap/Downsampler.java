package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.dlife.ctaccountapi.x;
import fe.rg.qw.ggg.fe;
import fe.rg.qw.ggg.i;
import fe.rg.qw.ggg.uk;
import fe.rg.qw.o.ad;
import fe.rg.qw.o.th.de.when;
import fe.rg.qw.o.th.de.xxx;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler {

    /* renamed from: i  reason: collision with root package name */
    public static final Set<String> f3716i = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));

    /* renamed from: if  reason: not valid java name */
    public static final Queue<BitmapFactory.Options> f136if = i.rg(0);

    /* renamed from: o  reason: collision with root package name */
    public static final DecodeCallbacks f3717o = new qw();

    /* renamed from: pf  reason: collision with root package name */
    public static final Set<ImageHeaderParser.ImageType> f3718pf = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));

    /* renamed from: th  reason: collision with root package name */
    public static final Option<DecodeFormat> f3719th = Option.th("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);

    /* renamed from: uk  reason: collision with root package name */
    public static final Option<Boolean> f3720uk = Option.th("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", Boolean.FALSE);

    /* renamed from: yj  reason: collision with root package name */
    public static final Option<Boolean> f3721yj = Option.th("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.FALSE);

    /* renamed from: ad  reason: collision with root package name */
    public final DisplayMetrics f3722ad;

    /* renamed from: de  reason: collision with root package name */
    public final ArrayPool f3723de;

    /* renamed from: fe  reason: collision with root package name */
    public final List<ImageHeaderParser> f3724fe;
    public final BitmapPool qw;

    /* renamed from: rg  reason: collision with root package name */
    public final when f3725rg = when.qw();

    public interface DecodeCallbacks {
        void ad(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void qw();
    }

    public class qw implements DecodeCallbacks {
        public void ad(BitmapPool bitmapPool, Bitmap bitmap) {
        }

        public void qw() {
        }
    }

    static {
        Option<DownsampleStrategy> option = DownsampleStrategy.f3715th;
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f3724fe = list;
        uk.fe(displayMetrics);
        this.f3722ad = displayMetrics;
        uk.fe(bitmapPool);
        this.qw = bitmapPool;
        uk.fe(arrayPool);
        this.f3723de = arrayPool;
    }

    public static void ddd(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public static void de(ImageHeaderParser.ImageType imageType, InputStream inputStream, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        float f;
        int i7;
        int i8;
        int i9;
        int i10;
        double d;
        ImageHeaderParser.ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        BitmapFactory.Options options2 = options;
        if (i12 <= 0 || i13 <= 0) {
            String str = x.a;
            if (Log.isLoggable("Downsampler", 3)) {
                "Unable to determine dimensions for: " + imageType2 + " with target [" + i14 + str + i15 + "]";
                return;
            }
            return;
        }
        if (i11 == 90 || i11 == 270) {
            f = downsampleStrategy2.ad(i13, i12, i14, i15);
        } else {
            f = downsampleStrategy2.ad(i12, i13, i14, i15);
        }
        if (f > 0.0f) {
            DownsampleStrategy.SampleSizeRounding qw2 = downsampleStrategy2.qw(i12, i13, i14, i15);
            if (qw2 != null) {
                float f2 = (float) i12;
                int nn = nn((double) (f * f2));
                float f3 = (float) i13;
                String str2 = "Downsampler";
                String str3 = x.a;
                int i16 = i12 / nn;
                int nn2 = i13 / nn((double) (f * f3));
                if (qw2 == DownsampleStrategy.SampleSizeRounding.MEMORY) {
                    i7 = Math.max(i16, nn2);
                } else {
                    i7 = Math.min(i16, nn2);
                }
                if (Build.VERSION.SDK_INT > 23 || !f3716i.contains(options2.outMimeType)) {
                    i8 = Math.max(1, Integer.highestOneBit(i7));
                    if (qw2 == DownsampleStrategy.SampleSizeRounding.MEMORY && ((float) i8) < 1.0f / f) {
                        i8 <<= 1;
                    }
                } else {
                    i8 = 1;
                }
                options2.inSampleSize = i8;
                if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                    float min = (float) Math.min(i8, 8);
                    i9 = (int) Math.ceil((double) (f2 / min));
                    i10 = (int) Math.ceil((double) (f3 / min));
                    int i17 = i8 / 8;
                    if (i17 > 0) {
                        i9 /= i17;
                        i10 /= i17;
                    }
                } else {
                    if (imageType2 == ImageHeaderParser.ImageType.PNG || imageType2 == ImageHeaderParser.ImageType.PNG_A) {
                        float f4 = (float) i8;
                        i9 = (int) Math.floor((double) (f2 / f4));
                        d = Math.floor((double) (f3 / f4));
                    } else if (imageType2 == ImageHeaderParser.ImageType.WEBP || imageType2 == ImageHeaderParser.ImageType.WEBP_A) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            float f5 = (float) i8;
                            i9 = Math.round(f2 / f5);
                            i10 = Math.round(f3 / f5);
                        } else {
                            float f6 = (float) i8;
                            i9 = (int) Math.floor((double) (f2 / f6));
                            d = Math.floor((double) (f3 / f6));
                        }
                    } else if (i12 % i8 == 0 && i13 % i8 == 0) {
                        i9 = i12 / i8;
                        i10 = i13 / i8;
                    } else {
                        int[] pf2 = pf(inputStream, options2, decodeCallbacks, bitmapPool);
                        int i18 = pf2[0];
                        i10 = pf2[1];
                        i9 = i18;
                    }
                    i10 = (int) d;
                }
                double ad2 = (double) downsampleStrategy2.ad(i9, i10, i14, i15);
                if (Build.VERSION.SDK_INT >= 19) {
                    options2.inTargetDensity = qw(ad2);
                    options2.inDensity = o(ad2);
                }
                if (ppp(options)) {
                    options2.inScaled = true;
                } else {
                    options2.inTargetDensity = 0;
                    options2.inDensity = 0;
                }
                if (Log.isLoggable(str2, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Calculate scaling, source: [");
                    sb.append(i12);
                    String str4 = str3;
                    sb.append(str4);
                    sb.append(i13);
                    sb.append("], target: [");
                    sb.append(i14);
                    sb.append(str4);
                    sb.append(i15);
                    sb.append("], power of two scaled: [");
                    sb.append(i9);
                    sb.append(str4);
                    sb.append(i10);
                    sb.append("], exact scale factor: ");
                    sb.append(f);
                    sb.append(", power of 2 sample size: ");
                    sb.append(i8);
                    sb.append(", adjusted scale factor: ");
                    sb.append(ad2);
                    sb.append(", target density: ");
                    sb.append(options2.inTargetDensity);
                    sb.append(", density: ");
                    sb.append(options2.inDensity);
                    sb.toString();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        String str5 = x.a;
        throw new IllegalArgumentException("Cannot scale with factor: " + f + " from: " + downsampleStrategy2 + ", source: [" + i12 + str5 + i13 + "], target: [" + i14 + str5 + i15 + "]");
    }

    public static void ggg(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j) {
        "Decoded " + uk(bitmap) + " from [" + i2 + x.a + i3 + "] " + str + " with inBitmap " + m249if(options) + " for [" + i4 + x.a + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + fe.qw(j);
    }

    public static synchronized BitmapFactory.Options i() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            synchronized (f136if) {
                poll = f136if.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                ddd(poll);
            }
        }
        return poll;
    }

    /* renamed from: if  reason: not valid java name */
    public static String m249if(BitmapFactory.Options options) {
        return uk(options.inBitmap);
    }

    @TargetApi(26)
    public static void mmm(BitmapFactory.Options options, BitmapPool bitmapPool, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            config = options.outConfig;
        } else {
            return;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool.rg(i2, i3, config);
    }

    public static int nn(double d) {
        return (int) (d + 0.5d);
    }

    public static int o(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    public static int[] pf(InputStream inputStream, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        yj(inputStream, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.inDensity;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean ppp(android.graphics.BitmapFactory.Options r1) {
        /*
            int r0 = r1.inTargetDensity
            if (r0 <= 0) goto L_0x000c
            int r1 = r1.inDensity
            if (r1 <= 0) goto L_0x000c
            if (r0 == r1) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.ppp(android.graphics.BitmapFactory$Options):boolean");
    }

    public static int qw(double d) {
        int o2 = o(d);
        int nn = nn(((double) o2) * d);
        return nn((d / ((double) (((float) nn) / ((float) o2)))) * ((double) nn));
    }

    @TargetApi(19)
    @Nullable
    public static String uk(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + x.a + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    public static IOException vvv(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + m249if(options), illegalArgumentException);
    }

    public static void xxx(BitmapFactory.Options options) {
        ddd(options);
        synchronized (f136if) {
            f136if.offer(options);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0056 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap yj(java.io.InputStream r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r7, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r8) throws java.io.IOException {
        /*
            boolean r0 = r6.inJustDecodeBounds
            if (r0 == 0) goto L_0x000a
            r0 = 10485760(0xa00000, float:1.469368E-38)
            r5.mark(r0)
            goto L_0x000d
        L_0x000a:
            r7.qw()
        L_0x000d:
            int r0 = r6.outWidth
            int r1 = r6.outHeight
            java.lang.String r2 = r6.outMimeType
            java.util.concurrent.locks.Lock r3 = fe.rg.qw.o.th.de.xxx.th()
            r3.lock()
            r3 = 0
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeStream(r5, r3, r6)     // Catch:{ IllegalArgumentException -> 0x0030 }
            java.util.concurrent.locks.Lock r8 = fe.rg.qw.o.th.de.xxx.th()
            r8.unlock()
            boolean r6 = r6.inJustDecodeBounds
            if (r6 == 0) goto L_0x002d
            r5.reset()
        L_0x002d:
            return r7
        L_0x002e:
            r5 = move-exception
            goto L_0x0058
        L_0x0030:
            r4 = move-exception
            java.io.IOException r0 = vvv(r4, r0, r1, r2, r6)     // Catch:{ all -> 0x002e }
            java.lang.String r1 = "Downsampler"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch:{ all -> 0x002e }
            android.graphics.Bitmap r1 = r6.inBitmap     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0057
            r5.reset()     // Catch:{ IOException -> 0x0056 }
            android.graphics.Bitmap r1 = r6.inBitmap     // Catch:{ IOException -> 0x0056 }
            r8.de(r1)     // Catch:{ IOException -> 0x0056 }
            r6.inBitmap = r3     // Catch:{ IOException -> 0x0056 }
            android.graphics.Bitmap r5 = yj(r5, r6, r7, r8)     // Catch:{ IOException -> 0x0056 }
            java.util.concurrent.locks.Lock r6 = fe.rg.qw.o.th.de.xxx.th()
            r6.unlock()
            return r5
        L_0x0056:
            throw r0     // Catch:{ all -> 0x002e }
        L_0x0057:
            throw r0     // Catch:{ all -> 0x002e }
        L_0x0058:
            java.util.concurrent.locks.Lock r6 = fe.rg.qw.o.th.de.xxx.th()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.yj(java.io.InputStream, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    public final boolean aaa(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return f3718pf.contains(imageType);
    }

    public final void ad(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        if (!this.f3725rg.de(i2, i3, options, decodeFormat, z, z2)) {
            if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return;
            }
            boolean z3 = false;
            try {
                z3 = fe.rg.qw.o.qw.ad(this.f3724fe, inputStream, this.f3723de).hasAlpha();
            } catch (IOException unused) {
                if (Log.isLoggable("Downsampler", 3)) {
                    "Cannot determine whether the image has alpha or not from header, format " + decodeFormat;
                }
            }
            Bitmap.Config config = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565) {
                options.inDither = true;
            }
        }
    }

    public Resource<Bitmap> fe(InputStream inputStream, int i2, int i3, ad adVar) throws IOException {
        return rg(inputStream, i2, i3, adVar, f3717o);
    }

    public Resource<Bitmap> rg(InputStream inputStream, int i2, int i3, ad adVar, DecodeCallbacks decodeCallbacks) throws IOException {
        ad adVar2 = adVar;
        uk.qw(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.f3723de.de(65536, byte[].class);
        BitmapFactory.Options i4 = i();
        i4.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) adVar2.de(f3719th);
        try {
            return fe.rg.qw.o.th.de.fe.fe(th(inputStream, i4, (DownsampleStrategy) adVar2.de(DownsampleStrategy.f3715th), decodeFormat, adVar2.de(f3720uk) != null && ((Boolean) adVar2.de(f3720uk)).booleanValue(), i2, i3, ((Boolean) adVar2.de(f3721yj)).booleanValue(), decodeCallbacks), this.qw);
        } finally {
            xxx(i4);
            this.f3723de.put(bArr);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public boolean m250switch(InputStream inputStream) {
        return true;
    }

    public final Bitmap th(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i2, int i3, boolean z2, DecodeCallbacks decodeCallbacks) throws IOException {
        Downsampler downsampler;
        int i4;
        int i5;
        int i6;
        InputStream inputStream2 = inputStream;
        BitmapFactory.Options options2 = options;
        DecodeCallbacks decodeCallbacks2 = decodeCallbacks;
        long ad2 = fe.ad();
        int[] pf2 = pf(inputStream2, options2, decodeCallbacks2, this.qw);
        boolean z3 = false;
        int i7 = pf2[0];
        int i8 = pf2[1];
        String str = options2.outMimeType;
        boolean z4 = (i7 == -1 || i8 == -1) ? false : z;
        int qw2 = fe.rg.qw.o.qw.qw(this.f3724fe, inputStream2, this.f3723de);
        int yj2 = xxx.yj(qw2);
        boolean o2 = xxx.o(qw2);
        int i9 = i2;
        int i10 = i3;
        int i11 = i9 == Integer.MIN_VALUE ? i7 : i9;
        int i12 = i10 == Integer.MIN_VALUE ? i8 : i10;
        ImageHeaderParser.ImageType ad3 = fe.rg.qw.o.qw.ad(this.f3724fe, inputStream2, this.f3723de);
        BitmapPool bitmapPool = this.qw;
        ImageHeaderParser.ImageType imageType = ad3;
        de(ad3, inputStream, decodeCallbacks, bitmapPool, downsampleStrategy, yj2, i7, i8, i11, i12, options);
        int i13 = qw2;
        String str2 = str;
        int i14 = i8;
        int i15 = i7;
        DecodeCallbacks decodeCallbacks3 = decodeCallbacks2;
        BitmapFactory.Options options3 = options2;
        ad(inputStream, decodeFormat, z4, o2, options, i11, i12);
        if (Build.VERSION.SDK_INT >= 19) {
            z3 = true;
        }
        if (options3.inSampleSize == 1 || z3) {
            downsampler = this;
            if (downsampler.aaa(imageType)) {
                if (i15 < 0 || i14 < 0 || !z2 || !z3) {
                    float f = ppp(options) ? ((float) options3.inTargetDensity) / ((float) options3.inDensity) : 1.0f;
                    int i16 = options3.inSampleSize;
                    float f2 = (float) i16;
                    i6 = Math.round(((float) ((int) Math.ceil((double) (((float) i15) / f2)))) * f);
                    i5 = Math.round(((float) ((int) Math.ceil((double) (((float) i14) / f2)))) * f);
                    if (Log.isLoggable("Downsampler", 2)) {
                        "Calculated target [" + i6 + x.a + i5 + "] for source [" + i15 + x.a + i14 + "], sampleSize: " + i16 + ", targetDensity: " + options3.inTargetDensity + ", density: " + options3.inDensity + ", density multiplier: " + f;
                    }
                } else {
                    i6 = i11;
                    i5 = i12;
                }
                if (i6 > 0 && i5 > 0) {
                    mmm(options3, downsampler.qw, i6, i5);
                }
            }
        } else {
            downsampler = this;
        }
        Bitmap yj3 = yj(inputStream, options3, decodeCallbacks3, downsampler.qw);
        decodeCallbacks3.ad(downsampler.qw, yj3);
        if (Log.isLoggable("Downsampler", 2)) {
            i4 = i13;
            ggg(i15, i14, str2, options, yj3, i2, i3, ad2);
        } else {
            i4 = i13;
        }
        Bitmap bitmap = null;
        if (yj3 != null) {
            yj3.setDensity(downsampler.f3722ad.densityDpi);
            bitmap = xxx.pf(downsampler.qw, yj3, i4);
            if (!yj3.equals(bitmap)) {
                downsampler.qw.de(yj3);
            }
        }
        return bitmap;
    }

    public boolean when(ByteBuffer byteBuffer) {
        return true;
    }
}
