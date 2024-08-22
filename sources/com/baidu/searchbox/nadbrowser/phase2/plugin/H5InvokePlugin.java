package com.baidu.searchbox.nadbrowser.phase2.plugin;

import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.ad.lightbrowser.splash.SplashConfig;
import com.baidu.searchbox.feed.ad.scheme.NadInnerInvoker;
import com.baidu.searchbox.lightbrowser.container.LightBrowserContainer;
import com.baidu.searchbox.lightbrowser.container.presenter.ActionToolBarPresenter;
import com.baidu.searchbox.lightbrowser.container.presenter.BottomBarComponent;
import com.baidu.searchbox.nadbrowser.phase2.NadBrowserModelHelper;
import com.baidu.searchbox.schemedispatch.SchemeStatisticField;
import com.baidu.searchbox.schemedispatch.monitor.OpenAppBaseCheck;
import com.baidu.searchbox.schemedispatch.monitor.OpenAppManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0018\u00010\u0003R\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u001c\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u0014\u0010\u0002\u001a\b\u0018\u00010\u0003R\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/nadbrowser/phase2/plugin/H5InvokePlugin;", "Lcom/baidu/searchbox/nadbrowser/phase2/plugin/AbsNadPlugin;", "browserModel", "Lcom/baidu/searchbox/nadbrowser/phase2/NadBrowserModelHelper$NadBrowserModel;", "Lcom/baidu/searchbox/nadbrowser/phase2/NadBrowserModelHelper;", "container", "Lcom/baidu/searchbox/lightbrowser/container/LightBrowserContainer;", "(Lcom/baidu/searchbox/nadbrowser/phase2/NadBrowserModelHelper$NadBrowserModel;Lcom/baidu/searchbox/lightbrowser/container/LightBrowserContainer;)V", "generateStatisticFields", "Lcom/baidu/searchbox/schemedispatch/SchemeStatisticField;", "webView", "Lcom/baidu/browser/sailor/BdSailorWebView;", "notifyOverrideUrlLoading", "", "url", "", "overrideToAppMarket", "lib-ad-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: H5InvokePlugin.kt */
public final class H5InvokePlugin extends AbsNadPlugin {
    private final NadBrowserModelHelper.NadBrowserModel browserModel;
    private final LightBrowserContainer container;

    public H5InvokePlugin(NadBrowserModelHelper.NadBrowserModel browserModel2, LightBrowserContainer container2) {
        Intrinsics.checkNotNullParameter(container2, "container");
        this.browserModel = browserModel2;
        this.container = container2;
    }

