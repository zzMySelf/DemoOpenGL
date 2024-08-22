package com.baidu.chatsearch.aicall.animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010%\u001a\u00020&H\u0007J\u0006\u0010'\u001a\u00020&J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0014J\u0012\u0010+\u001a\u00020&2\b\b\u0001\u0010,\u001a\u00020\u0007H\u0007J\u0012\u0010-\u001a\u00020&2\b\b\u0001\u0010.\u001a\u00020\u0007H\u0007J\u0010\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020\u0015H\u0002R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\nj\b\u0012\u0004\u0012\u00020\u0007`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\nj\b\u0012\u0004\u0012\u00020\r`\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\nj\b\u0012\u0004\u0012\u00020\u000f`\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00150\nj\b\u0012\u0004\u0012\u00020\u0015`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00070\nj\b\u0012\u0004\u0012\u00020\u0007`\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R*\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00150\nj\b\u0012\u0004\u0012\u00020\u0015`\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/baidu/chatsearch/aicall/animation/VoiceWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "baseHeight", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "canDoAnim", "", "countDownTask", "Ljava/lang/Runnable;", "countDownTaskStart", "currentBaseHeight", "delayTime1", "hasUseData", "heightQueue", "", "indexArray", "isStopAnim", "maxHeight", "minHeight", "rectAnim", "Landroid/animation/ValueAnimator;", "rectNumberPerGroup", "rectPaint", "Landroid/graphics/Paint;", "rectPerGroupHeightWeight", "getRectPerGroupHeightWeight", "()Ljava/util/ArrayList;", "setRectPerGroupHeightWeight", "(Ljava/util/ArrayList;)V", "rectSpace", "cancelAnimator", "", "initParam", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setVoiceLinesColor", "color", "setVolume", "currentVolume", "updateHeight", "originHeight", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VoiceWaveView.kt */
public final class VoiceWaveView extends View {
    public Map<Integer, View> _$_findViewCache;
    private final ArrayList<Integer> baseHeight;
    private volatile ArrayList<Boolean> canDoAnim;
    private final ArrayList<Runnable> countDownTask;
    private boolean countDownTaskStart;
    private int currentBaseHeight;
    private final int delayTime1;
    private boolean hasUseData;
    private final ArrayList<Float> heightQueue;
    private final ArrayList<Integer> indexArray;
    private boolean isStopAnim;
    private final int maxHeight;
    private final int minHeight;
    private ValueAnimator rectAnim;
    private final int rectNumberPerGroup;
    private final Paint rectPaint;
    private ArrayList<Float> rectPerGroupHeightWeight;
    private final int rectSpace;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VoiceWaveView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VoiceWaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceWaveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.rectNumberPerGroup = 4;
        this.rectSpace = ViewExKt.getDp(4.0f);
        Float valueOf = Float.valueOf(0.8f);
        Float valueOf2 = Float.valueOf(1.3f);
        this.rectPerGroupHeightWeight = CollectionsKt.arrayListOf(valueOf, valueOf2, valueOf2, valueOf);
        this.delayTime1 = 50;
        int dp = ViewExKt.getDp(4);
        this.minHeight = dp;
        this.maxHeight = ViewExKt.getDp(20);
        this.baseHeight = CollectionsKt.arrayListOf(Integer.valueOf(dp), Integer.valueOf(dp), Integer.valueOf(dp), Integer.valueOf(dp));
        this.countDownTask = CollectionsKt.arrayListOf(new VoiceWaveView$$ExternalSyntheticLambda0(this), new VoiceWaveView$$ExternalSyntheticLambda1(this));
        this.currentBaseHeight = dp;
        this.hasUseData = true;
        this.heightQueue = new ArrayList<>();
        this.indexArray = CollectionsKt.arrayListOf(-1, -1, -1, -1);
        this.canDoAnim = CollectionsKt.arrayListOf(false, false, false, false);
        Paint paint = new Paint();
        Paint $this$rectPaint_u24lambda_u2d2 = paint;
        $this$rectPaint_u24lambda_u2d2.setColor(-16776961);
        $this$rectPaint_u24lambda_u2d2.setAntiAlias(true);
        this.rectPaint = paint;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VoiceWaveView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final ArrayList<Float> getRectPerGroupHeightWeight() {
        return this.rectPerGroupHeightWeight;
    }

