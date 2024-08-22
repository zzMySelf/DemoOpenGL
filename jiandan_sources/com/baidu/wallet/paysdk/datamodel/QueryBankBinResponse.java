package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.dxmpay.apollon.beans.IBeanResponse;
import java.io.Serializable;

public class QueryBankBinResponse implements IBeanResponse, Serializable {
    public static final long serialVersionUID = -7267923736947733889L;
    public GetCardInfoResponse.CardInfo card_info;

    public boolean checkResponseValidity() {
        return this.card_info != null;
    }

    public void storeResponse(Context context) {
    }
}
