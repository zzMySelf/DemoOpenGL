package com.baidu.searchbox.noveladapter.browser;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.lightbrowser.view.LightBrowserView;

public class NovelLightBrowserViewWarpper implements NoProGuard {
    private LightBrowserView mLightBrowserView;

    public NovelLightBrowserViewWarpper(LightBrowserView browserView) {
        this.mLightBrowserView = browserView;
    }

    public LightBrowserView getLightBrowserView() {
        return this.mLightBrowserView;
    }

    public void onDestroy() {
        LightBrowserView lightBrowserView = this.mLightBrowserView;
        if (lightBrowserView != null) {
            lightBrowserView.onDestroy();
        }
    }

    public NovelLightBrowserWebViewWarpper getLightBrowserWebViewWarpper() {
        if (this.mLightBrowserView != null) {
            return new NovelLightBrowserWebViewWarpper(this.mLightBrowserView);
        }
        return null;
    }
}
