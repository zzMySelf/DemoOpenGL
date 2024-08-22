package com.mars.kotlin.database;

import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import com.google.common.base.Ascii;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u0000B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0001¢\u0006\u0004\b\n\u0010\u0003J\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0003J\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\u0003J\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0003R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0002\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0012R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/mars/kotlin/database/Trigger;", "", "column", "(Ljava/lang/String;)Lcom/mars/kotlin/database/Trigger;", "content", "Landroid/database/sqlite/SQLiteDatabase;", "database", "create", "(Landroid/database/sqlite/SQLiteDatabase;)Lcom/mars/kotlin/database/Trigger;", "drop", "event", "", "forEach", "(Z)Lcom/mars/kotlin/database/Trigger;", "table", "on", "operate", "whenValue", "Ljava/lang/String;", "Z", "name", "<init>", "(Ljava/lang/String;)V", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@Tag("Trigger")
public final class Trigger {
    public String column;
    public String content;
    public String event;
    public boolean forEach;
    public final String name;
    public String operate;
    public String table;
    public String whenValue;

    public Trigger(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }

    @NotNull
    public final Trigger column(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "column");
        this.column = str;
        return this;
    }

    @NotNull
    public final Trigger content(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "content");
        this.content = str;
        return this;
    }

    @NotNull
    @WorkerThread
    public final Trigger create(@NotNull SQLiteDatabase sQLiteDatabase) {
        String str;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "database");
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TRIGGER IF NOT EXISTS ");
        sb.append(this.name);
        sb.append(Ascii.CASE_MASK);
        sb.append(this.event);
        sb.append(Ascii.CASE_MASK);
        sb.append(this.operate);
        String str2 = "";
        if (this.column != null) {
            str = " OF " + this.column;
        } else {
            str = str2;
        }
        sb.append(str);
        sb.append(" ON ");
        sb.append(this.table);
        sb.append(this.forEach ? " FOR EACH ROW" : str2);
        if (this.whenValue != null) {
            str2 = " WHEN " + this.whenValue;
        }
        sb.append(str2);
        sb.append(" BEGIN ");
        sb.append(this.content);
        sb.append(" ;END");
        try {
            sQLiteDatabase.execSQL((String) LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null));
            ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
        return this;
    }

    @NotNull
    @WorkerThread
    public final Trigger drop(@NotNull SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "database");
        try {
            sQLiteDatabase.execSQL((String) LoggerKt.d$default("DROP TRIGGER IF EXISTS " + this.name, (Object) null, 1, (Object) null));
            ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
        return this;
    }

    @NotNull
    public final Trigger event(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EVENT);
        this.event = str;
        return this;
    }

    @NotNull
    public final Trigger forEach(boolean z) {
        this.forEach = z;
        return this;
    }

    @NotNull
    public final Trigger on(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "table");
        this.table = str;
        return this;
    }

    @NotNull
    public final Trigger operate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "operate");
        this.operate = str;
        return this;
    }

    @NotNull
    public final Trigger whenValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "whenValue");
        this.whenValue = str;
        return this;
    }
}
