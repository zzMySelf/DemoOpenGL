package com.baidu.searchbox.goodsrender.nps;

import com.baidu.nps.main.invoke.IInvokeCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RenderPluginManager$$ExternalSyntheticLambda0 implements IInvokeCallback {
    public final /* synthetic */ RenderPluginManager f$0;
    public final /* synthetic */ ILoadPluginListener f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ boolean f$3;

    public /* synthetic */ RenderPluginManager$$ExternalSyntheticLambda0(RenderPluginManager renderPluginManager, ILoadPluginListener iLoadPluginListener, long j2, boolean z) {
        this.f$0 = renderPluginManager;
        this.f$1 = iLoadPluginListener;
        this.f$2 = j2;
        this.f$3 = z;
    }

    public final void onResult(int i2, String str, Object obj) {
        RenderPluginManager.m17813loadPlugin$lambda0(this.f$0, this.f$1, this.f$2, this.f$3, i2, str, obj);
    }
}
