package com.baidu.swan.apps.adaptation.webview;

import com.baidu.swan.apps.adaptation.webview.ISwanAppWebView;
import com.baidu.swan.apps.core.master.SwanAppMasterContainer;

public interface ISwanAppMasterManager<T extends ISwanAppWebView> extends ISwanAppWebViewManager<T>, SwanAppMasterContainer {
}
