package com.baidu.searchbox.video;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import java.util.ArrayList;
import java.util.List;

public class LocalVideoDbUtil {
    private static final int BLACKLIST_ITEM_MAX_NUM = 2000;
    private static final String ID_TABLE_NAME = "sqlite_sequence";
    private static final String TAG = "LocalVideoUtil";
    private final LocalVideoDbHelper databaseHelper;

    public LocalVideoDbUtil(Context context) {
        this.databaseHelper = new LocalVideoDbHelper(context);
    }

    private void insertItem(SQLiteDatabase db, LocalVideoItem item) {
        if (db != null && item != null) {
            try {
                ContentValues cv = new ContentValues();
                cv.put("video_path", item.getLocalVideoPath());
                db.insertOrThrow(LocalVideoItemsTable.TABLE_NAME, (String) null, cv);
            } catch (SQLiteConstraintException e2) {
                Log.w(TAG, "insertItem failed: " + e2);
                e2.printStackTrace();
            }
        }
    }

    public void insertBlacklistItems(List<LocalVideoItem> items) {
        if (items != null && items.size() != 0) {
            SQLiteDatabase db = this.databaseHelper.getWritableDatabase();
            db.beginTransaction();
            try {
                int endID = getRemoveBlacklistItemEndID(db, items.size());
                if (endID > 0) {
                    db.delete(LocalVideoBlacklistItemsTable.TABLE_NAME, "_id <='" + endID + "'", (String[]) null);
                }
                for (int i2 = 0; i2 < items.size(); i2++) {
                    insertBlacklistItem(db, items.get(i2));
                }
                db.setTransactionSuccessful();
            } catch (SQLException sqlException) {
                Log.w(TAG, "insertBlacklistItems failed: " + sqlException);
                sqlException.printStackTrace();
            } catch (Throwable th2) {
                db.endTransaction();
                throw th2;
            }
            db.endTransaction();
        }
    }

    private int getRemoveBlacklistItemEndID(SQLiteDatabase db, int insertCount) {
        Cursor cursor = null;
        try {
            cursor = db.query(LocalVideoBlacklistItemsTable.TABLE_NAME, LocalVideoBlacklistItemsTable.getAllColumns(), (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
            if (cursor == null) {
                return -1;
            }
            int count = cursor.getCount();
            if (count + insertCount < 2000) {
                Closeables.closeSafely(cursor);
                return -1;
            }
            int midIndex = ((count + insertCount) - 1000) - 1;
            if (midIndex < 0) {
                midIndex = 0;
            } else if (midIndex >= count) {
                midIndex = count - 1;
            }
            if (!cursor.moveToPosition(midIndex)) {
                Closeables.closeSafely(cursor);
                return -1;
            }
            int i2 = cursor.getInt(cursor.getColumnIndex("_id"));
            Closeables.closeSafely(cursor);
            return i2;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            return -1;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    private void insertBlacklistItem(SQLiteDatabase db, LocalVideoItem item) {
        if (db != null && item != null) {
            try {
                ContentValues cv = new ContentValues();
                cv.put(LocalVideoBlacklistItemsTable.BLACKLIST_VIDEO_PATH, item.getLocalVideoPath());
                db.insertOrThrow(LocalVideoBlacklistItemsTable.TABLE_NAME, (String) null, cv);
            } catch (SQLiteConstraintException e2) {
                Log.e(TAG, "insertBlacklistItem failed: " + e2);
                e2.printStackTrace();
            }
        }
    }

    public void insertItemsAfterDelete(List<LocalVideoItem> items) {
        if (items != null) {
            SQLiteDatabase db = this.databaseHelper.getWritableDatabase();
            db.beginTransaction();
            try {
                db.delete(LocalVideoItemsTable.TABLE_NAME, (String) null, (String[]) null);
                for (int i2 = 0; i2 < items.size(); i2++) {
                    insertItem(db, items.get(i2));
                }
                db.setTransactionSuccessful();
            } catch (SQLException sqlException) {
                Log.e(TAG, "insertItems failed: " + sqlException);
                sqlException.printStackTrace();
            } catch (Throwable th2) {
                db.endTransaction();
                throw th2;
            }
            db.endTransaction();
        }
    }

    public void deleteItems(List<LocalVideoItem> items) {
        if (items != null) {
            SQLiteDatabase db = this.databaseHelper.getWritableDatabase();
            db.beginTransaction();
            int i2 = 0;
            while (i2 < items.size()) {
                try {
                    deleteItem(db, items.get(i2));
                    i2++;
                } catch (SQLException sqlException) {
                    Log.e(TAG, "deleteItems failed: " + sqlException);
                    sqlException.printStackTrace();
                } catch (Throwable th2) {
                    db.endTransaction();
                    throw th2;
                }
            }
            db.setTransactionSuccessful();
            db.endTransaction();
        }
    }

    private void deleteItem(SQLiteDatabase db, LocalVideoItem item) {
        if (db != null && item != null) {
            db.delete(LocalVideoItemsTable.TABLE_NAME, "video_path='" + item.getLocalVideoPath() + "'", (String[]) null);
        }
    }

    public List<LocalVideoItem> queryLocalVideoItems() {
        return queryLocalVideoItemsCommon(LocalVideoItemsTable.TABLE_NAME, LocalVideoItemsTable.getAllColumns(), "video_path");
    }

    public List<LocalVideoItem> queryLocalVideoBlacklistItems() {
        return queryLocalVideoItemsCommon(LocalVideoBlacklistItemsTable.TABLE_NAME, LocalVideoBlacklistItemsTable.getAllColumns(), LocalVideoBlacklistItemsTable.BLACKLIST_VIDEO_PATH);
    }

    private List<LocalVideoItem> queryLocalVideoItemsCommon(String tableName, String[] allColumns, String queryColumn) {
        String videoPath;
        String str = queryColumn;
        int videoPathColumnIdx = findColumnIndex(allColumns, str);
        Cursor cursor = null;
        List<LocalVideoItem> resultList = new ArrayList<>();
        try {
            cursor = this.databaseHelper.getWritableDatabase().query(tableName, allColumns, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
            if (cursor == null) {
                Closeables.closeSafely(cursor);
                return resultList;
            }
            while (cursor.moveToNext()) {
                if (videoPathColumnIdx != -1) {
                    videoPath = cursor.getString(videoPathColumnIdx);
                } else {
                    videoPath = cursor.getString(cursor.getColumnIndex(str));
                }
                LocalVideoItem item = new LocalVideoItem();
                item.setLocalVideoPath(videoPath);
                resultList.add(item);
            }
            Closeables.closeSafely(cursor);
            String str2 = tableName;
            return resultList;
        } catch (SQLiteException sqlException) {
            Log.w(TAG, "queryItems failed: " + sqlException + " tableName: " + tableName);
            sqlException.printStackTrace();
            Closeables.closeSafely(cursor);
        } catch (Throwable th2) {
            th = th2;
            Closeables.closeSafely(cursor);
            throw th;
        }
    }

    private int findColumnIndex(String[] columns, String columnName) {
        for (int i2 = 0; i2 < columns.length; i2++) {
            if (columns[i2].equals(columnName)) {
                return i2;
            }
        }
        return -1;
    }
}
