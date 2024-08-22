package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BindCardProtocolActivity;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.List;

public class m extends BaseBean<Object> {
    public BindFastRequest a;
    public PwdRequest b;

    public <T> m(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.b = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD);
    }

    public void a(BindFastRequest bindFastRequest) {
        this.a = bindFastRequest;
    }

    public void execBean() {
        super.execBean((Class) null);
    }

    public List<RestNameValuePair> generateRequestParam() {
        if (this.a != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("request_type", this.a.getCardRequestType()));
            arrayList.add(new RestNameValuePair("service_type", this.a.getServiceType()));
            arrayList.add(new RestNameValuePair("source_flag", "3"));
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.a.getmBankCard())));
            if (!TextUtils.isEmpty(this.a.getmName())) {
                arrayList.add(new RestNameValuePair("true_name", this.a.getmName()));
            }
            if (!TextUtils.isEmpty(this.a.getCertificateType())) {
                arrayList.add(new RestNameValuePair(BindCardProtocolActivity.IDENTITY_TYPE, this.a.getCertificateType()));
            }
            if (!TextUtils.isEmpty(this.a.getmIdCard())) {
                arrayList.add(new RestNameValuePair("identity_code", PayUtils.encrypt("identity_code", this.a.getmIdCard())));
            }
            if (!TextUtils.isEmpty(this.a.getmPhone())) {
                arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", this.a.getmPhone())));
            }
            arrayList.add(new RestNameValuePair("vcode", this.a.mSmsVCode));
            String handlePwdSimple = PasswordController.handlePwdSimple(this.b.mPayPass);
            String seed = PasswordController.getSeed();
            String handlePwd = PasswordController.handlePwd(this.b.mConfirmPayPass, seed);
            arrayList.add(new RestNameValuePair("mobile_pass", SecurePay.getInstance().encryptProxy(handlePwdSimple)));
            arrayList.add(new RestNameValuePair("mobile_pass_confirm", handlePwd));
            arrayList.add(new RestNameValuePair("mobile_pwd_psp", PasswordController.handlePwdForPassport(this.b.mConfirmPayPass)));
            arrayList.add(new RestNameValuePair("seed", SecurePay.getInstance().encryptProxy(seed)));
            arrayList.add(new RestNameValuePair("key", SecurePay.getInstance().getpwProxy()));
            if (!TextUtils.isEmpty(this.a.getmValidDate())) {
                arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", this.a.getmValidDate())));
            }
            if (!TextUtils.isEmpty(this.a.getmCvv())) {
                arrayList.add(new RestNameValuePair("cvv2", PayUtils.encrypt("cvv2", this.a.getmCvv())));
            }
            if (!TextUtils.isEmpty(this.a.getChannelNo())) {
                arrayList.add(new RestNameValuePair("channel_no", this.a.getChannelNo()));
            }
            if (!TextUtils.isEmpty(this.a.getSubBankCode())) {
                arrayList.add(new RestNameValuePair("sub_bank_code", this.a.getSubBankCode()));
            }
            CardData.BondCard bondCard = this.a.mBondCard;
            if (bondCard != null) {
                arrayList.add(new RestNameValuePair("card_no_bind", bondCard.account_no));
            }
            arrayList.add(new RestNameValuePair("session_id", this.a.getSessionId()));
            return arrayList;
        }
        throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
    }

    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD;
    }

    public String getEncode() {
        return "UTF-8";
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_FIND_PASSWD;
    }
}
