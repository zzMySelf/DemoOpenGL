package com.tera.scan.ui.widget;

import android.content.Context;
import android.util.AttributeSet;

public class VerticalSeekBar extends AbsVerticalSeekBar {
    public OnSeekBarChangeListener mOnSeekBarChangeListener;

    public interface OnSeekBarChangeListener {
        void ad(VerticalSeekBar verticalSeekBar);

        void de(VerticalSeekBar verticalSeekBar);

        void qw(VerticalSeekBar verticalSeekBar, int i2, boolean z);
    }

    public VerticalSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onProgressRefresh(float f, boolean z) {
        super.onProgressRefresh(f, z);
        OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.qw(this, getProgress(), z);
        }
    }

    public void onStartTrackingTouch() {
        OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.de(this);
        }
    }

    public void onStopTrackingTouch() {
        OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.ad(this);
        }
    }

    public void setOnSeekBarChangeListener(OnSeekBarChangeListener onSeekBarChangeListener) {
        this.mOnSeekBarChangeListener = onSeekBarChangeListener;
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842875);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
