package com.baidu.wallet.paysdk.securitycenter.bean;

import android.content.Context;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.beans.OtherBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;

public class PaySetListBean extends OtherBean<String> implements NoProguard {
    public PaySetListBean(Context context) {
        super(context);
    }

    public void execBean() {
        super.execBean(String.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        String str = "1";
        arrayList.add(new RestNameValuePair("enroll_fingerprint", WalletFingerprint.getInstance(this.mContext).hasEnrollFingerprint() ? str : "0"));
        if (!WalletFingerprint.getInstance(this.mContext).isDevicesSupport()) {
            str = "0";
        }
        arrayList.add(new RestNameValuePair("device_support", str));
        return arrayList;
    }

    public int getBeanId() {
        return 1;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_PAY_SET_GET_PERSONALSET;
    }

    public boolean needNonce() {
        return false;
    }
}
