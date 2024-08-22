package com.baidu.android.ext.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.searchbox.common.res.R;

public class ClickableTextView extends TextView {
    /* access modifiers changed from: private */
    public float mAlphaOnDown;
    /* access modifiers changed from: private */
    public float mAlphaOnUp;
    /* access modifiers changed from: private */
    public boolean mClickableDisable;

    public ClickableTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ClickableTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClickableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mAlphaOnUp = 1.0f;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ClickableTextView);
        this.mAlphaOnDown = ta.getFloat(R.styleable.ClickableTextView_down_alpha, 1.0f);
        ta.recycle();
        this.mClickableDisable = false;
        init();
    }

    private void init() {
        setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (ClickableTextView.this.mClickableDisable) {
                    return false;
                }
                switch (event.getAction()) {
                    case 0:
                        ClickableTextView clickableTextView = ClickableTextView.this;
                        float unused = clickableTextView.mAlphaOnUp = clickableTextView.getAlpha();
                        ClickableTextView clickableTextView2 = ClickableTextView.this;
                        clickableTextView2.setAlpha(clickableTextView2.mAlphaOnDown);
                        break;
                    case 1:
                    case 3:
                        ClickableTextView clickableTextView3 = ClickableTextView.this;
                        clickableTextView3.setAlpha(clickableTextView3.mAlphaOnUp);
                        break;
                }
                return false;
            }
        });
    }

    public void disableClickable() {
        this.mClickableDisable = true;
        setClickable(false);
    }

    public void enableClickable() {
        this.mClickableDisable = false;
        setClickable(true);
    }
}
