package fe.fe.fe.fe.fe;

import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.MGF1ParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

public final class rg {

    /* renamed from: uk  reason: collision with root package name */
    public static final Map<String, byte[]> f1845uk = Collections.synchronizedMap(new HashMap());

    /* renamed from: ad  reason: collision with root package name */
    public final int f1846ad;

    /* renamed from: de  reason: collision with root package name */
    public SecureRandom f1847de;

    /* renamed from: fe  reason: collision with root package name */
    public final int f1848fe;
    public final int qw;

    /* renamed from: rg  reason: collision with root package name */
    public MessageDigest f1849rg;

    /* renamed from: th  reason: collision with root package name */
    public MessageDigest f1850th;

    /* renamed from: yj  reason: collision with root package name */
    public byte[] f1851yj;

    public rg(int i2, int i3, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) {
        String str;
        this.qw = i2;
        this.f1846ad = i3;
        this.f1847de = secureRandom;
        if (i3 >= 64) {
            if (i2 == 1 || i2 == 2) {
                i3 -= 11;
            } else if (i2 != 3) {
                if (i2 == 4) {
                    byte[] bArr = null;
                    String str2 = "SHA-1";
                    if (oAEPParameterSpec != null) {
                        try {
                            str2 = oAEPParameterSpec.getDigestAlgorithm();
                            String mGFAlgorithm = oAEPParameterSpec.getMGFAlgorithm();
                            if (mGFAlgorithm.equalsIgnoreCase("MGF1")) {
                                String digestAlgorithm = ((MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters()).getDigestAlgorithm();
                                PSource pSource = oAEPParameterSpec.getPSource();
                                String algorithm = pSource.getAlgorithm();
                                if (algorithm.equalsIgnoreCase("PSpecified")) {
                                    byte[] value = ((PSource.PSpecified) pSource).getValue();
                                    str = digestAlgorithm;
                                    bArr = value;
                                } else {
                                    throw new InvalidAlgorithmParameterException("Unsupported pSource algo: " + algorithm);
                                }
                            } else {
                                throw new InvalidAlgorithmParameterException("Unsupported MGF algo: " + mGFAlgorithm);
                            }
                        } catch (NoSuchAlgorithmException e) {
                            throw new InvalidKeyException("Digest " + str2 + " not available", e);
                        }
                    } else {
                        str = str2;
                    }
                    this.f1849rg = MessageDigest.getInstance(str2);
                    this.f1850th = MessageDigest.getInstance(str);
                    byte[] rg2 = rg(this.f1849rg, bArr);
                    this.f1851yj = rg2;
                    int length = (i3 - 2) - (rg2.length * 2);
                    this.f1848fe = length;
                    if (length <= 0) {
                        throw new InvalidKeyException("Key is too short for encryption using OAEPPadding with " + str2 + " and MGF1" + str);
                    }
                    return;
                }
                throw new InvalidKeyException("Invalid padding: " + i2);
            }
            this.f1848fe = i3;
            return;
        }
        throw new InvalidKeyException("Padded size must be at least 64");
    }

    public static rg ad(int i2, int i3, SecureRandom secureRandom) {
        return new rg(i2, i3, secureRandom, (OAEPParameterSpec) null);
    }

    public static rg de(int i2, int i3, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) {
        return new rg(i2, i3, secureRandom, oAEPParameterSpec);
    }

    public static byte[] rg(MessageDigest messageDigest, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return messageDigest.digest(bArr);
        }
        String algorithm = messageDigest.getAlgorithm();
        byte[] bArr2 = f1845uk.get(algorithm);
        if (bArr2 != null) {
            return bArr2;
        }
        byte[] digest = messageDigest.digest();
        f1845uk.put(algorithm, digest);
        return digest;
    }

