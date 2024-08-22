package fe.mmm.qw.p024if.pf.rg;

import android.content.ContentValues;
import java.util.concurrent.ThreadPoolExecutor;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.if.pf.rg.when  reason: invalid package */
public final class when {
    @Nullable
    public static ThreadPoolExecutor qw;

    public static final void fe(ContentValues contentValues, String str, Object obj) {
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Byte) {
            contentValues.put(str, (Byte) obj);
        } else if (obj instanceof Short) {
            contentValues.put(str, (Short) obj);
        } else if (obj instanceof Integer) {
            contentValues.put(str, (Integer) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Float) {
            contentValues.put(str, (Float) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else if (obj instanceof Boolean) {
            contentValues.put(str, (Boolean) obj);
        } else if (obj instanceof byte[]) {
            contentValues.put(str, (byte[]) obj);
        }
    }
}
