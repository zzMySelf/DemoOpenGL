package fe.fe.mmm.u;

import android.database.Cursor;
import fe.fe.mmm.tt;
import java.io.Closeable;

public class qw {
    public static final boolean qw = tt.vvv();

    public static void ad(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                if (qw) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void qw(Cursor cursor) {
        if (cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception e) {
                if (qw) {
                    e.printStackTrace();
                }
            }
        }
    }
}
