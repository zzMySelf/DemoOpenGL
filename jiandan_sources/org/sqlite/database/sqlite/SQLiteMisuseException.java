package org.sqlite.database.sqlite;

public class SQLiteMisuseException extends SQLiteException {
    public SQLiteMisuseException() {
    }

    public SQLiteMisuseException(String str) {
        super(str);
    }
}
