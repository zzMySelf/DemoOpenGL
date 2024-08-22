package com.baidu.searchbox.fluency.tracer;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.fluency.core.FrameRefreshMonitor;
import com.baidu.searchbox.fluency.utils.Logcat;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0017J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0017J\b\u0010\f\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/fluency/tracer/Tracer;", "Lcom/baidu/searchbox/fluency/core/FrameRefreshMonitor$FrameRefreshObserver;", "Lcom/baidu/searchbox/fluency/tracer/ITracer;", "()V", "TAG", "", "isAlive", "", "onAlive", "", "onCloseTrace", "onDead", "onStartTrace", "lib-fps_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Tracer.kt */
public abstract class Tracer extends FrameRefreshMonitor.FrameRefreshObserver implements ITracer {
    private final String TAG = "FrameRateTracer";
    private boolean isAlive;

    public void onAlive() {
        Logcat.INSTANCE.d(this.TAG, "[onAlive] " + getClass().getName());
    }

    public void onDead() {
        Logcat.INSTANCE.d(this.TAG, "[onDead] " + getClass().getName());
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void onStartTrace() {
        if (!this.isAlive) {
            this.isAlive = true;
            onAlive();
        }
    }

    public void onCloseTrace() {
        if (this.isAlive) {
            this.isAlive = false;
            onDead();
        }
    }
}