    public boolean notifyOverrideUrlLoading(BdSailorWebView webView, String url) {
        NadBrowserModelHelper.PageLoadingExt pageLoadingExt;
        NadBrowserModelHelper.PageLoadingExt pageLoadingExt2;
        BottomBarComponent bottomBar;
        NadBrowserModelHelper.NadBrowserModel nadBrowserModel = this.browserModel;
        if ((nadBrowserModel != null && nadBrowserModel.isSplash()) && OpenAppBaseCheck.checkSchemeInDefault(url)) {
            return false;
        }
        NadBrowserModelHelper.NadBrowserModel nadBrowserModel2 = this.browserModel;
        if ((nadBrowserModel2 != null && nadBrowserModel2.isSplash()) && SplashConfig.getInstance().isBlockApp()) {
            return true;
        }
        if (NadInnerInvoker.INSTANCE.isMatchProtocol("browser", NadInnerInvoker.HIDE_BOTTOM_BAR, url)) {
            ActionToolBarPresenter actionToolbarPresenter = this.container.getActionToolbarPresenter();
            if (!(actionToolbarPresenter == null || (bottomBar = actionToolbarPresenter.getBottomBar()) == null)) {
                bottomBar.setVisibility(8);
            }
            return true;
        } else if (overrideToAppMarket(url, webView)) {
            return true;
        } else {
            SchemeStatisticField fields = generateStatisticFields(webView);
            NadBrowserModelHelper.NadBrowserModel nadBrowserModel3 = this.browserModel;
            String str = null;
            if (OpenAppManager.adCheckSchemeInGlobalWhiteList(url, (nadBrowserModel3 == null || (pageLoadingExt2 = nadBrowserModel3.getPageLoadingExt()) == null) ? null : pageLoadingExt2.getInvokeFlag(), fields)) {
                return false;
            }
            NadBrowserModelHelper.NadBrowserModel nadBrowserModel4 = this.browserModel;
            if (!(nadBrowserModel4 == null || (pageLoadingExt = nadBrowserModel4.getPageLoadingExt()) == null)) {
                str = pageLoadingExt.getInvokeFlag();
            }
            if (!OpenAppManager.adCheckSchemeInFeedWhiteList(url, str, fields)) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0079 A[Catch:{ Exception -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b4 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean overrideToAppMarket(java.lang.String r12, com.baidu.browser.sailor.BdSailorWebView r13) {
        /*
            r11 = this;
            com.baidu.searchbox.nadbrowser.phase2.NadBrowserModelHelper$NadBrowserModel r0 = r11.browserModel
            r1 = 0
            if (r0 == 0) goto L_0x00b9
            com.baidu.searchbox.nadbrowser.phase2.NadBrowserModelHelper$NadExt r0 = r0.getNadExt()
            if (r0 == 0) goto L_0x00b9
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r0.overrideLoadingMap
            if (r0 == 0) goto L_0x00b9
            r2 = 0
            java.lang.String r3 = "override_to_url"
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5 = 1
            if (r4 == 0) goto L_0x0028
            boolean r4 = kotlin.text.StringsKt.isBlank(r4)
            if (r4 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r4 = r1
            goto L_0x0029
        L_0x0028:
            r4 = r5
        L_0x0029:
            if (r4 == 0) goto L_0x002c
            return r1
        L_0x002c:
            java.lang.String r4 = "type"
            java.lang.Object r4 = r0.get(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String r6 = "mimarket"
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r4 = android.text.TextUtils.equals(r4, r6)
            if (r4 == 0) goto L_0x00b8
            com.baidu.searchbox.ad.download.manager.NadMiApiManager r4 = com.baidu.searchbox.ad.download.manager.NadMiApiManager.getInstance()
            boolean r4 = r4.isMiMobile()
            if (r4 != 0) goto L_0x004b
            return r1
        L_0x004b:
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r6 = "scheme_header_list"
            java.lang.Object r6 = r0.get(r6)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x00b7 }
            r4.<init>(r6)     // Catch:{ Exception -> 0x00b7 }
            r6 = 0
            int r7 = r4.length()     // Catch:{ Exception -> 0x00b7 }
        L_0x005f:
            if (r6 >= r7) goto L_0x00b8
            r8 = 0
            if (r12 == 0) goto L_0x0076
            java.lang.String r9 = r4.optString(r6)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "headerJson.optString(i)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)     // Catch:{ Exception -> 0x00b7 }
            r10 = 2
            boolean r9 = kotlin.text.StringsKt.startsWith$default(r12, r9, r1, r10, r8)     // Catch:{ Exception -> 0x00b7 }
            if (r9 != r5) goto L_0x0076
            r9 = r5
            goto L_0x0077
        L_0x0076:
            r9 = r1
        L_0x0077:
            if (r9 == 0) goto L_0x00b4
            com.baidu.searchbox.schemedispatch.SchemeStatisticField r9 = r11.generateStatisticFields(r13)     // Catch:{ Exception -> 0x00b7 }
            com.baidu.searchbox.nadbrowser.phase2.NadBrowserModelHelper$NadBrowserModel r10 = r11.browserModel     // Catch:{ Exception -> 0x00b7 }
            if (r10 == 0) goto L_0x008d
            com.baidu.searchbox.nadbrowser.phase2.NadBrowserModelHelper$PageLoadingExt r10 = r10.getPageLoadingExt()     // Catch:{ Exception -> 0x00b7 }
            if (r10 == 0) goto L_0x008d
            java.lang.String r10 = r10.getInvokeFlag()     // Catch:{ Exception -> 0x00b7 }
            goto L_0x008e
        L_0x008d:
            r10 = r8
        L_0x008e:
            boolean r10 = com.baidu.searchbox.schemedispatch.monitor.OpenAppManager.adCheckSchemeInGlobalWhiteList(r3, r10, r9)     // Catch:{ Exception -> 0x00b7 }
            if (r10 != 0) goto L_0x00aa
            com.baidu.searchbox.nadbrowser.phase2.NadBrowserModelHelper$NadBrowserModel r10 = r11.browserModel     // Catch:{ Exception -> 0x00b7 }
            if (r10 == 0) goto L_0x00a3
            com.baidu.searchbox.nadbrowser.phase2.NadBrowserModelHelper$PageLoadingExt r10 = r10.getPageLoadingExt()     // Catch:{ Exception -> 0x00b7 }
            if (r10 == 0) goto L_0x00a3
            java.lang.String r10 = r10.getInvokeFlag()     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00a4
        L_0x00a3:
            r10 = r8
        L_0x00a4:
            boolean r10 = com.baidu.searchbox.schemedispatch.monitor.OpenAppManager.adCheckSchemeInFeedWhiteList(r3, r10, r9)     // Catch:{ Exception -> 0x00b7 }
            if (r10 == 0) goto L_0x00b4
        L_0x00aa:
            if (r13 == 0) goto L_0x00b0
            android.content.Context r8 = r13.getContext()     // Catch:{ Exception -> 0x00b7 }
        L_0x00b0:
            com.baidu.searchbox.schemedispatch.monitor.OpenAppUtils.openApp(r8, r3)     // Catch:{ Exception -> 0x00b7 }
            return r5
        L_0x00b4:
            int r6 = r6 + 1
            goto L_0x005f
        L_0x00b7:
            r4 = move-exception
        L_0x00b8:
        L_0x00b9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.nadbrowser.phase2.plugin.H5InvokePlugin.overrideToAppMarket(java.lang.String, com.baidu.browser.sailor.BdSailorWebView):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r3 = r3.getPageLoadingExt();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.baidu.searchbox.schemedispatch.SchemeStatisticField generateStatisticFields(com.baidu.browser.sailor.BdSailorWebView r6) {
        /*
            r5 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r1 = 0
            java.lang.String r2 = "adnm"
            com.baidu.searchbox.nadbrowser.phase2.NadBrowserModelHelper$NadBrowserModel r3 = r5.browserModel     // Catch:{ JSONException -> 0x001d }
            if (r3 == 0) goto L_0x0018
            com.baidu.searchbox.nadbrowser.phase2.NadBrowserModelHelper$PageLoadingExt r3 = r3.getPageLoadingExt()     // Catch:{ JSONException -> 0x001d }
            if (r3 == 0) goto L_0x0018
            java.lang.String r3 = r3.getAdvertiserName()     // Catch:{ JSONException -> 0x001d }
            goto L_0x0019
        L_0x0018:
            r3 = r1
        L_0x0019:
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x001d }
            goto L_0x0021
        L_0x001d:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0021:
            com.baidu.searchbox.schemedispatch.SchemeStatisticField r2 = new com.baidu.searchbox.schemedispatch.SchemeStatisticField
            r2.<init>()
            com.baidu.searchbox.nadbrowser.phase2.NadBrowserModelHelper$NadBrowserModel r3 = r5.browserModel
            if (r3 == 0) goto L_0x002e
            java.lang.String r1 = r3.getSchemeUrl()
        L_0x002e:
            java.lang.String r3 = "pageurl"
            com.baidu.searchbox.schemedispatch.SchemeStatisticField r1 = r2.addField(r3, r1)
            java.lang.String r2 = com.baidu.searchbox.lightbrowser.utils.SchemeForbidStatisticUtils.getRefer(r6)
            java.lang.String r3 = "refer"
            com.baidu.searchbox.schemedispatch.SchemeStatisticField r1 = r1.addField(r3, r2)
            java.lang.String r2 = r0.toString()
            java.lang.String r3 = "ext"
            com.baidu.searchbox.schemedispatch.SchemeStatisticField r1 = r1.addField(r3, r2)
            com.baidu.searchbox.nadbrowser.phase2.NadBrowserModelHelper$NadBrowserModel r2 = r5.browserModel
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0058
            boolean r2 = r2.isSplash()
            if (r2 != r3) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r3 = r4
        L_0x0059:
            java.lang.String r2 = "source"
            if (r3 == 0) goto L_0x0065
            java.lang.String r3 = "splash"
            r1.addField(r2, r3)
            goto L_0x006a
        L_0x0065:
            java.lang.String r3 = "feedh5"
            r1.addField(r2, r3)
        L_0x006a:
            java.lang.String r2 = "fields"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.nadbrowser.phase2.plugin.H5InvokePlugin.generateStatisticFields(com.baidu.browser.sailor.BdSailorWebView):com.baidu.searchbox.schemedispatch.SchemeStatisticField");
    }
}
