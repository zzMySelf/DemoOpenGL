package com.tera.scan.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.baidu.aiscan.R;
import com.dxmpay.walletsdk.core.BuildConfig;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.main.ui.ScanBaseActivity;
import com.tera.scan.main.ui.fragment.LeftDrawerFragment;
import com.tera.scan.main.view.MainTabView;
import com.tera.scan.main.viewmodel.MainActivityViewModel;
import com.tera.scan.permission.util.NotificationPermissionHelper;
import com.tera.scan.ui.view.layout.UIConstraintLayout;
import fe.fe.when.qw.qw.de;
import fe.mmm.qw.d.fe.uk;
import fe.mmm.qw.p030switch.th.de.ad.qw;
import fe.mmm.qw.xxx.p033switch.ad;
import fe.mmm.qw.xxx.ppp.th;
import i.qw.Cif;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0006J\b\u0010\u0011\u001a\u00020\u0006H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\r\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\"\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u0012\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J-\u0010#\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00062\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0%2\u0006\u0010'\u001a\u00020(H\u0016¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u0013H\u0014J\u0006\u0010+\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006,"}, d2 = {"Lcom/tera/scan/main/MainActivity;", "Lcom/tera/scan/main/ui/ScanBaseActivity;", "()V", "handler", "Landroid/os/Handler;", "leftDrawerMaxWidth", "", "getLeftDrawerMaxWidth", "()I", "leftDrawerMaxWidth$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/tera/scan/main/viewmodel/MainActivityViewModel;", "getViewModel", "()Lcom/tera/scan/main/viewmodel/MainActivityViewModel;", "viewModel$delegate", "fragmentContainerId", "getLayoutId", "initDrawer", "", "initListener", "initView", "initWalletSDK", "mainDrawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "mainDrawerLayout$app_main_aiscanConfigRelease", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "openDrawer", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Route(path = "/home/main/activity")
@Tag("MainActivity_tag")
public final class MainActivity extends ScanBaseActivity {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final Handler handler = new Handler(Looper.getMainLooper());
    @NotNull
    public final Lazy leftDrawerMaxWidth$delegate = LazyKt__LazyJVMKt.lazy(new MainActivity$leftDrawerMaxWidth$2(this));
    @NotNull
    public final Lazy viewModel$delegate = LazyKt__LazyJVMKt.lazy(new MainActivity$viewModel$2(this));

    private final int getLeftDrawerMaxWidth() {
        return ((Number) this.leftDrawerMaxWidth$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public final MainActivityViewModel getViewModel() {
        return (MainActivityViewModel) this.viewModel$delegate.getValue();
    }

    private final void initDrawer() {
        ((DrawerLayout) _$_findCachedViewById(R.id.main_drawer)).setDrawerLockMode(1);
        ViewGroup.LayoutParams layoutParams = ((FrameLayout) _$_findCachedViewById(R.id.left_drawer_view)).getLayoutParams();
        layoutParams.width = Math.min((int) (((double) qw.rg()) * 0.84d), getLeftDrawerMaxWidth());
        ((FrameLayout) _$_findCachedViewById(R.id.left_drawer_view)).setLayoutParams(layoutParams);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "supportFragmentManager.beginTransaction()");
        beginTransaction.add((int) R.id.left_drawer_view, (Fragment) new LeftDrawerFragment());
        beginTransaction.commitAllowingStateLoss();
    }

    private final void initListener() {
        Job unused = Cif.fe(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new MainActivity$initListener$1(this, (Continuation<? super MainActivity$initListener$1>) null), 3, (Object) null);
        Job unused2 = Cif.fe(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new MainActivity$initListener$2(this, (Continuation<? super MainActivity$initListener$2>) null), 3, (Object) null);
        ((DrawerLayout) _$_findCachedViewById(R.id.main_drawer)).addDrawerListener(new MainActivity$initListener$3(this));
    }

    private final void initWalletSDK() {
        de deVar = new de();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        deVar.de(context, BuildConfig.sChannelId, MainActivity$initWalletSDK$1.INSTANCE);
    }

    /* renamed from: onResume$lambda-1  reason: not valid java name */
    public static final void m764onResume$lambda1(MainActivity mainActivity) {
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        if (!fe.mmm.qw.g.de.qw.de()) {
            fe.mmm.qw.g.qw.qw.qw.qw().tt(new ad(mainActivity), mainActivity.getContext());
        }
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

    public final int fragmentContainerId() {
        return R.id.fl_main_content;
    }

    public int getLayoutId() {
        return R.layout.activity_main_new;
    }

    public void initView() {
        initListener();
        initDrawer();
        ((MainTabView) _$_findCachedViewById(R.id.main_bottom_tab)).initTabData(this, getViewModel(), th.f8636rg.ad());
    }

    @NotNull
    public final DrawerLayout mainDrawerLayout$app_main_aiscanConfigRelease() {
        DrawerLayout drawerLayout = (DrawerLayout) _$_findCachedViewById(R.id.main_drawer);
        Intrinsics.checkNotNullExpressionValue(drawerLayout, "main_drawer");
        return drawerLayout;
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        for (Fragment onActivityResult : getSupportFragmentManager().getFragments()) {
            onActivityResult.onActivityResult(i2, i3, intent);
        }
    }

    public void onBackPressed() {
        if (getViewModel().isInFileSelectMode()) {
            getViewModel().exitFileSelectMode(this);
            return;
        }
        DrawerLayout drawerLayout = (DrawerLayout) _$_findCachedViewById(R.id.main_drawer);
        boolean z = true;
        if (drawerLayout == null || !drawerLayout.isDrawerOpen((int) GravityCompat.START)) {
            z = false;
        }
        if (z) {
            ((DrawerLayout) _$_findCachedViewById(R.id.main_drawer)).closeDrawer((int) GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        fe.mmm.qw.ggg.ad.yj.qw.f7841th.rg();
        initWalletSDK();
    }

    public void onRequestPermissionsResult(int i2, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        for (Fragment onRequestPermissionsResult : getSupportFragmentManager().getFragments()) {
            onRequestPermissionsResult.onRequestPermissionsResult(i2, strArr, iArr);
        }
        NotificationPermissionHelper.qw(this, i2, strArr, iArr);
    }

    public void onResume() {
        super.onResume();
        UIConstraintLayout uIConstraintLayout = (UIConstraintLayout) _$_findCachedViewById(R.id.main_container);
        if (uIConstraintLayout != null) {
            uIConstraintLayout.setPadding(uIConstraintLayout.getPaddingLeft(), uk.qw(uIConstraintLayout.getContext()), uIConstraintLayout.getPaddingRight(), uIConstraintLayout.getPaddingBottom());
        }
        this.handler.postDelayed(new fe.mmm.qw.xxx.qw(this), 100);
    }

    public final void openDrawer() {
        if (!((DrawerLayout) _$_findCachedViewById(R.id.main_drawer)).isDrawerOpen((int) GravityCompat.START)) {
            ((DrawerLayout) _$_findCachedViewById(R.id.main_drawer)).openDrawer((int) GravityCompat.START);
        }
    }
}
