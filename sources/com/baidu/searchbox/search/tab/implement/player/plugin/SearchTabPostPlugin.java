package com.baidu.searchbox.search.tab.implement.player.plugin;

import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.search.tab.implement.player.PlayerAttachInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/player/plugin/SearchTabPostPlugin;", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "()V", "playerAttachInfo", "Lcom/baidu/searchbox/search/tab/implement/player/PlayerAttachInfo;", "getPlayerAttachInfo", "()Lcom/baidu/searchbox/search/tab/implement/player/PlayerAttachInfo;", "setPlayerAttachInfo", "(Lcom/baidu/searchbox/search/tab/implement/player/PlayerAttachInfo;)V", "getSubscribeEvent", "", "onLayerEventNotify", "", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onPlayerEventNotify", "onPlayerStatusChanged", "status", "Lcom/baidu/searchbox/player/constants/PlayerStatus;", "old", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchTabPostPlugin.kt */
public final class SearchTabPostPlugin extends AbsPlugin {
    private PlayerAttachInfo playerAttachInfo;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SearchTabPostPlugin.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerStatus.values().length];
            iArr[PlayerStatus.PLAYING.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final PlayerAttachInfo getPlayerAttachInfo() {
        return this.playerAttachInfo;
    }

    public final void setPlayerAttachInfo(PlayerAttachInfo playerAttachInfo2) {
        this.playerAttachInfo = playerAttachInfo2;
    }

    public void onLayerEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        switch (action.hashCode()) {
            case 1554330967:
                action.equals("layer_event_hide_poster");
                return;
            default:
                return;
        }
    }

    public void onPlayerStatusChanged(PlayerStatus status, PlayerStatus old) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(old, "old");
        int i2 = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
    }

    public void onPlayerEventNotify(VideoEvent event) {
        PlayerAttachInfo playerAttachInfo2;
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        switch (action.hashCode()) {
            case 1370689931:
                if (action.equals("player_event_on_info")) {
                    int what = event.getIntExtra(1);
                    if ((what == 904 || 956 == what) && (playerAttachInfo2 = this.playerAttachInfo) != null) {
                        playerAttachInfo2.onBeginPlay();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public int[] getSubscribeEvent() {
        return new int[]{4, 5, 3};
    }
}
