package com.baidu.wallet.paysdk.banksign.datamodel;

import android.content.Context;
import com.dxmpay.apollon.beans.IBeanResponse;

public class PollingResponse implements IBeanResponse {
    public int has_sign_result;
    public String toast_msg;

    public boolean checkResponseValidity() {
        return true;
    }

    public void storeResponse(Context context) {
    }
}
