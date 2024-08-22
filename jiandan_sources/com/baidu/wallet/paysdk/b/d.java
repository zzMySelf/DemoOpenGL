package com.baidu.wallet.paysdk.b;

import android.text.TextUtils;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.a;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.wallet.base.datamodel.UserData;

@Deprecated
public class d extends b {
    public boolean F() {
        return true;
    }

    public a a(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
        return null;
    }

    public void a(String... strArr) {
        if (strArr.length > 1) {
            this.a.a(strArr[0], "");
        }
        this.a.a("find_password");
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

    public boolean g() {
        return !TextUtils.isEmpty(h());
    }

    public a u() {
        return null;
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
                this.f3595i = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.certificate_code);
                if ("1".equals(this.e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()))) {
                    z7 = true;
                }
                this.j = z7;
                this.k = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.certificate_type);
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
                BindFastRequest bindFastRequest2 = this.e;
                if (bindFastRequest2 == null || bindFastRequest2.getmBankInfo() == null) {
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
