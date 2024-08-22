package com.baidu.pass.biometrics.face.liveness.enums;

import com.baidu.pass.biometrics.face.liveness.view.face.CircleProgressView;
import java.util.TimerTask;

/* compiled from: ProgressBackTask */
public class a extends TimerTask {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CircleProgressView f15943a;

    /* renamed from: com.baidu.pass.biometrics.face.liveness.enums.a$a  reason: collision with other inner class name */
    /* compiled from: ProgressBackTask */
    class C0247a implements Runnable {
        C0247a() {
        }

        public void run() {
            int progress;
            if (a.this.f15943a != null && (progress = a.this.f15943a.getProgress()) > 0) {
                a.this.f15943a.setProgress(progress - 1);
            }
        }
    }

    public a(CircleProgressView circleProgressView) {
        this.f15943a = circleProgressView;
    }

    public boolean cancel() {
        this.f15943a = null;
        return super.cancel();
    }

    public void run() {
        CircleProgressView circleProgressView = this.f15943a;
        if (circleProgressView != null) {
            circleProgressView.post(new C0247a());
        }
    }
}
