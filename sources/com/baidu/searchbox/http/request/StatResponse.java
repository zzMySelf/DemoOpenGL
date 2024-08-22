package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class StatResponse {
    private Response realResponse;
    private NetworkStatRecord statRecord;

    public StatResponse(Response response, NetworkStatRecord record) {
        this.realResponse = response;
        this.statRecord = record;
    }

    public StatResponse(NetworkStatRecord record) {
        this((Response) null, record);
    }

    public NetworkStatRecord getStatRecord() {
        return this.statRecord;
    }

    public Response getResponse() {
        return this.realResponse;
    }

    public ResponseBody body() {
        Response response = this.realResponse;
        if (response != null) {
            return response.body();
        }
        return null;
    }
}
