package com.baidu.searchbox.video.feedflow.flow.talos.item;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.component.audiofocus.OnAudioFocusChangeAction;
import com.baidu.searchbox.video.component.datachannel.talospanel.TalosCommonPluginModel;
import com.baidu.searchbox.video.component.talos.TalosConfig;
import com.baidu.searchbox.video.component.talos.item.TalosItemAction;
import com.baidu.searchbox.video.component.talos.item.TalosItemReducer;
import com.baidu.searchbox.video.feedflow.detail.panelBgmAndAnim.CardPanelAction;
import com.baidu.searchbox.video.feedflow.detail.panelBgmAndAnim.CardPanelBgmStatus;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.TalosItemInfoModel;
import com.baidu.searchbox.video.feedflow.flow.list.TalosItemModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0016\u0010\t\u001a\u0004\u0018\u00010\n2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0014J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0010H\u0014¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/talos/item/FlowTalosItemReducer;", "Lcom/baidu/searchbox/video/component/talos/item/TalosItemReducer;", "()V", "mapDataChannelData", "Lcom/baidu/searchbox/video/component/datachannel/talospanel/TalosCommonPluginModel;", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "action", "Lcom/baidu/searchbox/video/component/talos/item/TalosItemAction$TalosItemDataUpdate;", "mapTalosItemData", "Lcom/baidu/searchbox/video/component/talos/TalosConfig;", "Lcom/baidu/searchbox/feed/detail/arch/ext/NestedAction$OnBindData;", "onAudioFocusChange", "", "Lcom/baidu/searchbox/video/component/audiofocus/OnAudioFocusChangeAction;", "reducerItem", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowTalosItemReducer.kt */
public final class FlowTalosItemReducer extends TalosItemReducer {
    /* access modifiers changed from: protected */
    public CommonState reducerItem(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof CardPanelAction.BgmStatusAction) {
            FlowTalosWithBgmState flowTalosWithBgmState = (FlowTalosWithBgmState) state.select(FlowTalosWithBgmState.class);
            MutableLiveData<CardPanelBgmStatus> videoStatus = flowTalosWithBgmState != null ? flowTalosWithBgmState.getVideoStatus() : null;
            if (videoStatus != null) {
                videoStatus.setValue(((CardPanelAction.BgmStatusAction) action).getStatus());
            }
        } else if (action instanceof OnAudioFocusChangeAction) {
            onAudioFocusChange((OnAudioFocusChangeAction) action, state);
        }
        return super.reducerItem(state, action);
    }

    /* access modifiers changed from: protected */
    public TalosConfig mapTalosItemData(NestedAction.OnBindData<?> action) {
        String moduleName;
        String bundleVersion;
        Intrinsics.checkNotNullParameter(action, "action");
        Object data = action.getData();
        ItemModel model = data instanceof ItemModel ? (ItemModel) data : null;
        if (model != null) {
            Object data2 = model.getData();
            TalosItemModel talosModel = data2 instanceof TalosItemModel ? (TalosItemModel) data2 : null;
            if (talosModel != null) {
                String nid = model.getNid();
                TalosItemInfoModel info = talosModel.getInfo();
                String bundleId = info != null ? info.getBundleId() : null;
                String bundleId2 = bundleId == null ? "" : bundleId;
                TalosItemInfoModel info2 = talosModel.getInfo();
                String moduleName2 = info2 != null ? info2.getModuleName() : null;
                if (moduleName2 == null) {
                    moduleName = "";
                } else {
                    moduleName = moduleName2;
                }
                TalosItemInfoModel info3 = talosModel.getInfo();
                String bundleVersion2 = info3 != null ? info3.getBundleVersion() : null;
                if (bundleVersion2 == null) {
                    bundleVersion = "";
                } else {
                    bundleVersion = bundleVersion2;
                }
                TalosConfig config = new TalosConfig(nid, bundleId2, moduleName, bundleVersion, talosModel.getExtData());
                if (config.checkValid()) {
                    return config;
                }
            }
        }
        return null;
    }

    private final void onAudioFocusChange(OnAudioFocusChangeAction action, CommonState state) {
        if (state.isActive() && action.getFocusStatus() == 1) {
            FlowTalosWithBgmState flowTalosWithBgmState = (FlowTalosWithBgmState) state.select(FlowTalosWithBgmState.class);
            MutableLiveData<Unit> resumePlay = flowTalosWithBgmState != null ? flowTalosWithBgmState.getResumePlay() : null;
            if (resumePlay != null) {
                resumePlay.setValue(Unit.INSTANCE);
            }
        }
    }

    /* access modifiers changed from: protected */
    public TalosCommonPluginModel mapDataChannelData(CommonState state, TalosItemAction.TalosItemDataUpdate action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        String nid = action.getModel().getNid();
        ItemModel itemModel = (ItemModel) state.select(ItemModel.class);
        if (Intrinsics.areEqual((Object) nid, (Object) itemModel != null ? itemModel.getNid() : null)) {
            return action.getModel();
        }
        return null;
    }
}
