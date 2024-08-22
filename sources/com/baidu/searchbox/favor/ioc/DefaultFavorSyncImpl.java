package com.baidu.searchbox.favor.ioc;

import com.baidu.searchbox.favor.data.event.FavorDispatchEvent;
import com.baidu.searchbox.http.cookie.CookieManager;

public class DefaultFavorSyncImpl implements IFavorSyncIOC {
    public void syncLastTime(String time, boolean notify) {
    }

    public CookieManager getCookieManager() {
        return null;
    }

    public boolean enableSyncRequest() {
        return true;
    }

    public void dispatchFavorEvent(FavorDispatchEvent event) {
    }
}
