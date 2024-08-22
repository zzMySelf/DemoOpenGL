package com.baidu.searchbox.feed.topicdetail.biserial;

import com.baidu.searchbox.feed.biserial.action.AfterFirstBindViewHolderAction;
import com.baidu.searchbox.feed.biserial.action.DislikePopupConfigAction;
import com.baidu.searchbox.feed.biserial.action.RefreshSuccessAction;
import com.baidu.searchbox.feed.biserial.processors.BiSerialFlowTemplateProcessor;
import com.baidu.searchbox.feed.biserial.processors.HDImagePrefetchProcessor;
import com.baidu.searchbox.feed.flow.Actions;
import com.baidu.searchbox.feed.flow.impl.PageStateProcessor;
import com.baidu.searchbox.feed.topicdetail.biserial.processors.TopicBiSerialFlowRefreshProcessor;
import com.baidu.searchbox.feed.topicdetail.biserial.processors.TopicBiSerialLinkageEventProcessor;
import com.baidu.searchbox.feed.topicdetail.biserial.processors.TopicStatisticsProcessor;
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

public class TopicBiSerialProcessorRegistry_Impl extends TopicBiSerialProcessorRegistry implements ProcessorRegistry {
    protected final BiSerialFlowTemplateProcessor mBiSerialFlowTemplateProcessor = new BiSerialFlowTemplateProcessor();
    protected final HDImagePrefetchProcessor mHDImagePrefetchProcessor = new HDImagePrefetchProcessor();
    protected final PageStateProcessor mPageStateProcessor = new PageStateProcessor();
    protected final TopicBiSerialFlowRefreshProcessor mTopicBiSerialFlowRefreshProcessor = new TopicBiSerialFlowRefreshProcessor();
    protected final TopicBiSerialLinkageEventProcessor mTopicBiSerialLinkageEventProcessor = new TopicBiSerialLinkageEventProcessor();
    protected final TopicStatisticsProcessor mTopicStatisticsProcessor = new TopicStatisticsProcessor();

    public void registerProcessorsFor(ProcessContext pProcessContext) {
        AbstractProcessContext abstractProcessContext = (AbstractProcessContext) pProcessContext;
        abstractProcessContext.addProcessors((Class<? extends Action>) AfterFirstBindViewHolderAction.class, fixupProcessorsOfAction(AfterFirstBindViewHolderAction.class, this.mTopicBiSerialFlowRefreshProcessor));
        abstractProcessContext.addProcessors((Class<? extends Action>) Actions.BindItemViewAction.class, fixupProcessorsOfAction(Actions.BindItemViewAction.class, this.mBiSerialFlowTemplateProcessor, this.mTopicStatisticsProcessor));
        abstractProcessContext.addProcessors((Class<? extends Action>) Actions.ItemViewWindowRelationAction.class, fixupProcessorsOfAction(Actions.ItemViewWindowRelationAction.class, this.mBiSerialFlowTemplateProcessor));
        abstractProcessContext.addProcessors(Actions.ACTION_ON_CREATE_VIEW, fixupProcessorsOfAction(Actions.ACTION_ON_CREATE_VIEW, this.mPageStateProcessor, this.mBiSerialFlowTemplateProcessor, this.mTopicStatisticsProcessor));
        abstractProcessContext.addProcessors(Actions.ACTION_ON_HOME_STATE, fixupProcessorsOfAction(Actions.ACTION_ON_HOME_STATE, this.mPageStateProcessor));
        abstractProcessContext.addProcessors(Actions.ACTION_ON_REFRESH_OPERATOR, fixupProcessorsOfAction(Actions.ACTION_ON_REFRESH_OPERATOR, this.mBiSerialFlowTemplateProcessor));
        abstractProcessContext.addProcessors(Actions.ACTION_ON_RESUME, fixupProcessorsOfAction(Actions.ACTION_ON_RESUME, this.mPageStateProcessor, this.mTopicBiSerialFlowRefreshProcessor, this.mBiSerialFlowTemplateProcessor, this.mTopicBiSerialLinkageEventProcessor));
        abstractProcessContext.addProcessors(Actions.ACTION_ON_START, fixupProcessorsOfAction(Actions.ACTION_ON_START, this.mPageStateProcessor));
        abstractProcessContext.addProcessors(Actions.ACTION_ON_TAB_STATE, fixupProcessorsOfAction(Actions.ACTION_ON_TAB_STATE, this.mPageStateProcessor));
        abstractProcessContext.addProcessors(Actions.ACTION_ON_USER_VISIBLE_HINT, fixupProcessorsOfAction(Actions.ACTION_ON_USER_VISIBLE_HINT, this.mPageStateProcessor, this.mTopicBiSerialLinkageEventProcessor));
    }

