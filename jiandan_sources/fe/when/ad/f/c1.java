package fe.when.ad.f;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import fe.when.ad.aaa;
import fe.when.ad.de;
import fe.when.ad.e.ad;
import fe.when.ad.i;
import fe.when.ad.qw;
import java.util.HashMap;

public class c1 implements IAccessibleElement {

    /* renamed from: ad  reason: collision with root package name */
    public final Logger f9367ad;
    public qw ggg;

    /* renamed from: i  reason: collision with root package name */
    public float[] f9368i;

    /* renamed from: if  reason: not valid java name */
    public boolean f404if;

    /* renamed from: o  reason: collision with root package name */
    public float f9369o;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f9370pf;
    public HashMap<s0, y0> ppp;

    /* renamed from: switch  reason: not valid java name */
    public int[] f405switch;

    /* renamed from: th  reason: collision with root package name */
    public boolean f9371th;

    /* renamed from: uk  reason: collision with root package name */
    public float[] f9372uk;
    public s0 when;

    /* renamed from: yj  reason: collision with root package name */
    public a1[] f9373yj;

    public c1(a1[] a1VarArr) {
        this(a1VarArr, (c1) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r0.f9708yj;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean pf(fe.when.ad.f.q r0) {
        /*
            if (r0 == 0) goto L_0x000e
            fe.when.ad.f.c2 r0 = r0.f9708yj
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.a0()
            if (r0 == 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.c1.pf(fe.when.ad.f.q):boolean");
    }

    public static float ppp(pf pfVar, float f, float f2, float f3, float f4) {
        if (f > f3) {
            f3 = f;
        }
        if (f2 > f4) {
            f4 = f2;
        }
        pfVar.n(f, f2, f3, f4);
        return f4;
    }

    public void aaa(float f, float f2, float f3, a1 a1Var, q[] qVarArr) {
        de ad2 = a1Var.ad();
        if (ad2 != null || a1Var.a()) {
            float ddd = a1Var.ddd() + f;
            float aaa = a1Var.aaa() + f2;
            float vvv = a1Var.vvv() + f;
            float f4 = aaa - f3;
            if (ad2 != null) {
                q qVar = qVarArr[1];
                qVar.h0(ad2);
                qVar.N(vvv, f4, ddd - vvv, aaa - f4);
                qVar.p();
            }
            if (a1Var.a()) {
                aaa aaa2 = new aaa(vvv, f4, ddd, aaa);
                aaa2.qw(a1Var);
                aaa2.e((de) null);
                qVarArr[2].O(aaa2);
            }
        }
    }

    public void ad(d1 d1Var, int i2) {
        if (d1Var != null) {
            for (int i3 = 0; i3 < this.f9373yj.length; i3++) {
                a1 a1Var = d1Var.eee(i2).de()[i3];
                int i4 = i2;
                while (a1Var == null && i4 > 0) {
                    i4--;
                    a1Var = d1Var.eee(i4).de()[i3];
                }
                a1[] a1VarArr = this.f9373yj;
                if (!(a1VarArr[i3] == null || a1Var == null)) {
                    a1VarArr[i3].M(a1Var.s());
                    this.f9370pf = false;
                }
            }
        }
    }

    public boolean ddd(float[] fArr) {
        int length = fArr.length;
        a1[] a1VarArr = this.f9373yj;
        int i2 = 0;
        if (length != a1VarArr.length) {
            return false;
        }
        System.arraycopy(fArr, 0, this.f9372uk, 0, a1VarArr.length);
        this.f9370pf = false;
        float f = 0.0f;
        while (i2 < fArr.length) {
            a1 a1Var = this.f9373yj[i2];
            if (a1Var == null) {
                f += fArr[i2];
            } else {
                a1Var.k(f);
                int r = a1Var.r() + i2;
                while (i2 < r) {
                    f += fArr[i2];
                    i2++;
                }
                i2--;
                a1Var.l(f);
                a1Var.n(0.0f);
            }
            i2++;
        }
        return true;
    }

    public a1[] de() {
        return this.f9373yj;
    }

    public float[] fe(float f, float[] fArr) {
        int i2 = 1;
        int i3 = 0;
        int i4 = 1;
        while (true) {
            a1[] a1VarArr = this.f9373yj;
            if (i3 < a1VarArr.length) {
                if (a1VarArr[i3] == null) {
                    while (true) {
                        a1[] a1VarArr2 = this.f9373yj;
                        if (i3 >= a1VarArr2.length || a1VarArr2[i3] != null) {
                            break;
                        }
                        i4++;
                        i3++;
                    }
                } else {
                    i4++;
                    i3 += a1VarArr[i3].r();
                }
            } else {
                break;
            }
        }
        float[] fArr2 = new float[i4];
        fArr2[0] = f;
        int i5 = 0;
        while (true) {
            a1[] a1VarArr3 = this.f9373yj;
            if (i5 >= a1VarArr3.length || i2 >= i4) {
                return fArr2;
            }
            if (a1VarArr3[i5] == null) {
                fArr2[i2] = fArr2[i2 - 1];
                while (true) {
                    a1[] a1VarArr4 = this.f9373yj;
                    if (i5 >= a1VarArr4.length || a1VarArr4[i5] != null) {
                        break;
                    }
                    fArr2[i2] = fArr2[i2] + fArr[i5];
                    i5++;
                }
            } else {
                int r = a1VarArr3[i5].r();
                fArr2[i2] = fArr2[i2 - 1];
                int i6 = 0;
                while (i6 < r && i5 < fArr.length) {
                    fArr2[i2] = fArr2[i2] + fArr[i5];
                    i6++;
                    i5++;
                }
            }
            i2++;
        }
        return fArr2;
    }

    public y0 getAccessibleAttribute(s0 s0Var) {
        HashMap<s0, y0> hashMap = this.ppp;
        if (hashMap != null) {
            return hashMap.get(s0Var);
        }
        return null;
    }

    public HashMap<s0, y0> getAccessibleAttributes() {
        return this.ppp;
    }

    public qw getId() {
        return this.ggg;
    }

    public s0 getRole() {
        return this.when;
    }

    public void ggg(int i2, float f) {
        if (i2 >= 0 && i2 < this.f9373yj.length) {
            this.f9368i[i2] = f;
        }
    }

    public boolean i() {
        return this.f404if;
    }

    /* renamed from: if  reason: not valid java name */
    public void m1067if(q[] qVarArr) {
        for (int i2 = 0; i2 < 4; i2++) {
            rg w = qVarArr[i2].w();
            int nn = w.nn();
            qVarArr[i2].Y();
            int[] iArr = this.f405switch;
            int i3 = i2 * 2;
            if (nn == iArr[i3 + 1]) {
                w.ddd(iArr[i3]);
            }
        }
    }

    public boolean isInline() {
        return false;
    }

    public void mmm(d1 d1Var, int i2, d1 d1Var2, int i3) {
        if (d1Var != null && d1Var2 != null) {
            int i4 = 0;
            while (true) {
                a1[] a1VarArr = this.f9373yj;
                if (i4 >= a1VarArr.length) {
                    return;
                }
                if (a1VarArr[i4] == null) {
                    int i5 = d1Var.m1073if(i2, i4);
                    int i6 = d1Var2.m1073if(i3, i4);
                    a1 a1Var = d1Var.eee(i5).de()[i4];
                    a1 a1Var2 = d1Var2.eee(i6).de()[i4];
                    if (a1Var != null) {
                        this.f9373yj[i4] = new a1(a1Var2);
                        int i7 = (i3 - i6) + 1;
                        this.f9373yj[i4].R(a1Var2.D() - i7);
                        a1Var.R(i7);
                        this.f9370pf = false;
                    }
                    i4++;
                } else {
                    i4 += a1VarArr[i4].r();
                }
            }
        }
    }

    public c1 nn(d1 d1Var, int i2, float f) {
        float f2;
        d1 d1Var2 = d1Var;
        int i3 = i2;
        float f3 = f;
        this.f9367ad.fe("Splitting " + i3 + " " + f3);
        a1[] a1VarArr = this.f9373yj;
        a1[] a1VarArr2 = new a1[a1VarArr.length];
        float[] fArr = new float[a1VarArr.length];
        float[] fArr2 = new float[a1VarArr.length];
        int i4 = 0;
        boolean z = true;
        while (true) {
            a1[] a1VarArr3 = this.f9373yj;
            if (i4 >= a1VarArr3.length) {
                break;
            }
            a1 a1Var = a1VarArr3[i4];
            if (a1Var != null) {
                fArr[i4] = a1Var.x();
                fArr2[i4] = a1Var.C();
                i A = a1Var.A();
                a1 a1Var2 = new a1(a1Var);
                if (A != null) {
                    float t = a1Var.t() + a1Var.w() + 2.0f;
                    if ((A.k0() || A.S() + t < f3) && f3 > t) {
                        a1Var2.Q((Phrase) null);
                        z = false;
                    }
                } else {
                    pf fe2 = pf.fe(a1Var.s());
                    float vvv = a1Var.vvv() + a1Var.u();
                    float aaa = (a1Var.aaa() + a1Var.t()) - f3;
                    float ddd = a1Var.ddd() - a1Var.v();
                    float aaa2 = a1Var.aaa() - a1Var.w();
                    int mmm = a1Var.mmm();
                    if (mmm == 90 || mmm == 270) {
                        f2 = ppp(fe2, aaa, vvv, aaa2, ddd);
                    } else {
                        float f4 = aaa + 1.0E-5f;
                        if (a1Var.I()) {
                            ddd = 20000.0f;
                        }
                        f2 = ppp(fe2, vvv, f4, ddd, aaa2);
                    }
                    try {
                        int ddd2 = fe2.ddd(true);
                        boolean z2 = fe2.vvv() == f2;
                        if (z2) {
                            a1Var2.M(pf.fe(a1Var.s()));
                            fe2.e(0.0f);
                        } else if ((ddd2 & 1) == 0) {
                            a1Var2.M(fe2);
                            fe2.e(0.0f);
                        } else {
                            a1Var2.Q((Phrase) null);
                        }
                        z = z && z2;
                    } catch (DocumentException e) {
                        throw new ExceptionConverter(e);
                    }
                }
                a1VarArr2[i4] = a1Var2;
                a1Var.N(f3);
            } else if (d1Var2.v(i3, i4)) {
                int i5 = i3;
                while (true) {
                    i5--;
                    if (!d1Var2.v(i5, i4)) {
                        break;
                    }
                    d1Var2.eee(i5).rg();
                }
                c1 eee = d1Var2.eee(i5);
                if (!(eee == null || eee.de()[i4] == null)) {
                    a1VarArr2[i4] = new a1(eee.de()[i4]);
                    a1VarArr2[i4].M((pf) null);
                    a1VarArr2[i4].R((eee.de()[i4].D() - i3) + i5);
                    z = false;
                }
            }
            i4++;
            d1Var2 = d1Var;
            i3 = i2;
        }
        if (z) {
            int i6 = 0;
            while (true) {
                a1[] a1VarArr4 = this.f9373yj;
                if (i6 >= a1VarArr4.length) {
                    return null;
                }
                a1 a1Var3 = a1VarArr4[i6];
                if (a1Var3 != null) {
                    if (fArr[i6] > 0.0f) {
                        a1Var3.N(fArr[i6]);
                    } else {
                        a1Var3.O(fArr2[i6]);
                    }
                }
                i6++;
            }
        } else {
            qw();
            c1 c1Var = new c1(a1VarArr2, this);
            c1Var.f9372uk = (float[]) this.f9372uk.clone();
            return c1Var;
        }
    }

    public boolean o() {
        return this.f9371th;
    }

    public void qqq(int i2, int i3, float f, float f2, q[] qVarArr, boolean z) {
        int i4;
        int i5;
        pf pfVar;
        float f3;
        float f4;
        float f5;
        float f6;
        pf pfVar2;
        boolean z2;
        float f7;
        float f8;
        float f9;
        int i6 = i3;
        q[] qVarArr2 = qVarArr;
        if (!this.f9370pf) {
            qw();
        }
        if (i6 < 0) {
            i4 = this.f9373yj.length;
        } else {
            i4 = Math.min(i6, this.f9373yj.length);
        }
        int i7 = i2 < 0 ? 0 : i2;
        if (i7 < i4) {
            int i8 = i7;
            float f10 = f;
            while (i8 >= 0 && this.f9373yj[i8] == null) {
                if (i8 > 0) {
                    f10 -= this.f9372uk[i8 - 1];
                }
                i8--;
            }
            if (i8 < 0) {
                i8 = 0;
            }
            a1[] a1VarArr = this.f9373yj;
            if (a1VarArr[i8] != null) {
                f10 -= a1VarArr[i8].vvv();
            }
            float f11 = f10;
            char c = 3;
            if (pf(qVarArr2[3])) {
                qVarArr2[3].K(this);
            }
            int i9 = i8;
            while (i9 < i4) {
                a1 a1Var = this.f9373yj[i9];
                if (a1Var == null) {
                    i5 = i9;
                } else {
                    if (pf(qVarArr2[c])) {
                        qVarArr2[c].K(a1Var);
                    }
                    float f12 = this.f9369o + this.f9368i[i9];
                    aaa(f11, f2, f12, a1Var, qVarArr);
                    i A = a1Var.A();
                    float aaa = (a1Var.aaa() + f2) - a1Var.w();
                    if (a1Var.ggg() <= f12) {
                        int F = a1Var.F();
                        if (F == 5) {
                            f9 = a1Var.aaa() + f2 + ((a1Var.ggg() - f12) / 2.0f);
                            f8 = a1Var.w();
                        } else if (F == 6) {
                            f9 = ((a1Var.aaa() + f2) - f12) + a1Var.ggg();
                            f8 = a1Var.w();
                        }
                        aaa = f9 - f8;
                    }
                    if (A != null) {
                        if (a1Var.mmm() != 0) {
                            A = i.I(A);
                            i5 = i9;
                            A.E0(A.B() + ((float) ((((double) a1Var.mmm()) * 3.141592653589793d) / 180.0d)));
                        } else {
                            i5 = i9;
                        }
                        if (a1Var.ggg() <= f12) {
                            z2 = false;
                        } else if (A.k0()) {
                            A.r0(100.0f);
                            A.r0((((f12 - a1Var.w()) - a1Var.t()) / A.S()) * 100.0f);
                            z2 = true;
                        }
                        float vvv = a1Var.vvv() + f11 + a1Var.u();
                        if (z2) {
                            int z3 = a1Var.z();
                            if (z3 != 1) {
                                if (z3 == 2) {
                                    f7 = ((a1Var.ddd() + f11) - a1Var.v()) - A.T();
                                }
                                aaa = (a1Var.aaa() + f2) - a1Var.w();
                            } else {
                                f7 = (((((a1Var.vvv() + a1Var.u()) + a1Var.ddd()) - a1Var.v()) - A.T()) / 2.0f) + f11;
                            }
                            vvv = f7;
                            aaa = (a1Var.aaa() + f2) - a1Var.w();
                        }
                        A.u0(vvv, aaa - A.S());
                        try {
                            if (pf(qVarArr2[3])) {
                                qVarArr2[3].K(A);
                            }
                            qVarArr2[3].th(A);
                            if (pf(qVarArr2[3])) {
                                qVarArr2[3].eee(A);
                            }
                        } catch (DocumentException e) {
                            throw new ExceptionConverter(e);
                        }
                    } else {
                        i5 = i9;
                        if (a1Var.mmm() == 90 || a1Var.mmm() == 270) {
                            float w = (f12 - a1Var.w()) - a1Var.t();
                            float rrr = (a1Var.rrr() - a1Var.u()) - a1Var.v();
                            pf fe2 = pf.fe(a1Var.s());
                            fe2.c(qVarArr2);
                            fe2.n(0.0f, 0.0f, 0.001f + w, -rrr);
                            try {
                                fe2.ddd(true);
                                float f13 = -fe2.vvv();
                                if (w <= 0.0f || rrr <= 0.0f) {
                                    f13 = 0.0f;
                                }
                                if (f13 > 0.0f) {
                                    if (a1Var.K()) {
                                        f13 -= fe2.pf();
                                    }
                                    if (z) {
                                        pfVar = pf.fe(a1Var.s());
                                    } else {
                                        pfVar = a1Var.s();
                                    }
                                    pf pfVar3 = pfVar;
                                    pfVar3.c(qVarArr2);
                                    pfVar3.n(-0.003f, -0.001f, w + 0.003f, f13);
                                    if (a1Var.mmm() == 90) {
                                        float aaa2 = ((a1Var.aaa() + f2) - f12) + a1Var.t();
                                        int F2 = a1Var.F();
                                        if (F2 == 5) {
                                            f6 = a1Var.vvv() + f11 + ((((a1Var.rrr() + a1Var.u()) - a1Var.v()) + f13) / 2.0f);
                                        } else if (F2 != 6) {
                                            f6 = a1Var.vvv() + f11 + a1Var.u() + f13;
                                        } else {
                                            f6 = ((a1Var.vvv() + f11) + a1Var.rrr()) - a1Var.v();
                                        }
                                        m1068switch(qVarArr, 0.0f, 1.0f, -1.0f, 0.0f, f6, aaa2);
                                    } else {
                                        float aaa3 = (a1Var.aaa() + f2) - a1Var.w();
                                        int F3 = a1Var.F();
                                        if (F3 == 5) {
                                            f5 = a1Var.vvv() + f11;
                                            f4 = (((a1Var.rrr() + a1Var.u()) - a1Var.v()) - f13) / 2.0f;
                                        } else if (F3 != 6) {
                                            f3 = (((a1Var.vvv() + f11) + a1Var.rrr()) - a1Var.v()) - f13;
                                            m1068switch(qVarArr, 0.0f, -1.0f, 1.0f, 0.0f, f3, aaa3);
                                        } else {
                                            f5 = a1Var.vvv() + f11;
                                            f4 = a1Var.u();
                                        }
                                        f3 = f5 + f4;
                                        m1068switch(qVarArr, 0.0f, -1.0f, 1.0f, 0.0f, f3, aaa3);
                                    }
                                    try {
                                        pfVar3.xxx();
                                        m1067if(qVarArr2);
                                    } catch (DocumentException e2) {
                                        throw new ExceptionConverter(e2);
                                    } catch (Throwable th2) {
                                        m1067if(qVarArr2);
                                        throw th2;
                                    }
                                }
                            } catch (DocumentException e3) {
                                throw new ExceptionConverter(e3);
                            }
                        } else {
                            float x = a1Var.x();
                            float ddd = (a1Var.ddd() + f11) - a1Var.v();
                            float vvv2 = a1Var.vvv() + f11 + a1Var.u();
                            if (a1Var.I()) {
                                int z4 = a1Var.z();
                                if (z4 == 1) {
                                    ddd += 10000.0f;
                                    vvv2 -= 10000.0f;
                                } else if (z4 == 2 ? a1Var.mmm() != 180 : a1Var.mmm() == 180) {
                                    vvv2 -= 20000.0f;
                                } else {
                                    ddd += 20000.0f;
                                }
                            }
                            if (z) {
                                pfVar2 = pf.fe(a1Var.s());
                            } else {
                                pfVar2 = a1Var.s();
                            }
                            pf pfVar4 = pfVar2;
                            pfVar4.c(qVarArr2);
                            float w2 = aaa - ((f12 - a1Var.w()) - a1Var.t());
                            if (x > 0.0f && a1Var.ggg() > f12) {
                                aaa = (a1Var.aaa() + f2) - a1Var.w();
                                w2 = a1Var.t() + ((a1Var.aaa() + f2) - f12);
                            }
                            if ((aaa > w2 || pfVar4.y()) && vvv2 < ddd) {
                                pfVar4.n(vvv2, w2 - 0.001f, ddd, aaa);
                                if (a1Var.mmm() == 180) {
                                    m1068switch(qVarArr, -1.0f, 0.0f, 0.0f, -1.0f, vvv2 + ddd, (((f2 + f2) - f12) + a1Var.t()) - a1Var.w());
                                }
                                try {
                                    pfVar4.xxx();
                                    if (a1Var.mmm() == 180) {
                                        m1067if(qVarArr2);
                                    }
                                } catch (DocumentException e4) {
                                    throw new ExceptionConverter(e4);
                                } catch (Throwable th3) {
                                    if (a1Var.mmm() == 180) {
                                        m1067if(qVarArr2);
                                    }
                                    throw th3;
                                }
                            }
                        }
                    }
                    PdfPCellEvent q = a1Var.q();
                    if (q != null) {
                        q.qw(a1Var, new aaa(a1Var.vvv() + f11, (a1Var.aaa() + f2) - f12, a1Var.ddd() + f11, a1Var.aaa() + f2), qVarArr2);
                    }
                    if (pf(qVarArr2[3])) {
                        qVarArr2[3].eee(a1Var);
                    }
                }
                i9 = i5 + 1;
                c = 3;
            }
            if (pf(qVarArr2[3])) {
                qVarArr2[3].eee(this);
            }
        }
    }

    public void qw() {
        this.f9369o = 0.0f;
        int i2 = 0;
        while (true) {
            a1[] a1VarArr = this.f9373yj;
            if (i2 < a1VarArr.length) {
                a1 a1Var = a1VarArr[i2];
                if (a1Var != null) {
                    float B = a1Var.B();
                    if (B > this.f9369o && a1Var.D() == 1) {
                        this.f9369o = B;
                    }
                }
                i2++;
            } else {
                this.f9370pf = true;
                return;
            }
        }
    }

    public float rg() {
        if (!this.f9370pf) {
            qw();
        }
        return this.f9369o;
    }

    public void setAccessibleAttribute(s0 s0Var, y0 y0Var) {
        if (this.ppp == null) {
            this.ppp = new HashMap<>();
        }
        this.ppp.put(s0Var, y0Var);
    }

    public void setId(qw qwVar) {
        this.ggg = qwVar;
    }

    public void setRole(s0 s0Var) {
        this.when = s0Var;
    }

    /* renamed from: switch  reason: not valid java name */
    public void m1068switch(q[] qVarArr, float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.f405switch == null) {
            this.f405switch = new int[8];
        }
        for (int i2 = 0; i2 < 4; i2++) {
            rg w = qVarArr[i2].w();
            int i3 = i2 * 2;
            this.f405switch[i3] = w.nn();
            qVarArr[i2].d0();
            qVarArr[i2].e(f, f2, f3, f4, f5, f6);
            this.f405switch[i3 + 1] = w.nn();
        }
    }

    public float th() {
        return this.f9369o;
    }

    public void uk() {
        this.f9368i = new float[this.f9373yj.length];
        int i2 = 0;
        while (true) {
            float[] fArr = this.f9368i;
            if (i2 < fArr.length) {
                fArr[i2] = 0.0f;
                i2++;
            } else {
                return;
            }
        }
    }

    public void vvv(float f) {
        xxx(f);
        this.f9370pf = true;
    }

    public void when(boolean z) {
        this.f404if = z;
    }

    public void xxx(float f) {
        this.f9369o = f;
    }

    public boolean yj() {
        int i2 = 0;
        while (true) {
            a1[] a1VarArr = this.f9373yj;
            if (i2 >= a1VarArr.length) {
                return false;
            }
            if (a1VarArr[i2] != null && a1VarArr[i2].D() > 1) {
                return true;
            }
            i2++;
        }
    }

    public c1(a1[] a1VarArr, c1 c1Var) {
        this.f9367ad = ad.qw(c1.class);
        this.f9371th = false;
        this.f9369o = 0.0f;
        this.f9370pf = false;
        this.f404if = false;
        this.when = s0.j5;
        this.ppp = null;
        this.ggg = new qw();
        this.f9373yj = a1VarArr;
        this.f9372uk = new float[a1VarArr.length];
        uk();
        if (c1Var != null) {
            this.ggg = c1Var.ggg;
            this.when = c1Var.when;
            if (c1Var.ppp != null) {
                this.ppp = new HashMap<>(c1Var.ppp);
            }
        }
    }

    public c1(c1 c1Var) {
        a1[] a1VarArr;
        this.f9367ad = ad.qw(c1.class);
        this.f9371th = false;
        this.f9369o = 0.0f;
        this.f9370pf = false;
        this.f404if = false;
        this.when = s0.j5;
        this.ppp = null;
        this.ggg = new qw();
        this.f9371th = c1Var.f9371th;
        this.f9369o = c1Var.f9369o;
        this.f9370pf = c1Var.f9370pf;
        this.f9373yj = new a1[c1Var.f9373yj.length];
        int i2 = 0;
        while (true) {
            a1VarArr = this.f9373yj;
            if (i2 >= a1VarArr.length) {
                break;
            }
            a1[] a1VarArr2 = c1Var.f9373yj;
            if (a1VarArr2[i2] != null) {
                if (a1VarArr2[i2] instanceof b1) {
                    a1VarArr[i2] = new b1((b1) a1VarArr2[i2]);
                } else {
                    a1VarArr[i2] = new a1(a1VarArr2[i2]);
                }
            }
            i2++;
        }
        float[] fArr = new float[a1VarArr.length];
        this.f9372uk = fArr;
        System.arraycopy(c1Var.f9372uk, 0, fArr, 0, a1VarArr.length);
        uk();
        this.ggg = c1Var.ggg;
        this.when = c1Var.when;
        if (c1Var.ppp != null) {
            this.ppp = new HashMap<>(c1Var.ppp);
        }
    }
}
