package org.sqlite.database.sqlite;

public class SQLiteOutOfMemoryException extends SQLiteException {
    public SQLiteOutOfMemoryException() {
    }

    public SQLiteOutOfMemoryException(String str) {
        super(str);
    }
}
