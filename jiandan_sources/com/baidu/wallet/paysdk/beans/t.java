package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayErrorContent;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class t extends BaseBean<DirectPayContentResponse> {
    public PayRequest a;
    public String b;
    public String c;

    public <T> t(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
    }

    public void a(String str) {
        this.b = str;
    }

    public void execBean() {
        if ("/cashdesk/wireless/cashier/direct".equals(this.c)) {
            List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo());
            HashMap hashMap = new HashMap();
            hashMap.put(StatHelper.SP_NO, StatHelper.getSpNo());
            hashMap.put("pay_amount", StatHelper.getPayAmount());
            StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_ORDER_COLLATION, (Collection<String>) collectData, (Map<String, Object>) hashMap);
        }
        super.execBean(DirectPayContentResponse.class, DirectPayErrorContent.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        return null;
    }

    public int getBeanId() {
        return 1;
    }

    public String getEncode() {
        return BeanConstants.ENCODE_GB_18030;
    }

    public int getHttpMethod() {
        return 0;
    }

    public String getUrl() {
        String str;
        this.c = "/cashdesk/wireless/cashier/direct";
        if (this.a.hasCashDeskCode()) {
            this.c = DxmPayBeanConstants.API_GET_PAY_ORDER_PREPAY;
        } else if (BaiduPay.PAY_FROM_HUA_ZHUAN_ZHANG.equals(this.a.getPayFrom())) {
            this.c = DxmPayBeanConstants.API_GET_PAY_ORDER_TRANSFER;
        } else if (BaiduPay.PAY_FROM_HUA_FEI.equals(this.a.getPayFrom())) {
            this.c = DxmPayBeanConstants.API_GET_PAY_ORDER_CHARGE;
        } else if (BaiduPay.PAY_FROM_BIND_CARD.equals(this.a.getPayFrom())) {
            this.c = DxmPayBeanConstants.API_CARD_ADD;
        } else if (BaiduPay.PAY_FROM_AUTHORIZE.equals(this.a.getPayFrom())) {
            this.c = DxmPayBeanConstants.API_AUTHORIZE_ORDER;
        } else if (PayDataCache.getInstance().isFromPreCashier()) {
            this.c = "/cashdesk/wireless/cashier/direct";
        }
        if (PayDataCache.getInstance().isFromPreCashier()) {
            str = DomainConfig.getInstance().getAppPayHost() + this.c + "?" + this.a.mParams + a.n + this.b;
        } else {
            str = DomainConfig.getInstance().getAppPayHost() + this.c + "?" + this.a.mParams;
        }
        if (WalletFingerprint.getInstance(this.mContext).hasEnrollFingerprint()) {
            str = str + "&enroll_fingerprint=1";
        }
        if (TextUtils.isEmpty(this.a.mSecurityParams)) {
            return str;
        }
        return str + "&security_sdk_param=" + this.a.mSecurityParams;
    }
}
