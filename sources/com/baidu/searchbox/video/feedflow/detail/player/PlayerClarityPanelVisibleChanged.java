package com.baidu.searchbox.video.feedflow.detail.player;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/player/PlayerClarityPanelVisibleChanged;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "isVisible", "", "clarityKeyArray", "Lorg/json/JSONArray;", "(ZLorg/json/JSONArray;)V", "getClarityKeyArray", "()Lorg/json/JSONArray;", "()Z", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: PlayerActionManifest.kt */
public final class PlayerClarityPanelVisibleChanged implements Action {
    private final JSONArray clarityKeyArray;
    private final boolean isVisible;

    public PlayerClarityPanelVisibleChanged(boolean isVisible2, JSONArray clarityKeyArray2) {
        Intrinsics.checkNotNullParameter(clarityKeyArray2, "clarityKeyArray");
        this.isVisible = isVisible2;
        this.clarityKeyArray = clarityKeyArray2;
    }

    public final JSONArray getClarityKeyArray() {
        return this.clarityKeyArray;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }
}