    public final void setRectPerGroupHeightWeight(ArrayList<Float> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.rectPerGroupHeightWeight = arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: countDownTask$lambda-0  reason: not valid java name */
    public static final void m13023countDownTask$lambda0(VoiceWaveView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canDoAnim.set(1, Boolean.valueOf(this$0.countDownTaskStart));
    }

    /* access modifiers changed from: private */
    /* renamed from: countDownTask$lambda-1  reason: not valid java name */
    public static final void m13024countDownTask$lambda1(VoiceWaveView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canDoAnim.set(2, Boolean.valueOf(this$0.countDownTaskStart));
    }

    public final void initParam() {
        int size = this.indexArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.indexArray.set(i2, -1);
            this.canDoAnim.set(i2, false);
        }
    }

    public final void setVoiceLinesColor(int color) {
        this.rectPaint.setColor(color);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float drawHeight;
        Canvas canvas2 = canvas;
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        super.onDraw(canvas);
        try {
            Result.Companion companion = Result.Companion;
            canvas.save();
            this.baseHeight.clear();
            canvas2.translate(((float) (getWidth() - (this.rectNumberPerGroup * (this.rectSpace + this.minHeight)))) / 2.0f, ((float) getHeight()) / 2.0f);
            int i2 = this.rectNumberPerGroup;
            for (int i3 = 0; i3 < i2; i3++) {
                Boolean bool = this.canDoAnim.get(i3);
                Intrinsics.checkNotNullExpressionValue(bool, "canDoAnim[i]");
                if (bool.booleanValue()) {
                    if (i3 != 0) {
                        ArrayList<Integer> arrayList = this.indexArray;
                        int intValue = (arrayList.get(i3).intValue() + 1) % 500;
                        arrayList.set(i3, Integer.valueOf(intValue + ((((intValue ^ 500) & ((-intValue) | intValue)) >> 31) & 500)));
                    }
                    ArrayList<Integer> arrayList2 = this.baseHeight;
                    ArrayList<Float> arrayList3 = this.heightQueue;
                    Integer num = this.indexArray.get(i3);
                    Intrinsics.checkNotNullExpressionValue(num, "indexArray[i]");
                    arrayList2.add(Integer.valueOf((int) arrayList3.get(num.intValue()).floatValue()));
                } else {
                    this.baseHeight.add(Integer.valueOf(this.minHeight));
                }
            }
            Integer num2 = this.baseHeight.get(0);
            Intrinsics.checkNotNullExpressionValue(num2, "baseHeight[0]");
            this.currentBaseHeight = num2.intValue();
            int i4 = this.rectNumberPerGroup;
            for (int j2 = 0; j2 < i4; j2++) {
                float floatValue = this.baseHeight.get(j2).floatValue();
                Float f2 = this.rectPerGroupHeightWeight.get(j2);
                Intrinsics.checkNotNullExpressionValue(f2, "rectPerGroupHeightWeight[j]");
                float drawHeight2 = Math.max(floatValue * f2.floatValue(), (float) this.minHeight);
                if (this.isStopAnim) {
                    drawHeight = (float) this.minHeight;
                } else {
                    drawHeight = drawHeight2;
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    float f3 = (float) 2;
                    int i5 = this.minHeight;
                    canvas.drawRoundRect(0.0f, (-drawHeight) / f3, (float) i5, drawHeight / f3, (float) i5, (float) i5, this.rectPaint);
                }
                canvas2.translate(((float) this.rectSpace) + ((float) this.minHeight), 0.0f);
            }
            canvas.restore();
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        this.hasUseData = true;
    }

    private final void updateHeight(float originHeight) {
        ArrayList<Integer> arrayList = this.indexArray;
        int intValue = (arrayList.get(0).intValue() + 1) % 500;
        arrayList.set(0, Integer.valueOf(intValue + ((((intValue ^ 500) & ((-intValue) | intValue)) >> 31) & 500)));
        Integer num = this.indexArray.get(0);
        Intrinsics.checkNotNullExpressionValue(num, "indexArray[0]");
        if (num.intValue() <= this.heightQueue.size()) {
            ArrayList<Float> arrayList2 = this.heightQueue;
            Integer num2 = this.indexArray.get(0);
            Intrinsics.checkNotNullExpressionValue(num2, "indexArray[0]");
            arrayList2.add(num2.intValue(), Float.valueOf(originHeight));
        }
        invalidate();
    }

    public final void setVolume(int currentVolume) {
        if (((long) currentVolume) <= 100 && currentVolume >= 0) {
            this.isStopAnim = false;
            ValueAnimator valueAnimator = this.rectAnim;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            int i2 = this.maxHeight;
            int i3 = this.minHeight;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) this.currentBaseHeight, (((float) (i2 - i3)) * 0.01f * ((float) (currentVolume + 10))) + ((float) i3), (float) i3});
            ValueAnimator $this$setVolume_u24lambda_u2d6 = ofFloat;
            $this$setVolume_u24lambda_u2d6.setDuration(400);
            $this$setVolume_u24lambda_u2d6.addUpdateListener(new VoiceWaveView$$ExternalSyntheticLambda2(this));
            this.rectAnim = ofFloat;
            if (!this.countDownTaskStart) {
                this.countDownTaskStart = true;
                this.canDoAnim.set(0, Boolean.valueOf(this.countDownTaskStart));
                this.canDoAnim.set(3, Boolean.valueOf(this.countDownTaskStart));
                postDelayed(this.countDownTask.get(0), 50);
                postDelayed(this.countDownTask.get(1), 130);
            }
            ValueAnimator valueAnimator2 = this.rectAnim;
            if (valueAnimator2 != null) {
                valueAnimator2.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setVolume$lambda-6$lambda-5  reason: not valid java name */
    public static final void m13025setVolume$lambda6$lambda5(VoiceWaveView this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        UiThreadUtils.runOnUiThread(new VoiceWaveView$$ExternalSyntheticLambda3(this$0, it));
    }

    /* access modifiers changed from: private */
    /* renamed from: setVolume$lambda-6$lambda-5$lambda-4  reason: not valid java name */
    public static final void m13026setVolume$lambda6$lambda5$lambda4(VoiceWaveView this$0, ValueAnimator $it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($it, "$it");
        if (this$0.hasUseData) {
            this$0.hasUseData = false;
            Object animatedValue = $it.getAnimatedValue();
            Float f2 = animatedValue instanceof Float ? (Float) animatedValue : null;
            this$0.updateHeight(f2 != null ? f2.floatValue() : (float) this$0.minHeight);
        }
    }

    public final void cancelAnimator() {
        ValueAnimator valueAnimator = this.rectAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.countDownTaskStart = false;
        this.currentBaseHeight = this.minHeight;
        this.hasUseData = true;
        try {
            Result.Companion companion = Result.Companion;
            int size = this.countDownTask.size();
            for (int i2 = 0; i2 < size; i2++) {
                removeCallbacks(this.countDownTask.get(i2));
            }
            int i3 = this.rectNumberPerGroup;
            for (int i4 = 0; i4 < i3; i4++) {
                this.canDoAnim.set(i4, false);
                this.baseHeight.set(i4, Integer.valueOf(this.minHeight));
                this.indexArray.set(i4, -1);
            }
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        this.heightQueue.clear();
        this.isStopAnim = true;
        postInvalidate();
    }
}
