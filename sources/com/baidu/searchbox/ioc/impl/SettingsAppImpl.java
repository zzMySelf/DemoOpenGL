package com.baidu.searchbox.ioc.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.browser.utils.IncognitoModeInterface;
import com.baidu.nettest.android.NetTestManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.DownloadInstallReceiver;
import com.baidu.searchbox.MainActivity;
import com.baidu.searchbox.SettingsCommonActivity;
import com.baidu.searchbox.appmanager.AppRestartController;
import com.baidu.searchbox.buildconfig.BuildConfigManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.HostConfig;
import com.baidu.searchbox.database.OEMConfiguartion;
import com.baidu.searchbox.deprecation.R;
import com.baidu.searchbox.fastopen.FastOpenManager;
import com.baidu.searchbox.hissug.data.IHistoryInterface;
import com.baidu.searchbox.hissug.pyramid.IFeedHistory;
import com.baidu.searchbox.hissug.pyramid.IPrivateMode;
import com.baidu.searchbox.home.tabs.extend.IHomeTabFun;
import com.baidu.searchbox.home.theme.IHomeThemeFun;
import com.baidu.searchbox.items.setting.SettingUbcUtils;
import com.baidu.searchbox.launch.restore.ioc.ColdLaunchRestoreSettingRuntime;
import com.baidu.searchbox.launch.restore.ioc.SystemKillSettingRuntime;
import com.baidu.searchbox.location.BoxLocationManager;
import com.baidu.searchbox.location.LocationInfo;
import com.baidu.searchbox.notrace.NoTraceInokeManager;
import com.baidu.searchbox.plugins.PluginNewsObservable;
import com.baidu.searchbox.plugins.kernels.webview.WebkitKernelPlugin;
import com.baidu.searchbox.search.pyramid.RestoreFeatureInterface;
import com.baidu.searchbox.search.pyramid.SearchAdBlockInterface;
import com.baidu.searchbox.settings.ioc.ISettingsApp;
import com.baidu.searchbox.shake.BDShakePowerManager;
import com.baidu.searchbox.update.UpdateListener;
import com.baidu.searchbox.update.WeeklyDailyChecker;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.searchbox.util.Utility;
import com.baidu.searchbox.videointerface.ISearchSnifferSwitch;
import java.io.InputStream;

public class SettingsAppImpl implements ISettingsApp {
    public boolean getHolidaySwitcherState() {
        return ((IHomeThemeFun) ServiceManager.getService(IHomeThemeFun.SERVICE_REFERENCE)).getHolidaySwitcherState();
    }

    public void clearPreferenceUbcRecord() {
        SettingUbcUtils.INSTANCE.clearUbcRecord();
    }

    public boolean getVideoSnifferSwitcherState() {
        return ((ISearchSnifferSwitch) ServiceManager.getService(ISearchSnifferSwitch.Companion.getReference())).getVideoSnifferSwitcherState();
    }

    public void setVideoSnifferSwitcherState(boolean enable) {
        ISearchSnifferSwitch snifferSwitch = (ISearchSnifferSwitch) ServiceManager.getService(ISearchSnifferSwitch.Companion.getReference());
        snifferSwitch.setVideoSnifferSwitcherState(enable);
        snifferSwitch.updateSnifferSetting();
    }

    public void setHolidaySwitcherState(boolean enable) {
        IHomeThemeFun homeThemeFun = (IHomeThemeFun) ServiceManager.getService(IHomeThemeFun.SERVICE_REFERENCE);
        homeThemeFun.setHolidaySwitcherState(enable);
        homeThemeFun.updateHolidaySwitcherState(enable);
        IHomeTabFun homeTabFun = (IHomeTabFun) ServiceManager.getService(IHomeTabFun.SERVICE_REFERENCE);
        if (homeTabFun != null) {
            homeTabFun.setTabBarThemeHolidaySwitch(enable);
        }
    }

    public boolean getPluginNewsState() {
        return PluginNewsObservable.getInstance(AppRuntime.getAppContext()).queryUpdatesCount() > 0;
    }

    public boolean getWebkitKernelPluginStatus() {
        return WebkitKernelPlugin.getInstance(AppRuntime.getAppContext()).isAvailable();
    }

    public boolean getAdsEnableStatus(Context context) {
        SearchAdBlockInterface searchAdBlockInterface = (SearchAdBlockInterface) ServiceManager.getService(SearchAdBlockInterface.SERVICE_REFERENCE);
        return searchAdBlockInterface.isEnableAds(context) && searchAdBlockInterface.isOpenAutoAds(context);
    }

