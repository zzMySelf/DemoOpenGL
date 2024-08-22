package com.baidu.android.lbspay.network;

import android.content.Context;
import com.dxmpay.apollon.beans.IBeanResponse;
import java.io.Serializable;

public class SignResultResponse implements IBeanResponse, Serializable {
    public String customerId;
    public int signStatus;

    public boolean checkResponseValidity() {
        return this.signStatus == 1;
    }

    public void storeResponse(Context context) {
    }
}
