package com.facebook.fresco.animation.bitmap.preparation.ondemandanimation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.fresco.animation.bitmap.preparation.loadframe.AnimationLoaderExecutor;
import com.facebook.fresco.animation.bitmap.preparation.loadframe.FpsCompressorInfo;
import com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u0001:\u0001<B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000fH\u0016J*\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000fH\u0003J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010$\u001a\u00020\u000fH\u0002J \u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000fH\u0017J\b\u0010-\u001a\u00020\u000fH\u0002J\u0018\u0010.\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000fH\u0002J6\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000fH\u0002J\b\u00101\u001a\u00020\u001fH\u0016J&\u00102\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001f04H\u0017J\u001e\u00105\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000fH\u0002J \u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u000fH\u0002J\f\u0010\u001e\u001a\u00020\u001f*\u00020\u0011H\u0002J\f\u0010!\u001a\u00020\u000f*\u00020\tH\u0002J \u0010:\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010;\u001a\u00020\u0011H\u0002R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/BufferFrameLoader;", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoader;", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "bitmapFrameRenderer", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameRenderer;", "fpsCompressor", "Lcom/facebook/fresco/animation/bitmap/preparation/loadframe/FpsCompressorInfo;", "animationInformation", "Lcom/facebook/fresco/animation/backend/AnimationInformation;", "(Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;Lcom/facebook/fresco/animation/bitmap/BitmapFrameRenderer;Lcom/facebook/fresco/animation/bitmap/preparation/loadframe/FpsCompressorInfo;Lcom/facebook/fresco/animation/backend/AnimationInformation;)V", "getAnimationInformation", "()Lcom/facebook/fresco/animation/backend/AnimationInformation;", "bufferFramesHash", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "bufferFramesSequence", "", "bufferSize", "compressionFrameMap", "", "frameSequence", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/CircularList;", "isFetching", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lastRenderedFrameNumber", "renderableFrameIndexes", "", "clear", "", "compressToFps", "fps", "extractDemandedFrame", "", "targetFrame", "width", "height", "count", "findNearestFrame", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/AnimationBitmapFrame;", "getFrame", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameResult;", "frameNumber", "getThreshold", "loadNextFrameIfNeeded", "obtainFrame", "oldBitmapRef", "onStop", "prepareFrames", "onAnimationLoaded", "Lkotlin/Function0;", "renderFirstBitmap", "updateBitmap", "fromBitmap", "from", "dest", "set", "src", "Companion", "animated-drawable_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BufferFrameLoader.kt */
public final class BufferFrameLoader implements FrameLoader {
    private static final int BUFFER_SECOND_SIZE = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float THRESHOLD_PERCENTAGE = 0.5f;
    private final AnimationInformation animationInformation;
    private final BitmapFrameRenderer bitmapFrameRenderer;
    private final ConcurrentHashMap<Integer, CloseableReference<Bitmap>> bufferFramesHash = new ConcurrentHashMap<>();
    private List<Integer> bufferFramesSequence = CollectionsKt.emptyList();
    private final int bufferSize = (fps(getAnimationInformation()) * 1);
    private Map<Integer, Integer> compressionFrameMap = MapsKt.emptyMap();
    private final FpsCompressorInfo fpsCompressor;
    private final CircularList frameSequence = new CircularList(getAnimationInformation().getFrameCount());
    /* access modifiers changed from: private */
    public final AtomicBoolean isFetching = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public int lastRenderedFrameNumber = -1;
    private final PlatformBitmapFactory platformBitmapFactory;
    private Set<Integer> renderableFrameIndexes = SetsKt.emptySet();

    public BufferFrameLoader(PlatformBitmapFactory platformBitmapFactory2, BitmapFrameRenderer bitmapFrameRenderer2, FpsCompressorInfo fpsCompressor2, AnimationInformation animationInformation2) {
        Intrinsics.checkNotNullParameter(platformBitmapFactory2, "platformBitmapFactory");
        Intrinsics.checkNotNullParameter(bitmapFrameRenderer2, "bitmapFrameRenderer");
        Intrinsics.checkNotNullParameter(fpsCompressor2, "fpsCompressor");
        Intrinsics.checkNotNullParameter(animationInformation2, "animationInformation");
        this.platformBitmapFactory = platformBitmapFactory2;
        this.bitmapFrameRenderer = bitmapFrameRenderer2;
        this.fpsCompressor = fpsCompressor2;
        this.animationInformation = animationInformation2;
        compressToFps(fps(getAnimationInformation()));
    }

