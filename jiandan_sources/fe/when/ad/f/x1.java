package fe.when.ad.f;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDiv;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import com.itextpdf.text.pdf.interfaces.IPdfStructureElement;
import fe.when.ad.aaa;
import fe.when.ad.c.qw;
import fe.when.ad.de;
import fe.when.ad.fe;
import fe.when.ad.ggg;
import fe.when.ad.i;
import fe.when.ad.ppp;
import fe.when.ad.th;
import fe.when.ad.vvv;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;

public class x1 extends x implements IPdfStructureElement {
    public l0 ppp;

    /* renamed from: switch  reason: not valid java name */
    public x1 f465switch;
    public y1 when;

    public x1(x xVar, s0 s0Var) {
        if (xVar instanceof x1) {
            x1 x1Var = (x1) xVar;
            this.when = x1Var.when;
            q(xVar, s0Var);
            this.f465switch = x1Var;
            h(s0.F3, x1Var.ppp);
            h(s0.K5, s0.V4);
        } else if (xVar instanceof y1) {
            y1 y1Var = (y1) xVar;
            this.when = y1Var;
            q(xVar, s0Var);
            h(s0.F3, y1Var.n());
            h(s0.K5, s0.V4);
        }
    }

    public final void A(ggg ggg) {
    }

    public final void B(ListItem listItem) {
        if (listItem != null) {
            y0 qw = this.f465switch.qw(s0.S4);
            if (qw instanceof v0) {
                if (Float.compare(((v0) qw).qqq(), listItem.getIndentationLeft()) != 0) {
                    s(s0.S4, new v0(listItem.getIndentationLeft()));
                }
            } else if (Math.abs(listItem.getIndentationLeft()) > Float.MIN_VALUE) {
                s(s0.S4, new v0(listItem.getIndentationLeft()));
            }
            y0 qw2 = this.f465switch.qw(s0.S0);
            if (qw2 instanceof v0) {
                if (Float.compare(((v0) qw2).qqq(), listItem.getIndentationRight()) != 0) {
                    s(s0.S0, new v0(listItem.getIndentationRight()));
                }
            } else if (Float.compare(listItem.getIndentationRight(), 0.0f) != 0) {
                s(s0.S0, new v0(listItem.getIndentationRight()));
            }
        }
    }

    public final void C(vvv vvv) {
        if (vvv != null) {
            y0 qw = this.f465switch.qw(s0.S4);
            if (qw instanceof v0) {
                if (Float.compare(((v0) qw).qqq(), vvv.qw()) != 0) {
                    s(s0.S4, new v0(vvv.qw()));
                }
            } else if (Math.abs(vvv.qw()) > Float.MIN_VALUE) {
                s(s0.S4, new v0(vvv.qw()));
            }
        }
    }

    public final void D(Paragraph paragraph) {
        if (paragraph != null) {
            s(s0.o3, s0.C2);
            if (Float.compare(paragraph.getSpacingBefore(), 0.0f) != 0) {
                s(s0.P4, new v0(paragraph.getSpacingBefore()));
            }
            if (Float.compare(paragraph.getSpacingAfter(), 0.0f) != 0) {
                s(s0.O4, new v0(paragraph.getSpacingAfter()));
            }
            boolean z = true;
            IPdfStructureElement iPdfStructureElement = (IPdfStructureElement) n(true);
            y0 qw = iPdfStructureElement.qw(s0.R);
            if (!(paragraph.getFont() == null || paragraph.getFont().i() == null)) {
                t(paragraph.getFont().i(), qw, s0.R);
            }
            y0 qw2 = iPdfStructureElement.qw(s0.p5);
            if (Float.compare(paragraph.getFirstLineIndent(), 0.0f) != 0) {
                if ((qw2 instanceof v0) && Float.compare(((v0) qw2).qqq(), new Float(paragraph.getFirstLineIndent()).floatValue()) == 0) {
                    z = false;
                }
                if (z) {
                    s(s0.p5, new v0(paragraph.getFirstLineIndent()));
                }
            }
            y0 qw3 = iPdfStructureElement.qw(s0.S4);
            if (qw3 instanceof v0) {
                if (Float.compare(((v0) qw3).qqq(), paragraph.getIndentationLeft()) != 0) {
                    s(s0.S4, new v0(paragraph.getIndentationLeft()));
                }
            } else if (Math.abs(paragraph.getIndentationLeft()) > Float.MIN_VALUE) {
                s(s0.S4, new v0(paragraph.getIndentationLeft()));
            }
            y0 qw4 = iPdfStructureElement.qw(s0.S0);
            if (qw4 instanceof v0) {
                if (Float.compare(((v0) qw4).qqq(), paragraph.getIndentationRight()) != 0) {
                    s(s0.S0, new v0(paragraph.getIndentationRight()));
                }
            } else if (Float.compare(paragraph.getIndentationRight(), 0.0f) != 0) {
                s(s0.S0, new v0(paragraph.getIndentationRight()));
            }
            v(paragraph.getAlignment());
        }
    }

