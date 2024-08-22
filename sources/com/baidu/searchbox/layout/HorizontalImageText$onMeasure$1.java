package com.baidu.searchbox.layout;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: pudding.kt */
/* synthetic */ class HorizontalImageText$onMeasure$1 extends FunctionReferenceImpl implements Function2<Integer, Integer, Unit> {
    HorizontalImageText$onMeasure$1(Object obj) {
        super(2, obj, HorizontalImageText.class, "setMeasuredDimension", "setMeasuredDimension(II)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Number) p1).intValue(), ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int p0, int p1) {
        ((HorizontalImageText) this.receiver).setMeasuredDimension(p0, p1);
    }
}
