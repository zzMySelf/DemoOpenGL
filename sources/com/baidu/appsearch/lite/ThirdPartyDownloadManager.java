package com.baidu.appsearch.lite;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.appsearch.wrapper.AppSearchWrapper;
import com.baidu.appsearch.wrapper.LaunchAppSearchInfo;
import com.baidu.appsearch.wrapper.OnDownloadInfoListener;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.aps.base.db.PluginCache;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.data.DialogData;
import com.baidu.searchbox.download.FileDownloader;
import com.baidu.searchbox.download.util.DownloadStatisticUtil;
import com.baidu.searchbox.download.util.FileClassifyHelper;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.searchbox.downloadcenter.service.IDownloadCenterFun;
import com.baidu.searchbox.downloads.DownloadMessageSender;
import com.baidu.searchbox.downloads.filter.ApkDownloadFilter;
import com.baidu.searchbox.downloads.filter.DownloadDataInfo;
import com.baidu.searchbox.downloads.filter.DownloadFilterManager;
import com.baidu.searchbox.statistics.ButtonSourceUtil;
import com.baidu.searchbox.statistics.DownloadWindownUBC;

public final class ThirdPartyDownloadManager {
    public static final String APPASSISTANT_SRC_BANNER = "1";
    public static final String APPASSISTANT_SRC_DISCOVERY = "2";
    public static final String APPASSISTANT_SRC_OTHERS = "3";
    public static final String APPASSITANT_SRC_BROWSER = "4";
    public static final String APPASSITANT_SRC_SWAN_APP = "5";
    private static final int APPSEARCH_AVAILABLE_VERSION = 16782894;
    private static final int APPSEARCH_CANCEL_NOTIFICATION_VERSION = 16782895;
    private static final String APPSEARCH_EXTRA_DETAILE_DOCID = "docid";
    private static final String APPSEARCH_EXTRA_DETAILE_PKG = "pkg";
    private static final String APPSEARCH_EXTRA_DETAILE_VALUE = "10";
    private static final String APPSEARCH_EXTRA_FUNC = "func";
    private static final String APPSEARCH_EXTRA_FUNC_VALUE = "25";
    private static final int APPSEARCH_INTENT_FLAG = 32;
    private static final String APPSEARCH_LAUNCH_ACTION = "com.baidu.appsearch.extinvoker.LITELAUNCH";
    private static final String APPSEARCH_LITE_PKG_NAME = "com.baidu.appsearch";
    private static final String APPSEARCH_METHOD_NAME = "plugin_appsearch_invoker";
    private static final String APPSEARCH_PACKAGE_NAME = "com.baidu.appsearch";
    private static final int APPSEARCH_POPUP_DOWNLOAD_DIALOG_VERSION = 16782897;
    private static final int APP_SEARCH_MAIN_VERSION_DOWNLOADED = 1;
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final boolean DOWNLOAD_WITH_APPSEARCH_SWITCH = true;
    private static final boolean GUARD_ICON_DEFAULT_SWITCH_STATUS = false;
    private static final String JSON_KEY_ACTION = "action";
    private static final String JSON_KEY_BYUSER = "S.by_user";
    private static final String JSON_KEY_METHODNAME = "S.method_name";
    private static final String JSON_KEY_PACKNAME = "S.package_name";
    private static final String JSON_KEY_PARAMS = "S.params";
    private static final String JSON_VALUE_ACTION = "com.baidu.searchbox.plugin.action.THIRD_INVOKE";
    private static final String JSON_VALUE_BYUSER = "1";
    private static final String TAG = ThirdPartyDownloadManager.class.getSimpleName();

    private ThirdPartyDownloadManager() {
        AppSearchWrapper.setDebug(DEBUG);
    }

    public static boolean isAppAssistantSwitchEnabled() {
        return DefaultSharedPrefsWrapper.getInstance().getBoolean("appsearch_download_guide_switch", true);
    }

    public static boolean hasInstalledAppAssistant(Context context) {
        if (hasInstalledMainAppAssistant(context)) {
            return true;
        }
        return false;
    }

