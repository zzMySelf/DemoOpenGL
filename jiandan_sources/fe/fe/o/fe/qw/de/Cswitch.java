package fe.fe.o.fe.qw.de;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.down.loopj.android.a.a.b;
import com.baidu.down.request.taskmanager.OnFetchDataRequestListener;
import fe.fe.o.ad.ad;
import fe.fe.o.rg.ad.de;
import fe.fe.o.rg.ad.fe;
import fe.fe.o.rg.ad.rg;
import fe.fe.o.rg.de.i;
import fe.fe.o.rg.de.yj;
import fe.fe.o.th.ggg;
import java.io.InputStream;
import org.apache.http.Header;

/* renamed from: fe.fe.o.fe.qw.de.switch  reason: invalid class name */
public class Cswitch extends fe {

    /* renamed from: if  reason: not valid java name */
    public boolean f79if;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f2559pf;

    /* renamed from: switch  reason: not valid java name */
    public ad f80switch;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Cswitch(de deVar) {
        super(deVar);
        deVar.getClass();
        this.f2559pf = true;
        this.f79if = true;
        this.f80switch = new ad();
        this.f80switch = new ad();
    }

    public boolean A() {
        return this.f79if;
    }

    public void B() {
        this.f2559pf = true;
        this.f2531th = 0;
        this.f79if = true;
        this.f80switch = new ad();
    }

    public boolean C() {
        if (i.ad((Context) null).qw().aaa().qw != 1) {
            return false;
        }
        return D() || E();
    }

    public boolean D() {
        String qw = ggg.qw(this.f2532uk.f82switch);
        return this.f2559pf && this.f2531th == 2 && !TextUtils.isEmpty(qw) && !this.f80switch.f2444fe.equals(qw) && i.ad((Context) null).qw().mmm() == null;
    }

    public boolean E() {
        return ((rg) this.f2532uk).t();
    }

    public void q(OnFetchDataRequestListener onFetchDataRequestListener) {
        if (i.ad((Context) null).qw().aaa().qw == 1) {
            ((rg) this.f2532uk).b(onFetchDataRequestListener);
        }
    }

    public void r(String str, int i2) {
        ((rg) this.f2532uk).c(str, i2);
    }

    public void s(boolean z) {
        this.f2559pf = z;
    }

    public void t(b bVar, rg rgVar) {
        boolean z;
        rg rgVar2;
        r(bVar.d(), 3);
        if (this.f2531th == 0) {
            rgVar2 = (rg) this.f2532uk;
            z = false;
        } else {
            rgVar2 = (rg) this.f2532uk;
            z = true;
        }
        String str = rgVar2.m173switch(z);
        if (bVar.de(str)) {
            ((Cif) rgVar).xxx(str);
        }
    }

    public void u(boolean z) {
        this.f79if = z;
        this.f2531th = z ? 0 : 2;
    }

    public void v(b bVar, rg rgVar) {
        String str = ((rg) this.f2532uk).m173switch(true);
        if (bVar.de(str)) {
            Cif ifVar = (Cif) rgVar;
            ifVar.xxx(str);
            ifVar.vvv(Boolean.TRUE);
        }
    }

    public void w(int i2) {
        this.f80switch.f2445i = i2;
    }

    public boolean x() {
        return this.f2559pf;
    }

    public long xxx(b bVar, long j, int i2, rg rgVar) {
        int read;
        long j2 = j;
        InputStream f = bVar.f();
        bVar.g();
        Cif ifVar = (Cif) rgVar;
        int i3 = -1;
        if (this.f2559pf && j2 != 0) {
            if (!ifVar.qqq()) {
                ((rg) this.f2532uk).d(ifVar.e, ifVar.f2554o);
            }
            yj xxx = ((rg) this.f2532uk).xxx(ifVar.e);
            if (xxx != null) {
                xxx.f88switch = 1;
            }
            this.f80switch.f2447pf = -1;
        }
        r(ifVar.e, 2);
        if (f != null) {
            fe.fe.o.rg.de.ad qw = i.ad((Context) null).qw().vvv().qw();
            qw.f2612ad = j2;
            qw.qw = 0;
            this.qw = true;
            ifVar.nn(j2);
            long o2 = this.f2532uk.eee.o(j2);
            if (o2 != 0) {
                ifVar.ddd(o2);
            }
            int length = qw.f2613de.length;
            byte[] bArr = new byte[length];
            while (this.qw && ifVar.mmm() && (read = f.read(bArr)) != i3) {
                int i4 = length - qw.qw;
                if (read <= i4) {
                    i4 = read;
                }
                int i5 = qw.qw;
                if (i5 + i4 >= length) {
                    System.arraycopy(bArr, 0, qw.f2613de, i5, i4);
                    qw.qw += i4;
                    e(qw);
                    j2 += (long) i4;
                    qw = i.ad((Context) null).qw().vvv().qw();
                    qw.f2612ad = j2;
                    qw.qw = 0;
                } else {
                    System.arraycopy(bArr, 0, qw.f2613de, i5, i4);
                    qw.qw += i4;
                    j2 += (long) i4;
                }
                if (i4 < read) {
                    int i6 = read - i4;
                    System.arraycopy(bArr, i4, qw.f2613de, qw.qw, i6);
                    qw.qw += i6;
                    j2 += (long) i6;
                }
                if (this.f2559pf && this.f2531th == 1 && ifVar.qqq()) {
                    ifVar.ggg((rg) this.f2532uk, j2, read);
                }
                if (j2 > ifVar.aaa()) {
                    break;
                }
                i3 = -1;
            }
            if (!this.qw || !ifVar.mmm() || qw.qw <= 0) {
                i.ad((Context) null).qw().vvv().de(qw);
            } else {
                e(qw);
                if (this.f2559pf && this.f2531th == 1 && ifVar.qqq()) {
                    ifVar.ggg((rg) this.f2532uk, j2, qw.qw);
                }
            }
        }
        long j3 = j2;
        if (this.qw && ifVar.mmm()) {
            aaa(i2, (Header[]) null, (String) null, j3);
        }
        if (this.f2561de) {
            this.qw = false;
        }
        return j3;
    }

    public void y() {
        ((rg) this.f2532uk).ggg();
    }

    public boolean z() {
        if (((rg) this.f2532uk).J >= 3 || m() != 2) {
            return false;
        }
        ((rg) this.f2532uk).J++;
        return true;
    }
}
