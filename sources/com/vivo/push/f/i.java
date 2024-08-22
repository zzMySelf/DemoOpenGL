package com.vivo.push.f;

import android.text.TextUtils;

/* compiled from: OnBindAppReceiveTask */
final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6439a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.i f6440b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ h f6441c;

    i(h hVar, String str, com.vivo.push.b.i iVar) {
        this.f6441c = hVar;
        this.f6439a = str;
        this.f6440b = iVar;
    }

    public final void run() {
        if (!TextUtils.isEmpty(this.f6439a)) {
            this.f6441c.f6420b.onReceiveRegId(this.f6441c.f6478a, this.f6439a);
        }
        this.f6441c.f6420b.onBind(this.f6441c.f6478a, this.f6440b.i(), this.f6440b.d());
    }
}
