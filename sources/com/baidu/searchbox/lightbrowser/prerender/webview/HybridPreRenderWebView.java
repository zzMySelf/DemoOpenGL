package com.baidu.searchbox.lightbrowser.prerender.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import com.baidu.browser.sailor.BdSailorWebSettings;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.lightbrowser.prerender.abtest.PreRenderAbtestManager;
import com.baidu.searchbox.lightbrowser.prerender.base.IRenderData;
import com.baidu.searchbox.lightbrowser.prerender.base.PreRenderWebView;
import com.baidu.searchbox.lightbrowser.prerender.data.HybridRenderData;
import com.baidu.searchbox.lightbrowser.prerender.ioc.IPreRenderContext;
import com.baidu.searchbox.lightbrowser.prerender.jsbridge.NewsJSFun;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bJ\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u0013\u001a\u00020\nJ\b\u0010\u0014\u001a\u00020\nH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/lightbrowser/prerender/webview/HybridPreRenderWebView;", "Lcom/baidu/searchbox/lightbrowser/prerender/base/PreRenderWebView;", "()V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "performanceRecorder", "", "", "allowWebViewFileAccess", "", "consumeAble", "", "getTplPkgVer", "getTplVer", "onInit", "onPageReady", "recordFEProcessInfo", "jsonStr", "recordStartInfo", "recycle", "lib-lightbrowser-prerender_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HybridPreRenderWebView.kt */
public final class HybridPreRenderWebView extends PreRenderWebView {
    private final Map<String, String> performanceRecorder = new LinkedHashMap();

    public HybridPreRenderWebView() {
        super((Context) null, (AttributeSet) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HybridPreRenderWebView(Context context) {
        super(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void onInit() {
        super.onInit();
        allowWebViewFileAccess();
        IPreRenderContext.Impl.get().initCodeCache(getSettings());
        setMaxUseCount(PreRenderAbtestManager.getPreHeatTplMaxUsageValue());
    }

    public final void allowWebViewFileAccess() {
        BdSailorWebSettings settings = getSettings();
        if (settings != null) {
            settings.setAllowFileAccess(true);
        }
    }

    public void onPageReady() {
        super.onPageReady();
        this.performanceRecorder.put("6", String.valueOf(System.currentTimeMillis()));
    }

    public boolean consumeAble() {
        if (URLUtil.isValidUrl(getUrl()) && !isInUse() && isPageReady() && !isContaminated()) {
            return true;
        }
        return false;
    }

    public void recycle() {
        super.recycle();
        setInUse(false);
        PreRenderWebView.loadJavaScript$default(this, NewsJSFun.PAGE_LEAVE, (ValueCallback) null, 2, (Object) null);
    }

    public final String getTplVer() {
        String tplVer;
        IRenderData curRenderData = getCurRenderData();
        HybridRenderData hybridRenderData = curRenderData instanceof HybridRenderData ? (HybridRenderData) curRenderData : null;
        return (hybridRenderData == null || (tplVer = hybridRenderData.getTplVer()) == null) ? "" : tplVer;
    }

    public final String getTplPkgVer() {
        String tplPkgVer;
        IRenderData curRenderData = getCurRenderData();
        HybridRenderData hybridRenderData = curRenderData instanceof HybridRenderData ? (HybridRenderData) curRenderData : null;
        return (hybridRenderData == null || (tplPkgVer = hybridRenderData.getTplPkgVer()) == null) ? "" : tplPkgVer;
    }

    public final void recordStartInfo() {
        this.performanceRecorder.clear();
        this.performanceRecorder.put("0", String.valueOf(System.currentTimeMillis()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003b A[Catch:{ Exception -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003c A[Catch:{ Exception -> 0x0052 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void recordFEProcessInfo(java.lang.String r9) {
        /*
            r8 = this;
            r0 = r9
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0010
            int r0 = r0.length()
            if (r0 != 0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            if (r0 == 0) goto L_0x0014
            return
        L_0x0014:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0052 }
            r0.<init>(r9)     // Catch:{ Exception -> 0x0052 }
            java.util.Iterator r3 = r0.keys()     // Catch:{ Exception -> 0x0052 }
        L_0x001e:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x0052 }
            if (r4 == 0) goto L_0x0056
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x0052 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0052 }
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x0052 }
            if (r5 == 0) goto L_0x0038
            int r5 = r5.length()     // Catch:{ Exception -> 0x0052 }
            if (r5 != 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r5 = r1
            goto L_0x0039
        L_0x0038:
            r5 = r2
        L_0x0039:
            if (r5 == 0) goto L_0x003c
            goto L_0x001e
        L_0x003c:
            java.util.Map<java.lang.String, java.lang.String> r5 = r8.performanceRecorder     // Catch:{ Exception -> 0x0052 }
            java.lang.String r6 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r6 = r0.optString(r4)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r7 = "json.optString(key)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ Exception -> 0x0052 }
            r5.put(r4, r6)     // Catch:{ Exception -> 0x0052 }
            goto L_0x001e
        L_0x0052:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0056:
            java.util.Map<java.lang.String, java.lang.String> r0 = r8.performanceRecorder
            java.lang.String r3 = "6"
            java.lang.Object r0 = r0.get(r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0068
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0069
        L_0x0068:
            r1 = r2
        L_0x0069:
            if (r1 != 0) goto L_0x009a
            java.util.Map<java.lang.String, java.lang.String> r0 = r8.performanceRecorder
            java.lang.String r1 = r8.getTplPkgVer()
            java.lang.String r2 = "tplpkg_version"
            r0.put(r2, r1)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            java.util.Map<java.lang.String, java.lang.String> r2 = r8.performanceRecorder
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "ext"
            r1.put(r3, r2)
            com.baidu.pyramid.runtime.service.ServiceReference r1 = com.baidu.ubc.UBCManager.SERVICE_REFERENCE
            java.lang.Object r1 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r1)
            com.baidu.ubc.UBCManager r1 = (com.baidu.ubc.UBCManager) r1
            r2 = r0
            java.util.Map r2 = (java.util.Map) r2
            java.lang.String r3 = "4109"
            r1.onEvent((java.lang.String) r3, (java.util.Map<java.lang.String, java.lang.String>) r2)
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.lightbrowser.prerender.webview.HybridPreRenderWebView.recordFEProcessInfo(java.lang.String):void");
    }
}
