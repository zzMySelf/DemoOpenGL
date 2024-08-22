package com.baidu.wallet.paysdk.b;

import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.utils.ResUtils;

public class g extends b {
    public boolean E() {
        if (PayDataCache.getInstance().hasMobilePwd()) {
            BindFastRequest bindFastRequest = this.e;
            if (bindFastRequest.mBondCard != null) {
                ErrorContentResponse errorContentResponse = bindFastRequest.mCardInfoUpdateContent;
                if (errorContentResponse == null || TextUtils.isEmpty(errorContentResponse.need_send_sms)) {
                    return this.e.mBondCard.isNeedSendSms();
                }
                return this.e.mCardInfoUpdateContent.isNeedSendSms();
            }
        }
        return true;
    }

    public void a(String... strArr) {
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        if (strArr.length > 1) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                this.a.a("", strArr[0]);
            } else {
                CardData.BondCard bondCard = this.e.mBondCard;
                if (bondCard != null) {
                    this.a.a(strArr[0], bondCard.account_no);
                } else {
                    this.a.a(strArr[0], "");
                }
            }
        }
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        if (!(payResponse == null || (directPayPay = payResponse.pay) == null || (easyPay = directPayPay.easypay) == null)) {
            this.a.a(easyPay.getService());
        }
        super.a(strArr);
    }

    public void b(String... strArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        CardData.BondCard bondCard = this.e.getmBondCard();
        if (s()) {
            Boolean valueOf = Boolean.valueOf(bondCard != null && PayDataCache.getInstance().hasMobilePwd());
            if (valueOf.booleanValue()) {
                this.e.setmBankCard(bondCard.account_no);
                this.e.setBankType(bondCard.card_type);
            }
            if (bondCard != null && !TextUtils.isEmpty(bondCard.bank_code)) {
                this.e.mBankNo = bondCard.bank_code;
            }
            if (!valueOf.booleanValue() || !bondCard.hasName()) {
                str4 = "";
            } else {
                str4 = bondCard.true_name;
            }
            if (!valueOf.booleanValue() || !bondCard.hasId()) {
                str3 = "";
            } else {
                str3 = bondCard.certificate_code;
            }
            if (bondCard != null && !TextUtils.isEmpty(bondCard.account_bank_code)) {
                this.e.setChannelNo(bondCard.account_bank_code);
            }
            if (this.n || !valueOf.booleanValue() || !bondCard.hasMobile()) {
                str2 = "";
            } else {
                str2 = bondCard.mobile;
            }
            if (this.m || !valueOf.booleanValue() || !bondCard.hasCvv()) {
                str = "";
            } else {
                str = bondCard.verify_code;
            }
            str5 = (this.l || !valueOf.booleanValue() || !bondCard.hasDate()) ? "" : bondCard.valid_date;
        } else {
            if (5 <= strArr.length && TextUtils.isDigitsOnly(strArr[4])) {
                str6 = strArr[4];
            } else if (bondCard != null) {
                str6 = bondCard.mobile;
            } else {
                str5 = "";
                str4 = str5;
                str3 = str4;
                str2 = str3;
                str = str2;
            }
            str5 = "";
            str4 = str5;
            str3 = str4;
            str = str3;
        }
        if (strArr.length >= 6) {
            if (k()) {
                this.e.setmCvv(strArr[0]);
            } else if (!TextUtils.isEmpty(str)) {
                this.e.setmCvv(str);
            }
            if (l()) {
                this.e.setmValidDate(strArr[1].replaceAll("/", ""));
            } else if (!TextUtils.isEmpty(str5)) {
                this.e.setmValidDate(str5);
            }
            if (j()) {
                this.e.setmName(strArr[2]);
            } else if (!TextUtils.isEmpty(str4)) {
                this.e.setmName(str4);
            }
            if (m()) {
                this.e.setmIdCard(strArr[3]);
            } else if (!TextUtils.isEmpty(str3)) {
                this.e.setmIdCard(str3);
            }
            if (n()) {
                this.e.setmPhone(strArr[4].replaceAll(" ", ""));
            } else if (!TextUtils.isEmpty(str2)) {
                this.e.setmPhone(str2);
            }
            if (this.k || !TextUtils.isEmpty(strArr[5])) {
                this.e.setCertificateType(strArr[5]);
            } else {
                this.e.setCertificateType("");
            }
        }
        super.b(strArr);
    }

    public boolean g() {
        CardData.BondCard bondCard = this.e.mBondCard;
        if (bondCard != null && "1".equals(bondCard.need_true_name)) {
            return false;
        }
        if (TextUtils.isEmpty(PayDataCache.getInstance().hasMobilePwd() ? PayDataCache.getInstance().getFormatUserName() : "")) {
            return false;
        }
        return true;
    }

    public String p() {
        CardData.BondCard bondCard = this.e.mBondCard;
        if (bondCard == null) {
            this.d.finish();
            return super.p();
        }
        String last4Num = bondCard.getLast4Num();
        if (s()) {
            if (this.e.mBondCard.card_type == 2) {
                return this.e.mBondCard.bank_name + " " + ResUtils.getString(this.d, "wallet_base_mode_debit") + " " + ResUtils.getString(this.d, "ebpay_last_nums") + last4Num;
            }
            return this.e.mBondCard.bank_name + " " + ResUtils.getString(this.d, "wallet_base_mode_credit") + " " + ResUtils.getString(this.d, "ebpay_last_nums") + last4Num;
        } else if (PayDataCache.getInstance().hasMobilePwd()) {
            if (this.e.mBondCard.card_type == 2) {
                return this.e.mBondCard.bank_name + " " + ResUtils.getString(this.d, "wallet_base_mode_debit") + " " + ResUtils.getString(this.d, "ebpay_last_nums") + last4Num;
            }
            return this.e.mBondCard.bank_name + " " + ResUtils.getString(this.d, "wallet_base_mode_credit") + " " + ResUtils.getString(this.d, "ebpay_last_nums") + last4Num;
        } else if (this.e.mBondCard.card_type == 2) {
            return this.e.mBondCard.bank_name + " " + ResUtils.getString(this.d, "wallet_base_mode_debit") + " " + ResUtils.getString(this.d, "ebpay_last_nums") + last4Num;
        } else {
            return this.e.mBondCard.bank_name + " " + ResUtils.getString(this.d, "wallet_base_mode_credit") + " " + ResUtils.getString(this.d, "ebpay_last_nums") + last4Num;
        }
    }

    public boolean q() {
        if (!s() && !PayDataCache.getInstance().hasMobilePwd()) {
            return true;
        }
        return false;
    }

    public boolean t() {
        return true;
    }

    public GetCardInfoResponse.CertificateTypeInfo[] v() {
        GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr;
        BindFastRequest bindFastRequest = this.e;
        GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr2 = null;
        if (bindFastRequest != null) {
            if (bindFastRequest.getmBankInfo() == null || this.e.getmBankInfo().channel_info == null) {
                ErrorContentResponse errorContentResponse = this.e.mCardInfoUpdateContent;
                if (errorContentResponse == null || (certificateTypeInfoArr = errorContentResponse.certificate_type_info) == null) {
                    if (this.e.getmBondCard() != null) {
                        certificateTypeInfoArr = this.e.getmBondCard().certificate_type_info;
                    }
                }
                certificateTypeInfoArr2 = certificateTypeInfoArr;
            } else {
                certificateTypeInfoArr2 = this.e.getmBankInfo().channel_info.certificate_type_info;
            }
        }
        if (certificateTypeInfoArr2 != null && certificateTypeInfoArr2.length != 0) {
            return certificateTypeInfoArr2;
        }
        GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = new GetCardInfoResponse.CertificateTypeInfo();
        certificateTypeInfo.type = "1";
        certificateTypeInfo.description = ResUtils.getString(this.d, "ebpay_certificate");
        return new GetCardInfoResponse.CertificateTypeInfo[]{certificateTypeInfo};
    }

    public void a() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        super.a();
        BindFastRequest bindFastRequest = this.e;
        boolean z13 = false;
        if (bindFastRequest != null) {
            if (bindFastRequest.getmBankInfo() == null || this.e.getmBankInfo().channel_info == null || this.e.getmBankInfo().channel_info.card_item_required == null) {
                CardData.BondCard bondCard = this.e.mBondCard;
                if (bondCard != null) {
                    this.f = !bondCard.hasCvv();
                    this.g = !this.e.mBondCard.hasName();
                    this.h = !this.e.mBondCard.hasDate();
                    this.f3595i = !this.e.mBondCard.hasId();
                    this.j = !this.e.mBondCard.hasMobile();
                    this.k = !this.e.mBondCard.hasIdType();
                }
                z12 = false;
                z11 = false;
                z10 = false;
                z9 = false;
                z8 = false;
                z7 = false;
            } else {
                this.f = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.valid_code);
                this.g = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.true_name);
                this.h = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.valid_date);
                this.f3595i = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.certificate_code);
                this.j = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()));
                this.k = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.certificate_type);
                z12 = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.cert_start_date);
                z11 = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.cert_end_date);
                z10 = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.nationality);
                z9 = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.gender);
                z8 = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.job);
                z7 = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.address);
            }
            if (this.e.getmBondCard() != null) {
                this.f = this.f || "1".equals(this.e.getmBondCard().need_cvv2);
                if (this.h || "1".equals(this.e.getmBondCard().need_valid_date)) {
                    z13 = true;
                }
                this.h = z13;
            }
            z6 = z12;
            z5 = z11;
            z4 = z10;
            z3 = z9;
            z2 = z8;
            z = z7;
        } else {
            z6 = false;
            z5 = false;
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
        }
        if (this.d != null) {
            if (!q()) {
                this.d.updateBankTitleInfo((GetCardInfoResponse.CardInfo) null, true);
            } else if (this.e.getmBankInfo() != null) {
                this.d.updateBankTitleInfo(this.e.getmBankInfo().card_info, true);
            } else {
                this.d.updateBankTitleInfo((GetCardInfoResponse.CardInfo) null, true);
            }
            this.d.updateCardElement(this.f, this.h, this.g, this.f3595i, this.j);
            this.d.updateCompliance(z6, z5, z4, z3, z2, z);
        }
    }

    public String[] a(int i2) {
        String[] strArr = new String[2];
        String string = ResUtils.getString(this.d, "ebpay_title_complete_info_for_pay");
        if (i2 == 0) {
            string = ResUtils.getString(this.d, "ebpay_title_complete_info_for_pay");
        } else if (i2 == 1) {
            string = ResUtils.getString(this.d, "ebpay_title_complete_info_for_pay");
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
