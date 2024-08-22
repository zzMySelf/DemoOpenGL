package com.baidu.netdisk.transfer.storage.db.upload;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.baidu.netdisk.db.LinkableVersion;
import com.baidu.netdisk.db.Table;
import com.baidu.netdisk.db.View;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.transfer.storage.db.TransferContract;

class Version7120 extends LinkableVersion {
    private static final String TAG = "Version7120";

    Version7120() {
    }

    public void onHandle(SQLiteDatabase database) {
        SQLiteDatabase sQLiteDatabase = database;
        Table table = new Table(Tables.TASKS);
        try {
            table.addColumn("quality", "INTEGER").alter(sQLiteDatabase);
        } catch (SQLiteException e2) {
            NetDiskLog.w(TAG, "升级失败", e2);
        }
        new View(Views.PROCESSING_TASKS).drop(sQLiteDatabase).select("_id", "state", TransferContract.TasksColumns.OFFSET_SIZE, "size", "local_url", "rate", "priority", "date", TransferContract.UploadTasks.NEED_OVERRIDE, "quality", TransferContract.UploadTasks.UPLOAD_ID).from(table).where("state=100 OR state=104 OR state=105").create(sQLiteDatabase);
        new View(Views.FAILED_TASKS).drop(sQLiteDatabase).select("_id", TransferContract.TasksColumns.EXTRA_INFO_NUM, "local_url", TransferContract.TasksColumns.REMOTE_URL, TransferContract.UploadTasks.NEED_OVERRIDE, "type", "quality", TransferContract.UploadTasks.UPLOAD_ID).from(table).where("state=106").create(sQLiteDatabase);
    }
}
