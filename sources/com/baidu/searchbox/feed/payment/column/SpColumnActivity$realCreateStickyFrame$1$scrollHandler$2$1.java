package com.baidu.searchbox.feed.payment.column;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpColumnActivity.kt */
/* synthetic */ class SpColumnActivity$realCreateStickyFrame$1$scrollHandler$2$1 extends FunctionReferenceImpl implements Function0<Unit> {
    SpColumnActivity$realCreateStickyFrame$1$scrollHandler$2$1(Object obj) {
        super(0, obj, SpColumnActivity.class, "onNestedScrollEnd", "onNestedScrollEnd()V", 0);
    }

    public final void invoke() {
        ((SpColumnActivity) this.receiver).onNestedScrollEnd();
    }
}
