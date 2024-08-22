package org.sqlite.database.sqlite;

import org.sqlite.database.SQLException;

public class SQLiteException extends SQLException {
    public SQLiteException() {
    }

    public SQLiteException(String str) {
        super(str);
    }

    public SQLiteException(String str, Throwable th2) {
        super(str, th2);
    }
}
