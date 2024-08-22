package com.baidu.searchbox.kmm.foundation.network;

import co.touchlab.stately.concurrency.AtomicBoolean;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "resHeaders", "", "", "", "resBody", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpRequest.kt */
final class HttpRequest$httpRequestWithDelayCache$2 extends Lambda implements Function2<Map<String, ? extends Object>, String, Unit> {
    final /* synthetic */ AtomicBoolean $serverResponded;
    final /* synthetic */ Function2<Map<String, ? extends Object>, String, Unit> $succeedCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpRequest$httpRequestWithDelayCache$2(AtomicBoolean atomicBoolean, Function2<? super Map<String, ? extends Object>, ? super String, Unit> function2) {
        super(2);
        this.$serverResponded = atomicBoolean;
        this.$succeedCallback = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Map<String, ? extends Object>) (Map) p1, (String) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(Map<String, ? extends Object> resHeaders, String resBody) {
        this.$serverResponded.setValue(true);
        this.$succeedCallback.invoke(resHeaders, resBody);
    }
}
