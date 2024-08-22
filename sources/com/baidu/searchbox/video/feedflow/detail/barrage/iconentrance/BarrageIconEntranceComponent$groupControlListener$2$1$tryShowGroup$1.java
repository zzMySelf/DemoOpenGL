package com.baidu.searchbox.video.feedflow.detail.barrage.iconentrance;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BarrageIconEntranceComponent.kt */
final class BarrageIconEntranceComponent$groupControlListener$2$1$tryShowGroup$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BarrageIconEntranceComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BarrageIconEntranceComponent$groupControlListener$2$1$tryShowGroup$1(BarrageIconEntranceComponent barrageIconEntranceComponent) {
        super(0);
        this.this$0 = barrageIconEntranceComponent;
    }

    public final void invoke() {
        Store $this$select$iv = this.this$0.getStore();
        if ($this$select$iv != null) {
            State state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(BarrageIconEntranceState.class);
            }
            BarrageIconEntranceState barrageIconEntranceState = (BarrageIconEntranceState) obj;
            if (barrageIconEntranceState != null) {
                BarrageIconEntranceState $this$invoke_u24lambda_u2d0 = barrageIconEntranceState;
                if ($this$invoke_u24lambda_u2d0.getCanShow() && !Intrinsics.areEqual((Object) $this$invoke_u24lambda_u2d0.getVisible().getValue(), (Object) true)) {
                    $this$invoke_u24lambda_u2d0.getVisible().setValue(true);
                }
            }
        }
    }
}
