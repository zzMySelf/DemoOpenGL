package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.PayUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.List;

public class p extends BaseBean<GetCardInfoResponse> {
    public boolean a;
    public BindFastRequest b;
    public PayRequest c;
    public String d;
    public String e;
    public String f;
    public DirectPayContentResponse g;

    public <T> p(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = "";
        this.e = "";
        this.f = "";
        this.a = true;
        this.g = PayDataCache.getInstance().getPayResponse();
        this.c = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
    }

    private boolean b() {
        BindFastRequest bindFastRequest = this.b;
        if (bindFastRequest != null) {
            return "13".equals(bindFastRequest.getCardRequestType());
        }
        return false;
    }

    private List<RestNameValuePair> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("request_type", "13"));
        arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.d)));
        if (!TextUtils.isEmpty(this.b.getSubBankCode())) {
            arrayList.add(new RestNameValuePair("front_bank_code", this.b.getSubBankCode()));
        }
        if (!TextUtils.isEmpty(this.e)) {
            arrayList.add(new RestNameValuePair("card_no_bind", this.e));
        }
        arrayList.addAll(PayDataCache.getInstance().getSessionData());
        return arrayList;
    }

    public void a(String str, String str2) {
        this.d = str;
        this.e = str2;
    }

    public void execBean() {
        super.execBean(GetCardInfoResponse.class, ErrorContentResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        PayData.DirectPayBalance directPayBalance;
        if (b()) {
            return c();
        }
        if (this.b != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("request_type", this.b.getCardRequestType()));
            arrayList.add(new RestNameValuePair("service_type", this.b.getServiceType()));
            arrayList.add(new RestNameValuePair("service", this.f));
            if (!TextUtils.isEmpty(this.d)) {
                arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.d)));
            }
            if (this.b.getmBondCard() != null) {
                arrayList.add(new RestNameValuePair("card_no_bind", this.b.getmBondCard().account_no));
            }
            PayRequest payRequest = this.c;
            if (payRequest == null || !this.a) {
                if (!this.a) {
                    this.a = true;
                }
                arrayList.add(new RestNameValuePair("is_transfer", "0"));
            } else {
                arrayList.add(new RestNameValuePair("is_transfer", payRequest.isTransfer()));
            }
            arrayList.add(new RestNameValuePair("source_flag", "3"));
            if (this.b.getmBindFrom() == 0 || this.b.getmBindFrom() == 2 || a()) {
                if (a()) {
                    b.a(arrayList);
                }
                PayRequest payRequest2 = this.c;
                if (payRequest2 != null && !TextUtils.isEmpty(payRequest2.mSpNO)) {
                    arrayList.add(new RestNameValuePair("first_sp_id_tpl", this.c.mSpNO));
                    arrayList.add(new RestNameValuePair(StatHelper.SP_NO, this.c.mSpNO));
                }
                PayRequest payRequest3 = this.c;
                if (payRequest3 != null && !TextUtils.isEmpty(payRequest3.mOrderNo)) {
                    arrayList.add(new RestNameValuePair("order_no", this.c.mOrderNo));
                }
                if (!TextUtils.isEmpty(PayDataCache.getInstance().getInsideTransOrder())) {
                    arrayList.add(new RestNameValuePair("trans_need_to_pay", PayDataCache.getInstance().getInsideTransOrder()));
                }
                if (!TextUtils.isEmpty(PayDataCache.getInstance().getSellerUserId())) {
                    arrayList.add(new RestNameValuePair("seller_user_id", PayDataCache.getInstance().getSellerUserId()));
                }
                PayRequest payRequest4 = this.c;
                if (payRequest4 != null) {
                    arrayList.add(new RestNameValuePair("total_amount", payRequest4.getOrderPrice()));
                    arrayList.add(new RestNameValuePair("pay_amount", this.c.getEasyPayAmount()));
                    if (this.b.getmBindFrom() == 0) {
                        arrayList.add(new RestNameValuePair("need_calc_balance", "0"));
                        UserData.UserModel userModel = this.g.user;
                        if (userModel == null || !userModel.isSupportBalance()) {
                            arrayList.add(new RestNameValuePair("balance_amount", "0"));
                        } else {
                            PayData.DirectPayPay directPayPay = this.g.pay;
                            if (!(directPayPay == null || (directPayBalance = directPayPay.balance) == null)) {
                                arrayList.add(new RestNameValuePair("balance_amount", directPayBalance.balance_trans_amount));
                            }
                        }
                        arrayList.add(new RestNameValuePair("need_calc_umoney", "0"));
                        arrayList.add(new RestNameValuePair("umoney_amount", this.c.getCreditTotalAmount()));
                        if (this.c.hasDiscountOrCoupon()) {
                            String activitiesJsonParams = this.c.getCalcPayment().getActivitiesJsonParams();
                            String couponJsonParams = this.c.getCalcPayment().getCouponJsonParams();
                            if (!TextUtils.isEmpty(couponJsonParams)) {
                                arrayList.add(new RestNameValuePair("coupon_list", couponJsonParams));
                            }
                            if (!TextUtils.isEmpty(activitiesJsonParams)) {
                                arrayList.add(new RestNameValuePair("activity_list", activitiesJsonParams));
                            }
                        }
                    }
                }
                CardData.BondCard bondCard = this.b.mBondCard;
                if (bondCard != null) {
                    arrayList.add(new RestNameValuePair("easypay_channel", bondCard.bank_code));
                }
            } else if (this.b.getmBindFrom() == 1) {
                PayRequest payRequest5 = this.c;
                if (payRequest5 != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest5.getPayFrom())) {
                    arrayList.add(new RestNameValuePair(StatHelper.SP_NO, this.c.mSpNO));
                    if (!TextUtils.isEmpty(this.c.mOrderNo)) {
                        arrayList.add(new RestNameValuePair("order_no", this.c.mOrderNo));
                    }
                } else if (!TextUtils.isEmpty(this.b.getSp_no())) {
                    arrayList.add(new RestNameValuePair(StatHelper.SP_NO, this.b.getSp_no()));
                }
            }
            if (!TextUtils.isEmpty(this.b.getSubBankCode())) {
                arrayList.add(new RestNameValuePair("sub_bank_code", this.b.getSubBankCode()));
            }
            arrayList.add(new RestNameValuePair("session_id", this.b.getSessionId()));
            return arrayList;
        }
        throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
    }

    public int getBeanId() {
        return 4;
    }

    public String getUrl() {
        if (b()) {
            return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_VERIFY_CARDINFO;
        } else if (a()) {
            return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_SIGN_CARD_INFO;
        } else {
            return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_GET_CARD_INFO;
        }
    }

    public void a(String str) {
        this.f = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.mBindFrom;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a() {
        /*
            r4 = this;
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r0 = r4.b
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0014
            r3 = 6
            int r0 = r0.mBindFrom
            if (r3 == r0) goto L_0x0012
            r3 = 7
            if (r3 == r0) goto L_0x0012
            r3 = 8
            if (r3 != r0) goto L_0x0014
        L_0x0012:
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            boolean r3 = com.baidu.wallet.paysdk.a.b.a()
            if (r3 == 0) goto L_0x001e
            if (r0 == 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r1 = 0
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.beans.p.a():boolean");
    }

    public void a(BindFastRequest bindFastRequest) {
        this.b = bindFastRequest;
    }
}
