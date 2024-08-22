package com.baidu.searchbox.video.feedflow.detail.guesslike;

import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "itemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "invoke", "(Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GuessLikeComponent.kt */
final class GuessLikeComponent$onNestedAction$1 extends Lambda implements Function1<ItemModel<?>, Boolean> {
    public static final GuessLikeComponent$onNestedAction$1 INSTANCE = new GuessLikeComponent$onNestedAction$1();

    GuessLikeComponent$onNestedAction$1() {
        super(1);
    }

    public final Boolean invoke(ItemModel<?> itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        return Boolean.valueOf(ItemTypeManifestKt.isGuessLikeItem(itemModel));
    }
}
