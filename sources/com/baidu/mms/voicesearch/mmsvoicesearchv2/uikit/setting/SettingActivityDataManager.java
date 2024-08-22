package com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.setting;

import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\u0011R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\u0011R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\u0011¨\u0006&"}, d2 = {"Lcom/baidu/mms/voicesearch/mmsvoicesearchv2/uikit/setting/SettingActivityDataManager;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "anchorId", "", "getAnchorId", "()I", "setAnchorId", "(I)V", "content", "getContent", "setContent", "(Ljava/lang/String;)V", "needShowBroadcastToast", "", "getNeedShowBroadcastToast", "()Z", "setNeedShowBroadcastToast", "(Z)V", "referer", "getReferer", "setReferer", "toastText", "getToastText", "setToastText", "type", "getType", "setType", "clear", "", "setData", "dataJson", "Lorg/json/JSONObject;", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SettingActivityDataManager.kt */
public final class SettingActivityDataManager {
    public static final SettingActivityDataManager INSTANCE = new SettingActivityDataManager();
    private static final String TAG = SettingActivityDataManager.class.getSimpleName();
    private static int anchorId;
    private static String content = "";
    private static boolean needShowBroadcastToast;
    private static String referer = "";
    private static String toastText = "";
    private static String type = "0";

    private SettingActivityDataManager() {
    }

    public final String getTAG() {
        return TAG;
    }

    public final String getType() {
        return type;
    }

    public final void setType(String str) {
        type = str;
    }

    public final String getReferer() {
        return referer;
    }

    public final void setReferer(String str) {
        referer = str;
    }

    public final String getContent() {
        return content;
    }

    public final void setContent(String str) {
        content = str;
    }

    public final int getAnchorId() {
        return anchorId;
    }

    public final void setAnchorId(int i2) {
        anchorId = i2;
    }

    public final String getToastText() {
        return toastText;
    }

    public final void setToastText(String str) {
        toastText = str;
    }

    public final boolean getNeedShowBroadcastToast() {
        return needShowBroadcastToast;
    }

    public final void setNeedShowBroadcastToast(boolean z) {
        needShowBroadcastToast = z;
    }

    public final void setData(JSONObject dataJson) {
        if (dataJson != null) {
            type = dataJson.optString("type", "0");
            referer = dataJson.optString("referer", "");
            content = dataJson.optString(SettingActivityDataManagerKt.SETTING_ACTIVITY_CONTENT_KEY, "");
            anchorId = dataJson.optInt("anchor", 0);
            toastText = dataJson.optString("toast", "");
        }
    }

    public final void clear() {
        type = "0";
        referer = "";
        content = "";
        anchorId = 0;
        toastText = "";
    }
}
