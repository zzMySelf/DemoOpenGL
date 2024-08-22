package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.dxmpay.apollon.beans.IBeanResponse;

public class O2OScancodeSendSMSRsp implements IBeanResponse {
    public int send_sms_by_bfb;
    public String sms_length;
    public String sms_pattern;
    public String sms_type;

    public boolean checkResponseValidity() {
        return true;
    }

    public void storeResponse(Context context) {
    }
}
