package com.baidu.searchbox.favor.sync.account.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.favor.ioc.FavorCoreRuntime;
import com.baidu.searchbox.favor.sync.business.favor.db.FavorDbControl;

public abstract class BaseAccountDBHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 303;
    private static final int DB_VERSION_200 = 200;
    private static final int DB_VERSION_201 = 201;
    private static final int DB_VERSION_202 = 202;
    private static final int DB_VERSION_300 = 300;
    private static final int DB_VERSION_301 = 301;
    private static final int DB_VERSION_302 = 302;
    private static final int DB_VERSION_303 = 303;

    protected BaseAccountDBHelper(Context context, String uid) {
        super(context, uid + FavorCoreRuntime.getFavorDBImpl().getDBSuffixName(), (SQLiteDatabase.CursorFactory) null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        FavorDbControl.createFavorTable(db);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (int version = oldVersion; version < newVersion; version++) {
            switch (version) {
                case 200:
                    FavorDbControl.cleanDirtyFavorData(db);
                    break;
                case 300:
                    FavorDbControl.createFavorTable(db);
                    break;
                case 301:
                    FavorDbControl.addOriginalTitleColumn(db);
                    break;
                case 302:
                    FavorDbControl.addRecycleTypeColumn(db);
                    break;
            }
        }
    }
}
