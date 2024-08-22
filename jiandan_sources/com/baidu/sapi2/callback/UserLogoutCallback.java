package com.baidu.sapi2.callback;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.result.SapiResult;

public interface UserLogoutCallback extends NoProguard {
    void onFailure(SapiResult sapiResult);

    void onSuccess(SapiResult sapiResult);
}
