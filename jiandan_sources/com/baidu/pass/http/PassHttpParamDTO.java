package com.baidu.pass.http;

import com.baidu.pass.a;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;

public class PassHttpParamDTO implements a {
    public boolean asyncCookie = false;
    public int connectTimeout;
    public List<HttpCookie> cookie;
    public HashMap<String, String> headers = new HashMap<>(1);
    public HttpHashMap paramsMap = new HttpHashMap();
    public ReqPriority priority = ReqPriority.NORMAL;
    public String proxyHost;
    public int proxyPort = 443;
    public String url;
    public String userAgent;
}
