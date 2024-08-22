package com.baidu.searchbox.feed.template.biserial;

import android.view.View;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.feed.biserial.BiSerialStatisticUtilsKt;
import com.baidu.searchbox.feed.biserial.event.BiSerialDeleteAndInsertTplEvent;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedProbingCardModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/template/biserial/FeedProbingCardView$updateSelectContainer$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedProbingCardView.kt */
public final class FeedProbingCardView$updateSelectContainer$2 implements View.OnClickListener {
    final /* synthetic */ FeedBaseModel $feedModel;
    final /* synthetic */ int $i;
    final /* synthetic */ Ref.ObjectRef<FeedProbingCardModel.FeedProbingItemModel> $selectItem;

    FeedProbingCardView$updateSelectContainer$2(FeedBaseModel $feedModel2, Ref.ObjectRef<FeedProbingCardModel.FeedProbingItemModel> $selectItem2, int $i2) {
        this.$feedModel = $feedModel2;
        this.$selectItem = $selectItem2;
        this.$i = $i2;
    }

    public void onClick(View v) {
        BdEventBus bdEventBus = BdEventBus.Companion.getDefault();
        FeedBaseModel feedBaseModel = this.$feedModel;
        String str = null;
        String str2 = feedBaseModel != null ? feedBaseModel.id : null;
        FeedProbingCardModel.FeedProbingItemModel feedProbingItemModel = (FeedProbingCardModel.FeedProbingItemModel) this.$selectItem.element;
        bdEventBus.post(new BiSerialDeleteAndInsertTplEvent(1, str2, feedProbingItemModel != null ? feedProbingItemModel.getRelatedList() : null));
        FeedProbingCardModel.FeedProbingItemModel feedProbingItemModel2 = (FeedProbingCardModel.FeedProbingItemModel) this.$selectItem.element;
        if (feedProbingItemModel2 != null) {
            str = feedProbingItemModel2.getTitle();
        }
        BiSerialStatisticUtilsKt.probingCardStatistics("click", str, this.$i);
    }
}
