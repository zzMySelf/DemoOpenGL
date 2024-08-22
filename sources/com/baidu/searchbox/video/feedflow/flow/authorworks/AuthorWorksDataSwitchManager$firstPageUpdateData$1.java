package com.baidu.searchbox.video.feedflow.flow.authorworks;

import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "invoke", "(Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthorWorksDataSwitchManager.kt */
final class AuthorWorksDataSwitchManager$firstPageUpdateData$1 extends Lambda implements Function1<ItemModel<?>, Boolean> {
    final /* synthetic */ ItemModel<?> $curItemModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthorWorksDataSwitchManager$firstPageUpdateData$1(ItemModel<?> itemModel) {
        super(1);
        this.$curItemModel = itemModel;
    }

    public final Boolean invoke(ItemModel<?> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(it == this.$curItemModel);
    }
}
