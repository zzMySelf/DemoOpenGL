package com.baidu.searchbox.newhome.content.fragment.inter;

import com.baidu.searchbox.launch.IdleLaunchTask;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/newhome/content/fragment/inter/HomeTalosContentFragment$preCreateTalosView$1", "Lcom/baidu/searchbox/launch/IdleLaunchTask;", "execute", "", "new-home-content_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeTalosContentFragment.kt */
public final class HomeTalosContentFragment$preCreateTalosView$1 extends IdleLaunchTask {
    final /* synthetic */ HomeTalosContentFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeTalosContentFragment$preCreateTalosView$1(HomeTalosContentFragment $receiver) {
        super("createTalosView", 3);
        this.this$0 = $receiver;
    }

    public void execute() {
        this.this$0.createTalosView(true);
    }
}
