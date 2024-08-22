package fe.when.ad.f.q2.ad;

import fe.when.ad.f.v0;
import fe.when.ad.f.w1;
import fe.when.ad.f.y0;
import java.util.HashMap;

public class de extends qw {

    /* renamed from: fe  reason: collision with root package name */
    public HashMap<Integer, byte[]> f9723fe = new HashMap<>();

    /* renamed from: rg  reason: collision with root package name */
    public final byte[] f9724rg = new byte[0];

    /* renamed from: if  reason: not valid java name */
    public byte[] m1115if(int i2) {
        byte[] bArr = this.f9723fe.get(Integer.valueOf(i2));
        return bArr == null ? this.f9724rg : bArr;
    }

    public void qw(w1 w1Var, y0 y0Var) {
        if (y0Var instanceof v0) {
            this.f9723fe.put(Integer.valueOf(((v0) y0Var).eee()), qw.de(w1Var));
        }
    }
}
