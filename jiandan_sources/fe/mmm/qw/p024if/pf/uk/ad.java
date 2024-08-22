package fe.mmm.qw.p024if.pf.uk;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* renamed from: fe.mmm.qw.if.pf.uk.ad  reason: invalid package */
public class ad {
    public static String qw;

    public static String ad(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir.exists()) {
            return filesDir.getParent();
        }
        return null;
    }

    public static String de(Context context, String str) {
        String str2;
        String str3 = "/BaiduNote" + File.separator + str;
        String rg2 = rg(context);
        if (rg2 != null) {
            str2 = rg2 + File.separator + str3;
        } else {
            str2 = ad(context);
            if (str2 != null) {
                str2 = str2 + File.separator + str3;
            }
        }
        if (str2 != null) {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return str2;
    }

    public static String fe(Context context) {
        File externalFilesDir;
        String str = qw;
        if (str != null) {
            return str;
        }
        if (!"mounted".equals(Environment.getExternalStorageState()) || (externalFilesDir = context.getExternalFilesDir((String) null)) == null || !externalFilesDir.exists()) {
            return null;
        }
        File file = new File(externalFilesDir.getAbsolutePath());
        if (file.exists() || file.mkdirs()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static String qw(Context context) {
        return de(context, "img");
    }

    public static String rg(Context context) {
        String fe2 = fe(context);
        return fe2 == null ? ad(context) : fe2;
    }
}
