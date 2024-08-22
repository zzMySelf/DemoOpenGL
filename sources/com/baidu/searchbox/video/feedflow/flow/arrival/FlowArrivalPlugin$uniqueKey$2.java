package com.baidu.searchbox.video.feedflow.flow.arrival;

import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowArrivalPlugin.kt */
final class FlowArrivalPlugin$uniqueKey$2 extends Lambda implements Function0<String> {
    public static final FlowArrivalPlugin$uniqueKey$2 INSTANCE = new FlowArrivalPlugin$uniqueKey$2();

    FlowArrivalPlugin$uniqueKey$2() {
        super(0);
    }

    public final String invoke() {
        return VideoFlowUtilsKt.md5(DIFactory.INSTANCE.getCUID() + System.currentTimeMillis());
    }
}
