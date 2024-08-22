package com.baidu.searchbox.card.net;

public interface OnTaskFinishListener<T> {
    public static final int ERROR_CODE_ACTION_NULL_ERROR = 7;
    public static final int ERROR_CODE_ACTION_RUNTIME_ERROR = 6;
    public static final int ERROR_CODE_CONNECT_NET = 1;
    public static final int ERROR_CODE_MANAGE_DATABASE = 0;
    public static final int ERROR_CODE_PARSE_RESPONSE = 5;
    public static final int ERROR_CODE_POST_DATA_NULL = 4;
    public static final int ERROR_CODE_POST_PARAMS = 2;
    public static final int NO_ERROR = -1;

    void handleErrorCode(int i2, String str);

    void onFinish(T t, CommonTask<T> commonTask);
}
