package com.baidu.searchbox.combinepublisher.fragment.publishsame;

import com.baidu.searchbox.dynamicpublisher.topbar.TopbarComponent;
import com.baidu.searchbox.feed.detail.arch.UiComponent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/arch/UiComponent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PublishSameComponentRegister.kt */
final class PublishSameComponentRegister$collectComponent$1 extends Lambda implements Function0<UiComponent> {
    public static final PublishSameComponentRegister$collectComponent$1 INSTANCE = new PublishSameComponentRegister$collectComponent$1();

    PublishSameComponentRegister$collectComponent$1() {
        super(0);
    }

    public final UiComponent invoke() {
        return new TopbarComponent(false);
    }
}
