package org.sqlite.database.sqlite;

public class SQLiteBlobTooBigException extends SQLiteException {
    public SQLiteBlobTooBigException() {
    }

    public SQLiteBlobTooBigException(String str) {
        super(str);
    }
}
