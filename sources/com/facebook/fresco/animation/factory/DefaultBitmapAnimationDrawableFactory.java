package com.facebook.fresco.animation.factory;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.fresco.animation.bitmap.cache.AnimationFrameCacheKey;
import com.facebook.fresco.animation.bitmap.cache.FrescoFpsCache;
import com.facebook.fresco.animation.bitmap.cache.FrescoFrameCache;
import com.facebook.fresco.animation.bitmap.cache.KeepLastFrameCache;
import com.facebook.fresco.animation.bitmap.cache.NoOpCache;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.loadframe.FpsCompressorInfo;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.KAnimatedDrawable2;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.options.ImageOptionsDrawableFactory;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.AnimatedCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

public class DefaultBitmapAnimationDrawableFactory implements DrawableFactory, ImageOptionsDrawableFactory {
    public static final int CACHING_STRATEGY_FRESCO_CACHE = 1;
    public static final int CACHING_STRATEGY_FRESCO_CACHE_NO_REUSING = 2;
    public static final int CACHING_STRATEGY_KEEP_LAST_CACHE = 3;
    public static final int CACHING_STRATEGY_NO_CACHE = 0;
    private final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    private final Supplier<AnimatedCache> mAnimatedDrawableCache;
    private final Supplier<Integer> mAnimationFpsLimit;
    private final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    private final Supplier<Integer> mBalancedStrategyPreparationMs;
    private final Supplier<Integer> mCachingStrategySupplier;
    private final Supplier<Boolean> mDownscaleFrameToDrawableDimensions;
    private final ExecutorService mExecutorServiceForFramePreparing;
    private final MonotonicClock mMonotonicClock;
    private final Supplier<Integer> mNumberOfFramesToPrepareSupplier;
    private final PlatformBitmapFactory mPlatformBitmapFactory;
    private final ScheduledExecutorService mScheduledExecutorServiceForUiThread;
    private final Supplier<Boolean> mUseDeepEqualsForCacheKey;
    private final Supplier<Boolean> mUseNewBitmapRender;
    private final Supplier<Boolean> useRendererAnimatedDrawable = Suppliers.BOOLEAN_FALSE;

    public DefaultBitmapAnimationDrawableFactory(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, ScheduledExecutorService scheduledExecutorServiceForUiThread, ExecutorService executorServiceForFramePreparing, MonotonicClock monotonicClock, PlatformBitmapFactory platformBitmapFactory, CountingMemoryCache<CacheKey, CloseableImage> backingCache, Supplier<AnimatedCache> animatedDrawableCache, Supplier<Integer> cachingStrategySupplier, Supplier<Integer> numberOfFramesToPrepareSupplier, Supplier<Boolean> useDeepEqualsForCacheKey, Supplier<Boolean> useNewBitmapRender, Supplier<Boolean> downscaleFrameToDrawableDimensions, Supplier<Integer> animationFpsLimit, Supplier<Integer> balancedStrategyPreparationMs) {
        this.mAnimatedDrawableBackendProvider = animatedDrawableBackendProvider;
        this.mScheduledExecutorServiceForUiThread = scheduledExecutorServiceForUiThread;
        this.mExecutorServiceForFramePreparing = executorServiceForFramePreparing;
        this.mMonotonicClock = monotonicClock;
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBackingCache = backingCache;
        this.mCachingStrategySupplier = cachingStrategySupplier;
        this.mNumberOfFramesToPrepareSupplier = numberOfFramesToPrepareSupplier;
        this.mUseDeepEqualsForCacheKey = useDeepEqualsForCacheKey;
        this.mUseNewBitmapRender = useNewBitmapRender;
        this.mAnimatedDrawableCache = animatedDrawableCache;
        this.mAnimationFpsLimit = animationFpsLimit;
        this.mBalancedStrategyPreparationMs = balancedStrategyPreparationMs;
        this.mDownscaleFrameToDrawableDimensions = downscaleFrameToDrawableDimensions;
    }

    public boolean supportsImageType(CloseableImage image) {
        return image instanceof CloseableAnimatedImage;
    }

    public Drawable createDrawable(CloseableImage image) {
        CloseableAnimatedImage closeable = (CloseableAnimatedImage) image;
        AnimatedImage animatedImage = closeable.getImage();
        AnimationBackend animationBackend = createAnimationBackend((AnimatedImageResult) Preconditions.checkNotNull(closeable.getImageResult()), animatedImage != null ? animatedImage.getAnimatedBitmapConfig() : null, (ImageOptions) null);
        if (this.useRendererAnimatedDrawable.get().booleanValue()) {
            return new KAnimatedDrawable2(animationBackend);
        }
        return new AnimatedDrawable2(animationBackend);
    }

