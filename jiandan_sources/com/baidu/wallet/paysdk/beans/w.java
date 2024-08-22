package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class w extends BaseBean<Object> {
    public PwdRequest a = ((PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD));
    public String b;
    public boolean c;

    public <T> w(Context context) {
        super(context);
    }

    private void a(List<RestNameValuePair> list) {
        if (this.c && !TextUtils.isEmpty(this.b)) {
            try {
                JSONObject jSONObject = new JSONObject(this.b);
                jSONObject.remove("half_screen_pwd_verify");
                Iterator<String> keys = jSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Object opt = jSONObject.opt(next);
                        list.add(new RestNameValuePair(next, opt != null ? String.valueOf(opt) : ""));
                    }
                }
            } catch (JSONException e) {
                LogUtil.e("MobilePwdBean", e.getMessage(), e);
            }
        }
    }

    public void execBean() {
        super.execBean(String.class, ErrorContentResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        String seed = PasswordController.getSeed();
        String encryptProxy = SecurePay.getInstance().encryptProxy(seed);
        int i2 = this.a.mRequestType;
        if (i2 == 2 || i2 == 1) {
            if (!TextUtils.isEmpty(this.a.mPayPass)) {
                String handlePwd = PasswordController.handlePwd(this.a.mPayPass, seed);
                String str = SecurePay.getInstance().getpwProxy();
                arrayList.add(new RestNameValuePair("mobile_pwd", handlePwd));
                arrayList.add(new RestNameValuePair("key", str));
            }
            a((List<RestNameValuePair>) arrayList);
        } else {
            String encryptProxy2 = SecurePay.getInstance().encryptProxy(PasswordController.handlePwdSimple(this.a.mConfirmPayPass));
            String handlePwd2 = PasswordController.handlePwd(this.a.mConfirmPayPass, seed);
            String str2 = SecurePay.getInstance().getpwProxy();
            arrayList.add(new RestNameValuePair("new_mobile_pwd", encryptProxy2));
            arrayList.add(new RestNameValuePair("confirm_new_mobile_pwd", handlePwd2));
            arrayList.add(new RestNameValuePair("mobile_pwd_psp", PasswordController.handlePwdForPassport(this.a.mConfirmPayPass)));
            arrayList.add(new RestNameValuePair("key_no", str2));
            arrayList.add(new RestNameValuePair("sess_key", this.a.mSessionKey));
        }
        arrayList.add(new RestNameValuePair("seed", encryptProxy));
        PwdRequest pwdRequest = this.a;
        if (pwdRequest.mRequestType == 2 && TextUtils.equals(pwdRequest.fromType, DxmPayBeanConstants.FROM_BIND)) {
            BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
            arrayList.add(new RestNameValuePair("scenario", "bindcard"));
            arrayList.add(new RestNameValuePair("source_flag", "3"));
            if (bindFastRequest != null) {
                arrayList.add(new RestNameValuePair("request_type", bindFastRequest.getCardRequestType()));
            } else {
                arrayList.add(new RestNameValuePair("request_type", BindFastRequest.getCardRequestType(1)));
            }
            arrayList.add(new RestNameValuePair("service_type", this.a.serviceType));
        }
        return arrayList;
    }

    public int getBeanId() {
        int i2 = this.a.mRequestType;
        if (i2 == 2) {
            return 257;
        }
        return i2 == 3 ? PayBeanFactory.BEAN_ID_MODIFY_MOBILE_PWD : PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD;
    }

    public String getUrl() {
        int i2 = this.a.mRequestType;
        if (i2 == 2) {
            String str = PayRequestCache.getInstance().isPaying() ? DxmPayBeanConstants.API_VERIFY_PAY_PWD : DxmPayBeanConstants.API_VERIFY_MOBILE_PWD_NEW;
            return DomainConfig.getInstance().getAppPayHost() + str;
        } else if (i2 == 1) {
            return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_CHECK_MOBILE_PWD;
        } else if (i2 != 3) {
            return "";
        } else {
            return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_MODIFY_MOBILE_PWD;
        }
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(boolean z) {
        this.c = z;
    }
}