    public final void E(PdfDiv pdfDiv) {
        if (pdfDiv != null) {
            if (pdfDiv.de() != null) {
                t(pdfDiv.de(), (y0) null, s0.k);
            }
            v(pdfDiv.th());
        }
    }

    public final void F(a1 a1Var) {
        if (a1Var != null) {
            s(s0.o3, s0.f5);
            if (a1Var.r() != 1) {
                s(s0.W, new v0(a1Var.r()));
            }
            if (a1Var.D() != 1) {
                s(s0.y4, new v0(a1Var.D()));
            }
            if (a1Var.y() != null) {
                k kVar = new k();
                Iterator<b1> it = a1Var.y().iterator();
                while (it.hasNext()) {
                    b1 next = it.next();
                    if (next.T() != null) {
                        kVar.qqq(new w1(next.T()));
                    }
                }
                if (!kVar.isEmpty()) {
                    s(s0.P1, kVar);
                }
            }
            if (a1Var.x() > 0.0f) {
                s(s0.Q1, new v0(a1Var.x()));
            }
            if (a1Var.rrr() > 0.0f) {
                s(s0.l6, new v0(a1Var.rrr()));
            }
            if (a1Var.ad() != null) {
                de ad2 = a1Var.ad();
                s(s0.k, new k(new float[]{((float) ad2.fe()) / 255.0f, ((float) ad2.ad()) / 255.0f, ((float) ad2.qw()) / 255.0f}));
            }
        }
    }

    public final void G(b1 b1Var) {
        if (b1Var != null) {
            if (b1Var.U() != 0) {
                int U = b1Var.U();
                if (U == 1) {
                    s(s0.F4, s0.w4);
                } else if (U == 2) {
                    s(s0.F4, s0.X);
                } else if (U == 3) {
                    s(s0.F4, s0.w);
                }
            }
            if (b1Var.T() != null) {
                s(s0.c3, new s0(b1Var.T()));
            }
            F(b1Var);
        }
    }

    public final void H(c1 c1Var) {
        if (c1Var != null) {
            s(s0.o3, s0.f5);
        }
    }

    public final void I(d1 d1Var) {
        if (d1Var != null) {
            if (Float.compare(d1Var.getSpacingBefore(), 0.0f) != 0) {
                s(s0.P4, new v0(d1Var.getSpacingBefore()));
            }
            if (Float.compare(d1Var.c(), 0.0f) != 0) {
                s(s0.O4, new v0(d1Var.c()));
            }
            if (d1Var.e() > 0.0f) {
                s(s0.Q1, new v0(d1Var.e()));
            }
            if (d1Var.f() > 0.0f) {
                s(s0.l6, new v0(d1Var.f()));
            }
        }
    }

    public final void J(e1 e1Var) {
    }

    public final void K(f1 f1Var) {
    }

