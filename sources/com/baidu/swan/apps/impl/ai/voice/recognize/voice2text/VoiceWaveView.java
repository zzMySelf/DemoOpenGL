package com.baidu.swan.apps.impl.ai.voice.recognize.voice2text;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import com.baidu.swan.apps.util.SwanAppUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001-B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0014J\u000e\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(J\u0012\u0010)\u001a\u00020\"2\b\b\u0001\u0010*\u001a\u00020\u0007H\u0007J\u0010\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u0014H\u0002R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\nj\b\u0012\u0004\u0012\u00020\u0007`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\nj\b\u0012\u0004\u0012\u00020\r`\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\nj\b\u0012\u0004\u0012\u00020\u000f`\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\nj\b\u0012\u0004\u0012\u00020\u0014`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00070\nj\b\u0012\u0004\u0012\u00020\u0007`\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00140\nj\b\u0012\u0004\u0012\u00020\u0014`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00140\nj\b\u0012\u0004\u0012\u00020\u0014`\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/baidu/swan/apps/impl/ai/voice/recognize/voice2text/VoiceWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "baseHeight", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "canDoAnim", "", "countDownTask", "Ljava/lang/Runnable;", "countDownTaskStart", "currentBaseHeight", "hasUseData", "heightQueue", "", "indexArray", "isStopAnim", "lineColor", "maxHeight", "minHeight", "paintLine", "Landroid/graphics/Paint;", "rectHeightWeight", "rectPerGroupHeightWeight", "rectSpace", "valueAnimator", "Landroid/animation/ValueAnimator;", "cancelAnim", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setLineColor", "colorValue", "", "startAnim", "currentVolume", "updateHeight", "originHeight", "Companion", "lib-swan-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VoiceWaveView.kt */
public final class VoiceWaveView extends View {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long DELAY1 = 50;
    private static final long DELAY2 = 80;
    private static final long DURATION = 400;
    private static final float LINE_WIDTH = 2.0f;
    private static final int MAX_LENGTH = 500;
    private static final long MAX_VOLUME = 100;
    private static final String TAG = "VoiceWaveView";
    private static final int WAVE_GROUP_NUM = 8;
    private static final int WAVE_PER_GROUP_NUM = 4;
    public static final String WAVING_COLOR_BLUE = "#756DFF";
    public static final String WAVING_COLOR_RED = "#F85756";
    private final ArrayList<Integer> baseHeight;
    private volatile ArrayList<Boolean> canDoAnim;
    private final ArrayList<Runnable> countDownTask;
    private boolean countDownTaskStart;
    private int currentBaseHeight;
    private boolean hasUseData;
    private final ArrayList<Float> heightQueue;
    private final ArrayList<Integer> indexArray;
    private boolean isStopAnim;
    private int lineColor;
    private final int maxHeight;
    private final int minHeight;
    private Paint paintLine;
    private final ArrayList<Float> rectHeightWeight;
    private final ArrayList<Float> rectPerGroupHeightWeight;
    private final int rectSpace;
    private ValueAnimator valueAnimator;

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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VoiceWaveView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceWaveView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paintLine = new Paint();
        this.lineColor = Color.parseColor(WAVING_COLOR_BLUE);
        Float valueOf = Float.valueOf(2.0f);
        int dp2px = SwanAppUIUtils.dp2px(2.0f);
        this.minHeight = dp2px;
        this.maxHeight = SwanAppUIUtils.dp2px(16.0f);
        this.rectSpace = SwanAppUIUtils.dp2px(4.0f);
        Float valueOf2 = Float.valueOf(0.5f);
        Float valueOf3 = Float.valueOf(1.0f);
        Float valueOf4 = Float.valueOf(1.5f);
        this.rectHeightWeight = CollectionsKt.arrayListOf(valueOf2, valueOf3, valueOf4, valueOf, valueOf, valueOf4, valueOf3, valueOf2);
        this.rectPerGroupHeightWeight = CollectionsKt.arrayListOf(Float.valueOf(0.4f), Float.valueOf(0.8f), Float.valueOf(0.6f), valueOf3);
        this.baseHeight = CollectionsKt.arrayListOf(Integer.valueOf(dp2px), Integer.valueOf(dp2px), Integer.valueOf(dp2px), Integer.valueOf(dp2px), Integer.valueOf(dp2px), Integer.valueOf(dp2px), Integer.valueOf(dp2px), Integer.valueOf(dp2px));
        this.canDoAnim = CollectionsKt.arrayListOf(false, false, false, false, false, false, false, false);
        this.countDownTask = CollectionsKt.arrayListOf(new VoiceWaveView$$ExternalSyntheticLambda0(this), new VoiceWaveView$$ExternalSyntheticLambda1(this), new VoiceWaveView$$ExternalSyntheticLambda2(this), new VoiceWaveView$$ExternalSyntheticLambda3(this), new VoiceWaveView$$ExternalSyntheticLambda4(this), new VoiceWaveView$$ExternalSyntheticLambda5(this));
        this.currentBaseHeight = dp2px;
        this.hasUseData = true;
        this.heightQueue = new ArrayList<>();
        this.indexArray = CollectionsKt.arrayListOf(-1, -1, -1, -1, -1, -1, -1, -1);
        this.paintLine.setAntiAlias(true);
        this.paintLine.setStrokeWidth((float) SwanAppUIUtils.dp2px(2.0f));
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/swan/apps/impl/ai/voice/recognize/voice2text/VoiceWaveView$Companion;", "", "()V", "DELAY1", "", "DELAY2", "DURATION", "LINE_WIDTH", "", "MAX_LENGTH", "", "MAX_VOLUME", "TAG", "", "WAVE_GROUP_NUM", "WAVE_PER_GROUP_NUM", "WAVING_COLOR_BLUE", "WAVING_COLOR_RED", "lib-swan-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VoiceWaveView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: countDownTask$lambda-0  reason: not valid java name */
    public static final void m7990countDownTask$lambda0(VoiceWaveView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canDoAnim.set(1, Boolean.valueOf(this$0.countDownTaskStart));
    }