    public AnimationInformation getAnimationInformation() {
        return this.animationInformation;
    }

    public FrameResult getFrame(int frameNumber, int width, int height) {
        FrameResult.FrameType frameType;
        Integer num = this.compressionFrameMap.get(Integer.valueOf(frameNumber));
        CloseableReference bitmapRef = null;
        if (num != null) {
            int cachedFrameIndex = num.intValue();
            this.lastRenderedFrameNumber = cachedFrameIndex;
            CloseableReference closeableReference = this.bufferFramesHash.get(Integer.valueOf(cachedFrameIndex));
            CloseableReference cachedFrame = closeableReference != null ? closeableReference.cloneOrNull() : null;
            if (cachedFrame != null) {
                if (this.frameSequence.isTargetAhead(getThreshold(), cachedFrameIndex, this.bufferSize)) {
                    loadNextFrameIfNeeded(width, height);
                }
                return new FrameResult(cachedFrame, FrameResult.FrameType.SUCCESS);
            }
            loadNextFrameIfNeeded(width, height);
            AnimationBitmapFrame findNearestFrame = findNearestFrame(cachedFrameIndex);
            CloseableReference it = findNearestFrame != null ? findNearestFrame.getBitmap() : null;
            if (it != null) {
                bitmapRef = it.cloneOrNull();
            }
            return new FrameResult(bitmapRef, bitmapRef == null ? FrameResult.FrameType.MISSING : FrameResult.FrameType.NEAREST);
        }
        AnimationBitmapFrame findNearestFrame2 = findNearestFrame(frameNumber);
        CloseableReference it2 = findNearestFrame2 != null ? findNearestFrame2.getBitmap() : null;
        if (it2 != null) {
            bitmapRef = it2.cloneOrNull();
        }
        this.lastRenderedFrameNumber = frameNumber;
        if (bitmapRef == null) {
            frameType = FrameResult.FrameType.MISSING;
        } else {
            frameType = FrameResult.FrameType.NEAREST;
        }
        return new FrameResult(bitmapRef, frameType);
    }

    private final int getThreshold() {
        if (this.bufferFramesSequence.isEmpty()) {
            return (int) (((float) this.bufferSize) * 0.5f);
        }
        return this.bufferFramesSequence.get((int) (((float) this.bufferFramesSequence.size()) * 0.5f)).intValue();
    }

    public void prepareFrames(int width, int height, Function0<Unit> onAnimationLoaded) {
        Intrinsics.checkNotNullParameter(onAnimationLoaded, "onAnimationLoaded");
        loadNextFrameIfNeeded(width, height);
        onAnimationLoaded.invoke();
    }

    public void compressToFps(int fps) {
        Map<Integer, Integer> calculateReducedIndexes = this.fpsCompressor.calculateReducedIndexes(getAnimationInformation().getLoopDurationMs() * RangesKt.coerceAtLeast(getAnimationInformation().getLoopCount(), 1), getAnimationInformation().getFrameCount(), RangesKt.coerceAtMost(fps, fps(getAnimationInformation())));
        this.compressionFrameMap = calculateReducedIndexes;
        this.renderableFrameIndexes = CollectionsKt.toSet(calculateReducedIndexes.values());
    }

