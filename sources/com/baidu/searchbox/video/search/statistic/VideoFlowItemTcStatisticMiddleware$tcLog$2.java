package com.baidu.searchbox.video.search.statistic;

import com.baidu.searchbox.video.search.secondjumpswitch.SecondJumpTcLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/search/secondjumpswitch/SecondJumpTcLog;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowItemTcStatisticMiddleware.kt */
final class VideoFlowItemTcStatisticMiddleware$tcLog$2 extends Lambda implements Function0<SecondJumpTcLog> {
    final /* synthetic */ VideoFlowItemTcStatisticMiddleware this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoFlowItemTcStatisticMiddleware$tcLog$2(VideoFlowItemTcStatisticMiddleware videoFlowItemTcStatisticMiddleware) {
        super(0);
        this.this$0 = videoFlowItemTcStatisticMiddleware;
    }

    public final SecondJumpTcLog invoke() {
        return new SecondJumpTcLog(this.this$0.getTcService());
    }
}
