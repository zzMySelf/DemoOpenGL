package fe.fe.pf.yj.de;

import com.baidu.helios.common.gene.interfaces.HeliosKey;
import fe.fe.pf.yj.fe.qw.ad;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class qw {
    public ad qw;

    public static qw ad() throws NoSuchPaddingException {
        qw qwVar = new qw();
        ad adVar = new ad();
        qwVar.qw = adVar;
        adVar.fe(2);
        return qwVar;
    }

    public void de(int i2, HeliosKey heliosKey) throws InvalidKeyException {
        this.qw.de(i2, heliosKey);
    }

    public final byte[] qw(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException {
        if (bArr != null) {
            return this.qw.ad(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
