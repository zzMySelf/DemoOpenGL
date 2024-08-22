package com.baidu.live.feed.search.presenter;

import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.feed.search.model.LiveSearchModel;
import com.baidu.live.feed.search.presenter.LiveFeedSearchContract;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"com/baidu/live/feed/search/presenter/LiveFeedSearchPresenter$loadHotRank$1", "Lcom/baidu/live/feed/search/model/LiveSearchModel$OnDataLoadCallback;", "", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "onFail", "", "errCode", "", "errMsg", "", "onSuccess", "data", "lib-live-feed-search_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveFeedSearchPresenter.kt */
public final class LiveFeedSearchPresenter$loadHotRank$1 implements LiveSearchModel.OnDataLoadCallback<List<? extends LiveRoomEntity>> {
    final /* synthetic */ LiveFeedSearchPresenter this$0;

    LiveFeedSearchPresenter$loadHotRank$1(LiveFeedSearchPresenter $receiver) {
        this.this$0 = $receiver;
    }

    public void onSuccess(List<? extends LiveRoomEntity> data) {
        LiveFeedSearchContract.ISearchPage searchPage = this.this$0.getSearchPage();
        if (searchPage != null) {
            searchPage.setHotRank(data);
        }
    }

    public void onFail(int errCode, String errMsg) {
        LiveFeedSearchContract.ISearchPage searchPage = this.this$0.getSearchPage();
        if (searchPage != null) {
            searchPage.setHotRank((List<? extends LiveRoomEntity>) null);
        }
    }
}
