package com.baidu.searchbox.history.core.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.fileviewer.activity.FileViewerActivity;

public class HistoryDBControl {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String INTEGER_NOT_NULL = "INTEGER NOT NULL";
    public static int MAX_HISTORY_COUNT = 0;
    public static final String NOT_NULL = "NOT NULL";
    public static final String TABLE_NAME = "history";
    private static final String TAG = "HistoryDBControl";
    public static final String TEXT = "TEXT";
    public static final String TEXT_NOT_NULL = "TEXT NOT NULL";
    private static volatile HistoryDBControl sInstance;
    private HistorySQLiteOpenHelper mDbHelper;

    static {
        MAX_HISTORY_COUNT = 1000;
        if (Build.VERSION.SDK_INT >= 28) {
            MAX_HISTORY_COUNT = 2000;
        }
    }

    private HistoryDBControl(Context context) {
        this.mDbHelper = new HistorySQLiteOpenHelper(context, this);
    }

    static HistoryDBControl getInstance(Context context) {
        if (sInstance == null) {
            synchronized (HistoryDBControl.class) {
                if (sInstance == null) {
                    sInstance = new HistoryDBControl(context);
                }
            }
        }
        return sInstance;
    }

    /* access modifiers changed from: package-private */
    public String[] buildCreateTableColumnStr() {
        return new String[]{"_id INTEGER PRIMARY KEY AUTOINCREMENT", HistoryTable.ukey.name() + " " + "TEXT NOT NULL", HistoryTable.tplid.name() + " " + "TEXT", HistoryTable.title.name() + " " + "TEXT", HistoryTable.originaltitle.name() + " " + "TEXT", HistoryTable.img.name() + " " + "TEXT", HistoryTable.url.name() + " " + "TEXT", HistoryTable.cmd.name() + " " + "TEXT", HistoryTable.feature.name() + " " + "TEXT", HistoryTable.tts.name() + " " + "TEXT", HistoryTable.createtime.name() + " " + "INTEGER NOT NULL" + " DEFAULT 0", HistoryTable.extra.name() + " " + "TEXT", HistoryTable.isShowFeedback.name() + " " + "TEXT", HistoryTable.isShowGuarantee.name() + " " + "TEXT", HistoryTable.isShowServiceRate.name() + " " + "TEXT", HistoryTable.status.name() + " " + "INTEGER NOT NULL" + " DEFAULT " + 0, HistoryTable.visitTime.name() + " " + "INTEGER NOT NULL" + " DEFAULT 0", HistoryTable.visitCount.name() + " " + "INTEGER NOT NULL" + " DEFAULT 0", "UNIQUE(" + HistoryTable.ukey.name() + ") ON CONFLICT REPLACE"};
    }

    /* access modifiers changed from: package-private */
    public void createTriggers(SQLiteDatabase db) {
        if (db != null) {
            try {
                db.execSQL("DROP TRIGGER IF EXISTS delete_old_visit_history");
                db.execSQL("CREATE TRIGGER delete_old_visit_history AFTER INSERT ON history WHEN (select count(*) from history WHERE status=0)>" + MAX_HISTORY_COUNT + " BEGIN  DELETE FROM " + "history" + " WHERE _id IN (SELECT _id FROM  " + "history" + " WHERE status=0 ORDER BY " + HistoryTable.createtime.name() + " LIMIT (SELECT count(*) -" + MAX_HISTORY_COUNT + " FROM " + "history" + " WHERE status=0)); END;");
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void deleteTableIfExist(SQLiteDatabase db, String tableName) {
        if (db != null && !TextUtils.isEmpty(tableName) && tableIsExits(db, tableName)) {
            try {
                db.execSQL("DROP TABLE " + tableName);
            } catch (Exception e2) {
                if (DEBUG) {
                    Log.e(TAG, "createTableIfNotExist", e2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void createTableIfNotExist(SQLiteDatabase db) {
        if (db != null) {
            String[] columnInfoStrs = buildCreateTableColumnStr();
            if (columnInfoStrs != null && columnInfoStrs.length != 0) {
                StringBuilder sqlBuilder = new StringBuilder();
                sqlBuilder.append("CREATE TABLE IF NOT EXISTS ").append("history").append(FileViewerActivity.LEFT_BRACKET);
                boolean isFirstColumn = true;
                for (String columnInfoStr : columnInfoStrs) {
                    if (isFirstColumn) {
                        sqlBuilder.append(" ");
                        isFirstColumn = false;
                    } else {
                        sqlBuilder.append(", ");
                    }
                    sqlBuilder.append(columnInfoStr);
                }
                sqlBuilder.append(");");
                String sqlStr = sqlBuilder.toString();
                if (DEBUG) {
                    Log.i(TAG, "createTableIfNotExist: sqlStr=" + sqlStr);
                }
                try {
                    db.execSQL(sqlStr);
                } catch (Exception e2) {
                    if (DEBUG) {
                        Log.e(TAG, "createTableIfNotExist", e2);
                    }
                }
            } else if (DEBUG) {
                Log.e(TAG, "createTableIfNotExist: columnInfoStrs is empty.");
            }
        } else if (DEBUG) {
            Log.w(TAG, "createTableIfNotExist: db is null.");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean tableIsExits(SQLiteDatabase db, String tableName) {
        if (db == null || TextUtils.isEmpty(tableName)) {
            return false;
        }
        boolean exits = false;
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("select count(*) as c from sqlite_master where type ='table' and name='" + tableName + "';", (String[]) null);
            if (cursor.moveToNext() && cursor.getInt(0) > 0) {
                exits = true;
            }
        } catch (SQLiteFullException e2) {
        } catch (Throwable th2) {
            Closeables.closeSafely((Cursor) null);
            throw th2;
        }
        Closeables.closeSafely(cursor);
        return exits;
    }

    /* access modifiers changed from: package-private */
    public SQLiteDatabase getReadableDatabase() {
        return this.mDbHelper.getReadableDatabase();
    }

    /* access modifiers changed from: package-private */
    public SQLiteDatabase getWritableDatabase() {
        return this.mDbHelper.getWritableDatabase();
    }
}
