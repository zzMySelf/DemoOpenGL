package com.baidu.searchbox.video.feedflow.view.carousepic.gesture;

import android.view.ScaleGestureDetector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/ScaleGestureDetector;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScaleDragDetector.kt */
final class ScaleDragDetector$scaleDetector$2 extends Lambda implements Function0<ScaleGestureDetector> {
    final /* synthetic */ ScaleDragDetector this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScaleDragDetector$scaleDetector$2(ScaleDragDetector scaleDragDetector) {
        super(0);
        this.this$0 = scaleDragDetector;
    }

    public final ScaleGestureDetector invoke() {
        return new ScaleGestureDetector(this.this$0.getContext(), this.this$0);
    }
}
