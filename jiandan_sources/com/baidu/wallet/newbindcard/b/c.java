package com.baidu.wallet.newbindcard.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.newbindcard.c.a;
import com.baidu.wallet.newbindcard.ui.NewBindCardMainActivity;
import com.baidu.wallet.newbindcard.ui.NewCheckSmsActivity;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.h;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.CheckCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.DxmAddress;
import com.baidu.wallet.paysdk.datamodel.DxmJob;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.beans.BeanErrorContent;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.utils.StatHelper;
import java.net.URLEncoder;
import java.util.Map;

public class c extends a {
    public BindFastRequest c;
    public String d;
    public GetCardInfoResponse.CardItemRequired e;
    public CardAddResponse f;
    public String g;
    public boolean h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3578i = false;

    public c(NewBindCardMainActivity newBindCardMainActivity) {
        super(newBindCardMainActivity);
    }

    public void d() {
        BindFastRequest bindFastRequest = this.c;
        if (bindFastRequest == null || bindFastRequest.getmBankInfo() == null || this.c.getmBankInfo().channel_info == null) {
            this.b.initCardDateAndCvv2((GetCardInfoResponse.CardItemRequired) null);
            return;
        }
        this.b.initCardDateAndCvv2(this.c.getmBankInfo().channel_info.card_item_required);
    }

    public void e() {
        BindFastRequest bindFastRequest;
        CardAddResponse cardAddResponse = this.f;
        if (cardAddResponse == null || cardAddResponse.user == null || (bindFastRequest = this.c) == null || bindFastRequest.getmBankInfo() == null || this.c.getmBankInfo().channel_info == null || this.c.getmBankInfo().channel_info.certificate_type_info == null || this.c.getmBankInfo().channel_info.certificate_type_info.length <= 0) {
            this.b.setCertificateType((String) null, (GetCardInfoResponse.CertificateTypeInfo[]) null);
            return;
        }
        this.b.setCertificateType(this.f.user.certificate_type, this.c.getmBankInfo().channel_info.certificate_type_info);
    }

    public void f() {
        UserData.UserModel userModel;
        CardAddResponse cardAddResponse = this.f;
        if (cardAddResponse == null || (userModel = cardAddResponse.user) == null || TextUtils.isEmpty(userModel.certificate_code)) {
            this.b.setCertificateCode((String) null);
        } else {
            this.b.setCertificateCode(this.f.user.certificate_code);
        }
    }

    public void g() {
        UserData.UserModel userModel;
        CardAddResponse cardAddResponse = this.f;
        if (cardAddResponse == null || (userModel = cardAddResponse.user) == null || TextUtils.isEmpty(userModel.mobile)) {
            this.b.setUserPhone((String) null);
        } else {
            this.b.setUserPhone(this.f.user.mobile);
        }
    }

    public void h() {
        BindFastRequest bindFastRequest = this.c;
        if (bindFastRequest == null || bindFastRequest.getmBankInfo() == null || this.c.getmBankInfo().protocol_platform_info == null) {
            this.b.setBindCardProtocol((GetCardInfoResponse.ProtocolPlatformInfo) null);
        } else {
            this.b.setBindCardProtocol(this.c.getmBankInfo().protocol_platform_info);
        }
    }

    public void i() {
        UserData.UserModel userModel;
        CardAddResponse cardAddResponse = this.f;
        if (cardAddResponse == null || (userModel = cardAddResponse.user) == null) {
            this.b.setPhoneTip((String) null, 0);
            return;
        }
        this.b.setPhoneTip(userModel.mobile, userModel.has_mobile_password);
    }

    public boolean j() {
        GetCardInfoResponse.CardItemRequired cardItemRequired = this.e;
        return cardItemRequired != null && "1".equals(cardItemRequired.cert_start_date);
    }

    public boolean k() {
        GetCardInfoResponse.CardItemRequired cardItemRequired = this.e;
        return cardItemRequired != null && "1".equals(cardItemRequired.cert_end_date);
    }

