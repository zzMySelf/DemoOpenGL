package com.baidu.chatsearch.aicall.utils;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ViewExtKt$$ExternalSyntheticLambda0 implements View.OnTouchListener {
    public final /* synthetic */ float f$0;
    public final /* synthetic */ float f$1;

    public /* synthetic */ ViewExtKt$$ExternalSyntheticLambda0(float f2, float f3) {
        this.f$0 = f2;
        this.f$1 = f3;
    }

    public final boolean onTouch(View view2, MotionEvent motionEvent) {
        return ViewExtKt.m13134addPressedState$lambda0(this.f$0, this.f$1, view2, motionEvent);
    }
}
