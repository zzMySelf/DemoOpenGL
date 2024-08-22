package fe.vvv.qw.p037if;

import androidx.annotation.NonNull;
import fe.vvv.qw.xxx.ad;

@Deprecated
/* renamed from: fe.vvv.qw.if.th  reason: invalid package */
public class th {
    public static byte[] qw(@NonNull byte[] bArr, @NonNull ad adVar, int i2) {
        byte[] bArr2 = bArr;
        int i3 = i2;
        if (i3 == 0) {
            return bArr2;
        }
        if (i3 % 90 != 0 || i3 < 0 || i3 > 270) {
            throw new IllegalArgumentException("0 <= rotation < 360, rotation % 90 == 0");
        }
        int rg2 = adVar.rg();
        int fe2 = adVar.fe();
        byte[] bArr3 = new byte[bArr2.length];
        int i4 = rg2 * fe2;
        boolean z = i3 % 180 != 0;
        boolean z2 = i3 % 270 != 0;
        boolean z3 = i3 >= 180;
        for (int i5 = 0; i5 < fe2; i5++) {
            for (int i6 = 0; i6 < rg2; i6++) {
                int i7 = (i5 * rg2) + i6;
                int i8 = ((i5 >> 1) * rg2) + i4 + (i6 & -2);
                int i9 = i8 + 1;
                int i10 = z ? fe2 : rg2;
                int i11 = z ? rg2 : fe2;
                int i12 = z ? i5 : i6;
                int i13 = z ? i6 : i5;
                if (z2) {
                    i12 = (i10 - i12) - 1;
                }
                if (z3) {
                    i13 = (i11 - i13) - 1;
                }
                int i14 = i4 + ((i13 >> 1) * i10) + (i12 & -2);
                bArr3[(i13 * i10) + i12] = (byte) (bArr2[i7] & 255);
                bArr3[i14] = (byte) (bArr2[i8] & 255);
                bArr3[i14 + 1] = (byte) (bArr2[i9] & 255);
            }
        }
        return bArr3;
    }
}
