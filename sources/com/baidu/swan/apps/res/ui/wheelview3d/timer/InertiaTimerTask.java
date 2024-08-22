package com.baidu.swan.apps.res.ui.wheelview3d.timer;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;

public final class InertiaTimerTask extends TimerTask {
    private float mCurrentVelocityY = 2.14748365E9f;
    private final float mFirstVelocityY;
    private final WheelView3d mWheelView;

    public InertiaTimerTask(WheelView3d wheelView, float velocityY) {
        this.mWheelView = wheelView;
        this.mFirstVelocityY = velocityY;
    }

    public final void run() {
        if (this.mCurrentVelocityY == 2.14748365E9f) {
            float f2 = 2000.0f;
            if (Math.abs(this.mFirstVelocityY) > 2000.0f) {
                if (this.mFirstVelocityY <= 0.0f) {
                    f2 = -2000.0f;
                }
                this.mCurrentVelocityY = f2;
            } else {
                this.mCurrentVelocityY = this.mFirstVelocityY;
            }
        }
        if (Math.abs(this.mCurrentVelocityY) < 0.0f || Math.abs(this.mCurrentVelocityY) > 20.0f) {
            int dy = (int) (this.mCurrentVelocityY / 100.0f);
            WheelView3d wheelView3d = this.mWheelView;
            wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() - ((float) dy));
            if (!this.mWheelView.isLoop()) {
                float itemHeight = this.mWheelView.getItemHeight();
                float top = ((float) (-this.mWheelView.getInitPosition())) * itemHeight;
                float bottom = ((float) ((this.mWheelView.getItemsCount() - 1) - this.mWheelView.getInitPosition())) * itemHeight;
                if (((double) this.mWheelView.getTotalScrollY()) - (((double) itemHeight) * 0.25d) < ((double) top)) {
                    top = this.mWheelView.getTotalScrollY() + ((float) dy);
                } else if (((double) this.mWheelView.getTotalScrollY()) + (((double) itemHeight) * 0.25d) > ((double) bottom)) {
                    bottom = this.mWheelView.getTotalScrollY() + ((float) dy);
                }
                if (this.mWheelView.getTotalScrollY() <= top) {
                    this.mCurrentVelocityY = 40.0f;
                    this.mWheelView.setTotalScrollY((float) ((int) top));
                } else if (this.mWheelView.getTotalScrollY() >= bottom) {
                    this.mWheelView.setTotalScrollY((float) ((int) bottom));
                    this.mCurrentVelocityY = -40.0f;
                }
            }
            float itemHeight2 = this.mCurrentVelocityY;
            if (itemHeight2 < 0.0f) {
                this.mCurrentVelocityY = itemHeight2 + 20.0f;
            } else {
                this.mCurrentVelocityY = itemHeight2 - 20.0f;
            }
            this.mWheelView.getHandler().sendEmptyMessage(1000);
            return;
        }
        this.mWheelView.cancelFuture();
        this.mWheelView.getHandler().sendEmptyMessage(2000);
    }
}
