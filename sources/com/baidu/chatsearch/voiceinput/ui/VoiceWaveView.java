package com.baidu.chatsearch.voiceinput.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.chatsearch.voice_input.R;
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
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010%\u001a\u00020&H\u0007J\u0010\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0014J\u0006\u0010*\u001a\u00020&J\u0006\u0010+\u001a\u00020&J\u0012\u0010,\u001a\u00020&2\b\b\u0001\u0010-\u001a\u00020\u0007H\u0007J\u0010\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u0016H\u0002R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\nj\b\u0012\u0004\u0012\u00020\u0007`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\nj\b\u0012\u0004\u0012\u00020\r`\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\nj\b\u0012\u0004\u0012\u00020\u000f`\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00160\nj\b\u0012\u0004\u0012\u00020\u0016`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00070\nj\b\u0012\u0004\u0012\u00020\u0007`\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00160\nj\b\u0012\u0004\u0012\u00020\u0016`\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00160\nj\b\u0012\u0004\u0012\u00020\u0016`\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/baidu/chatsearch/voiceinput/ui/VoiceWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "baseHeight", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "canDoAnim", "", "countDownTask", "Ljava/lang/Runnable;", "countDownTaskStart", "currentBaseHeight", "delayTime1", "delayTime2", "hasUseData", "heightQueue", "", "indexArray", "isStopAnim", "maxHeight", "maxLength", "minHeight", "rectAnim", "Landroid/animation/ValueAnimator;", "rectGroupNumber", "rectHeightWeight", "rectNumberPerGroup", "rectPaint", "Landroid/graphics/Paint;", "rectPerGroupHeightWeight", "rectSpace", "cancelAnimator", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "resetColor", "setColorToError", "setVolume", "currentVolume", "updateHeight", "originHeight", "lib-chatsearch-voice-input_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VoiceWaveView.kt */
public final class VoiceWaveView extends View {
    public Map<Integer, View> _$_findViewCache;
    private final ArrayList<Integer> baseHeight;
    private volatile ArrayList<Boolean> canDoAnim;
    private final ArrayList<Runnable> countDownTask;
    private boolean countDownTaskStart;
    private int currentBaseHeight;
    private final int delayTime1;
    private final int delayTime2;
    private boolean hasUseData;
    private final ArrayList<Float> heightQueue;
    private final ArrayList<Integer> indexArray;
    private boolean isStopAnim;
    private final int maxHeight;
    private final int maxLength;
    private final int minHeight;
    private ValueAnimator rectAnim;
    private final int rectGroupNumber;
    private final ArrayList<Float> rectHeightWeight;
    private final int rectNumberPerGroup;
    private final Paint rectPaint;
    private final ArrayList<Float> rectPerGroupHeightWeight;
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
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.maxLength = 500;
        this.rectGroupNumber = 8;
        this.rectNumberPerGroup = 4;
        this.rectSpace = ViewExKt.getDp(4.0f);
        Float valueOf = Float.valueOf(0.5f);
        Float valueOf2 = Float.valueOf(1.0f);
        Float valueOf3 = Float.valueOf(1.5f);
        Float valueOf4 = Float.valueOf(2.0f);
        this.rectHeightWeight = CollectionsKt.arrayListOf(valueOf, valueOf2, valueOf3, valueOf4, valueOf4, valueOf3, valueOf2, valueOf);
        this.rectPerGroupHeightWeight = CollectionsKt.arrayListOf(Float.valueOf(0.4f), Float.valueOf(0.8f), Float.valueOf(0.6f), valueOf2);
        this.delayTime1 = 50;
        this.delayTime2 = 80;
        int dp = ViewExKt.getDp(2.0f);
        this.minHeight = dp;
        this.maxHeight = ViewExKt.getDp(16.0f);
        this.baseHeight = CollectionsKt.arrayListOf(Integer.valueOf(dp), Integer.valueOf(dp), Integer.valueOf(dp), Integer.valueOf(dp), Integer.valueOf(dp), Integer.valueOf(dp), Integer.valueOf(dp), Integer.valueOf(dp));
        this.countDownTask = CollectionsKt.arrayListOf(new VoiceWaveView$$ExternalSyntheticLambda2(this), new VoiceWaveView$$ExternalSyntheticLambda3(this), new VoiceWaveView$$ExternalSyntheticLambda4(this), new VoiceWaveView$$ExternalSyntheticLambda5(this), new VoiceWaveView$$ExternalSyntheticLambda6(this), new VoiceWaveView$$ExternalSyntheticLambda7(this));
        this.currentBaseHeight = dp;
        this.hasUseData = true;
        this.heightQueue = new ArrayList<>();
        this.indexArray = CollectionsKt.arrayListOf(-1, -1, -1, -1, -1, -1, -1, -1);
        this.canDoAnim = CollectionsKt.arrayListOf(false, false, false, false, false, false, false, false);
        setBackgroundResource(R.drawable.voice_wave_background);
        Paint paint = new Paint();
        Paint $this$rectPaint_u24lambda_u2d6 = paint;
        $this$rectPaint_u24lambda_u2d6.setColor(ContextCompat.getColor(context2, R.color.voice_wave_new_color));
        $this$rectPaint_u24lambda_u2d6.setAntiAlias(true);
        this.rectPaint = paint;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VoiceWaveView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: countDownTask$lambda-0  reason: not valid java name */
    public static final void m13251countDownTask$lambda0(VoiceWaveView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canDoAnim.set(1, Boolean.valueOf(this$0.countDownTaskStart));
    }

    /* access modifiers changed from: private */
    /* renamed from: countDownTask$lambda-1  reason: not valid java name */
    public static final void m13252countDownTask$lambda1(VoiceWaveView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canDoAnim.set(2, Boolean.valueOf(this$0.countDownTaskStart));
    }

    /* access modifiers changed from: private */
    /* renamed from: countDownTask$lambda-2  reason: not valid java name */
    public static final void m13253countDownTask$lambda2(VoiceWaveView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canDoAnim.set(3, Boolean.valueOf(this$0.countDownTaskStart));
    }

    /* access modifiers changed from: private */
    /* renamed from: countDownTask$lambda-3  reason: not valid java name */
    public static final void m13254countDownTask$lambda3(VoiceWaveView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canDoAnim.set(5, Boolean.valueOf(this$0.countDownTaskStart));
    }

    /* access modifiers changed from: private */
    /* renamed from: countDownTask$lambda-4  reason: not valid java name */
    public static final void m13255countDownTask$lambda4(VoiceWaveView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canDoAnim.set(6, Boolean.valueOf(this$0.countDownTaskStart));
    }

    /* access modifiers changed from: private */
    /* renamed from: countDownTask$lambda-5  reason: not valid java name */
    public static final void m13256countDownTask$lambda5(VoiceWaveView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canDoAnim.set(7, Boolean.valueOf(this$0.countDownTaskStart));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean z;
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
            int width = getWidth();
            int i2 = this.rectGroupNumber * this.rectNumberPerGroup;
            int i3 = this.rectSpace;
            canvas2.translate(((float) ((width - (i2 * (this.minHeight + i3))) - i3)) / 2.0f, ((float) getHeight()) / 2.0f);
            int i4 = this.rectNumberPerGroup;
            for (int i5 = 0; i5 < i4; i5++) {
                Boolean bool = this.canDoAnim.get(i5);
                Intrinsics.checkNotNullExpressionValue(bool, "canDoAnim[i]");
                if (bool.booleanValue()) {
                    if (i5 != 0) {
                        ArrayList<Integer> arrayList = this.indexArray;
                        int i6 = this.maxLength;
                        int intValue = (arrayList.get(i5).intValue() + 1) % i6;
                        arrayList.set(i5, Integer.valueOf(intValue + (i6 & (((intValue ^ i6) & ((-intValue) | intValue)) >> 31))));
                    }
                    ArrayList<Integer> arrayList2 = this.baseHeight;
                    ArrayList<Float> arrayList3 = this.heightQueue;
                    Integer num = this.indexArray.get(i5);
                    Intrinsics.checkNotNullExpressionValue(num, "indexArray[i]");
                    arrayList2.add(Integer.valueOf((int) arrayList3.get(num.intValue()).floatValue()));
                } else {
                    this.baseHeight.add(Integer.valueOf(this.minHeight));
                }
            }
            int i7 = this.rectNumberPerGroup;
            int j2 = 2;
            int i8 = i7 * 2;
            for (int i9 = i7; i9 < i8; i9++) {
                Boolean bool2 = this.canDoAnim.get(i9);
                Intrinsics.checkNotNullExpressionValue(bool2, "canDoAnim[i]");
                if (bool2.booleanValue()) {
                    if (i9 != this.rectNumberPerGroup) {
                        ArrayList<Integer> arrayList4 = this.indexArray;
                        int i10 = this.maxLength;
                        int intValue2 = (arrayList4.get(i9).intValue() + 1) % i10;
                        arrayList4.set(i9, Integer.valueOf(intValue2 + (i10 & (((intValue2 ^ i10) & ((-intValue2) | intValue2)) >> 31))));
                    }
                    ArrayList<Integer> arrayList5 = this.baseHeight;
                    ArrayList<Float> arrayList6 = this.heightQueue;
                    Integer num2 = this.indexArray.get(i9);
                    Intrinsics.checkNotNullExpressionValue(num2, "indexArray[i]");
                    arrayList5.add(Integer.valueOf((int) arrayList6.get(num2.intValue()).floatValue()));
                } else {
                    this.baseHeight.add(Integer.valueOf(this.minHeight));
                }
            }
            Integer num3 = this.baseHeight.get(0);
            Intrinsics.checkNotNullExpressionValue(num3, "baseHeight[0]");
            this.currentBaseHeight = num3.intValue();
            int i11 = this.rectGroupNumber / 2;
            int i12 = 0;
            while (true) {
                z = false;
                str = "rectPerGroupHeightWeight[j]";
                str2 = "rectHeightWeight[i]";
                if (i12 >= i11) {
                    break;
                }
                int i13 = this.rectNumberPerGroup;
                int j3 = 0;
                while (j3 < i13) {
                    float floatValue = this.baseHeight.get(j3).floatValue();
                    Float f2 = this.rectHeightWeight.get(i12);
                    Intrinsics.checkNotNullExpressionValue(f2, str2);
                    float floatValue2 = floatValue * f2.floatValue();
                    Float f3 = this.rectPerGroupHeightWeight.get(j3);
                    Intrinsics.checkNotNullExpressionValue(f3, str);
                    float drawHeight3 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(floatValue2 * f3.floatValue(), (float) this.minHeight), (float) this.maxHeight);
                    if (this.isStopAnim) {
                        drawHeight2 = (float) this.minHeight;
                    } else {
                        drawHeight2 = drawHeight3;
                    }
                    float f4 = (float) j2;
                    int i14 = this.minHeight;
                    float f5 = drawHeight2 / f4;
                    float f6 = (-drawHeight2) / f4;
                    float f7 = drawHeight2;
                    float drawHeight4 = (float) i14;
                    int j4 = j3;
                    float f8 = f5;
                    canvas.drawRoundRect(0.0f, f6, drawHeight4, f8, (float) i14, (float) i14, this.rectPaint);
                    canvas2.translate(((float) this.rectSpace) + ((float) this.minHeight), 0.0f);
                    j3 = j4 + 1;
                    i13 = i13;
                    str2 = str2;
                    str = str;
                    j2 = 2;
                }
                int i15 = j3;
                i12++;
                j2 = 2;
            }
            String str3 = str2;
            String str4 = str;
            int i16 = this.rectGroupNumber;
            for (int i17 = i16 / 2; i17 < i16; i17++) {
                int j5 = this.rectNumberPerGroup - 1;
                while (-1 < j5) {
                    float floatValue3 = this.baseHeight.get(this.rectNumberPerGroup + j5).floatValue();
                    Float f9 = this.rectHeightWeight.get(i17);
                    String str5 = str3;
                    Intrinsics.checkNotNullExpressionValue(f9, str5);
                    float floatValue4 = floatValue3 * f9.floatValue();
                    Float f10 = this.rectPerGroupHeightWeight.get(j5);
                    String str6 = str4;
                    Intrinsics.checkNotNullExpressionValue(f10, str6);
                    float drawHeight5 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(floatValue4 * f10.floatValue(), (float) this.minHeight), (float) this.maxHeight);
                    if (this.isStopAnim) {
                        drawHeight = (float) this.minHeight;
                    } else {
                        drawHeight = drawHeight5;
                    }
                    float f11 = (float) 2;
                    int i18 = this.minHeight;
                    float f12 = drawHeight;
                    canvas.drawRoundRect(0.0f, (-drawHeight) / f11, (float) i18, drawHeight / f11, (float) i18, (float) i18, this.rectPaint);
                    canvas2.translate(((float) this.rectSpace) + ((float) this.minHeight), 0.0f);
                    j5--;
                    z = false;
                    str3 = str5;
                    str4 = str6;
                }
                boolean z2 = z;
                String str7 = str3;
                String str8 = str4;
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
        try {
            Result.Companion companion = Result.Companion;
            ArrayList<Integer> arrayList = this.indexArray;
            int i2 = this.maxLength;
            int intValue = (arrayList.get(0).intValue() + 1) % i2;
            arrayList.set(0, Integer.valueOf(intValue + (i2 & (((intValue ^ i2) & ((-intValue) | intValue)) >> 31))));
            ArrayList<Integer> arrayList2 = this.indexArray;
            int i3 = this.rectNumberPerGroup;
            int i4 = this.maxLength;
            int intValue2 = (arrayList2.get(i3).intValue() + 1) % i4;
            arrayList2.set(i3, Integer.valueOf(intValue2 + (i4 & (((intValue2 ^ i4) & ((-intValue2) | intValue2)) >> 31))));
            Integer num = this.indexArray.get(0);
            Intrinsics.checkNotNullExpressionValue(num, "indexArray[0]");
            if (num.intValue() <= this.heightQueue.size()) {
                ArrayList<Float> arrayList3 = this.heightQueue;
                Integer num2 = this.indexArray.get(0);
                Intrinsics.checkNotNullExpressionValue(num2, "indexArray[0]");
                arrayList3.add(num2.intValue(), Float.valueOf(originHeight));
            }
            invalidate();
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
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
            ValueAnimator $this$setVolume_u24lambda_u2d11 = ofFloat;
            $this$setVolume_u24lambda_u2d11.setDuration(400);
            $this$setVolume_u24lambda_u2d11.addUpdateListener(new VoiceWaveView$$ExternalSyntheticLambda1(this));
            this.rectAnim = ofFloat;
            if (!this.countDownTaskStart) {
                this.countDownTaskStart = true;
                this.canDoAnim.set(0, Boolean.valueOf(this.countDownTaskStart));
                this.canDoAnim.set(this.rectNumberPerGroup, Boolean.valueOf(this.countDownTaskStart));
                int i4 = this.rectNumberPerGroup - 1;
                for (int i5 = 0; i5 < i4; i5++) {
                    postDelayed(this.countDownTask.get(i5), (long) ((i5 + 1) * this.delayTime1));
                }
                int i6 = this.rectNumberPerGroup - 1;
                for (int i7 = 0; i7 < i6; i7++) {
                    postDelayed(this.countDownTask.get(i7 + 3), (long) ((i7 + 1) * this.delayTime2));
                }
            }
            ValueAnimator valueAnimator2 = this.rectAnim;
            if (valueAnimator2 != null) {
                valueAnimator2.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setVolume$lambda-11$lambda-10  reason: not valid java name */
    public static final void m13257setVolume$lambda11$lambda10(VoiceWaveView this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        UiThreadUtils.runOnUiThread(new VoiceWaveView$$ExternalSyntheticLambda0(this$0, it));
    }

    /* access modifiers changed from: private */
    /* renamed from: setVolume$lambda-11$lambda-10$lambda-9  reason: not valid java name */
    public static final void m13258setVolume$lambda11$lambda10$lambda9(VoiceWaveView this$0, ValueAnimator $it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($it, "$it");
        if (this$0.hasUseData) {
            this$0.hasUseData = false;
            Object animatedValue = $it.getAnimatedValue();
            Float f2 = animatedValue instanceof Float ? (Float) animatedValue : null;
            this$0.updateHeight(f2 != null ? f2.floatValue() : (float) this$0.minHeight);
        }
    }

    public final void setColorToError() {
        setBackgroundResource(R.drawable.voice_wave_background_error);
        this.rectPaint.setColor(ContextCompat.getColor(getContext(), R.color.voice_wave_new_color_error));
    }

    public final void resetColor() {
        setBackgroundResource(R.drawable.voice_wave_background);
        this.rectPaint.setColor(ContextCompat.getColor(getContext(), R.color.voice_wave_new_color));
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
            int i2 = (this.rectNumberPerGroup - 1) * 2;
            for (int i3 = 0; i3 < i2; i3++) {
                removeCallbacks(this.countDownTask.get(i3));
            }
            int i4 = this.rectNumberPerGroup * 2;
            for (int i5 = 0; i5 < i4; i5++) {
                this.canDoAnim.set(i5, false);
                this.baseHeight.set(i5, Integer.valueOf(this.minHeight));
                this.indexArray.set(i5, -1);
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
