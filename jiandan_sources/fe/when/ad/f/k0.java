package fe.when.ad.f;

import fe.when.ad.rg;
import java.io.IOException;
import java.io.OutputStream;

public class k0 {

    /* renamed from: rg  reason: collision with root package name */
    public static final byte[] f9514rg = rg.rg(" obj\n");

    /* renamed from: th  reason: collision with root package name */
    public static final byte[] f9515th;

    /* renamed from: ad  reason: collision with root package name */
    public int f9516ad;

    /* renamed from: de  reason: collision with root package name */
    public y0 f9517de;

    /* renamed from: fe  reason: collision with root package name */
    public c2 f9518fe;
    public int qw;

    static {
        byte[] rg2 = rg.rg("\nendobj\n");
        f9515th = rg2;
        int length = f9514rg.length;
        int length2 = rg2.length;
    }

    public k0(int i2, y0 y0Var, c2 c2Var) {
        this(i2, 0, y0Var, c2Var);
    }

    public void ad(OutputStream outputStream) throws IOException {
        outputStream.write(rg.rg(String.valueOf(this.qw)));
        outputStream.write(32);
        outputStream.write(rg.rg(String.valueOf(this.f9516ad)));
        outputStream.write(f9514rg);
        this.f9517de.nn(this.f9518fe, outputStream);
        outputStream.write(f9515th);
    }

    public l0 qw() {
        return new l0(this.f9517de.mmm(), this.qw, this.f9516ad);
    }

    public k0(int i2, int i3, y0 y0Var, c2 c2Var) {
        this.f9516ad = 0;
        this.f9518fe = c2Var;
        this.qw = i2;
        this.f9516ad = i3;
        this.f9517de = y0Var;
        b0 y = c2Var != null ? c2Var.y() : null;
        if (y != null) {
            y.pf(i2, i3);
        }
    }
}
