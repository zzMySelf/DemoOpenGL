package com.baidu.searchbox.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class SkinTextView extends TextView {
    public SkinTextView(Context context) {
        super(context);
    }

    public SkinTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SkinTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setPressed(boolean pressed) {
        if (pressed) {
            setAlpha(0.2f);
        } else {
            setAlpha(1.0f);
        }
        super.setPressed(pressed);
    }
}
