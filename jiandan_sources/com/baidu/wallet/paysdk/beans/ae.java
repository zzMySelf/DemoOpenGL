package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.VerifyByBankResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ae extends BaseBean<VerifyByBankResponse> {
    public static final String[] a = {"coupon_id", ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, "stage_number", "need_bind_card", "sms_vcode", "seed", "mobile_pwd", "confirm_mobile_pwd", "mobile_pwd_psp", "open_passfree", "fp_code", "fp_num", "need_open_passfree", "need_open_authorize", "message_vcode", "is_pay_sms"};
    public final List b = Arrays.asList(a);

    public ae(Context context) {
        super(context);
    }

    public void execBean() {
        super.execBean(VerifyByBankResponse.class, ErrorContentResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList(PayDataCache.getInstance().getPrePayRequestParams());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (this.b.indexOf(((RestNameValuePair) it.next()).getName()) != -1) {
                it.remove();
            }
        }
        return arrayList;
    }

    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_APPLY_VERIFY_SMS_BY_BANK;
    }
}
