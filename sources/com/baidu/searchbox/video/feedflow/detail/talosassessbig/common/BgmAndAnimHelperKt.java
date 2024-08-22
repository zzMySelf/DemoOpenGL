package com.baidu.searchbox.video.feedflow.detail.talosassessbig.common;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"stateTransToString", "", "state", "Lcom/baidu/searchbox/video/feedflow/detail/talosassessbig/common/BgmAndAnimState;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BgmAndAnimHelper.kt */
public final class BgmAndAnimHelperKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BgmAndAnimHelper.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BgmAndAnimState.values().length];
            iArr[BgmAndAnimState.PLAY_SUCCESS.ordinal()] = 1;
            iArr[BgmAndAnimState.PLAY_UNUSUAL.ordinal()] = 2;
            iArr[BgmAndAnimState.DEFAULT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String stateTransToString(BgmAndAnimState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
                return "播放成功";
            case 2:
                return "播放异常";
            case 3:
                return "";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
