package com.baidu.sapi2.views.logindialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.aiscan.R;
import com.baidu.pass.view.CommonDialog;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.enums.LoginTypes;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ToastUtil;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
import com.baidu.sapi2.views.logindialog.callback.QuickLoginDialogCallback;
import com.baidu.sapi2.views.logindialog.enums.ColorType;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.IPagerLoadCallback;
import com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback;
import com.baidu.sapi2.views.logindialog.interf.ISendSmsCallback;
import com.baidu.sapi2.views.logindialog.page.LoginPager;
import com.baidu.sapi2.views.logindialog.page.SmsPager;
import com.baidu.sapi2.views.logindialog.utils.ViewUtils;
import com.baidu.sapi2.views.logindialog.view.LoadingView;
import com.baidu.sapi2.views.logindialog.view.NoScrollViewPager;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import java.util.ArrayList;
import java.util.List;

public class QuickLoginDialog extends Dialog implements View.OnClickListener, IPagerLoadCallback, ISendSmsCallback, IQuickLoginDialogCallback {
    public static final int HEIGHT_HISTORY = 256;
    public static final int HEIGHT_ONEKEY = 238;
    public static final int HEIGHT_SHARE = 256;
    public static final int HEIGHT_SMS = 181;
    public static final int HEIGHT_VERITFY_CODE = 181;
    public static final String STAG = "QuickLoginDialog";
    public Context a;
    public ColorType b;
    public LinearLayout c;
    public ImageView d;
    public TextView e;
    public ImageView f;
    public NoScrollViewPager g;
    public LoadingView h;

    /* renamed from: i  reason: collision with root package name */
    public LoginPager f972i;
    public SmsPager j;
    public List<Integer> k;
    public com.baidu.sapi2.views.logindialog.a.a l;
    public int m;
    public IQuickLoginDialogCallback n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f973o;

    public static class Builder implements NoProguard {
        public final Activity a;
        public ColorType b = ColorType.LIGHT;
        public QuickLoginDialogCallback c;
        public boolean d;

        public Builder(@NonNull Activity activity) {
            this.a = activity;
        }

        public QuickLoginDialog build() {
            return new QuickLoginDialog(this);
        }

        public Builder setCallbackSingle(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setColorType(ColorType colorType) {
            this.b = colorType;
            return this;
        }

        public Builder setDialogCallback(QuickLoginDialogCallback quickLoginDialogCallback) {
            this.c = quickLoginDialogCallback;
            return this;
        }
    }

    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            com.baidu.sapi2.views.logindialog.utils.a.c();
            if (QuickLoginDialog.this.n != null) {
                QuickLoginDialog.this.n.onDismiss();
            }
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        public void onPageScrollStateChanged(int i2) {
        }

        public void onPageScrolled(int i2, float f, int i3) {
        }

        public void onPageSelected(int i2) {
            if (i2 == 0) {
                QuickLoginDialog.this.d.setVisibility(8);
                QuickLoginDialog.this.e.setText("登录你的百度，精彩永相随");
                if (QuickLoginDialog.this.n != null) {
                    QuickLoginDialog.this.n.onPreShowDialog(QuickLoginDialog.this.b, QuickLoginDialog.this.c, QuickLoginDialog.this.e);
                }
            } else {
                QuickLoginDialog.this.d.setVisibility(0);
                QuickLoginDialog.this.e.setText("请输入短信验证码");
            }
            ViewGroup.LayoutParams layoutParams = QuickLoginDialog.this.g.getLayoutParams();
            layoutParams.height = ((Integer) QuickLoginDialog.this.k.get(i2)).intValue();
            QuickLoginDialog.this.g.setLayoutParams(layoutParams);
            int unused = QuickLoginDialog.this.m = i2;
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        public void onClick(View view) {
            QuickLoginDialog.this.openRegister(this.a);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
        }
    }

    public class e extends WebAuthListener {
        public e() {
        }

        public void onFailure(WebAuthResult webAuthResult) {
            ToastUtil.show("登录失败：" + webAuthResult.getResultMsg());
        }

