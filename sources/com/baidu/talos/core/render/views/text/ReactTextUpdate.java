package com.baidu.talos.core.render.views.text;

import android.text.Spannable;

public class ReactTextUpdate {
    private final boolean mContainsClickableText;
    private final boolean mContainsImages;
    private final int mJsEventCounter;
    private final float mPaddingBottom;
    private final float mPaddingLeft;
    private final float mPaddingRight;
    private final float mPaddingTop;
    private final float mStrokeWidth;
    private final Spannable mText;
    private final int mTextAlign;

    public ReactTextUpdate(Spannable text, int jsEventCounter, boolean containsImages, boolean containsClickableText, float[] padding, int textAlign, float strokeWidth) {
        this.mText = text;
        this.mJsEventCounter = jsEventCounter;
        this.mContainsImages = containsImages;
        this.mContainsClickableText = containsClickableText;
        this.mPaddingLeft = padding[0];
        this.mPaddingTop = padding[1];
        this.mPaddingRight = padding[2];
        this.mPaddingBottom = padding[3];
        this.mTextAlign = textAlign;
        this.mStrokeWidth = strokeWidth;
    }

    public Spannable getText() {
        return this.mText;
    }

    public int getJsEventCounter() {
        return this.mJsEventCounter;
    }

    public boolean containsImages() {
        return this.mContainsImages;
    }

    public boolean containsClickableText() {
        return this.mContainsClickableText;
    }

    public float getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public float getPaddingTop() {
        return this.mPaddingTop;
    }

    public float getPaddingRight() {
        return this.mPaddingRight;
    }

    public float getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getTextAlign() {
        return this.mTextAlign;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }
}
