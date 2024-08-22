package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.List;

public class l extends BaseBean<Object> {
    public BindFastRequest a;
    public PwdRequest b;

    public <T> l(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.b = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD);
    }

    public void execBean() {
        super.execBean((Class) null);
    }

    public List<RestNameValuePair> generateRequestParam() {
        if (this.a != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.a.getmBankCard())));
            String handlePwdSimple = PasswordController.handlePwdSimple(this.b.mPayPass);
            String seed = PasswordController.getSeed();
            String handlePwd = PasswordController.handlePwd(this.b.mConfirmPayPass, seed);
            arrayList.add(new RestNameValuePair("mobile_pwd", SecurePay.getInstance().encryptProxy(handlePwdSimple)));
            arrayList.add(new RestNameValuePair("confirm_mobile_pwd", handlePwd));
            arrayList.add(new RestNameValuePair("mobile_pwd_psp", PasswordController.handlePwdForPassport(this.b.mConfirmPayPass)));
            arrayList.add(new RestNameValuePair("seed", SecurePay.getInstance().encryptProxy(seed)));
            arrayList.add(new RestNameValuePair("key", SecurePay.getInstance().getpwProxy()));
            arrayList.add(new RestNameValuePair("sms_token", this.a.getSmsToken()));
            arrayList.add(new RestNameValuePair("session_id", this.a.getSessionId()));
            return arrayList;
        }
        throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
    }

    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD;
    }

    public String getEncode() {
        return BeanConstants.ENCODE_GB_18030;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_FIND_PASS_FROM_OLD_CARD_RESETPASS;
    }
}
