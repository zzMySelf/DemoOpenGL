package com.baidu.swan.webcompat.ioc;

import com.baidu.pyramid.annotation.Provider;
import com.baidu.swan.webcompat.impl.WebCompatImpl;

public class IWebCompat_IWebCompat$Ioc_Provider implements Provider {
    public Object get() {
        return new WebCompatImpl();
    }
}