    public boolean l() {
        GetCardInfoResponse.CardItemRequired cardItemRequired = this.e;
        return cardItemRequired != null && "1".equals(cardItemRequired.nationality);
    }

    public boolean m() {
        GetCardInfoResponse.CardItemRequired cardItemRequired = this.e;
        return cardItemRequired != null && "1".equals(cardItemRequired.gender);
    }

    public boolean n() {
        GetCardInfoResponse.CardItemRequired cardItemRequired = this.e;
        return cardItemRequired != null && "1".equals(cardItemRequired.job);
    }

    public boolean o() {
        GetCardInfoResponse.CardItemRequired cardItemRequired = this.e;
        return cardItemRequired != null && "1".equals(cardItemRequired.address);
    }

    public void p() {
        this.c = null;
        this.e = null;
        this.d = null;
        this.f = null;
        super.p();
    }

    public void c() {
        UserData.UserModel userModel;
        CardAddResponse cardAddResponse = this.f;
        if (cardAddResponse == null || (userModel = cardAddResponse.user) == null) {
            this.b.initBindCardUi((String) null, (UserData.UserModel.DisplayFlag) null);
            return;
        }
        this.b.initBindCardUi(userModel.true_name, userModel.display_flag);
    }

    public void b() {
        BindFastRequest bindFastRequest = this.c;
        if (bindFastRequest == null || bindFastRequest.getmBankInfo() == null) {
            this.b.initBankCardInfo((String) null, (String) null, (String) null);
            return;
        }
        GetCardInfoResponse.CardInfo cardInfo = this.c.getmBankInfo().card_info;
        if (cardInfo == null || TextUtils.isEmpty(cardInfo.bank_logourl) || TextUtils.isEmpty(cardInfo.bank_name) || TextUtils.isEmpty(cardInfo.type_name)) {
            this.b.initBankCardInfo((String) null, (String) null, (String) null);
        } else {
            this.b.initBankCardInfo(cardInfo.bank_logourl, cardInfo.bank_name, cardInfo.type_name);
        }
    }

