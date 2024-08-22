package com.dxmbumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.dlife.ctaccountapi.x;
import com.dxmbumptech.glide.load.DecodeFormat;
import com.dxmbumptech.glide.load.ImageHeaderParser;
import com.dxmbumptech.glide.load.Option;
import com.dxmbumptech.glide.load.PreferredColorSpace;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.dxmbumptech.glide.load.resource.bitmap.DownsampleStrategy;
import fe.uk.qw.pf.ad;
import fe.uk.qw.pf.de.pf;
import fe.uk.qw.pf.th.fe.aaa;
import fe.uk.qw.pf.th.fe.ggg;
import fe.uk.qw.pf.th.fe.ppp;
import fe.uk.qw.vvv.i;
import fe.uk.qw.vvv.o;
import fe.uk.qw.vvv.rg;
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
    public static final Option<Boolean> f3888i = Option.th("com.dxmbumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", Boolean.FALSE);

    /* renamed from: if  reason: not valid java name */
    public static final Set<ImageHeaderParser.ImageType> f147if = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));

    /* renamed from: o  reason: collision with root package name */
    public static final Set<String> f3889o = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));

    /* renamed from: pf  reason: collision with root package name */
    public static final DecodeCallbacks f3890pf = new qw();

    /* renamed from: switch  reason: not valid java name */
    public static final Queue<BitmapFactory.Options> f148switch = o.rg(0);

    /* renamed from: th  reason: collision with root package name */
    public static final Option<DecodeFormat> f3891th = Option.th("com.dxmbumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);

    /* renamed from: uk  reason: collision with root package name */
    public static final Option<Boolean> f3892uk = Option.th("com.dxmbumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.FALSE);

    /* renamed from: yj  reason: collision with root package name */
    public static final Option<PreferredColorSpace> f3893yj = Option.th("com.dxmbumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);

    /* renamed from: ad  reason: collision with root package name */
    public final DisplayMetrics f3894ad;

    /* renamed from: de  reason: collision with root package name */
    public final ArrayPool f3895de;

    /* renamed from: fe  reason: collision with root package name */
    public final List<ImageHeaderParser> f3896fe;
    public final BitmapPool qw;

    /* renamed from: rg  reason: collision with root package name */
    public final ppp f3897rg = ppp.ad();

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
        Option<DownsampleStrategy> option = DownsampleStrategy.f3886th;
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f3896fe = list;
        i.fe(displayMetrics);
        this.f3894ad = displayMetrics;
        i.fe(bitmapPool);
        this.qw = bitmapPool;
        i.fe(arrayPool);
        this.f3895de = arrayPool;
    }

    public static void aaa(BitmapFactory.Options options) {
        qqq(options);
        synchronized (f148switch) {
            f148switch.offer(options);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.inDensity;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean ddd(android.graphics.BitmapFactory.Options r1) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.dxmbumptech.glide.load.resource.bitmap.Downsampler.ddd(android.graphics.BitmapFactory$Options):boolean");
    }

    public static void de(ImageHeaderParser.ImageType imageType, ggg ggg, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        double d;
        ImageHeaderParser.ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int i13 = i3;
        int i14 = i4;
        int i15 = i5;
        int i16 = i6;
        BitmapFactory.Options options2 = options;
        if (i13 > 0 && i14 > 0) {
            if (xxx(i2)) {
                i7 = i13;
                i8 = i14;
            } else {
                i8 = i13;
                i7 = i14;
            }
            float ad2 = downsampleStrategy2.ad(i8, i7, i15, i16);
            if (ad2 > 0.0f) {
                DownsampleStrategy.SampleSizeRounding qw2 = downsampleStrategy2.qw(i8, i7, i15, i16);
                if (qw2 != null) {
                    float f = (float) i8;
                    float f2 = (float) i7;
                    int eee = i8 / eee((double) (ad2 * f));
                    int eee2 = i7 / eee((double) (ad2 * f2));
                    if (qw2 == DownsampleStrategy.SampleSizeRounding.MEMORY) {
                        i9 = Math.max(eee, eee2);
                    } else {
                        i9 = Math.min(eee, eee2);
                    }
                    int i17 = Build.VERSION.SDK_INT;
                    String str = x.a;
                    if (i17 > 23 || !f3889o.contains(options2.outMimeType)) {
                        i10 = Math.max(1, Integer.highestOneBit(i9));
                        if (qw2 == DownsampleStrategy.SampleSizeRounding.MEMORY && ((float) i10) < 1.0f / ad2) {
                            i10 <<= 1;
                        }
                    } else {
                        i10 = 1;
                    }
                    options2.inSampleSize = i10;
                    if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                        float min = (float) Math.min(i10, 8);
                        i11 = (int) Math.ceil((double) (f / min));
                        i12 = (int) Math.ceil((double) (f2 / min));
                        int i18 = i10 / 8;
                        if (i18 > 0) {
                            i11 /= i18;
                            i12 /= i18;
                        }
                    } else {
                        if (imageType2 == ImageHeaderParser.ImageType.PNG || imageType2 == ImageHeaderParser.ImageType.PNG_A) {
                            float f3 = (float) i10;
                            i11 = (int) Math.floor((double) (f / f3));
                            d = Math.floor((double) (f2 / f3));
                        } else if (imageType2 == ImageHeaderParser.ImageType.WEBP || imageType2 == ImageHeaderParser.ImageType.WEBP_A) {
                            if (Build.VERSION.SDK_INT >= 24) {
                                float f4 = (float) i10;
                                i11 = Math.round(f / f4);
                                i12 = Math.round(f2 / f4);
                            } else {
                                float f5 = (float) i10;
                                i11 = (int) Math.floor((double) (f / f5));
                                d = Math.floor((double) (f2 / f5));
                            }
                        } else if (i8 % i10 == 0 && i7 % i10 == 0) {
                            i11 = i8 / i10;
                            i12 = i7 / i10;
                        } else {
                            int[] iArr = m264switch(ggg, options2, decodeCallbacks, bitmapPool);
                            i11 = iArr[0];
                            i12 = iArr[1];
                        }
                        i12 = (int) d;
                    }
                    double ad3 = (double) downsampleStrategy2.ad(i11, i12, i15, i16);
                    if (Build.VERSION.SDK_INT >= 19) {
                        options2.inTargetDensity = qw(ad3);
                        options2.inDensity = m263if(ad3);
                    }
                    if (ddd(options)) {
                        options2.inScaled = true;
                    } else {
                        options2.inTargetDensity = 0;
                        options2.inDensity = 0;
                    }
                    if (Log.isLoggable("Downsampler", 2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Calculate scaling, source: [");
                        sb.append(i3);
                        String str2 = str;
                        sb.append(str2);
                        sb.append(i4);
                        sb.append("], degreesToRotate: ");
                        sb.append(i2);
                        sb.append(", target: [");
                        sb.append(i15);
                        sb.append(str2);
                        sb.append(i16);
                        sb.append("], power of two scaled: [");
                        sb.append(i11);
                        sb.append(str2);
                        sb.append(i12);
                        sb.append("], exact scale factor: ");
                        sb.append(ad2);
                        sb.append(", power of 2 sample size: ");
                        sb.append(i10);
                        sb.append(", adjusted scale factor: ");
                        sb.append(ad3);
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
            throw new IllegalArgumentException("Cannot scale with factor: " + ad2 + " from: " + downsampleStrategy2 + ", source: [" + i13 + x.a + i14 + "], target: [" + i15 + x.a + i16 + "]");
        } else if (Log.isLoggable("Downsampler", 3)) {
            "Unable to determine dimensions for: " + imageType2 + " with target [" + i15 + x.a + i16 + "]";
        }
    }

    public static int eee(double d) {
        return (int) (d + 0.5d);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap i(fe.uk.qw.pf.th.fe.ggg r4, android.graphics.BitmapFactory.Options r5, com.dxmbumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r6, com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool r7) throws java.io.IOException {
        /*
            boolean r0 = r5.inJustDecodeBounds
            if (r0 != 0) goto L_0x000a
            r6.qw()
            r4.ad()
        L_0x000a:
            int r0 = r5.outWidth
            int r1 = r5.outHeight
            java.lang.String r2 = r5.outMimeType
            java.util.concurrent.locks.Lock r3 = fe.uk.qw.pf.th.fe.aaa.th()
            r3.lock()
            android.graphics.Bitmap r4 = r4.qw(r5)     // Catch:{ IllegalArgumentException -> 0x0025 }
            java.util.concurrent.locks.Lock r5 = fe.uk.qw.pf.th.fe.aaa.th()
            r5.unlock()
            return r4
        L_0x0023:
            r4 = move-exception
            goto L_0x004b
        L_0x0025:
            r3 = move-exception
            java.io.IOException r0 = mmm(r3, r0, r1, r2, r5)     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = "Downsampler"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch:{ all -> 0x0023 }
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x004a
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch:{ IOException -> 0x0049 }
            r7.de(r1)     // Catch:{ IOException -> 0x0049 }
            r1 = 0
            r5.inBitmap = r1     // Catch:{ IOException -> 0x0049 }
            android.graphics.Bitmap r4 = i(r4, r5, r6, r7)     // Catch:{ IOException -> 0x0049 }
            java.util.concurrent.locks.Lock r5 = fe.uk.qw.pf.th.fe.aaa.th()
            r5.unlock()
            return r4
        L_0x0049:
            throw r0     // Catch:{ all -> 0x0023 }
        L_0x004a:
            throw r0     // Catch:{ all -> 0x0023 }
        L_0x004b:
            java.util.concurrent.locks.Lock r5 = fe.uk.qw.pf.th.fe.aaa.th()
            r5.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmbumptech.glide.load.resource.bitmap.Downsampler.i(fe.uk.qw.pf.th.fe.ggg, android.graphics.BitmapFactory$Options, com.dxmbumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    /* renamed from: if  reason: not valid java name */
    public static int m263if(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    public static IOException mmm(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + when(options), illegalArgumentException);
    }

    public static void nn(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j) {
        "Decoded " + o(bitmap) + " from [" + i2 + x.a + i3 + "] " + str + " with inBitmap " + when(options) + " for [" + i4 + x.a + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + rg.qw(j);
    }

    @TargetApi(19)
    @Nullable
    public static String o(Bitmap bitmap) {
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

    public static synchronized BitmapFactory.Options pf() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            synchronized (f148switch) {
                poll = f148switch.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                qqq(poll);
            }
        }
        return poll;
    }

    public static void qqq(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public static int qw(double d) {
        int i2 = m263if(d);
        int eee = eee(((double) i2) * d);
        return eee((d / ((double) (((float) eee) / ((float) i2)))) * ((double) eee));
    }

    @TargetApi(26)
    public static void rrr(BitmapFactory.Options options, BitmapPool bitmapPool, int i2, int i3) {
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

    /* renamed from: switch  reason: not valid java name */
    public static int[] m264switch(ggg ggg, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        i(ggg, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public static String when(BitmapFactory.Options options) {
        return o(options.inBitmap);
    }

    public static boolean xxx(int i2) {
        return i2 == 90 || i2 == 270;
    }

    public final void ad(ggg ggg, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        if (!this.f3897rg.i(i2, i3, options, z, z2)) {
            if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return;
            }
            boolean z3 = false;
            try {
                z3 = ggg.fe().hasAlpha();
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

    @RequiresApi(21)
    public Resource<Bitmap> fe(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, ad adVar) throws IOException {
        return rg(new ggg.ad(parcelFileDescriptor, this.f3896fe, this.f3895de), i2, i3, adVar, f3890pf);
    }

    public boolean ggg(InputStream inputStream) {
        return true;
    }

    public boolean ppp(ParcelFileDescriptor parcelFileDescriptor) {
        return pf.de();
    }

    public final Resource<Bitmap> rg(ggg ggg, int i2, int i3, ad adVar, DecodeCallbacks decodeCallbacks) throws IOException {
        ad adVar2 = adVar;
        byte[] bArr = (byte[]) this.f3895de.de(65536, byte[].class);
        BitmapFactory.Options pf2 = pf();
        pf2.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) adVar2.de(f3891th);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) adVar2.de(f3893yj);
        try {
            return fe.uk.qw.pf.th.fe.rg.fe(uk(ggg, pf2, (DownsampleStrategy) adVar2.de(DownsampleStrategy.f3886th), decodeFormat, preferredColorSpace, adVar2.de(f3888i) != null && ((Boolean) adVar2.de(f3888i)).booleanValue(), i2, i3, ((Boolean) adVar2.de(f3892uk)).booleanValue(), decodeCallbacks), this.qw);
        } finally {
            aaa(pf2);
            this.f3895de.put(bArr);
        }
    }

    public Resource<Bitmap> th(InputStream inputStream, int i2, int i3, ad adVar) throws IOException {
        return yj(inputStream, i2, i3, adVar, f3890pf);
    }

    public final boolean tt(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return f147if.contains(imageType);
    }

    public final Bitmap uk(ggg ggg, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z, int i2, int i3, boolean z2, DecodeCallbacks decodeCallbacks) throws IOException {
        int i4;
        int i5;
        Downsampler downsampler;
        int i6;
        ColorSpace colorSpace;
        int i7;
        int i8;
        BitmapFactory.Options options2 = options;
        DecodeCallbacks decodeCallbacks2 = decodeCallbacks;
        long ad2 = rg.ad();
        int[] iArr = m264switch(ggg, options2, decodeCallbacks2, this.qw);
        boolean z3 = false;
        int i9 = iArr[0];
        int i10 = iArr[1];
        String str = options2.outMimeType;
        boolean z4 = (i9 == -1 || i10 == -1) ? false : z;
        int de2 = ggg.de();
        int yj2 = aaa.yj(de2);
        boolean o2 = aaa.o(de2);
        int i11 = i2;
        if (i11 == Integer.MIN_VALUE) {
            i5 = i3;
            i4 = xxx(yj2) ? i10 : i9;
        } else {
            i5 = i3;
            i4 = i11;
        }
        int i12 = i5 == Integer.MIN_VALUE ? xxx(yj2) ? i9 : i10 : i5;
        ImageHeaderParser.ImageType fe2 = ggg.fe();
        BitmapPool bitmapPool = this.qw;
        ImageHeaderParser.ImageType imageType = fe2;
        de(fe2, ggg, decodeCallbacks, bitmapPool, downsampleStrategy, yj2, i9, i10, i4, i12, options);
        int i13 = de2;
        String str2 = str;
        int i14 = i10;
        int i15 = i9;
        DecodeCallbacks decodeCallbacks3 = decodeCallbacks2;
        BitmapFactory.Options options3 = options2;
        ad(ggg, decodeFormat, z4, o2, options, i4, i12);
        boolean z5 = Build.VERSION.SDK_INT >= 19;
        if (options3.inSampleSize == 1 || z5) {
            downsampler = this;
            if (downsampler.tt(imageType)) {
                if (i15 < 0 || i14 < 0 || !z2 || !z5) {
                    float f = ddd(options) ? ((float) options3.inTargetDensity) / ((float) options3.inDensity) : 1.0f;
                    int i16 = options3.inSampleSize;
                    float f2 = (float) i16;
                    i8 = Math.round(((float) ((int) Math.ceil((double) (((float) i15) / f2)))) * f);
                    i7 = Math.round(((float) ((int) Math.ceil((double) (((float) i14) / f2)))) * f);
                    if (Log.isLoggable("Downsampler", 2)) {
                        "Calculated target [" + i8 + x.a + i7 + "] for source [" + i15 + x.a + i14 + "], sampleSize: " + i16 + ", targetDensity: " + options3.inTargetDensity + ", density: " + options3.inDensity + ", density multiplier: " + f;
                    }
                } else {
                    i8 = i4;
                    i7 = i12;
                }
                if (i8 > 0 && i7 > 0) {
                    rrr(options3, downsampler.qw, i8, i7);
                }
            }
        } else {
            downsampler = this;
        }
        int i17 = Build.VERSION.SDK_INT;
        if (i17 >= 28) {
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && (colorSpace = options3.outColorSpace) != null && colorSpace.isWideGamut()) {
                z3 = true;
            }
            options3.inPreferredColorSpace = ColorSpace.get(z3 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        } else if (i17 >= 26) {
            options3.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap i18 = i(ggg, options3, decodeCallbacks3, downsampler.qw);
        decodeCallbacks3.ad(downsampler.qw, i18);
        if (Log.isLoggable("Downsampler", 2)) {
            i6 = i13;
            nn(i15, i14, str2, options, i18, i2, i3, ad2);
        } else {
            i6 = i13;
        }
        Bitmap bitmap = null;
        if (i18 != null) {
            i18.setDensity(downsampler.f3894ad.densityDpi);
            bitmap = aaa.pf(downsampler.qw, i18, i6);
            if (!i18.equals(bitmap)) {
                downsampler.qw.de(i18);
            }
        }
        return bitmap;
    }

    public boolean vvv(ByteBuffer byteBuffer) {
        return true;
    }

    public Resource<Bitmap> yj(InputStream inputStream, int i2, int i3, ad adVar, DecodeCallbacks decodeCallbacks) throws IOException {
        return rg(new ggg.qw(inputStream, this.f3896fe, this.f3895de), i2, i3, adVar, decodeCallbacks);
    }
}
