package com.baidu.wallet.paysdk.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import com.alipay.sdk.m.p.e;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.banksign.BankSignPayFlow;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.baidu.wallet.paysdk.banksign.datamodel.GetJumpUrlResponse;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.aa;
import com.baidu.wallet.paysdk.beans.h;
import com.baidu.wallet.paysdk.beans.n;
import com.baidu.wallet.paysdk.beans.o;
import com.baidu.wallet.paysdk.beans.y;
import com.baidu.wallet.paysdk.c.a;
import com.baidu.wallet.paysdk.datamodel.AuthorizeInfo;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.LicaiBalancePayResponse;
import com.baidu.wallet.paysdk.datamodel.LivingVerifyResultModel;
import com.baidu.wallet.paysdk.datamodel.OfflinePayQueryResponse;
import com.baidu.wallet.paysdk.datamodel.PayQueryRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PayResponse;
import com.baidu.wallet.paysdk.datamodel.QueryPayResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult;
import com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback;
import com.baidu.wallet.paysdk.presenter.PwdPayPresenterForCashdesk;
import com.baidu.wallet.paysdk.sms.controller.ISmsController;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.baidu.wallet.paysdk.ui.widget.quota.QuotaPromptDialog;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.dialog.DxmNewStandardDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanActivity;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.beans.BeanErrorContent;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.beans.sm.SMManagerDelegate;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.NFCUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import com.dxmpay.wallet.utils.StringUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public abstract class PayBaseActivity extends PayBaseBeanActivity {
    public static final int FUND_IS_FULL = 2;
    public static final int FUND_NOT_FULL = 3;
    public static final String PAY_DIALOG_HASH_ID = "paySDKDialogPayPage";
    public static final String PAY_DIALOG_HASH_NAME = "支付中弹窗页面";
    public static final int QUERY_DELTA_FOR_EASY = 3000;
    public static final int QUERY_TIME_FOR_EASY = 20000;
    public static final int REQUEST_CODE = 1000;
    public aa a;
    public PayQueryRequest b;
    public boolean c = false;
    public CountDownTimer d;
    public long e = 0;
    public ErrorContentResponse.LivingParam f;
    public boolean g = false;
    public View.OnClickListener h = new View.OnClickListener() {
        public void onClick(View view) {
            ErrorContentResponse.Operations[] operationsArr = PayBaseActivity.this.mGuidance.operations;
            if (operationsArr.length >= 1) {
                int i2 = operationsArr.length >= 3 ? 2 : 0;
                PayBaseActivity.this.c(i2);
                if (PayBaseActivity.this.mGuidance.operations[i2].getAction() != null) {
                    n action = PayBaseActivity.this.mGuidance.operations[i2].getAction();
                    PayBaseActivity payBaseActivity = PayBaseActivity.this;
                    action.a(payBaseActivity.mGuidance.operations[i2], payBaseActivity.mAct);
                }
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f3615i = new View.OnClickListener() {
        public void onClick(View view) {
            PayBaseActivity payBaseActivity = PayBaseActivity.this;
            if (payBaseActivity.mGuidance.operations.length >= 2) {
                payBaseActivity.c(1);
                if (PayBaseActivity.this.mGuidance.operations[1].getAction() != null) {
                    n action = PayBaseActivity.this.mGuidance.operations[1].getAction();
                    PayBaseActivity payBaseActivity2 = PayBaseActivity.this;
                    action.a(payBaseActivity2.mGuidance.operations[1], payBaseActivity2.mAct);
                }
            }
        }
    };
    public View.OnClickListener j = new View.OnClickListener() {
        public void onClick(View view) {
            ErrorContentResponse.Operations[] operationsArr = PayBaseActivity.this.mGuidance.operations;
            if (operationsArr.length >= 2) {
                int i2 = operationsArr.length >= 3 ? 0 : 1;
                PayBaseActivity.this.c(i2);
                if (PayBaseActivity.this.mGuidance.operations[i2].getAction() != null) {
                    n action = PayBaseActivity.this.mGuidance.operations[i2].getAction();
                    PayBaseActivity payBaseActivity = PayBaseActivity.this;
                    action.a(payBaseActivity.mGuidance.operations[i2], payBaseActivity.mAct);
                }
            }
        }
    };
    public int mBeanId = -1;
    public ErrorContentResponse mErrorContent;
    public ErrorContentResponse.Guidance mGuidance;
    public int mPayErrorCode;

    public void addDoPayorCheckCardStatistics(String str) {
        int i2 = this.mBeanId;
        String str2 = DxmPayBeanConstants.API_DO_PAY;
        if (!(i2 == 14 || i2 == 263 || (i2 == 13 && !b.a()))) {
            str2 = (this.mBeanId == 5 && h.a == 1) ? DxmPayBeanConstants.API_CHECK_CARD_INFO : "";
        }
        if (!TextUtils.isEmpty(str2)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            arrayList.add(String.valueOf(this.mPayErrorCode));
            arrayList.add(str);
            StatisticManager.onEventWithValues("payAlertAction", arrayList);
            this.mBeanId = -1;
        }
    }

    public void continuePay(boolean z) {
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        if (payRequest != null) {
            payRequest.setContinuePay(true);
            PayRequest.PayPrice payPrice = payRequest.getPayPrice();
            if (payPrice != null) {
                if (z) {
                    payPrice.payType = PayRequest.PayPrice.PayType.BANKCARD;
                    StatHelper.cachePayType(0);
                } else {
                    payPrice.payType = PayRequest.PayPrice.PayType.BALANCE;
                    StatHelper.cachePayType(1);
                }
            }
        }
        BeanActivity beanActivity = this.mAct;
        if (!(beanActivity instanceof PwdPayActivity) || ((PwdPayActivity) beanActivity).mPresenter == null || !(((PwdPayActivity) beanActivity).mPresenter instanceof PwdPayPresenterForCashdesk)) {
            BeanActivity beanActivity2 = this.mAct;
            if (!(beanActivity2 instanceof WalletSmsActivity) || ((WalletSmsActivity) beanActivity2).mController == null || !(((WalletSmsActivity) beanActivity2).mController instanceof ISmsController)) {
                BeanActivity beanActivity3 = this.mAct;
                if (beanActivity3 instanceof PwdSetAndConfirmActivity) {
                    ((PwdSetAndConfirmActivity) beanActivity3).handleConfirmPwd();
                    return;
                }
                BaseActivity.clearTasksWithFlagWithoutAnim(1);
                PayController.getInstance().gotoPwdPay(this.mAct);
                return;
            }
            ((WalletSmsActivity) beanActivity2).mController.onNextBtnClick((String) null);
            return;
        }
        ((PwdPayPresenterForCashdesk) ((PwdPayActivity) beanActivity).mPresenter).doPay();
    }

    public void doLivingPay() {
    }

    public void handleErrorContent() {
    }

    public void handleFailure(int i2, int i3, String str) {
        int i4 = 1;
        if (i2 == 12) {
            this.c = false;
            if (TextUtils.isEmpty(str)) {
                if (b.a()) {
                    str = getString(ResUtils.string(this, "ebpay_pay_fail"));
                } else {
                    str = getString(ResUtils.string(this, "ebpay_sign_fail"));
                }
            }
            PayResultContent payResultContent = new PayResultContent();
            payResultContent.mErrorMsg = str;
            if (i3 >= -1) {
                WalletGlobalUtils.safeDismissDialog(this, 0);
                CountDownTimer countDownTimer = this.d;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                    this.d = null;
                }
                PayController instance = PayController.getInstance();
                if (b.a()) {
                    i4 = 4;
                }
                instance.payPaying(this, payResultContent, i4);
                return;
            }
            "mTimeAmount=" + this.e;
            if (this.e == 0) {
                WalletGlobalUtils.safeDismissDialog(this, 0);
                PayController instance2 = PayController.getInstance();
                if (b.a()) {
                    i4 = 4;
                }
                instance2.payPaying(this, payResultContent, i4);
                StatisticManager.onEventWithValue("queryPayResultFail", String.valueOf(i3));
            }
        } else if (i2 == 768) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            continuePay(true);
        } else if (i2 == 15) {
            GlobalUtils.toast(this, str);
            WalletGlobalUtils.safeDismissDialog(this, 0);
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            if (PayDataCache.getInstance().isFromPreCashier() && (this.mAct instanceof PwdPayActivity) && payRequest != null && payRequest.getPayWay() == 2) {
                PayCallBackManager.callBackClientCancel(this, "PayBaseActivityGetCardInfo4ModifyPhone fail");
            }
        } else if (i2 == 619) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            GlobalUtils.toast(this, str);
            PayRequest payRequest2 = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            if (payRequest2 != null && payRequest2.getPayWay() == 2 && PayDataCache.getInstance().isFromPreCashier()) {
                PayCallBackManager.callBackClientCancel(this, "PayBaseActivityOfflinePayQueryResponse fail");
            }
        } else {
            super.handleFailure(i2, i3, str);
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        String str2;
        String str3;
        if (i2 == 13 || i2 == 263) {
            PayResponse payResponse = (PayResponse) obj;
            if (PayDataCache.getInstance().isFromPreCashier() && a.a().c()) {
                licaiBalancePaySuccess(3, i2, obj);
            } else if (payResponse != null && payResponse.checkResponseValidity()) {
                if (this.b == null) {
                    this.b = new PayQueryRequest();
                }
                PayQueryRequest payQueryRequest = this.b;
                payQueryRequest.mBankNo = payResponse.bank_no;
                payQueryRequest.mOrderNo = payResponse.order_no;
                if (b.a()) {
                    if (b.b()) {
                        b(0);
                        PayResultContent payResultContent = new PayResultContent();
                        payResultContent.title_url = payResponse.title_url;
                        payResultContent.paytype_info = payResponse.paytype_info;
                        payResultContent.cash_amount = "";
                        payResultContent.total_amount = "";
                        payResultContent.authorize_msg = "";
                        payResultContent.isPaySuccess = true;
                        payResultContent.paytype_desc = payResponse.sign_success_tips;
                        payResultContent.subtitle_msg = payResponse.update_mobile_desc;
                        PayController.getInstance().paySucess(this, payResultContent, 4);
                        return;
                    }
                    this.b.mName = PayQueryRequest.EASYPAY_NAME;
                    PayDataCache.getInstance().setSignSuccessTips(payResponse.sign_success_tips);
                    PayDataCache.getInstance().setAccountBankCard(payResponse.account_bank_card);
                } else if (i2 == 263) {
                    this.b.mName = PayQueryRequest.CRDDITPAY_NAME;
                } else {
                    this.b.mName = PayQueryRequest.EASYPAY_NAME;
                }
                if (payResponse.toShowH5ResultPage()) {
                    PayDataCache.getInstance().setH5ResultParams(new H5ResultParams(payResponse.redirect_sp_succpage_remain_time, payResponse.pay_result_url, payResponse.pay_result_params, payResponse.show_h5_result, CashierDeskPayResult.PayScenario.BankcardPay));
                }
                PayRequestCache.getInstance().addBeanRequestToCache(this.b.getRequestId(), this.b);
                queryPayResult();
            }
            stopCountDown();
            return;
        }
        byte[] bArr = null;
        if (i2 == 12) {
            this.c = false;
            QueryPayResponse queryPayResponse = (QueryPayResponse) obj;
            if (queryPayResponse == null || (str2 = queryPayResponse.trans_state) == null || !"0".equals(str2)) {
                "mTimeAmount====" + this.e;
                if (this.e == 0) {
                    WalletGlobalUtils.safeDismissDialog(this, 0);
                    StatisticManager.onEvent("queryPayResultFail");
                    showPaySuccessPage(false, new PayResultContent(), 1);
                    return;
                }
                return;
            }
            "######. query ok = " + System.currentTimeMillis();
            PayResultContent payResultContent2 = new PayResultContent();
            payResultContent2.subtitle_msg = queryPayResponse.display_msg;
            payResultContent2.compliance = queryPayResponse.compliance;
            payResultContent2.notify = queryPayResponse.notify;
            payResultContent2.score_tip = queryPayResponse.score_tip;
            payResultContent2.paytype_desc = queryPayResponse.paytype_desc;
            payResultContent2.coupon_msg = queryPayResponse.coupon_msg;
            payResultContent2.coupon_find_prompt = queryPayResponse.coupon_find_prompt;
            payResultContent2.title_url = queryPayResponse.title_url;
            payResultContent2.discount_info = queryPayResponse.discount_info;
            QueryPayResponse.Business business = queryPayResponse.business;
            if (business != null) {
                String str4 = business.stream_recharge_msg;
                if (str4 != null) {
                    payResultContent2.stream_recharge_msg = str4;
                }
                String str5 = queryPayResponse.business.expected_time;
                if (str5 != null) {
                    payResultContent2.expected_time = str5;
                }
            }
            payResultContent2.total_amount = queryPayResponse.total_amount;
            payResultContent2.cash_amount = queryPayResponse.cash_amount;
            payResultContent2.discount_amount = queryPayResponse.discount_amount;
            payResultContent2.pay_detail_info = queryPayResponse.pay_detail_info;
            payResultContent2.paytype_info = queryPayResponse.paytype_info;
            AuthorizeInfo authorizeInfo = queryPayResponse.authorize_info;
            if (authorizeInfo != null) {
                str3 = authorizeInfo.authorize_desc;
            } else {
                str3 = "";
            }
            payResultContent2.authorize_msg = str3;
            payResultContent2.trans_no = queryPayResponse.trans_no;
            payResultContent2.feedback_info = queryPayResponse.feedback_info;
            payResultContent2.cross_market = queryPayResponse.cross_market;
            payResultContent2.order_prefix = queryPayResponse.order_prefix;
            payResultContent2.discount_prefix = queryPayResponse.discount_prefix;
            payResultContent2.redirect_sp_succpage_remain_time = queryPayResponse.redirect_sp_succpage_remain_time;
            payResultContent2.fp_open_or_update_msg = queryPayResponse.fp_open_or_update_msg;
            payResultContent2.payResultCashbackDetail = queryPayResponse.cashback_dialog_detail;
            CountDownTimer countDownTimer = this.d;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            StatHelper.cachePayAmount(Double.valueOf(queryPayResponse.cash_amount).doubleValue());
            b(0);
            if (!b.a() || b.b()) {
                showPaySuccessPage(true, payResultContent2, 1);
            } else {
                payResultContent2.paytype_desc = PayDataCache.getInstance().getSignSuccessTips();
                PayDataCache.getInstance().setAccountBankCard((String[][]) null);
                PayDataCache.getInstance().setSignSuccessTips("");
                PayController.getInstance().paySucess(this, payResultContent2, 4);
            }
            WalletGlobalUtils.safeDismissDialog(this, 0);
        } else if (i2 == 768) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            GetJumpUrlResponse getJumpUrlResponse = (GetJumpUrlResponse) obj;
            if (getJumpUrlResponse.agreement_trans_id != null) {
                com.baidu.wallet.paysdk.banksign.a.a.a().f(getJumpUrlResponse.agreement_trans_id);
            }
            if (getJumpUrlResponse.is_signed == 0) {
                com.baidu.wallet.paysdk.banksign.a.a.a().a(true);
                String str6 = getJumpUrlResponse.form_data;
                if (str6 != null) {
                    bArr = str6.getBytes();
                }
                com.baidu.wallet.paysdk.banksign.a.a.a().a(bArr);
                com.baidu.wallet.paysdk.banksign.a.a.a().b(false);
                com.baidu.wallet.paysdk.banksign.a.a.a().d(getJumpUrlResponse.form_url);
                com.baidu.wallet.paysdk.banksign.a.a.a().e(getJumpUrlResponse.webview_title);
                BankSignPayFlow a2 = BankSignPayFlow.a();
                a2.a(BankSignPayFlow.Action.ShowGuide);
                a2.a((Context) this.mAct);
                BeanActivity beanActivity = this.mAct;
                if (beanActivity instanceof WalletSmsActivity) {
                    beanActivity.finishWithoutAnim();
                    return;
                }
                return;
            }
            continuePay(true);
        } else if (i2 == 15) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            GetCardInfoResponse getCardInfoResponse = (GetCardInfoResponse) obj;
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            if (!(getCardInfoResponse == null || payRequest == null)) {
                PayController.getInstance().completeCardPay(this.mAct, payRequest.mBondCard, getCardInfoResponse);
            }
            if (payRequest == null || payRequest.getPayWay() != 2) {
                BeanActivity beanActivity2 = this.mAct;
                if (beanActivity2 instanceof WalletSmsActivity) {
                    beanActivity2.finishWithoutAnim();
                    return;
                }
                return;
            }
            c();
        } else if (i2 == 619) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            OfflinePayQueryResponse offlinePayQueryResponse = (OfflinePayQueryResponse) obj;
            StatHelper.statServiceEvent(PayStatServiceEvent.OFFLINE_PAY_SUCCESS);
            b(0);
            if (offlinePayQueryResponse != null) {
                PayCallBackManager.callBackClientSuccess(this, offlinePayQueryResponse.notify);
            } else {
                PayCallBackManager.callBackClientSuccess(this, "");
            }
        } else if (i2 == 622) {
            licaiBalancePaySuccess(2, i2, obj);
        }
    }

    public void hideFullScreenLoading() {
    }

    public boolean isBindPay() {
        return false;
    }

    public boolean isSlidingEnable() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void licaiBalancePaySuccess(int r5, int r6, java.lang.Object r7) {
        /*
            r4 = this;
            r0 = 0
            com.dxmpay.wallet.core.utils.WalletGlobalUtils.safeDismissDialog(r4, r0)
            r1 = 622(0x26e, float:8.72E-43)
            r2 = 0
            if (r6 != r1) goto L_0x0010
            com.baidu.wallet.paysdk.datamodel.LicaiBalancePayResponse r7 = (com.baidu.wallet.paysdk.datamodel.LicaiBalancePayResponse) r7
            if (r7 == 0) goto L_0x0026
            com.baidu.wallet.paysdk.datamodel.LicaiBalancePayResponse$RepaymentOrder r7 = r7.repayment
            goto L_0x0027
        L_0x0010:
            r3 = 13
            if (r6 != r3) goto L_0x001b
            com.baidu.wallet.paysdk.datamodel.PayResponse r7 = (com.baidu.wallet.paysdk.datamodel.PayResponse) r7
            if (r7 == 0) goto L_0x0026
            com.baidu.wallet.paysdk.datamodel.LicaiBalancePayResponse$RepaymentOrder r7 = r7.repayment
            goto L_0x0027
        L_0x001b:
            r3 = 14
            if (r6 != r3) goto L_0x0026
            com.baidu.wallet.paysdk.datamodel.BalancePayResponse r7 = (com.baidu.wallet.paysdk.datamodel.BalancePayResponse) r7
            if (r7 == 0) goto L_0x0026
            com.baidu.wallet.paysdk.datamodel.LicaiBalancePayResponse$RepaymentOrder r7 = r7.repayment
            goto L_0x0027
        L_0x0026:
            r7 = r2
        L_0x0027:
            if (r7 == 0) goto L_0x0041
            java.lang.String r2 = r7.cash_amount
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            double r2 = r2.doubleValue()
            com.dxmpay.wallet.utils.StatHelper.cachePayAmount(r2)
            com.baidu.wallet.paysdk.c.a r2 = com.baidu.wallet.paysdk.c.a.a()
            java.lang.String r2 = r2.h()
            java.lang.String r7 = r7.notify
            goto L_0x0042
        L_0x0041:
            r7 = r2
        L_0x0042:
            r4.b((int) r5)
            java.lang.String r5 = ""
            if (r6 == r1) goto L_0x005b
            com.baidu.wallet.paysdk.c.a r6 = com.baidu.wallet.paysdk.c.a.a()
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r6 = r6.e()
            if (r6 == 0) goto L_0x0054
            goto L_0x005b
        L_0x0054:
            com.dxmpay.wallet.core.beans.BeanActivity r6 = r4.mAct
            r7 = 3
            com.baidu.wallet.paysdk.PayCallBackManager.callBackLicaiBalance(r6, r7, r5, r5, r5)
            goto L_0x0060
        L_0x005b:
            com.dxmpay.wallet.core.beans.BeanActivity r6 = r4.mAct
            com.baidu.wallet.paysdk.PayCallBackManager.callBackLicaiBalance(r6, r0, r2, r7, r5)
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.ui.PayBaseActivity.licaiBalancePaySuccess(int, int, java.lang.Object):void");
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        ErrorContentResponse errorContentResponse;
        LicaiBalancePayResponse.RepaymentOrder repaymentOrder;
        ErrorContentResponse.Guidance guidance;
        ErrorContentResponse errorContentResponse2;
        StatHelper.cacheCodeAndMsg(i3 + "", str);
        this.mDialogMsg = str;
        if (obj != null && (obj instanceof ErrorContentResponse)) {
            this.mErrorContent = (ErrorContentResponse) obj;
        }
        if (i3 == 15500) {
            this.mPayErrorCode = i3;
            this.mBeanId = i2;
            WalletGlobalUtils.safeDismissDialog(this, 0);
            WalletGlobalUtils.safeShowDialog(this, 34, "");
        } else if (i3 == 80320 || i3 == 80321 || i3 == 80326 || i3 == 80327) {
            PayDataCache.getInstance().cleanDetainmentDesc();
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if (!TextUtils.isEmpty(str)) {
                this.mPayErrorCode = i3;
                this.mBeanId = i2;
                WalletGlobalUtils.safeShowDialog(this, 35, "");
            }
        } else if (i3 != 51010 || (errorContentResponse2 = this.mErrorContent) == null || errorContentResponse2.verify == null) {
            ErrorContentResponse errorContentResponse3 = this.mErrorContent;
            if (errorContentResponse3 != null && (guidance = errorContentResponse3.guidance) != null && guidance.isGuidanceAvilable()) {
                StatisticManager.onEvent("payTimeoutGuidanceState", String.valueOf(i3));
                WalletGlobalUtils.safeDismissDialog(this, 0);
                WalletGlobalUtils.safeDismissDialog(this, -1);
                WalletGlobalUtils.safeDismissDialog(this, -2);
                if (!(b.a() || i3 == 100015 || i3 == 16545)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(StatHelper.HASH_NAME, PAY_DIALOG_HASH_NAME);
                    hashMap.put("hash", PAY_DIALOG_HASH_ID);
                    hashMap.put(StatHelper.EVENT_TAG, "展示");
                    hashMap.put(StatHelper.PAGE_NAME, StatHelper.PAY_SDK_CASHDESH_PAY_NAME);
                    hashMap.put(StatHelper.PAGE_ID, StatHelper.PAY_SDK_CASHDESH_PAY_ID);
                    hashMap.put(StatHelper.EVENT_PATH, "paySDK_pay_guidance_enter");
                    hashMap.put(StatHelper.EVENT_MOLD, StatHelper.PAY_SDK_AUTO_ACTION);
                    StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_ENTER, hashMap, i3 + "", str);
                }
                ErrorContentResponse errorContentResponse4 = this.mErrorContent;
                this.f = errorContentResponse4.living_param;
                a(errorContentResponse4.guidance);
                this.mGuidance = this.mErrorContent.guidance;
                this.mPayErrorCode = i3;
                this.mBeanId = i2;
                if (619 == i2) {
                    StatHelper.statServiceEvent(PayStatServiceEvent.SHOW_OFFLINE_DIALOG);
                }
                WalletGlobalUtils.safeShowDialog(this, 53, "");
            } else if (i2 == 13 && i3 == 5320 && this.mErrorContent != null) {
                WalletGlobalUtils.safeDismissDialog(this, 0);
                ErrorContentResponse.Verify verify = this.mErrorContent.verify;
                if (verify != null) {
                    a(verify.getVerifyType(), i3, str);
                }
                ErrorContentResponse errorContentResponse5 = this.mErrorContent;
                triggerSmsVerify(errorContentResponse5.verify, false, errorContentResponse5.hint_sms, 5320);
                StatisticManager.onEvent("event_banks_need_to_verify_sms");
                b();
            } else if ((i2 != 13 && i2 != 14) || !PayDataCache.getInstance().isFromPreCashier() || !a.a().c() || a.a().e() == null || (errorContentResponse = this.mErrorContent) == null || (repaymentOrder = errorContentResponse.fund) == null || errorContentResponse.repayment == null) {
                super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
            } else if (!"0".equals(repaymentOrder.errno) || "0".equals(this.mErrorContent.repayment.errno)) {
                super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
            } else {
                WalletGlobalUtils.safeDismissDialog(this, 0);
                WalletGlobalUtils.safeShowDialog(this.mAct, 65, "");
            }
        } else {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if (!TextUtils.isEmpty(this.mErrorContent.verify.type)) {
                a(this.mErrorContent.verify.type, i3, str);
                a(this.mErrorContent.verify);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        Serializable serializable;
        super.onCreate(bundle);
        if (!(bundle == null || (serializable = bundle.getSerializable("mCardInfoUpdateContent")) == null || !(serializable instanceof ErrorContentResponse))) {
            this.mErrorContent = (ErrorContentResponse) serializable;
        }
        setFlagPaySdk();
    }

    public Dialog onCreateDialog(int i2) {
        ErrorContentResponse.Guidance guidance;
        if (i2 == 53 && (guidance = this.mGuidance) != null && guidance.isGuidanceAvilable()) {
            if (isBindPay()) {
                ErrorContentResponse.Guidance guidance2 = this.mGuidance;
                guidance2.operations = a(guidance2.operations);
            }
            if (this.mGuidance.operations.length > 0) {
                PromptMultiBtnDialog promptMultiBtnDialog = new PromptMultiBtnDialog(this);
                promptMultiBtnDialog.setNewDialogStyle(true);
                return promptMultiBtnDialog;
            }
        } else if (i2 == 57) {
            return new QuotaPromptDialog(this);
        } else {
            if (i2 == 64) {
                return new DxmNewStandardDialog(this);
            }
            if (i2 == 65) {
                return new PromptDialog(this);
            }
        }
        return super.onCreateDialog(i2);
    }

    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.d = null;
        }
        BeanManager.getInstance().removeAllBeans("PayBaseActivity");
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event != null && "ev_bean_execut_err_content".equals(event.mEventKey)) {
            Object obj = event.mEventObj;
            if (obj instanceof BeanErrorContent) {
                BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
                onBeanExecFailureWithErrContent(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg(), beanErrorContent.getErrContent());
                EventBus.getInstance().removeStickyEvent("ev_bean_execut_err_content");
            }
        }
    }

    public void onNegativeBtnClick() {
    }

    public void onOtherPayTypeClick(int i2) {
        WalletGlobalUtils.safeDismissDialog(this, i2);
    }

    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
        }
        EventBus.getInstance().unregister((Object) this, "ev_bean_execut_err_content");
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        String str;
        CardData.BondCard bondCard;
        if (i2 == 53) {
            ErrorContentResponse.Guidance guidance = this.mGuidance;
            if (guidance != null && guidance.isGuidanceAvilable()) {
                a(dialog, this.mGuidance);
            }
        } else if (i2 == 18) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setCanceledOnTouchOutside(false);
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            String detainmentDesc = PayDataCache.getInstance().getDetainmentDesc();
            if (TextUtils.isEmpty(detainmentDesc)) {
                detainmentDesc = ResUtils.getString(this, "ebpay_confirm_abandon_pay");
            }
            promptDialog.setMessage((CharSequence) detainmentDesc);
            HashMap hashMap = new HashMap();
            hashMap.put(StatHelper.HASH_NAME, PwdPayActivity.PWD_PAY_HASH_NAME);
            hashMap.put("hash", PwdPayActivity.PWD_PAY_HASH_ID);
            hashMap.put(StatHelper.EVENT_TAG, "展示取消支付弹窗");
            hashMap.put(StatHelper.PAGE_NAME, StatHelper.PAY_SDK_CASHDESH_PAY_NAME);
            hashMap.put(StatHelper.PAGE_ID, StatHelper.PAY_SDK_CASHDESH_PAY_ID);
            hashMap.put(StatHelper.EVENT_PATH, "paySDK_cancelDoPayAlert");
            hashMap.put(StatHelper.EVENT_MOLD, StatHelper.PAY_SDK_AUTO_ACTION);
            StatHelper.statServiceEvent("cancelDoPayAlert", hashMap, detainmentDesc, PayDataCache.getInstance().getInsideTransOrder());
            promptDialog.setNegativeBtn(ResUtils.string(this, "ebpay_abandom_pay_comfirm"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    if (!PayDataCache.getInstance().isFromPreCashier()) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_CANCEL);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(StatHelper.HASH_NAME, PwdPayActivity.PWD_PAY_HASH_NAME);
                    hashMap.put("hash", PwdPayActivity.PWD_PAY_HASH_ID);
                    hashMap.put(StatHelper.EVENT_TAG, "展示取消支付弹窗，点击确认");
                    hashMap.put(StatHelper.PAGE_NAME, StatHelper.PAY_SDK_CASHDESH_PAY_NAME);
                    hashMap.put(StatHelper.PAGE_ID, StatHelper.PAY_SDK_CASHDESH_PAY_ID);
                    hashMap.put(StatHelper.EVENT_PATH, StatHelper.PAY_SDK_EVENT_PATH + StatServiceEvent.EVENT_CLICK_CONFIRM_IN_QUIT_DIALOG);
                    hashMap.put(StatHelper.EVENT_MOLD, StatHelper.PAY_SDK_AUTO_ACTION);
                    StatisticManager.onEventWithValues(StatServiceEvent.EVENT_CLICK_CONFIRM_IN_QUIT_DIALOG, (Collection<String>) null, (Map<String, Object>) hashMap);
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this, 18);
                    PayCallBackManager.callBackClientCancel(PayBaseActivity.this, "PayBaseActivity.onPrepareDialog().1");
                }
            });
            promptDialog.setPositiveBtn(ResUtils.string(this, "dxm_ebpay_cancel"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(StatHelper.HASH_NAME, PwdPayActivity.PWD_PAY_HASH_NAME);
                    hashMap.put("hash", PwdPayActivity.PWD_PAY_HASH_ID);
                    hashMap.put(StatHelper.EVENT_TAG, "展示取消支付弹窗，点击取消");
                    hashMap.put(StatHelper.PAGE_NAME, StatHelper.PAY_SDK_CASHDESH_PAY_NAME);
                    hashMap.put(StatHelper.PAGE_ID, StatHelper.PAY_SDK_CASHDESH_PAY_ID);
                    hashMap.put(StatHelper.EVENT_PATH, StatHelper.PAY_SDK_EVENT_PATH + StatServiceEvent.EVENT_CLICK_CANCEL_IN_QUIT_DIALOG);
                    hashMap.put(StatHelper.EVENT_MOLD, StatHelper.PAY_SDK_AUTO_ACTION);
                    StatisticManager.onEventWithValues(StatServiceEvent.EVENT_CLICK_CANCEL_IN_QUIT_DIALOG, (Collection<String>) null, (Map<String, Object>) hashMap);
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this, 18);
                }
            });
        } else if (i2 == 34) {
            StatisticManager.onEvent("showCardOverDue");
            PayRequest payRequest2 = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            if (!(payRequest2 == null || (bondCard = payRequest2.mBondCard) == null)) {
                bondCard.isCheckPass = true;
            }
            PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
            promptMultiBtnDialog.setMessage((CharSequence) this.mDialogMsg);
            promptMultiBtnDialog.setFirstBtn(ResUtils.string(this, "ebpay_wallet_continue_pay"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    PayBaseActivity payBaseActivity = PayBaseActivity.this;
                    payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity.getActivity(), "ebpay_wallet_continue_pay"));
                    StatisticManager.onEvent("continueFromCardOverdue");
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this, 34);
                    PayController instance = PayController.getInstance();
                    PayBaseActivity payBaseActivity2 = PayBaseActivity.this;
                    instance.updateCardInfoPay(payBaseActivity2, payBaseActivity2.mErrorContent);
                    PayBaseActivity.this.finishWithoutAnim();
                }
            });
            promptMultiBtnDialog.setSecondBtn(ResUtils.string(this, "ebpay_use_other_paytype"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    PayBaseActivity payBaseActivity = PayBaseActivity.this;
                    payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity.getActivity(), "ebpay_use_other_paytype"));
                    PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
                    if (payRequest != null) {
                        payRequest.clearMktSolution();
                    }
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this, 34);
                    PayController.getInstance().gotoPayTypePage(PayBaseActivity.this, false);
                    PayBaseActivity.this.finishWithoutAnim();
                }
            });
            promptMultiBtnDialog.setThirdBtn("取消", (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    PayBaseActivity.this.addDoPayorCheckCardStatistics("取消");
                    PayBaseActivity.this.d(34);
                    PayBaseActivity payBaseActivity = PayBaseActivity.this;
                    if (payBaseActivity instanceof WalletSmsActivity) {
                        payBaseActivity.finishWithoutAnim();
                    }
                }
            });
        } else if (i2 == 35) {
            StatisticManager.onEvent("showOrigPriceAlert");
            PromptMultiBtnDialog promptMultiBtnDialog2 = (PromptMultiBtnDialog) dialog;
            promptMultiBtnDialog2.setMessage((CharSequence) this.mDialogMsg);
            promptMultiBtnDialog2.setFirstBtn(ResUtils.getString(this, "bd_wallet_pay_by_order_price"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    StatisticManager.onEvent("origPriceFromAlert");
                    PayBaseActivity payBaseActivity = PayBaseActivity.this;
                    payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity.getActivity(), "bd_wallet_pay_by_order_price"));
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this, 35);
                    PayBaseActivity.this.handleErrorContent();
                }
            });
            promptMultiBtnDialog2.setSecondBtn(ResUtils.getString(this, "ebpay_use_other_paytype"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    PayBaseActivity payBaseActivity = PayBaseActivity.this;
                    payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity.getActivity(), "ebpay_use_other_paytype"));
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this, 35);
                    PayController.getInstance().gotoPayTypePage(PayBaseActivity.this, false);
                    PayBaseActivity.this.finishWithoutAnim();
                }
            });
            promptMultiBtnDialog2.setThirdBtn("取消", (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    PayBaseActivity.this.addDoPayorCheckCardStatistics("取消");
                    PayBaseActivity.this.d(35);
                }
            });
        } else if (i2 == 54) {
            StatisticManager.onEvent("livingVerifyDialogShow");
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setCanceledOnTouchOutside(false);
            promptDialog2.setMessage((CharSequence) ResUtils.getString(this.mAct, "wallet_base_finish_living_verify"));
            promptDialog2.setNegativeBtn(ResUtils.getString(this.mAct, "dxm_ebpay_cancel"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this.mAct, 54);
                    PayBaseActivity.this.onNegativeBtnClick();
                }
            });
            promptDialog2.setPositiveBtn(ResUtils.getString(this.mAct, "wallet_base_revalidation"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this.mAct, 54);
                    StatisticManager.onEvent("livingVerifyDialogRetry");
                    PayBaseActivity.this.triggerLivingVerify();
                }
            });
        } else if (i2 == 57) {
            ErrorContentResponse errorContentResponse = this.mErrorContent;
            if (errorContentResponse != null && errorContentResponse.banklimit != null) {
                QuotaPromptDialog quotaPromptDialog = (QuotaPromptDialog) dialog;
                quotaPromptDialog.setCanceledOnTouchOutside(false);
                StatHelper.statServiceEvent(PayStatServiceEvent.SHOW_QUOTA_DIALOG);
                ErrorContentResponse.BankLimit bankLimit = this.mErrorContent.banklimit;
                if (!TextUtils.isEmpty(bankLimit.title)) {
                    quotaPromptDialog.setTitleText(bankLimit.title);
                }
                if (!TextUtils.isEmpty(bankLimit.question)) {
                    quotaPromptDialog.setQuestionMsg(bankLimit.question);
                }
                if (!TextUtils.isEmpty(bankLimit.answer)) {
                    quotaPromptDialog.setAnswerMsg(bankLimit.answer);
                }
                ErrorContentResponse.BankLimit.BankLimitTip[] bankLimitTipArr = bankLimit.tips;
                if (bankLimitTipArr != null) {
                    if (bankLimitTipArr.length == 1) {
                        if (bankLimitTipArr[0] != null) {
                            if (!TextUtils.isEmpty(bankLimitTipArr[0].title)) {
                                quotaPromptDialog.setLeftTipTitle(bankLimitTipArr[0].title);
                            }
                            if (!TextUtils.isEmpty(bankLimitTipArr[0].money)) {
                                quotaPromptDialog.setLeftMoney(bankLimitTipArr[0].money);
                            }
                        }
                        quotaPromptDialog.setHideOneTip(false);
                        quotaPromptDialog.setHideTwoTip(true);
                    } else if (bankLimitTipArr.length > 1) {
                        if (bankLimitTipArr[0] != null) {
                            if (!TextUtils.isEmpty(bankLimitTipArr[0].title)) {
                                quotaPromptDialog.setLeftTipTitle(bankLimitTipArr[0].title);
                            }
                            if (!TextUtils.isEmpty(bankLimitTipArr[0].money)) {
                                quotaPromptDialog.setLeftMoney(bankLimitTipArr[0].money);
                            }
                        }
                        if (bankLimitTipArr[1] != null) {
                            if (!TextUtils.isEmpty(bankLimitTipArr[1].title)) {
                                quotaPromptDialog.setRightTipTitle(bankLimitTipArr[1].title);
                            }
                            if (!TextUtils.isEmpty(bankLimitTipArr[1].money)) {
                                quotaPromptDialog.setRightMoney(bankLimitTipArr[1].money);
                            }
                        }
                        quotaPromptDialog.setHideOneTip(true);
                        quotaPromptDialog.setHideTwoTip(false);
                    }
                }
                quotaPromptDialog.setDialogBtnOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.CLOSE_QUOTA_DIALOG);
                        WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this.mAct, 57);
                    }
                });
            }
        } else if (i2 == 64) {
            StatHelper.statServiceEvent(PayStatServiceEvent.PAY_SHOW_OPEN_CERTIFICATE_DIALOG);
            DxmNewStandardDialog dxmNewStandardDialog = (DxmNewStandardDialog) dialog;
            final DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            PayData.CertificateGuideDialog cfcaGuideDialogContent = PayDataCache.getInstance().getCfcaGuideDialogContent();
            if (cfcaGuideDialogContent != null) {
                if (!TextUtils.isEmpty(cfcaGuideDialogContent.title)) {
                    dxmNewStandardDialog.setTitleMessage(cfcaGuideDialogContent.title);
                } else {
                    dxmNewStandardDialog.setTitleMessage(ResUtils.getString(this, "dxm_wallet_open_certificate_dialog_title"));
                }
                if (!TextUtils.isEmpty(cfcaGuideDialogContent.content)) {
                    dxmNewStandardDialog.setMessage(cfcaGuideDialogContent.content);
                } else {
                    dxmNewStandardDialog.setMessage(ResUtils.getString(this, "dxm_wallet_open_certificate_dialog_title"));
                }
                if (!TextUtils.isEmpty(cfcaGuideDialogContent.btn_text)) {
                    str = cfcaGuideDialogContent.btn_text;
                } else {
                    str = ResUtils.getString(this, "dxm_wallet_open_certificate_dialog_btn");
                }
            } else {
                dxmNewStandardDialog.setTitleMessage(ResUtils.getString(this, "dxm_wallet_open_certificate_dialog_title"));
                dxmNewStandardDialog.setMessage(ResUtils.getString(this, "dxm_wallet_open_certificate_dialog_title"));
                str = ResUtils.getString(this, "dxm_wallet_open_certificate_dialog_btn");
            }
            dxmNewStandardDialog.setHideSecondBtn(true);
            dxmNewStandardDialog.setFirstBtn(str, new View.OnClickListener() {
                public void onClick(View view) {
                    StatHelper.statServiceEvent(PayStatServiceEvent.PAY_CLICK_INSTALL_CERTIFICATE);
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this.mAct, 64);
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
                    sMManagerDelegate.certificateManage(PayBaseActivity.this, jSONObject.toString(), new RouterCallback() {
                        public void onResult(int i2, HashMap hashMap) {
                            if (i2 == 0 && hashMap != null && hashMap.get("result") != null) {
                                try {
                                    JSONObject optJSONObject = new JSONObject(hashMap.get("result").toString()).optJSONObject("cnt");
                                    if (optJSONObject == null || optJSONObject.optInt("errCode", -1) != 0) {
                                        PayBaseActivity.this.a();
                                    } else {
                                        PayBaseActivity.this.continuePay(false);
                                    }
                                } catch (JSONException e) {
                                    LogUtil.errord(e.getMessage());
                                    PayBaseActivity.this.a();
                                }
                            }
                        }
                    });
                }
            });
            dxmNewStandardDialog.setCloseBtnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    StatisticManager.onEvent(StatServiceEvent.DXM_CLICK_CLOSE_DIALOG);
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this.mAct, 64);
                    PayBaseActivity.this.a();
                }
            });
        } else if (i2 == 65) {
            PromptDialog promptDialog3 = (PromptDialog) dialog;
            promptDialog3.setMessage((CharSequence) this.mDialogMsg);
            promptDialog3.setCanceledOnTouchOutside(false);
            promptDialog3.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this.mAct, 65);
                    PayCallBackManager.callBackLicaiBalance(PayBaseActivity.this.mAct, 3, a.a().h(), "", "");
                }
            });
            promptDialog3.hideNegativeButton();
        } else {
            super.onPrepareDialog(i2, dialog);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.g) {
            this.g = false;
            WalletGlobalUtils.safeShowDialog(this, 54, "");
        }
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
        }
        EventBus.getInstance().registerSticky(this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
    }

    public void onSaveInstanceState(Bundle bundle) {
        ErrorContentResponse errorContentResponse = this.mErrorContent;
        if (errorContentResponse != null) {
            bundle.putSerializable("mCardInfoUpdateContent", errorContentResponse);
        }
        super.onSaveInstanceState(bundle);
    }

    public void queryPayResult() {
        if (this.a == null) {
            this.a = (aa) PayBeanFactory.getInstance().getBean((Context) this, 12, "PayBaseActivity");
        }
        this.c = true;
        this.a.setResponseCallback(this);
        this.a.execBean();
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.d = null;
        }
        long j2 = this.e;
        if (j2 <= 0) {
            j2 = 20000;
        }
        AnonymousClass1 r1 = new CountDownTimer(j2, 3000) {
            public void onFinish() {
                long unused = PayBaseActivity.this.e = 0;
                if (PayBaseActivity.this.c) {
                    "######. onFinish. query return = " + System.currentTimeMillis();
                    return;
                }
                boolean unused2 = PayBaseActivity.this.c = true;
                PayBaseActivity.this.a.setResponseCallback(PayBaseActivity.this);
                PayBaseActivity.this.a.execBean();
                "######. onTick. query = " + System.currentTimeMillis();
            }

            public void onTick(long j) {
                long unused = PayBaseActivity.this.e = j;
                if (PayBaseActivity.this.c) {
                    "######. onTick. query return = " + System.currentTimeMillis();
                    return;
                }
                "######. onTick. query = " + System.currentTimeMillis() + " , remain millis = " + j;
                boolean unused2 = PayBaseActivity.this.c = true;
                PayBaseActivity.this.a.setResponseCallback(PayBaseActivity.this);
                PayBaseActivity.this.a.execBean();
            }
        };
        this.d = r1;
        r1.start();
    }

    public abstract void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2);

    public void stopCountDown() {
    }

    public void triggerCardItemVerify(ErrorContentResponse.Verify verify) {
        String[] strArr;
        if (verify != null && (strArr = verify.card_item_required) != null && strArr.length >= 1) {
            String str = strArr[0];
            Intent intent = new Intent();
            intent.setClass(this, CardInfoCheckActivity.class);
            if (ErrorContentResponse.Verify.VERIFY_CVV2.equals(str)) {
                intent.putExtra(CardInfoCheckActivity.CHECK_INFO_STATE, 3);
                startActivityWithoutAnim(intent);
                b();
            } else if (ErrorContentResponse.Verify.VERIFY_CETIFICATE_CODE.equals(str)) {
                intent.putExtra(CardInfoCheckActivity.CHECK_INFO_STATE, 1);
                startActivityWithoutAnim(intent);
                b();
            } else if ("card_no".equals(str)) {
                intent.putExtra(CardInfoCheckActivity.CHECK_INFO_STATE, 2);
                startActivityWithoutAnim(intent);
                b();
            }
        }
    }

    public void triggerLivingVerify() {
        StatisticManager.onEvent("triggerLivingVerify");
        hideFullScreenLoading();
        final PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        if (!LocalRouter.getInstance(this).isProviderExisted("livenessidentifyauth") || this.f == null) {
            StatisticManager.onEvent("triggerLivingVerifyFailWithErrorCode");
            if (payRequest != null) {
                payRequest.mLivingResultCode = "10003";
            }
            doLivingPay();
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("showGuidePage", this.f.show_guide_page);
        hashMap.put(e.s, "DXMPayLivenessMatch");
        hashMap.put("recogType", "authToken");
        hashMap.put("authToken", this.f.usertoken);
        hashMap.put(EnterDxmPayServiceAction.SP_PARAMS, this.f.sp_params);
        hashMap.put("userDisplayName", this.f.user_display_name);
        hashMap.put("authProtocol", this.f.auth_protocol);
        LocalRouter.getInstance(this).route(this, new RouterRequest().provider("livenessidentifyauth").action("livenessidentifyauth").data(hashMap), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
                if (hashMap != null) {
                    if (i2 == 0) {
                        StatisticManager.onEvent("triggerLivingVerifySuccess");
                    } else {
                        StatisticManager.onEvent("triggerLivingVerifyFailWithErrorCode");
                        if (i2 == -203 || i2 == -202 || i2 == -201 || i2 == -402) {
                            boolean unused = PayBaseActivity.this.g = true;
                            return;
                        }
                    }
                    if (hashMap.get("value") != null) {
                        LivingVerifyResultModel c = PayBaseActivity.this.d(hashMap.get("value").toString());
                        PayRequest payRequest = payRequest;
                        if (!(payRequest == null || c == null)) {
                            payRequest.mLivingKey = c.callback_key;
                        }
                    }
                } else {
                    StatisticManager.onEvent("triggerLivingVerifyFailWithErrorCode");
                }
                if (i2 == -100 || i2 == 5) {
                    i2 = 10003;
                }
                PayRequest payRequest2 = payRequest;
                if (payRequest2 != null) {
                    payRequest2.mLivingResultCode = i2 + "";
                }
                PayBaseActivity.this.doLivingPay();
            }
        });
    }

    public void triggerSmsVerify(ErrorContentResponse.Verify verify, boolean z, String str, int i2) {
        StatHelper.statServiceEvent("triggleSmsPay");
        Intent intent = new Intent();
        intent.setClass(this, WalletSmsActivity.class);
        intent.putExtra(DxmPayBeanConstants.SMS_ACTIVITY_FROM_KEY, 1);
        intent.putExtra(DxmPayBeanConstants.KEY_SEND_SMS_AUTO, z);
        intent.putExtra(DxmPayBeanConstants.EXTRA_VERIFY_VOICE_DATA, verify);
        intent.putExtra(DxmPayBeanConstants.KEY_SMS_HINT, str);
        intent.putExtra(DxmPayBeanConstants.KEY_THE_REASON_FOR_SENDING, i2);
        startActivityWithoutAnim(intent);
    }

    public void triggerSpeechVerify(ErrorContentResponse.Verify verify) {
        StatisticManager.onEvent("triggerSpeechVerify");
        Intent intent = new Intent();
        intent.setClass(this, VoiceVerifyActivity.class);
        intent.putExtra(DxmPayBeanConstants.SMS_ACTIVITY_FROM_KEY, 1);
        intent.putExtra(DxmPayBeanConstants.EXTRA_VERIFY_VOICE_DATA, verify);
        startActivityWithoutAnim(intent);
    }

    private void d(Dialog dialog, ErrorContentResponse.Guidance guidance) {
        PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
        promptMultiBtnDialog.setCanceledOnTouchOutside(false);
        if (guidance != null) {
            if (!TextUtils.isEmpty(guidance.prompt_head)) {
                promptMultiBtnDialog.setTitleMessage(guidance.prompt_head);
            }
            if (!TextUtils.isEmpty(guidance.prompt_body)) {
                promptMultiBtnDialog.setMessage(StringUtil.parseColorString(a(guidance.prompt_body)));
            }
            a(promptMultiBtnDialog);
        }
        promptMultiBtnDialog.setFirstBtn(guidance.operations[0].getActionName(), this.j);
        promptMultiBtnDialog.setSecondBtn(guidance.operations[1].getActionName(), this.f3615i);
        promptMultiBtnDialog.setThirdBtn(guidance.operations[2].getActionName(), this.h);
        promptMultiBtnDialog.setFirstBtnTip(guidance.operations[0].tip);
        promptMultiBtnDialog.setSecondBtnTip(guidance.operations[1].tip);
        promptMultiBtnDialog.setThirdBtnTip(guidance.operations[2].tip);
        promptMultiBtnDialog.setHideSecondBtn(false);
        promptMultiBtnDialog.setHideThirdBtn(false);
    }

    /* access modifiers changed from: private */
    public void c(int i2) {
        ErrorContentResponse.Operations[] operationsArr;
        ErrorContentResponse.Operations[] operationsArr2;
        boolean z;
        ErrorContentResponse.Guidance guidance = this.mGuidance;
        if (guidance != null && (operationsArr = guidance.operations) != null) {
            boolean z2 = true;
            if (operationsArr.length > 1) {
                int i3 = 0;
                boolean z3 = false;
                boolean z4 = false;
                boolean z5 = false;
                while (true) {
                    operationsArr2 = this.mGuidance.operations;
                    if (i3 >= operationsArr2.length) {
                        break;
                    }
                    if (ErrorContentResponse.Operations.CASHDESK_CLOSE.equals(operationsArr2[i3].type)) {
                        z3 = true;
                    } else if ("change_paytype".equals(this.mGuidance.operations[i3].type)) {
                        z5 = true;
                    } else if (ErrorContentResponse.Operations.BIND_OTHER_CARDS.equals(this.mGuidance.operations[i3].type)) {
                        z4 = true;
                    }
                    i3++;
                }
                if (619 == this.mBeanId && ErrorContentResponse.Operations.CASHDESK_CLOSE.equals(operationsArr2[i2].type)) {
                    StatHelper.statServiceEvent(PayStatServiceEvent.OFFLINE_CASHDESK_CLOSE);
                }
                if (z3) {
                    z = ErrorContentResponse.Operations.CASHDESK_CLOSE.equals(this.mGuidance.operations[i2].type);
                } else {
                    if (z4 || z5) {
                        z = !ErrorContentResponse.Operations.HELP_CENTER.equals(this.mGuidance.operations[i2].type);
                    }
                    addDoPayorCheckCardStatistics(this.mGuidance.operations[i2].getActionName());
                }
                z2 = z;
                addDoPayorCheckCardStatistics(this.mGuidance.operations[i2].getActionName());
            }
            if (z2) {
                WalletGlobalUtils.safeDismissDialog(this.mAct, 53);
            }
        }
    }

    private void b(int i2) {
        StatHelper.cachePayType(i2);
        if (PayDataCache.getInstance().isFromPreCashier()) {
            StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY);
            StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PERCASHIER_PAY_SUCCESS, PayCallBackManager.PRE_HASH_NAME, PayCallBackManager.PRE_HASH_ID, PayCallBackManager.PAY_SUCCESS_MSG, new String[0]);
            return;
        }
        StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY);
        StatHelper.statPayAllServiceEvent(PayStatServiceEvent.STD_PAY_SUCCESS, PayCallBackManager.STD_HASH_NAME, PayCallBackManager.STD_HASH_ID, PayCallBackManager.PAY_SUCCESS_MSG, new String[0]);
    }

    /* access modifiers changed from: private */
    public void a() {
        LinkedList<BaseActivity> linkedList;
        PayRequest.PayPrice payPrice;
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        if (!(payRequest == null || (payPrice = payRequest.getPayPrice()) == null)) {
            payPrice.payType = PayRequest.PayPrice.PayType.BANKCARD;
        }
        if (PayDataCache.getInstance().isFromPreCashier()) {
            if (PayRequestCache.getInstance().isPaying() && (linkedList = BaseActivity.mActivityStack) != null && linkedList.size() == 1) {
                PayCallBackManager.callBackClientCancel(this.mAct, "openCfcaFail");
            }
        } else if (BaseActivity.tasksIsExistActivityWithActivityName(OrderConfirmActivity.class)) {
            BaseActivity.clearTasksWithActivityName(OrderConfirmActivity.class);
        }
    }

    private void b(Dialog dialog, ErrorContentResponse.Guidance guidance) {
        PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
        promptMultiBtnDialog.setCanceledOnTouchOutside(false);
        if (guidance != null) {
            if (!TextUtils.isEmpty(guidance.prompt_head)) {
                promptMultiBtnDialog.setTitleMessage(guidance.prompt_head);
            }
            if (!TextUtils.isEmpty(guidance.prompt_body)) {
                promptMultiBtnDialog.setMessage(StringUtil.parseColorString(a(guidance.prompt_body)));
            }
            a(promptMultiBtnDialog);
        }
        promptMultiBtnDialog.setFirstBtn(guidance.operations[0].getActionName(), this.h);
        promptMultiBtnDialog.setFirstBtnTip(guidance.operations[0].tip);
        promptMultiBtnDialog.setHideSecondBtn(true);
        promptMultiBtnDialog.setHideThirdBtn(true);
    }

    private void c(Dialog dialog, ErrorContentResponse.Guidance guidance) {
        PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
        promptMultiBtnDialog.setCanceledOnTouchOutside(false);
        if (guidance != null) {
            if (!TextUtils.isEmpty(guidance.prompt_head)) {
                promptMultiBtnDialog.setTitleMessage(guidance.prompt_head);
            }
            if (!TextUtils.isEmpty(guidance.prompt_body)) {
                promptMultiBtnDialog.setMessage(StringUtil.parseColorString(a(guidance.prompt_body)));
            }
            a(promptMultiBtnDialog);
        }
        if (TextUtils.equals(ErrorContentResponse.Operations.LIVING_AGAIN, guidance.operations[1].type)) {
            StatisticManager.onEvent("livingVerifyDialogShow");
        }
        promptMultiBtnDialog.setFirstBtn(guidance.operations[0].getActionName(), this.h);
        promptMultiBtnDialog.setSecondBtn(guidance.operations[1].getActionName(), this.j);
        promptMultiBtnDialog.setFirstBtnTip(guidance.operations[0].tip);
        promptMultiBtnDialog.setSecondBtnTip(guidance.operations[1].tip);
        promptMultiBtnDialog.setHideThirdBtn(true);
    }

    /* access modifiers changed from: private */
    public void d(int i2) {
        WalletGlobalUtils.safeDismissDialog(this, i2);
        onNegativeBtnClick();
    }

    private void a(Dialog dialog, ErrorContentResponse.Guidance guidance) {
        ErrorContentResponse.Operations[] operationsArr;
        if (guidance != null && (operationsArr = guidance.operations) != null && operationsArr.length != 0) {
            if (operationsArr.length == 1) {
                b(dialog, guidance);
            } else if (operationsArr.length == 2) {
                c(dialog, guidance);
            } else if (operationsArr.length >= 3) {
                d(dialog, guidance);
            }
        }
    }

    /* access modifiers changed from: private */
    public LivingVerifyResultModel d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (LivingVerifyResultModel) JsonUtils.fromJson(str, LivingVerifyResultModel.class);
        } catch (org.json.JSONException e2) {
            LogUtil.e("PayBaseActivity", e2.getMessage(), e2);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this instanceof PwdPayActivity) {
            finishWithoutAnim();
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        WalletGlobalUtils.safeShowDialog(this.mAct, 0, "");
        com.baidu.wallet.paysdk.banksign.beans.b bVar = (com.baidu.wallet.paysdk.banksign.beans.b) BankSignFactory.getInstance().getBean((Context) this.mAct, 768, "PayBaseActivity");
        bVar.a(str);
        bVar.setResponseCallback(this.mAct);
        bVar.execBean();
    }

    private Spannable a(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || !str.contains(PayTypeItemView.PayTypeItemViewData.MASK_FLAG) || (split = str.split("\\^")) == null || split.length <= 1 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) {
            return new SpannableString(str);
        }
        SpannableString spannableString = new SpannableString(str.replaceAll("\\^", ""));
        spannableString.setSpan(new StyleSpan(1), split[0].length(), split[0].length() + split[1].length(), 18);
        return spannableString;
    }

    /* access modifiers changed from: private */
    public void c() {
        if ((this instanceof PwdPayActivity) || (this instanceof WalletSmsActivity)) {
            finishWithoutAnim();
        }
    }

    private void b(ErrorContentResponse.Verify verify) {
        a(verify, false);
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        AnonymousClass28 r0 = new H5LifeCycleCallback() {
            public void onActivityDestroyed(Activity activity) {
                pop();
                WalletGlobalUtils.safeShowDialog(PayBaseActivity.this.mAct, 0, "");
                y yVar = (y) PayBeanFactory.getInstance().getBean((Context) PayBaseActivity.this, (int) PayBeanFactory.BEAN_ID_QUERY_OFFLINE_PAY, "PayBaseActivity");
                yVar.setResponseCallback(PayBaseActivity.this);
                yVar.execBean();
            }
        };
        Bundle bundle = new Bundle();
        bundle.putBoolean("with_anim", false);
        bundle.putBoolean("show_share", false);
        bundle.putString("url", str);
        bundle.putParcelable("lifecycleLsnr", r0);
        r0.push();
        BaiduWalletDelegate.getInstance().openH5Module((Context) this, bundle);
    }

    private void a(PromptMultiBtnDialog promptMultiBtnDialog) {
        ErrorContentResponse errorContentResponse;
        if (promptMultiBtnDialog != null && (errorContentResponse = this.mErrorContent) != null) {
            ErrorContentResponse.BankLimit bankLimit = errorContentResponse.banklimit;
            if (bankLimit == null || TextUtils.isEmpty(bankLimit.title)) {
                promptMultiBtnDialog.setHideDialogIcon(true);
                return;
            }
            promptMultiBtnDialog.setHideDialogIcon(false);
            promptMultiBtnDialog.setDialogIconOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeShowDialog(PayBaseActivity.this.mAct, 57, "");
                }
            });
        }
    }

    private ErrorContentResponse.Operations[] a(ErrorContentResponse.Operations[] operationsArr) {
        if (operationsArr == null || operationsArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, operationsArr);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals("change_paytype", ((ErrorContentResponse.Operations) it.next()).type)) {
                it.remove();
            }
        }
        return (ErrorContentResponse.Operations[]) arrayList.toArray(new ErrorContentResponse.Operations[arrayList.size()]);
    }

    private void a(final ErrorContentResponse.Guidance guidance) {
        final HashMap hashMap = new HashMap();
        hashMap.put(StatHelper.HASH_NAME, PAY_DIALOG_HASH_NAME);
        hashMap.put("hash", PAY_DIALOG_HASH_ID);
        hashMap.put(StatHelper.EVENT_TAG, "点击弹窗按钮");
        hashMap.put(StatHelper.PAGE_NAME, StatHelper.PAY_SDK_CASHDESH_PAY_NAME);
        hashMap.put(StatHelper.PAGE_ID, StatHelper.PAY_SDK_CASHDESH_PAY_ID);
        hashMap.put(StatHelper.EVENT_PATH, "paySDK_pay_guidance_click");
        hashMap.put(StatHelper.EVENT_MOLD, StatHelper.PAY_SDK_AUTO_ACTION);
        if (guidance != null && guidance.operations != null) {
            final int i2 = 0;
            while (true) {
                ErrorContentResponse.Operations[] operationsArr = guidance.operations;
                if (i2 < operationsArr.length) {
                    operationsArr[i2].registerActionHandler(ErrorContentResponse.Operations.SEND_SMS, new n() {
                        public void a(Object obj, Object obj2) {
                            StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, hashMap, ErrorContentResponse.Operations.SEND_SMS);
                            PayBaseActivity.this.a((ErrorContentResponse.Verify) null, true);
                            PayBaseActivity.this.b();
                        }
                    });
                    guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.LIVING_AGAIN, new n() {
                        public void a(Object obj, Object obj2) {
                            StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, hashMap, ErrorContentResponse.Operations.LIVING_AGAIN);
                            StatisticManager.onEvent("livingVerifyDialogRetry");
                            PayBaseActivity.this.triggerLivingVerify();
                        }
                    });
                    guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.BIND_OTHER_CARDS, new n() {
                        public void a(Object obj, Object obj2) {
                            StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, hashMap, ErrorContentResponse.Operations.BIND_OTHER_CARDS);
                            PayBaseActivity payBaseActivity = PayBaseActivity.this;
                            if (payBaseActivity instanceof BindCardImplActivity) {
                                ((BindCardImplActivity) payBaseActivity).handleBindOtherCard();
                            }
                        }
                    });
                    guidance.operations[i2].registerActionHandler("change_paytype", new n() {
                        public void a(Object obj, Object obj2) {
                            StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, hashMap, "change_paytype");
                            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
                            if (payRequest != null) {
                                payRequest.clearMktSolution();
                            }
                            PayController.getInstance().gotoPayTypePage(PayBaseActivity.this, false);
                            PayBaseActivity.this.c();
                        }
                    });
                    guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.RETRY_PAY, new n() {
                        public void a(Object obj, Object obj2) {
                            StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, hashMap, ErrorContentResponse.Operations.RETRY_PAY);
                            if (PayRequestCache.getInstance().isPaying()) {
                                BaiduPayDelegate.getInstance().reOrderPay(PayBaseActivity.this.getActivity());
                            }
                        }
                    });
                    guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.CONTINUE_PAY, new n() {
                        public void a(Object obj, Object obj2) {
                            ErrorContentResponse.MktSolution mktSolution;
                            PayData.DirectPayPay directPayPay;
                            PayData.EasyPay easyPay;
                            CardData.BondCard[] bondCardArr;
                            boolean z = false;
                            String str = null;
                            StatHelper.statServiceEvent(PayStatServiceEvent.CHANGE_CARD_CONTINUE_PAY, (Map<String, Object>) null, new String[0]);
                            ErrorContentResponse.Operations[] operationsArr = guidance.operations;
                            int i2 = i2;
                            if (operationsArr[i2] != null && !TextUtils.isEmpty(operationsArr[i2].card_no)) {
                                DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
                                PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
                                if (!(payResponse == null || (directPayPay = payResponse.pay) == null || (easyPay = directPayPay.easypay) == null || (bondCardArr = easyPay.bind_card_arr) == null || bondCardArr.length <= 0)) {
                                    String str2 = guidance.operations[i2].card_no;
                                    int i3 = 0;
                                    while (true) {
                                        CardData.BondCard[] bondCardArr2 = payResponse.pay.easypay.bind_card_arr;
                                        if (i3 >= bondCardArr2.length) {
                                            break;
                                        } else if (str2.equals(bondCardArr2[i3].account_no)) {
                                            BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
                                            CardData.BondCard bondCard = payResponse.pay.easypay.bind_card_arr[i3];
                                            if (bondCard != null && 1 == bondCard.is_sign_jump_bank) {
                                                z = true;
                                            }
                                            if (payRequest != null) {
                                                payRequest.mBondCard = bondCard;
                                            }
                                            if (!(!PayDataCache.getInstance().isFromPreCashier() || PayDataCache.getInstance().getPayResponse() == null || PayDataCache.getInstance().getPayResponse().pay == null)) {
                                                PayDataCache.getInstance().getPayResponse().pay.selected_card_no = str2;
                                            }
                                            if (bindFastRequest != null) {
                                                bindFastRequest.mBondCard = bondCard;
                                                bindFastRequest.mBankCard = str2;
                                                bindFastRequest.mBankNo = bondCard.bank_code;
                                                bindFastRequest.setChannelNo(bondCard.account_bank_code);
                                                bindFastRequest.mCardInfoUpdateContent = null;
                                                bindFastRequest.setmValidDate((String) null);
                                                bindFastRequest.setmCvv((String) null);
                                            }
                                        } else {
                                            i3++;
                                        }
                                    }
                                    str = str2;
                                }
                                if (z) {
                                    PayBaseActivity.this.b(str);
                                    return;
                                }
                                if (payRequest != null) {
                                    ErrorContentResponse.Operations[] operationsArr2 = guidance.operations;
                                    int i4 = i2;
                                    if (operationsArr2[i4] != null && !TextUtils.isEmpty(operationsArr2[i4].otp_reuse_code)) {
                                        payRequest.setOtpReuseCode(guidance.operations[i2].otp_reuse_code);
                                    }
                                    ErrorContentResponse errorContentResponse = PayBaseActivity.this.mErrorContent;
                                    if (!(errorContentResponse == null || (mktSolution = errorContentResponse.mkt_solution) == null)) {
                                        payRequest.setMktSolution(mktSolution);
                                    }
                                    CardData.BondCard bondCard2 = payRequest.mBondCard;
                                    if (bondCard2 != null && !bondCard2.isCompled()) {
                                        BeanActivity beanActivity = PayBaseActivity.this.mAct;
                                        if (beanActivity instanceof WalletSmsActivity) {
                                            beanActivity.finishWithoutAnim();
                                        }
                                        BaseActivity.finishActivityWithActivityName(BindCardImplActivity.class);
                                        PayController.getInstance().completeCardPay(PayBaseActivity.this.mAct, payRequest.mBondCard);
                                        return;
                                    }
                                }
                                PayBaseActivity.this.continuePay(true);
                            }
                        }
                    });
                    guidance.operations[i2].registerActionHandler("bind_card_pay", new n() {
                        public void a(Object obj, Object obj2) {
                            int i2;
                            int i3;
                            StatHelper.statServiceEvent("bind_card_pay", (Map<String, Object>) null, new String[0]);
                            StatHelper.cachePayType(0);
                            StatHelper.cachePayWay(4);
                            BeanActivity beanActivity = PayBaseActivity.this.mAct;
                            if (beanActivity instanceof WalletSmsActivity) {
                                beanActivity.finishWithoutAnim();
                            }
                            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
                            BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
                            if (payRequest != null) {
                                payRequest.setPayWay(3);
                                CardData.BondCard bondCard = payRequest.mBondCard;
                                if (bondCard == null || bondCard.isCompled()) {
                                    if (!(!BaseActivity.tasksIsExistActivityWithActivityName(BindCardImplActivity.class) || bindFastRequest == null || (i3 = bindFastRequest.mBindFrom) == 9 || i3 == 2)) {
                                        BaseActivity.clearTasksWithActivityName(BindCardImplActivity.class);
                                        return;
                                    }
                                } else if (PayDataCache.getInstance().isFromPreCashier()) {
                                    BaseActivity.clearTasksWithFlagWithoutAnim(1);
                                }
                            } else if (!(!(PayBaseActivity.this.mAct instanceof BindCardImplActivity) || bindFastRequest == null || (i2 = bindFastRequest.mBindFrom) == 9 || i2 == 2)) {
                                return;
                            }
                            if (PayDataCache.getInstance().hasMobilePwd()) {
                                if (BaseActivity.tasksIsExistActivityWithActivityName(OrderConfirmActivity.class)) {
                                    BaseActivity.clearTasksWithActivityName(OrderConfirmActivity.class);
                                }
                                Intent intent = new Intent(PayBaseActivity.this.mAct, PwdPayActivity.class);
                                intent.putExtra("IS_FOR_BIND_CARD_PAY", true);
                                PayBaseActivity.this.startActivity(intent);
                                PayBaseActivity.this.mAct.finishWithoutAnim();
                            } else if (PayBaseActivity.this.mAct instanceof PwdSetAndConfirmActivity) {
                                BaseActivity.clearTasksWithActivityName(BindCardImplActivity.class);
                            } else {
                                PayController instance = PayController.getInstance();
                                BeanActivity beanActivity2 = PayBaseActivity.this.mAct;
                                instance.bindCardPay(beanActivity2, beanActivity2.getIntent(), true);
                            }
                        }
                    });
                    guidance.operations[i2].registerActionHandler("balance_pay", new n() {
                        public void a(Object obj, Object obj2) {
                            StatHelper.statServiceEvent("balance_pay", (Map<String, Object>) null, new String[0]);
                            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
                            if (payRequest != null) {
                                PayRequest.PayPrice payPrice = payRequest.getPayPrice();
                                if (payPrice != null) {
                                    payPrice.payType = PayRequest.PayPrice.PayType.BALANCE;
                                }
                                ErrorContentResponse.Operations[] operationsArr = guidance.operations;
                                int i2 = i2;
                                if (operationsArr[i2] != null && !TextUtils.isEmpty(operationsArr[i2].otp_reuse_code)) {
                                    payRequest.setOtpReuseCode(guidance.operations[i2].otp_reuse_code);
                                }
                            }
                            if (PayDataCache.getInstance().needOpenCertificate(PayBaseActivity.this.mAct)) {
                                WalletGlobalUtils.safeShowDialog(PayBaseActivity.this.mAct, 64, "");
                            } else {
                                PayBaseActivity.this.continuePay(false);
                            }
                        }
                    });
                    guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.NOTICE, new n() {
                        public void a(Object obj, Object obj2) {
                            ErrorContentResponse errorContentResponse;
                            LicaiBalancePayResponse.RepaymentOrder repaymentOrder;
                            StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, hashMap, ErrorContentResponse.Operations.NOTICE);
                            if (!PayDataCache.getInstance().isFromPreCashier() || !a.a().c() || a.a().e() == null || (errorContentResponse = PayBaseActivity.this.mErrorContent) == null || (repaymentOrder = errorContentResponse.fund) == null || errorContentResponse.repayment == null || !"0".equals(repaymentOrder.errno) || "0".equals(PayBaseActivity.this.mErrorContent.repayment.errno)) {
                                PayBaseActivity.this.onNegativeBtnClick();
                            } else {
                                PayCallBackManager.callBackLicaiBalance(PayBaseActivity.this.mAct, 3, a.a().h(), "", "");
                            }
                        }
                    });
                    guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.CHANGE_MOBILE, new n() {
                        public void a(Object obj, Object obj2) {
                            StatHelper.statServiceEvent(PayStatServiceEvent.CHANGE_MOBILE_PAY, (Map<String, Object>) null, new String[0]);
                            BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
                            if (bindFastRequest != null && bindFastRequest.mBindFrom == 9) {
                                BeanActivity beanActivity = PayBaseActivity.this.mAct;
                                if (beanActivity instanceof WalletSmsActivity) {
                                    beanActivity.finishWithoutAnim();
                                }
                                if (PayBaseActivity.this.mAct instanceof BindCardImplActivity) {
                                    return;
                                }
                            }
                            WalletGlobalUtils.safeShowDialog(PayBaseActivity.this.mAct, 0, "");
                            o oVar = (o) PayBeanFactory.getInstance().getBean((Context) PayBaseActivity.this.mAct, 15, "PayBaseActivity");
                            oVar.setResponseCallback(PayBaseActivity.this.mAct);
                            oVar.execBean();
                        }
                    });
                    guidance.operations[i2].registerActionHandler("offline_pay", new n() {
                        public void a(Object obj, Object obj2) {
                            if (619 == PayBaseActivity.this.mBeanId) {
                                StatHelper.statServiceEvent(PayStatServiceEvent.OFFLINE_PAY_DIALOG);
                            } else {
                                StatHelper.statServiceEvent("offline_pay");
                            }
                            WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this.mAct, 53);
                            PayBaseActivity.this.c(guidance.operations[i2].jump_uri);
                        }
                    });
                    guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.OFFLINE_RECORD, new n() {
                        public void a(Object obj, Object obj2) {
                            StatHelper.statServiceEvent(PayStatServiceEvent.OFFLINE_RECORD_DIALOG);
                            WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this.mAct, 53);
                            PayBaseActivity.this.c(guidance.operations[i2].jump_uri);
                        }
                    });
                    guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.CLOSE_DIALOG, new n() {
                        public void a(Object obj, Object obj2) {
                            StatHelper.statServiceEvent(PayStatServiceEvent.CLICK_CLOSE_GUIDANCE_DIALOG);
                            WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this.mAct, 53);
                        }
                    });
                    guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.CALL_UP, new n() {
                        public void a(Object obj, Object obj2) {
                            StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, hashMap, ErrorContentResponse.Operations.CALL_UP);
                            if (PayDataCache.getInstance().isFromPreCashier()) {
                                PayCallBackManager.callBackClientCancel(PayBaseActivity.this.mAct, "click call_up");
                            } else if (BaseActivity.tasksIsExistActivityWithActivityName(OrderConfirmActivity.class)) {
                                BaseActivity.clearTasksWithActivityName(OrderConfirmActivity.class);
                            } else {
                                PayBaseActivity payBaseActivity = PayBaseActivity.this;
                                if (payBaseActivity.mAct instanceof WalletSmsActivity) {
                                    payBaseActivity.finishWithoutAnim();
                                }
                            }
                            try {
                                String str = guidance.operations[i2].mobile;
                                PayBaseActivity.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)));
                            } catch (Exception e) {
                                LogUtil.e("PayBaseActivity", e.getMessage(), e);
                            }
                        }
                    });
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    private void a(ErrorContentResponse.Verify verify) {
        if (verify != null) {
            String verifyType = verify.getVerifyType();
            if ("1".equals(verifyType)) {
                b(verify);
                b();
            } else if ("2".equals(verifyType)) {
                triggerSpeechVerify(verify);
                b();
            } else if ("3".equals(verifyType)) {
                triggerCardItemVerify(verify);
            } else if ("4".equals(verifyType)) {
                this.f = verify.living_param;
                triggerLivingVerify();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(ErrorContentResponse.Verify verify, boolean z) {
        triggerSmsVerify(verify, z, (String) null, Integer.MIN_VALUE);
    }

    private void a(String str, int i2, String str2) {
        if (!b.a()) {
            HashMap hashMap = new HashMap();
            hashMap.put(StatHelper.HASH_NAME, WalletSmsActivity.PAY_SMS_HASH_NAME);
            hashMap.put("hash", WalletSmsActivity.PAY_SMS_HASH_ID);
            hashMap.put(StatHelper.EVENT_TAG, "进入");
            hashMap.put(StatHelper.PAGE_NAME, StatHelper.PAY_SDK_CASHDESH_PAY_NAME);
            hashMap.put(StatHelper.PAGE_ID, StatHelper.PAY_SDK_CASHDESH_PAY_ID);
            hashMap.put(StatHelper.EVENT_PATH, "paySDK_pay_sms_enter");
            hashMap.put(StatHelper.EVENT_MOLD, StatHelper.PAY_SDK_AUTO_ACTION);
            StatHelper.statServiceEvent(PayStatServiceEvent.PAY_SMS_ENTER, hashMap, i2 + "", str2, str);
        }
        StatisticManager.onEventStart(PayStatServiceEvent.PAY_SMS_DURATION);
    }
}
