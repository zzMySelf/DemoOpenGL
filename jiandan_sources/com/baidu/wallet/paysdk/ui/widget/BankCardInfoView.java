package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.ui.BindCardImplActivity;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.DivisionEditText;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Collection;
import java.util.HashMap;

@SuppressLint({"NewApi"})
public class BankCardInfoView extends LinearLayout {
    public TextView a;
    public DivisionEditText b;
    public boolean c = true;
    public BankCardErrorMsgView d;
    public TextView e;
    public View f;
    public ImageView g;
    public View h;

    /* renamed from: i  reason: collision with root package name */
    public String f3628i = null;
    public boolean j = false;

    public BankCardInfoView(Context context) {
        super(context);
        a();
    }

    public void ajustCompleteUi() {
        findViewById(ResUtils.id(getContext(), "line0")).setVisibility(0);
        findViewById(ResUtils.id(getContext(), "line2")).setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
    }

    public void configDetectCardNum(boolean z) {
        this.c = z;
        this.g.setImageResource(ResUtils.drawable(getContext(), z ? "dxm_wallet_base_camera_scan_btn_selector" : "dxm_wallet_base_delete"));
    }

    public DivisionEditText getCardNoView() {
        return this.b;
    }

    public View getClearView() {
        return this.g;
    }

    public String getScanCardNum() {
        return this.f3628i;
    }

    public View getTrueNameView() {
        return this.f;
    }

    public void hideErrorLayout() {
        BankCardErrorMsgView bankCardErrorMsgView = this.d;
        if (bankCardErrorMsgView != null) {
            bankCardErrorMsgView.showErrorLayout("", "");
            a.a(this.b, false, false);
        }
    }

    public void resetScanCardNum() {
        this.f3628i = null;
    }

    public void setBindcardTip(CharSequence charSequence) {
        if (this.a == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.a.setVisibility(8);
            return;
        }
        this.a.setVisibility(0);
        this.a.setText(charSequence);
    }

    public void setTipClick(View.OnClickListener onClickListener) {
        this.h.setOnClickListener(onClickListener);
    }

    public void setTipDel() {
        this.j = true;
        this.g.setImageResource(ResUtils.drawable(getContext(), "dxm_wallet_base_delete"));
        AccessibilityUtils.setContentDescription(this.g, "清除");
    }

    public void setTipScan() {
        this.j = false;
        this.g.setVisibility(0);
        if (this.c) {
            this.g.setImageResource(ResUtils.drawable(getContext(), "dxm_wallet_base_camera_scan_btn_selector"));
        } else if (!TextUtils.isEmpty(this.b.getRealText())) {
            this.g.setImageResource(ResUtils.drawable(getContext(), "dxm_wallet_base_delete"));
        } else {
            this.g.setVisibility(4);
        }
        AccessibilityUtils.setContentDescription(this.g, "扫描银行卡");
    }

    public void setTrueName(String str) {
        a(!TextUtils.isEmpty(str));
        if (!TextUtils.isEmpty(str)) {
            this.e.setText(str);
        }
    }

    public void showErrorLayout(String str) {
        BankCardErrorMsgView bankCardErrorMsgView = this.d;
        if (bankCardErrorMsgView != null) {
            bankCardErrorMsgView.showErrorLayout((CharSequence) null, str);
            this.d.setTag(this.b);
            a.a(this.b, true, false);
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(24)
    public boolean b() {
        if (Build.VERSION.SDK_INT < 24 || !(getContext() instanceof Activity) || !((Activity) getContext()).isInMultiWindowMode()) {
            return false;
        }
        GlobalUtils.toast(getContext(), ResUtils.getString(getContext(), "dxm_wallet_base_multi_window_close"), -1, 1);
        return true;
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_bind_cardinfo_view"), this);
        this.a = (TextView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_tip"));
        ImageView imageView = (ImageView) findViewById(ResUtils.id(getContext(), "card_clear"));
        this.g = imageView;
        AccessibilityUtils.setContentDescription(imageView, "扫描银行卡");
        this.f = findViewById(ResUtils.id(getContext(), "card_true_name_area"));
        this.e = (TextView) findViewById(ResUtils.id(getContext(), "card_true_name"));
        this.h = findViewById(ResUtils.id(getContext(), "card_name_tip_img"));
        View findViewById = findViewById(ResUtils.id(getContext(), "card_area"));
        DivisionEditText divisionEditText = (DivisionEditText) findViewById.findViewById(ResUtils.id(getContext(), "ebpay_card_no_id"));
        this.b = divisionEditText;
        divisionEditText.setUseSafeKeyBoard(true);
        this.b.setViewType(25);
        this.b.setTag(findViewById.findViewWithTag(ResUtils.getString(getContext(), "wallet_base_string_bindcard_item_line_tag")));
        this.d = (BankCardErrorMsgView) findViewById.findViewById(ResUtils.id(getContext(), "wallet_bindcard_cardinfo_error_card_no"));
        this.f3628i = null;
        ImageView imageView2 = this.g;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (BankCardInfoView.this.j) {
                        BankCardInfoView.this.b.setText("");
                    } else if (LocalRouter.getInstance(BankCardInfoView.this.getContext()).isProviderExisted("bankdetection") && BankCardInfoView.this.c && !BankCardInfoView.this.b()) {
                        LocalRouter.getInstance(BankCardInfoView.this.getContext()).route(BankCardInfoView.this.getContext(), new RouterRequest().provider("bankdetection").action("bankcarddetction"), new RouterCallback() {
                            public void onResult(int i2, HashMap hashMap) {
                                if (i2 == 0) {
                                    if (hashMap != null && !TextUtils.isEmpty((String) hashMap.get("card_num"))) {
                                        String unused = BankCardInfoView.this.f3628i = (String) hashMap.get("card_num");
                                        if (!BankCardInfoView.this.f3628i.equals(BankCardInfoView.this.b.getRealText())) {
                                            if (BankCardInfoView.this.getContext() instanceof BindCardImplActivity) {
                                                ((BindCardImplActivity) BankCardInfoView.this.getContext()).resetCardInfoState();
                                            }
                                            BankCardInfoView.this.b.setText(BankCardInfoView.this.f3628i);
                                            try {
                                                BankCardInfoView.this.b.setSelection(BankCardInfoView.this.b.getText().toString().length());
                                                BankCardInfoView.this.b.requestFocus();
                                            } catch (Exception unused2) {
                                            }
                                        }
                                    }
                                } else if (i2 == 5) {
                                    StatHelper.bankCardDetction(PayStatServiceEvent.BANKCARD_DETCTION_ERROR, i2 + "");
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put("provider", "bankdetection");
                                    hashMap2.put("action", "bankcarddetction");
                                    StatisticManager.onEventEndWithValues("sdk_router_error", i2, (Collection<String>) hashMap2.values());
                                } else {
                                    StatHelper.bankCardDetction(PayStatServiceEvent.BANKCARD_DETCTION_ERROR, i2 + "");
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public BankCardInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BankCardInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a(boolean z) {
        this.f.setVisibility(!z ? 8 : 0);
    }
}
