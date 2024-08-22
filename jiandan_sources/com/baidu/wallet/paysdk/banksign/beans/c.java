package com.baidu.wallet.paysdk.banksign.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.banksign.a.a;
import com.baidu.wallet.paysdk.banksign.datamodel.PollingResponse;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.NetworkBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class c extends BaseBean<PollingResponse> {
    public c(Context context) {
        super(context);
    }

    public void execBean() {
        super.execBean(PollingResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        String str;
        ArrayList arrayList = new ArrayList();
        String str2 = null;
        String sessionId = NetworkBean.SessionCache.getInstance().getSessionId((NetworkBean.BizType) null);
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        if (payResponse != null) {
            UserData.SP sp = payResponse.sp;
            String str3 = (sp == null || TextUtils.isEmpty(sp.serial_num)) ? null : payResponse.sp.serial_num;
            Map<String, String> map = payResponse.cashdesk;
            if (map != null && !map.isEmpty() && !TextUtils.isEmpty(payResponse.cashdesk.get("session_no"))) {
                str2 = payResponse.cashdesk.get("session_no");
            }
            str = str2;
            str2 = str3;
        } else {
            str = null;
        }
        String encryptProxy = SecurePay.getInstance().encryptProxy(a.a().m());
        String str4 = SecurePay.getInstance().getpwProxy();
        arrayList.add(new RestNameValuePair("agreement_trans_id", encryptProxy));
        arrayList.add(new RestNameValuePair("key", str4));
        if (!TextUtils.isEmpty(sessionId)) {
            arrayList.add(new RestNameValuePair("session_id", sessionId));
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new RestNameValuePair("serial_num", str2));
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new RestNameValuePair("precashier_session_no", str));
        }
        return arrayList;
    }

    public int getBeanId() {
        return BankSignFactory.BEAN_ID_POLLING;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_BANKSING_POLLING;
    }
}
