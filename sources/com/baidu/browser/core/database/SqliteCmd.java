package com.baidu.browser.core.database;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.browser.core.database.callback.BdDbCallBack;

public abstract class SqliteCmd {
    protected Class<? extends BdDbDataModel> mModule;

    public abstract void excute(BdDbCallBack bdDbCallBack);

    public abstract void toSql();

    /* access modifiers changed from: package-private */
    public Class<? extends BdDbDataModel> getModule() {
        return this.mModule;
    }

    /* access modifiers changed from: package-private */
    public long excuteOnDb(SQLiteDatabase aDb) {
        return -1;
    }
}
