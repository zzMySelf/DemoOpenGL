package com.baidu.searchbox.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class PressedImageView extends ImageView {
    private static final int DEFAULT_OPAQUE_ALPHA = 255;
    private static final int DEFAULT_PRESSED_ALPHA = 51;
    private static final String TAG = "PressedImageView";
    private int mPressedAlpha = 51;

    public PressedImageView(Context context) {
        super(context);
    }

    public PressedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PressedImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setPressedAlpha(float alpha) {
        this.mPressedAlpha = (int) (255.0f * alpha);
    }

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean pressed) {
        setImageAlpha(pressed ? this.mPressedAlpha : 255);
    }
}
