package com.squareup.sqldelight.android;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.squareup.sqldelight.Transacter;
import com.squareup.sqldelight.db.AfterVersionWithDriver;
import com.squareup.sqldelight.db.SqlCursor;
import com.squareup.sqldelight.db.SqlDriver;
import com.squareup.sqldelight.db.SqlDriverKt;
import com.squareup.sqldelight.db.SqlPreparedStatement;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001d\u0018\u00002\u00020\u0001:\u00029:B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BK\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013B\u0019\b\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0016B'\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0017J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\n %*\u0004\u0018\u00010!0!H\u0016J_\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\b\u0010(\u001a\u0004\u0018\u00010\u00102\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0019\u0010,\u001a\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020#\u0018\u00010-¢\u0006\u0002\b/2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u0002H'0-¢\u0006\u0002\b/H\u0002¢\u0006\u0002\u00101JB\u0010&\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010\u00102\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00102\u0019\u0010,\u001a\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020#\u0018\u00010-¢\u0006\u0002\b/H\u0016¢\u0006\u0002\u00104JB\u00105\u001a\u0002062\b\u0010(\u001a\u0004\u0018\u00010\u00102\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00102\u0019\u0010,\u001a\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020#\u0018\u00010-¢\u0006\u0002\b/H\u0016¢\u0006\u0002\u00107J\b\u00108\u001a\u00020!H\u0016R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/squareup/sqldelight/android/AndroidSqliteDriver;", "Lcom/squareup/sqldelight/db/SqlDriver;", "openHelper", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper;)V", "schema", "Lcom/squareup/sqldelight/db/SqlDriver$Schema;", "context", "Landroid/content/Context;", "name", "", "factory", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "cacheSize", "", "useNoBackupDirectory", "", "(Lcom/squareup/sqldelight/db/SqlDriver$Schema;Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;IZ)V", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "(Landroidx/sqlite/db/SupportSQLiteDatabase;I)V", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper;Landroidx/sqlite/db/SupportSQLiteDatabase;I)V", "getDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "database$delegate", "Lkotlin/Lazy;", "statements", "com/squareup/sqldelight/android/AndroidSqliteDriver$statements$1", "Lcom/squareup/sqldelight/android/AndroidSqliteDriver$statements$1;", "transactions", "Ljava/lang/ThreadLocal;", "Lcom/squareup/sqldelight/Transacter$Transaction;", "close", "", "currentTransaction", "kotlin.jvm.PlatformType", "execute", "T", "identifier", "createStatement", "Lkotlin/Function0;", "Lcom/squareup/sqldelight/android/AndroidStatement;", "binders", "Lkotlin/Function1;", "Lcom/squareup/sqldelight/db/SqlPreparedStatement;", "Lkotlin/ExtensionFunctionType;", "result", "(Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "sql", "parameters", "(Ljava/lang/Integer;Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "executeQuery", "Lcom/squareup/sqldelight/db/SqlCursor;", "(Ljava/lang/Integer;Ljava/lang/String;ILkotlin/jvm/functions/Function1;)Lcom/squareup/sqldelight/db/SqlCursor;", "newTransaction", "Callback", "Transaction", "sqldelight-android-driver_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AndroidSqliteDriver.kt */
public final class AndroidSqliteDriver implements SqlDriver {
    private final int cacheSize;
    private final Lazy database$delegate;
    /* access modifiers changed from: private */
    public final SupportSQLiteOpenHelper openHelper;
    private final AndroidSqliteDriver$statements$1 statements;
    /* access modifiers changed from: private */
    public final ThreadLocal<Transacter.Transaction> transactions;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SupportSQLiteDatabase supportSQLiteDatabase) {
        this(supportSQLiteDatabase, 0, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
    }

    public /* synthetic */ AndroidSqliteDriver(SupportSQLiteOpenHelper supportSQLiteOpenHelper, SupportSQLiteDatabase supportSQLiteDatabase, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(supportSQLiteOpenHelper, supportSQLiteDatabase, i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SqlDriver.Schema schema, Context context) {
        this(schema, context, (String) null, (SupportSQLiteOpenHelper.Factory) null, (SupportSQLiteOpenHelper.Callback) null, 0, false, 124, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SqlDriver.Schema schema, Context context, String str) {
        this(schema, context, str, (SupportSQLiteOpenHelper.Factory) null, (SupportSQLiteOpenHelper.Callback) null, 0, false, 120, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SqlDriver.Schema schema, Context context, String str, SupportSQLiteOpenHelper.Factory factory) {
        this(schema, context, str, factory, (SupportSQLiteOpenHelper.Callback) null, 0, false, 112, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(factory, "factory");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SqlDriver.Schema schema, Context context, String str, SupportSQLiteOpenHelper.Factory factory, SupportSQLiteOpenHelper.Callback callback) {
        this(schema, context, str, factory, callback, 0, false, 96, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SqlDriver.Schema schema, Context context, String str, SupportSQLiteOpenHelper.Factory factory, SupportSQLiteOpenHelper.Callback callback, int i2) {
        this(schema, context, str, factory, callback, i2, false, 64, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    private AndroidSqliteDriver(SupportSQLiteOpenHelper openHelper2, SupportSQLiteDatabase database, int cacheSize2) {
        this.openHelper = openHelper2;
        this.cacheSize = cacheSize2;
        boolean z = true;
        if ((database == null ? false : z) ^ (openHelper2 != null)) {
            this.transactions = new ThreadLocal<>();
            this.database$delegate = LazyKt.lazy(new AndroidSqliteDriver$database$2(this, database));
            this.statements = new AndroidSqliteDriver$statements$1(cacheSize2);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ AndroidSqliteDriver(SupportSQLiteOpenHelper supportSQLiteOpenHelper, SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : supportSQLiteOpenHelper, (i3 & 2) != 0 ? null : supportSQLiteDatabase, i2);
    }

    /* access modifiers changed from: private */
    public final SupportSQLiteDatabase getDatabase() {
        return (SupportSQLiteDatabase) this.database$delegate.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SupportSQLiteOpenHelper openHelper2) {
        this(openHelper2, (SupportSQLiteDatabase) null, AndroidSqliteDriverKt.DEFAULT_CACHE_SIZE);
        Intrinsics.checkNotNullParameter(openHelper2, "openHelper");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AndroidSqliteDriver(com.squareup.sqldelight.db.SqlDriver.Schema r10, android.content.Context r11, java.lang.String r12, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r13, androidx.sqlite.db.SupportSQLiteOpenHelper.Callback r14, int r15, boolean r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r9 = this;
            r0 = r17 & 4
            if (r0 == 0) goto L_0x0007
            r0 = 0
            r4 = r0
            goto L_0x0008
        L_0x0007:
            r4 = r12
        L_0x0008:
            r0 = r17 & 8
            if (r0 == 0) goto L_0x0015
            androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory r0 = new androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
            r0.<init>()
            androidx.sqlite.db.SupportSQLiteOpenHelper$Factory r0 = (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r0
            r5 = r0
            goto L_0x0016
        L_0x0015:
            r5 = r13
        L_0x0016:
            r0 = r17 & 16
            if (r0 == 0) goto L_0x0025
            com.squareup.sqldelight.android.AndroidSqliteDriver$Callback r0 = new com.squareup.sqldelight.android.AndroidSqliteDriver$Callback
            r2 = r10
            r0.<init>(r10)
            androidx.sqlite.db.SupportSQLiteOpenHelper$Callback r0 = (androidx.sqlite.db.SupportSQLiteOpenHelper.Callback) r0
            r6 = r0
            goto L_0x0027
        L_0x0025:
            r2 = r10
            r6 = r14
        L_0x0027:
            r0 = r17 & 32
            if (r0 == 0) goto L_0x0031
            int r0 = com.squareup.sqldelight.android.AndroidSqliteDriverKt.DEFAULT_CACHE_SIZE
            r7 = r0
            goto L_0x0032
        L_0x0031:
            r7 = r15
        L_0x0032:
            r0 = r17 & 64
            if (r0 == 0) goto L_0x0039
            r0 = 0
            r8 = r0
            goto L_0x003b
        L_0x0039:
            r8 = r16
        L_0x003b:
            r1 = r9
            r2 = r10
            r3 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.sqldelight.android.AndroidSqliteDriver.<init>(com.squareup.sqldelight.db.SqlDriver$Schema, android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.sqlite.db.SupportSQLiteOpenHelper$Callback, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SqlDriver.Schema schema, Context context, String name, SupportSQLiteOpenHelper.Factory factory, SupportSQLiteOpenHelper.Callback callback, int cacheSize2, boolean useNoBackupDirectory) {
        this(factory.create(SupportSQLiteOpenHelper.Configuration.builder(context).callback(callback).name(name).noBackupDirectory(useNoBackupDirectory).build()), (SupportSQLiteDatabase) null, cacheSize2);
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidSqliteDriver(SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(supportSQLiteDatabase, (i3 & 2) != 0 ? AndroidSqliteDriverKt.DEFAULT_CACHE_SIZE : i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AndroidSqliteDriver(SupportSQLiteDatabase database, int cacheSize2) {
        this((SupportSQLiteOpenHelper) null, database, cacheSize2);
        Intrinsics.checkNotNullParameter(database, "database");
    }

    public Transacter.Transaction newTransaction() {
        Transacter.Transaction enclosing = this.transactions.get();
        Transaction transaction = new Transaction(this, enclosing);
        this.transactions.set(transaction);
        if (enclosing == null) {
            getDatabase().beginTransactionNonExclusive();
        }
        return transaction;
    }

    public Transacter.Transaction currentTransaction() {
        return this.transactions.get();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/squareup/sqldelight/android/AndroidSqliteDriver$Transaction;", "Lcom/squareup/sqldelight/Transacter$Transaction;", "enclosingTransaction", "(Lcom/squareup/sqldelight/android/AndroidSqliteDriver;Lcom/squareup/sqldelight/Transacter$Transaction;)V", "getEnclosingTransaction", "()Lcom/squareup/sqldelight/Transacter$Transaction;", "endTransaction", "", "successful", "", "sqldelight-android-driver_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AndroidSqliteDriver.kt */
    public final class Transaction extends Transacter.Transaction {
        private final Transacter.Transaction enclosingTransaction;
        final /* synthetic */ AndroidSqliteDriver this$0;

        public Transaction(AndroidSqliteDriver this$02, Transacter.Transaction enclosingTransaction2) {
            Intrinsics.checkNotNullParameter(this$02, "this$0");
            this.this$0 = this$02;
            this.enclosingTransaction = enclosingTransaction2;
        }

        /* access modifiers changed from: protected */
        public Transacter.Transaction getEnclosingTransaction() {
            return this.enclosingTransaction;
        }

        /* access modifiers changed from: protected */
        public void endTransaction(boolean successful) {
            if (getEnclosingTransaction() == null) {
                if (successful) {
                    this.this$0.getDatabase().setTransactionSuccessful();
                    this.this$0.getDatabase().endTransaction();
                } else {
                    this.this$0.getDatabase().endTransaction();
                }
            }
            this.this$0.transactions.set(getEnclosingTransaction());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.squareup.sqldelight.android.AndroidStatement} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> T execute(java.lang.Integer r4, kotlin.jvm.functions.Function0<? extends com.squareup.sqldelight.android.AndroidStatement> r5, kotlin.jvm.functions.Function1<? super com.squareup.sqldelight.db.SqlPreparedStatement, kotlin.Unit> r6, kotlin.jvm.functions.Function1<? super com.squareup.sqldelight.android.AndroidStatement, ? extends T> r7) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x000c
            com.squareup.sqldelight.android.AndroidSqliteDriver$statements$1 r1 = r3.statements
            java.lang.Object r1 = r1.remove(r4)
            r0 = r1
            com.squareup.sqldelight.android.AndroidStatement r0 = (com.squareup.sqldelight.android.AndroidStatement) r0
        L_0x000c:
            if (r0 != 0) goto L_0x0015
            java.lang.Object r1 = r5.invoke()
            r0 = r1
            com.squareup.sqldelight.android.AndroidStatement r0 = (com.squareup.sqldelight.android.AndroidStatement) r0
        L_0x0015:
            if (r6 == 0) goto L_0x001b
            r6.invoke(r0)     // Catch:{ all -> 0x0034 }
        L_0x001b:
            java.lang.Object r1 = r7.invoke(r0)     // Catch:{ all -> 0x0034 }
            if (r4 == 0) goto L_0x0030
            com.squareup.sqldelight.android.AndroidSqliteDriver$statements$1 r2 = r3.statements
            java.lang.Object r2 = r2.put(r4, r0)
            com.squareup.sqldelight.android.AndroidStatement r2 = (com.squareup.sqldelight.android.AndroidStatement) r2
            if (r2 != 0) goto L_0x002c
            goto L_0x0033
        L_0x002c:
            r2.close()
            goto L_0x0033
        L_0x0030:
            r0.close()
        L_0x0033:
            return r1
        L_0x0034:
            r1 = move-exception
            if (r4 == 0) goto L_0x0046
            com.squareup.sqldelight.android.AndroidSqliteDriver$statements$1 r2 = r3.statements
            java.lang.Object r2 = r2.put(r4, r0)
            com.squareup.sqldelight.android.AndroidStatement r2 = (com.squareup.sqldelight.android.AndroidStatement) r2
            if (r2 != 0) goto L_0x0042
            goto L_0x0049
        L_0x0042:
            r2.close()
            goto L_0x0049
        L_0x0046:
            r0.close()
        L_0x0049:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.sqldelight.android.AndroidSqliteDriver.execute(java.lang.Integer, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    public void execute(Integer identifier, String sql, int parameters, Function1<? super SqlPreparedStatement, Unit> binders) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        execute(identifier, (Function0<? extends AndroidStatement>) new AndroidSqliteDriver$execute$1(this, sql), binders, AndroidSqliteDriver$execute$2.INSTANCE);
    }

    public SqlCursor executeQuery(Integer identifier, String sql, int parameters, Function1<? super SqlPreparedStatement, Unit> binders) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        return (SqlCursor) execute(identifier, (Function0<? extends AndroidStatement>) new AndroidSqliteDriver$executeQuery$1(sql, this, parameters), binders, AndroidSqliteDriver$executeQuery$2.INSTANCE);
    }

    public void close() {
        Unit unit;
        this.statements.evictAll();
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.openHelper;
        if (supportSQLiteOpenHelper == null) {
            unit = null;
        } else {
            supportSQLiteOpenHelper.close();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            getDatabase().close();
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0002\u0010\bB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0006\"\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0018\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/squareup/sqldelight/android/AndroidSqliteDriver$Callback;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "schema", "Lcom/squareup/sqldelight/db/SqlDriver$Schema;", "(Lcom/squareup/sqldelight/db/SqlDriver$Schema;)V", "callbacks", "", "Lcom/squareup/sqldelight/db/AfterVersion;", "(Lcom/squareup/sqldelight/db/SqlDriver$Schema;[Lcom/squareup/sqldelight/db/AfterVersion;)V", "Lcom/squareup/sqldelight/db/AfterVersionWithDriver;", "(Lcom/squareup/sqldelight/db/SqlDriver$Schema;[Lcom/squareup/sqldelight/db/AfterVersionWithDriver;)V", "[Lcom/squareup/sqldelight/db/AfterVersionWithDriver;", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onUpgrade", "oldVersion", "", "newVersion", "sqldelight-android-driver_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AndroidSqliteDriver.kt */
    public static class Callback extends SupportSQLiteOpenHelper.Callback {
        private final AfterVersionWithDriver[] callbacks;
        private final SqlDriver.Schema schema;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Callback(SqlDriver.Schema schema2, AfterVersionWithDriver... callbacks2) {
            super(schema2.getVersion());
            Intrinsics.checkNotNullParameter(schema2, "schema");
            Intrinsics.checkNotNullParameter(callbacks2, "callbacks");
            this.schema = schema2;
            this.callbacks = callbacks2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Callback(com.squareup.sqldelight.db.SqlDriver.Schema r3) {
            /*
                r2 = this;
                java.lang.String r0 = "schema"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r0 = 0
                r1 = 0
                com.squareup.sqldelight.db.AfterVersionWithDriver[] r1 = new com.squareup.sqldelight.db.AfterVersionWithDriver[r1]
                java.lang.Object[] r1 = (java.lang.Object[]) r1
                com.squareup.sqldelight.db.AfterVersionWithDriver[] r1 = (com.squareup.sqldelight.db.AfterVersionWithDriver[]) r1
                int r0 = r1.length
                java.lang.Object[] r0 = java.util.Arrays.copyOf(r1, r0)
                com.squareup.sqldelight.db.AfterVersionWithDriver[] r0 = (com.squareup.sqldelight.db.AfterVersionWithDriver[]) r0
                r2.<init>((com.squareup.sqldelight.db.SqlDriver.Schema) r3, (com.squareup.sqldelight.db.AfterVersionWithDriver[]) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.sqldelight.android.AndroidSqliteDriver.Callback.<init>(com.squareup.sqldelight.db.SqlDriver$Schema):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Callback(com.squareup.sqldelight.db.SqlDriver.Schema r12, com.squareup.sqldelight.db.AfterVersion... r13) {
            /*
                r11 = this;
                java.lang.String r0 = "schema"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                java.lang.String r0 = "callbacks"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
                r0 = r13
                r1 = 0
                java.util.ArrayList r2 = new java.util.ArrayList
                int r3 = r0.length
                r2.<init>(r3)
                java.util.Collection r2 = (java.util.Collection) r2
                r3 = r0
                r4 = 0
                int r5 = r3.length
                r6 = 0
                r7 = r6
            L_0x001a:
                if (r7 >= r5) goto L_0x002b
                r8 = r3[r7]
                r9 = r8
                r10 = 0
                com.squareup.sqldelight.db.AfterVersionWithDriver r9 = com.squareup.sqldelight.db.SqlDriverKt.toAfterVersionWithDriver(r9)
                r2.add(r9)
                int r7 = r7 + 1
                goto L_0x001a
            L_0x002b:
                java.util.List r2 = (java.util.List) r2
                java.util.Collection r2 = (java.util.Collection) r2
                r0 = r2
                r1 = 0
                com.squareup.sqldelight.db.AfterVersionWithDriver[] r3 = new com.squareup.sqldelight.db.AfterVersionWithDriver[r6]
                java.lang.Object[] r3 = r2.toArray(r3)
                if (r3 == 0) goto L_0x0049
                com.squareup.sqldelight.db.AfterVersionWithDriver[] r3 = (com.squareup.sqldelight.db.AfterVersionWithDriver[]) r3
                int r0 = r3.length
                java.lang.Object[] r0 = java.util.Arrays.copyOf(r3, r0)
                com.squareup.sqldelight.db.AfterVersionWithDriver[] r0 = (com.squareup.sqldelight.db.AfterVersionWithDriver[]) r0
                r11.<init>((com.squareup.sqldelight.db.SqlDriver.Schema) r12, (com.squareup.sqldelight.db.AfterVersionWithDriver[]) r0)
                return
            L_0x0049:
                java.lang.NullPointerException r3 = new java.lang.NullPointerException
                java.lang.String r4 = "null cannot be cast to non-null type kotlin.Array<T>"
                r3.<init>(r4)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.sqldelight.android.AndroidSqliteDriver.Callback.<init>(com.squareup.sqldelight.db.SqlDriver$Schema, com.squareup.sqldelight.db.AfterVersion[]):void");
        }

        public void onCreate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            this.schema.create(new AndroidSqliteDriver((SupportSQLiteOpenHelper) null, db, 1, (DefaultConstructorMarker) null));
        }

        public void onUpgrade(SupportSQLiteDatabase db, int oldVersion, int newVersion) {
            Intrinsics.checkNotNullParameter(db, "db");
            if (!(this.callbacks.length == 0)) {
                AfterVersionWithDriver[] afterVersionWithDriverArr = this.callbacks;
                SqlDriverKt.migrateWithCallbacks(this.schema, (SqlDriver) new AndroidSqliteDriver((SupportSQLiteOpenHelper) null, db, 1, (DefaultConstructorMarker) null), oldVersion, newVersion, (AfterVersionWithDriver[]) Arrays.copyOf(afterVersionWithDriverArr, afterVersionWithDriverArr.length));
                return;
            }
            this.schema.migrate(new AndroidSqliteDriver((SupportSQLiteOpenHelper) null, db, 1, (DefaultConstructorMarker) null), oldVersion, newVersion);
        }
    }
}
