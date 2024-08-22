package fe.when.ad.f;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.text.Typography;

public class w1 extends y0 {

    /* renamed from: i  reason: collision with root package name */
    public String f9832i = "PDF";

    /* renamed from: if  reason: not valid java name */
    public boolean f463if = false;

    /* renamed from: o  reason: collision with root package name */
    public int f9833o = 0;

    /* renamed from: pf  reason: collision with root package name */
    public int f9834pf = 0;

    /* renamed from: uk  reason: collision with root package name */
    public String f9835uk = "";

    public w1() {
        super(3);
    }

    public void aaa(m1 m1Var) {
        b0 pf2 = m1Var.pf();
        if (pf2 != null) {
            pf2.pf(this.f9833o, this.f9834pf);
            byte[] de2 = a0.de(this.f9835uk, (String) null);
            this.f9852ad = de2;
            byte[] fe2 = pf2.fe(de2);
            this.f9852ad = fe2;
            this.f9835uk = a0.fe(fe2, (String) null);
        }
    }

    public w1 eee(boolean z) {
        this.f463if = z;
        return this;
    }

    public void nn(c2 c2Var, OutputStream outputStream) throws IOException {
        c2.g(c2Var, 11, this);
        byte[] th2 = th();
        b0 y = c2Var != null ? c2Var.y() : null;
        if (y != null && !y.i()) {
            th2 = y.rg(th2);
        }
        if (this.f463if) {
            rg rgVar = new rg();
            rgVar.de(Typography.less);
            for (byte when : th2) {
                rgVar.when(when);
            }
            rgVar.de(Typography.greater);
            outputStream.write(rgVar.mmm());
            return;
        }
        outputStream.write(q.n(th2));
    }

    public boolean qqq() {
        return this.f463if;
    }

    public void rrr(int i2, int i3) {
        this.f9833o = i2;
        this.f9834pf = i3;
    }

    public byte[] th() {
        if (this.f9852ad == null) {
            String str = this.f9832i;
            if (str == null || !str.equals("UnicodeBig") || !a0.rg(this.f9835uk)) {
                this.f9852ad = a0.de(this.f9835uk, this.f9832i);
            } else {
                this.f9852ad = a0.de(this.f9835uk, "PDF");
            }
        }
        return this.f9852ad;
    }

    public String toString() {
        return this.f9835uk;
    }

    public String tt() {
        String str = this.f9832i;
        if (str != null && str.length() != 0) {
            return this.f9835uk;
        }
        th();
        byte[] bArr = this.f9852ad;
        if (bArr.length >= 2 && bArr[0] == -2 && bArr[1] == -1) {
            return a0.fe(bArr, "UnicodeBig");
        }
        return a0.fe(this.f9852ad, "PDF");
    }

    public w1(String str) {
        super(3);
        this.f9835uk = str;
    }

    public w1(String str, String str2) {
        super(3);
        this.f9835uk = str;
        this.f9832i = str2;
    }

    public w1(byte[] bArr) {
        super(3);
        this.f9835uk = a0.fe(bArr, (String) null);
        this.f9832i = "";
    }
}
