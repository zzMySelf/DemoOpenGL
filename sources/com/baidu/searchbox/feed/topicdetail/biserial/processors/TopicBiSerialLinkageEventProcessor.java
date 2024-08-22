package com.baidu.searchbox.feed.topicdetail.biserial.processors;

import android.text.TextUtils;
import com.baidu.searchbox.feed.controller.FeedLinkageManager;
import com.baidu.searchbox.feed.flow.Actions;
import com.baidu.searchbox.feed.flow.FlowProcessor;
import com.baidu.searchbox.feed.flow.FlowState;
import com.baidu.searchbox.feed.model.FeedBar;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.LinkageData;
import com.baidu.searchbox.feed.topicdetail.biserial.TopicDetailInfoMgrs;
import com.baidu.texas.context.Action;
import com.baidu.texas.context.TypedAction;
import java.util.List;

public class TopicBiSerialLinkageEventProcessor extends FlowProcessor {
    public /* synthetic */ FlowState onProcess(FlowState flowState, Action action) {
        FlowState onProcess = super.onProcess(flowState, action);
        boolean z = action instanceof TypedAction;
        if (!z || !Actions.ACTION_ON_RESUME.equals(((TypedAction) action).type)) {
            if (z) {
                TypedAction typedAction = (TypedAction) action;
                if (Actions.ACTION_ON_USER_VISIBLE_HINT.equals(typedAction.type)) {
                    onUserVisibleHint((Boolean) typedAction.payload);
                }
            }
            return onProcess;
        }
        onViewResume();
        return onProcess;
    }

    private void onViewResume() {
        processPraiseLinkages();
    }

    private void onUserVisibleHint(Boolean isShowToUser) {
        if (Boolean.TRUE.equals(isShowToUser)) {
            processPraiseLinkages();
        }
    }

    private void processPraiseLinkages() {
        FeedBar.Like like;
        List<LinkageData> items = FeedLinkageManager.getInstance("feed").getLinkages();
        boolean isNeedRefresh = false;
        if (items != null && items.size() > 0) {
            for (int i2 = 0; i2 < items.size(); i2++) {
                LinkageData item = items.get(i2);
                if (item != null && !item.isUsed && TextUtils.equals(item.type, "pro")) {
                    FeedBaseModel model = getFeedBaseModeById(item.nid);
                    if (model != null && model.data != null && (like = model.data.feedBar.like) != null) {
                        if (like.count != Integer.parseInt(item.count) || like.status != TextUtils.equals(item.status, "1")) {
                            item.isUsed = true;
                            isNeedRefresh = true;
                            like.count = Integer.parseInt(item.count);
                            like.status = TextUtils.equals(item.status, "1");
                        }
                    } else {
                        return;
                    }
                }
            }
            if (isNeedRefresh) {
                getPage().notifyVisibleItemsChanged();
            }
        }
    }

    private FeedBaseModel getFeedBaseModeById(String uKey) {
        List<FeedBaseModel> topicFeedsCacheList = TopicDetailInfoMgrs.getInfoManager(getProcessContext()).getTopicFeedsCacheListByTabID(getChannelId());
        if (topicFeedsCacheList == null || topicFeedsCacheList.size() <= 0) {
            return null;
        }
        for (FeedBaseModel model : topicFeedsCacheList) {
            if (TextUtils.equals(model.id, uKey)) {
                return model;
            }
        }
        return null;
    }
}
