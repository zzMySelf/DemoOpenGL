package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.dxmpay.apollon.beans.IBeanResponse;
import java.io.Serializable;

public class VerifyPayPasswordResponse implements IBeanResponse, Serializable {
    public static final int HAS_PWD_DEFAULT = 0;
    public int has_pwd = 0;

    public boolean checkResponseValidity() {
        return true;
    }

    public void storeResponse(Context context) {
    }
}
