package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.dxmpay.apollon.beans.IBeanResponse;
import java.io.Serializable;

public class OfflinePayQueryResponse implements IBeanResponse, Serializable {
    public String notify;

    public boolean checkResponseValidity() {
        return true;
    }

    public void storeResponse(Context context) {
    }
}
