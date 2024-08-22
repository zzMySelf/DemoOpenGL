package fe.mmm.qw.qw;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.aiscan.R;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.GlobalCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.Switch;
import com.baidu.sapi2.views.logindialog.QuickLoginDialog;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
import com.baidu.sapi2.views.logindialog.callback.QuickLoginDialogCallback;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.Logger;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import fe.mmm.qw.e.rg;
import fe.mmm.qw.th.qw.th.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("account_tag")
public final class de extends ad {
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public static final de f8249fe = new de();

    public static final class ad extends GlobalCallback {
        public final /* synthetic */ Context qw;

        public ad(Context context) {
            this.qw = context;
        }

        public void onLoginStatusChange() {
            String str = null;
            LoggerKt.d$default("registerPassGlobalListeners onLoginStatusChange", (Object) null, 1, (Object) null);
            if (SapiAccountManager.getInstance().isLogin()) {
                SapiAccount session = SapiAccountManager.getInstance().getSession();
                String str2 = session != null ? session.uid : null;
                fe.mmm.qw.qw.rg.qw fe2 = de.f8249fe.fe();
                if (fe2 != null) {
                    str = fe2.uk();
                }
                if (!Intrinsics.areEqual((Object) str2, (Object) str)) {
                    de.f8249fe.mmm();
                }
            }
        }

        public void onNeedInitPassSdk() {
            LoggerKt.d$default("registerPassGlobalListeners onNeedInitPassSdk", (Object) null, 1, (Object) null);
            de.f8249fe.nn(this.qw);
        }
    }

    /* renamed from: fe.mmm.qw.qw.de$de  reason: collision with other inner class name */
    public static final class C0291de extends WebAuthListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f8250ad;

        public C0291de(Function1<? super Boolean, Unit> function1) {
            this.f8250ad = function1;
        }

        public void onFailure(@Nullable WebAuthResult webAuthResult) {
            o.rg(R.string.login_fail);
            StringBuilder sb = new StringBuilder();
            sb.append("登录失败，");
            sb.append(webAuthResult != null ? webAuthResult.getLoginType() : null);
            sb.append(", err:");
            sb.append(webAuthResult != null ? Integer.valueOf(webAuthResult.getResultCode()) : null);
            sb.append(", msg:");
            sb.append(webAuthResult != null ? webAuthResult.getResultMsg() : null);
            LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
        }

