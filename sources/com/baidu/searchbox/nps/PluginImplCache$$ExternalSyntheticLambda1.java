package com.baidu.searchbox.nps;

import com.baidu.searchbox.nps.INpsPluginLoader;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PluginImplCache$$ExternalSyntheticLambda1 implements INpsPluginLoader.Callback {
    public final /* synthetic */ PluginImplCache f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Function1 f$2;

    public /* synthetic */ PluginImplCache$$ExternalSyntheticLambda1(PluginImplCache pluginImplCache, int i2, Function1 function1) {
        this.f$0 = pluginImplCache;
        this.f$1 = i2;
        this.f$2 = function1;
    }

    public final void onResult(Object obj, Exception exc) {
        PluginImplCache.m1777withCache$lambda3(this.f$0, this.f$1, this.f$2, obj, exc);
    }
}
