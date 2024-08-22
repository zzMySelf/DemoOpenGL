package com.baidu.down.request.taskmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.request.db.DownloadDatabaseHelper;

public class DatabaseMng {
    public static final String DB_NAME = "bddownloads.db";
    public static final int DB_VERSION = 1;
    public static final String DEFAULT_SORT_ORDER = "_id DESC";
    private Context mContext;
    private DownloadDatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    private DownloadDataConstants mDownLoad;

    public DatabaseMng(Context ctx) {
        this.mContext = ctx;
        DownloadDatabaseHelper downloadDatabaseHelper = new DownloadDatabaseHelper(ctx);
        this.mDBHelper = downloadDatabaseHelper;
        try {
            this.mDb = downloadDatabaseHelper.getWritableDatabase();
        } catch (SQLiteException e2) {
        }
        this.mDownLoad = new DownloadDataConstants(this.mContext);
    }

    public DownloadDataConstants getDownLoad() {
        return this.mDownLoad;
    }

    public SQLiteDatabase getSQLiteDatabase() {
        return this.mDb;
    }

    public long insertToDatabase(String uri, String filename, String fileDir, int taskType) {
        ContentValues values = new ContentValues();
        values.put("uri", uri);
        values.put("name", filename);
        values.put("path", fileDir);
        values.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(taskType));
        return this.mDownLoad.insert(this.mDb, values);
    }

    public long insert(ContentValues values) {
        return this.mDownLoad.insert(this.mDb, values);
    }

    public int delete(String where, String[] selectionArgs) {
        return this.mDownLoad.delete(this.mDb, where, selectionArgs);
    }

    public int update(ContentValues values, String where, String[] selectionArgs) {
        return this.mDownLoad.update(this.mDb, values, where, selectionArgs);
    }

    public Cursor query(String[] projection, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return this.mDownLoad.query(this.mDb, projection, selection, selectionArgs, groupBy, having, orderBy);
    }

    public int insertOrUpdate(ContentValues values) {
        return this.mDownLoad.insertOrUpdate(this.mDb, values);
    }
}
