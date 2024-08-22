package com.yy.open.log;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

final class DBLogManager extends SQLiteOpenHelper {
    private static final String DB_NAME = "udbauthlooog";
    private static final int DB_VERSION = 1;
    private static final String F_DATA = "dd";
    private static final String F_ID = "id";
    private static final String F_TIME = "time";
    private static final int MAX_ATTEMPT_TIMES = 3;
    private static final String TABLE_NAME = "looog";

    DBLogManager(Context context) {
        this(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    private DBLogManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void onCreate(SQLiteDatabase db) {
        createTable(db);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        createTable(db);
    }

    private void createTable(SQLiteDatabase db) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ").append(TABLE_NAME).append(" (");
            sb.append("id").append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append("dd").append(" TEXT, ");
            sb.append("time").append(" INTEGER ) ");
            db.execSQL(sb.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void insert(String data) {
        if (data != null) {
            try {
                if (data.length() > 0) {
                    ContentValues values = new ContentValues();
                    values.put("dd", data);
                    values.put("time", 0);
                    getWritableDatabase().insert(TABLE_NAME, (String) null, values);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void delete(int id) {
        try {
            getWritableDatabase().delete(TABLE_NAME, String.format(Locale.getDefault(), "%s=%d", new Object[]{"id", Integer.valueOf(id)}), (String[]) null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void increaseAttemptTimes(int id) {
        try {
            Cursor cursor = getWritableDatabase().rawQuery(String.format(Locale.getDefault(), "select %s from %s where %s=%d", new Object[]{"time", TABLE_NAME, "id", Integer.valueOf(id)}), new String[0]);
            int times = -1;
            if (cursor.moveToFirst()) {
                times = cursor.getInt(cursor.getColumnIndex("time"));
            }
            cursor.close();
            if (times != -1) {
                if (times >= 3) {
                    delete(id);
                    return;
                }
                getWritableDatabase().execSQL(String.format(Locale.getDefault(), "update %s set %s=%s+1 where %s=%d", new Object[]{TABLE_NAME, "time", "time", "id", Integer.valueOf(id)}));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public List<DataInfo> queryAll() {
        try {
            Cursor cursor = getReadableDatabase().rawQuery(String.format("select * from %s ", new Object[]{TABLE_NAME}), new String[0]);
            List<DataInfo> results = new ArrayList<>();
            while (cursor.moveToNext()) {
                DataInfo i2 = new DataInfo();
                i2.id = cursor.getInt(cursor.getColumnIndex("id"));
                i2.data = cursor.getString(cursor.getColumnIndex("dd"));
                results.add(i2);
            }
            cursor.close();
            return results;
        } catch (Exception e2) {
            e2.printStackTrace();
            return new ArrayList();
        }
    }

    static class DataInfo {
        String data;
        int id;

        DataInfo() {
        }
    }
}
