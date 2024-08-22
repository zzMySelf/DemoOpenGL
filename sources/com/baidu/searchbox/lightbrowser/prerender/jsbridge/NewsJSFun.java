package com.baidu.searchbox.lightbrowser.prerender.jsbridge;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/lightbrowser/prerender/jsbridge/NewsJSFun;", "", "()V", "PAGE_GET_PROCESS_INFO", "", "PAGE_INJECT", "PAGE_LEAVE", "lib-lightbrowser-prerender_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JsConstants.kt */
public final class NewsJSFun {
    public static final NewsJSFun INSTANCE = new NewsJSFun();
    public static final String PAGE_GET_PROCESS_INFO = "javascript:window.getPreheatSituation()";
    public static final String PAGE_INJECT = "javascript:window.newsPageInject";
    public static final String PAGE_LEAVE = "javascript:window.newsPageDeleteContent()";

    private NewsJSFun() {
    }
}
