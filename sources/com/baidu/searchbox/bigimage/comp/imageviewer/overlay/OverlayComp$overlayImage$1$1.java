package com.baidu.searchbox.bigimage.comp.imageviewer.overlay;

import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.bigimage.event.ImageDragHorizontallyToEnd;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OverlayComp.kt */
final class OverlayComp$overlayImage$1$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ UniqueId $token;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OverlayComp$overlayImage$1$1(UniqueId uniqueId) {
        super(1);
        this.$token = uniqueId;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float it) {
        BdEventBus.Companion.getDefault().post(new ImageDragHorizontallyToEnd(this.$token, it));
    }
}
