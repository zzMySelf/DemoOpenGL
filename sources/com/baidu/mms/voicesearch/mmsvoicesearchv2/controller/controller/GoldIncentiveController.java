package com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller;

import android.text.TextUtils;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.model.utils.ToolsUtils;
import com.baidu.mms.voicesearch.voice.common.Tools;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.homepage.extend.IHomeFun;
import com.baidu.voicesearch.component.net.VoiceOkhttpClientHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Request;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0003J\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0003J\u0012\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/mms/voicesearch/mmsvoicesearchv2/controller/controller/GoldIncentiveController;", "", "()V", "GOLD_INCENTIVE_DATE_SP", "", "GOLD_INCENTIVE_KEY_NA_COMMAND", "GOLD_INCENTIVE_KEY_NA_TYPE", "GOLD_INCENTIVE_KEY_UI", "GOLD_INCENTIVE_REQUEST_KEY_REWARD", "GOLD_INCENTIVE_REQUEST_KEY_TIPOFF", "GOLD_INCENTIVE_REQUEST_KEY_VSC", "GOLD_INCENTIVE_SWITCH_SP", "GOLD_INCENTIVE_VALUE_NA_TYPE", "TAG", "addCurrDayCount", "", "addRequest", "jsonObject", "Lorg/json/JSONObject;", "checkGoldIncentive", "response", "createGoldToastCommand", "uiJson", "getCurrDayCount", "", "getTipsInfo", "url", "isToastEnable", "", "setToastEnable", "enable", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GoldIncentiveController.kt */
public final class GoldIncentiveController {
    private static final String GOLD_INCENTIVE_DATE_SP = "gold_incentive_date_sp";
    private static final String GOLD_INCENTIVE_KEY_NA_COMMAND = "na_cmd";
    private static final String GOLD_INCENTIVE_KEY_NA_TYPE = "na_type";
    private static final String GOLD_INCENTIVE_KEY_UI = "ui";
    private static final String GOLD_INCENTIVE_REQUEST_KEY_REWARD = "coin_reward";
    private static final String GOLD_INCENTIVE_REQUEST_KEY_TIPOFF = "tipoff";
    private static final String GOLD_INCENTIVE_REQUEST_KEY_VSC = "vsc";
    private static final String GOLD_INCENTIVE_SWITCH_SP = "gold_incentive_switch_sp";
    private static final String GOLD_INCENTIVE_VALUE_NA_TYPE = "gold_incentive";
    public static final GoldIncentiveController INSTANCE = new GoldIncentiveController();
    private static final String TAG = "GoldIncentiveController";

