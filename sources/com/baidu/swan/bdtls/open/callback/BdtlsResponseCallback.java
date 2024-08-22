package com.baidu.swan.bdtls.open.callback;

import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import okhttp3.Response;

public class BdtlsResponseCallback<T> extends ResponseCallback<T> implements StatResponseCallback<T> {
    private static final String TAG = "BdtlsResponseCallback";
    private boolean mIsStat = false;
    private final ResponseCallback<T> mResponseCallback;
    private final StatResponseCallback<T> mStatResponseCallback;

    public BdtlsResponseCallback(ResponseCallback<T> responseCallback, StatResponseCallback<T> statResponseCallback) {
        this.mResponseCallback = responseCallback;
        this.mStatResponseCallback = statResponseCallback;
    }

    public T parseResponse(Response response, int i2) throws Exception {
        ResponseCallback<T> responseCallback = this.mResponseCallback;
        if (responseCallback != null) {
            return responseCallback.parseResponse(response, i2);
        }
        return null;
    }

    public T parseResponse(Response response, int i2, NetworkStatRecord networkStatRecord) throws Exception {
        StatResponseCallback<T> statResponseCallback = this.mStatResponseCallback;
        if (statResponseCallback != null) {
            return statResponseCallback.parseResponse(response, i2, networkStatRecord);
        }
        return null;
    }

    public void onSuccess(T data, int i2) {
        ResponseCallback<T> responseCallback = this.mResponseCallback;
        if (responseCallback != null) {
            responseCallback.onSuccess(data, i2);
        }
        StatResponseCallback<T> statResponseCallback = this.mStatResponseCallback;
        if (statResponseCallback != null) {
            statResponseCallback.onSuccess(data, i2);
        }
    }

    public void onFail(Exception e2) {
        ResponseCallback<T> responseCallback = this.mResponseCallback;
        if (responseCallback != null) {
            responseCallback.onFail(e2);
        }
        StatResponseCallback<T> statResponseCallback = this.mStatResponseCallback;
        if (statResponseCallback != null) {
            statResponseCallback.onFail(e2);
        }
    }

    public boolean isStat() {
        return this.mIsStat;
    }

    public void setStat(boolean stat) {
        this.mIsStat = stat;
    }
}
