package com.baidu.searchbox.schemedispatch.united.module.impl;

import android.app.Activity;
import com.baidu.searchbox.schemedispatch.united.module.UnitedSchemeTalosPopUpFrameAdapter;
import com.baidu.searchbox.schemedispatch.united.module.UnitedSchemeTalosPopUpFrameDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TalosPopupImpl$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ UnitedSchemeTalosPopUpFrameDispatcher f$0;
    public final /* synthetic */ Activity f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ UnitedSchemeEntity f$3;
    public final /* synthetic */ UnitedSchemeTalosPopUpFrameAdapter f$4;

    public /* synthetic */ TalosPopupImpl$$ExternalSyntheticLambda0(UnitedSchemeTalosPopUpFrameDispatcher unitedSchemeTalosPopUpFrameDispatcher, Activity activity, String str, UnitedSchemeEntity unitedSchemeEntity, UnitedSchemeTalosPopUpFrameAdapter unitedSchemeTalosPopUpFrameAdapter) {
        this.f$0 = unitedSchemeTalosPopUpFrameDispatcher;
        this.f$1 = activity;
        this.f$2 = str;
        this.f$3 = unitedSchemeEntity;
        this.f$4 = unitedSchemeTalosPopUpFrameAdapter;
    }

    public final void run() {
        TalosPopupImpl.m2737showTalosPopup$lambda2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
