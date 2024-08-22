package com.baidu.searchbox.feed.flow.impl;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.rewardsystem.event.TaskVisibleStateChangeEvent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FeedFloatFunctionProcessor$$ExternalSyntheticLambda2 implements Action {
    public final /* synthetic */ FeedFloatFunctionProcessor f$0;

    public /* synthetic */ FeedFloatFunctionProcessor$$ExternalSyntheticLambda2(FeedFloatFunctionProcessor feedFloatFunctionProcessor) {
        this.f$0 = feedFloatFunctionProcessor;
    }

    public final void call(Object obj) {
        FeedFloatFunctionProcessor.m18666registerEventBus$lambda2(this.f$0, (TaskVisibleStateChangeEvent) obj);
    }
}
