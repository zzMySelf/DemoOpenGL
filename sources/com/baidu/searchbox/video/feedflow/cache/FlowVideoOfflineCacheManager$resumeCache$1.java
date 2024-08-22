package com.baidu.searchbox.video.feedflow.cache;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoOfflineCacheManager.kt */
final class FlowVideoOfflineCacheManager$resumeCache$1 extends Lambda implements Function0<Unit> {
    public static final FlowVideoOfflineCacheManager$resumeCache$1 INSTANCE = new FlowVideoOfflineCacheManager$resumeCache$1();

    FlowVideoOfflineCacheManager$resumeCache$1() {
        super(0);
    }

    public final void invoke() {
        FlowVideoOfflineCacheManager.INSTANCE.getVideoMediaDownloader().resume(AnonymousClass1.INSTANCE);
    }
}
