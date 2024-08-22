package fe.when.ad.g;

public class qw {
    public static String ad(byte[] bArr) {
        byte b = bArr[0] & 255;
        byte b2 = bArr[1] & 255;
        if (b == 254 && b2 == 255) {
            return "UTF-16BE";
        }
        if (b == 255 && b2 == 254) {
            return "UTF-16LE";
        }
        byte b3 = bArr[2] & 255;
        if (b == 239 && b2 == 187 && b3 == 191) {
            return "UTF-8";
        }
        byte b4 = bArr[3] & 255;
        if (b == 0 && b2 == 0 && b3 == 0 && b4 == 60) {
            return "ISO-10646-UCS-4";
        }
        if (b == 60 && b2 == 0 && b3 == 0 && b4 == 0) {
            return "ISO-10646-UCS-4";
        }
        if (b == 0 && b2 == 0 && b3 == 60 && b4 == 0) {
            return "ISO-10646-UCS-4";
        }
        if (b == 0 && b2 == 60 && b3 == 0 && b4 == 0) {
            return "ISO-10646-UCS-4";
        }
        if (b == 0 && b2 == 60 && b3 == 0 && b4 == 63) {
            return "UTF-16BE";
        }
        if (b == 60 && b2 == 0 && b3 == 63 && b4 == 0) {
            return "UTF-16LE";
        }
        if (b == 76 && b2 == 111 && b3 == 167 && b4 == 148) {
            return "CP037";
        }
        return "UTF-8";
    }

    public static boolean de(int i2) {
        return i2 == 9 || i2 == 10 || i2 == 13 || (i2 >= 32 && i2 <= 55295) || ((i2 >= 57344 && i2 <= 65533) || (i2 >= 65536 && i2 <= 1114111));
    }

    public static String qw(String str, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : str.toCharArray()) {
            if (c == '\"') {
                stringBuffer.append("&quot;");
            } else if (c == '<') {
                stringBuffer.append("&lt;");
            } else if (c == '>') {
                stringBuffer.append("&gt;");
            } else if (c == '&') {
                stringBuffer.append("&amp;");
            } else if (c == '\'') {
                stringBuffer.append("&apos;");
            } else if (de(c)) {
                if (!z || c <= 127) {
                    stringBuffer.append((char) c);
                } else {
                    stringBuffer.append("&#");
                    stringBuffer.append(c);
                    stringBuffer.append(';');
                }
            }
        }
        return stringBuffer.toString();
    }
}
