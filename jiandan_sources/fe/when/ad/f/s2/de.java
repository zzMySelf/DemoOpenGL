package fe.when.ad.f.s2;

import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;
import fe.when.ad.f.s0;
import fe.when.ad.f.x;

public class de implements PdfViewerPreferences {

    /* renamed from: ad  reason: collision with root package name */
    public int f9767ad = 0;

    /* renamed from: th  reason: collision with root package name */
    public x f9768th = new x();

    static {
        s0 s0Var = s0.W1;
        s0 s0Var2 = s0.V1;
        s0 s0Var3 = s0.X1;
        s0 s0Var4 = s0.m1;
        s0 s0Var5 = s0.I;
        s0 s0Var6 = s0.A0;
        s0 s0Var7 = s0.j3;
        s0 s0Var8 = s0.z0;
        s0 s0Var9 = s0.d6;
        s0 s0Var10 = s0.e6;
        s0 s0Var11 = s0.a4;
        s0 s0Var12 = s0.b4;
        s0 s0Var13 = s0.d4;
        s0 s0Var14 = s0.G0;
        s0 s0Var15 = s0.V3;
        s0 s0Var16 = s0.c4;
        s0 s0Var17 = s0.m3;
        s0 s0Var18 = s0.V5;
        s0 s0Var19 = s0.X5;
        s0 s0Var20 = s0.Z5;
        s0 s0Var21 = s0.W5;
        s0 s0Var22 = s0.w2;
        s0 s0Var23 = s0.j4;
        s0 s0Var24 = s0.W2;
        s0 s0Var25 = s0.h0;
        s0 s0Var26 = s0.t;
        s0 s0Var27 = s0.E5;
        s0 s0Var28 = s0.eee;
        s0 s0Var29 = s0.aaa;
        s0 s0Var30 = s0.i3;
        s0 s0Var31 = s0.K4;
        s0 s0Var32 = s0.H0;
        s0 s0Var33 = s0.I0;
    }

    public void qw(x xVar) {
        xVar.k(s0.I3);
        int i2 = this.f9767ad;
        if ((i2 & 1) != 0) {
            xVar.h(s0.I3, s0.L4);
        } else if ((i2 & 2) != 0) {
            xVar.h(s0.I3, s0.w3);
        } else if ((i2 & 4) != 0) {
            xVar.h(s0.I3, s0.G5);
        } else if ((i2 & 8) != 0) {
            xVar.h(s0.I3, s0.H5);
        } else if ((i2 & 16) != 0) {
            xVar.h(s0.I3, s0.I5);
        } else if ((i2 & 32) != 0) {
            xVar.h(s0.I3, s0.J5);
        }
        xVar.k(s0.J3);
        int i3 = this.f9767ad;
        if ((i3 & 64) != 0) {
            xVar.h(s0.J3, s0.V5);
        } else if ((i3 & 128) != 0) {
            xVar.h(s0.J3, s0.X5);
        } else if ((i3 & 256) != 0) {
            xVar.h(s0.J3, s0.Z5);
        } else if ((i3 & 512) != 0) {
            xVar.h(s0.J3, s0.B1);
        } else if ((i3 & 1024) != 0) {
            xVar.h(s0.J3, s0.W5);
        } else if ((i3 & 2048) != 0) {
            xVar.h(s0.J3, s0.U5);
        }
        xVar.k(s0.f6);
        if (this.f9768th.size() > 0) {
            xVar.h(s0.f6, this.f9768th);
        }
    }
}
