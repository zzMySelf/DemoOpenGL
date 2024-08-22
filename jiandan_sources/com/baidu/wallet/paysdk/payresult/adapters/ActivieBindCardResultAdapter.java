package com.baidu.wallet.paysdk.payresult.adapters;

import com.dxmpay.wallet.core.BaseActivity;
import java.util.HashMap;

public class ActivieBindCardResultAdapter extends PayResultAdapter {
    public ActivieBindCardResultAdapter(BaseActivity baseActivity) {
        super(baseActivity);
    }

    public String getActionBarTextId() {
        return "dxm_ebpay_bind_card_result";
    }

    public HashMap<String, String> getPaySuccessContents() {
        super.getPaySuccessContents();
        this.contents.put("mainTip", "dxm_ebpay_bind_card_success");
        return this.contents;
    }

    public HashMap<String, String> getPayingContents() {
        super.getPayingContents();
        this.contents.put("mainTip", "dxm_ebpay_bind_card_success");
        return this.contents;
    }
}
