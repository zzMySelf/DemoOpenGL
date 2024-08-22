package com.baidu.searchbox.feed.attention.page;

import com.baidu.searchbox.feed.attention.page.processor.AttentionFloatClearListProcessor;
import com.baidu.searchbox.feed.flow.Actions;
import com.baidu.searchbox.feed.flow.impl.LinkageEventProcessor;
import com.baidu.searchbox.feed.flow.impl.PageStateProcessor;
import com.baidu.searchbox.feed.flow.impl.StatisticsProcessor;
import com.baidu.searchbox.feed.silex.processors.SilexEmptyViewProcessor;
import com.baidu.searchbox.feed.silex.processors.SilexLinkageDataUpdateProcessor;
import com.baidu.searchbox.feed.silex.processors.SilexLoadMoreProcessor;
import com.baidu.searchbox.feed.silex.processors.SilexPullLoadingTipsProcessor;
import com.baidu.searchbox.feed.silex.processors.SilexPullToRefreshProcessor;
import com.baidu.searchbox.feed.silex.processors.SilexTemplateProcessor;
import com.baidu.searchbox.feed.silex.refresh.action.AutoLoadMoreAction;
import com.baidu.searchbox.feed.silex.refresh.action.AutoRefreshAction;
import com.baidu.searchbox.feed.silex.refresh.action.FeedItemsSuccessAction;
import com.baidu.searchbox.feed.silex.refresh.action.ListEmptyAction;
import com.baidu.searchbox.feed.silex.refresh.action.LoadMoreHistoryResultAction;
import com.baidu.searchbox.feed.silex.refresh.action.PullPolicySuccessAction;
import com.baidu.searchbox.feed.silex.refresh.action.ServerFeedsResultAction;
import com.baidu.texas.context.AbstractProcessContext;
import com.baidu.texas.context.Action;
import com.baidu.texas.context.Id;
import com.baidu.texas.context.ProcessContext;
import com.baidu.texas.context.Processor;
import com.baidu.texas.context.ProcessorRegistry;
import com.baidu.texas.context.support.ClassId;
import com.baidu.texas.context.support.StringId;
import java.util.Collections;
import java.util.List;

public class AttentionFloatProcessorRegistry_Impl extends AttentionFloatProcessorRegistry implements ProcessorRegistry {
    protected final AttentionFloatClearListProcessor mAttentionFloatClearListProcessor = new AttentionFloatClearListProcessor();
    protected final LinkageEventProcessor mLinkageEventProcessor = new LinkageEventProcessor();
    protected final PageStateProcessor mPageStateProcessor = new PageStateProcessor();
    protected final SilexEmptyViewProcessor mSilexEmptyViewProcessor = new SilexEmptyViewProcessor();
    protected final SilexLinkageDataUpdateProcessor mSilexLinkageDataUpdateProcessor = new SilexLinkageDataUpdateProcessor();
    protected final SilexLoadMoreProcessor mSilexLoadMoreProcessor = new SilexLoadMoreProcessor();
    protected final SilexPullLoadingTipsProcessor mSilexPullLoadingTipsProcessor = new SilexPullLoadingTipsProcessor();
    protected final SilexPullToRefreshProcessor mSilexPullToRefreshProcessor = new SilexPullToRefreshProcessor();
    protected final SilexTemplateProcessor mSilexTemplateProcessor = new SilexTemplateProcessor();
    protected final StatisticsProcessor mStatisticsProcessor = new StatisticsProcessor();

