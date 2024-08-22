package com.baidu.browser.explore.mutable.feature;

import com.baidu.browser.components.commonmenu.advancefilter.AdvanceFilterViewModel;
import com.baidu.browser.components.commonmenu.advancefilter.CommonMenuUbc;
import com.baidu.browser.tablayout.data.FilterSearchTabItem;
import com.baidu.browser.tablayout.data.FilterSortTabItem;
import com.baidu.browser.tablayout.data.MoreNormalItem;
import com.baidu.browser.tablayout.data.MoreSearchTabItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "moreItem", "Lcom/baidu/browser/tablayout/data/MoreNormalItem;", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MultiTabFeature.kt */
final class MultiTabFeature$updateMoreLayoutUI$1$1 extends Lambda implements Function2<MoreNormalItem, Integer, Unit> {
    final /* synthetic */ MultiTabFeature this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiTabFeature$updateMoreLayoutUI$1$1(MultiTabFeature multiTabFeature) {
        super(2);
        this.this$0 = multiTabFeature;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((MoreNormalItem) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(MoreNormalItem moreItem, int index) {
        Intrinsics.checkNotNullParameter(moreItem, "moreItem");
        if (moreItem instanceof MoreSearchTabItem) {
            this.this$0.onItemSelected(((MoreSearchTabItem) moreItem).getItem());
            return;
        }
        if (moreItem instanceof FilterSortTabItem) {
            AdvanceFilterViewModel adVanceFilterVm = this.this$0.getAdVanceFilterVm();
            if (adVanceFilterVm != null) {
                adVanceFilterVm.selectFilterItem(((FilterSortTabItem) moreItem).getModel());
            }
            CommonMenuUbc.ubcClick(CommonMenuUbc.UBC_SOURCE_MULTITABBAR, "", "", "", ((FilterSortTabItem) moreItem).getModel().getTitle());
        } else if (moreItem instanceof FilterSearchTabItem) {
            AdvanceFilterViewModel adVanceFilterVm2 = this.this$0.getAdVanceFilterVm();
            if (adVanceFilterVm2 != null) {
                adVanceFilterVm2.selectTimeFilterItem(((FilterSearchTabItem) moreItem).getModel());
            }
            CommonMenuUbc.ubcClick(CommonMenuUbc.UBC_SOURCE_MULTITABBAR, "", "", ((FilterSearchTabItem) moreItem).getModel().getTitle(), (String) null);
        }
        this.this$0.moreItemHandle(false);
    }
}
