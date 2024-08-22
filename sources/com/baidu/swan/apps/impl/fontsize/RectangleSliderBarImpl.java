package com.baidu.swan.apps.impl.fontsize;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.R;

public class RectangleSliderBarImpl extends SliderBarImpl {
    public static final String THUMB_TEXT_COLOR = "thumb_text_color";
    float barBgCorner = ((float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.swan_font_setting_default_bar_bg_corner));
    float barLineHeight = ((float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.swan_font_setting_default_bar_line_height));
    float barLineMargin = ((float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.swan_font_setting_default_bar_line_margin));
    private Paint barLinePaint = new Paint();
    float barLineWidth = ((float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.swan_font_setting_default_bar_line_width));
    float thumbCorner = ((float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.swan_font_setting_default_thumb_corner));
    float thumbHeight = ((float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.swan_font_setting_default_thumb_height));
    int thumbTextColor = AppRuntime.getAppContext().getResources().getColor(R.color.GC1);
    private Paint thumbTextPaint = new Paint();
    float thumbTextSize = 36.5f;
    float thumbWidth = ((float) AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.swan_font_setting_default_thumb_width));

    public RectangleSliderBarImpl(View parent) {
        super(parent);
    }

    /* access modifiers changed from: package-private */
    public void init(TypedArray typedArray) {
    }

    public void setOtherAttrs(Bundle bundle) {
        super.setOtherAttrs(bundle);
        this.thumbTextColor = bundle.getInt("thumb_text_color", this.thumbTextColor);
    }

    public int getDefWidth() {
        return 0;
    }

    public float moveThumb(float x, float startX, float endX) {
        if (startX < x && x < endX) {
            return x;
        }
        float f2 = this.barLineMargin;
        if (x >= startX - f2 && x <= startX) {
            return startX;
        }
        if (x < endX || x > f2 + endX) {
            return 0.0f;
        }
        return endX;
    }

    public int getMinHeight() {
        return 0;
    }

    public float getTouchZoneX() {
        return this.thumbWidth / 2.0f;
    }

    public float getTouchZoneY() {
        return this.thumbHeight / 2.0f;
    }

    public void drawBg(Canvas canvas) {
        RectF mBgRect = new RectF(getXCoordinate() - this.barLineMargin, getYCoordinate() - (this.barBgHeight / 2.0f), (getXCoordinate() - this.barLineMargin) + getBarBgLength(), getYCoordinate() + (this.barBgHeight / 2.0f));
        this.barBgPaint.setColor(this.barBgColor);
        this.barBgPaint.setAntiAlias(true);
        float f2 = this.barBgCorner;
        canvas.drawRoundRect(mBgRect, f2, f2, this.barBgPaint);
    }

    public void drawTicksAndTexts(int curIndex, Canvas canvas) {
        this.barLinePaint.setColor(this.barLineColor);
        this.barLinePaint.setStrokeWidth(this.barLineWidth);
        this.barLinePaint.setAntiAlias(true);
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize((float) this.textSize);
        this.textPaint.setAntiAlias(true);
        for (int i2 = 0; i2 < this.tickCount; i2++) {
            float curX = getXCoordinate() + (getTickDistance() * ((float) i2));
            canvas.drawLine(curX, getYCoordinate() - (this.barLineHeight / 2.0f), curX, getYCoordinate() + (this.barLineHeight / 2.0f), this.barLinePaint);
            if (this.textArray != null && i2 < this.textArray.length) {
                String text = this.textArray[i2];
                canvas.drawText(text, curX - (this.textPaint.measureText(text) / 2.0f), ((float) this.parent.getPaddingTop()) - this.textPaint.getFontMetrics().ascent, this.textPaint);
            }
        }
    }

    public void drawThumb(float centerX, float centerY, boolean isPressed, Canvas canvas) {
        float f2 = this.thumbWidth;
        float f3 = this.thumbHeight;
        RectF mRect = new RectF(centerX - (f2 / 2.0f), centerY - (f3 / 2.0f), (f2 / 2.0f) + centerX, (f3 / 2.0f) + centerY);
        this.thumbPaint.setColor(this.thumbColorNormal);
        this.thumbPaint.setAntiAlias(true);
        this.thumbPressedPaint.setColor(this.thumbColorPressed);
        this.thumbPressedPaint.setAntiAlias(true);
        this.thumbTextPaint.setColor(this.thumbTextColor);
        this.thumbTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.thumbTextPaint.setTextSize(this.thumbTextSize);
        this.thumbTextPaint.setAntiAlias(true);
        if (this.isShowShadow) {
            this.parent.setLayerType(1, this.thumbPaint);
            this.parent.setLayerType(1, this.thumbPressedPaint);
            this.thumbPaint.setShadowLayer(3.33f, 0.0f, 0.67f, this.shadowColor);
            this.thumbPressedPaint.setShadowLayer(3.33f, 0.0f, 0.67f, this.shadowColor);
        }
        if (isPressed) {
            float f4 = this.thumbCorner;
            canvas.drawRoundRect(mRect, f4, f4, this.thumbPressedPaint);
        } else {
            float f5 = this.thumbCorner;
            canvas.drawRoundRect(mRect, f5, f5, this.thumbPaint);
        }
        if (this.textArray != null && this.curIndex < this.textArray.length) {
            String text = this.textArray[this.curIndex];
            Paint.FontMetrics fontMetrics = this.thumbTextPaint.getFontMetrics();
            canvas.drawText(text, centerX - (this.textPaint.measureText(text) / 2.0f), centerY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f), this.thumbTextPaint);
        }
    }

    public float getXCoordinate() {
        return ((float) this.parent.getPaddingLeft()) + this.barLineMargin;
    }

    public float getYCoordinate() {
        return ((float) (this.parent.getHeight() - this.parent.getPaddingBottom())) - (this.barBgHeight / 2.0f);
    }

    public float getBarBgLength() {
        return (float) ((this.parent.getWidth() - this.parent.getPaddingLeft()) - this.parent.getPaddingRight());
    }

    public float getTickDistance() {
        return (getBarBgLength() - (this.barLineMargin * 2.0f)) / ((float) (this.tickCount - 1));
    }
}
