package fe.fe.pf.yj.fe.de;

import android.database.Cursor;
import java.io.Closeable;
import java.util.zip.ZipFile;

public class de {
    public static boolean ad(Closeable closeable) {
        if (closeable == null) {
            return false;
        }
        try {
            closeable.close();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean de(Closeable closeable) {
        if (closeable == null) {
            return false;
        }
        try {
            closeable.close();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean fe(ZipFile zipFile) {
        if (zipFile == null) {
            return false;
        }
        try {
            zipFile.close();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean qw(Cursor cursor) {
        if (cursor == null) {
            return false;
        }
        try {
            cursor.close();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
