package com.baidu.chatsearch.fusion.sidebar;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "position", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FusionSideBarAdapter.kt */
final class FusionSideBarListAdapter$itemTouchListener$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ FusionSideBarListAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FusionSideBarListAdapter$itemTouchListener$1(FusionSideBarListAdapter fusionSideBarListAdapter) {
        super(1);
        this.this$0 = fusionSideBarListAdapter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int position) {
        this.this$0.touchPosition = position;
    }
}
