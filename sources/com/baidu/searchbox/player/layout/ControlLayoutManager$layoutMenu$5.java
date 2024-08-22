package com.baidu.searchbox.player.layout;

import com.baidu.searchbox.player.slot.ISlotView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/player/slot/ISlotView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ControlLayoutManager.kt */
final class ControlLayoutManager$layoutMenu$5 extends Lambda implements Function1<ISlotView, Unit> {
    final /* synthetic */ ControlLayoutManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ControlLayoutManager$layoutMenu$5(ControlLayoutManager controlLayoutManager) {
        super(1);
        this.this$0 = controlLayoutManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((ISlotView) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(ISlotView $this$isAttach) {
        Intrinsics.checkNotNullParameter($this$isAttach, "$this$isAttach");
        ControlLayoutManager.connectMenu$default(this.this$0, $this$isAttach.getView(), 1, 0, 4, (Object) null);
    }
}
