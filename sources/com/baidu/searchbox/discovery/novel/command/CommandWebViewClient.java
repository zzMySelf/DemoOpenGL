package com.baidu.searchbox.discovery.novel.command;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.lightbrowser.view.LightBrowserWebViewClient;
import com.baidu.swan.game.ad.jsbridge.BaseHtmlBridgeHandler;

public class CommandWebViewClient extends LightBrowserWebViewClient {
    private Activity mActivity;

    public CommandWebViewClient(Activity activity) {
        this.mActivity = activity;
    }

    public void onPageFinished(BdSailorWebView view2, String url) {
        super.onPageFinished(view2, url);
        String commandData = CommandParser.parseCommandData(this.mActivity, 1);
        if (!TextUtils.isEmpty(commandData)) {
            view2.loadUrl(BaseHtmlBridgeHandler.JAVASCRIPT_PREFIX + commandData);
        }
    }
}
