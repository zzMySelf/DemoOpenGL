package com.baidu.searchbox.feed.hot.search.processor;

import com.baidu.searchbox.feed.flow.Actions;
import com.baidu.searchbox.feed.flow.FeedFlowContext;
import com.baidu.searchbox.feed.flow.FlowProcessor;
import com.baidu.searchbox.feed.flow.FlowState;
import com.baidu.searchbox.feed.flow.extension.IHotSearchUnfoldMoreProcessExtension;
import com.baidu.searchbox.feed.flow.util.ScrollAttachment;
import com.baidu.searchbox.feed.hot.search.action.HotSearchUnfoldMoreActions;
import com.baidu.searchbox.feed.hot.template.unfold.FeedHotUnfoldMoreItemData;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.texas.context.Action;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/feed/hot/search/processor/HotSearchUnfoldMoreProcessor;", "Lcom/baidu/searchbox/feed/flow/FlowProcessor;", "()V", "onHotListMoreTemplateClick", "", "action", "Lcom/baidu/searchbox/feed/hot/search/action/HotSearchUnfoldMoreActions;", "onScrolled", "scrolledAction", "Lcom/baidu/searchbox/feed/flow/Actions$ScrolledAction;", "lib-hotsearch_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotSearchUnfoldMoreProcessor.kt */
public final class HotSearchUnfoldMoreProcessor extends FlowProcessor {
    public /* synthetic */ FlowState onProcess(FlowState flowState, Action action) {
        FlowState onProcess = super.onProcess(flowState, action);
        if (action instanceof HotSearchUnfoldMoreActions) {
            onHotListMoreTemplateClick((HotSearchUnfoldMoreActions) action);
            return onProcess;
        }
        if (action instanceof Actions.ScrolledAction) {
            onScrolled((Actions.ScrolledAction) action);
        }
        return onProcess;
    }

    private final void onHotListMoreTemplateClick(HotSearchUnfoldMoreActions action) {
        FeedBaseModel model = action.getModel();
        if (Intrinsics.areEqual((Object) model.layout, (Object) HotSearchUnfoldMoreProcessorKt.TEMPLATE_HOT_LIST_BOARD_MORE) && (model.data instanceof FeedHotUnfoldMoreItemData)) {
            for (IHotSearchUnfoldMoreProcessExtension extension : getExtensions(IHotSearchUnfoldMoreProcessExtension.EP)) {
                FeedFlowContext processContext = getProcessContext();
                Intrinsics.checkNotNullExpressionValue(processContext, "processContext");
                extension.onClickUnfoldMoreTemplate(processContext, model);
            }
        }
    }

    public final void onScrolled(Actions.ScrolledAction scrolledAction) {
        Intrinsics.checkNotNullParameter(scrolledAction, "scrolledAction");
        List<FeedBaseModel> cachedFeeds = getDataManager().getCachedFeeds();
        Collection collection = cachedFeeds;
        if (!(collection == null || collection.isEmpty())) {
            ScrollAttachment attachment = scrolledAction.attachment;
            Intrinsics.checkNotNullExpressionValue(attachment, "scrolledAction.attachment");
            FeedBaseModel lastFeed = cachedFeeds.get(cachedFeeds.size() - 1);
            if (attachment.lastVisiblePosition == cachedFeeds.size() - 1 && !Intrinsics.areEqual((Object) lastFeed.layout, (Object) HotSearchUnfoldMoreProcessorKt.TEMPLATE_HOT_LIST_BOARD_MORE)) {
                getPage().setFooterVisibility(0);
            } else if (Intrinsics.areEqual((Object) lastFeed.layout, (Object) HotSearchUnfoldMoreProcessorKt.TEMPLATE_HOT_LIST_BOARD_MORE)) {
                getPage().setFooterVisibility(8);
            }
        }
    }
}
