package com.baidu.searchbox.video.collectionflow.clearscreen.flow;

import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "item", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearScreenCollectionFlowComponent.kt */
final class ClearScreenCollectionFlowComponent$refreshListDataInternal$1$2 extends Lambda implements Function1<ItemModel<?>, String> {
    public static final ClearScreenCollectionFlowComponent$refreshListDataInternal$1$2 INSTANCE = new ClearScreenCollectionFlowComponent$refreshListDataInternal$1$2();

    ClearScreenCollectionFlowComponent$refreshListDataInternal$1$2() {
        super(1);
    }

    public final String invoke(ItemModel<?> item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.getNid();
    }
}
