package com.baidu.wallet.paysdk.b;

import android.text.TextUtils;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.wallet.base.datamodel.UserData;

@Deprecated
public class a extends b {
    public void a(String... strArr) {
        if (strArr.length > 1) {
            this.a.a(strArr[0], "");
        }
        this.a.a(QueryResponse.Options.BIND_CARD);
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

    public boolean b() {
        return true;
    }

    public String c() {
        BindFastRequest bindFastRequest = this.e;
        if (bindFastRequest == null || bindFastRequest.getmBankInfo() == null || TextUtils.isEmpty(this.e.getmBankInfo().getOneCentsDesc())) {
            return super.c();
        }
        return this.e.getmBankInfo().getOneCentsDesc();
    }

    public void a() {
        super.a();
        BindFastRequest bindFastRequest = this.e;
        if (!(bindFastRequest == null || bindFastRequest.getmBankInfo() == null || this.e.getmBankInfo().channel_info == null || this.e.getmBankInfo().channel_info.card_item_required == null)) {
            this.f = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.valid_code);
            boolean z = false;
            this.g = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.true_name) && !g();
            this.h = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.valid_date);
            this.f3595i = ("1".equals(this.e.getmBankInfo().channel_info.card_item_required.certificate_code) && TextUtils.isEmpty(PayDataCache.getInstance().getUserId())) || ("1".equals(this.e.getmBankInfo().channel_info.card_item_required.certificate_code) && !TextUtils.isEmpty(PayDataCache.getInstance().getUserId()) && !a(PayDataCache.getInstance().getCertificateType(), v())) || ("1".equals(this.e.getmBankInfo().channel_info.card_item_required.certificate_code) && !TextUtils.isEmpty(PayDataCache.getInstance().getUserId()) && a(PayDataCache.getInstance().getCertificateType(), v()) && a(w()) != null && !"1".equals(a(w()).b()));
            if ("1".equals(this.e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()))) {
                z = true;
            }
            this.j = z;
            this.k = "1".equals(this.e.getmBankInfo().channel_info.card_item_required.certificate_type);
        }
        if (this.d != null) {
            BindFastRequest bindFastRequest2 = this.e;
            if (bindFastRequest2 == null || bindFastRequest2.getmBankInfo() == null) {
                this.d.updateBankTitleInfo((GetCardInfoResponse.CardInfo) null, true);
            } else {
                this.d.updateBankTitleInfo(this.e.getmBankInfo().card_info, true);
            }
            BindFastRequest bindFastRequest3 = this.e;
            if (bindFastRequest3 == null || bindFastRequest3.getmBankInfo() == null) {
                this.d.updateBindCardProtocolFields((GetCardInfoResponse.ProtocolPlatformInfo) null);
                this.d.updateProtocolFields((GetCardInfoResponse.ProtocolInfo) null);
            } else if (BindFastRequest.BIND_FROM_INITIATIVE.equals(this.e.getCardRequestType())) {
                this.d.updateBindCardProtocolFields(this.e.getmBankInfo().protocol_platform_info);
            } else {
                this.d.updateProtocolFields(this.e.getmBankInfo().protocol_info);
            }
            this.d.updateCardElement(this.f, this.h, this.g, this.f3595i, this.j);
        }
    }
}
