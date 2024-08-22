package com.baidu.swan.game.ad.request;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.swan.game.ad.downloader.AdDownloadInfo;
import com.baidu.swan.game.ad.entity.AdLandingDownloadInfo;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import com.baidu.swan.game.ad.interfaces.IHttpRequest;
import com.baidu.swan.network.config.SwanNetworkConfig;
import com.baidu.swan.network.manager.SwanHttpManager;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

public class AdNetRequest implements IHttpRequest {
    private static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";
    private static final String URL_CTK_POST = "https://pimlog.baidu.com/mapp/advlog";
    private boolean isUseHttps;
    private Context mContext;

    public AdNetRequest(Context context) {
        this.mContext = context;
    }

    public void requestAd(String url, ResponseCallback<AdResponseInfo> callback) {
        boolean startsWith = url.startsWith("https://");
        this.isUseHttps = startsWith;
        if (startsWith) {
            ((GetRequest.GetRequestBuilder) SwanHttpManager.getDefault().getRequest().url(url)).build().executeAsync(callback);
        } else {
            ((GetRequest.GetRequestBuilder) SwanHttpManager.getDefault().getRequest().url(url)).build().executeAsync(callback);
        }
    }

    public void adStatis(String url) {
        ResponseCallback adResponseCallback = new ResponseCallback<String>() {
            public String parseResponse(Response response, int i2) throws Exception {
                if (response == null || response.body() == null) {
                    return "";
                }
                response.body().close();
                return "";
            }

            public void onSuccess(String resData, int i2) {
            }

            public void onFail(Exception e2) {
            }
        };
        boolean startsWith = url.startsWith("https://");
        this.isUseHttps = startsWith;
        if (startsWith) {
            ((GetRequest.GetRequestBuilder) SwanHttpManager.getDefault().getRequest().url(url)).build().executeAsync(adResponseCallback);
        } else {
            ((GetRequest.GetRequestBuilder) SwanHttpManager.getDefault().getRequest().url(url)).build().executeAsync(adResponseCallback);
        }
    }

    public void sendCTKByPostMethod(String content) {
        if (!TextUtils.isEmpty(content)) {
            SwanNetworkConfig config = new SwanNetworkConfig();
            config.method = "POST";
            config.url = URL_CTK_POST;
            config.requestBody = RequestBody.create(MediaType.get("application/json; charset=utf-8"), content);
            SwanHttpManager.getDefault().execPostRequest(config);
        }
    }

    public void requestAdDownload(String url, ResponseCallback<AdDownloadInfo> callback) {
        boolean startsWith = url.startsWith("https://");
        this.isUseHttps = startsWith;
        if (startsWith) {
            ((GetRequest.GetRequestBuilder) SwanHttpManager.getDefault().getRequest().url(url)).build().executeAsync(callback);
        } else {
            ((GetRequest.GetRequestBuilder) SwanHttpManager.getDefault().getRequest().url(url)).build().executeAsync(callback);
        }
    }

    public void postAd(String url, JSONObject body, ResponseCallback<AdResponseInfo> callback) {
        boolean startsWith = url.startsWith("https://");
        this.isUseHttps = startsWith;
        if (startsWith) {
            ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) SwanHttpManager.getDefault().postRequest().url(url)).requestBody(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body.toString()))).build().executeAsync(callback);
        } else {
            ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) SwanHttpManager.getDefault().postRequest().url(url)).requestBody(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body.toString()))).build().executeAsync(callback);
        }
    }

    public void postAfdDownloadInfo(String url, JSONObject body, ResponseCallback<AdLandingDownloadInfo> callback) {
        ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) SwanHttpManager.getDefault().postRequest().url(url)).requestBody(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body.toString()))).build().executeAsync(callback);
    }
}
