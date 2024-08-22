package com.baidu.wallet.paysdk.storage;

import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.router.LocalRouter;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class PayDataCache {
    public static final String DO_PAY_RESULT_NOTIFI_EVENTBUS_EVENTKEY = "do_pay_result_notifi";
    public static final String PAY_TYPE_BALANCE = "balance";
    public static final String PAY_TYPE_COMPOSITE = "composite";
    public static final String PAY_TYPE_CREDITPAY = "credit_pay";
    public static final String PAY_TYPE_EASYPAY = "easypay";
    public static final String PAY_TYPE_LICAI_BALANCE = "licaibalance";
    public PayResultContent a;
    public DirectPayContentResponse b;
    public H5ResultParams c;
    public DirectPayContentResponse d;
    public DirectPayContentResponse e;
    public DirectPayContentResponse f;
    public DirectPayContentResponse g;
    public DirectPayContentResponse h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3605i;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public boolean n;

    /* renamed from: o  reason: collision with root package name */
    public String f3606o;
    public String[][] p;
    public List<RestNameValuePair> q;
    public String r;
    public String s;
    public String t;
    public HashMap<String, HashMap<String, String>> u;
    public IBeanResponse v;

    /* renamed from: com.baidu.wallet.paysdk.storage.PayDataCache$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.baidu.wallet.paysdk.storage.PayRequestCache$BindCategory[] r0 = com.baidu.wallet.paysdk.storage.PayRequestCache.BindCategory.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.baidu.wallet.paysdk.storage.PayRequestCache$BindCategory r1 = com.baidu.wallet.paysdk.storage.PayRequestCache.BindCategory.Initiative     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.wallet.paysdk.storage.PayRequestCache$BindCategory r1 = com.baidu.wallet.paysdk.storage.PayRequestCache.BindCategory.Pwd     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.AnonymousClass1.<clinit>():void");
        }
    }

    public static class a {
        public static PayDataCache a = new PayDataCache((AnonymousClass1) null);
    }

    public static class b<A, B> {
        public final A a;
        public final B b;

        public b(A a2, B b2) {
            this.a = a2;
            this.b = b2;
        }
    }

    public /* synthetic */ PayDataCache(AnonymousClass1 r1) {
        this();
    }

    public static PayDataCache getInstance() {
        return a.a;
    }

    public b<Boolean, String> canUseBalance() {
        UserData.UserModel userModel;
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (directPayBalance = directPayPay.balance) == null) {
            DirectPayContentResponse directPayContentResponse2 = this.b;
            if (directPayContentResponse2 == null || (userModel = directPayContentResponse2.user) == null) {
                return new b<>(Boolean.FALSE, "");
            }
            return new b<>(Boolean.valueOf("1".equals(userModel.balance_support_status)), this.b.user.balance_unsupport_reason);
        }
        boolean z = true;
        if (directPayBalance.enough != 1) {
            z = false;
        }
        return new b<>(Boolean.valueOf(z), this.b.pay.balance.disabled_msg);
    }

    public b<Boolean, String> canUseCredit() {
        PayData.DirectPayPay directPayPay;
        PayData.CreditPay creditPay;
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (creditPay = directPayPay.credit_pay) == null) {
            return new b<>(Boolean.FALSE, "");
        }
        boolean equals = "1".equals(creditPay.status);
        return new b<>(Boolean.valueOf(equals), this.b.pay.credit_pay.disable_msg);
    }

    public boolean canUseEasypay() {
        PayData.DirectPayPay directPayPay;
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || directPayPay.easypay == null) {
            return false;
        }
        return true;
    }

    public void cleanDetainmentDesc() {
        PayData.DirectPayPay directPayPay;
        PayData.Detainment detainment;
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse != null && (directPayPay = directPayContentResponse.pay) != null && (detainment = directPayPay.detainment) != null) {
            detainment.desc = "";
        }
    }

    public void clearDataCache() {
        this.b = null;
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.m = false;
        this.n = false;
        this.f3606o = null;
        this.p = null;
        List<RestNameValuePair> list = this.q;
        if (list != null) {
            list.clear();
        }
        this.r = null;
        this.s = null;
        this.t = null;
    }

    public boolean enableAddBondCards() {
        DirectPayContentResponse directPayContentResponse = this.b;
        return directPayContentResponse != null && "1".equals(directPayContentResponse.can_bind_card_flag);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = (r0 = r0.pay).easypay;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean enableAddBondCardsVerify() {
        /*
            r2 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r2.b
            if (r0 == 0) goto L_0x0018
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r0 = r0.pay
            if (r0 == 0) goto L_0x0018
            com.baidu.wallet.base.datamodel.PayData$EasyPay r0 = r0.easypay
            if (r0 == 0) goto L_0x0018
            java.lang.String r0 = r0.can_bind_card_flag
            java.lang.String r1 = "1"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0018
            r0 = 1
            return r0
        L_0x0018:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.enableAddBondCardsVerify():boolean");
    }

    public String[][] getAccountBankCard() {
        return this.p;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
        r0 = (r0 = (r0 = r0.pay).credit_pay).credit_info;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getAvailableCreditAmount() {
        /*
            r1 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            if (r0 == 0) goto L_0x0023
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r0 = r0.pay
            if (r0 == 0) goto L_0x0023
            com.baidu.wallet.base.datamodel.PayData$CreditPay r0 = r0.credit_pay
            if (r0 == 0) goto L_0x0023
            com.baidu.wallet.base.datamodel.PayData$CreditInfo r0 = r0.credit_info
            if (r0 == 0) goto L_0x0023
            java.lang.String r0 = r0.available_credit
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0023
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r0 = r0.pay
            com.baidu.wallet.base.datamodel.PayData$CreditPay r0 = r0.credit_pay
            com.baidu.wallet.base.datamodel.PayData$CreditInfo r0 = r0.credit_info
            java.lang.String r0 = r0.available_credit
            return r0
        L_0x0023:
            java.lang.String r0 = "0"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.getAvailableCreditAmount():java.lang.String");
    }

    public PayData.DirectPayBalance getBalance() {
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (directPayBalance = directPayPay.balance) == null) {
            return null;
        }
        return directPayBalance;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = (r0 = r0.pay).balance;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getBalanceJumpUrl() {
        /*
            r1 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            if (r0 == 0) goto L_0x000f
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r0 = r0.pay
            if (r0 == 0) goto L_0x000f
            com.baidu.wallet.base.datamodel.PayData$DirectPayBalance r0 = r0.balance
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.balance_jump_url
            return r0
        L_0x000f:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.getBalanceJumpUrl():java.lang.String");
    }

    public List<RestNameValuePair> getBalancePayPostInfo() {
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        Map<String, String> map;
        ArrayList arrayList = new ArrayList();
        DirectPayContentResponse directPayContentResponse = this.b;
        if (!(directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (directPayBalance = directPayPay.balance) == null || (map = directPayBalance.post_info) == null)) {
            for (Map.Entry next : map.entrySet()) {
                arrayList.add(new RestNameValuePair((String) next.getKey(), (String) next.getValue()));
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.user;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getBalanceUnSupportReason() {
        /*
            r2 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r2.b
            if (r0 == 0) goto L_0x0019
            com.dxmpay.wallet.base.datamodel.UserData$UserModel r0 = r0.user
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = r0.balance_support_status
            java.lang.String r1 = "0"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0019
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r2.b
            com.dxmpay.wallet.base.datamodel.UserData$UserModel r0 = r0.user
            java.lang.String r0 = r0.balance_unsupport_reason
            return r0
        L_0x0019:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.getBalanceUnSupportReason():java.lang.String");
    }

    public CardData.BondCard[] getBondCards() {
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse != null) {
            return directPayContentResponse.getBondCards();
        }
        return null;
    }

    public String getCanAmount() {
        DirectPayContentResponse directPayContentResponse = this.b;
        return (directPayContentResponse == null || directPayContentResponse.user == null || !hasCanAmount()) ? "" : this.b.user.getCanAmount();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.user;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getCertificateDes() {
        /*
            r1 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            if (r0 == 0) goto L_0x000b
            com.dxmpay.wallet.base.datamodel.UserData$UserModel r0 = r0.user
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r0.certificate_type_name
            return r0
        L_0x000b:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.getCertificateDes():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.user;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getCertificateType() {
        /*
            r1 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            if (r0 == 0) goto L_0x000b
            com.dxmpay.wallet.base.datamodel.UserData$UserModel r0 = r0.user
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r0.certificate_type
            return r0
        L_0x000b:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.getCertificateType():java.lang.String");
    }

    public PayData.CertificateGuideDialog getCfcaGuideDialogContent() {
        PayData.CertificateGuideDialog certificateGuideDialog;
        PayData.CertificateGuideDialog certificateGuideDialog2;
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse == null || directPayContentResponse.pay == null || payRequest == null) {
            return null;
        }
        PayRequest.PayPrice payPrice = payRequest.getPayPrice();
        if (payPrice == null || payPrice.payType != PayRequest.PayPrice.PayType.BALANCE) {
            PayData.EasyPay easyPay = this.b.pay.easypay;
            if (easyPay == null || (certificateGuideDialog = easyPay.cfca_guide_dialog) == null) {
                return null;
            }
            return certificateGuideDialog;
        }
        PayData.DirectPayBalance directPayBalance = this.b.pay.balance;
        if (directPayBalance == null || (certificateGuideDialog2 = directPayBalance.cfca_guide_dialog) == null) {
            return null;
        }
        return certificateGuideDialog2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = (r0 = r0.pay).credit_pay;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getCreditPayDispayName() {
        /*
            r1 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            if (r0 == 0) goto L_0x001d
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r0 = r0.pay
            if (r0 == 0) goto L_0x001d
            com.baidu.wallet.base.datamodel.PayData$CreditPay r0 = r0.credit_pay
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r0.display_name
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x001d
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r0 = r0.pay
            com.baidu.wallet.base.datamodel.PayData$CreditPay r0 = r0.credit_pay
            java.lang.String r0 = r0.display_name
            return r0
        L_0x001d:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.getCreditPayDispayName():java.lang.String");
    }

    public List<RestNameValuePair> getCreditPayPostInfo() {
        PayData.DirectPayPay directPayPay;
        PayData.CreditPay creditPay;
        Map<String, String> map;
        ArrayList arrayList = new ArrayList();
        DirectPayContentResponse directPayContentResponse = this.b;
        if (!(directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (creditPay = directPayPay.credit_pay) == null || (map = creditPay.post_info) == null)) {
            for (Map.Entry next : map.entrySet()) {
                arrayList.add(new RestNameValuePair((String) next.getKey(), (String) next.getValue()));
            }
        }
        return arrayList;
    }

    public String getDefaultPayType() {
        PayData.DirectPayPay directPayPay;
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null) {
            return null;
        }
        return directPayPay.default_pay_type_display;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = (r0 = r0.pay).detainment;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getDetainmentDesc() {
        /*
            r1 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            if (r0 == 0) goto L_0x000f
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r0 = r0.pay
            if (r0 == 0) goto L_0x000f
            com.baidu.wallet.base.datamodel.PayData$Detainment r0 = r0.detainment
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.desc
            return r0
        L_0x000f:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.getDetainmentDesc():java.lang.String");
    }

    public UserData.UserModel.FingerprintMsg getFingerprintMsg() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null || userModel.getFingerprintMsg() == null) {
            return null;
        }
        return this.b.user.getFingerprintMsg();
    }

    public String getFormatUserName() {
        String userName = getUserName();
        if (hasMobilePwd() || TextUtils.isEmpty(userName)) {
            return userName;
        }
        return "*" + userName.charAt(userName.length() - 1);
    }

    public HashMap<String, String> getH5PayResult(String str) {
        return this.u.get(str);
    }

    public H5ResultParams getH5ResultParams() {
        return this.c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.misc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getInsideTransOrder() {
        /*
            r1 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            if (r0 == 0) goto L_0x000d
            com.dxmpay.wallet.base.datamodel.UserData$Misc r0 = r0.misc
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = r0.getInsideTransOrder()
            return r0
        L_0x000d:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.getInsideTransOrder():java.lang.String");
    }

    public List<RestNameValuePair> getLicaiBalancePayPostInfo() {
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        Map<String, String> map;
        ArrayList arrayList = new ArrayList();
        DirectPayContentResponse directPayContentResponse = this.b;
        if (!(directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (directPayBalance = directPayPay.licaibalance) == null || (map = directPayBalance.post_info) == null)) {
            for (Map.Entry next : map.entrySet()) {
                arrayList.add(new RestNameValuePair((String) next.getKey(), (String) next.getValue()));
            }
        }
        return arrayList;
    }

    public String getOrderExtraInfo() {
        return this.r;
    }

    public List<RestNameValuePair> getPayPostInfo() {
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        Map<String, String> map;
        ArrayList arrayList = new ArrayList();
        DirectPayContentResponse directPayContentResponse = this.b;
        if (!(directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (easyPay = directPayPay.easypay) == null || (map = easyPay.post_info) == null)) {
            for (Map.Entry next : map.entrySet()) {
                arrayList.add(new RestNameValuePair((String) next.getKey(), (String) next.getValue()));
            }
        }
        return arrayList;
    }

    public DirectPayContentResponse getPayResponse() {
        return this.b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.pay;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getPaySessionInfo() {
        /*
            r1 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            if (r0 == 0) goto L_0x0017
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r0 = r0.pay
            if (r0 == 0) goto L_0x0017
            java.lang.String r0 = r0.session_info
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0017
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r0 = r0.pay
            java.lang.String r0 = r0.session_info
            goto L_0x0019
        L_0x0017:
            java.lang.String r0 = ""
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.getPaySessionInfo():java.lang.String");
    }

    public PayResultContent getPayStateContent() {
        return this.a;
    }

    public List<RestNameValuePair> getPrePayRequestParams() {
        return this.q;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.authorize;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getPureSign() {
        /*
            r1 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            if (r0 == 0) goto L_0x0017
            com.baidu.wallet.base.datamodel.Authorize r0 = r0.authorize
            if (r0 == 0) goto L_0x0017
            java.lang.String r0 = r0.pure_sign
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0017
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            com.baidu.wallet.base.datamodel.Authorize r0 = r0.authorize
            java.lang.String r0 = r0.pure_sign
            return r0
        L_0x0017:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.getPureSign():java.lang.String");
    }

    public String getRemotePayHostName() {
        return this.j;
    }

    public String getRemotePkg() {
        return this.k;
    }

    public String getRemoteWhereToBackAct() {
        return this.l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.pay;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getSelectedCardNo() {
        /*
            r1 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            if (r0 == 0) goto L_0x0017
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r0 = r0.pay
            if (r0 == 0) goto L_0x0017
            java.lang.String r0 = r0.selected_card_no
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0017
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r0 = r0.pay
            java.lang.String r0 = r0.selected_card_no
            return r0
        L_0x0017:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.getSelectedCardNo():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.sp;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getSellerUserId() {
        /*
            r1 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            if (r0 == 0) goto L_0x000d
            com.dxmpay.wallet.base.datamodel.UserData$SP r0 = r0.sp
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = r0.getSellerUserId()
            return r0
        L_0x000d:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.getSellerUserId():java.lang.String");
    }

    public List<RestNameValuePair> getSessionData() {
        Map<String, String> map;
        ArrayList arrayList = new ArrayList();
        DirectPayContentResponse directPayContentResponse = this.b;
        if (!(directPayContentResponse == null || (map = directPayContentResponse.cashdesk) == null || map == null)) {
            for (Map.Entry next : map.entrySet()) {
                arrayList.add(new RestNameValuePair((String) next.getKey(), (String) next.getValue()));
            }
        }
        return arrayList;
    }

    public String getSignSuccessTips() {
        return this.f3606o;
    }

    public String getSpGoodsName() {
        DirectPayContentResponse directPayContentResponse = this.b;
        return directPayContentResponse != null ? directPayContentResponse.getSpGoodsName() : "";
    }

    public String getSpName() {
        DirectPayContentResponse directPayContentResponse = this.b;
        return directPayContentResponse != null ? directPayContentResponse.getSpName() : "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.user;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getTotalBalance() {
        /*
            r1 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            if (r0 == 0) goto L_0x000d
            com.dxmpay.wallet.base.datamodel.UserData$UserModel r0 = r0.user
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = r0.getCanAmount()
            return r0
        L_0x000d:
            java.lang.String r0 = "0"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.getTotalBalance():java.lang.String");
    }

    public IBeanResponse getTransferAccountConfig() {
        return this.v;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.user;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getUserId() {
        /*
            r1 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            if (r0 == 0) goto L_0x000b
            com.dxmpay.wallet.base.datamodel.UserData$UserModel r0 = r0.user
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r0.certificate_code
            return r0
        L_0x000b:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.getUserId():java.lang.String");
    }

    public UserData.UserModel getUserInfo() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) {
            return null;
        }
        return userModel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.user;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getUserName() {
        /*
            r1 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            if (r0 == 0) goto L_0x000b
            com.dxmpay.wallet.base.datamodel.UserData$UserModel r0 = r0.user
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r0.true_name
            return r0
        L_0x000b:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.getUserName():java.lang.String");
    }

    public String getmWxAppId() {
        return this.s;
    }

    public boolean hasBondCards() {
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse != null) {
            return directPayContentResponse.hasBindCards();
        }
        return false;
    }

    public boolean hasCanAmount() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) {
            return false;
        }
        return userModel.hasCanAmount();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.pay;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasCreditPay() {
        /*
            r1 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            if (r0 == 0) goto L_0x000e
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r0 = r0.pay
            if (r0 == 0) goto L_0x000e
            com.baidu.wallet.base.datamodel.PayData$CreditPay r0 = r0.credit_pay
            if (r0 == 0) goto L_0x000e
            r0 = 1
            return r0
        L_0x000e:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.hasCreditPay():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getEnableCardsForFindPWD();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasEnableCardsForFindPWD() {
        /*
            r1 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r1.b
            if (r0 == 0) goto L_0x000f
            com.baidu.wallet.base.datamodel.CardData$BondCard[] r0 = r0.getEnableCardsForFindPWD()
            if (r0 == 0) goto L_0x000f
            int r0 = r0.length
            if (r0 <= 0) goto L_0x000f
            r0 = 1
            return r0
        L_0x000f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.hasEnableCardsForFindPWD():boolean");
    }

    public boolean hasMobilePwd() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) {
            return false;
        }
        return userModel.hasMobilePwd();
    }

    public boolean isBalanceEnough() {
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        DirectPayContentResponse directPayContentResponse = this.h;
        if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (directPayBalance = directPayPay.balance) == null || directPayBalance.enough != 1) {
            return false;
        }
        return true;
    }

    public boolean isBalanceSupport() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) {
            return false;
        }
        return userModel.isSupportBalance();
    }

    public boolean isFromPreCashier() {
        return this.m;
    }

    public boolean isPassFree() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) {
            return false;
        }
        return "0".equals(userModel.need_pay_password);
    }

    public boolean isPaySettingOpenFingerprintPay() {
        return this.n;
    }

    public boolean isRemotePay() {
        return this.f3605i;
    }

    public boolean isShowCreditPay() {
        PayData.DirectPayPay directPayPay;
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || directPayPay.credit_pay == null) {
            return false;
        }
        return true;
    }

    public boolean isShowDetection() {
        if (!LocalRouter.getInstance(BaiduWalletDelegate.getInstance().getAppContext()).isProviderExisted("bankdetection")) {
            return false;
        }
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse == null || !"0".equals(directPayContentResponse.bank_card_detect_enabled)) {
            return true;
        }
        return false;
    }

    public boolean needCalcPayment() {
        UserData.SP sp;
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse == null || (sp = directPayContentResponse.sp) == null) {
            return false;
        }
        return !TextUtils.isEmpty(sp.seller_user_id);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean needOpenCertificate(android.content.Context r5) {
        /*
            r4 = this;
            com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse r0 = com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse.getInstance()
            boolean r0 = r0.getIs_sdk_sm_open()
            r1 = 0
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            com.baidu.wallet.paysdk.storage.PayRequestCache r0 = com.baidu.wallet.paysdk.storage.PayRequestCache.getInstance()
            java.lang.String r2 = "key_pay_request"
            com.dxmpay.wallet.core.beans.BeanRequestBase r0 = r0.getBeanRequestFromCache(r2)
            com.baidu.wallet.paysdk.datamodel.PayRequest r0 = (com.baidu.wallet.paysdk.datamodel.PayRequest) r0
            com.dxmpay.wallet.core.beans.sm.SMManagerDelegate r2 = new com.dxmpay.wallet.core.beans.sm.SMManagerDelegate
            r2.<init>()
            java.lang.String r5 = r2.getUserKeyId(r5)
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            r2 = 1
            r5 = r5 ^ r2
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r3 = r4.b
            if (r3 == 0) goto L_0x005b
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r3 = r3.pay
            if (r3 == 0) goto L_0x005b
            if (r0 == 0) goto L_0x005b
            com.baidu.wallet.paysdk.datamodel.PayRequest$PayPrice r0 = r0.getPayPrice()
            if (r0 == 0) goto L_0x004c
            com.baidu.wallet.paysdk.datamodel.PayRequest$PayPrice$PayType r0 = r0.payType
            com.baidu.wallet.paysdk.datamodel.PayRequest$PayPrice$PayType r3 = com.baidu.wallet.paysdk.datamodel.PayRequest.PayPrice.PayType.BALANCE
            if (r0 != r3) goto L_0x004c
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r4.b
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r0 = r0.pay
            com.baidu.wallet.base.datamodel.PayData$DirectPayBalance r0 = r0.balance
            if (r0 == 0) goto L_0x005b
            int r0 = r0.need_cfca
            if (r0 != r2) goto L_0x005b
            if (r5 != 0) goto L_0x005b
            return r2
        L_0x004c:
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r4.b
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r0 = r0.pay
            com.baidu.wallet.base.datamodel.PayData$EasyPay r0 = r0.easypay
            if (r0 == 0) goto L_0x005b
            int r0 = r0.need_cfca
            if (r0 != r2) goto L_0x005b
            if (r5 != 0) goto L_0x005b
            return r2
        L_0x005b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.storage.PayDataCache.needOpenCertificate(android.content.Context):boolean");
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event != null && DO_PAY_RESULT_NOTIFI_EVENTBUS_EVENTKEY.equals(event.mEventKey) && event.mEventObj != null) {
            try {
                JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                if (jSONObject.has("pay_result") && jSONObject.has("order_no")) {
                    String optString = jSONObject.optString("pay_result");
                    String optString2 = jSONObject.optString("order_no");
                    if (TextUtils.isEmpty(optString2)) {
                        optString2 = this.t;
                    }
                    String optString3 = jSONObject.optString("notify");
                    HashMap hashMap = new HashMap();
                    hashMap.put("pay_result", optString);
                    hashMap.put("order_no", optString2);
                    hashMap.put("notify", optString3);
                    putH5PayResult(optString2, hashMap);
                }
            } catch (Exception e2) {
                LogUtil.e("PayDataCache", e2.getMessage(), e2);
            }
        }
    }

    public boolean oneKeyPayForCredit() {
        PayData.DirectPayPay directPayPay;
        PayData.CreditPay creditPay;
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (creditPay = directPayPay.credit_pay) == null) {
            return false;
        }
        return "1".equals(creditPay.status);
    }

    public void putH5PayResult(String str, HashMap<String, String> hashMap) {
        this.u.put(str, hashMap);
    }

    public void registerEventBus() {
        EventBus.getInstance().register((Object) this, DO_PAY_RESULT_NOTIFI_EVENTBUS_EVENTKEY, 0, EventBus.ThreadMode.MainThread);
    }

    public void removeH5PayResult(String str) {
        this.u.remove(str);
    }

    public void resetFromPrecashier() {
        this.m = false;
    }

    public void setAccountBankCard(String[][] strArr) {
        this.p = strArr;
    }

    public void setCurrentPayRequest(PayRequestCache.BindCategory bindCategory) {
        int i2 = AnonymousClass1.a[bindCategory.ordinal()];
        if (i2 == 1) {
            this.b = this.e;
        } else if (i2 != 2) {
            this.b = this.g;
        } else {
            this.b = this.d;
        }
    }

    public void setFromPreCashier() {
        this.m = true;
    }

    public void setH5ResultParams(H5ResultParams h5ResultParams) {
        this.c = h5ResultParams;
    }

    public void setHasPwd() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.b;
        if (directPayContentResponse != null && (userModel = directPayContentResponse.user) != null) {
            userModel.setHasMobilePwd();
        }
    }

    public void setIsRemotePay(boolean z) {
        this.f3605i = z;
    }

    public void setOrderExtraInfo(String str) {
        this.r = str;
    }

    public void setOrderNo(String str) {
        this.t = str;
    }

    public void setPayReslutContent(PayResultContent payResultContent) {
        this.a = payResultContent;
    }

    public void setPayResponse(DirectPayContentResponse directPayContentResponse) {
        PayData.DirectPayPay directPayPay;
        if (directPayContentResponse instanceof CardAddResponse) {
            int i2 = ((CardAddResponse) directPayContentResponse).request_type;
            if (4 == i2) {
                this.d = directPayContentResponse;
            } else if (11 == i2) {
                this.e = directPayContentResponse;
            } else if (12 == i2) {
                this.f = directPayContentResponse;
            } else {
                this.g = directPayContentResponse;
            }
        } else {
            this.g = directPayContentResponse;
        }
        this.b = directPayContentResponse;
        if (directPayContentResponse != null && (directPayPay = directPayContentResponse.pay) != null && directPayPay.balance != null) {
            this.h = directPayContentResponse;
        }
    }

    public void setPaySettingOpenFingerprintPay(boolean z) {
        this.n = z;
    }

    public void setPrePayRequestParams(List<RestNameValuePair> list) {
        if (this.q == null) {
            this.q = new ArrayList();
        }
        this.q.clear();
        this.q.addAll(list);
    }

    public void setRemotePayHostName(String str) {
        this.j = str;
    }

    public void setRemotePkg(String str) {
        this.k = str;
    }

    public void setRemoteWhereToBackAct(String str) {
        this.l = str;
    }

    public void setSessionData(Map<String, String> map) {
        if (this.b != null && map != null && map.size() > 0) {
            this.b.cashdesk = map;
        }
    }

    public void setSignSuccessTips(String str) {
        this.f3606o = str;
    }

    public void setTransferAccountConfig(IBeanResponse iBeanResponse) {
        this.v = iBeanResponse;
    }

    public void setmWxAppId(String str) {
        this.s = str;
    }

    public PayDataCache() {
        this.f3605i = false;
        this.m = false;
        this.n = false;
        this.f3606o = "";
        this.u = new HashMap<>();
        this.q = new ArrayList();
    }
}
