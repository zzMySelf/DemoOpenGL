package fe.when.ad.f;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.pdf.PdfDiv;
import java.util.ArrayList;
import java.util.List;

public class ggg {

    /* renamed from: ad  reason: collision with root package name */
    public float f9457ad;

    /* renamed from: de  reason: collision with root package name */
    public float f9458de;

    /* renamed from: fe  reason: collision with root package name */
    public float f9459fe;

    /* renamed from: i  reason: collision with root package name */
    public final pf f9460i;

    /* renamed from: o  reason: collision with root package name */
    public final List<Element> f9461o;

    /* renamed from: pf  reason: collision with root package name */
    public final boolean f9462pf;
    public float qw;

    /* renamed from: rg  reason: collision with root package name */
    public float f9463rg;

    /* renamed from: th  reason: collision with root package name */
    public float f9464th;

    /* renamed from: uk  reason: collision with root package name */
    public float f9465uk;

    /* renamed from: yj  reason: collision with root package name */
    public float f9466yj;

    public ggg(List<Element> list, boolean z) {
        pf pfVar = new pf((q) null);
        this.f9460i = pfVar;
        pfVar.u(z);
        this.f9462pf = z;
        this.f9461o = list;
    }

    public float ad() {
        return this.f9465uk;
    }

    public float de() {
        return this.f9463rg;
    }

    public int fe(q qVar, boolean z) throws DocumentException {
        this.f9460i.b(qVar);
        ArrayList arrayList = new ArrayList();
        List arrayList2 = z ? new ArrayList(this.f9461o) : this.f9461o;
        int i2 = 1;
        while (true) {
            if (arrayList2.isEmpty()) {
                break;
            } else if (arrayList2.get(0) instanceof PdfDiv) {
                PdfDiv pdfDiv = (PdfDiv) arrayList2.get(0);
                if (pdfDiv.rg() == PdfDiv.FloatType.LEFT || pdfDiv.rg() == PdfDiv.FloatType.RIGHT) {
                    arrayList.add(pdfDiv);
                    arrayList2.remove(0);
                } else {
                    if (!arrayList.isEmpty()) {
                        i2 = qw(arrayList, z);
                        if ((i2 & 1) == 0) {
                            break;
                        }
                    }
                    arrayList2.remove(0);
                    i2 = pdfDiv.uk(qVar, this.f9462pf, true, this.f9464th, this.f9457ad, this.f9466yj, this.f9463rg);
                    if (!z) {
                        qVar.K(pdfDiv);
                        i2 = pdfDiv.uk(qVar, this.f9462pf, z, this.f9464th, this.f9457ad, this.f9466yj, this.f9463rg);
                        qVar.eee(pdfDiv);
                    }
                    if (pdfDiv.ad() > this.f9465uk) {
                        this.f9465uk = pdfDiv.ad();
                    }
                    if ((i2 & 1) == 0) {
                        arrayList2.add(0, pdfDiv);
                        this.f9463rg = pdfDiv.yj();
                        break;
                    }
                    this.f9463rg -= pdfDiv.qw();
                }
            } else {
                arrayList.add(arrayList2.get(0));
                arrayList2.remove(0);
            }
        }
        if ((i2 & 1) != 0 && !arrayList.isEmpty()) {
            i2 = qw(arrayList, z);
        }
        arrayList2.addAll(0, arrayList);
        return i2;
    }

