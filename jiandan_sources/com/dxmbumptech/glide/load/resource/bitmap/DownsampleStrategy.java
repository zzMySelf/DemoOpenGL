package com.dxmbumptech.glide.load.resource.bitmap;

import android.os.Build;
import com.dxmbumptech.glide.load.Option;

public abstract class DownsampleStrategy {

    /* renamed from: ad  reason: collision with root package name */
    public static final DownsampleStrategy f3882ad = new qw();

    /* renamed from: de  reason: collision with root package name */
    public static final DownsampleStrategy f3883de = new ad();

    /* renamed from: fe  reason: collision with root package name */
    public static final DownsampleStrategy f3884fe = new fe();
    public static final DownsampleStrategy qw = new de();

    /* renamed from: rg  reason: collision with root package name */
    public static final DownsampleStrategy f3885rg;

    /* renamed from: th  reason: collision with root package name */
    public static final Option<DownsampleStrategy> f3886th;

    /* renamed from: yj  reason: collision with root package name */
    public static final boolean f3887yj = (Build.VERSION.SDK_INT >= 19);

    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    public static class ad extends DownsampleStrategy {
        public float ad(int i2, int i3, int i4, int i5) {
            return Math.max(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
        }

        public SampleSizeRounding qw(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }
    }

    public static class de extends DownsampleStrategy {
        public float ad(int i2, int i3, int i4, int i5) {
            if (DownsampleStrategy.f3887yj) {
                return Math.min(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
            }
            int max = Math.max(i3 / i5, i2 / i4);
            if (max == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(max));
        }

        public SampleSizeRounding qw(int i2, int i3, int i4, int i5) {
            if (DownsampleStrategy.f3887yj) {
                return SampleSizeRounding.QUALITY;
            }
            return SampleSizeRounding.MEMORY;
        }
    }

    public static class fe extends DownsampleStrategy {
        public float ad(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }

        public SampleSizeRounding qw(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }
    }

    public static class qw extends DownsampleStrategy {
        public float ad(int i2, int i3, int i4, int i5) {
            return Math.min(1.0f, DownsampleStrategy.qw.ad(i2, i3, i4, i5));
        }

        public SampleSizeRounding qw(int i2, int i3, int i4, int i5) {
            if (ad(i2, i3, i4, i5) == 1.0f) {
                return SampleSizeRounding.QUALITY;
            }
            return DownsampleStrategy.qw.qw(i2, i3, i4, i5);
        }
    }

    static {
        DownsampleStrategy downsampleStrategy = f3883de;
        f3885rg = downsampleStrategy;
        f3886th = Option.th("com.dxmbumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", downsampleStrategy);
    }

    public abstract float ad(int i2, int i3, int i4, int i5);

    public abstract SampleSizeRounding qw(int i2, int i3, int i4, int i5);
}
