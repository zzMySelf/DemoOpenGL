package com.baidu.android.lbspay.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.channelpay.PayDataBean;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.io.Serializable;
import org.json.JSONException;

public class GetPayContent implements IBeanResponse, Serializable {
    public static final String TAG = "GetPayContent";
    public static final long serialVersionUID = 1;
    public int authorize_err_no;
    public String authorize_return_data;
    public CashierDataNew extraOrderInfo;
    public String order_info;
    public int payId;
    public String pay_result_param;
    public String pay_result_url;
    public String paydata;
    public String payurl;
    public String quthorize_err_msg;
    public String redirect_sp_succpage_remain_time;
    public PrecashierCreateOrderResponse sdk_info;

    public boolean checkResponseValidity() {
        return true;
    }

    public PayDataBean getPayData() {
        if (!TextUtils.isEmpty(this.paydata)) {
            String str = new String(Base64.decode(this.paydata, 0));
            "decodeddata=" + str;
            try {
                return (PayDataBean) JsonUtils.fromJson(str, PayDataBean.class);
            } catch (JSONException e) {
                LogUtil.e(TAG, e.getMessage(), e);
            }
        }
        return null;
    }

    public int getPayId() {
        return this.payId;
    }

    public void setPayId(int i2) {
        this.payId = i2;
    }

    public void storeResponse(Context context) {
    }
}
