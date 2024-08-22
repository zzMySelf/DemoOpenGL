package fe.th.de.rrr.o;

import com.google.common.base.Ascii;
import fe.th.de.rrr.fe;
import java.io.IOException;
import okio.ByteString;

public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public static final String[] f5326ad = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: de  reason: collision with root package name */
    public static final String[] f5327de = new String[64];

    /* renamed from: fe  reason: collision with root package name */
    public static final String[] f5328fe = new String[256];
    public static final ByteString qw = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    static {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = f5328fe;
            if (i3 >= strArr.length) {
                break;
            }
            strArr[i3] = fe.xxx("%8s", Integer.toBinaryString(i3)).replace(Ascii.CASE_MASK, '0');
            i3++;
        }
        String[] strArr2 = f5327de;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i4 = 0; i4 < 1; i4++) {
            int i5 = iArr[i4];
            f5327de[i5 | 8] = f5327de[i5] + "|PADDED";
        }
        String[] strArr3 = f5327de;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i6 = 0; i6 < 3; i6++) {
            int i7 = iArr2[i6];
            for (int i8 = 0; i8 < 1; i8++) {
                int i9 = iArr[i8];
                String[] strArr4 = f5327de;
                int i10 = i9 | i7;
                strArr4[i10] = f5327de[i9] + '|' + f5327de[i7];
                f5327de[i10 | 8] = f5327de[i9] + '|' + f5327de[i7] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr5 = f5327de;
            if (i2 < strArr5.length) {
                if (strArr5[i2] == null) {
                    strArr5[i2] = f5328fe[i2];
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public static String ad(boolean z, int i2, int i3, byte b, byte b2) {
        String[] strArr = f5326ad;
        String xxx = b < strArr.length ? strArr[b] : fe.xxx("0x%02x", Byte.valueOf(b));
        String qw2 = qw(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = xxx;
        objArr[4] = qw2;
        return fe.xxx("%s 0x%08x %5d %-13s %s", objArr);
    }

    public static IllegalArgumentException de(String str, Object... objArr) {
        throw new IllegalArgumentException(fe.xxx(str, objArr));
    }

    public static IOException fe(String str, Object... objArr) throws IOException {
        throw new IOException(fe.xxx(str, objArr));
    }

    public static String qw(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (!(b == 2 || b == 3)) {
            if (b == 4 || b == 6) {
                if (b2 == 1) {
                    return "ACK";
                }
                return f5328fe[b2];
            } else if (!(b == 7 || b == 8)) {
                String[] strArr = f5327de;
                String str = b2 < strArr.length ? strArr[b2] : f5328fe[b2];
                if (b != 5 || (b2 & 4) == 0) {
                    return (b != 0 || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f5328fe[b2];
    }
}
