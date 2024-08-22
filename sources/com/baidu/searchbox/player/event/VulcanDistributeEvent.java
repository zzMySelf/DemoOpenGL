package com.baidu.searchbox.player.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/player/event/VulcanDistributeEvent;", "Lcom/baidu/searchbox/player/event/LayerEvent;", "action", "", "(Ljava/lang/String;)V", "Companion", "vulcan-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VulcanDistributeEvent.kt */
public final class VulcanDistributeEvent extends LayerEvent {
    public static final String ACTION_REMOVE_EXT_SERVICE_SLOT = "distribute_remove_ext_service_slot";
    public static final String ACTION_REMOVE_RIGHT_CENTER_SLOT = "distribute_remove_right_center_slot";
    public static final String ACTION_VULCAN_DISTRIBUTE_PANEL_HIDE = "distribute_layer_content_panel_hide";
    public static final String ACTION_VULCAN_DISTRIBUTE_PANEL_SHOW = "distribute_layer_content_panel_show";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int KEY_VULCAN_SLOT_ID = 1;
    public static final int KEY_VULCAN_WITH_ANIMATION = 2;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/player/event/VulcanDistributeEvent$Companion;", "", "()V", "ACTION_REMOVE_EXT_SERVICE_SLOT", "", "ACTION_REMOVE_RIGHT_CENTER_SLOT", "ACTION_VULCAN_DISTRIBUTE_PANEL_HIDE", "ACTION_VULCAN_DISTRIBUTE_PANEL_SHOW", "KEY_VULCAN_SLOT_ID", "", "KEY_VULCAN_WITH_ANIMATION", "vulcan-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VulcanDistributeEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VulcanDistributeEvent(String action) {
        super(action);
        Intrinsics.checkNotNullParameter(action, "action");
    }
}
