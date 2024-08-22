package com.baidu.searchbox.video.channel.tab.utils;

import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.channel.tab.ChannelTabUtilsKt;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.list.FlowState;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u001a\u001a\u0010\b\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u001a\u001a\u0010\b\u001a\u00020\u0001*\u00020\u00072\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u001a\u001a\u0010\t\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u001a\u001a\u0010\t\u001a\u00020\u0001*\u00020\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004¨\u0006\u000b"}, d2 = {"isChannelColdFirstJump", "", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "itemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "isChannelColdFirstVideo", "isChannelFirstJump", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "isChannelFirstVideo", "isChannelFlowFirstVideo", "model", "video-channel_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelFirstJumpUtils.kt */
public final class ChannelFirstJumpUtilsKt {
    public static /* synthetic */ boolean isChannelFirstJump$default(ComponentArchManager componentArchManager, ItemModel itemModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            itemModel = null;
        }
        return isChannelFirstJump(componentArchManager, (ItemModel<?>) itemModel);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r0.getState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isChannelFirstJump(com.baidu.searchbox.feed.detail.arch.ComponentArchManager r1, com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?> r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            com.baidu.searchbox.feed.detail.frame.Store r0 = r1.getStore()
            if (r0 == 0) goto L_0x001c
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r0
            if (r0 == 0) goto L_0x001c
            boolean r0 = isChannelFirstJump((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r0, (com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>) r2)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            boolean r0 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.tab.utils.ChannelFirstJumpUtilsKt.isChannelFirstJump(com.baidu.searchbox.feed.detail.arch.ComponentArchManager, com.baidu.searchbox.video.feedflow.flow.list.ItemModel):boolean");
    }

    public static /* synthetic */ boolean isChannelFirstJump$default(CommonState commonState, ItemModel itemModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            itemModel = null;
        }
        return isChannelFirstJump(commonState, (ItemModel<?>) itemModel);
    }

