package com.baidu.wallet.paysdk.presenter.a;

import android.text.TextUtils;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.contract.a;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;

public class c implements a.C0164a {
    public a.b a;

    public c(a.b bVar) {
        this.a = bVar;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.trim().length() == 3 || str.trim().length() == 4) {
            return true;
        }
        return false;
    }

    public boolean b(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 3) {
            return true;
        }
        return false;
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            payRequest.setmCvv2(str.trim());
            PayRequestCache.getInstance().addBeanRequestToCache(DxmPayBeanConstants.REQUEST_ID_PAY, payRequest);
        }
    }
}