        public void onSuccess(WebAuthResult webAuthResult) {
            if (QuickLoginDialog.this.n != null) {
                QuickLoginResult quickLoginResult = new QuickLoginResult();
                quickLoginResult.setResultCode(webAuthResult.getResultCode());
                quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                quickLoginResult.mLoginType = QuickLoginType.FULL_SCREEN;
                QuickLoginDialog.this.n.onLoginSuccess(quickLoginResult);
            }
            QuickLoginDialog.this.cancel();
        }
    }

    public class f extends WebAuthListener {
        public f() {
        }

        public void onFailure(WebAuthResult webAuthResult) {
            ToastUtil.show("注册失败：" + webAuthResult.getResultMsg());
        }

        public void onSuccess(WebAuthResult webAuthResult) {
            if (QuickLoginDialog.this.n != null) {
                QuickLoginResult quickLoginResult = new QuickLoginResult();
                quickLoginResult.setResultCode(webAuthResult.getResultCode());
                quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                quickLoginResult.mLoginType = QuickLoginType.REGISTER;
                QuickLoginDialog.this.n.onLoginSuccess(quickLoginResult);
            }
            QuickLoginDialog.this.cancel();
        }
    }

    public static /* synthetic */ class g {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.baidu.sapi2.views.logindialog.enums.QuickLoginType[] r0 = com.baidu.sapi2.views.logindialog.enums.QuickLoginType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.baidu.sapi2.views.logindialog.enums.QuickLoginType r1 = com.baidu.sapi2.views.logindialog.enums.QuickLoginType.HISTORY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.sapi2.views.logindialog.enums.QuickLoginType r1 = com.baidu.sapi2.views.logindialog.enums.QuickLoginType.SHARE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.sapi2.views.logindialog.enums.QuickLoginType r1 = com.baidu.sapi2.views.logindialog.enums.QuickLoginType.ONEKEY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.views.logindialog.QuickLoginDialog.g.<clinit>():void");
        }
    }

    public QuickLoginDialog(@NonNull Builder builder) {
        this(builder.a, builder);
    }

