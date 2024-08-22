package com.baidu.searchbox.feed.db;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.baidu.searchbox.feed.FeedRuntime;

public abstract class SQLiteTransaction {
    private static final boolean DEBUG = FeedRuntime.GLOBAL_DEBUG;
    private static final String TAG = "SQLiteTransaction";
    private boolean mTransactionSuccess = false;

    /* access modifiers changed from: protected */
    public abstract boolean performTransaction(SQLiteDatabase sQLiteDatabase);

    /* Debug info: failed to restart local var, previous not found, register: 3 */
    public void run(SQLiteDatabase db) {
        this.mTransactionSuccess = false;
        db.beginTransaction();
        try {
            if (performTransaction(db)) {
                db.setTransactionSuccessful();
                this.mTransactionSuccess = true;
            }
            try {
                db.endTransaction();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (RuntimeException e2) {
            if (!DEBUG) {
                Log.e("SQLiteTransaction", "SQLiteTransaction.run()", e2);
                db.endTransaction();
                return;
            }
            throw e2;
        } catch (Throwable th2) {
            try {
                db.endTransaction();
            } catch (SQLException ex2) {
                ex2.printStackTrace();
            }
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isTransactionSuccess() {
        return this.mTransactionSuccess;
    }
}
