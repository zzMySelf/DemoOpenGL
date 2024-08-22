package fe.mmm.qw.j.vvv;

public class ad {
    public static String ad(byte[] bArr, String str, boolean z) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    public static String de(byte[] bArr, boolean z) {
        return ad(bArr, "", z);
    }

    public static String qw(byte[] bArr) {
        return de(bArr, false);
    }
}
