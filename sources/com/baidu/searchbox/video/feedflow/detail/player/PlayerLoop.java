package com.baidu.searchbox.video.feedflow.detail.player;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/player/PlayerLoop;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "LoopCount", "", "(I)V", "getLoopCount", "()I", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: PlayerActionManifest.kt */
public final class PlayerLoop implements Action {
    private final int LoopCount;

    public PlayerLoop(int LoopCount2) {
        this.LoopCount = LoopCount2;
    }

    public final int getLoopCount() {
        return this.LoopCount;
    }
}
