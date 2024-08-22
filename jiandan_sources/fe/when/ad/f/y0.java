package fe.when.ad.f;

import java.io.IOException;
import java.io.OutputStream;

public abstract class y0 {

    /* renamed from: ad  reason: collision with root package name */
    public byte[] f9852ad;

    /* renamed from: th  reason: collision with root package name */
    public int f9853th;

    /* renamed from: yj  reason: collision with root package name */
    public c f9854yj;

    public y0(int i2) {
        this.f9853th = i2;
    }

    public void ddd(c cVar) {
        this.f9854yj = cVar;
    }

    public boolean ggg() {
        return this.f9853th == 7;
    }

    public boolean i() {
        return this.f9853th == 5;
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m1124if() {
        return this.f9853th == 10;
    }

    public int mmm() {
        return this.f9853th;
    }

    public void nn(c2 c2Var, OutputStream outputStream) throws IOException {
        if (this.f9852ad != null) {
            c2.g(c2Var, 11, this);
            outputStream.write(this.f9852ad);
        }
    }

    public boolean o() {
        return this.f9853th == 1;
    }

    public boolean pf() {
        return this.f9853th == 6;
    }

    public boolean ppp() {
        return this.f9853th == 2;
    }

    public boolean rg() {
        switch (this.f9853th) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public boolean m1125switch() {
        return this.f9853th == 4;
    }

    public byte[] th() {
        return this.f9852ad;
    }

    public String toString() {
        byte[] bArr = this.f9852ad;
        if (bArr == null) {
            return super.toString();
        }
        return a0.fe(bArr, (String) null);
    }

    public c uk() {
        return this.f9854yj;
    }

    public boolean vvv() {
        return this.f9853th == 3;
    }

    public boolean when() {
        return this.f9853th == 8;
    }

    public void xxx(String str) {
        this.f9852ad = a0.de(str, (String) null);
    }

    public y0(int i2, String str) {
        this.f9853th = i2;
        this.f9852ad = a0.de(str, (String) null);
    }

    public y0(int i2, byte[] bArr) {
        this.f9852ad = bArr;
        this.f9853th = i2;
    }
}
