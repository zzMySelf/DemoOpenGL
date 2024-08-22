package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.LoadQrUrlResult;

public abstract class LoadQrUrlCallback {
    public abstract void onCancelAccount(LoadQrUrlResult loadQrUrlResult);

    public abstract void onFinish();

    public abstract void onJumpTo(String str);
}
