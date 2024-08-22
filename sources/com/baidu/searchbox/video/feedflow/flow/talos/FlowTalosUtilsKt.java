package com.baidu.searchbox.video.feedflow.flow.talos;

import android.os.Bundle;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import com.baidu.searchbox.video.feedflow.tab.TabState;
import com.baidu.searchbox.video.feedflow.utils.TabUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a(\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005¨\u0006\u0010"}, d2 = {"buildFlowTalosExtData", "Landroid/os/Bundle;", "bizParams", "", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "isPreCreate", "", "buildRequestData", "nid", "service", "Lcom/baidu/searchbox/video/feedflow/flow/service/IFlowComponentService;", "getIds", "", "getTabTopHeight", "", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowTalosUtils.kt */
public final class FlowTalosUtilsKt {
    public static /* synthetic */ Bundle buildFlowTalosExtData$default(String str, Store store, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return buildFlowTalosExtData(str, store, z);
    }

    public static final Bundle buildFlowTalosExtData(String bizParams, Store<?> store, boolean isPreCreate) {
        Intrinsics.checkNotNullParameter(bizParams, "bizParams");
        Bundle bundle = new Bundle();
        Bundle $this$buildFlowTalosExtData_u24lambda_u2d0 = bundle;
        boolean z = false;
        if (bizParams.length() > 0) {
            try {
                JSONObject extraObj = new JSONObject(bizParams);
                Iterator it = extraObj.keys();
                while (it.hasNext()) {
                    String key = it.next().toString();
                    $this$buildFlowTalosExtData_u24lambda_u2d0.putString(key, extraObj.optString(key));
                }
                String rnInfo = DIFactory.INSTANCE.getConfig().getRnChannelConfig();
                if (rnInfo.length() > 0) {
                    z = true;
                }
                if (z) {
                    JSONObject channelObj = new JSONObject(rnInfo).optJSONObject(extraObj.optString("channelId"));
                    String optString = channelObj != null ? channelObj.optString("talos_backgrounds") : null;
                    if (optString == null) {
                        optString = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(optString, "channelObj?.optString(\"talos_backgrounds\") ?: \"\"");
                    }
                    $this$buildFlowTalosExtData_u24lambda_u2d0.putString("backgrounds", optString);
                }
            } catch (JSONException e2) {
            }
        }
        $this$buildFlowTalosExtData_u24lambda_u2d0.putInt("fontSize", DIFactory.INSTANCE.getFontSize());
        $this$buildFlowTalosExtData_u24lambda_u2d0.putInt("tabHeight", getTabTopHeight(store));
        $this$buildFlowTalosExtData_u24lambda_u2d0.putInt("is_close_individual", DIFactory.INSTANCE.getConfig().isCloseIndividual() ^ true ? 1 : 0);
        $this$buildFlowTalosExtData_u24lambda_u2d0.putString("homeOperateStatus", "0");
        $this$buildFlowTalosExtData_u24lambda_u2d0.putString("isCover", "0");
        if (isPreCreate) {
            $this$buildFlowTalosExtData_u24lambda_u2d0.putBoolean("is_preload", true);
        }
        return bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x018c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String buildRequestData(com.baidu.searchbox.feed.detail.frame.Store<?> r9, java.lang.String r10, com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService r11) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r1 = r0
            r2 = 0
            r3 = 1
            r4 = 0
            if (r11 == 0) goto L_0x001b
            java.util.List r5 = r11.getDataSource()
            if (r5 == 0) goto L_0x001b
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r3
            if (r5 != r3) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r3 = r4
        L_0x001c:
            java.lang.String r5 = ""
            if (r3 == 0) goto L_0x002f
            java.util.List r3 = r11.getDataSource()
            java.lang.Object r3 = r3.get(r4)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r3 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r3
            java.lang.String r3 = r3.getId()
            goto L_0x0030
        L_0x002f:
            r3 = r5
        L_0x0030:
            java.lang.String r4 = "first_id"
            r1.putOpt(r4, r3)
            r3 = 0
            if (r9 == 0) goto L_0x0057
            r4 = r9
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r4.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x0045
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x0046
        L_0x0045:
            r7 = r3
        L_0x0046:
            if (r7 == 0) goto L_0x004f
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r8 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x0050
        L_0x004f:
            r7 = r3
        L_0x0050:
            com.baidu.searchbox.video.detail.core.model.IntentData r7 = (com.baidu.searchbox.video.detail.core.model.IntentData) r7
            if (r7 == 0) goto L_0x0057
            java.lang.String r4 = r7.pd
            goto L_0x0058
        L_0x0057:
            r4 = r3
        L_0x0058:
            if (r4 != 0) goto L_0x005b
            r4 = r5
        L_0x005b:
            java.lang.String r6 = "pd"
            r1.putOpt(r6, r4)
            if (r9 == 0) goto L_0x0081
            r4 = r9
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r4.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x006f
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x0070
        L_0x006f:
            r7 = r3
        L_0x0070:
            if (r7 == 0) goto L_0x0079
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r8 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x007a
        L_0x0079:
            r7 = r3
        L_0x007a:
            com.baidu.searchbox.video.detail.core.model.IntentData r7 = (com.baidu.searchbox.video.detail.core.model.IntentData) r7
            if (r7 == 0) goto L_0x0081
            java.lang.String r4 = r7.from
            goto L_0x0082
        L_0x0081:
            r4 = r3
        L_0x0082:
            if (r4 != 0) goto L_0x0085
            r4 = r5
        L_0x0085:
            java.lang.String r6 = "from"
            r1.putOpt(r6, r4)
            if (r9 == 0) goto L_0x00ab
            r4 = r9
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r4.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x0099
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x009a
        L_0x0099:
            r7 = r3
        L_0x009a:
            if (r7 == 0) goto L_0x00a3
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r8 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x00a4
        L_0x00a3:
            r7 = r3
        L_0x00a4:
            com.baidu.searchbox.video.detail.core.model.IntentData r7 = (com.baidu.searchbox.video.detail.core.model.IntentData) r7
            if (r7 == 0) goto L_0x00ab
            java.lang.String r4 = r7.page
            goto L_0x00ac
        L_0x00ab:
            r4 = r3
        L_0x00ac:
            if (r4 != 0) goto L_0x00af
            r4 = r5
        L_0x00af:
            java.lang.String r6 = "page"
            r1.putOpt(r6, r4)
            if (r9 == 0) goto L_0x00d7
            r4 = r9
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r4.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x00c3
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x00c4
        L_0x00c3:
            r7 = r3
        L_0x00c4:
            if (r7 == 0) goto L_0x00cd
            java.lang.Class<com.baidu.searchbox.feed.detail.ext.common.UbcBean> r8 = com.baidu.searchbox.feed.detail.ext.common.UbcBean.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x00ce
        L_0x00cd:
            r7 = r3
        L_0x00ce:
            com.baidu.searchbox.feed.detail.ext.common.UbcBean r7 = (com.baidu.searchbox.feed.detail.ext.common.UbcBean) r7
            if (r7 == 0) goto L_0x00d7
            java.lang.String r4 = r7.getSource()
            goto L_0x00d8
        L_0x00d7:
            r4 = r3
        L_0x00d8:
            if (r4 != 0) goto L_0x00db
            goto L_0x00dc
        L_0x00db:
            r5 = r4
        L_0x00dc:
            java.lang.String r4 = "source"
            r1.putOpt(r4, r5)
            java.lang.String r4 = "is_preload"
            java.lang.String r5 = "1"
            r1.putOpt(r4, r5)
            java.lang.String r4 = "nid"
            r1.putOpt(r4, r10)
            com.baidu.searchbox.video.detail.export.IVideoToolBarUtils r4 = com.baidu.searchbox.video.detail.export.IVideoToolBarUtils.Impl.get()
            java.lang.String r4 = r4.getSessionId()
            java.lang.String r6 = "session_id"
            r1.putOpt(r6, r4)
            if (r9 == 0) goto L_0x011d
            r4 = r9
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r4.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x010b
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x010c
        L_0x010b:
            r7 = r3
        L_0x010c:
            if (r7 == 0) goto L_0x0115
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r8 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x0116
        L_0x0115:
            r7 = r3
        L_0x0116:
            com.baidu.searchbox.video.detail.core.model.IntentData r7 = (com.baidu.searchbox.video.detail.core.model.IntentData) r7
            if (r7 == 0) goto L_0x011d
            java.lang.String r4 = r7.tpl
            goto L_0x011e
        L_0x011d:
            r4 = r3
        L_0x011e:
            java.lang.String r6 = "tpl"
            r1.putOpt(r6, r4)
            int r4 = com.baidu.searchbox.feed.util.FeedUtil.getPlayQualityScore()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r6 = "video_play_score"
            r1.putOpt(r6, r4)
            com.baidu.searchbox.video.feedflow.di.DIFactory r4 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            java.lang.String r4 = r4.getApkStateEx()
            java.lang.String r6 = "iadex"
            r1.putOpt(r6, r4)
            com.baidu.searchbox.video.feedflow.di.DIFactory r4 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            java.lang.String r4 = r4.getApkState()
            java.lang.String r6 = "iad"
            r1.putOpt(r6, r4)
            org.json.JSONObject r4 = com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt.buildAppInfo()
            java.lang.String r4 = r4.toString()
            java.lang.String r6 = "info"
            r1.putOpt(r6, r4)
            com.baidu.searchbox.video.feedflow.di.DIFactory r4 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            com.baidu.searchbox.video.feedflow.di.IFlowVideoConfig r4 = r4.getConfig()
            boolean r4 = r4.isCloseIndividual()
            if (r4 == 0) goto L_0x0163
            java.lang.String r5 = "0"
        L_0x0163:
            java.lang.String r4 = "is_close_individual"
            r1.putOpt(r4, r5)
            if (r11 == 0) goto L_0x0173
            int r4 = r11.getPageNum()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x0174
        L_0x0173:
            r4 = r3
        L_0x0174:
            int r4 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r4)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = "refresh_index"
            r1.putOpt(r5, r4)
            java.util.List r4 = getIds(r11)
            java.lang.String r5 = "deduplicatids"
            r1.put(r5, r4)
            if (r9 == 0) goto L_0x01aa
            r4 = r9
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r4.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x0199
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x019a
        L_0x0199:
            r6 = r3
        L_0x019a:
            if (r6 == 0) goto L_0x01a3
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r7 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x01a4
        L_0x01a3:
            r6 = r3
        L_0x01a4:
            com.baidu.searchbox.video.detail.core.model.IntentData r6 = (com.baidu.searchbox.video.detail.core.model.IntentData) r6
            if (r6 == 0) goto L_0x01aa
            org.json.JSONObject r3 = r6.extRequest
        L_0x01aa:
            if (r3 != 0) goto L_0x01b2
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            goto L_0x01b8
        L_0x01b2:
            java.lang.String r4 = "store?.select<IntentData…xtRequest ?: JSONObject()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
        L_0x01b8:
            java.lang.String r4 = "extRequest"
            r1.putOpt(r4, r3)
            float r3 = com.baidu.searchbox.feed.util.FeedUtil.getStaticDeviceScore()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "device_static_score"
            r1.putOpt(r4, r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "JSONObject().apply {\n   …tring())\n    }.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.talos.FlowTalosUtilsKt.buildRequestData(com.baidu.searchbox.feed.detail.frame.Store, java.lang.String, com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService):java.lang.String");
    }

    private static final List<String> getIds(IFlowComponentService service) {
        List ids = new ArrayList();
        List<ItemModel> flowList = service != null ? service.getDataSource() : null;
        if (flowList != null) {
            for (ItemModel itemModel : flowList) {
                ids.add(itemModel.getNid());
            }
        }
        return ids;
    }

    public static final int getTabTopHeight(Store<?> store) {
        float tabHeight;
        boolean z = false;
        if (store != null) {
            Object state = store.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(TabState.class);
            }
            TabState tabState = (TabState) obj;
            if (tabState != null && !tabState.isImmersiveStatusBar()) {
                z = true;
            }
        }
        if (z) {
            tabHeight = (float) TabUtilsKt.getTabViewScaledHeight();
        } else {
            tabHeight = ((float) TabUtilsKt.getTabViewScaledHeight()) + ((float) DIFactory.INSTANCE.getStatusBarHeight());
        }
        return DIFactory.INSTANCE.px2dp(tabHeight);
    }
}
