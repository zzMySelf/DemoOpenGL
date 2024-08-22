package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.hl;
import com.xiaomi.push.ji;
import com.xiaomi.push.service.XMPushService;

class aa extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ji f7539a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f952a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aa(int i2, XMPushService xMPushService, ji jiVar) {
        super(i2);
        this.f952a = xMPushService;
        this.f7539a = jiVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8861a() {
        try {
            ai.a(this.f952a, ai.a(this.f7539a.b(), this.f7539a.a()));
        } catch (hl e2) {
            b.a((Throwable) e2);
            this.f952a.a(10, (Exception) e2);
        }
    }

    public String a() {
        return "send app absent message.";
    }
}