    public static final boolean isChannelFirstJump(CommonState $this$isChannelFirstJump, ItemModel<?> itemModel) {
        RunTimeStatus runTimeStatus;
        Intrinsics.checkNotNullParameter($this$isChannelFirstJump, "<this>");
        if (isChannelFirstVideo($this$isChannelFirstJump, itemModel)) {
            ItemModel<?> itemModel2 = itemModel == null ? (ItemModel) $this$isChannelFirstJump.select(ItemModel.class) : itemModel;
            if ((itemModel2 == null || (runTimeStatus = itemModel2.getRunTimeStatus()) == null || runTimeStatus.isDetachedOnce()) ? false : true) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isChannelColdFirstJump$default(ComponentArchManager componentArchManager, ItemModel itemModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            itemModel = null;
        }
        return isChannelColdFirstJump(componentArchManager, itemModel);
    }

    public static final boolean isChannelColdFirstJump(ComponentArchManager $this$isChannelColdFirstJump, ItemModel<?> itemModel) {
        Intrinsics.checkNotNullParameter($this$isChannelColdFirstJump, "<this>");
        return ChannelTabUtilsKt.isColdEnterVideoTab((Store<?>) $this$isChannelColdFirstJump.getStore()) && isChannelFirstJump($this$isChannelColdFirstJump, itemModel);
    }

    public static /* synthetic */ boolean isChannelFirstVideo$default(ComponentArchManager componentArchManager, ItemModel itemModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            itemModel = null;
        }
        return isChannelFirstVideo(componentArchManager, (ItemModel<?>) itemModel);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r0.getState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isChannelFirstVideo(com.baidu.searchbox.feed.detail.arch.ComponentArchManager r1, com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?> r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            com.baidu.searchbox.feed.detail.frame.Store r0 = r1.getStore()
            if (r0 == 0) goto L_0x001c
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r0
            if (r0 == 0) goto L_0x001c
            boolean r0 = isChannelFirstVideo((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r0, (com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>) r2)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            boolean r0 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.tab.utils.ChannelFirstJumpUtilsKt.isChannelFirstVideo(com.baidu.searchbox.feed.detail.arch.ComponentArchManager, com.baidu.searchbox.video.feedflow.flow.list.ItemModel):boolean");
    }

    public static /* synthetic */ boolean isChannelFirstVideo$default(CommonState commonState, ItemModel itemModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            itemModel = null;
        }
        return isChannelFirstVideo(commonState, (ItemModel<?>) itemModel);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isChannelFirstVideo(com.baidu.searchbox.feed.detail.arch.ext.CommonState r5, com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?> r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = isChannelFlowFirstVideo((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5, (com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>) r6)
            if (r0 == 0) goto L_0x0065
            r0 = r5
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r2 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.tab.TabState r0 = (com.baidu.searchbox.video.feedflow.tab.TabState) r0
            r1 = 0
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r0.getCurrentTabId()
            goto L_0x001e
        L_0x001d:
            r0 = r1
        L_0x001e:
            r2 = r5
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r4 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r2 = r2.select(r4)
            com.baidu.searchbox.video.feedflow.tab.TabState r2 = (com.baidu.searchbox.video.feedflow.tab.TabState) r2
            if (r2 == 0) goto L_0x002f
            java.lang.String r2 = r2.getDefaultSelectedTagId()
            goto L_0x0030
        L_0x002f:
            r2 = r1
        L_0x0030:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0065
            r0 = r5
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r3 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r0 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r0
            if (r0 == 0) goto L_0x005b
            androidx.lifecycle.MutableLiveData r0 = r0.getFlowModel()
            if (r0 == 0) goto L_0x005b
            java.lang.Object r0 = r0.getValue()
            com.baidu.searchbox.video.feedflow.flow.list.FlowModel r0 = (com.baidu.searchbox.video.feedflow.flow.list.FlowModel) r0
            if (r0 == 0) goto L_0x005b
            java.lang.String r1 = "request_extend_refresh_state"
            java.lang.Object r0 = r0.getExtData(r1)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
        L_0x005b:
            java.lang.String r0 = "3"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0065
            r0 = 1
            goto L_0x0066
        L_0x0065:
            r0 = 0
        L_0x0066:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.tab.utils.ChannelFirstJumpUtilsKt.isChannelFirstVideo(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.video.feedflow.flow.list.ItemModel):boolean");
    }

    public static /* synthetic */ boolean isChannelColdFirstVideo$default(ComponentArchManager componentArchManager, ItemModel itemModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            itemModel = null;
        }
        return isChannelColdFirstVideo(componentArchManager, itemModel);
    }

    public static final boolean isChannelColdFirstVideo(ComponentArchManager $this$isChannelColdFirstVideo, ItemModel<?> itemModel) {
        Intrinsics.checkNotNullParameter($this$isChannelColdFirstVideo, "<this>");
        return ChannelTabUtilsKt.isColdEnterVideoTab((Store<?>) $this$isChannelColdFirstVideo.getStore()) && isChannelFirstVideo($this$isChannelColdFirstVideo, itemModel);
    }

    public static /* synthetic */ boolean isChannelFlowFirstVideo$default(ComponentArchManager componentArchManager, ItemModel itemModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            itemModel = null;
        }
        return isChannelFlowFirstVideo(componentArchManager, (ItemModel<?>) itemModel);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r0.getState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isChannelFlowFirstVideo(com.baidu.searchbox.feed.detail.arch.ComponentArchManager r1, com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?> r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            com.baidu.searchbox.feed.detail.frame.Store r0 = r1.getStore()
            if (r0 == 0) goto L_0x001c
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r0
            if (r0 == 0) goto L_0x001c
            boolean r0 = isChannelFlowFirstVideo((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r0, (com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>) r2)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            boolean r0 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.tab.utils.ChannelFirstJumpUtilsKt.isChannelFlowFirstVideo(com.baidu.searchbox.feed.detail.arch.ComponentArchManager, com.baidu.searchbox.video.feedflow.flow.list.ItemModel):boolean");
    }

    public static /* synthetic */ boolean isChannelFlowFirstVideo$default(CommonState commonState, ItemModel itemModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            itemModel = null;
        }
        return isChannelFlowFirstVideo(commonState, (ItemModel<?>) itemModel);
    }

    public static final boolean isChannelFlowFirstVideo(CommonState $this$isChannelFlowFirstVideo, ItemModel<?> model) {
        ItemModel itemModel;
        String nid;
        List flowList;
        Intrinsics.checkNotNullParameter($this$isChannelFlowFirstVideo, "<this>");
        if (model == null) {
            itemModel = (ItemModel) $this$isChannelFlowFirstVideo.select(ItemModel.class);
        } else {
            itemModel = model;
        }
        RunTimeStatus runTimeStatus = itemModel != null ? itemModel.getRunTimeStatus() : null;
        if (DIFactory.INSTANCE.getConfig().getFlowCacheSwitch()) {
            if ((runTimeStatus != null && runTimeStatus.getPosition() == 0) && !runTimeStatus.isColdModelFromCache()) {
                return true;
            }
            if (!(itemModel == null || (nid = itemModel.getNid()) == null)) {
                FlowState flowState = (FlowState) $this$isChannelFlowFirstVideo.select(FlowState.class);
                if (flowState == null || (flowList = flowState.getFlowList()) == null) {
                    Void voidR = null;
                } else {
                    List dataSource = flowList;
                    int size = dataSource.size();
                    for (int index = 0; index < size; index++) {
                        if (Intrinsics.areEqual((Object) nid, (Object) dataSource.get(index).getNid())) {
                            int prevIndex = index - 1;
                            if (prevIndex < 0 || prevIndex >= dataSource.size()) {
                                return false;
                            }
                            if (!dataSource.get(prevIndex).getRunTimeStatus().isColdModelFromCache() || dataSource.get(index).getRunTimeStatus().isColdModelFromCache()) {
                                return false;
                            }
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        }
        return runTimeStatus != null && runTimeStatus.getPosition() == 0;
    }
}
