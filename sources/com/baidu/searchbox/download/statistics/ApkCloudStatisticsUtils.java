package com.baidu.searchbox.download.statistics;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.abtest.ExpInfo;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.appsearch.lite.AppsearchNetService;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.constants.DownloadRecommendConstants;
import com.baidu.searchbox.download.dialog.DownloadSharedPrefsUtils;
import com.baidu.searchbox.download.model.ExtraInfoModel;
import com.baidu.searchbox.download.util.ApkUtil;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.FileClassifyHelper;
import com.baidu.searchbox.downloads.manage.SearchBoxDownloadManager;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.security.WarmTipsManager;
import com.baidu.searchbox.util.BaiduIdentityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Response;

public class ApkCloudStatisticsUtils {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "ApkCloudStatisticsUtils";
    private static AtomicInteger mReadyStaticCount = new AtomicInteger();
    private static ConcurrentLinkedQueue<String> mStaticJobInList = new ConcurrentLinkedQueue<>();

    public static void doApkStartDownloadStatisticJob(DownloadActionModel downloadActionModel) {
        if (downloadActionModel != null) {
            boolean z = DEBUG;
            if (z) {
                Log.e(TAG, downloadActionModel.toString());
            }
            if (z) {
                Log.e(TAG, "发起下载 仅apk" + downloadActionModel.toString());
            }
            handleNextCloudStatic(getStaticUrl(ApkStaticNetService.WEBDOWNLOAD_URL, downloadActionModel));
        }
    }

    private static String getStaticUrl(String staticUrl, DownloadActionModel downloadActionModel) {
        Map<String, String> params = new HashMap<>();
        params.put(ApkStaticNetService.KEY_STATIC_TYPE, "basic");
        if (WarmTipsManager.hasConfirmDialog()) {
            params.put("cuid", CommonParam.getCUID(AppRuntime.getApplication()));
        }
        params.put(ApkStaticNetService.STATIC_DOWNLOAD_NET, NetWorkUtils.getNetworkClass());
        params.put(ApkStaticNetService.STATIC_HOST_DOWNLOAD_VERSION_NAME, BaiduIdentityManager.getInstance().getVersionName());
        params.put("sid", buildSid());
        String uri = "";
        if (downloadActionModel != null) {
            if (downloadActionModel.downloadId != 0) {
                String[] result = SearchBoxDownloadManager.getInstance(AppRuntime.getAppContext()).queryStaticsInfoByDownloadID(String.valueOf(downloadActionModel.downloadId));
                if (result == null || result.length != 6) {
                    return "";
                }
                uri = result[0];
                params.put("totalsize", result[1]);
                params.put("from_refer", removeBDussInUrl(result[2]));
                String mimeType = result[4];
                if (TextUtils.isEmpty(mimeType)) {
                    mimeType = downloadActionModel.mimeType;
                }
                params.put("fileType", DownloadHelper.getFileTypeString(uri, mimeType));
                if (TextUtils.isEmpty(downloadActionModel.extraInfo) && !TextUtils.isEmpty(result[5])) {
                    downloadActionModel.extraInfo = result[5];
                }
            }
            if (!TextUtils.isEmpty(downloadActionModel.extraInfo)) {
                try {
                    ExtraInfoModel model = ApkUtil.parseApkInfo(downloadActionModel.extraInfo);
                    if (model != null) {
                        if (!TextUtils.isEmpty(model.pkgName)) {
                            params.put("pkg", model.pkgName);
                        }
                        if (!TextUtils.isEmpty(model.source)) {
                            params.put("source", model.source);
                        }
                        if (!TextUtils.isEmpty(model.category)) {
                            params.put("category", model.category);
                        }
                        if (!TextUtils.isEmpty(model.channel)) {
                            params.put("channel", model.channel);
                        }
                        if (TextUtils.isEmpty(model.version)) {
                            params.put(ApkStaticNetService.STATIC_DOWNLOAD_VER, model.version);
                        }
                        if (!TextUtils.isEmpty(model.originalUri)) {
                            uri = model.originalUri;
                        }
                    }
                } catch (Exception e2) {
                    if (DEBUG) {
                        Log.e(TAG, "获取统计链接 额外参数失败：" + e2.toString());
                    }
                }
            }
            if (!TextUtils.isEmpty(uri)) {
                params.put(ApkStaticNetService.STATIC_DOWNLOAD_URL, uri);
            }
        }
        return UrlUtil.addParam(staticUrl, params);
    }

