package fe.fe.fe.qw;

import java.util.Arrays;

public class qw {
    public rg[] qw = {new th(8, 0), new yj(0, 1), new yj(1, 1), new th(7, 1)};

    public byte[] qw(byte[] bArr) {
        fe feVar = new fe();
        byte[] ad2 = ad.ad(bArr, bArr.length + ((this.qw.length + 1) * fe.f1883ad));
        ad.qw(ad2, feVar.ad(), bArr.length);
        int i2 = 0;
        while (true) {
            rg[] rgVarArr = this.qw;
            if (i2 >= rgVarArr.length) {
                return Arrays.copyOf(feVar.ad(), fe.f1883ad);
            }
            rg rgVar = rgVarArr[i2];
            i2++;
            int length = bArr.length + (fe.f1883ad * i2);
            feVar.qw(rgVar.ad(ad2, 0, length), rgVar.qw(), rgVar.de(), rgVar.fe());
            ad.qw(ad2, feVar.ad(), length);
        }
    }
}
