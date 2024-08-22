package com.baidu.sapi2.booster;

import android.webkit.WebView;
import com.baidu.sapi2.booster.SapiUtil;

public class SapiCallBacks {
    public static final String TAG = "SapiCallBacks";

    public static class CallBacks {
        public EvalJavaScript evalJavaScript;
    }

    public interface EvalJavaScript {
        void postResult(WebView webView, String str, SapiUtil.Command command);
    }
}
