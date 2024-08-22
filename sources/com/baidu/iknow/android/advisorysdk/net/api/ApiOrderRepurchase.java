package com.baidu.iknow.android.advisorysdk.net.api;

import com.baidu.iknow.android.net.response.ADBaseResponse;
import com.baidu.searchbox.NoProGuard;
import java.io.Serializable;

public class ApiOrderRepurchase extends ADBaseResponse implements Serializable, NoProGuard {
    public Data data = new Data();

    public static class Data implements Serializable, NoProGuard {
        public String orderId;
        public long price;
    }
}