    private static String buildSid() {
        List<ExpInfo> list = AbTestManager.getInstance().getExperimentInfoList();
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (ExpInfo expInfo : list) {
            builder.append(expInfo.getExpId()).append("_").append(expInfo.getExpComponentKey()).append("-");
        }
        return builder.substring(0, builder.length() - 1);
    }

    /* access modifiers changed from: private */
    public static void handleNextCloudStatic(String url) {
        if (!TextUtils.isEmpty(url)) {
            mStaticJobInList.add(url);
        } else {
            mReadyStaticCount.decrementAndGet();
        }
        if (mStaticJobInList.size() > 0 && mReadyStaticCount.get() < 2) {
            mReadyStaticCount.incrementAndGet();
            sendCloudStatic(mStaticJobInList.poll());
        }
    }

    private static void sendCloudStatic(String staticUrl) {
        if (DEBUG) {
            Log.e(TAG, "发起统计" + staticUrl);
        }
        if (TextUtils.isEmpty(staticUrl)) {
            handleNextCloudStatic((String) null);
            return;
        }
        GetRequest request = ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(staticUrl)).cookieManager(HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(false, false))).autoRetry(false)).readTimeout(3000)).connectionTimeout(3000)).writeTimeout(3000)).enableStat(true)).requestFrom(10)).requestSubFrom(1022)).build();
        if (request.makeRequestCall() != null) {
            request.executeAsync(new ResponseCallback<String>() {
                public String parseResponse(Response response, int i2) throws Exception {
                    if (ApkCloudStatisticsUtils.DEBUG) {
                        Log.e(ApkCloudStatisticsUtils.TAG, "统计成功:" + i2);
                    }
                    try {
                        ApkCloudStatisticsUtils.handleNextCloudStatic((String) null);
                        if (response != null) {
                            try {
                            } catch (Exception e2) {
                                if (ApkCloudStatisticsUtils.DEBUG) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        return null;
                    } finally {
                        if (response != null) {
                            try {
                                if (response.body() != null) {
                                    response.body().close();
                                }
                            } catch (Exception e3) {
                                if (ApkCloudStatisticsUtils.DEBUG) {
                                    e3.printStackTrace();
                                }
                            }
                        }
                    }
                }

                public void onSuccess(String s, int i2) {
                    if (ApkCloudStatisticsUtils.DEBUG) {
                        Log.e(ApkCloudStatisticsUtils.TAG, "统计成功:" + i2);
                    }
                }

                public void onFail(Exception e2) {
                    if (ApkCloudStatisticsUtils.DEBUG) {
                        Log.e(ApkCloudStatisticsUtils.TAG, "统计成功:" + e2);
                    }
                }
            });
        }
    }

    public static boolean enableAppsearchCloudStatic() {
        return NetWorkUtils.isNetworkConnected() && TextUtils.equals(DownloadSharedPrefsUtils.getInstance().getString(DownloadRecommendConstants.APPSEARCH_CLOUD_STATIC_KEY, "1"), "1");
    }

    public static String getDownloadStaticMimeType(String fileName) {
        return FileClassifyHelper.guessMimeTypeFromExtension(FileClassifyHelper.getFileSuffix(fileName));
    }

    public static String buildApkAnalysisParamsUrl() {
        Map<String, String> params = new HashMap<>();
        params.put("action", "apkanalysis");
        params.put("request_source", "1");
        params.put(AppsearchNetService.KEY_NATIVE_API, "1");
        params.put("baidu_entry", "commendAlert");
        if (WarmTipsManager.hasConfirmDialog()) {
            params.put("cuid", CommonParam.getCUID(AppRuntime.getApplication()));
        }
        return UrlUtil.addParam(AppsearchNetService.GET_APP_INFO_BY_HIJACK_ONLINE, params);
    }

    public static String removeBDussInUrl(String url) {
        if (TextUtils.isEmpty(url)) {
            return url;
        }
        try {
            String lowerCase = url.toLowerCase(Locale.getDefault());
            if (lowerCase.contains("bduss=")) {
                int index = lowerCase.indexOf(GameCenterUtils.SCHEME_SWAN_SUFFIX);
                String host = lowerCase.substring(0, index + 1);
                String[] params = lowerCase.substring(index + 1).split("&");
                StringBuilder urlBuilder = new StringBuilder();
                urlBuilder.append(host);
                for (String param : params) {
                    if (!param.contains("bduss=")) {
                        urlBuilder.append(param).append("&");
                    }
                }
                return urlBuilder.substring(0, urlBuilder.length() - 1);
            }
        } catch (Throwable th2) {
        }
        return url;
    }
}
