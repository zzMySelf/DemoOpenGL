package org.sqlite.database;

public class SQLException extends RuntimeException {
    public SQLException() {
    }

    public SQLException(String str) {
        super(str);
    }

    public SQLException(String str, Throwable th2) {
        super(str, th2);
    }
}
