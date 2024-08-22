package com.baidu.nadcore.webpanel.proxy;

import com.baidu.searchbox.lightbrowser.container.base.IFrameExtHandler;
import com.baidu.searchbox.lightbrowser.container.base.IWebViewNotifier;
import com.baidu.searchbox.nadbrowser.webpanel.NadWrappedBrowserContainer;

public class WebPanelBrowserContainer extends NadWrappedBrowserContainer {
    public WebPanelBrowserContainer(IFrameContext frameContext, IFrameExtHandler frameExtHandler, IWebViewNotifier webViewNotifier) {
        super(frameContext, frameExtHandler, webViewNotifier);
    }
}
