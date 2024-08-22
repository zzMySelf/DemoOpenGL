package com.xiaomi.push;

import com.xiaomi.push.ke;
import java.io.ByteArrayOutputStream;

public class kd {

    /* renamed from: a  reason: collision with root package name */
    private ki f7459a;

    /* renamed from: a  reason: collision with other field name */
    private final kp f877a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f878a;

    public kd() {
        this(new ke.a());
    }

    public kd(kk kkVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f878a = byteArrayOutputStream;
        kp kpVar = new kp(byteArrayOutputStream);
        this.f877a = kpVar;
        this.f7459a = kkVar.a(kpVar);
    }

    public byte[] a(jx jxVar) {
        this.f878a.reset();
        jxVar.b(this.f7459a);
        return this.f878a.toByteArray();
    }
}
