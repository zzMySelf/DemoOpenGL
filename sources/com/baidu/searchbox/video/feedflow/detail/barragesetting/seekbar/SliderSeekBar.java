package com.baidu.searchbox.video.feedflow.detail.barragesetting.seekbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.barragesetting.seekbar.OnSliderSeekBarChangeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001:\u0002VWB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0011\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020$H\u0002J'\u0010*\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00072\u0010\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u00010,H\u0002¢\u0006\u0002\u0010.J \u0010/\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u00100\u001a\u00020\u0007H\u0002J\u0018\u00101\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002J\u0010\u00102\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0002J\u0018\u00103\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002J\u0010\u00104\u001a\u00020$2\u0006\u00105\u001a\u000206H\u0014J\u0018\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007H\u0014J(\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0014J\u0010\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020AH\u0017J\u0018\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u0007H\u0014J\b\u0010E\u001a\u00020$H\u0002J\u0006\u0010F\u001a\u00020$J\b\u0010G\u001a\u00020$H\u0002J\u0010\u0010H\u001a\u00020$2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\"\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020\u00072\b\b\u0002\u0010K\u001a\u00020\u00122\b\b\u0002\u0010L\u001a\u00020\u0012J'\u0010M\u001a\u00020$2\u0006\u0010 \u001a\u00020\u00072\u0012\b\u0002\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u00010,¢\u0006\u0002\u0010NJ\u000e\u0010\u001b\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u0012J\u0018\u0010O\u001a\u00020$2\u0006\u0010P\u001a\u00020'2\u0006\u0010Q\u001a\u00020'H\u0002J\b\u0010R\u001a\u00020$H\u0002J\u0006\u0010S\u001a\u00020$J\u0006\u0010T\u001a\u00020$J\u0006\u0010U\u001a\u00020$J\u000e\u0010#\u001a\u00020$2\u0006\u0010#\u001a\u00020\u0012R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0018\u00010\fR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0012@BX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/barragesetting/seekbar/SliderSeekBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "bar", "Lcom/baidu/searchbox/video/feedflow/detail/barragesetting/seekbar/SliderSeekBar$Bar;", "<set-?>", "currentIndex", "getCurrentIndex", "()I", "disableSlide", "", "indexPressed", "isAnimationRunning", "()Z", "isSupportPressInTouchBlank", "listener", "Lcom/baidu/searchbox/video/feedflow/detail/barragesetting/seekbar/OnSliderSeekBarChangeListener;", "otherAttrs", "Landroid/os/Bundle;", "showTicksAndTexts", "styleImpl", "Lcom/baidu/searchbox/video/feedflow/detail/barragesetting/seekbar/BarrageSettingSliderSeekSeekBarStyle;", "thumb", "Lcom/baidu/searchbox/video/feedflow/detail/barragesetting/seekbar/SliderSeekBar$Thumb;", "tickCount", "typedArray", "Landroid/content/res/TypedArray;", "withAnimation", "", "getTickIndex", "x", "", "y", "init", "isValidTickCount", "textArray", "", "", "(I[Ljava/lang/String;)Z", "isWithinTick", "i", "onActionDown", "onActionMove", "onActionUp", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onVisibilityChanged", "changedView", "visibility", "pressThumb", "refresh", "releaseThumb", "setOnSliderBarChangeListener", "setThumbIndex", "index", "isChangedByUser", "isReset", "setTickCount", "(I[Ljava/lang/String;)V", "startAnimation", "start", "end", "stopAnimation", "updateFontSize", "updateLandscapeSkin", "updateSkin", "Bar", "Thumb", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SliderSeekBar.kt */
public final class SliderSeekBar extends View {
    private ValueAnimator animator;
    private Bar bar;
    private int currentIndex;
    private boolean disableSlide;
    private int indexPressed;
    private boolean isSupportPressInTouchBlank;
    private OnSliderSeekBarChangeListener listener;
    private final Bundle otherAttrs;
    /* access modifiers changed from: private */
    public boolean showTicksAndTexts;
    /* access modifiers changed from: private */
    public BarrageSettingSliderSeekSeekBarStyle styleImpl;
    private Thumb thumb;
    private int tickCount;
    private TypedArray typedArray;
    private boolean withAnimation;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SliderSeekBar(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SliderSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SliderSeekBar(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.tickCount = 4;
        this.indexPressed = -1;
        this.showTicksAndTexts = true;
        this.styleImpl = new BarrageSettingSliderSeekSeekBarStyle();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.SliderSeekBar);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr….styleable.SliderSeekBar)");
        this.typedArray = obtainStyledAttributes;
        this.otherAttrs = new Bundle();
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    private final void init() {
        this.styleImpl.setParent(this);
        this.styleImpl.setOtherAttrs(this.otherAttrs);
        this.styleImpl.init();
        this.bar = new Bar(this.styleImpl.getXCoordinate(), this.styleImpl.getBarBgLength() + this.styleImpl.getXCoordinate());
        this.thumb = new Thumb(this.styleImpl.getXCoordinate() + (this.styleImpl.getTickDistance() * ((float) this.currentIndex)), this.styleImpl.getYCoordinate());
    }

