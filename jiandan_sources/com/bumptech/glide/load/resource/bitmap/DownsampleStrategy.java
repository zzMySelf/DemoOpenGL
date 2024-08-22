package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Option;

public abstract class DownsampleStrategy {

    /* renamed from: ad  reason: collision with root package name */
    public static final DownsampleStrategy f3711ad = new ad();

    /* renamed from: de  reason: collision with root package name */
    public static final DownsampleStrategy f3712de = new qw();

    /* renamed from: fe  reason: collision with root package name */
    public static final DownsampleStrategy f3713fe = new fe();
    public static final DownsampleStrategy qw = new de();

    /* renamed from: rg  reason: collision with root package name */
    public static final DownsampleStrategy f3714rg;

    /* renamed from: th  reason: collision with root package name */
    public static final Option<DownsampleStrategy> f3715th;

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
            return Math.min(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
        }

        public SampleSizeRounding qw(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
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
            return SampleSizeRounding.QUALITY;
        }
    }

    static {
        DownsampleStrategy downsampleStrategy = f3711ad;
        f3714rg = downsampleStrategy;
        f3715th = Option.th("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", downsampleStrategy);
    }

    public abstract float ad(int i2, int i3, int i4, int i5);

    public abstract SampleSizeRounding qw(int i2, int i3, int i4, int i5);
}
