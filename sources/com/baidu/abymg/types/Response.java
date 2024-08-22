package com.baidu.abymg.types;

import java.util.List;
import java.util.Map;

public class Response {
    private byte[] respBody;
    private int respCode;
    private Map<String, List<String>> respHeaders;

    public Response() {
    }

    public Response(byte[] bArr, int i2, Map<String, List<String>> map) {
        this.respBody = bArr;
        this.respCode = i2;
        this.respHeaders = map;
    }

    public byte[] getRespBody() {
        return this.respBody;
    }

    public int getRespCode() {
        return this.respCode;
    }

    public Map<String, List<String>> getRespHeaders() {
        return this.respHeaders;
    }

    public void setRespBody(byte[] bArr) {
        this.respBody = bArr;
    }

    public void setRespCode(int i2) {
        this.respCode = i2;
    }

    public void setRespHeaders(Map<String, List<String>> map) {
        this.respHeaders = map;
    }
}