    public Drawable createDrawable(Resources resources, CloseableImage closeableImage, ImageOptions imageOptions) {
        CloseableAnimatedImage closeable = (CloseableAnimatedImage) closeableImage;
        AnimatedImage animatedImage = closeable.getImage();
        AnimationBackend animationBackend = createAnimationBackend((AnimatedImageResult) Preconditions.checkNotNull(closeable.getImageResult()), animatedImage != null ? animatedImage.getAnimatedBitmapConfig() : null, imageOptions);
        if (this.useRendererAnimatedDrawable.get().booleanValue()) {
            return new KAnimatedDrawable2(animationBackend);
        }
        return new AnimatedDrawable2(animationBackend);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: com.facebook.fresco.animation.bitmap.preparation.BalancedAnimationStrategy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: com.facebook.fresco.animation.bitmap.preparation.FrameLoaderStrategy} */
    /* JADX WARNING: type inference failed for: r5v9, types: [com.facebook.fresco.animation.bitmap.preparation.FixedNumberBitmapFramePreparationStrategy] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.fresco.animation.backend.AnimationBackend createAnimationBackend(com.facebook.imagepipeline.animated.base.AnimatedImageResult r20, @javax.annotation.Nullable android.graphics.Bitmap.Config r21, @javax.annotation.Nullable com.facebook.fresco.vito.options.ImageOptions r22) {
        /*
            r19 = this;
            r0 = r19
            com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend r1 = r19.createAnimatedDrawableBackend(r20)
            com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendAnimationInformation r3 = new com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendAnimationInformation
            r3.<init>(r1)
            com.facebook.fresco.animation.bitmap.BitmapFrameCache r13 = r19.createBitmapFrameCache(r20)
            com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer r2 = new com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer
            com.facebook.common.internal.Supplier<java.lang.Boolean> r4 = r0.mUseNewBitmapRender
            java.lang.Object r4 = r4.get()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r2.<init>(r13, r1, r4)
            r14 = r2
            com.facebook.common.internal.Supplier<java.lang.Integer> r2 = r0.mNumberOfFramesToPrepareSupplier
            java.lang.Object r2 = r2.get()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r15 = r2.intValue()
            r2 = 0
            r4 = 0
            if (r15 <= 0) goto L_0x0041
            com.facebook.fresco.animation.bitmap.preparation.FixedNumberBitmapFramePreparationStrategy r5 = new com.facebook.fresco.animation.bitmap.preparation.FixedNumberBitmapFramePreparationStrategy
            r5.<init>(r15)
            r2 = r5
            r12 = r21
            com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer r4 = r0.createBitmapFramePreparer(r14, r12)
            r11 = r2
            r16 = r4
            goto L_0x0046
        L_0x0041:
            r12 = r21
            r11 = r2
            r16 = r4
        L_0x0046:
            r2 = 0
            if (r22 == 0) goto L_0x0050
            com.facebook.fresco.vito.options.RoundingOptions r2 = r22.getRoundingOptions()
            r17 = r2
            goto L_0x0052
        L_0x0050:
            r17 = r2
        L_0x0052:
            com.facebook.common.internal.Supplier<java.lang.Boolean> r2 = r0.mUseNewBitmapRender
            java.lang.Object r2 = r2.get()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x00c4
            com.facebook.common.internal.Supplier<java.lang.Integer> r2 = r0.mBalancedStrategyPreparationMs
            java.lang.Object r2 = r2.get()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 == 0) goto L_0x0097
            com.facebook.fresco.animation.bitmap.preparation.BalancedAnimationStrategy r8 = new com.facebook.fresco.animation.bitmap.preparation.BalancedAnimationStrategy
            com.facebook.common.internal.Supplier<java.lang.Integer> r2 = r0.mBalancedStrategyPreparationMs
            java.lang.Object r2 = r2.get()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r4 = r2.intValue()
            com.facebook.fresco.animation.bitmap.preparation.loadframe.LoadFrameTaskFactory r5 = new com.facebook.fresco.animation.bitmap.preparation.loadframe.LoadFrameTaskFactory
            com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory r2 = r0.mPlatformBitmapFactory
            r5.<init>(r2, r14)
            com.facebook.common.internal.Supplier<java.lang.Boolean> r2 = r0.mDownscaleFrameToDrawableDimensions
            java.lang.Object r2 = r2.get()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r7 = r2.booleanValue()
            r2 = r8
            r6 = r13
            r2.<init>(r3, r4, r5, r6, r7)
            r11 = r8
            r2 = r11
            goto L_0x00c5
        L_0x0097:
            com.facebook.fresco.animation.bitmap.preparation.FrameLoaderStrategy r2 = new com.facebook.fresco.animation.bitmap.preparation.FrameLoaderStrategy
            java.lang.String r6 = r20.getSource()
            com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoaderFactory r9 = new com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoaderFactory
            com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory r4 = r0.mPlatformBitmapFactory
            com.facebook.common.internal.Supplier<java.lang.Integer> r5 = r0.mAnimationFpsLimit
            java.lang.Object r5 = r5.get()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r9.<init>(r4, r5)
            com.facebook.common.internal.Supplier<java.lang.Boolean> r4 = r0.mDownscaleFrameToDrawableDimensions
            java.lang.Object r4 = r4.get()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r10 = r4.booleanValue()
            r5 = r2
            r7 = r3
            r8 = r14
            r5.<init>(r6, r7, r8, r9, r10)
            r11 = r2
            goto L_0x00c5
        L_0x00c4:
            r2 = r11
        L_0x00c5:
            com.facebook.fresco.animation.bitmap.BitmapAnimationBackend r18 = new com.facebook.fresco.animation.bitmap.BitmapAnimationBackend
            com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory r5 = r0.mPlatformBitmapFactory
            com.facebook.common.internal.Supplier<java.lang.Boolean> r4 = r0.mUseNewBitmapRender
            java.lang.Object r4 = r4.get()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r9 = r4.booleanValue()
            r4 = r18
            r6 = r13
            r7 = r3
            r8 = r14
            r10 = r2
            r11 = r16
            r12 = r17
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            com.facebook.common.time.MonotonicClock r5 = r0.mMonotonicClock
            java.util.concurrent.ScheduledExecutorService r6 = r0.mScheduledExecutorServiceForUiThread
            com.facebook.fresco.animation.backend.AnimationBackendDelegate r5 = com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.createForBackend(r4, r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.animation.factory.DefaultBitmapAnimationDrawableFactory.createAnimationBackend(com.facebook.imagepipeline.animated.base.AnimatedImageResult, android.graphics.Bitmap$Config, com.facebook.fresco.vito.options.ImageOptions):com.facebook.fresco.animation.backend.AnimationBackend");
    }

    private BitmapFramePreparer createBitmapFramePreparer(BitmapFrameRenderer bitmapFrameRenderer, @Nullable Bitmap.Config animatedBitmapConig) {
        return new DefaultBitmapFramePreparer(this.mPlatformBitmapFactory, bitmapFrameRenderer, animatedBitmapConig != null ? animatedBitmapConig : Bitmap.Config.ARGB_8888, this.mExecutorServiceForFramePreparing);
    }

    private AnimatedDrawableBackend createAnimatedDrawableBackend(AnimatedImageResult animatedImageResult) {
        AnimatedImage animatedImage = animatedImageResult.getImage();
        return this.mAnimatedDrawableBackendProvider.get(animatedImageResult, new Rect(0, 0, animatedImage.getWidth(), animatedImage.getHeight()));
    }

    private BitmapFrameCache createBitmapFrameCache(AnimatedImageResult animatedImageResult) {
        if (this.mUseNewBitmapRender.get().booleanValue()) {
            return new FrescoFpsCache(animatedImageResult, new FpsCompressorInfo(this.mAnimationFpsLimit.get().intValue()), this.mAnimatedDrawableCache.get());
        }
        switch (this.mCachingStrategySupplier.get().intValue()) {
            case 1:
                return new FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), true);
            case 2:
                return new FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), false);
            case 3:
                return new KeepLastFrameCache();
            default:
                return new NoOpCache();
        }
    }

    private AnimatedFrameCache createAnimatedFrameCache(AnimatedImageResult animatedImageResult) {
        return new AnimatedFrameCache(new AnimationFrameCacheKey(animatedImageResult.hashCode(), this.mUseDeepEqualsForCacheKey.get().booleanValue()), this.mBackingCache);
    }
}
