package com.tera.scan.ui.view.widget.floatview;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import fe.mmm.qw.f.ad.de.qw;

public class UIFloatView extends FrameLayout {
    public static final String TAG = "UIFloatView";
    public boolean mAutoClear = false;
    public boolean mCanDrag = true;
    public View mContent;
    public float mLastX;
    public float mLastY;
    public float mStartX;
    public float mStartY;

    public UIFloatView(@NonNull Context context, View view) {
        super(context);
        try {
            this.mContent = view;
            addView(view);
        } catch (Exception e) {
            qw.qw.ad(TAG, e.getMessage(), e);
        }
    }

    private boolean isDragEvent(MotionEvent motionEvent) {
        return Math.sqrt(Math.pow((double) Math.abs(motionEvent.getRawX() - this.mStartX), 2.0d) + Math.pow((double) Math.abs(motionEvent.getRawY() - this.mStartY), 2.0d)) > ((double) ViewConfiguration.get(getContext()).getScaledTouchSlop());
    }

    private void updatePosition(MotionEvent motionEvent) {
        View view = (View) getParent();
        float x = getX() + (motionEvent.getRawX() - this.mLastX);
        float f = 0.0f;
        if (x < 0.0f) {
            x = 0.0f;
        } else if (x > ((float) (view.getRight() - getWidth()))) {
            x = (float) (view.getRight() - getWidth());
        }
        setX(x);
        float y = getY() + (motionEvent.getRawY() - this.mLastY);
        if (y >= 0.0f) {
            f = y > ((float) (view.getHeight() - getHeight())) ? (float) (view.getHeight() - getHeight()) : y;
        }
        setY(f);
    }

    public boolean accept(Activity activity) {
        return true;
    }

    public boolean canDrag() {
        return this.mCanDrag;
    }

    public boolean isAutoClear() {
        return this.mAutoClear;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanDrag) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            float rawX = motionEvent.getRawX();
            this.mStartX = rawX;
            this.mLastX = rawX;
            float rawY = motionEvent.getRawY();
            this.mStartY = rawY;
            this.mLastY = rawY;
        } else if (action != 1) {
            if (action == 2) {
                updatePosition(motionEvent);
                this.mLastX = motionEvent.getRawX();
                this.mLastY = motionEvent.getRawY();
            }
        } else if (!isDragEvent(motionEvent) && hasOnClickListeners()) {
            performClick();
        }
        return true;
    }

    public void setAutoClear(boolean z) {
        this.mAutoClear = z;
    }

    public void setDrag(boolean z) {
        this.mCanDrag = z;
    }
}
