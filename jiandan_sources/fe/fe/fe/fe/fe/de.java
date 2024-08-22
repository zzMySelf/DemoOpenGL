package fe.fe.fe.fe.fe;

import com.baidu.cesium.c.d.d;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Locale;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public String f1838ad = "PKCS1Padding";

    /* renamed from: de  reason: collision with root package name */
    public rg f1839de;

    /* renamed from: fe  reason: collision with root package name */
    public byte[] f1840fe;
    public int qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f1841rg;

    /* renamed from: th  reason: collision with root package name */
    public d f1842th;

    /* renamed from: yj  reason: collision with root package name */
    public String f1843yj = "SHA-1";

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ad(int r8, com.baidu.cesium.c.d.d r9, java.security.SecureRandom r10, java.security.spec.AlgorithmParameterSpec r11) {
        /*
            r7 = this;
            r0 = 0
            r1 = 3
            r2 = 2
            r3 = 4
            r4 = 1
            if (r8 == r4) goto L_0x0027
            if (r8 == r2) goto L_0x0025
            if (r8 == r1) goto L_0x0027
            if (r8 != r3) goto L_0x000e
            goto L_0x0025
        L_0x000e:
            java.security.InvalidKeyException r9 = new java.security.InvalidKeyException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Unknown mode: "
            r10.append(r11)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        L_0x0025:
            r8 = 0
            goto L_0x0028
        L_0x0027:
            r8 = 1
        L_0x0028:
            boolean r5 = r9 instanceof com.baidu.cesium.c.d.d
            if (r5 == 0) goto L_0x00c4
            if (r8 == 0) goto L_0x0030
            r5 = 1
            goto L_0x0031
        L_0x0030:
            r5 = 4
        L_0x0031:
            r7.qw = r5
            r7.f1842th = r9
            java.math.BigInteger r9 = r9.a()
            int r9 = fe.fe.fe.fe.fe.ad.qw(r9)
            r7.f1841rg = r0
            java.lang.String r0 = r7.f1838ad
            java.lang.String r5 = "Parameters not supported"
            java.lang.String r6 = "NoPadding"
            if (r0 != r6) goto L_0x005a
            if (r11 != 0) goto L_0x0054
            fe.fe.fe.fe.fe.rg r8 = fe.fe.fe.fe.fe.rg.ad(r1, r9, r10)
            r7.f1839de = r8
            byte[] r8 = new byte[r9]
            r7.f1840fe = r8
            goto L_0x00bb
        L_0x0054:
            java.security.InvalidAlgorithmParameterException r8 = new java.security.InvalidAlgorithmParameterException
            r8.<init>(r5)
            throw r8
        L_0x005a:
            java.lang.String r6 = "PKCS1Padding"
            if (r0 != r6) goto L_0x0082
            if (r11 != 0) goto L_0x007c
            int r11 = r7.qw
            if (r11 > r2) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r2 = 1
        L_0x0066:
            fe.fe.fe.fe.fe.rg r10 = fe.fe.fe.fe.fe.rg.ad(r2, r9, r10)
            r7.f1839de = r10
            if (r8 == 0) goto L_0x0077
            int r8 = r10.qw()
            byte[] r8 = new byte[r8]
            r7.f1840fe = r8
            goto L_0x00bb
        L_0x0077:
            byte[] r8 = new byte[r9]
            r7.f1840fe = r8
            goto L_0x00bb
        L_0x007c:
            java.security.InvalidAlgorithmParameterException r8 = new java.security.InvalidAlgorithmParameterException
            r8.<init>(r5)
            throw r8
        L_0x0082:
            int r0 = r7.qw
            if (r0 == r1) goto L_0x00bc
            if (r0 == r3) goto L_0x00bc
            if (r11 == 0) goto L_0x0099
            boolean r0 = r11 instanceof javax.crypto.spec.OAEPParameterSpec
            if (r0 == 0) goto L_0x0091
            javax.crypto.spec.OAEPParameterSpec r11 = (javax.crypto.spec.OAEPParameterSpec) r11
            goto L_0x00a6
        L_0x0091:
            java.security.InvalidAlgorithmParameterException r8 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r9 = "Wrong Parameters for OAEP Padding"
            r8.<init>(r9)
            throw r8
        L_0x0099:
            javax.crypto.spec.OAEPParameterSpec r11 = new javax.crypto.spec.OAEPParameterSpec
            java.lang.String r0 = r7.f1843yj
            java.security.spec.MGF1ParameterSpec r1 = java.security.spec.MGF1ParameterSpec.SHA1
            javax.crypto.spec.PSource$PSpecified r2 = javax.crypto.spec.PSource.PSpecified.DEFAULT
            java.lang.String r4 = "MGF1"
            r11.<init>(r0, r4, r1, r2)
        L_0x00a6:
            fe.fe.fe.fe.fe.rg r10 = fe.fe.fe.fe.fe.rg.de(r3, r9, r10, r11)
            r7.f1839de = r10
            if (r8 == 0) goto L_0x00b7
            int r8 = r10.qw()
            byte[] r8 = new byte[r8]
            r7.f1840fe = r8
            goto L_0x00bb
        L_0x00b7:
            byte[] r8 = new byte[r9]
            r7.f1840fe = r8
        L_0x00bb:
            return
        L_0x00bc:
            java.security.InvalidKeyException r8 = new java.security.InvalidKeyException
            java.lang.String r9 = "OAEP cannot be used to sign or verify signatures"
            r8.<init>(r9)
            throw r8
        L_0x00c4:
            java.security.InvalidKeyException r8 = new java.security.InvalidKeyException
            java.lang.String r9 = "only support helios key"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.fe.fe.fe.de.ad(int, com.baidu.cesium.c.d.d, java.security.SecureRandom, java.security.spec.AlgorithmParameterSpec):void");
    }

    public final byte[] de() {
        int i2 = this.f1841rg;
        byte[] bArr = this.f1840fe;
        if (i2 <= bArr.length) {
            try {
                int i3 = this.qw;
                if (i3 == 1) {
                    byte[] rg2 = ad.rg(this.f1839de.yj(bArr, 0, i2), this.f1842th);
                    this.f1841rg = 0;
                    return rg2;
                } else if (i3 == 2) {
                    throw new UnsupportedOperationException("only verify supported");
                } else if (i3 == 3) {
                    throw new UnsupportedOperationException("only verify supported");
                } else if (i3 == 4) {
                    return this.f1839de.uk(ad.rg(ad.fe(bArr, 0, i2), this.f1842th));
                } else {
                    throw new AssertionError("Internal error");
                }
            } finally {
                this.f1841rg = 0;
            }
        } else {
            throw new IllegalBlockSizeException("Data must not be longer than " + this.f1840fe.length + " bytes");
        }
    }

    public byte[] fe(byte[] bArr, int i2, int i3) {
        th(bArr, i2, i3);
        return de();
    }

    public void qw(int i2, d dVar, SecureRandom secureRandom) {
        try {
            ad(i2, dVar, secureRandom, (AlgorithmParameterSpec) null);
        } catch (InvalidAlgorithmParameterException e) {
            InvalidKeyException invalidKeyException = new InvalidKeyException("Wrong parameters");
            invalidKeyException.initCause(e);
            throw invalidKeyException;
        }
    }

    public void rg(String str) {
        String str2 = "NoPadding";
        if (!str.equalsIgnoreCase(str2)) {
            str2 = "PKCS1Padding";
            if (!str.equalsIgnoreCase(str2)) {
                String lowerCase = str.toLowerCase(Locale.ENGLISH);
                if (lowerCase.equals("oaeppadding")) {
                    this.f1838ad = "OAEP";
                    return;
                } else if (!lowerCase.startsWith("oaepwith") || !lowerCase.endsWith("andmgf1padding")) {
                    throw new NoSuchPaddingException("Padding " + str + " not supported");
                } else {
                    this.f1838ad = "OAEP";
                    this.f1843yj = str.substring(8, str.length() - 14);
                    throw new NoSuchPaddingException("MessageDigest not available for " + str);
                }
            }
        }
        this.f1838ad = str2;
    }

    public final void th(byte[] bArr, int i2, int i3) {
        int i4;
        if (i3 != 0 && bArr != null) {
            int i5 = this.f1841rg;
            int i6 = i5 + i3;
            byte[] bArr2 = this.f1840fe;
            if (i6 > bArr2.length) {
                i4 = bArr2.length + 1;
            } else {
                System.arraycopy(bArr, i2, bArr2, i5, i3);
                i4 = this.f1841rg + i3;
            }
            this.f1841rg = i4;
        }
    }
}
