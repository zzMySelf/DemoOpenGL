package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.DarkModeUtil;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.Enums;
import com.tera.scan.app.R$styleable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SmsLoginView extends FrameLayout implements NoProguard {
    public static final String q = "extrajson";
    public static final String r = "sdk_situation";
    public static final String s = "pop_login";
    public static final String t = "skipreg";
    public static final int u = 6;
    public static String v;
    public Context a;
    public View b;
    public View c;
    public EditText d;
    public EditText e;
    public TextView f;
    public TextView g;
    public View h;

    /* renamed from: i  reason: collision with root package name */
    public View f964i;
    public Dialog j;
    public CountDownTimer k;
    public String l;
    public boolean m;
    public boolean n;

    /* renamed from: o  reason: collision with root package name */
    public PrivacyAgreementIntercept f965o;
    public SmsViewLoginCallback p;

    public class GetCheckCodeListener implements View.OnClickListener {

        public class a extends CountDownTimer {
            public a(long j, long j2) {
                super(j, j2);
            }

            public void onFinish() {
                if (SmsLoginView.this.d.getText().toString().length() == 11) {
                    SmsLoginView.this.f.setEnabled(true);
                    SmsLoginView.this.f.setText(R.string.sapi_sdk_sms_re_get_check_code);
                    SmsLoginView.this.a(true);
                    return;
                }
                SmsLoginView.this.f.setText(R.string.sapi_sdk_sms_get_check_code);
                SmsLoginView.this.a(false);
            }

            public void onTick(long j) {
                TextView a2 = SmsLoginView.this.f;
                a2.setText((j / 1000) + SmsLoginView.this.a.getString(R.string.sapi_sdk_sms_second));
                SmsLoginView.this.f.setEnabled(false);
                SmsLoginView.this.a(false);
            }
        }

        public GetCheckCodeListener() {
        }

        public void onClick(View view) {
            if ((SmsLoginView.this.f965o == null || SmsLoginView.this.f965o.across(1)) && SmsLoginView.this.d.getText().toString().length() == 11) {
                SmsLoginView smsLoginView = SmsLoginView.this;
                boolean unused = smsLoginView.m = smsLoginView.f.getText().toString().equals(SmsLoginView.this.a.getString(R.string.sapi_sdk_sms_get_check_code));
                SmsLoginView.this.g.setVisibility(8);
                SmsLoginView.this.g.setText("");
                SmsLoginView.this.e.requestFocus();
                CountDownTimer unused2 = SmsLoginView.this.k = new a(60000, 1000);
                SmsLoginView.this.k.start();
                SmsLoginView smsLoginView2 = SmsLoginView.this;
                String unused3 = smsLoginView2.l = smsLoginView2.d.getText().toString();
                String a2 = SmsLoginView.getSmsLoginStatExtra();
                HashMap hashMap = new HashMap();
                if (SapiUtils.statExtraValid(a2)) {
                    hashMap.put("extrajson", a2);
                }
                hashMap.put("sdk_situation", "pop_login");
                hashMap.put("skipreg", "1");
                SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new GetDynamicPwdCallback() {
                    public void onFinish() {
                    }

                    public void onStart() {
                    }

                    public void onCaptchaRequired(GetDynamicPwdResult getDynamicPwdResult) {
                        if (SmsLoginView.this.m) {
                            SmsLoginView.b(f.f, getDynamicPwdResult.getResultCode() + "");
                        } else {
                            SmsLoginView.b(f.f966i, getDynamicPwdResult.getResultCode() + "");
                        }
                        if (SmsLoginView.this.k != null) {
                            SmsLoginView.this.k.cancel();
                        }
                        WebAuthResult webAuthResult = new WebAuthResult();
                        webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
                        webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
                        SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.l;
                        SmsViewLoginCallback k = SmsLoginView.this.getSmsViewLoginCallback();
                        if (k != null) {
                            String unused = SmsLoginView.this.l = "";
                            k.onNeedBack(webAuthResult);
                        }
                    }

                    public void onFailure(GetDynamicPwdResult getDynamicPwdResult) {
                        if (SmsLoginView.this.m) {
                            SmsLoginView.b(f.f, getDynamicPwdResult.getResultCode() + "");
                            SmsLoginView.this.f.setText(R.string.sapi_sdk_sms_get_check_code);
                        } else {
                            SmsLoginView.b(f.f966i, getDynamicPwdResult.getResultCode() + "");
                            SmsLoginView.this.f.setText(R.string.sapi_sdk_sms_re_get_check_code);
                        }
                        if (SmsLoginView.this.k != null) {
                            SmsLoginView.this.k.cancel();
                        }
                        SmsLoginView.this.f.setEnabled(true);
                        SmsLoginView.this.a(true);
                        if (getDynamicPwdResult.noNeedBack) {
                            SmsLoginView.this.g.setText(getDynamicPwdResult.getResultMsg());
                            SmsLoginView.this.g.setVisibility(0);
                            return;
                        }
                        WebAuthResult webAuthResult = new WebAuthResult();
                        webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
                        webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
                        SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.l;
                        SmsViewLoginCallback k = SmsLoginView.this.getSmsViewLoginCallback();
                        if (k != null) {
                            String unused = SmsLoginView.this.l = "";
                            k.onNeedBack(webAuthResult);
                        }
                    }

                    public void onSuccess(GetDynamicPwdResult getDynamicPwdResult) {
                        if (SmsLoginView.this.m) {
                            SmsLoginView.b(f.e, (String) null);
                        } else {
                            SmsLoginView.b(f.h, (String) null);
                        }
                    }
                }, SmsLoginView.this.l, (String) null, hashMap);
                if (SmsLoginView.this.m) {
                    SmsLoginView.b(f.d, (String) null);
                } else {
                    SmsLoginView.b(f.g, (String) null);
                }
            }
        }

        public /* synthetic */ GetCheckCodeListener(SmsLoginView smsLoginView, a aVar) {
            this();
        }
    }

    public interface PrivacyAgreementIntercept extends NoProguard {
        public static final int LOGIN = 2;
        public static final int SNED_SMS = 1;

        boolean across(int i2);
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            SmsLoginView.this.e.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) SmsLoginView.this.a.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(SmsLoginView.this.d, 0);
            }
        }
    }

    public class b extends DynamicPwdLoginCallback {
        public b() {
        }

        /* renamed from: a */
        public void onFailure(DynamicPwdLoginResult dynamicPwdLoginResult) {
            SmsLoginView.b(f.l, dynamicPwdLoginResult.getResultCode() + "");
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.setResultCode(dynamicPwdLoginResult.getResultCode());
            webAuthResult.setResultMsg(dynamicPwdLoginResult.getResultMsg());
            if (dynamicPwdLoginResult.noNeedBack) {
                SmsLoginView.this.g.setText(dynamicPwdLoginResult.getResultMsg());
                SmsLoginView.this.g.setVisibility(0);
                SmsLoginView.this.e.setText("");
                SmsViewLoginCallback k = SmsLoginView.this.getSmsViewLoginCallback();
                if (k != null) {
                    k.onFailure(webAuthResult);
                    return;
                }
                return;
            }
            SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.l;
            SmsViewLoginCallback k2 = SmsLoginView.this.getSmsViewLoginCallback();
            if (k2 != null) {
                String unused = SmsLoginView.this.l = "";
                k2.onNeedBack(webAuthResult);
            }
        }

        /* renamed from: b */
        public void onSuccess(DynamicPwdLoginResult dynamicPwdLoginResult) {
            SmsLoginView.b(f.k, (String) null);
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.setResultCode(dynamicPwdLoginResult.getResultCode());
            webAuthResult.setResultMsg(dynamicPwdLoginResult.getResultMsg());
            webAuthResult.accountType = AccountType.NORMAL;
            SmsViewLoginCallback k = SmsLoginView.this.getSmsViewLoginCallback();
            if (k != null) {
                SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, SmsLoginView.this.l);
                SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.SMS.getName());
                k.onSuccess(webAuthResult);
            }
            new PtokenStat().onEvent(PtokenStat.LOGIN_POP);
        }

        public void onFinish() {
            SmsLoginView.this.b();
        }

        public void onStart() {
            SmsLoginView.this.c();
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            int length = charSequence.toString().length();
            if (length == 0) {
                SmsLoginView.this.e.setGravity(19);
            } else if (1 == length) {
                SmsLoginView.this.g.setText("");
                SmsLoginView.this.g.setVisibility(8);
                SmsLoginView.this.e.setGravity(17);
            } else if (length == SapiAccountManager.getInstance().getSmsCodeLength() && !TextUtils.isEmpty(SmsLoginView.this.l)) {
                SmsLoginView.this.d();
            }
        }

        public /* synthetic */ c(SmsLoginView smsLoginView, a aVar) {
            this();
        }
    }

    public class d extends Dialog {
        public d(Context context) {
            super(context, R.style.sapi_sdk_empty_dialog);
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            setContentView(new TextView(context));
            getWindow().setFlags(131072, 131072);
        }
    }

    public class e implements TextWatcher {
        public e() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            int length = charSequence.toString().length();
            if (length == 0) {
                SmsViewLoginCallback k = SmsLoginView.this.getSmsViewLoginCallback();
                if (k != null) {
                    k.onCheckCodeViewHide();
                }
                SmsLoginView.this.c.setVisibility(8);
                SmsLoginView.this.g.setVisibility(8);
                SmsLoginView.this.g.setText("");
                SmsLoginView.this.d.setGravity(19);
            } else if (SmsLoginView.this.c.getVisibility() != 0) {
                SmsViewLoginCallback k2 = SmsLoginView.this.getSmsViewLoginCallback();
                if (k2 != null) {
                    k2.onCheckCodeViewShow();
                }
                SmsLoginView.this.c.setVisibility(0);
                SmsLoginView.this.d.setGravity(17);
            }
            if (length == 10) {
                if (TextUtils.isEmpty(SmsLoginView.this.l)) {
                    SmsLoginView.this.f.setText(R.string.sapi_sdk_sms_get_check_code);
                    SmsLoginView.this.a(false);
                    SmsLoginView.this.g.setVisibility(8);
                    SmsLoginView.this.g.setText("");
                    SmsLoginView.this.f.setEnabled(false);
                }
            } else if (length == 11) {
                if (!SmsLoginView.this.d.getText().toString().equals(SmsLoginView.this.l)) {
                    if (SmsLoginView.this.k != null) {
                        SmsLoginView.this.k.cancel();
                    }
                    SmsLoginView.this.f.setText(R.string.sapi_sdk_sms_get_check_code);
                    SmsLoginView.this.a(true);
                    if (SapiUtils.validateMobile(charSequence.toString())) {
                        SmsLoginView.this.f.setEnabled(true);
                    } else {
                        SmsLoginView.this.g.setVisibility(0);
                        SmsLoginView.this.g.setText(R.string.sapi_sdk_sms_prompt_phone_number_error);
                    }
                }
                SmsLoginView.b(f.c, (String) null);
            }
        }

        public /* synthetic */ e(SmsLoginView smsLoginView, a aVar) {
            this();
        }
    }

    public interface f {
        public static final String a = "pop_login";
        public static final String b = "show";
        public static final String c = "input_phone";
        public static final String d = "first_get_dpass";
        public static final String e = "first_get_dpass_success";
        public static final String f = "first_get_dpass_failure";
        public static final String g = "get_dpass_again";
        public static final String h = "get_dpass_again_success";

        /* renamed from: i  reason: collision with root package name */
        public static final String f966i = "get_dpass_again_failure";
        public static final String j = "verify";
        public static final String k = "success";
        public static final String l = "failure";
    }

    public SmsLoginView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static String getSmsLoginStatExtra() {
        if (v == null) {
            v = CoreViewRouter.getInstance().getSmsLoginStatExtra();
        }
        return WebLoginDTO.getStatExtraDecode(v);
    }

    /* access modifiers changed from: private */
    public SmsViewLoginCallback getSmsViewLoginCallback() {
        if (this.p == null) {
            this.p = CoreViewRouter.getInstance().getSmsViewLoginCallback();
            CoreViewRouter.getInstance().releaseSmsViewLoginCallback();
        }
        return this.p;
    }

    public static void notifyStartLogin() {
        b(f.b, (String) null);
    }

    public void clean() {
        this.e.setText("");
        this.d.setText("");
        CountDownTimer countDownTimer = this.k;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f.setText(R.string.sapi_sdk_sms_get_check_code);
        a(false);
    }

    public void close() {
        CountDownTimer countDownTimer = this.k;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CoreViewRouter.getInstance().releaseWithoutAccountCenter();
    }

    public void setDarkMode(boolean z) {
        if (this.n == (!z)) {
            this.n = z;
            e();
            a(false);
        }
    }

    public void setSendVerificationCodeIntercept(PrivacyAgreementIntercept privacyAgreementIntercept) {
        this.f965o = privacyAgreementIntercept;
    }

    public void setSmsLoginStatExtra(String str) {
        v = str;
    }

    public void setSmsViewLoginCallback(SmsViewLoginCallback smsViewLoginCallback) {
        this.p = smsViewLoginCallback;
    }

    public void try2SmsLogin() {
        Editable text;
        EditText editText = this.e;
        if (editText != null && (text = editText.getText()) != null && text.toString().length() >= 6) {
            PrivacyAgreementIntercept privacyAgreementIntercept = this.f965o;
            if (privacyAgreementIntercept == null || privacyAgreementIntercept.across(2)) {
                d();
            }
        }
    }

    public SmsLoginView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    /* access modifiers changed from: private */
    public void c() {
        this.f964i.setVisibility(0);
        d dVar = new d(this.a);
        this.j = dVar;
        dVar.show();
    }

    /* access modifiers changed from: private */
    public void d() {
        PrivacyAgreementIntercept privacyAgreementIntercept = this.f965o;
        if (privacyAgreementIntercept == null || privacyAgreementIntercept.across(2)) {
            String obj = this.e.getText().toString();
            String smsLoginStatExtra = getSmsLoginStatExtra();
            HashMap hashMap = new HashMap();
            if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
                hashMap.put("extrajson", smsLoginStatExtra);
            }
            hashMap.put("sdk_situation", "pop_login");
            SapiAccountManager.getInstance().getAccountService().dynamicPwdLogin((DynamicPwdLoginCallback) new b(), this.l, obj, (Map<String, String>) hashMap);
            b(f.j, (String) null);
        }
    }

    private void e() {
        if (this.n) {
            this.b.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_sms_bg_night_mode));
            this.d.setTextColor(getResources().getColor(R.color.sapi_sdk_sms_edit_phone_text_color_night_mode));
            this.d.setHintTextColor(getResources().getColor(R.color.sapi_sdk_sms_edit_hint_color_night_mode));
            this.e.setTextColor(getResources().getColor(R.color.sapi_sdk_sms_edit_check_code_text_color_night_mode));
            this.e.setHintTextColor(getResources().getColor(R.color.sapi_sdk_sms_edit_check_code_hint_text_color_night_mode));
            this.g.setTextColor(getResources().getColor(R.color.sapi_sdk_sms_prompt_phone_number_error_color_night_mode));
            this.h.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_separate_line_color_night_mode));
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.e, Integer.valueOf(R.drawable.sapi_sdk_input_edit_text_cursor_bg_night));
            } catch (Exception unused) {
            }
        } else {
            this.b.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_sms_bg_light_mode));
            this.d.setTextColor(getResources().getColor(R.color.sapi_sdk_sms_edit_phone_text_color));
            this.d.setHintTextColor(getResources().getColor(R.color.sapi_sdk_sms_edit_hint_color));
            this.e.setTextColor(getResources().getColor(R.color.sapi_sdk_sms_edit_check_code_text_color));
            this.e.setHintTextColor(getResources().getColor(R.color.sapi_sdk_sms_edit_check_code_hint_text_color));
            this.g.setTextColor(getResources().getColor(R.color.sapi_sdk_sms_prompt_phone_number_error_color));
            this.h.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_separate_line_color));
            Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField2.setAccessible(true);
            declaredField2.set(this.e, Integer.valueOf(R.drawable.sapi_sdk_input_edit_text_cursor_bg));
        }
        a(false);
    }

    public SmsLoginView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        boolean z = true;
        this.m = true;
        this.a = context;
        this.b = LayoutInflater.from(context).inflate(R.layout.layout_sapi_sdk_sms_login_view, this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.sapi_sdk_sms_login_view, i2, 0);
        boolean z2 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        this.c = this.b.findViewById(R.id.code_container);
        this.d = (EditText) this.b.findViewById(R.id.phone);
        this.f964i = this.b.findViewById(R.id.loading_container);
        this.e = (EditText) this.b.findViewById(R.id.check_code);
        this.f = (TextView) this.b.findViewById(R.id.get_code);
        this.g = (TextView) this.b.findViewById(R.id.prompt);
        this.h = this.b.findViewById(R.id.separate_line);
        a(this.d, context.getString(R.string.sapi_sdk_sms_hint_input_phone));
        a(this.e, context.getString(R.string.sapi_sdk_sms_hint_input_check_code));
        this.d.addTextChangedListener(new e(this, (a) null));
        this.e.addTextChangedListener(new c(this, (a) null));
        this.f.setEnabled(false);
        this.f.setOnClickListener(new GetCheckCodeListener(this, (a) null));
        if (SapiAccountManager.getInstance().getSapiConfiguration() != null) {
            if (!SapiAccountManager.getInstance().getSapiConfiguration().isNightMode && !DarkModeUtil.isDarkMode(context)) {
                z = false;
            }
            this.n = z;
        } else {
            this.n = false;
        }
        e();
        if (z2) {
            new Handler().postDelayed(new a(), 100);
        }
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        if (sapiConfiguration != null) {
            ViewUtility.enlargedViews(this.d, sapiConfiguration.textZoom);
            ViewUtility.enlargedViews(this.e, sapiConfiguration.textZoom);
            ViewUtility.enlargedViews(this.f, (sapiConfiguration.textZoom * 100) / 120);
            ViewUtility.enlargedOtherView(this.f, (sapiConfiguration.textZoom * 100) / 120);
            ViewUtility.enlargedViews(this.g, sapiConfiguration.textZoom);
        }
        if (SapiUtils.getLastLoginType() == Enums.LastLoginType.SMS.getValue()) {
            String decryptStr = SapiContext.getInstance().getDecryptStr(SapiContext.KEY_LAST_LOGIN_PHONE);
            if (!TextUtils.isEmpty(decryptStr) && decryptStr.length() == 11) {
                this.d.setText(decryptStr);
                this.d.setSelection(decryptStr.length());
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        this.f964i.setVisibility(8);
        try {
            this.j.dismiss();
        } catch (Throwable unused) {
        }
    }

    public static void b(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(2);
        linkedHashMap.put("pop_login", str);
        HashMap hashMap = new HashMap(1);
        hashMap.put("extrajson", getSmsLoginStatExtra());
        hashMap.put("errno", str2);
        StatService.onEventAutoStatistic(linkedHashMap, hashMap);
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        int i2;
        getResources().getColor(R.color.sapi_sdk_sms_get_code_text_color);
        int i3 = -1;
        if (this.n) {
            i3 = getResources().getColor(R.color.sapi_sdk_sms_bg_night_mode);
            if (z) {
                i2 = getResources().getColor(R.color.sapi_sdk_sms_get_code_text_color_night_mode);
            } else {
                i2 = getResources().getColor(R.color.sapi_sdk_sms_get_code_disable_color_night_mode);
            }
        } else if (z) {
            i2 = getResources().getColor(R.color.sapi_sdk_sms_get_code_text_color);
        } else {
            i2 = getResources().getColor(R.color.sapi_sdk_sms_get_code_disable_color);
        }
        GradientDrawable gradientDrawable = (GradientDrawable) this.f.getBackground();
        gradientDrawable.setStroke(SapiUtils.dip2px(getContext(), 0.5f), i2);
        gradientDrawable.setColor(i3);
        this.f.setTextColor(i2);
    }

    private void a(EditText editText, String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(18, true), 0, spannableString.length(), 33);
        editText.setHint(new SpannedString(spannableString));
    }
}
