package com.baidu.swan.pms.node.common.pkg;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

public class PkgDownloadLimitStrategy {
    private static final int DEFAULT_CALL_INTERVAL = 1000;
    private static final int DEFAULT_MAX_NUM = 2;
    private static final int DEFAULT_PER_CALL_NUM = 2;
    private static final String KEY_CALL_INTERVAL = "call_interval";
    private static final String KEY_MAX_NUM = "max_num";
    private static final String KEY_PER_CALL_NUM = "per_call_num";
    public static final String MSG_INTERVAL_LIMIT = "over time interval limit";
    public static final String MSG_OVER_MAX = "over max limit";
    public static final String MSG_OVER_SINGLE_MAX = "over single max limit";
    public int callInterval;
    public int maxNum;
    public int perCallNum;

    PkgDownloadLimitStrategy(int maxNum2, int perCallNum2, int callInterval2) {
        this.maxNum = maxNum2;
        this.perCallNum = perCallNum2;
        this.callInterval = callInterval2;
    }

    public static PkgDownloadLimitStrategy parseObject(JSONObject data) {
        if (data != null) {
            return new PkgDownloadLimitStrategy(data.optInt(KEY_MAX_NUM, 2), data.optInt(KEY_PER_CALL_NUM, 2), data.optInt(KEY_CALL_INTERVAL, 1000));
        }
        return createDefault();
    }

    public static PkgDownloadLimitStrategy createDefault() {
        return new PkgDownloadLimitStrategy(2, 2, 1000);
    }

    public String toString() {
        return "PkgDownloadLimitStrategy{maxNum=" + this.maxNum + ", perCallNum=" + this.perCallNum + ", callInterval=" + this.callInterval + AbstractJsonLexerKt.END_OBJ;
    }
}
