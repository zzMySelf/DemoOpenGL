package fe.mmm.qw.j;

public class th {
    public static String qw(long j) {
        if (j > ((long) 1073741824)) {
            return String.format("%.2fGB", new Object[]{Float.valueOf(((float) j) / ((float) 1073741824))});
        } else if (j > ((long) 1048576)) {
            return String.format("%.2fMB", new Object[]{Float.valueOf(((float) j) / ((float) 1048576))});
        } else if ((100 * j) / ((long) 1024) > 0) {
            return String.format("%.2fKB", new Object[]{Float.valueOf(((float) j) / ((float) 1024))});
        } else {
            return String.format("%dB", new Object[]{Long.valueOf(j)});
        }
    }
}
