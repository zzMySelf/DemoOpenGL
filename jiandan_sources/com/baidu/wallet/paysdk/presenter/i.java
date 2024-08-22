package com.baidu.wallet.paysdk.presenter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.baidu.android.pay.PayCallBack;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.api.BaiduPay;
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
import com.baidu.wallet.paysdk.ui.H5PayWebViewActivity;
import com.baidu.wallet.paysdk.ui.OrderConfirmActivity;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.Base64;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class i extends k {
    public PayRequest a = null;
    public t c;

    public i(PayBaseBeanActivity payBaseBeanActivity) {
        super(payBaseBeanActivity);
    }

    private void f() {
        Pair<Integer, Object> checkSecurityEvn = BaiduWalletDelegate.getInstance().checkSecurityEvn();
        if (checkSecurityEvn != null && ((Integer) checkSecurityEvn.first).intValue() == 0) {
            Object obj = checkSecurityEvn.second;
            String str = null;
            if (obj != null && (obj instanceof String)) {
                str = (String) obj;
            }
            if (this.a != null && !TextUtils.isEmpty(str)) {
                this.a.mSecurityParams = Base64.encodeBytes(str.getBytes());
            }
        }
    }

    private void h() {
        if (!PayDataCache.getInstance().hasMobilePwd()) {
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            if (PayDataCache.getInstance().hasBondCards()) {
                StatHelper.statServiceEvent(StatServiceEvent.ENTER_SELECT_CARD_ACTIVITY);
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
        } else if (this.a.isWithHoldingValidity()) {
            PayController.getInstance().gotoWithholdPay(this.b);
        } else {
            StatHelper.statPayAllServiceEvent("enterOrderConfirmActivity", OrderConfirmActivity.PAY_ORDER_CONFIRM_HASH_NAME, OrderConfirmActivity.PAY_ORDER_CONFIRM_HASH_ID, "进入", new String[0]);
            PayController instance3 = PayController.getInstance();
            PayBaseBeanActivity payBaseBeanActivity3 = this.b;
            instance3.gotoOrderConfirm(payBaseBeanActivity3, payBaseBeanActivity3.getIntent());
        }
    }

    private void i() {
        PwdRequest pwdRequest = new PwdRequest();
        PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
        if (PayDataCache.getInstance().hasBondCards()) {
            Intent intent = new Intent(this.b, AuthorizeSignActivity.class);
            if (b.b()) {
                intent.putExtra(AuthorizeSignActivity.AUTH_SIGN_TYPE, 2);
            } else if (b.c()) {
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

    /* access modifiers changed from: private */
    public void j() {
        PayRequest payRequest = this.a;
        String str = "";
        String str2 = payRequest != null ? payRequest.mParams : str;
        "doRePayOrder->orderinfo:" + str2;
        PayRequest payRequest2 = this.a;
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

    public void a(String str) {
    }

    public void b() {
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        this.a = payRequest;
        if (payRequest != null && payRequest.checkRequestValidity()) {
            if (this.c == null) {
                PayBeanFactory instance = PayBeanFactory.getInstance();
                PayBaseBeanActivity payBaseBeanActivity = this.b;
                this.c = (t) instance.getBean((Context) payBaseBeanActivity, 1, "PayWelcomePresenter" + toString());
            }
            if (PayDataCache.getInstance().isRemotePay()) {
                StatisticManager.onEventStart("remoteCreateOrder");
            } else {
                StatisticManager.onEventStart("createOrder");
            }
            this.c.setResponseCallback(this);
            this.c.execBean();
        } else if (PayDataCache.getInstance().isRemotePay()) {
            StatisticManager.onEvent("remotePreCreateOrderPayReqInvalid");
            PayCallBackManager.callBackClientCancel(this.b, "PayWelcomePresenter.loadData().1 remotePay");
        } else {
            PayCallBackManager.callBackClientCancel(this.b, "PayWelcomePresenter.loadData().1");
        }
    }

    public void c() {
        PayCallBackManager.callBackClientCancel(this.b, "PayWelcomePresenter.callBackCancel().1");
    }

    public void d() {
        PayBaseBeanActivity payBaseBeanActivity = this.b;
        if (payBaseBeanActivity != null) {
            payBaseBeanActivity.setFlagPaySdk();
        }
    }

    public void e() {
        BeanManager instance = BeanManager.getInstance();
        instance.removeAllBeans("PayWelcomePresenter" + toString());
    }

    public boolean a(Bundle bundle) {
        if (bundle == null) {
            this.a = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        } else {
            Serializable serializable = bundle.getSerializable("mPayRequest");
            if (serializable != null && (serializable instanceof PayRequest)) {
                this.a = (PayRequest) serializable;
            }
            Serializable serializable2 = bundle.getSerializable("mPayResponse");
            if (serializable2 != null && (serializable2 instanceof DirectPayContentResponse)) {
                PayDataCache.getInstance().setPayResponse((DirectPayContentResponse) serializable2);
            }
        }
        if (this.a != null) {
            PayRequestCache.getInstance().addBeanRequestToCache(this.a.getRequestId(), this.a);
            return true;
        }
        PayCallBackManager.callBackClientCancel(this.b, "PayWelcomePresenter.initSaveInstanceData().1");
        return false;
    }

    public void a() {
        f();
        b();
    }

    public void a(int i2, Object obj, String str) {
        UserData.Misc misc;
        PayData.EasyPay easyPay;
        DirectPayContentResponse directPayContentResponse = (DirectPayContentResponse) obj;
        if (directPayContentResponse == null || !directPayContentResponse.checkResponseValidity()) {
            PayCallBackManager.callBackClientCancel(this.b, "PayWelcomePresenter.handleResponse().1");
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
        if (this.a == null) {
            PayCallBackManager.callBackClientCancel(this.b, "PayWelcomePresenter.handleResponse().2");
            return;
        }
        UserData.SP sp = directPayContentResponse.sp;
        if (sp != null && !TextUtils.isEmpty(sp.goods_name)) {
            this.a.mGoodName = directPayContentResponse.sp.goods_name;
        }
        directPayContentResponse.storeResponse(this.b);
        PayRequest payRequest = this.a;
        if (!(payRequest == null || (misc = directPayContentResponse.misc) == null)) {
            payRequest.title_url = misc.title_url;
            ArrayList<String> a2 = a(directPayContentResponse);
            if (!TextUtils.isEmpty(a2.get(0)) && !TextUtils.isEmpty(a2.get(1))) {
                if (PayDataCache.getInstance().isRemotePay()) {
                    StatisticManager.onEventEndWithValues("remoteCreateOrder", 0, (Collection<String>) a2);
                } else {
                    StatisticManager.onEventEndWithValues("createOrder", 0, (Collection<String>) a2);
                }
            }
        }
        PayData.DirectPayPay directPayPay2 = directPayContentResponse.pay;
        if (directPayPay2 != null) {
            this.a.setCalcPayment(directPayPay2.composite);
            this.a.setRandomDiscount(directPayContentResponse.pay.random_discount);
        }
        if (directPayContentResponse.isWithHoldingValidity()) {
            this.a.withholding = directPayContentResponse.authorize_common_cashdesk;
        }
        if (BaiduPay.PAY_FROM_BIND_CARD.equals(this.a.mPayFrom)) {
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            a(directPayContentResponse.hasPwd(), directPayContentResponse.hasBindCards());
            BindFastRequest bindFastRequest = new BindFastRequest();
            bindFastRequest.mBindFrom = 1;
            PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
            this.b.startActivity(new Intent(this.b, BindCardImplActivity.class));
            this.b.finishWithoutAnim();
        } else if (BaiduPay.PAY_FROM_AUTHORIZE.equals(this.a.mPayFrom)) {
            this.a.initPayStrategy(this.b);
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(3);
            a(directPayContentResponse.hasPwd(), directPayContentResponse.hasBindCards());
            Authorize authorize = directPayContentResponse.authorize;
            if (authorize != null) {
                this.a.title_url = authorize.title_url;
            }
            i();
        } else {
            this.a.initPayStrategy(this.b);
            if ("balance".equals(PayDataCache.getInstance().getDefaultPayType())) {
                StatHelper.cachePayType(1);
            } else {
                StatHelper.cachePayType(0);
            }
            if (this.a.getPayWay() == 2) {
                StatHelper.cachePayWay(1);
            } else {
                StatHelper.cachePayWay(0);
            }
            a(directPayContentResponse.hasPwd(), directPayContentResponse.hasBindCards());
            if (PayDataCache.getInstance().isRemotePay()) {
                b(directPayContentResponse);
            } else {
                h();
            }
            this.b.finishWithoutAnim();
        }
    }

    private void b(DirectPayContentResponse directPayContentResponse) {
        PayData.DirectPayPay directPayPay;
        if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || ((directPayPay.easypay == null && directPayPay.balance == null) || directPayContentResponse.user == null)) {
            StatisticManager.onEvent("remoteOrderInfoInvalid");
            PayCallBackManager.callBackClientCancel(this.b, "PayWelcomePresenter.confirmRemotePayOrderInfo().1");
            return;
        }
        h();
    }

    private void a(boolean z, boolean z2) {
        CardData.BondCard bondCard;
        if (this.a != null) {
            StatHelper.cacheHasPwd(z);
            StatHelper.cacheHasBankCard(z2);
            String str = "0";
            String str2 = "-1";
            if (BaiduPay.PAY_FROM_AUTHORIZE.equals(this.a.mPayFrom)) {
                if (this.a.getDefaultBankCardIdx() != null) {
                    str2 = this.a.getDefaultBankCardIdx().card_type + "";
                    str = this.a.getDefaultBankCardIdx().bank_code;
                } else {
                    str = str2;
                }
                if (b.c()) {
                    StatHelper.cacheSignPay("1");
                } else {
                    StatHelper.cacheSignPay("2");
                }
            } else {
                if (PayDataCache.getInstance().hasMobilePwd()) {
                    if (this.a.getPayPrice() != null && this.a.getPayPrice().payType == PayRequest.PayPrice.PayType.BANKCARD && (bondCard = this.a.mBondCard) != null) {
                        str = bondCard.bank_code;
                        str2 = this.a.mBondCard.card_type + "";
                    } else if (this.a.getPayPrice() != null && this.a.getPayPrice().payType == PayRequest.PayPrice.PayType.BALANCE) {
                        str2 = str;
                    }
                }
                str = str2;
            }
            StatHelper.cacheBankCode(str);
            StatHelper.cacheCardType(str2);
            StatHelper.statPayAllServiceEvent(PayStatServiceEvent.STD_PAY_ORDER, "标准收银台下单页", "paySDKStdPayEnter", "下单成功", new String[0]);
        }
    }

    public void a(int i2, int i3, String str) {
        if (i3 == 65340) {
            StatisticManager.onEventEnd("createOrder", i3);
            if (this.b != null) {
                StatisticManager.onEventWithValue(PayStatServiceEvent.PASS_NOT_MATCH_DIALOG, StatHelper.getOrderNo());
                WalletGlobalUtils.safeShowDialog(this.b, 55, str);
                return;
            }
            return;
        }
        PayRequest payRequest = this.a;
        if (payRequest != null && !BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) {
            if (PayDataCache.getInstance().isRemotePay()) {
                StatisticManager.onEventEndWithValues("remoteCreateOrder", i3, (Collection<String>) a((DirectPayContentResponse) null));
            } else {
                StatisticManager.onEventEndWithValues("createOrder", i3, (Collection<String>) a((DirectPayContentResponse) null));
            }
        }
        super.a(i2, i3, str);
    }

    private ArrayList<String> a(DirectPayContentResponse directPayContentResponse) {
        UserData.Misc misc;
        ArrayList<String> arrayList = new ArrayList<>();
        PayRequest payRequest = this.a;
        String str = "\"\"";
        String str2 = (payRequest == null || TextUtils.isEmpty(payRequest.mSpNO)) ? str : this.a.mSpNO;
        if (!(directPayContentResponse == null || (misc = directPayContentResponse.misc) == null)) {
            str = misc.getInsideTransOrder();
        }
        arrayList.add(str2);
        arrayList.add(str);
        return arrayList;
    }

    public void a(int i2, int i3, String str, Object obj) {
        DirectPayErrorContent directPayErrorContent = (obj == null || !(obj instanceof DirectPayErrorContent)) ? null : (DirectPayErrorContent) obj;
        if (i3 == 65015 && directPayErrorContent != null && !TextUtils.isEmpty(directPayErrorContent.order_url)) {
            StatisticManager.onEventWithValue(PayStatServiceEvent.JUMP_WAPCASHIER, StatHelper.getOrderNo());
            BaiduPay.getInstance().jumpWapCashier(this.b, directPayErrorContent.order_url, H5PayWebViewActivity.class.getName());
        } else if ((i3 != 5170 && i3 != 5177) || directPayErrorContent == null) {
            super.a(i2, i3, str, obj);
        } else if (TextUtils.isEmpty(directPayErrorContent.auth_url_sdk)) {
            c();
        } else {
            BaiduPayDelegate.getInstance().doPayRNAuth(this.b, directPayErrorContent.auth_url_sdk, new RNAuthCallBack() {
                public void onRNAuthResult(int i2, String str) {
                    if (i2 == 0) {
                        i.this.j();
                    } else {
                        i.this.c();
                    }
                }
            });
            this.b.finishWithoutAnim();
        }
    }

    public void a(int i2, Dialog dialog) {
        if (i2 == 55) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.hideTitle();
            promptDialog.setMessage((CharSequence) WalletGlobalUtils.showStr);
            promptDialog.setPositiveBtn(ResUtils.string(this.b, "wallet_base_to_rnauth_for_pay"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    StatisticManager.onEventWithValue("nameNotMatchToConfirm", StatHelper.getOrderNo());
                    HashMap hashMap = new HashMap();
                    hashMap.put("service_type", "1171");
                    BaiduPayDelegate.getInstance().doRNAuth(i.this.b, hashMap, new RNAuthCallBack() {
                        public void onRNAuthResult(int i2, String str) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(StatHelper.getOrderNo());
                            arrayList.add("" + i2);
                            StatisticManager.onEventWithValues(PayStatServiceEvent.PASS_NOT_MATCH_RESULT, arrayList);
                            if (i2 == 0) {
                                i.this.j();
                            } else {
                                i.this.c();
                            }
                        }
                    });
                    WalletGlobalUtils.safeDismissDialog(i.this.b, 55);
                    i.this.b.finish();
                }
            });
            promptDialog.setNegativeBtn(ResUtils.string(this.b, "wallet_base_quit_pay"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    StatisticManager.onEventWithValue("nameNotMatchToCancel", StatHelper.getOrderNo());
                    i.this.c();
                    WalletGlobalUtils.safeDismissDialog(i.this.b, 55);
                    i.this.b.finish();
                }
            });
        }
    }

    public Dialog a(int i2) {
        return this.b.onCreateDialog(i2);
    }

    public void a(PrecashierCreateOrderResponse precashierCreateOrderResponse) {
        if (precashierCreateOrderResponse == null) {
            b();
        } else if (TextUtils.equals(precashierCreateOrderResponse.ret, "0")) {
            StatisticManager.onEventStart("createOrder");
            a(-1, (Object) precashierCreateOrderResponse.content, (String) null);
        } else if (Integer.parseInt(precashierCreateOrderResponse.ret) == 5173 || Integer.parseInt(precashierCreateOrderResponse.ret) == 5172 || (Integer.parseInt(precashierCreateOrderResponse.ret) == 5171 && !TextUtils.isEmpty(precashierCreateOrderResponse.msg))) {
            PayBaseBeanActivity payBaseBeanActivity = this.b;
            if (payBaseBeanActivity != null) {
                WalletGlobalUtils.safeShowDialog(payBaseBeanActivity, 3, precashierCreateOrderResponse.msg);
            }
        } else if (TextUtils.equals(precashierCreateOrderResponse.ret, String.valueOf(65340))) {
            StatisticManager.onEventEnd("preCreateOrderFromTransfer", Integer.valueOf(precashierCreateOrderResponse.ret).intValue());
            PayBaseBeanActivity payBaseBeanActivity2 = this.b;
            if (payBaseBeanActivity2 != null) {
                WalletGlobalUtils.safeShowDialog(payBaseBeanActivity2, 55, precashierCreateOrderResponse.msg);
            }
        } else {
            DirectPayErrorContent directPayErrorContent = precashierCreateOrderResponse.errContent;
            if (directPayErrorContent != null) {
                try {
                    if (Integer.parseInt(precashierCreateOrderResponse.ret) == 65015 && !TextUtils.isEmpty(directPayErrorContent.order_url)) {
                        BaiduPay.getInstance().jumpWapCashier(this.b, directPayErrorContent.order_url, H5PayWebViewActivity.class.getName());
                    } else if (Integer.parseInt(precashierCreateOrderResponse.ret) != 5170 && Integer.parseInt(precashierCreateOrderResponse.ret) != 5177) {
                    } else {
                        if (TextUtils.isEmpty(directPayErrorContent.auth_url_sdk)) {
                            c();
                            return;
                        }
                        this.b.finishWithoutAnim();
                        BaiduPayDelegate.getInstance().doPayRNAuth(this.b, directPayErrorContent.auth_url_sdk, new RNAuthCallBack() {
                            public void onRNAuthResult(int i2, String str) {
                                if (i2 == 0) {
                                    i.this.j();
                                } else {
                                    i.this.c();
                                }
                            }
                        });
                    }
                } catch (Exception unused) {
                    b();
                }
            } else {
                try {
                    a(-1, Integer.parseInt(precashierCreateOrderResponse.ret), precashierCreateOrderResponse.msg);
                } catch (Exception unused2) {
                    b();
                }
            }
        }
    }
}
