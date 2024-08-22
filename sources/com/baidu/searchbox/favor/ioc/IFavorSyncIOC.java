package com.baidu.searchbox.favor.ioc;

import com.baidu.searchbox.favor.data.event.FavorDispatchEvent;
import com.baidu.searchbox.http.cookie.CookieManager;

public interface IFavorSyncIOC {
    void dispatchFavorEvent(FavorDispatchEvent favorDispatchEvent);

    boolean enableSyncRequest();

    CookieManager getCookieManager();

    void syncLastTime(String str, boolean z);
}
