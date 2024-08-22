package com.baidu.down.common.intercepter;

public final class InterceptResult {
    public static final int RET_CANCEL = 3;
    public static final int RET_CONTINUE = 0;
    public static final int RET_ERROR = 2;
    public static final int RET_PAUSE = 1;
    public static final int RET_RETRY = 4;
    public String interceptMsg = null;
    public int retCode = 0;

    public InterceptResult(int pRetCode) {
        this.retCode = pRetCode;
    }
}
