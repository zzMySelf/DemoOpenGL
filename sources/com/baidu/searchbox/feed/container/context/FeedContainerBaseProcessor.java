package com.baidu.searchbox.feed.container.context;

import android.content.Context;
import com.baidu.searchbox.feed.container.FeedContainerAbility;
import com.baidu.searchbox.feed.tab.FeedTabAbility;
import com.baidu.searchbox.feed.tab.FeedTabStickyAbility;
import com.baidu.texas.context.Action;
import com.baidu.texas.context.Id;
import com.baidu.texas.context.ProcessState;
import com.baidu.texas.context.processors.MappedActionProcessor;
import com.baidu.texas.context.support.StringId;

public abstract class FeedContainerBaseProcessor extends MappedActionProcessor {
    public FeedContainerBaseProcessor() {
        super((Id) null);
    }

    public final ProcessState process(ProcessState state, Action action) {
        ContainerState containerState = onProcess((ContainerState) state, action);
        return super.process(containerState != null ? containerState : state, action);
    }

    /* access modifiers changed from: protected */
    public final FeedContainerContext getProcessContext() {
        return (FeedContainerContext) super.getProcessContext();
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return getProcessContext().getContext();
    }

    /* access modifiers changed from: protected */
    public ContainerState onProcess(ContainerState state, Action action) {
        return state;
    }

    /* access modifiers changed from: protected */
    public Id createId() {
        return new StringId(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public FeedContainerAbility getFeedContainer() {
        return (FeedContainerAbility) getProcessContext().getPage().queryAbility(FeedContainerAbility.class);
    }

    /* access modifiers changed from: protected */
    public FeedTabAbility getFeedTab() {
        return (FeedTabAbility) getProcessContext().getPage().queryAbility(FeedTabAbility.class);
    }

    /* access modifiers changed from: protected */
    public FeedTabStickyAbility getFeedTabStickyUI() {
        return (FeedTabStickyAbility) getProcessContext().getPage().queryAbility(FeedTabStickyAbility.class);
    }
}
