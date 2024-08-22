package com.baidu.searchbox.video.feedflow.detail.dislike.adapter;

import com.baidu.searchbox.video.feedflow.detail.dislike.DislikeNewPanelItemOptionModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dislike/adapter/IDislikeContentListener;", "", "onMultipleItemClicked", "", "list", "", "Lcom/baidu/searchbox/video/feedflow/detail/dislike/DislikeNewPanelItemOptionModel;", "onSingleItemClicked", "model", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DislikeNewPanelContentView.kt */
public interface IDislikeContentListener {
    void onMultipleItemClicked(List<DislikeNewPanelItemOptionModel> list);

    void onSingleItemClicked(DislikeNewPanelItemOptionModel dislikeNewPanelItemOptionModel);
}
