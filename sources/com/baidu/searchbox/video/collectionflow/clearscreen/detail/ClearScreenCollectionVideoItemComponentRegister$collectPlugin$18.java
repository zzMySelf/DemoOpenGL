package com.baidu.searchbox.video.collectionflow.clearscreen.detail;

import com.baidu.searchbox.feed.detail.arch.api.IPlugin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/arch/api/IPlugin;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearScreenCollectionVideoItemComponentRegister.kt */
final class ClearScreenCollectionVideoItemComponentRegister$collectPlugin$18 extends Lambda implements Function0<IPlugin> {
    final /* synthetic */ ClearScreenCollectionVideoItemComponentRegister this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClearScreenCollectionVideoItemComponentRegister$collectPlugin$18(ClearScreenCollectionVideoItemComponentRegister clearScreenCollectionVideoItemComponentRegister) {
        super(0);
        this.this$0 = clearScreenCollectionVideoItemComponentRegister;
    }

    public final IPlugin invoke() {
        return this.this$0.getProvider().getLongPressNewMoreUnit().createPlugin();
    }
}
