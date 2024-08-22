package fe.fe.pf.yj.fe.qw;

import com.baidu.helios.common.gene.interfaces.HeliosKey;
import java.math.BigInteger;

public class de implements HeliosKey {

    /* renamed from: ad  reason: collision with root package name */
    public BigInteger f2978ad;
    public BigInteger qw;

    public de(byte[] bArr, byte[] bArr2) {
        this.qw = new BigInteger(bArr);
        this.f2978ad = new BigInteger(bArr2);
    }

    public BigInteger ad() {
        return this.qw;
    }

    public BigInteger qw() {
        return this.f2978ad;
    }
}
