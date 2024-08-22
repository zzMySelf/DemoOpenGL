package fe.mmm.qw.e.yj;

import android.content.Context;
import com.baidu.android.common.util.DeviceId;
import fe.fe.p004if.qw.yj.de;
import fe.mmm.qw.a.uk.rg;

public class qw {

    /* renamed from: de  reason: collision with root package name */
    public static Context f7758de;

    /* renamed from: fe  reason: collision with root package name */
    public static volatile qw f7759fe;

    /* renamed from: ad  reason: collision with root package name */
    public int f7760ad = 0;
    public boolean qw = false;

    /* renamed from: fe.mmm.qw.e.yj.qw$qw  reason: collision with other inner class name */
    public class C0276qw extends rg {
        public C0276qw(qw qwVar, String str) {
            super(str);
        }

        public void when() throws Exception {
            fe.fe.ddd.uk.qw.de().th(qw.f7758de);
        }
    }

    public static qw ad(Context context) {
        if (f7759fe == null) {
            synchronized (qw.class) {
                if (f7759fe == null) {
                    f7759fe = new qw();
                    f7758de = context.getApplicationContext();
                }
            }
        }
        return f7759fe;
    }

    public synchronized void de(boolean z, String str) {
        rg(" init");
        this.f7760ad++;
        this.qw = z;
        fe.fe.p004if.qw.yj.rg.qqq(f7758de, true);
        fe(str);
    }

    public final void fe(String str) {
        rg(" loginToLCP");
        int i2 = 1;
        if (this.qw) {
            de.qw = true;
        }
        if (this.f7760ad > 1) {
            i2 = 2;
        }
        Context context = f7758de;
        fe.fe.p004if.qw.ad.qw.qw(context, str, DeviceId.getCUID(context), i2);
        new C0276qw(this, "RegisterConnect").mmm();
    }

    public final void rg(String str) {
        boolean z = this.qw;
    }
}
