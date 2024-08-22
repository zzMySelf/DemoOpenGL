package com.baidu.android.lbspay.channelpay.fast;

import com.baidu.android.lbspay.channelpay.ChannelBaseWapPay;
import com.baidu.android.lbspay.channelpay.PayDataBean;
import com.baidu.android.lbspay.network.GetPayContent;

public class ChannelFastPay extends ChannelBaseWapPay {
    public int getChannelId() {
        return 107;
    }

    public String getUrl(GetPayContent getPayContent) {
        PayDataBean payData = getPayData(getPayContent);
        return payData != null ? payData.payurl : "";
    }
}
