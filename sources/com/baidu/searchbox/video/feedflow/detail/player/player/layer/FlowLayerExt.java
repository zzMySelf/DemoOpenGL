package com.baidu.searchbox.video.feedflow.detail.player.player.layer;

import com.baidu.searchbox.player.slot.ISlot;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/FlowLayerExt;", "", "()V", "FlowDistributeSlotManifest", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowLayerExt.kt */
public final class FlowLayerExt {
    public static final FlowLayerExt INSTANCE = new FlowLayerExt();

    private FlowLayerExt() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/FlowLayerExt$FlowDistributeSlotManifest;", "Lcom/baidu/searchbox/player/slot/ISlot;", "()V", "FlowDistributeVoteSlot", "Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/FlowLayerExt$FlowDistributeSlotManifest$FlowDistributeVoteSlot;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlowLayerExt.kt */
    public static abstract class FlowDistributeSlotManifest implements ISlot {
        public /* synthetic */ FlowDistributeSlotManifest(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private FlowDistributeSlotManifest() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/FlowLayerExt$FlowDistributeSlotManifest$FlowDistributeVoteSlot;", "Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/FlowLayerExt$FlowDistributeSlotManifest;", "()V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: FlowLayerExt.kt */
        public static final class FlowDistributeVoteSlot extends FlowDistributeSlotManifest {
            public static final FlowDistributeVoteSlot INSTANCE = new FlowDistributeVoteSlot();

            private FlowDistributeVoteSlot() {
                super((DefaultConstructorMarker) null);
            }
        }
    }
}
