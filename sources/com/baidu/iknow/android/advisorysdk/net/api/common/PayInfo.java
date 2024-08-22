package com.baidu.iknow.android.advisorysdk.net.api.common;

import com.baidu.searchbox.NoProGuard;
import java.io.Serializable;

public class PayInfo implements Serializable, NoProGuard {
    public String appKey;
    public String dealId;
    public String rsaSign;
    public String totalAmount;
    public String tpMarketingDetail;
    public String tpOrderId;
}
