package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.dxmpay.apollon.beans.IBeanResponse;
import java.io.Serializable;

public class BindCardProtocolPreviewResponse implements IBeanResponse, Serializable {
    public String accessPartyId;
    public String protocolHtml;
    public String protocolType;
    public String templateCode;

    public boolean checkResponseValidity() {
        return true;
    }

    public void storeResponse(Context context) {
    }
}
