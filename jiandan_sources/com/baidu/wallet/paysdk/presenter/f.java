package com.baidu.wallet.paysdk.presenter;

import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;

public class f {
    public PayBaseBeanActivity a;

    public f(PayBaseBeanActivity payBaseBeanActivity) {
        this.a = payBaseBeanActivity;
    }

    public void a(BindFastRequest bindFastRequest) {
        if (this.a != null && bindFastRequest != null) {
            PayRequestCache.BindCategory category = BindFastRequest.getCategory(bindFastRequest.getmBindFrom());
            if (PayRequestCache.BindCategory.Initiative == category || PayRequestCache.BindCategory.Pwd == category) {
                this.a.setFlagActiveBindCard();
            } else if (PayRequestCache.BindCategory.Other == category) {
                this.a.setFlagPaySdk();
            }
        }
    }
}
