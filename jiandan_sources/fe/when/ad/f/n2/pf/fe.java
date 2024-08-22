package fe.when.ad.f.n2.pf;

import com.itextpdf.text.ExceptionConverter;
import fe.when.ad.f.ad;
import fe.when.ad.th;
import fe.when.ad.yj;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class fe extends rg {

    /* renamed from: pf  reason: collision with root package name */
    public static final String[] f9590pf = {"Courier", "Courier-Bold", "Courier-Oblique", "Courier-BoldOblique", "Helvetica", "Helvetica-Bold", "Helvetica-Oblique", "Helvetica-BoldOblique", "Times-Roman", "Times-Bold", "Times-Italic", "Times-BoldItalic", "Symbol", "ZapfDingbats"};

    /* renamed from: ad  reason: collision with root package name */
    public int f9591ad;

    /* renamed from: de  reason: collision with root package name */
    public float f9592de;

    /* renamed from: fe  reason: collision with root package name */
    public int f9593fe;

    /* renamed from: i  reason: collision with root package name */
    public String f9594i = "arial";

    /* renamed from: o  reason: collision with root package name */
    public ad f9595o = null;

    /* renamed from: rg  reason: collision with root package name */
    public int f9596rg;

    /* renamed from: th  reason: collision with root package name */
    public boolean f9597th;

    /* renamed from: uk  reason: collision with root package name */
    public int f9598uk;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f9599yj;

    public fe() {
        this.qw = 3;
    }

    public float ad() {
        return this.f9592de;
    }

    public ad de() {
        String str;
        ad adVar = this.f9595o;
        if (adVar != null) {
            return adVar;
        }
        ad fe2 = yj.ad(this.f9594i, "Cp1252", true, 10.0f, (this.f9596rg != 0 ? 2 : 0) | (this.f9593fe != 0 ? 1 : 0)).fe();
        this.f9595o = fe2;
        if (fe2 != null) {
            return fe2;
        }
        if (this.f9594i.indexOf("courier") != -1 || this.f9594i.indexOf("terminal") != -1 || this.f9594i.indexOf("fixedsys") != -1) {
            str = f9590pf[this.f9596rg + 0 + this.f9593fe];
        } else if (this.f9594i.indexOf("ms sans serif") != -1 || this.f9594i.indexOf("arial") != -1 || this.f9594i.indexOf("system") != -1) {
            str = f9590pf[this.f9596rg + 4 + this.f9593fe];
        } else if (this.f9594i.indexOf("arial black") != -1) {
            str = f9590pf[this.f9596rg + 4 + 1];
        } else if (this.f9594i.indexOf("times") != -1 || this.f9594i.indexOf("ms serif") != -1 || this.f9594i.indexOf("roman") != -1) {
            str = f9590pf[this.f9596rg + 8 + this.f9593fe];
        } else if (this.f9594i.indexOf("symbol") != -1) {
            str = f9590pf[12];
        } else {
            int i2 = this.f9598uk;
            int i3 = i2 & 3;
            int i4 = (i2 >> 4) & 7;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        str = f9590pf[this.f9596rg + 0 + this.f9593fe];
                    } else if (!(i4 == 4 || i4 == 5)) {
                        if (i3 != 1) {
                            str = f9590pf[this.f9596rg + 4 + this.f9593fe];
                        } else {
                            str = f9590pf[this.f9596rg + 0 + this.f9593fe];
                        }
                    }
                }
                str = f9590pf[this.f9596rg + 4 + this.f9593fe];
            } else {
                str = f9590pf[this.f9596rg + 8 + this.f9593fe];
            }
        }
        try {
            ad fe3 = ad.fe(str, "Cp1252", false);
            this.f9595o = fe3;
            return fe3;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public float fe(yj yjVar) {
        return Math.abs(yjVar.h(this.f9591ad) - yjVar.h(0)) * th.aaa;
    }

    public void rg(qw qwVar) throws IOException {
        this.f9591ad = Math.abs(qwVar.rg());
        int i2 = 2;
        qwVar.yj(2);
        this.f9592de = (float) ((((double) qwVar.rg()) / 1800.0d) * 3.141592653589793d);
        qwVar.yj(2);
        boolean z = true;
        this.f9593fe = qwVar.rg() >= 600 ? 1 : 0;
        if (qwVar.ad() == 0) {
            i2 = 0;
        }
        this.f9596rg = i2;
        this.f9597th = qwVar.ad() != 0;
        if (qwVar.ad() == 0) {
            z = false;
        }
        this.f9599yj = z;
        qwVar.ad();
        qwVar.yj(3);
        this.f9598uk = qwVar.ad();
        byte[] bArr = new byte[32];
        int i3 = 0;
        while (i3 < 32) {
            int ad2 = qwVar.ad();
            if (ad2 != 0) {
                bArr[i3] = (byte) ad2;
                i3++;
            }
        }
        try {
            this.f9594i = new String(bArr, 0, i3, "Cp1252");
        } catch (UnsupportedEncodingException unused) {
            this.f9594i = new String(bArr, 0, i3);
        }
        this.f9594i = this.f9594i.toLowerCase();
    }

    public boolean th() {
        return this.f9599yj;
    }

    public boolean yj() {
        return this.f9597th;
    }
}
