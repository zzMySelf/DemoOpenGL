package com.baidu.searchbox.openwidget.scheme;

import com.baidu.searchbox.openwidget.model.OpenWidgetConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HasOpenWidgetAction$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ long f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ OpenWidgetConfig f$2;
    public final /* synthetic */ HasOpenWidgetAction f$3;
    public final /* synthetic */ AtomicReference f$4;
    public final /* synthetic */ UnitedSchemeEntity f$5;
    public final /* synthetic */ Function0 f$6;

    public /* synthetic */ HasOpenWidgetAction$$ExternalSyntheticLambda2(long j2, boolean z, OpenWidgetConfig openWidgetConfig, HasOpenWidgetAction hasOpenWidgetAction, AtomicReference atomicReference, UnitedSchemeEntity unitedSchemeEntity, Function0 function0) {
        this.f$0 = j2;
        this.f$1 = z;
        this.f$2 = openWidgetConfig;
        this.f$3 = hasOpenWidgetAction;
        this.f$4 = atomicReference;
        this.f$5 = unitedSchemeEntity;
        this.f$6 = function0;
    }

    public final void run() {
        HasOpenWidgetAction.m1835handleAction$lambda5(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
    }
}
