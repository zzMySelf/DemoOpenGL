package com.baidu.searchbox.video.feedflow.debug;

import com.baidu.searchbox.video.feedflow.update.FlowHalfScreenSwitcher;
import com.baidu.searchbox.video.feedflow.update.FlowHalfScreenSwitcherKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "changeValue", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowDebugProvider.kt */
final class VideoFlowDebugProvider$getChildItemList$30 extends Lambda implements Function1<String, Unit> {
    public static final VideoFlowDebugProvider$getChildItemList$30 INSTANCE = new VideoFlowDebugProvider$getChildItemList$30();

    VideoFlowDebugProvider$getChildItemList$30() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((String) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(String changeValue) {
        Intrinsics.checkNotNullParameter(changeValue, "changeValue");
        FlowHalfScreenSwitcherKt.setDefaultHalfScreenConfig(changeValue);
        FlowHalfScreenSwitcher.INSTANCE.handleConfig(new JSONObject(FlowHalfScreenSwitcherKt.getDefaultHalfScreenConfig()));
    }
}
