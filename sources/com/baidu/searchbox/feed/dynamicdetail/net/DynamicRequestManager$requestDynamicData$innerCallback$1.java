package com.baidu.searchbox.feed.dynamicdetail.net;

import com.baidu.searchbox.feed.dynamicdetail.utils.DynamicUtilsKt;
import com.baidu.searchbox.feed.list.controller.ListController;
import com.baidu.searchbox.feed.model.FeedFlowModel;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import java.util.HashMap;
import kotlin.Metadata;
import okhttp3.Response;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/baidu/searchbox/feed/dynamicdetail/net/DynamicRequestManager$requestDynamicData$innerCallback$1", "Lcom/baidu/searchbox/http/callback/StatResponseCallback;", "Lcom/baidu/searchbox/feed/model/FeedFlowModel;", "onFail", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "response", "statusCode", "", "parseResponse", "Lokhttp3/Response;", "statRecord", "Lcom/baidu/searchbox/http/statistics/NetworkStatRecord;", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicRequestManager.kt */
public final class DynamicRequestManager$requestDynamicData$innerCallback$1 implements StatResponseCallback<FeedFlowModel> {
    final /* synthetic */ String $authorId;
    final /* synthetic */ StatResponseCallback<FeedFlowModel> $callback;
    final /* synthetic */ DynamicConnectPolicy $connectPolicy;
    final /* synthetic */ ListController $controller;
    final /* synthetic */ boolean $fromTab;
    final /* synthetic */ HashMap<String, String> $paramsMap;
    final /* synthetic */ int $refreshCount;
    final /* synthetic */ int $refreshType;
    final /* synthetic */ String $reqTag;
    final /* synthetic */ String $strategyType;

    DynamicRequestManager$requestDynamicData$innerCallback$1(StatResponseCallback<FeedFlowModel> $callback2, DynamicConnectPolicy $connectPolicy2, HashMap<String, String> $paramsMap2, String $authorId2, int $refreshCount2, int $refreshType2, String $strategyType2, ListController $controller2, String $reqTag2, boolean $fromTab2) {
        this.$callback = $callback2;
        this.$connectPolicy = $connectPolicy2;
        this.$paramsMap = $paramsMap2;
        this.$authorId = $authorId2;
        this.$refreshCount = $refreshCount2;
        this.$refreshType = $refreshType2;
        this.$strategyType = $strategyType2;
        this.$controller = $controller2;
        this.$reqTag = $reqTag2;
        this.$fromTab = $fromTab2;
    }

    public FeedFlowModel parseResponse(Response response, int statusCode, NetworkStatRecord statRecord) {
        return this.$callback.parseResponse(response, statusCode, statRecord);
    }

    public void onSuccess(FeedFlowModel response, int statusCode) {
        this.$callback.onSuccess(response, statusCode);
    }

    public void onFail(Exception exception) {
        DynamicUtilsKt.dynamicOnLineLog("DynamicRequestManager", "requestDynamicData: onFail in");
        DynamicRequestManager.INSTANCE.setErrorMsg(exception != null ? exception.getMessage() : null);
        DynamicConnectPolicy dynamicConnectPolicy = this.$connectPolicy;
        boolean z = true;
        if (dynamicConnectPolicy == null || !dynamicConnectPolicy.shouldRetry()) {
            z = false;
        }
        if (z) {
            DynamicUtilsKt.dynamicOnLineLog("DynamicRequestManager", "requestDynamicData: onFail should retry");
            this.$connectPolicy.markRetried();
            DynamicRequestManagerKt.preConnectMBD(new DynamicRequestManager$requestDynamicData$innerCallback$1$onFail$1(this.$paramsMap, this.$authorId, this.$refreshCount, this.$refreshType, this.$strategyType, this.$controller, this.$callback, this.$reqTag, this.$fromTab, this.$connectPolicy));
            return;
        }
        this.$callback.onFail(exception);
    }
}
