package org.sqlite.database.sqlite;

import android.content.Context;
import java.io.File;
import org.sqlite.database.DatabaseErrorHandler;
import org.sqlite.database.sqlite.SQLiteDatabase;

public abstract class SQLiteOpenHelper {
    public static final boolean DEBUG_STRICT_READONLY = false;
    public static final String TAG = "SQLiteOpenHelper";
    public final Context mContext;
    public SQLiteDatabase mDatabase;
    public boolean mEnableWriteAheadLogging;
    public final DatabaseErrorHandler mErrorHandler;
    public final SQLiteDatabase.CursorFactory mFactory;
    public boolean mIsInitializing;
    public final int mMinimumSupportedVersion;
    public final String mName;
    public final int mNewVersion;

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        this(context, str, cursorFactory, i2, (DatabaseErrorHandler) null);
    }

    private SQLiteDatabase getDatabaseLocked(boolean z) {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null) {
            if (!sQLiteDatabase.isOpen()) {
                this.mDatabase = null;
            } else if (!z || !this.mDatabase.isReadOnly()) {
                return this.mDatabase;
            }
        }
        if (!this.mIsInitializing) {
            SQLiteDatabase sQLiteDatabase2 = this.mDatabase;
            try {
                this.mIsInitializing = true;
                if (sQLiteDatabase2 == null) {
                    sQLiteDatabase2 = this.mName == null ? SQLiteDatabase.create((SQLiteDatabase.CursorFactory) null) : SQLiteDatabase.openOrCreateDatabase(this.mName, this.mFactory, this.mErrorHandler);
                } else if (z && sQLiteDatabase2.isReadOnly()) {
                    sQLiteDatabase2.reopenReadWrite();
                }
            } catch (SQLiteException e) {
                if (!z) {
                    "Couldn't open " + this.mName + " for writing (will try read-only):";
                    sQLiteDatabase2 = SQLiteDatabase.openDatabase(this.mContext.getDatabasePath(this.mName).getPath(), this.mFactory, 1, this.mErrorHandler);
                } else {
                    throw e;
                }
            } catch (Throwable th2) {
                this.mIsInitializing = false;
                if (!(sQLiteDatabase2 == null || sQLiteDatabase2 == this.mDatabase)) {
                    sQLiteDatabase2.close();
                }
                throw th2;
            }
            onConfigure(sQLiteDatabase2);
            int version = sQLiteDatabase2.getVersion();
            if (version != this.mNewVersion) {
                if (sQLiteDatabase2.isReadOnly()) {
                    throw new SQLiteException("Can't upgrade read-only database from version " + sQLiteDatabase2.getVersion() + " to " + this.mNewVersion + ": " + this.mName);
                } else if (version <= 0 || version >= this.mMinimumSupportedVersion) {
                    sQLiteDatabase2.beginTransaction();
                    if (version == 0) {
                        onCreate(sQLiteDatabase2);
                    } else if (version > this.mNewVersion) {
                        onDowngrade(sQLiteDatabase2, version, this.mNewVersion);
                    } else {
                        onUpgrade(sQLiteDatabase2, version, this.mNewVersion);
                    }
                    sQLiteDatabase2.setVersion(this.mNewVersion);
                    sQLiteDatabase2.setTransactionSuccessful();
                    sQLiteDatabase2.endTransaction();
                } else {
                    File file = new File(sQLiteDatabase2.getPath());
                    onBeforeDelete(sQLiteDatabase2);
                    sQLiteDatabase2.close();
                    if (SQLiteDatabase.deleteDatabase(file)) {
                        this.mIsInitializing = false;
                        SQLiteDatabase databaseLocked = getDatabaseLocked(z);
                        this.mIsInitializing = false;
                        if (!(sQLiteDatabase2 == null || sQLiteDatabase2 == this.mDatabase)) {
                            sQLiteDatabase2.close();
                        }
                        return databaseLocked;
                    }
                    throw new IllegalStateException("Unable to delete obsolete database " + this.mName + " with version " + version);
                }
            }
            onOpen(sQLiteDatabase2);
            if (sQLiteDatabase2.isReadOnly()) {
                "Opened " + this.mName + " in read-only mode";
            }
            this.mDatabase = sQLiteDatabase2;
            this.mIsInitializing = false;
            if (!(sQLiteDatabase2 == null || sQLiteDatabase2 == sQLiteDatabase2)) {
                sQLiteDatabase2.close();
            }
            return sQLiteDatabase2;
        }
        throw new IllegalStateException("getDatabase called recursively");
    }

    public synchronized void close() {
        if (this.mIsInitializing) {
            throw new IllegalStateException("Closed during initialization");
        } else if (this.mDatabase != null && this.mDatabase.isOpen()) {
            this.mDatabase.close();
            this.mDatabase = null;
        }
    }

    public String getDatabaseName() {
        return this.mName;
    }

    public SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase databaseLocked;
        synchronized (this) {
            databaseLocked = getDatabaseLocked(false);
        }
        return databaseLocked;
    }

    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase databaseLocked;
        synchronized (this) {
            databaseLocked = getDatabaseLocked(true);
        }
        return databaseLocked;
    }

    public void onBeforeDelete(SQLiteDatabase sQLiteDatabase) {
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        throw new SQLiteException("Can't downgrade database from version " + i2 + " to " + i3);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3);

    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this) {
            if (this.mEnableWriteAheadLogging != z) {
                if (this.mDatabase != null && this.mDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
                    if (z) {
                        this.mDatabase.enableWriteAheadLogging();
                    } else {
                        this.mDatabase.disableWriteAheadLogging();
                    }
                }
                this.mEnableWriteAheadLogging = z;
            }
        }
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2, DatabaseErrorHandler databaseErrorHandler) {
        this(context, str, cursorFactory, i2, 0, databaseErrorHandler);
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2, int i3, DatabaseErrorHandler databaseErrorHandler) {
        if (i2 >= 1) {
            this.mContext = context;
            this.mName = str;
            this.mFactory = cursorFactory;
            this.mNewVersion = i2;
            this.mErrorHandler = databaseErrorHandler;
            this.mMinimumSupportedVersion = Math.max(0, i3);
            return;
        }
        throw new IllegalArgumentException("Version must be >= 1, was " + i2);
    }
}
