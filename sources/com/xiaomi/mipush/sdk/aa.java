package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.iq;

class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C0107a f6624a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ iq f78a;

    aa(MiTinyDataClient.a.C0107a aVar, iq iqVar) {
        this.f6624a = aVar;
        this.f78a = iqVar;
    }

    public void run() {
        this.f6624a.f73a.add(this.f78a);
        MiTinyDataClient.a.C0107a.a(this.f6624a);
    }
}
