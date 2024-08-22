package com.baidu.wallet.paysdk.payresult.adapters;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.dxmpay.wallet.core.BaseActivity;
import java.util.HashMap;

public class FastPayResultAdapter extends PayResultAdapter {
    public FastPayResultAdapter(BaseActivity baseActivity) {
        super(baseActivity);
    }

    public String getExpectedTime() {
        PayResultContent payResultContent = this.c;
        return (payResultContent == null || TextUtils.isEmpty(payResultContent.expected_time)) ? "" : this.c.expected_time;
    }

    public HashMap<String, String> getPayingContents() {
        super.getPayingContents();
        this.contents.put("mainTip", "ebpay_pay_error_huafei");
        return this.contents;
    }

    public boolean onCreateCheckInvalide(Bundle bundle) {
        super.onCreateCheckInvalide(bundle);
        return this.c != null;
    }
}
