package com.baidu.searchbox.video.feedflow.debug;

import com.baidu.searchbox.video.feedflow.update.FlowCommentBubbleSwitcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "change", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowDebugProvider.kt */
final class VideoFlowDebugProvider$getChildItemList$9 extends Lambda implements Function1<Integer, Unit> {
    public static final VideoFlowDebugProvider$getChildItemList$9 INSTANCE = new VideoFlowDebugProvider$getChildItemList$9();

    VideoFlowDebugProvider$getChildItemList$9() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int change) {
        FlowCommentBubbleSwitcher.INSTANCE.setDelayTime(change);
    }
}
