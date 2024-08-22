package com.baidu.sapi2.views.logindialog.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.aiscan.R;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback;
import com.baidu.sapi2.views.logindialog.utils.ViewUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgreementView extends LinearLayout implements View.OnClickListener {

    /* renamed from: i  reason: collision with root package name */
    public static final String f980i = "百度用户协议";
    public static final String j = "https://wappass.baidu.com/passport/agreement?adapter=3";
    public static final String k = "隐私政策";
    public static final String l = "https://wappass.baidu.com/passport/agreement?personal=1&adapter=3";
    public static final String m = "儿童个人信息保护声明";
    public static final String n = "https://privacy.baidu.com/policy/children-privacy-policy/index.html";

    /* renamed from: o  reason: collision with root package name */
    public static final String f981o = "中国移动认证服务条款";
    public static final String p = "https://wap.cmpassport.com/resources/html/contract.html";
    public static final String q = "中国联通认证服务协议";
    public static final String r = "https://ms.zzx9.cn/html/oauth/protocol2.html";
    public static final String s = "中国电信天翼账号服务条款";
    public static final String t = "https://e.189.cn/sdk/agreement/show.do?order=2&type=main&appKey=&hidetop=true&returnUrl=";
    public static final String u = "阅读并同意百度用户协议 隐私政策 和 儿童个人信息保护声明";
    public static final String v = "阅读并同意百度用户协议 隐私政策";
    public Context a;
    public Activity b;
    public TextView c;
    public ImageView d;
    public boolean e;
    public boolean f;
    public SpannableStringBuilder g;
    public IQuickLoginDialogCallback h;

    public class a extends ClickableSpan {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        public void onClick(@NonNull View view) {
            com.baidu.sapi2.views.logindialog.utils.a.a(this.a);
            AgreementView.this.a(this.b, this.c);
        }

        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(true);
            textPaint.setColor(Color.parseColor("#858585"));
        }
    }

    public AgreementView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void d() {
        Drawable drawable;
        boolean booleanValue = SapiContext.getInstance().getSapiOptions().getIsProtocolCheck(SapiAccountManager.getInstance().getConfignation().tpl).booleanValue();
        this.e = booleanValue;
        ImageView imageView = this.d;
        if (booleanValue) {
            drawable = this.a.getResources().getDrawable(R.drawable.sapi_sdk_icon_quick_login_dialog_selector_checked);
        } else {
            drawable = this.a.getResources().getDrawable(R.drawable.sapi_sdk_icon_quick_login_dialog_selector_narmol);
        }
        imageView.setBackgroundDrawable(drawable);
    }

    private void e() {
        LayoutInflater.from(this.a).inflate(R.layout.layout_sapi_dialog_quick_login_agreement, this);
        setPadding(0, ViewUtils.dp2px(this.a, 25.0f), 0, 0);
        this.c = (TextView) findViewById(R.id.sapi_sdk_tv_login_dialog_agreement);
        ImageView imageView = (ImageView) findViewById(R.id.sapi_sdk_iv_login_dialog_agreement_selector);
        this.d = imageView;
        imageView.setOnClickListener(this);
        boolean isShowChildrenAgreement = SapiContext.getInstance().getSapiOptions().getIsShowChildrenAgreement();
        this.f = isShowChildrenAgreement;
        if (isShowChildrenAgreement) {
            this.g = new SpannableStringBuilder(u);
        } else {
            this.g = new SpannableStringBuilder(v);
        }
        a(this.g, f980i, j, "user_agreement");
        a(this.g, k, l, "privacy_policy");
        if (this.f) {
            a(this.g, m, n, "children_agreement");
        }
        this.c.setText(this.g);
        this.d.setContentDescription(this.c.getText());
        this.c.setMovementMethod(LinkMovementMethod.getInstance());
        d();
    }

    public void a(Activity activity, IQuickLoginDialogCallback iQuickLoginDialogCallback) {
        this.b = activity;
        this.h = iQuickLoginDialogCallback;
        iQuickLoginDialogCallback.onPreShowAgreement(this.c, this.g);
    }

    public void b() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.String r8) {
        /*
            r7 = this;
            android.text.SpannableStringBuilder r0 = r7.g
            int r1 = r8.hashCode()
            r2 = 2
            r3 = 1
            r4 = 2154(0x86a, float:3.018E-42)
            if (r1 == r4) goto L_0x0029
            r4 = 2161(0x871, float:3.028E-42)
            if (r1 == r4) goto L_0x001f
            r4 = 2162(0x872, float:3.03E-42)
            if (r1 == r4) goto L_0x0015
            goto L_0x0033
        L_0x0015:
            java.lang.String r1 = "CU"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0033
            r1 = 1
            goto L_0x0034
        L_0x001f:
            java.lang.String r1 = "CT"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0033
            r1 = 2
            goto L_0x0034
        L_0x0029:
            java.lang.String r1 = "CM"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0033
            r1 = 0
            goto L_0x0034
        L_0x0033:
            r1 = -1
        L_0x0034:
            java.lang.String r4 = "中国电信天翼账号服务条款"
            java.lang.String r5 = "中国联通认证服务协议"
            java.lang.String r6 = "中国移动认证服务条款"
            if (r1 == 0) goto L_0x0047
            if (r1 == r3) goto L_0x0045
            if (r1 == r2) goto L_0x0043
            java.lang.String r1 = ""
            goto L_0x0048
        L_0x0043:
            r1 = r4
            goto L_0x0048
        L_0x0045:
            r1 = r5
            goto L_0x0048
        L_0x0047:
            r1 = r6
        L_0x0048:
            boolean r2 = r7.f
            if (r2 == 0) goto L_0x006b
            java.lang.String r2 = r0.toString()
            java.lang.String r3 = "和"
            int r2 = r2.indexOf(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = " "
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.insert(r2, r1)
            goto L_0x0074
        L_0x006b:
            java.lang.String r2 = " 和 "
            android.text.SpannableStringBuilder r2 = r0.append(r2)
            r2.append(r1)
        L_0x0074:
            java.lang.String r1 = "https://wap.cmpassport.com/resources/html/contract.html"
            java.lang.String r2 = "cmcc_agreement"
            r7.a(r0, r6, r1, r2)
            java.lang.String r1 = "https://ms.zzx9.cn/html/oauth/protocol2.html"
            java.lang.String r2 = "cucc_agreement"
            r7.a(r0, r5, r1, r2)
            java.lang.String r1 = "https://e.189.cn/sdk/agreement/show.do?order=2&type=main&appKey=&hidetop=true&returnUrl="
            java.lang.String r2 = "ctcc_agreement"
            r7.a(r0, r4, r1, r2)
            java.lang.String r1 = "隐私政策"
            java.lang.String r2 = "https://wappass.baidu.com/passport/agreement?personal=1&adapter=3"
            java.lang.String r3 = "privacy_policy"
            r7.a(r0, r1, r2, r3)
            android.widget.TextView r1 = r7.c
            r1.setText(r0)
            android.widget.ImageView r1 = r7.d
            android.widget.TextView r2 = r7.c
            java.lang.CharSequence r2 = r2.getText()
            r1.setContentDescription(r2)
            com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback r1 = r7.h
            android.widget.TextView r2 = r7.c
            r1.onPreShowAgreementWithOperator(r2, r8, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.views.logindialog.view.AgreementView.b(java.lang.String):void");
    }

    public boolean c() {
        TextView textView;
        if (!this.e && (textView = this.c) != null) {
            announceForAccessibility(textView.getText());
        }
        return this.e;
    }

    public void onClick(View view) {
        Drawable drawable;
        com.baidu.sapi2.views.logindialog.utils.a.a("select_agree");
        boolean z = !this.e;
        this.e = z;
        ImageView imageView = this.d;
        if (z) {
            drawable = this.a.getResources().getDrawable(R.drawable.sapi_sdk_icon_quick_login_dialog_selector_checked);
        } else {
            drawable = this.a.getResources().getDrawable(R.drawable.sapi_sdk_icon_quick_login_dialog_selector_narmol);
        }
        imageView.setBackgroundDrawable(drawable);
    }

    public AgreementView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AgreementView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f = true;
        this.a = context;
        e();
    }

    public void a(String str, String str2) {
        Activity activity = this.b;
        if (activity != null) {
            Intent intent = new Intent(activity, LoadExternalWebViewActivity.class);
            intent.putExtra("extra_external_title", str);
            intent.putExtra("extra_external_url", str2);
            this.b.startActivity(intent);
        }
    }

    public void a() {
        this.e = true;
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.sapi_sdk_icon_quick_login_dialog_selector_checked));
        }
    }

    public CharSequence a(String str) {
        this.f = SapiContext.getInstance().getSapiOptions().getIsShowChildrenAgreement();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str == null) {
            str = "";
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 2154) {
            if (hashCode != 2161) {
                if (hashCode == 2162 && str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC)) {
                    c2 = 1;
                }
            } else if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC)) {
                c2 = 2;
            }
        } else if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC)) {
            c2 = 0;
        }
        if (c2 == 0) {
            spannableStringBuilder.append(f980i).append(" 和 ").append(k).append(" 及 ").append(f981o).append(" 及 ").append(m);
        } else if (c2 == 1) {
            spannableStringBuilder.append(f980i).append(" 和 ").append(k).append(" 及 ").append(q).append(" 及 ").append(m);
        } else if (c2 != 2) {
            spannableStringBuilder.append(f980i).append(" 和 ").append(k).append(" 及 ").append(m);
        } else {
            spannableStringBuilder.append(f980i).append(" 和 ").append(k).append(" 及 ").append(s).append(" 及 ").append(m);
        }
        a(spannableStringBuilder, f980i, j, "user_agreement");
        a(spannableStringBuilder, k, l, "privacy_policy");
        a(spannableStringBuilder, m, n, "children_agreement");
        a(spannableStringBuilder, f981o, p, "cmcc_agreement");
        a(spannableStringBuilder, q, r, "cucc_agreement");
        a(spannableStringBuilder, s, t, "ctcc_agreement");
        return spannableStringBuilder;
    }

    private void a(SpannableStringBuilder spannableStringBuilder, String str, String str2, String str3) {
        Matcher matcher = Pattern.compile(str).matcher(spannableStringBuilder);
        while (matcher.find()) {
            spannableStringBuilder.setSpan(new a(str3, str, str2), matcher.start(), matcher.end(), 33);
        }
    }
}