    public boolean getAbSwitcherAndSettingPageSwitchStatus() {
        RestoreFeatureInterface restoreFeatureInterface = (RestoreFeatureInterface) ServiceManager.getService(RestoreFeatureInterface.SERVICE_REFERENCE);
        if (!restoreFeatureInterface.getAbSwitcher()) {
            return false;
        }
        restoreFeatureInterface.setSettingPageSwitcher(restoreFeatureInterface.getSettingPageSwitcher());
        return true;
    }

    public boolean getSettingPageSwitcher() {
        return ((RestoreFeatureInterface) ServiceManager.getService(RestoreFeatureInterface.SERVICE_REFERENCE)).getSettingPageSwitcher();
    }

    public void setSettingPageSwitcher(boolean restore) {
        ((RestoreFeatureInterface) ServiceManager.getService(RestoreFeatureInterface.SERVICE_REFERENCE)).setSettingPageSwitcher(restore);
    }

    public boolean getSettingColdLaunchRestorePageSwitch() {
        return ColdLaunchRestoreSettingRuntime.INSTANCE.getColdLaunchRestoreSetting().getLaunchRestoreSwitcherState();
    }

    public void setSettingColdLaunchRestorePageSwitch(boolean restore) {
        ColdLaunchRestoreSettingRuntime.INSTANCE.getColdLaunchRestoreSetting().setLaunchRestoreSwitcherState(restore);
    }

    public boolean isNeedShowColdLaunchRestoreSwitchItem() {
        return ColdLaunchRestoreSettingRuntime.INSTANCE.getColdLaunchRestoreSetting().isNeedShowSwitchItem();
    }

    public String getLaunchRestoreSwitcherText() {
        return ColdLaunchRestoreSettingRuntime.INSTANCE.getColdLaunchRestoreSetting().getLaunchRestoreSwitcherText();
    }

    public boolean canShowSystemKillUserSwitch() {
        return SystemKillSettingRuntime.INSTANCE.getSystemKillSettings().canShowUserSwitch();
    }

    public String getUserSystemKillSwitchText() {
        return SystemKillSettingRuntime.INSTANCE.getSystemKillSettings().getUserSwitchText();
    }

    public boolean isUserSystemKillSwitchOpen() {
        return SystemKillSettingRuntime.INSTANCE.getSystemKillSettings().isUserSwitchOpen();
    }

    public void setUserSystemKillSwitchStatus(boolean open) {
        SystemKillSettingRuntime.INSTANCE.getSystemKillSettings().setUserSwitchStatus(open);
    }

    public void recordHolidayThemeStatistic(String page, String type) {
        ((IHomeThemeFun) ServiceManager.getService(IHomeThemeFun.SERVICE_REFERENCE)).recordHolidayThemeStatistic(page, type);
    }

    public void handleFastOpenSwitch(boolean enable) {
        FastOpenManager.getInstance().saveSettingsSwitchValue(enable);
        FastOpenManager.getInstance().handleFastOpenSwitch(false);
    }

    public boolean isNetworkConnected(Context context) {
        return NetWorkUtils.isNetworkConnected();
    }

    public boolean isNeedNetSpeedTest(Context context) {
        return true;
    }

    public void netSpeedTest(Context context) {
        LocationInfo locationInfo = ((BoxLocationManager) ServiceManager.getService(BoxLocationManager.SERVICE_REFERENCE)).getLocationInfo();
        String locInfo = null;
        if (locationInfo != null) {
            locInfo = locationInfo.addressStr;
        }
        NetTestManager nm = new NetTestManager(context, BaiduIdentityManager.getInstance(AppRuntime.getAppContext()).appendParam(HostConfig.getNetTestServer(), 1), BaiduIdentityManager.getInstance(AppRuntime.getAppContext()).appendParam(HostConfig.getNetTestServer(), 1), locInfo);
        nm.setDebugEnable(AppConfig.isDebug());
        nm.run();
    }

    public void switchToTabByTag(Context context) {
        MainActivity.switchToTabByTag(context, "Personal");
    }

    public boolean getNotificationFastOpenURLSwitch() {
        return FastOpenManager.getInstance().isCloudSwitchOn();
    }

    public void pluginRetractUpdates() {
        PluginNewsObservable.getInstance(AppRuntime.getAppContext()).retractUpdates();
    }

