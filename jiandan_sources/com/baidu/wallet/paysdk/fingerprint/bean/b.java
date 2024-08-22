package com.baidu.wallet.paysdk.fingerprint.bean;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.datamodel.OpenFingerprintResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;

public class b extends BaseBean<OpenFingerprintResponse> {
    public PwdRequest a = ((PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD));

    public b(Context context) {
        super(context);
    }

    public void execBean() {
        execBean(OpenFingerprintResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        PwdRequest pwdRequest = this.a;
        if (pwdRequest != null && !TextUtils.isEmpty(pwdRequest.mPayPass)) {
            String seed = PasswordController.getSeed();
            String encryptProxy = SecurePay.getInstance().encryptProxy(seed);
            arrayList.add(new RestNameValuePair("mobile_pwd", PasswordController.handlePwd(this.a.mPayPass, seed)));
            arrayList.add(new RestNameValuePair("seed", encryptProxy));
        }
        return arrayList;
    }

    public int getBeanId() {
        return FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_OPEN;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + "/cashdesk/wireless/fingerprint/open";
    }
}
