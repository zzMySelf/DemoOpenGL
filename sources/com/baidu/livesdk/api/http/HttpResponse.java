package com.baidu.livesdk.api.http;

import java.util.List;
import java.util.Map;

public class HttpResponse {
    private String content;
    private Map<String, List<String>> headers;
    private int responseCode = 0;

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(int responseCode2) {
        this.responseCode = responseCode2;
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, List<String>> headers2) {
        this.headers = headers2;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content2) {
        this.content = content2;
    }
}