    public final void disableSlide(boolean disableSlide2) {
        this.disableSlide = disableSlide2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width;
        int height;
        int measureWidthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int measureWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        if (measureWidthMode == 1073741824) {
            width = measureWidth;
        } else {
            width = this.styleImpl.getDefWidth();
            if (measureWidthMode == Integer.MIN_VALUE) {
                width = Math.min(measureWidth, width);
            }
        }
        int measureHeightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int measureHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        if (measureHeightMode == 1073741824) {
            height = measureHeight;
        } else {
            int height2 = this.styleImpl.getMinHeight();
            if (measureHeightMode == Integer.MIN_VALUE) {
                height = Math.min(measureHeight, height2);
            } else {
                height = height2;
            }
        }
        setMeasuredDimension(width, height);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        init();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Bar bar2 = this.bar;
        if (bar2 != null) {
            bar2.draw(canvas);
        }
        Thumb thumb2 = this.thumb;
        if (thumb2 != null) {
            thumb2.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility != 0) {
            stopAnimation();
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isEnabled() || isAnimationRunning()) {
            return false;
        }
        switch (event.getAction()) {
            case 0:
                return onActionDown(event.getX(), event.getY());
            case 1:
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                return onActionUp(event.getX(), event.getY());
            case 2:
                if (this.disableSlide) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                return onActionMove(event.getX());
            default:
                return true;
        }
    }

    private final boolean onActionDown(float x, float y) {
        Thumb $this$onActionDown_u24lambda_u2d0 = this.thumb;
        if ($this$onActionDown_u24lambda_u2d0 == null) {
            return true;
        }
        if ($this$onActionDown_u24lambda_u2d0.isPressed() || !$this$onActionDown_u24lambda_u2d0.isInTargetZone(x, y)) {
            this.indexPressed = getTickIndex(x, y);
            if (this.isSupportPressInTouchBlank) {
                return true;
            }
            BarrageSettingSliderSeekSeekBarStyle barrageSettingSliderSeekSeekBarStyle = this.styleImpl;
            Bar bar2 = this.bar;
            float startX = bar2 != null ? bar2.getStartX() : 0.0f;
            Bar bar3 = this.bar;
            float moveToX = barrageSettingSliderSeekSeekBarStyle.moveThumb(x, startX, bar3 != null ? bar3.getEndX() : 0.0f);
            if (moveToX <= 0.0f) {
                return true;
            }
            $this$onActionDown_u24lambda_u2d0.setX(moveToX);
            $this$onActionDown_u24lambda_u2d0.press();
            invalidate();
            return true;
        }
        pressThumb();
        return true;
    }

    private final boolean onActionMove(float x) {
        Thumb thumb2 = this.thumb;
        boolean z = false;
        if (thumb2 != null && thumb2.isPressed()) {
            z = true;
        }
        if (z) {
            BarrageSettingSliderSeekSeekBarStyle barrageSettingSliderSeekSeekBarStyle = this.styleImpl;
            Bar bar2 = this.bar;
            float startX = bar2 != null ? bar2.getStartX() : 0.0f;
            Bar bar3 = this.bar;
            float moveToX = barrageSettingSliderSeekSeekBarStyle.moveThumb(x, startX, bar3 != null ? bar3.getEndX() : 0.0f);
            if (moveToX > 0.0f) {
                Thumb thumb3 = this.thumb;
                if (thumb3 != null) {
                    thumb3.setX(moveToX);
                }
                invalidate();
            }
        }
        return true;
    }

    private final boolean onActionUp(float x, float y) {
        Thumb thumb2 = this.thumb;
        boolean z = false;
        if (thumb2 != null && thumb2.isPressed()) {
            z = true;
        }
        if (z) {
            releaseThumb();
        } else if (this.indexPressed == getTickIndex(x, y) && this.indexPressed != -1) {
            Thumb thumb3 = this.thumb;
            float start = thumb3 != null ? thumb3.getX() : 0.0f;
            float end = this.styleImpl.getXCoordinate() + (((float) this.indexPressed) * this.styleImpl.getTickDistance());
            if (this.withAnimation) {
                startAnimation(start, end);
            } else {
                Thumb thumb4 = this.thumb;
                if (thumb4 != null) {
                    thumb4.setX(end);
                }
                invalidate();
            }
            int i2 = this.indexPressed;
            this.currentIndex = i2;
            this.styleImpl.setCurIndex(i2);
            this.otherAttrs.putInt("current_index", this.currentIndex);
            OnSliderSeekBarChangeListener onSliderSeekBarChangeListener = this.listener;
            if (onSliderSeekBarChangeListener != null) {
                OnSliderSeekBarChangeListener.DefaultImpls.onIndexChanged$default(onSliderSeekBarChangeListener, this, this.currentIndex, false, 4, (Object) null);
            }
        }
        return true;
    }

