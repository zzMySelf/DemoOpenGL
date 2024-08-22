package com.baidu.searchbox.gamecore.pyramid;

import com.baidu.searchbox.base.NoProGuard;

public interface IAccountContext extends NoProGuard {

    public interface IAccountLoginCallback extends NoProGuard {
        void onResult(int i2);
    }

    int getLoginCodeSuccess();

    String getNickName();

    String getPortrait();

    String getUid();

    boolean isLogin();

    void login(String str, IAccountLoginCallback iAccountLoginCallback);
}
