package org.sqlite.database;

import java.io.File;
import org.sqlite.database.sqlite.SQLiteDatabase;
import org.sqlite.database.sqlite.SQLiteDatabaseConfiguration;

public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    public static final String TAG = "DefaultDatabaseErrorHandler";

    private void deleteDatabaseFile(String str) {
        if (!str.equalsIgnoreCase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH) && str.trim().length() != 0) {
            "deleting the database file: " + str;
            try {
                SQLiteDatabase.deleteDatabase(new File(str));
            } catch (Exception e) {
                "delete failed: " + e.getMessage();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r0 != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        r3 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (r3.hasNext() != false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        deleteDatabaseFile((java.lang.String) r3.next().second);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        deleteDatabaseFile(r3.getPath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0031 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f A[ExcHandler: all (r1v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r0 
      PHI: (r0v10 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r0v3 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:8:0x002a, B:11:0x0031, B:12:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:8:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCorruption(org.sqlite.database.sqlite.SQLiteDatabase r3) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Corruption reported by sqlite on database: "
            r0.append(r1)
            java.lang.String r1 = r3.getPath()
            r0.append(r1)
            r0.toString()
            boolean r0 = org.sqlite.database.sqlite.SQLiteDatabase.hasCodec()
            if (r0 == 0) goto L_0x001b
            return
        L_0x001b:
            boolean r0 = r3.isOpen()
            if (r0 != 0) goto L_0x0029
            java.lang.String r3 = r3.getPath()
            r2.deleteDatabaseFile(r3)
            return
        L_0x0029:
            r0 = 0
            java.util.List r0 = r3.getAttachedDbs()     // Catch:{ SQLiteException -> 0x0031, all -> 0x002f }
            goto L_0x0031
        L_0x002f:
            r1 = move-exception
            goto L_0x0035
        L_0x0031:
            r3.close()     // Catch:{ SQLiteException -> 0x0057, all -> 0x002f }
            goto L_0x0058
        L_0x0035:
            if (r0 == 0) goto L_0x004f
            java.util.Iterator r3 = r0.iterator()
        L_0x003b:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0056
            java.lang.Object r0 = r3.next()
            android.util.Pair r0 = (android.util.Pair) r0
            java.lang.Object r0 = r0.second
            java.lang.String r0 = (java.lang.String) r0
            r2.deleteDatabaseFile(r0)
            goto L_0x003b
        L_0x004f:
            java.lang.String r3 = r3.getPath()
            r2.deleteDatabaseFile(r3)
        L_0x0056:
            throw r1
        L_0x0057:
        L_0x0058:
            if (r0 == 0) goto L_0x0072
            java.util.Iterator r3 = r0.iterator()
        L_0x005e:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0079
            java.lang.Object r0 = r3.next()
            android.util.Pair r0 = (android.util.Pair) r0
            java.lang.Object r0 = r0.second
            java.lang.String r0 = (java.lang.String) r0
            r2.deleteDatabaseFile(r0)
            goto L_0x005e
        L_0x0072:
            java.lang.String r3 = r3.getPath()
            r2.deleteDatabaseFile(r3)
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.sqlite.database.DefaultDatabaseErrorHandler.onCorruption(org.sqlite.database.sqlite.SQLiteDatabase):void");
    }
}
