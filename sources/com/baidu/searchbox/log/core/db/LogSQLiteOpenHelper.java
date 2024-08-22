package com.baidu.searchbox.log.core.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.log.core.db.dao.DBBIZ;
import com.baidu.searchbox.log.core.db.dao.DBFetch;
import com.baidu.searchbox.log.core.db.dao.DBLog;

public class LogSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "BaiduPerfLog.db";
    private static final int DATABASE_VERSION = 6;
    private static final int DATABASE_VERSION_1 = 1;
    private static final int DATABASE_VERSION_2 = 2;
    private static final int DATABASE_VERSION_3 = 3;
    private static final int DATABASE_VERSION_4 = 4;
    private static final int DATABASE_VERSION_5 = 5;
    private static final int DATABASE_VERSION_6 = 6;

    public LogSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 6);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBLog.LogEntry.SQL_CREATE_LOG_ENTRIES);
        onUpgrade(db, 1, 6);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (int i2 = oldVersion; i2 < newVersion; i2++) {
            switch (i2) {
                case 1:
                    updateLogToVersion2(db);
                    break;
                case 2:
                    createBIZTable(db);
                    break;
                case 3:
                    upgradeToVersion4(db);
                    break;
                case 4:
                    updateToVersion5(db);
                    break;
                case 5:
                    updateToVersion6(db);
                    break;
            }
        }
    }

    private static void updateLogToVersion2(SQLiteDatabase database) {
        database.execSQL("alter table log add isreal TEXT ");
        database.execSQL("alter table log add idtype TEXT ");
        database.execSQL("alter table log add timeout TEXT ");
        database.execSQL("alter table log add isAbtest TEXT ");
        database.execSQL("alter table log add temporary TEXT ");
        database.execSQL("alter table log add eventType TEXT ");
        database.execSQL("alter table log add fileSize INTEGER ");
    }

    private static void createBIZTable(SQLiteDatabase database) {
        database.execSQL(DBBIZ.BIZEntry.SQL_CREATE_BIZ_ENTRIES);
    }

    private static void upgradeToVersion4(SQLiteDatabase database) {
        database.execSQL("alter table log add isFetchBack TEXT ");
        database.execSQL(DBFetch.FetchEntry.SQL_CREATE_FETCH_ENTRIES);
    }

    private static void updateToVersion5(SQLiteDatabase database) {
        database.execSQL("alter table log add filemeta TEXT ");
    }

    private static void updateToVersion6(SQLiteDatabase database) {
        database.execSQL("alter table log add gflow TEXT ");
        database.execSQL("alter table biz add gflow TEXT ");
    }
}
