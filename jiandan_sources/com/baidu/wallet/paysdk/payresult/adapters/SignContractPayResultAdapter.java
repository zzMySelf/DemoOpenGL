package com.baidu.wallet.paysdk.payresult.adapters;

import android.os.Bundle;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.dxmpay.wallet.core.BaseActivity;
import java.util.HashMap;

public class SignContractPayResultAdapter extends BasePayResultAdapter {
    public SignContractPayResultAdapter(BaseActivity baseActivity) {
        super(baseActivity);
    }

    public String getActionBarTextId() {
        return "ebpay_sign_contract_result";
    }

    public HashMap<String, String> getPaySuccessContents() {
        this.contents.clear();
        PayResultContent payResultContent = this.c;
        if (payResultContent == null || this.b == null) {
            return null;
        }
        if (payResultContent.isPaySuccess) {
            if (b.a()) {
                this.contents.put("mainTip", b.b() ? "ebpay_auth_payresult_sign_success" : "ebpay_auth_payresult_pay_success");
            } else {
                this.contents.put("mainTip", "ebpay_pay_success");
            }
            this.contents.put("statusDrawableName", "wallet_base_result_main_success");
            this.contents.put("okBtnText", "dxm_ebpay_result_btn_success");
            this.contents.put("payDetailInfo", this.c.pay_detail_info);
        }
        return this.contents;
    }

    public HashMap<String, String> getPayingContents() {
        this.contents.clear();
        PayResultContent payResultContent = this.c;
        if (payResultContent == null || this.b == null) {
            return null;
        }
        if (!payResultContent.isPaySuccess) {
            this.contents.put("statusDrawableName", "dxm_wallet_base_result_paying");
            this.contents.put("mainTip", b.a() ? "ebpay_sign_paying" : "ebpay_pay_paying");
            this.contents.put("errorMsg", this.c.mErrorMsg);
        }
        return this.contents;
    }

    public void handleOKBtnOnclick() {
        PayCallBackManager.callBackClientSuccess(((BaseActivity) this.a.get()).getActivity(), "");
    }

    public boolean onCreateCheckInvalide(Bundle bundle) {
        super.onCreateCheckInvalide(bundle);
        return this.c != null;
    }
}