    public final void L(g1 g1Var) {
        if (g1Var != null) {
            s(s0.o3, s0.f5);
        }
    }

    public final void M(z1 z1Var) {
        if (z1Var != null) {
            s(s0.o3, s0.C2);
            if (z1Var.n1() > 0.0f) {
                s(s0.l6, new v0(z1Var.n1()));
            }
            if (z1Var.g1() > 0.0f) {
                s(s0.Q1, new v0(z1Var.g1()));
            }
            s(s0.m, new o1(z1Var.d1()));
        }
    }

    public void N(IAccessibleElement iAccessibleElement) {
        if (this.when.p().O().ad() >= '7') {
            if (iAccessibleElement instanceof ListItem) {
                B((ListItem) iAccessibleElement);
            } else if (iAccessibleElement instanceof Paragraph) {
                D((Paragraph) iAccessibleElement);
            } else if (iAccessibleElement instanceof fe) {
                w((fe) iAccessibleElement);
            } else if (iAccessibleElement instanceof i) {
                y((i) iAccessibleElement);
            } else if (iAccessibleElement instanceof ppp) {
                z((ppp) iAccessibleElement);
            } else if (iAccessibleElement instanceof vvv) {
                C((vvv) iAccessibleElement);
            } else if (iAccessibleElement instanceof ggg) {
                A((ggg) iAccessibleElement);
            } else if (iAccessibleElement instanceof d1) {
                I((d1) iAccessibleElement);
            } else if (iAccessibleElement instanceof c1) {
                H((c1) iAccessibleElement);
            } else if (iAccessibleElement instanceof b1) {
                G((b1) iAccessibleElement);
            } else if (iAccessibleElement instanceof a1) {
                F((a1) iAccessibleElement);
            } else if (iAccessibleElement instanceof g1) {
                L((g1) iAccessibleElement);
            } else if (iAccessibleElement instanceof f1) {
                K((f1) iAccessibleElement);
            } else if (iAccessibleElement instanceof e1) {
                J((e1) iAccessibleElement);
            } else if (iAccessibleElement instanceof PdfDiv) {
                E((PdfDiv) iAccessibleElement);
            } else if (iAccessibleElement instanceof z1) {
                M((z1) iAccessibleElement);
            } else if (iAccessibleElement instanceof th) {
                x((th) iAccessibleElement);
            }
            if (iAccessibleElement.getAccessibleAttributes() != null) {
                for (s0 next : iAccessibleElement.getAccessibleAttributes().keySet()) {
                    if (next.equals(s0.x2) || next.equals(s0.vvv) || next.equals(s0.when) || next.equals(s0.K0)) {
                        h(next, iAccessibleElement.getAccessibleAttribute(next));
                    } else {
                        s(next, iAccessibleElement.getAccessibleAttribute(next));
                    }
                }
            }
        }
    }

    public final boolean l(k kVar, float[] fArr) {
        return Float.compare(fArr[0], kVar.e(0).qqq()) == 0 && Float.compare(fArr[1], kVar.e(1).qqq()) == 0 && Float.compare(fArr[2], kVar.e(2).qqq()) == 0;
    }

    public x m() {
        return n(false);
    }

    public x n(boolean z) {
        if (this.f465switch != null || !z) {
            return this.f465switch;
        }
        return this.when;
    }

    public void nn(c2 c2Var, OutputStream outputStream) throws IOException {
        c2.g(c2Var, 16, this);
        super.nn(c2Var, outputStream);
    }

    public l0 p() {
        return this.ppp;
    }

