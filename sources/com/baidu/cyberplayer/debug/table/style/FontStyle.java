package com.baidu.cyberplayer.debug.table.style;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import com.baidu.cyberplayer.debug.table.util.DensityUtils;

public class FontStyle implements IStyle {
    private static Paint.Align sDefaultAlign = Paint.Align.CENTER;
    private static int sDefaultFontColor = Color.parseColor("#636363");
    private static int sDefaultFontSize = 45;
    private Paint.Align mAlign;
    private int mTextColor;
    private int mTextSize;

    public static void setDefaultTextSize(int defaultTextSize) {
        sDefaultFontSize = defaultTextSize;
    }

    public static void setDefaultTextAlign(Paint.Align align) {
        sDefaultAlign = align;
    }

    public static void setDefaultTextSpSize(Context context, int defaultTextSpSize) {
        sDefaultFontSize = DensityUtils.sp2px(context, (float) defaultTextSpSize);
    }

    public static void setDefaultTextColor(int defaultTextColor) {
        sDefaultFontColor = defaultTextColor;
    }

    public FontStyle() {
    }

    public FontStyle(int textSize, int textColor) {
        this.mTextSize = textSize;
        this.mTextColor = textColor;
    }

    public FontStyle(Context context, int sp, int textColor) {
        this.mTextSize = DensityUtils.sp2px(context, (float) sp);
        this.mTextColor = textColor;
    }

    public Paint.Align getAlign() {
        Paint.Align align = this.mAlign;
        if (align == null) {
            return sDefaultAlign;
        }
        return align;
    }

    public FontStyle setAlign(Paint.Align align) {
        this.mAlign = align;
        return this;
    }

    public int getTextSize() {
        int i2 = this.mTextSize;
        if (i2 == 0) {
            return sDefaultFontSize;
        }
        return i2;
    }

    public FontStyle setTextSize(int textSize) {
        this.mTextSize = textSize;
        return this;
    }

    public void setTextSpSize(Context context, int sp) {
        setTextSize(DensityUtils.sp2px(context, (float) sp));
    }

    public int getTextColor() {
        int i2 = this.mTextColor;
        if (i2 == 0) {
            return sDefaultFontColor;
        }
        return i2;
    }

    public FontStyle setTextColor(int textColor) {
        this.mTextColor = textColor;
        return this;
    }

    public void fillPaint(Paint paint) {
        paint.setColor(getTextColor());
        paint.setTextAlign(getAlign());
        paint.setTextSize((float) getTextSize());
        paint.setStyle(Paint.Style.FILL);
    }
}
