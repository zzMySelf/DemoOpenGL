package com.baidu.searchbox.talos.lite.render;

import com.baidu.searchbox.talos.lite.interaction.event.TalosLiteUiEventEmitter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/talos/lite/interaction/event/TalosLiteUiEventEmitter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosLiteRenderManager.kt */
final class TalosLiteRenderManager$uiEventEmitter$2 extends Lambda implements Function0<TalosLiteUiEventEmitter> {
    public static final TalosLiteRenderManager$uiEventEmitter$2 INSTANCE = new TalosLiteRenderManager$uiEventEmitter$2();

    TalosLiteRenderManager$uiEventEmitter$2() {
        super(0);
    }

    public final TalosLiteUiEventEmitter invoke() {
        return new TalosLiteUiEventEmitter();
    }
}
