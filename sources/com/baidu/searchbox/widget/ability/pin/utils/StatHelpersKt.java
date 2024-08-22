package com.baidu.searchbox.widget.ability.pin.utils;

import android.os.Build;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.widget.ability.config.WidgeAddNewGuideConfigKt;
import com.baidu.searchbox.widget.ability.pin.WidgetPinResponse;
import com.baidu.searchbox.widget.ability.pin.a.AbilityChecker;
import com.baidu.searchbox.widget.pin.InvokeType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0000\u001a\f\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0002\u001a\f\u0010\u001c\u001a\u00020\u001a*\u00020\u001bH\u0002\u001a\u0014\u0010\u001d\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u0012\u0010 \u001a\u00020\u001a*\u00020\u001b2\u0006\u0010!\u001a\u00020\"\u001a\f\u0010#\u001a\u00020\u001a*\u00020\u001bH\u0002\u001a\f\u0010$\u001a\u00020\u001a*\u00020\u001bH\u0000\u001a\u0014\u0010%\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"KEY_ABILITY_DEVICE_RULE", "", "KEY_ABILITY_LIB_LOADED", "KEY_ABILITY_USER_PORTRAIT", "KEY_ABILITY_VERSION", "KEY_DEVICE_MANUFACTURER", "KEY_DEVICE_MIUI_SHORTCUT_PERM", "KEY_DEVICE_MODEL", "KEY_DEVICE_OEM_VER", "KEY_DEVICE_PRODUCT", "KEY_DEVICE_SDK_INT", "KEY_LAUNCHER_ACTIVITY", "KEY_LAUNCHER_PACKAGE", "KEY_LAUNCHER_VERSION_CODE", "KEY_LAUNCHER_VERSION_NAME", "KEY_MIUI_PERM_PAGE_CANCEL", "KEY_MIUI_PERM_PAGE_SHOW", "KEY_MIUI_PERM_PAGE_START_SETTINGS", "KEY_NEW_SILENT_PIN", "KEY_OEM_HARMONY_OS_VER", "KEY_TALOS_GUIDE_TYPE", "KEY_WIDGET_PIN_ERROR_CODE", "getSilentPinStatConfig", "", "", "putAbilityCheckerExtras", "", "Lcom/baidu/searchbox/widget/ability/pin/WidgetPinResponse;", "putDeviceInfoExtras", "putErrorCodeExtra", "code", "", "putGuideTypeExtra", "invokeType", "Lcom/baidu/searchbox/widget/pin/InvokeType;", "putLauncherInfoExtras", "putPinFailureExtras", "putPinSuccessExtras", "lib-widget-ability-impl_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: StatHelpers.kt */
public final class StatHelpersKt {
    private static final String KEY_ABILITY_DEVICE_RULE = "ability_device_rule";
    private static final String KEY_ABILITY_LIB_LOADED = "ability_lib_loaded";
    private static final String KEY_ABILITY_USER_PORTRAIT = "ability_user_portrait";
    private static final String KEY_ABILITY_VERSION = "ability_version";
    private static final String KEY_DEVICE_MANUFACTURER = "device_manu";
    private static final String KEY_DEVICE_MIUI_SHORTCUT_PERM = "device_m_sc";
    private static final String KEY_DEVICE_MODEL = "device_model";
    private static final String KEY_DEVICE_OEM_VER = "device_oem_ver";
    private static final String KEY_DEVICE_PRODUCT = "device_product";
    private static final String KEY_DEVICE_SDK_INT = "device_sdk_int";
    private static final String KEY_LAUNCHER_ACTIVITY = "launcher_act";
    private static final String KEY_LAUNCHER_PACKAGE = "launcher_pkg";
    private static final String KEY_LAUNCHER_VERSION_CODE = "launcher_vc";
    private static final String KEY_LAUNCHER_VERSION_NAME = "launcher_vn";
    public static final String KEY_MIUI_PERM_PAGE_CANCEL = "miui_perm_page_cancel";
    public static final String KEY_MIUI_PERM_PAGE_SHOW = "miui_perm_page_show";
    public static final String KEY_MIUI_PERM_PAGE_START_SETTINGS = "miui_perm_page_start_settings";
    private static final String KEY_NEW_SILENT_PIN = "pin_by_silent";
    private static final String KEY_OEM_HARMONY_OS_VER = "device_oem_hm_ver";
    private static final String KEY_TALOS_GUIDE_TYPE = "guidetype";
    public static final String KEY_WIDGET_PIN_ERROR_CODE = "pin_error_code";

    public static final void putPinSuccessExtras(WidgetPinResponse $this$putPinSuccessExtras, InvokeType invokeType) {
        Intrinsics.checkNotNullParameter($this$putPinSuccessExtras, "<this>");
        Intrinsics.checkNotNullParameter(invokeType, "invokeType");
        $this$putPinSuccessExtras.putExtra(KEY_NEW_SILENT_PIN, $this$putPinSuccessExtras.getPinBySilent() ? "1" : "0");
        putGuideTypeExtra($this$putPinSuccessExtras, invokeType);
        putLauncherInfoExtras($this$putPinSuccessExtras);
        putDeviceInfoExtras($this$putPinSuccessExtras);
        putAbilityCheckerExtras($this$putPinSuccessExtras);
    }