    private final int getTickIndex(float x, float y) {
        int i2 = this.tickCount;
        for (int i3 = 0; i3 < i2; i3++) {
            if (isWithinTick(x, y, i3)) {
                return i3;
            }
        }
        return -1;
    }

    private final boolean isWithinTick(float x, float y, int i2) {
        return Math.abs(y - this.styleImpl.getYCoordinate()) < this.styleImpl.getTouchZoneY() * ((float) 2) && Math.abs(x - (this.styleImpl.getXCoordinate() + (this.styleImpl.getTickDistance() * ((float) i2)))) < this.styleImpl.getTouchZoneX();
    }

    private final void pressThumb() {
        Thumb $this$pressThumb_u24lambda_u2d1 = this.thumb;
        if ($this$pressThumb_u24lambda_u2d1 != null) {
            $this$pressThumb_u24lambda_u2d1.press();
        }
        invalidate();
    }

    private final void releaseThumb() {
        Bar bar2 = this.bar;
        int index = bar2 != null ? bar2.getNearestTickIndex(this.thumb) : 0;
        if (this.currentIndex != index) {
            this.currentIndex = index;
            this.styleImpl.setCurIndex(index);
            this.otherAttrs.putInt("current_index", this.currentIndex);
            OnSliderSeekBarChangeListener onSliderSeekBarChangeListener = this.listener;
            if (onSliderSeekBarChangeListener != null) {
                OnSliderSeekBarChangeListener.DefaultImpls.onIndexChanged$default(onSliderSeekBarChangeListener, this, this.currentIndex, false, 4, (Object) null);
            }
        }
        Thumb thumb2 = this.thumb;
        float end = 0.0f;
        float start = thumb2 != null ? thumb2.getX() : 0.0f;
        Bar bar3 = this.bar;
        if (bar3 != null) {
            end = bar3.getNearestTickCoordinateX(this.thumb);
        }
        if (this.withAnimation) {
            startAnimation(start, end);
        } else {
            Thumb thumb3 = this.thumb;
            if (thumb3 != null) {
                thumb3.setX(end);
            }
            invalidate();
        }
        Thumb thumb4 = this.thumb;
        if (thumb4 != null) {
            thumb4.release();
        }
    }

