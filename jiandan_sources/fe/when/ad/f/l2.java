package fe.when.ad.f;

import com.itextpdf.text.DocumentException;
import fe.when.ad.f.ad;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class l2 {
    public c2 qw = null;

    public l2(c2 c2Var) {
        this.qw = c2Var;
    }

    public void qw(k2 k2Var, l0 l0Var, Object[] objArr, byte[] bArr) throws DocumentException, IOException {
        l0 l0Var2;
        byte[] bArr2;
        HashMap hashMap = objArr[0];
        k2Var.f(hashMap, true, k2Var.vvv);
        int[][] iArr = (int[][]) hashMap.values().toArray(new int[0][]);
        Arrays.sort(iArr, k2Var);
        if (k2Var.e) {
            byte[] z = k2Var.z();
            if (k2Var.vvv || k2Var.f9359ad != null) {
                yj yjVar = new yj(new e2(z), hashMap);
                z = yjVar.n(yjVar.yj()[0]);
            }
            l0Var2 = this.qw.eee(new ad.qw(z, "CIDFontType0C", k2Var.f402switch)).qw();
        } else {
            if (k2Var.vvv || k2Var.h != 0) {
                bArr2 = k2Var.u(new HashSet(hashMap.keySet()), true);
            } else {
                bArr2 = k2Var.q();
            }
            l0Var2 = this.qw.eee(new ad.qw(bArr2, new int[]{bArr2.length}, k2Var.f402switch)).qw();
        }
        String uk2 = k2Var.vvv ? ad.uk() : "";
        l0 l0Var3 = null;
        l0 qw2 = this.qw.eee(k2Var.J(this.qw.eee(k2Var.p(l0Var2, uk2, (l0) null)).qw(), uk2, iArr)).qw();
        v1 N = k2Var.N(iArr);
        if (N != null) {
            l0Var3 = this.qw.eee(N).qw();
        }
        this.qw.tt(k2Var.K(qw2, uk2, l0Var3), l0Var);
    }
}
