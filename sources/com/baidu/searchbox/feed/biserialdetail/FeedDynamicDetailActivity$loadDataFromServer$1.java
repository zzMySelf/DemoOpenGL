package com.baidu.searchbox.feed.biserialdetail;

import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.feed.biserialdetail.model.DynamicDetailFlow;
import com.baidu.searchbox.feed.biserialdetail.net.NetCallback;
import com.baidu.searchbox.feed.biserialdetail.ubc.perf.PerformanceStatisticsProcessor;
import com.baidu.searchbox.feed.biserialdetail.utils.CommonUtils;
import com.baidu.searchbox.feed.ui.drawerslide.BiSerialDetailBaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/feed/biserialdetail/FeedDynamicDetailActivity$loadDataFromServer$1", "Lcom/baidu/searchbox/feed/biserialdetail/net/NetCallback;", "Lcom/baidu/searchbox/feed/biserialdetail/model/DynamicDetailFlow;", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onResponse", "onSuccess", "model", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedDynamicDetailActivity.kt */
public final class FeedDynamicDetailActivity$loadDataFromServer$1 implements NetCallback<DynamicDetailFlow> {
    final /* synthetic */ FeedDynamicDetailActivity this$0;

    FeedDynamicDetailActivity$loadDataFromServer$1(FeedDynamicDetailActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onResponse() {
        PerformanceStatisticsProcessor perfStatisticsProcessor = this.this$0.getPerfStatisticsProcessor();
        if (perfStatisticsProcessor != null) {
            perfStatisticsProcessor.onFetchServerDataBack();
        }
    }

    public void onSuccess(DynamicDetailFlow model) {
        CommonUtils.onLineLog(BiSerialDetailBaseActivity.TAG, "[loadDataFromServer]请求数据成功");
        this.this$0.setRefreshing(false);
        if (this.this$0.isExecutingFinishAnim()) {
            CommonUtils.onLineLog(BiSerialDetailBaseActivity.TAG, "[loadDataFromServer]请求数据成功, 正在执行退场动画, return");
            return;
        }
        PerformanceStatisticsProcessor perfStatisticsProcessor = this.this$0.getPerfStatisticsProcessor();
        if (perfStatisticsProcessor != null) {
            perfStatisticsProcessor.onPullDataParse(model);
        }
        UiThreadUtils.runOnUiThread(new FeedDynamicDetailActivity$loadDataFromServer$1$$ExternalSyntheticLambda0(this.this$0, model));
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-0  reason: not valid java name */
    public static final void m18477onSuccess$lambda0(FeedDynamicDetailActivity this$02, DynamicDetailFlow $model) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        this$02.handleDataFromServer($model);
    }

    public void onFail(Exception e2) {
        PerformanceStatisticsProcessor perfStatisticsProcessor = this.this$0.getPerfStatisticsProcessor();
        if (perfStatisticsProcessor != null) {
            perfStatisticsProcessor.cancel();
        }
        CommonUtils.onLineLog(BiSerialDetailBaseActivity.TAG, "[loadDataFromServer]请求数据失败");
        this.this$0.setRefreshing(false);
        this.this$0.setNetError(true);
        if (this.this$0.isExecutingFinishAnim()) {
            CommonUtils.onLineLog(BiSerialDetailBaseActivity.TAG, "[loadDataFromServer]请求数据失败, 正在执行退场动画, return");
        } else {
            UiThreadUtils.runOnUiThread(new FeedDynamicDetailActivity$loadDataFromServer$1$$ExternalSyntheticLambda1(this.this$0));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onFail$lambda-1  reason: not valid java name */
    public static final void m18476onFail$lambda1(FeedDynamicDetailActivity this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        this$02.handleNetError();
    }
}
