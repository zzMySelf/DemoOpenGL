package fe.mmm.qw.j;

/* renamed from: fe.mmm.qw.j.if  reason: invalid class name */
public class Cif {
    public static boolean ad(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c < 'a' || c > 'z') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    public static int qw(String str) {
        if (str == null) {
            return -1;
        }
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (!ad(charAt) && Character.isLetter(charAt)) {
                i2 += 2;
            } else {
                i2++;
            }
        }
        return i2;
    }
}
