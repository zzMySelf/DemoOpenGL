package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.dxmpay.apollon.beans.IBeanResponse;
import java.io.Serializable;

public class LicaiBalancePayResponse implements IBeanResponse, Serializable {
    public RepaymentOrder fund;
    public String pay_result_params;
    public String pay_result_url;
    public String redirect_sp_succpage_remain_time;
    public RepaymentOrder repayment;
    public String show_h5_result;
    public String title_url;

    public static class RepaymentOrder implements Serializable {
        public String cash_amount;
        public String errno;
        public String notify;
    }

    public boolean checkResponseValidity() {
        return this.repayment != null;
    }

    public void storeResponse(Context context) {
    }

    public boolean toShowH5ResultPage() {
        return H5ResultParams.toShowH5ResultPage(this.redirect_sp_succpage_remain_time, this.pay_result_url, this.show_h5_result);
    }
}
