package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.widget.OrderConfirmation;
import com.baidu.wallet.base.widget.WalletBaseButtonWithImage;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.presenter.d;
import com.baidu.wallet.paysdk.presenter.e;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.statusbar.ImmersiveStatusBarManager;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.widget.BdActionBar;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.SDKBaseActivity;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.ui.WebViewActivity;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.Map;

public class AuthorizeSignActivity extends PayBaseBeanActivity implements View.OnClickListener {
    public static final String AUTH_SIGN_TYPE = "AuthorizeSignType";
    public static final int BUTTON_STATE_AUTH = 3;
    public static final int BUTTON_STATE_AUTH_NEWCARD = 4;
    public static final int BUTTON_STATE_NEWCARD = 2;
    public static final int BUTTON_STATE_NEXT = 1;
    public e a;
    public AuthorizeInfoView b;
    public OrderConfirmation c;
    public LinearLayout d;
    public NetImageView e;
    public TextView f;
    public TextView g;
    public TextView h;

    /* renamed from: i  reason: collision with root package name */
    public WalletBaseButtonWithImage f3607i;
    public LinearLayout j;
    public TextView k;
    public LinearLayout l;
    public CheckBox m;
    public TextView n;

    /* renamed from: o  reason: collision with root package name */
    public PayRequest f3608o;
    public DirectPayContentResponse p;
    public CardData.BondCard q;
    public View r;

    public AuthorizeInfoView.b getAuthInfoViewAdapter(int i2) {
        if (this.b != null) {
            return AuthorizeInfoView.a.a().a(i2, this.b);
        }
        return null;
    }

    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public PayRequest getPayRequest() {
        if (this.f3608o == null) {
            this.f3608o = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        }
        return this.f3608o;
    }

    public DirectPayContentResponse getPayResponse() {
        if (this.p == null) {
            this.p = PayDataCache.getInstance().getPayResponse();
        }
        return this.p;
    }

    public CardData.BondCard getSelectedCard() {
        return this.q;
    }

    public void handleResponse(int i2, Object obj, String str) {
    }

