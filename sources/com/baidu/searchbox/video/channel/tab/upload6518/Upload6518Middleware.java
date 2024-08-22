package com.baidu.searchbox.video.channel.tab.upload6518;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.channel.flow.utils.VideoChannelUtils;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.playmode.PlayMode;
import com.baidu.searchbox.video.feedflow.flow.playmode.PlayModePluginKt;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import com.baidu.voicesearch.component.vglog.VgLogConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J.\u0010\u000f\u001a\u00020\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014H\u0002¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/video/channel/tab/upload6518/Upload6518Middleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "getPlayMode", "Lorg/json/JSONObject;", "getSpecificExt", "getUserStatusExt", "upload6518", "", "triggerType", "Lcom/baidu/searchbox/video/channel/tab/upload6518/TriggerType;", "itemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Upload6518Middleware.kt */
public final class Upload6518Middleware implements Middleware<CommonState> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Upload6518Middleware.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayMode.values().length];
            iArr[PlayMode.LOOP_PLAY.ordinal()] = 1;
            iArr[PlayMode.CONTINUE_PLAY.ordinal()] = 2;
            iArr[PlayMode.AI_PLAY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof Report6518) {
            upload6518$default(this, store, ((Report6518) action).getTriggerType(), (ItemModel) null, 4, (Object) null);
        }
        return next.next(store, action);
    }

    static /* synthetic */ void upload6518$default(Upload6518Middleware upload6518Middleware, Store store, TriggerType triggerType, ItemModel itemModel, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            itemModel = null;
        }
        upload6518Middleware.upload6518(store, triggerType, itemModel);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void upload6518(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r17, com.baidu.searchbox.video.channel.tab.upload6518.TriggerType r18, com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?> r19) {
        /*
            r16 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r13 = r0
            r0 = 0
            if (r19 != 0) goto L_0x0025
            r1 = r17
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r1.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0017
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0018
        L_0x0017:
            r3 = r0
        L_0x0018:
            if (r3 == 0) goto L_0x0021
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r4 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x0022
        L_0x0021:
            r3 = r0
        L_0x0022:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r3 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r3
            goto L_0x0027
        L_0x0025:
            r3 = r19
        L_0x0027:
            r14 = r3
            r1 = r17
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r1.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0036
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0037
        L_0x0036:
            r3 = r0
        L_0x0037:
            if (r3 == 0) goto L_0x0040
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r4 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x0041
        L_0x0040:
            r3 = r0
        L_0x0041:
            r15 = r3
            com.baidu.searchbox.video.detail.core.model.IntentData r15 = (com.baidu.searchbox.video.detail.core.model.IntentData) r15
            com.baidu.searchbox.feed.util.FeedSessionManager r1 = com.baidu.searchbox.feed.util.FeedSessionManager.getInstance()
            java.lang.String r1 = r1.getClickId()
            java.lang.String r2 = "click_id"
            r13.put(r2, r1)
            if (r14 == 0) goto L_0x0058
            java.lang.String r1 = r14.getNid()
            goto L_0x0059
        L_0x0058:
            r1 = r0
        L_0x0059:
            java.lang.String r2 = "id"
            r13.put(r2, r1)
            if (r14 == 0) goto L_0x006f
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r1 = r14.getRunTimeStatus()
            if (r1 == 0) goto L_0x006f
            int r1 = r1.getPosition()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0070
        L_0x006f:
            r1 = r0
        L_0x0070:
            java.lang.String r2 = "pos"
            r13.put(r2, r1)
            com.baidu.searchbox.feed.util.FeedSessionManager r1 = com.baidu.searchbox.feed.util.FeedSessionManager.getInstance()
            java.lang.String r1 = r1.getSessionId()
            java.lang.String r2 = "session_id"
            r13.put(r2, r1)
            java.lang.String r1 = r18.getLabel()
            java.lang.String r2 = "trigger_aciton"
            r13.put(r2, r1)
            if (r14 == 0) goto L_0x0174
            com.baidu.searchbox.video.feedflow.flow.list.CommonItemData r1 = r14.getCommonItemData()
            if (r1 == 0) goto L_0x0174
            org.json.JSONObject r1 = r1.getExtLogJo()
            if (r1 == 0) goto L_0x0174
            r3 = r1
            r4 = 0
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r5 = r14.getRunTimeStatus()
            int r5 = r5.getAutoPlayFlagState()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r6 = "autoPlay"
            r3.putOpt(r6, r5)
            if (r19 == 0) goto L_0x00b6
            java.lang.Object r5 = r19.getData()
            goto L_0x00b7
        L_0x00b6:
            r5 = r0
        L_0x00b7:
            boolean r6 = r5 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel
            if (r6 == 0) goto L_0x00be
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r5
            goto L_0x00bf
        L_0x00be:
            r5 = r0
        L_0x00bf:
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x00cb
            int r5 = r5.getFlowVideoGrType()
            if (r5 != r6) goto L_0x00cb
            r5 = r6
            goto L_0x00cc
        L_0x00cb:
            r5 = r7
        L_0x00cc:
            java.lang.String r8 = "1"
            if (r5 == 0) goto L_0x00d5
            java.lang.String r5 = "followrid"
            r3.put(r5, r8)
        L_0x00d5:
            java.lang.String r5 = r18.getLabel()
            r3.put(r2, r5)
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r2 = r14.getRunTimeStatus()
            com.baidu.searchbox.video.feedflow.flow.list.RecommendShowModel r2 = r2.getRecommendNextContentFlagState()
            if (r2 == 0) goto L_0x00ee
            boolean r2 = r2.isClicked()
            if (r2 != r6) goto L_0x00ee
            r2 = r6
            goto L_0x00ef
        L_0x00ee:
            r2 = r7
        L_0x00ef:
            if (r2 == 0) goto L_0x0112
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r2 = r14.getRunTimeStatus()
            com.baidu.searchbox.video.feedflow.flow.list.RecommendShowModel r2 = r2.getRecommendNextContentFlagState()
            if (r2 == 0) goto L_0x0105
            boolean r2 = r2.isDefaultText()
            if (r2 != r6) goto L_0x0105
            r2 = r6
            goto L_0x0106
        L_0x0105:
            r2 = r7
        L_0x0106:
            if (r2 == 0) goto L_0x010b
            java.lang.String r2 = "0"
            goto L_0x010c
        L_0x010b:
            r2 = r8
        L_0x010c:
            java.lang.String r5 = "trailer_status"
            r3.putOpt(r5, r2)
        L_0x0112:
            if (r15 == 0) goto L_0x011f
            java.lang.Boolean r2 = r15.isColdLaunchRestore
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r6)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            goto L_0x0120
        L_0x011f:
            r2 = r7
        L_0x0120:
            if (r2 == 0) goto L_0x0127
            java.lang.String r2 = "coldstart"
            r3.put(r2, r8)
        L_0x0127:
            java.lang.Object r2 = r14.getData()
            boolean r5 = r2 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel
            if (r5 == 0) goto L_0x0132
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r2 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r2
            goto L_0x0133
        L_0x0132:
            r2 = r0
        L_0x0133:
            if (r2 == 0) goto L_0x0139
            java.lang.String r0 = r2.getLandscapeRelatedRecommendSuperId()
        L_0x0139:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0146
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0145
            goto L_0x0146
        L_0x0145:
            r6 = r7
        L_0x0146:
            if (r6 != 0) goto L_0x0156
            java.lang.String r2 = "template"
            java.lang.String r5 = "relate_recommend"
            r3.put(r2, r5)
            java.lang.String r2 = "mounted_rid"
            r3.put(r2, r0)
        L_0x0156:
            org.json.JSONObject r2 = r16.getSpecificExt()
            com.baidu.searchbox.feed.detail.ext.common.UbcExtBeanKt.mergeExt((org.json.JSONObject) r3, (org.json.JSONObject) r2)
            org.json.JSONObject r2 = r16.getUserStatusExt()
            com.baidu.searchbox.feed.detail.ext.common.UbcExtBeanKt.mergeExt((org.json.JSONObject) r3, (org.json.JSONObject) r2)
            org.json.JSONObject r2 = r16.getPlayMode(r17)
            com.baidu.searchbox.feed.detail.ext.common.UbcExtBeanKt.mergeExt((org.json.JSONObject) r3, (org.json.JSONObject) r2)
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r2 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            r2.appendFoldScreenInfo(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r0 = r1
        L_0x0174:
            java.lang.String r1 = "ext_log"
            r13.putOpt(r1, r0)
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r0 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE
            com.baidu.searchbox.feed.detail.frame.State r1 = r17.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r1 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r1
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r9 = 0
            r11 = 316(0x13c, float:4.43E-43)
            r12 = 0
            java.lang.String r2 = "click"
            java.lang.String r10 = "6518"
            r7 = r13
            r8 = r19
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.upload6518Ubc$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.tab.upload6518.Upload6518Middleware.upload6518(com.baidu.searchbox.feed.detail.frame.Store, com.baidu.searchbox.video.channel.tab.upload6518.TriggerType, com.baidu.searchbox.video.feedflow.flow.list.ItemModel):void");
    }

    private final JSONObject getPlayMode(Store<CommonState> store) {
        String str;
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$getPlayMode_u24lambda_u2d1 = jSONObject;
        switch (WhenMappings.$EnumSwitchMapping$0[PlayModePluginKt.getCurPlayMode((Store<?>) store).ordinal()]) {
            case 1:
                str = "loop";
                break;
            case 2:
                str = "auto";
                break;
            case 3:
                str = "ai";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        $this$getPlayMode_u24lambda_u2d1.putOpt("play_mode", str);
        return jSONObject;
    }

    private final JSONObject getUserStatusExt() {
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$getUserStatusExt_u24lambda_u2d2 = jSONObject;
        String str = "1";
        $this$getUserStatusExt_u24lambda_u2d2.putOpt(VgLogConfig.BLUETOOTH, VideoFlowUtilsKt.getBluetoothStatus() ? str : "0");
        $this$getUserStatusExt_u24lambda_u2d2.putOpt("battery", String.valueOf(VideoFlowUtilsKt.getElectricity()));
        if (!VideoFlowUtilsKt.getHeadsetStatus(DIFactory.INSTANCE.getAppContext())) {
            str = "0";
        }
        $this$getUserStatusExt_u24lambda_u2d2.putOpt("is_headset_play", str);
        $this$getUserStatusExt_u24lambda_u2d2.putOpt("volume_size", String.valueOf(VideoFlowUtilsKt.getSystemVolume(DIFactory.INSTANCE.getAppContext())));
        return jSONObject;
    }

    private final JSONObject getSpecificExt() {
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$getSpecificExt_u24lambda_u2d3 = jSONObject;
        $this$getSpecificExt_u24lambda_u2d3.put("extra_pd", VideoChannelUtils.EXTRA_PD);
        $this$getSpecificExt_u24lambda_u2d3.put("video_source", VideoChannelUtils.VIDEO_SOURCE);
        return jSONObject;
    }
}
