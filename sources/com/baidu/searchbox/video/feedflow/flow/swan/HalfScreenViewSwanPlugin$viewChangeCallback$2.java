package com.baidu.searchbox.video.feedflow.flow.swan;

import com.baidu.swan.api.interfaces.ISwanHalfScreenViewApp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/swan/api/interfaces/ISwanHalfScreenViewApp$ViewChangeCallback;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HalfScreenViewSwanPlugin.kt */
final class HalfScreenViewSwanPlugin$viewChangeCallback$2 extends Lambda implements Function0<ISwanHalfScreenViewApp.ViewChangeCallback> {
    final /* synthetic */ HalfScreenViewSwanPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HalfScreenViewSwanPlugin$viewChangeCallback$2(HalfScreenViewSwanPlugin halfScreenViewSwanPlugin) {
        super(0);
        this.this$0 = halfScreenViewSwanPlugin;
    }

    public final ISwanHalfScreenViewApp.ViewChangeCallback invoke() {
        return this.this$0.createViewChangeCallback();
    }
}
