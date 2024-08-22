package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.preparation.loadframe.FpsCompressorInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.cache.AnimatedCache;
import com.facebook.imagepipeline.cache.AnimationFrames;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\u0016H\u0002J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J(\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u0018\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\u0018\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\"\u0010!\u001a\u00020\u00192\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\u0016H\u0016J&\u0010\"\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\n2\u0006\u0010$\u001a\u00020\u000fH\u0016J&\u0010%\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\n2\u0006\u0010$\u001a\u00020\u000fH\u0016J\b\u0010&\u001a\u00020\u0013H\u0002J\n\u0010'\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010(\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\f\u0010+\u001a\u00020\u000f*\u00020,H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006."}, d2 = {"Lcom/facebook/fresco/animation/bitmap/cache/FrescoFpsCache;", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameCache;", "animatedImageResult", "Lcom/facebook/imagepipeline/animated/base/AnimatedImageResult;", "fpsCompressorInfo", "Lcom/facebook/fresco/animation/bitmap/preparation/loadframe/FpsCompressorInfo;", "animatedDrawableCache", "Lcom/facebook/imagepipeline/cache/AnimatedCache;", "(Lcom/facebook/imagepipeline/animated/base/AnimatedImageResult;Lcom/facebook/fresco/animation/bitmap/preparation/loadframe/FpsCompressorInfo;Lcom/facebook/imagepipeline/cache/AnimatedCache;)V", "animationFrames", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/cache/AnimationFrames;", "cacheKey", "", "sizeInBytes", "", "getSizeInBytes", "()I", "clear", "", "compressAnimation", "frameBitmaps", "", "Landroid/graphics/Bitmap;", "contains", "", "frameNumber", "getBitmapToReuseForFrame", "width", "height", "getCachedFrame", "getFallbackFrame", "isAnimationReady", "onAnimationPrepared", "onFramePrepared", "bitmapReference", "frameType", "onFrameRendered", "releaseCache", "safeAnimationFrames", "setFrameCacheListener", "frameCacheListener", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameCache$FrameCacheListener;", "fps", "Lcom/facebook/imagepipeline/animated/base/AnimatedImage;", "Companion", "animated-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FrescoFpsCache.kt */
public final class FrescoFpsCache implements BitmapFrameCache {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int FPS_COMPRESSION_STEP = 1;
    private final AnimatedCache animatedDrawableCache;
    private final AnimatedImageResult animatedImageResult;
    private CloseableReference<AnimationFrames> animationFrames;
    private final String cacheKey;
    private final FpsCompressorInfo fpsCompressorInfo;

    public FrescoFpsCache(AnimatedImageResult animatedImageResult2, FpsCompressorInfo fpsCompressorInfo2, AnimatedCache animatedDrawableCache2) {
        Intrinsics.checkNotNullParameter(animatedImageResult2, "animatedImageResult");
        Intrinsics.checkNotNullParameter(fpsCompressorInfo2, "fpsCompressorInfo");
        Intrinsics.checkNotNullParameter(animatedDrawableCache2, "animatedDrawableCache");
        this.animatedImageResult = animatedImageResult2;
        this.fpsCompressorInfo = fpsCompressorInfo2;
        this.animatedDrawableCache = animatedDrawableCache2;
        String source = animatedImageResult2.getSource();
        source = source == null ? String.valueOf(animatedImageResult2.getImage().hashCode()) : source;
        this.cacheKey = source;
        this.animationFrames = animatedDrawableCache2.findAnimation(source);
    }

    public CloseableReference<Bitmap> getCachedFrame(int frameNumber) {
        AnimationFrames safeAnimationFrames = safeAnimationFrames();
        if (safeAnimationFrames != null) {
            return safeAnimationFrames.getFrame(frameNumber);
        }
        return null;
    }

    public CloseableReference<Bitmap> getFallbackFrame(int frameNumber) {
        return null;
    }

    public CloseableReference<Bitmap> getBitmapToReuseForFrame(int frameNumber, int width, int height) {
        return null;
    }

    public boolean contains(int frameNumber) {
        return getCachedFrame(frameNumber) != null;
    }

    public int getSizeInBytes() {
        AnimationFrames safeAnimationFrames = safeAnimationFrames();
        if (safeAnimationFrames != null) {
            return safeAnimationFrames.getSizeBytes();
        }
        return 0;
    }

    public void clear() {
        releaseCache();
    }

    private final void releaseCache() {
        this.animatedDrawableCache.removeAnimation(this.cacheKey);
        this.animationFrames = null;
    }

    public boolean isAnimationReady() {
        AnimationFrames safeAnimationFrames = safeAnimationFrames();
        Map<Integer, CloseableReference<Bitmap>> frames = safeAnimationFrames != null ? safeAnimationFrames.getFrames() : null;
        if (frames == null) {
            frames = MapsKt.emptyMap();
        }
        return frames.size() > 1;
    }

    public void onFrameRendered(int frameNumber, CloseableReference<Bitmap> bitmapReference, int frameType) {
        Intrinsics.checkNotNullParameter(bitmapReference, "bitmapReference");
    }

    public void onFramePrepared(int frameNumber, CloseableReference<Bitmap> bitmapReference, int frameType) {
        Intrinsics.checkNotNullParameter(bitmapReference, "bitmapReference");
    }

    public boolean onAnimationPrepared(Map<Integer, ? extends CloseableReference<Bitmap>> frameBitmaps) {
        Intrinsics.checkNotNullParameter(frameBitmaps, "frameBitmaps");
        AnimationFrames safeAnimationFrames = safeAnimationFrames();
        Map<Integer, CloseableReference<Bitmap>> frames = safeAnimationFrames != null ? safeAnimationFrames.getFrames() : null;
        if (frames == null) {
            frames = MapsKt.emptyMap();
        }
        if (frameBitmaps.size() < frames.size()) {
            return true;
        }
        CloseableReference<AnimationFrames> compressAnimation = compressAnimation(frameBitmaps);
        this.animationFrames = compressAnimation;
        if (compressAnimation != null) {
            return true;
        }
        return false;
    }

    private final CloseableReference<AnimationFrames> compressAnimation(Map<Integer, ? extends CloseableReference<Bitmap>> frameBitmaps) {
        AnimatedImage image = this.animatedImageResult.getImage();
        Intrinsics.checkNotNullExpressionValue(image, "animatedImageResult.image");
        int fps = fps(image);
        CloseableReference animationFrames2 = null;
        while (animationFrames2 == null && fps > 1) {
            FpsCompressorInfo.CompressionResult compressionResult = this.fpsCompressorInfo.compress(this.animatedImageResult.getImage().getDuration(), frameBitmaps, fps);
            animationFrames2 = this.animatedDrawableCache.saveAnimation(this.cacheKey, new AnimationFrames(compressionResult.getCompressedAnim(), compressionResult.getRealToReducedIndex()));
            if (animationFrames2 != null) {
                for (CloseableReference it : compressionResult.getRemovedFrames()) {
                    it.close();
                }
            }
            fps--;
        }
        return animationFrames2;
    }

    private final synchronized AnimationFrames safeAnimationFrames() {
        CloseableReference animatedCache = this.animationFrames;
        AnimationFrames animationFrames2 = null;
        if (animatedCache == null && (animatedCache = this.animatedDrawableCache.findAnimation(this.cacheKey)) == null) {
            return null;
        }
        synchronized (animatedCache) {
            if (animatedCache.isValid()) {
                animationFrames2 = animatedCache.get();
            }
        }
        return animationFrames2;
    }

    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener frameCacheListener) {
    }

    private final int fps(AnimatedImage $this$fps) {
        return (int) (TimeUnit.SECONDS.toMillis(1) / ((long) RangesKt.coerceAtLeast($this$fps.getDuration() / RangesKt.coerceAtLeast($this$fps.getFrameCount(), 1), 1)));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/cache/FrescoFpsCache$Companion;", "", "()V", "FPS_COMPRESSION_STEP", "", "animated-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FrescoFpsCache.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
