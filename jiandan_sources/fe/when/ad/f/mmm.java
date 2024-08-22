package fe.when.ad.f;

import com.itextpdf.text.ExceptionConverter;
import fe.when.ad.c.qw;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class mmm {

    /* renamed from: de  reason: collision with root package name */
    public static HashMap<String, Integer> f9531de;

    /* renamed from: ad  reason: collision with root package name */
    public int f9532ad;
    public byte[] qw;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f9531de = hashMap;
        hashMap.put("XYZ ", 3);
        f9531de.put("Lab ", 3);
        f9531de.put("Luv ", 3);
        f9531de.put("YCbr", 3);
        f9531de.put("Yxy ", 3);
        f9531de.put("RGB ", 3);
        f9531de.put("GRAY", 1);
        f9531de.put("HSV ", 3);
        f9531de.put("HLS ", 3);
        f9531de.put("CMYK", 4);
        f9531de.put("CMY ", 3);
        f9531de.put("2CLR", 2);
        f9531de.put("3CLR", 3);
        f9531de.put("4CLR", 4);
        f9531de.put("5CLR", 5);
        f9531de.put("6CLR", 6);
        f9531de.put("7CLR", 7);
        f9531de.put("8CLR", 8);
        f9531de.put("9CLR", 9);
        f9531de.put("ACLR", 10);
        f9531de.put("BCLR", 11);
        f9531de.put("CCLR", 12);
        f9531de.put("DCLR", 13);
        f9531de.put("ECLR", 14);
        f9531de.put("FCLR", 15);
    }

    public static mmm ad(byte[] bArr) {
        int i2;
        try {
            Integer num = f9531de.get(new String(bArr, 16, 4, "US-ASCII"));
            if (num == null) {
                i2 = 0;
            } else {
                i2 = num.intValue();
            }
            return de(bArr, i2);
        } catch (UnsupportedEncodingException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static mmm de(byte[] bArr, int i2) {
        int i3 = 0;
        if (bArr.length >= 128 && bArr[36] == 97 && bArr[37] == 99 && bArr[38] == 115 && bArr[39] == 112) {
            try {
                mmm mmm = new mmm();
                mmm.qw = bArr;
                Integer num = f9531de.get(new String(bArr, 16, 4, "US-ASCII"));
                if (num != null) {
                    i3 = num.intValue();
                }
                mmm.f9532ad = i3;
                if (i3 == i2) {
                    return mmm;
                }
                throw new IllegalArgumentException("ICC profile contains " + i3 + " component(s), the image data contains " + i2 + " component(s)");
            } catch (UnsupportedEncodingException e) {
                throw new ExceptionConverter(e);
            }
        } else {
            throw new IllegalArgumentException(qw.ad("invalid.icc.profile", new Object[0]));
        }
    }

    public int fe() {
        return this.f9532ad;
    }

    public byte[] qw() {
        return this.qw;
    }
}