    public void registerProcessorsFor(ProcessContext pProcessContext) {
        AbstractProcessContext abstractProcessContext = (AbstractProcessContext) pProcessContext;
        abstractProcessContext.addProcessors((Class<? extends Action>) Actions.BindItemViewAction.class, fixupProcessorsOfAction(Actions.BindItemViewAction.class, this.mSilexTemplateProcessor));
        abstractProcessContext.addProcessors((Class<? extends Action>) Actions.ItemViewWindowRelationAction.class, fixupProcessorsOfAction(Actions.ItemViewWindowRelationAction.class, this.mStatisticsProcessor, this.mSilexTemplateProcessor));
        abstractProcessContext.addProcessors((Class<? extends Action>) AutoLoadMoreAction.class, fixupProcessorsOfAction(AutoLoadMoreAction.class, this.mSilexLoadMoreProcessor));
        abstractProcessContext.addProcessors((Class<? extends Action>) AutoRefreshAction.class, fixupProcessorsOfAction(AutoRefreshAction.class, this.mSilexPullToRefreshProcessor));
        abstractProcessContext.addProcessors((Class<? extends Action>) FeedItemsSuccessAction.class, fixupProcessorsOfAction(FeedItemsSuccessAction.class, this.mSilexPullToRefreshProcessor, this.mSilexLoadMoreProcessor));
        abstractProcessContext.addProcessors((Class<? extends Action>) ListEmptyAction.class, fixupProcessorsOfAction(ListEmptyAction.class, this.mSilexEmptyViewProcessor));
        abstractProcessContext.addProcessors((Class<? extends Action>) LoadMoreHistoryResultAction.class, fixupProcessorsOfAction(LoadMoreHistoryResultAction.class, this.mSilexLoadMoreProcessor));
        abstractProcessContext.addProcessors((Class<? extends Action>) PullPolicySuccessAction.class, fixupProcessorsOfAction(PullPolicySuccessAction.class, this.mSilexPullLoadingTipsProcessor));
        abstractProcessContext.addProcessors((Class<? extends Action>) ServerFeedsResultAction.class, fixupProcessorsOfAction(ServerFeedsResultAction.class, this.mSilexPullToRefreshProcessor, this.mSilexLoadMoreProcessor));
        abstractProcessContext.addProcessors(Actions.ACTION_ON_CREATE_VIEW, fixupProcessorsOfAction(Actions.ACTION_ON_CREATE_VIEW, this.mPageStateProcessor, this.mSilexPullToRefreshProcessor, this.mLinkageEventProcessor, this.mSilexLinkageDataUpdateProcessor));
        abstractProcessContext.addProcessors(Actions.ACTION_ON_HOME_STATE, fixupProcessorsOfAction(Actions.ACTION_ON_HOME_STATE, this.mPageStateProcessor, this.mSilexPullToRefreshProcessor, this.mStatisticsProcessor));
        abstractProcessContext.addProcessors(Actions.ACTION_ON_REFRESH_OPERATOR, fixupProcessorsOfAction(Actions.ACTION_ON_REFRESH_OPERATOR, this.mSilexPullToRefreshProcessor, this.mStatisticsProcessor));
        abstractProcessContext.addProcessors(Actions.ACTION_ON_RESUME, fixupProcessorsOfAction(Actions.ACTION_ON_RESUME, this.mPageStateProcessor, this.mLinkageEventProcessor, this.mStatisticsProcessor, this.mSilexTemplateProcessor));
        abstractProcessContext.addProcessors(Actions.ACTION_ON_START, fixupProcessorsOfAction(Actions.ACTION_ON_START, this.mPageStateProcessor));
        abstractProcessContext.addProcessors(Actions.ACTION_ON_TAB_STATE, fixupProcessorsOfAction(Actions.ACTION_ON_TAB_STATE, this.mPageStateProcessor, this.mSilexPullToRefreshProcessor, this.mStatisticsProcessor));
        abstractProcessContext.addProcessors(Actions.ACTION_ON_USER_VISIBLE_HINT, fixupProcessorsOfAction(Actions.ACTION_ON_USER_VISIBLE_HINT, this.mPageStateProcessor, this.mLinkageEventProcessor, this.mStatisticsProcessor));
    }

    public void findProcessors(List<Processor> processors, Id actionId) {
        if (actionId instanceof StringId) {
            String type = ((StringId) actionId).id;
            if (type.equals(Actions.ACTION_ON_DESTROY)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ACTION_ON_DESTROY, this.mPageStateProcessor, this.mLinkageEventProcessor, this.mSilexLinkageDataUpdateProcessor, this.mAttentionFloatClearListProcessor));
            } else if (type.equals(Actions.ACTION_ON_PAUSE)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ACTION_ON_PAUSE, this.mPageStateProcessor, this.mSilexPullToRefreshProcessor, this.mStatisticsProcessor));
            } else if (type.equals(Actions.ACTION_ON_STOP)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ACTION_ON_STOP, this.mPageStateProcessor));
            } else if (type.equals(Actions.ACTION_ON_ENTER_PAGE)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ACTION_ON_ENTER_PAGE, this.mPageStateProcessor, this.mSilexPullToRefreshProcessor));
            } else if (type.equals(Actions.ACTION_ON_LEAVE_PAGE)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ACTION_ON_LEAVE_PAGE, this.mPageStateProcessor, this.mSilexPullToRefreshProcessor));
            }
        } else if (actionId instanceof ClassId) {
            Class<T> cls = ((ClassId) actionId).id;
            if (cls.equals(Actions.ExternalRefreshAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ExternalRefreshAction.class, this.mSilexPullToRefreshProcessor));
            } else if (cls.equals(Actions.ItemChildViewClickAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ItemChildViewClickAction.class, this.mSilexTemplateProcessor));
            } else if (cls.equals(Actions.ItemViewClickAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ItemViewClickAction.class, this.mPageStateProcessor, this.mSilexLoadMoreProcessor, this.mSilexTemplateProcessor));
            } else if (cls.equals(Actions.ItemViewLongClickAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ItemViewLongClickAction.class, this.mSilexTemplateProcessor));
            } else if (cls.equals(Actions.PageDispatchTouchAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.PageDispatchTouchAction.class, this.mStatisticsProcessor));
            } else if (cls.equals(Actions.PageTouchAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.PageTouchAction.class, this.mSilexLoadMoreProcessor, this.mStatisticsProcessor));
            } else if (cls.equals(Actions.ScrollDraggingStateAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ScrollDraggingStateAction.class, this.mPageStateProcessor, this.mSilexLoadMoreProcessor));
            } else if (cls.equals(Actions.ScrollIdleStateAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ScrollIdleStateAction.class, this.mPageStateProcessor, this.mSilexLoadMoreProcessor, this.mStatisticsProcessor));
            } else if (cls.equals(Actions.ScrollSettlingStateAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ScrollSettlingStateAction.class, this.mPageStateProcessor));
            } else if (cls.equals(Actions.ScrolledAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ScrolledAction.class, this.mSilexLoadMoreProcessor, this.mStatisticsProcessor));
            } else if (cls.equals(Actions.TemplateItemDeleteAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.TemplateItemDeleteAction.class, this.mSilexLoadMoreProcessor, this.mSilexTemplateProcessor));
            }
        }
    }

    public Processor[] fixupProcessorsOfAction(Object action, Processor... processors) {
        return processors;
    }
}
