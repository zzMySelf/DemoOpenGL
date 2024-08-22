package fe.th.de;

import fe.th.de.rrr.fe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public final class pf {
    public final String[] qw;

    public static final class qw {
        public final List<String> qw = new ArrayList(20);

        public qw ad(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                de(str.substring(0, indexOf), str.substring(indexOf + 1));
                return this;
            } else if (str.startsWith(":")) {
                de("", str.substring(1));
                return this;
            } else {
                de("", str);
                return this;
            }
        }

        public qw de(String str, String str2) {
            this.qw.add(str);
            this.qw.add(str2.trim());
            return this;
        }

        public qw fe(String str, String str2) {
            pf.qw(str);
            de(str, str2);
            return this;
        }

        public qw qw(String str, String str2) {
            pf.qw(str);
            pf.ad(str2, str);
            de(str, str2);
            return this;
        }

        public pf rg() {
            return new pf(this);
        }

        public String th(String str) {
            for (int size = this.qw.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.qw.get(size))) {
                    return this.qw.get(size + 1);
                }
            }
            return null;
        }

        public qw uk(String str, String str2) {
            pf.qw(str);
            pf.ad(str2, str);
            yj(str);
            de(str, str2);
            return this;
        }

        public qw yj(String str) {
            int i2 = 0;
            while (i2 < this.qw.size()) {
                if (str.equalsIgnoreCase(this.qw.get(i2))) {
                    this.qw.remove(i2);
                    this.qw.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }
    }

    public pf(qw qwVar) {
        List<String> list = qwVar.qw;
        this.qw = (String[]) list.toArray(new String[list.size()]);
    }

    public static void ad(String str, String str2) {
        if (str != null) {
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    i2++;
                } else {
                    throw new IllegalArgumentException(fe.xxx("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str2, str));
                }
            }
            return;
        }
        throw new NullPointerException("value for name " + str2 + " == null");
    }

    public static String fe(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static void qw(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (!str.isEmpty()) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(fe.xxx("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str));
                }
            }
        } else {
            throw new IllegalArgumentException("name is empty");
        }
    }

    public String de(String str) {
        return fe(this.qw, str);
    }

    public boolean equals(Object obj) {
        return (obj instanceof pf) && Arrays.equals(((pf) obj).qw, this.qw);
    }

    public int hashCode() {
        return Arrays.hashCode(this.qw);
    }

    public List<String> i(String str) {
        int yj2 = yj();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < yj2; i2++) {
            if (str.equalsIgnoreCase(rg(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(uk(i2));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String rg(int i2) {
        return this.qw[i2 * 2];
    }

    public qw th() {
        qw qwVar = new qw();
        Collections.addAll(qwVar.qw, this.qw);
        return qwVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int yj2 = yj();
        for (int i2 = 0; i2 < yj2; i2++) {
            sb.append(rg(i2));
            sb.append(": ");
            sb.append(uk(i2));
            sb.append(StringUtils.LF);
        }
        return sb.toString();
    }

    public String uk(int i2) {
        return this.qw[(i2 * 2) + 1];
    }

    public int yj() {
        return this.qw.length / 2;
    }
}
