package com.baidu.netdisk.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public interface IContentProvider extends IOpenable {
    int bulkInsert(int i2, ContentResolver contentResolver, SQLiteDatabase sQLiteDatabase, Uri uri, ContentValues[] contentValuesArr);

    int delete(int i2, ContentResolver contentResolver, SQLiteDatabase sQLiteDatabase, Uri uri, String str, String[] strArr);

    Uri insert(int i2, ContentResolver contentResolver, SQLiteDatabase sQLiteDatabase, Uri uri, ContentValues contentValues);

    boolean isNeedNotifyUI(int i2);

    void onBuildUriMatch(String str, UriMatcher uriMatcher);

    void onDeleteNotify(int i2, ContentResolver contentResolver, Uri uri);

    void onInsertNotify(int i2, ContentResolver contentResolver, Uri uri, ContentValues contentValues);

    void onUpdateNotify(int i2, ContentResolver contentResolver, Uri uri, ContentValues contentValues);

    Cursor query(int i2, ContentResolver contentResolver, SQLiteDatabase sQLiteDatabase, Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    int update(int i2, ContentResolver contentResolver, SQLiteDatabase sQLiteDatabase, Uri uri, ContentValues contentValues, String str, String[] strArr);
}
