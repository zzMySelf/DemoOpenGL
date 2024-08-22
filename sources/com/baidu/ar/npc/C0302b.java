package com.baidu.ar.npc;

/* renamed from: com.baidu.ar.npc.b  reason: case insensitive filesystem */
/* compiled from: ArBridge */
class C0302b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ float f10032a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ float f10033b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ArBridge f10034c;

    C0302b(ArBridge arBridge, float f2, float f3) {
        this.f10034c = arBridge;
        this.f10032a = f2;
        this.f10033b = f3;
    }

    public void run() {
        this.f10034c.nativeSetFrustum(this.f10032a, this.f10033b);
    }
}