    public static boolean hasInstalledMainAppAssistant(Context context) {
        AppSearchWrapper wrapper = AppSearchWrapper.getInstance(context.getApplicationContext());
        if (wrapper == null) {
            return false;
        }
        return wrapper.isInstallMatchMainAppSearch();
    }

    public static boolean hasInstalledLiteAppAssistant(Context context) {
        if (PluginCache.getInstance("com.baidu.appsearch").getInstallVersion(context) >= 16782894) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static void downloadOnlyByAssitant(Context activity, String fileName, String downloadUrl) {
        if (!TextUtils.isEmpty(downloadUrl)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", fileName);
            contentValues.put("hint", fileName);
            FileDownloader.startDownload(downloadUrl, contentValues);
            IDownloadCenterFun downloadCenterFun = (IDownloadCenterFun) ServiceManager.getService(IDownloadCenterFun.SERVICE_REFERENCE);
            if (!(downloadCenterFun == null || activity == null)) {
                downloadCenterFun.startDownloadCenterActivity(activity, false, "");
            }
            DownloadMessageSender.sendBeginMsg(-2);
            MigrateStatisticUtils.invoke("016002", MigrateStatisticUtils.build("5"));
            if (DEBUG) {
                Log.d(TAG, "launch lite appsearch and download app!");
            }
        } else if (DEBUG) {
            Log.w(TAG, "downloadUrl is empty");
        }
    }

    public static boolean filterApk(Context activity, String pageUrl, String downloadURL, String contentDisposition, String mimetype, long contentLength) {
        boolean needFilter = false;
        String filename = FileClassifyHelper.guessFileName(downloadURL, contentDisposition, mimetype);
        if (FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(filename), mimetype) == 3) {
            DownloadDataInfo dwnInfo = new DownloadDataInfo();
            dwnInfo.url = downloadURL;
            dwnInfo.filename = filename;
            dwnInfo.size = contentLength;
            dwnInfo.pageUrl = pageUrl;
            needFilter = DownloadFilterManager.apkDownloadFilter(activity, dwnInfo, new ApkDownloadFilter());
            if (DEBUG) {
                Log.d(TAG, "App Download: Filter=" + needFilter + "; Url: " + downloadURL);
            }
        }
        return needFilter;
    }

    public static boolean canStartDownloadWithAssistant(Context activity, String downloadURL, String contentDisposition, String mimeType) {
        if (!isAppAssistantSwitchEnabled() || !AppsearchUtils.isDownloadingApk(downloadURL, contentDisposition, mimeType) || !(activity instanceof Activity) || AppSearchWrapper.getInstance(activity) == null || !hasInstalledMainAppAssistant(activity)) {
            return false;
        }
        return true;
    }

