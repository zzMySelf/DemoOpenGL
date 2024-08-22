package com.baidu.searchbox.video.feedflow.flow.comonlistpanel;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/comonlistpanel/CommonListPanelMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonListPanelMiddleware.kt */
public final class CommonListPanelMiddleware implements Middleware<CommonState> {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.baidu.searchbox.video.detail.core.model.IntentData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: com.baidu.searchbox.video.detail.core.model.IntentData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: com.baidu.searchbox.video.detail.core.model.IntentData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: com.baidu.searchbox.video.detail.core.model.IntentData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: com.baidu.searchbox.video.detail.core.model.IntentData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: com.baidu.searchbox.video.detail.core.model.IntentData} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.frame.Action apply(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r20, com.baidu.searchbox.feed.detail.frame.Action r21, com.baidu.searchbox.feed.detail.frame.Next<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r22) {
        /*
            r19 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            java.lang.String r3 = "store"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "next"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            boolean r3 = r1 instanceof com.baidu.searchbox.feed.detail.arch.ext.CoreAction.NewIntent
            r4 = 0
            if (r3 == 0) goto L_0x004b
            r3 = r1
            com.baidu.searchbox.feed.detail.arch.ext.CoreAction$NewIntent r3 = (com.baidu.searchbox.feed.detail.arch.ext.CoreAction.NewIntent) r3
            java.lang.Object r3 = r3.getData()
            boolean r5 = r3 instanceof com.baidu.searchbox.video.detail.core.model.IntentData
            if (r5 == 0) goto L_0x002a
            r4 = r3
            com.baidu.searchbox.video.detail.core.model.IntentData r4 = (com.baidu.searchbox.video.detail.core.model.IntentData) r4
        L_0x002a:
            if (r4 == 0) goto L_0x0032
            java.lang.String r3 = r4.getTabLayout()
            if (r3 != 0) goto L_0x0034
        L_0x0032:
            java.lang.String r3 = "hotrank"
        L_0x0034:
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = kotlin.text.StringsKt.isBlank(r4)
            if (r4 == 0) goto L_0x003f
            java.lang.String r3 = "hotrank"
        L_0x003f:
            com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowType r4 = new com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowType
            r4.<init>(r3)
            com.baidu.searchbox.feed.detail.frame.Action r4 = (com.baidu.searchbox.feed.detail.frame.Action) r4
            r0.dispatch(r4)
            goto L_0x0113
        L_0x004b:
            boolean r3 = r1 instanceof com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelModelSetSuccess
            java.lang.String r5 = ""
            if (r3 == 0) goto L_0x0089
            r3 = r20
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r3.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x005f
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x0060
        L_0x005f:
            r7 = r4
        L_0x0060:
            if (r7 == 0) goto L_0x0068
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState> r4 = com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState.class
            java.lang.Object r4 = r7.select(r4)
        L_0x0068:
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState r4 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState) r4
            if (r4 == 0) goto L_0x0113
            r3 = r4
            r4 = 0
            com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowType r6 = new com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowType
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotTopicListTabModel r7 = r3.getCurHotTopicListTabModel()
            if (r7 == 0) goto L_0x007e
            java.lang.String r7 = r7.getLayout()
            if (r7 != 0) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            r5 = r7
        L_0x007e:
            r6.<init>(r5)
            com.baidu.searchbox.feed.detail.frame.Action r6 = (com.baidu.searchbox.feed.detail.frame.Action) r6
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r0, r6)
            goto L_0x0113
        L_0x0089:
            boolean r3 = r1 instanceof com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction
            if (r3 == 0) goto L_0x0113
            r3 = r1
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction r3 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction) r3
            java.lang.Integer r3 = r3.getClickId()
            int r4 = com.baidu.searchbox.video.feedflow.component.R.id.hot_challenge_button_container
            if (r3 != 0) goto L_0x0099
            goto L_0x00e9
        L_0x0099:
            int r3 = r3.intValue()
            if (r3 != r4) goto L_0x00e9
            r3 = r1
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction r3 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction) r3
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemModel r3 = r3.getItemModel()
            if (r3 == 0) goto L_0x00e9
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemDataModel r3 = r3.getData()
            if (r3 == 0) goto L_0x00e9
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.PanelButtonModel r3 = r3.getButton()
            if (r3 == 0) goto L_0x00e9
            r4 = 0
            com.baidu.searchbox.flowvideo.detail.repos.ChallengePublishModel r18 = new com.baidu.searchbox.flowvideo.detail.repos.ChallengePublishModel
            java.lang.String r7 = r3.getScheme()
            java.lang.String r8 = r3.getPublishToast()
            java.lang.String r9 = r3.getPublishToastLink()
            java.lang.String r10 = r3.getSourceFrom()
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 496(0x1f0, float:6.95E-43)
            r17 = 0
            r6 = r18
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            com.baidu.searchbox.video.feedflow.detail.challenge.PublishChallenge r7 = new com.baidu.searchbox.video.feedflow.detail.challenge.PublishChallenge
            kotlin.Pair r8 = new kotlin.Pair
            java.lang.String r9 = r3.getChallangeId()
            r8.<init>(r9, r6)
            r7.<init>(r8)
            com.baidu.searchbox.feed.detail.frame.Action r7 = (com.baidu.searchbox.feed.detail.frame.Action) r7
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r0, r7)
        L_0x00e9:
            r3 = r1
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction r3 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction) r3
            java.lang.Integer r3 = r3.getClickId()
            if (r3 != 0) goto L_0x0113
            com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowType r3 = new com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowType
            r4 = r1
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction r4 = (com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListItemClickAction) r4
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemModel r4 = r4.getItemModel()
            if (r4 == 0) goto L_0x010b
            com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemDataModel r4 = r4.getData()
            if (r4 == 0) goto L_0x010b
            java.lang.String r4 = r4.getLayoutType()
            if (r4 != 0) goto L_0x010a
            goto L_0x010b
        L_0x010a:
            r5 = r4
        L_0x010b:
            r3.<init>(r5)
            com.baidu.searchbox.feed.detail.frame.Action r3 = (com.baidu.searchbox.feed.detail.frame.Action) r3
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r0, r3)
        L_0x0113:
            com.baidu.searchbox.feed.detail.frame.Action r3 = r2.next(r0, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelMiddleware.apply(com.baidu.searchbox.feed.detail.frame.Store, com.baidu.searchbox.feed.detail.frame.Action, com.baidu.searchbox.feed.detail.frame.Next):com.baidu.searchbox.feed.detail.frame.Action");
    }
}
