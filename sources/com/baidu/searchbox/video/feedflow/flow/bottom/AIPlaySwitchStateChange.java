package com.baidu.searchbox.video.feedflow.flow.bottom;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.flow.playmode.PlayMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/bottom/AIPlaySwitchStateChange;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "playMode", "Lcom/baidu/searchbox/video/feedflow/flow/playmode/PlayMode;", "(Lcom/baidu/searchbox/video/feedflow/flow/playmode/PlayMode;)V", "getPlayMode", "()Lcom/baidu/searchbox/video/feedflow/flow/playmode/PlayMode;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: BottonBarActionManifest.kt */
public final class AIPlaySwitchStateChange implements Action {
    private final PlayMode playMode;

    public AIPlaySwitchStateChange(PlayMode playMode2) {
        Intrinsics.checkNotNullParameter(playMode2, IntentData.KEY_COLLECTION_MODE);
        this.playMode = playMode2;
    }

    public final PlayMode getPlayMode() {
        return this.playMode;
    }
}
