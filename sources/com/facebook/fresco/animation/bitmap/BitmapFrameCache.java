package com.facebook.fresco.animation.bitmap;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u001dJ\b\u0010\u0006\u001a\u00020\u0007H&J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H¦\u0002J(\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H&J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0003H&J\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\tH\u0016J\"\u0010\u0013\u001a\u00020\t2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0015H\u0016J&\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0018\u001a\u00020\u0003H&J&\u0010\u0019\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0018\u001a\u00020\u0003H&J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001e"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/BitmapFrameCache;", "", "sizeInBytes", "", "getSizeInBytes", "()I", "clear", "", "contains", "", "frameNumber", "getBitmapToReuseForFrame", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "width", "height", "getCachedFrame", "getFallbackFrame", "isAnimationReady", "onAnimationPrepared", "frameBitmaps", "", "onFramePrepared", "bitmapReference", "frameType", "onFrameRendered", "setFrameCacheListener", "frameCacheListener", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameCache$FrameCacheListener;", "FrameCacheListener", "animated-drawable_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BitmapFrameCache.kt */
public interface BitmapFrameCache {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/BitmapFrameCache$FrameCacheListener;", "", "onFrameCached", "", "bitmapFrameCache", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameCache;", "frameNumber", "", "onFrameEvicted", "animated-drawable_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BitmapFrameCache.kt */
    public interface FrameCacheListener {
        void onFrameCached(BitmapFrameCache bitmapFrameCache, int i2);

        void onFrameEvicted(BitmapFrameCache bitmapFrameCache, int i2);
    }

    void clear();

    boolean contains(int i2);

    CloseableReference<Bitmap> getBitmapToReuseForFrame(int i2, int i3, int i4);

    CloseableReference<Bitmap> getCachedFrame(int i2);

    CloseableReference<Bitmap> getFallbackFrame(int i2);

    int getSizeInBytes();

    boolean isAnimationReady();

    boolean onAnimationPrepared(Map<Integer, ? extends CloseableReference<Bitmap>> map);

    void onFramePrepared(int i2, CloseableReference<Bitmap> closeableReference, int i3);

    void onFrameRendered(int i2, CloseableReference<Bitmap> closeableReference, int i3);

    void setFrameCacheListener(FrameCacheListener frameCacheListener);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BitmapFrameCache.kt */
    public static final class DefaultImpls {
        public static boolean onAnimationPrepared(BitmapFrameCache bitmapFrameCache, Map<Integer, ? extends CloseableReference<Bitmap>> frameBitmaps) {
            Intrinsics.checkNotNullParameter(frameBitmaps, "frameBitmaps");
            return true;
        }

        public static boolean isAnimationReady(BitmapFrameCache bitmapFrameCache) {
            return false;
        }
    }
}