    /* access modifiers changed from: private */
    /* renamed from: countDownTask$lambda-1  reason: not valid java name */
    public static final void m7991countDownTask$lambda1(VoiceWaveView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canDoAnim.set(2, Boolean.valueOf(this$0.countDownTaskStart));
    }

    /* access modifiers changed from: private */
    /* renamed from: countDownTask$lambda-2  reason: not valid java name */
    public static final void m7992countDownTask$lambda2(VoiceWaveView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canDoAnim.set(3, Boolean.valueOf(this$0.countDownTaskStart));
    }

    /* access modifiers changed from: private */
    /* renamed from: countDownTask$lambda-3  reason: not valid java name */
    public static final void m7993countDownTask$lambda3(VoiceWaveView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canDoAnim.set(5, Boolean.valueOf(this$0.countDownTaskStart));
    }

    /* access modifiers changed from: private */
    /* renamed from: countDownTask$lambda-4  reason: not valid java name */
    public static final void m7994countDownTask$lambda4(VoiceWaveView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canDoAnim.set(6, Boolean.valueOf(this$0.countDownTaskStart));
    }

    /* access modifiers changed from: private */
    /* renamed from: countDownTask$lambda-5  reason: not valid java name */
    public static final void m7995countDownTask$lambda5(VoiceWaveView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canDoAnim.set(7, Boolean.valueOf(this$0.countDownTaskStart));
    }

