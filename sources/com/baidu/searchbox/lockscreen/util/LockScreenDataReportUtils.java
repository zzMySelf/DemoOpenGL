package com.baidu.searchbox.lockscreen.util;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.GZIP;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostByteRequest;
import com.baidu.searchbox.lockscreen.bridge.LockScreenRuntime;
import com.baidu.searchbox.privacy.FeedIdentityManager;
import java.io.IOException;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class LockScreenDataReportUtils {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = (LockScreenUtil.GLOBAL_DEBUG & true);
    private static final String TAG = "DataReportUtils";

    public static void reportData(String url, final JSONObject data) {
        final String urlWithPublicParams = FeedIdentityManager.processUrl(url);
        if (data != null) {
            try {
                data.put("timestamp", String.valueOf(System.currentTimeMillis()));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        final StringResponseCallback callback = new StringResponseCallback() {
            public void onSuccess(String response, int statusCode) {
                if (LockScreenDataReportUtils.DEBUG) {
                    Log.d(LockScreenDataReportUtils.TAG, "onSuccess: " + response + ", statusCode = " + statusCode);
                }
            }

            public void onFail(Exception exception) {
                if (LockScreenDataReportUtils.DEBUG && exception != null) {
                    Log.d(LockScreenDataReportUtils.TAG, "onFail: " + exception.getMessage());
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    String str = urlWithPublicParams;
                    JSONObject jSONObject = data;
                    LockScreenDataReportUtils.sendReportData(str, jSONObject == null ? "" : jSONObject.toString(), callback);
                }
            }, "LockScreenDataReportAsync", 3);
        } else {
            sendReportData(urlWithPublicParams, data == null ? "" : data.toString(), callback);
        }
    }

    /* access modifiers changed from: private */
    public static void sendReportData(String url, String data, StringResponseCallback callback) {
        byte[] gzipData;
        if (!TextUtils.isEmpty(url) && (gzipData = GZIP.gZip(data.toString().getBytes())) != null && gzipData.length > 0) {
            ((PostByteRequest.PostByteRequestBuilder) ((PostByteRequest.PostByteRequestBuilder) HttpManager.getDefault(LockScreenRuntime.getAppContext()).postByteRequest().url(url)).addHeader("Content-Encoding", "gzip")).content(gzipData).build().executeAsyncOnUIBack(callback);
        }
    }

    public static boolean reportDataSync(String url, byte[] data, boolean isGzip) {
        String urlWithPublicParams = FeedIdentityManager.processUrl(url);
        PostByteRequest.PostByteRequestBuilder builder = HttpManager.getDefault(LockScreenRuntime.getAppContext()).postByteRequest();
        builder.url(urlWithPublicParams);
        if (isGzip) {
            builder.addHeader("Content-Encoding", "gzip");
        }
        try {
            Response resp = builder.content(data).build().executeSync();
            if (!resp.isSuccessful()) {
                if (DEBUG) {
                    Log.d(TAG, "postByteRequest, fail: " + resp.message());
                }
                resp.body().close();
                return false;
            }
            resp.body().close();
            return true;
        } catch (IOException e2) {
            if (DEBUG) {
                Log.d(TAG, "postByteRequest, IOException: ", e2);
            }
            return false;
        }
    }
}
