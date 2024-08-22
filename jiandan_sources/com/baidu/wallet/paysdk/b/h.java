package com.baidu.wallet.paysdk.b;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.utils.StringUtils;

public class h extends b {
    public PayRequest r = ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY));

    public boolean C() {
        return !d();
    }

    public String D() {
        return (b.c() || !d()) ? "" : ResUtils.getString(this.d, "wallet_bindcard_addnewcard_tip");
    }

    public void a(String... strArr) {
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        BindFastRequest bindFastRequest = this.e;
        if (bindFastRequest != null) {
            bindFastRequest.setCalcPaymentResponse((CalcPaymentResponse) null);
        }
        if (strArr.length > 1) {
            this.a.a(strArr[0], "");
        }
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        if (!(payResponse == null || (directPayPay = payResponse.pay) == null || (easyPay = directPayPay.easypay) == null)) {
            this.a.a(easyPay.getService());
        }
        super.a(strArr);
    }

    public void b(String... strArr) {
        String str;
        String userName = PayDataCache.getInstance().getUserName();
        String userId = PayDataCache.getInstance().getUserId();
        String certificateType = PayDataCache.getInstance().getCertificateType();
        UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
        if (userInfo == null || TextUtils.isEmpty(userInfo.mobile_number)) {
            str = "";
        } else {
            str = userInfo.mobile_number;
        }
        if (strArr.length >= 6) {
            if (k()) {
                this.e.setmCvv(strArr[0]);
            }
            if (l()) {
                this.e.setmValidDate(strArr[1].replaceAll("/", ""));
            }
            if (j()) {
                this.e.setmName(strArr[2]);
            } else if (this.e.getmBankInfo() == null || this.e.getmBankInfo().channel_info == null || this.e.getmBankInfo().channel_info.card_item_required == null || !"1".equals(this.e.getmBankInfo().channel_info.card_item_required.true_name)) {
                this.e.setmName("");
            } else {
                this.e.setmName(userName);
            }
            if (m()) {
                this.e.setmIdCard(strArr[3]);
            } else if (this.e.getmBankInfo() == null || this.e.getmBankInfo().channel_info == null || this.e.getmBankInfo().channel_info.card_item_required == null || !"1".equals(this.e.getmBankInfo().channel_info.card_item_required.certificate_code)) {
                this.e.setmIdCard("");
            } else {
                this.e.setmIdCard(userId);
            }
            if (!TextUtils.isEmpty(strArr[4])) {
                this.e.setmPhone(strArr[4].replaceAll(" ", ""));
            } else if (this.e.getmBankInfo() == null || this.e.getmBankInfo().channel_info == null || this.e.getmBankInfo().channel_info.card_item_required == null || !"1".equals(this.e.getmBankInfo().channel_info.card_item_required.mobile)) {
                this.e.setmPhone("");
            } else {
                this.e.setmPhone(str);
            }
            if (m()) {
                if (this.k) {
                    this.e.setCertificateType(strArr[5]);
                } else {
                    this.e.setCertificateType("");
                }
            } else if (this.k) {
                this.e.setCertificateType(certificateType);
            } else {
                this.e.setCertificateType("");
            }
        }
        super.b(strArr);
    }

    public String c() {
        BindFastRequest bindFastRequest = this.e;
        if (bindFastRequest == null || bindFastRequest.getmBankInfo() == null || TextUtils.isEmpty(this.e.getmBankInfo().getOneCentsDesc())) {
            return super.c();
        }
        return this.e.getmBankInfo().getOneCentsDesc();
    }

    public boolean d() {
        if (i()) {
            return false;
        }
        if (this.e.getmBindFrom() == 6 && b.c() && !PayDataCache.getInstance().hasBondCards()) {
            return true;
        }
        if (this.e.getmBindFrom() != 0 || PayDataCache.getInstance().hasMobilePwd() || PayDataCache.getInstance().getBondCards() == null || PayDataCache.getInstance().getBondCards().length > 0) {
            return super.d();
        }
        return true;
    }

    public boolean e() {
        PayRequest payRequest = this.r;
        if (payRequest == null || !payRequest.showCouponListEntry()) {
            return super.e();
        }
        return true;
    }

    public boolean i() {
        if (!b.b() || PayDataCache.getInstance().hasBondCards()) {
            return super.i();
        }
        return true;
    }

    public void o() {
        PayRequest payRequest = this.r;
        if (payRequest != null) {
            String needToPayAmount = payRequest.getNeedToPayAmount();
            String orderPrice = this.r.getOrderPrice();
            String discountAmount = this.r.getDiscountAmount();
            String randomDiscountMsg = this.r.getRandomDiscountMsg();
            boolean z = !TextUtils.isEmpty(StringUtils.fen2Yuan(discountAmount)) && !StringUtils.fen2Yuan(discountAmount).equals("0.00");
            SpannableString spannableString = new SpannableString(ResUtils.getString(this.d, "dxm_wallet_base_unit") + StringUtils.fen2Yuan(orderPrice));
            if (z) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
            String str = "-" + ResUtils.getString(this.d, "dxm_wallet_base_unit") + StringUtils.fen2Yuan(discountAmount);
            if (z) {
                this.d.updateDiscountTxt(this.r.getGoodsName(), spannableString, this.r.getDiscountMsg(), str, StringUtils.fen2Yuan(needToPayAmount));
            } else if (this.r.showCouponListEntry()) {
                this.d.updateDiscountTxt(this.r.getGoodsName(), (CharSequence) null, this.r.getDiscountMsg(), str, StringUtils.fen2Yuan(needToPayAmount));
            } else {
                this.d.updateDiscountTxt(this.r.getGoodsName(), (CharSequence) null, randomDiscountMsg, (CharSequence) null, StringUtils.fen2Yuan(needToPayAmount));
            }
            this.d.updateDiscountTitle(this.r.title_url);
        }
    }

    public void a() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        super.a();
        BindFastRequest bindFastRequest = this.e;
        if (bindFastRequest != null) {
            boolean z7 = false;
            if (bindFastRequest.getmBankInfo() == null || this.e.getmBankInfo().channel_info == null || this.e.getmBankInfo().channel_info.card_item_required == null) {
                z6 = false;
                z5 = false;
                z4 = false;
                z3 = false;
                z2 = false;
                z = false;
            } else {
                this.f = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.valid_code);
                this.g = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.true_name) && !g();
                this.h = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.valid_date);
                boolean equals = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.cert_start_date);
                boolean equals2 = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.cert_end_date);
                boolean equals3 = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.nationality);
                boolean equals4 = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.gender);
                boolean equals5 = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.job);
                boolean equals6 = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.address);
                this.f3595i = ("1".equals(this.e.getmBankInfo().channel_info.card_item_required.certificate_code) && TextUtils.isEmpty(PayDataCache.getInstance().getUserId())) || ("1".equals(this.e.getmBankInfo().channel_info.card_item_required.certificate_code) && !TextUtils.isEmpty(PayDataCache.getInstance().getUserId()) && !a(PayDataCache.getInstance().getCertificateType(), v())) || ("1".equals(this.e.getmBankInfo().channel_info.card_item_required.certificate_code) && !TextUtils.isEmpty(PayDataCache.getInstance().getUserId()) && a(PayDataCache.getInstance().getCertificateType(), v()) && a(w()) != null && !"1".equals(a(w()).b()));
                if ("1".equals(this.e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()))) {
                    z7 = true;
                }
                this.j = z7;
                this.k = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.certificate_type);
                z6 = equals;
                z5 = equals2;
                z4 = equals3;
                z3 = equals4;
                z2 = equals5;
                z = equals6;
            }
            BindFastRequest bindFastRequest2 = this.e;
            if (bindFastRequest2 == null || bindFastRequest2.getmBankInfo() == null || this.e.getmBankInfo().channel_info == null) {
                this.e.setCalcPaymentResponse((CalcPaymentResponse) null);
            } else {
                BindFastRequest bindFastRequest3 = this.e;
                bindFastRequest3.setCalcPaymentResponse(bindFastRequest3.getmBankInfo().channel_info.mkt_info);
            }
            if (this.d != null) {
                if (this.e.getmBankInfo() != null) {
                    this.d.updateBankCouponDesc(this.e.getmBankInfo().getCardInfoCouponDesc());
                    this.d.updateBankTitleInfo(this.e.getmBankInfo().card_info, true);
                } else {
                    this.d.updateBankTitleInfo((GetCardInfoResponse.CardInfo) null, true);
                    this.d.updateBankCouponDesc("");
                }
                BindFastRequest bindFastRequest4 = this.e;
                if (bindFastRequest4 == null || bindFastRequest4.getmBankInfo() == null) {
                    this.d.updateBindCardProtocolFields((GetCardInfoResponse.ProtocolPlatformInfo) null);
                    this.d.updateProtocolFields((GetCardInfoResponse.ProtocolInfo) null);
                } else if (this.e.getmBankInfo().protocol_platform_info != null) {
                    this.d.updateBindCardProtocolFields(this.e.getmBankInfo().protocol_platform_info);
                } else {
                    this.d.updateProtocolFields(this.e.getmBankInfo().protocol_info);
                }
                this.d.updateCardElement(this.f, this.h, this.g, this.f3595i, this.j);
                this.d.updateCompliance(z6, z5, z4, z3, z2, z);
            }
        }
    }

    public boolean b() {
        return !d() && !i();
    }

    private String[] b(int i2) {
        Authorize authorize;
        String[] strArr = new String[2];
        String string = ResUtils.getString(this.d, "bd_wallet_withhold_title");
        if (i2 == 0) {
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            if (payResponse == null || (authorize = payResponse.authorize) == null || TextUtils.isEmpty(authorize.top_title)) {
                string = ResUtils.getString(this.d, "bd_wallet_withhold_title");
            } else {
                string = payResponse.authorize.top_title;
            }
        } else if (i2 == 1) {
            string = ResUtils.getString(this.d, "bd_wallet_bind_card_second");
        }
        String string2 = ResUtils.getString(this.d, "ebpay_pay_checkcard");
        if (i2 == 0) {
            string2 = ResUtils.getString(this.d, "ebpay_pay_checkcard");
        } else if (i2 == 1) {
            string2 = ResUtils.getString(this.d, "dxm_ebpay_pay_next");
        }
        strArr[0] = string;
        strArr[1] = string2;
        return strArr;
    }

    public String[] a(int i2) {
        if (b.a() && (PayDataCache.getInstance().getBondCards() == null || PayDataCache.getInstance().getBondCards().length <= 0)) {
            return b(i2);
        }
        if (PayDataCache.getInstance().hasMobilePwd() || PayDataCache.getInstance().getBondCards() == null || PayDataCache.getInstance().getBondCards().length > 0) {
            return super.a(i2);
        }
        String[] strArr = new String[2];
        String string = ResUtils.getString(this.d, "bd_wallet_bind_card_first_pay");
        if (i2 == 0) {
            string = ResUtils.getString(this.d, "bd_wallet_bind_card_first_pay");
        } else if (i2 == 1) {
            string = ResUtils.getString(this.d, "bd_wallet_bind_card_second");
        }
        String string2 = ResUtils.getString(this.d, "ebpay_pay_checkcard");
        if (i2 == 0) {
            string2 = ResUtils.getString(this.d, "ebpay_pay_checkcard");
        } else if (i2 == 1) {
            string2 = ResUtils.getString(this.d, "dxm_ebpay_pay_next");
        }
        strArr[0] = string;
        strArr[1] = string2;
        return strArr;
    }
}
