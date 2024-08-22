package com.baidu.searchbox.kmm.updateprocessor;

import com.baidu.searchbox.kmm.foundation.kelson.JsonObject;
import com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt;
import com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0013\u001a\u0016\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u0006\u0010\u0017\u001a\u00020\u0018\u001a&\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0014\u001a\u00020\u00012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"ACTION_SWITCH_OFF", "", "ACTION_SWITCH_ON", "LOCAL_SP_SWITCH", "LOCAL_SP_SWITCH_REASON", "NEWHOME_CONTROL_UPDATE_ACTION", "NEWHOME_CONTROL_UPDATE_MODULE", "SERVER_KEY_AB_ATTR", "SERVER_KEY_NEWHOME_FEEDTAB_ONE", "SERVER_KEY_NEWHOME_FIVETAB_ONE", "SERVER_KEY_NEWHOME_SEARCH_ONE", "SERVER_KEY_NEWHOME_SWITCH_ONE", "SERVER_KEY_NEWHOME_TABV1_HIDE", "SERVER_KEY_NEWHOME_WEATHER_COLOR_ONE", "SERVER_KEY_NEWHOME_WEATHER_ONE", "SERVER_KEY_SWITCH", "SERVER_KEY_SWITCH_REASON", "VERSION", "getUpdateKvIntFromLocal", "", "jsonKey", "default", "getUpdateKvStringFromLocal", "isUpdateNewHome", "", "setKvStringFromJSONToLocal", "", "data", "Lcom/baidu/searchbox/kmm/foundation/kelson/JsonObject;", "localKey", "com.baidu.searchbox.kmm.business.updateprocessor"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewHomeControlUpdateListener.kt */
public final class NewHomeControlUpdateListenerKt {
    private static final String ACTION_SWITCH_OFF = "0";
    private static final String ACTION_SWITCH_ON = "1";
    private static final String LOCAL_SP_SWITCH = "new_home_ctrl_switch";
    private static final String LOCAL_SP_SWITCH_REASON = "new_home_ctrl_switch_reason";
    public static final String NEWHOME_CONTROL_UPDATE_ACTION = "new_home_ctrl";
    public static final String NEWHOME_CONTROL_UPDATE_MODULE = "home";
    private static final String SERVER_KEY_AB_ATTR = "abAttr";
    private static final String SERVER_KEY_NEWHOME_FEEDTAB_ONE = "newhome_feedtab_one";
    private static final String SERVER_KEY_NEWHOME_FIVETAB_ONE = "newhome_fivetab_one";
    private static final String SERVER_KEY_NEWHOME_SEARCH_ONE = "newhome_search_one";
    private static final String SERVER_KEY_NEWHOME_SWITCH_ONE = "newhome_switch_one";
    private static final String SERVER_KEY_NEWHOME_TABV1_HIDE = "newhome_tabv1_hide";
    private static final String SERVER_KEY_NEWHOME_WEATHER_COLOR_ONE = "newhome_weather_color_one";
    private static final String SERVER_KEY_NEWHOME_WEATHER_ONE = "newhome_weather_one";
    private static final String SERVER_KEY_SWITCH = "switch";
    private static final String SERVER_KEY_SWITCH_REASON = "switchReason";
    private static final String VERSION = "new_home_ctrl_version";

    public static final boolean isUpdateNewHome() {
        return Intrinsics.areEqual((Object) QuickConfigKt.getQuickConfigString$default(LOCAL_SP_SWITCH, (String) null, 2, (Object) null), (Object) "1");
    }

    static /* synthetic */ void setKvStringFromJSONToLocal$default(JsonObject jsonObject, String str, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        setKvStringFromJSONToLocal(jsonObject, str, str2);
    }

    /* access modifiers changed from: private */
    public static final void setKvStringFromJSONToLocal(JsonObject data, String jsonKey, String localKey) {
        String value;
        if (data != null && (value = JsonUtilKt.getString(data, jsonKey, "")) != null) {
            if (localKey == null) {
                QuickConfigKt.setQuickConfigString("new_home_ctrl_" + jsonKey, value);
            } else {
                QuickConfigKt.setQuickConfigString(localKey, value);
            }
        }
    }

    public static final int getUpdateKvIntFromLocal(String jsonKey, int i2) {
        Intrinsics.checkNotNullParameter(jsonKey, "jsonKey");
        try {
            return Integer.parseInt(QuickConfigKt.getQuickConfigString("new_home_ctrl_" + jsonKey, String.valueOf(i2)));
        } catch (Exception e2) {
            return i2;
        }
    }

    public static final String getUpdateKvStringFromLocal(String jsonKey, String str) {
        Intrinsics.checkNotNullParameter(jsonKey, "jsonKey");
        Intrinsics.checkNotNullParameter(str, "default");
        try {
            return QuickConfigKt.getQuickConfigString("new_home_ctrl_" + jsonKey, str);
        } catch (Exception e2) {
            return str;
        }
    }
}
