package com.baidu.swan.card.render.jscontainer.interfaces;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.card.render.jscontainer.interfaces.ISwanAppWebView;

public interface ISwanAppConsoleManager<T extends ISwanAppWebView> extends ISwanAppWebViewManager<T> {
    public static final String CONSOLE_ID = "console";

    void addToParent(ViewGroup viewGroup);

    void printLogToSConsole(String str, String str2);

    void releaseConsole();

    void setConsoleButton(View view2);

    void setConsoleVisible(boolean z);

    void toggleConsoleVisibility();
}
