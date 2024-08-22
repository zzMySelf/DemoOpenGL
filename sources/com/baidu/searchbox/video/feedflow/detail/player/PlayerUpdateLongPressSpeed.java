package com.baidu.searchbox.video.feedflow.detail.player;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/player/PlayerUpdateLongPressSpeed;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "speed", "", "oldSpeed", "isInClearScreen", "", "(FFZ)V", "()Z", "getOldSpeed", "()F", "getSpeed", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: PlayerActionManifest.kt */
public final class PlayerUpdateLongPressSpeed implements Action {
    private final boolean isInClearScreen;
    private final float oldSpeed;
    private final float speed;

    public PlayerUpdateLongPressSpeed(float speed2, float oldSpeed2, boolean isInClearScreen2) {
        this.speed = speed2;
        this.oldSpeed = oldSpeed2;
        this.isInClearScreen = isInClearScreen2;
    }

    public final float getOldSpeed() {
        return this.oldSpeed;
    }

    public final float getSpeed() {
        return this.speed;
    }

    public final boolean isInClearScreen() {
        return this.isInClearScreen;
    }
}
