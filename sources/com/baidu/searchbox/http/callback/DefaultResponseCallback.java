package com.baidu.searchbox.http.callback;

import okhttp3.Response;

public abstract class DefaultResponseCallback extends ResponseCallback<Response> {
    public Response parseResponse(Response response, int statusCode) throws Exception {
        return response;
    }
}
