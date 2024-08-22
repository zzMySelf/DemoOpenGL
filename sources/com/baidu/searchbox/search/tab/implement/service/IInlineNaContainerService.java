package com.baidu.searchbox.search.tab.implement.service;

import android.graphics.Rect;
import com.baidu.searchbox.search.tab.core.service.IService;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J8\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0013\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/service/IInlineNaContainerService;", "Lcom/baidu/searchbox/search/tab/core/service/IService;", "addNoStatePrefetch", "", "url", "", "referer", "buildCkValue", "rcvUrl", "adWidth", "adHeight", "adX", "adY", "screenState", "dispatchScheme", "", "scheme", "handler", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "getCurrentUrl", "openUrl", "rootViewInWindow", "Landroid/graphics/Rect;", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IInlineNaContainerService.kt */
public interface IInlineNaContainerService extends IService {
    void addNoStatePrefetch(String str, String str2);

    String buildCkValue(String str, String str2, String str3, String str4, String str5, String str6);

    boolean dispatchScheme(String str, CallbackHandler callbackHandler);

    String getCurrentUrl();

    boolean openUrl(String str);

    Rect rootViewInWindow();
}
