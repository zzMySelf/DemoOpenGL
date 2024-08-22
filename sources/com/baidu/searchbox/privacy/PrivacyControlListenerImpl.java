package com.baidu.searchbox.privacy;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.cookie.inner.Location2BaseCookie;

public class PrivacyControlListenerImpl implements IPrivacyControlListener {
    public void onPrivacySwitchToOff() {
        Location2BaseCookie.clearLocCookie(AppRuntime.getAppContext());
    }
}
