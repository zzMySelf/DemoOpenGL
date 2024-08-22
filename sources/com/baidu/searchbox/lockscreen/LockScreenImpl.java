package com.baidu.searchbox.lockscreen;

import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.lockscreen.bridge.ILockScreenInterface;
import com.baidu.searchbox.lockscreen.imagesearch.LockScreenCodeScannerActivity;
import com.baidu.searchbox.net.SearchBoxCookieManager;

public class LockScreenImpl implements ILockScreenInterface {
    public CookieManager newCookieManagerInstance(boolean needSync, boolean needSaveBduss) {
        return new SearchBoxCookieManager(needSync, needSaveBduss);
    }

    public Class getLockScreenCodeScannerActivity() {
        return LockScreenCodeScannerActivity.class;
    }
}
