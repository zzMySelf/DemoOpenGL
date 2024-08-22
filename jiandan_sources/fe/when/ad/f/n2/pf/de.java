package fe.when.ad.f.n2.pf;

import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.itextpdf.text.DocumentException;
import fe.when.ad.f.ad;
import fe.when.ad.f.n2.qw;
import fe.when.ad.f.q;
import fe.when.ad.i;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public qw f9583ad;

    /* renamed from: de  reason: collision with root package name */
    public int f9584de;

    /* renamed from: fe  reason: collision with root package name */
    public int f9585fe;
    public q qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f9586rg;

    /* renamed from: th  reason: collision with root package name */
    public int f9587th;

    /* renamed from: uk  reason: collision with root package name */
    public yj f9588uk = new yj();

    /* renamed from: yj  reason: collision with root package name */
    public int f9589yj;

    public de(InputStream inputStream, q qVar) {
        this.qw = qVar;
        this.f9583ad = new qw(inputStream);
    }

    public static float qw(float f, float f2, float f3, float f4) {
        double atan2 = Math.atan2((double) (f4 - f2), (double) (f3 - f));
        if (atan2 < 0.0d) {
            atan2 += 6.283185307179586d;
        }
        return (float) ((atan2 / 3.141592653589793d) * 180.0d);
    }

    public boolean ad(boolean z) {
        th uk2 = this.f9588uk.uk();
        ad th2 = this.f9588uk.th();
        boolean z2 = true;
        boolean z3 = uk2.fe() == 5;
        int de2 = th2.de();
        boolean z4 = de2 == 0 || (de2 == 2 && this.f9588uk.fe() == 2);
        if (!z3 || z4) {
            z2 = false;
        }
        if (!z3) {
            if (z) {
                this.f9588uk.eee(this.qw);
            } else {
                this.f9588uk.qqq(this.qw);
            }
        }
        return z2;
    }

    public void de(int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str) {
        String str2 = str;
        fe yj2 = this.f9588uk.yj();
        float g = this.f9588uk.g(i2);
        float h = this.f9588uk.h(i3);
        double f = (double) this.f9588uk.f(yj2.ad());
        float sin = (float) Math.sin(f);
        float cos = (float) Math.cos(f);
        float fe2 = yj2.fe(this.f9588uk);
        ad de2 = yj2.de();
        int i9 = this.f9588uk.m1100switch();
        float eee = de2.eee(str2, fe2);
        float f2 = de2.m1066switch(3, fe2);
        float f3 = de2.m1066switch(8, fe2);
        this.qw.d0();
        this.qw.e(cos, sin, -sin, cos, g, h);
        float f4 = 0.0f;
        float f5 = (i9 & 6) == 6 ? (-eee) / 2.0f : (i9 & 2) == 2 ? -eee : 0.0f;
        if ((i9 & 24) != 24) {
            f4 = (i9 & 8) == 8 ? -f2 : -f3;
        }
        if (this.f9588uk.fe() == 2) {
            this.qw.h0(this.f9588uk.rg());
            this.qw.N(f5, f4 + f2, eee, f3 - f2);
            this.qw.p();
        }
        this.qw.h0(this.f9588uk.o());
        this.qw.vvv();
        this.qw.p0(de2, fe2);
        this.qw.L0(f5, f4);
        this.qw.R0(str2);
        this.qw.j();
        if (yj2.yj()) {
            this.qw.N(f5, f4 - (fe2 / 4.0f), eee, fe2 / 15.0f);
            this.qw.p();
        }
        if (yj2.th()) {
            this.qw.N(f5, f4 + (fe2 / 3.0f), eee, fe2 / 15.0f);
            this.qw.p();
        }
        this.qw.Y();
    }

    public void fe() throws IOException, DocumentException {
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str2;
        int i7;
        int i8 = 0;
        if (this.f9583ad.fe() == -1698247209) {
            this.f9583ad.th();
            this.f9584de = this.f9583ad.rg();
            this.f9585fe = this.f9583ad.rg();
            this.f9586rg = this.f9583ad.rg();
            this.f9587th = this.f9583ad.rg();
            int th2 = this.f9583ad.th();
            this.f9589yj = th2;
            this.f9588uk.c((((float) (this.f9586rg - this.f9584de)) / ((float) th2)) * 72.0f);
            this.f9588uk.d((((float) (this.f9587th - this.f9585fe)) / ((float) this.f9589yj)) * 72.0f);
            this.f9588uk.tt(this.f9584de);
            this.f9588uk.a(this.f9585fe);
            this.f9588uk.mmm(this.f9586rg - this.f9584de);
            this.f9588uk.aaa(this.f9587th - this.f9585fe);
            this.f9583ad.fe();
            this.f9583ad.th();
            this.f9583ad.yj(18);
            this.qw.s0(1);
            this.qw.w0(1);
            while (true) {
                int qw2 = this.f9583ad.qw();
                int fe2 = this.f9583ad.fe();
                if (fe2 < 3) {
                    this.f9588uk.ad(this.qw);
                    return;
                }
                int th3 = this.f9583ad.th();
                switch (th3) {
                    case 30:
                        this.f9588uk.ppp(this.qw);
                        break;
                    case LightappBusinessClient.REQUEST_PERMISSION_UNIVERSAL_SET:
                    case 322:
                    case 1791:
                        this.f9588uk.qw(new rg());
                        break;
                    case PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD:
                        this.f9588uk.vvv(this.f9583ad.th());
                        break;
                    case 262:
                        this.f9588uk.b(this.f9583ad.th());
                        break;
                    case 295:
                        this.f9588uk.when(this.f9583ad.rg(), this.qw);
                        break;
                    case 301:
                        this.f9588uk.ggg(this.f9583ad.th(), this.qw);
                        break;
                    case 302:
                        this.f9588uk.e(this.f9583ad.th());
                        break;
                    case 496:
                        this.f9588uk.de(this.f9583ad.th());
                        break;
                    case 513:
                        this.f9588uk.xxx(this.f9583ad.de());
                        break;
                    case 521:
                        this.f9588uk.nn(this.f9583ad.de());
                        break;
                    case 523:
                        this.f9588uk.a(this.f9583ad.rg());
                        this.f9588uk.tt(this.f9583ad.rg());
                        break;
                    case PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD:
                        this.f9588uk.aaa(this.f9583ad.rg());
                        this.f9588uk.mmm(this.f9583ad.rg());
                        break;
                    case 531:
                        int rg2 = this.f9583ad.rg();
                        int rg3 = this.f9583ad.rg();
                        uk i9 = this.f9588uk.i();
                        this.qw.I(this.f9588uk.g(i9.qw), this.f9588uk.h(i9.f9604ad));
                        this.qw.G(this.f9588uk.g(rg3), this.f9588uk.h(rg2));
                        this.qw.V0();
                        this.f9588uk.ddd(new uk(rg3, rg2));
                        break;
                    case 532:
                        this.f9588uk.ddd(new uk(this.f9583ad.rg(), this.f9583ad.rg()));
                        break;
                    case 762:
                        th thVar = new th();
                        thVar.rg(this.f9583ad);
                        this.f9588uk.qw(thVar);
                        break;
                    case 763:
                        fe feVar = new fe();
                        feVar.rg(this.f9583ad);
                        this.f9588uk.qw(feVar);
                        break;
                    case 764:
                        ad adVar = new ad();
                        adVar.fe(this.f9583ad);
                        this.f9588uk.qw(adVar);
                        break;
                    case 804:
                        if (!ad(false)) {
                            int th4 = this.f9583ad.th();
                            int rg4 = this.f9583ad.rg();
                            int rg5 = this.f9583ad.rg();
                            this.qw.I(this.f9588uk.g(rg4), this.f9588uk.h(rg5));
                            for (int i10 = 1; i10 < th4; i10++) {
                                this.qw.G(this.f9588uk.g(this.f9583ad.rg()), this.f9588uk.h(this.f9583ad.rg()));
                            }
                            this.qw.G(this.f9588uk.g(rg4), this.f9588uk.h(rg5));
                            rg();
                            break;
                        } else {
                            break;
                        }
                    case 805:
                        this.f9588uk.qqq(this.qw);
                        int th5 = this.f9583ad.th();
                        this.qw.I(this.f9588uk.g(this.f9583ad.rg()), this.f9588uk.h(this.f9583ad.rg()));
                        for (int i11 = 1; i11 < th5; i11++) {
                            this.qw.G(this.f9588uk.g(this.f9583ad.rg()), this.f9588uk.h(this.f9583ad.rg()));
                        }
                        this.qw.V0();
                        break;
                    case 1046:
                        float h = this.f9588uk.h(this.f9583ad.rg());
                        float g = this.f9588uk.g(this.f9583ad.rg());
                        float h2 = this.f9588uk.h(this.f9583ad.rg());
                        float g2 = this.f9588uk.g(this.f9583ad.rg());
                        this.qw.N(g2, h, g - g2, h2 - h);
                        this.qw.k();
                        this.qw.J();
                        break;
                    case 1048:
                        if (!ad(this.f9588uk.pf())) {
                            int rg6 = this.f9583ad.rg();
                            int rg7 = this.f9583ad.rg();
                            int rg8 = this.f9583ad.rg();
                            int rg9 = this.f9583ad.rg();
                            this.qw.m1113if(this.f9588uk.g(rg9), this.f9588uk.h(rg6), this.f9588uk.g(rg7), this.f9588uk.h(rg8), 0.0f, 360.0f);
                            rg();
                            break;
                        } else {
                            break;
                        }
                    case 1051:
                        if (!ad(true)) {
                            float h3 = this.f9588uk.h(this.f9583ad.rg());
                            float g3 = this.f9588uk.g(this.f9583ad.rg());
                            float h4 = this.f9588uk.h(this.f9583ad.rg());
                            float g4 = this.f9588uk.g(this.f9583ad.rg());
                            this.qw.N(g4, h3, g3 - g4, h4 - h3);
                            rg();
                            break;
                        } else {
                            break;
                        }
                    case 1055:
                        fe.when.ad.de de2 = this.f9583ad.de();
                        int rg10 = this.f9583ad.rg();
                        int rg11 = this.f9583ad.rg();
                        this.qw.d0();
                        this.qw.h0(de2);
                        this.qw.N(this.f9588uk.g(rg11), this.f9588uk.h(rg10), 0.2f, 0.2f);
                        this.qw.p();
                        this.qw.Y();
                        break;
                    case 1313:
                        int th6 = this.f9583ad.th();
                        byte[] bArr = new byte[th6];
                        int i12 = 0;
                        while (i12 < th6) {
                            byte ad2 = (byte) this.f9583ad.ad();
                            if (ad2 != 0) {
                                bArr[i12] = ad2;
                                i12++;
                            }
                        }
                        try {
                            i2 = 0;
                            try {
                                str = new String(bArr, 0, i12, "Cp1252");
                            } catch (UnsupportedEncodingException unused) {
                            }
                        } catch (UnsupportedEncodingException unused2) {
                            i2 = 0;
                            str = new String(bArr, i2, i12);
                            this.f9583ad.yj(((th6 + 1) & 65534) - i12);
                            int rg12 = this.f9583ad.rg();
                            de(this.f9583ad.rg(), rg12, 0, 0, 0, 0, 0, str);
                            qw qwVar = this.f9583ad;
                            qwVar.yj((fe2 * 2) - (qwVar.qw() - qw2));
                            i8 = 0;
                        }
                        this.f9583ad.yj(((th6 + 1) & 65534) - i12);
                        int rg122 = this.f9583ad.rg();
                        de(this.f9583ad.rg(), rg122, 0, 0, 0, 0, 0, str);
                    case 1336:
                        if (!ad(false)) {
                            int th7 = this.f9583ad.th();
                            int[] iArr = new int[th7];
                            for (int i13 = 0; i13 < th7; i13++) {
                                iArr[i13] = this.f9583ad.th();
                            }
                            for (int i14 = 0; i14 < th7; i14++) {
                                int i15 = iArr[i14];
                                int rg13 = this.f9583ad.rg();
                                int rg14 = this.f9583ad.rg();
                                this.qw.I(this.f9588uk.g(rg13), this.f9588uk.h(rg14));
                                for (int i16 = 1; i16 < i15; i16++) {
                                    this.qw.G(this.f9588uk.g(this.f9583ad.rg()), this.f9588uk.h(this.f9583ad.rg()));
                                }
                                this.qw.G(this.f9588uk.g(rg13), this.f9588uk.h(rg14));
                            }
                            rg();
                            break;
                        } else {
                            break;
                        }
                    case 1564:
                        if (!ad(true)) {
                            float h5 = this.f9588uk.h(0) - this.f9588uk.h(this.f9583ad.rg());
                            float g5 = this.f9588uk.g(this.f9583ad.rg()) - this.f9588uk.g(0);
                            float h6 = this.f9588uk.h(this.f9583ad.rg());
                            float g6 = this.f9588uk.g(this.f9583ad.rg());
                            float h7 = this.f9588uk.h(this.f9583ad.rg());
                            float g7 = this.f9588uk.g(this.f9583ad.rg());
                            this.qw.Z(g7, h6, g6 - g7, h7 - h6, (h5 + g5) / 4.0f);
                            rg();
                            break;
                        } else {
                            break;
                        }
                    case 2071:
                        if (!ad(this.f9588uk.pf())) {
                            float h8 = this.f9588uk.h(this.f9583ad.rg());
                            float g8 = this.f9588uk.g(this.f9583ad.rg());
                            float h9 = this.f9588uk.h(this.f9583ad.rg());
                            float g9 = this.f9588uk.g(this.f9583ad.rg());
                            float h10 = this.f9588uk.h(this.f9583ad.rg());
                            float g10 = this.f9588uk.g(this.f9583ad.rg());
                            float h11 = this.f9588uk.h(this.f9583ad.rg());
                            float g11 = this.f9588uk.g(this.f9583ad.rg());
                            float f = (g10 + g11) / 2.0f;
                            float f2 = (h11 + h10) / 2.0f;
                            float qw3 = qw(f, f2, g9, h9);
                            float qw4 = qw(f, f2, g8, h8) - qw3;
                            if (qw4 <= 0.0f) {
                                qw4 += 360.0f;
                            }
                            this.qw.m1113if(g11, h10, g10, h11, qw3, qw4);
                            this.qw.V0();
                            break;
                        } else {
                            break;
                        }
                    case 2074:
                        if (!ad(this.f9588uk.pf())) {
                            float h12 = this.f9588uk.h(this.f9583ad.rg());
                            float g12 = this.f9588uk.g(this.f9583ad.rg());
                            float h13 = this.f9588uk.h(this.f9583ad.rg());
                            float g13 = this.f9588uk.g(this.f9583ad.rg());
                            float h14 = this.f9588uk.h(this.f9583ad.rg());
                            float g14 = this.f9588uk.g(this.f9583ad.rg());
                            float h15 = this.f9588uk.h(this.f9583ad.rg());
                            float g15 = this.f9588uk.g(this.f9583ad.rg());
                            float f3 = (g14 + g15) / 2.0f;
                            float f4 = (h15 + h14) / 2.0f;
                            float qw5 = qw(f3, f4, g13, h13);
                            float qw6 = qw(f3, f4, g12, h12) - qw5;
                            if (qw6 <= 0.0f) {
                                qw6 += 360.0f;
                            }
                            ArrayList<float[]> ddd = q.ddd(g15, h14, g14, h15, qw5, qw6);
                            if (!ddd.isEmpty()) {
                                float[] fArr = ddd.get(0);
                                this.qw.I(f3, f4);
                                this.qw.G(fArr[0], fArr[1]);
                                for (int i17 = 0; i17 < ddd.size(); i17++) {
                                    float[] fArr2 = ddd.get(i17);
                                    this.qw.f(fArr2[2], fArr2[3], fArr2[4], fArr2[5], fArr2[6], fArr2[7]);
                                }
                                this.qw.G(f3, f4);
                                rg();
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    case 2096:
                        if (!ad(this.f9588uk.pf())) {
                            float h16 = this.f9588uk.h(this.f9583ad.rg());
                            float g16 = this.f9588uk.g(this.f9583ad.rg());
                            float h17 = this.f9588uk.h(this.f9583ad.rg());
                            float g17 = this.f9588uk.g(this.f9583ad.rg());
                            float h18 = this.f9588uk.h(this.f9583ad.rg());
                            float g18 = this.f9588uk.g(this.f9583ad.rg());
                            float h19 = this.f9588uk.h(this.f9583ad.rg());
                            float g19 = this.f9588uk.g(this.f9583ad.rg());
                            float f5 = (g18 + g19) / 2.0f;
                            float f6 = (h19 + h18) / 2.0f;
                            float qw7 = qw(f5, f6, g17, h17);
                            float qw8 = qw(f5, f6, g16, h16) - qw7;
                            if (qw8 <= 0.0f) {
                                qw8 += 360.0f;
                            }
                            ArrayList<float[]> ddd2 = q.ddd(g19, h18, g18, h19, qw7, qw8);
                            if (!ddd2.isEmpty()) {
                                float[] fArr3 = ddd2.get(0);
                                float f7 = fArr3[0];
                                float f8 = fArr3[1];
                                this.qw.I(f7, f8);
                                for (int i18 = 0; i18 < ddd2.size(); i18++) {
                                    float[] fArr4 = ddd2.get(i18);
                                    this.qw.f(fArr4[2], fArr4[3], fArr4[4], fArr4[5], fArr4[6], fArr4[7]);
                                }
                                this.qw.G(f7, f8);
                                rg();
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    case 2610:
                        int rg15 = this.f9583ad.rg();
                        int rg16 = this.f9583ad.rg();
                        int th8 = this.f9583ad.th();
                        int th9 = this.f9583ad.th();
                        if ((th9 & 6) != 0) {
                            i6 = this.f9583ad.rg();
                            i5 = this.f9583ad.rg();
                            i4 = this.f9583ad.rg();
                            i3 = this.f9583ad.rg();
                        } else {
                            i6 = 0;
                            i5 = 0;
                            i4 = 0;
                            i3 = 0;
                        }
                        byte[] bArr2 = new byte[th8];
                        int i19 = 0;
                        while (i19 < th8) {
                            byte ad3 = (byte) this.f9583ad.ad();
                            if (ad3 != 0) {
                                bArr2[i19] = ad3;
                                i19++;
                            }
                        }
                        try {
                            i7 = 0;
                            try {
                                str2 = new String(bArr2, 0, i19, "Cp1252");
                            } catch (UnsupportedEncodingException unused3) {
                            }
                        } catch (UnsupportedEncodingException unused4) {
                            i7 = 0;
                            str2 = new String(bArr2, i7, i19);
                            de(rg16, rg15, th9, i6, i5, i4, i3, str2);
                            qw qwVar2 = this.f9583ad;
                            qwVar2.yj((fe2 * 2) - (qwVar2.qw() - qw2));
                            i8 = 0;
                        }
                        de(rg16, rg15, th9, i6, i5, i4, i3, str2);
                    case 2881:
                    case 3907:
                        this.f9583ad.fe();
                        if (th3 == 3907) {
                            this.f9583ad.th();
                        }
                        int rg17 = this.f9583ad.rg();
                        int rg18 = this.f9583ad.rg();
                        int rg19 = this.f9583ad.rg();
                        int rg20 = this.f9583ad.rg();
                        float h20 = this.f9588uk.h(this.f9583ad.rg()) - this.f9588uk.h(i8);
                        float g20 = this.f9588uk.g(this.f9583ad.rg()) - this.f9588uk.g(i8);
                        float h21 = this.f9588uk.h(this.f9583ad.rg());
                        float g21 = this.f9588uk.g(this.f9583ad.rg());
                        int qw9 = (fe2 * 2) - (this.f9583ad.qw() - qw2);
                        byte[] bArr3 = new byte[qw9];
                        for (int i20 = 0; i20 < qw9; i20++) {
                            bArr3[i20] = (byte) this.f9583ad.ad();
                        }
                        try {
                            i th10 = qw.th(new ByteArrayInputStream(bArr3), true, qw9);
                            this.qw.d0();
                            this.qw.N(g21, h21, g20, h20);
                            this.qw.qqq();
                            this.qw.J();
                            float f9 = (float) rg18;
                            float f10 = (float) rg17;
                            th10.q0((th10.rrr() * g20) / f9, ((-h20) * th10.ggg()) / f10);
                            th10.u0(g21 - ((g20 * ((float) rg20)) / f9), (h21 + ((h20 * ((float) rg19)) / f10)) - th10.S());
                            this.qw.th(th10);
                            this.qw.Y();
                            break;
                        } catch (Exception unused5) {
                            break;
                        }
                }
                qw qwVar22 = this.f9583ad;
                qwVar22.yj((fe2 * 2) - (qwVar22.qw() - qw2));
                i8 = 0;
            }
        } else {
            throw new DocumentException(fe.when.ad.c.qw.ad("not.a.placeable.windows.metafile", new Object[0]));
        }
    }

    public void rg() {
        th uk2 = this.f9588uk.uk();
        ad th2 = this.f9588uk.th();
        int fe2 = uk2.fe();
        int de2 = th2.de();
        if (fe2 == 5) {
            this.qw.tt();
            if (this.f9588uk.m1099if() == 1) {
                this.qw.l();
            } else {
                this.qw.p();
            }
        } else {
            if (!(de2 == 0 || (de2 == 2 && this.f9588uk.fe() == 2))) {
                this.qw.c();
            } else if (this.f9588uk.m1099if() == 1) {
                this.qw.a();
            } else {
                this.qw.b();
            }
        }
    }
}
