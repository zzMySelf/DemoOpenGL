package fe.when.ad.f;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.common.base.Ascii;
import com.itextpdf.awt.geom.AffineTransform;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.exceptions.IllegalPdfSyntaxException;
import com.itextpdf.text.pdf.PdfOCG;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import fe.when.ad.aaa;
import fe.when.ad.de;
import fe.when.ad.i;
import fe.when.ad.pf;
import fe.when.qw.qw.fe;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class q {
    public static final float[] vvv = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    public static HashMap<s0, String> xxx;

    /* renamed from: ad  reason: collision with root package name */
    public rg f9702ad = new rg();
    public q ggg = null;

    /* renamed from: i  reason: collision with root package name */
    public qw f9703i = new qw();

    /* renamed from: if  reason: not valid java name */
    public int f450if = 10;

    /* renamed from: o  reason: collision with root package name */
    public ArrayList<qw> f9704o = new ArrayList<>();

    /* renamed from: pf  reason: collision with root package name */
    public ArrayList<Integer> f9705pf;
    public ArrayList<IAccessibleElement> ppp = new ArrayList<>();

    /* renamed from: switch  reason: not valid java name */
    public int f451switch = 0;

    /* renamed from: th  reason: collision with root package name */
    public int f9706th = 0;

    /* renamed from: uk  reason: collision with root package name */
    public y f9707uk;
    public boolean when = false;

    /* renamed from: yj  reason: collision with root package name */
    public c2 f9708yj;

    public static class ad extends f {

        /* renamed from: th  reason: collision with root package name */
        public de f9709th;

        /* renamed from: yj  reason: collision with root package name */
        public float f9710yj;

        public ad(l1 l1Var, de deVar, float f) {
            super(l1Var);
            this.f9709th = deVar;
            this.f9710yj = f;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ad) {
                ad adVar = (ad) obj;
                return adVar.f9446rg.equals(this.f9446rg) && adVar.f9709th.equals(this.f9709th) && adVar.f9710yj == this.f9710yj;
            }
        }
    }

    static {
        HashMap<s0, String> hashMap = new HashMap<>();
        xxx = hashMap;
        hashMap.put(s0.p, "/BPC ");
        xxx.put(s0.T, "/CS ");
        xxx.put(s0.o0, "/D ");
        xxx.put(s0.p0, "/DP ");
        xxx.put(s0.e1, "/F ");
        xxx.put(s0.Q1, "/H ");
        xxx.put(s0.d2, "/IM ");
        xxx.put(s0.i2, "/Intent ");
        xxx.put(s0.j2, "/I ");
        xxx.put(s0.l6, "/W ");
    }

    public q(c2 c2Var) {
        if (c2Var != null) {
            this.f9708yj = c2Var;
            this.f9707uk = c2Var.L();
        }
    }

    public static ArrayList<float[]> ddd(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        int i2;
        if (f > f3) {
            f7 = f;
            f8 = f3;
        } else {
            f8 = f;
            f7 = f3;
        }
        if (f4 > f2) {
            f9 = f2;
            f10 = f4;
        } else {
            f10 = f2;
            f9 = f4;
        }
        if (Math.abs(f6) <= 90.0f) {
            f11 = f6;
            i2 = 1;
        } else {
            i2 = (int) Math.ceil((double) (Math.abs(f6) / 90.0f));
            f11 = f6 / ((float) i2);
        }
        float f12 = (f10 + f9) / 2.0f;
        float f13 = (f7 - f8) / 2.0f;
        float f14 = (f9 - f10) / 2.0f;
        double d = 3.141592653589793d;
        float f15 = (f8 + f7) / 2.0f;
        double d2 = (double) ((float) ((((double) f11) * 3.141592653589793d) / 360.0d));
        float abs = (float) Math.abs(((1.0d - Math.cos(d2)) * 1.3333333333333333d) / Math.sin(d2));
        ArrayList<float[]> arrayList = new ArrayList<>();
        int i3 = 0;
        while (i3 < i2) {
            float f16 = (float) ((((double) (f5 + (((float) i3) * f11))) * d) / 180.0d);
            i3++;
            double d3 = (double) f16;
            float cos = (float) Math.cos(d3);
            double d4 = (double) ((float) ((((double) (f5 + (((float) i3) * f11))) * d) / 180.0d));
            float cos2 = (float) Math.cos(d4);
            float sin = (float) Math.sin(d3);
            float sin2 = (float) Math.sin(d4);
            if (f11 > 0.0f) {
                arrayList.add(new float[]{f15 + (f13 * cos), f12 - (f14 * sin), f15 + ((cos - (abs * sin)) * f13), f12 - ((sin + (cos * abs)) * f14), f15 + (((abs * sin2) + cos2) * f13), f12 - ((sin2 - (abs * cos2)) * f14), f15 + (cos2 * f13), f12 - (sin2 * f14)});
            } else {
                arrayList.add(new float[]{f15 + (f13 * cos), f12 - (f14 * sin), f15 + (((abs * sin) + cos) * f13), f12 - ((sin - (cos * abs)) * f14), f15 + ((cos2 - (abs * sin2)) * f13), f12 - (((abs * cos2) + sin2) * f14), f15 + (cos2 * f13), f12 - (sin2 * f14)});
            }
            d = 3.141592653589793d;
        }
        return arrayList;
    }

    public static void m(byte[] bArr, rg rgVar) {
        rgVar.ppp(40);
        for (byte b : bArr) {
            if (b == 12) {
                rgVar.uk("\\f");
            } else if (b != 13) {
                if (b != 40 && b != 41 && b != 92) {
                    switch (b) {
                        case 8:
                            rgVar.uk("\\b");
                            break;
                        case 9:
                            rgVar.uk("\\t");
                            break;
                        case 10:
                            rgVar.uk("\\n");
                            break;
                        default:
                            rgVar.ppp(b);
                            break;
                    }
                } else {
                    rgVar.ppp(92);
                    rgVar.ppp(b);
                }
            } else {
                rgVar.uk("\\r");
            }
        }
        rgVar.uk(")");
    }

    public static byte[] n(byte[] bArr) {
        rg rgVar = new rg();
        m(bArr, rgVar);
        return rgVar.mmm();
    }

    public final x A() {
        x xVar = y().size() > 0 ? this.f9707uk.eee.get(y().get(y().size() - 1).getId()) : null;
        return xVar == null ? this.f9708yj.S() : xVar;
    }

    public void A0(ArrayList<IAccessibleElement> arrayList) {
        q qVar = this.ggg;
        if (qVar != null) {
            qVar.A0(arrayList);
        } else {
            this.ppp = arrayList;
        }
    }

    public y B() {
        return this.f9707uk;
    }

    public void B0(l1 l1Var) {
        if (l1Var.y1()) {
            C0(l1Var, l1Var.u1());
            return;
        }
        aaa();
        s0 rg2 = z().rg(this.f9708yj.ddd(l1Var), l1Var.h1());
        b0(new f(l1Var), true);
        rg rgVar = this.f9702ad;
        rgVar.pf(s0.R3.th());
        rgVar.uk(" cs ");
        rgVar.pf(rg2.th());
        rgVar.uk(" scn");
        rgVar.ppp(this.f450if);
    }

    public c2 C() {
        return this.f9708yj;
    }

    public void C0(l1 l1Var, de deVar) {
        if (ppp.uk(deVar) == 3) {
            D0(l1Var, deVar, ((h2) deVar).pf());
        } else {
            D0(l1Var, deVar, 0.0f);
        }
    }

    public float D() {
        return this.f9703i.f9713fe;
    }

    public void D0(l1 l1Var, de deVar, float f) {
        aaa();
        if (l1Var.y1()) {
            e z = z();
            s0 rg2 = z.rg(this.f9708yj.ddd(l1Var), l1Var.h1());
            o nn = this.f9708yj.nn(deVar);
            s0 qw2 = z.qw(nn.qw(), nn.ad());
            b0(new ad(l1Var, deVar, f), true);
            rg rgVar = this.f9702ad;
            rgVar.pf(qw2.th());
            rgVar.uk(" cs");
            rgVar.ppp(this.f450if);
            M(deVar, f);
            rg rgVar2 = this.f9702ad;
            rgVar2.de(Ascii.CASE_MASK);
            rgVar2.pf(rg2.th());
            rgVar2.uk(" scn");
            rgVar2.ppp(this.f450if);
            return;
        }
        throw new RuntimeException(fe.when.ad.c.qw.ad("an.uncolored.pattern.was.expected", new Object[0]));
    }

    public float E() {
        return this.f9703i.f9717rg;
    }

    public void E0(l1 l1Var) {
        if (l1Var.y1()) {
            F0(l1Var, l1Var.u1());
            return;
        }
        aaa();
        s0 rg2 = z().rg(this.f9708yj.ddd(l1Var), l1Var.h1());
        b0(new f(l1Var), false);
        rg rgVar = this.f9702ad;
        rgVar.pf(s0.R3.th());
        rgVar.uk(" CS ");
        rgVar.pf(rg2.th());
        rgVar.uk(" SCN");
        rgVar.ppp(this.f450if);
    }

    public boolean F() {
        c2 c2Var = this.f9708yj;
        return c2Var != null && c2Var.a0();
    }

    public void F0(l1 l1Var, de deVar) {
        if (ppp.uk(deVar) == 3) {
            G0(l1Var, deVar, ((h2) deVar).pf());
        } else {
            G0(l1Var, deVar, 0.0f);
        }
    }

    public void G(float f, float f2) {
        if (this.when) {
            if (F()) {
                j();
            } else {
                throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        rg rgVar = this.f9702ad;
        rgVar.rg(f);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f2);
        rgVar.uk(" l");
        rgVar.ppp(this.f450if);
    }

    public void G0(l1 l1Var, de deVar, float f) {
        aaa();
        if (l1Var.y1()) {
            e z = z();
            s0 rg2 = z.rg(this.f9708yj.ddd(l1Var), l1Var.h1());
            o nn = this.f9708yj.nn(deVar);
            s0 qw2 = z.qw(nn.qw(), nn.ad());
            b0(new ad(l1Var, deVar, f), false);
            rg rgVar = this.f9702ad;
            rgVar.pf(qw2.th());
            rgVar.uk(" CS");
            rgVar.ppp(this.f450if);
            M(deVar, f);
            rg rgVar2 = this.f9702ad;
            rgVar2.de(Ascii.CASE_MASK);
            rgVar2.pf(rg2.th());
            rgVar2.uk(" SCN");
            rgVar2.ppp(this.f450if);
            return;
        }
        throw new RuntimeException(fe.when.ad.c.qw.ad("an.uncolored.pattern.was.expected", new Object[0]));
    }

    public void H(float f, float f2) {
        if (!this.when && F()) {
            xxx(true);
        }
        qw qwVar = this.f9703i;
        qwVar.f9713fe += f;
        qwVar.f9717rg += f2;
        if (F()) {
            qw qwVar2 = this.f9703i;
            float f3 = qwVar2.f9713fe;
            if (f3 != qwVar2.f9715o) {
                M0(qwVar2.f9718th, qwVar2.f9720yj, qwVar2.f9719uk, qwVar2.f9714i, f3, qwVar2.f9717rg);
                return;
            }
        }
        rg rgVar = this.f9702ad;
        rgVar.rg(f);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f2);
        rgVar.uk(" Td");
        rgVar.ppp(this.f450if);
    }

    public void H0(int i2, int i3, int i4) {
        b0(new de(i2, i3, i4), true);
        ad(((float) (i2 & 255)) / 255.0f, ((float) (i3 & 255)) / 255.0f, ((float) (i4 & 255)) / 255.0f);
        rg rgVar = this.f9702ad;
        rgVar.uk(" rg");
        rgVar.ppp(this.f450if);
    }

    public void I(float f, float f2) {
        if (this.when) {
            if (F()) {
                j();
            } else {
                throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        rg rgVar = this.f9702ad;
        rgVar.rg(f);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f2);
        rgVar.uk(" m");
        rgVar.ppp(this.f450if);
    }

    public void I0(int i2, int i3, int i4) {
        b0(new de(i2, i3, i4), false);
        ad(((float) (i2 & 255)) / 255.0f, ((float) (i3 & 255)) / 255.0f, ((float) (i4 & 255)) / 255.0f);
        rg rgVar = this.f9702ad;
        rgVar.uk(" RG");
        rgVar.ppp(this.f450if);
    }

    public void J() {
        if (this.when) {
            if (F()) {
                j();
            } else {
                throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        rg rgVar = this.f9702ad;
        rgVar.uk(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION);
        rgVar.ppp(this.f450if);
    }

    public void J0(s1 s1Var) {
        this.f9708yj.qqq(s1Var);
        e z = z();
        s0 rg2 = z.rg(s1Var.n(), s1Var.p());
        b0(new f2(s1Var), true);
        rg rgVar = this.f9702ad;
        rgVar.pf(s0.R3.th());
        rgVar.uk(" cs ");
        rgVar.pf(rg2.th());
        rgVar.uk(" scn");
        rgVar.ppp(this.f450if);
        o m = s1Var.m();
        if (m != null) {
            z.qw(m.qw(), m.ad());
        }
    }

    public void K(IAccessibleElement iAccessibleElement) {
        if (F()) {
            y yVar = this.f9707uk;
            if (yVar.rrr) {
                yVar.rrr = false;
                this.f9708yj.x().K(this.f9707uk);
            }
            if (iAccessibleElement != null && !y().contains(iAccessibleElement)) {
                x1 L = L(iAccessibleElement);
                y().add(iAccessibleElement);
                if (L != null) {
                    this.f9707uk.eee.put(iAccessibleElement.getId(), L);
                }
            }
        }
    }

    public void K0(s1 s1Var) {
        this.f9708yj.qqq(s1Var);
        e z = z();
        s0 rg2 = z.rg(s1Var.n(), s1Var.p());
        b0(new f2(s1Var), false);
        rg rgVar = this.f9702ad;
        rgVar.pf(s0.R3.th());
        rgVar.uk(" CS ");
        rgVar.pf(rg2.th());
        rgVar.uk(" SCN");
        rgVar.ppp(this.f450if);
        o m = s1Var.m();
        if (m != null) {
            z.qw(m.qw(), m.ad());
        }
    }

    public final x1 L(IAccessibleElement iAccessibleElement) {
        x1 x1Var;
        x xVar = null;
        if (!F()) {
            return null;
        }
        this.f9708yj.e(iAccessibleElement, y().size() > 0 ? y().get(y().size() - 1) : null);
        if (iAccessibleElement.getRole() == null) {
            return null;
        }
        if (!s0.rrr.equals(iAccessibleElement.getRole())) {
            x1Var = this.f9707uk.eee.get(iAccessibleElement.getId());
            if (x1Var == null) {
                x1Var = new x1(A(), iAccessibleElement.getRole());
            }
        } else {
            x1Var = null;
        }
        if (s0.rrr.equals(iAccessibleElement.getRole())) {
            HashMap<s0, y0> accessibleAttributes = iAccessibleElement.getAccessibleAttributes();
            if (accessibleAttributes != null && !accessibleAttributes.isEmpty()) {
                xVar = new x();
                for (Map.Entry next : accessibleAttributes.entrySet()) {
                    xVar.h((s0) next.getKey(), (y0) next.getValue());
                }
            }
            boolean z = this.when;
            if (z) {
                j();
            }
            ppp(iAccessibleElement.getRole(), xVar, true);
            if (z) {
                xxx(true);
            }
        } else if (this.f9708yj.b0(iAccessibleElement)) {
            boolean z2 = this.when;
            if (z2) {
                j();
            }
            ggg(x1Var);
            if (z2) {
                xxx(true);
            }
        }
        return x1Var;
    }

    public void L0(float f, float f2) {
        M0(1.0f, 0.0f, 0.0f, 1.0f, f, f2);
    }

    public void M(de deVar, float f) {
        c2.g(this.f9708yj, 1, deVar);
        int uk2 = ppp.uk(deVar);
        if (uk2 == 0) {
            this.f9702ad.rg(((float) deVar.fe()) / 255.0f);
            this.f9702ad.de(Ascii.CASE_MASK);
            this.f9702ad.rg(((float) deVar.ad()) / 255.0f);
            this.f9702ad.de(Ascii.CASE_MASK);
            this.f9702ad.rg(((float) deVar.qw()) / 255.0f);
        } else if (uk2 == 1) {
            this.f9702ad.rg(((nn) deVar).o());
        } else if (uk2 == 2) {
            i iVar = (i) deVar;
            rg rgVar = this.f9702ad;
            rgVar.rg(iVar.pf());
            rgVar.de(Ascii.CASE_MASK);
            rgVar.rg(iVar.m1083if());
            rg rgVar2 = this.f9702ad;
            rgVar2.de(Ascii.CASE_MASK);
            rgVar2.rg(iVar.m1084switch());
            rgVar2.de(Ascii.CASE_MASK);
            rgVar2.rg(iVar.o());
        } else if (uk2 == 3) {
            this.f9702ad.rg(f);
        } else {
            throw new RuntimeException(fe.when.ad.c.qw.ad("invalid.color.type", new Object[0]));
        }
    }

    public void M0(float f, float f2, float f3, float f4, float f5, float f6) {
        if (!this.when && F()) {
            xxx(true);
        }
        qw qwVar = this.f9703i;
        qwVar.f9713fe = f5;
        qwVar.f9717rg = f6;
        qwVar.f9718th = f;
        qwVar.f9720yj = f2;
        qwVar.f9719uk = f3;
        qwVar.f9714i = f4;
        qwVar.f9715o = f5;
        rg rgVar = this.f9702ad;
        rgVar.rg(f);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f2);
        rgVar.ppp(32);
        rgVar.rg(f3);
        rgVar.ppp(32);
        rgVar.rg(f4);
        rgVar.ppp(32);
        rgVar.rg(f5);
        rgVar.ppp(32);
        rgVar.rg(f6);
        rgVar.uk(" Tm");
        rgVar.ppp(this.f450if);
    }

    public void N(float f, float f2, float f3, float f4) {
        if (this.when) {
            if (F()) {
                j();
            } else {
                throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        rg rgVar = this.f9702ad;
        rgVar.rg(f);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f2);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f3);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f4);
        rgVar.uk(" re");
        rgVar.ppp(this.f450if);
    }

    public void N0(int i2) {
        if (!this.when && F()) {
            xxx(true);
        }
        this.f9703i.ddd = i2;
        rg rgVar = this.f9702ad;
        rgVar.th(i2);
        rgVar.uk(" Tr");
        rgVar.ppp(this.f450if);
    }

    public void O(aaa aaa) {
        float vvv2 = aaa.vvv();
        float when2 = aaa.when();
        float ddd = aaa.ddd();
        float aaa2 = aaa.aaa();
        de ad2 = aaa.ad();
        if (ad2 != null) {
            d0();
            h0(ad2);
            N(vvv2, when2, ddd - vvv2, aaa2 - when2);
            p();
            Y();
        }
        if (aaa.a()) {
            if (aaa.b()) {
                Z0(aaa);
                return;
            }
            if (aaa.i() != -1.0f) {
                x0(aaa.i());
            }
            de fe2 = aaa.fe();
            if (fe2 != null) {
                l0(fe2);
            }
            if (aaa.tt(15)) {
                N(vvv2, when2, ddd - vvv2, aaa2 - when2);
            } else {
                if (aaa.tt(8)) {
                    I(ddd, when2);
                    G(ddd, aaa2);
                }
                if (aaa.tt(4)) {
                    I(vvv2, when2);
                    G(vvv2, aaa2);
                }
                if (aaa.tt(2)) {
                    I(vvv2, when2);
                    G(ddd, when2);
                }
                if (aaa.tt(1)) {
                    I(vvv2, aaa2);
                    G(ddd, aaa2);
                }
            }
            V0();
            if (fe2 != null) {
                U();
            }
        }
    }

    public void O0(float f) {
        if (!this.when && F()) {
            xxx(true);
        }
        rg rgVar = this.f9702ad;
        rgVar.rg(f);
        rgVar.uk(" Ts");
        rgVar.ppp(this.f450if);
    }

    public void P() {
        Q(true);
    }

    public void P0(float f) {
        if (!this.when && F()) {
            xxx(true);
        }
        this.f9703i.when = f;
        rg rgVar = this.f9702ad;
        rgVar.rg(f);
        rgVar.uk(" Tw");
        rgVar.ppp(this.f450if);
    }

    public void Q(boolean z) {
        this.f9702ad.xxx();
        this.f9706th = 0;
        if (z) {
            a0();
        }
        this.f9703i = new qw();
        this.f9704o = new ArrayList<>();
    }

    public void Q0(a2 a2Var) {
        mmm();
        if (!this.when && F()) {
            xxx(true);
        }
        if (this.f9703i.qw != null) {
            this.f9702ad.uk("[");
            Iterator<Object> it = a2Var.de().iterator();
            while (true) {
                boolean z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof String) {
                        String str = (String) next;
                        S0(str);
                        Y0(str, 0.0f);
                    } else {
                        if (z) {
                            this.f9702ad.de(Ascii.CASE_MASK);
                        } else {
                            z = true;
                        }
                        Float f = (Float) next;
                        this.f9702ad.rg(f.floatValue());
                        Y0("", f.floatValue());
                    }
                }
                rg rgVar = this.f9702ad;
                rgVar.uk("]TJ");
                rgVar.ppp(this.f450if);
                return;
            }
        }
        throw new NullPointerException(fe.when.ad.c.qw.ad("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
    }

    public void R() {
        b0(new nn(0), true);
        rg rgVar = this.f9702ad;
        rgVar.uk("0 g");
        rgVar.ppp(this.f450if);
    }

    public void R0(String str) {
        mmm();
        if (!this.when && F()) {
            xxx(true);
        }
        S0(str);
        Y0(str, 0.0f);
        rg rgVar = this.f9702ad;
        rgVar.uk("Tj");
        rgVar.ppp(this.f450if);
    }

    public void S() {
        b0(new nn(0), false);
        rg rgVar = this.f9702ad;
        rgVar.uk("0 G");
        rgVar.ppp(this.f450if);
    }

    public final void S0(String str) {
        vvv vvv2 = this.f9703i.qw;
        if (vvv2 != null) {
            m(vvv2.ad(str), this.f9702ad);
            return;
        }
        throw new NullPointerException(fe.when.ad.c.qw.ad("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
    }

    public void T() {
        R();
    }

    public int T0() {
        return U0(true);
    }

    public void U() {
        S();
    }

    public int U0(boolean z) {
        if (z) {
            return this.f9702ad.nn();
        }
        return this.f9702ad.nn() - this.f9706th;
    }

    public final void V() throws IOException {
        if (!F()) {
            return;
        }
        if (this.when) {
            qw qwVar = this.f9703i;
            if (!qwVar.ppp.equals(qwVar.ggg)) {
                W(this.f9703i.ppp, true);
            }
            qw qwVar2 = this.f9703i;
            if (!qwVar2.vvv.equals(qwVar2.xxx)) {
                W(this.f9703i.vvv, false);
                return;
            }
            return;
        }
        qw qwVar3 = this.f9703i;
        if (!qwVar3.ppp.equals(qwVar3.ggg)) {
            W(this.f9703i.ggg, true);
        }
        qw qwVar4 = this.f9703i;
        if (!qwVar4.vvv.equals(qwVar4.xxx)) {
            W(this.f9703i.xxx, false);
        }
    }

    public void V0() {
        if (this.when) {
            if (F()) {
                j();
            } else {
                throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        c2.g(this.f9708yj, 1, this.f9703i.xxx);
        c2.g(this.f9708yj, 6, this.f9703i.mmm);
        rg rgVar = this.f9702ad;
        rgVar.uk(ExifInterface.LATITUDE_SOUTH);
        rgVar.ppp(this.f450if);
    }

    public final void W(de deVar, boolean z) throws IOException {
        if (!F()) {
            return;
        }
        if (deVar instanceof ad) {
            ad adVar = (ad) deVar;
            if (z) {
                D0(adVar.o(), adVar.f9709th, adVar.f9710yj);
            } else {
                G0(adVar.o(), adVar.f9709th, adVar.f9710yj);
            }
        } else if (z) {
            h0(deVar);
        } else {
            l0(deVar);
        }
    }

    public byte[] W0(c2 c2Var) {
        a0();
        return this.f9702ad.mmm();
    }

    public void X(ArrayList<IAccessibleElement> arrayList) {
        if (F() && arrayList != null) {
            A0(arrayList);
            for (int i2 = 0; i2 < y().size(); i2++) {
                L(y().get(i2));
            }
        }
    }

    public void X0(AffineTransform affineTransform) {
        if (this.when && F()) {
            j();
        }
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        this.f9703i.nn.concatenate(affineTransform);
        rg rgVar = this.f9702ad;
        rgVar.fe(dArr[0]);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.fe(dArr[1]);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.fe(dArr[2]);
        rgVar.de(Ascii.CASE_MASK);
        rg rgVar2 = this.f9702ad;
        rgVar2.fe(dArr[3]);
        rgVar2.de(Ascii.CASE_MASK);
        rgVar2.fe(dArr[4]);
        rgVar2.de(Ascii.CASE_MASK);
        rgVar2.fe(dArr[5]);
        rgVar2.uk(" cm");
        rgVar2.ppp(this.f450if);
    }

    public void Y() {
        c2.g(this.f9708yj, 12, "Q");
        if (this.when && F()) {
            j();
        }
        rg rgVar = this.f9702ad;
        rgVar.uk("Q");
        rgVar.ppp(this.f450if);
        int size = this.f9704o.size() - 1;
        if (size >= 0) {
            this.f9703i.ad(this.f9704o.get(size));
            this.f9704o.remove(size);
            return;
        }
        throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("unbalanced.save.restore.state.operators", new Object[0]));
    }

    public void Y0(String str, float f) {
        this.f9703i.f9715o += u(str, false, f);
    }

    public void Z(float f, float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        float f9 = f3;
        float f10 = f4;
        float f11 = f5;
        if (f9 < 0.0f) {
            float f12 = f + f9;
            f9 = -f9;
            f6 = f12;
        } else {
            f6 = f;
        }
        if (f10 < 0.0f) {
            f8 = -f10;
            f7 = f2 + f10;
        } else {
            f7 = f2;
            f8 = f10;
        }
        float f13 = f11 < 0.0f ? -f11 : f11;
        float f14 = f6 + f13;
        I(f14, f7);
        float f15 = f6 + f9;
        float f16 = f15 - f13;
        G(f16, f7);
        float f17 = f13 * 0.4477f;
        float f18 = f15 - f17;
        float f19 = f7 + f17;
        float f20 = f7 + f13;
        f(f18, f7, f15, f19, f15, f20);
        float f21 = f8 + f7;
        float f22 = f21 - f13;
        G(f15, f22);
        float f23 = f21 - f17;
        f(f15, f23, f18, f21, f16, f21);
        G(f14, f21);
        float f24 = f6 + f17;
        f(f24, f21, f6, f23, f6, f22);
        G(f6, f20);
        f(f6, f19, f24, f7, f14, f7);
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Z0(fe.when.ad.aaa r25) {
        /*
            r24 = this;
            r0 = r24
            float r1 = r25.aaa()
            float r2 = r25.when()
            float r3 = r25.ddd()
            float r4 = r25.vvv()
            float r5 = r25.m1062switch()
            float r6 = r25.o()
            float r7 = r25.m1061if()
            float r8 = r25.pf()
            fe.when.ad.de r9 = r25.uk()
            fe.when.ad.de r10 = r25.rg()
            fe.when.ad.de r11 = r25.yj()
            fe.when.ad.de r12 = r25.th()
            r24.d0()
            r13 = 0
            r0.s0(r13)
            r0.w0(r13)
            r15 = 1073741824(0x40000000, float:2.0)
            r16 = 1
            r17 = 0
            int r18 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r18 <= 0) goto L_0x0064
            r0.x0(r5)
            if (r9 != 0) goto L_0x004f
            r24.U()
            goto L_0x0052
        L_0x004f:
            r0.l0(r9)
        L_0x0052:
            float r18 = r5 / r15
            float r13 = r1 - r18
            r0.I(r4, r13)
            r0.G(r3, r13)
            r24.V0()
            r13 = r5
            r14 = r9
            r18 = 1
            goto L_0x0068
        L_0x0064:
            r13 = 0
            r14 = 0
            r18 = 0
        L_0x0068:
            int r19 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r19 <= 0) goto L_0x0095
            int r19 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r19 == 0) goto L_0x0074
            r0.x0(r6)
            r13 = r6
        L_0x0074:
            if (r18 == 0) goto L_0x007c
            boolean r19 = r0.d(r14, r10)
            if (r19 != 0) goto L_0x0088
        L_0x007c:
            if (r10 != 0) goto L_0x0082
            r24.U()
            goto L_0x0085
        L_0x0082:
            r0.l0(r10)
        L_0x0085:
            r14 = r10
            r18 = 1
        L_0x0088:
            float r19 = r6 / r15
            float r15 = r2 + r19
            r0.I(r3, r15)
            r0.G(r4, r15)
            r24.V0()
        L_0x0095:
            int r15 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x011b
            int r15 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r15 == 0) goto L_0x00a1
            r0.x0(r7)
            r13 = r7
        L_0x00a1:
            if (r18 == 0) goto L_0x00a9
            boolean r15 = r0.d(r14, r11)
            if (r15 != 0) goto L_0x00b5
        L_0x00a9:
            if (r11 != 0) goto L_0x00af
            r24.U()
            goto L_0x00b2
        L_0x00af:
            r0.l0(r11)
        L_0x00b2:
            r14 = r11
            r18 = 1
        L_0x00b5:
            boolean r15 = r0.d(r9, r11)
            boolean r19 = r0.d(r10, r11)
            r20 = 1073741824(0x40000000, float:2.0)
            float r21 = r7 / r20
            r22 = r13
            float r13 = r3 - r21
            if (r15 == 0) goto L_0x00cb
            r23 = r14
            r14 = r1
            goto L_0x00d1
        L_0x00cb:
            float r21 = r1 - r5
            r23 = r14
            r14 = r21
        L_0x00d1:
            r0.I(r13, r14)
            if (r19 == 0) goto L_0x00d8
            r14 = r2
            goto L_0x00da
        L_0x00d8:
            float r14 = r2 + r6
        L_0x00da:
            r0.G(r13, r14)
            r24.V0()
            if (r15 == 0) goto L_0x00ea
            if (r19 != 0) goto L_0x00e5
            goto L_0x00ea
        L_0x00e5:
            r13 = r22
            r14 = r23
            goto L_0x011b
        L_0x00ea:
            if (r11 != 0) goto L_0x00f0
            r24.T()
            goto L_0x00f3
        L_0x00f0:
            r0.h0(r11)
        L_0x00f3:
            if (r15 != 0) goto L_0x0105
            r0.I(r3, r1)
            float r13 = r1 - r5
            r0.G(r3, r13)
            float r14 = r3 - r7
            r0.G(r14, r13)
            r24.p()
        L_0x0105:
            if (r19 != 0) goto L_0x0116
            r0.I(r3, r2)
            float r13 = r2 + r6
            r0.G(r3, r13)
            float r3 = r3 - r7
            r0.G(r3, r13)
            r24.p()
        L_0x0116:
            r13 = r22
            r14 = r23
            goto L_0x011e
        L_0x011b:
            r11 = 0
            r16 = 0
        L_0x011e:
            int r3 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r3 <= 0) goto L_0x0192
            int r3 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r3 == 0) goto L_0x0129
            r0.x0(r8)
        L_0x0129:
            if (r18 == 0) goto L_0x0131
            boolean r3 = r0.d(r14, r12)
            if (r3 != 0) goto L_0x013a
        L_0x0131:
            if (r12 != 0) goto L_0x0137
            r24.U()
            goto L_0x013a
        L_0x0137:
            r0.l0(r12)
        L_0x013a:
            boolean r3 = r0.d(r9, r12)
            boolean r7 = r0.d(r10, r12)
            r9 = 1073741824(0x40000000, float:2.0)
            float r9 = r8 / r9
            float r9 = r9 + r4
            if (r3 == 0) goto L_0x014b
            r10 = r1
            goto L_0x014d
        L_0x014b:
            float r10 = r1 - r5
        L_0x014d:
            r0.I(r9, r10)
            if (r7 == 0) goto L_0x0154
            r10 = r2
            goto L_0x0156
        L_0x0154:
            float r10 = r2 + r6
        L_0x0156:
            r0.G(r9, r10)
            r24.V0()
            if (r3 == 0) goto L_0x0160
            if (r7 != 0) goto L_0x0192
        L_0x0160:
            if (r16 == 0) goto L_0x0168
            boolean r9 = r0.d(r11, r12)
            if (r9 != 0) goto L_0x0171
        L_0x0168:
            if (r12 != 0) goto L_0x016e
            r24.T()
            goto L_0x0171
        L_0x016e:
            r0.h0(r12)
        L_0x0171:
            if (r3 != 0) goto L_0x0182
            r0.I(r4, r1)
            float r1 = r1 - r5
            r0.G(r4, r1)
            float r3 = r4 + r8
            r0.G(r3, r1)
            r24.p()
        L_0x0182:
            if (r7 != 0) goto L_0x0192
            r0.I(r4, r2)
            float r2 = r2 + r6
            r0.G(r4, r2)
            float r4 = r4 + r8
            r0.G(r4, r2)
            r24.p()
        L_0x0192:
            r24.Y()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.q.Z0(fe.when.ad.aaa):void");
    }

    public void a() {
        if (this.when) {
            if (F()) {
                j();
            } else {
                throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        c2.g(this.f9708yj, 1, this.f9703i.ggg);
        c2.g(this.f9708yj, 1, this.f9703i.xxx);
        c2.g(this.f9708yj, 6, this.f9703i.mmm);
        rg rgVar = this.f9702ad;
        rgVar.uk("b*");
        rgVar.ppp(this.f450if);
    }

    public void a0() {
        if (x() == 0) {
            if (this.when) {
                if (F()) {
                    j();
                } else {
                    throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("unbalanced.begin.end.text.operators", new Object[0]));
                }
            }
            ArrayList<Integer> arrayList = this.f9705pf;
            if (arrayList != null && !arrayList.isEmpty()) {
                throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("unbalanced.layer.operators", new Object[0]));
            } else if (!this.f9704o.isEmpty()) {
                throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("unbalanced.save.restore.state.operators", new Object[0]));
            }
        } else {
            throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("unbalanced.marked.content.operators", new Object[0]));
        }
    }

    public void aaa() {
        if (this.f9708yj == null) {
            throw new NullPointerException(fe.when.ad.c.qw.ad("the.writer.in.pdfcontentbyte.is.null", new Object[0]));
        }
    }

    public final void ad(float f, float f2, float f3) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f3 < 0.0f) {
            f3 = 0.0f;
        } else if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        rg rgVar = this.f9702ad;
        rgVar.rg(f);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f2);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f3);
    }

    public void b() {
        if (this.when) {
            if (F()) {
                j();
            } else {
                throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        c2.g(this.f9708yj, 1, this.f9703i.ggg);
        c2.g(this.f9708yj, 1, this.f9703i.xxx);
        c2.g(this.f9708yj, 6, this.f9703i.mmm);
        rg rgVar = this.f9702ad;
        rgVar.uk("b");
        rgVar.ppp(this.f450if);
    }

    public final void b0(de deVar, boolean z) {
        if (F()) {
            if (this.when) {
                if (z) {
                    this.f9703i.ppp = deVar;
                } else {
                    this.f9703i.vvv = deVar;
                }
            } else if (z) {
                this.f9703i.ggg = deVar;
            } else {
                this.f9703i.xxx = deVar;
            }
        } else if (z) {
            this.f9703i.ggg = deVar;
        } else {
            this.f9703i.xxx = deVar;
        }
    }

    public void c() {
        if (this.when) {
            if (F()) {
                j();
            } else {
                throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        c2.g(this.f9708yj, 1, this.f9703i.xxx);
        c2.g(this.f9708yj, 6, this.f9703i.mmm);
        rg rgVar = this.f9702ad;
        rgVar.uk("s");
        rgVar.ppp(this.f450if);
    }

    public ArrayList<IAccessibleElement> c0() {
        ArrayList<IAccessibleElement> arrayList = new ArrayList<>();
        if (F()) {
            arrayList = y();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                rrr(arrayList.get(i2));
            }
            A0(new ArrayList());
        }
        return arrayList;
    }

    public final boolean d(de deVar, de deVar2) {
        if (deVar == null && deVar2 == null) {
            return true;
        }
        if (deVar == null || deVar2 == null) {
            return false;
        }
        if (deVar instanceof ppp) {
            return deVar.equals(deVar2);
        }
        return deVar2.equals(deVar);
    }

    public void d0() {
        c2.g(this.f9708yj, 12, com.dlife.ctaccountapi.q.a);
        if (this.when && F()) {
            j();
        }
        rg rgVar = this.f9702ad;
        rgVar.uk(com.dlife.ctaccountapi.q.a);
        rgVar.ppp(this.f450if);
        this.f9704o.add(new qw(this.f9703i));
    }

    public void de(q qVar) {
        c2 c2Var = qVar.f9708yj;
        if (c2Var == null || this.f9708yj == c2Var) {
            this.f9702ad.yj(qVar.f9702ad);
            this.f9706th += qVar.f9706th;
            return;
        }
        throw new RuntimeException(fe.when.ad.c.qw.ad("inconsistent.writers.are.you.mixing.two.documents", new Object[0]));
    }

    public void e(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.when && F()) {
            j();
        }
        this.f9703i.nn.concatenate(new AffineTransform(f, f2, f3, f4, f5, f6));
        rg rgVar = this.f9702ad;
        rgVar.rg(f);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f2);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f3);
        rgVar.de(Ascii.CASE_MASK);
        rg rgVar2 = this.f9702ad;
        rgVar2.rg(f4);
        rgVar2.de(Ascii.CASE_MASK);
        rgVar2.rg(f5);
        rgVar2.de(Ascii.CASE_MASK);
        rgVar2.rg(f6);
        rgVar2.uk(" cm");
        rgVar2.ppp(this.f450if);
    }

    public void e0(float f, float f2, float f3, float f4) {
        b0(new i(f, f2, f3, f4), true);
        qw(f, f2, f3, f4);
        rg rgVar = this.f9702ad;
        rgVar.uk(" k");
        rgVar.ppp(this.f450if);
    }

    public void eee(IAccessibleElement iAccessibleElement) {
        if (F() && iAccessibleElement != null && y().contains(iAccessibleElement)) {
            rrr(iAccessibleElement);
            y().remove(iAccessibleElement);
        }
    }

    public void f(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.when) {
            if (F()) {
                j();
            } else {
                throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        rg rgVar = this.f9702ad;
        rgVar.rg(f);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f2);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f3);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f4);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f5);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f6);
        rgVar.uk(" c");
        rgVar.ppp(this.f450if);
    }

    public void f0(float f, float f2, float f3, float f4) {
        b0(new i(f, f2, f3, f4), false);
        qw(f, f2, f3, f4);
        rg rgVar = this.f9702ad;
        rgVar.uk(" K");
        rgVar.ppp(this.f450if);
    }

    public void fe(j jVar) {
        boolean z = F() && jVar.getRole() != null && (!(jVar instanceof e0) || ((e0) jVar).w() == null);
        if (z) {
            K(jVar);
        }
        this.f9708yj.pf(jVar);
        if (z) {
            x1 x1Var = this.f9707uk.eee.get(jVar.getId());
            if (x1Var != null) {
                int m = this.f9707uk.m(jVar);
                jVar.h(s0.W4, new v0(m));
                x1Var.r(jVar, r());
                this.f9708yj.S().r(m, x1Var.p());
            }
            eee(jVar);
        }
    }

    public void g() {
        ArrayList<Integer> arrayList = this.f9705pf;
        if (arrayList == null || arrayList.isEmpty()) {
            throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("unbalanced.layer.operators", new Object[0]));
        }
        ArrayList<Integer> arrayList2 = this.f9705pf;
        int intValue = arrayList2.get(arrayList2.size() - 1).intValue();
        ArrayList<Integer> arrayList3 = this.f9705pf;
        arrayList3.remove(arrayList3.size() - 1);
        while (true) {
            int i2 = intValue - 1;
            if (intValue > 0) {
                rg rgVar = this.f9702ad;
                rgVar.uk("EMC");
                rgVar.ppp(this.f450if);
                intValue = i2;
            } else {
                return;
            }
        }
    }

    public void g0(float f) {
        if (!this.when && F()) {
            xxx(true);
        }
        this.f9703i.f453switch = f;
        rg rgVar = this.f9702ad;
        rgVar.rg(f);
        rgVar.uk(" Tc");
        rgVar.ppp(this.f450if);
    }

    public void ggg(x1 x1Var) {
        k kVar;
        y0 qqq = x1Var.qqq(s0.s2);
        int[] n = this.f9707uk.n(r());
        int i2 = n[0];
        int i3 = n[1];
        if (qqq != null) {
            if (qqq.ppp()) {
                kVar = new k();
                kVar.qqq(qqq);
                x1Var.h(s0.s2, kVar);
            } else if (qqq.i()) {
                kVar = (k) qqq;
            } else {
                throw new IllegalArgumentException(fe.when.ad.c.qw.ad("unknown.object.at.k.1", qqq.getClass().toString()));
            }
            if (kVar.e(0) != null) {
                x xVar = new x(s0.Y2);
                xVar.h(s0.U3, r());
                xVar.h(s0.X2, new v0(i3));
                kVar.qqq(xVar);
            }
            x1Var.u(this.f9707uk.m(r()), -1);
        } else {
            x1Var.u(i2, i3);
            x1Var.h(s0.U3, r());
        }
        z0(x() + 1);
        int nn = this.f9702ad.nn();
        rg rgVar = this.f9702ad;
        rgVar.pf(x1Var.qqq(s0.D4).th());
        rgVar.uk(" <</MCID ");
        rgVar.th(i3);
        rgVar.uk(">> BDC");
        rgVar.ppp(this.f450if);
        this.f9706th += this.f9702ad.nn() - nn;
    }

    public void h() {
        if (x() != 0) {
            int nn = this.f9702ad.nn();
            z0(x() - 1);
            rg rgVar = this.f9702ad;
            rgVar.uk("EMC");
            rgVar.ppp(this.f450if);
            this.f9706th += this.f9702ad.nn() - nn;
            return;
        }
        throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("unbalanced.begin.end.marked.content.operators", new Object[0]));
    }

    public void h0(de deVar) {
        switch (ppp.uk(deVar)) {
            case 1:
                q0(((nn) deVar).o());
                return;
            case 2:
                i iVar = (i) deVar;
                e0(iVar.pf(), iVar.m1083if(), iVar.m1084switch(), iVar.o());
                return;
            case 3:
                h2 h2Var = (h2) deVar;
                k0(h2Var.o(), h2Var.pf());
                return;
            case 4:
                B0(((f) deVar).o());
                return;
            case 5:
                J0(((f2) deVar).o());
                return;
            case 6:
                Cswitch switchR = (Cswitch) deVar;
                i0(switchR.o(), switchR.pf());
                return;
            case 7:
                eee eee = (eee) deVar;
                j0(eee.m1080switch(), eee.m1079if(), eee.o(), eee.pf());
                return;
            default:
                H0(deVar.fe(), deVar.ad(), deVar.qw());
                return;
        }
    }

    public void i(i iVar, boolean z) throws DocumentException {
        if (iVar.b0()) {
            float[] o0 = iVar.o0();
            o0[4] = iVar.p() - o0[4];
            o0[5] = iVar.q() - o0[5];
            uk(iVar, o0[0], o0[1], o0[2], o0[3], o0[4], o0[5], z);
            return;
        }
        throw new DocumentException(fe.when.ad.c.qw.ad("the.image.must.have.absolute.positioning", new Object[0]));
    }

    public void i0(w wVar, float[] fArr) {
        aaa();
        this.f9703i.f9711ad = this.f9708yj.vvv(wVar);
        s0 qw2 = z().qw(this.f9703i.f9711ad.qw(), this.f9703i.f9711ad.ad());
        b0(new Cswitch(wVar, fArr), true);
        rg rgVar = this.f9702ad;
        rgVar.pf(qw2.th());
        rgVar.uk(" cs ");
        for (float f : fArr) {
            rg rgVar2 = this.f9702ad;
            rgVar2.uk(f + " ");
        }
        rg rgVar3 = this.f9702ad;
        rgVar3.uk("scn");
        rgVar3.ppp(this.f450if);
    }

    /* renamed from: if  reason: not valid java name */
    public void m1113if(float f, float f2, float f3, float f4, float f5, float f6) {
        ArrayList<float[]> ddd = ddd(f, f2, f3, f4, f5, f6);
        if (!ddd.isEmpty()) {
            float[] fArr = ddd.get(0);
            I(fArr[0], fArr[1]);
            for (int i2 = 0; i2 < ddd.size(); i2++) {
                float[] fArr2 = ddd.get(i2);
                f(fArr2[2], fArr2[3], fArr2[4], fArr2[5], fArr2[6], fArr2[7]);
            }
        }
    }

    public void j() {
        if (this.when) {
            this.when = false;
            rg rgVar = this.f9702ad;
            rgVar.uk("ET");
            rgVar.ppp(this.f450if);
            if (F()) {
                try {
                    V();
                } catch (IOException unused) {
                }
            }
        } else if (!F()) {
            throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("unbalanced.begin.end.text.operators", new Object[0]));
        }
    }

    public void j0(m0 m0Var, float f, float f2, float f3) {
        aaa();
        this.f9703i.f9711ad = this.f9708yj.vvv(m0Var);
        s0 qw2 = z().qw(this.f9703i.f9711ad.qw(), this.f9703i.f9711ad.ad());
        b0(new eee(m0Var, f, f2, f3), true);
        rg rgVar = this.f9702ad;
        rgVar.pf(qw2.th());
        rgVar.uk(" cs ");
        rg rgVar2 = this.f9702ad;
        rgVar2.uk(f + " " + f2 + " " + f3 + " ");
        rg rgVar3 = this.f9702ad;
        rgVar3.uk("scn");
        rgVar3.ppp(this.f450if);
    }

    public void k() {
        if (this.when && F()) {
            j();
        }
        rg rgVar = this.f9702ad;
        rgVar.uk("W*");
        rgVar.ppp(this.f450if);
    }

    public void k0(t1 t1Var, float f) {
        aaa();
        this.f9703i.f9711ad = this.f9708yj.vvv(t1Var);
        s0 qw2 = z().qw(this.f9703i.f9711ad.qw(), this.f9703i.f9711ad.ad());
        b0(new h2(t1Var, f), true);
        rg rgVar = this.f9702ad;
        rgVar.pf(qw2.th());
        rgVar.uk(" cs ");
        rgVar.rg(f);
        rgVar.uk(" scn");
        rgVar.ppp(this.f450if);
    }

    public void l() {
        if (this.when) {
            if (F()) {
                j();
            } else {
                throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        c2.g(this.f9708yj, 1, this.f9703i.ggg);
        c2.g(this.f9708yj, 6, this.f9703i.mmm);
        rg rgVar = this.f9702ad;
        rgVar.uk("f*");
        rgVar.ppp(this.f450if);
    }

    public void l0(de deVar) {
        switch (ppp.uk(deVar)) {
            case 1:
                r0(((nn) deVar).o());
                return;
            case 2:
                i iVar = (i) deVar;
                f0(iVar.pf(), iVar.m1083if(), iVar.m1084switch(), iVar.o());
                return;
            case 3:
                h2 h2Var = (h2) deVar;
                o0(h2Var.o(), h2Var.pf());
                return;
            case 4:
                E0(((f) deVar).o());
                return;
            case 5:
                K0(((f2) deVar).o());
                return;
            case 6:
                Cswitch switchR = (Cswitch) deVar;
                m0(switchR.o(), switchR.pf());
                return;
            case 7:
                eee eee = (eee) deVar;
                n0(eee.m1080switch(), eee.m1079if(), eee.o(), eee.pf());
                return;
            default:
                I0(deVar.fe(), deVar.ad(), deVar.qw());
                return;
        }
    }

    public void m0(w wVar, float[] fArr) {
        aaa();
        this.f9703i.f9711ad = this.f9708yj.vvv(wVar);
        s0 qw2 = z().qw(this.f9703i.f9711ad.qw(), this.f9703i.f9711ad.ad());
        b0(new Cswitch(wVar, fArr), true);
        rg rgVar = this.f9702ad;
        rgVar.pf(qw2.th());
        rgVar.uk(" CS ");
        for (float f : fArr) {
            rg rgVar2 = this.f9702ad;
            rgVar2.uk(f + " ");
        }
        rg rgVar3 = this.f9702ad;
        rgVar3.uk("SCN");
        rgVar3.ppp(this.f450if);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mmm() {
        /*
            r4 = this;
            fe.when.ad.f.q$qw r0 = r4.f9703i
            int r0 = r0.ddd
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x000b
            r0 = 0
        L_0x0009:
            r1 = 1
            goto L_0x0015
        L_0x000b:
            if (r0 != r2) goto L_0x000f
            r0 = 1
            goto L_0x0015
        L_0x000f:
            r3 = 2
            if (r0 != r3) goto L_0x0014
            r0 = 1
            goto L_0x0009
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r1 == 0) goto L_0x002b
            fe.when.ad.f.c2 r1 = r4.f9708yj
            boolean r3 = r4.F()
            if (r3 == 0) goto L_0x0024
            fe.when.ad.f.q$qw r3 = r4.f9703i
            fe.when.ad.de r3 = r3.ppp
            goto L_0x0028
        L_0x0024:
            fe.when.ad.f.q$qw r3 = r4.f9703i
            fe.when.ad.de r3 = r3.ggg
        L_0x0028:
            fe.when.ad.f.c2.g(r1, r2, r3)
        L_0x002b:
            if (r0 == 0) goto L_0x0041
            fe.when.ad.f.c2 r0 = r4.f9708yj
            boolean r1 = r4.F()
            if (r1 == 0) goto L_0x003a
            fe.when.ad.f.q$qw r1 = r4.f9703i
            fe.when.ad.de r1 = r1.vvv
            goto L_0x003e
        L_0x003a:
            fe.when.ad.f.q$qw r1 = r4.f9703i
            fe.when.ad.de r1 = r1.xxx
        L_0x003e:
            fe.when.ad.f.c2.g(r0, r2, r1)
        L_0x0041:
            fe.when.ad.f.c2 r0 = r4.f9708yj
            r1 = 6
            fe.when.ad.f.q$qw r2 = r4.f9703i
            fe.when.ad.f.y0 r2 = r2.mmm
            fe.when.ad.f.c2.g(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.q.mmm():void");
    }

    public void n0(m0 m0Var, float f, float f2, float f3) {
        aaa();
        this.f9703i.f9711ad = this.f9708yj.vvv(m0Var);
        s0 qw2 = z().qw(this.f9703i.f9711ad.qw(), this.f9703i.f9711ad.ad());
        b0(new eee(m0Var, f, f2, f3), true);
        rg rgVar = this.f9702ad;
        rgVar.pf(qw2.th());
        rgVar.uk(" CS ");
        rg rgVar2 = this.f9702ad;
        rgVar2.uk(f + " " + f2 + " " + f3 + " ");
        rg rgVar3 = this.f9702ad;
        rgVar3.uk("SCN");
        rgVar3.ppp(this.f450if);
    }

    public void nn(z1 z1Var) {
        if (z1Var.m1() == 3) {
            throw new RuntimeException(fe.when.ad.c.qw.ad("invalid.use.of.a.pattern.a.template.was.expected", new Object[0]));
        }
    }

    public void o(z1 z1Var, float f, float f2, float f3, float f4, float f5, float f6) {
        pf(z1Var, f, f2, f3, f4, f5, f6, false);
    }

    public void o0(t1 t1Var, float f) {
        aaa();
        this.f9703i.f9711ad = this.f9708yj.vvv(t1Var);
        s0 qw2 = z().qw(this.f9703i.f9711ad.qw(), this.f9703i.f9711ad.ad());
        b0(new h2(t1Var, f), false);
        rg rgVar = this.f9702ad;
        rgVar.pf(qw2.th());
        rgVar.uk(" CS ");
        rgVar.rg(f);
        rgVar.uk(" SCN");
        rgVar.ppp(this.f450if);
    }

    public void p() {
        if (this.when) {
            if (F()) {
                j();
            } else {
                throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        c2.g(this.f9708yj, 1, this.f9703i.ggg);
        c2.g(this.f9708yj, 6, this.f9703i.mmm);
        rg rgVar = this.f9702ad;
        rgVar.uk("f");
        rgVar.ppp(this.f450if);
    }

    public void p0(ad adVar, float f) {
        if (!this.when && F()) {
            xxx(true);
        }
        aaa();
        if (f >= 1.0E-4f || f <= -1.0E-4f) {
            qw qwVar = this.f9703i;
            qwVar.f9712de = f;
            qwVar.qw = this.f9708yj.xxx(adVar);
            s0 fe2 = z().fe(this.f9703i.qw.rg(), this.f9703i.qw.yj());
            rg rgVar = this.f9702ad;
            rgVar.pf(fe2.th());
            rgVar.de(Ascii.CASE_MASK);
            rgVar.rg(f);
            rgVar.uk(" Tf");
            rgVar.ppp(this.f450if);
            return;
        }
        throw new IllegalArgumentException(fe.when.ad.c.qw.ad("font.size.too.small.1", String.valueOf(f)));
    }

    public void pf(z1 z1Var, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
        aaa();
        nn(z1Var);
        c2.g(this.f9708yj, 20, z1Var);
        s0 yj2 = z().yj(this.f9708yj.when(z1Var, (s0) null), z1Var.h1());
        if (F()) {
            if (this.when) {
                j();
            }
            if (z1Var.o1() || (z1Var.k1() != null && z)) {
                throw new RuntimeException(fe.when.ad.c.qw.ad("template.with.tagged.could.not.be.used.more.than.once", new Object[0]));
            }
            z1Var.r1(this.f9708yj.t());
            if (z) {
                z1Var.p1(true);
                ArrayList<IAccessibleElement> y = y();
                if (y != null && y.size() > 0) {
                    z1Var.y().add(y.get(y.size() - 1));
                }
            } else {
                K(z1Var);
            }
        }
        this.f9702ad.uk("q ");
        rg rgVar = this.f9702ad;
        rgVar.rg(f);
        rgVar.de(Ascii.CASE_MASK);
        rg rgVar2 = this.f9702ad;
        rgVar2.rg(f2);
        rgVar2.de(Ascii.CASE_MASK);
        rg rgVar3 = this.f9702ad;
        rgVar3.rg(f3);
        rgVar3.de(Ascii.CASE_MASK);
        rg rgVar4 = this.f9702ad;
        rgVar4.rg(f4);
        rgVar4.de(Ascii.CASE_MASK);
        rg rgVar5 = this.f9702ad;
        rgVar5.rg(f5);
        rgVar5.de(Ascii.CASE_MASK);
        rg rgVar6 = this.f9702ad;
        rgVar6.rg(f6);
        rgVar6.uk(" cm ");
        rg rgVar7 = this.f9702ad;
        rgVar7.pf(yj2.th());
        rgVar7.uk(" Do Q");
        rgVar7.ppp(this.f450if);
        if (F() && !z) {
            eee(z1Var);
            z1Var.setId((fe.when.ad.qw) null);
        }
    }

    public void ppp(s0 s0Var, x xVar, boolean z) {
        y0[] y0VarArr;
        int nn = this.f9702ad.nn();
        if (xVar == null) {
            rg rgVar = this.f9702ad;
            rgVar.pf(s0Var.th());
            rgVar.uk(" BMC");
            rgVar.ppp(this.f450if);
            z0(x() + 1);
        } else {
            rg rgVar2 = this.f9702ad;
            rgVar2.pf(s0Var.th());
            rgVar2.de(Ascii.CASE_MASK);
            if (z) {
                try {
                    xVar.nn(this.f9708yj, this.f9702ad);
                } catch (Exception e) {
                    throw new ExceptionConverter(e);
                }
            } else {
                if (this.f9708yj.c0(xVar)) {
                    y0VarArr = this.f9708yj.mmm(xVar, (l0) null);
                } else {
                    c2 c2Var = this.f9708yj;
                    y0VarArr = c2Var.mmm(xVar, c2Var.M());
                }
                this.f9702ad.pf(z().th((s0) y0VarArr[0], (l0) y0VarArr[1]).th());
            }
            rg rgVar3 = this.f9702ad;
            rgVar3.uk(" BDC");
            rgVar3.ppp(this.f450if);
            z0(x() + 1);
        }
        this.f9706th += this.f9702ad.nn() - nn;
    }

    public float q() {
        return this.f9703i.f453switch;
    }

    public void q0(float f) {
        b0(new nn(f), true);
        rg rgVar = this.f9702ad;
        rgVar.rg(f);
        rgVar.uk(" g");
        rgVar.ppp(this.f450if);
    }

    public void qqq() {
        if (this.when && F()) {
            j();
        }
        rg rgVar = this.f9702ad;
        rgVar.uk(ExifInterface.LONGITUDE_WEST);
        rgVar.ppp(this.f450if);
    }

    public final void qw(float f, float f2, float f3, float f4) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f3 < 0.0f) {
            f3 = 0.0f;
        } else if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        if (f4 < 0.0f) {
            f4 = 0.0f;
        } else if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        rg rgVar = this.f9702ad;
        rgVar.rg(f);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f2);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f3);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f4);
    }

    public l0 r() {
        return this.f9708yj.t();
    }

    public void r0(float f) {
        b0(new nn(f), false);
        rg rgVar = this.f9702ad;
        rgVar.rg(f);
        rgVar.uk(" G");
        rgVar.ppp(this.f450if);
    }

    public void rg(j jVar, boolean z) {
        if (z && this.f9703i.nn.getType() != 0) {
            jVar.l(this.f9703i.nn);
        }
        fe(jVar);
    }

    public final void rrr(IAccessibleElement iAccessibleElement) {
        if (F() && iAccessibleElement.getRole() != null) {
            x1 x1Var = this.f9707uk.eee.get(iAccessibleElement.getId());
            if (x1Var != null) {
                x1Var.N(iAccessibleElement);
            }
            if (this.f9708yj.b0(iAccessibleElement)) {
                boolean z = this.when;
                if (z) {
                    j();
                }
                h();
                if (z) {
                    xxx(true);
                }
            }
        }
    }

    public q s() {
        q qVar = new q(this.f9708yj);
        qVar.ggg = this;
        return qVar;
    }

    public void s0(int i2) {
        if (i2 >= 0 && i2 <= 2) {
            rg rgVar = this.f9702ad;
            rgVar.th(i2);
            rgVar.uk(" J");
            rgVar.ppp(this.f450if);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m1114switch(PdfOCG pdfOCG) {
        int i2 = 0;
        if (!(pdfOCG instanceof n0) || ((n0) pdfOCG).n() == null) {
            if (this.f9705pf == null) {
                this.f9705pf = new ArrayList<>();
            }
            if (pdfOCG instanceof o0) {
                this.f9705pf.add(1);
                when(pdfOCG);
                return;
            }
            for (n0 n0Var = (n0) pdfOCG; n0Var != null; n0Var = n0Var.m()) {
                if (n0Var.n() == null) {
                    when(n0Var);
                    i2++;
                }
            }
            this.f9705pf.add(Integer.valueOf(i2));
            return;
        }
        throw new IllegalArgumentException(fe.when.ad.c.qw.ad("a.title.is.not.a.layer", new Object[0]));
    }

    public q t(boolean z) {
        q s = s();
        if (z) {
            s.f9703i = this.f9703i;
            s.f9704o = this.f9704o;
        }
        return s;
    }

    public void t0(float f) {
        rg rgVar = this.f9702ad;
        rgVar.uk("[] ");
        rgVar.rg(f);
        rgVar.uk(" d");
        rgVar.ppp(this.f450if);
    }

    public void th(i iVar) throws DocumentException {
        i(iVar, false);
    }

    public String toString() {
        return this.f9702ad.toString();
    }

    public void tt() {
        if (this.when) {
            if (F()) {
                j();
            } else {
                throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        rg rgVar = this.f9702ad;
        rgVar.uk("h");
        rgVar.ppp(this.f450if);
    }

    public final float u(String str, boolean z, float f) {
        float f2;
        ad fe2 = this.f9703i.qw.fe();
        if (z) {
            f2 = fe2.rrr(str, this.f9703i.f9712de);
        } else {
            f2 = fe2.eee(str, this.f9703i.f9712de);
        }
        if (this.f9703i.f453switch != 0.0f && str.length() > 0) {
            f2 += this.f9703i.f453switch * ((float) str.length());
        }
        if (this.f9703i.when != 0.0f && !fe2.c()) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (str.charAt(i2) == ' ') {
                    f2 += this.f9703i.when;
                }
            }
        }
        qw qwVar = this.f9703i;
        float f3 = f2 - ((f / 1000.0f) * qwVar.f9712de);
        float f4 = qwVar.f452if;
        return ((double) f4) != 100.0d ? (f3 * f4) / 100.0f : f3;
    }

    public void u0(float f, float f2) {
        rg rgVar = this.f9702ad;
        rgVar.uk("[");
        rgVar.rg(f);
        rgVar.uk("] ");
        rgVar.rg(f2);
        rgVar.uk(" d");
        rgVar.ppp(this.f450if);
    }

    public void uk(i iVar, float f, float f2, float f3, float f4, float f5, float f6, boolean z) throws DocumentException {
        char c;
        int i2;
        float f7;
        boolean z2;
        byte[] M0;
        i iVar2 = iVar;
        float f8 = f;
        float f9 = f2;
        float f10 = f3;
        float f11 = f4;
        float f12 = f5;
        float f13 = f6;
        try {
            if (iVar.O() != null) {
                m1114switch(iVar.O());
            }
            if (F()) {
                if (this.when) {
                    j();
                }
                fe.ad[] adVarArr = new fe.ad[4];
                new AffineTransform(f, f2, f3, f4, f5, f6).transform((fe[]) new fe.ad[]{new fe.ad(0.0f, 0.0f), new fe.ad(1.0f, 0.0f), new fe.ad(1.0f, 1.0f), new fe.ad(0.0f, 1.0f)}, 0, (fe[]) adVarArr, 0, 4);
                float f14 = -3.4028235E38f;
                float f15 = -3.4028235E38f;
                float f16 = Float.MAX_VALUE;
                float f17 = Float.MAX_VALUE;
                int i3 = 0;
                for (int i4 = 4; i3 < i4; i4 = 4) {
                    if (adVarArr[i3].getX() < ((double) f16)) {
                        f16 = (float) adVarArr[i3].getX();
                    }
                    if (adVarArr[i3].getX() > ((double) f14)) {
                        f14 = (float) adVarArr[i3].getX();
                    }
                    if (adVarArr[i3].getY() < ((double) f17)) {
                        f17 = (float) adVarArr[i3].getY();
                    }
                    if (adVarArr[i3].getY() > ((double) f15)) {
                        f15 = (float) adVarArr[i3].getY();
                    }
                    i3++;
                    float f18 = f5;
                    float f19 = f6;
                }
                iVar2.setAccessibleAttribute(s0.m, new k(new float[]{f16, f17, f14, f15}));
            }
            if (this.f9708yj == null || !iVar.f0()) {
                c = 0;
                this.f9702ad.uk("q ");
                rg rgVar = this.f9702ad;
                rgVar.rg(f8);
                rgVar.de(Ascii.CASE_MASK);
                rg rgVar2 = this.f9702ad;
                rgVar2.rg(f9);
                rgVar2.de(Ascii.CASE_MASK);
                rg rgVar3 = this.f9702ad;
                rgVar3.rg(f10);
                rgVar3.de(Ascii.CASE_MASK);
                rg rgVar4 = this.f9702ad;
                rgVar4.rg(f11);
                rgVar4.de(Ascii.CASE_MASK);
                rg rgVar5 = this.f9702ad;
                f7 = f5;
                rgVar5.rg(f7);
                rgVar5.de(Ascii.CASE_MASK);
                rg rgVar6 = this.f9702ad;
                rgVar6.rg(f6);
                rgVar6.uk(" cm");
                if (z) {
                    this.f9702ad.uk("\nBI\n");
                    i0 i0Var = new i0(iVar2, "", (l0) null);
                    if ((iVar2 instanceof pf) && (M0 = ((pf) iVar2).M0()) != null) {
                        x xVar = new x();
                        xVar.h(s0.o2, this.f9708yj.P(M0));
                        i0Var.h(s0.p0, xVar);
                    }
                    c2.g(this.f9708yj, 17, i0Var);
                    for (s0 next : i0Var.e()) {
                        y0 qqq = i0Var.qqq(next);
                        String str = xxx.get(next);
                        if (str != null) {
                            this.f9702ad.uk(str);
                            if (next.equals(s0.T) && qqq.i()) {
                                k kVar = (k) qqq;
                                if (kVar.size() == 4 && s0.g2.equals(kVar.d(0)) && kVar.g(1).m1125switch()) {
                                    if (kVar.g(2).ppp()) {
                                        if (kVar.g(3).vvv()) {
                                            z2 = false;
                                            if (z2 && next.equals(s0.T) && !qqq.m1125switch()) {
                                                s0 q = this.f9708yj.q();
                                                z().qw(q, this.f9708yj.eee(qqq).qw());
                                                qqq = q;
                                            }
                                            qqq.nn((c2) null, this.f9702ad);
                                            this.f9702ad.de(10);
                                        }
                                    }
                                    z2 = true;
                                    s0 q2 = this.f9708yj.q();
                                    z().qw(q2, this.f9708yj.eee(qqq).qw());
                                    qqq = q2;
                                    qqq.nn((c2) null, this.f9702ad);
                                    this.f9702ad.de(10);
                                }
                            }
                            z2 = true;
                            s0 q22 = this.f9708yj.q();
                            z().qw(q22, this.f9708yj.eee(qqq).qw());
                            qqq = q22;
                            qqq.nn((c2) null, this.f9702ad);
                            this.f9702ad.de(10);
                        }
                    }
                    i2 = 2;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    i0Var.p(byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    this.f9702ad.uk(String.format("/L %s\n", new Object[]{Integer.valueOf(byteArray.length)}));
                    this.f9702ad.uk("ID\n");
                    this.f9702ad.pf(byteArray);
                    rg rgVar7 = this.f9702ad;
                    rgVar7.uk("\nEI\nQ");
                    rgVar7.ppp(this.f450if);
                } else {
                    i2 = 2;
                    e z3 = z();
                    i A = iVar.A();
                    if (A != null) {
                        s0 s0Var = this.f9708yj.m1069if(A);
                        z3.yj(s0Var, this.f9708yj.A(s0Var));
                    }
                    s0 s0Var2 = this.f9708yj.m1069if(iVar2);
                    s0 yj2 = z3.yj(s0Var2, this.f9708yj.A(s0Var2));
                    rg rgVar8 = this.f9702ad;
                    rgVar8.de(Ascii.CASE_MASK);
                    rgVar8.pf(yj2.th());
                    rgVar8.uk(" Do Q");
                    rgVar8.ppp(this.f450if);
                }
            } else {
                this.f9708yj.m1069if(iVar2);
                z1 W = iVar.W();
                if (iVar.getAccessibleAttributes() != null) {
                    for (s0 next2 : iVar.getAccessibleAttributes().keySet()) {
                        W.setAccessibleAttribute(next2, iVar2.getAccessibleAttribute(next2));
                    }
                }
                float n1 = W.n1();
                float g1 = W.g1();
                c = 0;
                o(W, f8 / n1, f9 / n1, f10 / g1, f11 / g1, f5, f6);
                f7 = f5;
                float f20 = f6;
                i2 = 2;
            }
            if (iVar.a()) {
                d0();
                float rrr = iVar.rrr();
                float ggg2 = iVar.ggg();
                e(f8 / rrr, f9 / rrr, f10 / ggg2, f11 / ggg2, f5, f6);
                O(iVar);
                Y();
            }
            if (iVar.O() != null) {
                g();
            }
            fe.when.ad.ad t = iVar.t();
            if (t != null) {
                int length = vvv.length;
                float[] fArr = new float[length];
                for (int i5 = 0; i5 < vvv.length; i5 += 2) {
                    int i6 = i5 + 1;
                    fArr[i5] = (vvv[i5] * f8) + (vvv[i6] * f10) + f7;
                    fArr[i6] = (vvv[i5] * f9) + (vvv[i6] * f11) + f6;
                }
                float f21 = fArr[c];
                float f22 = fArr[1];
                float f23 = f22;
                float f24 = f21;
                while (i2 < length) {
                    f21 = Math.min(f21, fArr[i2]);
                    int i7 = i2 + 1;
                    f22 = Math.min(f22, fArr[i7]);
                    f24 = Math.max(f24, fArr[i2]);
                    f23 = Math.max(f23, fArr[i7]);
                    i2 += 2;
                }
                fe.when.ad.ad adVar = new fe.when.ad.ad(t);
                adVar.uk(f21, f22, f24, f23);
                j fe2 = fe.when.ad.f.s2.qw.fe(this.f9708yj, adVar, new aaa(f21, f22, f24, f23));
                if (fe2 != null) {
                    fe(fe2);
                }
            }
        } catch (Exception e) {
            throw new DocumentException(e);
        }
    }

    public boolean v() {
        return this.when;
    }

    public void v0(float f, float f2, float f3) {
        rg rgVar = this.f9702ad;
        rgVar.uk("[");
        rgVar.rg(f);
        rgVar.de(Ascii.CASE_MASK);
        rgVar.rg(f2);
        rgVar.uk("] ");
        rgVar.rg(f3);
        rgVar.uk(" d");
        rgVar.ppp(this.f450if);
    }

    public void vvv() {
        xxx(false);
    }

    public rg w() {
        return this.f9702ad;
    }

    public void w0(int i2) {
        if (i2 >= 0 && i2 <= 2) {
            rg rgVar = this.f9702ad;
            rgVar.th(i2);
            rgVar.uk(" j");
            rgVar.ppp(this.f450if);
        }
    }

    public final void when(PdfOCG pdfOCG) {
        s0 th2 = z().th((s0) this.f9708yj.mmm(pdfOCG, pdfOCG.fe())[0], pdfOCG.fe());
        rg rgVar = this.f9702ad;
        rgVar.uk("/OC ");
        rgVar.pf(th2.th());
        rgVar.uk(" BDC");
        rgVar.ppp(this.f450if);
    }

    public int x() {
        q qVar = this.ggg;
        if (qVar != null) {
            return qVar.x();
        }
        return this.f451switch;
    }

    public void x0(float f) {
        rg rgVar = this.f9702ad;
        rgVar.rg(f);
        rgVar.uk(" w");
        rgVar.ppp(this.f450if);
    }

    public void xxx(boolean z) {
        if (!this.when) {
            this.when = true;
            rg rgVar = this.f9702ad;
            rgVar.uk("BT");
            rgVar.ppp(this.f450if);
            if (z) {
                qw qwVar = this.f9703i;
                float f = qwVar.f9713fe;
                float f2 = qwVar.f9715o;
                M0(qwVar.f9718th, qwVar.f9720yj, qwVar.f9719uk, qwVar.f9714i, f2, qwVar.f9717rg);
                qw qwVar2 = this.f9703i;
                qwVar2.f9713fe = f;
                qwVar2.f9715o = f2;
            } else {
                qw qwVar3 = this.f9703i;
                qwVar3.f9713fe = 0.0f;
                qwVar3.f9717rg = 0.0f;
                qwVar3.f9715o = 0.0f;
            }
            if (F()) {
                try {
                    V();
                } catch (IOException unused) {
                }
            }
        } else if (!F()) {
            throw new IllegalPdfSyntaxException(fe.when.ad.c.qw.ad("unbalanced.begin.end.text.operators", new Object[0]));
        }
    }

    public ArrayList<IAccessibleElement> y() {
        q qVar = this.ggg;
        if (qVar != null) {
            return qVar.y();
        }
        return this.ppp;
    }

    public void y0(String str) {
        this.f9702ad.uk(str);
    }

    public void yj(i iVar, float f, float f2, float f3, float f4, float f5, float f6) throws DocumentException {
        uk(iVar, f, f2, f3, f4, f5, f6, false);
    }

    public e z() {
        return this.f9707uk.l();
    }

    public void z0(int i2) {
        q qVar = this.ggg;
        if (qVar != null) {
            qVar.z0(i2);
        } else {
            this.f451switch = i2;
        }
    }

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public o f9711ad;
        public int ddd = 0;

        /* renamed from: de  reason: collision with root package name */
        public float f9712de;

        /* renamed from: fe  reason: collision with root package name */
        public float f9713fe = 0.0f;
        public de ggg = new nn(0);

        /* renamed from: i  reason: collision with root package name */
        public float f9714i = 1.0f;

        /* renamed from: if  reason: not valid java name */
        public float f452if = 100.0f;
        public y0 mmm = null;
        public AffineTransform nn = new AffineTransform();

        /* renamed from: o  reason: collision with root package name */
        public float f9715o = 0.0f;

        /* renamed from: pf  reason: collision with root package name */
        public float f9716pf = 0.0f;
        public de ppp = new nn(0);
        public vvv qw;

        /* renamed from: rg  reason: collision with root package name */
        public float f9717rg = 0.0f;

        /* renamed from: switch  reason: not valid java name */
        public float f453switch = 0.0f;

        /* renamed from: th  reason: collision with root package name */
        public float f9718th = 1.0f;

        /* renamed from: uk  reason: collision with root package name */
        public float f9719uk = 0.0f;
        public de vvv = new nn(0);
        public float when = 0.0f;
        public de xxx = new nn(0);

        /* renamed from: yj  reason: collision with root package name */
        public float f9720yj = 0.0f;

        public qw() {
        }

        public void ad(qw qwVar) {
            qw(qwVar);
        }

        public void qw(qw qwVar) {
            this.qw = qwVar.qw;
            this.f9711ad = qwVar.f9711ad;
            this.f9712de = qwVar.f9712de;
            this.f9713fe = qwVar.f9713fe;
            this.f9717rg = qwVar.f9717rg;
            this.f9718th = qwVar.f9718th;
            this.f9720yj = qwVar.f9720yj;
            this.f9719uk = qwVar.f9719uk;
            this.f9714i = qwVar.f9714i;
            this.f9715o = qwVar.f9715o;
            this.f9716pf = qwVar.f9716pf;
            this.f452if = qwVar.f452if;
            this.f453switch = qwVar.f453switch;
            this.when = qwVar.when;
            this.ppp = qwVar.ppp;
            this.ggg = qwVar.ggg;
            this.vvv = qwVar.vvv;
            this.xxx = qwVar.xxx;
            this.nn = new AffineTransform(qwVar.nn);
            this.ddd = qwVar.ddd;
            this.mmm = qwVar.mmm;
        }

        public qw(qw qwVar) {
            qw(qwVar);
        }
    }
}
