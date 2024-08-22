package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.ui.widget.compliance.DxmShowDateActivity;
import com.baidu.wallet.paysdk.ui.widget.compliance.b.b;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.DivisionEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.textfilter.BlankCharEditTextPasteFilter;
import com.dxmpay.wallet.base.widget.textfilter.IDCardEditTextPasteFilter;
import com.dxmpay.wallet.base.widget.textfilter.IEditTextPasteFilter;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Calendar;
import java.util.List;

@SuppressLint({"NewApi"})
public class BankUserInfoView extends LinearLayout implements View.OnClickListener {
    public View a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public LinearLayout g;
    public LinearLayout h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f3629i;
    public CheckBox j;
    public TextView k;
    public TextView l;
    public TextView m;
    public View mIdArea;
    public SafeKeyBoardEditText mIdCard;
    public View mMobileArea;
    public DivisionEditText mMobilePhone;
    public View mNameArea;
    public SafeKeyBoardEditText mTrueName;
    public TextView n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f3630o;
    public TextView p;
    public TextView q;
    public ImageView r;
    public ImageView s;
    public ImageView t;
    public BankCardErrorMsgView u;
    public BankCardErrorMsgView v;
    public BankCardErrorMsgView w;
    public boolean x;
    public boolean y;

    public interface a {
        void a();

        void b();
    }

    public BankUserInfoView(Context context) {
        super(context);
        a();
    }

    public void clearEditMsg() {
        this.mTrueName.setText("");
        this.mIdCard.setText("");
        this.mMobilePhone.setText("");
        this.k.setText("");
        this.l.setText("");
        this.n.setText("");
    }

    public void configMaginTop(int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(0, i2, 0, 0);
        setLayoutParams(layoutParams);
    }

    public String getEndDateTip() {
        if (this.b.getVisibility() != 0) {
            return null;
        }
        if (this.f3629i.getVisibility() == 0) {
            if (this.j.isChecked()) {
                return ResUtils.getString(getContext(), "ebpay_id_card_long_date_tip");
            }
            if (!TextUtils.isEmpty(this.l.getText())) {
                return this.l.getText().toString();
            }
            return null;
        } else if (!TextUtils.isEmpty(this.l.getText())) {
            return this.l.getText().toString();
        } else {
            return null;
        }
    }

    public String getGenderTip() {
        if (this.d.getVisibility() != 0 || TextUtils.isEmpty(this.n.getText())) {
            return null;
        }
        return ResUtils.getString(getContext(), "ebpay_man_tip").equals(this.n.getText().toString()) ? "1" : "2";
    }

    public boolean getIdCardFromNet() {
        return this.y;
    }

    public SafeKeyBoardEditText getIdEditText() {
        return this.mIdCard;
    }

    public ImageView getIdTip() {
        return this.s;
    }

    public DivisionEditText getMobileEditText() {
        return this.mMobilePhone;
    }

    public boolean getMobileFromNet() {
        return this.x;
    }

    public ImageView getMobileTip() {
        return this.t;
    }

    public ImageView getNameTip() {
        return this.r;
    }

    public String getNationalityTip() {
        if (this.c.getVisibility() != 0 || TextUtils.isEmpty(this.m.getText())) {
            return null;
        }
        return this.m.getText().toString();
    }

    public String getStartDateTip() {
        if (this.a.getVisibility() != 0 || TextUtils.isEmpty(this.k.getText())) {
            return null;
        }
        return this.k.getText().toString();
    }

    public SafeKeyBoardEditText getTrueNameText() {
        return this.mTrueName;
    }

    public void hideAllComplianceView() {
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        this.k.setText((CharSequence) null);
        this.l.setText((CharSequence) null);
        this.n.setText((CharSequence) null);
    }

    public void hideArea(boolean z, boolean z2, boolean z3) {
        int i2 = 8;
        this.mIdArea.setVisibility(z2 ? 8 : 0);
        this.mMobileArea.setVisibility(z3 ? 8 : 0);
        View view = this.mNameArea;
        if (!z) {
            i2 = 0;
        }
        view.setVisibility(i2);
    }

