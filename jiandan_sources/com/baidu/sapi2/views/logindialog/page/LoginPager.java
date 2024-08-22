package com.baidu.sapi2.views.logindialog.page;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.aiscan.R;
import com.baidu.pass.view.CommonDialog;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.ShareModelResultCallback;
import com.baidu.sapi2.callback.inner.LoginHistoryCallback;
import com.baidu.sapi2.common.LoginHistoryModel;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.logindialog.QuickLoginDialog;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
import com.baidu.sapi2.views.logindialog.enums.ColorType;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback;
import com.baidu.sapi2.views.logindialog.interf.IPagerLoadCallback;
import com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback;
import com.baidu.sapi2.views.logindialog.interf.ISendSmsCallback;
import com.baidu.sapi2.views.logindialog.interf.ISendSmsUICallback;
import com.baidu.sapi2.views.logindialog.utils.ViewUtils;
import com.baidu.sapi2.views.logindialog.view.AgreementView;
import com.baidu.sapi2.views.logindialog.view.HistoryLoginView;
import com.baidu.sapi2.views.logindialog.view.OneKeyLoginView;
import com.baidu.sapi2.views.logindialog.view.SendSmsView;
import com.baidu.sapi2.views.logindialog.view.ShareLoginView;
import com.baidu.sapi2.views.logindialog.view.ThirdPartyView;
import java.util.List;
import org.json.JSONArray;

public class LoginPager extends LinearLayout implements ILoginConfirmCallback, ISendSmsUICallback {
    public Context a;
    public ColorType b;
    public OneKeyLoginView c;
    public ShareLoginView d;
    public HistoryLoginView e;
    public SendSmsView f;
    public ThirdPartyView g;
    public AgreementView h;

    /* renamed from: i  reason: collision with root package name */
    public IQuickLoginDialogCallback f974i;
    public IPagerLoadCallback j;
    public ISendSmsCallback k;
    public JSONArray l;
    public int m;
    public final long n;

    /* renamed from: o  reason: collision with root package name */
    public String f975o;

    public class a implements ShareModelResultCallback {
        public a() {
        }

        public void onFailure(int i2, String str) {
            Log.e("sss", str);
            LoginPager loginPager = LoginPager.this;
            loginPager.a(loginPager.a(LoginPager.a(loginPager)));
        }

        public void onSuccess(List<ShareStorage.StorageModel> list) {
            Log.e("sss", "互通数据有效");
            LoginPager.this.b(list);
        }
    }

    public class b extends OneKeyLoginCallback {
        public b() {
        }

        public void available(OneKeyLoginResult oneKeyLoginResult) {
            Log.e(QuickLoginDialog.STAG, "one key login is available, enable = " + oneKeyLoginResult.enable + ", hasHistory is " + oneKeyLoginResult.hasHistory + ", encryptPhoneNum is " + oneKeyLoginResult.encryptPhoneNum);
            LoginPager.this.a(oneKeyLoginResult);
        }

        public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
            Log.e(QuickLoginDialog.STAG, "one key login is unAvailable, code is " + oneKeyLoginResult.getResultCode() + ", msg is " + oneKeyLoginResult.getResultMsg());
            LoginPager.this.a(oneKeyLoginResult);
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ Runnable a;

        public c(Runnable runnable) {
            this.a = runnable;
        }

        public void onClick(View view) {
            this.a.run();
            LoginPager.this.h.a();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
        }
    }

