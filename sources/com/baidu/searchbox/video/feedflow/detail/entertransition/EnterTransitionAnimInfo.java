package com.baidu.searchbox.video.feedflow.detail.entertransition;

import android.view.ViewGroup;
import com.baidu.searchbox.player.BaseVideoPlayer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/entertransition/EnterTransitionAnimInfo;", "", "playerHolder", "Landroid/view/ViewGroup;", "player", "Lcom/baidu/searchbox/player/BaseVideoPlayer;", "portraitContainer", "(Landroid/view/ViewGroup;Lcom/baidu/searchbox/player/BaseVideoPlayer;Landroid/view/ViewGroup;)V", "getPlayer", "()Lcom/baidu/searchbox/player/BaseVideoPlayer;", "setPlayer", "(Lcom/baidu/searchbox/player/BaseVideoPlayer;)V", "getPlayerHolder", "()Landroid/view/ViewGroup;", "setPlayerHolder", "(Landroid/view/ViewGroup;)V", "getPortraitContainer", "setPortraitContainer", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EnterTransitionAnimState.kt */
public final class EnterTransitionAnimInfo {
    private BaseVideoPlayer player;
    private ViewGroup playerHolder;
    private ViewGroup portraitContainer;

    public EnterTransitionAnimInfo(ViewGroup playerHolder2, BaseVideoPlayer player2, ViewGroup portraitContainer2) {
        this.playerHolder = playerHolder2;
        this.player = player2;
        this.portraitContainer = portraitContainer2;
    }

    public final BaseVideoPlayer getPlayer() {
        return this.player;
    }

    public final ViewGroup getPlayerHolder() {
        return this.playerHolder;
    }

    public final ViewGroup getPortraitContainer() {
        return this.portraitContainer;
    }

    public final void setPlayer(BaseVideoPlayer baseVideoPlayer) {
        this.player = baseVideoPlayer;
    }

    public final void setPlayerHolder(ViewGroup viewGroup) {
        this.playerHolder = viewGroup;
    }

    public final void setPortraitContainer(ViewGroup viewGroup) {
        this.portraitContainer = viewGroup;
    }
}