    public void cancel() {
        try {
            super.cancel();
        } catch (Exception e2) {
            Log.e(e2.getMessage(), new Object[0]);
        }
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e2) {
            Log.e(e2.getMessage(), new Object[0]);
        }
    }

    public void onChange2LoginPage() {
        this.j.a();
        this.g.setCurrentItem(0);
    }

    public void onChange2SmsPage(String str, int i2) {
        this.j.a(str, i2);
        this.j.c();
        this.g.setCurrentItem(1);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.sapi_sdk_close_view) {
            com.baidu.sapi2.views.logindialog.utils.a.a("close");
            cancel();
        } else if (view.getId() == R.id.sapi_sdk_back_view) {
            com.baidu.sapi2.views.logindialog.utils.a.a(com.alipay.sdk.m.x.d.u);
            onChange2LoginPage();
        }
    }

    public void onDismiss() {
    }

    public void onLoginFailure(QuickLoginResult quickLoginResult) {
        IQuickLoginDialogCallback iQuickLoginDialogCallback;
        boolean z = true;
        Log.e(STAG, "login result code : " + quickLoginResult.getResultCode() + ", result msg : " + quickLoginResult.getResultMsg());
        ToastUtil.show(quickLoginResult.getResultMsg());
        this.h.setVisibility(8);
        QuickLoginType quickLoginType = quickLoginResult.mLoginType;
        if (!(quickLoginType == QuickLoginType.HISTORY || quickLoginType == QuickLoginType.SHARE || quickLoginType == QuickLoginType.ONEKEY)) {
            z = false;
        }
        if (!z) {
            IQuickLoginDialogCallback iQuickLoginDialogCallback2 = this.n;
            if (iQuickLoginDialogCallback2 != null) {
                iQuickLoginDialogCallback2.onLoginFailure(quickLoginResult);
                return;
            }
            return;
        }
        if (!this.f973o && (iQuickLoginDialogCallback = this.n) != null) {
            iQuickLoginDialogCallback.onLoginFailure(quickLoginResult);
        }
        openScreenLogin(quickLoginResult.mLoginType, "");
    }

    public void onLoginSuccess(QuickLoginResult quickLoginResult) {
        if (TextUtils.isEmpty(quickLoginResult.mOperator)) {
            com.baidu.sapi2.views.logindialog.utils.a.a("0", quickLoginResult.mLoginType);
        } else {
            com.baidu.sapi2.views.logindialog.utils.a.a("0", quickLoginResult.mLoginType.getValue() + "_" + quickLoginResult.mOperator.toLowerCase());
        }
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.n;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onLoginSuccess(quickLoginResult);
        }
        this.h.setVisibility(8);
        Log.e(STAG, "login result code : " + quickLoginResult.getResultCode() + ", result msg : " + quickLoginResult.getResultMsg());
        cancel();
    }

    public void onPageLoading() {
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.n;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onPreShowLoading(this.b, this.h);
        }
        this.h.setVisibility(0);
    }

    public void onPageShow(int i2) {
        int dp2px = ViewUtils.dp2px(this.a, (float) i2);
        if (this.k.isEmpty()) {
            a(i2);
        } else {
            this.k.set(0, Integer.valueOf(dp2px));
        }
        ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
        layoutParams.height = dp2px;
        this.g.setLayoutParams(layoutParams);
        this.h.setVisibility(8);
    }

    public void onPreShowAgreement(TextView textView, SpannableStringBuilder spannableStringBuilder) {
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.n;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onPreShowAgreement(textView, spannableStringBuilder);
        }
    }

    public void onPreShowAgreementWithOperator(TextView textView, String str, SpannableStringBuilder spannableStringBuilder) {
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.n;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onPreShowAgreementWithOperator(textView, str, spannableStringBuilder);
        }
    }

    public void onPreShowDialog(ColorType colorType, LinearLayout linearLayout, TextView textView) {
    }

    public void onPreShowLoading(ColorType colorType, LoadingView loadingView) {
    }

    public void onPreShowLogin(ColorType colorType, QuickLoginType quickLoginType, TextView textView) {
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.n;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onPreShowLogin(colorType, quickLoginType, textView);
        }
    }

    public void onSendSmsFailure(String str, GetDynamicPwdResult getDynamicPwdResult) {
        int resultCode = getDynamicPwdResult.getResultCode();
        if (resultCode == 4) {
            int i2 = this.m;
            if (i2 == 0) {
                this.f972i.showSendMsgErrorTip(getDynamicPwdResult.getResultMsg());
            } else if (i2 == 1) {
                this.j.c(getDynamicPwdResult.getResultMsg());
            }
        } else if (resultCode == 5) {
            openScreenLogin((QuickLoginType) null, str);
        } else if (resultCode != 12) {
            ToastUtil.show("发送短信失败：" + getDynamicPwdResult.getResultMsg());
            openScreenLogin((QuickLoginType) null, str);
        } else {
            a(str);
        }
    }

    public void onSendSmsSuccess(boolean z, String str, GetDynamicPwdResult getDynamicPwdResult) {
        int i2 = this.m;
        if (i2 == 0) {
            this.f972i.hideSendMsgErrorTip();
        } else if (i2 == 1) {
            this.j.b();
        }
        onChange2SmsPage(str, getDynamicPwdResult.smsCodeLength);
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (a(getContext(), motionEvent) && motionEvent.getAction() == 1) {
            com.baidu.sapi2.views.logindialog.utils.a.a(QueryResponse.Options.CANCEL);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void openRegister(String str) {
        WebRegDTO webRegDTO = new WebRegDTO();
        webRegDTO.regType = WebRegDTO.EXTRA_REGISTER_MOBILE;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("loginUserName", str));
        webRegDTO.extraParams.addAll(arrayList);
        CoreViewRouter.getInstance().startRegister(new f(), webRegDTO);
    }

    public void openScreenLogin(QuickLoginType quickLoginType, String str) {
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.config = null;
        if (quickLoginType != null) {
            int i2 = g.a[quickLoginType.ordinal()];
            if (i2 == 1) {
                webLoginDTO.excludeTypes = LoginTypes.HISTORY;
            } else if (i2 == 2) {
                webLoginDTO.excludeTypes = LoginTypes.SHARE;
            } else if (i2 == 3) {
                webLoginDTO.excludeTypes = LoginTypes.ONE_KEY_LOGIN;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            webLoginDTO.preSetUname = str;
        }
        CoreViewRouter.getInstance().startLogin(new e(), webLoginDTO);
    }

    @Deprecated
    public void setOnCancelListener(@Nullable DialogInterface.OnCancelListener onCancelListener) {
    }

    @Deprecated
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
    }

    public void show() {
        if (Build.VERSION.SDK_INT >= 17) {
            Context context = this.a;
            if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
                return;
            }
        }
        try {
            super.show();
        } catch (Exception e2) {
            Log.e(e2.getMessage(), new Object[0]);
        }
    }

    public QuickLoginDialog(@NonNull Context context, @NonNull Builder builder) {
        this(context, R.style.sapi_sdk_bottom_in_dialog, builder);
    }

    private void b() {
        setContentView(R.layout.layout_sapi_dialog_quick_login);
        getWindow().setSoftInputMode(16);
        Window window = getWindow();
        window.setGravity(83);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.c = (LinearLayout) findViewById(R.id.sapi_sdk_ll_dialog_content);
        this.d = (ImageView) findViewById(R.id.sapi_sdk_back_view);
        this.e = (TextView) findViewById(R.id.sapi_sdk_tv_title_view);
        this.f = (ImageView) findViewById(R.id.sapi_sdk_close_view);
        this.h = (LoadingView) findViewById(R.id.sapi_sdk_login_dialog_loadingview);
        this.g = (NoScrollViewPager) findViewById(R.id.sapi_sdk_login_dialog_viewpager);
        this.d.setOnClickListener(this);
        this.f.setOnClickListener(this);
        c();
        if (this.k.isEmpty()) {
            a(181);
        }
        a();
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.n;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onPreShowDialog(this.b, this.c, this.e);
        }
    }

    private void c() {
        this.g.setScanScroll(false);
        ArrayList arrayList = new ArrayList();
        LoginPager loginPager = new LoginPager(this.a, this.b, this, this, this);
        this.f972i = loginPager;
        arrayList.add(loginPager);
        SmsPager smsPager = new SmsPager(this.a, this.b, this, this, this);
        this.j = smsPager;
        arrayList.add(smsPager);
        com.baidu.sapi2.views.logindialog.a.a aVar = new com.baidu.sapi2.views.logindialog.a.a(arrayList);
        this.l = aVar;
        this.g.setAdapter(aVar);
        this.g.addOnPageChangeListener(new b());
    }

    public QuickLoginDialog(@NonNull Context context, int i2, @NonNull Builder builder) {
        super(context, i2);
        this.k = new ArrayList();
        this.a = context;
        this.b = builder.b;
        this.n = builder.c;
        this.f973o = builder.d;
        b();
        super.setOnDismissListener(new a());
    }

    private void a(int i2) {
        this.k.add(0, Integer.valueOf(ViewUtils.dp2px(this.a, (float) i2)));
        this.k.add(1, Integer.valueOf(ViewUtils.dp2px(this.a, 181.0f)));
    }

    private void a(String str) {
        CommonDialog.qw qwVar = new CommonDialog.qw(this.a);
        qwVar.uk("提示");
        qwVar.rg("您的手机号还未注册，点击完成注册");
        qwVar.fe(ColorType.DARK == this.b);
        qwVar.th("取消", new d());
        qwVar.yj("去注册", new c(str));
        qwVar.de().show();
    }

    private void a() {
        if (ColorType.DARK == this.b) {
            this.c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_quick_login_dialog_bg_dark));
            this.e.setTextColor(Color.parseColor("#FFFFFF"));
            this.h.a();
        }
    }

    private boolean a(Context context, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int scaledWindowTouchSlop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        View decorView = getWindow().getDecorView();
        int i2 = -scaledWindowTouchSlop;
        return x < i2 || y < i2 || x > decorView.getWidth() + scaledWindowTouchSlop || y > decorView.getHeight() + scaledWindowTouchSlop;
    }
}
