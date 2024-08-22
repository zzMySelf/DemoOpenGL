package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.dxmpay.apollon.beans.IBeanResponse;

public class BindCardResponse implements IBeanResponse {
    public String activity_desc;
    public String card_no;
    public String notify;

    public boolean checkResponseValidity() {
        return true;
    }

    public void storeResponse(Context context) {
    }
}
