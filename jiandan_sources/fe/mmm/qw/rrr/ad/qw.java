package fe.mmm.qw.rrr.ad;

import android.database.Cursor;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.fp.Either;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a A[Catch:{ all -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b A[Catch:{ all -> 0x003d }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Integer ad(@org.jetbrains.annotations.NotNull android.database.Cursor r2, @org.jetbrains.annotations.NotNull java.lang.Object r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "columnName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r3 = r3.toString()
            int r3 = r2.getColumnIndex(r3)
            r0 = 1
            r1 = 0
            if (r3 >= 0) goto L_0x0018
        L_0x0016:
            r2 = r1
            goto L_0x0038
        L_0x0018:
            java.lang.String r2 = r2.getString(r3)     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x0027
            int r3 = r2.length()     // Catch:{ all -> 0x003d }
            if (r3 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r3 = 0
            goto L_0x0028
        L_0x0027:
            r3 = 1
        L_0x0028:
            if (r3 == 0) goto L_0x002b
            goto L_0x0016
        L_0x002b:
            java.lang.String r3 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ all -> 0x003d }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x003d }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x003d }
        L_0x0038:
            com.mars.kotlin.extension.fp.Either$Right r2 = com.mars.kotlin.extension.ExpectKt.success(r2)     // Catch:{ all -> 0x003d }
            goto L_0x0045
        L_0x003d:
            r2 = move-exception
            com.mars.kotlin.extension.LoggerKt.e$default(r2, r1, r0, r1)
            com.mars.kotlin.extension.fp.Either$Left r2 = com.mars.kotlin.extension.ExpectKt.failure(r2)
        L_0x0045:
            java.lang.Object r2 = com.mars.kotlin.extension.ExpectKt.successOrNull(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.rrr.ad.qw.ad(android.database.Cursor, java.lang.Object):java.lang.Integer");
    }

    public static final long de(@NotNull Cursor cursor, @NotNull String str, long j) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        Intrinsics.checkNotNullParameter(str, "column");
        Long fe2 = fe(cursor, str);
        return fe2 != null ? fe2.longValue() : j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a A[Catch:{ all -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b A[Catch:{ all -> 0x003d }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Long fe(@org.jetbrains.annotations.NotNull android.database.Cursor r2, @org.jetbrains.annotations.NotNull java.lang.Object r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "columnName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r3 = r3.toString()
            int r3 = r2.getColumnIndex(r3)
            r0 = 1
            r1 = 0
            if (r3 >= 0) goto L_0x0018
        L_0x0016:
            r2 = r1
            goto L_0x0038
        L_0x0018:
            java.lang.String r2 = r2.getString(r3)     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x0027
            int r3 = r2.length()     // Catch:{ all -> 0x003d }
            if (r3 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r3 = 0
            goto L_0x0028
        L_0x0027:
            r3 = 1
        L_0x0028:
            if (r3 == 0) goto L_0x002b
            goto L_0x0016
        L_0x002b:
            java.lang.String r3 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ all -> 0x003d }
            long r2 = java.lang.Long.parseLong(r2)     // Catch:{ all -> 0x003d }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x003d }
        L_0x0038:
            com.mars.kotlin.extension.fp.Either$Right r2 = com.mars.kotlin.extension.ExpectKt.success(r2)     // Catch:{ all -> 0x003d }
            goto L_0x0045
        L_0x003d:
            r2 = move-exception
            com.mars.kotlin.extension.LoggerKt.e$default(r2, r1, r0, r1)
            com.mars.kotlin.extension.fp.Either$Left r2 = com.mars.kotlin.extension.ExpectKt.failure(r2)
        L_0x0045:
            java.lang.Object r2 = com.mars.kotlin.extension.ExpectKt.successOrNull(r2)
            java.lang.Long r2 = (java.lang.Long) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.rrr.ad.qw.fe(android.database.Cursor, java.lang.Object):java.lang.Long");
    }

    public static final int qw(@NotNull Cursor cursor, @NotNull Object obj, int i2) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        Intrinsics.checkNotNullParameter(obj, "columnName");
        Integer ad2 = ad(cursor, obj);
        return ad2 != null ? ad2.intValue() : i2;
    }

    @NotNull
    public static final String rg(@NotNull Cursor cursor, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        Intrinsics.checkNotNullParameter(str, "column");
        Intrinsics.checkNotNullParameter(str2, "defaultValue");
        String th2 = th(cursor, str);
        return th2 == null ? str2 : th2;
    }

    @Nullable
    public static final String th(@NotNull Cursor cursor, @NotNull Object obj) {
        Either either;
        String str;
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        Intrinsics.checkNotNullParameter(obj, "columnName");
        int columnIndex = cursor.getColumnIndex(obj.toString());
        if (columnIndex < 0) {
            str = null;
        } else {
            try {
                str = cursor.getString(columnIndex);
            } catch (Throwable th2) {
                LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
                either = ExpectKt.failure(th2);
            }
        }
        either = ExpectKt.success(str);
        return (String) ExpectKt.successOrNull(either);
    }
}
