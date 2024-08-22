package com.baidu.searchbox.video.hotflow.router;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.feed.idal.biserial.IFeedBiserialService;
import com.baidu.searchbox.feed.ui.drawerslide.SlideToFinishActivity;
import com.baidu.searchbox.launch.restore.data.ColdLaunchRestoreTypeKt;
import com.baidu.searchbox.lightbrowser.IntentConstant;
import com.baidu.searchbox.schemedispatch.united.utils.UnitedSchemeParseUtil;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J$\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ&\u0010\u0010\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002JD\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0016j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00172\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J6\u0010\u0018\u001a\u0004\u0018\u00010\u00042\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0016j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00172\u0006\u0010\t\u001a\u00020\nH\u0002J,\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/video/hotflow/router/HotFlowSchemeAction;", "", "()V", "schemeParams", "", "checkIsColdLaunchRestore", "", "entity", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;", "intent", "Landroid/content/Intent;", "handle", "context", "Landroid/content/Context;", "handler", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "handleInvokeVideoDetail", "handleParamIsEmpty", "", "param", "handleParams", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "handleTransitionParam", "startTargetActivity", "transition", "stay", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotFlowSchemeAction.kt */
public final class HotFlowSchemeAction {
    private final String schemeParams = "params";

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r6.getParams();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handle(android.content.Context r5, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity r6, com.baidu.searchbox.unitedscheme.CallbackHandler r7) {
        /*
            r4 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0012
            java.util.HashMap r1 = r6.getParams()
            if (r1 == 0) goto L_0x0012
            java.lang.String r2 = r4.schemeParams
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0013
        L_0x0012:
            r1 = r0
        L_0x0013:
            java.lang.String r1 = com.baidu.searchbox.video.detail.core.model.IntentData.getNidFromParam(r1)
            r2 = 0
            if (r6 == 0) goto L_0x001e
            java.lang.String r0 = r6.getPath(r2)
        L_0x001e:
            java.lang.String r3 = "invokeVideoDetail"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x002b
            boolean r2 = r4.handleInvokeVideoDetail(r5, r6, r7)
            goto L_0x0053
        L_0x002b:
            java.lang.String r3 = "invokeVideoLandingPage"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            r3 = 302(0x12e, float:4.23E-43)
            if (r0 == 0) goto L_0x0049
            com.baidu.searchbox.video.feedflow.di.DIFactory r0 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            boolean r0 = r0.isDebug()
            if (r0 == 0) goto L_0x0042
            boolean r2 = r4.handleInvokeVideoDetail(r5, r6, r7)
            goto L_0x0053
        L_0x0042:
            org.json.JSONObject r0 = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.wrapCallbackParams(r3)
            r6.result = r0
            goto L_0x0053
        L_0x0049:
            if (r6 != 0) goto L_0x004c
            goto L_0x0052
        L_0x004c:
            org.json.JSONObject r0 = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.wrapCallbackParams(r3)
            r6.result = r0
        L_0x0052:
        L_0x0053:
            r0 = r2
            if (r1 != 0) goto L_0x0059
            java.lang.String r2 = ""
            goto L_0x005a
        L_0x0059:
            r2 = r1
        L_0x005a:
            com.baidu.searchbox.player.ubc.PlayerSpeedTracker.endVideoSchemeHandle(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.hotflow.router.HotFlowSchemeAction.handle(android.content.Context, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity, com.baidu.searchbox.unitedscheme.CallbackHandler):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: android.net.Uri} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean handleInvokeVideoDetail(android.content.Context r11, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity r12, com.baidu.searchbox.unitedscheme.CallbackHandler r13) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r12 == 0) goto L_0x000c
            java.lang.String r2 = r12.getPath(r0)
            goto L_0x000d
        L_0x000c:
            r2 = r1
        L_0x000d:
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            r4 = 1
            if (r3 == 0) goto L_0x003b
            if (r12 == 0) goto L_0x0020
            boolean r3 = r12.isOnlyVerify()
            if (r3 != r4) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r4 = r0
        L_0x0021:
            if (r4 != 0) goto L_0x002f
            if (r12 == 0) goto L_0x0029
            android.net.Uri r1 = r12.getUri()
        L_0x0029:
            java.lang.String r3 = "no action/params"
            com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil.doUBCForInvalidScheme(r1, r3)
        L_0x002f:
            if (r12 != 0) goto L_0x0032
            goto L_0x003a
        L_0x0032:
            r1 = 201(0xc9, float:2.82E-43)
            org.json.JSONObject r1 = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.wrapCallbackParams(r1)
            r12.result = r1
        L_0x003a:
            return r0
        L_0x003b:
            if (r12 == 0) goto L_0x0042
            java.util.HashMap r3 = r12.getParams()
            goto L_0x0043
        L_0x0042:
            r3 = r1
        L_0x0043:
            if (r3 == 0) goto L_0x00c5
            int r5 = r3.size()
            if (r5 > 0) goto L_0x004d
            goto L_0x00c5
        L_0x004d:
            android.content.Intent r5 = new android.content.Intent
            r5.<init>()
            java.lang.String r6 = r10.schemeParams
            java.lang.Object r6 = r3.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x0068
            boolean r7 = kotlin.text.StringsKt.isBlank(r7)
            if (r7 == 0) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r7 = r0
            goto L_0x0069
        L_0x0068:
            r7 = r4
        L_0x0069:
            if (r7 != 0) goto L_0x0085
            android.content.ComponentName r7 = new android.content.ComponentName     // Catch:{ JSONException -> 0x007b }
            android.content.Context r8 = r11.getApplicationContext()     // Catch:{ JSONException -> 0x007b }
            java.lang.Class<com.baidu.searchbox.video.hotflow.HotFlowActivity> r9 = com.baidu.searchbox.video.hotflow.HotFlowActivity.class
            r7.<init>(r8, r9)     // Catch:{ JSONException -> 0x007b }
            r5.setComponent(r7)     // Catch:{ JSONException -> 0x007b }
            goto L_0x0085
        L_0x007b:
            r1 = move-exception
            r4 = 202(0xca, float:2.83E-43)
            org.json.JSONObject r4 = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.wrapCallbackParams(r4)
            r12.result = r4
            return r0
        L_0x0085:
            boolean r7 = r10.checkIsColdLaunchRestore(r12, r5)
            java.lang.String r8 = "coldLaunchRestoreVideo"
            r5.putExtra(r8, r7)
            java.util.HashMap r7 = r12.getInvokeInfo()
            java.lang.String r8 = "launchSource"
            if (r7 == 0) goto L_0x009d
            java.lang.Object r1 = r7.get(r8)
            java.lang.String r1 = (java.lang.String) r1
        L_0x009d:
            r7 = r1
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00a9
            r5.putExtra(r8, r1)
        L_0x00a9:
            boolean r7 = r12.isOnlyVerify()
            if (r7 == 0) goto L_0x00b0
            return r4
        L_0x00b0:
            r10.handleParams(r12, r3, r5, r11)
            java.lang.String r7 = r12.getSource()
            android.net.Uri r8 = r12.getUri()
            com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil.doUBCForSchemeInvoke(r7, r8)
            org.json.JSONObject r0 = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.callCallback((com.baidu.searchbox.unitedscheme.CallbackHandler) r13, (com.baidu.searchbox.unitedscheme.UnitedSchemeEntity) r12, (int) r0)
            r12.result = r0
            return r4
        L_0x00c5:
            java.lang.String r1 = r10.schemeParams
            r10.handleParamIsEmpty(r12, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.hotflow.router.HotFlowSchemeAction.handleInvokeVideoDetail(android.content.Context, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity, com.baidu.searchbox.unitedscheme.CallbackHandler):boolean");
    }

    private final void handleParams(UnitedSchemeEntity entity, HashMap<String, String> params, Intent intent, Context context) {
        String stay = UnitedSchemeParseUtil.getStayParam(entity, params);
        UnitedSchemeParseUtil.handleCascadeScheme(params, intent);
        UnitedSchemeParseUtil.handleStyleParam(params, intent);
        UnitedSchemeParseUtil.handleRemainedParams((Map<String, String>) params, intent);
        startTargetActivity(handleTransitionParam(params, intent), stay, intent, context);
    }

    private final void startTargetActivity(String transition, String stay, Intent intent, Context context) {
        if (TextUtils.equals(transition, "0")) {
            IFeedBiserialService biserialService = (IFeedBiserialService) ServiceManager.getService(IFeedBiserialService.Companion.getSERVICE_REFERENCE());
            SlideToFinishActivity.Companion.setSharedElement(biserialService != null ? biserialService.getClickItemView() : null);
        }
        UnitedSchemeParseUtil.start(context, stay, intent);
    }

    private final String handleTransitionParam(HashMap<String, String> params, Intent intent) {
        String remove;
        IFeedBiserialService biserialService = (IFeedBiserialService) ServiceManager.getService(IFeedBiserialService.Companion.getSERVICE_REFERENCE());
        String str = "1";
        if (!((biserialService != null ? biserialService.getClickItemView() : null) == null || !biserialService.isClickFeedModelLegal() || (remove = params.remove(IntentConstant.TRANSITION_TYPE)) == null)) {
            str = remove;
        }
        String transition = str;
        intent.putExtra(SlideToFinishActivity.KEY_TRANSITION, transition);
        return transition;
    }

    private final void handleParamIsEmpty(UnitedSchemeEntity entity, String param) {
        String errorMsg = "no " + param;
        boolean z = true;
        if (entity == null || !entity.isOnlyVerify()) {
            z = false;
        }
        if (!z) {
            UnitedSchemeStatisticUtil.doUBCForInvalidScheme(entity != null ? entity.getUri() : null, errorMsg);
        }
        if (entity != null) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        }
    }

    private final boolean checkIsColdLaunchRestore(UnitedSchemeEntity entity, Intent intent) {
        HashMap<String, String> invokeInfo = entity.getInvokeInfo();
        String str = null;
        CharSequence charSequence = invokeInfo != null ? invokeInfo.get(ColdLaunchRestoreTypeKt.KEY_RESTORE_TYPE) : null;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        HashMap<String, String> invokeInfo2 = entity.getInvokeInfo();
        if (invokeInfo2 != null) {
            str = invokeInfo2.get(ColdLaunchRestoreTypeKt.KEY_RESTORE_TYPE);
        }
        intent.putExtra(ColdLaunchRestoreTypeKt.KEY_RESTORE_TYPE, str);
        return true;
    }
}