    public void findProcessors(List<Processor> processors, Id actionId) {
        if (actionId instanceof StringId) {
            String type = ((StringId) actionId).id;
            if (type.equals(Actions.ACTION_ON_DESTROY)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ACTION_ON_DESTROY, this.mPageStateProcessor, this.mBiSerialFlowTemplateProcessor));
            } else if (type.equals(Actions.ACTION_ON_PAUSE)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ACTION_ON_PAUSE, this.mPageStateProcessor));
            } else if (type.equals(Actions.ACTION_ON_STOP)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ACTION_ON_STOP, this.mPageStateProcessor));
            } else if (type.equals(Actions.ACTION_ON_ENTER_PAGE)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ACTION_ON_ENTER_PAGE, this.mPageStateProcessor));
            } else if (type.equals(Actions.ACTION_ON_LEAVE_PAGE)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ACTION_ON_LEAVE_PAGE, this.mPageStateProcessor));
            }
        } else if (actionId instanceof ClassId) {
            Class<T> cls = ((ClassId) actionId).id;
            if (cls.equals(DislikePopupConfigAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(DislikePopupConfigAction.class, this.mBiSerialFlowTemplateProcessor));
            } else if (cls.equals(RefreshSuccessAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(RefreshSuccessAction.class, this.mHDImagePrefetchProcessor));
            } else if (cls.equals(Actions.ItemChildViewClickAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ItemChildViewClickAction.class, this.mBiSerialFlowTemplateProcessor));
            } else if (cls.equals(Actions.ItemViewClickAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ItemViewClickAction.class, this.mPageStateProcessor, this.mTopicBiSerialFlowRefreshProcessor, this.mBiSerialFlowTemplateProcessor));
            } else if (cls.equals(Actions.ItemViewLongClickAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ItemViewLongClickAction.class, this.mBiSerialFlowTemplateProcessor));
            } else if (cls.equals(Actions.PageDispatchTouchAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.PageDispatchTouchAction.class, this.mBiSerialFlowTemplateProcessor));
            } else if (cls.equals(Actions.PageSelectedAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.PageSelectedAction.class, this.mTopicBiSerialFlowRefreshProcessor, this.mBiSerialFlowTemplateProcessor));
            } else if (cls.equals(Actions.ScrollDraggingStateAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ScrollDraggingStateAction.class, this.mPageStateProcessor, this.mBiSerialFlowTemplateProcessor));
            } else if (cls.equals(Actions.ScrollIdleStateAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ScrollIdleStateAction.class, this.mPageStateProcessor, this.mBiSerialFlowTemplateProcessor, this.mHDImagePrefetchProcessor, this.mTopicStatisticsProcessor));
            } else if (cls.equals(Actions.ScrollSettlingStateAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ScrollSettlingStateAction.class, this.mPageStateProcessor, this.mBiSerialFlowTemplateProcessor));
            } else if (cls.equals(Actions.ScrolledAction.class)) {
                Collections.addAll(processors, fixupProcessorsOfAction(Actions.ScrolledAction.class, this.mTopicBiSerialFlowRefreshProcessor, this.mBiSerialFlowTemplateProcessor, this.mTopicStatisticsProcessor));
            }
        }
    }

    public Processor[] fixupProcessorsOfAction(Object action, Processor... processors) {
        return processors;
    }
}
