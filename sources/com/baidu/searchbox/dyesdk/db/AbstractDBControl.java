package com.baidu.searchbox.dyesdk.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.dyesdk.DyeLogUtils;
import com.baidu.swan.apps.network.WebSocketAction;
import java.io.Closeable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0002!\"B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H$J\"\u0010\u0016\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H$J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u001c\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0004J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0004J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/dyesdk/db/AbstractDBControl;", "Ljava/io/Closeable;", "context", "Landroid/content/Context;", "dbName", "", "dbVersion", "", "(Landroid/content/Context;Ljava/lang/String;I)V", "mExecutor", "Ljava/util/concurrent/Executor;", "getMExecutor", "()Ljava/util/concurrent/Executor;", "mOpenHelper", "Landroid/database/sqlite/SQLiteOpenHelper;", "getMOpenHelper", "()Landroid/database/sqlite/SQLiteOpenHelper;", "close", "", "onDBCreate", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onDBUpgrade", "oldVersion", "newVersion", "runTransactionAsync", "transaction", "Lcom/baidu/searchbox/dyesdk/db/SQLiteTransaction;", "listener", "Lcom/baidu/searchbox/dyesdk/db/AbstractDBControl$OnTransactionFinishedListener;", "runTransactionSync", "runTransactionSyncWithReturn", "", "DbOpenHelper", "OnTransactionFinishedListener", "lib-dye_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbstractDBControl.kt */
public abstract class AbstractDBControl implements Closeable {
    private final Executor mExecutor;
    private final SQLiteOpenHelper mOpenHelper;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/dyesdk/db/AbstractDBControl$OnTransactionFinishedListener;", "", "onFinished", "", "lib-dye_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AbstractDBControl.kt */
    public interface OnTransactionFinishedListener {
        void onFinished();
    }

    /* access modifiers changed from: protected */
    public abstract void onDBCreate(SQLiteDatabase sQLiteDatabase);

    /* access modifiers changed from: protected */
    public abstract void onDBUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3);

    public AbstractDBControl(Context context, String dbName, int dbVersion) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dbName, "dbName");
        ExecutorService logExecutor = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
        Intrinsics.checkNotNullExpressionValue(logExecutor, "newSingleThreadExecutor(logThreadFactory)");
        this.mExecutor = logExecutor;
        this.mOpenHelper = new DbOpenHelper(this, context, dbName, dbVersion);
    }

    /* access modifiers changed from: protected */
    public final Executor getMExecutor() {
        return this.mExecutor;
    }

    /* access modifiers changed from: protected */
    public final SQLiteOpenHelper getMOpenHelper() {
        return this.mOpenHelper;
    }

    /* access modifiers changed from: protected */
    public void runTransactionAsync(SQLiteTransaction transaction) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        runTransactionAsync(transaction, (OnTransactionFinishedListener) null);
    }

    public static /* synthetic */ void runTransactionAsync$default(AbstractDBControl abstractDBControl, SQLiteTransaction sQLiteTransaction, OnTransactionFinishedListener onTransactionFinishedListener, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                onTransactionFinishedListener = null;
            }
            abstractDBControl.runTransactionAsync(sQLiteTransaction, onTransactionFinishedListener);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: runTransactionAsync");
    }

    /* access modifiers changed from: protected */
    public final void runTransactionAsync(SQLiteTransaction transaction, OnTransactionFinishedListener listener) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        this.mExecutor.execute(new AbstractDBControl$$ExternalSyntheticLambda0(this, transaction, listener));
    }

    /* access modifiers changed from: private */
    /* renamed from: runTransactionAsync$lambda-0  reason: not valid java name */
    public static final void m17811runTransactionAsync$lambda0(AbstractDBControl this$0, SQLiteTransaction $transaction, OnTransactionFinishedListener $listener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($transaction, "$transaction");
        try {
            SQLiteOpenHelper sQLiteOpenHelper = this$0.mOpenHelper;
            Intrinsics.checkNotNull(sQLiteOpenHelper);
            SQLiteDatabase database = sQLiteOpenHelper.getWritableDatabase();
            if (database != null && database.isOpen()) {
                $transaction.run(database);
            }
            if ($transaction.isTransactionSuccess() && $listener != null) {
                $listener.onFinished();
            }
        } catch (Throwable th2) {
        }
    }

    public final boolean runTransactionSyncWithReturn(SQLiteTransaction transaction) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        SQLiteOpenHelper sQLiteOpenHelper = this.mOpenHelper;
        Intrinsics.checkNotNull(sQLiteOpenHelper);
        SQLiteDatabase db = sQLiteOpenHelper.getWritableDatabase();
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
    public final void runTransactionSync(SQLiteTransaction transaction) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        SQLiteOpenHelper sQLiteOpenHelper = this.mOpenHelper;
        Intrinsics.checkNotNull(sQLiteOpenHelper);
        transaction.run(sQLiteOpenHelper.getWritableDatabase());
    }

    public void close() {
        SQLiteOpenHelper sQLiteOpenHelper = this.mOpenHelper;
        if (sQLiteOpenHelper != null) {
            sQLiteOpenHelper.close();
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/dyesdk/db/AbstractDBControl$DbOpenHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "name", "", "version", "", "(Lcom/baidu/searchbox/dyesdk/db/AbstractDBControl;Landroid/content/Context;Ljava/lang/String;I)V", "debugTrace", "", "methodName", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onCreate", "onOpen", "onUpgrade", "oldVersion", "newVersion", "lib-dye_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AbstractDBControl.kt */
    public final class DbOpenHelper extends SQLiteOpenHelper {
        final /* synthetic */ AbstractDBControl this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DbOpenHelper(AbstractDBControl this$02, Context context, String name, int version) {
            super(context, name, (SQLiteDatabase.CursorFactory) null, version);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(name, "name");
            this.this$0 = this$02;
        }

        private final void debugTrace(String methodName, SQLiteDatabase db) {
            if (AppConfig.isDebug()) {
                StringBuilder sb = new StringBuilder(methodName);
                try {
                    sb.append(":\n");
                    sb.append("path=").append(db.getPath()).append(",\n");
                    sb.append("maxSize=").append(db.getMaximumSize()).append(",\n");
                    sb.append("pageSize=").append(db.getPageSize()).append(",\n");
                    sb.append("version=").append(db.getVersion()).append(",\n");
                    sb.append("attachedDbs=").append(db.getAttachedDbs()).append(".\n");
                } catch (Exception e2) {
                    sb.append(e2.getMessage());
                }
                DyeLogUtils dyeLogUtils = DyeLogUtils.INSTANCE;
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
                dyeLogUtils.logD("AbstractDBControl", sb2);
            }
        }

        public void onOpen(SQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            debugTrace(WebSocketAction.PARAM_KEY_ONOPEN, db);
            super.onOpen(db);
        }

        public void onCreate(SQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            debugTrace("onCreate", db);
            this.this$0.onDBCreate(db);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Intrinsics.checkNotNullParameter(db, "db");
            debugTrace("onUpgrade", db);
            this.this$0.onDBUpgrade(db, oldVersion, newVersion);
        }
    }
}
