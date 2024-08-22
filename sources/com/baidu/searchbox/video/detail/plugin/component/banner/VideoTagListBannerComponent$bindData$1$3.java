package com.baidu.searchbox.video.detail.plugin.component.banner;

import com.baidu.browser.statistic.BrowserStatisticConstants;
import com.baidu.searchbox.feed.model.VideoTagListModel;
import com.baidu.searchbox.feed.template.VideoTagListView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/video/detail/plugin/component/banner/VideoTagListBannerComponent$bindData$1$3", "Lcom/baidu/searchbox/feed/template/VideoTagListView$OnItemClickListener;", "onClick", "", "view", "Lcom/baidu/searchbox/feed/template/VideoTagListView$ListItemView;", "videoTagListItemModel", "Lcom/baidu/searchbox/feed/model/VideoTagListModel$VideoTagListItemModel;", "position", "", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoTagListBannerComponent.kt */
public final class VideoTagListBannerComponent$bindData$1$3 implements VideoTagListView.OnItemClickListener {
    final /* synthetic */ VideoTagListBannerComponent this$0;

    VideoTagListBannerComponent$bindData$1$3(VideoTagListBannerComponent $receiver) {
        this.this$0 = $receiver;
    }

    public void onClick(VideoTagListView.ListItemView view2, VideoTagListModel.VideoTagListItemModel videoTagListItemModel, int position) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(videoTagListItemModel, "videoTagListItemModel");
        Map map = new LinkedHashMap();
        map.put("tag_index", String.valueOf(position + 1));
        map.put(BrowserStatisticConstants.UBC_PAGE_DURATION_EXT_TAGINFO, String.valueOf(videoTagListItemModel.getName()));
        this.this$0.uploadTagListTcLog("na_detail_tag_clk", map);
    }
}
