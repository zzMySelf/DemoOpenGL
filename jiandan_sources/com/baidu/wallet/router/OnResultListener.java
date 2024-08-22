package com.baidu.wallet.router;

import com.baidu.wallet.core.NoProguard;

public interface OnResultListener extends NoProguard {
    public static final int CODE_ERROR = 2;
    public static final int CODE_FAIL = 1;
    public static final int CODE_SUCCESS = 0;

    void onResult(int i2);
}
