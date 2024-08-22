package fe.fe.pf.yj.fe.de;

import com.google.common.base.Ascii;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static final char[] f2971ad = "0123456789abcdef".toCharArray();

    /* renamed from: de  reason: collision with root package name */
    public static final byte[] f2972de = new byte[128];
    public static final char[] qw = "0123456789ABCDEF".toCharArray();

    static {
        for (int i2 = 0; i2 < 10; i2++) {
            byte[] bArr = f2972de;
            bArr[i2 + 48] = (byte) i2;
            byte b = (byte) (i2 + 10);
            bArr[i2 + 65] = b;
            bArr[i2 + 97] = b;
        }
    }

    public static String ad(byte[] bArr, boolean z) {
        return new String(qw(bArr, z));
    }

    public static char[] qw(byte[] bArr, boolean z) {
        char[] cArr = z ? qw : f2971ad;
        char[] cArr2 = new char[(bArr.length * 2)];
        int i2 = 0;
        for (byte b : bArr) {
            int i3 = i2 + 1;
            cArr2[i2] = cArr[(b & 240) >>> 4];
            i2 = i3 + 1;
            cArr2[i3] = cArr[b & Ascii.SI];
        }
        return cArr2;
    }
}
