package fe.when.ad.f;

import com.itextpdf.text.DocumentException;
import fe.when.ad.aaa;
import fe.when.ad.c.qw;
import fe.when.ad.de;
import fe.when.ad.i;

public final class l1 extends z1 {
    public float k;
    public float l;
    public boolean m = false;
    public de n;

    public l1() {
        this.ddd = 3;
    }

    public void B0(l1 l1Var) {
        t1();
        super.B0(l1Var);
    }

    public void D0(l1 l1Var, de deVar, float f) {
        t1();
        super.D0(l1Var, deVar, f);
    }

    public void E0(l1 l1Var) {
        t1();
        super.E0(l1Var);
    }

    public void G0(l1 l1Var, de deVar, float f) {
        t1();
        super.G0(l1Var, deVar, f);
    }

    public void H0(int i2, int i3, int i4) {
        t1();
        super.H0(i2, i3, i4);
    }

    public void I0(int i2, int i3, int i4) {
        t1();
        super.I0(i2, i3, i4);
    }

    public void R() {
        t1();
        super.R();
    }

    public void S() {
        t1();
        super.S();
    }

    public void T() {
        t1();
        super.T();
    }

    public void U() {
        t1();
        super.U();
    }

    public void e0(float f, float f2, float f3, float f4) {
        t1();
        super.e0(f, f2, f3, f4);
    }

    public void f0(float f, float f2, float f3, float f4) {
        t1();
        super.f0(f, f2, f3, f4);
    }

    public void h0(de deVar) {
        t1();
        super.h0(deVar);
    }

    public void k0(t1 t1Var, float f) {
        t1();
        super.k0(t1Var, f);
    }

    public void l0(de deVar) {
        t1();
        super.l0(deVar);
    }

    public void o0(t1 t1Var, float f) {
        t1();
        super.o0(t1Var, f);
    }

    public void q0(float f) {
        t1();
        super.q0(f);
    }

    public void r0(float f) {
        t1();
        super.r0(f);
    }

    public q s() {
        l1 l1Var = new l1();
        l1Var.f9708yj = this.f9708yj;
        l1Var.f9707uk = this.f9707uk;
        l1Var.nn = this.nn;
        l1Var.mmm = this.mmm;
        l1Var.aaa = new aaa(this.aaa);
        l1Var.k = this.k;
        l1Var.l = this.l;
        l1Var.qqq = this.qqq;
        l1Var.m = this.m;
        l1Var.n = this.n;
        return l1Var;
    }

    public void t1() {
        if (this.m) {
            throw new RuntimeException(qw.ad("colors.are.not.allowed.in.uncolored.tile.patterns", new Object[0]));
        }
    }

    public de u1() {
        return this.n;
    }

    public k1 v1(int i2) {
        return new k1(this, i2);
    }

    public float w1() {
        return this.k;
    }

    public float x1() {
        return this.l;
    }

    public boolean y1() {
        return this.m;
    }

    public void yj(i iVar, float f, float f2, float f3, float f4, float f5, float f6) throws DocumentException {
        if (this.m && !iVar.i0()) {
            t1();
        }
        super.yj(iVar, f, f2, f3, f4, f5, f6);
    }
}
