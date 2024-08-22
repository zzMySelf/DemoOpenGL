package io.flutter.view;

import android.view.Choreographer;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.FlutterJNI;

public class VsyncWaiter {
    public static VsyncWaiter instance;
    public final FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = new FlutterJNI.AsyncWaitForVsyncDelegate() {
        public void asyncWaitForVsync(final long j) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
                public void doFrame(long j) {
                    long nanoTime = System.nanoTime() - j;
                    FlutterJNI.nativeOnVsync(nanoTime < 0 ? 0 : nanoTime, VsyncWaiter.this.refreshPeriodNanos, j);
                }
            });
        }
    };
    public final float fps;
    public final long refreshPeriodNanos;

    public VsyncWaiter(float f) {
        this.fps = f;
        this.refreshPeriodNanos = (long) (1.0E9d / ((double) f));
    }

    @NonNull
    public static VsyncWaiter getInstance(float f) {
        if (instance == null) {
            instance = new VsyncWaiter(f);
        }
        return instance;
    }

    public void init() {
        FlutterJNI.setAsyncWaitForVsyncDelegate(this.asyncWaitForVsyncDelegate);
        FlutterJNI.setRefreshRateFPS(this.fps);
    }
}
