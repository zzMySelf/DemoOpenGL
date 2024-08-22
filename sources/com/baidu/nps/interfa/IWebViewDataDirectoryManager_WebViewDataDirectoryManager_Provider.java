package com.baidu.nps.interfa;

import com.baidu.pyramid.annotation.Provider;
import com.baidu.searchbox.nps.impl.WebViewDataDirectoryManager;

public class IWebViewDataDirectoryManager_WebViewDataDirectoryManager_Provider implements Provider {
    public Object get() {
        return new WebViewDataDirectoryManager();
    }
}
