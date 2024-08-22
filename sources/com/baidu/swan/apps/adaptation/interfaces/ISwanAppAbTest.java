package com.baidu.swan.apps.adaptation.interfaces;

import org.json.JSONObject;

public interface ISwanAppAbTest {
    void forceReloadConfig();

    JSONObject getAllAbSwitch();

    String getAllAbTest();

    String getExpInfos();

    boolean getHttpsProtocolSwitch();

    boolean getPortCheckAbTestSwitch();

    JSONObject getRawSwitch();

    long getRecordFcpSwitch();

    boolean getServerDomainsCheckAbTestSwitch();

    int getSilentUpdateStrategyPms();

    int getSwanAppNavigateMaxValue();

    double getSwitch(String str, double d2);

    int getSwitch(String str, int i2);

    long getSwitch(String str, long j2);

    Object getSwitch(String str);

    String getSwitch(String str, String str2);

    boolean getSwitch(String str, boolean z);

    int getUbcReportLogSize();

    boolean getWebDomainsAbTestSwitch();

    boolean getWebViewIFrameCheckSwitch();

    boolean isExtensionJsHotApplyEnable();

    boolean isInlinePlayerSameProcess();

    boolean isPreCacheSystemInfoSwitchOn();

    boolean isPreloadUbcSwitchOn();

    boolean isProtectWebViewSwitchOn();

    boolean isSystemInfoCacheSwitchOn();

    boolean isUnitedLowEndV2On();

    boolean isUploadJsSwitchOn();

    boolean isV8MasterSwitchOn();

    boolean isV8StabilitySwitchOn();
}
