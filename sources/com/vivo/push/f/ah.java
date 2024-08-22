package com.vivo.push.f;

import com.baidu.android.imsdk.IMConstants;
import com.vivo.push.l;
import com.vivo.push.o;

/* compiled from: PushClientTaskFactory */
public final class ah {
    public static l a(o oVar) {
        switch (oVar.b()) {
            case 0:
            case 2000:
            case 2001:
            case 2002:
            case 2003:
            case 2004:
            case 2005:
            case 2008:
            case 2009:
            case 2010:
            case 2011:
            case 2012:
            case IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME:
            case 2014:
            case 2015:
                return new ai(oVar);
            case 1:
                return new ab(oVar);
            case 2:
                return new l(oVar);
            case 3:
                return new t(oVar);
            case 4:
                return new u(oVar);
            case 5:
                return new x(oVar);
            case 6:
                return new y(oVar);
            case 7:
                return new r(oVar);
            case 8:
                return new p(oVar);
            case 9:
                return new k(oVar);
            case 10:
                return new h(oVar);
            case 11:
                return new ae(oVar);
            case 12:
                return new j(oVar);
            case 20:
                return new ag(oVar);
            case 100:
                return new b(oVar);
            case 101:
                return new c(oVar);
            case 2006:
                return new a(oVar);
            case 2007:
                return new aj(oVar);
            default:
                return null;
        }
    }

    public static aa b(o oVar) {
        switch (oVar.b()) {
            case 1:
                return new ab(oVar);
            case 2:
                return new l(oVar);
            case 3:
                return new t(oVar);
            case 4:
                return new u(oVar);
            case 5:
                return new x(oVar);
            case 6:
                return new y(oVar);
            case 7:
                return new r(oVar);
            case 8:
                return new p(oVar);
            case 9:
                return new k(oVar);
            case 10:
                return new h(oVar);
            case 11:
                return new ae(oVar);
            case 20:
                return new ag(oVar);
            case 2016:
                return new o(oVar);
            default:
                return null;
        }
    }
}