        public void onSuccess(@Nullable WebAuthResult webAuthResult) {
            if (SapiAccountManager.getInstance().getSession() == null) {
                o.rg(R.string.login_fail);
                LoggerKt.d$default("session 获取为null", (Object) null, 1, (Object) null);
                Function1<Boolean, Unit> function1 = this.f8250ad;
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                    return;
                }
                return;
            }
            de.f8249fe.mmm();
            rg.qw("7476", "aiscan", "display", "APPLoad", "APPLoadSuc", "");
            Function1<Boolean, Unit> function12 = this.f8250ad;
            if (function12 != null) {
                function12.invoke(Boolean.TRUE);
            }
        }
    }

    public static final class fe extends QuickLoginDialogCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f8251ad;

        public fe(Function1<? super Boolean, Unit> function1) {
            this.f8251ad = function1;
        }

        public void onLoginFailure(@Nullable QuickLoginResult quickLoginResult) {
            o.rg(R.string.login_fail);
            StringBuilder sb = new StringBuilder();
            sb.append("登录失败，");
            sb.append(quickLoginResult != null ? quickLoginResult.mLoginType : null);
            sb.append(", err:");
            sb.append(quickLoginResult != null ? Integer.valueOf(quickLoginResult.getResultCode()) : null);
            sb.append(", msg:");
            sb.append(quickLoginResult != null ? quickLoginResult.getResultMsg() : null);
            LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
        }

        public void onLoginSuccess(@Nullable QuickLoginResult quickLoginResult) {
            if (SapiAccountManager.getInstance().getSession() == null) {
                o.rg(R.string.login_fail);
                LoggerKt.d$default("session 获取为null", (Object) null, 1, (Object) null);
                Function1<Boolean, Unit> function1 = this.f8251ad;
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                    return;
                }
                return;
            }
            de.f8249fe.mmm();
            rg.qw("7476", "aiscan", "display", "APPLoad", "APPLoadSuc", "");
            Function1<Boolean, Unit> function12 = this.f8251ad;
            if (function12 != null) {
                function12.invoke(Boolean.TRUE);
            }
        }
    }

    public static final class qw extends AccountCenterCallback {
        public void onFinish(@Nullable AccountCenterResult accountCenterResult) {
            StringBuilder sb = new StringBuilder();
            sb.append("onFinish：isAccountDestroy：");
            sb.append(accountCenterResult != null ? Boolean.valueOf(accountCenterResult.isAccountDestory) : null);
            LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
            boolean z = false;
            if (accountCenterResult != null && accountCenterResult.isAccountDestory) {
                z = true;
            }
            if (z) {
                try {
                    ad.yj(de.f8249fe, (Function1) null, 1, (Object) null);
                    ExpectKt.success(Unit.INSTANCE);
                } catch (Throwable th2) {
                    LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
                    if (!Logger.INSTANCE.getEnable()) {
                        ExpectKt.failure(th2);
                        return;
                    }
                    throw th2;
                }
            }
        }

        public void onSocialBind(@Nullable String str) {
        }

        public void onSyncAccount(@Nullable SapiAccount sapiAccount) {
            super.onSyncAccount(sapiAccount);
            if (sapiAccount != null) {
                LoggerKt.d$default("onSyncAccount " + sapiAccount, (Object) null, 1, (Object) null);
                de deVar = de.f8249fe;
                deVar.m999switch(deVar.qqq(sapiAccount));
            }
        }
    }

    public void a(@NotNull LifecycleOwner lifecycleOwner, @NotNull String str, boolean z, @Nullable Function1<? super Boolean, Unit> function1) {
        boolean z2;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(str, "loginFromStat");
        if (z) {
            z2 = tt(lifecycleOwner, function1);
        } else {
            z2 = rrr(lifecycleOwner, function1);
        }
        if (z2) {
            rg.qw("7476", "aiscan", "display", "APPLoad", "APPLoad", "");
        }
    }

    public void aaa() {
        SapiAccountManager.getInstance().setAgreeDangerousProtocol(true);
    }

    public void ddd(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        eee(context);
        nn(context);
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        String str = session != null ? session.bduss : null;
        if (!(str == null || StringsKt__StringsJVMKt.isBlank(str))) {
            LoggerKt.d$default("用户已登录，尝试获取登录用户信息", (Object) null, 1, (Object) null);
            mmm();
        }
    }

    public final void eee(Context context) {
        SapiAccountManager.setGlobalCallback(new ad(context));
    }

    public final void mmm() {
        LoggerKt.d$default("onLoginSuccess ", (Object) null, 1, (Object) null);
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            LoggerKt.d$default("loginSuccess, session = " + session, (Object) null, 1, (Object) null);
            o(qqq(session));
            String str = fe.mmm.qw.de.ad.qw.qw.f7752rg;
            Intrinsics.checkNotNullExpressionValue(str, "channelNum");
            fe.mmm.qw.e.fe.qw("login_active", str);
        }
    }

    public final void nn(Context context) {
        SapiConfiguration.Builder customActionBar = new SapiConfiguration.Builder(context).setProductLineInfo("aiscan", "1", "4b65f4985820afd9c449cbb4c3f53a96").enableShare(true).setDebugSupportShareLogin(fe.mmm.qw.i.qw.o()).setSupportFaceLogin(false).customActionBar(true);
        Switch switchR = Switch.ON;
        SapiAccountManager.getInstance().init(customActionBar.smsLoginConfig(new SapiConfiguration.SmsLoginConfig(switchR, switchR, Switch.OFF)).setAgreeDangerousProtocol(fe.mmm.qw.th.qw.th.rg.qw(context)).debug(fe.mmm.qw.i.qw.o()).build());
    }

    public final fe.mmm.qw.qw.rg.qw qqq(SapiAccount sapiAccount) {
        SapiAccount sapiAccount2 = sapiAccount;
        return new fe.mmm.qw.qw.rg.qw(sapiAccount2.bduss, sapiAccount2.uid, sapiAccount.getCompletePortrait(), (Integer) null, sapiAccount2.displayname, (String) null, (String) null, (Long) null, (Long) null, (String) null, (String) null, (String) null, 4072, (DefaultConstructorMarker) null);
    }

    public boolean rg() {
        fe.mmm.qw.qw.rg.qw fe2 = fe();
        if (fe2 == null) {
            return false;
        }
        String uk2 = fe2.uk();
        if (uk2 == null || StringsKt__StringsJVMKt.isBlank(uk2)) {
            return false;
        }
        String rg2 = fe2.rg();
        if (!(rg2 == null || StringsKt__StringsJVMKt.isBlank(rg2))) {
            return true;
        }
        return false;
    }

    public final boolean rrr(LifecycleOwner lifecycleOwner, Function1<? super Boolean, Unit> function1) {
        Context context;
        if (lifecycleOwner instanceof FragmentActivity) {
            context = (Context) lifecycleOwner;
        } else if (lifecycleOwner instanceof Fragment) {
            context = ((Fragment) lifecycleOwner).getContext();
        } else if (!fe.mmm.qw.i.qw.o()) {
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
            context = null;
        } else {
            throw new RuntimeException("startLogin should use fragment or fragmentActivity as lifecycleOwner");
        }
        if (context == null) {
            return false;
        }
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.extraParams.add(SapiWebView.EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN);
        PassportSDK.getInstance().startLogin(context, new C0291de(function1), webLoginDTO);
        return true;
    }

    public void th(@Nullable Function1<? super Boolean, Unit> function1) {
        SapiAccountManager.getInstance().logout();
        m999switch((fe.mmm.qw.qw.rg.qw) null);
        i();
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
    }

    public final boolean tt(LifecycleOwner lifecycleOwner, Function1<? super Boolean, Unit> function1) {
        if (lifecycleOwner instanceof FragmentActivity) {
            new QuickLoginDialog.Builder((Activity) lifecycleOwner).setDialogCallback(new fe(function1)).build().show();
            return true;
        } else if (!fe.mmm.qw.i.qw.o()) {
            o.rg(R.string.login_fail);
            if (function1 == null) {
                return false;
            }
            function1.invoke(Boolean.FALSE);
            return false;
        } else {
            throw new RuntimeException("调起半屏登录需要传递Activity");
        }
    }

    public void xxx() {
        if (rg()) {
            AccountCenterDTO accountCenterDTO = new AccountCenterDTO();
            fe.mmm.qw.qw.rg.qw fe2 = fe();
            accountCenterDTO.bduss = fe2 != null ? fe2.rg() : null;
            PassportSDK.getInstance().loadAccountCenter(new qw(), accountCenterDTO);
        }
    }
}
