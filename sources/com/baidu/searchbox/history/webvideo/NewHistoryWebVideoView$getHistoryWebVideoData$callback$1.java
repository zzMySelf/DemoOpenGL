package com.baidu.searchbox.history.webvideo;

import com.baidu.searchbox.history.api.callback.HistoryDataCallback;
import com.baidu.searchbox.history.api.data.HistoryModel;
import com.baidu.searchbox.userassetsaggr.container.film.FavorHisWebFilmInfoManager;
import com.baidu.searchbox.userassetsaggr.container.webvideo.FavorHisWebVideoNetDiskManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/history/webvideo/NewHistoryWebVideoView$getHistoryWebVideoData$callback$1", "Lcom/baidu/searchbox/history/api/callback/HistoryDataCallback;", "", "Lcom/baidu/searchbox/history/api/data/HistoryModel;", "onResult", "", "data", "onUIBack", "", "lib-history_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewHistoryWebVideoView.kt */
public final class NewHistoryWebVideoView$getHistoryWebVideoData$callback$1 extends HistoryDataCallback<List<? extends HistoryModel>> {
    final /* synthetic */ boolean $isRefreshStockData;
    final /* synthetic */ long $lastItemCreateTime;
    final /* synthetic */ NewHistoryWebVideoView this$0;

    NewHistoryWebVideoView$getHistoryWebVideoData$callback$1(boolean $isRefreshStockData2, NewHistoryWebVideoView $receiver, long $lastItemCreateTime2) {
        this.$isRefreshStockData = $isRefreshStockData2;
        this.this$0 = $receiver;
        this.$lastItemCreateTime = $lastItemCreateTime2;
    }

    public void onResult(List<HistoryModel> data) {
        Collection collection = data;
        if (!(collection == null || collection.isEmpty())) {
            Ref.IntRef requestCount = new Ref.IntRef();
            requestCount.element = 2;
            ArrayList webVideoList = new ArrayList();
            ArrayList filmInfoModel = new ArrayList();
            filmInfoModel.addAll(data);
            for (HistoryModel it : data) {
                webVideoList.add(new HistoryWebVideoModel(it));
            }
            if (this.$isRefreshStockData) {
                requestCount.element--;
            } else {
                FavorHisWebFilmInfoManager.INSTANCE.getHistoryFilmInfo(filmInfoModel, new NewHistoryWebVideoView$getHistoryWebVideoData$callback$1$onResult$2(requestCount, this.this$0, this.$lastItemCreateTime, this.$isRefreshStockData, data));
            }
            FavorHisWebVideoNetDiskManager.INSTANCE.queryWebVideoStatus(webVideoList, new NewHistoryWebVideoView$getHistoryWebVideoData$callback$1$onResult$3(this.$isRefreshStockData, this.$lastItemCreateTime, this.this$0, webVideoList, requestCount, data));
            return;
        }
        this.this$0.onQueryStatusCallback(this.$lastItemCreateTime, this.$isRefreshStockData, data);
    }

    public boolean onUIBack() {
        return true;
    }
}
