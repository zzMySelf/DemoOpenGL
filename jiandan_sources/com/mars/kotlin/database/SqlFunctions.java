package com.mars.kotlin.database;

public interface SqlFunctions {
    public static final String CURRENT_MICRO_SECONDS_TIMESTAMP = "(STRFTIME('%s','now') * 1000)";
    public static final String CURRENT_MILLI_SECONDS_TIMESTAMP = "(STRFTIME('%s','now'))";
}
