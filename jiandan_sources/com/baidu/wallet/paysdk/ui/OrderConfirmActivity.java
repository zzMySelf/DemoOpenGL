package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.widget.WalletBaseButtonWithImage;
import com.baidu.wallet.paysdk.banksign.BankSignPayFlow;
import com.baidu.wallet.paysdk.banksign.a.a;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.baidu.wallet.paysdk.banksign.beans.b;
import com.baidu.wallet.paysdk.banksign.datamodel.GetJumpUrlResponse;
import com.baidu.wallet.paysdk.contract.OrderConfirmContract;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.presenter.OrderConfirmPresenter;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.dialog.DxmNewStandardDialog;
import com.dxmpay.wallet.core.beans.BeanActivity;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.beans.sm.SMManagerDelegate;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.AnimUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.math.BigDecimal;
import java.util.HashMap;

public class OrderConfirmActivity extends HalfScreenBaseActivity implements View.OnClickListener {
    public static final String PAY_ORDER_CONFIRM_HASH_ID = "paySDKOrderConfirmPage";
    public static final String PAY_ORDER_CONFIRM_HASH_NAME = "订单确认页面";
    public String A;
    public String B;
    public RelativeSizeSpan C;
    public View D;
    public boolean E = false;
    public String F;
    public String G;
    public boolean H;
    public final String a = OrderConfirmActivity.class.getSimpleName();
    public View b;
    public View c;
    public NetImageView d;
    public View e;
    public TextView f;
    public TextView g;
    public ImageView h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3613i = false;
    public TextView j;
    public View k;
    public TextView l;
    public View m;
    public OrderConfirmContract.Presenter mPresenter;
    public TextView n;

    /* renamed from: o  reason: collision with root package name */
    public View f3614o;
    public TextView p;
    public TextView q;
    public ImageView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public WalletBaseButtonWithImage w;
    public View x;
    public TextView y;
    public ImageView z;

    private boolean c() {
        CardData.BondCard selectCard = PayRequestCache.getInstance().getSelectCard();
        return selectCard != null && 1 == selectCard.is_sign_jump_bank;
    }

