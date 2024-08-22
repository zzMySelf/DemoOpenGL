package com.baidu.searchbox.video.channel.flow.detail.unit;

import com.baidu.searchbox.feed.detail.arch.SlotUnit;
import com.baidu.searchbox.feed.detail.arch.UiComponent;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.feedflow.detail.reward.RewardBubbleComponent;
import com.baidu.searchbox.video.feedflow.detail.reward.RewardBubbleReducer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/detail/unit/RewardBubbleUnit;", "Lcom/baidu/searchbox/feed/detail/arch/SlotUnit;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "createMiddlewares", "", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "createPlugin", "Lcom/baidu/searchbox/feed/detail/arch/UiComponent;", "createReducer", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RewardBubbleUnit.kt */
public final class RewardBubbleUnit implements SlotUnit<CommonState> {
    public List<Middleware<CommonState>> createMiddlewares() {
        return CollectionsKt.emptyList();
    }

    public UiComponent createPlugin() {
        return new RewardBubbleComponent();
    }

    public Reducer<CommonState> createReducer() {
        return new RewardBubbleReducer();
    }
}
