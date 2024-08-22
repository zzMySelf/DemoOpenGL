package com.baidu.wallet.api;

import com.baidu.apollon.NoProguard;

public interface ILocationCallback extends NoProguard {
    void onReceiveLocation(Object obj);
}
