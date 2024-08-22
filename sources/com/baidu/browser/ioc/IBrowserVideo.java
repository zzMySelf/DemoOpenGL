package com.baidu.browser.ioc;

import android.content.Context;
import com.baidu.browser.BrowserInfo;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.searchbox.player.BDVideoPlayer;

public interface IBrowserVideo {
    void addCapiVideoJSInterface(NgWebView ngWebView, Context context);

    void addVideoComponentsForWebView(BdSailorWebView bdSailorWebView, BrowserInfo browserInfo);

    void clearSearchPlayerCache();

    void createVideoShortcut(Context context, String str);

    String getConstantPrefVideoSearchHintKey();

    String getConstantPrefVideoSearchSchemeKey();

    String getConstantPrefVideoSearchSwitchBoxKey();

    String getConstantPrefVideoSearchSwitchButtonKey();

    String getConstantPrefVideoSearchTabsKey();

    BDVideoPlayer playLocalVideoDirectly(Context context, String str, String str2);

    void removeCapiVideoJSInterface(NgWebView ngWebView);

    boolean videoPluginHandledKeyDown(int i2);
}
