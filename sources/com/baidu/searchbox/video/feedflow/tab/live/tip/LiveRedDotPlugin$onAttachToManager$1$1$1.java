package com.baidu.searchbox.video.feedflow.tab.live.tip;

import android.content.Context;
import com.baidu.live.feedfollow.BdLiveVideoMixFollow;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveRedDotPlugin.kt */
final class LiveRedDotPlugin$onAttachToManager$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LiveRedDotPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveRedDotPlugin$onAttachToManager$1$1$1(LiveRedDotPlugin liveRedDotPlugin) {
        super(0);
        this.this$0 = liveRedDotPlugin;
    }

    public final void invoke() {
        BdLiveVideoMixFollow bdLiveVideoMixFollow = BdLiveVideoMixFollow.INSTANCE;
        Context access$getContext = this.this$0.getContext();
        final LiveRedDotPlugin liveRedDotPlugin = this.this$0;
        bdLiveVideoMixFollow.queryHasNewLive(access$getContext, new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke(((Boolean) p1).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean hasNewLive) {
                Store access$getStore;
                if (hasNewLive && (access$getStore = liveRedDotPlugin.getStore()) != null) {
                    StoreExtKt.post(access$getStore, HasNewLiveAction.INSTANCE);
                }
            }
        });
    }
}
