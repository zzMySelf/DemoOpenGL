package com.otaliastudios.cameraview.video;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.CameraLogger;
import fe.vvv.qw.rg;

public abstract class VideoRecorder {

    /* renamed from: th  reason: collision with root package name */
    public static final CameraLogger f6783th = CameraLogger.qw(VideoRecorder.class.getSimpleName());

    /* renamed from: ad  reason: collision with root package name */
    public final VideoResultListener f6784ad;

    /* renamed from: de  reason: collision with root package name */
    public Exception f6785de;

    /* renamed from: fe  reason: collision with root package name */
    public int f6786fe;
    @VisibleForTesting(otherwise = 4)
    public rg.qw qw;

    /* renamed from: rg  reason: collision with root package name */
    public final Object f6787rg = new Object();

    public interface VideoResultListener {
        void de();

        void ppp(@Nullable rg.qw qwVar, @Nullable Exception exc);

        void qw();
    }

    public VideoRecorder(@Nullable VideoResultListener videoResultListener) {
        this.f6784ad = videoResultListener;
        this.f6786fe = 0;
    }

    @CallSuper
    public void i() {
        f6783th.de("dispatchVideoRecordingStart:", "About to dispatch.");
        VideoResultListener videoResultListener = this.f6784ad;
        if (videoResultListener != null) {
            videoResultListener.qw();
        }
    }

    /* renamed from: if  reason: not valid java name */
    public abstract void m720if();

    public boolean o() {
        boolean z;
        synchronized (this.f6787rg) {
            z = this.f6786fe != 0;
        }
        return z;
    }

    public void pf() {
    }

    public final void ppp(boolean z) {
        synchronized (this.f6787rg) {
            if (this.f6786fe == 0) {
                f6783th.ad("stop:", "called twice, or called before start! Ignoring. isCameraShutdown:", Boolean.valueOf(z));
                return;
            }
            f6783th.de("stop:", "Changed state to STATE_STOPPING");
            this.f6786fe = 2;
            m721switch(z);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public abstract void m721switch(boolean z);

    @CallSuper
    public void uk() {
        f6783th.de("dispatchVideoRecordingEnd:", "About to dispatch.");
        VideoResultListener videoResultListener = this.f6784ad;
        if (videoResultListener != null) {
            videoResultListener.de();
        }
    }

    public final void when(@NonNull rg.qw qwVar) {
        synchronized (this.f6787rg) {
            if (this.f6786fe != 0) {
                f6783th.ad("start:", "called twice, or while stopping! Ignoring. state:", Integer.valueOf(this.f6786fe));
                return;
            }
            f6783th.de("start:", "Changed state to STATE_RECORDING");
            this.f6786fe = 1;
            this.qw = qwVar;
            m720if();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        pf();
        f6783th.de("dispatchResult:", "About to dispatch result:", r7.qw, r7.f6785de);
        r0 = r7.f6784ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004d, code lost:
        if (r0 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004f, code lost:
        r0.ppp(r7.qw, r7.f6785de);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0056, code lost:
        r7.qw = null;
        r7.f6785de = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void yj() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f6787rg
            monitor-enter(r0)
            boolean r1 = r7.o()     // Catch:{ all -> 0x005c }
            r2 = 1
            r3 = 2
            r4 = 0
            if (r1 != 0) goto L_0x001d
            com.otaliastudios.cameraview.CameraLogger r1 = f6783th     // Catch:{ all -> 0x005c }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x005c }
            java.lang.String r5 = "dispatchResult:"
            r3[r4] = r5     // Catch:{ all -> 0x005c }
            java.lang.String r4 = "Called, but not recording! Aborting."
            r3[r2] = r4     // Catch:{ all -> 0x005c }
            r1.i(r3)     // Catch:{ all -> 0x005c }
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            return
        L_0x001d:
            com.otaliastudios.cameraview.CameraLogger r1 = f6783th     // Catch:{ all -> 0x005c }
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x005c }
            java.lang.String r6 = "dispatchResult:"
            r5[r4] = r6     // Catch:{ all -> 0x005c }
            java.lang.String r6 = "Changed state to STATE_IDLE."
            r5[r2] = r6     // Catch:{ all -> 0x005c }
            r1.de(r5)     // Catch:{ all -> 0x005c }
            r7.f6786fe = r4     // Catch:{ all -> 0x005c }
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            r7.pf()
            com.otaliastudios.cameraview.CameraLogger r0 = f6783th
            r1 = 4
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r5 = "dispatchResult:"
            r1[r4] = r5
            java.lang.String r4 = "About to dispatch result:"
            r1[r2] = r4
            fe.vvv.qw.rg$qw r2 = r7.qw
            r1[r3] = r2
            r2 = 3
            java.lang.Exception r3 = r7.f6785de
            r1[r2] = r3
            r0.de(r1)
            com.otaliastudios.cameraview.video.VideoRecorder$VideoResultListener r0 = r7.f6784ad
            if (r0 == 0) goto L_0x0056
            fe.vvv.qw.rg$qw r1 = r7.qw
            java.lang.Exception r2 = r7.f6785de
            r0.ppp(r1, r2)
        L_0x0056:
            r0 = 0
            r7.qw = r0
            r7.f6785de = r0
            return
        L_0x005c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.video.VideoRecorder.yj():void");
    }
}
