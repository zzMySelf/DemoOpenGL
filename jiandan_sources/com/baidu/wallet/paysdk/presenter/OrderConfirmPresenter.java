package com.baidu.wallet.paysdk.presenter;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.contract.OrderConfirmContract;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.fingerprint.b;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.OrderConfirmActivity;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OrderConfirmPresenter implements OrderConfirmContract.Presenter {
    public static final String TAG = "OrderConfirmPresenter";
    public boolean isHasShowRedDot = false;
    public OrderConfirmActivity mActivity;
    public PayRequest mPayRequest;
    public OrderConfirmContract.Presenter.OrderConfirmViewData mViewData;

    public OrderConfirmPresenter(OrderConfirmActivity orderConfirmActivity) {
        this.mActivity = orderConfirmActivity;
        orderConfirmActivity.setPresenter((OrderConfirmContract.Presenter) this);
        this.mPayRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        EventBus.getInstance().registerSticky(this, "order_confirm_event_bus_key", 0, EventBus.ThreadMode.MainThread);
    }

    public void changePwdMode() {
        OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData = this.mViewData;
        if (orderConfirmViewData != null) {
            orderConfirmViewData.isFingerprintPay = false;
            orderConfirmViewData.confirmBtnMsg = "确认支付";
            this.mActivity.reFreshUI(orderConfirmViewData);
        }
    }

    public void clickCoupon() {
        this.mActivity.gotoCoupon();
    }

    public void clickPayway() {
        this.mActivity.gotoPayType();
    }

    public void closeOrderComfirmPage() {
        if (this.mPayRequest.isWithHoldingValidity()) {
            this.mActivity.finish();
        } else {
            WalletGlobalUtils.safeShowDialog(this.mActivity, 18, "");
        }
    }

    public int getPayWay() {
        return this.mPayRequest.getPayWay();
    }

    public void getViewData() {
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        CardData.BondCard bondCard;
        PayData.DirectPayPay directPayPay;
        PayData.CreditPay creditPay;
        PayData.DirectPayPay directPayPay2;
        PayData.DirectPayBalance directPayBalance;
        PayData.DirectPayPay directPayPay3;
        String str5;
        OrderConfirmActivity orderConfirmActivity = this.mActivity;
        if (orderConfirmActivity != null && !orderConfirmActivity.isFinishing()) {
            this.mViewData = new OrderConfirmContract.Presenter.OrderConfirmViewData();
            if (PayDataCache.getInstance().isRemotePay()) {
                OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData = this.mViewData;
                if (!TextUtils.isEmpty(WalletLoginHelper.getInstance().getPassUserName())) {
                    str5 = WalletLoginHelper.getInstance().getPassUserName();
                } else {
                    str5 = PayDataCache.getInstance().getPayResponse().getDisplayName();
                }
                orderConfirmViewData.currentAccount = str5;
            }
            PayRequest payRequest = this.mPayRequest;
            if (payRequest == null) {
                PayCallBackManager.callBackClientCancel(this.mActivity, "OrderConfirmPresentergetViewData().1");
                return;
            }
            OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData2 = this.mViewData;
            orderConfirmViewData2.goodsName = payRequest.mGoodName;
            orderConfirmViewData2.orderPrice = payRequest.getOrderPrice();
            this.mViewData.discountAmount = this.mPayRequest.getDiscountAmount();
            this.mViewData.discountDesc = this.mPayRequest.getDiscountMsg();
            this.mViewData.needPayAmount = this.mPayRequest.getFinalPayAmount();
            PayRequest.PayPrice payPrice = this.mPayRequest.getPayPrice();
            if (payPrice == null) {
                PayCallBackManager.callBackClientCancel(this.mActivity, "OrderConfirmPresentergetViewData().2");
                return;
            }
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            boolean z2 = false;
            if (payResponse == null || (directPayPay3 = payResponse.pay) == null) {
                z = false;
            } else {
                z = directPayPay3.hasRecommendPaytype();
                this.mViewData.spName = payResponse.getSpName();
            }
            PayRequest.PayPrice.PayType payType = payPrice.payType;
            if (payType == PayRequest.PayPrice.PayType.BANKCARD) {
                StatHelper.cachePayType(0);
                CardData.BondCard bondCard2 = this.mPayRequest.mBondCard;
                if (bondCard2 != null) {
                    if (TextUtils.equals(bondCard2.is_recommended, "1") || !z) {
                        this.mViewData.isShowRedDot = false;
                        this.isHasShowRedDot = true;
                    } else if (!this.isHasShowRedDot) {
                        this.mViewData.isShowRedDot = true;
                    }
                    this.mViewData.payTyeDesc = this.mPayRequest.mBondCard.getCardDesc(this.mActivity, true);
                    if (!TextUtils.isEmpty(this.mPayRequest.mBondCard.channelDiscountDesc)) {
                        OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData3 = this.mViewData;
                        orderConfirmViewData3.channelDiscountDesc = this.mPayRequest.mBondCard.channelDiscountDesc;
                        orderConfirmViewData3.highlight = true;
                    }
                    if (!TextUtils.isEmpty(this.mPayRequest.mBondCard.bank_card_msg)) {
                        this.mViewData.cardTip = this.mPayRequest.mBondCard.bank_card_msg;
                    }
                    this.mViewData.hasAvailablePayType = payResponse.hasSupportCards();
                } else {
                    this.mViewData.payTyeDesc = ResUtils.getString(this.mActivity, "ebpay_has_no_avaible_pay_type");
                    this.mViewData.hasAvailablePayType = false;
                }
            } else if (payType == PayRequest.PayPrice.PayType.BALANCE) {
                StatHelper.cachePayType(1);
                if (!z) {
                    this.mViewData.isShowRedDot = false;
                } else if (payResponse != null && (directPayPay2 = payResponse.pay) != null && (directPayBalance = directPayPay2.balance) != null && TextUtils.equals(directPayBalance.is_recommended, "1")) {
                    this.mViewData.isShowRedDot = false;
                    this.isHasShowRedDot = true;
                } else if (!this.isHasShowRedDot) {
                    this.mViewData.isShowRedDot = true;
                }
                this.mViewData.payTyeDesc = ResUtils.getString(this.mActivity, "ebpay_balance_pay");
                this.mViewData.hasAvailablePayType = PayDataCache.getInstance().isBalanceEnough();
            } else if (payType == PayRequest.PayPrice.PayType.CREIDT) {
                if (!z) {
                    this.mViewData.isShowRedDot = false;
                } else if (payResponse != null && (directPayPay = payResponse.pay) != null && (creditPay = directPayPay.credit_pay) != null && TextUtils.equals(creditPay.is_recommended, "1")) {
                    this.mViewData.isShowRedDot = false;
                    this.isHasShowRedDot = true;
                } else if (!this.isHasShowRedDot) {
                    this.mViewData.isShowRedDot = true;
                }
                this.mViewData.payTyeDesc = ResUtils.getString(this.mActivity, "ebpay_credit_pay");
                this.mViewData.hasAvailablePayType = PayDataCache.getInstance().oneKeyPayForCredit();
            }
            OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData4 = this.mViewData;
            if (!orderConfirmViewData4.hasAvailablePayType) {
                orderConfirmViewData4.payTyeDesc = ResUtils.getString(this.mActivity, "ebpay_has_no_avaible_pay_type");
            }
            this.mViewData.showDiscount = this.mPayRequest.showCouponListEntry();
            this.mViewData.randomDiscountMsg = this.mPayRequest.getRandomDiscountMsg();
            PayRequest payRequest2 = this.mPayRequest;
            if (!payRequest2.supportFingerprintPay) {
                payRequest2.clearFingerPrintData();
            }
            UserData.Misc misc = payResponse.misc;
            UserData.Misc.ConfirmButtonMsg payButtonMsg = misc != null ? misc.getPayButtonMsg() : null;
            OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData5 = this.mViewData;
            if (!orderConfirmViewData5.hasAvailablePayType) {
                if (payButtonMsg != null && !TextUtils.isEmpty(payButtonMsg.getNew_card())) {
                    str = payButtonMsg.getNew_card();
                } else if (payButtonMsg == null || TextUtils.isEmpty(payButtonMsg.getDefault_msg())) {
                    str = ResUtils.getString(this.mActivity, "ebpay_use_newcard_topay");
                } else {
                    str = payButtonMsg.getDefault_msg();
                }
                orderConfirmViewData5.confirmBtnMsg = str;
            } else if (payPrice.payType == PayRequest.PayPrice.PayType.BANKCARD && (bondCard = this.mPayRequest.mBondCard) != null && !bondCard.isCompled()) {
                this.mViewData.confirmBtnMsg = (payButtonMsg == null || TextUtils.isEmpty(payButtonMsg.getDefault_msg())) ? ResUtils.getString(this.mActivity, "wallet_confirm_order_title") : payButtonMsg.getDefault_msg();
            } else if (PayDataCache.getInstance().isPassFree()) {
                this.mPayRequest.setPayWay(1);
                OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData6 = this.mViewData;
                if (payButtonMsg != null && !TextUtils.isEmpty(payButtonMsg.getNopass())) {
                    str4 = misc.getPayButtonMsg().getNopass();
                } else if (payButtonMsg == null || TextUtils.isEmpty(payButtonMsg.getDefault_msg())) {
                    str4 = ResUtils.getString(this.mActivity, "wallet_confirm_order_title");
                } else {
                    str4 = payButtonMsg.getDefault_msg();
                }
                orderConfirmViewData6.confirmBtnMsg = str4;
            } else {
                PayRequest payRequest3 = this.mPayRequest;
                if (payRequest3.supportFingerprintPay) {
                    OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData7 = this.mViewData;
                    if (payRequest3.getPayWay() == 2) {
                        z2 = true;
                    }
                    orderConfirmViewData7.isFingerprintPay = z2;
                    OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData8 = this.mViewData;
                    if (!orderConfirmViewData8.isFingerprintPay || orderConfirmViewData8.isOTP) {
                        OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData9 = this.mViewData;
                        if (payButtonMsg == null || TextUtils.isEmpty(payButtonMsg.getDefault_msg())) {
                            str3 = ResUtils.getString(this.mActivity, "wallet_confirm_order_title");
                        } else {
                            str3 = payButtonMsg.getDefault_msg();
                        }
                        orderConfirmViewData9.confirmBtnMsg = str3;
                    } else {
                        orderConfirmViewData8.confirmBtnMsg = ResUtils.getString(this.mActivity, "bd_wallet_fingerprint_pay");
                    }
                } else {
                    OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData10 = this.mViewData;
                    if (payButtonMsg == null || TextUtils.isEmpty(payButtonMsg.getDefault_msg())) {
                        str2 = ResUtils.getString(this.mActivity, "wallet_confirm_order_title");
                    } else {
                        str2 = payButtonMsg.getDefault_msg();
                    }
                    orderConfirmViewData10.confirmBtnMsg = str2;
                    this.mViewData.isFingerprintPay = false;
                }
            }
            if (misc != null) {
                this.mViewData.title_url = misc.title_url;
            }
            StatisticManager.onEventWithValue("defaultVerType", this.mViewData.confirmBtnMsg);
            this.mActivity.reFreshUI(this.mViewData);
        }
    }

    public void gotoPayUsePwd(boolean z, String str) {
        if (z) {
            this.mPayRequest.supportFingerprintPay = false;
            StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_CHECK_FINGERPRINT_DURATION, (Map<String, Object>) null, new String[0]);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("pay_from", StatHelper.getPayFrom());
        ArrayList arrayList = new ArrayList();
        arrayList.add(StatHelper.getOrderNo());
        hashMap.put(StatHelper.PAY_WAY, "0");
        StatisticManager.onEventWithValues(PayStatServiceEvent.CHANGE_PAY_WAY, (Collection<String>) arrayList, (Map<String, Object>) hashMap);
        this.mPayRequest.setPayWay(3);
        this.mActivity.gotoNext((String) null, str);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                OrderConfirmPresenter.this.getViewData();
            }
        }, 800);
    }

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.mViewData = (OrderConfirmContract.Presenter.OrderConfirmViewData) bundle.get("viewdata");
        }
    }

    public void onDestroy() {
        EventBus.getInstance().removeAllStickyEvents();
        EventBus.getInstance().unregister((Object) this, "order_confirm_event_bus_key");
    }

    public void onFpCheckError() {
        this.mActivity.showFpCheckError();
    }

    public void onFpCheckSucces(String str) {
        this.mActivity.showFpCheckSuccess(str);
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event != null && "order_confirm_event_bus_key".equals(event.mEventKey)) {
            Object obj = event.mEventObj;
            if (obj != null && (obj instanceof PayRequest)) {
                this.mPayRequest = (PayRequest) obj;
            }
            getViewData();
            EventBus.getInstance().removeStickyEvent("order_confirm_event_bus_key");
        }
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("viewdata", this.mViewData);
    }

    public void quitCashDesk() {
        PayCallBackManager.callBackClientCancel(this.mActivity, "OrderConfirmPresenter.quitCashDesk().1");
    }

    public void startFingerprintListening() {
        IFingerprintPay iFingerprintPay;
        CardData.BondCard bondCard;
        if (this.mViewData != null) {
            if (this.mPayRequest.getPayWay() != 2 || (((bondCard = this.mPayRequest.mBondCard) == null || !bondCard.isCompled()) && (this.mPayRequest.getPayPrice() == null || this.mPayRequest.getPayPrice().payType != PayRequest.PayPrice.PayType.BALANCE))) {
                this.mPayRequest.setPayWay(3);
                this.mViewData.isFingerprintPay = false;
            } else {
                this.mPayRequest.setPayWay(2);
                this.mViewData.isFingerprintPay = true;
            }
        }
        this.mActivity.reFreshUI(this.mViewData);
        if (this.mPayRequest.getPayWay() == 2 && (iFingerprintPay = this.mPayRequest.mFingerprintPay) != null && (iFingerprintPay instanceof SysFingerprintPay) && Build.VERSION.SDK_INT >= 23) {
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_CHECK_FINGERPRINT_DURATION);
            WalletFingerprint.getInstance(this.mActivity).startListening(new b() {
                public void a(int i2, String str) {
                    StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_CHECK_FINGERPRINT_DURATION, (Map<String, Object>) null, new String[0]);
                    if (i2 == 0) {
                        StatHelper.cacheCodeAndMsg(i2 + "", StatHelper.SENSOR_OK);
                    } else {
                        StatHelper.cacheCodeAndMsg(i2 + "", str);
                    }
                    if (i2 == 0) {
                        OrderConfirmPresenter.this.onFpCheckSucces(str);
                    } else if (i2 == -5) {
                        OrderConfirmPresenter.this.onFpCheckError();
                    } else if (i2 == -3) {
                        OrderConfirmPresenter.this.gotoPayUsePwd(true, str);
                    } else if (i2 == -1) {
                        OrderConfirmPresenter.this.changePwdMode();
                    } else if (i2 == -4 || i2 == -6) {
                        OrderConfirmPresenter.this.gotoPayUsePwd(true, str);
                    } else if (i2 == -7) {
                        OrderConfirmPresenter.this.gotoPayUsePwd(true, str);
                    } else if (i2 == -2) {
                        OrderConfirmPresenter.this.gotoPayUsePwd(true, "");
                    } else if (i2 == -8) {
                        WalletFingerprint.getInstance(OrderConfirmPresenter.this.mActivity).cancleListening();
                    }
                }
            });
        }
    }
}
