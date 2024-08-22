package com.baidu.wallet.paysdk.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.widget.OrderConfirmation;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.api.BindCardEntry;
import com.baidu.wallet.paysdk.b.i;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.d;
import com.baidu.wallet.paysdk.beans.k;
import com.baidu.wallet.paysdk.datamodel.Bank;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.FindPwdCardCheckResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.baidu.wallet.paysdk.ui.widget.SelectBindCardLayout;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.statusbar.ImmersiveStatusBarManager;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.beans.BeanRequestBase;
import com.dxmpay.wallet.core.utils.NFCUtil;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;

public class SelectBindCardActivity extends PayBaseBeanActivity implements SelectBindCardLayout.b {
    public final String a = ("SelectBindCardActivity" + hashCode());
    public SelectBindCardLayout b;
    public TextView c;
    public OrderConfirmation d;
    public CardData.BondCard[] e;
    public boolean f = false;
    public BindFastRequest g;
    public PayRequest h;

    /* renamed from: i  reason: collision with root package name */
    public int f3620i;
    public SelectBindCardLayout.BindCardItemView j;
    public Boolean k = Boolean.FALSE;
    public View l;

    private void a() {
    }

    private void b() {
        String str;
        PayRequest payRequest = this.h;
        if (payRequest != null) {
            String needToPayAmount = payRequest.getNeedToPayAmount();
            String orderPrice = this.h.getOrderPrice();
            String discountAmount = this.h.getDiscountAmount();
            boolean z = !TextUtils.isEmpty(StringUtils.fen2Yuan(discountAmount)) && !StringUtils.fen2Yuan(discountAmount).equals("0.00");
            SpannableString spannableString = new SpannableString(ResUtils.getString(getActivity(), "dxm_wallet_base_unit") + StringUtils.fen2Yuan(orderPrice));
            if (z) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
            String str2 = "-" + ResUtils.getString(getActivity(), "dxm_wallet_base_unit") + StringUtils.fen2Yuan(discountAmount);
            if (this.h.showCouponListEntry()) {
                this.d.setDiscountInfoVisiable(true);
                this.d.setCouponInfo(this.h.getDiscountMsg(), str2, new View.OnClickListener() {
                    public void onClick(View view) {
                        PayController.getInstance().gotoDiscountPage(SelectBindCardActivity.this);
                    }
                });
            } else if (!TextUtils.isEmpty(this.h.getRandomDiscountMsg())) {
                this.d.setDiscountInfoVisiable(true);
                this.d.setCouponInfo(this.h.getRandomDiscountMsg(), "", (View.OnClickListener) null);
            } else {
                this.d.setDiscountInfoVisiable(false);
            }
            this.d.setOrderPrice(StringUtils.fen2Yuan(needToPayAmount), spannableString);
            this.d.setOrderInfo(this.h.getGoodsName());
            this.d.setTitle(this.h.title_url);
            this.d.setSpNameValue(PayDataCache.getInstance().getSpName());
            if (PayDataCache.getInstance().isRemotePay()) {
                if (!TextUtils.isEmpty(WalletLoginHelper.getInstance().getPassUserName())) {
                    str = WalletLoginHelper.getInstance().getPassUserName();
                } else {
                    str = PayDataCache.getInstance().getPayResponse().getDisplayName();
                }
                this.d.setAccountInfo(str, (View.OnClickListener) null);
            }
        }
    }

    private void c() {
        boolean z;
        if (d()) {
            this.e = new CardData.BondCard[0];
            WalletGlobalUtils.safeShowDialog(this, -1, "");
            e();
            z = true;
        } else {
            this.e = PayDataCache.getInstance().getBondCards();
            z = PayDataCache.getInstance().enableAddBondCards();
        }
        this.b.setAdaptetr(this.e, z);
        this.b.setBindCardItemClickListener(this);
    }

    private boolean d() {
        int i2 = this.g.mBindFrom;
        return i2 == 4 || i2 == 5;
    }

    private void e() {
        k kVar = (k) PayBeanFactory.getInstance().getBean((Context) getActivity(), (int) PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_GET_CARD_LIST, this.a);
        kVar.setResponseCallback(this);
        kVar.execBean();
    }

