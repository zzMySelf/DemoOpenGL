package com.baidu.searchbox.video.hotflow.detail;

import com.baidu.searchbox.feed.detail.arch.SlotComponentUnit;
import com.baidu.searchbox.feed.detail.arch.UiComponent;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/arch/UiComponent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotVideoItemComponentRegister.kt */
final class HotVideoItemComponentRegister$collectComponent$38$1 extends Lambda implements Function0<UiComponent> {
    final /* synthetic */ SlotComponentUnit<CommonState> $this_run;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HotVideoItemComponentRegister$collectComponent$38$1(SlotComponentUnit<CommonState> slotComponentUnit) {
        super(0);
        this.$this_run = slotComponentUnit;
    }

    public final UiComponent invoke() {
        return this.$this_run.createComponent();
    }
}
