package com.baidu.searchbox.feed.ad.scheme;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.ad.AdDeepLinkStayTime;
import com.baidu.searchbox.ad.AdH5DownloadAlsManager;
import com.baidu.searchbox.ad.exp.adconfig.ADConfigManager;
import com.baidu.searchbox.ad.util.MapUtils;
import com.baidu.searchbox.feed.ad.AdRuntimeHolder;
import com.baidu.searchbox.feed.ad.Als;
import com.baidu.searchbox.feed.ad.util.InterceptCallback;
import com.baidu.searchbox.feed.tab.model.TabController;
import com.baidu.searchbox.schemedispatch.SchemeStatisticField;
import com.baidu.searchbox.schemedispatch.forbid.InvokeStatistic;
import com.baidu.searchbox.schemedispatch.monitor.OpenAppManager;
import com.baidu.searchbox.schemedispatch.monitor.OpenAppUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.HashMap;
import org.json.JSONObject;

public class AdDeepLinkController {
    private static final String AD_DEFAULT_SCHEME = "baiduboxapp://v1/easybrowse/open?upgrade=0&url=_URL_TEMPLATE_&style=%7b%22toolbaricons%22%3a%7b%22toolids%22%3a%5b%223%22%5d%7d%7d";
    private static final boolean DEBUG = AdRuntimeHolder.DEBUG;
    private static final String DEEPLINK_APPURL_KEY = "appUrl";
    public static final String DEEPLINK_AUTO_INVOKE = "autoInvoke";
    private static final String DEEPLINK_CANCEL_H5_URL_KEY = "cancelUrl";
    public static final String DEEPLINK_CANCEL_H5_URL_OPT_KEY = "cancelUrlOpt";
    private static final String DEEPLINK_DEFERRED = "deferred";
    private static final String DEEPLINK_EXEMPTION_KEY = "exemption";
    private static final String DEEPLINK_EXTRAINFO_KEY = "extInfo";
    private static final String DEEPLINK_MARKETURL_KEY = "marketUrl";
    private static final String DEEPLINK_MARKET_PKGNAME_KEY = "marketPkgName";
    private static final String DEEPLINK_MINVER_KEY = "minVersion";
    private static final String DEEPLINK_PARAMS_KEY = "params";
    private static final String DEEPLINK_PKGNAME_KEY = "pkgName";
    private static final String DEEPLINK_REGISTER_INVOKE_KEY = "registerInvoke";
    private static final String DEEPLINK_SOURCE_KEY = "source";
    public static final String DEEPLINK_UBC_AD_NAME = "adnm";
    public static final String DEEPLINK_UBC_PAGE_URL_NA = "NA1";
    public static final String DEEPLINK_UBC_SOURCE_H5 = "feedh5";
    public static final String DEEPLINK_UBC_SOURCE_NA = "feedna";
    private static final String DEEPLINK_URL = "deeplinkUrl";
    private static final String DEEPLINK_WEBURL_KEY = "webUrl";
    private static final int EXEMPTION = 1;
    public static final String URL_TEMPLATE = "_URL_TEMPLATE_";
    private String mAdvertiserName = "";
    /* access modifiers changed from: private */
    public int mAutoInvoke = 0;
    private int mCancelUrlOpt = 0;
    /* access modifiers changed from: private */
    public String mExt;
    /* access modifiers changed from: private */
    public String mTabId;
    private String mUrl;

    public interface HandleDeeplinkCallback {
        void onResult(boolean z);
    }

