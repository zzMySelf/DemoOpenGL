package com.baidu.searchbox.download.center.clearcache.view.funison.views;

import com.baidu.searchbox.download.center.clearcache.view.funison.bo.ClearCacheCarefulItemInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "childView", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/ClearCacheCarefulCardItemView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearCacheCarefulCard.kt */
final class ClearCacheCarefulCard$refreshAllChildView$2 extends Lambda implements Function1<ClearCacheCarefulCardItemView, Unit> {
    final /* synthetic */ HashMap<String, ClearCacheCarefulItemInfo> $carefulCleanItemsMap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClearCacheCarefulCard$refreshAllChildView$2(HashMap<String, ClearCacheCarefulItemInfo> hashMap) {
        super(1);
        this.$carefulCleanItemsMap = hashMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((ClearCacheCarefulCardItemView) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(ClearCacheCarefulCardItemView childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        ClearCacheCarefulItemInfo carefulCleanItem = childView.getCarefulCleanItem();
        String cacheId = carefulCleanItem != null ? carefulCleanItem.getCacheId() : null;
        if (cacheId != null) {
            childView.setCarefulCleanItem(this.$carefulCleanItemsMap.get(cacheId));
        }
    }
}
