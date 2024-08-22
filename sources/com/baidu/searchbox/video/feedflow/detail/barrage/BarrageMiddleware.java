package com.baidu.searchbox.video.feedflow.detail.barrage;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailCommentModel;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.video.component.datachannel.DataChannelAction;
import com.baidu.searchbox.video.component.datachannel.DataChannelConstant;
import com.baidu.searchbox.video.component.datachannel.barrage.BarrageDataChannelModel;
import com.baidu.searchbox.video.component.datachannel.barrage.BarrageDataChannelModelKt;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.more.HotCommentBtnClickAction;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016J\u001e\u0010\u000e\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\u0002J\u001e\u0010\u0011\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0016\u0010\u0014\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0002J\u0016\u0010\u0015\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0002J%\u0010\u0016\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/barrage/BarrageMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "nid", "", "pageId", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "handleBarrageVisible", "", "Lcom/baidu/searchbox/video/component/datachannel/DataChannelAction$SyncOuterAction;", "handleDanmuSwitch", "model", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailModel;", "onBarrageClose", "onBarrageOpen", "sendBarrageAction", "open", "", "(Lcom/baidu/searchbox/feed/detail/frame/Store;Ljava/lang/Boolean;)V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BarrageMiddleware.kt */
public final class BarrageMiddleware implements Middleware<CommonState> {
    private String nid = "";
    private String pageId = "";

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.video.feedflow.detail.FlowDetailState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.baidu.searchbox.video.feedflow.detail.FlowDetailState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.frame.Action apply(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r6, com.baidu.searchbox.feed.detail.frame.Action r7, com.baidu.searchbox.feed.detail.frame.Next<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r8) {
        /*
            r5 = this;
            java.lang.String r0 = "store"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "next"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            boolean r0 = r7 instanceof com.baidu.searchbox.video.component.datachannel.DataChannelAction.SyncOuterAction
            if (r0 == 0) goto L_0x001e
            r0 = r7
            com.baidu.searchbox.video.component.datachannel.DataChannelAction$SyncOuterAction r0 = (com.baidu.searchbox.video.component.datachannel.DataChannelAction.SyncOuterAction) r0
            r5.handleBarrageVisible(r6, r0)
            goto L_0x00b1
        L_0x001e:
            boolean r0 = r7 instanceof com.baidu.searchbox.video.feedflow.detail.player.PlayerBarrageButtonClick
            if (r0 == 0) goto L_0x0038
            boolean r0 = com.baidu.searchbox.video.feedflow.common.CommonStateExtKt.isActive(r6)
            if (r0 == 0) goto L_0x00b1
            r0 = r7
            com.baidu.searchbox.video.feedflow.detail.player.PlayerBarrageButtonClick r0 = (com.baidu.searchbox.video.feedflow.detail.player.PlayerBarrageButtonClick) r0
            boolean r0 = r0.getOpen()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r5.sendBarrageAction(r6, r0)
            goto L_0x00b1
        L_0x0038:
            boolean r0 = r7 instanceof com.baidu.searchbox.video.feedflow.detail.more.HotCommentBtnClickAction
            if (r0 == 0) goto L_0x0051
            boolean r0 = com.baidu.searchbox.video.feedflow.common.CommonStateExtKt.isActive(r6)
            if (r0 == 0) goto L_0x00b1
            r0 = r7
            com.baidu.searchbox.video.feedflow.detail.more.HotCommentBtnClickAction r0 = (com.baidu.searchbox.video.feedflow.detail.more.HotCommentBtnClickAction) r0
            boolean r0 = r0.getOpen()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r5.sendBarrageAction(r6, r0)
            goto L_0x00b1
        L_0x0051:
            boolean r0 = r7 instanceof com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarBarrageIconClickedAction
            if (r0 == 0) goto L_0x0066
            boolean r0 = com.baidu.searchbox.video.feedflow.common.CommonStateExtKt.isActive(r6)
            if (r0 == 0) goto L_0x00b1
            r0 = r7
            com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarBarrageIconClickedAction r0 = (com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarBarrageIconClickedAction) r0
            java.lang.Boolean r0 = r0.getOpen()
            r5.sendBarrageAction(r6, r0)
            goto L_0x00b1
        L_0x0066:
            boolean r0 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnPageSelected
            r1 = 0
            if (r0 == 0) goto L_0x0091
            r0 = r6
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0078
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0079
        L_0x0078:
            r3 = r1
        L_0x0079:
            if (r3 == 0) goto L_0x0081
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.FlowDetailState> r1 = com.baidu.searchbox.video.feedflow.detail.FlowDetailState.class
            java.lang.Object r1 = r3.select(r1)
        L_0x0081:
            com.baidu.searchbox.video.feedflow.detail.FlowDetailState r1 = (com.baidu.searchbox.video.feedflow.detail.FlowDetailState) r1
            if (r1 == 0) goto L_0x0090
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r0 = r1.getData()
            if (r0 == 0) goto L_0x0090
            r1 = 0
            r5.handleDanmuSwitch(r6, r0)
        L_0x0090:
            goto L_0x00b1
        L_0x0091:
            boolean r0 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success
            if (r0 == 0) goto L_0x00b1
            boolean r0 = com.baidu.searchbox.video.feedflow.common.CommonStateExtKt.isActive(r6)
            if (r0 == 0) goto L_0x00b1
            r0 = r7
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Success r0 = (com.baidu.searchbox.feed.detail.arch.ext.NetAction.Success) r0
            java.lang.Object r0 = r0.getData()
            boolean r2 = r0 instanceof com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel
            if (r2 == 0) goto L_0x00a9
            r1 = r0
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r1 = (com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel) r1
        L_0x00a9:
            if (r1 == 0) goto L_0x00b1
            r0 = r1
            r1 = 0
            r5.handleDanmuSwitch(r6, r0)
        L_0x00b1:
            com.baidu.searchbox.feed.detail.frame.Action r0 = r8.next(r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.barrage.BarrageMiddleware.apply(com.baidu.searchbox.feed.detail.frame.Store, com.baidu.searchbox.feed.detail.frame.Action, com.baidu.searchbox.feed.detail.frame.Next):com.baidu.searchbox.feed.detail.frame.Action");
    }

    private final void handleBarrageVisible(Store<CommonState> store, DataChannelAction.SyncOuterAction action) {
        if (Intrinsics.areEqual((Object) action.getType(), (Object) DataChannelConstant.DATA_CHANNEL_SYNC_OUTER_TYPE_BARRAGE)) {
            Object data = action.getData();
            String str = null;
            BarrageDataChannelModel model = data instanceof BarrageDataChannelModel ? (BarrageDataChannelModel) data : null;
            String nid2 = model != null ? model.getNid() : null;
            String str2 = "";
            if (nid2 == null) {
                nid2 = str2;
            }
            this.nid = nid2;
            String pageId2 = model != null ? model.getPageId() : null;
            if (pageId2 != null) {
                str2 = pageId2;
            }
            this.pageId = str2;
            if (model != null) {
                str = model.getType();
            }
            if (Intrinsics.areEqual((Object) str, (Object) BarrageDataChannelModelKt.CHATROOM_ACTION_TYPE_OPEN_BARRAGE)) {
                onBarrageOpen(store);
            } else if (Intrinsics.areEqual((Object) str, (Object) BarrageDataChannelModelKt.CHATROOM_ACTION_TYPE_CLOSE_BARRAGE)) {
                onBarrageClose(store);
            }
        }
    }

    private final void onBarrageOpen(Store<CommonState> store) {
        StoreExtKt.post(store, new BarrageOpenAction(false, 1, (DefaultConstructorMarker) null));
    }

    private final void onBarrageClose(Store<CommonState> store) {
        StoreExtKt.post(store, new BarrageOpenAction(false));
    }

    private final void sendBarrageAction(Store<CommonState> store, Boolean open) {
        JSONObject sendData = new JSONObject();
        JSONObject $this$sendBarrageAction_u24lambda_u2d2 = sendData;
        $this$sendBarrageAction_u24lambda_u2d2.put("type", Intrinsics.areEqual((Object) open, (Object) true) ? BarrageDataChannelModelKt.CHATROOM_ACTION_TYPE_OPEN_BARRAGE : BarrageDataChannelModelKt.CHATROOM_ACTION_TYPE_CLOSE_BARRAGE);
        $this$sendBarrageAction_u24lambda_u2d2.put("nid", this.nid);
        $this$sendBarrageAction_u24lambda_u2d2.put("pageId", this.pageId);
        String jSONObject = sendData.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "sendData.toString()");
        StoreExtKt.post(store, new DataChannelAction.SendAction("com.baidu.channel.barrage", jSONObject));
    }

    private final void handleDanmuSwitch(Store<CommonState> store, FlowDetailModel model) {
        String conf;
        FlowDetailCommentModel comment = model.getComment();
        if (comment != null && (conf = comment.getCommentConf()) != null) {
            JSONObject obj = new JSONObject(conf).optJSONObject("danmu_switch");
            int version = -1;
            if (obj != null) {
                version = obj.optInt("version", -1);
            }
            if (version >= 0 && version > DIFactory.INSTANCE.getConfig().getCommentIconSwitchVersion()) {
                boolean isOpen = true;
                if (obj == null || obj.optInt("switch", 0) != 1) {
                    isOpen = false;
                }
                DIFactory.INSTANCE.getConfig().saveCommentIconSwitchVersion(version);
                DIFactory.INSTANCE.getConfig().saveHotCommentIconSwitch(isOpen);
                StoreExtKt.post(store, new HotCommentBtnClickAction(isOpen, false));
            }
        }
    }
}
