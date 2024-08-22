package fe.when.ad;

import com.itextpdf.text.pdf.PRTokeniser;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class a {
    public static int ad(char c, char c2) {
        return ((((c - 55296) * 1024) + c2) - 56320) + 65536;
    }

    public static int de(String str, int i2) {
        return ((((str.charAt(i2) - 55296) * 1024) + str.charAt(i2 + 1)) - 56320) + 65536;
    }

    public static int fe(char[] cArr, int i2) {
        return ((((cArr[i2] - 55296) * 1024) + cArr[i2 + 1]) - 56320) + 65536;
    }

    public static void i(InputStream inputStream, int i2) throws IOException {
        while (i2 > 0) {
            long j = (long) i2;
            long skip = inputStream.skip(j);
            if (skip > 0) {
                i2 = (int) (j - skip);
            } else {
                return;
            }
        }
    }

    public static URL o(String str) throws MalformedURLException {
        try {
            return new URL(str);
        } catch (Exception unused) {
            return new File(str).toURI().toURL();
        }
    }

    public static String pf(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        int i2 = 0;
        while (i2 < charArray.length) {
            char c = charArray[i2];
            if (c == '%') {
                int i3 = i2 + 2;
                if (i3 >= charArray.length) {
                    stringBuffer.append(c);
                } else {
                    int th2 = PRTokeniser.th(charArray[i2 + 1]);
                    int th3 = PRTokeniser.th(charArray[i3]);
                    if (th2 < 0 || th3 < 0) {
                        stringBuffer.append(c);
                    } else {
                        stringBuffer.append((char) ((th2 * 16) + th3));
                        i2 = i3;
                    }
                }
            } else {
                stringBuffer.append(c);
            }
            i2++;
        }
        return stringBuffer.toString();
    }

    public static Object[][] qw(Object[][] objArr, Object[] objArr2) {
        if (objArr == null) {
            return new Object[][]{objArr2};
        }
        Object[][] objArr3 = new Object[(objArr.length + 1)][];
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        objArr3[objArr.length] = objArr2;
        return objArr3;
    }

    public static boolean rg(char c) {
        return c >= 55296 && c <= 56319;
    }

    public static boolean th(char c) {
        return c >= 56320 && c <= 57343;
    }

    public static boolean uk(char[] cArr, int i2) {
        if (i2 < 0 || i2 > cArr.length - 2 || !rg(cArr[i2]) || !th(cArr[i2 + 1])) {
            return false;
        }
        return true;
    }

    public static boolean yj(String str, int i2) {
        if (i2 < 0 || i2 > str.length() - 2 || !rg(str.charAt(i2)) || !th(str.charAt(i2 + 1))) {
            return false;
        }
        return true;
    }
}
