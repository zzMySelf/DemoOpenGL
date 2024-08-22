package com.baidu.wallet.paysdk.fingerprint.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.dxmpay.apollon.beans.IBeanResponse;

public class OpenFingerprintResponse implements IBeanResponse {
    public String token_info;

    public boolean checkResponseValidity() {
        return !TextUtils.isEmpty(this.token_info);
    }

    public void storeResponse(Context context) {
    }
}
