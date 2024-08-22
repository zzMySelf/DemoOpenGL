package com.baidu.searchbox.feed.listpage.application.actions;

import android.text.TextUtils;
import com.baidu.searchbox.feed.flow.DynamicAction;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedFlowModel;
import com.baidu.searchbox.feed.model.FeedPolicyModel;
import com.baidu.texas.context.Action;
import com.baidu.texas.context.TypedAction;
import java.util.List;

public class RefreshActions {
    public static final String ACTION_AFTER_DATA_CHANGE = "ActionTypeOfAfterDataChange";
    public static final String ACTION_PROCESS_POLICY = "ActionTypeOfProcessPolicy";
    public static final String ACTION_REFRESH_BEGIN = "ActionTypeOfRefreshBegin";

    public static Action newActionOfRefreshBegin(String refreshState) {
        return new TypedAction(ACTION_REFRESH_BEGIN, refreshState);
    }

    public static boolean isActionOfRefreshBegin(Action action) {
        return (action instanceof TypedAction) && ACTION_REFRESH_BEGIN.equals(((TypedAction) action).type);
    }

    public static Action newActionOfProcessPolicy(FeedFlowModel model) {
        return new TypedAction(ACTION_PROCESS_POLICY, model);
    }

    public static boolean isActionOfProcessPolicy(Action action) {
        return (action instanceof TypedAction) && ACTION_PROCESS_POLICY.equals(((TypedAction) action).type);
    }

    public static Action newActionOfRefreshDataChange(List<FeedBaseModel> newsList) {
        return new TypedAction(ACTION_AFTER_DATA_CHANGE, newsList);
    }

    public static boolean isActionOfRefreshDataChange(Action action) {
        return (action instanceof TypedAction) && ACTION_AFTER_DATA_CHANGE.equals(((TypedAction) action).type);
    }

    public static abstract class RefreshStateAction implements DynamicAction {
        public String refreshState;

        public RefreshStateAction(String refreshState2) {
            this.refreshState = refreshState2;
        }

        public RefreshStateAction() {
        }
    }

    public static class RefreshEndAction extends RefreshStateAction {
        public static final String NORMAL_REFRESH = "0";
        public static final String PRE_REFRESH = "1";
        private final String mType;
        public int newFeedSize;
        public final List<FeedBaseModel> newFeeds;
        public long startTimestamp;
        public final int statusCode;

        public RefreshEndAction(String type, FeedPolicyModel policyModel, int statusCode2, List<FeedBaseModel> newFeeds2, int newFeedSize2, String refreshState, long start) {
            this.mType = type;
            this.statusCode = statusCode2;
            this.newFeeds = newFeeds2;
            this.newFeedSize = newFeedSize2;
            this.startTimestamp = start;
            this.refreshState = refreshState;
        }

        public RefreshEndAction(String type) {
            this.mType = type;
            this.statusCode = 0;
            this.newFeeds = null;
        }

        public boolean isNormalRefresh() {
            return TextUtils.equals(this.mType, "0");
        }
    }

    public static class RefreshBeforeChangeAction implements DynamicAction {
        public final List<FeedBaseModel> dupPending;
        public String refreshState;
        public long refreshTime;
        public final List<FeedBaseModel> resultFeeds;

        public RefreshBeforeChangeAction(List<FeedBaseModel> resultFeeds2, List<FeedBaseModel> dupPending2, long refreshTime2, String refreshState2) {
            this.resultFeeds = resultFeeds2;
            this.dupPending = dupPending2;
            this.refreshTime = refreshTime2;
            this.refreshState = refreshState2;
        }
    }
}
