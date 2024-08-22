package com.baidu.searchbox.feed.dynamicdetail.silex;

import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.feed.dynamicdetail.prefetch.SelectDBDataListener;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/dynamicdetail/silex/DynamicImmersivePrefetch$getPrefetchDynamicData$2", "Lcom/baidu/searchbox/feed/dynamicdetail/prefetch/SelectDBDataListener;", "getRelatedData", "", "prefetchData", "", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicImmersivePrefetch.kt */
public final class DynamicImmersivePrefetch$getPrefetchDynamicData$2 implements SelectDBDataListener {
    final /* synthetic */ String $interactiveStr;
    final /* synthetic */ String $nid;
    final /* synthetic */ String $pageUniqueId;
    final /* synthetic */ ArrayList<FeedBaseModel> $prefetchList;
    final /* synthetic */ Function1<Boolean, Unit> $prefetchStatusCallback;
    final /* synthetic */ String $source;

    DynamicImmersivePrefetch$getPrefetchDynamicData$2(ArrayList<FeedBaseModel> $prefetchList2, String $pageUniqueId2, String $nid2, String $source2, String $interactiveStr2, Function1<? super Boolean, Unit> $prefetchStatusCallback2) {
        this.$prefetchList = $prefetchList2;
        this.$pageUniqueId = $pageUniqueId2;
        this.$nid = $nid2;
        this.$source = $source2;
        this.$interactiveStr = $interactiveStr2;
        this.$prefetchStatusCallback = $prefetchStatusCallback2;
    }

    public void getRelatedData(String prefetchData) {
        Intrinsics.checkNotNullParameter(prefetchData, "prefetchData");
        UiThreadUtils.runOnUiThread(new DynamicImmersivePrefetch$getPrefetchDynamicData$2$$ExternalSyntheticLambda0(prefetchData, this.$prefetchList, this.$pageUniqueId, this.$nid, this.$source, this.$interactiveStr, this.$prefetchStatusCallback));
    }

    /* access modifiers changed from: private */
    /* renamed from: getRelatedData$lambda-0  reason: not valid java name */
    public static final void m18633getRelatedData$lambda0(String $prefetchData, ArrayList $prefetchList2, String $pageUniqueId2, String $nid2, String $source2, String $interactiveStr2, Function1 $prefetchStatusCallback2) {
        Function1 function1 = $prefetchStatusCallback2;
        Intrinsics.checkNotNullParameter($prefetchData, "$prefetchData");
        ArrayList arrayList = $prefetchList2;
        Intrinsics.checkNotNullParameter($prefetchList2, "$prefetchList");
        Intrinsics.checkNotNullParameter($nid2, "$nid");
        Intrinsics.checkNotNullParameter($source2, "$source");
        Intrinsics.checkNotNullParameter($interactiveStr2, "$interactiveStr");
        Intrinsics.checkNotNullParameter(function1, "$prefetchStatusCallback");
        if ($prefetchData.length() > 0) {
            DynamicImmersivePrefetch.INSTANCE.genDbPrefetchData($prefetchData, $prefetchList2, $pageUniqueId2, $nid2, $source2, $interactiveStr2);
            function1.invoke(true);
            return;
        }
        function1.invoke(false);
    }
}