    public static boolean startDownloadWithAssistant(Context activity, String downloadURL, String referer, String userAgent, String contentDisposition, String mimeType, long contentLength, boolean needConfirm, String source, int noHijack, DialogData dialogData) {
        AppSearchWrapper wrapper;
        Context context = activity;
        String str = downloadURL;
        String str2 = contentDisposition;
        String str3 = mimeType;
        DialogData dialogData2 = dialogData;
        if (isAppAssistantSwitchEnabled()) {
            String filename = FileClassifyHelper.guessFileName(str, str2, str3);
            if (!AppsearchUtils.isDownloadingApk(str, str2, str3)) {
                long j2 = contentLength;
                boolean z = needConfirm;
            } else if (!(context instanceof Activity) || (wrapper = AppSearchWrapper.getInstance(activity)) == null) {
                return false;
            } else {
                LaunchAppSearchInfo launchInfo = new LaunchAppSearchInfo();
                launchInfo.mDownloadUrl = str;
                launchInfo.mDownloadApp = true;
                launchInfo.mBackop = true;
                launchInfo.mNeedConfirm = needConfirm;
                launchInfo.mDownloadFileName = filename;
                launchInfo.mFileSize = contentLength;
                launchInfo.mId = AppRuntime.getApplication().getPackageName();
                if (hasInstalledMainAppAssistant(activity)) {
                    wrapper.launchMainDownloadActivity(context, launchInfo);
                    MigrateStatisticUtils.invoke("016001", MigrateStatisticUtils.build("4"));
                    if (DEBUG) {
                        Log.d(TAG, "launch main appsearch and download app!");
                    }
                    if (!TextUtils.isEmpty(source)) {
                        DownloadStatisticUtil.ubc("tool", "dispatch", "openbox", source, "shouzhu_app", "615");
                    }
                    if (!(dialogData2 == null || dialogData2.decraisModel == null || dialogData2.dialogType == 0)) {
                        DownloadWindownUBC.invoke("dispatch", ButtonSourceUtil.getButtonTypeSource(dialogData2.dialogType), "shouzhu_app", dialogData2.decraisModel.hjackSid, dialogData2.decraisModel);
                    }
                    DownloadWindownUBC.invokeCommon("dispatch", "shouzhu_app");
                    return true;
                } else if (hasInstalledLiteAppAssistant(activity)) {
                    MigrateStatisticUtils.invoke("016002", MigrateStatisticUtils.build("4"));
                    if (DEBUG) {
                        Log.d(TAG, "launch lite appsearch and download app!");
                    }
                    if (!TextUtils.isEmpty(source)) {
                        DownloadStatisticUtil.ubc("tool", "dispatch", "openbox", source, "shouzhu_lite", "615");
                    }
                    if (!(dialogData2 == null || dialogData2.decraisModel == null || dialogData2.dialogType == 0)) {
                        DownloadWindownUBC.invoke("dispatch", ButtonSourceUtil.getButtonTypeSource(dialogData2.dialogType), "shouzhu_lite", dialogData2.decraisModel.hjackSid, dialogData2.decraisModel);
                    }
                    DownloadWindownUBC.invokeCommon("dispatch", "shouzhu_lite");
                    return false;
                }
            }
        } else {
            long j3 = contentLength;
            boolean z2 = needConfirm;
        }
        DownloadWindownUBC.invokeCommon("dispatch", "shoubai");
        return false;
    }

    public static void enterAppAssistantDownloadCenter(Context context) {
        AppSearchWrapper wrapper = AppSearchWrapper.getInstance(context.getApplicationContext());
        if (wrapper != null) {
            LaunchAppSearchInfo launchInfo = new LaunchAppSearchInfo();
            launchInfo.mDownloadApp = false;
            launchInfo.mBackop = false;
            launchInfo.mNeedConfirm = false;
            launchInfo.mId = AppRuntime.getApplication().getPackageName();
            if (hasInstalledMainAppAssistant(context)) {
                wrapper.launchMainDownloadActivity(context, launchInfo);
                if (DEBUG) {
                    Log.d(TAG, "launch main appsearch without download!");
                    return;
                }
                return;
            }
            IDownloadCenterFun downloadCenterFun = (IDownloadCenterFun) ServiceManager.getService(IDownloadCenterFun.SERVICE_REFERENCE);
            if (!(downloadCenterFun == null || context == null)) {
                downloadCenterFun.startDownloadCenterActivity(context, false, "");
            }
            if (DEBUG) {
                Log.d(TAG, "launch lite appsearch without download!");
            }
        }
    }

    public static void getDownloadAppCount(Context context, OnDownloadInfoListener listener) {
        if (context != null && listener != null) {
            if (isAppAssistantSwitchEnabled()) {
                AppSearchWrapper wrapper = AppSearchWrapper.getInstance(context.getApplicationContext());
                if (wrapper == null) {
                    listener.onResult(0);
                    return;
                } else if (hasInstalledMainAppAssistant(context)) {
                    wrapper.getMainDownloadAppTotal(listener);
                    if (DEBUG) {
                        Log.d(TAG, "get main appsearch downloaded app total!");
                        return;
                    }
                    return;
                }
            }
            listener.onResult(0);
        }
    }

    public static void getUnReadDownloadAppCount(Context context, OnDownloadInfoListener listener) {
        if (context != null && listener != null) {
            if (isAppAssistantSwitchEnabled()) {
                AppSearchWrapper wrapper = AppSearchWrapper.getInstance(context.getApplicationContext());
                if (wrapper == null) {
                    listener.onResult(0);
                    return;
                } else if (hasInstalledMainAppAssistant(context)) {
                    wrapper.getMainUnReadDownloadAppCount(listener);
                    if (DEBUG) {
                        Log.d(TAG, "get main appsearch unread downloaded app total!");
                        return;
                    }
                    return;
                }
            }
            listener.onResult(0);
        }
    }

