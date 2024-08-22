package com.baidu.searchbox.video.feedflow.ad.topview.histroy;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.ext.common.UbcBean;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.component.history.CommonHistoryAction;
import com.baidu.searchbox.video.component.history.CommonHistoryModel;
import com.baidu.searchbox.video.detail.export.IVideoExecutorUtilsExt;
import com.baidu.searchbox.video.feedflow.detail.history.HistoryMiddleware;
import com.baidu.searchbox.video.feedflow.detail.history.map.HistoryMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0014¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/topview/histroy/AdChannelTopViewHistoryMiddleware;", "Lcom/baidu/searchbox/video/feedflow/detail/history/HistoryMiddleware;", "()V", "insertHistory", "", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "itemModel", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailModel;", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdChannelTopViewHistoryMiddleware.kt */
public final class AdChannelTopViewHistoryMiddleware extends HistoryMiddleware {
    /* access modifiers changed from: protected */
    public void insertHistory(Store<CommonState> store, FlowDetailModel itemModel) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        IVideoExecutorUtilsExt.Impl.get().postOnElastic(new AdChannelTopViewHistoryMiddleware$$ExternalSyntheticLambda0(itemModel, store), "AdChannelTopViewInsertHistory", 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: insertHistory$lambda-1  reason: not valid java name */
    public static final void m5797insertHistory$lambda1(FlowDetailModel $itemModel, Store $store) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter($itemModel, "$itemModel");
        Intrinsics.checkNotNullParameter($store, "$store");
        CommonHistoryModel model = HistoryMapper.INSTANCE.map($itemModel);
        if (model != null) {
            UbcBean ubcBean = (UbcBean) ((CommonState) $store.getState()).select(UbcBean.class);
            if (ubcBean == null || (str = ubcBean.getPage()) == null) {
                str = "merge_video_landing";
            }
            model.setPage(str);
            if (ubcBean == null || (str2 = ubcBean.getFrom()) == null) {
                str2 = "feed";
            }
            model.setFrom(str2);
            StoreExtKt.post($store, new CommonHistoryAction.InsertHistory(model));
        }
    }
}
