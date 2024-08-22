package rg.qw.vvv;

public class ad {
    public static String ad(String str) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    StringBuilder sb = new StringBuilder();
                    int i2 = 0;
                    char c = 0;
                    boolean z = false;
                    int i3 = 0;
                    while (i2 < str.length()) {
                        char charAt = str.charAt(i2);
                        if (charAt == '\"') {
                            if (c != '\\') {
                                z = !z;
                            }
                            sb.append(charAt);
                        } else if (charAt != ',') {
                            if (charAt != '[') {
                                if (charAt != ']') {
                                    if (charAt != '{') {
                                        if (charAt != '}') {
                                            sb.append(charAt);
                                        }
                                    }
                                }
                                if (!z) {
                                    sb.append(10);
                                    i3--;
                                    qw(sb, i3);
                                }
                                sb.append(charAt);
                            }
                            sb.append(charAt);
                            if (!z) {
                                sb.append(10);
                                i3++;
                                qw(sb, i3);
                            }
                        } else {
                            sb.append(charAt);
                            if (c != '\\' && !z) {
                                sb.append(10);
                                qw(sb, i3);
                            }
                        }
                        i2++;
                        c = charAt;
                    }
                    return sb.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static void qw(StringBuilder sb, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            try {
                sb.append(9);
                i3++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
