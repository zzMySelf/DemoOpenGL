package com.baidu.wallet.paysdk.presenter.a;

import android.text.TextUtils;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.contract.a;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;

public class a implements a.C0164a {
    public a.b a;

    public a(a.b bVar) {
        this.a = bVar;
    }

    public boolean a(String str) {
        return !TextUtils.isEmpty(str);
    }

    public boolean b(String str) {
        if (!TextUtils.isEmpty(str) && str.trim().replace(" ", "").length() >= 9) {
            return true;
        }
        return false;
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            payRequest.setmBankCardNumber(str.replace(" ", ""));
            PayRequestCache.getInstance().addBeanRequestToCache(DxmPayBeanConstants.REQUEST_ID_PAY, payRequest);
        }
    }
}