    private GoldIncentiveController() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002c A[Catch:{ Exception -> 0x000d }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkGoldIncentive(org.json.JSONObject r9) {
        /*
            r8 = this;
            r0 = -1
            if (r9 == 0) goto L_0x000f
            java.lang.String r1 = "status"
            int r1 = r9.optInt(r1)     // Catch:{ Exception -> 0x000d }
            r0 = r1
            goto L_0x000f
        L_0x000d:
            r0 = move-exception
            goto L_0x0048
        L_0x000f:
            if (r0 == 0) goto L_0x0012
            return
        L_0x0012:
            if (r9 == 0) goto L_0x001b
            java.lang.String r1 = "command"
            org.json.JSONObject r1 = r9.optJSONObject(r1)     // Catch:{ Exception -> 0x000d }
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            r2 = 1
            java.lang.String r3 = "na_tips"
            r4 = 0
            if (r1 == 0) goto L_0x0029
            boolean r5 = r1.has(r3)     // Catch:{ Exception -> 0x000d }
            if (r5 != r2) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r2 = r4
        L_0x002a:
            if (r2 == 0) goto L_0x0048
            org.json.JSONObject r2 = r1.optJSONObject(r3)     // Catch:{ Exception -> 0x000d }
            java.lang.String r3 = "url"
            java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x000d }
            com.baidu.voicesearch.component.utils.TaskDispatcher r4 = com.baidu.voicesearch.component.utils.TaskDispatcher.getSharedInstance()     // Catch:{ Exception -> 0x000d }
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.GoldIncentiveController$checkGoldIncentive$1 r5 = new com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.GoldIncentiveController$checkGoldIncentive$1     // Catch:{ Exception -> 0x000d }
            r5.<init>(r3)     // Catch:{ Exception -> 0x000d }
            com.baidu.voicesearch.component.utils.Task r5 = (com.baidu.voicesearch.component.utils.Task) r5     // Catch:{ Exception -> 0x000d }
            r6 = 500(0x1f4, double:2.47E-321)
            r4.addToAsyncWorkingLoop(r5, r6)     // Catch:{ Exception -> 0x000d }
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.GoldIncentiveController.checkGoldIncentive(org.json.JSONObject):void");
    }

    /* access modifiers changed from: private */
    public final void getTipsInfo(String url) {
        if (!TextUtils.isEmpty(url)) {
            IHomeFun iHomeFun = (IHomeFun) ServiceManager.getService(IHomeFun.SERVICE_REFERENCE);
            boolean z = true;
            if (iHomeFun == null || !iHomeFun.isHomePageVisible()) {
                z = false;
            }
            if (!z) {
                try {
                    Request request = new Request.Builder().url(url).addHeader("COOKIE", Tools.adornCookies()).addHeader("User-Agent", Tools.adornUserAgent()).addHeader("Referer", Tools.adornReferer()).build();
                    ToolsUtils.checkCookieAndUA("gold");
                    VoiceOkhttpClientHelper.getInstance().request(request, new GoldIncentiveController$getTipsInfo$1());
                } catch (Exception e2) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final JSONObject createGoldToastCommand(String uiJson) {
        JSONObject uiJSONObject = new JSONObject(uiJson);
        JSONObject naCmdJSONObject = new JSONObject();
        naCmdJSONObject.put("na_type", GOLD_INCENTIVE_VALUE_NA_TYPE);
        naCmdJSONObject.put("ui", uiJSONObject);
        JSONObject commandJSONObject = new JSONObject();
        commandJSONObject.put(GOLD_INCENTIVE_KEY_NA_COMMAND, naCmdJSONObject);
        return commandJSONObject;
    }

    /* access modifiers changed from: private */
    public final void addCurrDayCount() {
        int currDay = getCurrDayCount();
        QuickPersistConfig.getInstance().putString(GOLD_INCENTIVE_DATE_SP, new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis())) + '-' + (currDay + 1));
    }

    private final int getCurrDayCount() {
        String datStr = QuickPersistConfig.getInstance().getString(GOLD_INCENTIVE_DATE_SP, "");
        if (datStr == null || TextUtils.isEmpty(datStr) || datStr.length() <= 9) {
            return 0;
        }
        String currDateStr = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
        Intrinsics.checkNotNullExpressionValue(currDateStr, "currDateStr");
        if (StringsKt.startsWith$default(datStr, currDateStr, false, 2, (Object) null)) {
            try {
                String substring = datStr.substring(9);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                return Integer.parseInt(substring);
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    public final void addRequest(JSONObject jsonObject) {
        if (jsonObject != null) {
            JSONObject it = jsonObject;
            GoldIncentiveController goldIncentiveController = INSTANCE;
            it.put(GOLD_INCENTIVE_REQUEST_KEY_VSC, goldIncentiveController.getCurrDayCount());
            JSONObject rewardJs = new JSONObject();
            if (goldIncentiveController.isToastEnable()) {
                rewardJs.put(GOLD_INCENTIVE_REQUEST_KEY_TIPOFF, 0);
            } else {
                rewardJs.put(GOLD_INCENTIVE_REQUEST_KEY_TIPOFF, 1);
            }
            it.put(GOLD_INCENTIVE_REQUEST_KEY_REWARD, rewardJs);
        }
    }

    private final boolean isToastEnable() {
        return QuickPersistConfig.getInstance().getBoolean(GOLD_INCENTIVE_SWITCH_SP, true);
    }

    public final void setToastEnable(boolean enable) {
        QuickPersistConfig.getInstance().putBoolean(GOLD_INCENTIVE_SWITCH_SP, enable);
    }
}