    public boolean isSpecialVersion() {
        return Utility.isSpecialVersion();
    }

    public void exit(Context context) {
        AppRestartController.exit(context);
    }

    public String readBranchName() {
        return Utility.readBranchName();
    }

    public boolean isShowEncodeChannel(Context mContext) {
        return OEMConfiguartion.getInstance(mContext).isShowEncodeChannel();
    }

    public boolean isSwitchBeta() {
        return BuildConfigManager.getBoolean("NBSwitcher", "SWITCH_BETA");
    }

    public String readRawResource() {
        return readRawResource(BuildConfigManager.getResId("raw", "release_date"));
    }

    public static String readRawResource(int rawRes) {
        try {
            InputStream is = AppRuntime.getAppContext().getResources().openRawResource(rawRes);
            if (is == null) {
                return null;
            }
            byte[] temp = new byte[is.available()];
            if (is.read(temp) > 0) {
                return new String(temp);
            }
            return null;
        } catch (Exception e2) {
            if (!AppConfig.isDebug()) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public InputStream getHudsonVersionInputStream(Resources resources) {
        return resources.openRawResource(R.raw.hudson_build_version);
    }

    public String getEncodedChannel(Context mContext) {
        return Utility.getEncodedChannel(BaiduIdentityManager.getInstance(mContext).getTn());
    }

    public void check(Context context, UpdateListener mListener) {
        WeeklyDailyChecker.getInstance(context).check(context, mListener);
    }

    public boolean isGoogleMarket() {
        return OEMConfiguartion.getInstance(AppRuntime.getAppContext()).isGoogleMarket();
    }

    public Intent getSettingCommonAC(Context mContext, String urlValue, String titleValue) {
        Intent serviceProtoIntent = new Intent(mContext, SettingsCommonActivity.class);
        serviceProtoIntent.putExtra("load_url", urlValue);
        serviceProtoIntent.putExtra("title", titleValue);
        return serviceProtoIntent;
    }

    public String getDownloadInstallReceiverCanonicalName() {
        return DownloadInstallReceiver.class.getCanonicalName();
    }

    public boolean isHistoryPrivateMode(Context context) {
        IHistoryInterface iHistoryInterface = (IHistoryInterface) ServiceManager.getService(IHistoryInterface.Companion.getSERVICE_REFERENCE());
        if (iHistoryInterface != null) {
            return iHistoryInterface.isNoHisMode(context);
        }
        return false;
    }

    public boolean isSyncingPrivateMode() {
        IPrivateMode iPrivateMode = (IPrivateMode) ServiceManager.getService(IPrivateMode.Companion.getSERVICE_REFERENCE());
        if (iPrivateMode != null) {
            return iPrivateMode.isSyncingPrivateMode();
        }
        return false;
    }

    public boolean isIncognitoSwitchOn() {
        return ((IncognitoModeInterface) ServiceManager.getService(IncognitoModeInterface.SERVICE_REFERENCE)).isIncognitoSwitchOn();
    }

    public boolean getFeedHistory() {
        IFeedHistory iFeedHistory = (IFeedHistory) ServiceManager.getService(IFeedHistory.Companion.getSERVICE_REFERENCE());
        if (iFeedHistory != null) {
            return iFeedHistory.getFeedHistorySwitch();
        }
        return false;
    }

    public void setFeedHistory(boolean enable) {
        IFeedHistory iFeedHistory = (IFeedHistory) ServiceManager.getService(IFeedHistory.Companion.getSERVICE_REFERENCE());
        if (iFeedHistory != null) {
            iFeedHistory.setFeedHistorySwitch(enable);
        }
    }

    public boolean isOnShake() {
        return BDShakePowerManager.isOnShake();
    }

    public void setPrivateModeAsync(Context ctx, boolean privateMode) {
        IPrivateMode iPrivateMode = (IPrivateMode) ServiceManager.getService(IPrivateMode.Companion.getSERVICE_REFERENCE());
        if (iPrivateMode != null) {
            iPrivateMode.setPrivateMode(ctx, privateMode, true);
        }
    }

    public boolean isShowNoTrace() {
        return NoTraceInokeManager.isShowNoTrace(AppRuntime.getAppContext(), NoTraceInokeManager.NOTRACE_HOME_PAGE);
    }

    public boolean isMainActivity(Activity activity) {
        return activity instanceof MainActivity;
    }
}
