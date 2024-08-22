package com.baidu.searchbox.video.feedflow.detail.air.clarity;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.player.model.ClarityUrlList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/air/clarity/AirPlayClaritySwitchAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "clarityUrl", "Lcom/baidu/searchbox/player/model/ClarityUrlList$ClarityUrl;", "(Lcom/baidu/searchbox/player/model/ClarityUrlList$ClarityUrl;)V", "getClarityUrl", "()Lcom/baidu/searchbox/player/model/ClarityUrlList$ClarityUrl;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: AirPlayClarityPanelActionManifest.kt */
public final class AirPlayClaritySwitchAction implements Action {
    private final ClarityUrlList.ClarityUrl clarityUrl;

    public AirPlayClaritySwitchAction(ClarityUrlList.ClarityUrl clarityUrl2) {
        Intrinsics.checkNotNullParameter(clarityUrl2, "clarityUrl");
        this.clarityUrl = clarityUrl2;
    }

    public final ClarityUrlList.ClarityUrl getClarityUrl() {
        return this.clarityUrl;
    }
}
