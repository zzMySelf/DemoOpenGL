package fe.mmm.qw.mmm;

import android.database.Cursor;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.fp.Either;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ad {
    @NotNull
    public static final String qw(@NotNull Cursor cursor, @NotNull String str, @NotNull String str2) {
        Either either;
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        Intrinsics.checkNotNullParameter(str, "column");
        Intrinsics.checkNotNullParameter(str2, "defalut");
        int columnIndex = cursor.getColumnIndex(str);
        boolean z = columnIndex < 0;
        if (cursor.isClosed() || z) {
            return str2;
        }
        try {
            either = ExpectKt.success(cursor.getString(columnIndex));
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
        String str3 = (String) ExpectKt.successOrNull(either);
        return str3 == null ? str2 : str3;
    }
}
