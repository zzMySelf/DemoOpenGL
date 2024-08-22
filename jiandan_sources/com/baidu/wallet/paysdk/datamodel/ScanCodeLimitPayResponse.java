package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.dxmpay.apollon.beans.IBeanResponse;

public class ScanCodeLimitPayResponse implements IBeanResponse {
    public AuthInfo auth_info;
    public String bank_no;
    public String bank_send_trans_no;
    public String msg;
    public String notify;
    public O2OPayResultItemInfo pay_result;
    public String pay_type;
    public String paytype_desc;
    public String score;
    public String score_tip;

    public boolean checkResponseValidity() {
        return true;
    }

    public void storeResponse(Context context) {
    }
}
