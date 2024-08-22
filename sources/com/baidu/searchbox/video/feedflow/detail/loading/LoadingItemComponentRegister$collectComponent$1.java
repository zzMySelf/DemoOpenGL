package com.baidu.searchbox.video.feedflow.detail.loading;

import com.baidu.searchbox.feed.detail.arch.UiComponent;
import com.baidu.searchbox.video.feedflow.detail.loading.comp.neterror.LoadingNetErrorUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/arch/UiComponent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoadingItemComponentRegister.kt */
final class LoadingItemComponentRegister$collectComponent$1 extends Lambda implements Function0<UiComponent> {
    public static final LoadingItemComponentRegister$collectComponent$1 INSTANCE = new LoadingItemComponentRegister$collectComponent$1();

    LoadingItemComponentRegister$collectComponent$1() {
        super(0);
    }

    public final UiComponent invoke() {
        return LoadingNetErrorUnit.INSTANCE.createComponent();
    }
}
