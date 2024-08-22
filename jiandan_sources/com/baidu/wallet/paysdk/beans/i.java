package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.paysdk.datamodel.CheckPwdErrorContent;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class i extends BaseBean<Void> {
    public PwdRequest a = ((PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD));

    public i(Context context) {
        super(context);
    }

    public void execBean() {
        super.execBean((Class) null, CheckPwdErrorContent.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (this.a == null) {
            return arrayList;
        }
        String seed = PasswordController.getSeed();
        arrayList.add(new RestNameValuePair("mobile_pwd", PasswordController.handlePwd(this.a.mPayPass, seed)));
        arrayList.add(new RestNameValuePair("seed", SecurePay.getInstance().encryptProxy(seed)));
        arrayList.add(new RestNameValuePair("key", SecurePay.getInstance().getpwProxy()));
        Map<String, String> map = this.a.mExtData;
        if (map == null) {
            return arrayList;
        }
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            arrayList.add(new RestNameValuePair(str, str2));
        }
        return arrayList;
    }

    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_CHECK_PWD;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_CHECK_PWD;
    }
}
