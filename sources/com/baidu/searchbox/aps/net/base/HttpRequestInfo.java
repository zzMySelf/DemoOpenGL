package com.baidu.searchbox.aps.net.base;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HttpRequestInfo {
    public static final byte AUTH_BASIC = 2;
    public static final byte AUTH_NONE = 1;
    public static final byte AUTH_UNKNOWN = 0;
    public static final byte HTTP_GET = 1;
    public static final byte HTTP_HEAD = 4;
    public static final byte HTTP_POST = 2;
    public static final byte HTTP_PUT = 3;
    public static final byte HTTP_UNKNOWN = 0;
    public static final int PORT_HTTP = 80;
    public static final int PORT_HTTPS = 443;
    public static final String PREFIX_HTTP = "http";
    public static final String PREFIX_HTTPS = "https";
    public static final int TIME_OUT = 30000;
    final byte auth;
    private List<ParamPair<?>> headers;
    final int time;
    final byte type;
    final String url;

    public HttpRequestInfo(String url2, byte type2) {
        this(url2, type2, 30000);
    }

    public HttpRequestInfo(String url2, byte type2, int time2) {
        this(url2, type2, time2, (byte) 1);
    }

    public HttpRequestInfo(String url2, byte type2, int time2, byte auth2) {
        this.url = url2;
        this.type = type2;
        this.time = time2;
        this.auth = 1;
    }

    public String url() {
        return this.url;
    }

    public byte type() {
        return this.type;
    }

    public byte auth() {
        return this.auth;
    }

    public int time() {
        return this.time;
    }

    public List<ParamPair<?>> getHeaders() {
        return this.headers;
    }

    public <T> void addHeader(String key, T value) {
        if (this.headers == null) {
            this.headers = new ArrayList();
        }
        Iterator<ParamPair<?>> it = this.headers.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ParamPair<?> header = it.next();
            if (TextUtils.equals(header.getName(), key)) {
                this.headers.remove(header);
                break;
            }
        }
        this.headers.add(new ParamPair(key, value));
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof HttpRequestInfo)) {
            return false;
        }
        HttpRequestInfo info = (HttpRequestInfo) obj;
        if (this == info || (this.url.equals(info.url()) && this.type == info.type() && this.time == info.time() && this.auth == info.auth())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.url.hashCode() + this.type + this.time + this.auth;
    }

    public String toString() {
        return "{url=" + this.url + ", type=" + this.type + ", time=" + this.time + ", auth=" + this.auth + i.f2534d;
    }
}
