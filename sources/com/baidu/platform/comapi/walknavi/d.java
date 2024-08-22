package com.baidu.platform.comapi.walknavi;

/* compiled from: WNavigator */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f16283a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m f16284b;

    d(m mVar, String str) {
        this.f16284b = mVar;
        this.f16283a = str;
    }

    public void run() {
        this.f16284b.g().setInitialState(this.f16283a);
        this.f16284b.g().runCurrentState();
    }
}
