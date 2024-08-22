package com.baidu.wallet.paysdk.payresult.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.Compliance;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.presenter.a;
import com.baidu.wallet.paysdk.payresult.presenter.b;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.paysdk.ui.widget.FeedbackDialog;
import com.baidu.wallet.paysdk.ui.widget.ImageViewDialog;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.statusbar.ImmersiveStatusBarManager;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.ViewHelper;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.widget.BdActionBar;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.SDKBaseActivity;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.NFCUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.Arrays;
import java.util.HashMap;

public class WalletPayResultCommonActivity extends PayBaseBeanActivity implements View.OnClickListener, b.C0167b {
    public static final int DIALOG_FEEDBACK = 74081;
    public static final String b = WalletPayResultCommonActivity.class.getSimpleName();
    public b.a a;
    public NetImageView c;
    public TextView d;
    public View e;
    public View f;
    public View g;
    public int h = 0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3601i = true;
    public boolean j = true;
    public TextView mMainTip;
    public View mPayResultOrderAmountLayout;
    public TextView mPayResultOrderAmountText;
    public TextView mPayResultOrderPrefix;
    public TextView mPayResultPayType;
    public View mPayResultPayTypeGroup;
    public TextView mPayResultPayTypePrefix;
    public View mPayResultRealMoneyLayout;
    public TextView mPayResultRealMoneyText;
    public TextView mPayResultTotalDiscount;
    public View mPayResultTotalDiscountGroup;
    public TextView mPayResultTotalDiscountTip;
    public Button mPaySuccess;
    public ImageView mResultImg;
    public TextView mSubtitleView;
    public LinearLayout mpayResultDiscountType;
    public View mpayResultDiscountTypeGroup;
    public TextView mpayResultDiscountTypeTip;
    public String strRmbUnit = "";

    private void b() {
        a(findViewById(ResUtils.id(this, "root_layout")));
    }

    /* access modifiers changed from: private */
    public void c() {
        if (!isFinishing()) {
            this.a.h();
        }
    }