    private final void startAnimation(float start, float end) {
        stopAnimation();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{start, end});
        this.animator = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(80);
        }
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(new SliderSeekBar$$ExternalSyntheticLambda0(this));
        }
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startAnimation$lambda-2  reason: not valid java name */
    public static final void m10816startAnimation$lambda2(SliderSeekBar this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue != null) {
            float x = ((Float) animatedValue).floatValue();
            Thumb thumb2 = this$0.thumb;
            if (thumb2 != null) {
                thumb2.setX(x);
            }
            this$0.invalidate();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    public final void setOnSliderBarChangeListener(OnSliderSeekBarChangeListener listener2) {
        this.listener = listener2;
    }

    public static /* synthetic */ void setTickCount$default(SliderSeekBar sliderSeekBar, int i2, String[] strArr, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            strArr = null;
        }
        sliderSeekBar.setTickCount(i2, strArr);
    }

    public final void setTickCount(int tickCount2, String[] textArray) {
        String[] array = textArray;
        if (isValidTickCount(tickCount2, array)) {
            this.tickCount = tickCount2;
            this.otherAttrs.putInt("tick_count", tickCount2);
            if (array == null || array.length == 0) {
                array = new String[0];
            }
            this.otherAttrs.putStringArray("text_array", array);
        }
    }

    private final boolean isValidTickCount(int tickCount2, String[] textArray) {
        return (tickCount2 >= 2 && (textArray == null || textArray.length == 0)) || (tickCount2 >= 2 && textArray != null && textArray.length == tickCount2);
    }

    public static /* synthetic */ void setThumbIndex$default(SliderSeekBar sliderSeekBar, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = true;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        sliderSeekBar.setThumbIndex(i2, z, z2);
    }

    public final void setThumbIndex(int index, boolean isChangedByUser, boolean isReset) {
        OnSliderSeekBarChangeListener onSliderSeekBarChangeListener;
        if (index >= 0 && index < this.tickCount && this.currentIndex != index) {
            this.currentIndex = index;
            this.otherAttrs.putInt("current_index", index);
            Thumb thumb2 = this.thumb;
            if (thumb2 != null) {
                if (thumb2 != null) {
                    thumb2.setX(this.styleImpl.getXCoordinate() + (this.styleImpl.getTickDistance() * ((float) this.currentIndex)));
                }
                invalidate();
            }
            if (isChangedByUser && (onSliderSeekBarChangeListener = this.listener) != null) {
                onSliderSeekBarChangeListener.onIndexChanged(this, this.currentIndex, isReset);
            }
        }
    }

    public final void withAnimation(boolean withAnimation2) {
        this.withAnimation = withAnimation2;
    }

    public final void showTicksAndTexts(boolean showTicksAndTexts2) {
        this.showTicksAndTexts = showTicksAndTexts2;
        this.otherAttrs.putBoolean(AbstractSliderSeekBarStyleKt.IS_SHOW_TICKS, showTicksAndTexts2);
    }

    public final void refresh() {
        stopAnimation();
        init();
        requestLayout();
        invalidate();
    }

    private final boolean isAnimationRunning() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    private final void stopAnimation() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            valueAnimator.cancel();
            this.animator = null;
        }
    }

    public final void updateFontSize() {
        this.styleImpl.updateFontSize();
        init();
    }

    public final void updateSkin() {
        this.styleImpl.updateSkin();
        init();
    }

    public final void updateLandscapeSkin() {
        this.styleImpl.updateLandscapeSkin();
        init();
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0014\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/barragesetting/seekbar/SliderSeekBar$Bar;", "", "startX", "", "endX", "(Lcom/baidu/searchbox/video/feedflow/detail/barragesetting/seekbar/SliderSeekBar;FF)V", "getEndX", "()F", "getStartX", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getNearestTickCoordinateX", "thumb", "Lcom/baidu/searchbox/video/feedflow/detail/barragesetting/seekbar/SliderSeekBar$Thumb;", "Lcom/baidu/searchbox/video/feedflow/detail/barragesetting/seekbar/SliderSeekBar;", "getNearestTickIndex", "", "thumbX", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SliderSeekBar.kt */
    private final class Bar {
        private final float endX;
        private final float startX;

        public Bar(float startX2, float endX2) {
            this.startX = startX2;
            this.endX = endX2;
        }

        public final float getStartX() {
            return this.startX;
        }

        public final float getEndX() {
            return this.endX;
        }

        public final void draw(Canvas canvas) {
            if (canvas != null) {
                SliderSeekBar sliderSeekBar = SliderSeekBar.this;
                Canvas cv = canvas;
                sliderSeekBar.styleImpl.drawBg(cv);
                if (sliderSeekBar.showTicksAndTexts) {
                    sliderSeekBar.styleImpl.drawTicksAndTexts(sliderSeekBar.getCurrentIndex(), cv);
                }
            }
        }

        public final float getNearestTickCoordinateX(Thumb thumb) {
            return this.startX + (SliderSeekBar.this.styleImpl.getTickDistance() * ((float) getNearestTickIndex(thumb)));
        }

        public final int getNearestTickIndex(Thumb thumb) {
            return getNearestTickIndex(thumb != null ? thumb.getX() : 0.0f);
        }

        public final int getNearestTickIndex(float thumbX) {
            return (int) (((thumbX - this.startX) + (SliderSeekBar.this.styleImpl.getTickDistance() / 2.0f)) / SliderSeekBar.this.styleImpl.getTickDistance());
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0016\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/barragesetting/seekbar/SliderSeekBar$Thumb;", "", "x", "", "mY", "(Lcom/baidu/searchbox/video/feedflow/detail/barragesetting/seekbar/SliderSeekBar;FF)V", "isPressed", "", "()Z", "setPressed", "(Z)V", "getMY", "()F", "getX", "setX", "(F)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "isInTargetZone", "y", "press", "release", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SliderSeekBar.kt */
    private final class Thumb {
        private boolean isPressed;
        private final float mY;
        private float x;

        public Thumb(float x2, float mY2) {
            this.x = x2;
            this.mY = mY2;
        }

        public final float getX() {
            return this.x;
        }

        public final void setX(float f2) {
            this.x = f2;
        }

        public final float getMY() {
            return this.mY;
        }

        public final boolean isPressed() {
            return this.isPressed;
        }

        public final void setPressed(boolean z) {
            this.isPressed = z;
        }

        public final void draw(Canvas canvas) {
            if (canvas != null) {
                SliderSeekBar.this.styleImpl.drawThumb(this.x, this.mY, this.isPressed, canvas);
            }
        }

        public final void press() {
            this.isPressed = true;
        }

        public final void release() {
            this.isPressed = false;
        }

        public final boolean isInTargetZone(float x2, float y) {
            return Math.abs(x2 - this.x) <= SliderSeekBar.this.styleImpl.getTouchZoneX() && Math.abs(y - this.mY) <= SliderSeekBar.this.styleImpl.getTouchZoneY();
        }
    }
}
