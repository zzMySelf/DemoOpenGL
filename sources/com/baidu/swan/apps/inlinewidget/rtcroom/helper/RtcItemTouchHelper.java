package com.baidu.swan.apps.inlinewidget.rtcroom.helper;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.util.SwanAppUIUtils;

public class RtcItemTouchHelper {
    private static final int FOCUS_HEIGHT = 308;
    private static final int FOCUS_WIDTH = 308;
    private static final int MIN_DISTANCE = 30;
    private static final int MIN_FOCUS_X = 32;
    private static final int MODE_INIT = 0;
    private static final int MODE_ZOOM = 1;
    private static final float ZOOM_SCROLL_ACCURACY = 10.0f;
    private boolean isCanClick;
    private boolean isDoZoom = false;
    private Runnable mClickRunnable;
    private float mDistance;
    private float mDownX;
    private float mDownY;
    private OnGestureListener mGestureListener;
    private Handler mHandler;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mTouchSlop;
    private int mZoomMode = 0;

    public interface OnGestureListener {
        void onFocus(int i2, int i3, int i4, int i5);

        void onZoom(int i2);

        void onZoomFinish();
    }

    public RtcItemTouchHelper() {
        Context context = SwanAppRuntime.getAppContext();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledPagingTouchSlop();
        this.mScreenWidth = SwanAppUIUtils.getDisplayWidth(context);
        this.mScreenHeight = SwanAppUIUtils.getDisplayHeight(context);
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public boolean onTouchEvent(MotionEvent event) {
        handleTouchEvent(event);
        return true;
    }

    public void setGestureListener(OnGestureListener listener) {
        this.mGestureListener = listener;
    }

    private void handleTouchEvent(MotionEvent event) {
        switch (event.getAction() & 255) {
            case 0:
                this.mDownX = event.getX();
                this.mDownY = event.getY();
                this.mZoomMode = 0;
                this.isCanClick = true;
                this.isDoZoom = false;
                return;
            case 1:
            case 3:
                if (!this.isDoZoom && this.isCanClick) {
                    handleClick(event);
                }
                OnGestureListener onGestureListener = this.mGestureListener;
                if (onGestureListener != null && this.isDoZoom) {
                    onGestureListener.onZoomFinish();
                }
                this.isCanClick = false;
                this.isDoZoom = false;
                this.mZoomMode = 0;
                return;
            case 2:
                if (this.mZoomMode == 1) {
                    if (event.getPointerCount() >= 2) {
                        float endDis = spacingBetweenFingers(event);
                        int scale = (int) ((endDis - this.mDistance) / 10.0f);
                        if (this.mGestureListener != null && Math.abs(scale) >= 1) {
                            this.isDoZoom = true;
                            this.mGestureListener.onZoom(scale);
                            this.mDistance = endDis;
                            return;
                        }
                        return;
                    }
                    return;
                } else if (Math.abs(this.mDownX - event.getX()) > ((float) this.mTouchSlop) || Math.abs(this.mDownY - event.getY()) > ((float) this.mTouchSlop)) {
                    removeClickCallbacks();
                    return;
                } else {
                    return;
                }
            case 5:
                this.mZoomMode = 1;
                this.mDistance = spacingBetweenFingers(event);
                return;
            default:
                return;
        }
    }

    private void handleClick(final MotionEvent event) {
        if (event.getAction() == 1 && Math.abs(this.mDownX - event.getX()) < 30.0f && Math.abs(this.mDownY - event.getY()) < 30.0f) {
            removeClickCallbacks();
            AnonymousClass1 r0 = new Runnable() {
                public void run() {
                    RtcItemTouchHelper.this.handleTouchFocus(event);
                }
            };
            this.mClickRunnable = r0;
            this.mHandler.postDelayed(r0, 300);
        }
    }

    /* access modifiers changed from: private */
    public void handleTouchFocus(MotionEvent event) {
        int fx = (int) event.getX();
        int fy = (int) event.getY();
        if (fy <= this.mScreenHeight && fx >= SwanAppUIUtils.dp2px(32.0f)) {
            int fx2 = clamp(fx, 154, this.mScreenWidth - 154);
            int fy2 = clamp(fy, 154, this.mScreenHeight - 154);
            OnGestureListener onGestureListener = this.mGestureListener;
            if (onGestureListener != null) {
                onGestureListener.onFocus(308, 308, fx2, fy2);
            }
        }
    }

    private void removeClickCallbacks() {
        this.mHandler.removeCallbacks(this.mClickRunnable);
    }

    private float spacingBetweenFingers(MotionEvent event) {
        if (event == null || event.getPointerCount() < 2) {
            return 0.0f;
        }
        double x = (double) (event.getX(0) - event.getX(1));
        double y = (double) (event.getY(0) - event.getY(1));
        return (float) Math.sqrt((x * x) + (y * y));
    }

    private int clamp(int x, int min, int max) {
        if (x > max) {
            return max;
        }
        if (x < min) {
            return min;
        }
        return x;
    }
}
