package com.baidu.searchbox.log.sender.upload;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.io.GZIP;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.PostByteRequest;
import com.baidu.ubc.impl.DependConstants;
import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

public class BIMUploadManager {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final long PING_INTERVAL_MS = 1000;
    private static final String TAG = "BIMUploadManager";
    private static final int TIME_OUT_S = 30;
    private static volatile BIMUploadManager sInstance;

    private BIMUploadManager() {
    }

    public static BIMUploadManager getInstance() {
        if (sInstance == null) {
            synchronized (BIMUploadManager.class) {
                if (sInstance == null) {
                    sInstance = new BIMUploadManager();
                }
            }
        }
        return sInstance;
    }

    public String getLoggerUrl() {
        String url;
        boolean z = DEBUG;
        if (z) {
            url = AppConfig.getUbcTestUrl();
        } else {
            url = DependConstants.TCBOX_HOST_VALUE;
        }
        String url2 = CommonUrlParamManager.getInstance().processUrl(url);
        if (!z || TextUtils.isEmpty(url2)) {
            return url2;
        }
        return UrlUtil.addParam(url2, "debug", "1");
    }

    private byte[] gzipValue(String payLoad) {
        byte[] value = GZIP.gZip(payLoad.getBytes());
        if (value.length < 2) {
            return value;
        }
        value[0] = 117;
        value[1] = 123;
        return value;
    }

    public boolean upload(String payLoad) {
        String url = getLoggerUrl();
        PostByteRequest.PostByteRequestBuilder builder = HttpManager.getDefault(AppRuntime.getAppContext()).postByteRequest();
        builder.requestFrom(3);
        builder.url(url);
        builder.addHeader(BIMUploadConstants.CONTENT_TYPE, "application/x-www-form-urlencoded");
        builder.addHeader(BIMUploadConstants.NB, "1");
        builder.cookieManager(HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(true, false));
        byte[] value = gzipValue(payLoad);
        if (value.length < 2) {
            return false;
        }
        try {
            return handleResponse(builder.content(value).build().executeSync());
        } catch (IOException e2) {
            if (DEBUG) {
                Log.d(TAG, "postByteRequest, Exception: ", e2);
            }
            return false;
        }
    }

    private boolean handleResponse(Response resp) {
        if (resp == null) {
            return false;
        }
        ResponseBody body = resp.body();
        if (!resp.isSuccessful()) {
            if (body != null) {
                body.close();
            }
            return false;
        }
        if (body != null) {
            try {
                if (new JSONObject(body.string()).getInt("error") == 0) {
                    return true;
                }
                if (DEBUG) {
                    Log.d(TAG, "server error");
                }
                return false;
            } catch (Exception e2) {
                if (DEBUG) {
                    Log.d(TAG, "body tostring fail:" + e2.getMessage());
                }
                body.close();
            }
        }
        return false;
    }
}
