package org.sqlite.database.sqlite;

public class SQLiteAbortException extends SQLiteException {
    public SQLiteAbortException() {
    }

    public SQLiteAbortException(String str) {
        super(str);
    }
}
