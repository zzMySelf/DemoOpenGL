package com.tera.scan.main.welcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.main.MainActivity;
import com.tera.scan.main.TeraScanApplication;
import com.tera.scan.main.ui.ScanBaseActivity;
import com.tera.scan.main.viewmodel.WelcomeViewModel;
import com.tera.scan.vip.VipInfoManager;
import fe.mmm.qw.j.i;
import fe.mmm.qw.th.qw.th.pf;
import fe.mmm.qw.xxx.vvv.de;
import fe.mmm.qw.xxx.vvv.fe;
import fe.mmm.qw.xxx.vvv.yj;
import fe.mmm.qw.xxx.when.rg;
import fe.mmm.qw.yj.th;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0014J\r\u0010\u0015\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\"\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0012\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u000eH\u0014J\b\u0010#\u001a\u00020\u000eH\u0014J\b\u0010$\u001a\u00020\u000eH\u0002J\b\u0010%\u001a\u00020\u000eH\u0002J\b\u0010&\u001a\u00020\u000eH\u0002J\u0010\u0010'\u001a\u00020\u000e2\b\b\u0001\u0010(\u001a\u00020)J\u0012\u0010'\u001a\u00020\u000e2\b\b\u0001\u0010*\u001a\u00020+H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006-"}, d2 = {"Lcom/tera/scan/main/welcome/WelcomeActivity;", "Lcom/tera/scan/main/ui/ScanBaseActivity;", "()V", "handler", "Landroid/os/Handler;", "isEnterMain", "", "welcomeViewModel", "Lcom/tera/scan/main/viewmodel/WelcomeViewModel;", "getWelcomeViewModel", "()Lcom/tera/scan/main/viewmodel/WelcomeViewModel;", "welcomeViewModel$delegate", "Lkotlin/Lazy;", "afterInflaterInit", "", "enterNextPage", "getLayoutId", "", "initAnalyticsData", "initData", "initView", "isColdStart", "isColdStart$app_main_aiscanConfigRelease", "isYesterday", "timeStamp", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "readyToAppView", "realEnterNextPage", "showAgreementDialog", "transparentNavBar", "activity", "Landroid/app/Activity;", "window", "Landroid/view/Window;", "Companion", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("WelcomeActivity")
public final class WelcomeActivity extends ScanBaseActivity {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    public static int launchCount;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final Handler handler = new Handler(Looper.getMainLooper());
    public boolean isEnterMain;
    @NotNull
    public final Lazy welcomeViewModel$delegate = LazyKt__LazyJVMKt.lazy(new WelcomeActivity$welcomeViewModel$2(this));

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void afterInflaterInit() {
        showAgreementDialog();
    }

    private final void enterNextPage() {
        if (Intrinsics.areEqual((Object) rg.qw().getValue(), (Object) Boolean.TRUE)) {
            realEnterNextPage();
            return;
        }
        rg.qw().observe(this, new fe(this));
        this.handler.postDelayed(new fe.mmm.qw.xxx.vvv.qw(this), 3000);
    }

    /* renamed from: enterNextPage$lambda-2  reason: not valid java name */
    public static final void m838enterNextPage$lambda2(WelcomeActivity welcomeActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(welcomeActivity, "this$0");
        welcomeActivity.handler.post(new fe.mmm.qw.xxx.vvv.rg(welcomeActivity));
    }

    /* renamed from: enterNextPage$lambda-2$lambda-1  reason: not valid java name */
    public static final void m839enterNextPage$lambda2$lambda1(WelcomeActivity welcomeActivity) {
        Intrinsics.checkNotNullParameter(welcomeActivity, "this$0");
        if (!welcomeActivity.isEnterMain) {
            welcomeActivity.realEnterNextPage();
        }
    }

    /* renamed from: enterNextPage$lambda-3  reason: not valid java name */
    public static final void m840enterNextPage$lambda3(WelcomeActivity welcomeActivity) {
        Intrinsics.checkNotNullParameter(welcomeActivity, "this$0");
        if (!welcomeActivity.isEnterMain) {
            welcomeActivity.realEnterNextPage();
        }
    }

    private final WelcomeViewModel getWelcomeViewModel() {
        return (WelcomeViewModel) this.welcomeViewModel$delegate.getValue();
    }

    private final void initAnalyticsData() {
        fe.mmm.qw.ggg.qw.qw.yj(fe.mmm.qw.qw.qw.qw.yj());
        fe.mmm.qw.ggg.qw.qw.rg(fe.mmm.qw.qw.qw.qw.fe());
        fe.mmm.qw.ggg.qw.qw.fe(VipInfoManager.qw.yj() ? 1 : 0);
    }

    private final void initData() {
        this.handler.postDelayed(new de(this), 100);
    }

    /* renamed from: initData$lambda-0  reason: not valid java name */
    public static final void m841initData$lambda0(WelcomeActivity welcomeActivity) {
        Intrinsics.checkNotNullParameter(welcomeActivity, "this$0");
        welcomeActivity.afterInflaterInit();
    }

    private final boolean isYesterday(long j) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j);
        if (instance2.get(1) == instance.get(1) && instance.get(6) == instance2.get(6) + 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void readyToAppView() {
        TeraScanApplication teraScanApplication = TeraScanApplication.netdiskApplication;
        if (teraScanApplication != null) {
            teraScanApplication.onUserAgreePrivacyAgreement();
        }
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "splash_show", (List) null, 2, (Object) null);
        yj.qw(this);
        enterNextPage();
    }

    private final void realEnterNextPage() {
        initAnalyticsData();
        this.isEnterMain = true;
        startActivity(new Intent(this, MainActivity.class));
        finish();
        long th2 = th.ppp().th("first_launcher_time", 0);
        if (th2 == 0) {
            th.ppp().m1012if("first_launcher_time", i.ad());
        } else if (isYesterday(th2)) {
            new pf("remain_active", new String[0]).qw();
        }
    }

    private final void showAgreementDialog() {
        if (fe.mmm.qw.th.qw.th.rg.qw(this)) {
            readyToAppView();
            return;
        }
        fe.mmm.qw.xxx.pf.de.fe("Half_Pop", "LaunchPage", (String) null, (Map) null, 12, (Object) null);
        getWelcomeViewModel().showAgreementDialog(this, new WelcomeActivity$showAgreementDialog$1(this), new WelcomeActivity$showAgreementDialog$2(this));
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public int getLayoutId() {
        return 0;
    }

    public void initView() {
        fe.mmm.qw.ggg.ad.yj.qw.f7841th.uk(false);
        fe.mmm.qw.ggg.qw.qw.th(true);
    }

    public final boolean isColdStart$app_main_aiscanConfigRelease() {
        return launchCount <= 1;
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (-1 == i3 && i2 == 2) {
            startActivity(new Intent(this, MainActivity.class));
        }
        finish();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        initData();
        fe.mmm.qw.xxx.pf.de.fe("Launch", "LaunchPage", (String) null, (Map) null, 12, (Object) null);
        launchCount++;
    }

    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacksAndMessages((Object) null);
    }

    public void onResume() {
        super.onResume();
        transparentNavBar((Activity) this);
    }

    public final void transparentNavBar(@NotNull @NonNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "activity.window");
        transparentNavBar(window);
    }

    private final void transparentNavBar(@NonNull Window window) {
        try {
            Result.Companion companion = Result.Companion;
            if (Build.VERSION.SDK_INT >= 29) {
                window.setNavigationBarContrastEnforced(false);
            }
            window.setNavigationBarColor(0);
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1792);
            Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
    }
}
