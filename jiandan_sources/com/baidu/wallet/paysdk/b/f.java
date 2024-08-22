package com.baidu.wallet.paysdk.b;

import android.content.Context;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.g;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.ui.BindCardBaseActivity;
import com.dxmpay.wallet.statistics.api.StatisticManager;

public class f extends g {
    public g r;

    public boolean E() {
        BindFastRequest bindFastRequest = this.e;
        if (bindFastRequest == null || bindFastRequest.getmBankInfo() == null || this.e.getmBankInfo().channel_info == null) {
            return true;
        }
        return this.e.getmBankInfo().channel_info.isNeedSendSms();
    }

    public void c(String... strArr) {
        if (this.r == null) {
            this.r = (g) PayBeanFactory.getInstance().getBean((Context) this.d, 17, BindCardBaseActivity.BEAN_TAG);
        }
        this.r.a(this.e);
        this.r.setResponseCallback(this.d);
        StatisticManager.onEvent("callCardCheck");
        b(strArr);
        this.r.execBean();
    }
}
