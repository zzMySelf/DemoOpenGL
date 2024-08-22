package com.baidu.wallet.paysdk.presenter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.baidu.android.pay.PayCallBack;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.banksign.BankSignPayFlow;
import com.baidu.wallet.paysdk.banksign.a.a;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.baidu.wallet.paysdk.banksign.beans.b;
import com.baidu.wallet.paysdk.banksign.datamodel.GetJumpUrlResponse;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.t;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayErrorContent;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.AuthorizeSignActivity;
import com.baidu.wallet.paysdk.ui.BindCardImplActivity;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.Base64;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.dialog.DxmNewStandardDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.beans.sm.SMManagerDelegate;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class j extends k {
    public String a;
    public PayRequest c = null;
    public t d;

    public j(PayBaseBeanActivity payBaseBeanActivity) {
        super(payBaseBeanActivity);
    }

    private void h() {
        Pair<Integer, Object> checkSecurityEvn = BaiduWalletDelegate.getInstance().checkSecurityEvn();
        if (checkSecurityEvn != null && ((Integer) checkSecurityEvn.first).intValue() == 0) {
            Object obj = checkSecurityEvn.second;
            String str = null;
            if (obj != null && (obj instanceof String)) {
                str = (String) obj;
            }
            if (this.c != null && !TextUtils.isEmpty(str)) {
                this.c.mSecurityParams = Base64.encodeBytes(str.getBytes());
            }
        }
    }

    private void i() {
        if (m()) {
            BankSignFactory instance = BankSignFactory.getInstance();
            PayBaseBeanActivity payBaseBeanActivity = this.b;
            b bVar = (b) instance.getBean((Context) payBaseBeanActivity, 768, "PrecashierWelcomePresenter" + toString());
            bVar.a(PayDataCache.getInstance().getSelectedCardNo());
            bVar.setResponseCallback(this);
            bVar.execBean();
            return;
        }
        f();
    }

    /* access modifiers changed from: private */
    public void j() {
        if (!PayDataCache.getInstance().hasMobilePwd()) {
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            if (PayDataCache.getInstance().hasBondCards()) {
                PayController instance = PayController.getInstance();
                PayBaseBeanActivity payBaseBeanActivity = this.b;
                instance.selectCompletCards(payBaseBeanActivity, payBaseBeanActivity.getIntent());
                return;
            }
            PayController instance2 = PayController.getInstance();
            PayBaseBeanActivity payBaseBeanActivity2 = this.b;
            instance2.bindCardPay(payBaseBeanActivity2, payBaseBeanActivity2.getIntent(), true);
        } else if (PayDataCache.getInstance().isFromPreCashier()) {
            PayController.getInstance().gotoPwdPay(this.b);
        } else if (this.c.isWithHoldingValidity()) {
            PayController.getInstance().gotoWithholdPay(this.b);
        } else {
            PayController instance3 = PayController.getInstance();
            PayBaseBeanActivity payBaseBeanActivity3 = this.b;
            instance3.gotoOrderConfirm(payBaseBeanActivity3, payBaseBeanActivity3.getIntent());
        }
    }

    private void k() {
        PwdRequest pwdRequest = new PwdRequest();
        PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
        if (PayDataCache.getInstance().hasBondCards()) {
            Intent intent = new Intent(this.b, AuthorizeSignActivity.class);
            if (com.baidu.wallet.paysdk.a.b.b()) {
                intent.putExtra(AuthorizeSignActivity.AUTH_SIGN_TYPE, 2);
            } else if (com.baidu.wallet.paysdk.a.b.c()) {
                intent.putExtra(AuthorizeSignActivity.AUTH_SIGN_TYPE, 1);
            }
            this.b.startActivity(intent);
            this.b.finishWithoutAnim();
            return;
        }
        StatHelper.cachePayType(0);
        StatHelper.cachePayWay(4);
        StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_ENTER, PayController.PAY_BIND_CARD_ENTER_HASH_NAME, PayController.PAY_BIND_CARD_ENTER_HASH_ID, "进入", new String[0]);
        StatisticManager.onEventStart(PayStatServiceEvent.PAY_BIND_CARD_DURATION);
        BaiduPay.getInstance().bindCardAuth(this.b, true);
    }

    private void l() {
        PayRequest payRequest = this.c;
        String str = "";
        String str2 = payRequest != null ? payRequest.mParams : str;
        "doRePayOrder->orderinfo:" + str2;
        PayRequest payRequest2 = this.c;
        if (payRequest2 != null) {
            str = payRequest2.getPayFrom();
        }
        PayCallBack payBack = BaiduPay.getInstance().getPayBack();
        PayRequestCache.getInstance().clearPaySdkRequestCache();
        PayBaseBeanActivity.exitEbpay();
        HashMap hashMap = new HashMap();
        hashMap.put("pay_from", str);
        BaiduPay.getInstance().doPay(this.b.getActivity(), str2, payBack, hashMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getSelectedCard();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m() {
        /*
            r2 = this;
            com.baidu.wallet.paysdk.datamodel.PayRequest r0 = r2.c
            if (r0 == 0) goto L_0x0010
            com.baidu.wallet.base.datamodel.CardData$BondCard r0 = r0.getSelectedCard()
            if (r0 == 0) goto L_0x0010
            int r0 = r0.is_sign_jump_bank
            r1 = 1
            if (r1 != r0) goto L_0x0010
            return r1
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.presenter.j.m():boolean");
    }

    public void a(PrecashierCreateOrderResponse precashierCreateOrderResponse) {
    }

    public void b() {
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        this.c = payRequest;
        if (payRequest == null || !payRequest.checkRequestValidity()) {
            PayCallBackManager.callBackClientCancel(this.b, "PrecashierWelcomePresenter.loadData().1");
            return;
        }
        if (this.d == null) {
            PayBeanFactory instance = PayBeanFactory.getInstance();
            PayBaseBeanActivity payBaseBeanActivity = this.b;
            this.d = (t) instance.getBean((Context) payBaseBeanActivity, 1, "PrecashierWelcomePresenter" + toString());
        }
        PayRequest payRequest2 = this.c;
        if (payRequest2 != null && !BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest2.getPayFrom())) {
            StatisticManager.onEventStart("createPreOrder");
        }
        this.d.a(this.a);
        this.d.setResponseCallback(this);
        this.d.execBean();
    }

    public void c() {
        PayCallBackManager.callBackClientCancel(this.b, "PrecashierWelcomePresenter.callBackCancel().1");
    }

    public void d() {
        PayBaseBeanActivity payBaseBeanActivity = this.b;
        if (payBaseBeanActivity != null) {
            payBaseBeanActivity.setFlagPaySdk();
        }
    }

    public void e() {
        BeanManager instance = BeanManager.getInstance();
        instance.removeAllBeans("PrecashierWelcomePresenter" + toString());
    }

    public void f() {
        if (PayDataCache.getInstance().needOpenCertificate(this.b)) {
            WalletGlobalUtils.safeShowDialog(this.b, 64, "");
            return;
        }
        j();
        this.b.finishWithoutAnim();
    }

    public boolean a(Bundle bundle) {
        if (bundle == null) {
            this.c = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        } else {
            Serializable serializable = bundle.getSerializable("mPayRequest");
            if (serializable != null && (serializable instanceof PayRequest)) {
                this.c = (PayRequest) serializable;
            }
            Serializable serializable2 = bundle.getSerializable("mPayResponse");
            if (serializable2 != null && (serializable2 instanceof DirectPayContentResponse)) {
                PayDataCache.getInstance().setPayResponse((DirectPayContentResponse) serializable2);
            }
        }
        if (this.c != null) {
            PayRequestCache.getInstance().addBeanRequestToCache(this.c.getRequestId(), this.c);
            return true;
        }
        PayCallBackManager.callBackClientCancel(this.b, "PrecashierWelcomePresenter.initSaveInstanceData().1");
        return false;
    }

    public void a() {
        h();
        b();
    }

    private void b(DirectPayContentResponse directPayContentResponse) {
        PayData.DirectPayPay directPayPay;
        if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || directPayPay.easypay == null || directPayContentResponse.user == null) {
            PayCallBackManager.callBackClientCancel(this.b, "PrecashierWelcomePresenter.confirmRemotePayOrderInfo().1");
        } else {
            i();
        }
    }

    public void a(int i2, Object obj, String str) {
        int i3;
        PayData.EasyPay easyPay;
        if (i2 == 768) {
            GetJumpUrlResponse getJumpUrlResponse = (GetJumpUrlResponse) obj;
            if (getJumpUrlResponse.agreement_trans_id != null) {
                a.a().f(getJumpUrlResponse.agreement_trans_id);
            }
            if (getJumpUrlResponse.is_signed == 0) {
                a.a().a(this);
                String str2 = getJumpUrlResponse.form_data;
                a.a().a(str2 == null ? null : str2.getBytes());
                a.a().b(false);
                a.a().d(getJumpUrlResponse.form_url);
                a.a().e(getJumpUrlResponse.webview_title);
                BankSignPayFlow a2 = BankSignPayFlow.a();
                a2.a(BankSignPayFlow.Action.ShowGuide);
                a2.a((Context) this.b);
            } else {
                f();
            }
            if (!PayDataCache.getInstance().needOpenCertificate(this.b)) {
                this.b.finishWithoutAnim();
                return;
            }
            return;
        }
        DirectPayContentResponse directPayContentResponse = (DirectPayContentResponse) obj;
        if (directPayContentResponse == null || !directPayContentResponse.checkResponseValidity()) {
            PayCallBackManager.callBackClientCancel(this.b, "PrecashierWelcomePresenter.handleResponse().1");
            return;
        }
        UserData.UserModel userModel = directPayContentResponse.user;
        if (userModel != null) {
            userModel.decrypt();
        }
        PayData.DirectPayPay directPayPay = directPayContentResponse.pay;
        if (!(directPayPay == null || (easyPay = directPayPay.easypay) == null)) {
            easyPay.decrypt();
        }
        if (this.c == null) {
            PayCallBackManager.callBackClientCancel(this.b, "PrecashierWelcomePresenter.handleResponse().2");
            return;
        }
        UserData.SP sp = directPayContentResponse.sp;
        if (sp != null && !TextUtils.isEmpty(sp.goods_name)) {
            this.c.mGoodName = directPayContentResponse.sp.goods_name;
        }
        directPayContentResponse.storeResponse(this.b);
        if ("balance".equals(PayDataCache.getInstance().getDefaultPayType())) {
            i3 = 1;
        } else if (!PayDataCache.PAY_TYPE_LICAI_BALANCE.equals(PayDataCache.getInstance().getDefaultPayType()) || com.baidu.wallet.paysdk.c.a.a().c()) {
            i3 = (PayDataCache.PAY_TYPE_LICAI_BALANCE.equals(PayDataCache.getInstance().getDefaultPayType()) || !com.baidu.wallet.paysdk.c.a.a().c() || TextUtils.isEmpty(com.baidu.wallet.paysdk.c.a.a().d())) ? 0 : 3;
        } else {
            i3 = 2;
        }
        StatHelper.cachePayType(i3);
        PayRequest payRequest = this.c;
        if (!(payRequest == null || BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom()) || directPayContentResponse.misc == null)) {
            ArrayList<String> a3 = a(directPayContentResponse);
            if (!TextUtils.isEmpty(a3.get(0)) && !TextUtils.isEmpty(a3.get(1))) {
                StatisticManager.onEventEndWithValues("createPreOrder", 0, (Collection<String>) a3);
            }
        }
        PayData.DirectPayPay directPayPay2 = directPayContentResponse.pay;
        if (directPayPay2 != null) {
            this.c.setCalcPayment(directPayPay2.composite);
            this.c.setRandomDiscount(directPayContentResponse.pay.random_discount);
        }
        if (directPayContentResponse.isWithHoldingValidity()) {
            this.c.withholding = directPayContentResponse.authorize_common_cashdesk;
        }
        if (!com.baidu.wallet.paysdk.c.a.a().b() || !com.baidu.wallet.paysdk.c.a.a().c()) {
            if (!com.baidu.wallet.paysdk.c.a.a().b() && !com.baidu.wallet.paysdk.c.a.a().c()) {
                com.baidu.wallet.paysdk.c.a.a().j();
            }
            if (BaiduPay.PAY_FROM_BIND_CARD.equals(this.c.mPayFrom)) {
                StatHelper.cachePayType(0);
                StatHelper.cachePayWay(4);
                a(directPayContentResponse.hasPwd(), directPayContentResponse.hasBindCards());
                BindFastRequest bindFastRequest = new BindFastRequest();
                bindFastRequest.mBindFrom = 1;
                PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
                this.b.startActivity(new Intent(this.b, BindCardImplActivity.class));
                this.b.finishWithoutAnim();
            } else if (BaiduPay.PAY_FROM_AUTHORIZE.equals(this.c.mPayFrom)) {
                this.c.initPayStrategy(this.b);
                StatHelper.cachePayType(0);
                StatHelper.cachePayWay(3);
                a(directPayContentResponse.hasPwd(), directPayContentResponse.hasBindCards());
                k();
            } else {
                this.c.initPayStrategy(this.b);
                if (this.c.getPayWay() == 2) {
                    StatHelper.cachePayWay(1);
                } else {
                    StatHelper.cachePayWay(0);
                }
                a(directPayContentResponse.hasPwd(), directPayContentResponse.hasBindCards());
                if (PayDataCache.getInstance().isRemotePay()) {
                    b(directPayContentResponse);
                    this.b.finishWithoutAnim();
                    return;
                }
                i();
            }
        } else {
            com.baidu.wallet.paysdk.c.a.a().a(this.b, directPayContentResponse, this.c);
            this.b.finishWithoutAnim();
        }
    }

    private void a(boolean z, boolean z2) {
        CardData.BondCard bondCard;
        String str;
        if (this.c != null) {
            StatHelper.cacheHasPwd(z);
            StatHelper.cacheHasBankCard(z2);
            String str2 = "0";
            String str3 = "-1";
            if (BaiduPay.PAY_FROM_AUTHORIZE.equals(this.c.mPayFrom)) {
                if (this.c.getDefaultBankCardIdx() != null) {
                    str2 = this.c.getDefaultBankCardIdx().bank_code;
                    str = this.c.getDefaultBankCardIdx().card_type + "";
                }
                str2 = str3;
                StatHelper.cacheBankCode(str2);
                StatHelper.cacheCardType(str3);
                StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PERCASHIER_PAY_ORDER, "前置收银台下单页", "paySDKPercashierPayEnter", "下单成功", new String[0]);
            }
            if (PayDataCache.getInstance().hasMobilePwd()) {
                if (this.c.getPayPrice() != null && this.c.getPayPrice().payType == PayRequest.PayPrice.PayType.BANKCARD && (bondCard = this.c.mBondCard) != null) {
                    str2 = bondCard.bank_code;
                    str = this.c.mBondCard.card_type + "";
                } else if (this.c.getPayPrice() != null && this.c.getPayPrice().payType == PayRequest.PayPrice.PayType.BALANCE) {
                    str3 = str2;
                    StatHelper.cacheBankCode(str2);
                    StatHelper.cacheCardType(str3);
                    StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PERCASHIER_PAY_ORDER, "前置收银台下单页", "paySDKPercashierPayEnter", "下单成功", new String[0]);
                }
            }
            str2 = str3;
            StatHelper.cacheBankCode(str2);
            StatHelper.cacheCardType(str3);
            StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PERCASHIER_PAY_ORDER, "前置收银台下单页", "paySDKPercashierPayEnter", "下单成功", new String[0]);
            str3 = str;
            StatHelper.cacheBankCode(str2);
            StatHelper.cacheCardType(str3);
            StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PERCASHIER_PAY_ORDER, "前置收银台下单页", "paySDKPercashierPayEnter", "下单成功", new String[0]);
        }
    }

    public void a(int i2, int i3, String str) {
        StatisticManager.onEventEnd("createPreOrder", i3);
        if (i3 == 5173 || i3 == 5172 || (i3 == 5171 && !TextUtils.isEmpty(str))) {
            PayBaseBeanActivity payBaseBeanActivity = this.b;
            if (payBaseBeanActivity != null) {
                WalletGlobalUtils.safeShowDialog(payBaseBeanActivity, 3, str);
            }
        } else if (i2 == 768) {
            f();
        } else if (com.baidu.wallet.paysdk.c.a.a().b()) {
            if (com.baidu.wallet.paysdk.c.a.a().c()) {
                PayCallBackManager.callBackLicaiBalance(this.b, 5, this.c.mOrderNo, "", "");
            } else {
                PayCallBackManager.callBackClientCancel(this.b, "PrecashierWelcomePresenterdirect handleFailure");
            }
            this.b.finishWithoutAnim();
        } else if (com.baidu.wallet.paysdk.c.a.a().b() || !com.baidu.wallet.paysdk.c.a.a().c() || com.baidu.wallet.paysdk.c.a.a().e() == null) {
            l();
        } else {
            PayCallBackManager.callBackClientCancel(this.b, "PrecashierWelcomePresenterdirect handleFailure");
        }
    }

    private ArrayList<String> a(DirectPayContentResponse directPayContentResponse) {
        UserData.Misc misc;
        ArrayList<String> arrayList = new ArrayList<>();
        PayRequest payRequest = this.c;
        String str = "\"\"";
        String str2 = (payRequest == null || TextUtils.isEmpty(payRequest.mSpNO)) ? str : this.c.mSpNO;
        if (!(directPayContentResponse == null || (misc = directPayContentResponse.misc) == null)) {
            str = misc.getInsideTransOrder();
        }
        arrayList.add(str2);
        arrayList.add(str);
        return arrayList;
    }

    public void a(int i2, int i3, String str, Object obj) {
        StatisticManager.onEventEnd("createPreOrder", i3);
        if (obj == null || !(obj instanceof DirectPayErrorContent)) {
            l();
            return;
        }
        DirectPayErrorContent directPayErrorContent = (DirectPayErrorContent) obj;
        List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), new String[0]);
        if ("1".equals(directPayErrorContent.no_need_downgrade_retry)) {
            collectData.add(directPayErrorContent.no_need_downgrade_retry);
            PayCallBackManager.callBackClientCancel(this.b, "PrecashierWelcomePresenterdirect onBeanExecFailureWithErrContent");
        } else {
            collectData.add("0");
            l();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(StatHelper.SP_NO, StatHelper.getSpNo());
        hashMap.put("pay_amount", StatHelper.getPayAmount());
        StatisticManager.onEventWithValues(PayStatServiceEvent.PRE_PAY_DOWNGRADE_RETRY, (Collection<String>) collectData, (Map<String, Object>) hashMap);
    }

    public void a(int i2, Dialog dialog) {
        String str;
        if (i2 == 3) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.hideNegativeButton();
            promptDialog.setMessage((CharSequence) WalletGlobalUtils.showStr);
            promptDialog.setPositiveBtn(ResUtils.getString(this.b, "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.DismissLoadingDialog();
                    j.this.b.finish();
                }
            });
        } else if (i2 == 64) {
            StatHelper.statServiceEvent(PayStatServiceEvent.PAY_SHOW_OPEN_CERTIFICATE_DIALOG);
            DxmNewStandardDialog dxmNewStandardDialog = (DxmNewStandardDialog) dialog;
            final DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            PayData.CertificateGuideDialog cfcaGuideDialogContent = PayDataCache.getInstance().getCfcaGuideDialogContent();
            if (cfcaGuideDialogContent != null) {
                if (!TextUtils.isEmpty(cfcaGuideDialogContent.title)) {
                    dxmNewStandardDialog.setTitleMessage(cfcaGuideDialogContent.title);
                } else {
                    dxmNewStandardDialog.setTitleMessage(ResUtils.getString(this.b, "dxm_wallet_open_certificate_dialog_title"));
                }
                if (!TextUtils.isEmpty(cfcaGuideDialogContent.content)) {
                    dxmNewStandardDialog.setMessage(cfcaGuideDialogContent.content);
                } else {
                    dxmNewStandardDialog.setMessage(ResUtils.getString(this.b, "dxm_wallet_open_certificate_dialog_title"));
                }
                if (!TextUtils.isEmpty(cfcaGuideDialogContent.btn_text)) {
                    str = cfcaGuideDialogContent.btn_text;
                } else {
                    str = ResUtils.getString(this.b, "dxm_wallet_open_certificate_dialog_btn");
                }
            } else {
                dxmNewStandardDialog.setTitleMessage(ResUtils.getString(this.b, "dxm_wallet_open_certificate_dialog_title"));
                dxmNewStandardDialog.setMessage(ResUtils.getString(this.b, "dxm_wallet_open_certificate_dialog_title"));
                str = ResUtils.getString(this.b, "dxm_wallet_open_certificate_dialog_btn");
            }
            dxmNewStandardDialog.setHideSecondBtn(true);
            dxmNewStandardDialog.setFirstBtn(str, new View.OnClickListener() {
                public void onClick(View view) {
                    StatHelper.statServiceEvent(PayStatServiceEvent.PAY_CLICK_INSTALL_CERTIFICATE);
                    WalletGlobalUtils.safeDismissDialog(j.this.b, 64);
                    SMManagerDelegate sMManagerDelegate = new SMManagerDelegate();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (payResponse != null) {
                            jSONObject.put(BeanConstants.DXM_CERTIFICATE_TRUE_NAME, (Object) payResponse.getDisplayName());
                        }
                        jSONObject.put(BeanConstants.DXM_CERTIFICATE_TYPE, (Object) PayDataCache.getInstance().getCertificateType());
                        jSONObject.put(BeanConstants.DXM_CERTIFICATE_DES, (Object) PayDataCache.getInstance().getCertificateDes());
                        jSONObject.put(BeanConstants.DXM_NEED_JUMP_OPEN_SUCCESS_PAGE, 1);
                    } catch (JSONException e) {
                        LogUtil.errord(e.getMessage());
                    }
                    sMManagerDelegate.certificateManage(j.this.b, jSONObject.toString(), new RouterCallback() {
                        public void onResult(int i2, HashMap hashMap) {
                            if (i2 != 0 || hashMap == null || hashMap.get("result") == null) {
                                PayCallBackManager.callBackClientCancel(j.this.b, "openCertificate not open");
                                return;
                            }
                            try {
                                JSONObject optJSONObject = new JSONObject(hashMap.get("result").toString()).optJSONObject("cnt");
                                if (optJSONObject == null || optJSONObject.optInt("errCode", -1) != 0) {
                                    PayCallBackManager.callBackClientCancel(j.this.b, "openCertificate cancle");
                                    return;
                                }
                                j.this.j();
                                j.this.b.finishWithoutAnim();
                            } catch (JSONException e) {
                                LogUtil.errord(e.getMessage());
                                PayCallBackManager.callBackClientCancel(j.this.b, "JSONException error");
                            }
                        }
                    });
                }
            });
            dxmNewStandardDialog.setCloseBtnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    StatisticManager.onEvent(StatServiceEvent.DXM_CLICK_CLOSE_DIALOG);
                    WalletGlobalUtils.safeDismissDialog(j.this.b, 64);
                    PayCallBackManager.callBackClientCancel(j.this.b, "openCertificate dialog cancle");
                }
            });
        }
    }

    public Dialog a(int i2) {
        if (i2 == 64) {
            return new DxmNewStandardDialog(this.b);
        }
        return this.b.onCreateDialog(i2);
    }

    public void a(String str) {
        this.a = str;
    }
}
