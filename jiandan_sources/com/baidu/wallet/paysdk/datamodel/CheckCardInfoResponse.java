package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.dxmpay.apollon.beans.IBeanResponse;
import java.util.Map;

public class CheckCardInfoResponse implements IBeanResponse {
    public Map<String, String> cashdesk;
    public String channel_no;
    public String display_reset_route;
    public String need_verify_sms;
    public int send_sms_by_bfb;
    public String send_sms_phone;
    public String send_sms_tips;
    public String sms_length;
    public String sms_pattern;
    public String sms_type;
    public String update_mobile_desc;

    public boolean checkResponseValidity() {
        return true;
    }

    public void storeResponse(Context context) {
    }
}
