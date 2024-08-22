package com.xiaomi.push;

class hk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ hh f7114a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f504a;

    hk(hh hhVar, String str) {
        this.f7114a = hhVar;
        this.f504a = str;
    }

    public void run() {
        dc.a().a(this.f504a, true);
    }
}
