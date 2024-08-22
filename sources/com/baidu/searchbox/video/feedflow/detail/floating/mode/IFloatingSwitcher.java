package com.baidu.searchbox.video.feedflow.detail.floating.mode;

import com.baidu.searchbox.video.feedflow.detail.player.player.VideoFlowPlayer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/floating/mode/IFloatingSwitcher;", "", "back", "", "callback", "Lkotlin/Function1;", "", "bindPlayer", "player", "Lcom/baidu/searchbox/video/feedflow/detail/player/player/VideoFlowPlayer;", "close", "onFloatingDestroy", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IFloatingSwitcher.kt */
public interface IFloatingSwitcher {
    void back(Function1<? super Boolean, Unit> function1);

    void bindPlayer(VideoFlowPlayer videoFlowPlayer);

    void close();

    void onFloatingDestroy();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IFloatingSwitcher.kt */
    public static final class DefaultImpls {
        public static void close(IFloatingSwitcher iFloatingSwitcher) {
        }

        public static void back(IFloatingSwitcher iFloatingSwitcher, Function1<? super Boolean, Unit> callback) {
        }

        public static /* synthetic */ void back$default(IFloatingSwitcher iFloatingSwitcher, Function1 function1, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    function1 = null;
                }
                iFloatingSwitcher.back(function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: back");
        }

        public static void onFloatingDestroy(IFloatingSwitcher iFloatingSwitcher) {
        }

        public static void bindPlayer(IFloatingSwitcher iFloatingSwitcher, VideoFlowPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
        }
    }
}
