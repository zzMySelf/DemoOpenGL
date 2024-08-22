package com.baidu.down.request.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.request.taskmanager.DatabaseMng;

public class DownloadDatabaseHelper extends SQLiteOpenHelper {
    public DownloadDatabaseHelper(Context context) {
        super(context, DatabaseMng.DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        createDownloadsTable(db);
    }

    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        for (int version = oldV + 1; version <= newV; version++) {
            upgradeTo(db, version);
        }
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        createDownloadsTable(db);
    }

    private void upgradeTo(SQLiteDatabase db, int version) {
        switch (version) {
            case 2:
                addColumn(db, "downloads", DownloadDataConstants.Columns.COLUMN_PROGRESS_MAP, "TEXT");
                return;
            default:
                throw new IllegalStateException("Don't know how to upgrade to " + version);
        }
    }

    private void addColumn(SQLiteDatabase db, String dbTable, String columnName, String columnDefinition) {
        db.execSQL("ALTER TABLE " + dbTable + " ADD COLUMN " + columnName + " " + columnDefinition);
    }

    private void createDownloadsTable(SQLiteDatabase db) {
        try {
            db.execSQL("DROP TABLE IF EXISTS downloads");
            db.execSQL("CREATE TABLE downloads(_id INTEGER PRIMARY KEY AUTOINCREMENT,uri TEXT, name TEXT, path TEXT, data TEXT, mimetype TEXT, etag TEXT, tasktype INTEGER, status INTEGER DEFAULT 0, lastmodification BIGINT DEFAULT " + System.currentTimeMillis() + ", " + "total_bytes" + " BIGINT DEFAULT 0, " + "current_bytes" + " BIGINT DEFAULT 0, " + DownloadDataConstants.Columns.COLUMN_PROGRESS_MAP + " TEXT, " + "retry_count" + " INTEGER DEFAULT 0);");
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
