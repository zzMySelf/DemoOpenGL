package fe.when.ad.f.s2;

import com.itextpdf.text.pdf.PdfXConformanceException;
import com.itextpdf.text.pdf.interfaces.PdfXConformance;
import fe.when.ad.c.qw;
import fe.when.ad.de;
import fe.when.ad.f.ad;
import fe.when.ad.f.c2;
import fe.when.ad.f.f;
import fe.when.ad.f.f2;
import fe.when.ad.f.g0;
import fe.when.ad.f.h2;
import fe.when.ad.f.i0;
import fe.when.ad.f.k;
import fe.when.ad.f.ppp;
import fe.when.ad.f.s0;
import fe.when.ad.f.v0;
import fe.when.ad.f.x;
import fe.when.ad.f.y0;

public class fe implements PdfXConformance {

    /* renamed from: ad  reason: collision with root package name */
    public c2 f9769ad;
    public int qw = 0;

    public fe(c2 c2Var) {
        this.f9769ad = c2Var;
    }

    public void ad(int i2, Object obj) {
        y0 qqq;
        c2 c2Var = this.f9769ad;
        if (c2Var != null && c2Var.Y()) {
            int H = this.f9769ad.H();
            if (i2 != 1) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        ad adVar = (ad) obj;
                        if (!adVar.a()) {
                            throw new PdfXConformanceException(qw.ad("all.the.fonts.must.be.embedded.this.one.isn.t.1", adVar.ggg()));
                        }
                    } else if (i2 == 5) {
                        i0 i0Var = (i0) obj;
                        if (i0Var.qqq(s0.N4) != null) {
                            throw new PdfXConformanceException(qw.ad("the.smask.key.is.not.allowed.in.images", new Object[0]));
                        } else if (H != 1 || (qqq = i0Var.qqq(s0.T)) == null) {
                        } else {
                            if (qqq.m1125switch()) {
                                if (s0.w0.equals(qqq)) {
                                    throw new PdfXConformanceException(qw.ad("colorspace.rgb.is.not.allowed", new Object[0]));
                                }
                            } else if (qqq.i() && s0.B.equals(((k) qqq).g(0))) {
                                throw new PdfXConformanceException(qw.ad("colorspace.calrgb.is.not.allowed", new Object[0]));
                            }
                        }
                    } else if (i2 == 6) {
                        x xVar = (x) obj;
                        if (xVar != null) {
                            y0 qqq2 = xVar.qqq(s0.u);
                            if (qqq2 == null || g0.f416switch.equals(qqq2) || g0.when.equals(qqq2)) {
                                y0 qqq3 = xVar.qqq(s0.y);
                                if (qqq3 != null) {
                                    double aaa = ((v0) qqq3).aaa();
                                    if (aaa != 1.0d) {
                                        throw new PdfXConformanceException(qw.ad("transparency.is.not.allowed.ca.eq.1", String.valueOf(aaa)));
                                    }
                                }
                                y0 qqq4 = xVar.qqq(s0.z);
                                if (qqq4 != null) {
                                    double aaa2 = ((v0) qqq4).aaa();
                                    if (aaa2 != 1.0d) {
                                        throw new PdfXConformanceException(qw.ad("transparency.is.not.allowed.ca.eq.1", String.valueOf(aaa2)));
                                    }
                                    return;
                                }
                                return;
                            }
                            throw new PdfXConformanceException(qw.ad("blend.mode.1.not.allowed", qqq2.toString()));
                        }
                    } else if (i2 == 7) {
                        throw new PdfXConformanceException(qw.ad("layers.are.not.allowed", new Object[0]));
                    }
                } else if (H == 1) {
                    throw new PdfXConformanceException(qw.ad("colorspace.rgb.is.not.allowed", new Object[0]));
                }
            } else if (H == 1) {
                if (obj instanceof ppp) {
                    ppp ppp = (ppp) obj;
                    int yj2 = ppp.yj();
                    if (yj2 == 0) {
                        throw new PdfXConformanceException(qw.ad("colorspace.rgb.is.not.allowed", new Object[0]));
                    } else if (yj2 == 3) {
                        ad(1, ((h2) ppp).o().de());
                    } else if (yj2 == 4) {
                        ad(1, ((f) ppp).o().u1());
                    } else if (yj2 == 5) {
                        ad(1, ((f2) ppp).o().q().de());
                    }
                } else if (obj instanceof de) {
                    throw new PdfXConformanceException(qw.ad("colorspace.rgb.is.not.allowed", new Object[0]));
                }
            }
        }
    }

    public int de() {
        return this.qw;
    }

    public boolean fe() {
        return qw();
    }

    public boolean qw() {
        return this.qw != 0;
    }

    public boolean rg() {
        return this.qw == 1;
    }

    public boolean th() {
        return this.qw == 2;
    }
}
