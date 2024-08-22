package com.baidu.searchbox.aisearch.comps.input.text.inputmethod;

import android.content.Context;
import android.view.ViewTreeObserver;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InputMethodObservable$$ExternalSyntheticLambda0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ InputMethodObservable f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Context f$2;

    public /* synthetic */ InputMethodObservable$$ExternalSyntheticLambda0(InputMethodObservable inputMethodObservable, boolean z, Context context) {
        this.f$0 = inputMethodObservable;
        this.f$1 = z;
        this.f$2 = context;
    }

    public final void onGlobalLayout() {
        InputMethodObservable.m15761onListener$lambda0(this.f$0, this.f$1, this.f$2);
    }
}
