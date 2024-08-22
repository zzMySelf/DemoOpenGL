package fe.mmm.qw.j.vvv;

import android.text.TextUtils;
import com.alipay.sdk.m.n.a;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class qw {
    public static final String[] qw = {"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"};

    public static void ad(String str, ByteArrayOutputStream byteArrayOutputStream) {
        if (!TextUtils.isEmpty(str) && byteArrayOutputStream != null) {
            int length = str.length();
            int length2 = str.length() % 4;
            if (length2 > 0) {
                length2 = 4 - length2;
            }
            while (length2 > 0) {
                str = str + a.h;
                length2--;
            }
            int i2 = 0;
            while (true) {
                if (i2 < length && str.charAt(i2) <= ' ') {
                    i2++;
                } else if (i2 != length) {
                    int i3 = i2 + 2;
                    int i4 = i2 + 3;
                    int qw2 = (qw(str.charAt(i2), 0) << 18) + (qw(str.charAt(i2 + 1), 0) << 12) + (qw(str.charAt(i3), 0) << 6) + qw(str.charAt(i4), 0);
                    byteArrayOutputStream.write((qw2 >> 16) & 255);
                    if (str.charAt(i3) != '=') {
                        byteArrayOutputStream.write((qw2 >> 8) & 255);
                        if (str.charAt(i4) != '=') {
                            byteArrayOutputStream.write(qw2 & 255);
                            i2 += 4;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static byte[] de(String str) {
        byte[] bArr = null;
        if (str == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ad(str, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                fe.mmm.qw.i.qw.th("Base64Util", "", e);
            }
        } catch (Exception e2) {
            fe.mmm.qw.i.qw.th("Base64Util", "", e2);
            byteArrayOutputStream.close();
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e3) {
                fe.mmm.qw.i.qw.th("Base64Util", "", e3);
            }
            throw th2;
        }
        return bArr;
    }

    public static String fe(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return rg(str.getBytes());
    }

    public static int qw(char c, int i2) throws RuntimeException {
        if (i2 >= 0) {
            String[] strArr = qw;
            if (i2 < strArr.length) {
                char[] charArray = strArr[i2].toCharArray();
                if (c == '=') {
                    return 0;
                }
                for (int i3 = 0; i3 < 64; i3++) {
                    if (charArray[i3] == c) {
                        return i3;
                    }
                }
                throw new RuntimeException("unexpected code: " + c);
            }
        }
        throw new RuntimeException("unexpected key: " + i2);
    }

    public static String rg(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return th(bArr, 0, bArr.length, (StringBuffer) null, 0).toString();
    }

    public static StringBuffer th(byte[] bArr, int i2, int i3, StringBuffer stringBuffer, int i4) {
        char[] charArray = qw[i4].toCharArray();
        if (stringBuffer == null) {
            stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        }
        int i5 = i3 - 3;
        int i6 = i2;
        while (i6 <= i5) {
            byte b = ((bArr[i6] & 255) << Ascii.DLE) | ((bArr[i6 + 1] & 255) << 8) | (bArr[i6 + 2] & 255);
            stringBuffer.append(charArray[(b >> Ascii.DC2) & 63]);
            stringBuffer.append(charArray[(b >> 12) & 63]);
            stringBuffer.append(charArray[(b >> 6) & 63]);
            stringBuffer.append(charArray[b & 63]);
            i6 += 3;
        }
        int i7 = i2 + i3;
        if (i6 == i7 - 2) {
            int i8 = ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6] & 255) << Ascii.DLE);
            stringBuffer.append(charArray[(i8 >> 18) & 63]);
            stringBuffer.append(charArray[(i8 >> 12) & 63]);
            stringBuffer.append(charArray[(i8 >> 6) & 63]);
        } else if (i6 == i7 - 1) {
            int i9 = (bArr[i6] & 255) << Ascii.DLE;
            stringBuffer.append(charArray[(i9 >> 18) & 63]);
            stringBuffer.append(charArray[(i9 >> 12) & 63]);
        }
        return stringBuffer;
    }
}