    public void a(Bundle bundle) {
        BindFastRequest bindReq = NewBindCardEntry.getInstance().getBindReq();
        this.c = bindReq;
        if (bindReq == null) {
            NewBindCardEntry.getInstance().newBindCardCallback(StatHelper.SENSOR_ERR_2, "NewBindCardMainActivity bindFastRequest is null", false);
            this.b.finishWithoutAnim();
            return;
        }
        CardAddResponse instance = CardAddResponse.getInstance();
        this.f = instance;
        if (instance == null) {
            NewBindCardEntry.getInstance().newBindCardCallback(StatHelper.SENSOR_ERR_2, "NewBindCardMainActivity mCardAddResponse is null", false);
            this.b.finishWithoutAnim();
            return;
        }
        if (!(this.c.getmBankInfo() == null || this.c.getmBankInfo().channel_info == null)) {
            this.e = this.c.getmBankInfo().channel_info.card_item_required;
        }
        this.d = this.b.getIntent().getStringExtra(NewBindCardMainActivity.BIND_CARD_NUMBER);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        r0 = r0.user;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Context r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            com.baidu.wallet.paysdk.datamodel.CardAddResponse r0 = r3.f
            if (r0 == 0) goto L_0x0022
            com.dxmpay.wallet.base.datamodel.UserData$UserModel r0 = r0.user
            if (r0 == 0) goto L_0x0022
            java.lang.String r0 = r0.true_name
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x001f
            com.baidu.wallet.paysdk.datamodel.CardAddResponse r0 = r3.f
            com.dxmpay.wallet.base.datamodel.UserData$UserModel r0 = r0.user
            java.lang.String r0 = r0.certificate_code
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0022
        L_0x001f:
            java.lang.String r0 = "1"
            goto L_0x0024
        L_0x0022:
            java.lang.String r0 = "0"
        L_0x0024:
            com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse r1 = com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse.getInstance()
            java.lang.String r1 = r1.getBindCardSafeTipUrl(r4)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0034
            java.lang.String r1 = com.baidu.wallet.paysdk.beans.DxmPayBeanConstants.API_BIND_CARD_SAFE_TIP_URL
        L_0x0034:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = "&"
            r2.append(r1)
            java.lang.String r1 = "show_privacy="
            r2.append(r1)
            r2.append(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "----d:"
            r0.append(r1)
            java.lang.String r1 = r2.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.dxmpay.apollon.utils.LogUtil.d(r0)
            com.dxmpay.wallet.api.BaiduWalletDelegate r0 = com.dxmpay.wallet.api.BaiduWalletDelegate.getInstance()
            java.lang.String r1 = r2.toString()
            r0.openH5Module((android.content.Context) r4, (java.lang.String) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.newbindcard.b.c.b(android.content.Context):void");
    }

    public void a(int i2, Object obj, String str) {
        WalletGlobalUtils.safeDismissDialog(this.b, -2);
        if (i2 == 5) {
            CheckCardInfoResponse checkCardInfoResponse = (CheckCardInfoResponse) obj;
            int i3 = 0;
            if (1 == checkCardInfoResponse.send_sms_by_bfb || "1".equals(checkCardInfoResponse.need_verify_sms)) {
                i3 = 1;
            }
            this.c.setmNeedSms(i3);
            Map<String, String> map = checkCardInfoResponse.cashdesk;
            if (map != null && map.size() > 0) {
                PayDataCache.getInstance().setSessionData(checkCardInfoResponse.cashdesk);
            }
            if (!TextUtils.isEmpty(checkCardInfoResponse.channel_no)) {
                this.c.setChannelNo(checkCardInfoResponse.channel_no);
            }
            this.c.setRegEx(checkCardInfoResponse.sms_pattern);
            this.c.setSmsLength(checkCardInfoResponse.sms_length);
            this.c.setSmsType(checkCardInfoResponse.sms_type);
            this.c.setSendSmsphone(checkCardInfoResponse.send_sms_phone);
            this.c.setSendSmsTips(checkCardInfoResponse.send_sms_tips);
            this.b.startActivityWithoutAnim(new Intent(this.b, NewCheckSmsActivity.class));
        }
    }

    public void a(int i2, int i3, String str) {
        WalletGlobalUtils.safeDismissDialog(this.b, -2);
        this.b.handleFailure(i2, i3, str);
    }

    public void a() {
        NewBindCardMainActivity newBindCardMainActivity = this.b;
        if (newBindCardMainActivity != null) {
            newBindCardMainActivity.setFlagActiveBindCard();
        }
    }

    public boolean a(Context context) {
        UserData.UserModel userModel;
        CardAddResponse cardAddResponse = this.f;
        if (cardAddResponse == null || (userModel = cardAddResponse.user) == null || !userModel.hasMobilePwd() || userModel.auth_status >= 3 || "1".equals(userModel.certificate_type)) {
            return false;
        }
        a.a(PayStatServiceEvent.NEW_BIND_CARD_NO_REAL_NAME, NewBindCardMainActivity.BIND_CARD_MAIN_HASH_NAME, NewBindCardMainActivity.BIND_CARD_MAIN_HASH_ID, "跳转H5九要素页面", new String[0]);
        a(context, userModel.true_name, userModel.certificate_type, userModel.certificate_code, this.d, userModel.mobile, "", "");
        return true;
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, DxmAddress dxmAddress, DxmJob dxmJob) {
        WalletGlobalUtils.safeShowDialog(this.b, -2, "");
        h hVar = (h) PayBeanFactory.getInstance().getBean((Context) this.b, 5, NewBindCardMainActivity.BEAN_TAG);
        BindFastRequest bindFastRequest = this.c;
        if (bindFastRequest != null) {
            bindFastRequest.setmBankCard(this.d);
            GetCardInfoResponse.CardItemRequired cardItemRequired = this.e;
            if (cardItemRequired != null) {
                if ("1".equals(cardItemRequired.true_name)) {
                    String str11 = str;
                    this.c.setmName(str);
                } else {
                    this.c.setmName("");
                }
                if ("1".equals(this.e.certificate_type)) {
                    String str12 = str2;
                    this.c.setCertificateType(str2);
                } else {
                    this.c.setCertificateType("");
                }
                if ("1".equals(this.e.certificate_code)) {
                    String str13 = str3;
                    this.c.setmIdCard(str3);
                } else {
                    this.c.setmIdCard("");
                }
                if ("1".equals(this.e.mobile)) {
                    String str14 = str4;
                    this.c.setmPhone(str4);
                } else {
                    this.c.setmPhone("");
                }
                if ("1".equals(this.e.valid_date)) {
                    String str15 = str5;
                    this.c.setmValidDate(str5);
                } else {
                    this.c.setmValidDate("");
                }
                if ("1".equals(this.e.valid_code)) {
                    String str16 = str6;
                    this.c.setmCvv(str6);
                } else {
                    this.c.setmCvv("");
                }
                if ("1".equals(this.e.cert_start_date)) {
                    String str17 = str7;
                    this.c.setIdCardSartDate(str7);
                } else {
                    this.c.setIdCardSartDate("");
                }
                if ("1".equals(this.e.cert_end_date)) {
                    String str18 = str8;
                    this.c.setIdCardEndDate(str8);
                } else {
                    this.c.setIdCardEndDate("");
                }
                if ("1".equals(this.e.nationality)) {
                    String str19 = str9;
                    this.c.setNationality(str9);
                } else {
                    this.c.setNationality("");
                }
                if ("1".equals(this.e.gender)) {
                    this.c.setGender(str10);
                } else {
                    this.c.setGender("");
                }
                if ("1".equals(this.e.job)) {
                    this.c.setJob(dxmJob);
                } else {
                    this.c.setJob((DxmJob) null);
                }
                if ("1".equals(this.e.address)) {
                    this.c.setAddress(dxmAddress);
                } else {
                    this.c.setAddress((DxmAddress) null);
                }
            }
        }
        hVar.a(this.c);
        hVar.setResponseCallback(this);
        hVar.execBean();
    }

    public void a(Context context, String str, final String str2, String str3, String str4, String str5, String str6, String str7) {
        if (context != null) {
            String collectUserUrl = SdkInitResponse.getInstance().getCollectUserUrl(context);
            if (TextUtils.isEmpty(collectUserUrl)) {
                collectUserUrl = DxmPayBeanConstants.API_BIND_CARD_COLLECT_USER_URL;
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append("name=");
                stringBuffer.append(str);
                stringBuffer.append(com.alipay.sdk.m.s.a.n);
            }
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append("certificates_type=");
                stringBuffer.append(str2);
                stringBuffer.append(com.alipay.sdk.m.s.a.n);
            }
            if (!TextUtils.isEmpty(str3)) {
                stringBuffer.append("certificates_no=");
                stringBuffer.append(str3);
                stringBuffer.append(com.alipay.sdk.m.s.a.n);
            }
            if (!TextUtils.isEmpty(str4)) {
                stringBuffer.append("card_no=");
                stringBuffer.append(str4);
                stringBuffer.append(com.alipay.sdk.m.s.a.n);
            }
            if (!TextUtils.isEmpty(str5)) {
                stringBuffer.append("phone=");
                stringBuffer.append(str5);
                stringBuffer.append(com.alipay.sdk.m.s.a.n);
            }
            if (!TextUtils.isEmpty(str6)) {
                stringBuffer.append("cvv2=");
                stringBuffer.append(str6);
                stringBuffer.append(com.alipay.sdk.m.s.a.n);
            }
            if (!TextUtils.isEmpty(str7)) {
                stringBuffer.append("date=");
                stringBuffer.append(str7);
            }
            String localEncryptProxy = SecurePay.getInstance().localEncryptProxy(stringBuffer.toString());
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(collectUserUrl);
            stringBuffer2.append("?is_from_sdk=1&algorithmType=AES&data=");
            stringBuffer2.append(URLEncoder.encode(localEncryptProxy));
            EventBus.getInstance().register((Object) this.b, DxmPayBeanConstants.EV_BANK_DETAIL_CARD_CHANGE, 0, EventBus.ThreadMode.MainThread);
            EventBus.getInstance().register((Object) this.b, DxmPayBeanConstants.EV_H5_BIND_CARD_DATA_SUBMIT, 0, EventBus.ThreadMode.MainThread);
            AnonymousClass1 r6 = new H5LifeCycleCallback() {
                public void onActivityDestroyed(Activity activity) {
                    EventBus.getInstance().unregister((Object) c.this.b, DxmPayBeanConstants.EV_BANK_DETAIL_CARD_CHANGE);
                    EventBus.getInstance().unregister((Object) c.this.b, DxmPayBeanConstants.EV_H5_BIND_CARD_DATA_SUBMIT);
                    pop();
                    if (c.this.h) {
                        NewBindCardEntry.getInstance().newBindCardCallback("0", c.this.g, false);
                    } else if (c.this.f3578i) {
                        a.a(PayStatServiceEvent.NEW_BIND_CARD_REVIEW_RESULT, NewBindCardMainActivity.BIND_CARD_MAIN_HASH_NAME, NewBindCardMainActivity.BIND_CARD_MAIN_HASH_ID, "外籍九要素补全审核结果", a.a(), a.b(), a.c(), a.d(), str2, "0");
                        NewBindCardEntry.getInstance().newBindCardCallback(StatHelper.SENSOR_ERR_2, "", false);
                    } else {
                        a.a(PayStatServiceEvent.NEW_BIND_CARD_REVIEW_RESULT, NewBindCardMainActivity.BIND_CARD_MAIN_HASH_NAME, NewBindCardMainActivity.BIND_CARD_MAIN_HASH_ID, "外籍九要素补全审核结果", a.a(), a.b(), a.c(), a.d(), str2, "1");
                        c.this.b.finishWithoutAnim();
                    }
                    boolean unused = c.this.f3578i = false;
                    String unused2 = c.this.g = null;
                    boolean unused3 = c.this.h = false;
                }
            };
            r6.push();
            Bundle bundle = new Bundle();
            bundle.putBoolean("with_anim", false);
            bundle.putBoolean("show_share", false);
            bundle.putString("url", stringBuffer2.toString());
            bundle.putParcelable("lifecycleLsnr", r6);
            LogUtil.d("----d:" + stringBuffer2.toString());
            BaiduWalletDelegate.getInstance().openH5Module(context, bundle);
        }
    }

    public void a(EventBus.Event event) {
        Object obj;
        if (event != null && event.mEventObj != null) {
            if (DxmPayBeanConstants.EV_BANK_DETAIL_CARD_CHANGE.equals(event.mEventKey)) {
                try {
                    JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                    if (jSONObject.has("type") && 1 == jSONObject.getInt("type")) {
                        this.h = true;
                        this.g = jSONObject.optString("card_no", "");
                    }
                } catch (Exception e2) {
                    LogUtil.e("NewInitiativeBindCardPresenter", e2.getMessage(), e2);
                }
            } else if (DxmPayBeanConstants.EV_H5_BIND_CARD_DATA_SUBMIT.equals(event.mEventKey)) {
                try {
                    JSONObject jSONObject2 = new JSONObject((String) event.mEventObj);
                    if (jSONObject2.has("submit_result") && 1 == jSONObject2.getInt("submit_result")) {
                        this.f3578i = true;
                    }
                } catch (Exception e3) {
                    LogUtil.e("NewInitiativeBindCardPresenter", e3.getMessage(), e3);
                }
            } else if ("ev_bean_execut_err_content".equals(event.mEventKey) && (obj = event.mEventObj) != null && (obj instanceof BeanErrorContent)) {
                BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
                a(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg());
            }
        }
    }
}
