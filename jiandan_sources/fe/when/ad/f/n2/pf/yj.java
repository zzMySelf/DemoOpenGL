package fe.when.ad.f.n2.pf;

import fe.when.ad.de;
import fe.when.ad.f.q;
import java.util.ArrayList;
import java.util.Stack;

public class yj {

    /* renamed from: ad  reason: collision with root package name */
    public ArrayList<rg> f9605ad;

    /* renamed from: de  reason: collision with root package name */
    public uk f9606de;

    /* renamed from: fe  reason: collision with root package name */
    public th f9607fe;
    public int ggg;

    /* renamed from: i  reason: collision with root package name */
    public int f9608i;

    /* renamed from: if  reason: not valid java name */
    public int f434if;

    /* renamed from: o  reason: collision with root package name */
    public int f9609o;

    /* renamed from: pf  reason: collision with root package name */
    public int f9610pf;
    public int ppp;
    public Stack<yj> qw;

    /* renamed from: rg  reason: collision with root package name */
    public ad f9611rg;

    /* renamed from: switch  reason: not valid java name */
    public int f435switch;

    /* renamed from: th  reason: collision with root package name */
    public fe f9612th;

    /* renamed from: uk  reason: collision with root package name */
    public de f9613uk;
    public float vvv;
    public int when;
    public float xxx;

    /* renamed from: yj  reason: collision with root package name */
    public de f9614yj;

    public yj() {
        this.f9614yj = de.f9335ad;
        this.f9613uk = de.f9336de;
        this.f9608i = 2;
        this.f9609o = 1;
        this.f9610pf = 1;
        this.qw = new Stack<>();
        this.f9605ad = new ArrayList<>();
        this.f9606de = new uk(0, 0);
        this.f9607fe = new th();
        this.f9611rg = new ad();
        this.f9612th = new fe();
    }

    public void a(int i2) {
        this.when = i2;
    }

    public void aaa(int i2) {
        this.ggg = i2;
    }

    public void ad(q qVar) {
        int size = this.qw.size();
        while (true) {
            int i2 = size - 1;
            if (size > 0) {
                qVar.Y();
                size = i2;
            } else {
                return;
            }
        }
    }

    public void b(int i2) {
        this.f9609o = i2;
    }

    public void c(float f) {
        this.vvv = f;
    }

    public void d(float f) {
        this.xxx = f;
    }

    public void ddd(uk ukVar) {
        this.f9606de = ukVar;
    }

    public void de(int i2) {
        this.f9605ad.set(i2, (Object) null);
    }

    public void e(int i2) {
        this.f434if = i2;
    }

    public void eee(q qVar) {
        if (this.f9610pf != 0) {
            this.f9610pf = 0;
            qVar.w0(0);
        }
    }

    public float f(float f) {
        if (this.xxx < 0.0f) {
            f = -f;
        }
        return (float) (this.vvv < 0.0f ? 3.141592653589793d - ((double) f) : (double) f);
    }

    public int fe() {
        return this.f9608i;
    }

    public float g(int i2) {
        return ((((float) i2) - ((float) this.f435switch)) * this.vvv) / ((float) this.ppp);
    }

    public void ggg(int i2, q qVar) {
        rg rgVar = this.f9605ad.get(i2);
        if (rgVar != null) {
            int qw2 = rgVar.qw();
            if (qw2 == 1) {
                th thVar = (th) rgVar;
                this.f9607fe = thVar;
                int fe2 = thVar.fe();
                if (fe2 != 5) {
                    qVar.l0(this.f9607fe.ad());
                    qVar.x0(Math.abs((((float) this.f9607fe.de()) * this.vvv) / ((float) this.ppp)));
                    if (fe2 == 1) {
                        qVar.v0(18.0f, 6.0f, 0.0f);
                    } else if (fe2 == 2) {
                        qVar.u0(3.0f, 0.0f);
                    } else if (fe2 == 3) {
                        qVar.y0("[9 6 3 6]0 d\n");
                    } else if (fe2 != 4) {
                        qVar.t0(0.0f);
                    } else {
                        qVar.y0("[9 3 3 3 3 3]0 d\n");
                    }
                }
            } else if (qw2 == 2) {
                ad adVar = (ad) rgVar;
                this.f9611rg = adVar;
                int de2 = adVar.de();
                if (de2 == 0) {
                    qVar.h0(this.f9611rg.ad());
                } else if (de2 == 2) {
                    qVar.h0(this.f9614yj);
                }
            } else if (qw2 == 3) {
                this.f9612th = (fe) rgVar;
            }
        }
    }

