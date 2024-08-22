package com.baidu.searchbox.video.feedflow.flow.authorworks;

import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/authorworks/OnAuthorWorkSpeedBtnClick;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "speed", "", "lastSpeed", "(FF)V", "getLastSpeed", "()F", "getSpeed", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthorWorksActionManifest.kt */
public final class OnAuthorWorkSpeedBtnClick implements Action {
    private final float lastSpeed;
    private final float speed;

    public OnAuthorWorkSpeedBtnClick(float speed2, float lastSpeed2) {
        this.speed = speed2;
        this.lastSpeed = lastSpeed2;
    }

    public final float getLastSpeed() {
        return this.lastSpeed;
    }

    public final float getSpeed() {
        return this.speed;
    }
}
