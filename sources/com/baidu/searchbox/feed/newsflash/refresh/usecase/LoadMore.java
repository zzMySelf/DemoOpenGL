package com.baidu.searchbox.feed.newsflash.refresh.usecase;

import com.baidu.searchbox.feed.list.domain.DataSource;
import com.baidu.searchbox.feed.list.domain.ListRepository;
import com.baidu.searchbox.feed.listpage.domain.Channel;
import com.baidu.searchbox.feed.listpage.infrastructure.ChannelRepo;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedFlowModel;
import com.baidu.searchbox.feed.newsflash.infrastructure.DataSourceParams;
import com.baidu.searchbox.feed.newsflash.infrastructure.NewsFlashListRepository;
import com.baidu.searchbox.feed.newsflash.infrastructure.localdata.policy.DataFeedbackGRManager;
import com.baidu.searchbox.feed.newsflash.refresh.action.FeedItemsSuccessAction;
import com.baidu.searchbox.feed.newsflash.refresh.action.LoadMoreHistoryResultAction;
import com.baidu.searchbox.feed.newsflash.refresh.action.ServerFeedsResultAction;
import com.baidu.searchbox.feed.newsflash.refresh.domain.PolicyState;
import com.baidu.searchbox.feed.newsflash.refresh.domain.RefreshState;
import com.baidu.searchbox.feed.newsflash.refresh.usecase.command.CLoadMore;
import com.baidu.searchbox.feed.newsflash.refresh.usecase.command.CLoadMoreFromServerResult;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.texas.context.PartialActionDispatcher;
import java.util.List;

public class LoadMore {
    private final String mAssignID;
    private Channel mChannel;
    /* access modifiers changed from: private */
    public final PartialActionDispatcher mDispatcher;
    /* access modifiers changed from: private */
    public final ListRepository mListRepo;
    /* access modifiers changed from: private */
    public final PolicyState mPolicyState;
    /* access modifiers changed from: private */
    public final RefreshState mRefreshState;

    public LoadMore(String assign, PartialActionDispatcher dispatcher, ListRepository repo, RefreshState refreshState, PolicyState policyState) {
        this.mAssignID = assign;
        this.mDispatcher = dispatcher;
        this.mListRepo = repo;
        this.mRefreshState = refreshState;
        this.mPolicyState = policyState;
    }

    /* access modifiers changed from: private */
    public Channel getChannel() {
        if (this.mChannel == null) {
            this.mChannel = ChannelRepo.getChannel(this.mAssignID);
        }
        return this.mChannel;
    }

    public void execute(CLoadMore cLoadMore) {
        this.mRefreshState.updatePreLoadMore();
        if (this.mPolicyState.isLoadHistory()) {
            loadMoreFeedsFromHistory();
        } else {
            loadMoreFeedsFromServer();
        }
    }

    public void execute(CLoadMoreFromServerResult loadMoreResult, FeedFlowModel feedFlowModel) {
        this.mRefreshState.getLastRefreshTime().setValue(Long.valueOf(FeedUtil.convertRefreshTime(feedFlowModel.timestamp)));
        List<FeedBaseModel> moreFeeds = feedFlowModel.feedBaseModelList;
        boolean isApplyPolicy = false;
        if (moreFeeds != null && moreFeeds.size() > 0) {
            int originSize = getChannel().getDisplayList().getCachedFeeds().size();
            this.mPolicyState.updateLoadResult(true, feedFlowModel, this.mRefreshState, this.mListRepo, getChannel().getDisplayList());
            isApplyPolicy = originSize > getChannel().getDisplayList().getCachedFeeds().size();
            getChannel().getDisplayList().saveFeedToMemory(moreFeeds, false);
            this.mRefreshState.saveCurrentDayRefreshCount();
        }
        this.mDispatcher.dispatchOnProcess(new FeedItemsSuccessAction("load_more", moreFeeds, false, isApplyPolicy));
    }

    private void loadMoreFeedsFromServer() {
        if (!(this.mPolicyState == null || getChannel() == null)) {
            this.mPolicyState.reportDisplayBeforeRefresh(getChannel().getDisplayList().getHistoryFeeds());
        }
        final DataFeedbackGRManager grManager = ((NewsFlashListRepository) this.mListRepo).getFeedbackGRManager();
        this.mRefreshState.setRefreshType("load_more");
        this.mListRepo.getSource(new DataSourceParams(this.mAssignID, "type_remote", getChannel().getSourceState(), this.mRefreshState, this.mPolicyState, grManager, new DataSource.Callback<FeedFlowModel>() {
            public void onLoadResult(boolean isSuccess, FeedFlowModel feedFlowModel) {
                LoadMore.this.mRefreshState.updateAfterServerResult(false, feedFlowModel, LoadMore.this.getChannel().getNXState(), grManager);
                LoadMore.this.mDispatcher.dispatchOnProcess(new ServerFeedsResultAction("load_more", isSuccess, feedFlowModel));
            }
        }));
    }

    private void loadMoreFeedsFromHistory() {
        this.mRefreshState.updateLoadingMoreState(false);
        this.mListRepo.getSource(new DataSourceParams(this.mAssignID, "type_local", false, getChannel().getSourceState(), (DataSource.Callback) new DataSource.Callback<FeedFlowModel>() {
            public void onLoadResult(boolean isSuccess, FeedFlowModel feedFlowModel) {
                List<FeedBaseModel> resultList = feedFlowModel.feedBaseModelList;
                if (resultList != null && resultList.size() > 0) {
                    LoadMore.this.mRefreshState.removeExpiredFeed(resultList);
                    LoadMore.this.mPolicyState.updateLoadResult(true, feedFlowModel, LoadMore.this.mRefreshState, LoadMore.this.mListRepo, LoadMore.this.getChannel().getDisplayList());
                    LoadMore.this.getChannel().getDisplayList().saveFeedToMemory(resultList, false);
                }
                LoadMore.this.mDispatcher.dispatchOnProcess(new LoadMoreHistoryResultAction(true, resultList));
            }
        }));
    }
}
