package fe.fe.pf.yj.ad;

import java.util.Arrays;

public class qw {
    public fe[] qw = {new rg(8, 0), new th(0, 1), new th(1, 1), new rg(7, 1)};

    public byte[] qw(byte[] bArr) {
        de deVar = new de();
        byte[] ad2 = ad.ad(bArr, bArr.length + ((this.qw.length + 1) * de.f2952ad));
        ad.qw(ad2, deVar.ad(), bArr.length);
        int i2 = 0;
        while (true) {
            fe[] feVarArr = this.qw;
            if (i2 >= feVarArr.length) {
                return Arrays.copyOf(deVar.ad(), de.f2952ad);
            }
            fe feVar = feVarArr[i2];
            i2++;
            int length = bArr.length + (de.f2952ad * i2);
            deVar.qw(feVar.ad(ad2, 0, length), feVar.qw(), feVar.de(), feVar.fe());
            ad.qw(ad2, deVar.ad(), length);
        }
    }
}
