package com.baidu.megapp.plug;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import java.util.List;

public interface TargetMapping {
    ActivityInfo getActivityInfo(String str);

    String getApplicationClassName();

    String getDefaultActivityName();

    List<String> getExportedAbility();

    Bundle getMetaData();

    PackageInfo getPackageInfo();

    PackageInfo getPackageInfo(int i2);

    String getPackageName();

    PermissionInfo[] getPermissions();

    List<ProviderInfo> getProviderInfoList();

    ServiceInfo getServiceInfo(String str);

    int getTheme();

    int getThemeResource(String str);

    int getVersionCode();

    String getVersionName();

    boolean initSuccess();

    void setApplicationInfoDataDir(String str);
}
