package com.baidu.searchbox.secondfloor.home;

import com.baidu.searchbox.http.cookie.CookieManager;

public class EmptySecondFloorImpl implements ISecondFloorIOC {
    public boolean isHolidaySkinTheme() {
        return false;
    }

    public CookieManager getCookieManager(boolean needSync, boolean needSaveBduss) {
        return null;
    }
}
