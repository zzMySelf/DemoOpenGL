package com.baidu.talos.core.render.views.scroll;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import javax.annotation.Nullable;

public class VelocityHelper {
    @Nullable
    private VelocityTracker mVelocityTracker;
    private float mXVelocity;
    private float mYVelocity;

    public void calculateVelocity(MotionEvent ev) {
        int action = ev.getAction() & 255;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(ev);
        switch (action) {
            case 1:
            case 3:
                this.mVelocityTracker.computeCurrentVelocity(1);
                this.mXVelocity = this.mVelocityTracker.getXVelocity();
                this.mYVelocity = this.mVelocityTracker.getYVelocity();
                VelocityTracker velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.mVelocityTracker = null;
                    return;
                }
                return;
            default:
                return;
        }
    }

    public float getXVelocity() {
        return this.mXVelocity;
    }

    public float getYVelocity() {
        return this.mYVelocity;
    }
}
