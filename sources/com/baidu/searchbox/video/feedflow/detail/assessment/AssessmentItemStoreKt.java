package com.baidu.searchbox.video.feedflow.detail.assessment;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreReducer;
import com.baidu.searchbox.feed.detail.arch.ext.InterceptorToParentReducer;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.feedflow.common.IntentDataReducer;
import com.baidu.searchbox.video.feedflow.detail.bottom.BottomBarDetailActionInterceptorMiddleware;
import com.baidu.searchbox.video.feedflow.detail.bottom.statistic.BottomBarStatisticReducer;
import com.baidu.searchbox.video.feedflow.detail.foldscreen.FoldScreenInnerMiddleware;
import com.baidu.searchbox.video.feedflow.detail.search.AssessmentSearchReducer;
import com.baidu.searchbox.video.feedflow.detail.search.SearchMiddleware;
import com.baidu.searchbox.video.feedflow.detail.successarrive.SuccessRenderReducer;
import com.baidu.searchbox.video.feedflow.detail.talosassessbig.AssessBigTalosUnit;
import com.baidu.searchbox.video.feedflow.detail.talosassessbig.common.AssessmentAutoInterceptMiddleware;
import com.baidu.searchbox.video.feedflow.detail.talosassessbig.common.bottom.AssessmentBottomBarReducerAdapter;
import com.baidu.searchbox.video.feedflow.detail.talosassessbig.common.successarrive.AssessmentSuccessRenderMiddleware;
import com.baidu.searchbox.video.feedflow.detail.ubc.FlowDetailUbcReducer;
import com.baidu.searchbox.video.feedflow.flow.fontsize.FontSizeReducer;
import com.baidu.searchbox.video.feedflow.flow.more.MoreDetailActionInterceptorMiddleware;
import com.baidu.searchbox.video.feedflow.flow.more.MoreFlowReducerAdapterMiddleware;
import com.baidu.searchbox.video.feedflow.flow.search.SearchMarkFlowMiddleware;
import com.baidu.searchbox.video.feedflow.flow.search.SearchStaticMiddleware;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001\u001a\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u0001¨\u0006\u0006"}, d2 = {"collectReducer", "", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "collectionMiddleware", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "feed-flow_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AssessmentItemStore.kt */
public final class AssessmentItemStoreKt {
    public static final List<Middleware<CommonState>> collectionMiddleware() {
        List arrayList = new ArrayList();
        List $this$collectionMiddleware_u24lambda_u2d0 = arrayList;
        $this$collectionMiddleware_u24lambda_u2d0.add(new MoreDetailActionInterceptorMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new BottomBarDetailActionInterceptorMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new MoreFlowReducerAdapterMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new SearchMarkFlowMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new SearchStaticMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new SearchMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new AssessmentBottomBarReducerAdapter());
        $this$collectionMiddleware_u24lambda_u2d0.add(new FoldScreenInnerMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new AssessmentAutoInterceptMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.add(new AssessmentSuccessRenderMiddleware());
        $this$collectionMiddleware_u24lambda_u2d0.addAll(new AssessBigTalosUnit().createMiddlewares());
        return arrayList;
    }

    public static final List<Reducer<CommonState>> collectReducer() {
        List arrayList = new ArrayList();
        List $this$collectReducer_u24lambda_u2d1 = arrayList;
        $this$collectReducer_u24lambda_u2d1.add(new IntentDataReducer());
        $this$collectReducer_u24lambda_u2d1.add(new CoreReducer());
        $this$collectReducer_u24lambda_u2d1.add(new InterceptorToParentReducer());
        $this$collectReducer_u24lambda_u2d1.add(new FlowDetailUbcReducer());
        $this$collectReducer_u24lambda_u2d1.add(new AssessmentSearchReducer());
        $this$collectReducer_u24lambda_u2d1.add(new SuccessRenderReducer());
        $this$collectReducer_u24lambda_u2d1.add(new FontSizeReducer());
        $this$collectReducer_u24lambda_u2d1.add(new AssessBigTalosUnit().createReducer());
        $this$collectReducer_u24lambda_u2d1.add(new BottomBarStatisticReducer());
        return arrayList;
    }
}
