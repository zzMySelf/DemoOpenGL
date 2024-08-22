package org.sqlite.database.sqlite;

import android.os.StatFs;

public final class SQLiteGlobal {
    public static final String TAG = "SQLiteGlobal";
    public static int sDefaultPageSize;
    public static final Object sLock = new Object();

    public static String getDefaultJournalMode() {
        return "delete";
    }

    public static int getDefaultPageSize() {
        synchronized (sLock) {
            if (sDefaultPageSize == 0) {
                sDefaultPageSize = new StatFs("/data").getBlockSize();
            }
        }
        return 1024;
    }

    public static String getDefaultSyncMode() {
        return "normal";
    }

    public static int getJournalSizeLimit() {
        return 10000;
    }

    public static int getWALAutoCheckpoint() {
        return Math.max(1, 1000);
    }

    public static int getWALConnectionPoolSize() {
        return Math.max(2, 10);
    }

    public static String getWALSyncMode() {
        return "normal";
    }

    public static native int nativeReleaseMemory();

    public static int releaseMemory() {
        return nativeReleaseMemory();
    }
}
