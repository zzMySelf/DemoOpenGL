package org.sqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.OperationCanceledException;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.alipay.sdk.m.n.a;
import com.google.common.base.Ascii;
import com.google.zxing.common.StringUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.HashMap;
import java.util.Locale;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.sqlite.database.sqlite.SQLiteAbortException;
import org.sqlite.database.sqlite.SQLiteConstraintException;
import org.sqlite.database.sqlite.SQLiteDatabase;
import org.sqlite.database.sqlite.SQLiteDatabaseCorruptException;
import org.sqlite.database.sqlite.SQLiteDiskIOException;
import org.sqlite.database.sqlite.SQLiteException;
import org.sqlite.database.sqlite.SQLiteFullException;
import org.sqlite.database.sqlite.SQLiteProgram;
import org.sqlite.database.sqlite.SQLiteStatement;

public class DatabaseUtils {
    public static final boolean DEBUG = false;
    public static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final int STATEMENT_ABORT = 6;
    public static final int STATEMENT_ATTACH = 3;
    public static final int STATEMENT_BEGIN = 4;
    public static final int STATEMENT_COMMIT = 5;
    public static final int STATEMENT_DDL = 8;
    public static final int STATEMENT_OTHER = 99;
    public static final int STATEMENT_PRAGMA = 7;
    public static final int STATEMENT_SELECT = 1;
    public static final int STATEMENT_UNPREPARED = 9;
    public static final int STATEMENT_UPDATE = 2;
    public static final String TAG = "DatabaseUtils";
    public static Collator mColl = null;

    @Deprecated
    public static class InsertHelper {
        public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
        public HashMap<String, Integer> mColumns;
        public final SQLiteDatabase mDb;
        public String mInsertSQL = null;
        public SQLiteStatement mInsertStatement = null;
        public SQLiteStatement mPreparedStatement = null;
        public SQLiteStatement mReplaceStatement = null;
        public final String mTableName;

        public InsertHelper(SQLiteDatabase sQLiteDatabase, String str) {
            this.mDb = sQLiteDatabase;
            this.mTableName = str;
        }

