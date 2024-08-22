package com.baidu.searchbox.discovery.novel.database.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.searchbox.NoProGuard;

public abstract class BaseDbModel implements NoProGuard {
    public abstract String getTableName();

    public abstract void loadFromCursor(Cursor cursor);

    public abstract ContentValues toContentValues();
}
