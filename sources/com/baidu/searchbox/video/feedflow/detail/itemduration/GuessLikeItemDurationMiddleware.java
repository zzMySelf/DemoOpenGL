package com.baidu.searchbox.video.feedflow.detail.itemduration;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerFirstFrame;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerPause;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerResume;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/itemduration/GuessLikeItemDurationMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "playDuration", "", "playStartTime", "", "position", "videoDuration", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GuessLikeVideoItemDurationMiddleware.kt */
public final class GuessLikeItemDurationMiddleware implements Middleware<CommonState> {
    private int playDuration;
    private long playStartTime;
    private int position;
    private int videoDuration;

    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof PlayerFirstFrame) {
            this.videoDuration = ((PlayerFirstFrame) action).getDurationMs() / 1000;
            this.playStartTime = System.currentTimeMillis();
        } else if (action instanceof PlayerPause) {
            if (this.playStartTime > 0) {
                this.playDuration += (int) ((System.currentTimeMillis() - this.playStartTime) / ((long) 1000));
                this.playStartTime = 0;
            }
        } else if (action instanceof PlayerResume) {
            this.playStartTime = System.currentTimeMillis();
        } else if (action instanceof NestedAction.OnPageSelected) {
            this.position = ((NestedAction.OnPageSelected) action).getPosition();
        } else if (action instanceof NestedAction.OnDetachFromScreen) {
            if (this.playStartTime > 0) {
                this.playDuration += (int) ((System.currentTimeMillis() - this.playStartTime) / ((long) 1000));
                this.playStartTime = 0;
            }
            if (CommonStateExtKt.isActive(store)) {
                StoreExtKt.post(store, new GuessLikeVideoItemDurationAction(this.position, this.playDuration, this.videoDuration));
            }
            this.playDuration = 0;
            this.playStartTime = 0;
        }
        return next.next(store, action);
    }
}
