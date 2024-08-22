package com.baidu.searchbox.video.collectionflow.clearscreen;

import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.video.assemble.creator.ClearScreenCollectionArchCreator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearScreenCollectionPageView.kt */
final class ClearScreenCollectionPageView$componentManager$2 extends Lambda implements Function0<ComponentArchManager> {
    public static final ClearScreenCollectionPageView$componentManager$2 INSTANCE = new ClearScreenCollectionPageView$componentManager$2();

    ClearScreenCollectionPageView$componentManager$2() {
        super(0);
    }

    public final ComponentArchManager invoke() {
        return ClearScreenCollectionArchCreator.Impl.INSTANCE.get().createManager();
    }
}