    public final int qw(List<Element> list, boolean z) throws DocumentException {
        PdfDiv pdfDiv;
        List<Element> list2 = list;
        boolean z2 = z;
        float f = this.f9463rg;
        pf pfVar = this.f9460i;
        int i2 = 1;
        if (z2) {
            pfVar = pf.fe(pfVar);
        }
        float f2 = f;
        pf pfVar2 = pfVar;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (true) {
            if (list.isEmpty()) {
                break;
            }
            Element element = list2.get(0);
            list2.remove(0);
            if (element instanceof PdfDiv) {
                PdfDiv pdfDiv2 = (PdfDiv) element;
                int uk2 = pdfDiv2.uk(this.f9460i.i(), this.f9462pf, true, this.f9464th, this.f9457ad, this.f9466yj, this.f9463rg);
                if ((uk2 & 1) == 0) {
                    this.f9463rg = f2;
                    this.f9464th = this.f9458de;
                    this.f9466yj = this.f9459fe;
                    i2 = pdfDiv2.uk(this.f9460i.i(), this.f9462pf, true, this.f9464th, this.f9457ad, this.f9466yj, this.f9463rg);
                    if ((i2 & 1) == 0) {
                        list2.add(0, pdfDiv2);
                        break;
                    }
                    uk2 = i2;
                }
                if (pdfDiv2.rg() == PdfDiv.FloatType.LEFT) {
                    pdfDiv = pdfDiv2;
                    uk2 = pdfDiv2.uk(this.f9460i.i(), this.f9462pf, z, this.f9464th, this.f9457ad, this.f9466yj, this.f9463rg);
                    this.f9464th += pdfDiv.ad();
                    f3 += pdfDiv.ad();
                } else {
                    pdfDiv = pdfDiv2;
                    if (pdfDiv.rg() == PdfDiv.FloatType.RIGHT) {
                        uk2 = pdfDiv.uk(this.f9460i.i(), this.f9462pf, z, (this.f9466yj - pdfDiv.ad()) - 0.01f, this.f9457ad, this.f9466yj, this.f9463rg);
                        this.f9466yj -= pdfDiv.ad();
                        f4 += pdfDiv.ad();
                    }
                }
                f2 = Math.min(f2, this.f9463rg - pdfDiv.qw());
                i2 = uk2;
            } else {
                if (element instanceof Spaceable) {
                    this.f9463rg -= ((Spaceable) element).getSpacingBefore();
                }
                if (!z2) {
                    pfVar2.qw(element);
                } else if (element instanceof d1) {
                    pfVar2.qw(new d1((d1) element));
                } else {
                    pfVar2.qw(element);
                }
                float f5 = this.f9463rg;
                if (f5 > f2) {
                    pfVar2.n(this.f9464th, f5, this.f9466yj, f2);
                } else {
                    pfVar2.n(this.f9464th, f5, this.f9466yj, this.f9457ad);
                }
                pfVar2.e(0.0f);
                i2 = pfVar2.ddd(z2);
                if (this.f9463rg <= f2 || ((this.f9464th <= this.f9458de && this.f9466yj >= this.f9459fe) || (i2 & 1) != 0)) {
                    if (f4 > 0.0f) {
                        f4 += pfVar2.m1111if();
                    } else if (f3 > 0.0f) {
                        f3 += pfVar2.m1111if();
                    } else if (pfVar2.m1111if() > this.f9465uk) {
                        this.f9465uk = pfVar2.m1111if();
                    }
                    float min = Math.min(pfVar2.vvv() + pfVar2.pf(), f2);
                    this.f9463rg = pfVar2.vvv() + pfVar2.pf();
                    f2 = min;
                } else {
                    this.f9463rg = f2;
                    float f6 = this.f9458de;
                    this.f9464th = f6;
                    float f7 = this.f9459fe;
                    this.f9466yj = f7;
                    if (f3 == 0.0f || f4 == 0.0f) {
                        if (f3 > this.f9465uk) {
                            this.f9465uk = f3;
                        }
                        if (f4 > this.f9465uk) {
                            this.f9465uk = f4;
                        }
                    } else {
                        this.f9465uk = f7 - f6;
                    }
                    if (z2 && (element instanceof d1)) {
                        pfVar2.qw(new d1((d1) element));
                    }
                    pfVar2.n(this.f9464th, this.f9463rg, this.f9466yj, this.f9457ad);
                    i2 = pfVar2.ddd(z2);
                    float vvv = pfVar2.vvv() + pfVar2.pf();
                    this.f9463rg = vvv;
                    if (pfVar2.m1111if() > this.f9465uk) {
                        this.f9465uk = pfVar2.m1111if();
                    }
                    f2 = vvv;
                    f3 = 0.0f;
                    f4 = 0.0f;
                }
                if ((i2 & 1) != 0) {
                    pfVar2.t((Phrase) null);
                } else if (!z2) {
                    list2.addAll(0, pfVar2.o());
                    pfVar2.o().clear();
                } else {
                    list2.add(0, element);
                    pfVar2.t((Phrase) null);
                }
            }
        }
        if (f3 == 0.0f || f4 == 0.0f) {
            if (f3 > this.f9465uk) {
                this.f9465uk = f3;
            }
            if (f4 > this.f9465uk) {
                this.f9465uk = f4;
            }
        } else {
            this.f9465uk = this.f9459fe - this.f9458de;
        }
        this.f9463rg = f2;
        this.f9464th = this.f9458de;
        this.f9466yj = this.f9459fe;
        return i2;
    }

    public void rg(float f, float f2, float f3, float f4) {
        this.f9458de = Math.min(f, f3);
        this.qw = Math.max(f2, f4);
        this.f9457ad = Math.min(f2, f4);
        float max = Math.max(f, f3);
        this.f9459fe = max;
        this.f9464th = this.f9458de;
        this.f9466yj = max;
        this.f9463rg = this.qw;
        this.f9465uk = 0.0f;
    }
}
