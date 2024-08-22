package com.baidu.browser.framework.restore;

import android.content.Intent;

interface IRestore {
    void debugInfo(String str);

    boolean deleteBundleFile();

    boolean getAbSwitcher();

    String getAppVersion();

    int getNeedRestoreSwitcher();

    long getSaveBundleTime();

    boolean getSettingPageSwitcher();

    String getSystemVersion();

    int inRestoreTimeInterval();

    boolean meetAllConditions(boolean z);

    Intent restoreIntent();

    void saveAppVersion();

    void saveIntent(Intent intent);

    void saveIntent(String str, Intent intent);

    void saveSystemVersion();

    void setSaveBundleTime();

    void setSettingPageSwitcher(boolean z);
}
