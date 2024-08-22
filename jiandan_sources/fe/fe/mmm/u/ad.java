package fe.fe.mmm.u;

import fe.fe.mmm.tt;
import java.io.File;
import java.util.List;

public class ad {
    public static final boolean qw = tt.vvv();

    public static void ad(String str, List<String> list) {
        for (String file : list) {
            File file2 = new File(str, file);
            if (qw) {
                "deleteTimeoutFile file delete:" + file2.getAbsolutePath();
            }
            if (file2.exists() && file2.delete() && qw) {
                "deleteTimeoutFile success :" + file2.getAbsolutePath();
            }
        }
    }

    public static boolean qw(File file) {
        if (qw) {
            "delete file:" + file;
        }
        if (file == null) {
            return false;
        }
        boolean z = true;
        if (file.exists()) {
            if (file.isFile()) {
                return true & file.delete();
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File qw2 : listFiles) {
                        z &= qw(qw2);
                    }
                }
                return z & file.delete();
            } else if (!qw) {
                return true;
            } else {
                "a special file:" + file;
                return true;
            }
        } else if (!qw) {
            return true;
        } else {
            "not found the file to delete:" + file;
            return true;
        }
    }
}
