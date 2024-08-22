package com.baidu.swan.apps.impl.openapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.FileDownloader;
import com.baidu.searchbox.download.util.FileClassifyHelper;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.searchbox.downloadcenter.service.IDownloadCenterFun;
import com.baidu.searchbox.downloads.DownloadMessageSender;
import com.baidu.searchbox.downloads.filter.ApkDownloadFilter;
import com.baidu.searchbox.downloads.filter.DownloadDataInfo;
import com.baidu.searchbox.downloads.filter.DownloadFilterManager;
import com.baidu.swan.api.deprecations.interfaces.ISwanAppAchieveIoc;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.util.SwanAppFileClassifyHelper;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.interfaces.R;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

public final class SwanAppDownloadApkUtils {
    public static final String APPASSITANT_SRC_SWAN_APP = "5";
    private static final String CONTENT_TYPE = "Content-Type";
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String DOWNLAOD_TYPE_LOCAL = "local";
    private static final String DOWNLOAD_TYPE_ASSITANT = "plugin";
    private static final int HOLD_TIME = 300;
    private static final String PARAMS_DOWNLOAD_CONTENT_DISPOSITION = "contentDisposition";
    private static final String PARAMS_DOWNLOAD_CONTENT_LENGTH = "contentLength";
    private static final String PARAMS_DOWNLOAD_MIME_TYPE = "mimeType";
    private static final String PARAMS_DOWNLOAD_URL = "url";
    private static final String PARAMS_DOWNLOAD_USER_AGENT = "userAgent";
    public static final String TAG = "SwanAppDownloadApkUtils";

    public static void downloadAppForSwanApp(Context activity, String downloadParams, String type, ISwanAppAchieveIoc.DownloadActionCallback callback) {
        if (!TextUtils.isEmpty(downloadParams)) {
            JSONObject downloadJo = null;
            try {
                downloadJo = new JSONObject(downloadParams);
            } catch (JSONException e2) {
                if (DEBUG) {
                    Log.d("SwanAppDownloadApkUtils", "json parse fail");
                }
            }
            if (downloadJo != null) {
                String downloadUrl = downloadJo.optString("url");
                if (!TextUtils.isEmpty(downloadUrl)) {
                    String mimeType = downloadJo.optString("mimeType");
                    if (!TextUtils.isEmpty(mimeType) || !TextUtils.equals(type, "local")) {
                        downloadAppDispatcher(activity, downloadJo, downloadUrl, type, mimeType, callback);
                    } else {
                        requestMimeType(activity, downloadJo, downloadUrl, type, callback);
                    }
                }
            } else if (DEBUG) {
                Log.d("SwanAppDownloadApkUtils", "download app params is invalid");
            }
        } else if (DEBUG) {
            Log.w("SwanAppDownloadApkUtils", "downloadParams is null");
        }
    }

