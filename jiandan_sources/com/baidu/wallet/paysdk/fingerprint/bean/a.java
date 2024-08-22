package com.baidu.wallet.paysdk.fingerprint.bean;

import android.content.Context;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;

public class a extends BaseBean {
    public String a = null;

    public a(Context context) {
        super(context);
    }

    public void a(String str) {
        this.a = str;
    }

    public void execBean() {
        execBean(String.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (this.a != null) {
            arrayList.add(new RestNameValuePair("serial_num", SecurePay.getInstance().encryptProxy(this.a)));
        }
        arrayList.add(new RestNameValuePair("pay_type", "1"));
        return arrayList;
    }

    public int getBeanId() {
        return FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + "/cashdesk/wireless/fingerprint/close";
    }
}