    public boolean handleDeepLink(Context context, HashMap<String, String> params, HandleDeeplinkCallback callback, InvokeStatistic invokeStatistic) {
        this.mTabId = TabController.INSTANCE.getCurrentChannelId();
        this.mUrl = params.get(DEEPLINK_URL);
        return parseParams(context, params.get("params"), callback, invokeStatistic);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean parseParams(android.content.Context r26, java.lang.String r27, com.baidu.searchbox.feed.ad.scheme.AdDeepLinkController.HandleDeeplinkCallback r28, com.baidu.searchbox.schemedispatch.forbid.InvokeStatistic r29) {
        /*
            r25 = this;
            r15 = r25
            r14 = r28
            r13 = r29
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x013d }
            r11 = r27
            r0.<init>(r11)     // Catch:{ Exception -> 0x013d }
            java.lang.String r1 = "appUrl"
            java.lang.String r3 = r0.optString(r1)     // Catch:{ Exception -> 0x013d }
            java.lang.String r1 = "webUrl"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ Exception -> 0x013d }
            r10 = r1
            java.lang.String r1 = "minVersion"
            java.lang.String r7 = r0.optString(r1)     // Catch:{ Exception -> 0x013d }
            java.lang.String r1 = "pkgName"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ Exception -> 0x013d }
            r9 = r1
            java.lang.String r1 = "marketUrl"
            java.lang.String r5 = r0.optString(r1)     // Catch:{ Exception -> 0x013d }
            java.lang.String r1 = "marketPkgName"
            java.lang.String r6 = r0.optString(r1)     // Catch:{ Exception -> 0x013d }
            java.lang.String r1 = "exemption"
            int r1 = r0.optInt(r1)     // Catch:{ Exception -> 0x013d }
            r8 = r1
            java.lang.String r1 = "source"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ Exception -> 0x013d }
            r4 = r1
            java.lang.String r1 = "registerInvoke"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ Exception -> 0x013d }
            r2 = r1
            java.lang.String r1 = "extInfo"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ Exception -> 0x013d }
            r15.mExt = r1     // Catch:{ Exception -> 0x013d }
            java.lang.String r1 = "autoInvoke"
            int r1 = r0.optInt(r1)     // Catch:{ Exception -> 0x013d }
            r15.mAutoInvoke = r1     // Catch:{ Exception -> 0x013d }
            java.lang.String r1 = "adName"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ Exception -> 0x013d }
            r15.mAdvertiserName = r1     // Catch:{ Exception -> 0x013d }
            java.lang.String r1 = "cancelUrl"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ Exception -> 0x013d }
            java.lang.String r12 = "cancelUrlOpt"
            int r12 = r0.optInt(r12)     // Catch:{ Exception -> 0x013d }
            r15.mCancelUrlOpt = r12     // Catch:{ Exception -> 0x013d }
            r13.setFrom(r4)     // Catch:{ Exception -> 0x013d }
            java.lang.String r12 = r15.mExt     // Catch:{ Exception -> 0x013d }
            r13.setDeeplinkExtInfo(r12)     // Catch:{ Exception -> 0x013d }
            java.lang.String r12 = "1"
            boolean r12 = android.text.TextUtils.equals(r2, r12)     // Catch:{ Exception -> 0x013d }
            if (r12 == 0) goto L_0x008a
            java.lang.String r12 = r15.mUrl     // Catch:{ Exception -> 0x013d }
            r15.setDelayInvokeRegister(r12, r9)     // Catch:{ Exception -> 0x013d }
        L_0x008a:
            boolean r12 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x013d }
            r19 = r0
            r0 = 1
            if (r12 != 0) goto L_0x00c2
            if (r8 == r0) goto L_0x0097
            r12 = r0
            goto L_0x0098
        L_0x0097:
            r12 = 0
        L_0x0098:
            r0 = r1
            r1 = r25
            r20 = r2
            r2 = r26
            r21 = r4
            r4 = r10
            r14 = r8
            r8 = r9
            r22 = r9
            r9 = r12
            r12 = r10
            r10 = r21
            r11 = r27
            r17 = r14
            r14 = r12
            r12 = r28
            r13 = r29
            r1.openDeepLink(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0135 }
            r15.saveBackupUrl(r14, r0)     // Catch:{ Exception -> 0x0135 }
            r2 = r26
            r1 = r28
            r8 = r29
            r3 = r15
            goto L_0x011d
        L_0x00c2:
            r0 = r1
            r20 = r2
            r21 = r4
            r17 = r8
            r22 = r9
            r14 = r10
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0135 }
            if (r1 != 0) goto L_0x00fb
            r1 = r17
            r2 = 1
            if (r1 == r2) goto L_0x00d9
            r2 = 1
            goto L_0x00da
        L_0x00d9:
            r2 = 0
        L_0x00da:
            r8 = r25
            r9 = r26
            r10 = r14
            r11 = r5
            r12 = r6
            r13 = r7
            r23 = r1
            r4 = r14
            r1 = r28
            r14 = r22
            r24 = r3
            r3 = r15
            r15 = r2
            r16 = r21
            r17 = r28
            r18 = r29
            r8.openMarketUrl(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x012f }
            r2 = r26
            r8 = r29
            goto L_0x011d
        L_0x00fb:
            r1 = r28
            r24 = r3
            r4 = r14
            r3 = r15
            r23 = r17
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x012f }
            if (r2 != 0) goto L_0x0120
            if (r1 == 0) goto L_0x0119
            r2 = r26
            r8 = r29
            boolean r9 = r3.openBackupUrl(r2, r4, r8)     // Catch:{ Exception -> 0x0117 }
            r1.onResult(r9)     // Catch:{ Exception -> 0x0117 }
            goto L_0x011d
        L_0x0117:
            r0 = move-exception
            goto L_0x0143
        L_0x0119:
            r2 = r26
            r8 = r29
        L_0x011d:
            r0 = 1
            return r0
        L_0x0120:
            r2 = r26
            r8 = r29
            if (r1 == 0) goto L_0x012d
            r9 = 0
            r1.onResult(r9)     // Catch:{ Exception -> 0x012b }
            goto L_0x012e
        L_0x012b:
            r0 = move-exception
            goto L_0x0144
        L_0x012d:
            r9 = 0
        L_0x012e:
            return r9
        L_0x012f:
            r0 = move-exception
            r2 = r26
            r8 = r29
            goto L_0x0143
        L_0x0135:
            r0 = move-exception
            r2 = r26
            r1 = r28
            r8 = r29
            goto L_0x0142
        L_0x013d:
            r0 = move-exception
            r2 = r26
            r8 = r13
            r1 = r14
        L_0x0142:
            r3 = r15
        L_0x0143:
            r9 = 0
        L_0x0144:
            r0.printStackTrace()
            if (r1 == 0) goto L_0x014c
            r1.onResult(r9)
        L_0x014c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.ad.scheme.AdDeepLinkController.parseParams(android.content.Context, java.lang.String, com.baidu.searchbox.feed.ad.scheme.AdDeepLinkController$HandleDeeplinkCallback, com.baidu.searchbox.schemedispatch.forbid.InvokeStatistic):boolean");
    }

    private void setDelayInvokeRegister(String appUrl, String pkgName) {
        if (!TextUtils.isEmpty(appUrl) && !TextUtils.isEmpty(pkgName)) {
            AdH5DownloadAlsManager.getInstance().putDeeplinkUrl(pkgName, appUrl);
        }
    }

    /* access modifiers changed from: private */
    public boolean openBackupUrl(Context context, String webUrl, InvokeStatistic invokeStatistic) {
        if (TextUtils.isEmpty(webUrl)) {
            return false;
        }
        if (!TextUtils.isEmpty(this.mExt)) {
            Als.Builder builder = new Als.Builder();
            builder.setDaMenu(this.mTabId);
            builder.setPage(Als.Page.DEEPLINK);
            builder.setType(Als.LogType.DEEP_LINK);
            builder.setArea(Als.Area.DEEPLINK_RESULT_H5);
            builder.setExtraParam(this.mExt);
            if (this.mAutoInvoke == 1) {
                builder.setExt1(DEEPLINK_DEFERRED);
            }
            Als.postADRealTimeLog(builder);
        }
        if (webUrl.startsWith(UnitedSchemeConstants.UNITED_SCHEME)) {
            boolean result = Router.invokeScheme(context, Uri.parse(webUrl), "inside");
            if (invokeStatistic != null) {
                invokeStatistic.addScheme(webUrl);
                invokeStatistic.setOpenDeeplinkBackupUrlResult(result);
                if (result) {
                    invokeStatistic.invokeSuc();
                } else {
                    invokeStatistic.invokeFail();
                }
            }
            return true;
        } else if (!webUrl.startsWith("http") && !webUrl.startsWith("https")) {
            return false;
        } else {
            Router.invokeScheme(context, Uri.parse(AD_DEFAULT_SCHEME.replace("_URL_TEMPLATE_", webUrl)), "inside");
            return true;
        }
    }

    private void openDeepLink(Context context, String appUrl, String webUrl, String marketUrl, String marketPkgName, String minVer, String pkgName, boolean needCheck, String source, String params, HandleDeeplinkCallback callback, InvokeStatistic invokeStatistic) {
        try {
            try {
                SchemeStatisticField fields = new SchemeStatisticField().addField("source", source).addField("pageurl", "NA1").addField("refer", "");
                if (!TextUtils.isEmpty(this.mAdvertiserName)) {
                    fields.addField("ext", new JSONObject().put("adnm", this.mAdvertiserName).toString());
                }
                final HandleDeeplinkCallback handleDeeplinkCallback = callback;
                final String str = params;
                final Context context2 = context;
                final String str2 = webUrl;
                final String str3 = marketUrl;
                final String str4 = marketPkgName;
                final String str5 = minVer;
                final String str6 = pkgName;
                final boolean z = needCheck;
                final String str7 = source;
                final InvokeStatistic invokeStatistic2 = invokeStatistic;
                AnonymousClass1 r1 = new InterceptCallback() {
                    public void onResult(boolean result) {
                        if (result) {
                            if (!TextUtils.isEmpty(AdDeepLinkController.this.mExt)) {
                                Als.Builder builder = new Als.Builder();
                                builder.setDaMenu(AdDeepLinkController.this.mTabId);
                                builder.setPage(Als.Page.DEEPLINK);
                                builder.setType(Als.LogType.DEEP_LINK);
                                builder.setArea(Als.Area.DEEPLINK_RESULT_APP);
                                builder.setExtraParam(AdDeepLinkController.this.mExt);
                                if (AdDeepLinkController.this.mAutoInvoke == 1) {
                                    builder.setExt1(AdDeepLinkController.DEEPLINK_DEFERRED);
                                }
                                Als.postADRealTimeLog(builder);
                            }
                            HandleDeeplinkCallback handleDeeplinkCallback = handleDeeplinkCallback;
                            if (handleDeeplinkCallback != null) {
                                handleDeeplinkCallback.onResult(true);
                            }
                            AdDeepLinkStayTime.initConfigOnOpen(AdDeepLinkController.this.mExt);
                            AdRuntimeHolder.getSplashProxy().initConfigOnOpen(str);
                            return;
                        }
                        AdDeepLinkController.this.openMarketUrl(context2, str2, str3, str4, str5, str6, z, str7, handleDeeplinkCallback, invokeStatistic2);
                    }
                };
                OpenAppUtils.openApp(context, appUrl, minVer, pkgName, r1, fields, needCheck, OpenAppManager.isNoAlertSwitchOn("na"), invokeStatistic);
            } catch (Exception e2) {
                openMarketUrl(context, webUrl, marketUrl, marketPkgName, minVer, pkgName, needCheck, source, callback, invokeStatistic);
            }
        } catch (Exception e3) {
            String str8 = source;
            openMarketUrl(context, webUrl, marketUrl, marketPkgName, minVer, pkgName, needCheck, source, callback, invokeStatistic);
        }
    }

    /* access modifiers changed from: private */
    public void openMarketUrl(Context context, String webUrl, String marketUrl, String marketPkgName, String minVer, String pkgName, boolean needCheck, String source, HandleDeeplinkCallback callback, InvokeStatistic invokeStatistic) {
        Context context2;
        String str;
        HandleDeeplinkCallback handleDeeplinkCallback;
        InvokeStatistic invokeStatistic2;
        Context context3 = context;
        String str2 = webUrl;
        HandleDeeplinkCallback handleDeeplinkCallback2 = callback;
        InvokeStatistic invokeStatistic3 = invokeStatistic;
        if (!TextUtils.isEmpty(marketUrl)) {
            try {
                SchemeStatisticField fields = new SchemeStatisticField().addField("source", source).addField("pageurl", "NA1").addField("refer", "");
                if (!TextUtils.isEmpty(this.mAdvertiserName)) {
                    fields.addField("ext", new JSONObject().put("adnm", this.mAdvertiserName).toString());
                }
                final HandleDeeplinkCallback handleDeeplinkCallback3 = callback;
                final String str3 = pkgName;
                final Context context4 = context;
                final String str4 = webUrl;
                final InvokeStatistic invokeStatistic4 = invokeStatistic;
                AnonymousClass2 r1 = new InterceptCallback() {
                    public void onResult(boolean result) {
                        if (result) {
                            if (!TextUtils.isEmpty(AdDeepLinkController.this.mExt)) {
                                Als.Builder builder = new Als.Builder();
                                builder.setDaMenu(AdDeepLinkController.this.mTabId);
                                builder.setPage(Als.Page.DEEPLINK);
                                builder.setType(Als.LogType.DEEP_LINK);
                                builder.setArea(Als.Area.DEEPLINK_RESULT_MARKET);
                                builder.setExtraParam(AdDeepLinkController.this.mExt);
                                Als.postADRealTimeLog(builder);
                            }
                            HandleDeeplinkCallback handleDeeplinkCallback = handleDeeplinkCallback3;
                            if (handleDeeplinkCallback != null) {
                                handleDeeplinkCallback.onResult(true);
                            }
                            AdH5DownloadAlsManager.getInstance().putAdExtInfo(str3, AdDeepLinkController.this.mExt);
                            return;
                        }
                        HandleDeeplinkCallback handleDeeplinkCallback2 = handleDeeplinkCallback3;
                        if (handleDeeplinkCallback2 != null) {
                            handleDeeplinkCallback2.onResult(AdDeepLinkController.this.openBackupUrl(context4, str4, invokeStatistic4));
                        }
                    }
                };
                invokeStatistic2 = invokeStatistic3;
                handleDeeplinkCallback = handleDeeplinkCallback2;
                str = str2;
                context2 = context3;
                try {
                    OpenAppUtils.openApp(context, marketUrl, minVer, marketPkgName, r1, fields, needCheck, OpenAppManager.isNoAlertSwitchOn("na"), invokeStatistic);
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                invokeStatistic2 = invokeStatistic3;
                handleDeeplinkCallback = handleDeeplinkCallback2;
                str = str2;
                context2 = context3;
                if (handleDeeplinkCallback != null) {
                    handleDeeplinkCallback.onResult(openBackupUrl(context2, str, invokeStatistic2));
                }
            }
        } else if (handleDeeplinkCallback2 != null) {
            handleDeeplinkCallback2.onResult(openBackupUrl(context3, str2, invokeStatistic3));
        }
    }

    public static Long interceptDowngradeDelayMs() {
        return Long.valueOf(ADConfigManager.instance().getGlobalConfLong("deeplink_downgrade_delay_for_os", -1));
    }

    /* JADX WARNING: type inference failed for: r11v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean openLandPage(android.content.Context r10, java.util.Map<java.lang.String, java.lang.String> r11) {
        /*
            boolean r0 = com.baidu.searchbox.ad.util.MapUtils.isEmpty(r11)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String r0 = "webUrl"
            java.lang.Object r0 = com.baidu.searchbox.ad.util.MapUtils.get(r11, r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x0018
            return r1
        L_0x0018:
            java.lang.String r2 = "cancelUrl"
            java.lang.Object r2 = com.baidu.searchbox.ad.util.MapUtils.get(r11, r2)
            java.lang.String r2 = (java.lang.String) r2
            r3 = r2
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L_0x0028
            r3 = r0
        L_0x0028:
            r4 = 0
            java.lang.String r5 = "autoInvoke"
            java.lang.Object r5 = com.baidu.searchbox.ad.util.MapUtils.get(r11, r5)
            java.lang.String r5 = (java.lang.String) r5
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x003b
            int r4 = java.lang.Integer.parseInt(r5)
        L_0x003b:
            java.lang.String r6 = "extInfo"
            java.lang.Object r6 = com.baidu.searchbox.ad.util.MapUtils.get(r11, r6)
            java.lang.String r6 = (java.lang.String) r6
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            r8 = 1
            if (r7 != 0) goto L_0x0074
            com.baidu.searchbox.feed.ad.Als$Builder r7 = new com.baidu.searchbox.feed.ad.Als$Builder
            r7.<init>()
            com.baidu.searchbox.feed.tab.model.TabController r9 = com.baidu.searchbox.feed.tab.model.TabController.INSTANCE
            java.lang.String r9 = r9.getCurrentChannelId()
            r7.setDaMenu(r9)
            com.baidu.searchbox.feed.ad.Als$Page r9 = com.baidu.searchbox.feed.ad.Als.Page.DEEPLINK
            r7.setPage((com.baidu.searchbox.feed.ad.Als.Page) r9)
            com.baidu.searchbox.feed.ad.Als$LogType r9 = com.baidu.searchbox.feed.ad.Als.LogType.DEEP_LINK
            r7.setType((com.baidu.searchbox.feed.ad.Als.LogType) r9)
            com.baidu.searchbox.feed.ad.Als$Area r9 = com.baidu.searchbox.feed.ad.Als.Area.DEEPLINK_RESULT_CANCEL_H5
            r7.setArea((com.baidu.searchbox.feed.ad.Als.Area) r9)
            r7.setExtraParam(r6)
            if (r4 != r8) goto L_0x0071
            java.lang.String r9 = "deferred"
            r7.setExt1(r9)
        L_0x0071:
            com.baidu.searchbox.feed.ad.Als.postADRealTimeLog((com.baidu.searchbox.feed.ad.Als.Builder) r7)
        L_0x0074:
            java.lang.String r7 = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants.UNITED_SCHEME
            boolean r7 = r3.startsWith(r7)
            java.lang.String r9 = "inside"
            if (r7 == 0) goto L_0x0086
            android.net.Uri r1 = android.net.Uri.parse(r3)
            com.baidu.searchbox.Router.invokeScheme(r10, r1, r9)
            return r8
        L_0x0086:
            java.lang.String r7 = "http"
            boolean r7 = r3.startsWith(r7)
            if (r7 != 0) goto L_0x0098
            java.lang.String r7 = "https"
            boolean r7 = r3.startsWith(r7)
            if (r7 == 0) goto L_0x0097
            goto L_0x0098
        L_0x0097:
            return r1
        L_0x0098:
            java.lang.String r1 = "baiduboxapp://v1/easybrowse/open?upgrade=0&url=_URL_TEMPLATE_&style=%7b%22toolbaricons%22%3a%7b%22toolids%22%3a%5b%223%22%5d%7d%7d"
            java.lang.String r7 = "_URL_TEMPLATE_"
            java.lang.String r1 = r1.replace(r7, r3)
            android.net.Uri r7 = android.net.Uri.parse(r1)
            com.baidu.searchbox.Router.invokeScheme(r10, r7, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.ad.scheme.AdDeepLinkController.openLandPage(android.content.Context, java.util.Map):boolean");
    }

    private void saveBackupUrl(String webUrl, String cancelUrl) {
        MapUtils.put(AdDeepLinkStayTime.backupCmdMap, "webUrl", webUrl);
        MapUtils.put(AdDeepLinkStayTime.backupCmdMap, "extInfo", this.mExt);
        MapUtils.put(AdDeepLinkStayTime.backupCmdMap, DEEPLINK_AUTO_INVOKE, Integer.toString(this.mAutoInvoke));
        MapUtils.put(AdDeepLinkStayTime.backupCmdMap, DEEPLINK_CANCEL_H5_URL_KEY, cancelUrl);
        MapUtils.put(AdDeepLinkStayTime.backupCmdMap, DEEPLINK_CANCEL_H5_URL_OPT_KEY, Integer.toString(this.mCancelUrlOpt));
    }
}