    public void onStop() {
        AnimationBitmapFrame nearestFrame = findNearestFrame(this.lastRenderedFrameNumber);
        Set<Integer> keySet = this.bufferFramesHash.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "bufferFramesHash.keys");
        for (Integer frameNumber : CollectionsKt.filterNotNull(SetsKt.minus(keySet, nearestFrame != null ? Integer.valueOf(nearestFrame.getFrameNumber()) : null))) {
            CloseableReference.closeSafely((CloseableReference<?>) this.bufferFramesHash.get(frameNumber));
            this.bufferFramesHash.remove(frameNumber);
        }
    }

    public void clear() {
        Collection<CloseableReference<Bitmap>> $this$forEach$iv = this.bufferFramesHash.values();
        Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "bufferFramesHash.values");
        for (CloseableReference it : $this$forEach$iv) {
            CloseableReference.closeSafely((CloseableReference<?>) it);
        }
        this.bufferFramesHash.clear();
        this.lastRenderedFrameNumber = -1;
    }

    private final void loadNextFrameIfNeeded(int width, int height) {
        if (!this.isFetching.getAndSet(true)) {
            AnimationLoaderExecutor.INSTANCE.execute(new BufferFrameLoader$loadNextFrameIfNeeded$1(this, width, height));
        }
    }

    static /* synthetic */ boolean extractDemandedFrame$default(BufferFrameLoader bufferFrameLoader, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            i5 = 0;
        }
        return bufferFrameLoader.extractDemandedFrame(i2, i3, i4, i5);
    }

    private final boolean extractDemandedFrame(int targetFrame, int width, int height, int count) {
        CloseableReference newFrame;
        Set nextWindowIndexes;
        int i2 = width;
        int i3 = height;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : this.frameSequence.sublist(targetFrame, this.bufferSize)) {
            if (this.renderableFrameIndexes.contains(Integer.valueOf(((Number) element$iv$iv).intValue())) != 0) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List<Number> nextWindow = (List) destination$iv$iv;
        Set nextWindowIndexes2 = CollectionsKt.toSet(nextWindow);
        Set<Integer> keySet = this.bufferFramesHash.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "bufferFramesHash.keys");
        ArrayDeque oldFramesNumbers = new ArrayDeque(SetsKt.minus(keySet, nextWindowIndexes2));
        for (Number intValue : nextWindow) {
            int newFrameNumber = intValue.intValue();
            if (this.bufferFramesHash.get(Integer.valueOf(newFrameNumber)) == null) {
                int i4 = this.lastRenderedFrameNumber;
                if (i4 != -1 && !nextWindowIndexes2.contains(Integer.valueOf(i4))) {
                    return false;
                }
                Integer deprecatedFrameNumber = (Integer) oldFramesNumbers.pollFirst();
                CloseableReference deprecatedFrameBitmap = deprecatedFrameNumber != null ? this.bufferFramesHash.get(deprecatedFrameNumber) : null;
                if (deprecatedFrameBitmap == null) {
                    newFrame = obtainFrame((CloseableReference<Bitmap>) null, newFrameNumber, i2, i3);
                } else {
                    newFrame = obtainFrame(deprecatedFrameBitmap, newFrameNumber, i2, i3);
                }
                CloseableReference.closeSafely((CloseableReference<?>) deprecatedFrameBitmap);
                if (deprecatedFrameNumber != null) {
                    Intrinsics.checkNotNullExpressionValue(deprecatedFrameNumber, "deprecatedFrameNumber");
                    nextWindowIndexes = nextWindowIndexes2;
                    CloseableReference remove = this.bufferFramesHash.remove(Integer.valueOf(deprecatedFrameNumber.intValue()));
                } else {
                    nextWindowIndexes = nextWindowIndexes2;
                }
                this.bufferFramesHash.put(Integer.valueOf(newFrameNumber), newFrame);
                i2 = width;
                i3 = height;
                nextWindowIndexes2 = nextWindowIndexes;
            }
        }
        this.bufferFramesSequence = nextWindow;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        if (r3 == null) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r2 = r0.getBitmap();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.facebook.common.references.CloseableReference<android.graphics.Bitmap> obtainFrame(com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r7, int r8, int r9, int r10) {
        /*
            r6 = this;
            com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationBitmapFrame r0 = r6.findNearestFrame(r8)
            r1 = 0
            if (r0 == 0) goto L_0x0012
            com.facebook.common.references.CloseableReference r2 = r0.getBitmap()
            if (r2 == 0) goto L_0x0012
            com.facebook.common.references.CloseableReference r2 = r2.cloneOrNull()
            goto L_0x0013
        L_0x0012:
            r2 = r1
        L_0x0013:
            if (r0 == 0) goto L_0x005b
            if (r2 == 0) goto L_0x005b
            if (r7 == 0) goto L_0x001d
            com.facebook.common.references.CloseableReference r1 = r7.cloneOrNull()
        L_0x001d:
            if (r1 == 0) goto L_0x0031
            java.lang.Object r3 = r2.get()
            java.lang.String r4 = "nearestBitmap.get()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3
            com.facebook.common.references.CloseableReference r3 = r6.set(r1, r3)
            if (r3 != 0) goto L_0x0043
        L_0x0031:
            com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory r3 = r6.platformBitmapFactory
            java.lang.Object r4 = r2.get()
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4
            com.facebook.common.references.CloseableReference r3 = r3.createBitmap(r4)
            java.lang.String r4 = "platformBitmapFactory.cr…tmap(nearestBitmap.get())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
        L_0x0043:
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r2)
            java.lang.Object r4 = r3.get()
            java.lang.String r5 = "copyBitmap.get()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4
            int r5 = r0.getFrameNumber()
            r6.updateBitmap(r4, r5, r8)
            return r3
        L_0x005b:
            com.facebook.common.references.CloseableReference r1 = r6.renderFirstBitmap(r9, r10)
            java.lang.Object r3 = r1.get()
            java.lang.String r4 = "bitmap.get()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3
            r4 = 0
            r6.updateBitmap(r3, r4, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.BufferFrameLoader.obtainFrame(com.facebook.common.references.CloseableReference, int, int, int):com.facebook.common.references.CloseableReference");
    }

    private final AnimationBitmapFrame findNearestFrame(int targetFrame) {
        AnimationBitmapFrame animationBitmapFrame;
        Iterator it = new IntRange(0, this.frameSequence.getSize()).iterator();
        do {
            animationBitmapFrame = null;
            if (!it.hasNext()) {
                break;
            }
            int closestFrame = this.frameSequence.getPosition(targetFrame - ((IntIterator) it).nextInt());
            CloseableReference it2 = this.bufferFramesHash.get(Integer.valueOf(closestFrame));
            if (it2 != null) {
                if (!it2.isValid()) {
                    it2 = null;
                }
                if (it2 != null) {
                    animationBitmapFrame = new AnimationBitmapFrame(closestFrame, it2);
                    continue;
                } else {
                    continue;
                }
            }
        } while (animationBitmapFrame == null);
        return animationBitmapFrame;
    }

    private final CloseableReference<Bitmap> renderFirstBitmap(int width, int height) {
        CloseableReference base = this.platformBitmapFactory.createBitmap(width, height);
        Intrinsics.checkNotNullExpressionValue(base, "platformBitmapFactory.createBitmap(width, height)");
        BitmapFrameRenderer bitmapFrameRenderer2 = this.bitmapFrameRenderer;
        Bitmap bitmap = base.get();
        Intrinsics.checkNotNullExpressionValue(bitmap, "base.get()");
        bitmapFrameRenderer2.renderFrame(0, bitmap);
        return base;
    }

    private final void updateBitmap(Bitmap fromBitmap, int from, int dest) {
        if (from > dest) {
            clear(fromBitmap);
            Iterator it = new IntRange(0, dest).iterator();
            while (it.hasNext()) {
                this.bitmapFrameRenderer.renderFrame(((IntIterator) it).nextInt(), fromBitmap);
            }
        } else if (from < dest) {
            Iterator it2 = new IntRange(from + 1, dest).iterator();
            while (it2.hasNext()) {
                this.bitmapFrameRenderer.renderFrame(((IntIterator) it2).nextInt(), fromBitmap);
            }
        }
    }

    private final void clear(Bitmap $this$clear) {
        new Canvas($this$clear).drawColor(0, PorterDuff.Mode.CLEAR);
    }

    private final CloseableReference<Bitmap> set(CloseableReference<Bitmap> $this$set, Bitmap src) {
        if ($this$set.isValid()) {
            Canvas canvas = new Canvas($this$set.get());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            canvas.drawBitmap(src, 0.0f, 0.0f, (Paint) null);
        }
        return $this$set;
    }

    private final int fps(AnimationInformation $this$fps) {
        return (int) RangesKt.coerceAtLeast(TimeUnit.SECONDS.toMillis(1) / ((long) ($this$fps.getLoopDurationMs() / $this$fps.getFrameCount())), 1);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/BufferFrameLoader$Companion;", "", "()V", "BUFFER_SECOND_SIZE", "", "THRESHOLD_PERCENTAGE", "", "animated-drawable_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BufferFrameLoader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