    public void addContentView() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_order_confirm_layout"), (ViewGroup) null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
    }

    public void continuePay() {
        Intent intent = new Intent(this, PwdPayActivity.class);
        intent.putExtra("otpToken", this.F);
        intent.putExtra("warningTips", this.G);
        intent.putExtra("gatewaySign", this.H);
        if (this.E) {
            intent.putExtra("IS_FOR_BIND_CARD_PAY", true);
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_ENTER, PayController.PAY_BIND_CARD_ENTER_HASH_NAME, PayController.PAY_BIND_CARD_ENTER_HASH_ID, "进入", new String[0]);
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_BIND_CARD_DURATION);
        }
        startActivity(intent);
    }

    public void dismissLoading(int i2) {
    }

    public void gotoCoupon() {
        startActivity(new Intent(getActivity(), CouponListActivity.class));
    }

    public void gotoNext(String str, String str2) {
        if (c()) {
            this.F = str;
            this.G = str2;
            String str3 = "";
            WalletGlobalUtils.safeShowDialog(this.mAct, -1, str3);
            BankSignFactory instance = BankSignFactory.getInstance();
            BeanActivity beanActivity = this.mAct;
            b bVar = (b) instance.getBean((Context) beanActivity, 768, this.a + toString());
            CardData.BondCard selectCard = PayRequestCache.getInstance().getSelectCard();
            if (selectCard != null) {
                str3 = selectCard.account_no;
            }
            bVar.a(str3);
            bVar.setResponseCallback(this);
            bVar.execBean();
            return;
        }
        pay(str, str2, false);
    }

    public void gotoPayType() {
        startActivity(new Intent(getActivity(), PayTypeActivity.class));
    }

    public void handleFailure(int i2, int i3, String str) {
        if (i2 == 768) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            pay(this.F, this.G, true);
        }
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
                a.a().b(false);
                a.a().d(getJumpUrlResponse.form_url);
                a.a().e(getJumpUrlResponse.webview_title);
                a.a().c(this.F);
                a.a().b(this.G);
                a.a().a(this);
                BankSignPayFlow a2 = BankSignPayFlow.a();
                a2.a(BankSignPayFlow.Action.ShowGuide);
                a2.a((Context) this.mAct);
                return;
            }
            pay(this.F, this.G, true);
        }
    }

    public void onBackPressed() {
        this.mPresenter.closeOrderComfirmPage();
    }

    public void onClick(View view) {
        OrderConfirmContract.Presenter presenter;
        if (view == this.e) {
            StatHelper.statServiceEvent(StatServiceEvent.EVENT_CLICK_PAY_TYPE_ITEM);
            ImageView imageView = this.h;
            if (imageView != null && imageView.getVisibility() == 0) {
                this.f3613i = true;
            }
            this.mPresenter.clickPayway();
        } else if (view == this.f3614o) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_COUPON_ITEM);
            this.mPresenter.clickCoupon();
        } else if (view == this.D) {
            this.mPresenter.closeOrderComfirmPage();
        } else if (view == this.x && (presenter = this.mPresenter) != null) {
            presenter.startFingerprintListening();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        OrderConfirmPresenter orderConfirmPresenter = new OrderConfirmPresenter(this);
        this.mPresenter = orderConfirmPresenter;
        orderConfirmPresenter.onCreate(bundle);
        a();
    }

    public Dialog onCreateDialog(int i2) {
        if (i2 == 64) {
            return new DxmNewStandardDialog(this);
        }
        return super.onCreateDialog(i2);
    }

    public void onDestroy() {
        super.onDestroy();
        OrderConfirmContract.Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.onDestroy();
            this.mPresenter = null;
        }
    }

    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= 23) {
            WalletFingerprint.getInstance(this).cancleListening();
        }
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        String str;
        if (i2 == 64) {
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
                    WalletGlobalUtils.safeDismissDialog(OrderConfirmActivity.this.mAct, 64);
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
                    sMManagerDelegate.certificateManage(OrderConfirmActivity.this, jSONObject.toString(), new RouterCallback() {
                        public void onResult(int i2, HashMap hashMap) {
                            if (i2 == 0 && hashMap != null && hashMap.get("result") != null) {
                                try {
                                    JSONObject optJSONObject = new JSONObject(hashMap.get("result").toString()).optJSONObject("cnt");
                                    if (optJSONObject != null && optJSONObject.optInt("errCode", -1) == 0) {
                                        OrderConfirmActivity.this.continuePay();
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
                    WalletGlobalUtils.safeDismissDialog(OrderConfirmActivity.this.mAct, 64);
                }
            });
            return;
        }
        super.onPrepareDialog(i2, dialog);
    }

    public void onResume() {
        super.onResume();
        OrderConfirmContract.Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.startFingerprintListening();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mPresenter.onSaveInstanceState(bundle);
    }

    public void pay(String str, String str2, boolean z2) {
        this.F = str;
        this.G = str2;
        this.H = z2;
        if (PayDataCache.getInstance().needOpenCertificate(this)) {
            WalletGlobalUtils.safeShowDialog(this, 64, "");
        } else {
            continuePay();
        }
    }

    public void showFpCheckError() {
        this.y.setText(ResUtils.getString(getActivity(), "wallet_cashdesk_onceagain"));
        this.y.setTextColor(ResUtils.getColor(this.mAct, "dxm_wallet_fp_record_tip_color_error"));
        this.z.setImageDrawable(ResUtils.getDrawable(this, "wallet_fingerprint_little_icon_red"));
        AnimUtils.startSharkAnim(this.x);
    }

    public void showFpCheckSuccess(final String str) {
        this.y.setText("指纹验证成功");
        this.y.setTextColor(ResUtils.getColor(this.mAct, "wallet_fp_record_tip_coloe_397BE6"));
        this.z.setImageDrawable(ResUtils.getDrawable(this, "dxm_wallet_cashdesk_fp_succ"));
        this.y.postDelayed(new Runnable() {
            public void run() {
                OrderConfirmActivity.this.gotoNext(str, (String) null);
                OrderConfirmActivity.this.y.postDelayed(new Runnable() {
                    public void run() {
                        OrderConfirmActivity.this.y.setText(ResUtils.getString(OrderConfirmActivity.this, "wallet_fp_pay_tips"));
                        OrderConfirmActivity.this.z.setImageDrawable(ResUtils.getDrawable(OrderConfirmActivity.this, "wallet_cashdesk_fp_logo"));
                    }
                }, 300);
            }
        }, 300);
    }

    public void showLoading(int i2) {
    }

    public void showPaySuccessPage(boolean z2, PayResultContent payResultContent, int i2) {
    }

    private void a() {
        this.mPresenter.getViewData();
    }

    private void b() {
        this.mActionBar.setVisibility(8);
        this.d = (NetImageView) this.mContentView.findViewById(ResUtils.id(getActivity(), "cashdesk_logo"));
        this.d.setImageResource(ResUtils.drawable(getApplicationContext(), "wallet_cashdesk_logo"));
        TextView textView = (TextView) this.mContentView.findViewById(ResUtils.id(getActivity(), "cashdesk_paymethod_entry"));
        this.v = textView;
        textView.setVisibility(8);
        AccessibilityUtils.changeRoleDescription(this.v, ResUtils.getString(this, "wallet_access_button"));
        this.b = this.mContentView.findViewById(ResUtils.id(getActivity(), "ebpay_account_layout"));
        this.c = this.mContentView.findViewById(ResUtils.id(getActivity(), "bd_wallet_account_arrow_icon"));
        this.u = (TextView) findViewById(ResUtils.id(this, "ebpay_account"));
        this.e = this.mContentView.findViewById(ResUtils.id(getActivity(), "ebpay_payway_layout"));
        this.f = (TextView) findViewById(ResUtils.id(this, "paytype_desc"));
        this.g = (TextView) findViewById(ResUtils.id(this, "payway_discount"));
        this.j = (TextView) findViewById(ResUtils.id(this, "payway_txt_for_complete_bankcard"));
        this.h = (ImageView) findViewById(ResUtils.id(this, "wallet_base_red_dot"));
        this.e.setOnClickListener(this);
        this.k = findViewById(ResUtils.id(this, "ebpay_goods_layout"));
        this.l = (TextView) findViewById(ResUtils.id(this, "ebpay_order_info"));
        this.m = findViewById(ResUtils.id(this, "ebpay_sp_layout"));
        this.n = (TextView) findViewById(ResUtils.id(this, "ebpay_sp_info"));
        this.f3614o = this.mContentView.findViewById(ResUtils.id(getActivity(), "ebpay_discount_layout"));
        this.p = (TextView) findViewById(ResUtils.id(this, "ebpay_discount_desc_type"));
        this.q = (TextView) findViewById(ResUtils.id(this, "ebpay_discount_amount"));
        this.r = (ImageView) findViewById(ResUtils.id(this, "discount_arrow"));
        this.f3614o.setOnClickListener(this);
        this.s = (TextView) findViewById(ResUtils.id(this, "bd_wallet_pay_amount"));
        this.t = (TextView) findViewById(ResUtils.id(this, "ebpay_orderprice"));
        WalletBaseButtonWithImage walletBaseButtonWithImage = (WalletBaseButtonWithImage) findViewById(ResUtils.id(getActivity(), "bd_wallet_pay_btn"));
        this.w = walletBaseButtonWithImage;
        walletBaseButtonWithImage.setOnClickListener(this);
        this.x = findViewById(ResUtils.id(getActivity(), "pwd_fp_layout"));
        this.y = (TextView) findViewById(ResUtils.id(getActivity(), "fp_layout_tips"));
        this.z = (ImageView) findViewById(ResUtils.id(getActivity(), "fp_logo"));
        this.A = ResUtils.getString(this, "dxm_price_format");
        this.B = ResUtils.getString(this, "dxm_save_format");
        this.C = new RelativeSizeSpan(0.5f);
        View findViewById = findViewById(ResUtils.id(this, "ic_close"));
        this.D = findViewById;
        findViewById.setOnClickListener(this);
        this.x.setOnClickListener(this);
    }

    public void reFreshUI(final OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData) {
        if (orderConfirmViewData != null) {
            if (!TextUtils.isEmpty(orderConfirmViewData.currentAccount)) {
                this.b.setVisibility(0);
                this.u.setText(orderConfirmViewData.currentAccount);
                this.c.setVisibility(4);
            } else {
                this.b.setVisibility(8);
            }
            if (!TextUtils.isEmpty(orderConfirmViewData.title_url)) {
                this.d.setVisibility(0);
                this.d.setImageUrl(orderConfirmViewData.title_url);
            }
            this.f.setTextColor(ResUtils.getColor(this, orderConfirmViewData.hasAvailablePayType ? "ebpay_text_868e9e" : "dxm_wallet_base_textcolor_e85352"));
            String str = "";
            this.f.setText(!TextUtils.isEmpty(orderConfirmViewData.payTyeDesc) ? orderConfirmViewData.payTyeDesc : str);
            if (!TextUtils.isEmpty(orderConfirmViewData.channelDiscountDesc)) {
                this.g.setVisibility(0);
                this.g.setText(orderConfirmViewData.channelDiscountDesc);
            } else {
                this.g.setVisibility(8);
            }
            if (!TextUtils.isEmpty(orderConfirmViewData.cardTip)) {
                this.j.setVisibility(0);
                this.j.setText(orderConfirmViewData.cardTip);
            } else {
                this.j.setVisibility(8);
            }
            if (this.f3613i || !orderConfirmViewData.isShowRedDot) {
                this.h.setVisibility(8);
            } else {
                this.h.setVisibility(0);
            }
            if (!TextUtils.isEmpty(orderConfirmViewData.goodsName)) {
                this.l.setText(orderConfirmViewData.goodsName);
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            if (!TextUtils.isEmpty(orderConfirmViewData.spName)) {
                this.n.setText(orderConfirmViewData.spName);
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            if (orderConfirmViewData.showDiscount) {
                this.f3614o.setVisibility(0);
                this.f3614o.setClickable(true);
                this.p.setText(orderConfirmViewData.discountDesc);
                this.q.setText(String.format(this.B, new Object[]{StringUtils.fen2Yuan(orderConfirmViewData.discountAmount)}));
                this.r.setVisibility(0);
                this.q.setVisibility(0);
            } else if (!TextUtils.isEmpty(orderConfirmViewData.randomDiscountMsg)) {
                this.f3614o.setVisibility(0);
                this.f3614o.setClickable(false);
                this.p.setText(orderConfirmViewData.randomDiscountMsg);
                this.q.setVisibility(8);
                this.r.setVisibility(4);
            } else {
                this.f3614o.setVisibility(8);
            }
            this.t.setText(!TextUtils.isEmpty(orderConfirmViewData.orderPrice) ? String.format(this.A, new Object[]{StringUtils.fen2Yuan(orderConfirmViewData.orderPrice)}) : str);
            if (new BigDecimal(orderConfirmViewData.orderPrice).compareTo(new BigDecimal(orderConfirmViewData.needPayAmount)) > 0) {
                this.t.setVisibility(0);
                this.t.getPaint().setFlags(16);
            } else {
                this.t.setVisibility(4);
            }
            if (!TextUtils.isEmpty(orderConfirmViewData.needPayAmount)) {
                str = String.format(this.A, new Object[]{StringUtils.fen2Yuan(orderConfirmViewData.needPayAmount)});
            }
            if (str.length() > 0) {
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(this.C, 0, 1, 33);
                this.s.setText(spannableString);
            } else {
                this.s.setText(str);
            }
            TextView textView = this.s;
            textView.setContentDescription("支付金额" + str);
            this.w.setText(orderConfirmViewData.confirmBtnMsg);
            if (ResUtils.getString(this, "wallet_access_use_new_car_pay").equals(orderConfirmViewData.confirmBtnMsg)) {
                this.w.getNextBtn().setContentDescription(ResUtils.getString(this, "wallet_access_use_new_car_pay_action"));
            } else {
                this.w.getNextBtn().setContentDescription(orderConfirmViewData.confirmBtnMsg);
            }
            if (orderConfirmViewData.hasAvailablePayType) {
                this.E = false;
                if (orderConfirmViewData.isFingerprintPay) {
                    if (orderConfirmViewData.isOTP) {
                        this.w.setVisibility(8);
                        if (this.x.getVisibility() == 8) {
                            this.x.setVisibility(0);
                            this.y.setText(ResUtils.getString(this, "wallet_fp_pay_tips"));
                            this.z.setImageDrawable(ResUtils.getDrawable(this, "wallet_cashdesk_fp_logo"));
                        }
                    }
                    StatHelper.cachePayWay(1);
                    this.v.setVisibility(0);
                    this.v.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            OrderConfirmActivity.this.mPresenter.gotoPayUsePwd(false, (String) null);
                        }
                    });
                } else {
                    if (PayDataCache.getInstance().isPassFree()) {
                        StatHelper.cachePayWay(2);
                    } else {
                        StatHelper.cachePayWay(0);
                    }
                    this.w.setVisibility(0);
                    this.x.setVisibility(8);
                    this.v.setVisibility(8);
                }
            } else {
                StatHelper.cachePayType(0);
                StatHelper.cachePayWay(4);
                StatisticManager.onEvent(StatServiceEvent.EVENT_SHOW_USE_NEWCARD_TO_PAY);
                this.w.setVisibility(0);
                this.v.setVisibility(8);
                this.E = true;
            }
            this.w.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (!CheckUtils.isFastDoubleClick()) {
                        OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData = orderConfirmViewData;
                        if (!orderConfirmViewData.isFingerprintPay) {
                            if (orderConfirmViewData.hasAvailablePayType) {
                                StatisticManager.onEvent("onekeyClickpay");
                            } else {
                                StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_NEWCARD_TO_PAY);
                            }
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put(StatHelper.HASH_NAME, OrderConfirmActivity.PAY_ORDER_CONFIRM_HASH_NAME);
                        hashMap.put("hash", OrderConfirmActivity.PAY_ORDER_CONFIRM_HASH_ID);
                        hashMap.put(StatHelper.EVENT_TAG, "点击确认");
                        hashMap.put(StatHelper.PAGE_NAME, StatHelper.PAY_SDK_CASHDESH_PAY_NAME);
                        hashMap.put(StatHelper.PAGE_ID, StatHelper.PAY_SDK_CASHDESH_PAY_ID);
                        hashMap.put(StatHelper.EVENT_PATH, "paySDK_payVerType");
                        hashMap.put(StatHelper.EVENT_MOLD, StatHelper.PAY_SDK_AUTO_ACTION);
                        StatHelper.statServiceEvent("payVerType", hashMap, orderConfirmViewData.confirmBtnMsg);
                        OrderConfirmActivity.this.gotoNext((String) null, (String) null);
                    }
                }
            });
        }
    }

    public void setPresenter(OrderConfirmContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
