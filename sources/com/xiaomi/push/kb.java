package com.xiaomi.push;

import com.xiaomi.push.ke;

public class kb {

    /* renamed from: a  reason: collision with root package name */
    private final ki f7458a;

    /* renamed from: a  reason: collision with other field name */
    private final kr f876a;

    public kb() {
        this(new ke.a());
    }

    public kb(kk kkVar) {
        kr krVar = new kr();
        this.f876a = krVar;
        this.f7458a = kkVar.a(krVar);
    }

    public void a(jx jxVar, byte[] bArr) {
        try {
            this.f876a.a(bArr);
            jxVar.a(this.f7458a);
        } finally {
            this.f7458a.k();
        }
    }
}
