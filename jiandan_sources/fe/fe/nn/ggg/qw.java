package fe.fe.nn.ggg;

import android.content.Context;
import android.os.Build;
import com.baidu.sso.p.a;
import com.baidu.sso.p.b;
import fe.fe.nn.ddd.de;
import fe.fe.nn.vvv.ad;

public class qw implements a {

    /* renamed from: de  reason: collision with root package name */
    public static qw f2244de;

    /* renamed from: ad  reason: collision with root package name */
    public boolean f2245ad = false;
    public a qw = null;

    public static qw ad() {
        if (f2244de == null) {
            synchronized (qw.class) {
                if (f2244de == null) {
                    f2244de = new qw();
                }
            }
        }
        return f2244de;
    }

    public String a() {
        a aVar = this.qw;
        if (aVar == null) {
            return null;
        }
        try {
            return aVar.a();
        } catch (Throwable unused) {
            return null;
        }
    }

    public void qw(Context context, b bVar) {
        a adVar;
        try {
            if (!this.f2245ad) {
                this.f2245ad = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        adVar = new ad();
                    } else if (ordinal == 2) {
                        adVar = new fe.fe.nn.nn.ad();
                    } else if (ordinal == 3) {
                        adVar = new de();
                    } else if (ordinal == 4) {
                        adVar = new fe.fe.nn.xxx.ad();
                    }
                    this.qw = adVar;
                } else {
                    this.qw = null;
                }
                a aVar = this.qw;
                if (aVar != null) {
                    aVar.qw(context, bVar);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
