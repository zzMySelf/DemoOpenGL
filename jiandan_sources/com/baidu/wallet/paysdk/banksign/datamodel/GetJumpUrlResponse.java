package com.baidu.wallet.paysdk.banksign.datamodel;

import android.content.Context;
import com.dxmpay.apollon.beans.IBeanResponse;

public class GetJumpUrlResponse implements IBeanResponse {
    public String agreement_trans_id;
    public String form_data;
    public String form_url;
    public int is_signed;
    public String signed_msg;
    public String webview_title;

    public boolean checkResponseValidity() {
        return true;
    }

    public void storeResponse(Context context) {
    }
}
