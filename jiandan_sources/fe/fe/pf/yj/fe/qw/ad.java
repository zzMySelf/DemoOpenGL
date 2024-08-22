package fe.fe.pf.yj.fe.qw;

import com.baidu.helios.common.gene.interfaces.HeliosKey;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class ad {

    /* renamed from: ad  reason: collision with root package name */
    public int f2973ad = 2;

    /* renamed from: de  reason: collision with root package name */
    public fe f2974de;

    /* renamed from: fe  reason: collision with root package name */
    public byte[] f2975fe;
    public int qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f2976rg;

    /* renamed from: th  reason: collision with root package name */
    public HeliosKey f2977th;

    public byte[] ad(byte[] bArr, int i2, int i3) throws BadPaddingException, IllegalBlockSizeException {
        th(bArr, i2, i3);
        return qw();
    }

    public void de(int i2, HeliosKey heliosKey) throws InvalidKeyException {
        try {
            rg(i2, heliosKey, (AlgorithmParameterSpec) null);
        } catch (InvalidAlgorithmParameterException e) {
            InvalidKeyException invalidKeyException = new InvalidKeyException("Wrong parameters");
            invalidKeyException.initCause(e);
            throw invalidKeyException;
        }
    }

    public void fe(int i2) throws NoSuchPaddingException {
        if (i2 == 1) {
            this.f2973ad = 1;
        } else if (i2 == 2) {
            this.f2973ad = 2;
        } else {
            throw new NoSuchPaddingException("Padding " + i2 + " not supported");
        }
    }

    public final byte[] qw() throws BadPaddingException, IllegalBlockSizeException {
        int i2 = this.f2976rg;
        byte[] bArr = this.f2975fe;
        if (i2 <= bArr.length) {
            try {
                int i3 = this.qw;
                if (i3 == 1) {
                    throw new UnsupportedOperationException("only verify supported");
                } else if (i3 == 2) {
                    throw new UnsupportedOperationException("only verify supported");
                } else if (i3 == 3) {
                    throw new UnsupportedOperationException("only verify supported");
                } else if (i3 == 4) {
                    return this.f2974de.de(qw.rg(qw.qw(bArr, 0, i2), this.f2977th));
                } else {
                    throw new AssertionError("Internal error");
                }
            } finally {
                this.f2976rg = 0;
            }
        } else {
            throw new IllegalBlockSizeException("Data must not be longer than " + this.f2975fe.length + " bytes");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void rg(int r7, com.baidu.helios.common.gene.interfaces.HeliosKey r8, java.security.spec.AlgorithmParameterSpec r9) throws java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r6 = this;
            r0 = 0
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            if (r7 == r4) goto L_0x0027
            if (r7 == r3) goto L_0x0025
            if (r7 == r2) goto L_0x0027
            if (r7 != r1) goto L_0x000e
            goto L_0x0025
        L_0x000e:
            java.security.InvalidKeyException r8 = new java.security.InvalidKeyException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Unknown mode: "
            r9.append(r0)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r8.<init>(r7)
            throw r8
        L_0x0025:
            r7 = 0
            goto L_0x0028
        L_0x0027:
            r7 = 1
        L_0x0028:
            boolean r5 = r8 instanceof com.baidu.helios.common.gene.interfaces.HeliosKey
            if (r5 == 0) goto L_0x0084
            if (r7 == 0) goto L_0x002f
            r1 = 1
        L_0x002f:
            r6.qw = r1
            r6.f2977th = r8
            java.math.BigInteger r8 = r8.ad()
            int r8 = fe.fe.pf.yj.fe.qw.qw.de(r8)
            r6.f2976rg = r0
            int r0 = r6.f2973ad
            java.lang.String r1 = "Parameters not supported"
            if (r0 != r4) goto L_0x0056
            if (r9 != 0) goto L_0x0050
            fe.fe.pf.yj.fe.qw.fe r7 = fe.fe.pf.yj.fe.qw.fe.qw(r2, r8)
            r6.f2974de = r7
            byte[] r7 = new byte[r8]
            r6.f2975fe = r7
            goto L_0x0075
        L_0x0050:
            java.security.InvalidAlgorithmParameterException r7 = new java.security.InvalidAlgorithmParameterException
            r7.<init>(r1)
            throw r7
        L_0x0056:
            if (r0 != r3) goto L_0x007c
            if (r9 != 0) goto L_0x0076
            int r9 = r6.qw
            if (r9 > r3) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r3 = 1
        L_0x0060:
            fe.fe.pf.yj.fe.qw.fe r9 = fe.fe.pf.yj.fe.qw.fe.qw(r3, r8)
            r6.f2974de = r9
            if (r7 == 0) goto L_0x0071
            int r7 = r9.ad()
            byte[] r7 = new byte[r7]
            r6.f2975fe = r7
            goto L_0x0075
        L_0x0071:
            byte[] r7 = new byte[r8]
            r6.f2975fe = r7
        L_0x0075:
            return
        L_0x0076:
            java.security.InvalidAlgorithmParameterException r7 = new java.security.InvalidAlgorithmParameterException
            r7.<init>(r1)
            throw r7
        L_0x007c:
            java.security.InvalidKeyException r7 = new java.security.InvalidKeyException
            java.lang.String r8 = "PEAO not supported"
            r7.<init>(r8)
            throw r7
        L_0x0084:
            java.security.InvalidKeyException r7 = new java.security.InvalidKeyException
            java.lang.String r8 = "only support helios key"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.pf.yj.fe.qw.ad.rg(int, com.baidu.helios.common.gene.interfaces.HeliosKey, java.security.spec.AlgorithmParameterSpec):void");
    }

    public final void th(byte[] bArr, int i2, int i3) {
        if (i3 != 0 && bArr != null) {
            int i4 = this.f2976rg;
            int i5 = i4 + i3;
            byte[] bArr2 = this.f2975fe;
            if (i5 > bArr2.length) {
                this.f2976rg = bArr2.length + 1;
                return;
            }
            System.arraycopy(bArr, i2, bArr2, i4, i3);
            this.f2976rg += i3;
        }
    }
}
