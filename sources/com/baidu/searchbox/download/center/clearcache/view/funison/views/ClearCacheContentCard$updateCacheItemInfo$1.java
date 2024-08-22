package com.baidu.searchbox.download.center.clearcache.view.funison.views;

import com.baidu.searchbox.download.center.clearcache.view.funison.bo.ClearCacheContentCardInfo;
import com.baidu.searchbox.download.center.clearcache.view.funison.bo.ClearCacheItemInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "cardItemView", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/ClearCacheCardItemView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearCacheContentCard.kt */
final class ClearCacheContentCard$updateCacheItemInfo$1 extends Lambda implements Function1<ClearCacheCardItemView, Unit> {
    final /* synthetic */ ClearCacheItemInfo $clearCacheItem;
    final /* synthetic */ ClearCacheContentCard this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClearCacheContentCard$updateCacheItemInfo$1(ClearCacheItemInfo clearCacheItemInfo, ClearCacheContentCard clearCacheContentCard) {
        super(1);
        this.$clearCacheItem = clearCacheItemInfo;
        this.this$0 = clearCacheContentCard;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((ClearCacheCardItemView) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(ClearCacheCardItemView cardItemView) {
        Intrinsics.checkNotNullParameter(cardItemView, "cardItemView");
        cardItemView.setClearCacheItemData(this.$clearCacheItem);
        ClearCacheContentCardInfo clearCacheContentCardData = this.this$0.getClearCacheContentCardData();
        if (clearCacheContentCardData != null) {
            clearCacheContentCardData.replaceItemById(this.$clearCacheItem);
        }
        this.this$0.updateHeaderSubtitle();
    }
}
