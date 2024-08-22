package com.baidu.android.lbspay.network;

import android.content.Context;
import com.dxmpay.apollon.beans.IBeanResponse;
import java.io.Serializable;

public class AuthorizeSignContent implements IBeanResponse, Serializable {
    public SignData sign_data;

    public static class SignData implements Serializable {
        public String sign_channel;
        public String sign_query_url;
        public String sign_url;
    }

    public boolean checkResponseValidity() {
        return true;
    }

    public void storeResponse(Context context) {
    }
}
