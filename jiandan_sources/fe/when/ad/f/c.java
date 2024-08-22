package fe.when.ad.f;

import java.io.IOException;
import java.io.OutputStream;

public class c extends l0 {

    /* renamed from: o  reason: collision with root package name */
    public m1 f9366o;

    public c(m1 m1Var, int i2, int i3) {
        this.f9853th = 10;
        this.f9523uk = i2;
        this.f9522i = i3;
        this.f9366o = m1Var;
    }

    public void nn(c2 c2Var, OutputStream outputStream) throws IOException {
        int E = c2Var.E(this.f9366o, this.f9523uk, this.f9522i);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(E);
        stringBuffer.append(" ");
        stringBuffer.append(this.f9366o.tt() ? this.f9522i : 0);
        stringBuffer.append(" R");
        outputStream.write(a0.de(stringBuffer.toString(), (String) null));
    }

    public m1 qqq() {
        return this.f9366o;
    }
}
