package com.baidu.payment.widget.inner;

import org.json.JSONObject;

public interface PayInnerViewLoadResult {
    public static final int LOAD_FAILED = 2;
    public static final int LOAD_SUCCESS = 1;

    public interface SubCode {
        public static final int FAIL_NET_WORK_ERROR = 20003;
        public static final String FAIL_NET_WORK_ERROR_DESC = "net error";
        public static final int FAIL_PARAM_EMPTY = 20001;
        public static final String FAIL_PARAM_EMPTY_PARAM_NULL = "polyParam or userParam is null";
        public static final int FAIL_RESPONSE_CHANNEL_EMPTY = 20002;
        public static final String FAIL_RESPONSE_CHANNEL_EMPTY_DESC = "response channels length is 0";
        public static final int SUCCESS = 10001;
    }

    void onResult(int i2, int i3, String str, JSONObject jSONObject);
}
