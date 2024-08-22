package com.baidu.searchbox.ugc.aivideo;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/ugc/aivideo/AiVideoActivityCreateHttpTask;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiVideoActivityCreatingManager.kt */
final class AiVideoActivityCreatingManager$createTask$2 extends Lambda implements Function0<AiVideoActivityCreateHttpTask> {
    public static final AiVideoActivityCreatingManager$createTask$2 INSTANCE = new AiVideoActivityCreatingManager$createTask$2();

    AiVideoActivityCreatingManager$createTask$2() {
        super(0);
    }

    public final AiVideoActivityCreateHttpTask invoke() {
        return new AiVideoActivityCreateHttpTask(AiVideoActivityCreatingManager.INSTANCE);
    }
}
