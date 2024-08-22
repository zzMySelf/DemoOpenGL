package com.baidu.searchbox.log.core.db.dao;

import android.provider.BaseColumns;
import java.util.concurrent.TimeUnit;

public class DBBIZ {
    public static final String ACTIVE = "1";
    public static final String DEFAULT_EVENT_TYPE = "0";
    public static final long DEFAULT_EXPIRED_TIME = TimeUnit.DAYS.toMillis(30);
    public static final String DEFAULT_ID_TYPE = "1";
    public static final int DEFAULT_MAX_FILE_SIZE = 2097152;
    public static final int DEFAULT_MAX_SIZE = 2097152;
    public static final long DEFAULT_TIMEOUT = TimeUnit.SECONDS.toMillis(2);
    public static final String GFLOW = "1";
    public static final String ISABTEST = "1";
    public static final String MONITOR_ID_TYPE = "1";
    public static final String NON_GFLOW = "0";
    public static final String NON_ISABTEST = "0";
    public static final String NON_REAL_TIME = "0";
    public static final String NON_TEMPORARY_DATA = "0";
    public static final String PASSIVE = "0";
    public static final String PRODUCT_ID_TYPE = "0";
    public static final String REAL_TIME = "1";
    public static final String SWITCH_CLOSE = "0";
    public static final String SWITCH_OPEN = "1";
    public static final String TEMPORARY_DATA = "1";

    public static class BIZEntry implements BaseColumns {
        public static final String BIZ_ID = "bizid";
        public static final String CUR_FILE_SIZE = "curFileSize";
        public static final String CUR_NUM = "curNum";
        public static final String CUR_SIZE = "curSize";
        public static final String EXPIRED_TIME = "expiredTime";
        public static final String GFLOW = "gflow";
        public static final String ID_TYPE = "idtype";
        public static final String ISABTEST = "isAbtest";
        public static final String ISREAL = "isreal";
        public static final String LIMIT_CNT = "limitCnt";
        public static final String LIMIT_UNIT = "limitUnit";
        public static final String MAX_COUNT = "maxCount";
        public static final String MAX_FILE_SIZE = "maxFileSize";
        public static final String MAX_SIZE = "maxSize";
        public static final String SQL_CREATE_BIZ_ENTRIES = "CREATE TABLE IF NOT EXISTS biz (_id INTEGER PRIMARY KEY AUTOINCREMENT,bizid TEXT NOT NULL UNIQUE,switch TEXT,uploadType TEXT,isreal TEXT,isAbtest TEXT,type TEXT,idtype TEXT,timeout TEXT,maxCount TEXT,maxSize TEXT,maxFileSize TEXT,expiredTime TEXT,limitUnit TEXT,limitCnt TEXT,curNum INTEGER,curSize INTEGER,curFileSize INTEGER,version TEXT,_count INTEGER)";
        public static final String SQL_DELETE_LOG_ENTRIES = "DROP TABLE IF EXISTS biz";
        public static final String SWITCH = "switch";
        public static final String TABLE_NAME = "biz";
        public static final String TIMEOUT = "timeout";
        public static final String TYPE = "type";
        public static final String UPLOAD_TYPE = "uploadType";
        public static final String VERSION = "version";
    }

    private DBBIZ() {
    }
}
