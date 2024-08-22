package com.baidu.searchbox.video.feedflow.detail.toptitle.image;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.flowvideo.toptitle.TitleImageModel;
import com.baidu.searchbox.video.feedflow.clearscreen.ClearScreenNewState;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerFirstFrame;
import com.baidu.searchbox.video.feedflow.detail.toptitle.UpdateTopImageTitleVisible;
import com.baidu.searchbox.video.feedflow.detail.toptitle.UpdateTopTitleHeight;
import com.baidu.searchbox.video.feedflow.flow.list.CollectionFirstScreenDataRefreshedAction;
import com.baidu.searchbox.video.feedflow.flow.list.FlowModelUtilsKt;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\rH\u0002¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/toptitle/image/TopImageTitleReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "onNetSuccess", "", "action", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Success;", "state", "reduce", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "setVisible", "extraEnable", "", "updateVisible", "isVisible", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopImageTitleReducer.kt */
public final class TopImageTitleReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        TopImageTitleState $this$reduce_u24lambda_u2d2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof NestedAction.OnBindData) {
            TopImageTitleUtilsKt.runTopImageTitleAction(new TopImageTitleReducer$reduce$1(action, state));
        } else if (action instanceof NetAction.Success) {
            onNetSuccess((NetAction.Success) action, state);
        } else if (action instanceof NestedAction.OnDetachFromScreen) {
            TopImageTitleState topImageTitleState = (TopImageTitleState) state.select(TopImageTitleState.class);
            if (topImageTitleState != null) {
                topImageTitleState.reset();
            }
        } else {
            boolean z = false;
            TitleImageModel titleImageModel = null;
            if (action instanceof UpdateTopImageTitleVisible) {
                TopImageTitleState $this$reduce_u24lambda_u2d0 = (TopImageTitleState) state.select(TopImageTitleState.class);
                if ($this$reduce_u24lambda_u2d0 != null) {
                    if (((UpdateTopImageTitleVisible) action).getVisible()) {
                        $this$reduce_u24lambda_u2d0.setLayoutEnabled(true);
                        VideoItemModel transformVideoItemModel = FlowModelUtilsKt.transformVideoItemModel((ItemModel) state.select(ItemModel.class));
                        if (transformVideoItemModel != null) {
                            titleImageModel = transformVideoItemModel.getTitleImageModel();
                        }
                        $this$reduce_u24lambda_u2d0.getSetVisible().setValue(Boolean.valueOf(TopImageTitleUtilsKt.isShowImageTitleEnabled(titleImageModel, $this$reduce_u24lambda_u2d0.getTopRemainHeight())));
                    } else {
                        $this$reduce_u24lambda_u2d0.getSetVisible().setValue(false);
                    }
                }
            } else if (action instanceof UpdateTopTitleHeight) {
                TopImageTitleUtilsKt.runTopImageTitleAction(new TopImageTitleReducer$reduce$3(state, action, this));
            } else if (action instanceof PlayerFirstFrame) {
                TopImageTitleState $this$reduce_u24lambda_u2d1 = (TopImageTitleState) state.select(TopImageTitleState.class);
                if ($this$reduce_u24lambda_u2d1 != null) {
                    VideoItemModel transformVideoItemModel2 = FlowModelUtilsKt.transformVideoItemModel((ItemModel) state.select(ItemModel.class));
                    TitleImageModel titleImageModel2 = transformVideoItemModel2 != null ? transformVideoItemModel2.getTitleImageModel() : null;
                    if (!$this$reduce_u24lambda_u2d1.isLayoutEnabled()) {
                        return state;
                    }
                    if (titleImageModel2 == null && CommonStateExtKt.isFirstJump$default(state, (ItemModel) null, 1, (Object) null) && UBCManifestKt.isPageSourceFromCollection((AbsState) state)) {
                        return state;
                    }
                    if (CommonStateExtKt.isFirstJump$default(state, (ItemModel) null, 1, (Object) null)) {
                        ClearScreenNewState clearScreenNewState = (ClearScreenNewState) state.select(ClearScreenNewState.class);
                        if (clearScreenNewState != null && clearScreenNewState.isNewCollection()) {
                            z = true;
                        }
                        if (z) {
                            return state;
                        }
                    }
                    $this$reduce_u24lambda_u2d1.getCheckShowStatus().setValue(Unit.INSTANCE);
                }
            } else if ((action instanceof CollectionFirstScreenDataRefreshedAction) && ($this$reduce_u24lambda_u2d2 = (TopImageTitleState) state.select(TopImageTitleState.class)) != null && $this$reduce_u24lambda_u2d2.isLayoutEnabled() && CommonStateExtKt.isFirstJump$default(state, (ItemModel) null, 1, (Object) null)) {
                $this$reduce_u24lambda_u2d2.getCheckShowStatus().setValue(Unit.INSTANCE);
            }
        }
        return state;
    }

    static /* synthetic */ void setVisible$default(TopImageTitleReducer topImageTitleReducer, CommonState commonState, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        topImageTitleReducer.setVisible(commonState, z);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        r3 = r3.getShow();
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setVisible(com.baidu.searchbox.feed.detail.arch.ext.CommonState r9, boolean r10) {
        /*
            r8 = this;
            r0 = r9
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.toptitle.image.TopImageTitleState> r2 = com.baidu.searchbox.video.feedflow.detail.toptitle.image.TopImageTitleState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.toptitle.image.TopImageTitleState r0 = (com.baidu.searchbox.video.feedflow.detail.toptitle.image.TopImageTitleState) r0
            if (r0 == 0) goto L_0x0084
            r1 = r0
            r2 = 0
            boolean r3 = com.baidu.searchbox.video.feedflow.detail.toptitle.image.TopImageTitleUtilsKt.isShortVideoSize(r9)
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0048
            r3 = r9
            r6 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.toptitle.TopTitleState> r7 = com.baidu.searchbox.video.feedflow.detail.toptitle.TopTitleState.class
            java.lang.Object r3 = r3.select(r7)
            com.baidu.searchbox.video.feedflow.detail.toptitle.TopTitleState r3 = (com.baidu.searchbox.video.feedflow.detail.toptitle.TopTitleState) r3
            if (r3 == 0) goto L_0x0037
            androidx.lifecycle.MutableLiveData r3 = r3.getShow()
            if (r3 == 0) goto L_0x0037
            java.lang.Object r3 = r3.getValue()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)
            goto L_0x0038
        L_0x0037:
            r3 = r5
        L_0x0038:
            if (r3 != 0) goto L_0x0048
            boolean r3 = r1.isLayoutEnabled()
            if (r3 == 0) goto L_0x0048
            boolean r3 = r1.isShowEnabled()
            if (r3 != 0) goto L_0x0048
            r3 = r4
            goto L_0x0049
        L_0x0048:
            r3 = r5
        L_0x0049:
            r1 = 0
            if (r3 == 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r0 = r1
        L_0x004f:
            if (r0 == 0) goto L_0x0084
            r2 = 0
            r3 = r9
            r6 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r7 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r3 = r3.select(r7)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r3 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r3
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r3 = com.baidu.searchbox.video.feedflow.flow.list.FlowModelUtilsKt.transformVideoItemModel(r3)
            if (r3 == 0) goto L_0x0068
            com.baidu.searchbox.flowvideo.toptitle.TitleImageModel r1 = r3.getTitleImageModel()
        L_0x0068:
            androidx.lifecycle.MutableLiveData r3 = r0.getSetVisible()
            if (r10 == 0) goto L_0x007a
            int r6 = r0.getTopRemainHeight()
            boolean r6 = com.baidu.searchbox.video.feedflow.detail.toptitle.image.TopImageTitleUtilsKt.isShowImageTitleEnabled(r1, r6)
            if (r6 == 0) goto L_0x007a
            goto L_0x007b
        L_0x007a:
            r4 = r5
        L_0x007b:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r3.setValue(r4)
            goto L_0x0085
        L_0x0084:
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.toptitle.image.TopImageTitleReducer.setVisible(com.baidu.searchbox.feed.detail.arch.ext.CommonState, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        if ((r2 != null && r2.isAirLayerShowing()) == false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateVisible(com.baidu.searchbox.feed.detail.arch.ext.CommonState r6, boolean r7) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L_0x0035
            r2 = r6
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.toptitle.image.TopImageTitleState> r4 = com.baidu.searchbox.video.feedflow.detail.toptitle.image.TopImageTitleState.class
            java.lang.Object r2 = r2.select(r4)
            com.baidu.searchbox.video.feedflow.detail.toptitle.image.TopImageTitleState r2 = (com.baidu.searchbox.video.feedflow.detail.toptitle.image.TopImageTitleState) r2
            if (r2 == 0) goto L_0x001a
            boolean r2 = r2.isShowEnabled()
            if (r2 != r0) goto L_0x001a
            r2 = r0
            goto L_0x001b
        L_0x001a:
            r2 = r1
        L_0x001b:
            if (r2 == 0) goto L_0x0035
            r2 = r6
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.toptitle.TopTitleState> r4 = com.baidu.searchbox.video.feedflow.detail.toptitle.TopTitleState.class
            java.lang.Object r2 = r2.select(r4)
            com.baidu.searchbox.video.feedflow.detail.toptitle.TopTitleState r2 = (com.baidu.searchbox.video.feedflow.detail.toptitle.TopTitleState) r2
            if (r2 == 0) goto L_0x0031
            boolean r2 = r2.isAirLayerShowing()
            if (r2 != r0) goto L_0x0031
            r2 = r0
            goto L_0x0032
        L_0x0031:
            r2 = r1
        L_0x0032:
            if (r2 != 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r0 = r1
        L_0x0036:
            r5.setVisible(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.toptitle.image.TopImageTitleReducer.updateVisible(com.baidu.searchbox.feed.detail.arch.ext.CommonState, boolean):void");
    }

    private final void onNetSuccess(NetAction.Success<?> action, CommonState state) {
        Object data = action.getData();
        MutableLiveData<Boolean> mutableLiveData = null;
        FlowDetailModel detailModel = data instanceof FlowDetailModel ? (FlowDetailModel) data : null;
        if (detailModel != null) {
            TopImageTitleState topImageTitleState = (TopImageTitleState) state.select(TopImageTitleState.class);
            if (topImageTitleState != null) {
                mutableLiveData = topImageTitleState.isOffline();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Boolean.valueOf(detailModel.isOffLineVideo()));
            }
        }
    }
}