    private void d() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.g.getLayoutParams();
        int i2 = 0;
        if (this.f3601i) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mResultImg.getLayoutParams();
            layoutParams2.setMargins(0, DisplayUtils.dip2px(this, 100.0f), 0, 0);
            this.mResultImg.setLayoutParams(layoutParams2);
            findViewById(ResUtils.id(this, "pay_result_content_info_head_graw")).setVisibility(8);
            findViewById(ResUtils.id(this, "pay_result_content_info_foot_wave")).setVisibility(8);
            findViewById(ResUtils.id(this, "pay_result_content_info_white")).setBackgroundColor(ResUtils.getColor(this, "ebpay_f7f8fa"));
            layoutParams.height = DisplayUtils.dip2px(this, 230.0f);
            this.g.setLayoutParams(layoutParams);
            return;
        }
        if (this.j) {
            this.f.setVisibility(8);
            this.h++;
        }
        if (this.d.getVisibility() == 0) {
            i2 = 16;
        }
        int dip2px = DisplayUtils.dip2px(this, (float) (320 - (this.h * 35)));
        int displayHeight = (DisplayUtils.getDisplayHeight(this) - DisplayUtils.dip2px(this, 258.0f)) - i2;
        if (dip2px <= displayHeight) {
            dip2px = displayHeight;
        }
        layoutParams.height = dip2px;
        this.g.setLayoutParams(layoutParams);
    }

    public boolean changePayResultMainInfo(int i2, int i3) {
        return false;
    }

    public void finishPage() {
        finish();
    }

    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public void handleResponse(int i2, Object obj, String str) {
    }

    public void initActionBar(String str) {
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(this, "bdactionbar"));
        if (bdActionBar != null) {
            bdActionBar.setTitle(ResUtils.string(this, str));
            bdActionBar.hideLeftZone();
        }
    }

    public void initViewElements() {
        this.mResultImg = (ImageView) findViewById(ResUtils.id(this, "payresult_maininfo_icon"));
        this.mMainTip = (TextView) findViewById(ResUtils.id(this, "payresult_maininfo_main_tip"));
        Button button = (Button) findViewById(ResUtils.id(this, "pay_success_bt"));
        this.mPaySuccess = button;
        button.setOnClickListener(this);
        this.mPaySuccess.setVisibility(0);
        this.g = findViewById(ResUtils.id(this, "pay_result_content_info"));
        this.mPayResultPayTypeGroup = findViewById(ResUtils.id(this, "payresult_pay_type_group"));
        this.mPayResultPayType = (TextView) findViewById(ResUtils.id(this, "payresult_pay_type_info"));
        this.mPayResultPayTypePrefix = (TextView) findViewById(ResUtils.id(this, "payresult_pay_type_pfefix"));
        this.mPayResultOrderAmountLayout = findViewById(ResUtils.id(this, "payresult_order_amount_group"));
        this.mPayResultOrderPrefix = (TextView) findViewById(ResUtils.id(this, "payresult_order_amount_prefix"));
        this.mPayResultOrderAmountText = (TextView) findViewById(ResUtils.id(this, "payresult_order_amount"));
        this.mPayResultTotalDiscountGroup = findViewById(ResUtils.id(this, "payresult_discount_amount_group"));
        this.mPayResultTotalDiscount = (TextView) findViewById(ResUtils.id(this, "payresult_discount_amount"));
        this.mPayResultTotalDiscountTip = (TextView) findViewById(ResUtils.id(this, "payresult_discount_amount_tip"));
        this.mpayResultDiscountTypeGroup = findViewById(ResUtils.id(this, "payresult_discount_info_group"));
        this.mpayResultDiscountType = (LinearLayout) findViewById(ResUtils.id(this, "payresult_discount_info"));
        this.mpayResultDiscountTypeTip = (TextView) findViewById(ResUtils.id(this, "payresult_discount_info_tip"));
        this.mPayResultRealMoneyLayout = findViewById(ResUtils.id(this, "payresult_pay_info_group"));
        this.mPayResultRealMoneyText = (TextView) findViewById(ResUtils.id(this, "payresult_pay_info"));
        this.c = (NetImageView) findViewById(ResUtils.id(this, "payresult_title"));
        this.c.setImageResource(ResUtils.drawable(getApplicationContext(), "wallet_cashdesk_logo"));
        this.mSubtitleView = (TextView) findViewById(ResUtils.id(this, "payresult_maininfo_sub_tip"));
        this.d = (TextView) findViewById(ResUtils.id(this, "authorize_text"));
        this.e = findViewById(ResUtils.id(this, "statusbar_top"));
        this.f = findViewById(ResUtils.id(this, "divider_line"));
        setTop();
    }

    public boolean isPayResultMoneyLayoutVisible() {
        return true;
    }

    public boolean isPayResultRealMoneyTextVisible() {
        return this.mPayResultRealMoneyLayout.getVisibility() == 0;
    }

    public void onBackPressed() {
    }

    public void onClick(View view) {
        if (view == this.mPaySuccess) {
            StatisticManager.onEventWithValues("resultClickBtn", this.a.f());
            if (this.a.j()) {
                FeedbackDialog feedbackDialog = new FeedbackDialog(getActivity());
                feedbackDialog.initDialog(this.a.k());
                feedbackDialog.show();
                return;
            }
            finishWithoutAnim();
            this.a.g();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResUtils.layout(this, "wallet_cashdesk_pay_result_common_activity"));
        this.strRmbUnit = ResUtils.getString(this, "dxm_wallet_base_unit");
        a aVar = new a(this, this, bundle);
        this.a = aVar;
        if (!aVar.a()) {
            PayCallBackManager.callBackClientCancel(this, "WalletPayResultCommonActivity.onCreate().1");
            finish();
            return;
        }
        if (this.a.b()) {
            setFlagPaySdk();
        }
        if (!this.a.a(bundle)) {
            PayCallBackManager.callBackClientCancel(this, "WalletPayResultCommonActivity.onCreate().2");
            finish();
        } else if (this.a.c(bundle)) {
            d();
            b();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        b.a aVar = this.a;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void onModuleEvent(EventBus.Event event) {
    }

    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
        }
    }

    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.a.b(bundle);
    }

    public void setOKBtnText(String str) {
        this.mPaySuccess.setText(str);
    }

    public void setTitleLogo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c.setImageUrl(str);
        }
    }

    public void setTop() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.e.setLayoutParams(new LinearLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(getActivity())));
            ImmersiveStatusBarManager.setTopBar(getActivity(), this.e, isStatusbarTextColorBlack());
        }
    }

    public boolean showAuthDialog(Compliance compliance) {
        Compliance.AntiMoneyLaundering antiMoneyLaundering;
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        if (payRequest != null && TextUtils.equals(payRequest.getPayFrom(), BaiduPay.PAY_FROM_AUTHORIZE)) {
            LogUtil.e(WalletPayResultCommonActivity.class.getSimpleName(), payRequest.getPayFrom(), (Throwable) null);
            return false;
        } else if (compliance == null || (antiMoneyLaundering = compliance.anti_money_laundering) == null || antiMoneyLaundering.after_pay_identity != 1 || TextUtils.isEmpty(antiMoneyLaundering.auth_msg) || TextUtils.isEmpty(compliance.anti_money_laundering.sdk_auth_url)) {
            return false;
        } else {
            Compliance.AntiMoneyLaundering antiMoneyLaundering2 = compliance.anti_money_laundering;
            a(antiMoneyLaundering2.auth_msg, antiMoneyLaundering2.sdk_auth_url);
            return true;
        }
    }

    public void showAuthorizeMsg(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.mSubtitleView.getText())) {
                this.mSubtitleView.setVisibility(8);
            }
            this.d.setVisibility(0);
            this.d.setText(str);
            return;
        }
        this.d.setVisibility(8);
    }

    public void showDiscountAmountInfo(String str, String str2, String str3) {
    }

    public void showDiscountTypeInfo(String[][] strArr, String str, String str2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 5;
        layoutParams.gravity = 5;
        layoutParams.setMargins(0, DisplayUtils.dip2px(this, 15.0f), 0, 0);
        if (strArr != null) {
            this.f3601i = false;
            this.j = false;
            this.mpayResultDiscountTypeGroup.setVisibility(0);
            int i2 = 0;
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (strArr[i3].length > 1) {
                    if (TextUtils.equals(strArr[i3][0], "msg")) {
                        this.mpayResultDiscountTypeTip.setText(strArr[i3][1]);
                    } else {
                        i2++;
                        if (i3 == 0) {
                            a(strArr[i3][0], strArr[i3][1], layoutParams2);
                        } else {
                            this.h--;
                            a(strArr[i3][0], strArr[i3][1], layoutParams);
                        }
                    }
                }
            }
            if (i2 >= 2) {
                this.mPayResultTotalDiscountGroup.setVisibility(0);
                this.mPayResultTotalDiscountTip.setText(str2);
                this.mPayResultTotalDiscount.setText(new SpannableString("-" + this.strRmbUnit + str));
                return;
            }
            this.h++;
            this.mPayResultTotalDiscountGroup.setVisibility(8);
            return;
        }
        this.mPayResultTotalDiscountGroup.setVisibility(8);
        this.mpayResultDiscountTypeGroup.setVisibility(8);
    }

    public void showExpectedTime(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mSubtitleView.setText(str);
        }
    }

    public void showMarketDialog(String str, final String str2) {
        final PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        final ImageViewDialog imageViewDialog = new ImageViewDialog(getActivity());
        imageViewDialog.initDialog(str, new ImageViewDialog.a() {
            public void a() {
                if (CheckUtils.isFastDoubleClick()) {
                    String unused = WalletPayResultCommonActivity.b;
                    return;
                }
                BaiduWalletDelegate.getInstance().openH5Module((Context) WalletPayResultCommonActivity.this.getActivity(), str2);
                PayRequest payRequest = payRequest;
                if (payRequest != null) {
                    StatisticManager.onEventWithValues("payResultCrossMarketImageClick", Arrays.asList(new String[]{payRequest.mSpNO, str2}));
                }
                imageViewDialog.dismiss();
            }

            public void b() {
                PayRequest payRequest = payRequest;
                if (payRequest != null) {
                    StatisticManager.onEventWithValues("payResultCrossMarketCloseClick", Arrays.asList(new String[]{payRequest.mSpNO, str2}));
                }
            }

            public void c() {
                PayRequest payRequest = payRequest;
                if (payRequest != null) {
                    StatisticManager.onEventWithValues("payResultCrossMarketBackClick", Arrays.asList(new String[]{payRequest.mSpNO, str2}));
                }
            }
        });
        imageViewDialog.show();
    }

    public void showPayResultMoneyLayoutVisible(boolean z) {
    }

    public void showPayResultRealMoneyText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f.setVisibility(0);
            this.mPayResultRealMoneyLayout.setVisibility(0);
            RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.75f);
            SpannableString spannableString = new SpannableString(this.strRmbUnit + str);
            spannableString.setSpan(relativeSizeSpan, 0, 1, 33);
            this.mPayResultRealMoneyText.setText(spannableString);
            this.f3601i = false;
            return;
        }
        this.f.setVisibility(8);
        this.mPayResultRealMoneyLayout.setVisibility(8);
        this.h += 2;
    }

    public void showPaySuccess(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.size() <= 0) {
            PayCallBackManager.callBackClientCancel(this, "WalletPayResultCommonActivity.showPaySuccess().1");
            return;
        }
        this.mMainTip.setText(ResUtils.getString(this, hashMap.get("mainTip")));
        this.mResultImg.setImageDrawable(ResUtils.getDrawable(this, hashMap.get("statusDrawableName")));
        this.mPaySuccess.setText(ResUtils.getString(this, hashMap.get("okBtnText")));
        if (!TextUtils.isEmpty(hashMap.get("update_phone_desc"))) {
            this.mSubtitleView.setText(hashMap.get("update_phone_desc"));
        }
    }

    public void showPayTypeInfo(String[][] strArr, String str, String str2, String str3) {
        if (strArr == null || strArr.length <= 0) {
            this.h++;
            this.mPayResultPayTypeGroup.setVisibility(8);
            return;
        }
        this.f3601i = false;
        this.j = false;
        this.mPayResultPayTypeGroup.setVisibility(0);
        if (strArr[0].length > 1) {
            this.mPayResultPayTypePrefix.setText(strArr[0][0]);
            this.mPayResultPayType.setText(strArr[0][1]);
        }
    }

    public void showPaying(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.size() <= 0) {
            PayCallBackManager.callBackClientCancel(this, "WalletPayResultCommonActivity.showPaying().1");
            return;
        }
        this.mResultImg.setImageDrawable(ResUtils.getDrawable(this, hashMap.get("statusDrawableName")));
        this.mMainTip.setText(ResUtils.getString(this, hashMap.get("mainTip")));
        if (!TextUtils.isEmpty(hashMap.get("update_phone_desc"))) {
            this.mSubtitleView.setText(hashMap.get("update_phone_desc"));
        }
    }

    public void showTotalAmountInfo(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            this.f3601i = false;
            this.j = false;
            this.mPayResultOrderAmountLayout.setVisibility(0);
            this.mPayResultOrderAmountText.setText(this.strRmbUnit + str);
            if (!TextUtils.isEmpty(str2)) {
                this.mPayResultOrderPrefix.setText(str2);
            }
            if (Float.valueOf(str3).floatValue() < Float.valueOf(str).floatValue()) {
                this.mPayResultOrderAmountText.getPaint().setFlags(16);
            } else {
                this.mPayResultOrderAmountText.getPaint().setFlags(1);
            }
        } else {
            this.mPayResultOrderAmountLayout.setVisibility(8);
            this.h++;
        }
    }

    private void a(final View view) {
        view.post(new Runnable() {
            public void run() {
                final int bottom = view.getBottom();
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
                ofFloat.setDuration(500);
                ofFloat.setInterpolator(new DecelerateInterpolator());
                ofFloat.start();
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        ViewHelper.setTranslationY(view, ((float) (-bottom)) * floatValue);
                        if (floatValue <= 0.0f) {
                            WalletPayResultCommonActivity.this.c();
                        }
                    }
                });
            }
        });
    }

    private void a(String str, String str2, LinearLayout.LayoutParams layoutParams) {
        if (!TextUtils.isEmpty(str)) {
            View inflate = getLayoutInflater().inflate(ResUtils.layout(this, "wallet_cashdesk_discount_info_group"), (ViewGroup) null);
            ((TextView) inflate.findViewById(ResUtils.id(this, "payresult_discount_type"))).setText(str);
            ((TextView) inflate.findViewById(ResUtils.id(this, "payresult_discount_type_amount"))).setText("-" + this.strRmbUnit + str2);
            this.mpayResultDiscountType.addView(inflate, layoutParams);
        }
    }

    private void a(final String str, final String str2) {
        new Handler().post(new Runnable() {
            public void run() {
                final PromptDialog promptDialog = new PromptDialog(WalletPayResultCommonActivity.this.getActivity());
                promptDialog.setMessage((CharSequence) str);
                promptDialog.setCanceledOnTouchOutside(false);
                promptDialog.setCancelable(true);
                promptDialog.setPositiveBtn(ResUtils.string(WalletPayResultCommonActivity.this.getApplicationContext(), "wallet_hce_do_auth"), (View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View view) {
                        PromptDialog promptDialog = promptDialog;
                        if (promptDialog != null && promptDialog.isShowing()) {
                            promptDialog.dismiss();
                        }
                        BaiduPayDelegate.getInstance().doPayRNAuth(WalletPayResultCommonActivity.this.getActivity(), str2, new RNAuthCallBack() {
                            public void onRNAuthResult(int i2, String str) {
                            }
                        });
                    }
                });
                promptDialog.setNegativeBtn(ResUtils.string(WalletPayResultCommonActivity.this.getApplicationContext(), "dxm_ebpay_cancel"), (View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View view) {
                        PromptDialog promptDialog = promptDialog;
                        if (promptDialog != null && promptDialog.isShowing()) {
                            promptDialog.dismiss();
                        }
                    }
                });
                promptDialog.show();
            }
        });
    }
}