    public final void fe(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] bArr3 = new byte[4];
        byte[] bArr4 = new byte[20];
        while (i5 > 0) {
            this.f1850th.update(bArr, i2, i3);
            this.f1850th.update(bArr3);
            try {
                this.f1850th.digest(bArr4, 0, 20);
                for (int i6 = 0; i6 < 20 && i5 > 0; i6++) {
                    bArr2[i4] = (byte) (bArr4[i6] ^ bArr2[i4]);
                    i5--;
                    i4++;
                }
                if (i5 > 0) {
                    int i7 = 3;
                    while (true) {
                        byte b = (byte) (bArr3[i7] + 1);
                        bArr3[i7] = b;
                        if (b != 0 || i7 <= 0) {
                            break;
                        }
                        i7--;
                    }
                }
            } catch (DigestException e) {
                throw new BadPaddingException(e.toString());
            }
        }
    }

    public final byte[] i(byte[] bArr) {
        int i2;
        byte b;
        int i3 = this.f1846ad;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, i3 - bArr.length, bArr.length);
        int length = (this.f1846ad - 3) - bArr.length;
        bArr2[0] = 0;
        int i4 = this.qw;
        bArr2[1] = (byte) i4;
        int i5 = -1;
        int i6 = 2;
        if (i4 != 1) {
            if (this.f1847de == null) {
                this.f1847de = ad.qw;
            }
            byte[] bArr3 = new byte[64];
            while (true) {
                int i7 = length - 1;
                if (length <= 0) {
                    break;
                }
                while (true) {
                    if (i5 < 0) {
                        this.f1847de.nextBytes(bArr3);
                        i5 = 63;
                    }
                    i2 = i5 - 1;
                    b = bArr3[i5] & 255;
                    if (b != 0) {
                        break;
                    }
                    i5 = i2;
                }
                bArr2[i6] = (byte) b;
                i5 = i2;
                length = i7;
                i6++;
            }
        } else {
            while (true) {
                int i8 = length - 1;
                if (length <= 0) {
                    break;
                }
                bArr2[i6] = -1;
                i6++;
                length = i8;
            }
        }
        return bArr2;
    }

    /* renamed from: if  reason: not valid java name */
    public final byte[] m105if(byte[] bArr) {
        int length = this.f1851yj.length;
        if (bArr[0] == 0) {
            int i2 = length + 1;
            int length2 = bArr.length - i2;
            byte[] bArr2 = bArr;
            byte[] bArr3 = bArr;
            fe(bArr2, i2, length2, bArr3, 1, length);
            fe(bArr2, 1, length, bArr3, i2, length2);
            int i3 = 0;
            while (i3 < length) {
                if (this.f1851yj[i3] == bArr[i2 + i3]) {
                    i3++;
                } else {
                    throw new BadPaddingException("lHash mismatch");
                }
            }
            int i4 = i2 + length;
            while (bArr[i4] == 0) {
                i4++;
                if (i4 >= bArr.length) {
                    throw new BadPaddingException("Padding string not terminated");
                }
            }
            int i5 = i4 + 1;
            if (bArr[i4] == 1) {
                int length3 = bArr.length - i5;
                byte[] bArr4 = new byte[length3];
                System.arraycopy(bArr, i5, bArr4, 0, length3);
                return bArr4;
            }
            throw new BadPaddingException("Padding string not terminated by 0x01 byte");
        }
        throw new BadPaddingException("Data must start with zero");
    }

    public final byte[] o(byte[] bArr) {
        if (bArr[0] == 0) {
            int i2 = 2;
            if (bArr[1] == this.qw) {
                while (true) {
                    int i3 = i2 + 1;
                    byte b = bArr[i2] & 255;
                    if (b == 0) {
                        int length = bArr.length - i3;
                        if (length <= this.f1848fe) {
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

    public final byte[] pf(byte[] bArr) {
        if (this.f1847de == null) {
            this.f1847de = ad.qw;
        }
        int length = this.f1851yj.length;
        byte[] bArr2 = new byte[length];
        this.f1847de.nextBytes(bArr2);
        int i2 = this.f1846ad;
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr2, 0, bArr3, 1, length);
        int i3 = length + 1;
        int i4 = i2 - i3;
        int length2 = this.f1846ad - bArr.length;
        System.arraycopy(this.f1851yj, 0, bArr3, i3, length);
        bArr3[length2 - 1] = 1;
        System.arraycopy(bArr, 0, bArr3, length2, bArr.length);
        byte[] bArr4 = bArr3;
        byte[] bArr5 = bArr3;
        fe(bArr4, 1, length, bArr5, i3, i4);
        fe(bArr4, i3, i4, bArr5, 1, length);
        return bArr3;
    }

    public int qw() {
        return this.f1848fe;
    }

    public byte[] th(byte[] bArr) {
        if (bArr.length <= this.f1848fe) {
            int i2 = this.qw;
            if (i2 == 1 || i2 == 2) {
                return i(bArr);
            }
            if (i2 == 3) {
                return bArr;
            }
            if (i2 == 4) {
                return pf(bArr);
            }
            throw new AssertionError();
        }
        throw new BadPaddingException("Data must be shorter than " + (this.f1848fe + 1) + " bytes");
    }

    public byte[] uk(byte[] bArr) {
        if (bArr.length == this.f1846ad) {
            int i2 = this.qw;
            if (i2 == 1 || i2 == 2) {
                return o(bArr);
            }
            if (i2 == 3) {
                return bArr;
            }
            if (i2 == 4) {
                return m105if(bArr);
            }
            throw new AssertionError();
        }
        throw new BadPaddingException("Padded length must be " + this.f1846ad);
    }

    public byte[] yj(byte[] bArr, int i2, int i3) {
        return th(ad.fe(bArr, i2, i3));
    }
}
