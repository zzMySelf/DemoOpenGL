package com.dxmpay.wallet.core.beans;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.dxmpay.apollon.restnet.rest.d;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;

public class LoginStatusHttpRequestInterceptor implements RestHttpRequestInterceptor {
    public void qw(Context context, d dVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("OPENBDUSS=");
        sb.append(WalletLoginHelper.getInstance().getOpenLoginToken());
        if (!TextUtils.isEmpty(AccountManager.getInstance(context).getBfbToken())) {
            sb.append(i.b);
            sb.append("token=");
            sb.append(AccountManager.getInstance(context).getBfbToken());
        }
        dVar.a().rg("Cookie", sb.toString());
    }
}