    public static final void putPinFailureExtras(WidgetPinResponse $this$putPinFailureExtras) {
        Intrinsics.checkNotNullParameter($this$putPinFailureExtras, "<this>");
        $this$putPinFailureExtras.putExtra(KEY_NEW_SILENT_PIN, $this$putPinFailureExtras.getPinBySilent() ? "1" : "0");
        putErrorCodeExtra($this$putPinFailureExtras, $this$putPinFailureExtras.getStatusCode());
        putLauncherInfoExtras($this$putPinFailureExtras);
        putDeviceInfoExtras($this$putPinFailureExtras);
        putAbilityCheckerExtras($this$putPinFailureExtras);
    }

    public static final void putErrorCodeExtra(WidgetPinResponse $this$putErrorCodeExtra, int code) {
        Intrinsics.checkNotNullParameter($this$putErrorCodeExtra, "<this>");
        $this$putErrorCodeExtra.putExtra(KEY_WIDGET_PIN_ERROR_CODE, Integer.valueOf(code));
    }

    private static final void putAbilityCheckerExtras(WidgetPinResponse $this$putAbilityCheckerExtras) {
        String str;
        String str2 = "1";
        $this$putAbilityCheckerExtras.putExtra(KEY_ABILITY_DEVICE_RULE, AbilityChecker.INSTANCE.checkDeviceRule$lib_widget_ability_impl_release() ? str2 : "0");
        if (AbilityChecker.INSTANCE.checkAbilityVersion$lib_widget_ability_impl_release()) {
            str = str2;
        } else {
            str = "0";
        }
        $this$putAbilityCheckerExtras.putExtra(KEY_ABILITY_VERSION, str);
        if (!AbilityChecker.INSTANCE.checkLibLoaded$lib_widget_ability_impl_release()) {
            str2 = "0";
        }
        $this$putAbilityCheckerExtras.putExtra(KEY_ABILITY_LIB_LOADED, str2);
    }

    private static final void putLauncherInfoExtras(WidgetPinResponse $this$putLauncherInfoExtras) {
        $this$putLauncherInfoExtras.putExtra(KEY_LAUNCHER_PACKAGE, LauncherHelpersKt.getLauncherInfo().getPackageName());
        $this$putLauncherInfoExtras.putExtra(KEY_LAUNCHER_ACTIVITY, LauncherHelpersKt.getLauncherInfo().getActivityName());
        $this$putLauncherInfoExtras.putExtra(KEY_LAUNCHER_VERSION_NAME, LauncherHelpersKt.getLauncherInfo().getVersionName());
        $this$putLauncherInfoExtras.putExtra(KEY_LAUNCHER_VERSION_CODE, Long.valueOf(LauncherHelpersKt.getLauncherInfo().getVersionCode()));
    }

    public static final void putGuideTypeExtra(WidgetPinResponse $this$putGuideTypeExtra, InvokeType invokeType) {
        Intrinsics.checkNotNullParameter($this$putGuideTypeExtra, "<this>");
        Intrinsics.checkNotNullParameter(invokeType, "invokeType");
        String guideType = WidgeAddNewGuideConfigKt.getNewSilentGuideTypeExt(invokeType);
        CharSequence charSequence = guideType;
        if (!(charSequence == null || charSequence.length() == 0)) {
            $this$putGuideTypeExtra.putExtra("guidetype", guideType);
        }
    }

    private static final void putDeviceInfoExtras(WidgetPinResponse $this$putDeviceInfoExtras) {
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
        $this$putDeviceInfoExtras.putExtra(KEY_DEVICE_MANUFACTURER, str);
        String str2 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str2, "MODEL");
        $this$putDeviceInfoExtras.putExtra(KEY_DEVICE_MODEL, str2);
        String str3 = Build.PRODUCT;
        Intrinsics.checkNotNullExpressionValue(str3, "PRODUCT");
        $this$putDeviceInfoExtras.putExtra(KEY_DEVICE_PRODUCT, str3);
        $this$putDeviceInfoExtras.putExtra(KEY_DEVICE_SDK_INT, Integer.valueOf(Build.VERSION.SDK_INT));
        $this$putDeviceInfoExtras.putExtra(KEY_DEVICE_OEM_VER, DeviceHelpersKt.getOemVersion());
        if (DeviceUtils.isHarmonyOS(AppRuntime.getAppContext())) {
            String harmonyVersion = DeviceUtils.getHarmonyVersion();
            Intrinsics.checkNotNullExpressionValue(harmonyVersion, "getHarmonyVersion()");
            $this$putDeviceInfoExtras.putExtra(KEY_OEM_HARMONY_OS_VER, harmonyVersion);
        }
        if (DeviceHelpersKt.isMiuiCompat()) {
            $this$putDeviceInfoExtras.putExtra(KEY_DEVICE_MIUI_SHORTCUT_PERM, Integer.valueOf(PermissionHelpersKt.checkOpPermission(10017)));
        }
    }

    public static final Map<String, Object> getSilentPinStatConfig() {
        WidgetPinResponse widgetPinResponse = new WidgetPinResponse();
        WidgetPinResponse $this$getSilentPinStatConfig_u24lambda_u2d0 = widgetPinResponse;
        putLauncherInfoExtras($this$getSilentPinStatConfig_u24lambda_u2d0);
        putDeviceInfoExtras($this$getSilentPinStatConfig_u24lambda_u2d0);
        putAbilityCheckerExtras($this$getSilentPinStatConfig_u24lambda_u2d0);
        return widgetPinResponse.dumpExtras();
    }
}
