package org.sqlite.database.sqlite;

import android.database.CursorWindow;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.util.LruCache;
import android.util.Printer;
import com.alipay.sdk.m.u.h;
import com.baidu.android.common.others.lang.StringUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import org.sqlite.database.DatabaseUtils;
import org.sqlite.database.sqlite.SQLiteDebug;

public final class SQLiteConnection implements CancellationSignal.OnCancelListener {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final boolean DEBUG = false;
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final String TAG = "SQLiteConnection";
    public int mCancellationSignalAttachCount;
    public final CloseGuard mCloseGuard = CloseGuard.get();
    public final SQLiteDatabaseConfiguration mConfiguration;
    public final int mConnectionId;
    public long mConnectionPtr;
    public final boolean mIsPrimaryConnection;
    public final boolean mIsReadOnlyConnection;
    public boolean mOnlyAllowReadOnlyOperations;
    public final SQLiteConnectionPool mPool;
    public final PreparedStatementCache mPreparedStatementCache;
    public PreparedStatement mPreparedStatementPool;
    public final OperationLog mRecentOperations = new OperationLog();

    public static final class Operation {
        public static final int MAX_TRACE_METHOD_NAME_LEN = 256;
        public ArrayList<Object> mBindArgs;
        public int mCookie;
        public long mEndTime;
        public Exception mException;
        public boolean mFinished;
        public String mKind;
        public String mSql;
        public long mStartTime;
        public long mStartWallTime;

        public Operation() {
        }

