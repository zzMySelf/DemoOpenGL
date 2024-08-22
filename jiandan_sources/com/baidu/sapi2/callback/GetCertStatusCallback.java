package com.baidu.sapi2.callback;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.result.GetCertStatusResult;

public interface GetCertStatusCallback extends NoProguard {
    void onFailure(GetCertStatusResult getCertStatusResult);

    void onSuccess(GetCertStatusResult getCertStatusResult);
}
