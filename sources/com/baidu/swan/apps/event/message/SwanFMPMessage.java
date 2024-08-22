package com.baidu.swan.apps.event.message;

import android.text.TextUtils;
import com.baidu.swan.apps.event.JSEventDispatcher;

public class SwanFMPMessage extends SwanAppBaseMessage {
    private final String pagePath;
    private final String webViewId;

    public SwanFMPMessage(String webViewId2, String pagePath2) {
        this.webViewId = webViewId2;
        this.pagePath = pagePath2;
        this.mEventName = "firstMeaningfulPainted";
    }

    public String genSetDataStatement(String eventVar) {
        String str = "";
        StringBuilder append = new StringBuilder().append(JSEventDispatcher.genJSVarKeyValue(eventVar, "wvID", TextUtils.isEmpty(this.webViewId) ? str : this.webViewId));
        if (!TextUtils.isEmpty(this.pagePath)) {
            str = this.pagePath;
        }
        return append.append(JSEventDispatcher.genJSVarKeyValue(eventVar, "pageUrl", str)).toString();
    }
}
