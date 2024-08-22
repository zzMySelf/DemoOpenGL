package com.baidu.talos.core.devsupport.performance.fps.jankstats;

import android.view.View;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DelegatingOnPreDrawListener$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ DelegatingOnPreDrawListener f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ DelegatingOnPreDrawListener$$ExternalSyntheticLambda0(View view2, DelegatingOnPreDrawListener delegatingOnPreDrawListener, long j2) {
        this.f$0 = view2;
        this.f$1 = delegatingOnPreDrawListener;
        this.f$2 = j2;
    }

    public final void run() {
        DelegatingOnPreDrawListener.m8122onPreDraw$lambda3$lambda2$lambda0(this.f$0, this.f$1, this.f$2);
    }
}
