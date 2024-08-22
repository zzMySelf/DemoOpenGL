package com.vivo.push.f;

import com.vivo.push.b.i;

/* compiled from: OnUnBindAppReceiveTask */
final class af implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f6432a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ae f6433b;

    af(ae aeVar, i iVar) {
        this.f6433b = aeVar;
        this.f6432a = iVar;
    }

    public final void run() {
        this.f6433b.f6420b.onUnBind(this.f6433b.f6478a, this.f6432a.i(), this.f6432a.d());
    }
}
