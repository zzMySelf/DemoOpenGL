package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class InstrumentedDrawable extends ForwardingDrawable {
    private boolean mIsChecked = false;
    private final Listener mListener;
    private final String mScaleType;

    public interface Listener {
        void track(int i2, int i3, int i4, int i5, int i6, int i7, String str);
    }

    public InstrumentedDrawable(Drawable drawable, Listener listener) {
        super(drawable);
        this.mListener = listener;
        this.mScaleType = getScaleType(drawable);
    }

    private String getScaleType(Drawable drawable) {
        if (drawable instanceof ScaleTypeDrawable) {
            return ((ScaleTypeDrawable) drawable).getScaleType().toString();
        }
        return "none";
    }

    public void draw(Canvas canvas) {
        if (!this.mIsChecked) {
            this.mIsChecked = true;
            RectF bounds = new RectF();
            getRootBounds(bounds);
            int viewWidth = (int) bounds.width();
            int viewHeight = (int) bounds.height();
            getTransformedBounds(bounds);
            int scaledWidth = (int) bounds.width();
            int scaledHeight = (int) bounds.height();
            int imageWidth = getIntrinsicWidth();
            int imageHeight = getIntrinsicHeight();
            Listener listener = this.mListener;
            if (listener != null) {
                listener.track(viewWidth, viewHeight, imageWidth, imageHeight, scaledWidth, scaledHeight, this.mScaleType);
            }
        }
        super.draw(canvas);
    }
}
