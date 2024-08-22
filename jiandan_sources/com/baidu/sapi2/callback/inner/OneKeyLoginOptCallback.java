package com.baidu.sapi2.callback.inner;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.result.OneKeyLoginOptResult;

public interface OneKeyLoginOptCallback extends NoProguard {
    void onFinish(OneKeyLoginOptResult oneKeyLoginOptResult);
}
