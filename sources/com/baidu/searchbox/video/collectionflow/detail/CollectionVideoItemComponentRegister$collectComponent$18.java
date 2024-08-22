package com.baidu.searchbox.video.collectionflow.detail;

import com.baidu.searchbox.feed.detail.arch.UiComponent;
import com.baidu.searchbox.video.feedflow.detail.banner.BannerComponent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/arch/UiComponent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionVideoItemComponentRegister.kt */
final class CollectionVideoItemComponentRegister$collectComponent$18 extends Lambda implements Function0<UiComponent> {
    public static final CollectionVideoItemComponentRegister$collectComponent$18 INSTANCE = new CollectionVideoItemComponentRegister$collectComponent$18();

    CollectionVideoItemComponentRegister$collectComponent$18() {
        super(0);
    }

    public final UiComponent invoke() {
        return new BannerComponent();
    }
}
