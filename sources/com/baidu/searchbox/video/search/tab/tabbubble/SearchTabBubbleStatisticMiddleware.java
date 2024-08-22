package com.baidu.searchbox.video.search.tab.tabbubble;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.detail.tabguide.OnTabBubbleShowStatistic;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.playmode.PlayMode;
import com.baidu.searchbox.video.feedflow.flow.playmode.PlayModePluginKt;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/search/tab/tabbubble/SearchTabBubbleStatisticMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "search-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchTabBubbleStatisticMiddleware.kt */
public final class SearchTabBubbleStatisticMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        String str;
        Store<CommonState> store2 = store;
        Action action2 = action;
        Next<CommonState> next2 = next;
        Intrinsics.checkNotNullParameter(store2, "store");
        Intrinsics.checkNotNullParameter(action2, "action");
        Intrinsics.checkNotNullParameter(next2, "next");
        if (action2 instanceof OnTabBubbleShowStatistic) {
            CommonState state = store.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? state : null;
            IntentData intentData = (IntentData) (commonState != null ? commonState.select(IntentData.class) : null);
            boolean isColdStart = intentData != null ? Intrinsics.areEqual((Object) intentData.isColdLaunchRestore, (Object) true) : false;
            PlayMode playMode = PlayModePluginKt.getCurPlayMode((Store<?>) store);
            VideoFlowUBCHelper videoFlowUBCHelper = VideoFlowUBCHelper.INSTANCE;
            CommonState state2 = store.getState();
            CommonState commonState2 = state2 instanceof CommonState ? state2 : null;
            if (commonState2 != null) {
                obj = commonState2.select(ItemModel.class);
            }
            JSONObject ext = videoFlowUBCHelper.buildAllExt((ItemModel) obj, false, ((OnTabBubbleShowStatistic) action2).getExt(), isColdStart, playMode);
            if (ext == null) {
                ext = ((OnTabBubbleShowStatistic) action2).getExt();
            }
            VideoFlowUBCHelper videoFlowUBCHelper2 = VideoFlowUBCHelper.INSTANCE;
            CommonState state3 = store.getState();
            if (ext == null || (str = ext.toString()) == null) {
                str = "";
            }
            VideoFlowUBCHelper.uploadUbc6037$default(videoFlowUBCHelper2, state3, "show", "guide_bubble", (String) null, (String) null, str, (String) null, 88, (Object) null);
        }
        return next2.next(store2, action2);
    }
}
