package com.baidu.searchbox.feed.lottie;

import android.view.MotionEvent;

public class LottieMotionEventRunnable implements Runnable {
    private final MotionEvent motionEvent;

    public LottieMotionEventRunnable(MotionEvent motionEvent2) {
        this.motionEvent = motionEvent2;
    }

    public final void run() {
        doAction(this.motionEvent);
    }

    /* access modifiers changed from: protected */
    public void doAction(MotionEvent motionEvent2) {
    }
}