    public final void cancelAnim() {
        ValueAnimator valueAnimator2 = this.valueAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.countDownTaskStart = false;
        this.currentBaseHeight = this.minHeight;
        this.hasUseData = true;
        try {
            Result.Companion companion = Result.Companion;
            for (int i2 = 0; i2 < 6; i2++) {
                removeCallbacks(this.countDownTask.get(i2));
            }
            for (int i3 = 0; i3 < 8; i3++) {
                this.canDoAnim.set(i3, false);
                this.baseHeight.set(i3, Integer.valueOf(this.minHeight));
                this.indexArray.set(i3, -1);
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

    public final void startAnim(int currentVolume) {
        if (SwanAppLibConfig.DEBUG) {
            Log.d(TAG, "setVolume: " + currentVolume);
        }
        if (((long) currentVolume) <= 100 && currentVolume >= 0) {
            this.isStopAnim = false;
            ValueAnimator valueAnimator2 = this.valueAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            int i2 = this.maxHeight;
            int i3 = this.minHeight;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) this.currentBaseHeight, (((float) (i2 - i3)) * 0.01f * ((float) (currentVolume + 10))) + ((float) i3), (float) i3});
            ValueAnimator $this$startAnim_u24lambda_u2d9 = ofFloat;
            $this$startAnim_u24lambda_u2d9.setDuration(400);
            $this$startAnim_u24lambda_u2d9.addUpdateListener(new VoiceWaveView$$ExternalSyntheticLambda6(this));
            this.valueAnimator = ofFloat;
            if (!this.countDownTaskStart) {
                this.countDownTaskStart = true;
                this.canDoAnim.set(0, Boolean.valueOf(this.countDownTaskStart));
                this.canDoAnim.set(4, Boolean.valueOf(this.countDownTaskStart));
                for (int i4 = 0; i4 < 3; i4++) {
                    postDelayed(this.countDownTask.get(i4), ((long) (i4 + 1)) * 50);
                }
                for (int i5 = 0; i5 < 3; i5++) {
                    postDelayed(this.countDownTask.get(i5 + 3), ((long) (i5 + 1)) * 80);
                }
            }
            ValueAnimator valueAnimator3 = this.valueAnimator;
            if (valueAnimator3 != null) {
                valueAnimator3.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startAnim$lambda-9$lambda-8  reason: not valid java name */
    public static final void m7996startAnim$lambda9$lambda8(VoiceWaveView this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        SwanAppUtils.runOnUiThread(new VoiceWaveView$$ExternalSyntheticLambda7(this$0, it));
    }

    /* access modifiers changed from: private */
    /* renamed from: startAnim$lambda-9$lambda-8$lambda-7  reason: not valid java name */
    public static final void m7997startAnim$lambda9$lambda8$lambda7(VoiceWaveView this$0, ValueAnimator $it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($it, "$it");
        if (this$0.hasUseData) {
            this$0.hasUseData = false;
            Object animatedValue = $it.getAnimatedValue();
            Float f2 = animatedValue instanceof Float ? (Float) animatedValue : null;
            this$0.updateHeight(f2 != null ? f2.floatValue() : (float) this$0.minHeight);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        int i3;
        String str;
        String str2;
        float drawHeight;
        float drawHeight2;
        Canvas canvas2 = canvas;
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        super.onDraw(canvas);
        try {
            Result.Companion companion = Result.Companion;
            canvas.save();
            this.baseHeight.clear();
            this.paintLine.setColor(this.lineColor);
            int width = getWidth();
            int i4 = this.rectSpace;
            canvas2.translate(((float) ((width - ((this.minHeight + i4) * 32)) - i4)) / 2.0f, ((float) getHeight()) / 2.0f);
            int i5 = 0;
            while (true) {
                i2 = 4;
                if (i5 >= 4) {
                    break;
                }
                Boolean bool = this.canDoAnim.get(i5);
                Intrinsics.checkNotNullExpressionValue(bool, "canDoAnim[i]");
                if (bool.booleanValue()) {
                    if (i5 != 0) {
                        ArrayList<Integer> arrayList = this.indexArray;
                        int intValue = (arrayList.get(i5).intValue() + 1) % 500;
                        arrayList.set(i5, Integer.valueOf(intValue + ((((intValue ^ 500) & ((-intValue) | intValue)) >> 31) & 500)));
                    }
                    ArrayList<Integer> arrayList2 = this.baseHeight;
                    ArrayList<Float> arrayList3 = this.heightQueue;
                    Integer num = this.indexArray.get(i5);
                    Intrinsics.checkNotNullExpressionValue(num, "indexArray[i]");
                    arrayList2.add(Integer.valueOf((int) arrayList3.get(num.intValue()).floatValue()));
                } else {
                    this.baseHeight.add(Integer.valueOf(this.minHeight));
                }
                i5++;
            }
            int i6 = 4;
            while (true) {
                if (i6 >= 8) {
                    break;
                }
                Boolean bool2 = this.canDoAnim.get(i6);
                Intrinsics.checkNotNullExpressionValue(bool2, "canDoAnim[i]");
                if (bool2.booleanValue()) {
                    if (i6 != 4) {
                        ArrayList<Integer> arrayList4 = this.indexArray;
                        int intValue2 = (arrayList4.get(i6).intValue() + 1) % 500;
                        arrayList4.set(i6, Integer.valueOf(intValue2 + ((((intValue2 ^ 500) & ((-intValue2) | intValue2)) >> 31) & 500)));
                    }
                    ArrayList<Integer> arrayList5 = this.baseHeight;
                    ArrayList<Float> arrayList6 = this.heightQueue;
                    Integer num2 = this.indexArray.get(i6);
                    Intrinsics.checkNotNullExpressionValue(num2, "indexArray[i]");
                    arrayList5.add(Integer.valueOf((int) arrayList6.get(num2.intValue()).floatValue()));
                } else {
                    this.baseHeight.add(Integer.valueOf(this.minHeight));
                }
                i6++;
            }
            Integer num3 = this.baseHeight.get(0);
            Intrinsics.checkNotNullExpressionValue(num3, "baseHeight[0]");
            this.currentBaseHeight = num3.intValue();
            int i7 = 0;
            while (true) {
                int i8 = 2;
                str = "rectPerGroupHeightWeight[j]";
                str2 = "rectHeightWeight[i]";
                if (i7 >= i2) {
                    break;
                }
                int j2 = 0;
                while (j2 < i2) {
                    float floatValue = this.baseHeight.get(j2).floatValue();
                    Float f2 = this.rectHeightWeight.get(i7);
                    Intrinsics.checkNotNullExpressionValue(f2, str2);
                    float floatValue2 = floatValue * f2.floatValue();
                    Float f3 = this.rectPerGroupHeightWeight.get(j2);
                    Intrinsics.checkNotNullExpressionValue(f3, str);
                    float drawHeight3 = Math.min(Math.max(floatValue2 * f3.floatValue(), (float) this.minHeight), (float) this.maxHeight);
                    if (this.isStopAnim) {
                        drawHeight2 = (float) this.minHeight;
                    } else {
                        drawHeight2 = drawHeight3;
                    }
                    float f4 = (float) i8;
                    int i9 = this.minHeight;
                    float f5 = (-drawHeight2) / f4;
                    float f6 = drawHeight2;
                    canvas.drawRoundRect(0.0f, f5, (float) i9, drawHeight2 / f4, (float) i9, (float) i9, this.paintLine);
                    canvas2.translate(((float) this.rectSpace) + ((float) this.minHeight), 0.0f);
                    j2++;
                    str = str;
                    str2 = str2;
                    i8 = 2;
                    i2 = 4;
                }
                int i10 = j2;
                i7++;
                i2 = 4;
            }
            String str3 = str2;
            String str4 = str;
            int i11 = 4;
            for (i3 = 8; i11 < i3; i3 = 8) {
                int j3 = 3;
                while (-1 < j3) {
                    float floatValue3 = this.baseHeight.get(j3 + 4).floatValue();
                    Float f7 = this.rectHeightWeight.get(i11);
                    String str5 = str3;
                    Intrinsics.checkNotNullExpressionValue(f7, str5);
                    float floatValue4 = floatValue3 * f7.floatValue();
                    Float f8 = this.rectPerGroupHeightWeight.get(j3);
                    Intrinsics.checkNotNullExpressionValue(f8, str4);
                    float drawHeight4 = Math.min(Math.max(floatValue4 * f8.floatValue(), (float) this.minHeight), (float) this.maxHeight);
                    if (this.isStopAnim) {
                        drawHeight = (float) this.minHeight;
                    } else {
                        drawHeight = drawHeight4;
                    }
                    float f9 = (float) 2;
                    int i12 = this.minHeight;
                    float f10 = drawHeight;
                    canvas.drawRoundRect(0.0f, (-drawHeight) / f9, (float) i12, drawHeight / f9, (float) i12, (float) i12, this.paintLine);
                    canvas2.translate(((float) this.rectSpace) + ((float) this.minHeight), 0.0f);
                    j3--;
                    str3 = str5;
                }
                String str6 = str3;
                i11++;
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
        ArrayList<Integer> arrayList2 = this.indexArray;
        int intValue2 = (arrayList2.get(4).intValue() + 1) % 500;
        arrayList2.set(4, Integer.valueOf(intValue2 + ((((intValue2 ^ 500) & ((-intValue2) | intValue2)) >> 31) & 500)));
        ArrayList<Float> arrayList3 = this.heightQueue;
        Integer num = this.indexArray.get(0);
        Intrinsics.checkNotNullExpressionValue(num, "indexArray[0]");
        arrayList3.add(num.intValue(), Float.valueOf(originHeight));
        invalidate();
    }

    public final void setLineColor(String colorValue) {
        Intrinsics.checkNotNullParameter(colorValue, "colorValue");
        this.lineColor = Color.parseColor(colorValue);
    }
}
