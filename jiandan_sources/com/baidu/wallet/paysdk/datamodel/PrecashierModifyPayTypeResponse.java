package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.dxmpay.wallet.base.datamodel.UserData;
import java.io.Serializable;
import java.util.Map;

public class PrecashierModifyPayTypeResponse extends DirectPayContentResponse implements IBeanResponse, Serializable {
    public static final String BIND_CARD_HD_SESSION_ID = "bind_card_hd_session_id";
    public static final long serialVersionUID = -936968920336557051L;
    public String mOriginHttpResponse;

    public static class a {
        public static PrecashierModifyPayTypeResponse a = new PrecashierModifyPayTypeResponse();
    }

    public static PrecashierModifyPayTypeResponse getInstance() {
        return a.a;
    }

    public static void updateContent(Object obj) {
        if (obj instanceof PrecashierModifyPayTypeResponse) {
            PrecashierModifyPayTypeResponse unused = a.a = (PrecashierModifyPayTypeResponse) obj;
        } else if (obj == null) {
            PrecashierModifyPayTypeResponse unused2 = a.a = null;
        }
    }

    public boolean checkResponseValidity() {
        return (this.pay == null && this.sp == null && this.user == null) ? false : true;
    }

    public void decrypt() {
        PayData.EasyPay easyPay;
        UserData.UserModel userModel = this.user;
        if (userModel != null) {
            userModel.decrypt();
        }
        PayData.DirectPayPay directPayPay = this.pay;
        if (directPayPay != null && (easyPay = directPayPay.easypay) != null) {
            easyPay.decrypt();
        }
    }

    public String getHdSessionId() {
        Map<String, String> map = this.cashdesk;
        return (map == null || map.isEmpty() || this.cashdesk.size() <= 0 || TextUtils.isEmpty(this.cashdesk.get(BIND_CARD_HD_SESSION_ID))) ? "" : this.cashdesk.get(BIND_CARD_HD_SESSION_ID);
    }

    public String getOriginHttpResponse() {
        return this.mOriginHttpResponse;
    }

    public void setOriginHttpResponse(String str) {
        this.mOriginHttpResponse = str;
    }

    public void storeResponse(Context context) {
        decrypt();
        updateContent(this);
        PayDataCache.getInstance().setPayResponse(this);
        PayDataCache.getInstance().setFromPreCashier();
    }
}
