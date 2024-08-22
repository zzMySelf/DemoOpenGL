package com.baidu.sapi2.callback;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.result.ValidateWithHaoKanResult;

public interface ValidateWithHaoKanCallback extends NoProguard {
    void onFailure(ValidateWithHaoKanResult validateWithHaoKanResult);

    void onSuccess(ValidateWithHaoKanResult validateWithHaoKanResult);
}
