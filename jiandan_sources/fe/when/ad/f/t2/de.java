package fe.when.ad.f.t2;

import java.util.Comparator;

public class de implements Comparator<String> {
    /* renamed from: qw */
    public int compare(String str, String str2) {
        if (str2.length() > str.length()) {
            return 1;
        }
        if (str.length() > str2.length()) {
            return -1;
        }
        return str.compareTo(str2);
    }
}
