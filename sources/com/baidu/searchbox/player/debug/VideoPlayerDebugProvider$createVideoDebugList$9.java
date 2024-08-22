package com.baidu.searchbox.player.debug;

import com.baidu.searchbox.player.ab.PlayerAbManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "changeValue", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPlayerDebugProvider.kt */
final class VideoPlayerDebugProvider$createVideoDebugList$9 extends Lambda implements Function1<Boolean, Unit> {
    public static final VideoPlayerDebugProvider$createVideoDebugList$9 INSTANCE = new VideoPlayerDebugProvider$createVideoDebugList$9();

    VideoPlayerDebugProvider$createVideoDebugList$9() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean changeValue) {
        PlayerAbManager.setUseFlowMessengerEnable(changeValue);
    }
}
