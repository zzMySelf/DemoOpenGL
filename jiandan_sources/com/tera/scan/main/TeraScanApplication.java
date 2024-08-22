package com.tera.scan.main;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.os.IBinder;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import com.baidu.sofire.ac.BDModuleLoadCallback;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.xclient.privacycontrol.PrivacyControlConfig;
import com.baidu.sofire.xclient.privacycontrol.PrvDataManager;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.account.OnLoginCallBack;
import com.tera.scan.framework.kernel.BaseApplication;
import com.tera.scan.main.service.NetdiskService;
import fe.mmm.qw.th.qw.th.rg;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007\b\u0016¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0014J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\tH\u0014J\b\u0010\u001e\u001a\u00020\u0016H\u0014J\b\u0010\u001f\u001a\u00020\u0016H\u0015J\b\u0010 \u001a\u00020\u0016H\u0015J\b\u0010!\u001a\u00020\u0016H\u0014J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0016H\u0016J\b\u0010&\u001a\u00020\u0016H\u0014J\b\u0010'\u001a\u00020\u0016H\u0015J\b\u0010(\u001a\u00020\u0016H\u0016J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u0006H\u0016J\u0006\u0010+\u001a\u00020\u0016J\b\u0010,\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/tera/scan/main/TeraScanApplication;", "Lcom/tera/scan/framework/kernel/BaseApplication;", "()V", "connection", "Landroid/content/ServiceConnection;", "corePoolSize", "", "cpuCount", "isBoundService", "", "isEnableStartService", "()Z", "setEnableStartService", "(Z)V", "isInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "service", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "startTime", "", "attachBaseContext", "", "base", "Landroid/content/Context;", "basecreateOperation", "bindService", "initApp", "initSofire", "isCurrentAppProcess", "onAnyProcessInit", "onAsyncDelayedInit", "onAsyncInit", "onAttachContext", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onFirstActivityCreated", "onSyncInit", "onTerminate", "onTrimMemory", "level", "onUserAgreePrivacyAgreement", "unBindService", "Companion", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class TeraScanApplication extends BaseApplication {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @Nullable
    @SuppressLint({"StaticFieldLeak"})
    @JvmField
    public static TeraScanApplication netdiskApplication;

    /* renamed from: i  reason: collision with root package name */
    public final int f6953i;

    /* renamed from: if  reason: not valid java name */
    public long f285if;

    /* renamed from: o  reason: collision with root package name */
    public final int f6954o;
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public final AtomicBoolean f6955pf;
    @NotNull

    /* renamed from: switch  reason: not valid java name */
    public final ServiceConnection f286switch;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f6956uk;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f6957yj = true;

    public static final class ad implements ServiceConnection {
        public void onServiceConnected(@NotNull ComponentName componentName, @NotNull IBinder iBinder) {
            Intrinsics.checkNotNullParameter(componentName, "className");
            Intrinsics.checkNotNullParameter(iBinder, "service");
        }

        public void onServiceDisconnected(@NotNull ComponentName componentName) {
            Intrinsics.checkNotNullParameter(componentName, "className");
        }
    }

    public static final class de implements BDModuleLoadCallback {
        public void onFailure(int i2, int i3) {
            LoggerKt.e$default("Sofire 初始化失败，moduleId=" + i2 + "，errorCode=" + i3 + "，CUID=" + fe.mmm.qw.de.ad.qw.qw.f7750o, (Object) null, 1, (Object) null);
        }

        public void onSuccess(int i2) {
            LoggerKt.d$default("Sofire 初始化成功，moduleId=" + i2 + "，CUID=" + fe.mmm.qw.de.ad.qw.qw.f7750o, (Object) null, 1, (Object) null);
            PrvDataManager.setPrivacyControlConfig(new PrivacyControlConfig.Builder().setCacheSwitch(false).setDebugModel(fe.mmm.qw.i.qw.o()).build());
        }
    }

    public static final class fe implements OnLoginCallBack {
        public final /* synthetic */ TeraScanApplication qw;

        public fe(TeraScanApplication teraScanApplication) {
            this.qw = teraScanApplication;
        }

        public void ad() {
            fe.mmm.qw.rrr.qw.ad.qw.ad(this.qw);
            fe.mmm.qw.qw.qw.qw.ppp(this.qw);
            fe.mmm.qw.e.de.i(fe.mmm.qw.qw.qw.qw.yj());
        }

        public void qw() {
            fe.mmm.qw.rrr.qw.ad.qw.ad(this.qw);
            fe.mmm.qw.e.de.i("");
            fe.mmm.qw.p024if.ad.qw(this.qw);
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TeraScanApplication() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.f6953i = availableProcessors;
        int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(2, RangesKt___RangesKt.coerceAtMost(availableProcessors - 1, 4));
        this.f6954o = coerceAtLeast;
        Executors.newFixedThreadPool(coerceAtLeast);
        this.f6955pf = new AtomicBoolean(false);
        this.f286switch = new ad();
        netdiskApplication = this;
        fe.mmm.qw.rg.ad.qw.qw();
    }

    public void attachBaseContext(@Nullable Context context) {
        super.attachBaseContext(context);
        registerActivityLifecycleCallbacks(new fe.mmm.qw.ggg.ad.yj.qw());
        onAttachContext();
    }

    public void bindService() {
        bindService(new Intent(this, NetdiskService.class), this.f286switch, 1);
        this.f6956uk = true;
    }

    public final void de() {
        super.selfCreateOperation();
        fe.mmm.qw.d.de.de.when().vvv(this);
    }

    public final void fe() {
        FH.init(this, "743099", "7a7252da999d7336d3d8f858a39094c1", new de(), 1);
    }

    public void initApp() {
        super.initApp();
        if (isCurrentAppProcess()) {
            fe.mmm.qw.p024if.p026switch.de.qw().de("TextOcrPageHandler", new fe.mmm.qw.rg.de.mmm.qw());
            fe.mmm.qw.p024if.p026switch.de.qw().de("WatermarkPageHandler", new fe.mmm.qw.qqq.th.qw());
            onSyncInit();
            fe.mmm.qw.i.qw.ad("TeraScanApplication", "AppLaunch:Application Create End");
        }
    }

    public boolean isCurrentAppProcess() {
        return true;
    }

    public final boolean isEnableStartService() {
        return this.f6957yj;
    }

    public void onAnyProcessInit() {
    }

    @UiThread
    public void onAsyncDelayedInit() {
        fe.mmm.qw.i.qw.ad("TeraScanApplication", "全部初始化完成: " + (System.currentTimeMillis() - this.f285if));
    }

    @WorkerThread
    public void onAsyncInit() {
        onComponentAsyncInit();
    }

    public void onAttachContext() {
        LoggerKt.d$default("onAttachContext", (Object) null, 1, (Object) null);
        fe.mmm.qw.e.de.uk(fe.mmm.qw.i.qw.o());
        fe.mmm.qw.e.de.yj(true);
        fe.mmm.qw.e.de.fe(this);
    }

    public void onConfigurationChanged(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        fe.mmm.qw.h.ad.qw().de(getApplicationContext());
    }

    public void onCreate() {
        super.onCreate();
        fe.mmm.qw.h.ad.qw().de(getApplicationContext());
        if (rg.qw(this)) {
            onUserAgreePrivacyAgreement();
        }
    }

    public void onFirstActivityCreated() {
        onComponentFirstActivityCreated();
    }

    @UiThread
    public void onSyncInit() {
        LoggerKt.d$default("onSyncInit", (Object) null, 1, (Object) null);
        new fe.mmm.qw.xxx.o.ad(this).ad();
        bindService();
        fe.mmm.qw.qw.qw.qw.o(this);
        fe.mmm.qw.qw.qw.qw.de(new fe(this));
    }

    public void onTerminate() {
        super.onTerminate();
        if (isCurrentAppProcess()) {
            unBindService();
            onComponentDestroy();
        }
    }

    public void onTrimMemory(int i2) {
        try {
            super.onTrimMemory(i2);
        } catch (Exception e) {
            fe.mmm.qw.i.qw.th("TeraScanApplication", e.getMessage(), e);
        }
    }

    public final void onUserAgreePrivacyAgreement() {
        if (!this.f6955pf.get()) {
            FH.setAgreePolicy(this, true);
            fe();
            this.f6955pf.set(true);
            this.f285if = System.currentTimeMillis();
            de();
        }
    }

    public final void setEnableStartService(boolean z) {
        this.f6957yj = z;
    }

    public void unBindService() {
        if (this.f6956uk) {
            unbindService(this.f286switch);
            this.f6956uk = false;
        }
    }
}
