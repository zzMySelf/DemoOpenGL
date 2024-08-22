package com.squareup.sqldelight.android;

import com.squareup.sqldelight.db.SqlCursor;
import com.squareup.sqldelight.db.SqlPreparedStatement;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/squareup/sqldelight/android/AndroidStatement;", "Lcom/squareup/sqldelight/db/SqlPreparedStatement;", "close", "", "execute", "executeQuery", "Lcom/squareup/sqldelight/db/SqlCursor;", "sqldelight-android-driver_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AndroidSqliteDriver.kt */
public interface AndroidStatement extends SqlPreparedStatement {
    void close();

    void execute();

    SqlCursor executeQuery();
}
