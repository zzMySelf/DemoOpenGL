package com.baidu.searchbox.live.interfaces.context;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/context/LivePluginActivityContextWrapper;", "Landroid/content/ContextWrapper;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "act", "inflater", "Landroid/view/LayoutInflater;", "pluginService", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "kotlin.jvm.PlatformType", "getActivity", "getAssets", "Landroid/content/res/AssetManager;", "getClassLoader", "Ljava/lang/ClassLoader;", "getResources", "Landroid/content/res/Resources;", "getSystemService", "", "name", "", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: LivePluginActivityContextWrapper.kt */
public final class LivePluginActivityContextWrapper extends ContextWrapper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LIVE_PKG_NAME = "com.baidu.searchbox.livenps";
    private final Activity act;
    private LayoutInflater inflater;
    private final PluginInvokeService pluginService = ((PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE()));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LivePluginActivityContextWrapper(Activity activity) {
        super(activity);
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.act = activity;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/context/LivePluginActivityContextWrapper$Companion;", "", "()V", "LIVE_PKG_NAME", "", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: LivePluginActivityContextWrapper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    public AssetManager getAssets() {
        AssetManager it;
        PluginInvokeService pluginInvokeService = this.pluginService;
        if (pluginInvokeService != null && (it = pluginInvokeService.getPluginAssets("com.baidu.searchbox.livenps")) != null) {
            return it;
        }
        AssetManager it2 = super.getAssets();
        Intrinsics.checkExpressionValueIsNotNull(it2, "super.getAssets()");
        return it2;
    }

    public Resources getResources() {
        Resources it;
        PluginInvokeService pluginInvokeService = this.pluginService;
        if (pluginInvokeService != null && (it = pluginInvokeService.getPluginResource("com.baidu.searchbox.livenps")) != null) {
            return it;
        }
        Resources it2 = super.getResources();
        Intrinsics.checkExpressionValueIsNotNull(it2, "super.getResources()");
        return it2;
    }

    public ClassLoader getClassLoader() {
        ClassLoader it;
        PluginInvokeService pluginInvokeService = this.pluginService;
        if (pluginInvokeService != null && (it = pluginInvokeService.getPluginClassLoader("com.baidu.searchbox.livenps")) != null) {
            return it;
        }
        ClassLoader it2 = super.getClassLoader();
        Intrinsics.checkExpressionValueIsNotNull(it2, "super.getClassLoader()");
        return it2;
    }

    public Object getSystemService(String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        if (Intrinsics.areEqual((Object) name, (Object) "layout_inflater")) {
            if (this.inflater == null) {
                this.inflater = LayoutInflater.from(this.act).cloneInContext(this);
            }
            LayoutInflater it = this.inflater;
            if (it != null) {
                return it;
            }
        }
        return super.getSystemService(name);
    }

    public final Activity getActivity() {
        return this.act;
    }
}