    private void f() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        BindFastRequest bindFastRequest = this.g;
        if (bindFastRequest != null && bindFastRequest.mBondCard != null) {
            this.j.setProgressBarVisible(false);
            CardData.BondCard bondCard = this.g.mBondCard;
            if (bondCard != null) {
                extras.putSerializable(BindFastRequest.HAS_BINDED_CARD, bondCard);
                extras.putBoolean(BindFastRequest.BIND_IS_FIRST, false);
                int a2 = i.a().a(this.mAct, bondCard, false);
                if (a2 > 0 && 2 >= a2) {
                    extras.putInt("halfScreen", a2);
                }
                extras.putInt("reasonForChangeCardItem", 1);
                startActivityWithExtras(extras, BindCardImplActivity.class);
            }
        }
    }

    private void g() {
        BindFastRequest bindFastRequest;
        final Bundle extras = getIntent().getExtras();
        if (this.h != null && !d()) {
            this.h.mBondCard = null;
        }
        BindFastRequest bindFastRequest2 = this.g;
        int i2 = bindFastRequest2.mBindFrom;
        if (i2 == 2) {
            bindFastRequest2.mBindFrom = 0;
        } else if (i2 == 5) {
            bindFastRequest2.mBindFrom = 3;
        } else if (i2 == 4) {
            bindFastRequest2.mBindFrom = 3;
        }
        int i3 = this.g.mBindFrom;
        if ((i3 == 3 || i3 == 4) && (bindFastRequest = this.g) != null) {
            bindFastRequest.mUseNewCardFindPwd = true;
        }
        PayRequestCache.BindCategory h2 = h();
        if (PayRequestCache.BindCategory.Other == h2) {
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_ENTER, PayController.PAY_BIND_CARD_ENTER_HASH_NAME, PayController.PAY_BIND_CARD_ENTER_HASH_ID, "进入", new String[0]);
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_BIND_CARD_DURATION);
            getBindCardFlagDelegate().a(this.g);
            PayRequestCache.getInstance().addBeanRequestToCache(this.g.getRequestId(), this.g);
            this.g.mBondCard = null;
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putBoolean(BindFastRequest.BIND_IS_FIRST, false);
            startActivityWithExtras(extras, BindCardImplActivity.class);
            return;
        }
        BaiduPay.getInstance().bindCardOnCardaddReturn(this, new BindCardEntry.OnReturn() {
            public void onFailed(int i2, String str) {
            }

            public void onResponse(CardAddResponse cardAddResponse) {
                SelectBindCardActivity.this.getBindCardFlagDelegate().a(SelectBindCardActivity.this.g);
                PayRequestCache.getInstance().addBeanRequestToCache(SelectBindCardActivity.this.g.getRequestId(), SelectBindCardActivity.this.g);
                SelectBindCardActivity.this.g.mBondCard = null;
                Bundle bundle = extras;
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBoolean(BindFastRequest.BIND_IS_FIRST, false);
                Intent intent = SelectBindCardActivity.this.getIntent();
                if (intent != null && intent.hasExtra("baidu.wallet.from")) {
                    bundle.putString("baidu.wallet.from", intent.getStringExtra("baidu.wallet.from"));
                }
                Activity loadingUi = BindCardEntry.getLoadingUi();
                if (loadingUi instanceof BaseActivity) {
                    ((BaseActivity) loadingUi).startActivityWithExtras(bundle, BindCardImplActivity.class);
                } else {
                    SelectBindCardActivity.this.startActivityWithExtras(bundle, BindCardImplActivity.class);
                }
            }
        }, h2, this.k.booleanValue() ? PayRequestCache.BindCategory.Pwd.getScenario() : this.f3620i, (String) null, (String) null);
    }

    private PayRequestCache.BindCategory h() {
        if (PayRequestCache.getInstance().isPaying()) {
            return PayRequestCache.BindCategory.Other;
        }
        if (this.k.booleanValue()) {
            return PayRequestCache.BindCategory.Pwd;
        }
        int i2 = this.f3620i;
        if (1 == i2) {
            return PayRequestCache.BindCategory.Initiative;
        }
        if (4 == i2) {
            return PayRequestCache.BindCategory.Pwd;
        }
        if (5 != i2 || PayRequestCache.getInstance().isPaying()) {
            return PayRequestCache.BindCategory.Other;
        }
        return PayRequestCache.BindCategory.Initiative;
    }

    public void addNewCardClick() {
        g();
    }

    public void enableCardClick(SelectBindCardLayout.BindCardItemView bindCardItemView, CardData.BondCard bondCard) {
        if (!CheckUtils.isFastDoubleClick()) {
            this.j = bindCardItemView;
            a(bondCard);
        }
    }

    public void handleFailure(int i2, int i3, String str) {
        if (i2 == 526) {
            WalletGlobalUtils.safeDismissDialog(this, -1);
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_find_pwd_get_cardlist_failed"));
            finish();
            return;
        }
        super.handleFailure(i2, i3, str);
    }

    public void handleResponse(int i2, Object obj, String str) {
        if (i2 == 526) {
            WalletGlobalUtils.safeDismissDialog(this, -1);
            FindPwdCardCheckResponse findPwdCardCheckResponse = (FindPwdCardCheckResponse) obj;
            if (findPwdCardCheckResponse != null) {
                this.e = findPwdCardCheckResponse.getBondCards();
            }
            CardData.BondCard[] bondCardArr = this.e;
            if (bondCardArr == null || bondCardArr.length == 0) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_find_pwd_get_cardlist_failed"));
                finish();
                return;
            }
            this.b.setAdaptetr(bondCardArr, PayDataCache.getInstance().enableAddBondCards());
            this.b.setBindCardItemClickListener(this);
        } else if (i2 == 16) {
            CalcPaymentResponse calcPaymentResponse = null;
            if (obj instanceof CalcPaymentResponse) {
                calcPaymentResponse = (CalcPaymentResponse) obj;
            }
            this.h.setCalcPayment(calcPaymentResponse);
            if (calcPaymentResponse != null) {
                this.h.calcPayPriceByRemote(calcPaymentResponse);
            }
            f();
        }
    }

    public void onBackPressed() {
        PasswordController.getPassWordInstance().setPassByUserFail("");
        PasswordController.getPassWordInstance().forgetPasswdFailed();
        if (this.f) {
            WalletGlobalUtils.safeShowDialog(this, 4, "");
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setFlagPaySdk();
        if (bundle == null) {
            this.f = getIntent().getBooleanExtra(BindFastRequest.BIND_IS_FIRST, false);
            this.g = (BindFastRequest) PayRequestCache.getInstance().getRequest(PayRequestCache.getInstance().getBindCategoryByIntent(getIntent()));
            this.k = Boolean.valueOf(PayRequestCache.BindCategory.Pwd.name().equals(getIntent().getStringExtra("baidu.wallet.from")));
            BeanRequestBase beanRequestFromCache = PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            if (beanRequestFromCache != null && (beanRequestFromCache instanceof PayRequest)) {
                this.h = (PayRequest) beanRequestFromCache;
            }
            if (PayDataCache.getInstance().getPayResponse() == null || !PayDataCache.getInstance().getPayResponse().checkResponseValidity()) {
                finish();
                return;
            }
            PayDataCache.getInstance().getPayResponse().storeResponse(this);
        } else {
            this.f = bundle.getBoolean("isFrist", false);
            this.k = Boolean.valueOf(bundle.getBoolean("isForPwd", false));
            Serializable serializable = bundle.getSerializable("mBindRequest");
            if (serializable != null && (serializable instanceof BindFastRequest)) {
                this.g = (BindFastRequest) serializable;
            }
            Serializable serializable2 = bundle.getSerializable("mPayRequest");
            if (serializable2 != null && (serializable2 instanceof PayRequest)) {
                this.h = (PayRequest) serializable2;
            }
            Serializable serializable3 = bundle.getSerializable("DirectPayContentResponse");
            if (serializable3 != null && (serializable3 instanceof DirectPayContentResponse)) {
                ((DirectPayContentResponse) serializable3).storeResponse(getActivity());
            }
        }
        BindFastRequest bindFastRequest = this.g;
        if (bindFastRequest == null || (bindFastRequest.isRealPay() && this.h == null)) {
            finish();
            return;
        }
        PayRequestCache.getInstance().addBeanRequestToCache(this.g.getRequestId(), this.g);
        if (this.h != null) {
            PayRequestCache.getInstance().addBeanRequestToCache(this.h.getRequestId(), this.h);
        }
        "bindFrom=" + this.g.mBindFrom + Bank.HOT_BANK_LETTER;
        this.f3620i = this.g.mBindFrom;
        if (PayDataCache.getInstance().hasMobilePwd()) {
            a();
        }
        setContentView(ResUtils.layout(getActivity(), "wallet_cashdesk_bond_card_activity"));
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        this.c = (TextView) findViewById(ResUtils.id(getActivity(), "select_pay_card"));
        this.d = (OrderConfirmation) findViewById(ResUtils.id(getActivity(), "pay_layout"));
        this.l = findViewById(ResUtils.id(getActivity(), "statusbar_top"));
        this.d.getBackButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SelectBindCardActivity.this.onBackPressed();
            }
        });
        int i2 = this.g.mBindFrom;
        if (i2 == 4) {
            String string = ResUtils.getString(getActivity(), "ebpay_complete_tip1");
            initActionBar("ebpay_title_find_pwd");
            this.c.setVisibility(0);
            this.d.setVisibility(8);
            if (!TextUtils.isEmpty(string)) {
                this.c.setText(string);
            }
        } else if (i2 == 5) {
            if (PayDataCache.getInstance().hasEnableCardsForFindPWD()) {
                str = ResUtils.getString(getActivity(), "ebpay_complete_tip4");
            } else if (!PayDataCache.getInstance().enableAddBondCards()) {
                str = ResUtils.getString(getActivity(), "ebpay_complete_tip5");
            } else {
                str = ResUtils.getString(getActivity(), "ebpay_complete_tip6");
            }
            initActionBar("ebpay_title_complete_info");
            this.c.setVisibility(0);
            this.d.setVisibility(8);
            if (!TextUtils.isEmpty(str)) {
                this.c.setText(str);
            }
        } else if (i2 == 2) {
            initActionBar("ebpay_title_complete_info");
            this.c.setVisibility(8);
            if (PayDataCache.getInstance().hasCanAmount()) {
                this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_complete_tip7");
                if (bundle == null) {
                    WalletGlobalUtils.safeShowDialog(this, 3, "");
                }
            }
            this.d.setVisibility(0);
            if (payResponse != null) {
                b();
                findViewById(ResUtils.id(getActivity(), "bdactionbar")).setVisibility(8);
                setTop();
            }
        }
        SelectBindCardLayout selectBindCardLayout = (SelectBindCardLayout) findViewById(ResUtils.id(this, "lv_bond_card_list"));
        this.b = selectBindCardLayout;
        selectBindCardLayout.setBindFrom(this.f3620i);
        c();
        EventBus.getInstance().register((Object) this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
        EventBus.getInstance().registerSticky(this, "order_confirm_event_bus_key", 0, EventBus.ThreadMode.MainThread);
    }

    public Dialog onCreateDialog(int i2) {
        if (i2 == 3) {
            return new PromptDialog(getActivity());
        }
        if (i2 != 4) {
            return super.onCreateDialog(i2);
        }
        return new PromptDialog(getActivity());
    }

    public void onDestroy() {
        BeanManager.getInstance().removeAllBeans(this.a);
        EventBus.getInstance().unregister((Object) this, "ev_bean_execut_err_content");
        EventBus.getInstance().unregister((Object) this, "order_confirm_event_bus_key");
        super.onDestroy();
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event != null && "order_confirm_event_bus_key".equals(event.mEventKey)) {
            b();
            BindFastRequest bindFastRequest = this.g;
            if (bindFastRequest != null && bindFastRequest.mBindFrom == 2) {
                c();
            }
        }
    }

    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
        }
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        if (i2 != 3) {
            super.onPrepareDialog(i2, dialog);
            return;
        }
        PromptDialog promptDialog = (PromptDialog) dialog;
        promptDialog.setCanceledOnTouchOutside(false);
        promptDialog.setMessage((CharSequence) this.mDialogMsg);
        promptDialog.hideNegativeButton();
        promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_confirm"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                WalletGlobalUtils.safeDismissDialog(SelectBindCardActivity.this, 3);
            }
        });
    }

    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
        }
        setFlagPaySdk();
        BindFastRequest bindFastRequest = this.g;
        int i2 = this.f3620i;
        bindFastRequest.mBindFrom = i2;
        bindFastRequest.setBindFromOrigin(i2);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(BindFastRequest.BIND_IS_FIRST, this.f);
        bundle.putBoolean("isForPwd", this.k.booleanValue());
        bundle.putSerializable("mBindRequest", this.g);
        PayRequest payRequest = this.h;
        if (payRequest != null) {
            bundle.putSerializable("mPayRequest", payRequest);
        }
        bundle.putSerializable("DirectPayContentResponse", PayDataCache.getInstance().getPayResponse());
        super.onSaveInstanceState(bundle);
    }

    public void setTop() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(this.mAct) + 10));
            ImmersiveStatusBarManager.setTopBar(this.mAct.getActivity(), this.l, isStatusbarTextColorBlack());
        }
    }

    private void a(CardData.BondCard bondCard) {
        BindFastRequest bindFastRequest;
        final Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        if (bondCard != null) {
            BindFastRequest bindFastRequest2 = this.g;
            bindFastRequest2.mBondCard = bondCard;
            bindFastRequest2.setmBankInfo((GetCardInfoResponse) null);
            int i2 = this.g.mBindFrom;
            if (i2 == 2) {
                b(bondCard);
            } else if (i2 == 4 || i2 == 5) {
                this.g.setmBankCard(bondCard.account_no);
                this.g.setSubBankCode(bondCard.account_bank_code);
                this.g.mBindFrom = 3;
                extras.putBoolean(BindFastRequest.BIND_IS_FIRST, false);
                if (PayRequestCache.getInstance().isPaying()) {
                    BaiduPay.getInstance().launchBindCardActivity(this, (BaiduPay.IBindCardCallback) null, extras);
                } else {
                    BaiduPay.getInstance().bindCardOnCardaddReturn(this, new BindCardEntry.OnReturn() {
                        public void onFailed(int i2, String str) {
                        }

                        public void onResponse(CardAddResponse cardAddResponse) {
                            SelectBindCardActivity.this.getBindCardFlagDelegate().a(SelectBindCardActivity.this.g);
                            PayRequestCache.getInstance().addBeanRequestToCache(SelectBindCardActivity.this.g.getRequestId(), SelectBindCardActivity.this.g);
                            Activity loadingUi = BindCardEntry.getLoadingUi();
                            if (loadingUi instanceof BaseActivity) {
                                ((BaseActivity) loadingUi).startActivityWithExtras(extras, BindCardImplActivity.class);
                            } else {
                                SelectBindCardActivity.this.startActivityWithExtras(extras, BindCardImplActivity.class);
                            }
                        }
                    }, PayRequestCache.BindCategory.Pwd, this.k.booleanValue() ? PayRequestCache.BindCategory.Pwd.getScenario() : this.f3620i, (String) null, (String) null);
                }
            }
            int i3 = this.g.mBindFrom;
            if ((i3 == 3 || i3 == 4) && (bindFastRequest = this.g) != null) {
                bindFastRequest.mUseNewCardFindPwd = false;
            }
            getBindCardFlagDelegate().a(this.g);
            PayRequestCache.getInstance().addBeanRequestToCache(this.g.getRequestId(), this.g);
        }
    }

    private void b(CardData.BondCard bondCard) {
        PayRequest payRequest = this.h;
        if (payRequest != null) {
            payRequest.mBondCard = bondCard;
        }
        if (!PayDataCache.getInstance().needCalcPayment()) {
            f();
            return;
        }
        SelectBindCardLayout.BindCardItemView bindCardItemView = this.j;
        if (bindCardItemView != null) {
            bindCardItemView.setProgressBarVisible(true);
        }
        d dVar = (d) PayBeanFactory.getInstance().getBean((Context) getActivity(), 16, this.a);
        PayTypeItemView.PayTypeItemViewData payTypeItemViewData = new PayTypeItemView.PayTypeItemViewData();
        payTypeItemViewData.type = PayTypeItemView.ItemViewType.BANKCARD;
        payTypeItemViewData.card = bondCard;
        dVar.a(payTypeItemViewData);
        dVar.setResponseCallback(this);
        dVar.execBean();
    }
}
