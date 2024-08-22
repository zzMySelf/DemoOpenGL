package com.baidu.searchbox.player.control.layer;

import com.baidu.searchbox.player.control.element.VulcanVideoPlayButtonElement;
import com.baidu.searchbox.player.slot.ISlotView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/player/slot/ISlotView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VulcanControlSlotLayer.kt */
final class VulcanControlSlotLayer$setupElement$7 extends Lambda implements Function0<ISlotView> {
    public static final VulcanControlSlotLayer$setupElement$7 INSTANCE = new VulcanControlSlotLayer$setupElement$7();

    VulcanControlSlotLayer$setupElement$7() {
        super(0);
    }

    public final ISlotView invoke() {
        return new VulcanVideoPlayButtonElement();
    }
}
