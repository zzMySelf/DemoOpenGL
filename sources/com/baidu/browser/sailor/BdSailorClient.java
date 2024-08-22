package com.baidu.browser.sailor;

import android.content.Context;
import android.net.http.SslError;
import com.baidu.browser.sailor.platform.a.b;
import com.baidu.webkit.sdk.WebKitClient;
import com.baidu.webkit.sdk.WebView;

public class BdSailorClient extends WebKitClient implements ISailorUrlPushService, b {

    public enum DownloadTaskType {
        ZEUS,
        BROWSER
    }

    public interface IDownloadTaskListener {
        void onDownloadCancel(String str, long j2, long j3, String str2);

        void onDownloadFail(String str, long j2, String str2, String str3);

        void onDownloadPause(String str, long j2, long j3, String str2);

        void onDownloadStart(String str, long j2, String str2);

        void onDownloadSuccess(String str, String str2, long j2);

        void onDownloading(String str, long j2, long j3);
    }

    public void updateSearchUrlProtocol(Context context, boolean z) {
    }

    public void onGetABTestPolicy(String str, String str2) {
    }

    public void onShareWebPage(String str, String str2) {
    }

    public String getLocationInfo() {
        return null;
    }

    public boolean onStartLocation() {
        return false;
    }

    public void onStopLocation() {
    }

    public void onSailorStatistics(String str, String str2) {
    }

    public String getUrl(String str) {
        return null;
    }

    public boolean isNeedUpdate(String str) {
        return false;
    }

    public void updateFingerprint(String str, String str2) {
    }

    public boolean getSwitchByKey(String str) {
        return false;
    }

    public String getApplicationVersion() {
        return "";
    }

    public String getProcessedUrl(String str) {
        return str;
    }

    public String getErrpgSearchUrl(Context context) {
        return null;
    }

    public String getErrorPageInfo(Context context, int i2, String str, String str2, String str3) {
        return null;
    }

    public void checkErrorPageWifiBtnShow(WebView webView) {
    }

    public void invokeWifiPlugin() {
    }

    public void statWifiErrorPageShow() {
    }

    public String getSslErrorInfo(Context context, SslError sslError) {
        return null;
    }

    public void onShouldInsertToHistory(String str, String str2) {
    }

    public void onAddToLauncher(String str) {
    }

    public boolean onDownloadTask(String str, String str2, String str3, String str4, DownloadTaskType downloadTaskType, IDownloadTaskListener iDownloadTaskListener) {
        return false;
    }
}
