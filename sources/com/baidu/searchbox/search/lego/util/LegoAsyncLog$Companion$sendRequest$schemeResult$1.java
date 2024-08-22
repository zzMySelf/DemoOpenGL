package com.baidu.searchbox.search.lego.util;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/search/lego/util/LegoAsyncLog$Companion$sendRequest$schemeResult$1", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "getCurrentPageUrl", "", "handleSchemeDispatchCallback", "", "callback", "result", "lib_search_video_page_a_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LegoAsyncLog.kt */
public final class LegoAsyncLog$Companion$sendRequest$schemeResult$1 implements CallbackHandler {
    final /* synthetic */ String $url;

    LegoAsyncLog$Companion$sendRequest$schemeResult$1(String $url2) {
        this.$url = $url2;
    }

    public void handleSchemeDispatchCallback(String callback, String result) {
        if (AppConfig.isDebug()) {
            Log.d(LegoAsyncLog.Companion.getTAG(), "handleSchemeDispatchCallback callback: " + callback);
            Log.d(LegoAsyncLog.Companion.getTAG(), "handleSchemeDispatchCallback result: " + result);
        }
    }

    public String getCurrentPageUrl() {
        return this.$url;
    }
}
