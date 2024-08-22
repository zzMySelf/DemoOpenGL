package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;

public class d extends BaseBean<CalcPaymentResponse> {
    public DirectPayContentResponse a = PayDataCache.getInstance().getPayResponse();
    public PayRequest b = ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY));
    public int c;
    public int d;
    public String e;
    public PayTypeItemView.PayTypeItemViewData f;

    public d(Context context) {
        super(context);
    }

    private String b() {
        if (2 == this.c) {
            return this.b.getCalcPayment().getCouponJsonParams(this.d, this.e);
        }
        return this.b.getCalcPayment().getCouponJsonParams();
    }

    public void a(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        this.f = payTypeItemViewData;
    }

    public void execBean() {
        super.execBean(CalcPaymentResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        String str;
        PayData.DirectPayBalance directPayBalance;
        ArrayList arrayList = new ArrayList();
        if (!(this.a == null || this.b == null)) {
            arrayList.add(new RestNameValuePair("source_flag", "3"));
            arrayList.add(new RestNameValuePair("first_sp_id_tpl", this.b.mSpNO));
            arrayList.add(new RestNameValuePair("trans_need_to_pay", PayDataCache.getInstance().getInsideTransOrder()));
            arrayList.add(new RestNameValuePair("seller_user_id", PayDataCache.getInstance().getSellerUserId()));
            arrayList.add(new RestNameValuePair("total_amount", this.b.getOrderPrice()));
            CardData.BondCard bondCard = null;
            if (this.b.hasDiscountOrCoupon()) {
                str = a();
                if (!TextUtils.isEmpty(b())) {
                    arrayList.add(new RestNameValuePair("coupon_list", b()));
                }
            } else {
                str = null;
            }
            UserData.UserModel userModel = this.a.user;
            String str2 = "0";
            if (userModel == null || !userModel.isSupportBalance()) {
                arrayList.add(new RestNameValuePair("balance_amount", str2));
            } else {
                PayData.DirectPayPay directPayPay = this.a.pay;
                if (!(directPayPay == null || (directPayBalance = directPayPay.balance) == null)) {
                    arrayList.add(new RestNameValuePair("balance_amount", directPayBalance.balance_trans_amount));
                }
            }
            PayTypeItemView.PayTypeItemViewData payTypeItemViewData = this.f;
            String str3 = "1";
            if (payTypeItemViewData != null) {
                PayTypeItemView.ItemViewType itemViewType = payTypeItemViewData.type;
                if (itemViewType == PayTypeItemView.ItemViewType.BALANCE) {
                    String str4 = str2;
                    str2 = str3;
                    str3 = str4;
                } else if (itemViewType != PayTypeItemView.ItemViewType.CREDIT) {
                    bondCard = payTypeItemViewData.card;
                    str3 = str2;
                }
            } else {
                str2 = this.b.getBalanceSelectStatus();
                str3 = this.b.getCreditPaySelectStatus();
                bondCard = this.b.mBondCard;
            }
            arrayList.add(new RestNameValuePair("need_calc_balance", str2));
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new RestNameValuePair("activity_list", str));
            }
            arrayList.add(new RestNameValuePair("need_calc_umoney", str3));
            arrayList.add(new RestNameValuePair("umoney_amount", this.b.getCreditTotalAmount()));
            if (bondCard != null) {
                arrayList.add(new RestNameValuePair("card_no", bondCard.account_no));
                arrayList.add(new RestNameValuePair("pay_bank_code", bondCard.account_bank_code));
                arrayList.add(new RestNameValuePair("easypay_channel", bondCard.bank_code));
            }
            if (this.b.getCalcPayment() != null) {
                arrayList.add(new RestNameValuePair("activity_map", this.b.getCalcPayment().getDiscountMapJsonParams()));
            }
        }
        return arrayList;
    }

    public int getBeanId() {
        return 16;
    }

    public String getUrl() {
        if (b.a()) {
            return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_SIGN_CALC_PAYMENT;
        }
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_CALC_PAYMENT;
    }

    public void a(int i2, int i3, String str) {
        this.c = i2;
        this.d = i3;
        this.e = str;
    }

    private String a() {
        if (1 == this.c) {
            return this.b.getCalcPayment().getActivitiesJsonParams(this.d, this.e);
        }
        return this.b.getCalcPayment().getActivitiesJsonParams();
    }
}
