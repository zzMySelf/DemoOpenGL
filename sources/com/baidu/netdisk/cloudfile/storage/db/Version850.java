package com.baidu.netdisk.cloudfile.storage.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.baidu.netdisk.db.LinkableVersion;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;

public class Version850 extends LinkableVersion {
    private static final String TAG = "Version850";

    public void onHandle(SQLiteDatabase database) {
        recreateParentPathIndex(database);
    }

    private void recreateParentPathIndex(SQLiteDatabase db) {
        try {
            db.execSQL("DROP INDEX IF EXISTS PARENT_PATH");
            db.execSQL("CREATE INDEX IF NOT EXISTS PARENT_PATH ON cachefilelist(parent_path COLLATE NOCASE)");
        } catch (SQLiteException e2) {
            NetDiskLog.w(TAG, e2.getMessage(), e2);
        }
    }
}
