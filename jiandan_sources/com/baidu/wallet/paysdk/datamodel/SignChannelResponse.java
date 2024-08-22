package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.dxmpay.apollon.beans.IBeanResponse;

public class SignChannelResponse implements IBeanResponse {
    public SignBank[] arr_credit;
    public SignBank[] arr_debit;

    public boolean checkResponseValidity() {
        return true;
    }

    public void storeResponse(Context context) {
    }
}
