package fe.fe.pf.yj.fe.qw;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.HashMap;
import javax.crypto.BadPaddingException;

public final class fe {

    /* renamed from: ad  reason: collision with root package name */
    public final int f2979ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f2980de;
    public final int qw;

    static {
        Collections.synchronizedMap(new HashMap());
    }

    public fe(int i2, int i3) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.qw = i2;
        this.f2979ad = i3;
        if (i3 < 64) {
            throw new InvalidKeyException("Padded size must be at least 64");
        } else if (i2 == 1 || i2 == 2) {
            this.f2980de = i3 - 11;
        } else if (i2 == 3) {
            this.f2980de = i3;
        } else {
            throw new InvalidKeyException("Invalid padding: " + i2);
        }
    }

    public static fe qw(int i2, int i3) throws InvalidKeyException, InvalidAlgorithmParameterException {
        return new fe(i2, i3);
    }

    public int ad() {
        return this.f2980de;
    }

    public byte[] de(byte[] bArr) throws BadPaddingException {
        if (bArr.length == this.f2979ad) {
            int i2 = this.qw;
            if (i2 == 1 || i2 == 2) {
                return fe(bArr);
            }
            if (i2 == 3) {
                return bArr;
            }
            throw new AssertionError();
        }
        throw new BadPaddingException("Padded length must be " + this.f2979ad);
    }

    public final byte[] fe(byte[] bArr) throws BadPaddingException {
        if (bArr[0] == 0) {
            int i2 = 2;
            if (bArr[1] == this.qw) {
                while (true) {
                    int i3 = i2 + 1;
                    byte b = bArr[i2] & 255;
                    if (b == 0) {
                        int length = bArr.length - i3;
                        if (length <= this.f2980de) {
                            byte[] bArr2 = new byte[length];
                            System.arraycopy(bArr, bArr.length - length, bArr2, 0, length);
                            return bArr2;
                        }
                        throw new BadPaddingException("Padding string too short");
                    } else if (i3 == bArr.length) {
                        throw new BadPaddingException("Padding string not terminated");
                    } else if (this.qw != 1 || b == 255) {
                        i2 = i3;
                    } else {
                        throw new BadPaddingException("Padding byte not 0xff: " + b);
                    }
                }
            } else {
                throw new BadPaddingException("Blocktype mismatch: " + bArr[1]);
            }
        } else {
            throw new BadPaddingException("Data must start with zero");
        }
    }
}
