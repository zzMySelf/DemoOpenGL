package com.baidu.searchbox.combinepublisher.fragment.mvp;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/frame/AbsStore;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MvpPublisherFragment.kt */
final class MvpPublisherFragment$store$2 extends Lambda implements Function0<AbsStore<CommonState>> {
    final /* synthetic */ MvpPublisherFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MvpPublisherFragment$store$2(MvpPublisherFragment mvpPublisherFragment) {
        super(0);
        this.this$0 = mvpPublisherFragment;
    }

    public final AbsStore<CommonState> invoke() {
        return this.this$0.createStore();
    }
}
