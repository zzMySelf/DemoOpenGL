package com.baidu.searchbox.feed.payment.core;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.feed.log.OnLineLog;
import com.baidu.searchbox.feed.payment.core.model.PayInfo;
import com.baidu.searchbox.feed.payment.payui.PayUiFacade;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;

public class UnitedSchemeFeedCommonPayDispatcher extends UnitedSchemeBaseDispatcher {
    public static final String ACTION_PAY = "pay";
    public static final String ACTION_SUBSCRIBE = "subscribe";
    public static final String IS_FREE = "1";
    public static final String IS_PRESENT = "1";
    private static final String KEY_EXT = "ext";
    private static final String KEY_IS_FREE = "isFree";
    private static final String KEY_IS_PRESENT = "isPresent";
    private static final String KEY_PARAMS = "params";
    private static final String KEY_RES_ID = "resId";
    private static final String KEY_SEXT = "sExt";
    private static final String KEY_SOURCE = "source";
    private static final String KEY_TYPE = "type";
    public static final String TAG = "FeedCommonPayDispatcher";

    public String getDispatcherName() {
        return UnitedSchemeBaseDispatcher.DISPATCHER_NOT_FIRST_LEVEL;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d0, code lost:
        if (r2.equals("pay") != false) goto L_0x00d4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean invoke(android.content.Context r9, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity r10, com.baidu.searchbox.unitedscheme.CallbackHandler r11) {
        /*
            r8 = this;
            java.lang.String r0 = "FeedPay"
            com.baidu.searchbox.feed.log.IFeedLogger r1 = com.baidu.searchbox.feed.log.OnLineLog.get(r0)
            java.lang.String r2 = "FeedCommonPayDispatcher UnitedSchemeFeedCommonPayDispatcher invoke"
            r1.d(r2)
            r1 = 0
            if (r9 != 0) goto L_0x0020
            com.baidu.searchbox.feed.log.IFeedLogger r0 = com.baidu.searchbox.feed.log.OnLineLog.get(r0)
            java.lang.String r2 = "FeedCommonPayDispatcher context is null"
            r0.d(r2)
            r0 = 1001(0x3e9, float:1.403E-42)
            org.json.JSONObject r0 = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.wrapCallbackParams(r0)
            r10.result = r0
            return r1
        L_0x0020:
            java.lang.String r2 = r10.getPath(r1)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L_0x004c
            boolean r3 = r10.isOnlyVerify()
            if (r3 != 0) goto L_0x003a
            android.net.Uri r3 = r10.getUri()
            java.lang.String r4 = "no action"
            com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil.doUBCForInvalidScheme(r3, r4)
        L_0x003a:
            com.baidu.searchbox.feed.log.IFeedLogger r0 = com.baidu.searchbox.feed.log.OnLineLog.get(r0)
            java.lang.String r3 = "FeedCommonPayDispatcher Uri action is null"
            r0.w(r3)
            r0 = 201(0xc9, float:2.82E-43)
            org.json.JSONObject r0 = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.wrapCallbackParams(r0)
            r10.result = r0
            return r1
        L_0x004c:
            boolean r3 = r8.isActionValid(r2)
            if (r3 != 0) goto L_0x0074
            boolean r3 = r10.isOnlyVerify()
            if (r3 != 0) goto L_0x0062
            android.net.Uri r3 = r10.getUri()
            java.lang.String r4 = "unknown action"
            com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil.doUBCForInvalidScheme(r3, r4)
        L_0x0062:
            com.baidu.searchbox.feed.log.IFeedLogger r0 = com.baidu.searchbox.feed.log.OnLineLog.get(r0)
            java.lang.String r3 = "FeedCommonPayDispatcher Uri action is unknown"
            r0.d(r3)
            r0 = 302(0x12e, float:4.23E-43)
            org.json.JSONObject r0 = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.wrapCallbackParams(r0)
            r10.result = r0
            return r1
        L_0x0074:
            boolean r3 = r10.isOnlyVerify()
            r4 = 1
            if (r3 == 0) goto L_0x007c
            return r4
        L_0x007c:
            java.util.HashMap r3 = r10.getParams()
            com.baidu.searchbox.feed.log.IFeedLogger r0 = com.baidu.searchbox.feed.log.OnLineLog.get(r0)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "FeedCommonPayDispatcher param = "
            java.lang.StringBuilder r5 = r5.append(r6)
            if (r3 == 0) goto L_0x0096
            java.lang.String r6 = r3.toString()
            goto L_0x0099
        L_0x0096:
            java.lang.String r6 = "null"
        L_0x0099:
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            r0.d(r5)
            if (r3 == 0) goto L_0x00b0
            java.lang.String r0 = "params"
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x00b1
        L_0x00b0:
            r0 = 0
        L_0x00b1:
            org.json.JSONObject r5 = com.baidu.android.util.io.JSONUtils.parseString(r0)
            r6 = -1
            int r7 = r2.hashCode()
            switch(r7) {
                case 110760: goto L_0x00c9;
                case 514841930: goto L_0x00be;
                default: goto L_0x00bd;
            }
        L_0x00bd:
            goto L_0x00d3
        L_0x00be:
            java.lang.String r1 = "subscribe"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x00bd
            r1 = r4
            goto L_0x00d4
        L_0x00c9:
            java.lang.String r7 = "pay"
            boolean r7 = r2.equals(r7)
            if (r7 == 0) goto L_0x00bd
            goto L_0x00d4
        L_0x00d3:
            r1 = r6
        L_0x00d4:
            switch(r1) {
                case 0: goto L_0x00dc;
                case 1: goto L_0x00d8;
                default: goto L_0x00d7;
            }
        L_0x00d7:
            goto L_0x00e0
        L_0x00d8:
            r8.handleActionSubscribe(r9, r10, r11, r5)
            goto L_0x00e0
        L_0x00dc:
            r8.handleActionPay(r9, r10, r11, r5)
        L_0x00e0:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.core.UnitedSchemeFeedCommonPayDispatcher.invoke(android.content.Context, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity, com.baidu.searchbox.unitedscheme.CallbackHandler):boolean");
    }

    private void handleActionSubscribe(Context context, UnitedSchemeEntity entity, CallbackHandler handler, JSONObject paramJson) {
        if (!(context instanceof Activity)) {
            OnLineLog.get("FeedPay").d("FeedCommonPayDispatcher context is not activity");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return;
        }
        PayInfo info = obtainSubscribePayInfoFromJson(paramJson);
        if (TextUtils.isEmpty(info.columnId)) {
            OnLineLog.get("FeedPay").d("FeedCommonPayDispatcher resId is null");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return;
        }
        PayUiFacade.INSTANCE.startSubscription(context, info);
        entity.result = UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    private PayInfo obtainSubscribePayInfoFromJson(JSONObject paramJson) {
        PayInfo info = new PayInfo();
        info.payType = PayInfo.Type.PaidSubscription;
        if (paramJson == null) {
            return info;
        }
        info.columnId = paramJson.optString("subid");
        info.psExtNid = paramJson.optString("nid");
        info.from = paramJson.optString("from", "feed");
        info.pd = paramJson.optString("pd");
        info.pdRec = paramJson.optString("pdRec");
        info.source = paramJson.optString("source");
        JSONObject extJSON = paramJson.optJSONObject("ext");
        if (extJSON != null) {
            info.ext = extJSON.optString("sExt");
        }
        return info;
    }

    private void handleActionPay(Context context, UnitedSchemeEntity entity, CallbackHandler handler, JSONObject paramJson) {
        Context context2 = context;
        UnitedSchemeEntity unitedSchemeEntity = entity;
        JSONObject jSONObject = paramJson;
        String resId = jSONObject.optString("resId");
        String freeFlag = jSONObject.optString(KEY_IS_FREE);
        String type = jSONObject.optString("type");
        JSONObject extJson = jSONObject.optJSONObject("ext");
        String str = "";
        String source = extJson != null ? extJson.optString("source") : str;
        if (extJson != null) {
            str = extJson.optString("sExt");
        }
        String serverExtInfo = str;
        String presentFlag = jSONObject.optString(KEY_IS_PRESENT);
        if (!(context2 instanceof Activity)) {
            OnLineLog.get("FeedPay").d("FeedCommonPayDispatcher context is not activity");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        } else if (TextUtils.isEmpty(resId)) {
            OnLineLog.get("FeedPay").d("FeedCommonPayDispatcher resId is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        } else {
            PayUiFacade.INSTANCE.startPayment(context2, PayInfo.with(resId, TextUtils.equals(freeFlag, "1"), source, type, serverExtInfo, TextUtils.equals(presentFlag, "1")));
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(handler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String s) {
        return null;
    }

    private boolean isActionValid(String action) {
        return TextUtils.equals(action, "pay") || TextUtils.equals(action, "subscribe");
    }
}
