package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.dxmpay.apollon.beans.IBeanResponse;

public class VerifyByBankResponse implements IBeanResponse {
    public String channel_no;
    public String send_sms_by_bfb;
    public String send_sms_desc;
    public String send_sms_descript;
    public String send_sms_phone;
    public String sms_length;
    public String sms_pattern;
    public String sms_type;

    public boolean checkResponseValidity() {
        return true;
    }

    public void storeResponse(Context context) {
    }
}
