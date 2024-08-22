package com.baidu.wallet.lightapp.multipage;

import android.app.Activity;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;

public interface d {
    void backPressed();

    void closeTopWebview();

    void closeWindow();

    boolean controlCloseIcon(LightappBrowserWebView lightappBrowserWebView);

    boolean createLangbridgeCell(String str, boolean z, boolean z2, String str2);

    Activity getControllerActivity();

    long getLangbridgeHash();

    String getLangbridgeStamp();

    int getLangbridgeStatus();

    Activity getNextActivity();

    String getOwnerTag();

    void historyGo(int i2);

    boolean isActiveCell(c cVar);

    boolean isBottomCell(c cVar);

    void setLangbridgeStamp(String str);

    void setRnAuthResult(int i2, String str);
}