    public void hideErrorLayout() {
        BankCardErrorMsgView bankCardErrorMsgView = this.u;
        if (bankCardErrorMsgView != null) {
            bankCardErrorMsgView.showErrorLayout("", "");
            a.a(this.mTrueName, false, false);
        }
        BankCardErrorMsgView bankCardErrorMsgView2 = this.v;
        if (bankCardErrorMsgView2 != null) {
            bankCardErrorMsgView2.showErrorLayout("", "");
            a.a(this.mIdCard, false, false);
        }
        BankCardErrorMsgView bankCardErrorMsgView3 = this.w;
        if (bankCardErrorMsgView3 != null) {
            bankCardErrorMsgView3.showErrorLayout("", "");
            a.a(this.mMobilePhone, false, false);
        }
    }

    public void hideErrorLayoutWithTag(View view, boolean z) {
        BankCardErrorMsgView bankCardErrorMsgView;
        if (view == this.mTrueName) {
            bankCardErrorMsgView = this.u;
        } else if (view == this.mIdCard) {
            bankCardErrorMsgView = this.v;
        } else {
            bankCardErrorMsgView = view == this.mMobilePhone ? this.w : null;
        }
        if (bankCardErrorMsgView != null) {
            bankCardErrorMsgView.showErrorLayout("", "");
            a.a(view, false, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance().getUserInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isCheckMobileValidate() {
        /*
            r2 = this;
            com.dxmpay.wallet.base.widget.DivisionEditText r0 = r2.mMobilePhone
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x002a
            com.baidu.wallet.paysdk.storage.PayDataCache r0 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()
            com.dxmpay.wallet.base.datamodel.UserData$UserModel r0 = r0.getUserInfo()
            if (r0 == 0) goto L_0x002a
            java.lang.String r1 = r0.mobile_number
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x002a
            com.dxmpay.wallet.base.widget.DivisionEditText r1 = r2.mMobilePhone
            java.lang.String r1 = r1.getRealText()
            java.lang.String r0 = r0.mobile_number
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x002a
            r0 = 0
            return r0
        L_0x002a:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.ui.widget.BankUserInfoView.isCheckMobileValidate():boolean");
    }

    public void onClick(View view) {
    }

    public void setCertificateCanClick(boolean z) {
        if (!this.mIdCard.isEnabled()) {
            this.q.setBackgroundDrawable((Drawable) null);
            this.q.setEnabled(false);
        } else if (z) {
            Drawable drawable = ResUtils.getDrawable(getContext(), "dxm_right_arrow");
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.q.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            this.q.setEnabled(true);
            this.q.setContentDescription(ResUtils.getString(getContext(), "wallet_access_select_passport_des"));
        } else {
            this.q.setBackgroundDrawable((Drawable) null);
            this.q.setEnabled(false);
        }
    }

    public void setGenderStatus(boolean z) {
        if (z) {
            this.d.setVisibility(0);
            b();
            return;
        }
        this.d.setVisibility(8);
    }

    public void setGenderTxt(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.n.setText(str);
        }
    }

    public void setIdCardEndDateStatus(final BaseActivity baseActivity, boolean z, boolean z2, final a aVar) {
        if (z) {
            this.b.setVisibility(0);
            b();
            if (z2) {
                this.f3629i.setVisibility(0);
                this.l.setHint(ResUtils.getString(getContext(), "ebpay_id_card_end_date_long_hint"));
                this.f3629i.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.PAY_CLICK_LONG_DATE);
                        BankUserInfoView.this.j.setChecked(!BankUserInfoView.this.j.isChecked());
                        BankUserInfoView.this.l.setText((CharSequence) null);
                        a aVar = aVar;
                        if (aVar != null) {
                            aVar.b();
                        }
                    }
                });
                this.j.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.PAY_CLICK_LONG_DATE);
                        if (BankUserInfoView.this.j.isChecked()) {
                            BankUserInfoView.this.l.setText((CharSequence) null);
                        }
                        a aVar = aVar;
                        if (aVar != null) {
                            aVar.b();
                        }
                    }
                });
            } else {
                this.l.setHint(ResUtils.getString(getContext(), "ebpay_id_card_end_date_hint"));
                this.f3629i.setVisibility(8);
            }
            this.h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    StatHelper.statServiceEvent(PayStatServiceEvent.PAY_CLICK_END_DATE);
                    Calendar instance = Calendar.getInstance();
                    int i2 = Calendar.getInstance().get(1);
                    int i3 = Calendar.getInstance().get(2);
                    int i4 = Calendar.getInstance().get(5);
                    instance.set(i2, i3, i4);
                    Calendar instance2 = Calendar.getInstance();
                    instance2.set(i2 + 20, i3, i4);
                    com.baidu.wallet.paysdk.ui.widget.compliance.d.a.a().a(baseActivity, instance, instance2, new b() {
                        public void a(int i2, String str) {
                            if (i2 == 0 && !TextUtils.isEmpty(str)) {
                                BankUserInfoView.this.l.setText(str);
                                BankUserInfoView.this.j.setChecked(false);
                            }
                            a aVar = aVar;
                            if (aVar != null) {
                                aVar.b();
                            }
                        }
                    });
                }
            });
            return;
        }
        this.b.setVisibility(8);
    }

    public void setIdCardFromNet(boolean z) {
        this.y = z;
    }

    public void setIdCardStartDateStatus(final BaseActivity baseActivity, boolean z, final a aVar) {
        if (z) {
            this.a.setVisibility(0);
            b();
            this.g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    StatHelper.statServiceEvent(PayStatServiceEvent.PAY_CLICK_START_DATE);
                    Calendar instance = Calendar.getInstance();
                    int i2 = Calendar.getInstance().get(1);
                    int i3 = Calendar.getInstance().get(2);
                    int i4 = Calendar.getInstance().get(5);
                    instance.set(DxmShowDateActivity.START_YEAR, 0, 1);
                    Calendar instance2 = Calendar.getInstance();
                    instance2.set(i2, i3, i4);
                    com.baidu.wallet.paysdk.ui.widget.compliance.d.a.a().a(baseActivity, instance, instance2, new b() {
                        public void a(int i2, String str) {
                            if (i2 == 0 && !TextUtils.isEmpty(str)) {
                                BankUserInfoView.this.k.setText(str);
                            }
                            a aVar = aVar;
                            if (aVar != null) {
                                aVar.a();
                            }
                        }
                    });
                }
            });
            return;
        }
        this.a.setVisibility(8);
    }

    public void setIdInputAreaStatus(com.baidu.wallet.paysdk.datamodel.a aVar) {
        if (getVisibility() != 0 || this.mIdArea.getVisibility() != 0 || aVar == null) {
            this.mIdCard.setEnabled(true);
        } else if ("2".equals(aVar.b())) {
            this.y = false;
            this.mIdCard.setEnabled(false);
            this.mIdCard.setText(aVar.a());
            this.y = true;
        } else if ("3".equals(aVar.b())) {
            this.y = false;
            this.mIdCard.setEnabled(true);
            this.mIdCard.setText(aVar.a());
            if (!TextUtils.isEmpty(aVar.a())) {
                this.y = true;
            }
        } else {
            this.mIdCard.setEnabled(true);
            this.mIdCard.setText("");
        }
    }

    public void setIdTipRedColor(boolean z) {
        TextView textView = this.q;
        if (textView == null) {
            return;
        }
        if (z) {
            textView.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_font_text6Color"));
        } else {
            textView.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_font_text2Color"));
        }
    }

    public void setMobileInputAreaStatus(com.baidu.wallet.paysdk.datamodel.a aVar) {
        if (getVisibility() == 0 && this.mMobileArea.getVisibility() == 0 && aVar != null) {
            if ("2".equals(aVar.b())) {
                this.x = false;
                this.mMobilePhone.setEnabled(false);
                this.mMobilePhone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(13)});
                this.mMobilePhone.setText(StringUtils.maskingPhoneNumber(aVar.a()));
                this.x = true;
            }
            if ("3".equals(aVar.b())) {
                this.x = false;
                this.mMobilePhone.setEnabled(true);
                this.mMobilePhone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(13)});
                this.mMobilePhone.setText(StringUtils.maskingPhoneNumber(aVar.a()));
                if (!TextUtils.isEmpty(aVar.a())) {
                    this.x = true;
                }
            }
        }
    }

    public void setMobileRedColor(boolean z) {
        TextView textView = this.p;
        if (textView == null) {
            return;
        }
        if (z) {
            textView.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_font_text6Color"));
        } else {
            textView.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_font_text2Color"));
        }
    }

    public void setMoblieFromNet(boolean z) {
        this.x = z;
    }

    public void setNationalityStatus(boolean z) {
        if (z) {
            this.c.setVisibility(0);
            b();
            return;
        }
        this.c.setVisibility(8);
    }

    public void setOnCodeTypeClickListener(View.OnClickListener onClickListener) {
        this.q.setOnClickListener(onClickListener);
    }

    public void setTipClick(View.OnClickListener onClickListener) {
        this.t.setOnClickListener(onClickListener);
        this.r.setOnClickListener(onClickListener);
        this.s.setOnClickListener(onClickListener);
    }

    public void setTrueNameRedColor(boolean z) {
        TextView textView = this.f3630o;
        if (textView == null) {
            return;
        }
        if (z) {
            textView.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_font_text6Color"));
        } else {
            textView.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_font_text2Color"));
        }
    }

    public void showErrorLayout(String str, String str2, View view) {
        BankCardErrorMsgView bankCardErrorMsgView;
        if (view == this.mTrueName) {
            bankCardErrorMsgView = this.u;
        } else if (view == this.mIdCard) {
            bankCardErrorMsgView = this.v;
        } else {
            bankCardErrorMsgView = view == this.mMobilePhone ? this.w : null;
        }
        if (bankCardErrorMsgView != null) {
            bankCardErrorMsgView.showErrorLayout(str, str2);
            bankCardErrorMsgView.setTag(view);
            a.a(view, true, false);
        }
    }

    public void updateCertificateType(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
        if (certificateTypeInfo != null) {
            this.q.setText(certificateTypeInfo.description);
            if ("1".equals(certificateTypeInfo.type)) {
                List<IEditTextPasteFilter> editTextPasteFilters = this.mIdCard.getEditTextPasteFilters();
                if (editTextPasteFilters != null) {
                    editTextPasteFilters.clear();
                    editTextPasteFilters.add(new IDCardEditTextPasteFilter());
                }
                this.mIdCard.setFilters(new InputFilter[]{new InputFilter.LengthFilter(18)});
                this.mIdCard.setUseSafeKeyBoard(true);
                this.mIdCard.setUseKeyX(true);
                return;
            }
            List<IEditTextPasteFilter> editTextPasteFilters2 = this.mIdCard.getEditTextPasteFilters();
            if (editTextPasteFilters2 != null) {
                editTextPasteFilters2.clear();
                editTextPasteFilters2.add(new BlankCharEditTextPasteFilter());
            }
            this.mIdCard.setFilters(new InputFilter[]{new InputFilter.LengthFilter(40)});
            this.mIdCard.setUseSafeKeyBoard(false);
            this.mIdCard.setUseKeyX(false);
        }
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_bind_card_userinfo_view"), this);
        this.mNameArea = findViewById(ResUtils.id(getContext(), "true_name_area"));
        this.mIdArea = findViewById(ResUtils.id(getContext(), "id_card_area"));
        this.mMobileArea = findViewById(ResUtils.id(getContext(), "mobile_phone_area"));
        this.a = findViewById(ResUtils.id(getContext(), "lin_id_card_start_date_area"));
        this.b = findViewById(ResUtils.id(getContext(), "lin_id_card_end_date_area"));
        this.c = findViewById(ResUtils.id(getContext(), "lin_nationality_area"));
        this.d = findViewById(ResUtils.id(getContext(), "lin_gender_area"));
        this.g = (LinearLayout) findViewById(ResUtils.id(getContext(), "lin_start_date"));
        this.h = (LinearLayout) findViewById(ResUtils.id(getContext(), "lin_end_date"));
        this.f3629i = (LinearLayout) findViewById(ResUtils.id(getContext(), "lin_id_card_long_date_area"));
        this.j = (CheckBox) findViewById(ResUtils.id(getContext(), "cb_id_card_long_date"));
        this.e = findViewById(ResUtils.id(getContext(), "blank_area"));
        this.f = findViewById(ResUtils.id(getContext(), "compliance_line"));
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        this.f3629i.setVisibility(8);
        this.k = (TextView) findViewById(ResUtils.id(getContext(), "tv_id_card_start_date"));
        this.l = (TextView) findViewById(ResUtils.id(getContext(), "tv_id_card_end_date"));
        this.m = (TextView) findViewById(ResUtils.id(getContext(), "tv_nationality"));
        this.n = (TextView) findViewById(ResUtils.id(getContext(), "tv_gender"));
        this.f3630o = (TextView) findViewById(ResUtils.id(getContext(), "ebpay_true_name_tip"));
        SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) findViewById(ResUtils.id(getContext(), "ebpay_true_name_id"));
        this.mTrueName = safeKeyBoardEditText;
        safeKeyBoardEditText.setUseSafeKeyBoard(false);
        this.mTrueName.setUseKeyX(false);
        String string = ResUtils.getString(getContext(), "wallet_base_string_bindcard_item_line_tag");
        this.mTrueName.setTag(this.mNameArea.findViewWithTag(string));
        this.p = (TextView) findViewById(ResUtils.id(getContext(), "ebpay_phone_tip"));
        this.mMobilePhone = (DivisionEditText) findViewById(ResUtils.id(getContext(), "ebpay_mobile_phone_id"));
        this.mMobilePhone.setTag(this.mMobileArea.findViewWithTag(string));
        this.q = (TextView) findViewById(ResUtils.id(getContext(), "ebpay_id_card_tip"));
        this.mIdCard = (SafeKeyBoardEditText) findViewById(ResUtils.id(getContext(), "id_card"));
        this.mIdCard.setTag(this.mIdArea.findViewWithTag(string));
        this.r = (ImageView) findViewById(ResUtils.id(getContext(), "name_tip_img"));
        this.s = (ImageView) findViewById(ResUtils.id(getContext(), "id_tip_img"));
        this.mMobilePhone.setUseSafeKeyBoard(true);
        this.mMobilePhone.setViewType(13);
        this.mIdCard.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.mIdCard.setUseSafeKeyBoard(false);
        this.mIdCard.setUseKeyX(false);
        this.t = (ImageView) findViewById(ResUtils.id(getContext(), "phone_tip_img"));
        this.u = (BankCardErrorMsgView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_userinfo_error_name"));
        this.v = (BankCardErrorMsgView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_userinfo_error_idcard"));
        this.w = (BankCardErrorMsgView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_userinfo_error_mobile"));
        this.mIdCard.setMyHintTextSize("ebpay_bind_card_edittext_hint_txt_size");
        this.mMobilePhone.setMyHintTextSize("ebpay_bind_card_edittext_hint_txt_size");
        this.mTrueName.setMyHintTextSize("ebpay_bind_card_edittext_hint_txt_size");
    }

    private void b() {
        this.e.setVisibility(0);
        this.f.setVisibility(0);
    }

    public BankUserInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BankUserInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public void setIdInputAreaStatus(com.baidu.wallet.paysdk.datamodel.a aVar, boolean z) {
        if (getVisibility() != 0 || this.mIdArea.getVisibility() != 0 || aVar == null) {
            this.mIdCard.setEnabled(true);
        } else if ("2".equals(aVar.b())) {
            this.mIdCard.setEnabled(false);
        } else if ("3".equals(aVar.b())) {
            this.mIdCard.setEnabled(true);
        } else {
            this.mIdCard.setEnabled(true);
        }
    }
}
