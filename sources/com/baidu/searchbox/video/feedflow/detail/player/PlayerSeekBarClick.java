package com.baidu.searchbox.video.feedflow.detail.player;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/player/PlayerSeekBarClick;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "progress", "", "(I)V", "getProgress", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: PlayerActionManifest.kt */
public final class PlayerSeekBarClick implements Action {
    private final int progress;

    public static /* synthetic */ PlayerSeekBarClick copy$default(PlayerSeekBarClick playerSeekBarClick, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = playerSeekBarClick.progress;
        }
        return playerSeekBarClick.copy(i2);
    }

    public final int component1() {
        return this.progress;
    }

    public final PlayerSeekBarClick copy(int i2) {
        return new PlayerSeekBarClick(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PlayerSeekBarClick) && this.progress == ((PlayerSeekBarClick) obj).progress;
    }

    public int hashCode() {
        return Integer.hashCode(this.progress);
    }

    public String toString() {
        return "PlayerSeekBarClick(progress=" + this.progress + ')';
    }

    public PlayerSeekBarClick(int progress2) {
        this.progress = progress2;
    }

    public final int getProgress() {
        return this.progress;
    }
}
