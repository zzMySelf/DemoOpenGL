package com.baidu.searchbox.secondfloor.home.swan;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.secondfloor.home.HomeSwanAppView;
import com.baidu.searchbox.secondfloor.home.contract.HomeSecondFloorFragmentImpl;
import com.baidu.searchbox.secondfloor.home.stat.RecommendShowUBCUtils;
import com.baidu.swan.api.SwanAppApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/secondfloor/home/swan/HomeSecondFloorSwanImpl;", "Lcom/baidu/searchbox/secondfloor/home/contract/HomeSecondFloorFragmentImpl;", "()V", "mHomeSwanAppView", "Lcom/baidu/searchbox/secondfloor/home/HomeSwanAppView;", "onBackPressed", "", "onCreate", "context", "Landroid/content/Context;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "onDestroy", "onNightModeChanged", "isNightMode", "", "onPause", "onResume", "preDownloadSwanAppAsync", "reportSecondFloorSearchViewEvent", "lib-secondfloor-home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeSecondFloorSwanImpl.kt */
public final class HomeSecondFloorSwanImpl implements HomeSecondFloorFragmentImpl {
    private HomeSwanAppView mHomeSwanAppView;

    public boolean useImmersion() {
        return HomeSecondFloorFragmentImpl.DefaultImpls.useImmersion(this);
    }

    public void onCreate(Context context, Bundle savedInstanceState) {
        Bundle ext = new Bundle();
        ext.putString("bundle_key_preload_preload_scene", "4");
        SwanAppApi.getPreloadRuntime().startSwanRuntimeEnvironment(context, ext);
    }

    public View onCreateView(Context context) {
        if (context == null) {
            return null;
        }
        this.mHomeSwanAppView = new HomeSwanAppView(context);
        SwanAppApi.getSlientUpdateRuntime().startUpdate("4");
        preDownloadSwanAppAsync();
        HomeSwanAppView homeSwanAppView = this.mHomeSwanAppView;
        Intrinsics.checkNotNull(homeSwanAppView);
        return homeSwanAppView;
    }

    public void onResume() {
    }

    public void onPause() {
        RecommendShowUBCUtils.reportSecondFloorRecommendUBCShowData();
        reportSecondFloorSearchViewEvent();
    }

    public void onBackPressed() {
        HomeSwanAppView homeSwanAppView = this.mHomeSwanAppView;
        if (homeSwanAppView != null) {
            homeSwanAppView.dismissBubble();
        }
    }

    public void onDestroy() {
        RecommendShowUBCUtils.clearSecondFloorRecommendUBCShowData();
    }

    public void onNightModeChanged(boolean isNightMode) {
        HomeSwanAppView homeSwanAppView = this.mHomeSwanAppView;
        if (homeSwanAppView != null) {
            homeSwanAppView.updateNightMode();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: preDownloadSwanAppAsync$lambda-0  reason: not valid java name */
    public static final void m3103preDownloadSwanAppAsync$lambda0() {
        SwanAppApi.getPreloadRuntime().preDownloadSwanAppsByScene("8");
    }

    private final void preDownloadSwanAppAsync() {
        ExecutorUtilsExt.postOnElastic(new HomeSecondFloorSwanImpl$$ExternalSyntheticLambda0(), "SwanPreDownloadFromSecondFloor", 2);
    }

    private final void reportSecondFloorSearchViewEvent() {
        HomeSwanAppView homeSwanAppView = this.mHomeSwanAppView;
        if (homeSwanAppView != null) {
            homeSwanAppView.reportSearchViewShowEvent();
        }
    }
}
