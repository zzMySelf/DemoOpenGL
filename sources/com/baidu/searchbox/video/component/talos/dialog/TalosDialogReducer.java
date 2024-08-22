package com.baidu.searchbox.video.component.talos.dialog;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.component.datachannel.talospanel.TalosCommonPluginModel;
import com.baidu.searchbox.video.component.datachannel.talospanel.TalosCommonPluginModelKt;
import com.baidu.searchbox.video.component.talos.dialog.TalosDialogAction;
import com.baidu.searchbox.video.component.talos.item.TalosItemAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH$J\u001e\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u000bH$J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\rH\u0014¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/video/component/talos/dialog/TalosDialogReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "mapDataChannelData", "Lcom/baidu/searchbox/video/component/datachannel/talospanel/TalosCommonPluginModel;", "state", "action", "Lcom/baidu/searchbox/video/component/talos/item/TalosItemAction$TalosItemDataUpdate;", "mapTalosDialogConfig", "Lcom/baidu/searchbox/video/component/talos/dialog/TalosDialogConfig;", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Success;", "reduce", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "reducerItem", "lib-video-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosDialogReducer.kt */
public abstract class TalosDialogReducer implements Reducer<CommonState> {
    /* access modifiers changed from: protected */
    public abstract TalosCommonPluginModel mapDataChannelData(CommonState commonState, TalosItemAction.TalosItemDataUpdate talosItemDataUpdate);

    /* access modifiers changed from: protected */
    public abstract TalosDialogConfig mapTalosDialogConfig(CommonState commonState, NetAction.Success<?> success);

    public final CommonState reduce(CommonState state, Action action) {
        TalosCommonPluginModel model;
        TalosDialogState talosDialogState;
        TalosDialogState $this$reduce_u24lambda_u2d1_u24lambda_u2d0;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof NestedAction.OnBindData) {
            TalosDialogState talosDialogState2 = (TalosDialogState) state.select(TalosDialogState.class);
            if (talosDialogState2 != null) {
                talosDialogState2.reset();
            }
        } else if (action instanceof NetAction.Success) {
            TalosDialogConfig config = mapTalosDialogConfig(state, (NetAction.Success) action);
            if (!(config == null || ($this$reduce_u24lambda_u2d1_u24lambda_u2d0 = (TalosDialogState) state.select(TalosDialogState.class)) == null)) {
                $this$reduce_u24lambda_u2d1_u24lambda_u2d0.getOnBindData().setValue(config);
            }
        } else if (action instanceof TalosDialogAction.ChangeVisibleAction) {
            TalosDialogState talosDialogState3 = (TalosDialogState) state.select(TalosDialogState.class);
            if (talosDialogState3 != null) {
                talosDialogState3.changeVisible(((TalosDialogAction.ChangeVisibleAction) action).isVisible());
            }
        } else if (action instanceof NestedAction.OnDetachFromScreen) {
            TalosDialogState talosDialogState4 = (TalosDialogState) state.select(TalosDialogState.class);
            if (talosDialogState4 != null) {
                talosDialogState4.changeVisible(false);
            }
        } else if ((action instanceof TalosItemAction.TalosItemDataUpdate) && (model = mapDataChannelData(state, (TalosItemAction.TalosItemDataUpdate) action)) != null && Intrinsics.areEqual((Object) model.getType(), (Object) TalosCommonPluginModelKt.TALOS_COMMON_PANEL_TYPE_CLOSE_PANEL) && (talosDialogState = (TalosDialogState) state.select(TalosDialogState.class)) != null) {
            talosDialogState.changeVisible(false);
        }
        return reducerItem(state, action);
    }

    /* access modifiers changed from: protected */
    public CommonState reducerItem(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        return state;
    }
}
