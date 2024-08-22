package com.baidu.ubc.constants;

import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.x.d;
import com.baidu.sapi2.utils.SapiUtils;

public enum EnumConstants$RunTime {
    ON_EVENT("oe", NotificationCompat.CATEGORY_EVENT, 0),
    EVENT_SAVE_DB("edb", NotificationCompat.CATEGORY_EVENT, 0),
    EVENT_SAVE_CACHE("eca", NotificationCompat.CATEGORY_EVENT, 0),
    EVENT_ERROR_INIT_UNFINISH("eei", NotificationCompat.CATEGORY_EVENT, 1),
    ON_FLOW_START("osf", "flow", 0),
    ON_FLOW_END("of", "flow", 0),
    FLOW_SAVE_DB("fdb", "flow", 0),
    FLOW_ERROR_INIT_UNFINISH("fei", "flow", 1),
    FILE_SAVE("fis", "file", 0),
    FILE_SAVE_END("fise", "file", 0),
    FILE_SAVE_IO_ERROR("fierrio", "file", 1),
    FILE_DELETE_BY_UPLOAD_SUCCESS("fisucc", "file", 0),
    FILE_UPDATE_BY_UPLOAD_FAIL("fiuplerrdb", "file", 1),
    FILE_SAVE_DELETE_DB("fisddb", "file", 0),
    FILE_SAVE_TO_DB("fisdb", "file", 0),
    FILE_UPLOAD_START("upst", "file", 0),
    FILE_UPLOAD_SUCCESS("upsucc", "file", 0),
    FILE_UPLOAD_FAIL("uperr", "file", 1),
    FILE_UPLOAD_FAIL_IO_ERROR("uperrio", "file", 1),
    FILE_UPLOAD_RES_NUMBEL_ERROR("upresno", "file", 1),
    FILE_UPLOAD_RES_JSON_ERROR("upresjs", "file", 1),
    FILE_RENAME("firn", "file", 0),
    CLEAR_FILE_LIMIT("filimit", "file", 0),
    FILE_REUPLOAD("upre", "file", 0),
    FILE_REUPLOAD_NO_DATA_DELETE("upredl", "file", 1),
    CACHE_TO_DB("cadb", "db", 0),
    CLEAR_INVALID_DATA("cainv", "db", 0),
    CLEAR_UPLOADED_DATA("cacle", "db", 0),
    CLEAR_UPLOADED_DATA_SQL_ERROR("cadberr", "db", 1),
    CLEAR_DB_EVENT_LIMIT("clelimless", "db", 0),
    CLEAR_DB_FLOW_LIMIT("clflimless", "db", 0),
    CLEAR_DB_EVENT_OVERTIME("cletime", "db", 0),
    CLEAR_DB_FLOW_OVERTIME("clftime", "db", 0),
    CLEAR_DB_FILE_OVERTIME("fitimeup", "db", 0),
    CLEAR_DB_CHECK_POINT("dbcp", "db", 0),
    UPLOAD_EXCEED_REALTIME_LIMIT("uplimit", SapiUtils.KEY_QR_LOGIN_ERROR, 1),
    DB_SQL_ERROR("dbsqlerr", SapiUtils.KEY_QR_LOGIN_ERROR, 1),
    ON_MULTI_PROCESS_EVENT_ERROR("mproerr", SapiUtils.KEY_QR_LOGIN_ERROR, 1),
    DB_CORRUPT("dbc", "dbc", 1),
    DB_CORRUPT_REPAIRED("dbcr", "dbc", 1),
    DB_CORRUPT_REPAIRED_SUCCESS("dbcrs", "dbc", 0),
    DB_CORRUPT_REPAIRED_FAIL("dbcrf", "dbc", 1),
    CREATE_LOGID("cl", "related", 0),
    TIMING_BACK_TO_FRONT("front", "timing", 0),
    TIMING_FRONT_TO_BACK(d.u, "timing", 0),
    TIMING_NETWORK_AVAILABLE("network", "timing", 0),
    TIMING_LOG_TOO_MANY("toomany", "timing", 0),
    TIMING_SYSTEM_TIME_CHANGED("timechange", "timing", 0),
    CONTEXT_IS_NULL("contextnull", "init", 1),
    INIT_START("initst", "init", 0),
    INIT_EXCEPTION("initex", "init", 1),
    INIT_MESSAGE("initmsg", "init", 0);
    
    public final String from;
    public final String type;
    public final int value;

    /* access modifiers changed from: public */
    EnumConstants$RunTime(String str, String str2, int i2) {
        this.type = str;
        this.from = str2;
        this.value = i2;
    }

    public String getFrom() {
        return this.from;
    }

    public String getType() {
        return this.type;
    }

    public int getValue() {
        return this.value;
    }
}
