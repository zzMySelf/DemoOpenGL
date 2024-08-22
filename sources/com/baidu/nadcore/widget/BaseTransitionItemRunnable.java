package com.baidu.nadcore.widget;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u000fH\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/baidu/nadcore/widget/BaseTransitionItemRunnable;", "Ljava/lang/Runnable;", "delay", "", "duration", "(JJ)V", "mDelay", "getMDelay", "()J", "setMDelay", "(J)V", "mDuration", "getMDuration", "setMDuration", "onCancelAnim", "", "onStartAnim", "run", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseTransitionItemRunnable.kt */
public abstract class BaseTransitionItemRunnable implements Runnable {
    private long mDelay;
    private long mDuration;

    public abstract void onCancelAnim();

    public abstract void onStartAnim();

    public BaseTransitionItemRunnable(long delay, long duration) {
        this.mDelay = delay;
        this.mDuration = duration;
    }

    public final long getMDelay() {
        return this.mDelay;
    }

    public final void setMDelay(long j2) {
        this.mDelay = j2;
    }

    public final long getMDuration() {
        return this.mDuration;
    }

    public final void setMDuration(long j2) {
        this.mDuration = j2;
    }

    public void run() {
        onStartAnim();
    }
}