        /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.String[]] */
        /* JADX WARNING: type inference failed for: r3v3, types: [android.database.Cursor] */
        /* JADX WARNING: type inference failed for: r3v5 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void buildSQL() throws org.sqlite.database.SQLException {
            /*
                r11 = this;
                java.lang.String r0 = "'"
                java.lang.String r1 = ")"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r3 = 128(0x80, float:1.794E-43)
                r2.<init>(r3)
                java.lang.String r4 = "INSERT INTO "
                r2.append(r4)
                java.lang.String r4 = r11.mTableName
                r2.append(r4)
                java.lang.String r4 = " ("
                r2.append(r4)
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>(r3)
                java.lang.String r3 = "VALUES ("
                r4.append(r3)
                r3 = 0
                org.sqlite.database.sqlite.SQLiteDatabase r5 = r11.mDb     // Catch:{ all -> 0x00ae }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
                r6.<init>()     // Catch:{ all -> 0x00ae }
                java.lang.String r7 = "PRAGMA table_info("
                r6.append(r7)     // Catch:{ all -> 0x00ae }
                java.lang.String r7 = r11.mTableName     // Catch:{ all -> 0x00ae }
                r6.append(r7)     // Catch:{ all -> 0x00ae }
                r6.append(r1)     // Catch:{ all -> 0x00ae }
                java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00ae }
                android.database.Cursor r3 = r5.rawQuery(r6, r3)     // Catch:{ all -> 0x00ae }
                java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x00ae }
                int r6 = r3.getCount()     // Catch:{ all -> 0x00ae }
                r5.<init>(r6)     // Catch:{ all -> 0x00ae }
                r11.mColumns = r5     // Catch:{ all -> 0x00ae }
                r5 = 1
                r6 = 1
            L_0x004e:
                boolean r7 = r3.moveToNext()     // Catch:{ all -> 0x00ae }
                if (r7 == 0) goto L_0x009f
                java.lang.String r7 = r3.getString(r5)     // Catch:{ all -> 0x00ae }
                r8 = 4
                java.lang.String r8 = r3.getString(r8)     // Catch:{ all -> 0x00ae }
                java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r11.mColumns     // Catch:{ all -> 0x00ae }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x00ae }
                r9.put(r7, r10)     // Catch:{ all -> 0x00ae }
                r2.append(r0)     // Catch:{ all -> 0x00ae }
                r2.append(r7)     // Catch:{ all -> 0x00ae }
                r2.append(r0)     // Catch:{ all -> 0x00ae }
                if (r8 != 0) goto L_0x0077
                java.lang.String r7 = "?"
                r4.append(r7)     // Catch:{ all -> 0x00ae }
                goto L_0x0082
            L_0x0077:
                java.lang.String r7 = "COALESCE(?, "
                r4.append(r7)     // Catch:{ all -> 0x00ae }
                r4.append(r8)     // Catch:{ all -> 0x00ae }
                r4.append(r1)     // Catch:{ all -> 0x00ae }
            L_0x0082:
                int r7 = r3.getCount()     // Catch:{ all -> 0x00ae }
                java.lang.String r8 = ", "
                if (r6 != r7) goto L_0x008d
                java.lang.String r7 = ") "
                goto L_0x008e
            L_0x008d:
                r7 = r8
            L_0x008e:
                r2.append(r7)     // Catch:{ all -> 0x00ae }
                int r7 = r3.getCount()     // Catch:{ all -> 0x00ae }
                if (r6 != r7) goto L_0x0099
                java.lang.String r8 = ");"
            L_0x0099:
                r4.append(r8)     // Catch:{ all -> 0x00ae }
                int r6 = r6 + 1
                goto L_0x004e
            L_0x009f:
                if (r3 == 0) goto L_0x00a4
                r3.close()
            L_0x00a4:
                r2.append(r4)
                java.lang.String r0 = r2.toString()
                r11.mInsertSQL = r0
                return
            L_0x00ae:
                r0 = move-exception
                if (r3 == 0) goto L_0x00b4
                r3.close()
            L_0x00b4:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.sqlite.database.DatabaseUtils.InsertHelper.buildSQL():void");
        }

        private SQLiteStatement getStatement(boolean z) throws SQLException {
            if (z) {
                if (this.mReplaceStatement == null) {
                    if (this.mInsertSQL == null) {
                        buildSQL();
                    }
                    this.mReplaceStatement = this.mDb.compileStatement("INSERT OR REPLACE" + this.mInsertSQL.substring(6));
                }
                return this.mReplaceStatement;
            }
            if (this.mInsertStatement == null) {
                if (this.mInsertSQL == null) {
                    buildSQL();
                }
                this.mInsertStatement = this.mDb.compileStatement(this.mInsertSQL);
            }
            return this.mInsertStatement;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            "Error inserting " + r4 + " into table  " + r3.mTableName;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x005d, code lost:
            r0 = r3.mDb;
            r0.endTransaction();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0064, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0065, code lost:
            r3.mDb.endTransaction();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x006a, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0043 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private long insertInternal(android.content.ContentValues r4, boolean r5) {
            /*
                r3 = this;
                org.sqlite.database.sqlite.SQLiteDatabase r0 = r3.mDb
                r0.beginTransactionNonExclusive()
                org.sqlite.database.sqlite.SQLiteStatement r5 = r3.getStatement(r5)     // Catch:{ SQLException -> 0x0043 }
                r5.clearBindings()     // Catch:{ SQLException -> 0x0043 }
                java.util.Set r0 = r4.valueSet()     // Catch:{ SQLException -> 0x0043 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ SQLException -> 0x0043 }
            L_0x0014:
                boolean r1 = r0.hasNext()     // Catch:{ SQLException -> 0x0043 }
                if (r1 == 0) goto L_0x0032
                java.lang.Object r1 = r0.next()     // Catch:{ SQLException -> 0x0043 }
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ SQLException -> 0x0043 }
                java.lang.Object r2 = r1.getKey()     // Catch:{ SQLException -> 0x0043 }
                java.lang.String r2 = (java.lang.String) r2     // Catch:{ SQLException -> 0x0043 }
                int r2 = r3.getColumnIndex(r2)     // Catch:{ SQLException -> 0x0043 }
                java.lang.Object r1 = r1.getValue()     // Catch:{ SQLException -> 0x0043 }
                org.sqlite.database.DatabaseUtils.bindObjectToProgram(r5, r2, r1)     // Catch:{ SQLException -> 0x0043 }
                goto L_0x0014
            L_0x0032:
                long r0 = r5.executeInsert()     // Catch:{ SQLException -> 0x0043 }
                org.sqlite.database.sqlite.SQLiteDatabase r5 = r3.mDb     // Catch:{ SQLException -> 0x0043 }
                r5.setTransactionSuccessful()     // Catch:{ SQLException -> 0x0043 }
                org.sqlite.database.sqlite.SQLiteDatabase r4 = r3.mDb
                r4.endTransaction()
                return r0
            L_0x0041:
                r4 = move-exception
                goto L_0x0065
            L_0x0043:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0041 }
                r5.<init>()     // Catch:{ all -> 0x0041 }
                java.lang.String r0 = "Error inserting "
                r5.append(r0)     // Catch:{ all -> 0x0041 }
                r5.append(r4)     // Catch:{ all -> 0x0041 }
                java.lang.String r4 = " into table  "
                r5.append(r4)     // Catch:{ all -> 0x0041 }
                java.lang.String r4 = r3.mTableName     // Catch:{ all -> 0x0041 }
                r5.append(r4)     // Catch:{ all -> 0x0041 }
                r5.toString()     // Catch:{ all -> 0x0041 }
                r4 = -1
                org.sqlite.database.sqlite.SQLiteDatabase r0 = r3.mDb
                r0.endTransaction()
                return r4
            L_0x0065:
                org.sqlite.database.sqlite.SQLiteDatabase r5 = r3.mDb
                r5.endTransaction()
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: org.sqlite.database.DatabaseUtils.InsertHelper.insertInternal(android.content.ContentValues, boolean):long");
        }

        public void bind(int i2, double d) {
            this.mPreparedStatement.bindDouble(i2, d);
        }

        public void bindNull(int i2) {
            this.mPreparedStatement.bindNull(i2);
        }

        public void close() {
            SQLiteStatement sQLiteStatement = this.mInsertStatement;
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
                this.mInsertStatement = null;
            }
            SQLiteStatement sQLiteStatement2 = this.mReplaceStatement;
            if (sQLiteStatement2 != null) {
                sQLiteStatement2.close();
                this.mReplaceStatement = null;
            }
            this.mInsertSQL = null;
            this.mColumns = null;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:8|9|10|11) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
            r4.mPreparedStatement = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
            r4.mPreparedStatement = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x000c, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            "Error executing InsertHelper with table " + r4.mTableName;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long execute() {
            /*
                r4 = this;
                org.sqlite.database.sqlite.SQLiteStatement r0 = r4.mPreparedStatement
                if (r0 == 0) goto L_0x0028
                r1 = 0
                long r2 = r0.executeInsert()     // Catch:{ SQLException -> 0x000e }
                r4.mPreparedStatement = r1
                return r2
            L_0x000c:
                r0 = move-exception
                goto L_0x0025
            L_0x000e:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x000c }
                r0.<init>()     // Catch:{ all -> 0x000c }
                java.lang.String r2 = "Error executing InsertHelper with table "
                r0.append(r2)     // Catch:{ all -> 0x000c }
                java.lang.String r2 = r4.mTableName     // Catch:{ all -> 0x000c }
                r0.append(r2)     // Catch:{ all -> 0x000c }
                r0.toString()     // Catch:{ all -> 0x000c }
                r2 = -1
                r4.mPreparedStatement = r1
                return r2
            L_0x0025:
                r4.mPreparedStatement = r1
                throw r0
            L_0x0028:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "you must prepare this inserter before calling execute"
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.sqlite.database.DatabaseUtils.InsertHelper.execute():long");
        }

        public int getColumnIndex(String str) {
            getStatement(false);
            Integer num = this.mColumns.get(str);
            if (num != null) {
                return num.intValue();
            }
            throw new IllegalArgumentException("column '" + str + "' is invalid");
        }

        public long insert(ContentValues contentValues) {
            return insertInternal(contentValues, false);
        }

        public void prepareForInsert() {
            SQLiteStatement statement = getStatement(false);
            this.mPreparedStatement = statement;
            statement.clearBindings();
        }

        public void prepareForReplace() {
            SQLiteStatement statement = getStatement(true);
            this.mPreparedStatement = statement;
            statement.clearBindings();
        }

        public long replace(ContentValues contentValues) {
            return insertInternal(contentValues, true);
        }

        public void bind(int i2, float f) {
            this.mPreparedStatement.bindDouble(i2, (double) f);
        }

        public void bind(int i2, long j) {
            this.mPreparedStatement.bindLong(i2, j);
        }

        public void bind(int i2, int i3) {
            this.mPreparedStatement.bindLong(i2, (long) i3);
        }

        public void bind(int i2, boolean z) {
            this.mPreparedStatement.bindLong(i2, z ? 1 : 0);
        }

        public void bind(int i2, byte[] bArr) {
            if (bArr == null) {
                this.mPreparedStatement.bindNull(i2);
            } else {
                this.mPreparedStatement.bindBlob(i2, bArr);
            }
        }

        public void bind(int i2, String str) {
            if (str == null) {
                this.mPreparedStatement.bindNull(i2);
            } else {
                this.mPreparedStatement.bindString(i2, str);
            }
        }
    }

    public static void appendEscapedSQLString(StringBuilder sb, String str) {
        sb.append(ExtendedMessageFormat.QUOTE);
        if (str.indexOf(39) != -1) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt == '\'') {
                    sb.append(ExtendedMessageFormat.QUOTE);
                }
                sb.append(charAt);
            }
        } else {
            sb.append(str);
        }
        sb.append(ExtendedMessageFormat.QUOTE);
    }

    public static String[] appendSelectionArgs(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length == 0) {
            return strArr2;
        }
        String[] strArr3 = new String[(strArr.length + strArr2.length)];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    public static final void appendValueToSql(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append("NULL");
        } else if (!(obj instanceof Boolean)) {
            appendEscapedSQLString(sb, obj.toString());
        } else if (((Boolean) obj).booleanValue()) {
            sb.append('1');
        } else {
            sb.append('0');
        }
    }

    public static void bindObjectToProgram(SQLiteProgram sQLiteProgram, int i2, Object obj) {
        if (obj == null) {
            sQLiteProgram.bindNull(i2);
        } else if ((obj instanceof Double) || (obj instanceof Float)) {
            sQLiteProgram.bindDouble(i2, ((Number) obj).doubleValue());
        } else if (obj instanceof Number) {
            sQLiteProgram.bindLong(i2, ((Number) obj).longValue());
        } else if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                sQLiteProgram.bindLong(i2, 1);
            } else {
                sQLiteProgram.bindLong(i2, 0);
            }
        } else if (obj instanceof byte[]) {
            sQLiteProgram.bindBlob(i2, (byte[]) obj);
        } else {
            sQLiteProgram.bindString(i2, obj.toString());
        }
    }

    public static ParcelFileDescriptor blobFileDescriptorForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            return blobFileDescriptorForQuery(compileStatement, strArr);
        } finally {
            compileStatement.close();
        }
    }

    public static String concatenateWhere(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return "(" + str + ") AND (" + str2 + ")";
    }

    public static void createDbFromSqlStatements(Context context, String str, int i2, String str2) {
        File databasePath = context.getDatabasePath(str);
        databasePath.getParentFile().mkdirs();
        SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(databasePath, (SQLiteDatabase.CursorFactory) null);
        for (String str3 : TextUtils.split(str2, ";\n")) {
            if (!TextUtils.isEmpty(str3)) {
                openOrCreateDatabase.execSQL(str3);
            }
        }
        openOrCreateDatabase.setVersion(i2);
        openOrCreateDatabase.close();
    }

    public static void cursorDoubleToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (!cursor.isNull(columnIndex)) {
            contentValues.put(str2, Double.valueOf(cursor.getDouble(columnIndex)));
        } else {
            contentValues.put(str2, (Double) null);
        }
    }

    public static void cursorDoubleToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, Double.valueOf(cursor.getDouble(columnIndex)));
        }
    }

    public static void cursorDoubleToCursorValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorDoubleToContentValues(cursor, str, contentValues, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0079, code lost:
        r6 = r6 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void cursorFillWindow(android.database.Cursor r5, int r6, android.database.CursorWindow r7) {
        /*
            if (r6 < 0) goto L_0x0084
            int r0 = r5.getCount()
            if (r6 < r0) goto L_0x000a
            goto L_0x0084
        L_0x000a:
            int r0 = r5.getPosition()
            int r1 = r5.getColumnCount()
            r7.clear()
            r7.setStartPosition(r6)
            r7.setNumColumns(r1)
            boolean r2 = r5.moveToPosition(r6)
            if (r2 == 0) goto L_0x0081
        L_0x0021:
            boolean r2 = r7.allocRow()
            if (r2 != 0) goto L_0x0028
            goto L_0x0081
        L_0x0028:
            r2 = 0
        L_0x0029:
            if (r2 >= r1) goto L_0x0079
            int r3 = r5.getType(r2)
            if (r3 == 0) goto L_0x006c
            r4 = 1
            if (r3 == r4) goto L_0x0063
            r4 = 2
            if (r3 == r4) goto L_0x005a
            r4 = 4
            if (r3 == r4) goto L_0x004a
            java.lang.String r3 = r5.getString(r2)
            if (r3 == 0) goto L_0x0045
            boolean r3 = r7.putString(r3, r6, r2)
            goto L_0x0070
        L_0x0045:
            boolean r3 = r7.putNull(r6, r2)
            goto L_0x0070
        L_0x004a:
            byte[] r3 = r5.getBlob(r2)
            if (r3 == 0) goto L_0x0055
            boolean r3 = r7.putBlob(r3, r6, r2)
            goto L_0x0070
        L_0x0055:
            boolean r3 = r7.putNull(r6, r2)
            goto L_0x0070
        L_0x005a:
            double r3 = r5.getDouble(r2)
            boolean r3 = r7.putDouble(r3, r6, r2)
            goto L_0x0070
        L_0x0063:
            long r3 = r5.getLong(r2)
            boolean r3 = r7.putLong(r3, r6, r2)
            goto L_0x0070
        L_0x006c:
            boolean r3 = r7.putNull(r6, r2)
        L_0x0070:
            if (r3 != 0) goto L_0x0076
            r7.freeLastRow()
            goto L_0x0081
        L_0x0076:
            int r2 = r2 + 1
            goto L_0x0029
        L_0x0079:
            int r6 = r6 + 1
            boolean r2 = r5.moveToNext()
            if (r2 != 0) goto L_0x0021
        L_0x0081:
            r5.moveToPosition(r0)
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.sqlite.database.DatabaseUtils.cursorFillWindow(android.database.Cursor, int, android.database.CursorWindow):void");
    }

    public static void cursorFloatToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, Float.valueOf(cursor.getFloat(columnIndex)));
        }
    }

    public static void cursorIntToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorIntToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorIntToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, Integer.valueOf(cursor.getInt(columnIndex)));
        }
    }

    public static void cursorLongToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorLongToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorLongToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, Long.valueOf(cursor.getLong(columnIndex)));
        }
    }

    public static int cursorPickFillWindowStartPosition(int i2, int i3) {
        return Math.max(i2 - (i3 / 3), 0);
    }

    public static void cursorRowToContentValues(Cursor cursor, ContentValues contentValues) {
        String[] columnNames = cursor.getColumnNames();
        int length = columnNames.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (cursor.getType(i2) == 4) {
                contentValues.put(columnNames[i2], cursor.getBlob(i2));
            } else {
                contentValues.put(columnNames[i2], cursor.getString(i2));
            }
        }
    }

    public static void cursorShortToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, Short.valueOf(cursor.getShort(columnIndex)));
        }
    }

    public static void cursorStringToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorStringToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorStringToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, cursor.getString(columnIndex));
        }
    }

    public static void cursorStringToInsertHelper(Cursor cursor, String str, InsertHelper insertHelper, int i2) {
        insertHelper.bind(i2, cursor.getString(cursor.getColumnIndexOrThrow(str)));
    }

    public static void dumpCurrentRow(Cursor cursor) {
        dumpCurrentRow(cursor, System.out);
    }

    public static String dumpCurrentRowToString(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        dumpCurrentRow(cursor, sb);
        return sb.toString();
    }

    public static void dumpCursor(Cursor cursor) {
        dumpCursor(cursor, System.out);
    }

    public static String dumpCursorToString(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        dumpCursor(cursor, sb);
        return sb.toString();
    }

    public static char[] encodeHex(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            char[] cArr2 = DIGITS;
            cArr[i2] = cArr2[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[bArr[i3] & Ascii.SI];
        }
        return cArr;
    }

    public static int findRowIdColumnIndex(String[] strArr) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (strArr[i2].equals("_id")) {
                return i2;
            }
        }
        return -1;
    }

    public static String getCollationKey(String str) {
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        try {
            return new String(collationKeyInBytes, 0, getKeyLen(collationKeyInBytes), StringUtils.ISO88591);
        } catch (Exception unused) {
            return "";
        }
    }

    public static byte[] getCollationKeyInBytes(String str) {
        if (mColl == null) {
            Collator instance = Collator.getInstance();
            mColl = instance;
            instance.setStrength(0);
        }
        return mColl.getCollationKey(str).toByteArray();
    }

    public static String getHexCollationKey(String str) {
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        return new String(encodeHex(collationKeyInBytes), 0, getKeyLen(collationKeyInBytes) * 2);
    }

    public static int getKeyLen(byte[] bArr) {
        if (bArr[bArr.length - 1] != 0) {
            return bArr.length;
        }
        return bArr.length - 1;
    }

    public static int getSqlStatementType(String str) {
        String trim = str.trim();
        if (trim.length() < 3) {
            return 99;
        }
        String upperCase = trim.substring(0, 3).toUpperCase(Locale.ROOT);
        if (upperCase.equals("SEL")) {
            return 1;
        }
        if (upperCase.equals("INS") || upperCase.equals("UPD") || upperCase.equals("REP") || upperCase.equals("DEL")) {
            return 2;
        }
        if (upperCase.equals("ATT")) {
            return 3;
        }
        if (upperCase.equals("COM") || upperCase.equals("END")) {
            return 5;
        }
        if (upperCase.equals("ROL")) {
            return 6;
        }
        if (upperCase.equals("BEG")) {
            return 4;
        }
        if (upperCase.equals("PRA")) {
            return 7;
        }
        if (upperCase.equals("CRE") || upperCase.equals("DRO") || upperCase.equals("ALT")) {
            return 8;
        }
        if (upperCase.equals("ANA") || upperCase.equals("DET")) {
            return 9;
        }
        return 99;
    }

    public static int getTypeOfObject(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return 4;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return 2;
        }
        return ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) ? 1 : 3;
    }

    public static long longForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            return longForQuery(compileStatement, strArr);
        } finally {
            compileStatement.close();
        }
    }

    public static boolean queryIsEmpty(SQLiteDatabase sQLiteDatabase, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("select exists(select 1 from ");
        sb.append(str);
        sb.append(")");
        return longForQuery(sQLiteDatabase, sb.toString(), (String[]) null) == 0;
    }

    public static long queryNumEntries(SQLiteDatabase sQLiteDatabase, String str) {
        return queryNumEntries(sQLiteDatabase, str, (String) null, (String[]) null);
    }

    public static final void readExceptionFromParcel(Parcel parcel, String str, int i2) {
        switch (i2) {
            case 2:
                throw new IllegalArgumentException(str);
            case 3:
                throw new UnsupportedOperationException(str);
            case 4:
                throw new SQLiteAbortException(str);
            case 5:
                throw new SQLiteConstraintException(str);
            case 6:
                throw new SQLiteDatabaseCorruptException(str);
            case 7:
                throw new SQLiteFullException(str);
            case 8:
                throw new SQLiteDiskIOException(str);
            case 9:
                throw new SQLiteException(str);
            case 11:
                throw new OperationCanceledException(str);
            default:
                parcel.readException(i2, str);
                return;
        }
    }

    public static String sqlEscapeString(String str) {
        StringBuilder sb = new StringBuilder();
        appendEscapedSQLString(sb, str);
        return sb.toString();
    }

    public static String stringForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            return stringForQuery(compileStatement, strArr);
        } finally {
            compileStatement.close();
        }
    }

    public static final void writeExceptionToParcel(Parcel parcel, Exception exc) {
        int i2 = 1;
        if (!(exc instanceof FileNotFoundException)) {
            if (exc instanceof IllegalArgumentException) {
                i2 = 2;
            } else if (exc instanceof UnsupportedOperationException) {
                i2 = 3;
            } else if (exc instanceof SQLiteAbortException) {
                i2 = 4;
            } else if (exc instanceof SQLiteConstraintException) {
                i2 = 5;
            } else if (exc instanceof SQLiteDatabaseCorruptException) {
                i2 = 6;
            } else if (exc instanceof SQLiteFullException) {
                i2 = 7;
            } else if (exc instanceof SQLiteDiskIOException) {
                i2 = 8;
            } else if (exc instanceof SQLiteException) {
                i2 = 9;
            } else if (exc instanceof OperationApplicationException) {
                i2 = 10;
            } else if (exc instanceof OperationCanceledException) {
                i2 = 11;
            } else {
                parcel.writeException(exc);
                return;
            }
        }
        parcel.writeInt(i2);
        parcel.writeString(exc.getMessage());
    }

    public static void cursorIntToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (!cursor.isNull(columnIndex)) {
            contentValues.put(str2, Integer.valueOf(cursor.getInt(columnIndex)));
        } else {
            contentValues.put(str2, (Integer) null);
        }
    }

    public static void cursorLongToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (!cursor.isNull(columnIndex)) {
            contentValues.put(str2, Long.valueOf(cursor.getLong(columnIndex)));
        } else {
            contentValues.put(str2, (Long) null);
        }
    }

    public static void cursorStringToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        contentValues.put(str2, cursor.getString(cursor.getColumnIndexOrThrow(str)));
    }

    public static void dumpCurrentRow(Cursor cursor, PrintStream printStream) {
        String str;
        String[] columnNames = cursor.getColumnNames();
        printStream.println("" + cursor.getPosition() + " {");
        int length = columnNames.length;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                str = cursor.getString(i2);
            } catch (SQLiteException unused) {
                str = "<unprintable>";
            }
            printStream.println("   " + columnNames[i2] + a.h + str);
        }
        printStream.println("}");
    }

    public static void dumpCursor(Cursor cursor, PrintStream printStream) {
        printStream.println(">>>>> Dumping cursor " + cursor);
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, printStream);
            }
            cursor.moveToPosition(position);
        }
        printStream.println("<<<<<");
    }

    public static long queryNumEntries(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        return queryNumEntries(sQLiteDatabase, str, str2, (String[]) null);
    }

    public static long queryNumEntries(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        String str3;
        if (!TextUtils.isEmpty(str2)) {
            str3 = " where " + str2;
        } else {
            str3 = "";
        }
        return longForQuery(sQLiteDatabase, "select count(*) from " + str + str3, strArr);
    }

    public static ParcelFileDescriptor blobFileDescriptorForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        sQLiteStatement.bindAllArgsAsStrings(strArr);
        return sQLiteStatement.simpleQueryForBlobFileDescriptor();
    }

    public static long longForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        sQLiteStatement.bindAllArgsAsStrings(strArr);
        return sQLiteStatement.simpleQueryForLong();
    }

    public static String stringForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        sQLiteStatement.bindAllArgsAsStrings(strArr);
        return sQLiteStatement.simpleQueryForString();
    }

    public static void dumpCurrentRow(Cursor cursor, StringBuilder sb) {
        String str;
        String[] columnNames = cursor.getColumnNames();
        sb.append("" + cursor.getPosition() + " {\n");
        int length = columnNames.length;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                str = cursor.getString(i2);
            } catch (SQLiteException unused) {
                str = "<unprintable>";
            }
            sb.append("   " + columnNames[i2] + a.h + str + org.apache.commons.lang3.StringUtils.LF);
        }
        sb.append("}\n");
    }

    public static void dumpCursor(Cursor cursor, StringBuilder sb) {
        sb.append(">>>>> Dumping cursor " + cursor + org.apache.commons.lang3.StringUtils.LF);
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, sb);
            }
            cursor.moveToPosition(position);
        }
        sb.append("<<<<<\n");
    }
}
