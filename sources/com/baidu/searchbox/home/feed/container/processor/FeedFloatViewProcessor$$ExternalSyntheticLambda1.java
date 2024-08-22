package com.baidu.searchbox.home.feed.container.processor;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.feed.tab.interaction.tts.TTSPlayerAnimEvent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FeedFloatViewProcessor$$ExternalSyntheticLambda1 implements Action {
    public final /* synthetic */ FeedFloatViewProcessor f$0;

    public /* synthetic */ FeedFloatViewProcessor$$ExternalSyntheticLambda1(FeedFloatViewProcessor feedFloatViewProcessor) {
        this.f$0 = feedFloatViewProcessor;
    }

    public final void call(Object obj) {
        FeedFloatViewProcessor.m20067registerEventBus$lambda2(this.f$0, (TTSPlayerAnimEvent) obj);
    }
}
