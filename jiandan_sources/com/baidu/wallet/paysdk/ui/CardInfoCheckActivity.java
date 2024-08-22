package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.j;
import com.baidu.wallet.paysdk.beans.v;
import com.baidu.wallet.paysdk.beans.z;
import com.baidu.wallet.paysdk.contract.a;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.a.b;
import com.baidu.wallet.paysdk.ui.widget.PayLoadingImageViewNew;
import com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardUtil;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.core.beans.sm.SMManagerDelegate;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;

public class CardInfoCheckActivity extends HalfScreenBaseActivity {
    public static final String BEAN_TAG = "CardInfoCheckActivity";
    public static final String CHECK_INFO_STATE = "check_info_state";
    public static final String TAG = "CardInfoCheckActivity";
    public a.C0164a a;
    public a.b b;
    public int c = 0;
    public SafeKeyBoardEditText d;
    public PayRequest e;
    public RelativeLayout f;
    public SafeScrollView g;
    public SafeKeyBoardUtil h;

    /* renamed from: i  reason: collision with root package name */
    public PayLoadingImageViewNew f3612i;
    public View j;
    public SuccessImageViewNew k;
    public boolean l;

    private void e() {
        com.baidu.wallet.paysdk.beans.a aVar = (com.baidu.wallet.paysdk.beans.a) PayBeanFactory.getInstance().getBean((Context) this.mAct, 14, "CardInfoCheckActivity");
        aVar.setResponseCallback(this.mAct);
        aVar.execBean();
    }

    private void f() {
        v vVar = (v) PayBeanFactory.getInstance().getBean((Context) this.mAct, (int) PayBeanFactory.BEAN_ID_LICAI_BALANCE_PAY, "CardInfoCheckActivity");
        vVar.setResponseCallback(this.mAct);
        vVar.execBean();
    }

    private void g() {
        z zVar = (z) PayBeanFactory.getInstance().getBean((Context) this.mAct, 13, "CardInfoCheckActivity");
        zVar.setResponseCallback(this.mAct);
        zVar.a(true);
        zVar.execBean();
    }

