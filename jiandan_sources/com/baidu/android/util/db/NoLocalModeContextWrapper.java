package com.baidu.android.util.db;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;

@Deprecated
public final class NoLocalModeContextWrapper extends ContextWrapper {
    public NoLocalModeContextWrapper(Context context) {
        super(context);
    }

    @SuppressLint({"InlinedApi"})
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, SQLiteDatabase.CursorFactory cursorFactory) {
        return super.openOrCreateDatabase(str, i2 | 16, cursorFactory);
    }

    @SuppressLint({"InlinedApi"})
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return super.openOrCreateDatabase(str, i2 | 16, cursorFactory, databaseErrorHandler);
    }
}
