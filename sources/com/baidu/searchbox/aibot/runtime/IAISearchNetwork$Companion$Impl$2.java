package com.baidu.searchbox.aibot.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/aibot/runtime/IAISearchNetwork;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: IAISearchNetwork.kt */
final class IAISearchNetwork$Companion$Impl$2 extends Lambda implements Function0<IAISearchNetwork> {
    public static final IAISearchNetwork$Companion$Impl$2 INSTANCE = new IAISearchNetwork$Companion$Impl$2();

    IAISearchNetwork$Companion$Impl$2() {
        super(0);
    }

    public final IAISearchNetwork invoke() {
        return AIBotRuntime.INSTANCE.getNetworkContext();
    }
}