    public static boolean isAppAssistantPopupDownloadDialog(Context context) {
        int curVersion = getAppAssistantVersion(context);
        if (curVersion == -1 || curVersion > APPSEARCH_POPUP_DOWNLOAD_DIALOG_VERSION) {
            return false;
        }
        return true;
    }

    private static int getAppAssistantVersion(Context context) {
        return Long.valueOf(PluginCache.getInstance("com.baidu.appsearch").getInstallVersion(context)).intValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007e A[SYNTHETIC, Splitter:B:24:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void openAppsearchLiteOrWeb(android.content.Context r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            r8 = r16
            r9 = r17
            com.baidu.searchbox.download.dialog.DownloadSharedPrefsUtils r0 = com.baidu.searchbox.download.dialog.DownloadSharedPrefsUtils.getInstance()
            java.lang.String r1 = "enable_appsearch_lite_key"
            java.lang.String r2 = "0"
            java.lang.String r0 = r0.getString(r1, r2)
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L_0x00e6
            java.lang.String r0 = "https://mobile.baidu.com/item?docid="
            boolean r1 = android.text.TextUtils.isEmpty(r17)
            if (r1 == 0) goto L_0x0033
            com.baidu.searchbox.download.dialog.DownloadSharedPrefsUtils r1 = com.baidu.searchbox.download.dialog.DownloadSharedPrefsUtils.getInstance()
            java.lang.String r2 = "appsearch_lite_recommend_url_key"
            java.lang.String r3 = "https://mobile.baidu.com/topicBoard?topicid=2663&from=baiduapp"
            java.lang.String r0 = r1.getString(r2, r3)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0031
            return
        L_0x0031:
            r1 = r0
            goto L_0x0045
        L_0x0033:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r0 = r1.toString()
            r1 = r0
        L_0x0045:
            boolean r0 = android.text.TextUtils.isEmpty(r19)
            java.lang.String r2 = "utf-8"
            if (r0 != 0) goto L_0x0076
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x006f }
            r0.<init>()     // Catch:{ UnsupportedEncodingException -> 0x006f }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ UnsupportedEncodingException -> 0x006f }
            java.lang.String r3 = "&statistic_info="
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ UnsupportedEncodingException -> 0x006f }
            r10 = r19
            java.lang.String r3 = java.net.URLEncoder.encode(r10, r2)     // Catch:{ UnsupportedEncodingException -> 0x006d }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ UnsupportedEncodingException -> 0x006d }
            java.lang.String r0 = r0.toString()     // Catch:{ UnsupportedEncodingException -> 0x006d }
            r1 = r0
            goto L_0x0078
        L_0x006d:
            r0 = move-exception
            goto L_0x0072
        L_0x006f:
            r0 = move-exception
            r10 = r19
        L_0x0072:
            r0.printStackTrace()
            goto L_0x0078
        L_0x0076:
            r10 = r19
        L_0x0078:
            boolean r0 = android.text.TextUtils.isEmpty(r20)
            if (r0 != 0) goto L_0x00a6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x009f }
            r0.<init>()     // Catch:{ UnsupportedEncodingException -> 0x009f }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ UnsupportedEncodingException -> 0x009f }
            java.lang.String r3 = "&ck_info="
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ UnsupportedEncodingException -> 0x009f }
            r11 = r20
            java.lang.String r2 = java.net.URLEncoder.encode(r11, r2)     // Catch:{ UnsupportedEncodingException -> 0x009d }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ UnsupportedEncodingException -> 0x009d }
            java.lang.String r0 = r0.toString()     // Catch:{ UnsupportedEncodingException -> 0x009d }
            r1 = r0
            goto L_0x00a8
        L_0x009d:
            r0 = move-exception
            goto L_0x00a2
        L_0x009f:
            r0 = move-exception
            r11 = r20
        L_0x00a2:
            r0.printStackTrace()
            goto L_0x00a8
        L_0x00a6:
            r11 = r20
        L_0x00a8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r2 = "&cuid="
            java.lang.StringBuilder r0 = r0.append(r2)
            android.app.Application r2 = com.baidu.searchbox.common.runtime.AppRuntime.getApplication()
            java.lang.String r2 = com.baidu.android.common.util.CommonParam.getCUID(r2)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r2 = "&baidu_entry=commendAlert"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r0 = r1.toString()
            com.baidu.pyramid.runtime.service.ServiceReference r1 = com.baidu.searchbox.browser.ILightBrowser.SERVICE_REFERENCE
            java.lang.Object r1 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r1)
            com.baidu.searchbox.browser.ILightBrowser r1 = (com.baidu.searchbox.browser.ILightBrowser) r1
            r1.open(r8, r0)
            return
        L_0x00e6:
            r10 = r19
            r11 = r20
            boolean r0 = hasInstalledLiteAppAssistant(r16)
            java.lang.String r1 = "com.baidu.appsearch"
            if (r0 != 0) goto L_0x00f7
            r0 = 0
            r2 = 0
            com.baidu.searchbox.aps.center.activator.TargetActivatorProxy.loadTarget(r8, r1, r2, r0, r2)
        L_0x00f7:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r2 = "com.baidu.appsearch.extinvoker.LITELAUNCH"
            r0.<init>(r2)
            r12 = r0
            r0 = 32
            r12.addFlags(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r17)
            java.lang.String r2 = "1"
            java.lang.String r3 = "func"
            if (r0 == 0) goto L_0x0114
            r12.putExtra(r3, r2)
            r13 = r18
            goto L_0x0125
        L_0x0114:
            java.lang.String r0 = "10"
            r12.putExtra(r3, r0)
            java.lang.String r0 = "docid"
            r12.putExtra(r0, r9)
            java.lang.String r0 = "pkg"
            r13 = r18
            r12.putExtra(r0, r13)
        L_0x0125:
            r0 = 1
            java.lang.String r14 = r12.toUri(r0)
            java.lang.String r3 = ""
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0155 }
            r0.<init>()     // Catch:{ Exception -> 0x0155 }
            java.lang.String r4 = "action"
            java.lang.String r5 = "com.baidu.searchbox.plugin.action.THIRD_INVOKE"
            r0.put(r4, r5)     // Catch:{ Exception -> 0x0155 }
            java.lang.String r4 = "S.package_name"
            r0.put(r4, r1)     // Catch:{ Exception -> 0x0155 }
            java.lang.String r1 = "S.method_name"
            java.lang.String r4 = "plugin_appsearch_invoker"
            r0.put(r1, r4)     // Catch:{ Exception -> 0x0155 }
            java.lang.String r1 = "S.by_user"
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0155 }
            java.lang.String r1 = "S.params"
            r0.put(r1, r14)     // Catch:{ Exception -> 0x0155 }
            java.lang.String r1 = r0.toString()     // Catch:{ Exception -> 0x0155 }
            r3 = r1
            r0 = r3
            goto L_0x015a
        L_0x0155:
            r0 = move-exception
            r0.printStackTrace()
            r0 = r3
        L_0x015a:
            boolean r15 = DEBUG
            if (r15 == 0) goto L_0x0176
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "params:"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r1, r2)
        L_0x0176:
            r6 = 0
            r7 = 0
            java.lang.String r2 = "com.baidu.appsearch"
            java.lang.String r3 = "plugin_appsearch_invoker"
            java.lang.String r4 = ""
            r1 = r16
            r5 = r0
            com.baidu.searchbox.plugin.api.PluginInvoker.invokePlugin(r1, r2, r3, r4, r5, r6, r7)
            if (r15 == 0) goto L_0x018e
            java.lang.String r1 = TAG
            java.lang.String r2 = "start lite appsearch DownloadMergeService!"
            android.util.Log.d(r1, r2)
        L_0x018e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.appsearch.lite.ThirdPartyDownloadManager.openAppsearchLiteOrWeb(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
