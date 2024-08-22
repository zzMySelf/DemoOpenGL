package com.baidu.searchbox.bddownload.core.connection;

import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.RedirectUtil;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.GetRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class DownloadHttpManagerConnection implements DownloadConnection, DownloadConnection.Connected {
    private static final String TAG = "DownloadHttpManagerConnection";
    private Request request;
    final GetRequest.GetRequestBuilder requestBuilder;
    Response response;

    DownloadHttpManagerConnection(GetRequest.GetRequestBuilder builder) {
        this.requestBuilder = builder;
    }

    public void addHeader(String name, String value) {
        Util.d(TAG, " addHeader name = " + name + "  value = " + value);
        this.requestBuilder.addHeader(name, value);
    }

    public DownloadConnection.Connected execute() throws IOException {
        GetRequest getRequest = this.requestBuilder.build();
        this.request = getRequest.getOkRequest();
        this.response = getRequest.executeSync();
        Util.d(TAG, "execute ");
        return this;
    }

    public void release() {
        this.request = null;
        Response response2 = this.response;
        if (response2 != null) {
            response2.close();
        }
        this.response = null;
    }

    public Map<String, List<String>> getRequestProperties() {
        Request request2 = this.request;
        if (request2 != null) {
            return request2.headers().toMultimap();
        }
        return this.requestBuilder.build().getOkRequest().headers().toMultimap();
    }

    public String getRequestProperty(String key) {
        Request request2 = this.request;
        if (request2 != null) {
            return request2.header(key);
        }
        return this.requestBuilder.build().getOkRequest().header(key);
    }

    public int getResponseCode() throws IOException {
        if (this.response != null) {
            Util.d(TAG, "getResponseCode " + this.response.code());
            return this.response.code();
        }
        throw new IOException("Please invoke execute first!");
    }

    public InputStream getInputStream() throws IOException {
        Response response2 = this.response;
        if (response2 != null) {
            ResponseBody body = response2.body();
            if (body != null) {
                return body.byteStream();
            }
            throw new IOException("no body found on response!");
        }
        throw new IOException("Please invoke execute first!");
    }

    public boolean setRequestMethod(String method) throws ProtocolException {
        Request request2 = this.request;
        if (request2 != null) {
            request2.newBuilder().method(method, (RequestBody) null);
            return true;
        }
        this.requestBuilder.build().getOkRequest().newBuilder().method(method, (RequestBody) null);
        return true;
    }

    public Map<String, List<String>> getResponseHeaderFields() {
        Response response2 = this.response;
        if (response2 == null) {
            return null;
        }
        return response2.headers().toMultimap();
    }

    public String getResponseHeaderField(String name) {
        Response response2 = this.response;
        if (response2 == null) {
            return null;
        }
        return response2.header(name);
    }

    public String getRedirectLocation() {
        Response priorRes = this.response.priorResponse();
        if (priorRes == null || !this.response.isSuccessful() || !RedirectUtil.isRedirect(priorRes.code())) {
            return null;
        }
        return this.response.request().url().toString();
    }

    public static class Factory implements DownloadConnection.Factory {
        public DownloadConnection create(String url) throws IOException {
            Util.d(DownloadHttpManagerConnection.TAG, " create url = " + url);
            return new DownloadHttpManagerConnection((GetRequest.GetRequestBuilder) HttpManager.getDefault(BdDownload.with().context()).getRequest().url(url));
        }
    }
}
