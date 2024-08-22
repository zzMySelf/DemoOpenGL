package fe.fe.o.th;

import com.baidu.apollon.heartbeat.a;
import com.baidu.idl.authority.AuthorityState;
import java.io.UnsupportedEncodingException;
import java.net.IDN;
import java.net.URLEncoder;
import java.util.Locale;

public class uk {
    public static final byte[] qw = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    public static int ad(String str, int i2, int i3) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int de(String str, int i2, int i3, char c) {
        while (i2 < i3) {
            if (str.charAt(i2) == c) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int fe(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static String i(int i2) {
        byte[] bArr;
        byte[] bArr2;
        if (i2 < 128) {
            bArr = new byte[]{(byte) i2};
        } else {
            if (i2 < 2048) {
                bArr2 = new byte[]{(byte) ((i2 >> 6) | 192), (byte) ((i2 & 63) | 128)};
            } else if (i2 < 65536) {
                if (i2 < 55296 || i2 > 57343) {
                    bArr2 = new byte[]{(byte) ((i2 >> 12) | 224), (byte) (((i2 >> 6) & 63) | 128), (byte) ((i2 & 63) | 128)};
                } else {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
                }
            } else if (i2 <= 1114111) {
                bArr2 = new byte[]{(byte) ((i2 >> 18) | AuthorityState.STATE_ERROR_NETWORK), (byte) (((i2 >> 12) & 63) | 128), (byte) (((i2 >> 6) & 63) | 128), (byte) ((i2 & 63) | 128)};
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
            }
            bArr = bArr2;
        }
        return new String(bArr);
    }

    public static boolean o(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static byte[] pf(int i2) {
        byte[] bArr;
        if (i2 < 128) {
            return new byte[]{(byte) i2};
        }
        if (i2 < 2048) {
            bArr = new byte[]{(byte) ((i2 >> 6) | 192), (byte) ((i2 & 63) | 128)};
        } else if (i2 < 65536) {
            if (i2 < 55296 || i2 > 57343) {
                bArr = new byte[]{(byte) ((i2 >> 12) | 224), (byte) (((i2 >> 6) & 63) | 128), (byte) ((i2 & 63) | 128)};
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
            }
        } else if (i2 <= 1114111) {
            bArr = new byte[]{(byte) ((i2 >> 18) | AuthorityState.STATE_ERROR_NETWORK), (byte) (((i2 >> 12) & 63) | 128), (byte) (((i2 >> 6) & 63) | 128), (byte) ((i2 & 63) | 128)};
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
        }
        return bArr;
    }

    public static int qw(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    public static String rg(int i2) {
        return new String(new byte[]{(byte) i2});
    }

    public static String th(long j) {
        if (j == 0) {
            return rg(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        byte[] bArr = new byte[numberOfTrailingZeros];
        for (int i2 = numberOfTrailingZeros - 1; i2 >= 0; i2--) {
            bArr[i2] = qw[(int) (15 & j)];
            j >>>= 4;
        }
        try {
            return URLEncoder.encode(new String(bArr), a.h);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int uk(String str, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            char charAt = str.charAt(i4);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i4 + 1;
            }
        }
        return i2;
    }

    public static String yj(String str) {
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (!lowerCase.isEmpty() && !o(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
