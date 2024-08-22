package com.vivo.push.f;

import com.vivo.push.b.c;
import com.vivo.push.d.a;
import com.vivo.push.e;
import com.vivo.push.l;
import com.vivo.push.model.b;
import com.vivo.push.o;
import com.vivo.push.util.aa;
import com.vivo.push.util.y;

/* compiled from: UnbindAppSendCommandTask */
final class aj extends l {
    aj(o oVar) {
        super(oVar);
    }

    /* access modifiers changed from: protected */
    public final void a(o oVar) {
        c cVar = (c) oVar;
        b a2 = aa.a(this.f6478a, (com.vivo.push.util.o) a.a().f());
        if (a2 == null) {
            e.a().a(cVar.f(), 1005, new Object[0]);
            return;
        }
        String a3 = a2.a();
        if (a2.c()) {
            e.a().a(cVar.f(), 1004, new Object[0]);
            oVar = new com.vivo.push.b.e();
        } else {
            int a4 = y.a(cVar);
            if (a4 != 0) {
                e.a().a(cVar.f(), a4, new Object[0]);
                return;
            }
        }
        com.vivo.push.a.a.a(this.f6478a, a3, oVar);
    }
}
