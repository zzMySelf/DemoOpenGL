package com.baidu.searchbox.history.api;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.history.api.callback.HistoryDataCallback;
import com.baidu.searchbox.history.api.data.HistoryModel;
import com.baidu.searchbox.history.api.data.QueryVisitHistoryParams;
import java.util.List;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H&J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0007H&¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/history/api/IHistoryUserAction;", "", "queryHistoryVisitDataAsync", "", "params", "Lcom/baidu/searchbox/history/api/data/QueryVisitHistoryParams;", "callback", "Lcom/baidu/searchbox/history/api/callback/HistoryDataCallback;", "", "Lcom/baidu/searchbox/history/api/data/HistoryModel;", "queryHistoryVisitDataCountAsync", "", "queryHistoryVisitDataCountSync", "queryHistoryVisitDataSync", "updateVisitCountAsync", "uKey", "", "", "lib-history-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IHistoryUserAction.kt */
public interface IHistoryUserAction {
    void queryHistoryVisitDataAsync(QueryVisitHistoryParams queryVisitHistoryParams, HistoryDataCallback<List<HistoryModel>> historyDataCallback);

    void queryHistoryVisitDataCountAsync(QueryVisitHistoryParams queryVisitHistoryParams, HistoryDataCallback<Integer> historyDataCallback);

    int queryHistoryVisitDataCountSync(QueryVisitHistoryParams queryVisitHistoryParams);

    List<HistoryModel> queryHistoryVisitDataSync(QueryVisitHistoryParams queryVisitHistoryParams);

    void updateVisitCountAsync(String str, HistoryDataCallback<Boolean> historyDataCallback);
}