        /* access modifiers changed from: private */
        public String getFormattedStartTime() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(this.mStartWallTime));
        }

        private String getStatus() {
            if (!this.mFinished) {
                return "running";
            }
            return this.mException != null ? h.f684i : "succeeded";
        }

        private String getTraceMethodName() {
            String str = this.mKind + " " + this.mSql;
            return str.length() > 256 ? str.substring(0, 256) : str;
        }

        public void describe(StringBuilder sb, boolean z) {
            ArrayList<Object> arrayList;
            sb.append(this.mKind);
            if (this.mFinished) {
                sb.append(" took ");
                sb.append(this.mEndTime - this.mStartTime);
                sb.append("ms");
            } else {
                sb.append(" started ");
                sb.append(System.currentTimeMillis() - this.mStartWallTime);
                sb.append("ms ago");
            }
            sb.append(" - ");
            sb.append(getStatus());
            if (this.mSql != null) {
                sb.append(", sql=\"");
                sb.append(SQLiteConnection.trimSqlForDisplay(this.mSql));
                sb.append("\"");
            }
            if (!(!z || (arrayList = this.mBindArgs) == null || arrayList.size() == 0)) {
                sb.append(", bindArgs=[");
                int size = this.mBindArgs.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Object obj = this.mBindArgs.get(i2);
                    if (i2 != 0) {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    }
                    if (obj == null) {
                        sb.append(StringUtil.NULL_STRING);
                    } else if (obj instanceof byte[]) {
                        sb.append("<byte[]>");
                    } else if (obj instanceof String) {
                        sb.append("\"");
                        sb.append((String) obj);
                        sb.append("\"");
                    } else {
                        sb.append(obj);
                    }
                }
                sb.append("]");
            }
            if (this.mException != null) {
                sb.append(", exception=\"");
                sb.append(this.mException.getMessage());
                sb.append("\"");
            }
        }
    }

    public static final class OperationLog {
        public static final int COOKIE_GENERATION_SHIFT = 8;
        public static final int COOKIE_INDEX_MASK = 255;
        public static final int MAX_RECENT_OPERATIONS = 20;
        public int mGeneration;
        public int mIndex;
        public final Operation[] mOperations;

        public OperationLog() {
            this.mOperations = new Operation[20];
        }

        private boolean endOperationDeferLogLocked(int i2) {
            Operation operationLocked = getOperationLocked(i2);
            if (operationLocked != null) {
                operationLocked.mEndTime = SystemClock.uptimeMillis();
                operationLocked.mFinished = true;
            }
            return false;
        }

        private Operation getOperationLocked(int i2) {
            Operation operation = this.mOperations[i2 & 255];
            if (operation.mCookie == i2) {
                return operation;
            }
            return null;
        }

        private void logOperationLocked(int i2, String str) {
            Operation operationLocked = getOperationLocked(i2);
            StringBuilder sb = new StringBuilder();
            operationLocked.describe(sb, false);
            if (str != null) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(str);
            }
            sb.toString();
        }

        private int newOperationCookieLocked(int i2) {
            int i3 = this.mGeneration;
            this.mGeneration = i3 + 1;
            return i2 | (i3 << 8);
        }

        public int beginOperation(String str, String str2, Object[] objArr) {
            int newOperationCookieLocked;
            synchronized (this.mOperations) {
                int i2 = (this.mIndex + 1) % 20;
                Operation operation = this.mOperations[i2];
                if (operation == null) {
                    operation = new Operation();
                    this.mOperations[i2] = operation;
                } else {
                    operation.mFinished = false;
                    operation.mException = null;
                    if (operation.mBindArgs != null) {
                        operation.mBindArgs.clear();
                    }
                }
                operation.mStartWallTime = System.currentTimeMillis();
                operation.mStartTime = SystemClock.uptimeMillis();
                operation.mKind = str;
                operation.mSql = str2;
                if (objArr != null) {
                    if (operation.mBindArgs == null) {
                        operation.mBindArgs = new ArrayList<>();
                    } else {
                        operation.mBindArgs.clear();
                    }
                    for (Object obj : objArr) {
                        if (obj == null || !(obj instanceof byte[])) {
                            operation.mBindArgs.add(obj);
                        } else {
                            operation.mBindArgs.add(SQLiteConnection.EMPTY_BYTE_ARRAY);
                        }
                    }
                }
                newOperationCookieLocked = newOperationCookieLocked(i2);
                operation.mCookie = newOperationCookieLocked;
                this.mIndex = i2;
            }
            return newOperationCookieLocked;
        }

        public String describeCurrentOperation() {
            synchronized (this.mOperations) {
                Operation operation = this.mOperations[this.mIndex];
                if (operation == null || operation.mFinished) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                operation.describe(sb, false);
                String sb2 = sb.toString();
                return sb2;
            }
        }

        public void dump(Printer printer, boolean z) {
            synchronized (this.mOperations) {
                printer.println("  Most recently executed operations:");
                int i2 = this.mIndex;
                Operation operation = this.mOperations[i2];
                if (operation != null) {
                    int i3 = 0;
                    while (true) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("    ");
                        sb.append(i3);
                        sb.append(": [");
                        sb.append(operation.getFormattedStartTime());
                        sb.append("] ");
                        operation.describe(sb, z);
                        printer.println(sb.toString());
                        i2 = i2 > 0 ? i2 - 1 : 19;
                        i3++;
                        operation = this.mOperations[i2];
                        if (operation != null) {
                            if (i3 >= 20) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    printer.println("    <none>");
                }
            }
        }

        public void endOperation(int i2) {
            synchronized (this.mOperations) {
                if (endOperationDeferLogLocked(i2)) {
                    logOperationLocked(i2, (String) null);
                }
            }
        }

        public boolean endOperationDeferLog(int i2) {
            boolean endOperationDeferLogLocked;
            synchronized (this.mOperations) {
                endOperationDeferLogLocked = endOperationDeferLogLocked(i2);
            }
            return endOperationDeferLogLocked;
        }

        public void failOperation(int i2, Exception exc) {
            synchronized (this.mOperations) {
                Operation operationLocked = getOperationLocked(i2);
                if (operationLocked != null) {
                    operationLocked.mException = exc;
                }
            }
        }

        public void logOperation(int i2, String str) {
            synchronized (this.mOperations) {
                logOperationLocked(i2, str);
            }
        }
    }

    public static final class PreparedStatement {
        public boolean mInCache;
        public boolean mInUse;
        public int mNumParameters;
        public PreparedStatement mPoolNext;
        public boolean mReadOnly;
        public String mSql;
        public long mStatementPtr;
        public int mType;

        public PreparedStatement() {
        }
    }

    public final class PreparedStatementCache extends LruCache<String, PreparedStatement> {
        public PreparedStatementCache(int i2) {
            super(i2);
        }

        public void dump(Printer printer) {
            printer.println("  Prepared statement cache:");
            Map snapshot = snapshot();
            if (!snapshot.isEmpty()) {
                int i2 = 0;
                for (Map.Entry entry : snapshot.entrySet()) {
                    PreparedStatement preparedStatement = (PreparedStatement) entry.getValue();
                    if (preparedStatement.mInCache) {
                        printer.println("    " + i2 + ": statementPtr=0x" + Long.toHexString(preparedStatement.mStatementPtr) + ", numParameters=" + preparedStatement.mNumParameters + ", type=" + preparedStatement.mType + ", readOnly=" + preparedStatement.mReadOnly + ", sql=\"" + SQLiteConnection.trimSqlForDisplay((String) entry.getKey()) + "\"");
                    }
                    i2++;
                }
                return;
            }
            printer.println("    <none>");
        }

        public void entryRemoved(boolean z, String str, PreparedStatement preparedStatement, PreparedStatement preparedStatement2) {
            preparedStatement.mInCache = false;
            if (!preparedStatement.mInUse) {
                SQLiteConnection.this.finalizePreparedStatement(preparedStatement);
            }
        }
    }

    static {
        Class<SQLiteConnection> cls = SQLiteConnection.class;
    }

    public SQLiteConnection(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i2, boolean z) {
        this.mPool = sQLiteConnectionPool;
        this.mConfiguration = new SQLiteDatabaseConfiguration(sQLiteDatabaseConfiguration);
        this.mConnectionId = i2;
        this.mIsPrimaryConnection = z;
        this.mIsReadOnlyConnection = (sQLiteDatabaseConfiguration.openFlags & 1) == 0 ? false : true;
        this.mPreparedStatementCache = new PreparedStatementCache(this.mConfiguration.maxSqlCacheSize);
        this.mCloseGuard.open("close");
    }

    private PreparedStatement acquirePreparedStatement(String str) {
        boolean z;
        PreparedStatement preparedStatement = (PreparedStatement) this.mPreparedStatementCache.get(str);
        if (preparedStatement == null) {
            z = false;
        } else if (!preparedStatement.mInUse) {
            return preparedStatement;
        } else {
            z = true;
        }
        long nativePrepareStatement = nativePrepareStatement(this.mConnectionPtr, str);
        try {
            int nativeGetParameterCount = nativeGetParameterCount(this.mConnectionPtr, nativePrepareStatement);
            int sqlStatementType = DatabaseUtils.getSqlStatementType(str);
            PreparedStatement obtainPreparedStatement = obtainPreparedStatement(str, nativePrepareStatement, nativeGetParameterCount, sqlStatementType, nativeIsReadOnly(this.mConnectionPtr, nativePrepareStatement));
            if (!z && isCacheable(sqlStatementType)) {
                this.mPreparedStatementCache.put(str, obtainPreparedStatement);
                obtainPreparedStatement.mInCache = true;
            }
            obtainPreparedStatement.mInUse = true;
            return obtainPreparedStatement;
        } catch (RuntimeException e) {
            if (preparedStatement == null || !preparedStatement.mInCache) {
                nativeFinalizeStatement(this.mConnectionPtr, nativePrepareStatement);
            }
            throw e;
        }
    }

    private void applyBlockGuardPolicy(PreparedStatement preparedStatement) {
    }

    private void attachCancellationSignal(CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
            int i2 = this.mCancellationSignalAttachCount + 1;
            this.mCancellationSignalAttachCount = i2;
            if (i2 == 1) {
                nativeResetCancel(this.mConnectionPtr, true);
                cancellationSignal.setOnCancelListener(this);
            }
        }
    }

    private void bindArguments(PreparedStatement preparedStatement, Object[] objArr) {
        int length = objArr != null ? objArr.length : 0;
        if (length != preparedStatement.mNumParameters) {
            throw new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + preparedStatement.mNumParameters + " bind arguments but " + length + " were provided.");
        } else if (length != 0) {
            long j = preparedStatement.mStatementPtr;
            for (int i2 = 0; i2 < length; i2++) {
                Boolean bool = objArr[i2];
                int typeOfObject = DatabaseUtils.getTypeOfObject(bool);
                if (typeOfObject == 0) {
                    nativeBindNull(this.mConnectionPtr, j, i2 + 1);
                } else if (typeOfObject == 1) {
                    nativeBindLong(this.mConnectionPtr, j, i2 + 1, ((Number) bool).longValue());
                } else if (typeOfObject == 2) {
                    nativeBindDouble(this.mConnectionPtr, j, i2 + 1, ((Number) bool).doubleValue());
                } else if (typeOfObject == 4) {
                    nativeBindBlob(this.mConnectionPtr, j, i2 + 1, (byte[]) bool);
                } else if (bool instanceof Boolean) {
                    nativeBindLong(this.mConnectionPtr, j, i2 + 1, bool.booleanValue() ? 1 : 0);
                } else {
                    nativeBindString(this.mConnectionPtr, j, i2 + 1, bool.toString());
                }
            }
        }
    }

    public static String canonicalizeSyncMode(String str) {
        if (str.equals("0")) {
            return "OFF";
        }
        if (str.equals("1")) {
            return "NORMAL";
        }
        return str.equals("2") ? "FULL" : str;
    }

    private void detachCancellationSignal(CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            int i2 = this.mCancellationSignalAttachCount - 1;
            this.mCancellationSignalAttachCount = i2;
            if (i2 == 0) {
                cancellationSignal.setOnCancelListener((CancellationSignal.OnCancelListener) null);
                nativeResetCancel(this.mConnectionPtr, false);
            }
        }
    }

    private void dispose(boolean z) {
        CloseGuard closeGuard = this.mCloseGuard;
        if (closeGuard != null) {
            if (z) {
                closeGuard.warnIfOpen();
            }
            this.mCloseGuard.close();
        }
        if (this.mConnectionPtr != 0) {
            int beginOperation = this.mRecentOperations.beginOperation("close", (String) null, (Object[]) null);
            try {
                this.mPreparedStatementCache.evictAll();
                nativeClose(this.mConnectionPtr);
                this.mConnectionPtr = 0;
            } finally {
                this.mRecentOperations.endOperation(beginOperation);
            }
        }
    }

    /* access modifiers changed from: private */
    public void finalizePreparedStatement(PreparedStatement preparedStatement) {
        nativeFinalizeStatement(this.mConnectionPtr, preparedStatement.mStatementPtr);
        recyclePreparedStatement(preparedStatement);
    }

    private SQLiteDebug.DbStats getMainDbStatsUnsafe(int i2, long j, long j2) {
        String str = this.mConfiguration.path;
        if (!this.mIsPrimaryConnection) {
            str = str + " (" + this.mConnectionId + ")";
        }
        return new SQLiteDebug.DbStats(str, j, j2, i2, this.mPreparedStatementCache.hitCount(), this.mPreparedStatementCache.missCount(), this.mPreparedStatementCache.size());
    }

    public static boolean hasCodec() {
        return nativeHasCodec();
    }

    public static boolean isCacheable(int i2) {
        return i2 == 2 || i2 == 1;
    }

    public static native void nativeBindBlob(long j, long j2, int i2, byte[] bArr);

    public static native void nativeBindDouble(long j, long j2, int i2, double d);

    public static native void nativeBindLong(long j, long j2, int i2, long j3);

    public static native void nativeBindNull(long j, long j2, int i2);

    public static native void nativeBindString(long j, long j2, int i2, String str);

    public static native void nativeCancel(long j);

    public static native void nativeClose(long j);

    public static native void nativeExecute(long j, long j2);

    public static native int nativeExecuteForBlobFileDescriptor(long j, long j2);

    public static native int nativeExecuteForChangedRowCount(long j, long j2);

    public static native long nativeExecuteForCursorWindow(long j, long j2, CursorWindow cursorWindow, int i2, int i3, boolean z);

    public static native long nativeExecuteForLastInsertedRowId(long j, long j2);

    public static native long nativeExecuteForLong(long j, long j2);

    public static native String nativeExecuteForString(long j, long j2);

    public static native void nativeFinalizeStatement(long j, long j2);

    public static native int nativeGetColumnCount(long j, long j2);

    public static native String nativeGetColumnName(long j, long j2, int i2);

    public static native int nativeGetDbLookaside(long j);

    public static native int nativeGetParameterCount(long j, long j2);

    public static native boolean nativeHasCodec();

    public static native boolean nativeIsReadOnly(long j, long j2);

    public static native long nativeOpen(String str, int i2, String str2, boolean z, boolean z2);

    public static native long nativePrepareStatement(long j, String str);

    public static native void nativeRegisterCustomFunction(long j, SQLiteCustomFunction sQLiteCustomFunction);

    public static native void nativeRegisterLocalizedCollators(long j, String str);

    public static native void nativeResetCancel(long j, boolean z);

    public static native void nativeResetStatementAndClearBindings(long j, long j2);

    private PreparedStatement obtainPreparedStatement(String str, long j, int i2, int i3, boolean z) {
        PreparedStatement preparedStatement = this.mPreparedStatementPool;
        if (preparedStatement != null) {
            this.mPreparedStatementPool = preparedStatement.mPoolNext;
            preparedStatement.mPoolNext = null;
            preparedStatement.mInCache = false;
        } else {
            preparedStatement = new PreparedStatement();
        }
        preparedStatement.mSql = str;
        preparedStatement.mStatementPtr = j;
        preparedStatement.mNumParameters = i2;
        preparedStatement.mType = i3;
        preparedStatement.mReadOnly = z;
        return preparedStatement;
    }

    public static SQLiteConnection open(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i2, boolean z) {
        SQLiteConnection sQLiteConnection = new SQLiteConnection(sQLiteConnectionPool, sQLiteDatabaseConfiguration, i2, z);
        try {
            sQLiteConnection.open();
            return sQLiteConnection;
        } catch (SQLiteException e) {
            sQLiteConnection.dispose(false);
            throw e;
        }
    }

    private void recyclePreparedStatement(PreparedStatement preparedStatement) {
        preparedStatement.mSql = null;
        preparedStatement.mPoolNext = this.mPreparedStatementPool;
        this.mPreparedStatementPool = preparedStatement;
    }

    private void releasePreparedStatement(PreparedStatement preparedStatement) {
        preparedStatement.mInUse = false;
        if (preparedStatement.mInCache) {
            try {
                nativeResetStatementAndClearBindings(this.mConnectionPtr, preparedStatement.mStatementPtr);
            } catch (SQLiteException unused) {
                this.mPreparedStatementCache.remove(preparedStatement.mSql);
            }
        } else {
            finalizePreparedStatement(preparedStatement);
        }
    }

    private void setAutoCheckpointInterval() {
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection) {
            long wALAutoCheckpoint = (long) SQLiteGlobal.getWALAutoCheckpoint();
            if (executeForLong("PRAGMA wal_autocheckpoint", (Object[]) null, (CancellationSignal) null) != wALAutoCheckpoint) {
                executeForLong("PRAGMA wal_autocheckpoint=" + wALAutoCheckpoint, (Object[]) null, (CancellationSignal) null);
            }
        }
    }

    private void setForeignKeyModeFromConfiguration() {
        if (!this.mIsReadOnlyConnection) {
            long j = this.mConfiguration.foreignKeyConstraintsEnabled ? 1 : 0;
            if (executeForLong("PRAGMA foreign_keys", (Object[]) null, (CancellationSignal) null) != j) {
                execute("PRAGMA foreign_keys=" + j, (Object[]) null, (CancellationSignal) null);
            }
        }
    }

    private void setJournalMode(String str) {
        String executeForString = executeForString("PRAGMA journal_mode", (Object[]) null, (CancellationSignal) null);
        if (!executeForString.equalsIgnoreCase(str)) {
            try {
                if (executeForString("PRAGMA journal_mode=" + str, (Object[]) null, (CancellationSignal) null).equalsIgnoreCase(str)) {
                    return;
                }
            } catch (SQLiteDatabaseLockedException unused) {
            }
            "Could not change the database journal mode of '" + this.mConfiguration.label + "' from '" + executeForString + "' to '" + str + "' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.";
        }
    }

    private void setJournalSizeLimit() {
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection) {
            long journalSizeLimit = (long) SQLiteGlobal.getJournalSizeLimit();
            if (executeForLong("PRAGMA journal_size_limit", (Object[]) null, (CancellationSignal) null) != journalSizeLimit) {
                executeForLong("PRAGMA journal_size_limit=" + journalSizeLimit, (Object[]) null, (CancellationSignal) null);
            }
        }
    }

    private void setLocaleFromConfiguration() {
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfiguration;
        if ((sQLiteDatabaseConfiguration.openFlags & 16) == 0) {
            String locale = sQLiteDatabaseConfiguration.locale.toString();
            nativeRegisterLocalizedCollators(this.mConnectionPtr, locale);
            if (!this.mIsReadOnlyConnection) {
                try {
                    execute("CREATE TABLE IF NOT EXISTS android_metadata (locale TEXT)", (Object[]) null, (CancellationSignal) null);
                    String executeForString = executeForString("SELECT locale FROM android_metadata UNION SELECT NULL ORDER BY locale DESC LIMIT 1", (Object[]) null, (CancellationSignal) null);
                    if (executeForString == null || !executeForString.equals(locale)) {
                        execute("BEGIN", (Object[]) null, (CancellationSignal) null);
                        execute("DELETE FROM android_metadata", (Object[]) null, (CancellationSignal) null);
                        execute("INSERT INTO android_metadata (locale) VALUES(?)", new Object[]{locale}, (CancellationSignal) null);
                        execute("REINDEX LOCALIZED", (Object[]) null, (CancellationSignal) null);
                        execute("COMMIT", (Object[]) null, (CancellationSignal) null);
                    }
                } catch (RuntimeException e) {
                    throw new SQLiteException("Failed to change locale for db '" + this.mConfiguration.label + "' to '" + locale + "'.", e);
                } catch (Throwable th2) {
                    execute("ROLLBACK", (Object[]) null, (CancellationSignal) null);
                    throw th2;
                }
            }
        }
    }

    private void setPageSize() {
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection) {
            long defaultPageSize = (long) SQLiteGlobal.getDefaultPageSize();
            if (executeForLong("PRAGMA page_size", (Object[]) null, (CancellationSignal) null) != defaultPageSize) {
                execute("PRAGMA page_size=" + defaultPageSize, (Object[]) null, (CancellationSignal) null);
            }
        }
    }

    private void setSyncMode(String str) {
        if (!canonicalizeSyncMode(executeForString("PRAGMA synchronous", (Object[]) null, (CancellationSignal) null)).equalsIgnoreCase(canonicalizeSyncMode(str))) {
            execute("PRAGMA synchronous=" + str, (Object[]) null, (CancellationSignal) null);
        }
    }

    private void setWalModeFromConfiguration() {
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection) {
            if ((this.mConfiguration.openFlags & 536870912) != 0) {
                setJournalMode("WAL");
                setSyncMode(SQLiteGlobal.getWALSyncMode());
                return;
            }
            setJournalMode(SQLiteGlobal.getDefaultJournalMode());
            setSyncMode(SQLiteGlobal.getDefaultSyncMode());
        }
    }

    private void throwIfStatementForbidden(PreparedStatement preparedStatement) {
        if (this.mOnlyAllowReadOnlyOperations && !preparedStatement.mReadOnly) {
            throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
        }
    }

    public static String trimSqlForDisplay(String str) {
        return str.replaceAll("[\\s]*\\n+[\\s]*", " ");
    }

    public void close() {
        dispose(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0081, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c9, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00cc, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043 A[Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009d A[Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c8 A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:11:0x0038] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void collectDbStats(java.util.ArrayList<org.sqlite.database.sqlite.SQLiteDebug.DbStats> r26) {
        /*
            r25 = this;
            r9 = r25
            r0 = r26
            java.lang.String r10 = "PRAGMA "
            long r1 = r9.mConnectionPtr
            int r2 = nativeGetDbLookaside(r1)
            r11 = 0
            r13 = 0
            java.lang.String r1 = "PRAGMA page_count;"
            long r3 = r9.executeForLong(r1, r13, r13)     // Catch:{ SQLiteException -> 0x001c }
            java.lang.String r1 = "PRAGMA page_size;"
            long r5 = r9.executeForLong(r1, r13, r13)     // Catch:{ SQLiteException -> 0x001d }
            goto L_0x001e
        L_0x001c:
            r3 = r11
        L_0x001d:
            r5 = r11
        L_0x001e:
            r1 = r25
            org.sqlite.database.sqlite.SQLiteDebug$DbStats r1 = r1.getMainDbStatsUnsafe(r2, r3, r5)
            r0.add(r1)
            android.database.CursorWindow r14 = new android.database.CursorWindow
            java.lang.String r1 = "collectDbStats"
            r14.<init>(r1)
            java.lang.String r2 = "PRAGMA database_list;"
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r25
            r4 = r14
            r1.executeForCursorWindow(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            r1 = 1
            r2 = 1
        L_0x003d:
            int r3 = r14.getNumRows()     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            if (r2 >= r3) goto L_0x00cd
            java.lang.String r3 = r14.getString(r2, r1)     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            r4 = 2
            java.lang.String r4 = r14.getString(r2, r4)     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0081, all -> 0x00c8 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x0081, all -> 0x00c8 }
            r5.append(r10)     // Catch:{ SQLiteException -> 0x0081, all -> 0x00c8 }
            r5.append(r3)     // Catch:{ SQLiteException -> 0x0081, all -> 0x00c8 }
            java.lang.String r6 = ".page_count;"
            r5.append(r6)     // Catch:{ SQLiteException -> 0x0081, all -> 0x00c8 }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteException -> 0x0081, all -> 0x00c8 }
            long r5 = r9.executeForLong(r5, r13, r13)     // Catch:{ SQLiteException -> 0x0081, all -> 0x00c8 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0082, all -> 0x00c8 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x0082, all -> 0x00c8 }
            r7.append(r10)     // Catch:{ SQLiteException -> 0x0082, all -> 0x00c8 }
            r7.append(r3)     // Catch:{ SQLiteException -> 0x0082, all -> 0x00c8 }
            java.lang.String r8 = ".page_size;"
            r7.append(r8)     // Catch:{ SQLiteException -> 0x0082, all -> 0x00c8 }
            java.lang.String r7 = r7.toString()     // Catch:{ SQLiteException -> 0x0082, all -> 0x00c8 }
            long r7 = r9.executeForLong(r7, r13, r13)     // Catch:{ SQLiteException -> 0x0082, all -> 0x00c8 }
            r17 = r5
            r19 = r7
            goto L_0x0086
        L_0x0081:
            r5 = r11
        L_0x0082:
            r17 = r5
            r19 = r11
        L_0x0086:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            java.lang.String r6 = "  (attached) "
            r5.append(r6)     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            r5.append(r3)     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            java.lang.String r3 = r5.toString()     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            boolean r5 = r4.isEmpty()     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            if (r5 != 0) goto L_0x00b1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            r5.append(r3)     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            java.lang.String r3 = ": "
            r5.append(r3)     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            r5.append(r4)     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            java.lang.String r3 = r5.toString()     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
        L_0x00b1:
            r16 = r3
            org.sqlite.database.sqlite.SQLiteDebug$DbStats r3 = new org.sqlite.database.sqlite.SQLiteDebug$DbStats     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r15 = r3
            r15.<init>(r16, r17, r19, r21, r22, r23, r24)     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            r0.add(r3)     // Catch:{ SQLiteException -> 0x00cd, all -> 0x00c8 }
            int r2 = r2 + 1
            goto L_0x003d
        L_0x00c8:
            r0 = move-exception
            r14.close()
            throw r0
        L_0x00cd:
            r14.close()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.sqlite.database.sqlite.SQLiteConnection.collectDbStats(java.util.ArrayList):void");
    }

    public void collectDbStatsUnsafe(ArrayList<SQLiteDebug.DbStats> arrayList) {
        arrayList.add(getMainDbStatsUnsafe(0, 0, 0));
    }

    public String describeCurrentOperationUnsafe() {
        return this.mRecentOperations.describeCurrentOperation();
    }

    public void dump(Printer printer, boolean z) {
        dumpUnsafe(printer, z);
    }

    public void dumpUnsafe(Printer printer, boolean z) {
        printer.println("Connection #" + this.mConnectionId + ":");
        if (z) {
            printer.println("  connectionPtr: 0x" + Long.toHexString(this.mConnectionPtr));
        }
        printer.println("  isPrimaryConnection: " + this.mIsPrimaryConnection);
        printer.println("  onlyAllowReadOnlyOperations: " + this.mOnlyAllowReadOnlyOperations);
        this.mRecentOperations.dump(printer, z);
        if (z) {
            this.mPreparedStatementCache.dump(printer);
        }
    }

    public void enableLocalizedCollators() {
        if (nativeHasCodec()) {
            setLocaleFromConfiguration();
        }
    }

    public void execute(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str != null) {
            int beginOperation = this.mRecentOperations.beginOperation("execute", str, objArr);
            try {
                PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
                try {
                    throwIfStatementForbidden(acquirePreparedStatement);
                    bindArguments(acquirePreparedStatement, objArr);
                    applyBlockGuardPolicy(acquirePreparedStatement);
                    attachCancellationSignal(cancellationSignal);
                    nativeExecute(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                    detachCancellationSignal(cancellationSignal);
                    releasePreparedStatement(acquirePreparedStatement);
                    this.mRecentOperations.endOperation(beginOperation);
                } catch (Throwable th2) {
                    releasePreparedStatement(acquirePreparedStatement);
                    throw th2;
                }
            } catch (RuntimeException e) {
                try {
                    this.mRecentOperations.failOperation(beginOperation, e);
                    throw e;
                } catch (Throwable th3) {
                    this.mRecentOperations.endOperation(beginOperation);
                    throw th3;
                }
            }
        } else {
            throw new IllegalArgumentException("sql must not be null.");
        }
    }

    public ParcelFileDescriptor executeForBlobFileDescriptor(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str != null) {
            int beginOperation = this.mRecentOperations.beginOperation("executeForBlobFileDescriptor", str, objArr);
            try {
                PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
                try {
                    throwIfStatementForbidden(acquirePreparedStatement);
                    bindArguments(acquirePreparedStatement, objArr);
                    applyBlockGuardPolicy(acquirePreparedStatement);
                    attachCancellationSignal(cancellationSignal);
                    int nativeExecuteForBlobFileDescriptor = nativeExecuteForBlobFileDescriptor(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                    ParcelFileDescriptor adoptFd = nativeExecuteForBlobFileDescriptor >= 0 ? ParcelFileDescriptor.adoptFd(nativeExecuteForBlobFileDescriptor) : null;
                    detachCancellationSignal(cancellationSignal);
                    releasePreparedStatement(acquirePreparedStatement);
                    this.mRecentOperations.endOperation(beginOperation);
                    return adoptFd;
                } catch (Throwable th2) {
                    releasePreparedStatement(acquirePreparedStatement);
                    throw th2;
                }
            } catch (RuntimeException e) {
                try {
                    this.mRecentOperations.failOperation(beginOperation, e);
                    throw e;
                } catch (Throwable th3) {
                    this.mRecentOperations.endOperation(beginOperation);
                    throw th3;
                }
            }
        } else {
            throw new IllegalArgumentException("sql must not be null.");
        }
    }

    public int executeForChangedRowCount(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str != null) {
            int i2 = 0;
            int beginOperation = this.mRecentOperations.beginOperation("executeForChangedRowCount", str, objArr);
            try {
                PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
                try {
                    throwIfStatementForbidden(acquirePreparedStatement);
                    bindArguments(acquirePreparedStatement, objArr);
                    applyBlockGuardPolicy(acquirePreparedStatement);
                    attachCancellationSignal(cancellationSignal);
                    i2 = nativeExecuteForChangedRowCount(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                    detachCancellationSignal(cancellationSignal);
                    releasePreparedStatement(acquirePreparedStatement);
                    if (this.mRecentOperations.endOperationDeferLog(beginOperation)) {
                        OperationLog operationLog = this.mRecentOperations;
                        operationLog.logOperation(beginOperation, "changedRows=" + i2);
                    }
                    return i2;
                } catch (Throwable th2) {
                    releasePreparedStatement(acquirePreparedStatement);
                    throw th2;
                }
            } catch (RuntimeException e) {
                try {
                    this.mRecentOperations.failOperation(beginOperation, e);
                    throw e;
                } catch (Throwable th3) {
                    if (this.mRecentOperations.endOperationDeferLog(beginOperation)) {
                        OperationLog operationLog2 = this.mRecentOperations;
                        operationLog2.logOperation(beginOperation, "changedRows=" + i2);
                    }
                    throw th3;
                }
            }
        } else {
            throw new IllegalArgumentException("sql must not be null.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0147 A[Catch:{ all -> 0x0174 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int executeForCursorWindow(java.lang.String r22, java.lang.Object[] r23, android.database.CursorWindow r24, int r25, int r26, boolean r27, android.os.CancellationSignal r28) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            r2 = r23
            r10 = r24
            r11 = r25
            r12 = r28
            java.lang.String r13 = ", countedRows="
            java.lang.String r14 = ", filledRows="
            java.lang.String r15 = ", actualPos="
            java.lang.String r9 = "', startPos="
            java.lang.String r8 = "window='"
            if (r0 == 0) goto L_0x0181
            if (r10 == 0) goto L_0x0179
            r24.acquireReference()
            org.sqlite.database.sqlite.SQLiteConnection$OperationLog r3 = r1.mRecentOperations     // Catch:{ all -> 0x0174 }
            java.lang.String r4 = "executeForCursorWindow"
            int r7 = r3.beginOperation(r4, r0, r2)     // Catch:{ all -> 0x0174 }
            r16 = -1
            org.sqlite.database.sqlite.SQLiteConnection$PreparedStatement r6 = r21.acquirePreparedStatement(r22)     // Catch:{ RuntimeException -> 0x0129, all -> 0x011a }
            r1.throwIfStatementForbidden(r6)     // Catch:{ all -> 0x0106 }
            r1.bindArguments(r6, r2)     // Catch:{ all -> 0x0106 }
            r1.applyBlockGuardPolicy(r6)     // Catch:{ all -> 0x0106 }
            r1.attachCancellationSignal(r12)     // Catch:{ all -> 0x0106 }
            long r2 = r1.mConnectionPtr     // Catch:{ all -> 0x00f2 }
            long r4 = r6.mStatementPtr     // Catch:{ all -> 0x00f2 }
            r17 = r13
            r13 = r6
            r6 = r24
            r18 = r14
            r14 = r7
            r7 = r25
            r19 = r15
            r15 = r8
            r8 = r26
            r11 = r9
            r9 = r27
            long r2 = nativeExecuteForCursorWindow(r2, r4, r6, r7, r8, r9)     // Catch:{ all -> 0x00e7 }
            r0 = 32
            long r4 = r2 >> r0
            int r5 = (int) r4
            int r3 = (int) r2
            int r2 = r24.getNumRows()     // Catch:{ all -> 0x00d9 }
            r10.setStartPosition(r5)     // Catch:{ all -> 0x00cc }
            r1.detachCancellationSignal(r12)     // Catch:{ all -> 0x00be }
            r1.releasePreparedStatement(r13)     // Catch:{ RuntimeException -> 0x00b0, all -> 0x00a4 }
            org.sqlite.database.sqlite.SQLiteConnection$OperationLog r0 = r1.mRecentOperations     // Catch:{ all -> 0x0174 }
            boolean r0 = r0.endOperationDeferLog(r14)     // Catch:{ all -> 0x0174 }
            if (r0 == 0) goto L_0x00a0
            org.sqlite.database.sqlite.SQLiteConnection$OperationLog r0 = r1.mRecentOperations     // Catch:{ all -> 0x0174 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0174 }
            r4.<init>()     // Catch:{ all -> 0x0174 }
            r4.append(r15)     // Catch:{ all -> 0x0174 }
            r4.append(r10)     // Catch:{ all -> 0x0174 }
            r4.append(r11)     // Catch:{ all -> 0x0174 }
            r6 = r25
            r4.append(r6)     // Catch:{ all -> 0x0174 }
            r7 = r19
            r4.append(r7)     // Catch:{ all -> 0x0174 }
            r4.append(r5)     // Catch:{ all -> 0x0174 }
            r8 = r18
            r4.append(r8)     // Catch:{ all -> 0x0174 }
            r4.append(r2)     // Catch:{ all -> 0x0174 }
            r9 = r17
            r4.append(r9)     // Catch:{ all -> 0x0174 }
            r4.append(r3)     // Catch:{ all -> 0x0174 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0174 }
            r0.logOperation(r14, r2)     // Catch:{ all -> 0x0174 }
        L_0x00a0:
            r24.releaseReference()
            return r3
        L_0x00a4:
            r0 = move-exception
            r6 = r25
            r4 = r11
            r9 = r17
            r8 = r18
            r7 = r19
            goto L_0x013f
        L_0x00b0:
            r0 = move-exception
            r6 = r25
            r4 = r11
            r9 = r17
            r8 = r18
            r7 = r19
            r16 = r5
            goto L_0x0136
        L_0x00be:
            r0 = move-exception
            r6 = r25
            r4 = r11
            r9 = r17
            r8 = r18
            r7 = r19
            r16 = r5
            goto L_0x0114
        L_0x00cc:
            r0 = move-exception
            r6 = r25
            r4 = r11
            r9 = r17
            r8 = r18
            r7 = r19
            r16 = r5
            goto L_0x0100
        L_0x00d9:
            r0 = move-exception
            r6 = r25
            r4 = r11
            r9 = r17
            r8 = r18
            r7 = r19
            r16 = r5
            r2 = -1
            goto L_0x0100
        L_0x00e7:
            r0 = move-exception
            r6 = r25
            r4 = r11
            r9 = r17
            r8 = r18
            r7 = r19
            goto L_0x00fe
        L_0x00f2:
            r0 = move-exception
            r4 = r9
            r9 = r13
            r13 = r6
            r6 = r11
            r20 = r14
            r14 = r7
            r7 = r15
            r15 = r8
            r8 = r20
        L_0x00fe:
            r2 = -1
            r3 = -1
        L_0x0100:
            r1.detachCancellationSignal(r12)     // Catch:{ all -> 0x0104 }
            throw r0     // Catch:{ all -> 0x0104 }
        L_0x0104:
            r0 = move-exception
            goto L_0x0114
        L_0x0106:
            r0 = move-exception
            r4 = r9
            r9 = r13
            r13 = r6
            r6 = r11
            r20 = r14
            r14 = r7
            r7 = r15
            r15 = r8
            r8 = r20
            r2 = -1
            r3 = -1
        L_0x0114:
            r1.releasePreparedStatement(r13)     // Catch:{ RuntimeException -> 0x0118 }
            throw r0     // Catch:{ RuntimeException -> 0x0118 }
        L_0x0118:
            r0 = move-exception
            goto L_0x0136
        L_0x011a:
            r0 = move-exception
            r4 = r9
            r6 = r11
            r9 = r13
            r20 = r14
            r14 = r7
            r7 = r15
            r15 = r8
            r8 = r20
            r2 = -1
            r3 = -1
            r5 = -1
            goto L_0x013f
        L_0x0129:
            r0 = move-exception
            r4 = r9
            r6 = r11
            r9 = r13
            r20 = r14
            r14 = r7
            r7 = r15
            r15 = r8
            r8 = r20
            r2 = -1
            r3 = -1
        L_0x0136:
            org.sqlite.database.sqlite.SQLiteConnection$OperationLog r5 = r1.mRecentOperations     // Catch:{ all -> 0x013c }
            r5.failOperation(r14, r0)     // Catch:{ all -> 0x013c }
            throw r0     // Catch:{ all -> 0x013c }
        L_0x013c:
            r0 = move-exception
            r5 = r16
        L_0x013f:
            org.sqlite.database.sqlite.SQLiteConnection$OperationLog r11 = r1.mRecentOperations     // Catch:{ all -> 0x0174 }
            boolean r11 = r11.endOperationDeferLog(r14)     // Catch:{ all -> 0x0174 }
            if (r11 == 0) goto L_0x0173
            org.sqlite.database.sqlite.SQLiteConnection$OperationLog r11 = r1.mRecentOperations     // Catch:{ all -> 0x0174 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0174 }
            r12.<init>()     // Catch:{ all -> 0x0174 }
            r12.append(r15)     // Catch:{ all -> 0x0174 }
            r12.append(r10)     // Catch:{ all -> 0x0174 }
            r12.append(r4)     // Catch:{ all -> 0x0174 }
            r12.append(r6)     // Catch:{ all -> 0x0174 }
            r12.append(r7)     // Catch:{ all -> 0x0174 }
            r12.append(r5)     // Catch:{ all -> 0x0174 }
            r12.append(r8)     // Catch:{ all -> 0x0174 }
            r12.append(r2)     // Catch:{ all -> 0x0174 }
            r12.append(r9)     // Catch:{ all -> 0x0174 }
            r12.append(r3)     // Catch:{ all -> 0x0174 }
            java.lang.String r2 = r12.toString()     // Catch:{ all -> 0x0174 }
            r11.logOperation(r14, r2)     // Catch:{ all -> 0x0174 }
        L_0x0173:
            throw r0     // Catch:{ all -> 0x0174 }
        L_0x0174:
            r0 = move-exception
            r24.releaseReference()
            throw r0
        L_0x0179:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "window must not be null."
            r0.<init>(r2)
            throw r0
        L_0x0181:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "sql must not be null."
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.sqlite.database.sqlite.SQLiteConnection.executeForCursorWindow(java.lang.String, java.lang.Object[], android.database.CursorWindow, int, int, boolean, android.os.CancellationSignal):int");
    }

    public long executeForLastInsertedRowId(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str != null) {
            int beginOperation = this.mRecentOperations.beginOperation("executeForLastInsertedRowId", str, objArr);
            try {
                PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
                try {
                    throwIfStatementForbidden(acquirePreparedStatement);
                    bindArguments(acquirePreparedStatement, objArr);
                    applyBlockGuardPolicy(acquirePreparedStatement);
                    attachCancellationSignal(cancellationSignal);
                    long nativeExecuteForLastInsertedRowId = nativeExecuteForLastInsertedRowId(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                    detachCancellationSignal(cancellationSignal);
                    releasePreparedStatement(acquirePreparedStatement);
                    this.mRecentOperations.endOperation(beginOperation);
                    return nativeExecuteForLastInsertedRowId;
                } catch (Throwable th2) {
                    releasePreparedStatement(acquirePreparedStatement);
                    throw th2;
                }
            } catch (RuntimeException e) {
                try {
                    this.mRecentOperations.failOperation(beginOperation, e);
                    throw e;
                } catch (Throwable th3) {
                    this.mRecentOperations.endOperation(beginOperation);
                    throw th3;
                }
            }
        } else {
            throw new IllegalArgumentException("sql must not be null.");
        }
    }

    public long executeForLong(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str != null) {
            int beginOperation = this.mRecentOperations.beginOperation("executeForLong", str, objArr);
            try {
                PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
                try {
                    throwIfStatementForbidden(acquirePreparedStatement);
                    bindArguments(acquirePreparedStatement, objArr);
                    applyBlockGuardPolicy(acquirePreparedStatement);
                    attachCancellationSignal(cancellationSignal);
                    long nativeExecuteForLong = nativeExecuteForLong(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                    detachCancellationSignal(cancellationSignal);
                    releasePreparedStatement(acquirePreparedStatement);
                    this.mRecentOperations.endOperation(beginOperation);
                    return nativeExecuteForLong;
                } catch (Throwable th2) {
                    releasePreparedStatement(acquirePreparedStatement);
                    throw th2;
                }
            } catch (RuntimeException e) {
                try {
                    this.mRecentOperations.failOperation(beginOperation, e);
                    throw e;
                } catch (Throwable th3) {
                    this.mRecentOperations.endOperation(beginOperation);
                    throw th3;
                }
            }
        } else {
            throw new IllegalArgumentException("sql must not be null.");
        }
    }

    public String executeForString(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str != null) {
            int beginOperation = this.mRecentOperations.beginOperation("executeForString", str, objArr);
            try {
                PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
                try {
                    throwIfStatementForbidden(acquirePreparedStatement);
                    bindArguments(acquirePreparedStatement, objArr);
                    applyBlockGuardPolicy(acquirePreparedStatement);
                    attachCancellationSignal(cancellationSignal);
                    String nativeExecuteForString = nativeExecuteForString(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                    detachCancellationSignal(cancellationSignal);
                    releasePreparedStatement(acquirePreparedStatement);
                    this.mRecentOperations.endOperation(beginOperation);
                    return nativeExecuteForString;
                } catch (Throwable th2) {
                    releasePreparedStatement(acquirePreparedStatement);
                    throw th2;
                }
            } catch (RuntimeException e) {
                try {
                    this.mRecentOperations.failOperation(beginOperation, e);
                    throw e;
                } catch (Throwable th3) {
                    this.mRecentOperations.endOperation(beginOperation);
                    throw th3;
                }
            }
        } else {
            throw new IllegalArgumentException("sql must not be null.");
        }
    }

    public void finalize() throws Throwable {
        try {
            if (!(this.mPool == null || this.mConnectionPtr == 0)) {
                this.mPool.onConnectionLeaked();
            }
            dispose(true);
        } finally {
            super.finalize();
        }
    }

    public int getConnectionId() {
        return this.mConnectionId;
    }

    public boolean isPreparedStatementInCache(String str) {
        return this.mPreparedStatementCache.get(str) != null;
    }

    public boolean isPrimaryConnection() {
        return this.mIsPrimaryConnection;
    }

    public void onCancel() {
        nativeCancel(this.mConnectionPtr);
    }

    public void prepare(String str, SQLiteStatementInfo sQLiteStatementInfo) {
        PreparedStatement acquirePreparedStatement;
        if (str != null) {
            int beginOperation = this.mRecentOperations.beginOperation("prepare", str, (Object[]) null);
            try {
                acquirePreparedStatement = acquirePreparedStatement(str);
                if (sQLiteStatementInfo != null) {
                    sQLiteStatementInfo.numParameters = acquirePreparedStatement.mNumParameters;
                    sQLiteStatementInfo.readOnly = acquirePreparedStatement.mReadOnly;
                    int nativeGetColumnCount = nativeGetColumnCount(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr);
                    if (nativeGetColumnCount == 0) {
                        sQLiteStatementInfo.columnNames = EMPTY_STRING_ARRAY;
                    } else {
                        sQLiteStatementInfo.columnNames = new String[nativeGetColumnCount];
                        for (int i2 = 0; i2 < nativeGetColumnCount; i2++) {
                            sQLiteStatementInfo.columnNames[i2] = nativeGetColumnName(this.mConnectionPtr, acquirePreparedStatement.mStatementPtr, i2);
                        }
                    }
                }
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(beginOperation);
            } catch (RuntimeException e) {
                try {
                    this.mRecentOperations.failOperation(beginOperation, e);
                    throw e;
                } catch (Throwable th2) {
                    this.mRecentOperations.endOperation(beginOperation);
                    throw th2;
                }
            } catch (Throwable th3) {
                releasePreparedStatement(acquirePreparedStatement);
                throw th3;
            }
        } else {
            throw new IllegalArgumentException("sql must not be null.");
        }
    }

    public void reconfigure(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        boolean z = false;
        this.mOnlyAllowReadOnlyOperations = false;
        int size = sQLiteDatabaseConfiguration.customFunctions.size();
        for (int i2 = 0; i2 < size; i2++) {
            SQLiteCustomFunction sQLiteCustomFunction = sQLiteDatabaseConfiguration.customFunctions.get(i2);
            if (!this.mConfiguration.customFunctions.contains(sQLiteCustomFunction)) {
                nativeRegisterCustomFunction(this.mConnectionPtr, sQLiteCustomFunction);
            }
        }
        boolean z2 = sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled != this.mConfiguration.foreignKeyConstraintsEnabled;
        if (((sQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags) & 536870912) != 0) {
            z = true;
        }
        boolean z3 = !sQLiteDatabaseConfiguration.locale.equals(this.mConfiguration.locale);
        this.mConfiguration.updateParametersFrom(sQLiteDatabaseConfiguration);
        if (z2) {
            setForeignKeyModeFromConfiguration();
        }
        if (z) {
            setWalModeFromConfiguration();
        }
        if (z3) {
            setLocaleFromConfiguration();
        }
    }

    public void setOnlyAllowReadOnlyOperations(boolean z) {
        this.mOnlyAllowReadOnlyOperations = z;
    }

    public String toString() {
        return "SQLiteConnection: " + this.mConfiguration.path + " (" + this.mConnectionId + ")";
    }

    private void open() {
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfiguration;
        this.mConnectionPtr = nativeOpen(sQLiteDatabaseConfiguration.path, sQLiteDatabaseConfiguration.openFlags, sQLiteDatabaseConfiguration.label, SQLiteDebug.DEBUG_SQL_STATEMENTS, SQLiteDebug.DEBUG_SQL_TIME);
        setPageSize();
        setForeignKeyModeFromConfiguration();
        setJournalSizeLimit();
        setAutoCheckpointInterval();
        if (!nativeHasCodec()) {
            setWalModeFromConfiguration();
            setLocaleFromConfiguration();
        }
        int size = this.mConfiguration.customFunctions.size();
        for (int i2 = 0; i2 < size; i2++) {
            nativeRegisterCustomFunction(this.mConnectionPtr, this.mConfiguration.customFunctions.get(i2));
        }
    }
}
