package com.baidu.assistant.model.ttsplugin;

import android.content.Context;
import android.view.View;
import com.baidu.tts.plugin.api.IHumanPlugin;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ConvertDataManager$init$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ IHumanPlugin f$0;
    public final /* synthetic */ View f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ ConvertDataManager f$3;
    public final /* synthetic */ Context f$4;

    public /* synthetic */ ConvertDataManager$init$1$$ExternalSyntheticLambda0(IHumanPlugin iHumanPlugin, View view2, int i2, ConvertDataManager convertDataManager, Context context) {
        this.f$0 = iHumanPlugin;
        this.f$1 = view2;
        this.f$2 = i2;
        this.f$3 = convertDataManager;
        this.f$4 = context;
    }

    public final void run() {
        ConvertDataManager$init$1.m12572onResult$lambda0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
