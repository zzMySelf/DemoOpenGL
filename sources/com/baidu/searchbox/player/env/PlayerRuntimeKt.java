package com.baidu.searchbox.player.env;

import com.baidu.searchbox.player.constants.PlayerStatus;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\f\u0010\u0002\u001a\u00020\u0003*\u0004\u0018\u00010\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000*\n\u0010\u0005\"\u00020\u00012\u00020\u0001*\n\u0010\u0006\"\u00020\u00012\u00020\u0001*\n\u0010\u0007\"\u00020\u00012\u00020\u0001*\n\u0010\b\"\u00020\u00012\u00020\u0001¨\u0006\t"}, d2 = {"DEFAULT_THREAD_NAME", "", "isPrepareStatus", "", "Lcom/baidu/searchbox/player/constants/PlayerStatus;", "ExtLog", "From", "Page", "Source", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerRuntime.kt */
public final class PlayerRuntimeKt {
    private static final String DEFAULT_THREAD_NAME = "base_videoplayer";

    public static final boolean isPrepareStatus(PlayerStatus $this$isPrepareStatus) {
        return $this$isPrepareStatus == PlayerStatus.PREPARED || $this$isPrepareStatus == PlayerStatus.PREPARING;
    }
}