    public static /* synthetic */ class e {
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
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.views.logindialog.page.LoginPager.e.<clinit>():void");
        }
    }

    public LoginPager(@NonNull Context context, ColorType colorType, IQuickLoginDialogCallback iQuickLoginDialogCallback, IPagerLoadCallback iPagerLoadCallback, ISendSmsCallback iSendSmsCallback) {
        super(context);
        this.a = context;
        this.b = colorType;
        this.f974i = iQuickLoginDialogCallback;
        this.j = iPagerLoadCallback;
        this.k = iSendSmsCallback;
        c();
        IPagerLoadCallback iPagerLoadCallback2 = this.j;
        if (iPagerLoadCallback2 != null) {
            iPagerLoadCallback2.onPageLoading();
        }
        try {
            this.l = SapiContext.getInstance().getSapiOptions().getDialogLoginPriority(SapiAccountManager.getInstance().getConfignation().tpl);
        } catch (Exception e2) {
            Log.e(QuickLoginDialog.STAG, "get dialog config error:" + e2.getMessage());
        }
        if (this.l == null) {
            this.l = a();
        }
        a(a(this.m));
        this.n = System.currentTimeMillis();
    }

    private void c() {
        LayoutInflater.from(this.a).inflate(R.layout.layout_sapi_dialog_login_pager, this);
        this.c = (OneKeyLoginView) findViewById(R.id.sapi_sdk_login_dialog_onekeyloginview);
        this.d = (ShareLoginView) findViewById(R.id.sapi_sdk_login_dialog_shareloginview);
        this.e = (HistoryLoginView) findViewById(R.id.sapi_sdk_login_dialog_historyloginview);
        this.f = (SendSmsView) findViewById(R.id.sapi_sdk_login_dialog_sendsmsview);
        this.g = (ThirdPartyView) findViewById(R.id.sapi_sdk_login_dialog_thirdpartyview);
        this.h = (AgreementView) findViewById(R.id.sapi_sdk_login_dialog_agreementview);
        this.g.setLoginCallback(this);
        this.h.a((Activity) this.a, this.f974i);
        b();
    }

    private void d() {
        SapiAccountManager.getInstance().checkAvailableLoginHistory(new LoginHistoryCallback() {
            public void onFailure() {
                LoginPager loginPager = LoginPager.this;
                loginPager.a(loginPager.a(LoginPager.a(loginPager)));
            }

            public void onResult(JSONArray jSONArray) {
                super.onResult(jSONArray);
            }

            public void onSuccess(List<LoginHistoryModel> list) {
                LoginPager.this.a(list);
            }
        });
    }

    private void e() {
        SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new b());
    }

    private void f() {
        SapiAccountManager.getInstance().getShareModels((long) ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS, (ShareModelResultCallback) new a());
    }

    private void g() {
        IPagerLoadCallback iPagerLoadCallback = this.j;
        if (iPagerLoadCallback != null) {
            iPagerLoadCallback.onPageShow(181);
        }
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.f974i;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onPreShowLogin(this.b, QuickLoginType.SMS, this.f.getTvSendSms());
        }
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.f.setVisibility(0);
        this.f.a((Activity) this.a);
        this.g.c();
        this.g.setDialogLoginType(QuickLoginType.SMS);
        this.f.a(this, this.k, this);
        com.baidu.sapi2.views.logindialog.utils.a.a(System.currentTimeMillis() - this.n, QuickLoginType.SMS);
    }

    public void hideSendMsgErrorTip() {
        SendSmsView sendSmsView = this.f;
        if (sendSmsView != null) {
            sendSmsView.b();
        }
        AgreementView agreementView = this.h;
        if (agreementView != null) {
            agreementView.setPadding(0, ViewUtils.dp2px(this.a, 25.0f), 0, 0);
        }
    }

    public void onFailure(QuickLoginResult quickLoginResult) {
        Log.e(QuickLoginDialog.STAG, "login fail,login type = " + quickLoginResult.mLoginType + ",result code = " + quickLoginResult.getResultCode());
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.f974i;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onLoginFailure(quickLoginResult);
        }
    }

    public void onHideErrorTip() {
        hideSendMsgErrorTip();
    }

    public void onHideThirdParty() {
        this.g.setVisibility(8);
    }

    public void onPostLogin(boolean z, Runnable runnable) {
        IPagerLoadCallback iPagerLoadCallback;
        AgreementView agreementView = this.h;
        if (agreementView == null) {
            Log.e(QuickLoginDialog.STAG, "mAgreementView is null");
        } else if (!agreementView.c()) {
            Log.e(QuickLoginDialog.STAG, "thirdLogin privacy is not agree");
            a(runnable);
        } else {
            if (z && (iPagerLoadCallback = this.j) != null) {
                iPagerLoadCallback.onPageLoading();
            }
            runnable.run();
        }
    }

    public void onShowThirdParty() {
        this.g.setVisibility(0);
    }

    public void onSuccess(QuickLoginResult quickLoginResult) {
        Log.e(QuickLoginDialog.STAG, "login success,login type = " + quickLoginResult.mLoginType);
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.f974i;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onLoginSuccess(quickLoginResult);
        }
    }

    public void showSendMsgErrorTip(String str) {
        SendSmsView sendSmsView = this.f;
        if (sendSmsView != null) {
            sendSmsView.a(str);
        }
        AgreementView agreementView = this.h;
        if (agreementView != null) {
            agreementView.setPadding(0, 13, 0, 0);
        }
    }

    public static /* synthetic */ int a(LoginPager loginPager) {
        int i2 = loginPager.m + 1;
        loginPager.m = i2;
        return i2;
    }

    private void b() {
        if (this.b == ColorType.DARK) {
            this.c.a();
            this.d.a();
            this.e.a();
            this.f.a();
            this.g.a();
            this.h.b();
        }
    }

    private JSONArray a() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(QuickLoginType.HISTORY.getValue());
        jSONArray.put(QuickLoginType.SHARE.getValue());
        jSONArray.put(QuickLoginType.ONEKEY.getValue());
        jSONArray.put(QuickLoginType.SMS.getValue());
        return jSONArray;
    }

    /* access modifiers changed from: private */
    public void b(List<ShareStorage.StorageModel> list) {
        if (list == null || list.size() == 0) {
            int i2 = this.m + 1;
            this.m = i2;
            a(a(i2));
            return;
        }
        ShareStorage.StorageModel storageModel = list.get(0);
        if (storageModel == null) {
            int i3 = this.m + 1;
            this.m = i3;
            a(a(i3));
            return;
        }
        Log.e(QuickLoginDialog.STAG, "share login is available, enable = " + list.size());
        a(storageModel);
    }

    /* access modifiers changed from: private */
    public QuickLoginType a(int i2) {
        if (i2 < 0 || i2 > this.l.length() - 1) {
            return QuickLoginType.SMS;
        }
        String optString = this.l.optString(i2);
        if (TextUtils.isEmpty(optString)) {
            return QuickLoginType.SMS;
        }
        return QuickLoginType.getViewLoginTypeByValue(optString);
    }

    /* access modifiers changed from: private */
    public void a(QuickLoginType quickLoginType) {
        int i2 = e.a[quickLoginType.ordinal()];
        if (i2 == 1) {
            d();
        } else if (i2 == 2) {
            f();
        } else if (i2 != 3) {
            g();
        } else {
            e();
        }
    }

    /* access modifiers changed from: private */
    public void a(List<LoginHistoryModel> list) {
        if (list == null || list.size() == 0) {
            int i2 = this.m + 1;
            this.m = i2;
            a(a(i2));
            return;
        }
        LoginHistoryModel loginHistoryModel = list.get(0);
        if (loginHistoryModel == null) {
            int i3 = this.m + 1;
            this.m = i3;
            a(a(i3));
            return;
        }
        Log.e(QuickLoginDialog.STAG, "history login is available, enable = " + list.size());
        a(loginHistoryModel);
    }

    private void a(LoginHistoryModel loginHistoryModel) {
        IPagerLoadCallback iPagerLoadCallback = this.j;
        if (iPagerLoadCallback != null) {
            iPagerLoadCallback.onPageShow(256);
        }
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.f974i;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onPreShowLogin(this.b, QuickLoginType.HISTORY, this.e.getTvButton());
        }
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        this.g.b();
        this.g.setDialogLoginType(QuickLoginType.HISTORY);
        this.e.a((Activity) this.a, loginHistoryModel, this);
        com.baidu.sapi2.views.logindialog.utils.a.a(System.currentTimeMillis() - this.n, QuickLoginType.HISTORY);
    }

    private void a(ShareStorage.StorageModel storageModel) {
        IPagerLoadCallback iPagerLoadCallback = this.j;
        if (iPagerLoadCallback != null) {
            iPagerLoadCallback.onPageShow(256);
        }
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.f974i;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onPreShowLogin(this.b, QuickLoginType.SHARE, this.d.getTvButton());
        }
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        this.e.setVisibility(8);
        this.g.b();
        this.g.setDialogLoginType(QuickLoginType.SHARE);
        this.d.a((Activity) this.a, storageModel, this);
        com.baidu.sapi2.views.logindialog.utils.a.a(System.currentTimeMillis() - this.n, QuickLoginType.SHARE);
    }

    /* access modifiers changed from: private */
    public void a(OneKeyLoginResult oneKeyLoginResult) {
        if (oneKeyLoginResult == null || !oneKeyLoginResult.enable) {
            int i2 = this.m + 1;
            this.m = i2;
            a(a(i2));
            return;
        }
        IPagerLoadCallback iPagerLoadCallback = this.j;
        if (iPagerLoadCallback != null) {
            iPagerLoadCallback.onPageShow(QuickLoginDialog.HEIGHT_ONEKEY);
        }
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.f974i;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onPreShowLogin(this.b, QuickLoginType.ONEKEY, this.c.getTvButton());
        }
        String str = oneKeyLoginResult.operator;
        this.f975o = str;
        AgreementView agreementView = this.h;
        if (agreementView != null) {
            agreementView.b(str);
        }
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.g.b();
        this.g.setDialogLoginType(QuickLoginType.ONEKEY);
        this.c.a(oneKeyLoginResult.encryptPhoneNum, oneKeyLoginResult.operator, this);
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(oneKeyLoginResult.operator)) {
            com.baidu.sapi2.views.logindialog.utils.a.a(currentTimeMillis - this.n, QuickLoginType.ONEKEY);
            return;
        }
        long j2 = currentTimeMillis - this.n;
        com.baidu.sapi2.views.logindialog.utils.a.a(j2, QuickLoginType.ONEKEY.getValue() + "_" + oneKeyLoginResult.operator.toLowerCase());
    }

    private void a(Runnable runnable) {
        CommonDialog.qw qwVar = new CommonDialog.qw(this.a);
        qwVar.uk("为了更好的使用服务\n登录前请阅读并同意以下协议");
        qwVar.rg(this.h.a(this.f975o));
        qwVar.fe(ColorType.DARK == this.b);
        qwVar.th("不同意", new d());
        qwVar.yj("同意并继续", new c(runnable));
        qwVar.de().show();
    }
}
