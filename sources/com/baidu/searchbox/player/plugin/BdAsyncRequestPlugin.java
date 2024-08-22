package com.baidu.searchbox.player.plugin;

import com.baidu.searchbox.card.util.CardConstants;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/player/plugin/BdAsyncRequestPlugin;", "Lcom/baidu/searchbox/player/plugin/AsyncRequestPlugin;", "()V", "getBindPlayer", "Lcom/baidu/searchbox/player/BaseVideoPlayer;", "updateFreeUrl", "", "series", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "lib-player-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BdAsyncRequestPlugin.kt */
public final class BdAsyncRequestPlugin extends AsyncRequestPlugin {
    public void updateFreeUrl(BasicVideoSeries series) {
        Intrinsics.checkNotNullParameter(series, CardConstants.CARD_ITEM_FOLLOW_SERIES);
        BaseVideoPlayer bindPlayer = getBindPlayer();
        if (bindPlayer != null) {
            bindPlayer.updateFreeUrl(series.getPlayUrl());
        }
    }

    public BaseVideoPlayer getBindPlayer() {
        BDVideoPlayer bindPlayer = super.getBindPlayer();
        if (bindPlayer instanceof BaseVideoPlayer) {
            return (BaseVideoPlayer) bindPlayer;
        }
        return null;
    }
}
