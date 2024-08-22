package com.baidu.ar.npc;

import java.util.HashMap;

/* compiled from: ArBridge */
class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f10075a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f10076b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ HashMap f10077c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ int f10078d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ int f10079e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ ArBridge f10080f;

    t(ArBridge arBridge, String str, int i2, HashMap hashMap, int i3, int i4) {
        this.f10080f = arBridge;
        this.f10075a = str;
        this.f10076b = i2;
        this.f10077c = hashMap;
        this.f10078d = i3;
        this.f10079e = i4;
    }

    public void run() {
        this.f10080f.nativeCreateCase(this.f10075a, this.f10076b, this.f10077c, this.f10078d, this.f10079e);
    }
}
