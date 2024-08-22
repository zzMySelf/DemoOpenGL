package fe.fe.o.fe.qw.de;

import android.content.Context;
import android.os.SystemClock;
import com.baidu.down.loopj.android.a.a.b;
import fe.fe.o.rg.ad.rg;
import fe.fe.o.rg.de.i;
import fe.fe.o.rg.de.uk;

/* renamed from: fe.fe.o.fe.qw.de.if  reason: invalid class name */
public class Cif extends rg {
    public String e;
    public long f;
    public boolean g;
    public long h;
    public long j;
    public boolean k;
    public long l;
    public long rrr;
    public long tt = 0;

    public Cif(b bVar, uk ukVar, String str, when when) {
        super(bVar, ukVar);
        boolean z = true;
        this.g = true;
        this.j = 2147483647L;
        this.k = false;
        this.l = 0;
        this.e = str;
        this.k = ((o) ukVar).m() != 1 ? false : z;
        this.h = when.qw;
        this.j = when.f2562ad;
    }

    public long aaa() {
        return this.j;
    }

    public void ddd(long j2) {
        this.j = j2;
    }

    public void ggg(rg rgVar, long j2, int i2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.h = j2;
        long j3 = this.tt + ((long) i2);
        this.tt = j3;
        this.f = (j3 * 1000) / (elapsedRealtime - this.rrr);
        if (elapsedRealtime - this.l > 100) {
            this.l = SystemClock.elapsedRealtime();
            uk ukVar = new uk();
            ukVar.qw = rgVar;
            ukVar.f2658fe = this.e;
            ukVar.f2659rg = this.tt;
            ukVar.f2660th = (elapsedRealtime - this.rrr) - this.f2554o;
            i.ad((Context) null).qw().b(8, ukVar);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m162if() {
        this.g = false;
    }

    public boolean mmm() {
        return this.g;
    }

    public void nn(long j2) {
    }

    public boolean qqq() {
        return this.k;
    }

    public void run() {
        this.rrr = SystemClock.elapsedRealtime();
        super.run();
    }

    public void vvv(Boolean bool) {
        this.k = bool.booleanValue();
    }

    public void xxx(String str) {
        this.e = str;
        this.rrr = SystemClock.elapsedRealtime();
        this.l = SystemClock.elapsedRealtime();
    }
}
