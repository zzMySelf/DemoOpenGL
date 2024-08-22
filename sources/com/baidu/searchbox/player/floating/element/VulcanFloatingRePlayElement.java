package com.baidu.searchbox.player.floating.element;

import com.baidu.searchbox.floating.element.SimpleFloatingRePlayElement;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.BaseVulcanVideoPlayer;
import com.baidu.searchbox.player.callback.BaseVulcanVideoPlayerCallbackManager;
import com.baidu.searchbox.videoplayer.vulcan.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/player/floating/element/VulcanFloatingRePlayElement;", "Lcom/baidu/searchbox/floating/element/SimpleFloatingRePlayElement;", "()V", "initElement", "", "onRePlayViewClick", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VulcanFloatingRePlayElement.kt */
public final class VulcanFloatingRePlayElement extends SimpleFloatingRePlayElement {
    /* access modifiers changed from: protected */
    public void onRePlayViewClick() {
        BaseVulcanVideoPlayerCallbackManager playerCallbackManager;
        super.onRePlayViewClick();
        BDVideoPlayer videoPlayer = getVideoPlayer();
        BaseVulcanVideoPlayer baseVulcanVideoPlayer = videoPlayer instanceof BaseVulcanVideoPlayer ? (BaseVulcanVideoPlayer) videoPlayer : null;
        if (baseVulcanVideoPlayer != null && (playerCallbackManager = baseVulcanVideoPlayer.getPlayerCallbackManager()) != null) {
            playerCallbackManager.onFloatingReplayClick();
        }
    }

    public void initElement() {
        super.initElement();
        getContentView().setId(R.id.videoplayer_vulcan_floating_replay_button);
    }
}
