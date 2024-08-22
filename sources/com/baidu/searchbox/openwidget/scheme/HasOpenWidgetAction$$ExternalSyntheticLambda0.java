package com.baidu.searchbox.openwidget.scheme;

import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HasOpenWidgetAction$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ HasOpenWidgetAction f$0;
    public final /* synthetic */ AtomicReference f$1;
    public final /* synthetic */ UnitedSchemeEntity f$2;
    public final /* synthetic */ JSONObject f$3;
    public final /* synthetic */ Function0 f$4;

    public /* synthetic */ HasOpenWidgetAction$$ExternalSyntheticLambda0(HasOpenWidgetAction hasOpenWidgetAction, AtomicReference atomicReference, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Function0 function0) {
        this.f$0 = hasOpenWidgetAction;
        this.f$1 = atomicReference;
        this.f$2 = unitedSchemeEntity;
        this.f$3 = jSONObject;
        this.f$4 = function0;
    }

    public final void run() {
        HasOpenWidgetAction.m1836handleAction$lambda5$lambda3(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
