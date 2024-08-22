package com.baidu.searchbox.video.hotflow.flow.list;

import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.flowvideo.hot.repos.HotListModel;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState;
import com.baidu.searchbox.video.feedflow.flow.comonlistpanel.FlowListCacheModel;
import com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemDataModel;
import com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemModel;
import com.baidu.searchbox.video.feedflow.flow.hotflow.HotFlowMapper;
import com.baidu.searchbox.video.feedflow.flow.list.FlowModel;
import com.baidu.searchbox.video.feedflow.flow.list.FlowState;
import com.baidu.searchbox.video.feedflow.flow.list.HmpInfoModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.PoliciesModel;
import com.baidu.searchbox.video.feedflow.flow.list.RemoveListData;
import com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.mapper.IntentToFlowMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u000f\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001c\u0010\u0012\u001a\u00020\f2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u001dH\u0002J\u001a\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/video/hotflow/flow/list/HotFlowReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "checkResponseListValid", "", "state", "type", "", "model", "Lcom/baidu/searchbox/flowvideo/hot/repos/HotListModel;", "dealPanelBeanSuccess", "", "bean", "Lcom/baidu/searchbox/flowvideo/hot/api/CommonListPanelBean;", "dealRequestSuccess", "mapEventDataToFlowState", "Lcom/baidu/searchbox/video/feedflow/flow/comonlistpanel/HotListItemModel;", "mapIntentToFlowState", "action", "Lcom/baidu/searchbox/feed/detail/arch/ext/CoreAction$NewIntent;", "reduce", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "saveFlowListData", "switchToNextHotComment", "switchToNextHotRank", "tabId", "", "tryToNextHotTopic", "Lcom/baidu/searchbox/video/feedflow/flow/hotbottombar/HotBottomBarAction$OnNextHotClick;", "updateNewEventFlowState", "cacheModel", "Lcom/baidu/searchbox/video/feedflow/flow/comonlistpanel/FlowListCacheModel;", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotFlowReducer.kt */
public final class HotFlowReducer implements Reducer<CommonState> {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v2, resolved type: java.util.List<com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v62, resolved type: androidx.lifecycle.MutableLiveData<com.baidu.searchbox.video.feedflow.flow.list.FlowModel>} */
    /* JADX WARNING: type inference failed for: r7v5, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.arch.ext.CommonState reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState r29, com.baidu.searchbox.feed.detail.frame.Action r30) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r2 = r30
            java.lang.String r3 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            boolean r3 = r2 instanceof com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success
            if (r3 == 0) goto L_0x0055
            r3 = r2
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Success r3 = (com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success) r3
            java.lang.Object r3 = r3.getData()
            boolean r5 = r3 instanceof com.baidu.searchbox.flowvideo.hot.repos.HotListModel
            if (r5 == 0) goto L_0x0024
            com.baidu.searchbox.flowvideo.hot.repos.HotListModel r3 = (com.baidu.searchbox.flowvideo.hot.repos.HotListModel) r3
            goto L_0x0025
        L_0x0024:
            r3 = 0
        L_0x0025:
            if (r3 == 0) goto L_0x0037
            r5 = 0
            r6 = r2
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Success r6 = (com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success) r6
            int r6 = r6.getType()
            r0.dealRequestSuccess(r1, r6, r3)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x0037:
            r3 = r2
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Success r3 = (com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success) r3
            java.lang.Object r3 = r3.getData()
            boolean r5 = r3 instanceof com.baidu.searchbox.flowvideo.hot.api.CommonListPanelBean
            if (r5 == 0) goto L_0x0046
            r4 = r3
            com.baidu.searchbox.flowvideo.hot.api.CommonListPanelBean r4 = (com.baidu.searchbox.flowvideo.hot.api.CommonListPanelBean) r4
            goto L_0x0047
        L_0x0046:
            r4 = 0
        L_0x0047:
            if (r4 == 0) goto L_0x0646
            r3 = r4
            r4 = 0
            r0.dealPanelBeanSuccess(r1, r3)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            goto L_0x0646
        L_0x0055:
            boolean r3 = r2 instanceof com.baidu.searchbox.feed.detail.arch.ext.NetAction.Failure
            if (r3 == 0) goto L_0x009a
            r3 = r2
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Failure r3 = (com.baidu.searchbox.feed.detail.arch.ext.NetAction.Failure) r3
            java.lang.Class r3 = r3.getClazz()
            java.lang.Class<com.baidu.searchbox.flowvideo.hot.repos.HotFlowListParam> r4 = com.baidu.searchbox.flowvideo.hot.repos.HotFlowListParam.class
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0646
            java.lang.Class<com.baidu.searchbox.feed.detail.arch.ext.CoreState> r3 = com.baidu.searchbox.feed.detail.arch.ext.CoreState.class
            java.lang.Object r3 = r1.select(r3)
            com.baidu.searchbox.feed.detail.arch.ext.CoreState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CoreState) r3
            if (r3 == 0) goto L_0x0646
            r4 = 0
            androidx.lifecycle.MutableLiveData r5 = r3.getNetAction()
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Failure r13 = new com.baidu.searchbox.feed.detail.arch.ext.NetAction$Failure
            r6 = r2
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Failure r6 = (com.baidu.searchbox.feed.detail.arch.ext.NetAction.Failure) r6
            java.lang.Class r7 = r6.getClazz()
            r6 = r2
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Failure r6 = (com.baidu.searchbox.feed.detail.arch.ext.NetAction.Failure) r6
            java.lang.Throwable r8 = r6.getThrowable()
            r9 = 0
            r10 = 0
            r11 = 12
            r12 = 0
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r5.setValue(r13)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            goto L_0x0646
        L_0x009a:
            boolean r3 = r2 instanceof com.baidu.searchbox.feed.detail.arch.ext.NetAction.Loading
            if (r3 == 0) goto L_0x00c6
            r3 = r2
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Loading r3 = (com.baidu.searchbox.feed.detail.arch.ext.NetAction.Loading) r3
            java.lang.Class r3 = r3.getClazz()
            java.lang.Class<com.baidu.searchbox.flowvideo.hot.repos.HotFlowListParam> r4 = com.baidu.searchbox.flowvideo.hot.repos.HotFlowListParam.class
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0646
            java.lang.Class<com.baidu.searchbox.feed.detail.arch.ext.CoreState> r3 = com.baidu.searchbox.feed.detail.arch.ext.CoreState.class
            java.lang.Object r3 = r1.select(r3)
            com.baidu.searchbox.feed.detail.arch.ext.CoreState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CoreState) r3
            if (r3 == 0) goto L_0x0646
            r4 = 0
            androidx.lifecycle.MutableLiveData r5 = r3.getNetAction()
            r5.setValue(r2)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            goto L_0x0646
        L_0x00c6:
            boolean r3 = r2 instanceof com.baidu.searchbox.feed.detail.arch.ext.CoreAction.NewIntent
            if (r3 == 0) goto L_0x00d2
            r3 = r2
            com.baidu.searchbox.feed.detail.arch.ext.CoreAction$NewIntent r3 = (com.baidu.searchbox.feed.detail.arch.ext.CoreAction.NewIntent) r3
            r0.mapIntentToFlowState(r3, r1)
            goto L_0x0646
        L_0x00d2:
            boolean r3 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction
            java.lang.String r5 = "hotcomment"
            r7 = 1
            if (r3 == 0) goto L_0x040a
            r3 = r2
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction r3 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction) r3
            java.lang.Integer r3 = r3.getClickId()
            if (r3 == 0) goto L_0x00e3
            return r1
        L_0x00e3:
            r3 = r2
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction r3 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction) r3
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemModel r3 = r3.getItemModel()
            if (r3 == 0) goto L_0x0646
            r8 = 0
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemDataModel r9 = r3.getData()
            if (r9 == 0) goto L_0x00f8
            java.lang.String r9 = r9.getLayoutType()
            goto L_0x00f9
        L_0x00f8:
            r9 = 0
        L_0x00f9:
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r5)
            if (r9 == 0) goto L_0x033c
            r9 = r29
            r10 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r11 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r9 = r9.select(r11)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r9 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r9
            if (r9 == 0) goto L_0x01cb
            r10 = 0
            java.util.List r11 = r9.getFlowList()
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            r11 = r11 ^ r7
            if (r11 == 0) goto L_0x01c6
            java.lang.String r11 = r9.getCurrentFlowType()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x01c6
            r5 = r29
            r11 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState> r12 = com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState.class
            java.lang.Object r5 = r5.select(r12)
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState r5 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState) r5
            if (r5 == 0) goto L_0x0136
            java.lang.String r5 = r5.getCurrentFlowTab()
            goto L_0x0137
        L_0x0136:
            r5 = 0
        L_0x0137:
            r11 = 0
            r11 = -1
            if (r5 == 0) goto L_0x0146
            r12 = r5
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = kotlin.text.StringsKt.isBlank(r12)
            r12 = r12 ^ r7
            if (r12 != r7) goto L_0x0146
            goto L_0x0147
        L_0x0146:
            r7 = 0
        L_0x0147:
            if (r7 == 0) goto L_0x01c4
            java.util.List r4 = r9.getFlowList()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r6 = 0
            r7 = 0
            java.util.Iterator r12 = r4.iterator()
        L_0x0155:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0198
            java.lang.Object r13 = r12.next()
            int r14 = r7 + 1
            if (r7 >= 0) goto L_0x0166
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0166:
            r15 = r13
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r15 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r15
            r16 = 0
            r17 = r4
            java.lang.String r4 = r3.getId()
            r18 = r5
            java.lang.String r5 = r15.getId()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x0192
            r11 = r7
            androidx.lifecycle.MutableLiveData r4 = r9.getScrollToPosition()
            if (r4 != 0) goto L_0x0185
            goto L_0x018c
        L_0x0185:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            r4.setValue(r5)
        L_0x018c:
            r7 = r14
            r4 = r17
            r5 = r18
            goto L_0x0155
        L_0x0192:
            r7 = r14
            r4 = r17
            r5 = r18
            goto L_0x0155
        L_0x0198:
            r17 = r4
            r18 = r5
            if (r11 >= 0) goto L_0x01c2
            r11 = 0
            com.baidu.searchbox.video.feedflow.di.DIFactory r4 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            android.content.Context r4 = r4.getAppContext()
            com.baidu.android.ext.widget.toast.UniversalToast r4 = com.baidu.android.ext.widget.toast.UniversalToast.makeText(r4)
            com.baidu.searchbox.video.feedflow.di.DIFactory r5 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            android.content.Context r5 = r5.getAppContext()
            android.content.res.Resources r5 = r5.getResources()
            int r6 = com.baidu.searchbox.video.feedflow.component.R.string.video_flow_hot_islose
            java.lang.String r5 = r5.getString(r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            com.baidu.android.ext.widget.toast.UniversalToast r4 = r4.setText(r5)
            r4.show()
        L_0x01c2:
            goto L_0x0404
        L_0x01c4:
            r18 = r5
        L_0x01c6:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
        L_0x01cb:
            r5 = r29
            r7 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState> r9 = com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState.class
            java.lang.Object r5 = r5.select(r9)
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState r5 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState) r5
            if (r5 == 0) goto L_0x033a
            androidx.lifecycle.MutableLiveData r5 = r5.getTabModelList()
            if (r5 == 0) goto L_0x033a
            java.lang.Object r5 = r5.getValue()
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            if (r5 == 0) goto L_0x033a
            java.lang.String r7 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            r9 = 0
            java.util.Iterator r10 = r5.iterator()
        L_0x01f3:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0336
            java.lang.Object r11 = r10.next()
            r12 = r11
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotTopicListTabModel r12 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotTopicListTabModel) r12
            r13 = 0
            java.lang.String r14 = r12.getTabId()
            r15 = r2
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction r15 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction) r15
            java.lang.String r15 = r15.getTabId()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r15)
            if (r14 == 0) goto L_0x032c
            r14 = r29
            r15 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r6 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r6 = r14.select(r6)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r6 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r6
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.List r14 = (java.util.List) r14
            r15 = 0
            r15 = -1
            androidx.lifecycle.MutableLiveData r17 = r12.getItems()
            java.lang.Object r17 = r17.getValue()
            r4 = r17
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            if (r4 == 0) goto L_0x02c2
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r17 = 0
            r19 = 0
            java.util.Iterator r20 = r4.iterator()
        L_0x0241:
            boolean r21 = r20.hasNext()
            if (r21 == 0) goto L_0x02b9
            java.lang.Object r21 = r20.next()
            int r22 = r19 + 1
            if (r19 >= 0) goto L_0x0252
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0252:
            r23 = r4
            r4 = r21
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemModel r4 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemModel) r4
            r24 = 0
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r25 = r4.getCacheItemModel()
            if (r25 == 0) goto L_0x026b
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r25 = r4.getCacheItemModel()
            r26 = r7
            r7 = r25
            r25 = r5
            goto L_0x0295
        L_0x026b:
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemDataModel r25 = r4.getData()
            if (r25 == 0) goto L_0x0276
            com.baidu.searchbox.video.detail.core.model.IntentData r25 = r25.getCmdToIntentData()
            goto L_0x0278
        L_0x0276:
            r25 = 0
        L_0x0278:
            r26 = r25
            r25 = r5
            r5 = r26
            if (r5 == 0) goto L_0x028d
            r26 = r7
            com.baidu.searchbox.video.feedflow.flow.list.mapper.IntentToItemModelMapper r7 = com.baidu.searchbox.video.feedflow.flow.list.mapper.IntentToItemModelMapper.INSTANCE
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r7 = r7.map((com.baidu.searchbox.video.detail.core.model.IntentData) r5)
            r4.setCacheItemModel(r7)
            goto L_0x0295
        L_0x028d:
            r26 = r7
            r7 = 0
            r18 = r7
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r18 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r18
            r7 = 0
        L_0x0295:
            r5 = r7
            if (r5 == 0) goto L_0x02ae
            r14.add(r5)
            java.lang.String r7 = r3.getId()
            r27 = r4
            java.lang.String r4 = r5.getId()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x02b0
            r15 = r19
            goto L_0x02b0
        L_0x02ae:
            r27 = r4
        L_0x02b0:
            r19 = r22
            r4 = r23
            r5 = r25
            r7 = r26
            goto L_0x0241
        L_0x02b9:
            r23 = r4
            r25 = r5
            r26 = r7
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x02c6
        L_0x02c2:
            r25 = r5
            r26 = r7
        L_0x02c6:
            if (r15 >= 0) goto L_0x02eb
            com.baidu.searchbox.video.feedflow.di.DIFactory r4 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            android.content.Context r4 = r4.getAppContext()
            com.baidu.android.ext.widget.toast.UniversalToast r4 = com.baidu.android.ext.widget.toast.UniversalToast.makeText(r4)
            com.baidu.searchbox.video.feedflow.di.DIFactory r5 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            android.content.Context r5 = r5.getAppContext()
            android.content.res.Resources r5 = r5.getResources()
            int r7 = com.baidu.searchbox.video.feedflow.component.R.string.video_flow_hot_islose
            java.lang.String r5 = r5.getString(r7)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            com.baidu.android.ext.widget.toast.UniversalToast r4 = r4.setText(r5)
            r4.show()
        L_0x02eb:
            if (r6 == 0) goto L_0x0330
            androidx.lifecycle.MutableLiveData r4 = r12.getHasPrev()
            java.lang.Object r4 = r4.getValue()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            if (r4 != 0) goto L_0x02ff
            r4 = 0
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)
            r4 = r5
        L_0x02ff:
            java.lang.String r5 = "tabModel.hasPrev.value ?: false"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            boolean r4 = r4.booleanValue()
            androidx.lifecycle.MutableLiveData r5 = r12.getHasNext()
            java.lang.Object r5 = r5.getValue()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            if (r5 != 0) goto L_0x031b
            r5 = 0
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)
            r5 = r7
        L_0x031b:
            java.lang.String r7 = "tabModel.hasNext.value ?: false"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            boolean r5 = r5.booleanValue()
            r6.resetFlowState(r14, r4, r5, r15)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x0330
        L_0x032c:
            r25 = r5
            r26 = r7
        L_0x0330:
            r5 = r25
            r7 = r26
            goto L_0x01f3
        L_0x0336:
            r25 = r5
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x033a:
            goto L_0x0403
        L_0x033c:
            r4 = r29
            r6 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r9 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r4 = r4.select(r9)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r4 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r4
            java.lang.String r6 = ""
            if (r4 == 0) goto L_0x037d
            r9 = 0
            java.lang.String r10 = r4.getCurrentFlowType()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0378
            androidx.lifecycle.MutableLiveData r5 = r4.getClearList()
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            r5.setValue(r10)
            r5 = r2
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction r5 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction) r5
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemModel r5 = r5.getItemModel()
            if (r5 == 0) goto L_0x0374
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemDataModel r5 = r5.getData()
            if (r5 == 0) goto L_0x0374
            java.lang.String r5 = r5.getLayoutType()
            if (r5 != 0) goto L_0x0375
        L_0x0374:
            r5 = r6
        L_0x0375:
            r4.setCurrentFlowType(r5)
        L_0x0378:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x037d:
            r4 = r29
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r9 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r4 = r4.select(r9)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r4 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r4
            if (r4 == 0) goto L_0x038f
            java.lang.Object r4 = r4.getData()
            goto L_0x0390
        L_0x038f:
            r4 = 0
        L_0x0390:
            boolean r5 = r4 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel
            if (r5 == 0) goto L_0x0397
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r4 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r4
            goto L_0x0398
        L_0x0397:
            r4 = 0
        L_0x0398:
            if (r4 == 0) goto L_0x039f
            java.lang.String r5 = r4.getEventId()
            goto L_0x03a0
        L_0x039f:
            r5 = 0
        L_0x03a0:
            r9 = r2
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction r9 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction) r9
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemModel r9 = r9.getItemModel()
            if (r9 == 0) goto L_0x03b4
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemDataModel r9 = r9.getData()
            if (r9 == 0) goto L_0x03b4
            java.lang.String r9 = r9.getEventId()
            goto L_0x03b5
        L_0x03b4:
            r9 = 0
        L_0x03b5:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r9)
            if (r5 != 0) goto L_0x0403
            r5 = r29
            r9 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState> r10 = com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState.class
            java.lang.Object r5 = r5.select(r10)
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState r5 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState) r5
            if (r5 == 0) goto L_0x0403
            r9 = 0
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemDataModel r10 = r3.getData()
            if (r10 == 0) goto L_0x03d7
            java.lang.String r10 = r10.getEventId()
            if (r10 != 0) goto L_0x03d6
            goto L_0x03d7
        L_0x03d6:
            r6 = r10
        L_0x03d7:
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.FlowListCacheModel r6 = r5.getFlowListCache(r6)
            if (r6 == 0) goto L_0x03e4
            java.util.List r10 = r6.getItems()
            r18 = r10
            goto L_0x03e6
        L_0x03e4:
            r18 = 0
        L_0x03e6:
            java.util.Collection r18 = (java.util.Collection) r18
            if (r18 == 0) goto L_0x03f4
            boolean r10 = r18.isEmpty()
            if (r10 == 0) goto L_0x03f1
            goto L_0x03f4
        L_0x03f1:
            r16 = 0
            goto L_0x03f6
        L_0x03f4:
            r16 = r7
        L_0x03f6:
            if (r16 == 0) goto L_0x03fc
            r0.mapEventDataToFlowState(r3, r1)
            goto L_0x03ff
        L_0x03fc:
            r0.updateNewEventFlowState(r6, r1)
        L_0x03ff:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
        L_0x0403:
        L_0x0404:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            goto L_0x0646
        L_0x040a:
            boolean r3 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.hotbottombar.HotBottomBarAction.OnNextHotClick
            if (r3 == 0) goto L_0x049c
            com.baidu.searchbox.video.feedflow.di.DIFactory r3 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            boolean r3 = r3.isNetConnected()
            if (r3 == 0) goto L_0x0646
            r3 = r29
            r4 = 0
            java.lang.Class<com.baidu.searchbox.feed.detail.arch.ext.CoreState> r6 = com.baidu.searchbox.feed.detail.arch.ext.CoreState.class
            java.lang.Object r3 = r3.select(r6)
            com.baidu.searchbox.feed.detail.arch.ext.CoreState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CoreState) r3
            if (r3 == 0) goto L_0x0431
            androidx.lifecycle.MutableLiveData r3 = r3.getNetAction()
            if (r3 == 0) goto L_0x0431
            java.lang.Object r3 = r3.getValue()
            r7 = r3
            com.baidu.searchbox.feed.detail.arch.ext.NetAction r7 = (com.baidu.searchbox.feed.detail.arch.ext.NetAction) r7
            goto L_0x0432
        L_0x0431:
            r7 = 0
        L_0x0432:
            boolean r3 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.NetAction.Loading
            if (r3 == 0) goto L_0x0439
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Loading r7 = (com.baidu.searchbox.feed.detail.arch.ext.NetAction.Loading) r7
            goto L_0x043a
        L_0x0439:
            r7 = 0
        L_0x043a:
            if (r7 == 0) goto L_0x0441
            java.lang.Class r7 = r7.getClazz()
            goto L_0x0442
        L_0x0441:
            r7 = 0
        L_0x0442:
            java.lang.Class<com.baidu.searchbox.flowvideo.hot.repos.HotFlowListParam> r3 = com.baidu.searchbox.flowvideo.hot.repos.HotFlowListParam.class
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x046e
            com.baidu.searchbox.video.feedflow.di.DIFactory r3 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            android.content.Context r3 = r3.getAppContext()
            com.baidu.android.ext.widget.toast.UniversalToast r3 = com.baidu.android.ext.widget.toast.UniversalToast.makeText(r3)
            com.baidu.searchbox.video.feedflow.di.DIFactory r4 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            android.content.Context r4 = r4.getAppContext()
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.baidu.searchbox.video.feedflow.component.R.string.video_flow_hot_too_fast
            java.lang.String r4 = r4.getString(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            com.baidu.android.ext.widget.toast.UniversalToast r3 = r3.setText(r4)
            r3.show()
            return r1
        L_0x046e:
            r3 = r29
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r6 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r3 = r3.select(r6)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r3 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r3
            if (r3 == 0) goto L_0x0480
            java.lang.String r4 = r3.getCurrentFlowType()
            goto L_0x0481
        L_0x0480:
            r4 = 0
        L_0x0481:
            java.lang.String r3 = "hotrank"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0491
            r3 = r2
            com.baidu.searchbox.video.feedflow.flow.hotbottombar.HotBottomBarAction$OnNextHotClick r3 = (com.baidu.searchbox.video.feedflow.flow.hotbottombar.HotBottomBarAction.OnNextHotClick) r3
            r0.tryToNextHotTopic(r1, r3)
            goto L_0x0646
        L_0x0491:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0646
            r28.switchToNextHotComment(r29)
            goto L_0x0646
        L_0x049c:
            boolean r3 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.offline.OnOfflineTimerTaskCompleted
            if (r3 == 0) goto L_0x04c7
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r3 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r3 = r1.select(r3)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r3 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r3
            if (r3 == 0) goto L_0x0646
            r4 = 0
            r3.setScrollType(r7)
            androidx.lifecycle.MutableLiveData r5 = r3.getSmoothScrollToPosition()
            r6 = r2
            com.baidu.searchbox.video.feedflow.detail.offline.OnOfflineTimerTaskCompleted r6 = (com.baidu.searchbox.video.feedflow.detail.offline.OnOfflineTimerTaskCompleted) r6
            int r6 = r6.getPosition()
            int r6 = r6 + r7
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5.setValue(r6)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            goto L_0x0646
        L_0x04c7:
            boolean r3 = r2 instanceof com.baidu.searchbox.video.feedflow.detail.offline.OnOfflineNotActive
            if (r3 == 0) goto L_0x04ea
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r3 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r3 = r1.select(r3)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r3 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r3
            if (r3 == 0) goto L_0x0646
            r4 = 0
            androidx.lifecycle.MutableLiveData r5 = r3.getRemoveItemModel()
            r6 = r2
            com.baidu.searchbox.video.feedflow.detail.offline.OnOfflineNotActive r6 = (com.baidu.searchbox.video.feedflow.detail.offline.OnOfflineNotActive) r6
            java.lang.String r6 = r6.getNid()
            r5.setValue(r6)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            goto L_0x0646
        L_0x04ea:
            boolean r3 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.list.ScrollDisable
            if (r3 == 0) goto L_0x050f
            r3 = r29
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r5 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r3 = r3.select(r5)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r3 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r3
            if (r3 == 0) goto L_0x0500
            androidx.lifecycle.MutableLiveData r4 = r3.getCanScroll()
            goto L_0x0501
        L_0x0500:
            r4 = 0
        L_0x0501:
            if (r4 != 0) goto L_0x0505
            goto L_0x0646
        L_0x0505:
            r3 = 0
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r4.setValue(r3)
            goto L_0x0646
        L_0x050f:
            boolean r3 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.list.ScrollEnable
            if (r3 == 0) goto L_0x0533
            r3 = r29
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r5 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r3 = r3.select(r5)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r3 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r3
            if (r3 == 0) goto L_0x0525
            androidx.lifecycle.MutableLiveData r4 = r3.getCanScroll()
            goto L_0x0526
        L_0x0525:
            r4 = 0
        L_0x0526:
            if (r4 != 0) goto L_0x052a
            goto L_0x0646
        L_0x052a:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r7)
            r4.setValue(r3)
            goto L_0x0646
        L_0x0533:
            boolean r3 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowType
            if (r3 == 0) goto L_0x0552
            r3 = r29
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r5 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r3 = r3.select(r5)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r3 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r3
            if (r3 != 0) goto L_0x0546
            goto L_0x0646
        L_0x0546:
            r4 = r2
            com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowType r4 = (com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowType) r4
            java.lang.String r4 = r4.getFlowType()
            r3.setCurrentFlowType(r4)
            goto L_0x0646
        L_0x0552:
            boolean r3 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelDataToFlowDataAction
            if (r3 == 0) goto L_0x0646
            r3 = r29
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r5 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r3 = r3.select(r5)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r3 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r3
            if (r3 == 0) goto L_0x0568
            androidx.lifecycle.MutableLiveData r4 = r3.getFlowModel()
            goto L_0x0569
        L_0x0568:
            r4 = 0
        L_0x0569:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
            r6 = r2
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelDataToFlowDataAction r6 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelDataToFlowDataAction) r6
            java.util.ArrayList r6 = r6.getItemModelList()
            if (r6 == 0) goto L_0x05d9
            r8 = r6
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            r9 = 0
            r10 = 0
            java.util.Iterator r11 = r8.iterator()
        L_0x0582:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x05d5
            java.lang.Object r12 = r11.next()
            int r13 = r10 + 1
            if (r10 >= 0) goto L_0x0593
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0593:
            r14 = r12
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemModel r14 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemModel) r14
            r15 = 0
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r16 = r14.getCacheItemModel()
            if (r16 == 0) goto L_0x05a5
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r16 = r14.getCacheItemModel()
            r7 = r16
            r0 = 0
            goto L_0x05ca
        L_0x05a5:
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemDataModel r16 = r14.getData()
            if (r16 == 0) goto L_0x05b0
            com.baidu.searchbox.video.detail.core.model.IntentData r16 = r16.getCmdToIntentData()
            goto L_0x05b2
        L_0x05b0:
            r16 = 0
        L_0x05b2:
            r17 = r16
            r7 = r17
            if (r7 == 0) goto L_0x05c4
            com.baidu.searchbox.video.feedflow.flow.list.mapper.IntentToItemModelMapper r0 = com.baidu.searchbox.video.feedflow.flow.list.mapper.IntentToItemModelMapper.INSTANCE
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r0 = r0.map((com.baidu.searchbox.video.detail.core.model.IntentData) r7)
            r14.setCacheItemModel(r0)
            r7 = r0
            r0 = 0
            goto L_0x05ca
        L_0x05c4:
            r0 = 0
            r17 = r0
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r17 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r17
            r7 = r0
        L_0x05ca:
            if (r7 == 0) goto L_0x05d0
            r5.add(r7)
        L_0x05d0:
            r7 = 1
            r0 = r28
            r10 = r13
            goto L_0x0582
        L_0x05d5:
            r0 = 0
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            goto L_0x05da
        L_0x05d9:
            r0 = 0
        L_0x05da:
            if (r3 != 0) goto L_0x05dd
            goto L_0x05e7
        L_0x05dd:
            r7 = r2
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelDataToFlowDataAction r7 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelDataToFlowDataAction) r7
            boolean r7 = r7.getHasPrev()
            r3.setHasPrev(r7)
        L_0x05e7:
            if (r3 != 0) goto L_0x05ea
            goto L_0x05f4
        L_0x05ea:
            r7 = r2
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelDataToFlowDataAction r7 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelDataToFlowDataAction) r7
            boolean r7 = r7.getHasNext()
            r3.setHasMore(r7)
        L_0x05f4:
            r7 = r2
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelDataToFlowDataAction r7 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelDataToFlowDataAction) r7
            int r7 = r7.getType()
            switch(r7) {
                case 2: goto L_0x0618;
                case 3: goto L_0x0608;
                case 4: goto L_0x05ff;
                default: goto L_0x05fe;
            }
        L_0x05fe:
            goto L_0x0620
        L_0x05ff:
            if (r3 != 0) goto L_0x0602
            goto L_0x0620
        L_0x0602:
            java.lang.String r7 = "1"
            r3.setOriginDir(r7)
            goto L_0x0620
        L_0x0608:
            if (r3 != 0) goto L_0x060b
            goto L_0x060f
        L_0x060b:
            r7 = 1
            r3.setHasLoadFirstPage(r7)
        L_0x060f:
            if (r3 != 0) goto L_0x0612
            goto L_0x0620
        L_0x0612:
            java.lang.String r7 = "0"
            r3.setOriginDir(r7)
            goto L_0x0620
        L_0x0618:
            if (r3 != 0) goto L_0x061b
            goto L_0x0620
        L_0x061b:
            java.lang.String r7 = "-1"
            r3.setOriginDir(r7)
        L_0x0620:
            if (r4 == 0) goto L_0x0629
            java.lang.Object r7 = r4.getValue()
            com.baidu.searchbox.video.feedflow.flow.list.FlowModel r7 = (com.baidu.searchbox.video.feedflow.flow.list.FlowModel) r7
            goto L_0x062a
        L_0x0629:
            r7 = r0
        L_0x062a:
            if (r7 != 0) goto L_0x062d
            goto L_0x0630
        L_0x062d:
            r7.setItems(r5)
        L_0x0630:
            if (r3 == 0) goto L_0x0637
            androidx.lifecycle.MutableLiveData r7 = r3.getFlowModel()
            goto L_0x0638
        L_0x0637:
            r7 = r0
        L_0x0638:
            if (r7 != 0) goto L_0x063b
            goto L_0x0646
        L_0x063b:
            if (r4 == 0) goto L_0x0643
            java.lang.Object r0 = r4.getValue()
            com.baidu.searchbox.video.feedflow.flow.list.FlowModel r0 = (com.baidu.searchbox.video.feedflow.flow.list.FlowModel) r0
        L_0x0643:
            r7.setValue(r0)
        L_0x0646:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.hotflow.flow.list.HotFlowReducer.reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.feed.detail.frame.Action):com.baidu.searchbox.feed.detail.arch.ext.CommonState");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001a, code lost:
        r2 = r2.getCurItemModel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void tryToNextHotTopic(com.baidu.searchbox.feed.detail.arch.ext.CommonState r8, com.baidu.searchbox.video.feedflow.flow.hotbottombar.HotBottomBarAction.OnNextHotClick r9) {
        /*
            r7 = this;
            r0 = r8
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState> r2 = com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState r0 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState) r0
            if (r0 == 0) goto L_0x0091
            r1 = 0
            r2 = r8
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r4 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r2 = r2.select(r4)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r2 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r2
            r3 = 0
            if (r2 == 0) goto L_0x0025
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r2 = r2.getCurItemModel()
            if (r2 == 0) goto L_0x0025
            java.lang.Object r2 = r2.getData()
            goto L_0x0026
        L_0x0025:
            r2 = r3
        L_0x0026:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel
            if (r4 == 0) goto L_0x002d
            r3 = r2
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r3 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r3
        L_0x002d:
            java.lang.String r2 = ""
            if (r3 == 0) goto L_0x0037
            java.lang.String r3 = r3.getEventId()
            if (r3 != 0) goto L_0x0038
        L_0x0037:
            r3 = r2
        L_0x0038:
            java.lang.String r4 = r0.getCurrentFlowTab()
            if (r4 != 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r2 = r4
        L_0x0040:
            boolean r2 = r0.isLastEventData(r2, r3)
            if (r2 == 0) goto L_0x0084
            boolean r4 = r0.hasFirstEventData()
            if (r4 != 0) goto L_0x0084
            boolean r4 = r0.hasFirstEventFirstId()
            if (r4 == 0) goto L_0x0084
            com.baidu.searchbox.video.feedflow.di.DIFactory r4 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            android.content.Context r4 = r4.getAppContext()
            com.baidu.android.ext.widget.toast.UniversalToast r4 = com.baidu.android.ext.widget.toast.UniversalToast.makeText(r4)
            com.baidu.searchbox.video.feedflow.di.DIFactory r5 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            android.content.Context r5 = r5.getAppContext()
            android.content.res.Resources r5 = r5.getResources()
            int r6 = com.baidu.searchbox.video.feedflow.component.R.string.video_flow_hot_too_fast
            java.lang.String r5 = r5.getString(r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            com.baidu.android.ext.widget.toast.UniversalToast r4 = r4.setText(r5)
            r4.show()
            androidx.lifecycle.MutableLiveData r4 = r0.getNeedLoadFirstPageTabId()
            if (r4 != 0) goto L_0x007c
            goto L_0x008f
        L_0x007c:
            java.lang.String r5 = r0.getCurrentFlowTab()
            r4.setValue(r5)
            goto L_0x008f
        L_0x0084:
            com.baidu.searchbox.video.feedflow.flow.hotbottombar.HotBottomBarModel r4 = r9.getModel()
            java.lang.String r4 = r4.getTabId()
            r7.switchToNextHotRank(r8, r4)
        L_0x008f:
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.hotflow.flow.list.HotFlowReducer.tryToNextHotTopic(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.video.feedflow.flow.hotbottombar.HotBottomBarAction$OnNextHotClick):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001a, code lost:
        r2 = r2.getCurItemModel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void switchToNextHotRank(com.baidu.searchbox.feed.detail.arch.ext.CommonState r10, java.lang.String r11) {
        /*
            r9 = this;
            r0 = r10
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState> r2 = com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState r0 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState) r0
            if (r0 == 0) goto L_0x0107
            r1 = 0
            r2 = r10
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r4 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r2 = r2.select(r4)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r2 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r2
            r3 = 0
            if (r2 == 0) goto L_0x0025
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r2 = r2.getCurItemModel()
            if (r2 == 0) goto L_0x0025
            java.lang.Object r2 = r2.getData()
            goto L_0x0026
        L_0x0025:
            r2 = r3
        L_0x0026:
            boolean r4 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel
            if (r4 == 0) goto L_0x002d
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r2 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r2
            goto L_0x002e
        L_0x002d:
            r2 = r3
        L_0x002e:
            java.lang.String r4 = ""
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = r2.getEventId()
            if (r2 != 0) goto L_0x0039
        L_0x0038:
            r2 = r4
        L_0x0039:
            boolean r5 = r0.isLastEventData(r11, r2)
            r6 = 0
            if (r5 == 0) goto L_0x006b
            boolean r5 = r0.hasFirstEventData()
            if (r5 == 0) goto L_0x006b
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotTopicListTabModel r5 = r0.getCurHotTopicListTabModel()
            if (r5 == 0) goto L_0x0069
            androidx.lifecycle.MutableLiveData r5 = r5.getItems()
            if (r5 == 0) goto L_0x0069
            java.lang.Object r5 = r5.getValue()
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            if (r5 == 0) goto L_0x0069
            java.lang.String r7 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r5 = kotlin.collections.CollectionsKt.getOrNull(r5, r6)
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemModel) r5
            goto L_0x006f
        L_0x0069:
            r5 = r3
            goto L_0x006f
        L_0x006b:
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemModel r5 = r0.getNextEventData(r11, r2)
        L_0x006f:
            if (r5 == 0) goto L_0x0080
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemDataModel r7 = r5.getData()
            if (r7 == 0) goto L_0x0080
            java.lang.String r7 = r7.getEventId()
            if (r7 != 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            r4 = r7
        L_0x0080:
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.FlowListCacheModel r7 = r0.getFlowListCache(r4)
            if (r7 == 0) goto L_0x008a
            java.util.List r3 = r7.getItems()
        L_0x008a:
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L_0x0097
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0095
            goto L_0x0097
        L_0x0095:
            r3 = r6
            goto L_0x0098
        L_0x0097:
            r3 = 1
        L_0x0098:
            if (r3 != 0) goto L_0x009e
            r9.updateNewEventFlowState(r7, r10)
            goto L_0x0105
        L_0x009e:
            if (r5 == 0) goto L_0x00a4
            r9.mapEventDataToFlowState(r5, r10)
            goto L_0x0105
        L_0x00a4:
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotTopicListTabModel r3 = r0.getCurHotTopicListTabModel()
            if (r3 == 0) goto L_0x00bc
            androidx.lifecycle.MutableLiveData r3 = r3.getHasNext()
            if (r3 == 0) goto L_0x00bc
            java.lang.Object r3 = r3.getValue()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)
        L_0x00bc:
            if (r6 == 0) goto L_0x00e2
            com.baidu.searchbox.video.feedflow.di.DIFactory r3 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            android.content.Context r3 = r3.getAppContext()
            com.baidu.android.ext.widget.toast.UniversalToast r3 = com.baidu.android.ext.widget.toast.UniversalToast.makeText(r3)
            com.baidu.searchbox.video.feedflow.di.DIFactory r6 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            android.content.Context r6 = r6.getAppContext()
            android.content.res.Resources r6 = r6.getResources()
            int r8 = com.baidu.searchbox.video.feedflow.component.R.string.video_flow_hot_no_next_hot_text
            java.lang.String r6 = r6.getString(r8)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            com.baidu.android.ext.widget.toast.UniversalToast r3 = r3.setText(r6)
            r3.show()
            goto L_0x0105
        L_0x00e2:
            com.baidu.searchbox.video.feedflow.di.DIFactory r3 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            android.content.Context r3 = r3.getAppContext()
            com.baidu.android.ext.widget.toast.UniversalToast r3 = com.baidu.android.ext.widget.toast.UniversalToast.makeText(r3)
            com.baidu.searchbox.video.feedflow.di.DIFactory r6 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            android.content.Context r6 = r6.getAppContext()
            android.content.res.Resources r6 = r6.getResources()
            int r8 = com.baidu.searchbox.video.feedflow.component.R.string.video_flow_hot_too_fast
            java.lang.String r6 = r6.getString(r8)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            com.baidu.android.ext.widget.toast.UniversalToast r3 = r3.setText(r6)
            r3.show()
        L_0x0105:
        L_0x0107:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.hotflow.flow.list.HotFlowReducer.switchToNextHotRank(com.baidu.searchbox.feed.detail.arch.ext.CommonState, java.lang.String):void");
    }

    private final void switchToNextHotComment(CommonState state) {
        String eventId;
        FlowState $this$switchToNextHotComment_u24lambda_u2d17 = (FlowState) state.select(FlowState.class);
        if ($this$switchToNextHotComment_u24lambda_u2d17 == null) {
            return;
        }
        if ($this$switchToNextHotComment_u24lambda_u2d17.getCurItemPosition() + 1 >= $this$switchToNextHotComment_u24lambda_u2d17.getFlowList().size()) {
            CommonListPanelState $this$switchToNextHotComment_u24lambda_u2d17_u24lambda_u2d16 = (CommonListPanelState) state.select(CommonListPanelState.class);
            if ($this$switchToNextHotComment_u24lambda_u2d17_u24lambda_u2d16 != null) {
                FlowState flowState = (FlowState) state.select(FlowState.class);
                String str = "";
                if (flowState == null || (eventId = flowState.getLastEventId()) == null) {
                    eventId = str;
                }
                String currentFlowTab = $this$switchToNextHotComment_u24lambda_u2d17_u24lambda_u2d16.getCurrentFlowTab();
                if (currentFlowTab != null) {
                    str = currentFlowTab;
                }
                if (!$this$switchToNextHotComment_u24lambda_u2d17_u24lambda_u2d16.isLastEventData(str, eventId) || !$this$switchToNextHotComment_u24lambda_u2d17_u24lambda_u2d16.hasFirstEventData()) {
                    UniversalToast.makeText(DIFactory.INSTANCE.getAppContext()).setText(DIFactory.INSTANCE.getAppContext().getResources().getString(R.string.video_flow_hot_no_next_hot_text)).show();
                } else {
                    $this$switchToNextHotComment_u24lambda_u2d17.getScrollToPosition().setValue(0);
                }
            }
        } else {
            $this$switchToNextHotComment_u24lambda_u2d17.getScrollToPosition().setValue(Integer.valueOf($this$switchToNextHotComment_u24lambda_u2d17.getCurItemPosition() + 1));
        }
    }

    private final void updateNewEventFlowState(FlowListCacheModel cacheModel, CommonState state) {
        List<ItemModel> items;
        CommonState commonState = state;
        if (cacheModel == null || (items = cacheModel.getItems()) == null) {
            return;
        }
        FlowState $this$updateNewEventFlowState_u24lambda_u2d20_u24lambda_u2d19 = (FlowState) commonState.select(FlowState.class);
        if ($this$updateNewEventFlowState_u24lambda_u2d20_u24lambda_u2d19 != null) {
            saveFlowListData(commonState);
            $this$updateNewEventFlowState_u24lambda_u2d20_u24lambda_u2d19.getRemoveListData().setValue(new RemoveListData(0, $this$updateNewEventFlowState_u24lambda_u2d20_u24lambda_u2d19.getFlowList().size()));
            $this$updateNewEventFlowState_u24lambda_u2d20_u24lambda_u2d19.setScrolledOnce(false);
            for (ItemModel itemModel : items) {
                if (Intrinsics.areEqual((Object) itemModel.getId(), (Object) cacheModel.getSelectedId())) {
                    $this$updateNewEventFlowState_u24lambda_u2d20_u24lambda_u2d19.setInterceptLoadMore(true);
                    $this$updateNewEventFlowState_u24lambda_u2d20_u24lambda_u2d19.refreshFlowData(0, new FlowModel((PoliciesModel) null, false, 0, 0, 0, false, false, false, CollectionsKt.mutableListOf(itemModel), (String) null, (HmpInfoModel) null, 1790, (DefaultConstructorMarker) null));
                }
            }
            DIFactory.INSTANCE.post(new HotFlowReducer$updateNewEventFlowState$1$1$2(items, $this$updateNewEventFlowState_u24lambda_u2d20_u24lambda_u2d19));
            return;
        }
    }

    private final void mapEventDataToFlowState(HotListItemModel model, CommonState state) {
        IntentData intentData;
        FlowState $this$mapEventDataToFlowState_u24lambda_u2d23_u24lambda_u2d22;
        List items;
        String str;
        HotListItemDataModel data = model.getData();
        if (data != null && (intentData = data.getCmdToIntentData()) != null && ($this$mapEventDataToFlowState_u24lambda_u2d23_u24lambda_u2d22 = (FlowState) state.select(FlowState.class)) != null) {
            saveFlowListData(state);
            $this$mapEventDataToFlowState_u24lambda_u2d23_u24lambda_u2d22.getRemoveListData().setValue(new RemoveListData(0, $this$mapEventDataToFlowState_u24lambda_u2d23_u24lambda_u2d22.getFlowList().size()));
            $this$mapEventDataToFlowState_u24lambda_u2d23_u24lambda_u2d22.setScrolledOnce(false);
            $this$mapEventDataToFlowState_u24lambda_u2d23_u24lambda_u2d22.getFlowModel().setValue(IntentToFlowMapper.INSTANCE.map(intentData));
            FlowModel value = $this$mapEventDataToFlowState_u24lambda_u2d23_u24lambda_u2d22.getFlowModel().getValue();
            if (value != null && (items = value.getItems()) != null && items.size() == 1) {
                Object data2 = items.get(0).getData();
                VideoItemModel videoItemModel = data2 instanceof VideoItemModel ? (VideoItemModel) data2 : null;
                if (videoItemModel != null) {
                    HotListItemDataModel data3 = model.getData();
                    if (data3 == null || (str = data3.getEventId()) == null) {
                        str = "";
                    }
                    videoItemModel.setEventId(str);
                }
                items.get(0).resetShownState();
            }
        }
    }

    private final void saveFlowListData(CommonState state) {
        String eventId;
        FlowState $this$saveFlowListData_u24lambda_u2d27 = (FlowState) state.select(FlowState.class);
        if ($this$saveFlowListData_u24lambda_u2d27 != null) {
            ItemModel<?> curItemModel = $this$saveFlowListData_u24lambda_u2d27.getCurItemModel();
            String str = null;
            Object data = curItemModel != null ? curItemModel.getData() : null;
            VideoItemModel $this$saveFlowListData_u24lambda_u2d27_u24lambda_u2d24 = data instanceof VideoItemModel ? (VideoItemModel) data : null;
            if ($this$saveFlowListData_u24lambda_u2d27_u24lambda_u2d24 == null || !Intrinsics.areEqual((Object) $this$saveFlowListData_u24lambda_u2d27_u24lambda_u2d24.getSerialNum(), (Object) $this$saveFlowListData_u24lambda_u2d27_u24lambda_u2d24.getTotalCount())) {
                int startIndex = $this$saveFlowListData_u24lambda_u2d27.getCurItemPosition() - 2;
                int endIndex = $this$saveFlowListData_u24lambda_u2d27.getCurItemPosition() + 2;
                List list = new ArrayList();
                ItemModel<?> curItemModel2 = $this$saveFlowListData_u24lambda_u2d27.getCurItemModel();
                Object data2 = curItemModel2 != null ? curItemModel2.getData() : null;
                VideoItemModel videoItemModel = data2 instanceof VideoItemModel ? (VideoItemModel) data2 : null;
                if (videoItemModel == null || (eventId = videoItemModel.getEventId()) == null) {
                    eventId = "";
                }
                int index = startIndex;
                if (index <= endIndex) {
                    while (true) {
                        ItemModel itemModel = (ItemModel) CollectionsKt.getOrNull($this$saveFlowListData_u24lambda_u2d27.getFlowList(), index);
                        if (itemModel != null) {
                            Object data3 = itemModel.getData();
                            VideoItemModel videoItemModel2 = data3 instanceof VideoItemModel ? (VideoItemModel) data3 : null;
                            if (Intrinsics.areEqual((Object) videoItemModel2 != null ? videoItemModel2.getEventId() : null, (Object) eventId)) {
                                list.add(itemModel);
                            }
                        }
                        if (index == endIndex) {
                            break;
                        }
                        index++;
                    }
                }
                FlowListCacheModel flowListCacheModel = new FlowListCacheModel((List) null, (String) null, 3, (DefaultConstructorMarker) null);
                FlowListCacheModel $this$saveFlowListData_u24lambda_u2d27_u24lambda_u2d26 = flowListCacheModel;
                $this$saveFlowListData_u24lambda_u2d27_u24lambda_u2d26.setItems(list);
                ItemModel<?> curItemModel3 = $this$saveFlowListData_u24lambda_u2d27.getCurItemModel();
                if (curItemModel3 != null) {
                    str = curItemModel3.getId();
                }
                $this$saveFlowListData_u24lambda_u2d27_u24lambda_u2d26.setSelectedId(str);
                FlowListCacheModel cacheModel = flowListCacheModel;
                CommonListPanelState commonListPanelState = (CommonListPanelState) state.select(CommonListPanelState.class);
                if (commonListPanelState != null) {
                    commonListPanelState.saveFlowList(eventId, cacheModel);
                    return;
                }
                return;
            }
            CommonListPanelState commonListPanelState2 = (CommonListPanelState) state.select(CommonListPanelState.class);
            if (commonListPanelState2 != null) {
                commonListPanelState2.removeFlowListCache($this$saveFlowListData_u24lambda_u2d27_u24lambda_u2d24.getEventId());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void mapIntentToFlowState(com.baidu.searchbox.feed.detail.arch.ext.CoreAction.NewIntent<?> r12, com.baidu.searchbox.feed.detail.arch.ext.CommonState r13) {
        /*
            r11 = this;
            java.lang.Object r0 = r12.getData()
            boolean r1 = r0 instanceof com.baidu.searchbox.video.detail.core.model.IntentData
            r2 = 0
            if (r1 == 0) goto L_0x000c
            com.baidu.searchbox.video.detail.core.model.IntentData r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r0
            goto L_0x000d
        L_0x000c:
            r0 = r2
        L_0x000d:
            if (r0 == 0) goto L_0x0087
            r1 = 0
            r3 = 0
            java.lang.String r3 = ""
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0028 }
            java.lang.String r5 = r0.ext     // Catch:{ JSONException -> 0x0028 }
            r4.<init>(r5)     // Catch:{ JSONException -> 0x0028 }
            java.lang.String r5 = "event_id"
            java.lang.String r4 = r4.optString(r5)     // Catch:{ JSONException -> 0x0028 }
            java.lang.String r5 = "JSONObject(intentData.ext)?.optString(\"event_id\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ JSONException -> 0x0028 }
            r3 = r4
            goto L_0x0029
        L_0x0028:
            r4 = move-exception
        L_0x0029:
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r4 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r4 = r13.select(r4)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r4 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r4
            if (r4 == 0) goto L_0x0087
            r5 = 0
            com.baidu.searchbox.video.feedflow.flow.list.mapper.IntentToFlowMapper r6 = com.baidu.searchbox.video.feedflow.flow.list.mapper.IntentToFlowMapper.INSTANCE
            com.baidu.searchbox.video.feedflow.flow.list.FlowModel r6 = r6.map((com.baidu.searchbox.video.detail.core.model.IntentData) r0)
            java.lang.String r7 = r0.nid
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            r8 = 1
            if (r7 == 0) goto L_0x004f
            java.lang.Boolean r7 = r0.isIgnoreVid()
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x0052
        L_0x004f:
            r4.refreshFlowData(r8, r6)
        L_0x0052:
            androidx.lifecycle.MutableLiveData r7 = r4.getFlowModel()
            java.lang.Object r7 = r7.getValue()
            com.baidu.searchbox.video.feedflow.flow.list.FlowModel r7 = (com.baidu.searchbox.video.feedflow.flow.list.FlowModel) r7
            if (r7 == 0) goto L_0x0084
            java.util.List r7 = r7.getItems()
            if (r7 == 0) goto L_0x0084
            r9 = 0
            int r10 = r7.size()
            if (r10 != r8) goto L_0x0083
            r8 = 0
            java.lang.Object r8 = r7.get(r8)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r8 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r8
            java.lang.Object r8 = r8.getData()
            boolean r10 = r8 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel
            if (r10 == 0) goto L_0x007d
            r2 = r8
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r2 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r2
        L_0x007d:
            if (r2 != 0) goto L_0x0080
            goto L_0x0083
        L_0x0080:
            r2.setEventId(r3)
        L_0x0083:
        L_0x0084:
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.hotflow.flow.list.HotFlowReducer.mapIntentToFlowState(com.baidu.searchbox.feed.detail.arch.ext.CoreAction$NewIntent, com.baidu.searchbox.feed.detail.arch.ext.CommonState):void");
    }

    private final void dealRequestSuccess(CommonState state, int type, HotListModel model) {
        FlowState $this$dealRequestSuccess_u24lambda_u2d33;
        CommonListPanelState commonListPanelState = (CommonListPanelState) state.select(CommonListPanelState.class);
        HotListItemModel hotItemModelByEventId = commonListPanelState != null ? commonListPanelState.getHotItemModelByEventId(model.getEventId()) : null;
        if (hotItemModelByEventId != null) {
            hotItemModelByEventId.setOffline(model.isOffline());
        }
        boolean z = false;
        if (checkResponseListValid(state, type, model)) {
            FlowModel newModel = HotFlowMapper.INSTANCE.map(model);
            FlowState $this$dealRequestSuccess_u24lambda_u2d32 = (FlowState) state.select(FlowState.class);
            if ($this$dealRequestSuccess_u24lambda_u2d32 != null) {
                switch (type) {
                    case -1:
                        $this$dealRequestSuccess_u24lambda_u2d32.setHasPrev(newModel.getHasPrev());
                        $this$dealRequestSuccess_u24lambda_u2d32.setUpCTime(newModel.getUpCTime());
                        $this$dealRequestSuccess_u24lambda_u2d32.setOriginDir("-1");
                        break;
                    case 0:
                        $this$dealRequestSuccess_u24lambda_u2d32.setHasLoadFirstPage(true);
                        $this$dealRequestSuccess_u24lambda_u2d32.setHasPrev(newModel.getHasPrev());
                        $this$dealRequestSuccess_u24lambda_u2d32.setHasMore(newModel.getHasMore());
                        $this$dealRequestSuccess_u24lambda_u2d32.setUpCTime(newModel.getUpCTime());
                        $this$dealRequestSuccess_u24lambda_u2d32.setDownCTime(newModel.getDownCTime());
                        $this$dealRequestSuccess_u24lambda_u2d32.setOriginDir("0");
                        break;
                    case 1:
                        $this$dealRequestSuccess_u24lambda_u2d32.setHasMore(newModel.getHasMore());
                        $this$dealRequestSuccess_u24lambda_u2d32.setDownCTime(newModel.getDownCTime());
                        $this$dealRequestSuccess_u24lambda_u2d32.setOriginDir("1");
                        break;
                }
                $this$dealRequestSuccess_u24lambda_u2d32.getFlowModel().setValue(newModel);
                CoreState $this$dealRequestSuccess_u24lambda_u2d32_u24lambda_u2d31 = (CoreState) state.select(CoreState.class);
                if ($this$dealRequestSuccess_u24lambda_u2d32_u24lambda_u2d31 != null) {
                    $this$dealRequestSuccess_u24lambda_u2d32_u24lambda_u2d31.getNetAction().setValue(new NetAction.Success(newModel, 0, 2, (DefaultConstructorMarker) null));
                    return;
                }
                return;
            }
            return;
        }
        Collection items = model.getItems();
        if (items == null || items.isEmpty()) {
            z = true;
        }
        if (z && ($this$dealRequestSuccess_u24lambda_u2d33 = (FlowState) state.select(FlowState.class)) != null) {
            switch (type) {
                case -1:
                    if (!StringsKt.isBlank(model.getHasPrev())) {
                        $this$dealRequestSuccess_u24lambda_u2d33.setHasPrev(Intrinsics.areEqual((Object) model.getHasPrev(), (Object) "1"));
                        return;
                    }
                    return;
                case 0:
                    if (!StringsKt.isBlank(model.getHasPrev())) {
                        $this$dealRequestSuccess_u24lambda_u2d33.setHasPrev(Intrinsics.areEqual((Object) model.getHasPrev(), (Object) "1"));
                    }
                    if (!StringsKt.isBlank(model.getHasMore())) {
                        $this$dealRequestSuccess_u24lambda_u2d33.setHasMore(Intrinsics.areEqual((Object) model.getHasMore(), (Object) "1"));
                        return;
                    }
                    return;
                case 1:
                    if (!StringsKt.isBlank(model.getHasMore())) {
                        $this$dealRequestSuccess_u24lambda_u2d33.setHasMore(Intrinsics.areEqual((Object) model.getHasMore(), (Object) "1"));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f7, code lost:
        r3 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) kotlin.collections.CollectionsKt.getOrNull((r3 = r3.getFlowList()), 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean checkResponseListValid(com.baidu.searchbox.feed.detail.arch.ext.CommonState r10, int r11, com.baidu.searchbox.flowvideo.hot.repos.HotListModel r12) {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            switch(r11) {
                case -1: goto L_0x00e5;
                case 0: goto L_0x009e;
                case 1: goto L_0x0008;
                default: goto L_0x0006;
            }
        L_0x0006:
            goto L_0x0149
        L_0x0008:
            r3 = 0
            r4 = r10
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r6 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r4 = r4.select(r6)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r4 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r4
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x001d
            java.lang.String r4 = r4.getNextLastEventId()
            if (r4 != 0) goto L_0x001e
        L_0x001d:
            r4 = r5
        L_0x001e:
            r3 = r4
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = kotlin.text.StringsKt.isBlank(r4)
            if (r4 == 0) goto L_0x0064
            r4 = r10
            r6 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r7 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r4 = r4.select(r7)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r4 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r4
            if (r4 == 0) goto L_0x0064
            java.util.List r4 = r4.getFlowList()
            if (r4 == 0) goto L_0x0064
            r6 = 0
            int r7 = r4.size()
            int r7 = r7 - r0
            java.lang.Object r7 = kotlin.collections.CollectionsKt.getOrNull(r4, r7)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r7 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r7
            if (r7 == 0) goto L_0x004d
            java.lang.Object r7 = r7.getData()
            goto L_0x004e
        L_0x004d:
            r7 = r2
        L_0x004e:
            boolean r8 = r7 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel
            if (r8 == 0) goto L_0x0055
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r7 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r7
            goto L_0x0056
        L_0x0055:
            r7 = r2
        L_0x0056:
            if (r7 == 0) goto L_0x0061
            java.lang.String r7 = r7.getEventId()
            if (r7 != 0) goto L_0x005f
            goto L_0x0061
        L_0x005f:
            r5 = r7
            goto L_0x0062
        L_0x0061:
        L_0x0062:
            r3 = r5
        L_0x0064:
            java.util.List r4 = r12.getItems()
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = kotlin.collections.CollectionsKt.getOrNull(r4, r1)
            com.baidu.searchbox.flowvideo.hot.repos.HotItemModel r4 = (com.baidu.searchbox.flowvideo.hot.repos.HotItemModel) r4
            if (r4 == 0) goto L_0x007c
            com.baidu.searchbox.flowvideo.hot.repos.HotItemDataModel r4 = r4.getData()
            if (r4 == 0) goto L_0x007c
            java.lang.String r2 = r4.getEventId()
        L_0x007c:
            r4 = r10
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r6 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r4 = r4.select(r6)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r4 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r4
            if (r4 == 0) goto L_0x008d
            boolean r4 = r4.getHasMore()
            goto L_0x008e
        L_0x008d:
            r4 = r1
        L_0x008e:
            if (r4 == 0) goto L_0x0097
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r2)
            if (r5 != 0) goto L_0x0149
            return r1
        L_0x0097:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r2)
            if (r5 == 0) goto L_0x0149
            return r1
        L_0x009e:
            r3 = r10
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r5 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r3 = r3.select(r5)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r3 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r3
            if (r3 == 0) goto L_0x00b5
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r3 = r3.getCurItemModel()
            if (r3 == 0) goto L_0x00b5
            java.lang.Object r3 = r3.getData()
            goto L_0x00b6
        L_0x00b5:
            r3 = r2
        L_0x00b6:
            boolean r4 = r3 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel
            if (r4 == 0) goto L_0x00bd
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r3 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r3
            goto L_0x00be
        L_0x00bd:
            r3 = r2
        L_0x00be:
            if (r3 == 0) goto L_0x00c5
            java.lang.String r3 = r3.getEventId()
            goto L_0x00c6
        L_0x00c5:
            r3 = r2
        L_0x00c6:
            java.util.List r4 = r12.getItems()
            if (r4 == 0) goto L_0x00de
            java.lang.Object r4 = kotlin.collections.CollectionsKt.getOrNull(r4, r1)
            com.baidu.searchbox.flowvideo.hot.repos.HotItemModel r4 = (com.baidu.searchbox.flowvideo.hot.repos.HotItemModel) r4
            if (r4 == 0) goto L_0x00de
            com.baidu.searchbox.flowvideo.hot.repos.HotItemDataModel r4 = r4.getData()
            if (r4 == 0) goto L_0x00de
            java.lang.String r2 = r4.getEventId()
        L_0x00de:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r2)
            if (r4 != 0) goto L_0x0149
            return r1
        L_0x00e5:
            r3 = r10
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r5 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r3 = r3.select(r5)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r3 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r3
            if (r3 == 0) goto L_0x0104
            java.util.List r3 = r3.getFlowList()
            if (r3 == 0) goto L_0x0104
            java.lang.Object r3 = kotlin.collections.CollectionsKt.getOrNull(r3, r1)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r3 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r3
            if (r3 == 0) goto L_0x0104
            java.lang.Object r3 = r3.getData()
            goto L_0x0105
        L_0x0104:
            r3 = r2
        L_0x0105:
            boolean r4 = r3 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel
            if (r4 == 0) goto L_0x010c
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r3 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r3
            goto L_0x010d
        L_0x010c:
            r3 = r2
        L_0x010d:
            if (r3 == 0) goto L_0x0114
            java.lang.String r3 = r3.getEventId()
            goto L_0x0115
        L_0x0114:
            r3 = r2
        L_0x0115:
            java.util.List r4 = r12.getItems()
            if (r4 == 0) goto L_0x012e
            java.lang.Object r4 = kotlin.collections.CollectionsKt.getOrNull(r4, r1)
            com.baidu.searchbox.flowvideo.hot.repos.HotItemModel r4 = (com.baidu.searchbox.flowvideo.hot.repos.HotItemModel) r4
            if (r4 == 0) goto L_0x012e
            com.baidu.searchbox.flowvideo.hot.repos.HotItemDataModel r4 = r4.getData()
            if (r4 == 0) goto L_0x012e
            java.lang.String r2 = r4.getEventId()
        L_0x012e:
            r4 = r10
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r6 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r4 = r4.select(r6)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r4 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r4
            if (r4 == 0) goto L_0x013f
            boolean r4 = r4.getHasPrev()
            goto L_0x0140
        L_0x013f:
            r4 = r1
        L_0x0140:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r2)
            if (r5 == 0) goto L_0x0148
            if (r4 != 0) goto L_0x0149
        L_0x0148:
            return r1
        L_0x0149:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.hotflow.flow.list.HotFlowReducer.checkResponseListValid(com.baidu.searchbox.feed.detail.arch.ext.CommonState, int, com.baidu.searchbox.flowvideo.hot.repos.HotListModel):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel} */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r0 = r0.getFlowList();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a3 A[Catch:{ Exception -> 0x0111 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void dealPanelBeanSuccess(com.baidu.searchbox.feed.detail.arch.ext.CommonState r13, com.baidu.searchbox.flowvideo.hot.api.CommonListPanelBean r14) {
        /*
            r12 = this;
            r0 = r13
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r2 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r0 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001c
            java.util.List r0 = r0.getFlowList()
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.isEmpty()
            if (r0 != r1) goto L_0x001c
            r0 = r1
            goto L_0x001d
        L_0x001c:
            r0 = r2
        L_0x001d:
            if (r0 == 0) goto L_0x0120
            java.util.List r0 = r14.getItems()
            if (r0 == 0) goto L_0x0120
            java.lang.Object r0 = r0.get(r2)
            com.baidu.searchbox.flowvideo.hot.api.HotListItemBean r0 = (com.baidu.searchbox.flowvideo.hot.api.HotListItemBean) r0
            if (r0 == 0) goto L_0x0120
            com.baidu.searchbox.flowvideo.hot.api.HotListItemDataBean r0 = r0.getData()
            if (r0 == 0) goto L_0x0120
            java.lang.String r0 = r0.getCmd()
            if (r0 == 0) goto L_0x0120
            r3 = 0
            com.baidu.searchbox.video.detail.export.IVideoUnitedSchemeUtility r4 = com.baidu.searchbox.video.detail.export.IVideoUnitedSchemeUtility.Impl.get()
            boolean r4 = r4.isUnitedScheme((java.lang.String) r0)
            if (r4 == 0) goto L_0x011f
            com.baidu.searchbox.video.detail.export.IVideoUnitedSchemeUtility r4 = com.baidu.searchbox.video.detail.export.IVideoUnitedSchemeUtility.Impl.get()
            java.util.HashMap r4 = r4.getParams(r0)
            java.lang.String r5 = "params"
            java.lang.Object r5 = r4.get(r5)     // Catch:{ Exception -> 0x0111 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0111 }
            com.baidu.searchbox.video.detail.core.model.IntentData r5 = com.baidu.searchbox.video.detail.core.model.IntentData.create(r5, r2)     // Catch:{ Exception -> 0x0111 }
            if (r5 == 0) goto L_0x0110
            r6 = 0
            r7 = r13
            r8 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r9 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r9 = r7.select(r9)     // Catch:{ Exception -> 0x0111 }
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r9 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r9     // Catch:{ Exception -> 0x0111 }
            r7 = 0
            if (r9 == 0) goto L_0x006f
            androidx.lifecycle.MutableLiveData r8 = r9.getFlowModel()     // Catch:{ Exception -> 0x0111 }
            goto L_0x0070
        L_0x006f:
            r8 = r7
        L_0x0070:
            if (r8 != 0) goto L_0x0073
        L_0x0072:
            goto L_0x0083
        L_0x0073:
            com.baidu.searchbox.video.feedflow.flow.list.mapper.IntentToFlowMapper r9 = com.baidu.searchbox.video.feedflow.flow.list.mapper.IntentToFlowMapper.INSTANCE     // Catch:{ Exception -> 0x0111 }
            java.lang.String r10 = "newIntentData"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r10)     // Catch:{ Exception -> 0x0111 }
            com.baidu.searchbox.video.feedflow.flow.list.FlowModel r9 = r9.map((com.baidu.searchbox.video.detail.core.model.IntentData) r5)     // Catch:{ Exception -> 0x0111 }
            r8.setValue(r9)     // Catch:{ Exception -> 0x0111 }
            goto L_0x0072
        L_0x0083:
            r8 = r13
            r9 = 0
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r10 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r10 = r8.select(r10)     // Catch:{ Exception -> 0x0111 }
            com.baidu.searchbox.video.detail.core.model.IntentData r10 = (com.baidu.searchbox.video.detail.core.model.IntentData) r10     // Catch:{ Exception -> 0x0111 }
            if (r10 == 0) goto L_0x00b3
            r8 = r10
            r9 = 0
            java.lang.String r10 = r8.nid     // Catch:{ Exception -> 0x0111 }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x0111 }
            if (r10 == 0) goto L_0x00a0
            boolean r10 = kotlin.text.StringsKt.isBlank(r10)     // Catch:{ Exception -> 0x0111 }
            if (r10 == 0) goto L_0x009e
            goto L_0x00a0
        L_0x009e:
            r10 = r2
            goto L_0x00a1
        L_0x00a0:
            r10 = r1
        L_0x00a1:
            if (r10 == 0) goto L_0x00b2
            java.lang.String r10 = r5.vid     // Catch:{ Exception -> 0x0111 }
            r8.vid = r10     // Catch:{ Exception -> 0x0111 }
            java.lang.String r10 = r5.nid     // Catch:{ Exception -> 0x0111 }
            r8.nid = r10     // Catch:{ Exception -> 0x0111 }
            java.lang.String r10 = r5.getVideoInfo()     // Catch:{ Exception -> 0x0111 }
            r8.generateVideoInfoModel(r10)     // Catch:{ Exception -> 0x0111 }
        L_0x00b2:
        L_0x00b3:
            r8 = r13
            r9 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r10 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r10 = r8.select(r10)     // Catch:{ Exception -> 0x0111 }
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r10 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r10     // Catch:{ Exception -> 0x0111 }
            if (r10 == 0) goto L_0x010f
            androidx.lifecycle.MutableLiveData r8 = r10.getFlowModel()     // Catch:{ Exception -> 0x0111 }
            if (r8 == 0) goto L_0x010f
            java.lang.Object r8 = r8.getValue()     // Catch:{ Exception -> 0x0111 }
            com.baidu.searchbox.video.feedflow.flow.list.FlowModel r8 = (com.baidu.searchbox.video.feedflow.flow.list.FlowModel) r8     // Catch:{ Exception -> 0x0111 }
            if (r8 == 0) goto L_0x010f
            java.util.List r8 = r8.getItems()     // Catch:{ Exception -> 0x0111 }
            if (r8 == 0) goto L_0x010f
            r9 = 0
            int r10 = r8.size()     // Catch:{ Exception -> 0x0111 }
            if (r10 != r1) goto L_0x010e
            java.util.List r1 = r14.getItems()     // Catch:{ Exception -> 0x0111 }
            if (r1 == 0) goto L_0x010e
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x0111 }
            com.baidu.searchbox.flowvideo.hot.api.HotListItemBean r1 = (com.baidu.searchbox.flowvideo.hot.api.HotListItemBean) r1     // Catch:{ Exception -> 0x0111 }
            if (r1 == 0) goto L_0x010e
            com.baidu.searchbox.flowvideo.hot.api.HotListItemDataBean r1 = r1.getData()     // Catch:{ Exception -> 0x0111 }
            if (r1 == 0) goto L_0x010e
            java.lang.String r1 = r1.getEventId()     // Catch:{ Exception -> 0x0111 }
            if (r1 == 0) goto L_0x010e
            r10 = 0
            java.lang.Object r2 = r8.get(r2)     // Catch:{ Exception -> 0x0111 }
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r2 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r2     // Catch:{ Exception -> 0x0111 }
            java.lang.Object r2 = r2.getData()     // Catch:{ Exception -> 0x0111 }
            boolean r11 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel     // Catch:{ Exception -> 0x0111 }
            if (r11 == 0) goto L_0x0107
            r7 = r2
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r7 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r7     // Catch:{ Exception -> 0x0111 }
        L_0x0107:
            if (r7 != 0) goto L_0x010a
            goto L_0x010d
        L_0x010a:
            r7.setEventId(r1)     // Catch:{ Exception -> 0x0111 }
        L_0x010d:
        L_0x010e:
        L_0x010f:
        L_0x0110:
            goto L_0x011f
        L_0x0111:
            r1 = move-exception
            com.baidu.searchbox.video.detail.export.IVideoAppConfig r2 = com.baidu.searchbox.video.detail.export.IVideoAppConfig.Impl.get()
            boolean r2 = r2.isDebug()
            if (r2 == 0) goto L_0x011f
            r1.printStackTrace()
        L_0x011f:
        L_0x0120:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.hotflow.flow.list.HotFlowReducer.dealPanelBeanSuccess(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.flowvideo.hot.api.CommonListPanelBean):void");
    }
}
