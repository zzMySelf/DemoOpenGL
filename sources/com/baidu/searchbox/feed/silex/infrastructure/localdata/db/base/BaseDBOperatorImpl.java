package com.baidu.searchbox.feed.silex.infrastructure.localdata.db.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.feed.silex.SilexRuntime;
import java.io.Closeable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public abstract class BaseDBOperatorImpl implements Closeable {
    public static final boolean DEBUG = SilexRuntime.GLOBAL_DEBUG;
    public static final String TAG = "Feed_DB";
    protected Executor mExecutor = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
    protected SQLiteOpenHelper mOpenHelper;

    public interface OnTransactionFinishedListener {
        void onFinished();
    }

    public BaseDBOperatorImpl(Context context) {
    }

    public void runTransactionAsync(SQLiteTransaction transaction) {
        runTransactionAsync(transaction, (OnTransactionFinishedListener) null);
    }

    public void runTransactionAsync(final SQLiteTransaction transaction, final OnTransactionFinishedListener listener) {
        this.mExecutor.execute(new Runnable() {
            public void run() {
                OnTransactionFinishedListener onTransactionFinishedListener;
                transaction.run(BaseDBOperatorImpl.this.mOpenHelper.getWritableDatabase());
                if (transaction.isTransactionSuccess() && (onTransactionFinishedListener = listener) != null) {
                    onTransactionFinishedListener.onFinished();
                }
            }
        });
    }

    public boolean runTransactionSyncWithReturn(SQLiteTransaction transaction) {
        SQLiteDatabase db = this.mOpenHelper.getWritableDatabase();
        db.beginTransaction();
        try {
            if (transaction.performTransaction(db)) {
                db.setTransactionSuccessful();
                db.endTransaction();
                return true;
            }
        } catch (Exception e2) {
        } catch (Throwable th2) {
            db.endTransaction();
            throw th2;
        }
        db.endTransaction();
        return false;
    }

    /* access modifiers changed from: protected */
    public void runTransactionSync(SQLiteTransaction transaction) {
        transaction.run(this.mOpenHelper.getWritableDatabase());
    }

    public void close() {
        SQLiteOpenHelper sQLiteOpenHelper = this.mOpenHelper;
        if (sQLiteOpenHelper != null) {
            sQLiteOpenHelper.close();
        }
    }
}
