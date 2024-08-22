package com.baidu.browser.explore.mutable.feature;

import android.content.Intent;
import com.baidu.browser.explore.container.searchboxcontainer.data.UrlContainerModel;
import com.baidu.browser.framework.BeeBdWindow;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.webkit.sdk.WebResourceResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u0016J(\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/baidu/browser/explore/mutable/feature/LandingPageFeature;", "Lcom/baidu/browser/explore/mutable/feature/BaseLandingPageFeature;", "()V", "model", "Lcom/baidu/browser/explore/container/searchboxcontainer/data/UrlContainerModel;", "getModel", "()Lcom/baidu/browser/explore/container/searchboxcontainer/data/UrlContainerModel;", "setModel", "(Lcom/baidu/browser/explore/container/searchboxcontainer/data/UrlContainerModel;)V", "getQuery", "", "getReferUrl", "isSupportContainerType", "", "type", "", "onPause", "", "onResume", "intent", "Landroid/content/Intent;", "shouldBlockMediaRequest", "bdSailorWebView", "Lcom/baidu/browser/sailor/BdSailorWebView;", "interceptUrl", "curUrl", "shouldInterceptWebViewRequest", "Lcom/baidu/webkit/sdk/WebResourceResponse;", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandingPageFeature.kt */
public final class LandingPageFeature extends BaseLandingPageFeature {
    private UrlContainerModel model;

    public final UrlContainerModel getModel() {
        return this.model;
    }

    public final void setModel(UrlContainerModel urlContainerModel) {
        this.model = urlContainerModel;
    }

    public void onResume(Intent intent) {
        super.onResume(intent);
        boolean z = false;
        if (getErrorCode() == 0) {
            hideEmbeddedTitleBar(false);
            return;
        }
        BeeBdWindow window = getWindow();
        if (window != null && !window.isFullScreenMode()) {
            z = true;
        }
        if (z) {
            showEmbeddedTitleBar(true);
        }
    }

    public void onPause() {
        super.onPause();
        if (!isError()) {
            hideEmbeddedTitleBar(false);
        }
    }

    public boolean isSupportContainerType(int type) {
        return type == 16 || type == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.extra;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getQuery() {
        /*
            r3 = this;
            com.baidu.browser.explore.container.searchboxcontainer.data.UrlContainerModel r0 = r3.model
            r1 = 0
            if (r0 == 0) goto L_0x0011
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.extra
            if (r0 == 0) goto L_0x0011
            java.lang.String r2 = "query"
            java.lang.Object r0 = r0.get(r2)
            goto L_0x0012
        L_0x0011:
            r0 = r1
        L_0x0012:
            boolean r2 = r0 instanceof java.lang.String
            if (r2 == 0) goto L_0x0019
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.explore.mutable.feature.LandingPageFeature.getQuery():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.extra;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getReferUrl() {
        /*
            r3 = this;
            com.baidu.browser.explore.container.searchboxcontainer.data.UrlContainerModel r0 = r3.model
            r1 = 0
            if (r0 == 0) goto L_0x0011
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.extra
            if (r0 == 0) goto L_0x0011
            java.lang.String r2 = "refer_url"
            java.lang.Object r0 = r0.get(r2)
            goto L_0x0012
        L_0x0011:
            r0 = r1
        L_0x0012:
            boolean r2 = r0 instanceof java.lang.String
            if (r2 == 0) goto L_0x0019
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.explore.mutable.feature.LandingPageFeature.getReferUrl():java.lang.String");
    }

    public WebResourceResponse shouldInterceptWebViewRequest(BdSailorWebView bdSailorWebView, String interceptUrl, String curUrl) {
        return interceptFastAppJump(interceptUrl, curUrl, "other");
    }

    public boolean shouldBlockMediaRequest(BdSailorWebView bdSailorWebView, String interceptUrl, String curUrl) {
        return shouldInterceptFastAppJump(interceptUrl, curUrl, "media");
    }
}
