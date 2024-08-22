package com.baidu.searchbox.items.extrafunc;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.RecommendSettingsActivity;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.lockscreen.util.LockScreenPreferenceUtils;
import com.baidu.searchbox.settings.ioc.ISettingsApp;
import com.baidu.searchbox.widget.newpreference.model.SettingItemModel;
import com.baidu.searchbox.widget.preference.PreferenceManager;
import com.baidu.ubc.UBC;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\"\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bJ\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0017\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u000eJ\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nJ\"\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\b¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/items/extrafunc/ExtraFunc;", "", "()V", "getAutoSkinSettingItem", "Lcom/baidu/searchbox/widget/newpreference/model/SettingItemModel;", "context", "Landroid/content/Context;", "getBooleanPreferenceInDefaultSP", "", "key", "", "defaultValue", "getFreeSearchSettingItem", "getLocationPermissionMgrSettingItem", "getLocationPermissionMgrSettingItem$lib_settings_impl_release", "getLockSettingItem", "getOpenUrlSettingItem", "getPluginCenterSettingItem", "getRecommendSettingItem", "getTranslationSettingItem", "getVideoSnifferSettingItem", "getWealthVideoTaskFloatSettingItem", "isShowLockScreen", "isShowOpenUrl", "isShowRecommend", "onExtraFuncPreferenceClickUBC", "", "value", "type", "setBooleanPreferenceInDefaultSP", "Companion", "lib-settings-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExtraFunc.kt */
public final class ExtraFunc {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_FUNC_UBC_FROM = "tool";
    private static final String EXTRA_FUNC_UBC_TYPE_CLOSE = "close";
    private static final String EXTRA_FUNC_UBC_TYPE_ENTER = "enter";
    private static final String EXTRA_FUNC_UBC_TYPE_OPEN = "open";
    private static final String FROM_CHANGE_HOLIDAY_AUTO_SKIN_SETTINGS = "holiday_autoskin";
    private static final String FROM_CHANGE_VIDEO_SNIFFER_SETTINGS = "video_sniffer";
    private static final String FROM_LOCKSCREEN_SETTINGS = "suoping";
    private static final String FROM_NOTIFICATION_SETTINGS = "noti_search";
    private static final String FROM_PLUGIN_CENTER_SETTINGS = "plugin_center";
    private static final String KEY_FREE_FLOW_SEARCH = "pref_key_free_search_flow";
    private static final String KEY_FREE_NOTIFICATION_FAST_OPEN = "pref_key_notification_fast_open";
    private static final String KEY_PAGE_TRANSLATION_SWITCH = "web_translate_switch";
    private static final String VALUE_FREE_FLOW_SEARCH = "search_mianliu";
    private static final String VALUE_NOTIFICATION_FAST_OPEN = "noti_open";
    private static final String VALUE_RECOMMEND_SETTINGS = "recommend_set";

    public final SettingItemModel getPluginCenterSettingItem(Context context) {
        return new ExtraFunc$getPluginCenterSettingItem$1(context, ISettingsApp.Impl.get().getPluginNewsState(), this);
    }

    public final SettingItemModel getTranslationSettingItem(Context context) {
        return new ExtraFunc$getTranslationSettingItem$1(context);
    }

    public final SettingItemModel getFreeSearchSettingItem(Context context) {
        return new ExtraFunc$getFreeSearchSettingItem$1(context, this);
    }

    public final SettingItemModel getLockSettingItem(Context context) {
        return new ExtraFunc$getLockSettingItem$1(context, this);
    }

    public final boolean isShowLockScreen() {
        return Intrinsics.areEqual((Object) "1", (Object) LockScreenPreferenceUtils.getAppDefaultString("pref_lock_screen_state", "0"));
    }

    public final SettingItemModel getOpenUrlSettingItem(Context context) {
        return new ExtraFunc$getOpenUrlSettingItem$1(context, this);
    }

    public final SettingItemModel getLocationPermissionMgrSettingItem$lib_settings_impl_release(Context context) {
        return new ExtraFunc$getLocationPermissionMgrSettingItem$1(context);
    }

    public final boolean isShowOpenUrl() {
        boolean isNotificationFastOpenAbtestAble = AbTestManager.getInstance().getSwitch("fast_open_url", true);
        boolean isNotificationFastOpenAllSwitch = ISettingsApp.Impl.get().getNotificationFastOpenURLSwitch();
        if (!isNotificationFastOpenAbtestAble || !isNotificationFastOpenAllSwitch) {
            return false;
        }
        return true;
    }

    public final SettingItemModel getAutoSkinSettingItem(Context context) {
        return new ExtraFunc$getAutoSkinSettingItem$1(context, this);
    }

    public final SettingItemModel getVideoSnifferSettingItem(Context context) {
        return new ExtraFunc$getVideoSnifferSettingItem$1(context, this);
    }

    public final SettingItemModel getRecommendSettingItem(Context context) {
        return new ExtraFunc$getRecommendSettingItem$1(context, this);
    }

    public final SettingItemModel getWealthVideoTaskFloatSettingItem(Context context) {
        return new ExtraFunc$getWealthVideoTaskFloatSettingItem$1(context);
    }

    public final boolean isShowRecommend() {
        boolean personalDisplaySettingShow = PreferenceUtils.getBoolean(RecommendSettingsActivity.KEY_SETTING_PERSONAL_DISPLAY_SETTING_SHOW, false);
        boolean personalDisplaySwitchShow = PreferenceUtils.getBoolean(RecommendSettingsActivity.KEY_SETTING_PERSONAL_DISPLAY_SWITCH_SHOW, false);
        if (personalDisplaySettingShow || personalDisplaySwitchShow) {
            return true;
        }
        return false;
    }

    public final boolean getBooleanPreferenceInDefaultSP(Context context, String key, boolean defaultValue) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(key, defaultValue);
    }

    public final void setBooleanPreferenceInDefaultSP(Context context, String key, boolean value) {
        SharedPreferences.Editor booleanEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        booleanEditor.putBoolean(key, value);
        booleanEditor.apply();
    }

    public final void onExtraFuncPreferenceClickUBC(String value, String type) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("from", "tool");
            jsonObject.put("type", type);
            jsonObject.put("value", value);
            UBC.onEvent("534", jsonObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/items/extrafunc/ExtraFunc$Companion;", "", "()V", "EXTRA_FUNC_UBC_FROM", "", "EXTRA_FUNC_UBC_TYPE_CLOSE", "EXTRA_FUNC_UBC_TYPE_ENTER", "EXTRA_FUNC_UBC_TYPE_OPEN", "FROM_CHANGE_HOLIDAY_AUTO_SKIN_SETTINGS", "FROM_CHANGE_VIDEO_SNIFFER_SETTINGS", "FROM_LOCKSCREEN_SETTINGS", "FROM_NOTIFICATION_SETTINGS", "FROM_PLUGIN_CENTER_SETTINGS", "KEY_FREE_FLOW_SEARCH", "KEY_FREE_NOTIFICATION_FAST_OPEN", "KEY_PAGE_TRANSLATION_SWITCH", "VALUE_FREE_FLOW_SEARCH", "VALUE_NOTIFICATION_FAST_OPEN", "VALUE_RECOMMEND_SETTINGS", "lib-settings-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ExtraFunc.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
