package com.baidu.wallet.paysdk.banksign.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.dxmpay.apollon.beans.IBeanResponse;
import java.io.Serializable;

public class QueryResponse implements IBeanResponse, Serializable {
    public String agreement_trans_id;
    public String dialog_hint;
    public Options[] dialog_options;
    public String dialog_title;
    public String form_data;
    public String form_url;
    public String sign_card_no;
    public int sign_state;
    public String toast_msg;
    public String webview_title;

    public static class Options implements Serializable {
        public static final String BIND_CARD = "bind_card";
        public static final String CANCEL = "cancel";
        public static final String CHANGE_PAYTYPE = "change_paytype";
        public static final String JUMP_RESIGN = "jump_resign";
        public static final String PAY = "pay";
        public String msg;
        public String type;

        public boolean isOperationAvilable() {
            return !TextUtils.isEmpty(this.type) && !TextUtils.isEmpty(this.msg);
        }
    }

    public boolean checkResponseValidity() {
        return true;
    }

    public boolean isGuidanceAvilable() {
        Options[] optionsArr = this.dialog_options;
        if (optionsArr == null || optionsArr.length != 3) {
            return false;
        }
        boolean z = false;
        for (Options isOperationAvilable : optionsArr) {
            z = isOperationAvilable.isOperationAvilable();
            if (!z) {
                break;
            }
        }
        return z;
    }

    public void storeResponse(Context context) {
    }
}
