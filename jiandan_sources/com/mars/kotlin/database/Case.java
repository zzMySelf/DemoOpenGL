package com.mars.kotlin.database;

import android.text.TextUtils;
import com.baidu.idl.statistics.Statistics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\u0003R\u001a\u0010\u000b\u001a\u00060\tj\u0002`\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/mars/kotlin/database/Case;", "", "elze", "(Ljava/lang/String;)Lcom/mars/kotlin/database/Case;", "as", "end", "(Ljava/lang/String;)Ljava/lang/String;", "then", "when", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sqlBuilder", "Ljava/lang/StringBuilder;", "<init>", "()V", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class Case {
    public final StringBuilder sqlBuilder = new StringBuilder();

    @NotNull
    public final Case elze(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "elze");
        StringBuilder sb = this.sqlBuilder;
        sb.append(" ELSE ");
        sb.append(str);
        return this;
    }

    @NotNull
    public final String end(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Statistics.AS_FILE_NAME);
        this.sqlBuilder.append(" END");
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = this.sqlBuilder;
            sb.append(" AS ");
            sb.append(str);
        }
        String sb2 = this.sqlBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sqlBuilder.toString()");
        this.sqlBuilder.setLength(0);
        return sb2;
    }

    @NotNull
    public final Case then(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "then");
        StringBuilder sb = this.sqlBuilder;
        sb.append(" THEN ");
        sb.append(str);
        return this;
    }

    @NotNull
    public final Case when(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "when");
        if (this.sqlBuilder.length() == 0) {
            this.sqlBuilder.append("CASE");
        }
        StringBuilder sb = this.sqlBuilder;
        sb.append(" WHEN ");
        sb.append(str);
        return this;
    }
}
