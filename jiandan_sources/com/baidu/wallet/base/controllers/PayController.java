package com.baidu.wallet.base.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.b.i;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.BindCardResponse;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.fingerprint.FpConstancts;
import com.baidu.wallet.paysdk.fingerprint.ui.FingerprintOpenGuideActivity;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult;
import com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity;
import com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeManager;
import com.baidu.wallet.paysdk.presenter.PreCashierPayTypePresenter;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BindCardBaseActivity;
import com.baidu.wallet.paysdk.ui.BindCardImplActivity;
import com.baidu.wallet.paysdk.ui.CouponListActivity;
import com.baidu.wallet.paysdk.ui.OrderConfirmActivity;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import com.baidu.wallet.paysdk.ui.SelectBindCardActivity;
import com.baidu.wallet.paysdk.ui.WithholdPayActivity;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class PayController {
    public static final int KEY_CHECK_PWD_COMPLETE_CARD = 0;
    public static final int KEY_CHECK_PWD_PAY = 1;
    public static final String PAY_BIND_CARD_ENTER_HASH_ID = "paySDKPayBindCardEnter";
    public static final String PAY_BIND_CARD_ENTER_HASH_NAME = "支付中绑卡入口";
    public static final int SELECT_PAY_WAY_FROM_PWDPAY_ACT = 101;
    public static final int SELECT_PAY_WAY_FROM_SMS_ACT = 102;
    public static final int SELECT_PAY_WAY_FROM_WELCOME_ACT = 100;
    public a a;
    public IModifyPayTypeCallback b;
    public PayCallBack c;
    public Context d;

    public static final class PayResultWrapper implements Serializable {
        public int payResult;
        public PayResultContent payResultContent;
        public int payResultType;

        public PayResultWrapper(int i2, int i3, PayResultContent payResultContent2) {
            this.payResult = i2;
            this.payResultType = i3;
            this.payResultContent = payResultContent2;
        }
    }

    public interface a {
        void a();
    }

    public static class b {
        public static PayController a = new PayController();
    }

    private void a(Context context, Bundle bundle, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    private void b(BaseActivity baseActivity, int i2, int i3, PayResultContent payResultContent) {
        H5ResultParams h5ResultParams;
        if (payResultContent != null) {
            payResultContent.isPaySuccess = i2 == 0;
        }
        PayDataCache.getInstance().setPayReslutContent(payResultContent);
        if (payResultContent == null || !payResultContent.isPaySuccess || (h5ResultParams = PayDataCache.getInstance().getH5ResultParams()) == null || !h5ResultParams.toShowH5ResultPage()) {
            Bundle bundle = new Bundle();
            bundle.putInt(DxmPayBeanConstants.KEY_PAY_RESULT_TYPE, i3);
            baseActivity.startActivityWithExtras(bundle, WalletPayResultCommonActivity.class);
            PayBaseBeanActivity.exitEbpay();
            return;
        }
        CashierDeskPayResult cashierDeskPayResult = new CashierDeskPayResult(baseActivity.getActivity(), h5ResultParams);
        cashierDeskPayResult.beforeShow();
        cashierDeskPayResult.show();
    }

    public static PayController getInstance() {
        return b.a;
    }

    public static BigDecimal priceToBigDecimal(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return new BigDecimal(str).multiply(BigDecimal.valueOf(0.01d)).setScale(2);
    }

    public void bindCardPay(Context context, Intent intent, boolean z) {
        StatHelper.cachePayType(0);
        StatHelper.cachePayWay(4);
        StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_ENTER, PAY_BIND_CARD_ENTER_HASH_NAME, PAY_BIND_CARD_ENTER_HASH_ID, "进入", new String[0]);
        StatisticManager.onEventStart(PayStatServiceEvent.PAY_BIND_CARD_DURATION);
        Bundle extras = intent != null ? intent.getExtras() : new Bundle();
        if (extras == null) {
            extras = new Bundle();
        }
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        if (payRequest != null) {
            payRequest.setPayWay(3);
            PayRequest.PayPrice payPrice = payRequest.getPayPrice();
            if (payPrice != null) {
                payPrice.payType = PayRequest.PayPrice.PayType.BANKCARD;
            }
        }
        extras.putBoolean(BindFastRequest.BIND_IS_FIRST, z);
        BindFastRequest bindFastRequest = new BindFastRequest();
        bindFastRequest.mBindFrom = 0;
        PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
        a(context, extras, (Class<?>) BindCardImplActivity.class);
        if (z && (context instanceof BaseActivity)) {
            ((BaseActivity) context).finishWithoutAnim();
        }
    }

    public void bindExtSuccess(BaseActivity baseActivity, Object obj) {
        List<String> collectData = StatHelper.collectData(StatHelper.getSessionId(), new String[0]);
        HashMap hashMap = new HashMap();
        hashMap.put(StatHelper.BANK_CODE, StatHelper.getBankCode());
        hashMap.put(StatHelper.CARD_TYPE, StatHelper.getCardType());
        hashMap.put(StatHelper.BIND_CARD_USER_TYPE, StatHelper.getBindCardUserType());
        StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_SUCCESS, (Collection<String>) collectData, (Map<String, Object>) hashMap);
        BindCardResponse bindCardResponse = (BindCardResponse) obj;
        PayResultContent payResultContent = new PayResultContent();
        payResultContent.notify = bindCardResponse.notify;
        payResultContent.cash_amount = "";
        payResultContent.total_amount = "";
        payResultContent.pay_detail_info = bindCardResponse.activity_desc;
        payResultContent.isPaySuccess = true;
        WalletGlobalUtils.safeDismissDialog(baseActivity, 0);
        PayBaseBeanActivity.exitActiveBindCard();
        PayDataCache.getInstance().setPayReslutContent(payResultContent);
        paySucess(baseActivity, payResultContent, 1);
    }

    public void bindFail(Context context, String str) {
        BaiduPay.IBindCardCallback bindCallback = BaiduPay.getInstance().getBindCallback();
        BindBack bindCallbackExt = BaiduPay.getInstance().getBindCallbackExt();
        if (bindCallback != null) {
            bindCallback.onChangeFailed(str);
        } else if (bindCallbackExt != null) {
            StatisticManager.onEvent("#onPayResult");
            bindCallbackExt.onBindResult(2, new PayCallBackManager.PayStateModle(2, "").toString());
            PayRequestCache.getInstance().clearPaySdkRequestCache();
        }
        BaiduPay.getInstance().clearBindCallback();
        BaiduPay.getInstance().clearBindCallbackExt();
    }

    public void bindSuccess(Object obj) {
        List<String> collectData = StatHelper.collectData(StatHelper.getSessionId(), new String[0]);
        HashMap hashMap = new HashMap();
        hashMap.put(StatHelper.BANK_CODE, StatHelper.getBankCode());
        hashMap.put(StatHelper.CARD_TYPE, StatHelper.getCardType());
        hashMap.put(StatHelper.BIND_CARD_USER_TYPE, StatHelper.getBindCardUserType());
        StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_SUCCESS, (Collection<String>) collectData, (Map<String, Object>) hashMap);
        BaiduPay.IBindCardCallback bindCallback = BaiduPay.getInstance().getBindCallback();
        BindCardResponse bindCardResponse = (BindCardResponse) obj;
        if (bindCallback != null) {
            bindCallback.onChangeSucceed((bindCardResponse == null || TextUtils.isEmpty(bindCardResponse.card_no)) ? null : bindCardResponse.card_no);
        }
        BaiduPay.getInstance().clearBindCallback();
        PayBaseBeanActivity.exitActiveBindCard();
    }

    public void clearPreModifiedCallBack() {
        if (this.b != null) {
            this.b = null;
        }
    }

    public void completeCardPay(Context context, CardData.BondCard bondCard) {
        BindFastRequest bindFastRequest = new BindFastRequest();
        bindFastRequest.mBindFrom = 2;
        bindFastRequest.mBondCard = bondCard;
        Class<BindCardImplActivity> cls = BindCardImplActivity.class;
        PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
        Intent intent = new Intent(context, BindCardImplActivity.class);
        int a2 = i.a().a(context, bondCard, false);
        if (a2 > 0 && 2 >= a2) {
            intent.putExtra("halfScreen", a2);
        }
        intent.putExtra("reasonForChangeCardItem", 1);
        context.startActivity(intent);
    }

    public a getIConfirmPayCallback() {
        return this.a;
    }

    public IModifyPayTypeCallback getModifyPayTypeCallback() {
        return this.b;
    }

    public void gotoDiscountPage(BaseActivity baseActivity) {
        Intent intent = new Intent();
        intent.setClass(baseActivity, CouponListActivity.class);
        baseActivity.startActivity(intent);
    }

    public void gotoOrderConfirm(BaseActivity baseActivity, Intent intent) {
        a(baseActivity, intent != null ? intent.getExtras() : new Bundle(), (Class<?>) OrderConfirmActivity.class);
        baseActivity.finishWithoutAnim();
    }

    public void gotoPayTypePage(Context context, boolean z) {
        StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_OTHER_PAY_TYPE);
        Intent intent = new Intent();
        intent.putExtra("isGatewaySignPay", z);
        intent.setClass(context, PayTypeActivity.class);
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void gotoPwdPay(BaseActivity baseActivity) {
        Intent intent = new Intent(baseActivity, PwdPayActivity.class);
        if (PayDataCache.getInstance().hasBondCards() || com.baidu.wallet.paysdk.c.a.a().b()) {
            StatHelper.cachePayWay(0);
            intent.putExtra("IS_FOR_BIND_CARD_PAY", false);
        } else {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            if (payRequest != null) {
                payRequest.setPayWay(3);
                PayRequest.PayPrice payPrice = payRequest.getPayPrice();
                if (payPrice != null) {
                    payPrice.payType = PayRequest.PayPrice.PayType.BANKCARD;
                }
            }
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            intent.putExtra("IS_FOR_BIND_CARD_PAY", true);
        }
        baseActivity.startActivity(intent);
    }

    public void gotoWithholdPay(BaseActivity baseActivity) {
        baseActivity.startActivity(new Intent(baseActivity, WithholdPayActivity.class));
    }

    public void modifyPayType(Context context, PrecashierModifyPayTypeManager.TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> twoTupleForPrecashier) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setClass(context, PayTypeActivity.class);
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(268435456);
            }
            intent.putExtra(PreCashierPayTypePresenter.DEFAULT_PAY_DATA, twoTupleForPrecashier);
            context.startActivity(intent);
        }
    }

    public void onConfirmPay() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a();
            this.a = null;
        }
    }

    public void onPreModifiedPayType(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
        IModifyPayTypeCallback iModifyPayTypeCallback = this.b;
        if (iModifyPayTypeCallback != null) {
            iModifyPayTypeCallback.onPayTypeModified(precashierModifyPayTypeDefaultData);
            this.b = null;
        }
    }

    public void onPrePayMethodSetted() {
        IModifyPayTypeCallback iModifyPayTypeCallback = this.b;
        if (iModifyPayTypeCallback != null) {
            iModifyPayTypeCallback.onPayTypeSetted();
            this.b = null;
        }
    }

    public void payPaying(BaseActivity baseActivity, PayResultContent payResultContent, int i2) {
        WalletGlobalUtils.safeDismissDialog(baseActivity, 0);
        a(baseActivity, 1, i2, payResultContent);
    }

    public void paySucess(BaseActivity baseActivity, PayResultContent payResultContent, int i2) {
        a(baseActivity, 0, i2, payResultContent);
    }

    public void selectCompletCards(Context context, Intent intent) {
        if (context != null && intent != null) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putBoolean(BindFastRequest.BIND_IS_FIRST, true);
            BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
            if (bindFastRequest == null) {
                bindFastRequest = new BindFastRequest();
            }
            bindFastRequest.mBindFrom = 2;
            PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
            a(context, extras, (Class<?>) SelectBindCardActivity.class);
            if (context instanceof BaseActivity) {
                ((BaseActivity) context).finishWithoutAnim();
            }
        }
    }

    public void setMiniPayCallback(PayCallBack payCallBack, Context context) {
        this.c = payCallBack;
        this.d = context;
    }

    public void setModifyPayTypeCallback(IModifyPayTypeCallback iModifyPayTypeCallback) {
        this.b = iModifyPayTypeCallback;
    }

    public void updateCardInfoPay(Context context, ErrorContentResponse errorContentResponse) {
        BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        if (bindFastRequest == null) {
            bindFastRequest = new BindFastRequest();
            bindFastRequest.mBindFrom = 2;
            PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
        } else if (bindFastRequest.mBindFrom == 8) {
            bindFastRequest.mBindFrom = 7;
        }
        bindFastRequest.mBondCard = payRequest.mBondCard;
        bindFastRequest.mCardInfoUpdateContent = errorContentResponse;
        if (context instanceof BindCardBaseActivity) {
            ((BindCardBaseActivity) context).loadCvv2();
            return;
        }
        Intent intent = new Intent(context, BindCardImplActivity.class);
        int a2 = i.a().a(context, errorContentResponse);
        if (a2 > 0 && 2 >= a2) {
            intent.putExtra("halfScreen", a2);
        }
        intent.putExtra("reasonForChangeCardItem", 2);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).finish();
        }
        context.startActivity(intent);
    }

    public PayController() {
        this.c = null;
        this.d = null;
    }

    private void a(BaseActivity baseActivity, Bundle bundle, Class<?> cls) {
        Intent intent = new Intent(baseActivity, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        baseActivity.startActivityWithoutAnim(intent);
    }

    private void a(BaseActivity baseActivity, int i2, int i3, PayResultContent payResultContent) {
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        boolean z = false;
        if ((payResultContent == null || !"0".equalsIgnoreCase(payResultContent.redirect_sp_succpage_remain_time)) && payRequest != null && payRequest.FP_Guide_Strategy > 0 && !payRequest.supportFingerprintPay) {
            z = true;
        }
        if (z) {
            int intValue = ((Integer) SharedPreferencesUtils.getParam(baseActivity, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, "resultPageShowFpCounts", 3)).intValue();
            if (intValue <= 0) {
                b(baseActivity, i2, i3, payResultContent);
                return;
            }
            SharedPreferencesUtils.setParam(baseActivity, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, "resultPageShowFpCounts", Integer.valueOf(intValue - 1));
            Intent intent = new Intent(baseActivity, FingerprintOpenGuideActivity.class);
            intent.putExtra("payresultwrapper", new PayResultWrapper(i2, i3, payResultContent));
            baseActivity.startActivity(intent);
            return;
        }
        b(baseActivity, i2, i3, payResultContent);
    }

    public void completeCardPay(Context context, CardData.BondCard bondCard, GetCardInfoResponse getCardInfoResponse) {
        BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
        if (bindFastRequest == null) {
            bindFastRequest = new BindFastRequest();
        }
        bindFastRequest.mBondCard = bondCard;
        bindFastRequest.setBindFromOrigin(bindFastRequest.mBindFrom);
        bindFastRequest.mBindFrom = 9;
        bindFastRequest.setmBankInfo(getCardInfoResponse);
        PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
        Intent intent = new Intent(context, BindCardImplActivity.class);
        intent.putExtra("reasonForChangeCardItem", 1);
        context.startActivity(intent);
    }
}
