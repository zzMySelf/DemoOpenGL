package fe.mmm.qw.j;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class rg {
    public static Context qw;

    public static File ad() {
        return Environment.getExternalStorageDirectory();
    }

    public static String de() {
        return Environment.getExternalStorageState();
    }

    public static void fe(Context context) {
        qw = context;
    }

    public static File qw() {
        return qw.getExternalFilesDir("");
    }
}
