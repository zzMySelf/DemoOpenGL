package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.wallet.BaiduPayServiceController;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.banksign.BankSignPayFlow;
import com.baidu.wallet.paysdk.banksign.a.a;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.baidu.wallet.paysdk.banksign.datamodel.GetJumpUrlResponse;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.contract.PayTypeContract;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.presenter.h;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.dialog.DxmNewStandardDialog;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.beans.sm.SMManagerDelegate;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PayTypeActivity extends HalfScreenBaseActivity implements View.OnClickListener {
    public static final String PAY_TYPE_HASH_ID = "paySDKChanagePayTypePage";
    public static final String PAY_TYPE_HASH_NAME = "更换支付方式页面";
    public static final int REQUEST_CODE_FOR_BALANCE_LIMIT_LIGHT_APP = 1;
    public static final String TAG = "PayTypeActivity";
    public PayRequest a;
    public String b = "";
    public boolean c = false;
    public boolean d = false;
    public boolean e;
    public boolean f = false;
    public PayTypeItemView mClickedItemView;
    public ViewGroup mPayTypeContainerView;
    public PayTypeContract.Presenter mPresenter;

    public void addContentView() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_pay_way_list"), (ViewGroup) null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
    }

    public void dismissLoading(int i2) {
        PayTypeItemView payTypeItemView = this.mClickedItemView;
        if (payTypeItemView != null) {
            payTypeItemView.setItemState(false);
        }
    }

    public void gotoOrderConfim() {
        EventBus instance = EventBus.getInstance();
        EventBus instance2 = EventBus.getInstance();
        instance.getClass();
        PayTypeContract.Presenter presenter = this.mPresenter;
        instance2.postStickyEvent(new EventBus.Event("order_confirm_event_bus_key", presenter != null ? presenter.getPayRequest() : null));
        finishWithoutAnim();
    }

    public void gotoPwdPay(boolean z) {
        PayTypeItemView payTypeItemView;
        PayTypeItemView.PayTypeItemViewData payTypeItemViewData;
        CardData.BondCard bondCard;
        this.e = z;
        if (!PayDataCache.getInstance().isFromPreCashier() || (payTypeItemView = this.mClickedItemView) == null || (payTypeItemViewData = payTypeItemView.mData) == null || (bondCard = payTypeItemViewData.card) == null || TextUtils.isEmpty(bondCard.account_no)) {
            jumpPwdPayActivity();
        } else if (this.c) {
            String g = a.a().g(this.mClickedItemView.mData.card.account_no);
            if (!TextUtils.isEmpty(g)) {
                PayDataCache.getInstance().setOrderExtraInfo(g);
            }
            BaiduPayDelegate.getInstance().reOrderPay(this.mAct);
        } else if (this.mClickedItemView.mData.card.is_sign_jump_bank == 1) {
            PayData.DirectPayPay directPayPay = PayDataCache.getInstance().getPayResponse().pay;
            String str = this.mClickedItemView.mData.card.account_no;
            directPayPay.selected_card_no = str;
            a(str);
        } else {
            jumpPwdPayActivity();
        }
    }

    public void handleFailure(int i2, int i3, String str) {
        if (i2 == 768) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            GlobalUtils.toast(this.mAct, str);
        }
        super.handleFailure(i2, i3, str);
    }

    public void handleResponse(int i2, Object obj, String str) {
        if (i2 == 768) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            GetJumpUrlResponse getJumpUrlResponse = (GetJumpUrlResponse) obj;
            if (getJumpUrlResponse.agreement_trans_id != null) {
                a.a().f(getJumpUrlResponse.agreement_trans_id);
            }
            if (getJumpUrlResponse.is_signed == 0) {
                String str2 = getJumpUrlResponse.form_data;
                a.a().a(str2 == null ? null : str2.getBytes());
                if (!this.d) {
                    a.a().a(this);
                } else {
                    a.a().a((PayTypeActivity) null);
                }
                a.a().b(this.d);
                a.a().d(getJumpUrlResponse.form_url);
                a.a().e(getJumpUrlResponse.webview_title);
                BankSignPayFlow a2 = BankSignPayFlow.a();
                a2.a(BankSignPayFlow.Action.ShowGuide);
                a2.a((Context) this.mAct);
            } else if (PayDataCache.getInstance().isFromPreCashier() && !this.d) {
                jumpPwdPayActivity();
            } else if (this.d && !TextUtils.isEmpty(getJumpUrlResponse.signed_msg)) {
                GlobalUtils.toast(this.mAct, getJumpUrlResponse.signed_msg);
            }
        }
    }

    public void initView() {
        this.mHalfScreenContainer.setContentDescription((CharSequence) null);
        this.mHalfScreenContainer.setImportantForAccessibility(2);
        this.mActionBar.setVisibility(0);
        this.mLeftImg.setOnClickListener(this);
        this.mLeftImg.setContentDescription(ResUtils.getString(this, "wallet_access_back"));
        PayRequest payRequest = this.a;
        if (payRequest != null && payRequest.isWithHoldingValidity()) {
            this.mRightTxt.setVisibility(8);
        } else if (b.a()) {
            this.mRightTxt.setVisibility(8);
        } else {
            this.mRightTxt.setVisibility(0);
            this.mRightTxt.setText(ResUtils.getString(this, "ebpay_settings"));
            this.mRightTxt.setOnClickListener(this);
            this.mRightTxt.setContentDescription(ResUtils.getString(this, "wallet_access_set_pay_type"));
        }
        this.mTitle.setVisibility(4);
        TextView textView = (TextView) findViewById(ResUtils.id(this, "bd_wallet_payway_title"));
        this.mTitle = textView;
        textView.setText(ResUtils.getString(this, "ebpay_pwdpay_payment_select"));
        this.mPayTypeContainerView = (ViewGroup) findViewById(ResUtils.id(this, "bd_wallet_payway_container"));
    }

    public void jumpPwdPayActivity() {
        Intent intent = new Intent(this, PwdPayActivity.class);
        intent.putExtra("IS_FOR_BIND_CARD_PAY", this.e);
        startActivity(intent);
    }

    public void jumpUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            a(str, false, 1);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        PayTypeContract.Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.onActivityResult(i2, i3, intent);
        }
    }

    public void onBackPressed() {
        if (this.mHalfScreenContainer.isClickable()) {
            PayTypeContract.Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.onBackPressed();
            }
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        if (view == this.mLeftImg) {
            onBackPressed();
        } else if (view == this.mRightTxt) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_CASHDESK_SETTINGS);
            if (PayRequestCache.getInstance().isPaying()) {
                EventBus.getInstance().register((Object) this, DxmPayBeanConstants.EVENT_PAY_SORT_SETTING, 0, EventBus.ThreadMode.MainThread);
            }
            com.baidu.wallet.paysdk.setting.a.a().a(true);
            BaiduPayServiceController.getInstance().gotoPaySetActivity(this);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        this.c = getIntent().getBooleanExtra("isGatewaySignPay", false);
        initView();
        if (PayDataCache.getInstance().isFromPreCashier()) {
            this.b = "FORM_PRECASHIER";
        } else if (b.a()) {
            this.b = "FROM_AUTHORIZE";
        } else {
            this.b = "";
        }
        PayTypeContract.Presenter a2 = h.a(this.b, this);
        this.mPresenter = a2;
        if (a2 == null) {
            finish();
        } else {
            a2.onCreate(bundle);
        }
    }

    public Dialog onCreateDialog(int i2) {
        if (i2 == 64) {
            return new DxmNewStandardDialog(this);
        }
        return super.onCreateDialog(i2);
    }

    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(TAG);
        EventBus.getInstance().unregister((Object) this, DxmPayBeanConstants.EVENT_PAY_SORT_SETTING);
        PayTypeContract.Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.onDestroy();
            this.mPresenter = null;
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event != null && DxmPayBeanConstants.EVENT_PAY_SORT_SETTING.equals(event.mEventKey) && event.mEventObj != null) {
            try {
                JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                if (jSONObject.has("pay_sort_change") && 1 == jSONObject.getInt("pay_sort_change")) {
                    this.f = true;
                }
            } catch (Exception e2) {
                LogUtil.e(TAG, e2.getMessage(), e2);
            }
        }
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        String str;
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        PayData.CertificateGuideDialog certificateGuideDialog;
        if (i2 == 64) {
            StatHelper.statServiceEvent(PayStatServiceEvent.PAY_SHOW_OPEN_CERTIFICATE_DIALOG);
            DxmNewStandardDialog dxmNewStandardDialog = (DxmNewStandardDialog) dialog;
            final DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            PayData.CertificateGuideDialog certificateGuideDialog2 = null;
            if (!(payResponse == null || (directPayPay = payResponse.pay) == null || (easyPay = directPayPay.easypay) == null || (certificateGuideDialog = easyPay.cfca_guide_dialog) == null)) {
                certificateGuideDialog2 = certificateGuideDialog;
            }
            if (certificateGuideDialog2 != null) {
                if (!TextUtils.isEmpty(certificateGuideDialog2.title)) {
                    dxmNewStandardDialog.setTitleMessage(certificateGuideDialog2.title);
                } else {
                    dxmNewStandardDialog.setTitleMessage(ResUtils.getString(this, "dxm_wallet_open_certificate_dialog_title"));
                }
                if (!TextUtils.isEmpty(certificateGuideDialog2.content)) {
                    dxmNewStandardDialog.setMessage(certificateGuideDialog2.content);
                } else {
                    dxmNewStandardDialog.setMessage(ResUtils.getString(this, "dxm_wallet_open_certificate_dialog_title"));
                }
                if (!TextUtils.isEmpty(certificateGuideDialog2.btn_text)) {
                    str = certificateGuideDialog2.btn_text;
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
                    WalletGlobalUtils.safeDismissDialog(PayTypeActivity.this.mAct, 64);
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
                    sMManagerDelegate.certificateManage(PayTypeActivity.this, jSONObject.toString(), new RouterCallback() {
                        public void onResult(int i2, HashMap hashMap) {
                            if (i2 == 0 && hashMap != null && hashMap.get("result") != null) {
                                try {
                                    JSONObject optJSONObject = new JSONObject(hashMap.get("result").toString()).optJSONObject("cnt");
                                    if (optJSONObject != null && optJSONObject.optInt("errCode", -1) == 0) {
                                        PayTypeActivity.this.gotoPwdPay(true);
                                    }
                                } catch (JSONException e) {
                                    LogUtil.errord(e.getMessage());
                                }
                            }
                        }
                    });
                }
            });
            dxmNewStandardDialog.setCloseBtnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    StatisticManager.onEvent(StatServiceEvent.DXM_CLICK_CLOSE_DIALOG);
                    WalletGlobalUtils.safeDismissDialog(PayTypeActivity.this.mAct, 64);
                }
            });
            return;
        }
        super.onPrepareDialog(i2, dialog);
    }

    public void onResume() {
        super.onResume();
        if (this.f) {
            this.f = false;
            BaiduPayDelegate.getInstance().reOrderPay(this);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        PayTypeContract.Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.onSaveInstanceState(bundle);
        }
        super.onSaveInstanceState(bundle);
    }

    public void setPageClickable(boolean z) {
        this.mHalfScreenContainer.setClickable(z);
    }

    public void showLoading(int i2) {
        this.mClickedItemView.setItemState(true);
    }

    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
    }

    public void reFreshUI(ArrayList<PayTypeItemView.PayTypeItemViewData> arrayList) {
        boolean z;
        CardData.BondCard bondCard;
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        final String str = null;
        this.mClickedItemView = null;
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            if (payResponse == null || (directPayPay = payResponse.pay) == null || (easyPay = directPayPay.easypay) == null || TextUtils.isEmpty(easyPay.bind_card_hd_title)) {
                z = false;
            } else {
                str = payResponse.pay.easypay.bind_card_hd_title;
                z = true;
            }
            Iterator<PayTypeItemView.PayTypeItemViewData> it = arrayList.iterator();
            while (it.hasNext()) {
                final PayTypeItemView.PayTypeItemViewData next = it.next();
                boolean z2 = next.isChecked;
                if (this.mAct != null) {
                    if (!z && next != null && (bondCard = next.card) != null && !TextUtils.isEmpty(bondCard.card_hd_title)) {
                        z = true;
                    }
                    final PayTypeItemView generateItemView = PayTypeItemView.generateItemView(this.mAct, next, new View.OnClickListener() {
                        public void onClick(View view) {
                            PayTypeActivity.this.jumpUrl(next.jump_url);
                            StatisticManager.onEventWithValue("payMethodBalanceQuota", next.tips);
                        }
                    }, new View.OnClickListener() {
                        public void onClick(View view) {
                            CardData.BondCard bondCard;
                            boolean z = true;
                            boolean unused = PayTypeActivity.this.d = true;
                            PayTypeItemView.PayTypeItemViewData payTypeItemViewData = next;
                            boolean z2 = false;
                            if (!(payTypeItemViewData == null || (bondCard = payTypeItemViewData.card) == null)) {
                                if (bondCard.is_sign_jump_bank != 1 || TextUtils.isEmpty(bondCard.account_no)) {
                                    z = false;
                                }
                                StatHelper.cacheBankCode(next.card.bank_code);
                                StatHelper.cacheCardType(next.card.card_type + "");
                                z2 = z;
                            }
                            if (z2) {
                                PayTypeActivity.this.a(next.card.account_no);
                                return;
                            }
                            if (!TextUtils.isEmpty(next.hintUrl)) {
                                BaiduWalletDelegate.getInstance().openH5Module((Context) PayTypeActivity.this.getActivity(), next.hintUrl);
                            }
                            StatisticManager.onEventWithValue("payMethodBankHint", next.hintMsg);
                        }
                    });
                    if (generateItemView != null) {
                        if (!TextUtils.isEmpty(next.name)) {
                            String str2 = next.name;
                            if ("使用新银行卡".equals(str2)) {
                                AccessibilityUtils.setGroupDescription(generateItemView, ResUtils.getString(this, "wallet_access_use_new_card_des"));
                            } else if (str2.startsWith("余额")) {
                                AccessibilityUtils.setGroupDescription(generateItemView, ResUtils.getString(this, "wallet_access_use_balance_des"));
                            } else {
                                AccessibilityUtils.setGroupDescription(generateItemView, str2 + "，选择此银行进行支付");
                            }
                        }
                        AccessibilityUtils.changeRoleDescription(generateItemView, ResUtils.getString(this, "wallet_access_button"));
                        generateItemView.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                String str;
                                String str2;
                                CardData.BondCard bondCard;
                                CardData.BondCard bondCard2;
                                PayTypeItemView.PayTypeItemViewData payTypeItemViewData = next;
                                if (payTypeItemViewData.isAvaible) {
                                    String str3 = "";
                                    if (!(payTypeItemViewData == null || (bondCard2 = payTypeItemViewData.card) == null)) {
                                        StatHelper.cacheBankCode(bondCard2.bank_code);
                                        StatHelper.cacheCardType(next.card.card_type + str3);
                                    }
                                    if (!PayTypeActivity.this.c || !PayDataCache.getInstance().isFromPreCashier()) {
                                        PayTypeActivity payTypeActivity = PayTypeActivity.this;
                                        payTypeActivity.mClickedItemView = generateItemView;
                                        boolean unused = payTypeActivity.d = false;
                                        PayTypeItemView.ItemViewType itemViewType = next.type;
                                        String str4 = null;
                                        if (itemViewType == PayTypeItemView.ItemViewType.ADD_NEWCARD) {
                                            StatHelper.cachePayWay(4);
                                            StatHelper.statPayAllServiceEvent("onekeyClickNewcard", PayTypeActivity.PAY_TYPE_HASH_NAME, PayTypeActivity.PAY_TYPE_HASH_ID, "点击绑卡", new String[0]);
                                            str = str;
                                            str4 = next.name;
                                            str2 = null;
                                        } else if (itemViewType == PayTypeItemView.ItemViewType.BANKCARD) {
                                            StatHelper.statPayAllServiceEvent(StatServiceEvent.EVENT_SWITCH_BANKCARD, PayTypeActivity.PAY_TYPE_HASH_NAME, PayTypeActivity.PAY_TYPE_HASH_ID, "点击换卡", new String[0]);
                                            PayTypeItemView.PayTypeItemViewData payTypeItemViewData2 = next;
                                            CardData.BondCard bondCard3 = payTypeItemViewData2.card;
                                            String str5 = bondCard3.card_hd_title;
                                            str2 = bondCard3.bank_name;
                                            String str6 = str5;
                                            str4 = payTypeItemViewData2.name;
                                            str = str6;
                                        } else if (itemViewType == PayTypeItemView.ItemViewType.BALANCE) {
                                            str2 = null;
                                            str4 = "余额";
                                            str = null;
                                        } else {
                                            str = null;
                                            str2 = null;
                                        }
                                        StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PAY_METHOD_SELECT, PayTypeActivity.PAY_TYPE_HASH_NAME, PayTypeActivity.PAY_TYPE_HASH_ID, PayTypeItemView.MARKING_EVENT_TAG, StatHelper.getProcesssId(), str4, str, str2);
                                        if (PayTypeActivity.this.mPresenter != null) {
                                            BaseActivity.finishActivityWithActivityName(BindCardImplActivity.class);
                                            BaseActivity.finishActivityWithActivityName(PwdPayActivity.class);
                                            PayTypeActivity.this.mPresenter.modifyPayType(next);
                                            return;
                                        }
                                        return;
                                    }
                                    PayTypeItemView.PayTypeItemViewData payTypeItemViewData3 = next;
                                    if (!(payTypeItemViewData3 == null || (bondCard = payTypeItemViewData3.card) == null || bondCard.account_no == null)) {
                                        str3 = a.a().g(next.card.account_no);
                                    }
                                    if (!TextUtils.isEmpty(str3)) {
                                        PayDataCache.getInstance().setOrderExtraInfo(str3);
                                    }
                                    BaiduPayDelegate.getInstance().reOrderPay(PayTypeActivity.this.mAct);
                                } else if (!payTypeItemViewData.isNeedToColored()) {
                                    PayTypeActivity payTypeActivity2 = PayTypeActivity.this;
                                    PayTypeItemView.PayTypeItemViewData payTypeItemViewData4 = next;
                                    GlobalUtils.toast(payTypeActivity2, payTypeItemViewData4.removeSeparator(payTypeItemViewData4.tips));
                                }
                            }
                        });
                        arrayList2.add(generateItemView);
                    }
                }
            }
            if (z) {
                StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PAY_METHOD_MARKING_SHOW, PAY_TYPE_HASH_NAME, PAY_TYPE_HASH_ID, PayTypeItemView.MARKING_EVENT_TAG, StatHelper.getProcesssId());
            }
            this.mPayTypeContainerView.removeAllViews();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                this.mPayTypeContainerView.addView((PayTypeItemView) it2.next());
                View view = new View(getActivity());
                view.setBackgroundColor(ResUtils.getColor(getActivity(), "wallet_base_separator_color"));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 1);
                int dimension = (int) ResUtils.getDimension(this.mAct, "dxm_wallet_base_margin");
                layoutParams.setMargins(dimension, 0, dimension, 0);
                view.setLayoutParams(layoutParams);
                this.mPayTypeContainerView.addView(view);
            }
        }
    }

    public void setPresenter(PayTypeContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        WalletGlobalUtils.safeShowDialog(this.mAct, -1, "");
        if (this.d) {
            StatisticManager.onEvent("clickBankSign");
        }
        com.baidu.wallet.paysdk.banksign.beans.b bVar = (com.baidu.wallet.paysdk.banksign.beans.b) BankSignFactory.getInstance().getBean((Context) this.mAct, 768, TAG);
        a.a().a(str);
        bVar.a(str);
        bVar.setResponseCallback(this.mAct);
        bVar.execBean();
    }

    private void a(String str, boolean z, final int i2) {
        LocalRouter.getInstance(this).route(this, new RouterRequest().provider("langbrige").action("langbrige_getStartIntent").data("url", str).data("withAnim", Boolean.valueOf(z)).data("showShare", Boolean.TRUE), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
                Intent intent;
                if (i2 == 0 && hashMap != null && (hashMap.get("result") instanceof Intent) && (intent = (Intent) hashMap.get("result")) != null) {
                    PayTypeActivity.this.startActivityForResult(intent, i2);
                }
            }
        });
    }
}
