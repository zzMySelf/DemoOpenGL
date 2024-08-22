package com.baidu.searchbox.video.feedflow.flow.bottom;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.flow.playmode.PlayMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/bottom/AIPlaySwitchClick;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "clickedBeforePlayMode", "Lcom/baidu/searchbox/video/feedflow/flow/playmode/PlayMode;", "playMode", "(Lcom/baidu/searchbox/video/feedflow/flow/playmode/PlayMode;Lcom/baidu/searchbox/video/feedflow/flow/playmode/PlayMode;)V", "getClickedBeforePlayMode", "()Lcom/baidu/searchbox/video/feedflow/flow/playmode/PlayMode;", "getPlayMode", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: BottonBarActionManifest.kt */
public final class AIPlaySwitchClick implements Action {
    private final PlayMode clickedBeforePlayMode;
    private final PlayMode playMode;

    public static /* synthetic */ AIPlaySwitchClick copy$default(AIPlaySwitchClick aIPlaySwitchClick, PlayMode playMode2, PlayMode playMode3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            playMode2 = aIPlaySwitchClick.clickedBeforePlayMode;
        }
        if ((i2 & 2) != 0) {
            playMode3 = aIPlaySwitchClick.playMode;
        }
        return aIPlaySwitchClick.copy(playMode2, playMode3);
    }

    public final PlayMode component1() {
        return this.clickedBeforePlayMode;
    }

    public final PlayMode component2() {
        return this.playMode;
    }

    public final AIPlaySwitchClick copy(PlayMode playMode2, PlayMode playMode3) {
        Intrinsics.checkNotNullParameter(playMode2, "clickedBeforePlayMode");
        Intrinsics.checkNotNullParameter(playMode3, IntentData.KEY_COLLECTION_MODE);
        return new AIPlaySwitchClick(playMode2, playMode3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AIPlaySwitchClick)) {
            return false;
        }
        AIPlaySwitchClick aIPlaySwitchClick = (AIPlaySwitchClick) obj;
        return this.clickedBeforePlayMode == aIPlaySwitchClick.clickedBeforePlayMode && this.playMode == aIPlaySwitchClick.playMode;
    }

    public int hashCode() {
        return (this.clickedBeforePlayMode.hashCode() * 31) + this.playMode.hashCode();
    }

    public String toString() {
        return "AIPlaySwitchClick(clickedBeforePlayMode=" + this.clickedBeforePlayMode + ", playMode=" + this.playMode + ')';
    }

    public AIPlaySwitchClick(PlayMode clickedBeforePlayMode2, PlayMode playMode2) {
        Intrinsics.checkNotNullParameter(clickedBeforePlayMode2, "clickedBeforePlayMode");
        Intrinsics.checkNotNullParameter(playMode2, IntentData.KEY_COLLECTION_MODE);
        this.clickedBeforePlayMode = clickedBeforePlayMode2;
        this.playMode = playMode2;
    }

    public final PlayMode getClickedBeforePlayMode() {
        return this.clickedBeforePlayMode;
    }

    public final PlayMode getPlayMode() {
        return this.playMode;
    }
}
