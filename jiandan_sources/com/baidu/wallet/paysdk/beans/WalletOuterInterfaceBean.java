package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.WalletOutInterfaceResponse;
import com.baidu.wallet.paysdk.storage.PayPreferenceManager;
import java.util.ArrayList;
import java.util.List;

public class WalletOuterInterfaceBean extends BaseBean<WalletOutInterfaceResponse> {
    public static final int BEAN_ID_GET_WALLET_INTERFACE = 525;

    public WalletOuterInterfaceBean(Context context) {
        super(context);
    }

    private boolean a(Context context) {
        return ((Boolean) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_for_home_mask_switch" + PayPreferenceManager.getNewPpKey(context), Boolean.FALSE)).booleanValue();
    }

    public void execBean() {
        super.execBean(WalletOutInterfaceResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("isOpenSecurity", a(this.mContext) ? "1" : "0"));
        return arrayList;
    }

    public int getBeanId() {
        return BEAN_ID_GET_WALLET_INTERFACE;
    }

    public int getHttpMethod() {
        return 0;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppHost(this.tag) + BeanConstants.API_WALLET_INTERFACE;
    }
}
