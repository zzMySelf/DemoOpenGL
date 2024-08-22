package fe.mmm.qw.yj;

import java.io.File;

public class i {
    public static String qw(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (!str.endsWith(File.separator)) {
            sb.append(File.separator);
        }
        sb.append(str2);
        return sb.toString();
    }
}