    public final void q(x xVar, s0 s0Var) {
        k kVar;
        x c;
        if (!this.when.p().R().contains(s0Var)) {
            x tt = this.when.tt(s0.t4);
            if (tt == null || !tt.aaa(s0Var)) {
                throw new ExceptionConverter(new DocumentException(qw.ad("unknown.structure.element.role.1", s0Var.toString())));
            }
            tt.a(s0Var);
        }
        y0 qqq = xVar.qqq(s0.s2);
        if (qqq == null) {
            kVar = new k();
            xVar.h(s0.s2, kVar);
        } else if (qqq instanceof k) {
            kVar = (k) qqq;
        } else {
            k kVar2 = new k();
            kVar2.qqq(qqq);
            xVar.h(s0.s2, kVar2);
            kVar = kVar2;
        }
        if (kVar.size() > 0) {
            if (kVar.e(0) != null) {
                kVar.h(0);
            }
            if (kVar.size() > 0 && (c = kVar.c(0)) != null && s0.Y2.equals(c.a(s0.K5))) {
                kVar.h(0);
            }
        }
        kVar.qqq(this);
        h(s0.D4, s0Var);
        this.ppp = this.when.p().M();
    }

    public y0 qw(s0 s0Var) {
        x tt = tt(s0.f9757i);
        if (tt != null && tt.aaa(s0Var)) {
            return tt.qqq(s0Var);
        }
        x m = m();
        if (m instanceof x1) {
            return ((x1) m).qw(s0Var);
        }
        if (m instanceof y1) {
            return ((y1) m).qw(s0Var);
        }
        return new u0();
    }

    public void r(j jVar, l0 l0Var) {
        k eee = eee(s0.s2);
        if (eee == null) {
            eee = new k();
            y0 qqq = qqq(s0.s2);
            if (qqq != null) {
                eee.qqq(qqq);
            }
            h(s0.s2, eee);
        }
        x xVar = new x();
        xVar.h(s0.K5, s0.q3);
        xVar.h(s0.p3, jVar.n());
        if (jVar.getRole() == s0.y1) {
            xVar.h(s0.U3, l0Var);
        }
        eee.qqq(xVar);
    }

    public void s(s0 s0Var, y0 y0Var) {
        x tt = tt(s0.f9757i);
        if (tt == null) {
            tt = new x();
            h(s0.f9757i, tt);
        }
        tt.h(s0Var, y0Var);
    }

    public final void t(de deVar, y0 y0Var, s0 s0Var) {
        float[] fArr = {((float) deVar.fe()) / 255.0f, ((float) deVar.ad()) / 255.0f, ((float) deVar.qw()) / 255.0f};
        if (y0Var == null || !(y0Var instanceof k)) {
            s(s0Var, new k(fArr));
        } else if (l((k) y0Var, fArr)) {
            s(s0Var, new k(fArr));
        } else {
            s(s0Var, new k(fArr));
        }
    }

    public void u(int i2, int i3) {
        if (i3 >= 0) {
            h(s0.s2, new v0(i3));
        }
        this.when.s(i2, this.ppp);
    }

    public final void v(int i2) {
        s0 s0Var;
        if (i2 == 0) {
            s0Var = s0.R4;
        } else if (i2 == 1) {
            s0Var = s0.H;
        } else if (i2 != 2) {
            s0Var = i2 != 3 ? null : s0.r2;
        } else {
            s0Var = s0.R0;
        }
        y0 qw = this.f465switch.qw(s0.l5);
        if (qw instanceof s0) {
            s0 s0Var2 = (s0) qw;
            if (s0Var != null && !s0Var2.equals(s0Var)) {
                s(s0.l5, s0Var);
            }
        } else if (s0Var != null && !s0.R4.equals(s0Var)) {
            s(s0.l5, s0Var);
        }
    }

