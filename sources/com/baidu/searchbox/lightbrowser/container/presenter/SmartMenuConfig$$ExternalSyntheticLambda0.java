package com.baidu.searchbox.lightbrowser.container.presenter;

import com.baidu.searchbox.lightbrowser.ioc.ICommonCallback;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SmartMenuConfig$$ExternalSyntheticLambda0 implements ICommonCallback {
    public final /* synthetic */ Ref.BooleanRef f$0;
    public final /* synthetic */ SmartMenuConfig f$1;

    public /* synthetic */ SmartMenuConfig$$ExternalSyntheticLambda0(Ref.BooleanRef booleanRef, SmartMenuConfig smartMenuConfig) {
        this.f$0 = booleanRef;
        this.f$1 = smartMenuConfig;
    }

    public final void onResult(Object obj) {
        SmartMenuConfig.m20697currentPageIsCollected$lambda0(this.f$0, this.f$1, (String) obj);
    }
}
