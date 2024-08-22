package com.baidu.searchbox.video.feedflow.detail.player;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.detail.player.state.PlayerState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerComponent.kt */
final class PlayerComponent$registerThreeDivideGuide$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ PlayerComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayerComponent$registerThreeDivideGuide$1(PlayerComponent playerComponent) {
        super(0);
        this.this$0 = playerComponent;
    }

    public final Boolean invoke() {
        boolean z;
        Store $this$select$iv = this.this$0.getStore();
        if ($this$select$iv != null) {
            State state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(PlayerState.class);
            }
            PlayerState playerState = (PlayerState) obj;
            if (playerState != null) {
                z = playerState.isThreeDivideGuideShowing();
                return Boolean.valueOf(z);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