    public final void w(fe feVar) {
        if (feVar == null) {
            return;
        }
        if (feVar.yj() != null) {
            y(feVar.yj());
            return;
        }
        HashMap<String, Object> ad2 = feVar.ad();
        if (ad2 != null) {
            s(s0.o3, s0.C2);
            if (ad2.containsKey("UNDERLINE")) {
                s(s0.o5, s0.P5);
            }
            if (ad2.containsKey("BACKGROUND")) {
                de deVar = (de) ((Object[]) ad2.get("BACKGROUND"))[0];
                s(s0.k, new k(new float[]{((float) deVar.fe()) / 255.0f, ((float) deVar.ad()) / 255.0f, ((float) deVar.qw()) / 255.0f}));
            }
            IPdfStructureElement iPdfStructureElement = (IPdfStructureElement) n(true);
            y0 qw = iPdfStructureElement.qw(s0.R);
            if (!(feVar.fe() == null || feVar.fe().i() == null)) {
                t(feVar.fe().i(), qw, s0.R);
            }
            y0 qw2 = iPdfStructureElement.qw(s0.n5);
            y0 qw3 = iPdfStructureElement.qw(s0.m5);
            if (ad2.containsKey("UNDERLINE")) {
                Object[][] objArr = (Object[][]) ad2.get("UNDERLINE");
                Object[] objArr2 = objArr[objArr.length - 1];
                de deVar2 = (de) objArr2[0];
                float f = ((float[]) objArr2[1])[0];
                if (!(qw2 instanceof v0)) {
                    s(s0.n5, new v0(f));
                } else if (Float.compare(f, ((v0) qw2).qqq()) != 0) {
                    s(s0.n5, new v0(f));
                }
                if (deVar2 != null) {
                    t(deVar2, qw3, s0.m5);
                }
            }
            if (ad2.containsKey("LINEHEIGHT")) {
                float floatValue = ((Float) ad2.get("LINEHEIGHT")).floatValue();
                y0 qw4 = iPdfStructureElement.qw(s0.I2);
                if (!(qw4 instanceof v0)) {
                    s(s0.I2, new v0(floatValue));
                } else if (Float.compare(((v0) qw4).qqq(), floatValue) != 0) {
                    s(s0.I2, new v0(floatValue));
                }
            }
        }
    }

    public final void x(th thVar) {
    }

    public final void y(i iVar) {
        if (iVar != null) {
            s(s0.o3, s0.C2);
            if (iVar.rrr() > 0.0f) {
                s(s0.l6, new v0(iVar.rrr()));
            }
            if (iVar.ggg() > 0.0f) {
                s(s0.Q1, new v0(iVar.ggg()));
            }
            s(s0.m, new o1((aaa) iVar, iVar.mmm()));
            if (iVar.ad() != null) {
                de ad2 = iVar.ad();
                s(s0.k, new k(new float[]{((float) ad2.fe()) / 255.0f, ((float) ad2.ad()) / 255.0f, ((float) ad2.qw()) / 255.0f}));
            }
        }
    }

    public final void z(ppp ppp2) {
        if (ppp2 != null) {
            s(s0.o3, s0.K2);
            if (ppp2.yj()) {
                if (ppp2.o()) {
                    if (!ppp2.uk()) {
                        s(s0.M2, s0.n0);
                    } else if (ppp2.i()) {
                        s(s0.M2, s0.P2);
                    } else {
                        s(s0.M2, s0.R5);
                    }
                } else if (ppp2.uk()) {
                    if (ppp2.i()) {
                        s(s0.M2, s0.O2);
                    } else {
                        s(s0.M2, s0.Q5);
                    }
                }
            }
            y0 qw = this.f465switch.qw(s0.S4);
            if (qw instanceof v0) {
                if (Float.compare(((v0) qw).qqq(), ppp2.ad()) != 0) {
                    s(s0.S4, new v0(ppp2.ad()));
                }
            } else if (Math.abs(ppp2.ad()) > Float.MIN_VALUE) {
                s(s0.S4, new v0(ppp2.ad()));
            }
            y0 qw2 = this.f465switch.qw(s0.S0);
            if (qw2 instanceof v0) {
                if (Float.compare(((v0) qw2).qqq(), ppp2.de()) != 0) {
                    s(s0.S0, new v0(ppp2.de()));
                }
            } else if (Float.compare(ppp2.de(), 0.0f) != 0) {
                s(s0.S0, new v0(ppp2.de()));
            }
        }
    }
}
