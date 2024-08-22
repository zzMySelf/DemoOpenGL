package com.baidu.browser.explore.jsbridge;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.browser.BrowserRuntime;
import com.baidu.browser.explore.container.SearchBoxContainer;
import com.baidu.browser.framework.BdWindowStatistic;
import com.baidu.browser.framework.BeeBdWindow;
import com.baidu.search.core.utils.SearchCommonUtils;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.common.security.JsInterfaceLogger;
import com.baidu.searchbox.voice.ImageQuery;
import com.baidu.searchbox.voice.JSQuery;

public class MMJSInterface implements NoProGuard {
    private static final boolean DEBUG = BrowserRuntime.GLOBAL_DEBUG;
    public static final String JS_NAME = "Bdbox_android_common";
    private static final String TAG = "BeeBdWindow";
    /* access modifiers changed from: private */
    public final SearchBoxContainer mContainer;
    private final JsInterfaceLogger.LogContext mLogContext;

    public MMJSInterface(SearchBoxContainer container, JsInterfaceLogger.ReusableLogContext context) {
        this.mContainer = container;
        this.mLogContext = new JsInterfaceLogger.FilterLogContext(context, "MMJSInterface");
    }

    @JavascriptInterface
    public synchronized void setQuery(final String option) {
        new JsInterfaceLogger(this.mLogContext).setFun("setQuery").setArgs(option).log();
        if (DEBUG) {
            Log.d("BeeBdWindow", "set query:" + option);
        }
        if (!TextUtils.isEmpty(option)) {
            UiThreadUtil.getMainHandler().postAtFrontOfQueue(new Runnable() {
                public void run() {
                    BeeBdWindow window = MMJSInterface.this.mContainer.getWindow();
                    if (window != null) {
                        JSQuery jsQuery = JSQuery.parseString(option);
                        BdWindowStatistic mStatistic = window.getWindowStatistic();
                        if (jsQuery == null) {
                            return;
                        }
                        if (jsQuery.isVoice()) {
                            window.setQueryInBox(jsQuery.getQuery(), !TextUtils.equals(MMJSInterface.this.mContainer.getSearchBox().getCurrentQuery(), jsQuery.getQuery()), MMJSInterface.this.mContainer.getContainerId());
                        } else if (jsQuery.isPic()) {
                            mStatistic.onEvent("83", SearchCommonUtils.generateJsonString("type", "img"));
                            window.setQueryImageAndTextInBox(jsQuery.getQuery(), "", "", false);
                        } else if (jsQuery.isPicAndText()) {
                            mStatistic.onEvent("83", SearchCommonUtils.generateJsonString("type", "imgText"));
                            ImageQuery imageQuery = ImageQuery.parseString(jsQuery.getQuery());
                            window.setQueryImageAndTextInBox(imageQuery.getImg(), imageQuery.getQueryText(), imageQuery.getTipText(), true);
                        }
                    }
                }
            });
        }
    }
}
