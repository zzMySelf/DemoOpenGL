package com.baidu.searchbox.feed.controller;

import com.baidu.searchbox.feed.controller.FeedSearchPostCardManager;
import com.baidu.searchbox.feed.model.FeedSearchPostCardData;
import com.baidu.searchbox.feed.statistic.FeedStatisticCenter;
import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0016J \u0010\t\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u0010"}, d2 = {"com/baidu/searchbox/feed/controller/FeedSearchPostCardManager$fetchSearchPostCardDataFromNet$cancelable$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "", "Lcom/baidu/searchbox/feed/model/FeedSearchPostCardData;", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "feedSearchPostCardData", "i", "", "parseResponse", "response", "Lokhttp3/Response;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedSearchPostCardManager.kt */
public final class FeedSearchPostCardManager$fetchSearchPostCardDataFromNet$cancelable$1 extends ResponseCallback<List<FeedSearchPostCardData>> {
    FeedSearchPostCardManager$fetchSearchPostCardDataFromNet$cancelable$1() {
    }

    public List<FeedSearchPostCardData> parseResponse(Response response, int i2) throws Exception {
        String responseString;
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.isSuccessful()) {
            if (response.body() == null) {
                responseString = "";
            } else {
                ResponseBody body = response.body();
                Intrinsics.checkNotNull(body);
                responseString = body.string();
            }
            return FeedSearchPostCardData.parseSearchPostCardDates(new JSONObject(responseString));
        }
        List list = null;
        return null;
    }

    public void onSuccess(List<FeedSearchPostCardData> feedSearchPostCardData, int i2) {
        FeedSearchPostCardManager feedSearchPostCardManager = FeedSearchPostCardManager.INSTANCE;
        FeedSearchPostCardManager.isFetchingData = false;
        if (feedSearchPostCardData == null || feedSearchPostCardData.size() <= 0 || FeedSearchPostCardManager.isNeedAbandonData) {
            List access$getFeedInsertDatas$p = FeedSearchPostCardManager.feedInsertDatas;
            if (access$getFeedInsertDatas$p != null) {
                access$getFeedInsertDatas$p.clear();
            }
            FeedSearchPostCardManager feedSearchPostCardManager2 = FeedSearchPostCardManager.INSTANCE;
            FeedSearchPostCardManager.isNeedAbandonData = false;
            FeedSearchPostCardManager.SearchPostCardExp access$getExpModel$p = FeedSearchPostCardManager.expModel;
            FeedStatisticCenter.searchPostCardAction("5", (String) null, "", access$getExpModel$p != null ? access$getExpModel$p.getExperimentName() : null);
            return;
        }
        FeedSearchPostCardManager feedSearchPostCardManager3 = FeedSearchPostCardManager.INSTANCE;
        FeedSearchPostCardManager.feedInsertDatas = feedSearchPostCardData;
    }

    public void onFail(Exception e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        FeedSearchPostCardManager feedSearchPostCardManager = FeedSearchPostCardManager.INSTANCE;
        FeedSearchPostCardManager.feedInsertDatas = null;
        FeedSearchPostCardManager feedSearchPostCardManager2 = FeedSearchPostCardManager.INSTANCE;
        FeedSearchPostCardManager.isFetchingData = false;
        FeedSearchPostCardManager feedSearchPostCardManager3 = FeedSearchPostCardManager.INSTANCE;
        FeedSearchPostCardManager.isNeedAbandonData = false;
        FeedSearchPostCardManager.SearchPostCardExp access$getExpModel$p = FeedSearchPostCardManager.expModel;
        FeedStatisticCenter.searchPostCardAction("5", (String) null, "", access$getExpModel$p != null ? access$getExpModel$p.getExperimentName() : null);
    }
}
