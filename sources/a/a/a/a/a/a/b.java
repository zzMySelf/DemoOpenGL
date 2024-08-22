package a.a.a.a.a.a;

import com.baidu.searchbox.lockscreen.helper.SwipeGestureHelper;
import com.baidu.talos.core.archivers.tar.TarConstants;
import java.io.UnsupportedEncodingException;
import kotlin.UByte;
import okio.Utf8;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f1174a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, SwipeGestureHelper.BOTTOM_SWIPE, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, SwipeGestureHelper.LEFT_SWIPE, 109, 110, 111, 112, 113, SwipeGestureHelper.RIGHT_SWIPE, 115, SwipeGestureHelper.TOP_SWIPE, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 43, 47};

    public static String a(byte[] bArr, String str) throws UnsupportedEncodingException {
        int length = (bArr.length * 4) / 3;
        byte[] bArr2 = new byte[(length + (length / 76) + 3)];
        int length2 = bArr.length - (bArr.length % 3);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length2; i4 += 3) {
            int i5 = i2 + 1;
            byte[] bArr3 = f1174a;
            bArr2[i2] = bArr3[(bArr[i4] & UByte.MAX_VALUE) >> 2];
            int i6 = i5 + 1;
            int i7 = i4 + 1;
            bArr2[i5] = bArr3[((bArr[i4] & 3) << 4) | ((bArr[i7] & UByte.MAX_VALUE) >> 4)];
            int i8 = i6 + 1;
            int i9 = i4 + 2;
            bArr2[i6] = bArr3[((bArr[i7] & 15) << 2) | ((bArr[i9] & UByte.MAX_VALUE) >> 6)];
            i2 = i8 + 1;
            bArr2[i8] = bArr3[bArr[i9] & Utf8.REPLACEMENT_BYTE];
            if ((i2 - i3) % 76 == 0 && i2 != 0) {
                bArr2[i2] = 10;
                i3++;
                i2++;
            }
        }
        int length3 = bArr.length % 3;
        if (length3 == 1) {
            int i10 = i2 + 1;
            byte[] bArr4 = f1174a;
            bArr2[i2] = bArr4[(bArr[length2] & UByte.MAX_VALUE) >> 2];
            int i11 = i10 + 1;
            bArr2[i10] = bArr4[(bArr[length2] & 3) << 4];
            int i12 = i11 + 1;
            bArr2[i11] = 61;
            i2 = i12 + 1;
            bArr2[i12] = 61;
        } else if (length3 == 2) {
            int i13 = i2 + 1;
            byte[] bArr5 = f1174a;
            bArr2[i2] = bArr5[(bArr[length2] & UByte.MAX_VALUE) >> 2];
            int i14 = i13 + 1;
            int i15 = length2 + 1;
            bArr2[i13] = bArr5[((bArr[i15] & UByte.MAX_VALUE) >> 4) | ((bArr[length2] & 3) << 4)];
            int i16 = i14 + 1;
            bArr2[i14] = bArr5[(bArr[i15] & 15) << 2];
            i2 = i16 + 1;
            bArr2[i16] = 61;
        }
        return new String(bArr2, 0, i2, str);
    }

    public static byte[] a(byte[] bArr) {
        return a(bArr, bArr.length);
    }

    public static byte[] a(byte[] bArr, int i2) {
        byte b2;
        int i3;
        int i4 = (i2 / 4) * 3;
        if (i4 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i4];
        int i5 = i2;
        int i6 = 0;
        while (true) {
            byte b3 = bArr[i5 - 1];
            b2 = 10;
            if (!(b3 == 10 || b3 == 13 || b3 == 32 || b3 == 9)) {
                if (b3 != 61) {
                    break;
                }
                i6++;
            }
            i5--;
        }
        int i7 = 0;
        int i8 = 0;
        byte b4 = 0;
        int i9 = 0;
        while (i7 < i5) {
            byte b5 = bArr[i7];
            if (!(b5 == b2 || b5 == 13 || b5 == 32 || b5 == 9)) {
                if (b5 >= 65 && b5 <= 90) {
                    i3 = b5 - 65;
                } else if (b5 >= 97 && b5 <= 122) {
                    i3 = b5 - 71;
                } else if (b5 >= 48 && b5 <= 57) {
                    i3 = b5 + 4;
                } else if (b5 == 43) {
                    i3 = 62;
                } else if (b5 != 47) {
                    return null;
                } else {
                    i3 = 63;
                }
                b4 = ((byte) i3) | (b4 << 6);
                if (i9 % 4 == 3) {
                    int i10 = i8 + 1;
                    bArr2[i8] = (byte) ((16711680 & b4) >> 16);
                    int i11 = i10 + 1;
                    bArr2[i10] = (byte) ((65280 & b4) >> 8);
                    bArr2[i11] = (byte) (b4 & UByte.MAX_VALUE);
                    i8 = i11 + 1;
                }
                i9++;
            }
            i7++;
            b2 = 10;
        }
        if (i6 > 0) {
            int i12 = b4 << (i6 * 6);
            int i13 = i8 + 1;
            bArr2[i8] = (byte) ((i12 & 16711680) >> 16);
            if (i6 == 1) {
                i8 = i13 + 1;
                bArr2[i13] = (byte) ((i12 & 65280) >> 8);
            } else {
                i8 = i13;
            }
        }
        byte[] bArr3 = new byte[i8];
        System.arraycopy(bArr2, 0, bArr3, 0, i8);
        return bArr3;
    }
}
