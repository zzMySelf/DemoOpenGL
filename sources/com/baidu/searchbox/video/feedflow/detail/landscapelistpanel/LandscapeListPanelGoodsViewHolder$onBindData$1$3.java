package com.baidu.searchbox.video.feedflow.detail.landscapelistpanel;

import com.baidu.searchbox.video.feedflow.view.IOnItemSelectedListener;
import com.baidu.searchbox.video.inf.GoodsModel;
import com.baidu.searchbox.video.inf.GoodsRollBarModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/landscapelistpanel/LandscapeListPanelGoodsViewHolder$onBindData$1$3", "Lcom/baidu/searchbox/video/feedflow/view/IOnItemSelectedListener;", "onItemSelected", "", "position", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandscapeListPanelGoodsViewHolder.kt */
public final class LandscapeListPanelGoodsViewHolder$onBindData$1$3 implements IOnItemSelectedListener {
    final /* synthetic */ GoodsModel $data;

    LandscapeListPanelGoodsViewHolder$onBindData$1$3(GoodsModel $data2) {
        this.$data = $data2;
    }

    public void onItemSelected(int position) {
        List<GoodsRollBarModel> goodsRollBar = this.$data.getGoodsRollBar();
        GoodsRollBarModel goodsRollBarModel = goodsRollBar != null ? (GoodsRollBarModel) CollectionsKt.getOrNull(goodsRollBar, position) : null;
        if (goodsRollBarModel != null) {
            goodsRollBarModel.setShown(true);
        }
    }
}
