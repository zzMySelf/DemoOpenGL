package com.baidu.searchbox.ioc;

import android.content.Intent;
import com.baidu.searchbox.feed.ad.AdUtil;
import com.baidu.searchbox.ng.browser.inject.IWebViewAdUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/ioc/WebViewAdUtilsImpl;", "Lcom/baidu/searchbox/ng/browser/inject/IWebViewAdUtils;", "()V", "isAd", "", "intent", "Landroid/content/Intent;", "lib-ad-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebViewAdUtilsImpl.kt */
public final class WebViewAdUtilsImpl implements IWebViewAdUtils {
    public boolean isAd(Intent intent) {
        return AdUtil.isAd(intent);
    }
}
