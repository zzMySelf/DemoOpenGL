package com.tera.scan.flutter.plugin.caller;

import androidx.annotation.Keep;

@Keep
public interface AccountUtilsGen {
    String getBduss();

    String getCloudAvatarURL();

    String getCloudUK();

    String getDisplayName();

    int getGrowthLevel();

    String getUid();

    String getUserName();

    long getVipEndTime();

    int getVipLevel();

    boolean isAnonymous();

    boolean isLogin();

    boolean isSvipOverdueUser();

    boolean isThirdAccount();

    void logout();

    void startLoginActivity();

    long workPackageEndTime();
}
