package com.baidu.swan.apps.api.module.ui.menu;

import com.baidu.swan.apps.adaptation.webview.ISwanAppSlaveManager;
import com.baidu.swan.apps.api.base.ISwanApiContext;
import com.baidu.swan.apps.api.base.SwanBaseApi;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.core.fragment.SwanAppBaseFragment;
import com.baidu.swan.apps.core.fragment.SwanAppFragment;
import com.baidu.swan.apps.embed.page.ISwanPageManager;
import com.baidu.swan.apps.framework.ISwanFrameContainer;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.util.SwanAppUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\tH\u0007¨\u0006\u000b"}, d2 = {"Lcom/baidu/swan/apps/api/module/ui/menu/OpenMenuApi;", "Lcom/baidu/swan/apps/api/base/SwanBaseApi;", "swanApiContext", "Lcom/baidu/swan/apps/api/base/ISwanApiContext;", "(Lcom/baidu/swan/apps/api/base/ISwanApiContext;)V", "getApiModule", "", "getLogTag", "openMenu", "Lcom/baidu/swan/apps/api/result/SwanApiResult;", "Companion", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OpenMenuApi.kt */
public final class OpenMenuApi extends SwanBaseApi {
    private static final String API_OPEN_MENU = "openMenu";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "OpenMenuApi";
    private static final String WHITE_NAME_OPEN_MENU = "swanAPI/openMenu";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OpenMenuApi(ISwanApiContext swanApiContext) {
        super(swanApiContext);
        Intrinsics.checkNotNullParameter(swanApiContext, "swanApiContext");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/swan/apps/api/module/ui/menu/OpenMenuApi$Companion;", "", "()V", "API_OPEN_MENU", "", "TAG", "WHITE_NAME_OPEN_MENU", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OpenMenuApi.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public String getLogTag() {
        return TAG;
    }

    /* access modifiers changed from: protected */
    public String getApiModule() {
        return "Menu";
    }

    public final SwanApiResult openMenu() {
        boolean z = false;
        logInfo(TAG, false);
        if (Swan.get().getApp() == null || !SwanAppUtils.isLingJingAgent()) {
            return new SwanApiResult(1001);
        }
        ISwanFrameContainer swanFrameContainer = Swan.get().getSwanFrameContainer();
        if (swanFrameContainer != null && swanFrameContainer.isBackground()) {
            z = true;
        }
        if (z) {
            return new SwanApiResult(1002);
        }
        ISwanPageManager fragmentManager = SwanAppController.getInstance().getSwanPageManager();
        SwanAppBaseFragment fragment = fragmentManager != null ? fragmentManager.getTopFragment() : null;
        if (fragment == null) {
            return new SwanApiResult(1001);
        }
        if (!(fragment instanceof SwanAppFragment)) {
            return new SwanApiResult(1001);
        }
        SwanAppUtils.runOnUiThread(new OpenMenuApi$$ExternalSyntheticLambda0(((SwanAppFragment) fragment).getCurrentWebViewManager(), fragment));
        SwanApiResult ok = SwanApiResult.ok();
        Intrinsics.checkNotNullExpressionValue(ok, "ok()");
        return ok;
    }

    /* access modifiers changed from: private */
    /* renamed from: openMenu$lambda-0  reason: not valid java name */
    public static final void m7881openMenu$lambda0(ISwanAppSlaveManager $currentWebViewManager, SwanAppBaseFragment $fragment) {
        Intrinsics.checkNotNullParameter($fragment, "$fragment");
        if ($currentWebViewManager != null) {
            $currentWebViewManager.checkInputMethod();
        }
        ((SwanAppFragment) $fragment).showAgentMenu();
    }
}
