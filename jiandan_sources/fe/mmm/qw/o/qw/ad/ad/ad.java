package fe.mmm.qw.o.qw.ad.ad;

import android.content.Context;
import fe.mmm.qw.de.ad.qw.qw;
import java.io.File;
import java.util.Stack;

public final class ad {
    public static final String qw = (qw.ad().getFilesDir().getAbsolutePath() + "/office");

    public static boolean ad(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        Stack stack = new Stack();
        stack.push(file);
        while (stack.size() > 0) {
            try {
                File file2 = (File) stack.pop();
                if (file2 != null) {
                    if (file2.isDirectory()) {
                        File[] listFiles = file2.listFiles();
                        if (listFiles != null && listFiles.length > 0) {
                            stack.push(file2);
                            for (File push : listFiles) {
                                stack.push(push);
                            }
                        } else if (!file2.delete()) {
                            return false;
                        }
                    } else if (!file2.delete()) {
                        return false;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return true;
    }

    public static int de(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String fe(String str) {
        String str2 = qw + "/readerCache/" + str;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2;
    }

    public static void qw(String str) {
        ad(new File(fe(str)));
    }
}
