package com.baidu.searchbox.music.comp.player.ext;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerNewExtComp.kt */
final class PlayerNewExtComp$playerSeekBarComp$1$1 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ PlayerNewExtComp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayerNewExtComp$playerSeekBarComp$1$1(PlayerNewExtComp playerNewExtComp) {
        super(1);
        this.this$0 = playerNewExtComp;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long it) {
        this.this$0.startTracking();
        Function1<Long, Unit> seekbarChangeCallback = this.this$0.getSeekbarChangeCallback();
        if (seekbarChangeCallback != null) {
            seekbarChangeCallback.invoke(Long.valueOf(it));
        }
    }
}
