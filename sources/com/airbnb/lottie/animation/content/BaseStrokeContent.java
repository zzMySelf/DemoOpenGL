package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseStrokeContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, DrawingContent {
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final List<BaseKeyframeAnimation<?, Float>> dashPatternAnimations;
    private final BaseKeyframeAnimation<?, Float> dashPatternOffsetAnimation;
    private final float[] dashPatternValues;
    protected final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final BaseKeyframeAnimation<?, Integer> opacityAnimation;
    final Paint paint;
    private final Path path = new Path();
    private final List<PathGroup> pathGroups = new ArrayList();
    private final PathMeasure pm = new PathMeasure();
    private final RectF rect = new RectF();
    private final Path trimPathPath = new Path();
    private final BaseKeyframeAnimation<?, Float> widthAnimation;

    BaseStrokeContent(LottieDrawable lottieDrawable2, BaseLayer layer2, Paint.Cap cap, Paint.Join join, float miterLimit, AnimatableIntegerValue opacity, AnimatableFloatValue width, List<AnimatableFloatValue> dashPattern, AnimatableFloatValue offset) {
        LPaint lPaint = new LPaint(1);
        this.paint = lPaint;
        this.lottieDrawable = lottieDrawable2;
        this.layer = layer2;
        lPaint.setStyle(Paint.Style.STROKE);
        lPaint.setStrokeCap(cap);
        lPaint.setStrokeJoin(join);
        lPaint.setStrokeMiter(miterLimit);
        this.opacityAnimation = opacity.createAnimation();
        this.widthAnimation = width.createAnimation();
        if (offset == null) {
            this.dashPatternOffsetAnimation = null;
        } else {
            this.dashPatternOffsetAnimation = offset.createAnimation();
        }
        this.dashPatternAnimations = new ArrayList(dashPattern.size());
        this.dashPatternValues = new float[dashPattern.size()];
        for (int i2 = 0; i2 < dashPattern.size(); i2++) {
            this.dashPatternAnimations.add(dashPattern.get(i2).createAnimation());
        }
        layer2.addAnimation(this.opacityAnimation);
        layer2.addAnimation(this.widthAnimation);
        for (int i3 = 0; i3 < this.dashPatternAnimations.size(); i3++) {
            layer2.addAnimation(this.dashPatternAnimations.get(i3));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation != null) {
            layer2.addAnimation(baseKeyframeAnimation);
        }
        this.opacityAnimation.addUpdateListener(this);
        this.widthAnimation.addUpdateListener(this);
        for (int i4 = 0; i4 < dashPattern.size(); i4++) {
            this.dashPatternAnimations.get(i4).addUpdateListener(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(this);
        }
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    /* JADX WARNING: type inference failed for: r2v6, types: [com.airbnb.lottie.animation.content.Content] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setContents(java.util.List<com.airbnb.lottie.animation.content.Content> r8, java.util.List<com.airbnb.lottie.animation.content.Content> r9) {
        /*
            r7 = this;
            r0 = 0
            int r1 = r8.size()
            int r1 = r1 + -1
        L_0x0007:
            if (r1 < 0) goto L_0x0024
            java.lang.Object r2 = r8.get(r1)
            com.airbnb.lottie.animation.content.Content r2 = (com.airbnb.lottie.animation.content.Content) r2
            boolean r3 = r2 instanceof com.airbnb.lottie.animation.content.TrimPathContent
            if (r3 == 0) goto L_0x0021
            r3 = r2
            com.airbnb.lottie.animation.content.TrimPathContent r3 = (com.airbnb.lottie.animation.content.TrimPathContent) r3
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r3 = r3.getType()
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r4 = com.airbnb.lottie.model.content.ShapeTrimPath.Type.INDIVIDUALLY
            if (r3 != r4) goto L_0x0021
            r0 = r2
            com.airbnb.lottie.animation.content.TrimPathContent r0 = (com.airbnb.lottie.animation.content.TrimPathContent) r0
        L_0x0021:
            int r1 = r1 + -1
            goto L_0x0007
        L_0x0024:
            if (r0 == 0) goto L_0x0029
            r0.addListener(r7)
        L_0x0029:
            r1 = 0
            int r2 = r9.size()
            int r2 = r2 + -1
        L_0x0030:
            if (r2 < 0) goto L_0x0078
            java.lang.Object r3 = r9.get(r2)
            com.airbnb.lottie.animation.content.Content r3 = (com.airbnb.lottie.animation.content.Content) r3
            boolean r4 = r3 instanceof com.airbnb.lottie.animation.content.TrimPathContent
            r5 = 0
            if (r4 == 0) goto L_0x005f
            r4 = r3
            com.airbnb.lottie.animation.content.TrimPathContent r4 = (com.airbnb.lottie.animation.content.TrimPathContent) r4
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r4 = r4.getType()
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r6 = com.airbnb.lottie.model.content.ShapeTrimPath.Type.INDIVIDUALLY
            if (r4 != r6) goto L_0x005f
            if (r1 == 0) goto L_0x004f
            java.util.List<com.airbnb.lottie.animation.content.BaseStrokeContent$PathGroup> r4 = r7.pathGroups
            r4.add(r1)
        L_0x004f:
            com.airbnb.lottie.animation.content.BaseStrokeContent$PathGroup r4 = new com.airbnb.lottie.animation.content.BaseStrokeContent$PathGroup
            r6 = r3
            com.airbnb.lottie.animation.content.TrimPathContent r6 = (com.airbnb.lottie.animation.content.TrimPathContent) r6
            r4.<init>(r6)
            r1 = r4
            r4 = r3
            com.airbnb.lottie.animation.content.TrimPathContent r4 = (com.airbnb.lottie.animation.content.TrimPathContent) r4
            r4.addListener(r7)
            goto L_0x0075
        L_0x005f:
            boolean r4 = r3 instanceof com.airbnb.lottie.animation.content.PathContent
            if (r4 == 0) goto L_0x0075
            if (r1 != 0) goto L_0x006b
            com.airbnb.lottie.animation.content.BaseStrokeContent$PathGroup r4 = new com.airbnb.lottie.animation.content.BaseStrokeContent$PathGroup
            r4.<init>(r0)
            r1 = r4
        L_0x006b:
            java.util.List r4 = r1.paths
            r5 = r3
            com.airbnb.lottie.animation.content.PathContent r5 = (com.airbnb.lottie.animation.content.PathContent) r5
            r4.add(r5)
        L_0x0075:
            int r2 = r2 + -1
            goto L_0x0030
        L_0x0078:
            if (r1 == 0) goto L_0x007f
            java.util.List<com.airbnb.lottie.animation.content.BaseStrokeContent$PathGroup> r2 = r7.pathGroups
            r2.add(r1)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.BaseStrokeContent.setContents(java.util.List, java.util.List):void");
    }

    public void draw(Canvas canvas, Matrix parentMatrix, int parentAlpha) {
        L.beginSection("StrokeContent#draw");
        if (Utils.hasZeroScaleAxis(parentMatrix)) {
            L.endSection("StrokeContent#draw");
            return;
        }
        this.paint.setAlpha(MiscUtils.clamp((int) ((((((float) parentAlpha) / 255.0f) * ((float) ((IntegerKeyframeAnimation) this.opacityAnimation).getIntValue())) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(((FloatKeyframeAnimation) this.widthAnimation).getFloatValue() * Utils.getScale(parentMatrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            L.endSection("StrokeContent#draw");
            return;
        }
        applyDashPatternIfNeeded(parentMatrix);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter(baseKeyframeAnimation.getValue());
        }
        for (int i2 = 0; i2 < this.pathGroups.size(); i2++) {
            PathGroup pathGroup = this.pathGroups.get(i2);
            if (pathGroup.trimPath != null) {
                applyTrimPath(canvas, pathGroup, parentMatrix);
            } else {
                L.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int j2 = pathGroup.paths.size() - 1; j2 >= 0; j2--) {
                    this.path.addPath(((PathContent) pathGroup.paths.get(j2)).getPath(), parentMatrix);
                }
                L.endSection("StrokeContent#buildPath");
                L.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                L.endSection("StrokeContent#drawPath");
            }
        }
        L.endSection("StrokeContent#draw");
    }

    private void applyTrimPath(Canvas canvas, PathGroup pathGroup, Matrix parentMatrix) {
        float startValue;
        float endValue;
        float startValue2;
        Canvas canvas2 = canvas;
        Matrix matrix = parentMatrix;
        L.beginSection("StrokeContent#applyTrimPath");
        if (pathGroup.trimPath == null) {
            L.endSection("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int j2 = pathGroup.paths.size() - 1; j2 >= 0; j2--) {
            this.path.addPath(((PathContent) pathGroup.paths.get(j2)).getPath(), matrix);
        }
        this.pm.setPath(this.path, false);
        float totalLength = this.pm.getLength();
        while (this.pm.nextContour()) {
            totalLength += this.pm.getLength();
        }
        float offsetLength = (pathGroup.trimPath.getOffset().getValue().floatValue() * totalLength) / 360.0f;
        float startLength = ((pathGroup.trimPath.getStart().getValue().floatValue() * totalLength) / 100.0f) + offsetLength;
        float endLength = ((pathGroup.trimPath.getEnd().getValue().floatValue() * totalLength) / 100.0f) + offsetLength;
        float currentLength = 0.0f;
        for (int j3 = pathGroup.paths.size() - 1; j3 >= 0; j3--) {
            this.trimPathPath.set(((PathContent) pathGroup.paths.get(j3)).getPath());
            this.trimPathPath.transform(matrix);
            this.pm.setPath(this.trimPathPath, false);
            float length = this.pm.getLength();
            if (endLength > totalLength && endLength - totalLength < currentLength + length && currentLength < endLength - totalLength) {
                if (startLength > totalLength) {
                    startValue2 = (startLength - totalLength) / length;
                } else {
                    startValue2 = 0.0f;
                }
                Utils.applyTrimPathIfNeeded(this.trimPathPath, startValue2, Math.min((endLength - totalLength) / length, 1.0f), 0.0f);
                canvas2.drawPath(this.trimPathPath, this.paint);
            } else if (currentLength + length >= startLength && currentLength <= endLength) {
                if (currentLength + length > endLength || startLength >= currentLength) {
                    if (startLength < currentLength) {
                        startValue = 0.0f;
                    } else {
                        startValue = (startLength - currentLength) / length;
                    }
                    if (endLength > currentLength + length) {
                        endValue = 1.0f;
                    } else {
                        endValue = (endLength - currentLength) / length;
                    }
                    Utils.applyTrimPathIfNeeded(this.trimPathPath, startValue, endValue, 0.0f);
                    canvas2.drawPath(this.trimPathPath, this.paint);
                } else {
                    canvas2.drawPath(this.trimPathPath, this.paint);
                }
            }
            currentLength += length;
        }
        L.endSection("StrokeContent#applyTrimPath");
    }

    public void getBounds(RectF outBounds, Matrix parentMatrix, boolean applyParents) {
        L.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i2 = 0; i2 < this.pathGroups.size(); i2++) {
            PathGroup pathGroup = this.pathGroups.get(i2);
            for (int j2 = 0; j2 < pathGroup.paths.size(); j2++) {
                this.path.addPath(((PathContent) pathGroup.paths.get(j2)).getPath(), parentMatrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float width = ((FloatKeyframeAnimation) this.widthAnimation).getFloatValue();
        RectF rectF = this.rect;
        rectF.set(rectF.left - (width / 2.0f), this.rect.top - (width / 2.0f), this.rect.right + (width / 2.0f), this.rect.bottom + (width / 2.0f));
        outBounds.set(this.rect);
        outBounds.set(outBounds.left - 1.0f, outBounds.top - 1.0f, outBounds.right + 1.0f, outBounds.bottom + 1.0f);
        L.endSection("StrokeContent#getBounds");
    }

    private void applyDashPatternIfNeeded(Matrix parentMatrix) {
        L.beginSection("StrokeContent#applyDashPattern");
        if (this.dashPatternAnimations.isEmpty()) {
            L.endSection("StrokeContent#applyDashPattern");
            return;
        }
        float scale = Utils.getScale(parentMatrix);
        for (int i2 = 0; i2 < this.dashPatternAnimations.size(); i2++) {
            this.dashPatternValues[i2] = ((Float) this.dashPatternAnimations.get(i2).getValue()).floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.dashPatternValues;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.dashPatternValues;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.dashPatternValues;
            fArr3[i2] = fArr3[i2] * scale;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.dashPatternOffsetAnimation;
        this.paint.setPathEffect(new DashPathEffect(this.dashPatternValues, baseKeyframeAnimation == null ? 0.0f : baseKeyframeAnimation.getValue().floatValue() * scale));
        L.endSection("StrokeContent#applyDashPattern");
    }

    public void resolveKeyPath(KeyPath keyPath, int depth, List<KeyPath> accumulator, KeyPath currentPartialKeyPath) {
        MiscUtils.resolveKeyPath(keyPath, depth, accumulator, currentPartialKeyPath, this);
    }

    public <T> void addValueCallback(T property, LottieValueCallback<T> callback) {
        if (property == LottieProperty.OPACITY) {
            this.opacityAnimation.setValueCallback(callback);
        } else if (property == LottieProperty.STROKE_WIDTH) {
            this.widthAnimation.setValueCallback(callback);
        } else if (property == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
            if (baseKeyframeAnimation != null) {
                this.layer.removeAnimation(baseKeyframeAnimation);
            }
            if (callback == null) {
                this.colorFilterAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(callback);
            this.colorFilterAnimation = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.layer.addAnimation(this.colorFilterAnimation);
        }
    }

    private static final class PathGroup {
        /* access modifiers changed from: private */
        public final List<PathContent> paths;
        /* access modifiers changed from: private */
        public final TrimPathContent trimPath;

        private PathGroup(TrimPathContent trimPath2) {
            this.paths = new ArrayList();
            this.trimPath = trimPath2;
        }
    }
}
