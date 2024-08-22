package fe.mmm.qw.j.vvv;

import android.text.TextUtils;
import com.tera.scan.keymaker.encode.KeyMaker;
import java.io.UnsupportedEncodingException;

public class fe {
    public static String qw = "";

    public static String ad() {
        if (TextUtils.isEmpty(qw)) {
            qw = KeyMaker.convertToRC4Key(System.currentTimeMillis(), 12306, "FF214M12NSSFD7J8G6SDS90SFAG", "LKM3636U098FUCJSDGST");
        }
        return qw;
    }

    public static byte[] de(String str, String str2, String str3) {
        byte[] bArr;
        try {
            bArr = str.getBytes(str3);
        } catch (UnsupportedEncodingException unused) {
            bArr = str.getBytes();
        }
        return fe(bArr, str2);
    }

    public static byte[] fe(byte[] bArr, String str) {
        int[] iArr = new int[256];
        byte[] bArr2 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = i2;
        }
        if (!TextUtils.isEmpty(str)) {
            for (short s = 0; s < 256; s = (short) (s + 1)) {
                bArr2[s] = (byte) str.charAt(s % str.length());
            }
        }
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            i3 = ((i3 + iArr[i4]) + bArr2[i4]) % 256;
            int i5 = iArr[i4];
            iArr[i4] = iArr[i3];
            iArr[i3] = i5;
        }
        byte[] bArr3 = new byte[bArr.length];
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < bArr.length; i8++) {
            i6 = (i6 + 1) % 256;
            i7 = (i7 + iArr[i6]) % 256;
            int i9 = iArr[i6];
            iArr[i6] = iArr[i7];
            iArr[i7] = i9;
            bArr3[i8] = (byte) (((char) iArr[(iArr[i6] + (iArr[i7] % 256)) % 256]) ^ bArr[i8]);
        }
        return bArr3;
    }

    public static byte[] qw(byte[] bArr) {
        return fe(bArr, ad());
    }

    public static byte[] rg(String str, String str2) {
        return de(str, ad(), str2);
    }
}
