package com.baidu.android.util.time;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

public class CountDownTimer {
    public static final int MSG = 1;
    public final long mCountdownInterval;
    public long mCountdownMillis;
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            CountDownTimer.this.handleCountDownMessage(message);
        }
    };
    public boolean mIsCancelled = false;
    public boolean mIsFinished = false;
    public boolean mIsPaused = true;
    public StatusListener mListener = new StatusListener() {
        public void onStart() {
            super.onStart();
        }
    };
    public long mPauseTime;
    public long mStopTimeInFuture;

    public static abstract class StatusListener {
        public void onCancel() {
        }

        public void onFinish() {
        }

        public void onPause() {
        }

        public void onResume() {
        }

        public void onStart() {
        }

        public void onTick(long j) {
        }
    }

    public CountDownTimer(long j, long j2) {
        this.mCountdownMillis = j;
        this.mCountdownInterval = j2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleCountDownMessage(android.os.Message r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r10 = r9.mIsCancelled     // Catch:{ all -> 0x0056 }
            if (r10 != 0) goto L_0x0054
            boolean r10 = r9.mIsPaused     // Catch:{ all -> 0x0056 }
            if (r10 == 0) goto L_0x000a
            goto L_0x0054
        L_0x000a:
            long r0 = r9.mStopTimeInFuture     // Catch:{ all -> 0x0056 }
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0056 }
            long r0 = r0 - r2
            r10 = 1
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0020
            r9.mIsFinished = r10     // Catch:{ all -> 0x0056 }
            com.baidu.android.util.time.CountDownTimer$StatusListener r10 = r9.mListener     // Catch:{ all -> 0x0056 }
            r10.onFinish()     // Catch:{ all -> 0x0056 }
            goto L_0x0052
        L_0x0020:
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0056 }
            com.baidu.android.util.time.CountDownTimer$StatusListener r6 = r9.mListener     // Catch:{ all -> 0x0056 }
            r6.onTick(r0)     // Catch:{ all -> 0x0056 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0056 }
            long r6 = r6 - r4
            long r4 = r9.mCountdownInterval     // Catch:{ all -> 0x0056 }
            int r8 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x003c
            long r0 = r0 - r6
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x003a
            goto L_0x0047
        L_0x003a:
            r2 = r0
            goto L_0x0047
        L_0x003c:
            long r0 = r9.mCountdownInterval     // Catch:{ all -> 0x0056 }
            long r0 = r0 - r6
        L_0x003f:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x003a
            long r4 = r9.mCountdownInterval     // Catch:{ all -> 0x0056 }
            long r0 = r0 + r4
            goto L_0x003f
        L_0x0047:
            android.os.Handler r0 = r9.mHandler     // Catch:{ all -> 0x0056 }
            android.os.Handler r1 = r9.mHandler     // Catch:{ all -> 0x0056 }
            android.os.Message r10 = r1.obtainMessage(r10)     // Catch:{ all -> 0x0056 }
            r0.sendMessageDelayed(r10, r2)     // Catch:{ all -> 0x0056 }
        L_0x0052:
            monitor-exit(r9)     // Catch:{ all -> 0x0056 }
            return
        L_0x0054:
            monitor-exit(r9)     // Catch:{ all -> 0x0056 }
            return
        L_0x0056:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0056 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.time.CountDownTimer.handleCountDownMessage(android.os.Message):void");
    }

    public final synchronized void cancel() {
        this.mIsCancelled = true;
        this.mHandler.removeMessages(1);
        this.mListener.onCancel();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void pause() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.mIsPaused     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0023
            boolean r0 = r2.mIsCancelled     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0023
            boolean r0 = r2.mIsFinished     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x000e
            goto L_0x0023
        L_0x000e:
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0025 }
            r2.mPauseTime = r0     // Catch:{ all -> 0x0025 }
            r0 = 1
            r2.mIsPaused = r0     // Catch:{ all -> 0x0025 }
            com.baidu.android.util.time.CountDownTimer$StatusListener r1 = r2.mListener     // Catch:{ all -> 0x0025 }
            r1.onPause()     // Catch:{ all -> 0x0025 }
            android.os.Handler r1 = r2.mHandler     // Catch:{ all -> 0x0025 }
            r1.removeMessages(r0)     // Catch:{ all -> 0x0025 }
            monitor-exit(r2)
            return
        L_0x0023:
            monitor-exit(r2)
            return
        L_0x0025:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.time.CountDownTimer.pause():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void resume() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.mIsPaused     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0030
            boolean r0 = r4.mIsCancelled     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x0030
            boolean r0 = r4.mIsFinished     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x000e
            goto L_0x0030
        L_0x000e:
            r0 = 0
            r4.mIsPaused = r0     // Catch:{ all -> 0x0032 }
            long r0 = r4.mStopTimeInFuture     // Catch:{ all -> 0x0032 }
            long r2 = r4.mPauseTime     // Catch:{ all -> 0x0032 }
            long r0 = r0 - r2
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0032 }
            long r2 = r2 + r0
            r4.mStopTimeInFuture = r2     // Catch:{ all -> 0x0032 }
            com.baidu.android.util.time.CountDownTimer$StatusListener r0 = r4.mListener     // Catch:{ all -> 0x0032 }
            r0.onResume()     // Catch:{ all -> 0x0032 }
            android.os.Handler r0 = r4.mHandler     // Catch:{ all -> 0x0032 }
            android.os.Handler r1 = r4.mHandler     // Catch:{ all -> 0x0032 }
            r2 = 1
            android.os.Message r1 = r1.obtainMessage(r2)     // Catch:{ all -> 0x0032 }
            r0.sendMessage(r1)     // Catch:{ all -> 0x0032 }
            monitor-exit(r4)
            return
        L_0x0030:
            monitor-exit(r4)
            return
        L_0x0032:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.time.CountDownTimer.resume():void");
    }

    public void setCountDownMillis(long j) {
        this.mCountdownMillis = j;
    }

    public CountDownTimer setStatusListener(StatusListener statusListener) {
        if (statusListener != null) {
            this.mListener = statusListener;
        }
        return this;
    }

    public final synchronized CountDownTimer start() {
        this.mIsCancelled = false;
        if (this.mCountdownMillis <= 0) {
            this.mIsFinished = true;
            this.mListener.onFinish();
            return this;
        }
        this.mIsFinished = false;
        this.mIsPaused = false;
        this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mCountdownMillis;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        this.mListener.onStart();
        return this;
    }
}
