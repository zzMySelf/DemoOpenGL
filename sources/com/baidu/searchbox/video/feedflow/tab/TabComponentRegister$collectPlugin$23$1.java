package com.baidu.searchbox.video.feedflow.tab;

import com.baidu.searchbox.feed.detail.arch.SlotUnit;
import com.baidu.searchbox.feed.detail.arch.api.IPlugin;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/arch/api/IPlugin;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabComponentRegister.kt */
final class TabComponentRegister$collectPlugin$23$1 extends Lambda implements Function0<IPlugin> {
    final /* synthetic */ SlotUnit<CommonState> $this_run;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabComponentRegister$collectPlugin$23$1(SlotUnit<CommonState> slotUnit) {
        super(0);
        this.$this_run = slotUnit;
    }

    public final IPlugin invoke() {
        return this.$this_run.createPlugin();
    }
}
