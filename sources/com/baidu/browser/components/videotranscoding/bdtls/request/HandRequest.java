package com.baidu.browser.components.videotranscoding.bdtls.request;

import com.baidu.browser.BrowserRuntime;
import com.baidu.browser.components.videotranscoding.bdtls.BdtlsConstants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostByteRequest;
import com.baidu.searchbox.net.SearchBoxCookieManager;
import java.util.HashMap;
import okhttp3.Response;

public class HandRequest {
    public static final String TAG = "HandshakeRequest";

    public interface HandshakeRequestCallback {
        void onResponseCallback(boolean z, byte[] bArr);
    }

    public void doHandshakeRequest(byte[] requestData, final HandshakeRequestCallback callback) {
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/octet-stream");
        headerMap.put("Bdtls", "Bdtls");
        headerMap.put(BdtlsConstants.HEADER_KEY_BDTLS_TYPE, "json");
        ((PostByteRequest.PostByteRequestBuilder) ((PostByteRequest.PostByteRequestBuilder) ((PostByteRequest.PostByteRequestBuilder) HttpManager.getDefault(BrowserRuntime.getAppContext()).postByteRequest().url("https://mbd.baidu.com/bdtls")).cookieManager(new SearchBoxCookieManager(false, false))).headers(headerMap)).content(requestData).build().executeAsync(new ResponseCallback<byte[]>() {
            public byte[] parseResponse(Response response, int i2) throws Exception {
                return response.body().bytes();
            }

            public void onSuccess(final byte[] resultData, int i2) {
                ExecutorUtilsExt.postOnSerial(new Runnable() {
                    public void run() {
                        if (callback != null) {
                            callback.onResponseCallback(true, resultData);
                        }
                    }
                }, "HandshakeRequest");
            }

            public void onFail(Exception e2) {
                ExecutorUtilsExt.postOnSerial(new Runnable() {
                    public void run() {
                        if (callback != null) {
                            callback.onResponseCallback(false, (byte[]) null);
                        }
                    }
                }, "HandshakeRequest");
            }
        });
    }
}