    private void h() {
        this.f = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "wallet_cashdesk_card_info_check_content"));
        SafeScrollView safeScrollView = (SafeScrollView) findViewById(ResUtils.id(getActivity(), "scrollview"));
        this.g = safeScrollView;
        safeScrollView.setVisibility(0);
        this.g.addView(this.b.a());
        PayLoadingImageViewNew payLoadingImageViewNew = (PayLoadingImageViewNew) findViewById(ResUtils.id(this, "bd_wallet_cashier_loading_view"));
        this.f3612i = payLoadingImageViewNew;
        payLoadingImageViewNew.setVisibility(8);
        this.k = (SuccessImageViewNew) findViewById(ResUtils.id(this, "bd_wallet_success_logo"));
        View findViewById = findViewById(ResUtils.id(this, "bd_wallet_success_logo"));
        this.j = findViewById;
        findViewById.setVisibility(8);
        setSafeScrollView(this.g);
        ((TextView) this.mHalfScreenContainer.findViewById(ResUtils.id(this.mAct, "bd_wallet_bind_card_title"))).setText(ResUtils.getString(getActivity(), "ebpay_title_risk_control"));
        ViewGroup viewGroup = (ViewGroup) this.mHalfScreenContainer.findViewById(ResUtils.id(this.mAct, "wallet_bind_card_subtitle"));
        CardData.BondCard bondCard = this.e.mBondCard;
        if (bondCard == null) {
            com.baidu.wallet.paysdk.ui.widget.a.a(viewGroup, ResUtils.getString(this.mAct, "ebpay_title_complete_fixmsg"), (CharSequence) null, (CharSequence) null);
        } else {
            com.baidu.wallet.paysdk.ui.widget.a.a(viewGroup, "请完善", bondCard.getCardDesc(this.mAct, false), "的信息后继续支付");
        }
    }

    public void addContentView() {
        this.mHalfScreenContainer.removeView(this.mActionBar);
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_card_info_check_layout"), (ViewGroup) null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
        this.mActionBar = findViewById(ResUtils.id(getActivity(), "ebpay_halfscreen_action_bar"));
        this.mLeftImg = (ImageView) findViewById(ResUtils.id(getActivity(), "action_bar_left_img"));
        this.mTitle = (TextView) findViewById(ResUtils.id(getActivity(), "action_bar_title"));
        this.mRightTxt = (TextView) findViewById(ResUtils.id(getActivity(), "action_bar_left_txt"));
    }

    public void handleErrorContent() {
        b();
        this.l = false;
        this.g.setVisibility(0);
        super.handleErrorContent();
    }

    public void handleFailure(int i2, int i3, String str) {
        b();
        this.l = false;
        this.g.setVisibility(0);
        if (i2 != 263 && i2 != 13 && i2 != 14 && i2 != 622) {
            super.handleFailure(i2, i3, str);
        } else if (i3 == 5003) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_wallet_base_please_login"));
            AccountManager.getInstance(getActivity()).logout();
            WalletLoginHelper.getInstance().logout(false);
        } else if (i3 == -2) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_fp_get_data_fail"));
        } else if (i3 == -3) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_fp_get_data_fail"));
        } else if (i3 == -4) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_fp_get_data_fail"));
        } else if (i3 == -8) {
            WalletGlobalUtils.safeShowDialog(this, 11, "");
        } else {
            if (55000 == i3 || 55001 == i3) {
                new SMManagerDelegate().deleteUserKeyId(this.mAct);
            }
            this.mDialogMsg = str;
            if (TextUtils.isEmpty(str)) {
                this.mDialogMsg = ResUtils.getString(getActivity(), "dxm_fp_get_data_fail");
            }
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this, "dxm_fp_get_data_fail");
            }
            this.mDialogMsg = str;
            WalletGlobalUtils.safeShowDialog(this, 12, "");
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        super.handleResponse(i2, obj, str);
    }

    public void onBackPressed() {
        if (!this.l) {
            if (PayDataCache.getInstance().isFromPreCashier()) {
                WalletGlobalUtils.safeShowDialog(this, 18, "");
            } else {
                super.onBackPressed();
            }
        }
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        b();
        this.l = false;
        super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setIsShowMultiWindowTips(true);
        getActivity().getWindow().setSoftInputMode(2);
        this.e = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        this.c = extras.getInt(CHECK_INFO_STATE);
        a.b a2 = b.a().a(this.c, getActivity());
        this.b = a2;
        if (a2 == null) {
            finish();
            return;
        }
        a.C0164a a3 = com.baidu.wallet.paysdk.presenter.a.b.a(this.c, a2);
        this.a = a3;
        if (a3 == null) {
            finish();
            return;
        }
        h();
        CardData.BondCard bondCard = this.e.mBondCard;
        if (bondCard != null) {
            this.b.a(bondCard.getCardDescShort());
        }
        if (bundle != null) {
            this.l = bundle.getBoolean("isloading");
            this.d.setText((String) bundle.get("saveContent"));
        }
        SafeKeyBoardEditText b2 = this.b.b();
        this.d = b2;
        b2.setCheckFunc(new SafeKeyBoardEditText.CheckFunc() {
            public boolean check(String str) {
                return CardInfoCheckActivity.this.a.b(str);
            }
        });
        this.mLeftImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CardInfoCheckActivity.this.onBackPressed();
            }
        });
        this.d.setConfirmListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.C0164a a2 = CardInfoCheckActivity.this.a;
                CardInfoCheckActivity cardInfoCheckActivity = CardInfoCheckActivity.this;
                if (!a2.a(cardInfoCheckActivity.a((CharSequence) cardInfoCheckActivity.d.getEditableText().toString()))) {
                    CardInfoCheckActivity.this.b.c();
                    return;
                }
                a.C0164a a3 = CardInfoCheckActivity.this.a;
                CardInfoCheckActivity cardInfoCheckActivity2 = CardInfoCheckActivity.this;
                a3.c(cardInfoCheckActivity2.a((CharSequence) cardInfoCheckActivity2.d.getEditableText().toString()));
                CardInfoCheckActivity.this.c();
            }
        });
        SafeKeyBoardEditText safeKeyBoardEditText = this.d;
        safeKeyBoardEditText.initSafeKeyBoardParams(this.f, this.g, safeKeyBoardEditText, false);
        SafeKeyBoardUtil safeKeyBoardUtil = new SafeKeyBoardUtil();
        this.h = safeKeyBoardUtil;
        safeKeyBoardUtil.setState(SafeKeyBoardUtil.SafeKeyBoardState.CONFRIM_STATE);
        this.g.setSafeKeyBoardUtil(this.h);
        this.g.setAlwaysShowSoftKeyBoard(true);
        this.d.requestFocus();
    }

    public void onDestroy() {
        super.onDestroy();
        SafeKeyBoardUtil safeKeyBoardUtil = this.h;
        if (safeKeyBoardUtil != null) {
            safeKeyBoardUtil.hideSoftKeyBoard();
        }
        SafeScrollView safeScrollView = this.g;
        if (safeScrollView != null) {
            safeScrollView.clear();
        }
    }

    public void onNegativeBtnClick() {
        if (PayDataCache.getInstance().isFromPreCashier()) {
            PayCallBackManager.callBackClientCancel(this, "CardInfoCheckActivityonNegativeBtnClick().1");
        } else {
            finishWithoutAnim();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putSerializable("isloading", Boolean.valueOf(this.l));
            bundle.putString("saveContent", this.d.getEditableText().toString());
        }
    }

    public void showPaySuccessPage(final boolean z, final PayResultContent payResultContent, int i2) {
        b();
        this.mActionBar.setVisibility(4);
        this.g.setVisibility(8);
        this.j.setVisibility(0);
        this.k.startAnimation(new SuccessImageViewNew.a() {
            public void a() {
                if (z) {
                    boolean unused = CardInfoCheckActivity.this.l = false;
                    PayController.getInstance().paySucess(CardInfoCheckActivity.this, payResultContent, 1);
                    return;
                }
                boolean unused2 = CardInfoCheckActivity.this.l = false;
                PayController.getInstance().payPaying(CardInfoCheckActivity.this, payResultContent, 1);
            }
        });
    }

    private void b() {
        this.mActionBar.setVisibility(0);
        this.f3612i.stopAnimation();
        this.f3612i.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void c() {
        a();
        PayRequest.PayPrice.PayType payType = this.e.getPayPrice().payType;
        if (payType == PayRequest.PayPrice.PayType.BANKCARD) {
            g();
        } else if (payType == PayRequest.PayPrice.PayType.BALANCE) {
            e();
        } else if (payType == PayRequest.PayPrice.PayType.CREIDT) {
            d();
        } else if (payType == PayRequest.PayPrice.PayType.LICAIBALANCE) {
            f();
        }
    }

    private void d() {
        j jVar = (j) PayBeanFactory.getInstance().getBean((Context) this.mAct, 263, "CardInfoCheckActivity");
        jVar.setResponseCallback(this.mAct);
        jVar.execBean();
    }

    private void a() {
        this.mActionBar.setVisibility(4);
        this.l = true;
        this.g.setVisibility(8);
        this.g.dismissKeyBoard(this.d);
        this.f3612i.setVisibility(0);
        this.f3612i.startAnimation();
    }

    /* access modifiers changed from: private */
    public String a(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            return charSequence.toString().replace(" ", "").trim();
        }
        return "";
    }
}
