package com.baidu.sofire.ac;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import java.util.List;

public interface DeviceInfoCallback {
    String geBssid();

    String getAndroidId();

    ApplicationInfo getApplicationInfo(String str, int i2);

    String getIccid();

    String getImei();

    String getImsi();

    List<ApplicationInfo> getInstalledApplications(int i2);

    List<PackageInfo> getInstalledPackages(int i2);

    String getMeid();

    String getOaid();

    PackageInfo getPackageInfo(String str, int i2);
}