    /* access modifiers changed from: private */
    public static void downloadAppDispatcher(Context activity, JSONObject downloadJo, String downloadUrl, String type, String mimeType, ISwanAppAchieveIoc.DownloadActionCallback callback) {
        JSONObject jSONObject = downloadJo;
        String contentDisposition = jSONObject.optString("contentDisposition");
        String fileName = SwanAppFileClassifyHelper.guessFileName(downloadUrl, contentDisposition, mimeType);
        String srcType = jSONObject.optString("type", "");
        String userAgent = jSONObject.optString("userAgent", "");
        String apkAutoInstall = jSONObject.optString("apk_auto_install");
        String extInfo = jSONObject.optString("ext_info");
        long contentLength = jSONObject.optLong("contentLength", 0);
        final Context context = activity;
        final String str = downloadUrl;
        final String str2 = contentDisposition;
        final String str3 = mimeType;
        final long j2 = contentLength;
        Observable observeOn = Observable.defer(new Func0<Observable<Boolean>>() {
            public Observable<Boolean> call() {
                return Observable.just(Boolean.valueOf(SwanAppDownloadApkUtils.filterApk(context, "", str, str2, str3, j2)));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final String str4 = type;
        final Context context2 = activity;
        final String str5 = downloadUrl;
        final String str6 = fileName;
        final ISwanAppAchieveIoc.DownloadActionCallback downloadActionCallback = callback;
        final String str7 = srcType;
        final String str8 = contentDisposition;
        final String str9 = userAgent;
        final String str10 = apkAutoInstall;
        AnonymousClass1 r0 = r2;
        final String str11 = mimeType;
        String str12 = contentDisposition;
        final long j3 = contentLength;
        final String str13 = extInfo;
        AnonymousClass1 r2 = new Action1<Boolean>() {
            public void call(Boolean needFilter) {
                if (!needFilter.booleanValue()) {
                    if (TextUtils.equals("plugin", str4)) {
                        SwanAppDownloadApkUtils.downloadApkByAssitant(context2, str5, str6, downloadActionCallback);
                    } else if (TextUtils.equals("local", str4)) {
                        SwanAppDownloadApkUtils.downloadApkByLocal(context2, str7, str5, str8, str9, str10, str11, j3, str13, downloadActionCallback);
                    }
                }
            }
        };
        observeOn.subscribe(r0);
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
                Log.d("SwanAppDownloadApkUtils", "App Download: Filter=" + needFilter + "; Url: " + downloadURL);
            }
        }
        return needFilter;
    }

    /* access modifiers changed from: private */
    public static void downloadApkByAssitant(final Context activity, final String downloadUrl, final String fileName, final ISwanAppAchieveIoc.DownloadActionCallback callback) {
        if (!TextUtils.isEmpty(downloadUrl)) {
            SwanAppUtils.runOnUiThread(new Runnable() {
                public void run() {
                    Context context = activity;
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        Resources res = activity.getResources();
                        new SwanAppAlertDialog.Builder(activity).setTitle(res.getText(R.string.confirm_download_title)).setMessage(Html.fromHtml(res.getString(com.baidu.swan.apps.R.string.aiapps_about_download_tip) + "<br><small>" + res.getString(com.baidu.swan.apps.R.string.aiapps_about_download_file) + fileName + "</small>")).setPositiveButton(res.getText(R.string.dialog_positive_button_text), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                SwanAppDownloadApkUtils.downloadOnlyByAssitant(activity, fileName, downloadUrl);
                                if (callback != null) {
                                    callback.onActionDone(true);
                                }
                            }
                        }).setNegativeButton(res.getText(R.string.dialog_nagtive_button_text), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if (callback != null) {
                                    callback.onActionDone(false);
                                }
                            }
                        }).show();
                    }
                }
            });
        }
    }

    @Deprecated
    public static void downloadOnlyByAssitant(Context activity, String fileName, String downloadUrl) {
        if (!TextUtils.isEmpty(downloadUrl)) {
            JSONObject extJo = new JSONObject();
            try {
                extJo.put("source", SwanAppDownloadHelper.SOURCE_SWAN_AD);
            } catch (JSONException e2) {
                if (DEBUG) {
                    Log.d("SwanAppDownloadApkUtils", "downloadApkByLocal json parse fail");
                }
            }
            ContentValues cv = new ContentValues();
            cv.put("title", fileName);
            cv.put("hint", fileName);
            cv.put("extra_info", extJo.toString());
            cv.put("source", "swan");
            FileDownloader.startDownload(downloadUrl, cv);
            IDownloadCenterFun downloadCenterFun = (IDownloadCenterFun) ServiceManager.getService(IDownloadCenterFun.SERVICE_REFERENCE);
            if (!(downloadCenterFun == null || activity == null)) {
                downloadCenterFun.startDownloadCenterActivity(activity, false, "");
            }
            DownloadMessageSender.sendBeginMsg(-2);
            MigrateStatisticUtils.invoke("016002", MigrateStatisticUtils.build("5"));
            if (DEBUG) {
                Log.d("SwanAppDownloadApkUtils", "launch lite appsearch and download app!");
            }
        } else if (DEBUG) {
            Log.w("SwanAppDownloadApkUtils", "downloadUrl is empty");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void downloadApkByLocal(android.content.Context r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, long r23, java.lang.String r25, com.baidu.swan.api.deprecations.interfaces.ISwanAppAchieveIoc.DownloadActionCallback r26) {
        /*
            r1 = r26
            java.lang.String r2 = "source"
            boolean r0 = android.text.TextUtils.isEmpty(r18)
            if (r0 == 0) goto L_0x000c
            return
        L_0x000c:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r3 = r0
            java.lang.String r0 = "type"
            r4 = r17
            r3.put(r0, r4)     // Catch:{ JSONException -> 0x0033 }
            java.lang.String r0 = "apk_auto_install"
            r5 = r21
            r3.put(r0, r5)     // Catch:{ JSONException -> 0x0031 }
            java.lang.String r0 = "ext_info"
            r6 = r25
            r3.put(r0, r6)     // Catch:{ JSONException -> 0x002f }
            java.lang.String r0 = "swan_ad"
            r3.put(r2, r0)     // Catch:{ JSONException -> 0x002f }
            goto L_0x0047
        L_0x002f:
            r0 = move-exception
            goto L_0x003c
        L_0x0031:
            r0 = move-exception
            goto L_0x003a
        L_0x0033:
            r0 = move-exception
            goto L_0x0038
        L_0x0035:
            r0 = move-exception
            r4 = r17
        L_0x0038:
            r5 = r21
        L_0x003a:
            r6 = r25
        L_0x003c:
            boolean r7 = DEBUG
            if (r7 == 0) goto L_0x0047
            java.lang.String r7 = "SwanAppDownloadApkUtils"
            java.lang.String r8 = "downloadApkByLocal json parse fail"
            android.util.Log.d(r7, r8)
        L_0x0047:
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r7 = r3.toString()
            java.lang.String r8 = "extra_info"
            r0.put(r8, r7)
            java.lang.String r7 = "swan"
            r0.put(r2, r7)
            com.baidu.searchbox.downloads.manage.SearchBoxDownloadManager r7 = com.baidu.searchbox.downloads.manage.SearchBoxDownloadManager.getInstance(r16)
            java.lang.String r9 = ""
            r8 = r18
            r10 = r20
            r11 = r19
            r12 = r22
            r13 = r23
            r15 = r0
            r7.doDownload((java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (long) r13, (android.content.ContentValues) r15)
            android.os.Handler r2 = com.baidu.swan.apps.runtime.Swan.getMainHandler()
            com.baidu.swan.apps.impl.openapp.SwanAppDownloadApkUtils$4 r7 = new com.baidu.swan.apps.impl.openapp.SwanAppDownloadApkUtils$4
            r8 = r16
            r7.<init>(r8)
            r9 = 300(0x12c, double:1.48E-321)
            r2.postDelayed(r7, r9)
            if (r1 == 0) goto L_0x0085
            r2 = 1
            r1.onActionDone(r2)
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.impl.openapp.SwanAppDownloadApkUtils.downloadApkByLocal(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, com.baidu.swan.api.deprecations.interfaces.ISwanAppAchieveIoc$DownloadActionCallback):void");
    }

    private static void requestMimeType(Context context, JSONObject downloadJo, String downloadUrl, String type, ISwanAppAchieveIoc.DownloadActionCallback callback) {
        SwanApp swanApp;
        if (!TextUtils.isEmpty(downloadUrl) && (swanApp = SwanApp.get()) != null) {
            final Context context2 = context;
            final JSONObject jSONObject = downloadJo;
            final String str = downloadUrl;
            final String str2 = type;
            final ISwanAppAchieveIoc.DownloadActionCallback downloadActionCallback = callback;
            swanApp.getNetwork().getHttpClient().newBuilder().build().newCall(new Request.Builder().url(downloadUrl).build()).enqueue(new Callback() {
                public void onFailure(Call call, IOException e2) {
                    SwanAppDownloadApkUtils.downloadAppDispatcher(context2, jSONObject, str, str2, "", downloadActionCallback);
                }

                public void onResponse(Call call, Response response) {
                    String url = str;
                    String realUrl = response.request().url().toString();
                    if (!TextUtils.isEmpty(realUrl) && !TextUtils.isEmpty(SwanAppFileClassifyHelper.getFileSuffix(realUrl))) {
                        url = realUrl;
                    }
                    String contentType = response.header("Content-Type", (String) null);
                    SwanAppDownloadApkUtils.downloadAppDispatcher(context2, jSONObject, url, str2, !TextUtils.isEmpty(contentType) ? contentType : "", downloadActionCallback);
                }
            });
        }
    }
}
