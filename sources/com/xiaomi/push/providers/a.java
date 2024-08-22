package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.channel.commonutils.logger.b;

public class a extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static int f7501a = 1;

    /* renamed from: a  reason: collision with other field name */
    public static final Object f901a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f902a = {"package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT"};

    public a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, f7501a);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f901a) {
            try {
                a(sQLiteDatabase);
            } catch (SQLException e2) {
                b.a((Throwable) e2);
            }
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        int i2 = 0;
        while (true) {
            String[] strArr = f902a;
            if (i2 < strArr.length - 1) {
                if (i2 != 0) {
                    sb.append(",");
                }
                sb.append(strArr[i2]).append(" ").append(strArr[i2 + 1]);
                i2 += 2;
            } else {
                sb.append(");");
                sQLiteDatabase.execSQL(sb.toString());
                return;
            }
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
