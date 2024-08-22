package com.baidu.searchbox.history.webvideo;

import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.history.api.data.HistoryModel;
import com.baidu.searchbox.userassetsaggr.container.webvideo.data.AbsFavorHisWebVideoModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "success", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewHistoryWebVideoView.kt */
final class NewHistoryWebVideoView$getHistoryWebVideoData$callback$1$onResult$3 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ List<HistoryModel> $data;
    final /* synthetic */ boolean $isRefreshStockData;
    final /* synthetic */ long $lastItemCreateTime;
    final /* synthetic */ Ref.IntRef $requestCount;
    final /* synthetic */ ArrayList<AbsFavorHisWebVideoModel> $webVideoList;
    final /* synthetic */ NewHistoryWebVideoView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewHistoryWebVideoView$getHistoryWebVideoData$callback$1$onResult$3(boolean z, long j2, NewHistoryWebVideoView newHistoryWebVideoView, ArrayList<AbsFavorHisWebVideoModel> arrayList, Ref.IntRef intRef, List<HistoryModel> list) {
        super(1);
        this.$isRefreshStockData = z;
        this.$lastItemCreateTime = j2;
        this.this$0 = newHistoryWebVideoView;
        this.$webVideoList = arrayList;
        this.$requestCount = intRef;
        this.$data = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean success) {
        UiThreadUtils.runOnUiThread(new NewHistoryWebVideoView$getHistoryWebVideoData$callback$1$onResult$3$$ExternalSyntheticLambda0(this.$isRefreshStockData, this.$lastItemCreateTime, this.this$0, this.$webVideoList, this.$requestCount, this.$data));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m20017invoke$lambda1(boolean $isRefreshStockData2, long $lastItemCreateTime2, NewHistoryWebVideoView this$02, ArrayList $webVideoList2, Ref.IntRef $requestCount2, List $data2) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullParameter($webVideoList2, "$webVideoList");
        Intrinsics.checkNotNullParameter($requestCount2, "$requestCount");
        if (($isRefreshStockData2 || $lastItemCreateTime2 < 0) && (!this$02.mWebVideoDataList.isEmpty())) {
            this$02.mWebVideoDataList.clear();
        }
        Iterator it = $webVideoList2.iterator();
        while (it.hasNext()) {
            AbsFavorHisWebVideoModel model = (AbsFavorHisWebVideoModel) it.next();
            if (model instanceof HistoryWebVideoModel) {
                this$02.mWebVideoDataList.add(model);
            }
        }
        $requestCount2.element--;
        if ($requestCount2.element <= 0) {
            this$02.onQueryStatusCallback($lastItemCreateTime2, $isRefreshStockData2, $data2);
        }
    }
}
