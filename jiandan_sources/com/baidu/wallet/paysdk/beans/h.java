package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CheckCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.List;

public class h extends BaseBean<CheckCardInfoResponse> {
    public static int a;
    public BindFastRequest b;
    public PayRequest c;
    public boolean d;
    public boolean e;

    public <T> h(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = false;
        this.e = false;
        this.c = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
    }

    private boolean c() {
        BindFastRequest bindFastRequest = this.b;
        if (bindFastRequest != null) {
            return "13".equals(bindFastRequest.getCardRequestType());
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.mBindFrom;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean d() {
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.beans.h.d():boolean");
    }

    private List<RestNameValuePair> e() {
        String str;
        if (this.b != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("request_type", "13"));
            arrayList.add(new RestNameValuePair("source_flag", "3"));
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.b.getmBankCard())));
            if (!TextUtils.isEmpty(this.b.getSubBankCode())) {
                arrayList.add(new RestNameValuePair("front_bank_code", this.b.getSubBankCode()));
            }
            if (!TextUtils.isEmpty(this.b.getmName())) {
                arrayList.add(new RestNameValuePair("true_name", this.b.getmName()));
            }
            if (!TextUtils.isEmpty(this.b.getCertificateType())) {
                arrayList.add(new RestNameValuePair("certificate_type", this.b.getCertificateType()));
            }
            if (!TextUtils.isEmpty(this.b.getmIdCard())) {
                arrayList.add(new RestNameValuePair(ErrorContentResponse.Verify.VERIFY_CETIFICATE_CODE, PayUtils.encrypt("identity_code", this.b.getmIdCard())));
            }
            if (!TextUtils.isEmpty(this.b.getmPhone())) {
                arrayList.add(new RestNameValuePair("mobile", PayUtils.encrypt("phone_number", this.b.getmPhone())));
            }
            CardData.BondCard bondCard = this.b.mBondCard;
            if (!(bondCard == null || (str = bondCard.account_no) == null)) {
                arrayList.add(new RestNameValuePair("card_no_bind", str));
            }
            if (!TextUtils.isEmpty(this.b.getmValidDate())) {
                arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", this.b.getmValidDate())));
            }
            if (!TextUtils.isEmpty(this.b.getmCvv())) {
                arrayList.add(new RestNameValuePair(ErrorContentResponse.Verify.VERIFY_CVV2, PayUtils.encrypt("cvv2", this.b.getmCvv())));
            }
            arrayList.addAll(PayDataCache.getInstance().getSessionData());
            arrayList.add(new RestNameValuePair("session_id", this.b.getSessionId()));
            return arrayList;
        }
        throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
    }

    public void a() {
        this.d = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r0 = (r0 = r3.b).mBindFrom;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b() {
        /*
            r3 = this;
            boolean r0 = r3.d
            r1 = 1
            if (r0 != 0) goto L_0x0018
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r0 = r3.b
            if (r0 == 0) goto L_0x0018
            int r0 = r0.mBindFrom
            if (r0 == r1) goto L_0x0016
            r2 = 3
            if (r0 == r2) goto L_0x0016
            r2 = 4
            if (r0 == r2) goto L_0x0016
            r2 = 5
            if (r0 != r2) goto L_0x0018
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.beans.h.b():boolean");
    }

    public void execBean() {
        super.execBean(CheckCardInfoResponse.class, ErrorContentResponse.class);
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x0418  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.dxmpay.apollon.restnet.RestNameValuePair> generateRequestParam() {
        /*
            r18 = this;
            r0 = r18
            boolean r1 = r18.c()
            if (r1 == 0) goto L_0x000d
            java.util.List r1 = r18.e()
            return r1
        L_0x000d:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r3 = "source_flag"
            java.lang.String r4 = "3"
            r2.<init>(r3, r4)
            r1.add(r2)
            com.baidu.wallet.paysdk.storage.PayDataCache r2 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()
            java.lang.String r2 = r2.getPaySessionInfo()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x003e
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.storage.PayDataCache r3 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()
            java.lang.String r3 = r3.getPaySessionInfo()
            java.lang.String r4 = "session_info"
            r2.<init>(r4, r3)
            r1.add(r2)
        L_0x003e:
            boolean r2 = r0.d
            java.lang.String r3 = "easypay_channel"
            java.lang.String r4 = "channel_no"
            java.lang.String r5 = "identity_type"
            java.lang.String r6 = "true_name"
            java.lang.String r7 = "0"
            java.lang.String r8 = "without_pay"
            java.lang.String r9 = "card_type"
            java.lang.String r10 = "sub_bank_code"
            java.lang.String r11 = "request_type"
            java.lang.String r12 = "identity_code"
            java.lang.String r13 = "valid_date"
            java.lang.String r14 = "cvv2"
            java.lang.String r15 = "phone_number"
            r16 = r7
            java.lang.String r7 = "card_no"
            r17 = r8
            if (r2 == 0) goto L_0x0131
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r8 = "2"
            r2.<init>(r11, r8)
            r1.add(r2)
            com.baidu.wallet.paysdk.datamodel.PayRequest r2 = r0.c
            if (r2 == 0) goto L_0x0123
            com.baidu.wallet.base.datamodel.CardData$BondCard r2 = r2.mBondCard
            com.dxmpay.apollon.restnet.RestNameValuePair r8 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r11 = r2.bank_code
            r8.<init>(r10, r11)
            r1.add(r8)
            com.dxmpay.apollon.restnet.RestNameValuePair r8 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r10 = r2.account_no
            java.lang.String r10 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r7, r10)
            r8.<init>(r7, r10)
            r1.add(r8)
            com.dxmpay.apollon.restnet.RestNameValuePair r7 = new com.dxmpay.apollon.restnet.RestNameValuePair
            int r8 = r2.card_type
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r7.<init>(r9, r8)
            r1.add(r7)
            java.lang.String r7 = r2.bank_code
            com.dxmpay.wallet.utils.StatHelper.cacheBankCode(r7)
            int r7 = r2.card_type
            java.lang.String r7 = java.lang.String.valueOf(r7)
            com.dxmpay.wallet.utils.StatHelper.cacheCardType(r7)
            int r7 = r2.card_type
            r8 = 1
            if (r7 != r8) goto L_0x00c7
            com.dxmpay.apollon.restnet.RestNameValuePair r7 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r8 = r2.verify_code
            java.lang.String r8 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r14, r8)
            r7.<init>(r14, r8)
            r1.add(r7)
            com.dxmpay.apollon.restnet.RestNameValuePair r7 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r8 = r2.valid_date
            java.lang.String r8 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r13, r8)
            r7.<init>(r13, r8)
            r1.add(r7)
        L_0x00c7:
            com.dxmpay.apollon.restnet.RestNameValuePair r7 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r8 = r2.true_name
            r7.<init>(r6, r8)
            r1.add(r7)
            com.dxmpay.apollon.restnet.RestNameValuePair r6 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r7 = r2.mobile
            java.lang.String r7 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r15, r7)
            r6.<init>(r15, r7)
            r1.add(r6)
            java.lang.String r6 = r2.certificate_code
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x00ff
            com.dxmpay.apollon.restnet.RestNameValuePair r6 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r7 = r2.certificate_code
            java.lang.String r7 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r12, r7)
            r6.<init>(r12, r7)
            r1.add(r6)
            com.dxmpay.apollon.restnet.RestNameValuePair r6 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r7 = r2.certificate_type
            r6.<init>(r5, r7)
            r1.add(r6)
        L_0x00ff:
            java.lang.String r5 = r2.account_bank_code
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0111
            com.dxmpay.apollon.restnet.RestNameValuePair r5 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r6 = r2.account_bank_code
            r5.<init>(r4, r6)
            r1.add(r5)
        L_0x0111:
            java.lang.String r4 = r2.bank_code
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0123
            com.dxmpay.apollon.restnet.RestNameValuePair r4 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r2 = r2.bank_code
            r4.<init>(r3, r2)
            r1.add(r4)
        L_0x0123:
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            r8 = r16
            r3 = r17
            r2.<init>(r3, r8)
            r1.add(r2)
            goto L_0x0365
        L_0x0131:
            r2 = r17
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r8 = r0.b
            if (r8 != 0) goto L_0x0138
            return r1
        L_0x0138:
            r17 = r3
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r8 = r8.mBankNo
            r3.<init>(r10, r8)
            r1.add(r3)
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r8 = r0.b
            java.lang.String r8 = r8.getCardRequestType()
            r3.<init>(r11, r8)
            r1.add(r3)
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r8 = r0.b
            java.lang.String r8 = r8.getServiceType()
            java.lang.String r10 = "service_type"
            r3.<init>(r10, r8)
            r1.add(r3)
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r8 = r0.b
            java.lang.String r8 = r8.getmBankCard()
            java.lang.String r8 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r7, r8)
            r3.<init>(r7, r8)
            r1.add(r3)
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r7 = r0.b
            int r7 = r7.getCardType()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r3.<init>(r9, r7)
            r1.add(r3)
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r3 = r0.b
            java.lang.String r3 = r3.mBankNo
            com.dxmpay.wallet.utils.StatHelper.cacheBankCode(r3)
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r3 = r0.b
            int r3 = r3.getCardType()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            com.dxmpay.wallet.utils.StatHelper.cacheCardType(r3)
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r3 = r0.b
            int r3 = r3.getCardType()
            r7 = 1
            if (r3 != r7) goto L_0x01df
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r3 = r0.b
            java.lang.String r3 = r3.getmValidDate()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x01c1
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r7 = r0.b
            java.lang.String r7 = r7.getmValidDate()
            java.lang.String r7 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r13, r7)
            r3.<init>(r13, r7)
            r1.add(r3)
        L_0x01c1:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r3 = r0.b
            java.lang.String r3 = r3.getmCvv()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x01df
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r7 = r0.b
            java.lang.String r7 = r7.getmCvv()
            java.lang.String r7 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r14, r7)
            r3.<init>(r14, r7)
            r1.add(r3)
        L_0x01df:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r3 = r0.b
            java.lang.String r3 = r3.getmName()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x01f9
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r7 = r0.b
            java.lang.String r7 = r7.getmName()
            r3.<init>(r6, r7)
            r1.add(r3)
        L_0x01f9:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r3 = r0.b
            java.lang.String r3 = r3.getmPhone()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0217
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r6 = r0.b
            java.lang.String r6 = r6.getmPhone()
            java.lang.String r6 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r15, r6)
            r3.<init>(r15, r6)
            r1.add(r3)
        L_0x0217:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r3 = r0.b
            java.lang.String r3 = r3.getmIdCard()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0243
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r6 = r0.b
            java.lang.String r6 = r6.getmIdCard()
            java.lang.String r6 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r12, r6)
            r3.<init>(r12, r6)
            r1.add(r3)
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r6 = r0.b
            java.lang.String r6 = r6.getCertificateType()
            r3.<init>(r5, r6)
            r1.add(r3)
        L_0x0243:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r3 = r0.b
            java.lang.String r3 = r3.getChannelNo()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x025d
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r5 = r0.b
            java.lang.String r5 = r5.getChannelNo()
            r3.<init>(r4, r5)
            r1.add(r3)
        L_0x025d:
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r4 = r0.b
            java.lang.String r4 = r4.getWithoutPay()
            r3.<init>(r2, r4)
            r1.add(r3)
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            com.baidu.wallet.base.datamodel.CardData$BondCard r3 = r2.mBondCard
            com.baidu.wallet.paysdk.datamodel.ErrorContentResponse r2 = r2.mCardInfoUpdateContent
            if (r3 == 0) goto L_0x0287
            java.lang.String r4 = r3.need_true_name
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0287
            com.dxmpay.apollon.restnet.RestNameValuePair r4 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r5 = r3.need_true_name
            java.lang.String r6 = "need_true_name"
            r4.<init>(r6, r5)
            r1.add(r4)
        L_0x0287:
            if (r3 == 0) goto L_0x029d
            java.lang.String r4 = r3.need_identity_code
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x029d
            com.dxmpay.apollon.restnet.RestNameValuePair r4 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r5 = r3.need_identity_code
            java.lang.String r6 = "need_identity_code"
            r4.<init>(r6, r5)
            r1.add(r4)
        L_0x029d:
            if (r3 == 0) goto L_0x02b3
            java.lang.String r4 = r3.need_identity_type
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x02b3
            com.dxmpay.apollon.restnet.RestNameValuePair r4 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r5 = r3.need_identity_type
            java.lang.String r6 = "need_identity_type"
            r4.<init>(r6, r5)
            r1.add(r4)
        L_0x02b3:
            if (r2 == 0) goto L_0x02c8
            boolean r4 = r2.isNeedPhoneNum()
            if (r4 == 0) goto L_0x02c8
            com.dxmpay.apollon.restnet.RestNameValuePair r4 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r5 = r2.need_phone_num
            java.lang.String r6 = "need_phone_num"
            r4.<init>(r6, r5)
            r1.add(r4)
            goto L_0x02de
        L_0x02c8:
            if (r3 == 0) goto L_0x02de
            java.lang.String r4 = r3.need_phone_num
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x02de
            com.dxmpay.apollon.restnet.RestNameValuePair r4 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r5 = r3.need_phone_num
            java.lang.String r6 = "need_phone_num"
            r4.<init>(r6, r5)
            r1.add(r4)
        L_0x02de:
            if (r2 == 0) goto L_0x02f3
            boolean r4 = r2.isNeedValidCode()
            if (r4 == 0) goto L_0x02f3
            com.dxmpay.apollon.restnet.RestNameValuePair r4 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r5 = r2.need_cvv2
            java.lang.String r6 = "need_cvv2"
            r4.<init>(r6, r5)
            r1.add(r4)
            goto L_0x0309
        L_0x02f3:
            if (r3 == 0) goto L_0x0309
            java.lang.String r4 = r3.need_cvv2
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0309
            com.dxmpay.apollon.restnet.RestNameValuePair r4 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r5 = r3.need_cvv2
            java.lang.String r6 = "need_cvv2"
            r4.<init>(r6, r5)
            r1.add(r4)
        L_0x0309:
            if (r2 == 0) goto L_0x031e
            boolean r4 = r2.isNeedValidDate()
            if (r4 == 0) goto L_0x031e
            com.dxmpay.apollon.restnet.RestNameValuePair r4 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r2 = r2.need_valid_date
            java.lang.String r5 = "need_valid_date"
            r4.<init>(r5, r2)
            r1.add(r4)
            goto L_0x0334
        L_0x031e:
            if (r3 == 0) goto L_0x0334
            java.lang.String r2 = r3.need_valid_date
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0334
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r4 = r3.need_valid_date
            java.lang.String r5 = "need_valid_date"
            r2.<init>(r5, r4)
            r1.add(r2)
        L_0x0334:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            if (r2 == 0) goto L_0x034e
            java.lang.String r2 = r2.mBankNo
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x034e
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r4 = r0.b
            java.lang.String r4 = r4.mBankNo
            r5 = r17
            r2.<init>(r5, r4)
            r1.add(r2)
        L_0x034e:
            if (r3 == 0) goto L_0x035c
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r3 = r3.account_no
            java.lang.String r4 = "card_no_bind"
            r2.<init>(r4, r3)
            r1.add(r2)
        L_0x035c:
            boolean r2 = r18.d()
            if (r2 == 0) goto L_0x0365
            com.baidu.wallet.paysdk.a.b.a(r1)
        L_0x0365:
            boolean r2 = r18.b()
            java.lang.String r3 = "1"
            java.lang.String r4 = "order_no"
            java.lang.String r5 = "sp_no"
            r6 = 0
            if (r2 == 0) goto L_0x052e
            com.baidu.wallet.paysdk.datamodel.PayRequest r2 = r0.c
            if (r2 == 0) goto L_0x038a
            java.lang.String r2 = r2.mOrderNo
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x038a
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.PayRequest r7 = r0.c
            java.lang.String r7 = r7.mOrderNo
            r2.<init>(r4, r7)
            r1.add(r2)
        L_0x038a:
            com.baidu.wallet.paysdk.datamodel.PayRequest r2 = r0.c
            if (r2 == 0) goto L_0x03a2
            java.lang.String r2 = r2.mSpNO
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x03a2
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.PayRequest r7 = r0.c
            java.lang.String r7 = r7.mSpNO
            r2.<init>(r5, r7)
            r1.add(r2)
        L_0x03a2:
            com.baidu.wallet.paysdk.datamodel.PayRequest r2 = r0.c
            if (r2 == 0) goto L_0x03c0
            java.lang.String r2 = r2.getOrderPrice()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x03c0
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.PayRequest r7 = r0.c
            java.lang.String r7 = r7.getOrderPrice()
            java.lang.String r8 = "total_amount"
            r2.<init>(r8, r7)
            r1.add(r2)
        L_0x03c0:
            com.baidu.wallet.paysdk.datamodel.PayRequest r2 = r0.c
            r8 = 2
            java.lang.String r7 = "pay_amount"
            if (r2 == 0) goto L_0x043c
            boolean r9 = r2.isPayByMktSolution
            if (r9 == 0) goto L_0x043c
            com.baidu.wallet.paysdk.datamodel.ErrorContentResponse$MktSolution r2 = r2.mMktSolution
            if (r2 == 0) goto L_0x043c
            java.lang.String r2 = r2.easypay_amount
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x03e5
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.PayRequest r9 = r0.c
            com.baidu.wallet.paysdk.datamodel.ErrorContentResponse$MktSolution r9 = r9.mMktSolution
            java.lang.String r9 = r9.easypay_amount
            r2.<init>(r7, r9)
            r1.add(r2)
        L_0x03e5:
            com.baidu.wallet.paysdk.datamodel.PayRequest r2 = r0.c
            com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse r2 = r2.getCalcPayment()
            if (r2 == 0) goto L_0x040f
            com.baidu.wallet.paysdk.datamodel.PayRequest r2 = r0.c
            com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse r2 = r2.getCalcPayment()
            com.baidu.wallet.paysdk.datamodel.PayRequest r7 = r0.c
            com.baidu.wallet.paysdk.datamodel.ErrorContentResponse$MktSolution r7 = r7.mMktSolution
            com.baidu.wallet.base.datamodel.PayData$Discount[] r7 = r7.activity_list
            java.lang.String r2 = r2.getSelectedDiscountIds(r7)
            boolean r7 = android.text.TextUtils.isEmpty(r2)
            if (r7 != 0) goto L_0x040f
            com.dxmpay.apollon.restnet.RestNameValuePair r7 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r9 = "activity_id"
            r7.<init>(r9, r2)
            r1.add(r7)
            r2 = 2
            goto L_0x0410
        L_0x040f:
            r2 = 1
        L_0x0410:
            com.baidu.wallet.paysdk.datamodel.PayRequest r7 = r0.c
            com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse r7 = r7.getCalcPayment()
            if (r7 == 0) goto L_0x04ef
            com.baidu.wallet.paysdk.datamodel.PayRequest r7 = r0.c
            com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse r7 = r7.getCalcPayment()
            com.baidu.wallet.paysdk.datamodel.PayRequest r9 = r0.c
            com.baidu.wallet.paysdk.datamodel.ErrorContentResponse$MktSolution r9 = r9.mMktSolution
            com.baidu.wallet.base.datamodel.PayData$Coupon[] r9 = r9.coupon_list
            java.lang.String r7 = r7.getSelectedCouponIds(r9)
            boolean r9 = android.text.TextUtils.isEmpty(r7)
            if (r9 != 0) goto L_0x04ef
            int r2 = r2 + 1
            com.dxmpay.apollon.restnet.RestNameValuePair r9 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r10 = "coupon_id"
            r9.<init>(r10, r7)
            r1.add(r9)
            goto L_0x04ef
        L_0x043c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            boolean r9 = r0.d
            if (r9 == 0) goto L_0x0466
            com.baidu.wallet.paysdk.datamodel.PayRequest r9 = r0.c
            if (r9 == 0) goto L_0x0466
            com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse r9 = r9.getCalcPayment()
            if (r9 == 0) goto L_0x0456
            com.baidu.wallet.paysdk.datamodel.PayRequest r9 = r0.c
            com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse r9 = r9.getCalcPayment()
            goto L_0x0457
        L_0x0456:
            r9 = r6
        L_0x0457:
            com.dxmpay.apollon.restnet.RestNameValuePair r10 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.PayRequest r11 = r0.c
            java.lang.String r11 = r11.getEasyPayAmount()
            r10.<init>(r7, r11)
            r1.add(r10)
            goto L_0x04a3
        L_0x0466:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r9 = r0.b
            if (r9 == 0) goto L_0x0481
            int r10 = r9.mBindFrom
            if (r10 != 0) goto L_0x0481
            com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse r9 = r9.getCalcPaymentResponse()
            com.dxmpay.apollon.restnet.RestNameValuePair r10 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r11 = r0.b
            java.lang.String r11 = r11.getEasyPayAmount()
            r10.<init>(r7, r11)
            r1.add(r10)
            goto L_0x04a3
        L_0x0481:
            com.baidu.wallet.paysdk.datamodel.PayRequest r9 = r0.c
            if (r9 == 0) goto L_0x04a2
            com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse r9 = r9.getCalcPayment()
            if (r9 == 0) goto L_0x0492
            com.baidu.wallet.paysdk.datamodel.PayRequest r9 = r0.c
            com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse r9 = r9.getCalcPayment()
            goto L_0x0493
        L_0x0492:
            r9 = r6
        L_0x0493:
            com.dxmpay.apollon.restnet.RestNameValuePair r10 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.PayRequest r11 = r0.c
            java.lang.String r11 = r11.getEasyPayAmount()
            r10.<init>(r7, r11)
            r1.add(r10)
            goto L_0x04a3
        L_0x04a2:
            r9 = r6
        L_0x04a3:
            if (r9 == 0) goto L_0x04ee
            java.lang.String r7 = r9.getSelectedDiscountIds()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x04b8
            java.lang.String r7 = r9.getSelectedDiscountIds()
            r2.append(r7)
            r7 = 2
            goto L_0x04b9
        L_0x04b8:
            r7 = 1
        L_0x04b9:
            java.lang.String r10 = r2.toString()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x04d1
            com.dxmpay.apollon.restnet.RestNameValuePair r10 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r2 = r2.toString()
            java.lang.String r11 = "activity_id"
            r10.<init>(r11, r2)
            r1.add(r10)
        L_0x04d1:
            java.lang.String r2 = r9.getSelectedCouponIds()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x04ec
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r9 = r9.getSelectedCouponIds()
            java.lang.String r10 = "coupon_id"
            r2.<init>(r10, r9)
            r1.add(r2)
            int r2 = r7 + 1
            goto L_0x04ef
        L_0x04ec:
            r2 = r7
            goto L_0x04ef
        L_0x04ee:
            r2 = 1
        L_0x04ef:
            if (r2 < r8) goto L_0x04fc
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r7 = "composite_flag"
            r2.<init>(r7, r3)
            r1.add(r2)
            goto L_0x0508
        L_0x04fc:
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r7 = "composite_flag"
            r8 = r16
            r2.<init>(r7, r8)
            r1.add(r2)
        L_0x0508:
            com.baidu.wallet.paysdk.storage.PayDataCache r2 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r2 = r2.getPayResponse()
            if (r2 == 0) goto L_0x052e
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r2 = r2.pay
            if (r2 == 0) goto L_0x052e
            com.baidu.wallet.base.datamodel.PayData$EasyPay r2 = r2.easypay
            if (r2 == 0) goto L_0x052e
            java.lang.String r2 = r2.getHdTag()
            boolean r7 = android.text.TextUtils.isEmpty(r2)
            if (r7 != 0) goto L_0x052e
            com.dxmpay.apollon.restnet.RestNameValuePair r7 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r8 = "hd_tag"
            r7.<init>(r8, r2)
            r1.add(r7)
        L_0x052e:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            if (r2 == 0) goto L_0x0586
            int r2 = r2.getmBindFrom()
            r7 = 1
            if (r2 != r7) goto L_0x0586
            com.baidu.wallet.paysdk.datamodel.PayRequest r2 = r0.c
            if (r2 == 0) goto L_0x056c
            java.lang.String r2 = r2.getPayFrom()
            java.lang.String r7 = "pay_from_bind_card"
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x056c
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.PayRequest r7 = r0.c
            java.lang.String r7 = r7.mSpNO
            r2.<init>(r5, r7)
            r1.add(r2)
            com.baidu.wallet.paysdk.datamodel.PayRequest r2 = r0.c
            java.lang.String r2 = r2.mOrderNo
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0586
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.PayRequest r5 = r0.c
            java.lang.String r5 = r5.mOrderNo
            r2.<init>(r4, r5)
            r1.add(r2)
            goto L_0x0586
        L_0x056c:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            java.lang.String r2 = r2.getSp_no()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0586
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r4 = r0.b
            java.lang.String r4 = r4.getSp_no()
            r2.<init>(r5, r4)
            r1.add(r2)
        L_0x0586:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            if (r2 == 0) goto L_0x07c4
            com.dxmpay.apollon.restnet.RestNameValuePair r4 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r2 = r2.getSessionId()
            java.lang.String r5 = "session_id"
            r4.<init>(r5, r2)
            r1.add(r4)
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            java.lang.String r2 = r2.getIdCardSartDate()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r4 = "cardCheck"
            if (r2 != 0) goto L_0x05db
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "sartDate:"
            r2.append(r5)
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r5 = r0.b
            java.lang.String r5 = r5.getIdCardSartDate()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.dxmpay.apollon.utils.LogUtil.d(r4, r2)
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r5 = r0.b
            java.lang.String r5 = r5.getIdCardSartDate()
            java.lang.String r7 = "cert_start_date"
            java.lang.String r5 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r7, r5)
            java.lang.String r7 = "cert_start_date"
            r2.<init>(r7, r5)
            r1.add(r2)
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            r2.setIdCardSartDate(r6)
        L_0x05db:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            java.lang.String r2 = r2.getIdCardEndDate()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x061c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "endDate:"
            r2.append(r5)
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r5 = r0.b
            java.lang.String r5 = r5.getIdCardEndDate()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.dxmpay.apollon.utils.LogUtil.d(r4, r2)
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r5 = r0.b
            java.lang.String r5 = r5.getIdCardEndDate()
            java.lang.String r7 = "cert_end_date"
            java.lang.String r5 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r7, r5)
            java.lang.String r7 = "cert_end_date"
            r2.<init>(r7, r5)
            r1.add(r2)
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            r2.setIdCardEndDate(r6)
        L_0x061c:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            java.lang.String r2 = r2.getGender()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x063d
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r5 = r0.b
            java.lang.String r5 = r5.getGender()
            java.lang.String r7 = "gender"
            r2.<init>(r7, r5)
            r1.add(r2)
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            r2.setGender(r6)
        L_0x063d:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            java.lang.String r2 = r2.getNationality()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x067e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "nationality:"
            r2.append(r5)
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r5 = r0.b
            java.lang.String r5 = r5.getNationality()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.dxmpay.apollon.utils.LogUtil.d(r4, r2)
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r5 = r0.b
            java.lang.String r5 = r5.getNationality()
            java.lang.String r7 = "nationality"
            java.lang.String r5 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r7, r5)
            java.lang.String r7 = "nationality"
            r2.<init>(r7, r5)
            r1.add(r2)
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            r2.setNationality(r6)
        L_0x067e:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            com.baidu.wallet.paysdk.datamodel.DxmAddress r2 = r2.getAddress()
            if (r2 == 0) goto L_0x0751
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            com.baidu.wallet.paysdk.datamodel.DxmAddress r2 = r2.getAddress()
            java.lang.String r5 = r2.provinceId
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x06bc
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "provinceId:"
            r5.append(r7)
            java.lang.String r7 = r2.provinceId
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            com.dxmpay.apollon.utils.LogUtil.d(r4, r5)
            com.dxmpay.apollon.restnet.RestNameValuePair r5 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r7 = r2.provinceId
            java.lang.String r8 = "province_id"
            java.lang.String r7 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r8, r7)
            java.lang.String r8 = "province_id"
            r5.<init>(r8, r7)
            r1.add(r5)
        L_0x06bc:
            java.lang.String r5 = r2.cityId
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x06ec
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "cityId:"
            r5.append(r7)
            java.lang.String r7 = r2.cityId
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            com.dxmpay.apollon.utils.LogUtil.d(r4, r5)
            com.dxmpay.apollon.restnet.RestNameValuePair r5 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r7 = r2.cityId
            java.lang.String r8 = "city_id"
            java.lang.String r7 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r8, r7)
            java.lang.String r8 = "city_id"
            r5.<init>(r8, r7)
            r1.add(r5)
        L_0x06ec:
            java.lang.String r5 = r2.countyId
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x071c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "countyId:"
            r5.append(r7)
            java.lang.String r7 = r2.countyId
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            com.dxmpay.apollon.utils.LogUtil.d(r4, r5)
            com.dxmpay.apollon.restnet.RestNameValuePair r5 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r7 = r2.countyId
            java.lang.String r8 = "county_id"
            java.lang.String r7 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r8, r7)
            java.lang.String r8 = "county_id"
            r5.<init>(r8, r7)
            r1.add(r5)
        L_0x071c:
            java.lang.String r5 = r2.address
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x074c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "address:"
            r5.append(r7)
            java.lang.String r7 = r2.address
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            com.dxmpay.apollon.utils.LogUtil.d(r4, r5)
            com.dxmpay.apollon.restnet.RestNameValuePair r5 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r2 = r2.address
            java.lang.String r7 = "address"
            java.lang.String r2 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r7, r2)
            java.lang.String r7 = "address"
            r5.<init>(r7, r2)
            r1.add(r5)
        L_0x074c:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            r2.setAddress(r6)
        L_0x0751:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            com.baidu.wallet.paysdk.datamodel.DxmJob r2 = r2.getJob()
            if (r2 == 0) goto L_0x07c4
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            com.baidu.wallet.paysdk.datamodel.DxmJob r2 = r2.getJob()
            java.lang.String r5 = r2.jobId
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x078f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "jobId:"
            r5.append(r7)
            java.lang.String r7 = r2.jobId
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            com.dxmpay.apollon.utils.LogUtil.d(r4, r5)
            com.dxmpay.apollon.restnet.RestNameValuePair r5 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r7 = r2.jobId
            java.lang.String r8 = "job"
            java.lang.String r7 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r8, r7)
            java.lang.String r8 = "job"
            r5.<init>(r8, r7)
            r1.add(r5)
        L_0x078f:
            java.lang.String r5 = r2.lowerJobId
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x07bf
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "lowerJobId:"
            r5.append(r7)
            java.lang.String r7 = r2.lowerJobId
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            com.dxmpay.apollon.utils.LogUtil.d(r4, r5)
            com.dxmpay.apollon.restnet.RestNameValuePair r4 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r2 = r2.lowerJobId
            java.lang.String r5 = "lower_job_id"
            java.lang.String r2 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r5, r2)
            java.lang.String r5 = "lower_job_id"
            r4.<init>(r5, r2)
            r1.add(r4)
        L_0x07bf:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = r0.b
            r2.setJob(r6)
        L_0x07c4:
            boolean r2 = r0.e
            if (r2 == 0) goto L_0x07d5
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r4 = "need_reset_route"
            r2.<init>(r4, r3)
            r1.add(r2)
            r2 = 0
            r0.e = r2
        L_0x07d5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.beans.h.generateRequestParam():java.util.List");
    }

    public int getBeanId() {
        return 5;
    }

    public String getEncode() {
        return "UTF-8";
    }

    public String getUrl() {
        a = -1;
        if (c()) {
            return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_VERIFY_CARDCHECK;
        } else if (d()) {
            return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_SIGN_CARD_CHECK;
        } else {
            a = 1;
            return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_CHECK_CARD_INFO;
        }
    }

    public void a(BindFastRequest bindFastRequest) {
        this.b = bindFastRequest;
    }

    public void a(boolean z) {
        this.e = z;
    }
}
