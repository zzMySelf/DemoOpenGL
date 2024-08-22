package com.baidu.searchbox.video.feedflow.detail.bottombanner;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailBottomEntryModel;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.flowvideo.detail.repos.IntelligentRecommendModel;
import com.baidu.searchbox.video.feedflow.detail.halfscreen.switcher.HalfScreenSwitchConfigKt;
import com.baidu.searchbox.video.feedflow.detail.seamlessplay.SeamlessPlayStateKt;
import com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpState;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0004J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0004J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001c\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00022\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/bottombanner/BottomBannerReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "canInterceptFromSearchBox", "", "state", "canInterceptOfHalfScreen", "entryModel", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailBottomEntryModel;", "enableBottomBanner", "isInterceptShow", "model", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailModel;", "onNetSuccess", "", "action", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Success;", "reduce", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomBannerReducer.kt */
public class BottomBannerReducer implements Reducer<CommonState> {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v3, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: type inference failed for: r2v7, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.arch.ext.CommonState reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState r13, com.baidu.searchbox.feed.detail.frame.Action r14) {
        /*
            r12 = this;
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            boolean r0 = r14 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnBindData
            if (r0 == 0) goto L_0x0021
            r0 = r13
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState> r2 = com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState) r0
            if (r0 == 0) goto L_0x0106
            r0.reset()
            goto L_0x0106
        L_0x0021:
            boolean r0 = r14 instanceof com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success
            if (r0 == 0) goto L_0x002d
            r0 = r14
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Success r0 = (com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success) r0
            r12.onNetSuccess(r13, r0)
            goto L_0x0106
        L_0x002d:
            boolean r0 = r14 instanceof com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim
            r1 = 1
            if (r0 == 0) goto L_0x004e
            com.baidu.searchbox.video.feedflow.detail.collectonselectset.CollectionSelectSetsComponentKt.resetIsEnteredCollectionOfGuideShowing((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r13)
            r0 = r13
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState> r3 = com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState) r0
            if (r0 == 0) goto L_0x0106
            r2 = r14
            com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim r2 = (com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim) r2
            boolean r2 = r2.isStart()
            r2 = r2 ^ r1
            r0.changeVisible(r1, r2)
            goto L_0x0106
        L_0x004e:
            boolean r0 = r14 instanceof com.baidu.searchbox.video.feedflow.detail.seekbar.UserDragSeekBarEnd
            if (r0 == 0) goto L_0x0057
            com.baidu.searchbox.video.feedflow.detail.collectonselectset.CollectionSelectSetsComponentKt.resetIsEnteredCollectionOfGuideShowing((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r13)
            goto L_0x0106
        L_0x0057:
            boolean r0 = r14 instanceof com.baidu.searchbox.video.feedflow.detail.bottombanner.UpdateBottomBannerAssistantModel
            r2 = 0
            if (r0 == 0) goto L_0x007c
            r0 = r13
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState> r3 = com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState) r0
            if (r0 == 0) goto L_0x006c
            androidx.lifecycle.MutableLiveData r2 = r0.getUpdateAssistant()
        L_0x006c:
            if (r2 != 0) goto L_0x0070
            goto L_0x0106
        L_0x0070:
            r0 = r14
            com.baidu.searchbox.video.feedflow.detail.bottombanner.UpdateBottomBannerAssistantModel r0 = (com.baidu.searchbox.video.feedflow.detail.bottombanner.UpdateBottomBannerAssistantModel) r0
            com.baidu.searchbox.video.widget.textswitcher.TextSwitchModel r0 = r0.getModel()
            r2.setValue(r0)
            goto L_0x0106
        L_0x007c:
            boolean r0 = r14 instanceof com.baidu.searchbox.video.feedflow.detail.bottombanner.UpdateBottomBannerMultiLabelCount
            if (r0 == 0) goto L_0x00cf
            r0 = r13
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState> r3 = com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState) r0
            if (r0 == 0) goto L_0x00ce
            r2 = 0
            androidx.lifecycle.MutableLiveData r3 = r0.getModel()
            java.lang.Object r3 = r3.getValue()
            com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerModel r3 = (com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerModel) r3
            if (r3 == 0) goto L_0x00ce
            java.util.List r3 = r3.getTags()
            if (r3 == 0) goto L_0x00ce
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r4 = 0
            r5 = 0
            java.util.Iterator r6 = r3.iterator()
        L_0x00a7:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00cd
            java.lang.Object r7 = r6.next()
            int r8 = r5 + 1
            if (r5 >= 0) goto L_0x00b8
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x00b8:
            r9 = r7
            com.baidu.searchbox.flowvideo.detail.repos.BannerVideoLabelModel r9 = (com.baidu.searchbox.flowvideo.detail.repos.BannerVideoLabelModel) r9
            r10 = 0
            r11 = r14
            com.baidu.searchbox.video.feedflow.detail.bottombanner.UpdateBottomBannerMultiLabelCount r11 = (com.baidu.searchbox.video.feedflow.detail.bottombanner.UpdateBottomBannerMultiLabelCount) r11
            int r11 = r11.getShowCount()
            if (r5 >= r11) goto L_0x00c7
            r11 = r1
            goto L_0x00c8
        L_0x00c7:
            r11 = 0
        L_0x00c8:
            r9.setFocus(r11)
            r5 = r8
            goto L_0x00a7
        L_0x00cd:
        L_0x00ce:
            goto L_0x0106
        L_0x00cf:
            boolean r0 = r14 instanceof com.baidu.searchbox.video.feedflow.detail.bottombanner.StartBottomBannerTransHideAction
            if (r0 == 0) goto L_0x00ec
            r0 = r13
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState> r3 = com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState r0 = (com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerState) r0
            if (r0 == 0) goto L_0x00e3
            androidx.lifecycle.MutableLiveData r2 = r0.getStartTransHide()
        L_0x00e3:
            if (r2 != 0) goto L_0x00e6
            goto L_0x0106
        L_0x00e6:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r2.setValue(r0)
            goto L_0x0106
        L_0x00ec:
            boolean r0 = r14 instanceof com.baidu.searchbox.video.feedflow.detail.bottombanner.OnBottomBannerNextButtonShownAction
            if (r0 == 0) goto L_0x0106
            r0 = r13
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r4 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r0 = r0.select(r4)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r0 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r0
            if (r0 == 0) goto L_0x0100
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r2 = r0.getRunTimeStatus()
        L_0x0100:
            if (r2 != 0) goto L_0x0103
            goto L_0x0106
        L_0x0103:
            r2.setBottomBannerNextBtnShown(r1)
        L_0x0106:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerReducer.reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.feed.detail.frame.Action):com.baidu.searchbox.feed.detail.arch.ext.CommonState");
    }

    public void onNetSuccess(CommonState state, NetAction.Success<?> action) {
        FlowDetailBottomEntryModel bottomEntryModel;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        Object data = action.getData();
        FlowDetailModel model = data instanceof FlowDetailModel ? (FlowDetailModel) data : null;
        if (model != null && (bottomEntryModel = model.getBottomEntry()) != null && !model.isOffLineVideo() && enableBottomBanner(state) && !isInterceptShow(model, state) && !canInterceptOfHalfScreen(state, bottomEntryModel)) {
            BottomBannerModel bottomBannerModel = BottomBannerMapper.INSTANCE.map(model);
            if (bottomBannerModel != null) {
                ItemModel itemModel = (ItemModel) state.select(ItemModel.class);
                boolean z = true;
                if (itemModel == null || !itemModel.isBottomBannerNextBtnShown()) {
                    z = false;
                }
                bottomBannerModel.setShowNextBtn(z);
            }
            BottomBannerState bottomBannerState = (BottomBannerState) state.select(BottomBannerState.class);
            if (bottomBannerState != null) {
                bottomBannerState.setData(bottomBannerModel, model.getNid());
            }
        }
    }

    public boolean enableBottomBanner(CommonState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return true;
    }

    private final boolean isInterceptShow(FlowDetailModel model, CommonState state) {
        FlowDetailBottomEntryModel bottomModel = model.getBottomEntry();
        if (bottomModel != null) {
            if (bottomModel.isCollectionPoster() || bottomModel.isCollectionSelectSets()) {
                return true;
            }
            if (Intrinsics.areEqual((Object) bottomModel.getEntryType(), (Object) "14") && bottomModel.getTags().isEmpty()) {
                return true;
            }
            if (BottomBannerStateKt.isNotShowSearchBottom(state) && Intrinsics.areEqual((Object) bottomModel.getEntryType(), (Object) "6")) {
                return true;
            }
            IntelligentRecommendModel intelligentRecommend = model.getIntelligentRecommend();
            if (intelligentRecommend != null && intelligentRecommend.isBottomShow()) {
                IntelligentRecommendModel intelligentRecommend2 = model.getIntelligentRecommend();
                if (intelligentRecommend2 != null && intelligentRecommend2.isHasIntelligentData()) {
                    return true;
                }
            }
            if (SeamlessPlayStateKt.needShowSeamless(model, state)) {
                return true;
            }
            if (canInterceptFromSearchBox(state) && Intrinsics.areEqual((Object) bottomModel.getEntryType(), (Object) "6")) {
                return true;
            }
            if (Intrinsics.areEqual((Object) bottomModel.getEntryType(), (Object) "6")) {
                WindowMovingUpState windowMovingUpState = (WindowMovingUpState) state.select(WindowMovingUpState.class);
                if (windowMovingUpState != null && windowMovingUpState.getWindowMovingUpShowing()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r0 = r0.getSearchMarkStyle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean canInterceptFromSearchBox(com.baidu.searchbox.feed.detail.arch.ext.CommonState r10) {
        /*
            r9 = this;
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = r10
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.search.FlowDetailToSugState> r2 = com.baidu.searchbox.video.feedflow.detail.search.FlowDetailToSugState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.search.FlowDetailToSugState r0 = (com.baidu.searchbox.video.feedflow.detail.search.FlowDetailToSugState) r0
            if (r0 == 0) goto L_0x001d
            com.baidu.searchbox.video.feedflow.detail.search.SearchBoxStyleChangeModel r0 = r0.getSearchMarkStyle()
            if (r0 == 0) goto L_0x001d
            com.baidu.searchbox.video.feedflow.detail.search.view.SearchMarkViewStyle r0 = r0.getStyle()
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            boolean r1 = r0 instanceof com.baidu.searchbox.video.feedflow.detail.search.view.SearchMarkViewStyle.Expend
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x002b
            boolean r1 = r0 instanceof com.baidu.searchbox.video.feedflow.detail.search.view.SearchMarkViewStyle.Sink
            if (r1 == 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r1 = r3
            goto L_0x002c
        L_0x002b:
            r1 = r2
        L_0x002c:
            if (r1 == 0) goto L_0x006f
            boolean r4 = com.baidu.searchbox.video.feedflow.detail.search.utils.SearchBoxAbUtilsKt.searchBoxAbEnable((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r10)
            if (r4 == 0) goto L_0x0035
            goto L_0x006f
        L_0x0035:
            r4 = r10
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r6 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r4 = r4.select(r6)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r4 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r4
            if (r4 == 0) goto L_0x0047
            java.util.List r4 = r4.getFlowList()
            if (r4 != 0) goto L_0x004e
        L_0x0047:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
        L_0x004e:
            r5 = r10
            r6 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r7 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r5 = r5.select(r7)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r5
            r6 = r10
            r7 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.search.FlowDetailToSugState> r8 = com.baidu.searchbox.video.feedflow.detail.search.FlowDetailToSugState.class
            java.lang.Object r6 = r6.select(r8)
            com.baidu.searchbox.video.feedflow.detail.search.FlowDetailToSugState r6 = (com.baidu.searchbox.video.feedflow.detail.search.FlowDetailToSugState) r6
            if (r6 == 0) goto L_0x0069
            boolean r6 = r6.calculateShownLimit(r4, r5)
            goto L_0x006a
        L_0x0069:
            r6 = r3
        L_0x006a:
            if (r6 != 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r2 = r3
        L_0x006e:
            return r2
        L_0x006f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.bottombanner.BottomBannerReducer.canInterceptFromSearchBox(com.baidu.searchbox.feed.detail.arch.ext.CommonState):boolean");
    }

    /* access modifiers changed from: protected */
    public final boolean canInterceptOfHalfScreen(CommonState state, FlowDetailBottomEntryModel entryModel) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(entryModel, "entryModel");
        if (!HalfScreenSwitchConfigKt.canShowHalfScreen$default(state, false, 1, (Object) null) || Intrinsics.areEqual((Object) entryModel.getEntryType(), (Object) "11") || Intrinsics.areEqual((Object) entryModel.getEntryType(), (Object) "6") || Intrinsics.areEqual((Object) entryModel.getEntryType(), (Object) "14") || Intrinsics.areEqual((Object) entryModel.getEntryType(), (Object) "18")) {
            return false;
        }
        return true;
    }
}
