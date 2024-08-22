package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.gp;
import com.xiaomi.push.hl;
import com.xiaomi.push.service.XMPushService;

class c extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    private XMPushService f7644a = null;

    /* renamed from: a  reason: collision with other field name */
    private gp[] f1032a;

    public c(XMPushService xMPushService, gp[] gpVarArr) {
        super(4);
        this.f7644a = xMPushService;
        this.f1032a = gpVarArr;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8924a() {
        try {
            gp[] gpVarArr = this.f1032a;
            if (gpVarArr != null) {
                this.f7644a.a(gpVarArr);
            }
        } catch (hl e2) {
            b.a((Throwable) e2);
            this.f7644a.a(10, (Exception) e2);
        }
    }

    public String a() {
        return "batch send message.";
    }
}
