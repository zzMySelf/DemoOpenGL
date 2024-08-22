package com.baidu.searchbox.feed.infrastructure.net.pipeline;

import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.feed.event.FeedRefreshActionEvent;
import com.baidu.searchbox.feed.infrastructure.net.FetchState;
import com.baidu.searchbox.feed.infrastructure.net.pipeline.context.ChainContext;
import com.baidu.texas.context.pipeline.base.Result;

public class RequestAssemble extends BaseSourceStage<Object, Result> implements BaselineStage {
    public RequestAssemble() {
        super(Object.class);
    }

    /* access modifiers changed from: protected */
    public Result runWith(ChainContext context, Object result) {
        BdEventBus.Companion.getDefault().post(new FeedRefreshActionEvent(context.tabId, context.refreshState));
        context.frontend().retechSid();
        long lastRefreshTime = context.frontend().getLastRefreshTime();
        context.assembleGetParam(context.refreshState, lastRefreshTime);
        context.assemblePostParam(context.refreshState, lastRefreshTime);
        return Result.forResult(new FetchState(context.callResult, context));
    }
}