    public void initActionBarByString(String str) {
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
        if (bdActionBar != null) {
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(getApplicationContext(), "bd_wallet_withhold_title");
            }
            bdActionBar.setTitle(str);
            bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(AuthorizeSignActivity.this.getActivity());
                    AuthorizeSignActivity.this.onBackPressed();
                }
            });
        }
    }

    public void initCardList() {
        if (this.d != null && this.f != null && this.g != null && this.e != null) {
            PayRequest payRequest = getPayRequest();
            if (payRequest != null) {
                this.q = payRequest.getDefaultBankCardIdx();
            }
            e eVar = this.a;
            if (eVar != null) {
                eVar.a(this.q != null);
            }
            a();
            updateSelBankInfo(this.q);
        }
    }

    public void initNextButton(View.OnClickListener onClickListener) {
        WalletBaseButtonWithImage walletBaseButtonWithImage = this.f3607i;
        if (walletBaseButtonWithImage != null) {
            if (onClickListener != null) {
                walletBaseButtonWithImage.setOnClickListener(onClickListener);
            }
            updateNextButton();
        }
    }

    public void initView() {
        setContentView(ResUtils.layout(getApplicationContext(), "wallet_cashdesk_authorize_sign_activity"));
        this.b = (AuthorizeInfoView) findViewById(ResUtils.id(getApplicationContext(), "sign_info_view"));
        this.c = (OrderConfirmation) findViewById(ResUtils.id(getApplicationContext(), "sign_order_view"));
        this.d = (LinearLayout) findViewById(ResUtils.id(getApplicationContext(), "select_card_panel"));
        this.e = (NetImageView) findViewById(ResUtils.id(getApplicationContext(), "select_card_bank_logo"));
        this.f = (TextView) findViewById(ResUtils.id(getApplicationContext(), "select_card_bank_info"));
        this.g = (TextView) findViewById(ResUtils.id(getApplicationContext(), "select_card_txt"));
        this.h = (TextView) findViewById(ResUtils.id(getApplicationContext(), "select_card_need_detail"));
        this.f3607i = (WalletBaseButtonWithImage) findViewById(ResUtils.id(getApplicationContext(), "sign_next_btn"));
        this.j = (LinearLayout) findViewById(ResUtils.id(getApplicationContext(), "sign_hint_panel"));
        this.k = (TextView) findViewById(ResUtils.id(getApplicationContext(), "sign_hint_txt"));
        this.l = (LinearLayout) findViewById(ResUtils.id(getApplicationContext(), "sign_protocol_panel"));
        this.m = (CheckBox) findViewById(ResUtils.id(getApplicationContext(), "sign_protocol_cb"));
        this.n = (TextView) findViewById(ResUtils.id(getApplicationContext(), "sign_protocol_txt"));
        this.c.getBackButton().setOnClickListener(this);
        this.r = findViewById(ResUtils.id(getApplicationContext(), "statusbar_top"));
        e eVar = this.a;
        if (eVar != null) {
            int i2 = 0;
            this.b.setVisibility(eVar.d() ? 0 : 8);
            this.c.setVisibility(this.a.e() ? 0 : 8);
            this.j.setVisibility(this.a.f() ? 0 : 8);
            if (this.a.c()) {
                getBdActionBar().setVisibility(0);
            } else {
                getBdActionBar().setVisibility(8);
                setTop();
            }
            BdActionBar bdActionBar = getBdActionBar();
            if (!this.a.c()) {
                i2 = 8;
            }
            bdActionBar.setVisibility(i2);
            this.a.a();
        }
    }

    public void onBackPressed() {
        WalletGlobalUtils.safeShowDialog(this, 18, "");
    }

    public void onClick(View view) {
        if (view.getId() == ResUtils.id(getApplicationContext(), "bd_wallet_id_base_order_back")) {
            onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFlagPaySdk();
        this.a = d.a().a(getIntent().getIntExtra(AUTH_SIGN_TYPE, 0), this);
        initView();
        EventBus.getInstance().registerSticky(this, "order_confirm_event_bus_key", 0, EventBus.ThreadMode.MainThread);
        StatHelper.statServiceEvent(PayStatServiceEvent.ENTER_AUTHORIZE_SIGN_ACTIVITY);
        refreshUI();
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getInstance().unregister((Object) this, "order_confirm_event_bus_key");
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event != null && "order_confirm_event_bus_key".equals(event.mEventKey)) {
            refreshUI();
        }
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        if (i2 == 18) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.setMessage((CharSequence) ResUtils.getString(this, "bd_wallet_auth_confirm_to_cancel"));
            promptDialog.setNegativeBtn(ResUtils.string(this, "dxm_ebpay_cancel"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(AuthorizeSignActivity.this, 18);
                }
            });
            promptDialog.setPositiveBtn(ResUtils.string(this, "bd_wallet_auth_cancel_auth"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_CANCEL);
                    WalletGlobalUtils.safeDismissDialog(AuthorizeSignActivity.this, 18);
                    PayCallBackManager.callBackClientCancel(AuthorizeSignActivity.this, "AuthorizeActivity.onPrepareDialog().1");
                    AuthorizeSignActivity.this.finishWithoutAnim();
                }
            });
            return;
        }
        super.onPrepareDialog(i2, dialog);
    }

    public void refreshUI() {
        e eVar = this.a;
        if (eVar != null) {
            eVar.b();
        }
    }

    public void setProtocolPlatformInfo(final GetCardInfoResponse.ProtocolPlatformInfo protocolPlatformInfo) {
        final DirectPayContentResponse payResponse = getPayResponse();
        if (protocolPlatformInfo == null || TextUtils.isEmpty(protocolPlatformInfo.prefix) || TextUtils.isEmpty(protocolPlatformInfo.main_title)) {
            this.l.setVisibility(8);
            return;
        }
        this.m.setChecked(protocolPlatformInfo.isProtocolCheckedDefault());
        CheckBox checkBox = this.m;
        if (checkBox != null) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    String[] strArr = new String[1];
                    strArr[0] = z ? "0" : "1";
                    StatHelper.statServiceEvent("clickAgreeBtn", (Map<String, Object>) null, strArr);
                    AuthorizeSignActivity.this.a(z);
                }
            });
        }
        if (protocolPlatformInfo.ext_list == null && protocolPlatformInfo.list == null) {
            this.l.setVisibility(8);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int color = ResUtils.getColor(getActivity(), "wallet_base_font_868e9e");
        spannableStringBuilder.append(protocolPlatformInfo.prefix + " ");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, protocolPlatformInfo.prefix.length(), 33);
        spannableStringBuilder.append("《");
        spannableStringBuilder.append(protocolPlatformInfo.main_title);
        spannableStringBuilder.append("》");
        AnonymousClass7 r2 = new ClickableSpan() {
            public void onClick(View view) {
                UserData.UserModel userModel;
                String str;
                UserData.UserModel userModel2;
                String str2;
                UserData.UserModel userModel3;
                String str3;
                UserData.UserModel userModel4;
                String str4;
                if (!CheckUtils.isFastDoubleClick()) {
                    StatisticManager.onEvent("clickUserTerms");
                    Intent intent = new Intent(AuthorizeSignActivity.this.getActivity(), BindCardProtocolActivity.class);
                    intent.putExtra(BindCardProtocolActivity.PROTOCOL_DATA, protocolPlatformInfo);
                    DirectPayContentResponse directPayContentResponse = payResponse;
                    if (!(directPayContentResponse == null || (userModel4 = directPayContentResponse.user) == null || (str4 = userModel4.true_name) == null)) {
                        intent.putExtra("true_name", str4);
                    }
                    DirectPayContentResponse directPayContentResponse2 = payResponse;
                    if (!(directPayContentResponse2 == null || (userModel3 = directPayContentResponse2.user) == null || (str3 = userModel3.certificate_type) == null)) {
                        intent.putExtra(BindCardProtocolActivity.IDENTITY_TYPE, str3);
                    }
                    DirectPayContentResponse directPayContentResponse3 = payResponse;
                    if (!(directPayContentResponse3 == null || (userModel2 = directPayContentResponse3.user) == null || (str2 = userModel2.certificate_code) == null)) {
                        intent.putExtra("identity_code", str2);
                    }
                    DirectPayContentResponse directPayContentResponse4 = payResponse;
                    if (!(directPayContentResponse4 == null || (userModel = directPayContentResponse4.user) == null || (str = userModel.mobile) == null)) {
                        intent.putExtra("mobile", str);
                    }
                    if (!(AuthorizeSignActivity.this.q == null || AuthorizeSignActivity.this.q.account_no == null)) {
                        intent.putExtra("card_no", AuthorizeSignActivity.this.q.account_no);
                    }
                    if (!(AuthorizeSignActivity.this.q == null || AuthorizeSignActivity.this.q.bank_code == null)) {
                        intent.putExtra(BindCardProtocolActivity.BANK_CODE, AuthorizeSignActivity.this.q.bank_code);
                    }
                    AuthorizeSignActivity.this.startActivityWithoutAnim(intent);
                }
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(ResUtils.getColor(AuthorizeSignActivity.this.getActivity(), "dxm_wallet_base_color_clickable"));
            }
        };
        spannableStringBuilder.setSpan(new BackgroundColorSpan(-1), protocolPlatformInfo.prefix.length(), spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(r2, protocolPlatformInfo.prefix.length(), spannableStringBuilder.length(), 33);
        this.n.setEnabled(true);
        this.n.setMovementMethod(LinkMovementMethod.getInstance());
        this.n.setHintTextColor(-1);
        this.n.setText(spannableStringBuilder);
        String str = (TextUtils.isEmpty(protocolPlatformInfo.main_title) || (!protocolPlatformInfo.main_title.endsWith("协议") && !protocolPlatformInfo.main_title.endsWith("协议》"))) ? "协议详情" : "详情";
        TextView textView = this.n;
        textView.setContentDescription("查看" + protocolPlatformInfo.main_title + str);
    }

    public void setSelectCardListener(View.OnClickListener onClickListener) {
        LinearLayout linearLayout = this.d;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(onClickListener);
        }
    }

    public void setTop() {
        if (Build.VERSION.SDK_INT >= 19) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.r.getLayoutParams());
            layoutParams.height = StatusBarUtils.getStatusBarHeight(this.mAct);
            this.r.setLayoutParams(layoutParams);
            ImmersiveStatusBarManager.setTopBar(this.mAct.getActivity(), this.r, this.mAct.isStatusbarTextColorBlack());
        }
    }

    public void updateDiscountTitle(String str) {
        this.c.setTitle(str);
    }

    public void updateDiscountTxt(boolean z, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, View.OnClickListener onClickListener) {
        this.c.setDiscountInfoVisiable(z);
        this.c.setOrderPrice(charSequence5, charSequence2);
        this.c.setCouponInfo(charSequence3, charSequence4, onClickListener);
        this.c.setOrderInfo(charSequence);
        this.c.setSpNameValue(PayDataCache.getInstance().getSpName());
    }

    public void updateHintText(String str) {
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void updateNextButton() {
        e eVar = this.a;
        int g2 = eVar != null ? eVar.g() : 0;
        if (g2 == 1) {
            this.f3607i.setText(ResUtils.getString(getApplicationContext(), "wallet_base_next_step"));
            this.f3607i.setDrawableLeftVisible(false);
        } else if (g2 == 2) {
            this.f3607i.setText(ResUtils.getString(getApplicationContext(), "ebpay_use_newcard_topay"));
            this.f3607i.setDrawableLeftVisible(false);
        } else if (g2 == 3) {
            this.f3607i.setText(ResUtils.getString(getApplicationContext(), "bd_wallet_auth_submit_sign"));
            this.f3607i.setDrawableLeftVisible(true);
        } else if (g2 != 4) {
            this.f3607i.setText(ResUtils.getString(getApplicationContext(), "wallet_base_next_step"));
            this.f3607i.setDrawableLeftVisible(false);
        } else {
            this.f3607i.setText(ResUtils.getString(getApplicationContext(), "bd_wallet_auth_newcard_submit_sign"));
            this.f3607i.setDrawableLeftVisible(true);
        }
        a(this.m.isChecked());
    }

    public void updateProtocolFields() {
        DirectPayContentResponse payResponse = getPayResponse();
        if (payResponse == null) {
            this.l.setVisibility(8);
            return;
        }
        this.l.setVisibility(0);
        GetCardInfoResponse.ProtocolPlatformInfo protocolPlatformInfo = payResponse.protocol_platform_info;
        if (protocolPlatformInfo != null) {
            setProtocolPlatformInfo(protocolPlatformInfo);
            return;
        }
        Authorize.AgreementInfo agreementInfo = payResponse.authorize.agreement_info;
        if (agreementInfo != null) {
            a((GetCardInfoResponse.ProtocolInfo) agreementInfo);
        } else {
            this.l.setVisibility(8);
        }
    }

    public void updateSelBankInfo(CardData.BondCard bondCard) {
        if (bondCard == null || !"1".equals(bondCard.card_state)) {
            this.g.setText(ResUtils.string(getActivity(), "ebpay_has_no_avaible_pay_type"));
        } else {
            PayRequest payRequest = getPayRequest();
            this.q = bondCard;
            if (payRequest != null) {
                payRequest.mBondCard = bondCard;
            }
            this.g.setText(bondCard.getCardDesc(this.mAct, true));
            if (!TextUtils.isEmpty(bondCard.bank_card_msg)) {
                this.h.setVisibility(0);
                this.h.setText(bondCard.bank_card_msg);
            } else {
                this.h.setVisibility(4);
            }
        }
        this.f.setText(ResUtils.getString(getApplicationContext(), "bd_wallet_auth_primary_pay_method"));
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.f3607i.setEnabled(true);
        } else {
            this.f3607i.setEnabled(false);
        }
    }

    private void a() {
        if (this.g != null) {
            Drawable drawable = ResUtils.getDrawable(getActivity(), "dxm_wallet_base_indicator_arrow");
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.g.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            this.g.setCompoundDrawablePadding(DisplayUtils.dip2px(getApplicationContext(), 5.0f));
        }
    }

    private void a(GetCardInfoResponse.ProtocolInfo protocolInfo) {
        Authorize authorize;
        DirectPayContentResponse payResponse = getPayResponse();
        if (payResponse == null || (authorize = payResponse.authorize) == null || authorize.agreement_info == null) {
            this.l.setVisibility(8);
            return;
        }
        this.l.setVisibility(0);
        CheckBox checkBox = this.m;
        if (checkBox != null) {
            checkBox.setChecked(protocolInfo.isProtocolCheckedDefault());
            this.m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    String[] strArr = new String[1];
                    strArr[0] = z ? "0" : "1";
                    StatHelper.statServiceEvent("clickAgreeBtn", (Map<String, Object>) null, strArr);
                    AuthorizeSignActivity.this.a(z);
                }
            });
        }
        if (this.n != null) {
            ArrayList arrayList = new ArrayList();
            GetCardInfoResponse.ProtocolItem[] protocolItemArr = protocolInfo.list;
            if (protocolItemArr != null) {
                for (GetCardInfoResponse.ProtocolItem protocolItem : protocolItemArr) {
                    if (!TextUtils.isEmpty(protocolItem.title)) {
                        arrayList.add(protocolItem);
                    }
                }
            }
            if (arrayList.size() > 0) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                int color = ResUtils.getColor(getActivity(), "dxm_wallet_text_gray");
                spannableStringBuilder.append(protocolInfo.prefix + " ");
                spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, protocolInfo.prefix.length(), 33);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    GetCardInfoResponse.ProtocolItem protocolItem2 = (GetCardInfoResponse.ProtocolItem) arrayList.get(i2);
                    if (i2 != 0) {
                        String str = protocolInfo.separator;
                        if (i2 == arrayList.size() - 1) {
                            str = protocolInfo.last_separator;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            spannableStringBuilder.append(str);
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), spannableStringBuilder.length() - str.length(), spannableStringBuilder.length(), 33);
                        }
                    }
                    spannableStringBuilder.append(protocolItem2.title);
                    if (!TextUtils.isEmpty(protocolItem2.url)) {
                        final String str2 = protocolItem2.url;
                        final String replaceAll = protocolItem2.title.replaceAll("<|>|《|》", "");
                        spannableStringBuilder.setSpan(new ClickableSpan() {
                            public void onClick(View view) {
                                StatisticManager.onEvent("clickUserTerms");
                                Intent intent = new Intent(AuthorizeSignActivity.this.getActivity(), WebViewActivity.class);
                                intent.putExtra("jump_url", str2);
                                intent.putExtra("webview_title_string", replaceAll);
                                AuthorizeSignActivity.this.startActivity(intent);
                            }

                            public void updateDrawState(TextPaint textPaint) {
                                textPaint.setColor(ResUtils.getColor(AuthorizeSignActivity.this.getActivity(), "dxm_wallet_base_mainColor"));
                            }
                        }, spannableStringBuilder.length() - protocolItem2.title.length(), spannableStringBuilder.length(), 33);
                    } else {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), spannableStringBuilder.length() - protocolItem2.title.length(), spannableStringBuilder.length(), 33);
                    }
                }
                this.n.setEnabled(true);
                this.n.setMovementMethod(LinkMovementMethod.getInstance());
                this.n.setText(spannableStringBuilder);
                return;
            }
            this.n.setVisibility(8);
            this.l.setVisibility(8);
            return;
        }
        this.l.setVisibility(8);
    }
}
