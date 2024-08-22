package com.baidu.wallet.paysdk.banksign.datamodel;

import android.content.Context;
import com.dxmpay.apollon.beans.IBeanResponse;

public class BindCardResponse implements IBeanResponse {
    public String sign_card_no;

    public boolean checkResponseValidity() {
        return true;
    }

    public void storeResponse(Context context) {
    }
}
