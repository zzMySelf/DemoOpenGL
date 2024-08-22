package com.baidu.searchbox.oem;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.KeyEvent;
import com.baidu.searchbox.MainActivity;
import com.baidu.searchbox.SearchboxApplication;
import com.baidu.searchbox.SettingsCommonActivity;
import com.baidu.searchbox.UserExperienceActivity;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.buildconfig.BuildConfigManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.HostConfig;
import com.baidu.searchbox.net.SwitcherManager;
import com.baidu.searchbox.oem.bridge.IOemContext;
import com.baidu.searchbox.oem.privacy.R;
import com.baidu.searchbox.util.Utility;

public class OemContext implements IOemContext {
    private static final String OEM_NAME_SPACE = "OEMConfig";

    public int getOemTypeId() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_TYPE_ID");
    }

    public int getOemSwitchDing() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_DING");
    }

    public int getOemSwitchShortcut() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_SHORTCUT");
    }

    public int getOemSwitchBarcodeShortcut() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_BARCODE_SHORTCUT");
    }

    public int getOemSwitchBarcodeShortcut2() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_BARCODE_SHORTCUT_2");
    }

    public int getOemSwitchDisplayChannel() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_DISPLAY_CHANNEL");
    }

    public int getOemSwitchKillProcess() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_KILL_PROCESS");
    }

    public int getOemSwitchShowFlowDialog() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_SHOW_FLOW_DIALOG");
    }

    public int getOemSwitchFlowDialogDefault() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_FLOW_DIALOG_DEFAULT");
    }

    public int getOemSwitchVideoShortcut() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_VIDEO_SHORTCUT");
    }

    public int getOemSwitchNovelShortcut() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_NOVEL_SHORTCUT");
    }

    public int getOemSwitchPushMsg() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_PUSH_MSG");
    }

    public int getOemSwitchSupportMultiwindows() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_SUPPORT_MULTIWINDOWS");
    }

    public int getOemSwitchLightappShortcut() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_LIGHTAPP_SHORTCUT");
    }

    public int getOemSwitchDeleteTalosMario() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_DELETE_TALOS");
    }

    public int getOemSwitchDeleteNight() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_DELETE_NIGHT");
    }

    public int getOemSwitchDeleteOpencv() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_DELETE_OPENCV");
    }

    public int getOemSwitchBdShortcut() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_BD_SHORTCUT");
    }

    public int getOemSwitchAppsNavigation() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_APPS_NAVIGATION");
    }

    public int getOemSwitchFastSearch() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_FAST_SEARCH");
    }

    public int getOemSwitchSpeechShortcut() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_SPEECH_SHORTCUT");
    }

    public int getOemSwitchDeleteResource() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_DELETE_RESOURCE");
    }

    public int getOemSwitchPushDisableService() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_PUSH_DISABLE_SERVICE");
    }

    public int getOemSwitchPushDisableLocalserver() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_PUSH_DISABLE_LOCALSERVER");
    }

    public int getOemSwitchPushEnable() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_PUSH_ENABLE");
    }

    public int getOemSwitchMoplusEnable() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_MOPLUS_ENABLE");
    }

    public int getOemSwitchGuardEnable() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_GUARD_ENABLE");
    }

    public int getOemSwitchLifeplusShortcut() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_LIFEPLUS_SHORTCUT");
    }

    public int getOemSwitchScannerShortcut() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_SCANNER_SHORTCUT");
    }

    public int getOemSwitchWalletShow() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_WALLET_SHOW");
    }

    public int getOemSwitchGooglemarket() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_GOOGLEMARKET");
    }

    public int getOemSwitchXiaomimarket() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_XIAOMIMARKET");
    }

    public int getOemSwitchOppomarket() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_OPPOMARKET");
    }

    public int getOemSwitchInvokeEnable() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_INVOKE_ENABLE");
    }

    public int getOemSwitchFreewifiShortcut() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_FREEWIFI_SHORTCUT");
    }

    public int getOemSwitchSettingicons() {
        return BuildConfigManager.getInt(OEM_NAME_SPACE, "OEM_SWITCH_SETTINGICONS");
    }

    public String getOemChannelSoKey() {
        return SwitcherManager.OEM_CHANNEL_SO_KEY;
    }

    public String getMyWalletSwitchKey() {
        return "my_wallet_switch";
    }

    public void closeApplication(Context context) {
        Utility.closeApplication(context);
    }

    public String getMainActivityClassName() {
        return MainActivity.class.getName();
    }

    public String getUserExperienceActivityClassName() {
        return UserExperienceActivity.class.getName();
    }

    public void releaseSearchboxState() {
        BdBoxActivityManager.finishAllActivity();
    }

    public Resources getAlertDialogResources(Context context) {
        return ((SearchboxApplication) context.getApplicationContext()).getSuperResources();
    }

    public boolean isExitByClickBackTwice(Context context, KeyEvent event) {
        if (event.getAction() != 0 || !(context instanceof MainActivity)) {
            return true;
        }
        return ((MainActivity) context).exitByClickBackTwice();
    }

    public Intent getPrivacyPolicyIntent(Context context) {
        Intent intent = new Intent(AppRuntime.getAppContext(), SettingsCommonActivity.class);
        intent.putExtra("load_url", HostConfig.getUrlPrivacyPolicy());
        intent.putExtra("title", AppRuntime.getAppContext().getString(R.string.privacy_policy));
        return intent;
    }

    public Intent getServiceProtocolIntent(Context context) {
        Intent intent = new Intent(AppRuntime.getAppContext(), SettingsCommonActivity.class);
        intent.putExtra("load_url", HostConfig.getUrlServiceProtocal());
        intent.putExtra("title", AppRuntime.getAppContext().getString(R.string.service_protocol));
        return intent;
    }
}
