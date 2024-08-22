package com.baidu.browser.core.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.browser.core.database.callback.BdDbCallBack;
import java.util.List;

public class Update extends SqliteCmd {
    private BdDbCallBack mCallback;
    private List<Condition> mConditions = null;
    private ContentValues mValues;
    private String mWhere;
    private String[] mWhereArgs;

    public Update(Class<? extends BdDbDataModel> aModule) {
        this.mModule = aModule;
    }

    public Update set(ContentValues aValues) {
        this.mValues = aValues;
        return this;
    }

    public Update where(Condition aCondition) {
        if (aCondition == null) {
            return this;
        }
        this.mWhere = aCondition.toWhereCondition();
        this.mWhereArgs = new String[aCondition.getArgs().size()];
        aCondition.getArgs().copyInto(this.mWhereArgs);
        return this;
    }

    public Update where(List<Condition> aCondition) {
        this.mConditions = aCondition;
        return this;
    }

    public void toSql() {
    }

    public void excute(BdDbCallBack aCallBack) {
        this.mCallback = aCallBack;
        BdDbManager.getInstance().excuteSql(this, this.mModule);
    }

    /* access modifiers changed from: package-private */
    public long excuteOnDb(SQLiteDatabase aDb) {
        String name = BdDbManager.getInstance().getTableName(this.mModule);
        if (TextUtils.isEmpty(name)) {
            return 0;
        }
        int res = 0;
        try {
            BdDbCallBack bdDbCallBack = this.mCallback;
            if (bdDbCallBack != null) {
                bdDbCallBack.doPreTask();
            }
            List<Condition> list = this.mConditions;
            if (list == null || list.size() <= 0) {
                res = aDb.update(name, this.mValues, this.mWhere, this.mWhereArgs);
            } else {
                for (Condition condition : this.mConditions) {
                    where(condition);
                    res += aDb.update(name, this.mValues, this.mWhere, this.mWhereArgs);
                }
            }
            BdDbCallBack bdDbCallBack2 = this.mCallback;
            if (bdDbCallBack2 != null) {
                bdDbCallBack2.doOnTaskSucceed(res);
            }
        } catch (Exception e2) {
            Log.d("Update", "::excuteOnDb:" + e2);
            BdDbCallBack bdDbCallBack3 = this.mCallback;
            if (bdDbCallBack3 != null) {
                bdDbCallBack3.doOnTaskFailed(e2);
            }
        }
        return (long) res;
    }
}
