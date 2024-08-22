package com.baidu.iknow.android.advisorysdk.net.api.request;

import com.baidu.iknow.android.advisorysdk.AdvisoryConfig;
import com.baidu.iknow.android.advisorysdk.net.api.ApiOrderGetImagePayInfo;
import com.baidu.iknow.android.net.request.base.AdRequest;
import com.baidu.iknow.android.net.request.base.RequestParams;
import com.baidu.searchbox.NoProGuard;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;

public class ApiOrderGetImagePayInfoRequest extends AdRequest<ApiOrderGetImagePayInfo> implements NoProGuard {
    private String device;
    private String orderId;

    public ApiOrderGetImagePayInfoRequest(String orderId2, String device2) {
        this.orderId = orderId2;
        this.device = device2;
    }

    public RequestParams params() {
        RequestParams requestParams = new RequestParams();
        requestParams.put(SwanAppUBCStatistic.EXT_ORDERID, this.orderId);
        requestParams.put("device", this.device);
        return requestParams;
    }

    public String url() {
        return AdvisoryConfig.getConfigProvider().getBaseAPI() + "/sapi/order/getimagepayinfo";
    }

    public int method() {
        return 2;
    }

    public boolean needVerify() {
        return true;
    }
}