    public float h(int i2) {
        return (1.0f - ((((float) i2) - ((float) this.when)) / ((float) this.ggg))) * this.xxx;
    }

    public uk i() {
        return this.f9606de;
    }

    /* renamed from: if  reason: not valid java name */
    public int m1099if() {
        return this.f9609o;
    }

    public void mmm(int i2) {
        this.ppp = i2;
    }

    public void nn(de deVar) {
        this.f9613uk = deVar;
    }

    public de o() {
        return this.f9613uk;
    }

    public boolean pf() {
        return this.f9610pf == 0;
    }

    public void ppp(q qVar) {
        qVar.d0();
        this.qw.push(new yj(this));
    }

    public void qqq(q qVar) {
        if (this.f9610pf == 0) {
            this.f9610pf = 1;
            qVar.w0(1);
        }
    }

    public void qw(rg rgVar) {
        for (int i2 = 0; i2 < this.f9605ad.size(); i2++) {
            if (this.f9605ad.get(i2) == null) {
                this.f9605ad.set(i2, rgVar);
                return;
            }
        }
        this.f9605ad.add(rgVar);
    }

    public de rg() {
        return this.f9614yj;
    }

    public void rrr(yj yjVar) {
        this.qw = yjVar.qw;
        this.f9605ad = yjVar.f9605ad;
        this.f9606de = yjVar.f9606de;
        this.f9607fe = yjVar.f9607fe;
        this.f9611rg = yjVar.f9611rg;
        this.f9612th = yjVar.f9612th;
        this.f9614yj = yjVar.f9614yj;
        this.f9613uk = yjVar.f9613uk;
        this.f9608i = yjVar.f9608i;
        this.f9609o = yjVar.f9609o;
        this.f434if = yjVar.f434if;
        this.f9610pf = yjVar.f9610pf;
        this.f435switch = yjVar.f435switch;
        this.when = yjVar.when;
        this.ppp = yjVar.ppp;
        this.ggg = yjVar.ggg;
        this.vvv = yjVar.vvv;
        this.xxx = yjVar.xxx;
    }

    /* renamed from: switch  reason: not valid java name */
    public int m1100switch() {
        return this.f434if;
    }

    public ad th() {
        return this.f9611rg;
    }

    public void tt(int i2) {
        this.f435switch = i2;
    }

    public th uk() {
        return this.f9607fe;
    }

    public void vvv(int i2) {
        this.f9608i = i2;
    }

    public void when(int i2, q qVar) {
        int i3;
        if (i2 < 0) {
            i3 = Math.min(-i2, this.qw.size());
        } else {
            i3 = Math.max(this.qw.size() - i2, 0);
        }
        if (i3 != 0) {
            yj yjVar = null;
            while (true) {
                int i4 = i3 - 1;
                if (i3 != 0) {
                    qVar.Y();
                    yjVar = this.qw.pop();
                    i3 = i4;
                } else {
                    rrr(yjVar);
                    return;
                }
            }
        }
    }

    public void xxx(de deVar) {
        this.f9614yj = deVar;
    }

    public fe yj() {
        return this.f9612th;
    }

    public yj(yj yjVar) {
        this.f9614yj = de.f9335ad;
        this.f9613uk = de.f9336de;
        this.f9608i = 2;
        this.f9609o = 1;
        this.f9610pf = 1;
        rrr(yjVar);
    }
}
