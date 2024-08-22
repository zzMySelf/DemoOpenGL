package com.baidu.searchbox.video.feedflow.view.carousepic.gesture;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/view/carousepic/gesture/ScaleDragDetector;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MultipleGesturesDetector.kt */
final class MultipleGesturesDetector$scaleDragDetector$2 extends Lambda implements Function0<ScaleDragDetector> {
    final /* synthetic */ MultipleGesturesDetector this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultipleGesturesDetector$scaleDragDetector$2(MultipleGesturesDetector multipleGesturesDetector) {
        super(0);
        this.this$0 = multipleGesturesDetector;
    }

    public final ScaleDragDetector invoke() {
        return new ScaleDragDetector(this.this$0.context, this.this$0);
    }
}
