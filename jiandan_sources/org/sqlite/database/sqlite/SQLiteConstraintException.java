package org.sqlite.database.sqlite;

public class SQLiteConstraintException extends SQLiteException {
    public SQLiteConstraintException() {
    }

    public SQLiteConstraintException(String str) {
        super(str);
    }
}
