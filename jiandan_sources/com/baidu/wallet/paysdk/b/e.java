package com.baidu.wallet.paysdk.b;

import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.utils.ResUtils;

public class e extends b {
    public void a(String... strArr) {
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
        this.a.a("repair_card_info");
        super.a(strArr);
    }

    public void b(String... strArr) {
        String str;
        String str2;
        String str3;
        CardData.BondCard bondCard = this.e.getmBondCard();
        if (bondCard != null) {
            str2 = bondCard.true_name;
            str = bondCard.certificate_code;
            str3 = bondCard.mobile;
        } else {
            str3 = "";
            str2 = str3;
            str = str2;
        }
        if (strArr.length >= 5) {
            if (k()) {
                this.e.setmCvv(strArr[0]);
            }
            if (l()) {
                this.e.setmValidDate(strArr[1].replaceAll("/", ""));
            }
            if (j()) {
                this.e.setmName(strArr[2]);
            } else {
                this.e.setmName(str2);
            }
            if (m()) {
                this.e.setmIdCard(strArr[3]);
            } else {
                this.e.setmIdCard(str);
            }
            if (n()) {
                this.e.setmPhone(strArr[4].replaceAll(" ", ""));
            } else {
                this.e.setmPhone(str3);
            }
        }
        super.b(strArr);
    }

    public boolean g() {
        return !TextUtils.isEmpty(PayDataCache.getInstance().hasMobilePwd() ? PayDataCache.getInstance().getFormatUserName() : "");
    }

    public String p() {
        CardData.BondCard bondCard = this.e.mBondCard;
        if (bondCard == null) {
            this.d.finish();
            return super.p();
        }
        String last4Num = bondCard.getLast4Num();
        if (!PayDataCache.getInstance().hasMobilePwd()) {
            return String.format(ResUtils.getString(this.d, "ebpay_hint_last4num"), new Object[]{last4Num});
        } else if (this.e.mBondCard.card_type == 2) {
            return this.e.mBondCard.bank_name + " " + ResUtils.getString(this.d, "wallet_base_mode_debit") + " " + ResUtils.getString(this.d, "ebpay_last_nums") + last4Num;
        } else {
            return this.e.mBondCard.bank_name + " " + ResUtils.getString(this.d, "wallet_base_mode_credit") + " " + ResUtils.getString(this.d, "ebpay_last_nums") + last4Num;
        }
    }

    public boolean q() {
        return !PayDataCache.getInstance().hasMobilePwd();
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
                this.g = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.true_name);
                this.h = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.valid_date);
                this.f3595i = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.certificate_code);
                if ("1".equals(this.e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()))) {
                    z7 = true;
                }
                this.j = z7;
                boolean equals = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.cert_start_date);
                boolean equals2 = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.cert_end_date);
                boolean equals3 = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.nationality);
                boolean equals4 = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.gender);
                boolean equals5 = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.job);
                z5 = equals2;
                z6 = equals;
                z = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.address);
                z4 = equals3;
                z3 = equals4;
                z2 = equals5;
            }
            if (this.d != null) {
                if (this.e.getmBankInfo() != null) {
                    this.d.updateBankTitleInfo(this.e.getmBankInfo().card_info, true);
                } else {
                    this.d.updateBankTitleInfo((GetCardInfoResponse.CardInfo) null, true);
                }
                if (this.e.getmBankInfo() == null) {
                    this.d.updateBindCardProtocolFields((GetCardInfoResponse.ProtocolPlatformInfo) null);
                    this.d.updateProtocolFields((GetCardInfoResponse.ProtocolInfo) null);
                } else if (BindFastRequest.BIND_FROM_INITIATIVE.equals(this.e.getCardRequestType())) {
                    this.d.updateBindCardProtocolFields(this.e.getmBankInfo().protocol_platform_info);
                } else {
                    this.d.updateProtocolFields(this.e.getmBankInfo().protocol_info);
                }
                this.d.updateCardElement(this.f, this.h, this.g, this.f3595i, this.j);
                this.d.updateCompliance(z6, z5, z4, z3, z2, z);
            }
        }
    }
}
