package com.baidu.searchbox.ioc;

import android.view.View;
import com.baidu.searchbox.ad.business.feed.model.NadFeedDoubleItemModel;
import com.baidu.searchbox.ad.business.feed.multichilditem.NadMultiItemChildModel;
import com.baidu.searchbox.ad.business.feed.template.NadDoubleItemCardView;
import com.baidu.searchbox.ad.util.CollectionUtils;
import com.baidu.searchbox.feed.ad.ioc.INadFeedDoubleItemCardProxy;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/ioc/NadFeedDoubleItemCardManager;", "Lcom/baidu/searchbox/feed/ad/ioc/INadFeedDoubleItemCardProxy;", "()V", "getItemBaseModel", "", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "model", "getItemView", "Landroid/view/View;", "view", "lib-ad-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadFeedDoubleItemCardManager.kt */
public final class NadFeedDoubleItemCardManager implements INadFeedDoubleItemCardProxy {
    public List<FeedBaseModel> getItemBaseModel(FeedBaseModel model) {
        FeedItemData feedItemData = model != null ? model.data : null;
        NadFeedDoubleItemModel nadFeedDoubleItemModel = feedItemData instanceof NadFeedDoubleItemModel ? (NadFeedDoubleItemModel) feedItemData : null;
        if (nadFeedDoubleItemModel == null) {
            return null;
        }
        NadFeedDoubleItemModel data = nadFeedDoubleItemModel;
        if (data.getChildBaseModelList().isEmpty()) {
            for (NadMultiItemChildModel item : data.getList()) {
                CollectionUtils.add(data.getChildBaseModelList(), item.toFeedBaseModel(model));
            }
        }
        for (FeedBaseModel child : data.getChildBaseModelList()) {
            NadFeedDoubleItemModel.Companion.updateReportInfo(model, child);
        }
        return data.getChildBaseModelList();
    }

    public List<View> getItemView(View view2) {
        NadDoubleItemCardView card = view2 instanceof NadDoubleItemCardView ? (NadDoubleItemCardView) view2 : null;
        if (card == null) {
            return null;
        }
        ArrayList viewList = new ArrayList();
        CollectionUtils.add(viewList, card.getLeftChild());
        CollectionUtils.add(viewList, card.getRightChild());
        return viewList;
    }
}
