package com.baidu.searchbox.video.feedflow.detail.player;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"ACTION_PUSH_FIRST_JUMP_SHOW_V_SUBSCRIBE_DIALOG", "", "VIDEO_PLAY_ACTION_TYPE_VIDEO_FINISHED", "VIDEO_PLAY_ACTION_TYPE_VIDEO_PAUSED", "VIDEO_PLAY_ACTION_TYPE_VIDEO_PLAY_FAILED", "VIDEO_PLAY_ACTION_TYPE_VIDEO_REPLAY", "VIDEO_PLAY_ACTION_TYPE_VIDEO_RESUME", "VIDEO_PLAY_ACTION_TYPE_VIDEO_START", "sendPlayerStatus", "", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "type", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerMiddleware.kt */
public final class PlayerMiddlewareKt {
    private static final String ACTION_PUSH_FIRST_JUMP_SHOW_V_SUBSCRIBE_DIALOG = "com.baidu.channel.push.show_v_subscribe_dialog";
    private static final String VIDEO_PLAY_ACTION_TYPE_VIDEO_FINISHED = "videoFinished";
    private static final String VIDEO_PLAY_ACTION_TYPE_VIDEO_PAUSED = "videoPaused";
    private static final String VIDEO_PLAY_ACTION_TYPE_VIDEO_PLAY_FAILED = "videoPlayFailed";
    private static final String VIDEO_PLAY_ACTION_TYPE_VIDEO_REPLAY = "videoReplay";
    private static final String VIDEO_PLAY_ACTION_TYPE_VIDEO_RESUME = "videoResume";
    private static final String VIDEO_PLAY_ACTION_TYPE_VIDEO_START = "videoStart";

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r6.isNeedToSendPlayerMessage == true) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void sendPlayerStatus(com.baidu.searchbox.feed.detail.frame.Store<?> r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            boolean r1 = com.baidu.searchbox.video.feedflow.detail.player.PlayerDataChannelSwitchKt.getPlayerDataChannelAsyncMessageEnable()
            if (r1 == 0) goto L_0x0152
            r1 = 1
            r2 = 0
            r3 = 0
            if (r8 == 0) goto L_0x0032
            r4 = r8
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r4.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x001e
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x001f
        L_0x001e:
            r6 = r3
        L_0x001f:
            if (r6 == 0) goto L_0x0028
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r7 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x0029
        L_0x0028:
            r6 = r3
        L_0x0029:
            com.baidu.searchbox.video.detail.core.model.IntentData r6 = (com.baidu.searchbox.video.detail.core.model.IntentData) r6
            if (r6 == 0) goto L_0x0032
            boolean r4 = r6.isNeedToSendPlayerMessage
            if (r4 != r1) goto L_0x0032
            goto L_0x0033
        L_0x0032:
            r1 = r2
        L_0x0033:
            if (r1 == 0) goto L_0x0152
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            r2 = r1
            r4 = 0
            r2.put(r0, r9)
            r0 = r8
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r0.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x004c
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x004d
        L_0x004c:
            r6 = r3
        L_0x004d:
            if (r6 == 0) goto L_0x0056
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r7 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x0057
        L_0x0056:
            r6 = r3
        L_0x0057:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r6 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r6
            if (r6 == 0) goto L_0x0060
            java.lang.String r0 = r6.getNid()
            goto L_0x0061
        L_0x0060:
            r0 = r3
        L_0x0061:
            java.lang.String r5 = "nid"
            r2.put(r5, r0)
            r0 = r8
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r0.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x0074
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x0075
        L_0x0074:
            r6 = r3
        L_0x0075:
            if (r6 == 0) goto L_0x007e
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r7 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x007f
        L_0x007e:
            r6 = r3
        L_0x007f:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r6 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r6
            if (r6 == 0) goto L_0x0088
            java.lang.Object r0 = r6.getData()
            goto L_0x0089
        L_0x0088:
            r0 = r3
        L_0x0089:
            boolean r5 = r0 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel
            if (r5 == 0) goto L_0x0090
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r0 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r0
            goto L_0x0091
        L_0x0090:
            r0 = r3
        L_0x0091:
            if (r0 == 0) goto L_0x00a2
            com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries r0 = r0.getVideoSeries()
            if (r0 == 0) goto L_0x00a2
            int r0 = r0.getDuration()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x00a3
        L_0x00a2:
            r0 = r3
        L_0x00a3:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r5 = "duration"
            r2.put(r5, r0)
            r0 = r8
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r0.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x00b9
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x00ba
        L_0x00b9:
            r6 = r3
        L_0x00ba:
            if (r6 == 0) goto L_0x00c3
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r7 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x00c4
        L_0x00c3:
            r6 = r3
        L_0x00c4:
            com.baidu.searchbox.video.detail.core.model.IntentData r6 = (com.baidu.searchbox.video.detail.core.model.IntentData) r6
            if (r6 == 0) goto L_0x00cb
            java.lang.String r0 = r6.page
            goto L_0x00cc
        L_0x00cb:
            r0 = r3
        L_0x00cc:
            java.lang.String r5 = "page"
            r2.put(r5, r0)
            r0 = r8
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r0.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x00df
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x00e0
        L_0x00df:
            r6 = r3
        L_0x00e0:
            if (r6 == 0) goto L_0x00e9
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r7 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x00ea
        L_0x00e9:
            r6 = r3
        L_0x00ea:
            com.baidu.searchbox.video.detail.core.model.IntentData r6 = (com.baidu.searchbox.video.detail.core.model.IntentData) r6
            if (r6 == 0) goto L_0x00f1
            java.lang.String r0 = r6.pd
            goto L_0x00f2
        L_0x00f1:
            r0 = r3
        L_0x00f2:
            java.lang.String r5 = "pd"
            r2.put(r5, r0)
            com.baidu.searchbox.feed.detail.frame.State r0 = r8.getState()
            boolean r5 = r0 instanceof com.baidu.searchbox.feed.detail.frame.AbsState
            if (r5 == 0) goto L_0x0103
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            goto L_0x0104
        L_0x0103:
            r0 = r3
        L_0x0104:
            boolean r0 = com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt.isPageSourceFromChannelFlow((com.baidu.searchbox.feed.detail.frame.AbsState) r0)
            java.lang.String r5 = "isDibar"
            r2.put(r5, r0)
            r0 = r8
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r0.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x011b
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x011c
        L_0x011b:
            r6 = r3
        L_0x011c:
            if (r6 == 0) goto L_0x0125
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.FlowTabState> r7 = com.baidu.searchbox.video.feedflow.tab.FlowTabState.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x0126
        L_0x0125:
            r6 = r3
        L_0x0126:
            com.baidu.searchbox.video.feedflow.tab.FlowTabState r6 = (com.baidu.searchbox.video.feedflow.tab.FlowTabState) r6
            if (r6 == 0) goto L_0x0134
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r0 = r6.getTabInfo()
            if (r0 == 0) goto L_0x0134
            java.lang.String r3 = r0.getId()
        L_0x0134:
            java.lang.String r0 = "tabId"
            r2.put(r0, r3)
            r0 = r1
            com.baidu.searchbox.video.component.datachannel.DataChannelAction$SendAction r1 = new com.baidu.searchbox.video.component.datachannel.DataChannelAction$SendAction
            java.lang.String r2 = r0.toString()
            java.lang.String r3 = "sendData.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.String r3 = "com.baidu.channel.flowvideoevents"
            r1.<init>(r3, r2)
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r8, r1)
        L_0x0152:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.player.PlayerMiddlewareKt.sendPlayerStatus(com.baidu.searchbox.feed.detail.frame.Store, java.lang.String):void");
    }
}
