package com.baidu.searchbox.video.feedflow.clearscreen;

import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.clearscreen.service.IClearScreenPluginService;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"MAX_CLEAR_SCREEN_TOAST_TIME", "", "getClearScreenExtraBottomMargin", "isInClearScreen", "", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearScreenNewPlugin.kt */
public final class ClearScreenNewPluginKt {
    public static final int MAX_CLEAR_SCREEN_TOAST_TIME = 3;

    public static final boolean isInClearScreen(ComponentArchManager $this$isInClearScreen) {
        Intrinsics.checkNotNullParameter($this$isInClearScreen, "<this>");
        IClearScreenPluginService iClearScreenPluginService = (IClearScreenPluginService) $this$isInClearScreen.getService(IClearScreenPluginService.class);
        return BdPlayerUtils.orFalse(iClearScreenPluginService != null ? Boolean.valueOf(iClearScreenPluginService.isInClearScreen()) : null);
    }

    public static final int getClearScreenExtraBottomMargin() {
        return DIFactory.INSTANCE.dp2px(8.0f);
    }
}
