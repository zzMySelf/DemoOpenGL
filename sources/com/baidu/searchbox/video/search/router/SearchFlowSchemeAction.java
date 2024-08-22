package com.baidu.searchbox.video.search.router;

import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.browserenhanceengine.utils.BeeRenderMonitor;
import com.baidu.searchbox.player.preboot.env.PolicyScene;
import com.baidu.searchbox.player.preboot.env.PrebootRuntimeKt;
import com.baidu.searchbox.player.preboot.env.PrebootType;
import com.baidu.searchbox.player.ubc.PlayerSpeedTracker;
import com.baidu.searchbox.schemedispatch.united.utils.UnitedSchemeParseUtil;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.video.search.SearchFlowManifestKt;
import com.baidu.searchbox.video.search.player.plugin.SearchFirstJumpSlotRecord;
import com.baidu.searchbox.video.videoplayer.util.VideoInfoParser;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JT\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000ej\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011JV\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000ej\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\u000f2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\fH\u0002JD\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000ej\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020 H\u0002¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/video/search/router/SearchFlowSchemeAction;", "", "()V", "handle", "", "context", "Landroid/content/Context;", "entity", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;", "handler", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "action", "", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "startDispatchTimeStamp", "", "handleInvokeVideoDetail", "startTime", "handleJsonException", "", "e", "Lorg/json/JSONException;", "actionName", "handleParamIsEmpty", "param", "handleParams", "intent", "Landroid/content/Intent;", "handleUnknownAction", "preloadVideoFlowData", "Lorg/json/JSONObject;", "search-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchFlowSchemeAction.kt */
public final class SearchFlowSchemeAction {
    public final boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, String action, HashMap<String, String> params, long startDispatchTimeStamp) {
        boolean result;
        UnitedSchemeEntity unitedSchemeEntity = entity;
        String str = action;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(unitedSchemeEntity, "entity");
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(params, "params");
        if (Intrinsics.areEqual((Object) str, (Object) "invokeVideoDetail")) {
            result = handleInvokeVideoDetail(context, entity, handler, params, BeeRenderMonitor.getTime(), startDispatchTimeStamp);
        } else {
            result = handleUnknownAction(unitedSchemeEntity);
        }
        HashMap<String, String> params2 = entity.getParams();
        String nid = IntentData.getNidFromParam(params2 != null ? params2.get("params") : null);
        if (nid == null) {
            nid = "";
        }
        SearchFirstJumpSlotRecord.INSTANCE.recordEndSchemeDispatchTimeStamp(nid, System.currentTimeMillis());
        PlayerSpeedTracker.endVideoSchemeHandle(nid);
        return result;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c8, code lost:
        if (r0 != false) goto L_0x00ca;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0133  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean handleInvokeVideoDetail(android.content.Context r17, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity r18, com.baidu.searchbox.unitedscheme.CallbackHandler r19, java.util.HashMap<java.lang.String, java.lang.String> r20, long r21, long r23) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r0 = r5
            java.util.Map r0 = (java.util.Map) r0
            r6 = 1
            r7 = 0
            if (r0 == 0) goto L_0x001a
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            r0 = r7
            goto L_0x001b
        L_0x001a:
            r0 = r6
        L_0x001b:
            java.lang.String r8 = "params"
            if (r0 == 0) goto L_0x0024
            r1.handleParamIsEmpty(r3, r8)
            return r7
        L_0x0024:
            boolean r0 = r18.isOnlyVerify()
            if (r0 == 0) goto L_0x002b
            return r6
        L_0x002b:
            com.baidu.searchbox.videointerface.ISearchVideoBasic$Companion r0 = com.baidu.searchbox.videointerface.ISearchVideoBasic.Companion
            com.baidu.pyramid.runtime.service.ServiceReference r0 = r0.getReference()
            java.lang.Object r0 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r0)
            com.baidu.searchbox.videointerface.ISearchVideoBasic r0 = (com.baidu.searchbox.videointerface.ISearchVideoBasic) r0
            if (r0 == 0) goto L_0x0041
            boolean r0 = r0.fastClick()
            if (r0 != r6) goto L_0x0041
            r0 = r6
            goto L_0x0042
        L_0x0041:
            r0 = r7
        L_0x0042:
            if (r0 == 0) goto L_0x004b
            org.json.JSONObject r0 = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.callCallback((com.baidu.searchbox.unitedscheme.CallbackHandler) r4, (com.baidu.searchbox.unitedscheme.UnitedSchemeEntity) r3, (int) r7)
            r3.result = r0
            return r6
        L_0x004b:
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            r9 = r0
            r0 = 0
            java.lang.Object r8 = r5.get(r8)
            java.lang.String r0 = "toolbaricons"
            java.lang.Object r0 = r5.get(r0)
            r10 = r0
            java.lang.String r10 = (java.lang.String) r10
            com.baidu.searchbox.video.search.tab.SearchSpecificityTabHelper r0 = com.baidu.searchbox.video.search.tab.SearchSpecificityTabHelper.INSTANCE
            r0.parseTabConfig()
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0112 }
            r11 = r8
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ JSONException -> 0x0112 }
            r0.<init>(r11)     // Catch:{ JSONException -> 0x0112 }
            r11 = 0
            com.baidu.searchbox.video.search.router.SearchFlowSchemeAction$handleInvokeVideoDetail$1$1 r12 = new com.baidu.searchbox.video.search.router.SearchFlowSchemeAction$handleInvokeVideoDetail$1$1     // Catch:{ JSONException -> 0x0112 }
            r13 = r23
            r12.<init>(r13)     // Catch:{ JSONException -> 0x0110 }
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12     // Catch:{ JSONException -> 0x0110 }
            java.lang.String r12 = com.baidu.searchbox.video.search.utils.SearchFlowUbcUtilsKt.updateParams(r0, r12)     // Catch:{ JSONException -> 0x0110 }
            r8 = r12
            com.baidu.searchbox.video.feedflow.abtest.VideoFlowAbTestManager r12 = com.baidu.searchbox.video.feedflow.abtest.VideoFlowAbTestManager.INSTANCE     // Catch:{ JSONException -> 0x0110 }
            boolean r12 = r12.getSearchFlowPreboot()     // Catch:{ JSONException -> 0x0110 }
            if (r12 == 0) goto L_0x0088
            r1.preloadVideoFlowData(r0)     // Catch:{ JSONException -> 0x0110 }
        L_0x0088:
            com.baidu.pyramid.runtime.service.ServiceReference r0 = com.baidu.searchbox.search.pyramid.SearchBrowserInterface.SERVICE_REFERENCE     // Catch:{ JSONException -> 0x0110 }
            java.lang.Object r0 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r0)     // Catch:{ JSONException -> 0x0110 }
            com.baidu.searchbox.search.pyramid.SearchBrowserInterface r0 = (com.baidu.searchbox.search.pyramid.SearchBrowserInterface) r0     // Catch:{ JSONException -> 0x0110 }
            if (r0 == 0) goto L_0x00a0
            boolean r0 = r0.isLightSearchActivity(r2)     // Catch:{ JSONException -> 0x0110 }
            if (r0 != r6) goto L_0x009e
            r0 = r6
            goto L_0x00a1
        L_0x009e:
            r0 = r7
            goto L_0x00a1
        L_0x00a0:
            r0 = r7
        L_0x00a1:
            if (r0 == 0) goto L_0x00ca
            com.baidu.searchbox.browserenhanceengine.container.IContainerManager r0 = com.baidu.searchbox.browserenhanceengine.container.BeeSchemeRouter.getContainerManager()     // Catch:{ JSONException -> 0x0110 }
            if (r0 == 0) goto L_0x00ca
            com.baidu.searchbox.browserenhanceengine.container.IContainerManager r0 = com.baidu.searchbox.browserenhanceengine.container.BeeSchemeRouter.getContainerManager()     // Catch:{ JSONException -> 0x0110 }
            if (r0 == 0) goto L_0x00c7
            com.baidu.searchbox.video.search.container.SearchFlowContainerModel r11 = new com.baidu.searchbox.video.search.container.SearchFlowContainerModel     // Catch:{ JSONException -> 0x0110 }
            com.baidu.searchbox.video.search.router.SearchFlowSchemeParams r12 = new com.baidu.searchbox.video.search.router.SearchFlowSchemeParams     // Catch:{ JSONException -> 0x0110 }
            r12.<init>(r8, r10)     // Catch:{ JSONException -> 0x0110 }
            r11.<init>(r12)     // Catch:{ JSONException -> 0x0110 }
            com.baidu.searchbox.browserenhanceengine.container.ContainerModel r11 = (com.baidu.searchbox.browserenhanceengine.container.ContainerModel) r11     // Catch:{ JSONException -> 0x0110 }
            r12 = 0
            boolean r0 = r0.openContainerOnMainThread(r11, r12, r6)     // Catch:{ JSONException -> 0x0110 }
            if (r0 != 0) goto L_0x00c5
            r0 = r6
            goto L_0x00c8
        L_0x00c5:
            r0 = r7
            goto L_0x00c8
        L_0x00c7:
            r0 = r7
        L_0x00c8:
            if (r0 == 0) goto L_0x00f7
        L_0x00ca:
            r0 = r9
            r11 = 0
            java.lang.String r12 = "com.baidu.searchbox.action.LIGHT_SEARCH"
            r0.setAction(r12)     // Catch:{ JSONException -> 0x0110 }
            r12 = 536870912(0x20000000, float:1.0842022E-19)
            r0.addFlags(r12)     // Catch:{ JSONException -> 0x0110 }
            android.content.Context r12 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ JSONException -> 0x0110 }
            java.lang.String r12 = r12.getPackageName()     // Catch:{ JSONException -> 0x0110 }
            r0.setPackage(r12)     // Catch:{ JSONException -> 0x0110 }
            java.lang.String r12 = "EXTRA_BEE_CONTAINER_PARAMS"
            com.baidu.searchbox.video.search.container.SearchFlowContainerModel r15 = new com.baidu.searchbox.video.search.container.SearchFlowContainerModel     // Catch:{ JSONException -> 0x0110 }
            com.baidu.searchbox.video.search.router.SearchFlowSchemeParams r6 = new com.baidu.searchbox.video.search.router.SearchFlowSchemeParams     // Catch:{ JSONException -> 0x0110 }
            r6.<init>(r8, r10)     // Catch:{ JSONException -> 0x0110 }
            r15.<init>(r6)     // Catch:{ JSONException -> 0x0110 }
            java.io.Serializable r15 = (java.io.Serializable) r15     // Catch:{ JSONException -> 0x0110 }
            r0.putExtra(r12, r15)     // Catch:{ JSONException -> 0x0110 }
            r1.handleParams(r3, r5, r9, r2)     // Catch:{ JSONException -> 0x0110 }
        L_0x00f7:
            boolean r0 = r18.isOnlyVerify()
            if (r0 != 0) goto L_0x0108
            java.lang.String r0 = r18.getSource()
            android.net.Uri r6 = r18.getUri()
            com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil.doUBCForSchemeInvoke(r0, r6)
        L_0x0108:
            org.json.JSONObject r0 = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.callCallback((com.baidu.searchbox.unitedscheme.CallbackHandler) r4, (com.baidu.searchbox.unitedscheme.UnitedSchemeEntity) r3, (int) r7)
            r3.result = r0
            r0 = 1
            return r0
        L_0x0110:
            r0 = move-exception
            goto L_0x0115
        L_0x0112:
            r0 = move-exception
            r13 = r23
        L_0x0115:
            com.baidu.searchbox.videointerface.ISearchVideoBasic$Companion r6 = com.baidu.searchbox.videointerface.ISearchVideoBasic.Companion
            com.baidu.pyramid.runtime.service.ServiceReference r6 = r6.getReference()
            java.lang.Object r6 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r6)
            com.baidu.searchbox.videointerface.ISearchVideoBasic r6 = (com.baidu.searchbox.videointerface.ISearchVideoBasic) r6
            if (r6 == 0) goto L_0x0128
            java.lang.String r11 = ""
            r6.setEnterTransitionAnimationState(r7, r11)
        L_0x0128:
            java.lang.String r6 = "invokeVideoDetail"
            r1.handleJsonException(r3, r0, r6)
            boolean r6 = com.baidu.searchbox.video.search.SearchFlowManifestKt.getDEBUG()
            if (r6 == 0) goto L_0x0136
            r0.printStackTrace()
        L_0x0136:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.search.router.SearchFlowSchemeAction.handleInvokeVideoDetail(android.content.Context, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity, com.baidu.searchbox.unitedscheme.CallbackHandler, java.util.HashMap, long, long):boolean");
    }

    private final void preloadVideoFlowData(JSONObject params) {
        JSONObject $this$preloadVideoFlowData_u24lambda_u2d2 = params;
        BdVideoSeries series = VideoInfoParser.parseVideoInfo($this$preloadVideoFlowData_u24lambda_u2d2.optString("videoInfo"));
        CharSequence vid = series != null ? series.getVid() : null;
        boolean z = false;
        if ((vid == null || vid.length() == 0) && series != null) {
            String optString = $this$preloadVideoFlowData_u24lambda_u2d2.optString("vid");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"vid\")");
            series.setVid(optString);
        }
        if (series != null && series.isValid()) {
            z = true;
        }
        if (z) {
            PrebootRuntimeKt.prebootEngine().preboot(PrebootRuntimeKt.toPrebootInfo(series, PrebootType.PREPARE, PolicyScene.LIST));
        }
    }

    private final void handleParams(UnitedSchemeEntity entity, HashMap<String, String> params, Intent intent, Context context) {
        String stay = UnitedSchemeParseUtil.getStayParam(entity, params);
        UnitedSchemeParseUtil.handleCascadeScheme(params, intent);
        UnitedSchemeParseUtil.handleStyleParam(params, intent);
        UnitedSchemeParseUtil.handleRemainedParams((Map<String, String>) params, intent);
        UnitedSchemeParseUtil.start(context, stay, intent);
    }

    private final void handleJsonException(UnitedSchemeEntity entity, JSONException e2, String actionName) {
        SearchFlowManifestKt.getDEBUG();
        entity.result = UnitedSchemeUtility.wrapCallbackParams(202);
    }

    private final void handleParamIsEmpty(UnitedSchemeEntity entity, String param) {
        String errorMsg = "no " + param;
        if (!entity.isOnlyVerify()) {
            UnitedSchemeStatisticUtil.doUBCForInvalidScheme(entity.getUri(), errorMsg);
        }
        SearchFlowManifestKt.getDEBUG();
        entity.result = UnitedSchemeUtility.wrapCallbackParams(202);
    }

    private final boolean handleUnknownAction(UnitedSchemeEntity entity) {
        if (!entity.isOnlyVerify()) {
            UnitedSchemeStatisticUtil.doUBCForInvalidScheme(entity.getUri(), "unknown action");
        }
        SearchFlowManifestKt.getDEBUG();
        entity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        return false;
    }
}
