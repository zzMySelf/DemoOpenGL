package com.baidu.swan.network.builder;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.swan.network.SwanNetworkRuntime;

public class SwanGetRequestBuilder extends GetRequest.GetRequestBuilder {
    public SwanGetRequestBuilder(AbstractHttpManager httpManager) {
        super(httpManager);
    }

    public GetRequest build() {
        SwanNetworkRuntime.getSwanNetwork().addUserIdToHeader(this.httpUrl.toString(), this);
        requestFrom(6);
        return super.build();
    }
}
