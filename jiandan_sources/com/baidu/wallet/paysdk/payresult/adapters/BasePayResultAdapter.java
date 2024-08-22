package com.baidu.wallet.paysdk.payresult.adapters;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.wallet.core.BaseActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public class BasePayResultAdapter implements IPayResultDataAdapter {
    public WeakReference<BaseActivity> a;
    public PayRequest b;
    public PayResultContent c;
    public HashMap<String, String> contents = new HashMap<>();

    public BasePayResultAdapter(BaseActivity baseActivity) {
        this.a = new WeakReference<>(baseActivity);
    }

    public void a(String str, String str2) {
        EventBus instance = EventBus.getInstance();
        instance.getClass();
        EventBus.getInstance().post(new EventBus.Event(str, str2));
    }

    public void clearDataOnDestroy() {
        PayDataCache.getInstance().setPayReslutContent((PayResultContent) null);
    }

    public String getActionBarTextId() {
        return null;
    }

    public String getAuthorizeMsg() {
        return this.c.authorize_msg;
    }

    public ArrayList<String> getCouponContent() {
        PayResultContent payResultContent = this.c;
        if (payResultContent == null || TextUtils.isEmpty(payResultContent.coupon_msg)) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.c.coupon_msg);
        arrayList.add(this.c.coupon_find_prompt);
        return arrayList;
    }

    public ArrayList<String> getEventValue() {
        ArrayList<String> arrayList = new ArrayList<>();
        PayRequest payRequest = this.b;
        String str = "";
        arrayList.add(payRequest != null ? payRequest.mSpNO : str);
        PayRequest payRequest2 = this.b;
        if (payRequest2 != null) {
            str = payRequest2.mOrderNo;
        }
        arrayList.add(str);
        return arrayList;
    }

    public String getExpectedTime() {
        return null;
    }

    public String getFpOpenMsg() {
        return this.c.fp_open_or_update_msg;
    }

    public String getLBSPayText() {
        return isShowLBSPayText() ? this.b.mRemotePayHostName : "";
    }

    public ArrayList<String> getOKBtnOnClickEventValue() {
        ArrayList<String> arrayList = new ArrayList<>();
        PayRequest payRequest = this.b;
        String str = "";
        arrayList.add(payRequest != null ? payRequest.mSpNO : str);
        PayRequest payRequest2 = this.b;
        if (payRequest2 != null) {
            str = payRequest2.mOrderNo;
        }
        arrayList.add(str);
        return arrayList;
    }

    public PayResultContent getPayResultContent() {
        return this.c;
    }

    public HashMap<String, String> getPaySuccessContents() {
        PayRequest payRequest;
        this.contents.clear();
        PayResultContent payResultContent = this.c;
        if (payResultContent == null || (payRequest = this.b) == null) {
            return null;
        }
        if (payResultContent.isPaySuccess) {
            if (TextUtils.isEmpty(payRequest.withholding_auth) || !this.b.withholding_auth.equals("1")) {
                this.contents.put("mainTip", "ebpay_pay_success");
            } else {
                this.contents.put("mainTip", "dxm_wallet_withhold_success");
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
    }

    public boolean isBelongPaySdk() {
        return false;
    }

    public boolean isPaySuccess() {
        PayResultContent payResultContent = this.c;
        if (payResultContent == null || this.b == null) {
            return false;
        }
        return payResultContent.isPaySuccess;
    }

    public boolean isShowLBSPayText() {
        return PayDataCache.getInstance().isRemotePay() && !TextUtils.isEmpty(this.b.mRemotePayHostName);
    }

    public boolean onCreateCheckInvalide(Bundle bundle) {
        if (bundle != null) {
            this.c = (PayResultContent) bundle.getSerializable("mPayModle");
            this.b = (PayRequest) bundle.getSerializable("mPayRequest");
            return true;
        }
        this.c = PayDataCache.getInstance().getPayStateContent();
        this.b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        return true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        PayResultContent payResultContent = this.c;
        if (payResultContent != null) {
            bundle.putSerializable("mPayModle", payResultContent);
        }
        PayRequest payRequest = this.b;
        if (payRequest != null) {
            bundle.putSerializable("mPayRequest", payRequest);
        }
    }

    public boolean showCashbackDetail() {
        PayResultContent payResultContent = this.c;
        return (payResultContent == null || payResultContent.payResultCashbackDetail == null) ? false : true;
    }

    public boolean showMonkeylayout() {
        PayResultContent payResultContent = this.c;
        if (payResultContent == null) {
            return false;
        }
        if (!TextUtils.isEmpty(payResultContent.total_amount) || !TextUtils.isEmpty(this.c.cash_amount) || !TextUtils.isEmpty(this.c.discount_amount)) {
            return true;
        }
        String[][] strArr = this.c.paytype_info;
        return strArr != null && strArr.length > 0;
    }

    public boolean showResultPage() {
        PayResultContent payResultContent = this.c;
        return payResultContent != null && !"0".equalsIgnoreCase(payResultContent.redirect_sp_succpage_remain_time);
    }
}
