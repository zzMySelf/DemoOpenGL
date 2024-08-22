package fe.mmm.qw.d.fe;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class rg {
    public static String ad(Context context, String str, String str2) {
        String str3 = str2 + File.separator + str;
        try {
            InputStream open = context.getAssets().open("skin" + File.separator + str);
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str3);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.close();
            open.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str3;
    }

    public static String de(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            ad.qw("VersionInfo", "Exception" + e);
            return "";
        }
    }

    @RequiresApi(api = 8)
    public static String fe(Context context) {
        File externalCacheDir;
        if (!Environment.getExternalStorageState().equals("mounted") || (externalCacheDir = context.getExternalCacheDir()) == null || (!externalCacheDir.exists() && !externalCacheDir.mkdirs())) {
            return context.getCacheDir().getAbsolutePath();
        }
        return externalCacheDir.getAbsolutePath();
    }

    public static boolean qw(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        if (split.length < 3 || split2.length < 3) {
            return false;
        }
        int length = split.length > split2.length ? split.length : split2.length;
        int i2 = 0;
        while (i2 < length) {
            try {
                if (Integer.parseInt(split[i2]) > Integer.parseInt(split2[i2])) {
                    return true;
                }
                if (Integer.parseInt(split[i2]) < Integer.parseInt(split2[i2])) {
                    return false;
                }
                i2++;
            } catch (NumberFormatException unused) {
                ad.qw("SkinFileUtils", "Version name is error!");
                return false;
            }
        }
        if (split.length > split2.length) {
            return true;
        }
        return false;
    }

    public static String rg(Context context) {
        File file = new File(fe(context), "skin");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
