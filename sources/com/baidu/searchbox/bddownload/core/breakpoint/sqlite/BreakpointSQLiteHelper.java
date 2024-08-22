package com.baidu.searchbox.bddownload.core.breakpoint.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.SparseArray;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.exception.SQLiteException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class BreakpointSQLiteHelper extends SQLiteOpenHelper {
    private static final String BLOCK_TABLE_NAME = "block";
    private static final String BREAKPOINT_TABLE_NAME = "breakpoint";
    private static final String NAME = "bddownload-breakpoint.db";
    private static final String RESPONSE_FILENAME_TABLE_NAME = "bddownloadResponseFilename";
    static final String TASK_FILE_DIRTY_TABLE_NAME = "taskFileDirty";
    private static final int VERSION = 3;

    public BreakpointSQLiteHelper(Context context) {
        super(context, NAME, (SQLiteDatabase.CursorFactory) null, 3);
    }

    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (Build.VERSION.SDK_INT >= 16) {
            setWriteAheadLoggingEnabled(true);
        } else {
            db.enableWriteAheadLogging();
        }
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS breakpoint( id INTEGER PRIMARY KEY, url VARCHAR NOT NULL, etag VARCHAR, MIME_type VARCHAR, parent_path VARCHAR NOT NULL, filename VARCHAR, task_only_parent_path TINYINT(1) DEFAULT 0, chunked TINYINT(1) DEFAULT 0)");
        db.execSQL("CREATE TABLE IF NOT EXISTS block( id INTEGER PRIMARY KEY AUTOINCREMENT, breakpoint_id INTEGER, block_index INTEGER, start_offset INTEGER, content_length INTEGER, current_offset INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS bddownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1 && newVersion == 2) {
            db.execSQL("CREATE TABLE IF NOT EXISTS bddownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        }
        if (oldVersion <= 2) {
            db.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
        }
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void markFileDirty(int id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues(1);
        values.put("id", Integer.valueOf(id));
        db.insert(TASK_FILE_DIRTY_TABLE_NAME, (String) null, values);
    }

    public void markFileClear(int id) {
        getWritableDatabase().delete(TASK_FILE_DIRTY_TABLE_NAME, "id = ?", new String[]{String.valueOf(id)});
    }

    public List<Integer> loadDirtyFileList() {
        List<Integer> dirtyFileList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery("SELECT * FROM taskFileDirty", (String[]) null);
            while (cursor.moveToNext()) {
                dirtyFileList.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
            }
            return dirtyFileList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public SparseArray<BreakpointInfo> loadToCache() {
        Cursor breakpointCursor = null;
        Cursor blockCursor = null;
        SQLiteDatabase db = getWritableDatabase();
        List<BreakpointInfoRow> breakpointInfoRows = new ArrayList<>();
        List<BlockInfoRow> blockInfoRows = new ArrayList<>();
        try {
            breakpointCursor = db.rawQuery("SELECT * FROM breakpoint", (String[]) null);
            while (breakpointCursor.moveToNext()) {
                breakpointInfoRows.add(new BreakpointInfoRow(breakpointCursor));
            }
            blockCursor = db.rawQuery("SELECT * FROM block", (String[]) null);
            while (blockCursor.moveToNext()) {
                blockInfoRows.add(new BlockInfoRow(blockCursor));
            }
            SparseArray<BreakpointInfo> breakpointInfoMap = new SparseArray<>();
            for (BreakpointInfoRow infoRow : breakpointInfoRows) {
                BreakpointInfo info = infoRow.toInfo();
                Iterator<BlockInfoRow> blockIt = blockInfoRows.iterator();
                while (blockIt.hasNext()) {
                    BlockInfoRow blockInfoRow = blockIt.next();
                    if (blockInfoRow.getBreakpointId() == info.getId()) {
                        info.addBlock(blockInfoRow.toInfo());
                        blockIt.remove();
                    }
                }
                breakpointInfoMap.put(info.getId(), info);
            }
            return breakpointInfoMap;
        } finally {
            if (breakpointCursor != null) {
                breakpointCursor.close();
            }
            if (blockCursor != null) {
                blockCursor.close();
            }
        }
    }

    public HashMap<String, String> loadResponseFilenameToMap() {
        Cursor cursor = null;
        SQLiteDatabase db = getWritableDatabase();
        HashMap<String, String> urlFilenameMap = new HashMap<>();
        try {
            cursor = db.rawQuery("SELECT * FROM bddownloadResponseFilename", (String[]) null);
            while (cursor.moveToNext()) {
                urlFilenameMap.put(cursor.getString(cursor.getColumnIndex("url")), cursor.getString(cursor.getColumnIndex("filename")));
            }
            return urlFilenameMap;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 7 */
    public synchronized void updateFilename(String url, String filename) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues(2);
        values.put("url", url);
        values.put("filename", filename);
        Cursor c2 = null;
        try {
            c2 = db.rawQuery("SELECT filename FROM bddownloadResponseFilename WHERE url = ?", new String[]{url});
            if (!c2.moveToFirst()) {
                db.insert(RESPONSE_FILENAME_TABLE_NAME, (String) null, values);
            } else if (!filename.equals(c2.getString(c2.getColumnIndex("filename")))) {
                db.replace(RESPONSE_FILENAME_TABLE_NAME, (String) null, values);
            }
        } finally {
            if (c2 != null) {
                c2.close();
            }
        }
    }

    public void insert(SQLiteDatabase db, BreakpointInfo info) throws IOException {
        int blockCount = info.getBlockCount();
        int i2 = 0;
        while (i2 < blockCount) {
            BlockInfo blockInfo = info.getBlock(i2);
            if (db.insert("block", (String) null, toValues(info.getId(), i2, blockInfo)) != -1) {
                i2++;
            } else {
                throw new SQLiteException("insert block " + blockInfo + " failed!");
            }
        }
        if (db.insert(BREAKPOINT_TABLE_NAME, (String) null, toValues(info)) == -1) {
            throw new SQLiteException("insert info " + info + " failed!");
        }
    }

    public void insert(BreakpointInfo info) throws IOException {
        int blockCount = info.getBlockCount();
        SQLiteDatabase db = getWritableDatabase();
        int i2 = 0;
        while (i2 < blockCount) {
            BlockInfo blockInfo = info.getBlock(i2);
            if (db.insert("block", (String) null, toValues(info.getId(), i2, blockInfo)) != -1) {
                i2++;
            } else {
                throw new SQLiteException("insert block " + blockInfo + " failed!");
            }
        }
        if (db.insert(BREAKPOINT_TABLE_NAME, (String) null, toValues(info)) == -1) {
            throw new SQLiteException("insert info " + info + " failed!");
        }
    }

    public void updateBlockIncrease(BreakpointInfo info, int blockIndex, long newCurrentOffset) {
        ContentValues values = new ContentValues();
        values.put(BreakpointSQLiteKey.CURRENT_OFFSET, Long.valueOf(newCurrentOffset));
        getWritableDatabase().update("block", values, "breakpoint_id = ? AND block_index = ?", new String[]{Integer.toString(info.getId()), Integer.toString(blockIndex)});
    }

    public void updateInfo(BreakpointInfo info) throws IOException {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = null;
        db.beginTransaction();
        try {
            cursor = db.rawQuery("SELECT id FROM breakpoint WHERE id =" + info.getId() + " LIMIT 1", (String[]) null);
            if (cursor.moveToNext()) {
                removeInfo(db, info.getId());
                insert(db, info);
                db.setTransactionSuccessful();
                if (cursor != null) {
                    cursor.close();
                }
                db.endTransaction();
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.endTransaction();
        }
    }

    public void removeInfo(int id) {
        getWritableDatabase().delete(BREAKPOINT_TABLE_NAME, "id = ?", new String[]{String.valueOf(id)});
        removeBlock(id);
    }

    public void removeInfo(SQLiteDatabase db, int id) {
        db.delete(BREAKPOINT_TABLE_NAME, "id = ?", new String[]{String.valueOf(id)});
        removeBlock(db, id);
    }

    public void removeBlock(SQLiteDatabase db, int breakpointId) {
        db.delete("block", "breakpoint_id = ?", new String[]{String.valueOf(breakpointId)});
    }

    public void removeBlock(int breakpointId) {
        getWritableDatabase().delete("block", "breakpoint_id = ?", new String[]{String.valueOf(breakpointId)});
    }

    private static ContentValues toValues(BreakpointInfo info) {
        ContentValues values = new ContentValues();
        values.put("id", Integer.valueOf(info.getId()));
        values.put("url", info.getUrl());
        values.put("etag", info.getEtag());
        values.put(BreakpointSQLiteKey.MIME_TYPE, info.getMimeType());
        values.put("parent_path", info.getParentFile().getAbsolutePath());
        values.put("filename", info.getFilename());
        values.put(BreakpointSQLiteKey.TASK_ONLY_PARENT_PATH, Integer.valueOf(info.isTaskOnlyProvidedParentPath() ? 1 : 0));
        values.put("chunked", Integer.valueOf(info.isChunked() ? 1 : 0));
        return values;
    }

    private static ContentValues toValues(int breakpointId, int index, BlockInfo info) {
        ContentValues values = new ContentValues();
        values.put(BreakpointSQLiteKey.HOST_ID, Integer.valueOf(breakpointId));
        values.put(BreakpointSQLiteKey.BLOCK_INDEX, Integer.valueOf(index));
        values.put(BreakpointSQLiteKey.START_OFFSET, Long.valueOf(info.getStartOffset()));
        values.put("content_length", Long.valueOf(info.getContentLength()));
        values.put(BreakpointSQLiteKey.CURRENT_OFFSET, Long.valueOf(info.getCurrentOffset()));
        return values;
    }
}
