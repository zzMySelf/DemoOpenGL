package com.baidu.wallet.paysdk.banksign.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.banksign.a.a;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.NetworkBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class d extends BaseBean<QueryResponse> {
    public String a = null;

    public d(Context context) {
        super(context);
    }

    public void execBean() {
        super.execBean(QueryResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        if (payResponse != null) {
            UserData.SP sp = payResponse.sp;
            str = (sp == null || TextUtils.isEmpty(sp.serial_num)) ? null : payResponse.sp.serial_num;
            Map<String, String> map = payResponse.cashdesk;
            str2 = (map == null || map.isEmpty() || TextUtils.isEmpty(payResponse.cashdesk.get("session_no"))) ? null : payResponse.cashdesk.get("session_no");
        } else {
            str2 = null;
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new RestNameValuePair("serial_num", str));
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new RestNameValuePair("precashier_session_no", str2));
        }
        String b = a.a().b();
        if (!TextUtils.isEmpty(b)) {
            this.a = b;
        } else if (PayDataCache.getInstance().isFromPreCashier()) {
            this.a = PayDataCache.getInstance().getSelectedCardNo();
        } else {
            CardData.BondCard selectCard = PayRequestCache.getInstance().getSelectCard();
            if (selectCard != null) {
                this.a = selectCard.account_no;
            }
        }
        if (!TextUtils.isEmpty(this.a)) {
            arrayList.add(new RestNameValuePair("selected_card_no", this.a));
        }
        String sessionId = NetworkBean.SessionCache.getInstance().getSessionId((NetworkBean.BizType) null);
        if (!TextUtils.isEmpty(sessionId)) {
            arrayList.add(new RestNameValuePair("session_id", sessionId));
        }
        arrayList.add(new RestNameValuePair("sign_request_type", "1"));
        String encryptProxy = SecurePay.getInstance().encryptProxy(a.a().m());
        String str3 = SecurePay.getInstance().getpwProxy();
        arrayList.add(new RestNameValuePair("agreement_trans_id", encryptProxy));
        arrayList.add(new RestNameValuePair("key", str3));
        return arrayList;
    }

    public int getBeanId() {
        return BankSignFactory.BEAN_ID_QUERY;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_BANKSING_QUERY;
    }
}
