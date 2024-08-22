package com.baidu.searchbox.smartmenu.views.slider;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.smartmenu.R;
import com.baidu.searchbox.video.feedflow.tab.tablayout.TabLayoutView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J(\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u00100\u001a\u00020(2\u0006\u00101\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0016J\b\u00102\u001a\u00020\u000fH\u0016J\b\u00103\u001a\u00020\u0004H\u0016J\b\u00104\u001a\u00020\u000fH\u0002J\b\u00105\u001a\u00020\u0004H\u0016J\u0018\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020\u000fH\u0016J\b\u0010;\u001a\u00020\u000fH\u0016J\b\u0010<\u001a\u00020\u000fH\u0016J\b\u0010=\u001a\u00020\u000fH\u0016J\b\u0010>\u001a\u00020\u000fH\u0016J\u0010\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020AH\u0016J \u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u000fH\u0016J\u0010\u0010F\u001a\u00020(2\u0006\u0010G\u001a\u00020HH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001a\u0010\u0017\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001a\u0010\u001d\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u000e\u0010 \u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001a\u0010$\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013¨\u0006I"}, d2 = {"Lcom/baidu/searchbox/smartmenu/views/slider/CircleSliderBarImpl;", "Lcom/baidu/searchbox/smartmenu/views/slider/SliderBarImpl;", "()V", "chosenTextColor", "", "getChosenTextColor", "()I", "setChosenTextColor", "(I)V", "chosenTextPaint", "Landroid/graphics/Paint;", "defaultChosenIndex", "getDefaultChosenIndex", "setDefaultChosenIndex", "defaultChosenRadius", "", "getDefaultChosenRadius", "()F", "setDefaultChosenRadius", "(F)V", "defaultWidth", "getDefaultWidth", "setDefaultWidth", "textPadding", "getTextPadding", "setTextPadding", "thumbColorStroke", "getThumbColorStroke", "setThumbColorStroke", "thumbRadius", "getThumbRadius", "setThumbRadius", "thumbStrokePaint", "thumbWideStroke", "getThumbWideStroke", "setThumbWideStroke", "tickRadius", "getTickRadius", "setTickRadius", "drawBg", "", "canvas", "Landroid/graphics/Canvas;", "drawThumb", "centerX", "centerY", "isPressed", "", "drawTicksAndTexts", "curIndex", "getBarBgLength", "getDefWidth", "getFontHeight", "getMinHeight", "getTextWidth", "paint", "text", "", "getTickDistance", "getTouchZoneX", "getTouchZoneY", "getXCoordinate", "getYCoordinate", "init", "t", "Landroid/content/res/TypedArray;", "moveThumb", "x", "startX", "endX", "setOtherAttrs", "bundle", "Landroid/os/Bundle;", "lib-smart-menu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CircleSliderBarImpl.kt */
public final class CircleSliderBarImpl extends SliderBarImpl {
    private int chosenTextColor = TabLayoutView.VALUE_UNDERLINE_COLOR_DEFAULT;
    private Paint chosenTextPaint = new Paint();
    private int defaultChosenIndex = -1;
    private float defaultChosenRadius = 7.5f;
    private int defaultWidth = 500;
    private float textPadding = 50.0f;
    private int thumbColorStroke = 1711276032;
    private float thumbRadius = 30.0f;
    private Paint thumbStrokePaint = new Paint();
    private float thumbWideStroke = 3.0f;
    private float tickRadius = 7.5f;

    public final float getTickRadius() {
        return this.tickRadius;
    }

    public final void setTickRadius(float f2) {
        this.tickRadius = f2;
    }

    public final float getThumbRadius() {
        return this.thumbRadius;
    }

    public final void setThumbRadius(float f2) {
        this.thumbRadius = f2;
    }

    public final float getTextPadding() {
        return this.textPadding;
    }

    public final void setTextPadding(float f2) {
        this.textPadding = f2;
    }

    public final int getDefaultWidth() {
        return this.defaultWidth;
    }

    public final void setDefaultWidth(int i2) {
        this.defaultWidth = i2;
    }

    public final float getThumbWideStroke() {
        return this.thumbWideStroke;
    }

    public final void setThumbWideStroke(float f2) {
        this.thumbWideStroke = f2;
    }

    public final int getThumbColorStroke() {
        return this.thumbColorStroke;
    }

    public final void setThumbColorStroke(int i2) {
        this.thumbColorStroke = i2;
    }

    public final int getChosenTextColor() {
        return this.chosenTextColor;
    }

    public final void setChosenTextColor(int i2) {
        this.chosenTextColor = i2;
    }

    public final float getDefaultChosenRadius() {
        return this.defaultChosenRadius;
    }

    public final void setDefaultChosenRadius(float f2) {
        this.defaultChosenRadius = f2;
    }

    public final int getDefaultChosenIndex() {
        return this.defaultChosenIndex;
    }

    public final void setDefaultChosenIndex(int i2) {
        this.defaultChosenIndex = i2;
    }

    public void init(TypedArray t) {
        Intrinsics.checkNotNullParameter(t, "t");
        try {
            float f2 = (float) 2;
            this.tickRadius = t.getDimension(R.styleable.SliderBar_tickDiameter, this.tickRadius * f2) / f2;
            setBarBgHeight(t.getDimension(R.styleable.SliderBar_barLineWide, 3.0f));
            setBarBgColor(t.getColor(R.styleable.SliderBar_barLineColor, getBarBgColor()));
            this.thumbRadius = t.getDimension(R.styleable.SliderBar_thumbRadius, this.thumbRadius);
            setThumbColorNormal(t.getColor(R.styleable.SliderBar_thumbColorNormal, getThumbColorNormal()));
            setThumbColorPressed(t.getColor(R.styleable.SliderBar_thumbColorPressed, getThumbColorPressed()));
            this.thumbColorStroke = t.getColor(R.styleable.SliderBar_thumbCircleColor, this.thumbColorStroke);
            this.thumbWideStroke = t.getDimension(R.styleable.SliderBar_thumbCircleWide, this.thumbWideStroke);
            setTextSize((int) t.getDimension(R.styleable.SliderBar_barTextSize, 40.0f));
            setTextColor(t.getColor(R.styleable.SliderBar_barTextColor, TabLayoutView.VALUE_UNDERLINE_COLOR_DEFAULT));
            this.chosenTextColor = t.getColor(R.styleable.SliderBar_barChosenTextColor, this.chosenTextColor);
            this.textPadding = t.getDimension(R.styleable.SliderBar_barTextPadding, this.textPadding);
            this.defaultWidth = (int) t.getDimension(R.styleable.SliderBar_defaultWidth, 500.0f);
            setCurIndex(t.getInt(R.styleable.SliderBar_currentIndex, 0));
            setShowShadow(t.getBoolean(R.styleable.SliderBar_isShowShadow, true));
            setShadowColor(t.getColor(R.styleable.SliderBar_shadowColor, TabLayoutView.VALUE_TEXT_SIZE_UNSELECT_COLOR_DEFAULT));
        } finally {
            t.recycle();
        }
    }

    public void setOtherAttrs(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        super.setOtherAttrs(bundle);
        this.chosenTextColor = bundle.getInt("chosen_text_color", this.chosenTextColor);
        this.textPadding = (float) bundle.getInt("text_padding", (int) this.textPadding);
        this.thumbRadius = bundle.getFloat("thumb_radius", this.thumbRadius);
        this.thumbColorStroke = bundle.getInt("thumb_stroke_color", this.thumbColorStroke);
        this.thumbWideStroke = bundle.getFloat("thumb_stroke_wide", this.thumbWideStroke);
        this.defaultChosenRadius = bundle.getFloat("default_chosen_radius", this.defaultChosenRadius);
        this.defaultChosenIndex = bundle.getInt("default_chosen_index", this.defaultChosenIndex);
    }

    public float moveThumb(float x, float startX, float endX) {
        boolean z = false;
        if (startX <= x && x <= endX) {
            z = true;
        }
        if (z) {
            return x;
        }
        return 0.0f;
    }

    public int getDefWidth() {
        return this.defaultWidth;
    }

    public int getMinHeight() {
        return (int) ((this.thumbRadius * ((float) 2)) + this.textPadding + getFontHeight() + ((float) getParent().getPaddingTop()) + ((float) getParent().getPaddingBottom()));
    }

    public float getXCoordinate() {
        return ((float) getParent().getPaddingLeft()) + this.thumbRadius;
    }

    public float getYCoordinate() {
        return (((float) (getParent().getHeight() - getParent().getPaddingBottom())) - (((float) (getParent().getHeight() - getMinHeight())) / 2.0f)) - this.thumbRadius;
    }

    public float getBarBgLength() {
        return ((((float) getParent().getWidth()) - (((float) 2) * this.thumbRadius)) - ((float) getParent().getPaddingLeft())) - ((float) getParent().getPaddingRight());
    }

    public float getTouchZoneX() {
        return Math.max(50.0f, this.thumbRadius * ((float) 2));
    }

    public float getTouchZoneY() {
        return Math.max(50.0f, this.thumbRadius * ((float) 2));
    }

    public void drawBg(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getBarBgPaint().setColor(getBarLineColor());
        getBarBgPaint().setStrokeWidth(getBarBgHeight());
        getBarBgPaint().setAntiAlias(true);
        canvas.drawLine(getXCoordinate(), getYCoordinate(), getXCoordinate() + getBarBgLength(), getYCoordinate(), getBarBgPaint());
    }

    public void drawTicksAndTexts(int curIndex, Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getTextPaint().setColor(getTextColor());
        getTextPaint().setTextSize((float) getTextSize());
        getTextPaint().setAntiAlias(true);
        this.chosenTextPaint.setColor(this.chosenTextColor);
        this.chosenTextPaint.setTextSize((float) getTextSize());
        this.chosenTextPaint.setAntiAlias(true);
        int i2 = 0;
        int tickCount = getTickCount();
        while (i2 < tickCount) {
            float curX = getXCoordinate() + (((float) i2) * getTickDistance());
            canvas.drawCircle(curX, getYCoordinate(), i2 == this.defaultChosenIndex ? this.defaultChosenRadius : this.tickRadius, getBarBgPaint());
            if ((!(getTextArray().length == 0)) && i2 < getTextArray().length) {
                String text = getTextArray()[i2];
                if (!TextUtils.isEmpty(text)) {
                    if (i2 == curIndex) {
                        Paint.FontMetrics fontMetrics = this.chosenTextPaint.getFontMetrics();
                        canvas.drawText(text, curX - (getTextWidth(this.chosenTextPaint, text) / ((float) 2)), ((getYCoordinate() - this.thumbRadius) - this.textPadding) - (fontMetrics.bottom - fontMetrics.descent), this.chosenTextPaint);
                    } else {
                        Paint.FontMetrics fontMetrics2 = getTextPaint().getFontMetrics();
                        canvas.drawText(text, curX - (getTextWidth(getTextPaint(), text) / ((float) 2)), ((getYCoordinate() - this.thumbRadius) - this.textPadding) - (fontMetrics2.bottom - fontMetrics2.descent), getTextPaint());
                    }
                }
            }
            i2++;
        }
    }

    public void drawThumb(float centerX, float centerY, boolean isPressed, Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getThumbPaint().setColor(getThumbColorNormal());
        getThumbPaint().setAntiAlias(true);
        getThumbPressedPaint().setColor(getThumbColorPressed());
        getThumbPressedPaint().setAntiAlias(true);
        this.thumbStrokePaint.setStyle(Paint.Style.STROKE);
        this.thumbStrokePaint.setColor(this.thumbColorStroke);
        this.thumbStrokePaint.setAntiAlias(true);
        this.thumbStrokePaint.setStrokeWidth(this.thumbWideStroke);
        if (isShowShadow()) {
            getParent().setLayerType(1, getThumbPaint());
            getParent().setLayerType(1, getThumbPressedPaint());
            getThumbPaint().setShadowLayer(3.0f, 0.0f, 3.0f, getShadowColor());
            getThumbPressedPaint().setShadowLayer(3.0f, 0.0f, 3.0f, getShadowColor());
        }
        if (isPressed) {
            canvas.drawCircle(centerX, centerY, this.thumbRadius, getThumbPressedPaint());
        } else {
            canvas.drawCircle(centerX, centerY, this.thumbRadius, getThumbPaint());
        }
        canvas.drawCircle(centerX, centerY, this.thumbRadius, this.thumbStrokePaint);
    }

    public float getTickDistance() {
        return getBarBgLength() / ((float) (getTickCount() - 1));
    }

    private final float getFontHeight() {
        if (getTextArray().length == 0) {
            return 0.0f;
        }
        Paint paint = new Paint();
        paint.setTextSize((float) getTextSize());
        paint.measureText(getTextArray()[0]);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    private final float getTextWidth(Paint paint, String text) {
        return paint.measureText(text);
    }
}
