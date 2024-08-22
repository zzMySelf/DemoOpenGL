package com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs;

import androidx.browser.customtabs.CustomTabsClient;

public interface ServiceConnectionCallback {
    void onServiceConnected(CustomTabsClient customTabsClient);

    void onServiceDisconnected();
}
