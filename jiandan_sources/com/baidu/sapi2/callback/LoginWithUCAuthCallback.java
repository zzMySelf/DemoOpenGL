package com.baidu.sapi2.callback;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.result.LoginWithUCAuthResult;

public interface LoginWithUCAuthCallback extends NoProguard {
    void onFailure(LoginWithUCAuthResult loginWithUCAuthResult);

    void onSuccess(LoginWithUCAuthResult loginWithUCAuthResult);
}
