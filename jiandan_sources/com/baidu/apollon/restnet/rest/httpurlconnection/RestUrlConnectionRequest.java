package com.baidu.apollon.restnet.rest.httpurlconnection;

import android.text.TextUtils;
import com.baidu.apollon.restnet.RestMultipartEntity;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.http.HttpDefines;
import com.baidu.apollon.restnet.http.a;
import com.baidu.apollon.restnet.rest.RestHttpNetwork;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.apollon.restnet.rest.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import kotlin.text.Typography;

public class RestUrlConnectionRequest implements d {
    public final RestHttpNetwork a;
    public final a b = new a();
    public String c;
    public HttpDefines.HttpMethod d;
    public String e;
    public String f;
    public List<RestNameValuePair> g;
    public RestMultipartEntity h;

    /* renamed from: i  reason: collision with root package name */
    public int f711i = -1;

    public RestUrlConnectionRequest(RestHttpNetwork restHttpNetwork, String str, HttpDefines.HttpMethod httpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2) {
        this.a = restHttpNetwork;
        this.c = str2;
        this.d = httpMethod;
        this.e = str;
        this.g = list;
        this.h = restMultipartEntity;
    }

    public a a() {
        return this.b;
    }

    public HttpDefines.HttpMethod b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public e d() throws Exception {
        if (!Thread.currentThread().isInterrupted()) {
            return this.a.a(this);
        }
        return null;
    }

    public String e() {
        return this.c;
    }

    public void f() {
        this.a.a();
    }

    public int g() {
        return this.f711i;
    }

    public String getProcessedParams() {
        List<RestNameValuePair> list = this.g;
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (RestNameValuePair next : this.g) {
            String name = next.getName();
            String value = next.getValue();
            if (!TextUtils.isEmpty(name)) {
                if (value == null) {
                    value = "";
                }
                try {
                    sb.append(URLEncoder.encode(name, this.c));
                    sb.append(com.alipay.sdk.m.n.a.h);
                    sb.append(URLEncoder.encode(value, this.c));
                    sb.append(Typography.amp);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (sb.length() > 1) {
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        return sb.toString();
    }

    public String h() {
        return this.f;
    }

    public RestMultipartEntity i() {
        return this.h;
    }

    public boolean j() {
        return b() == HttpDefines.HttpMethod.POST;
    }

    public boolean k() {
        return b() == HttpDefines.HttpMethod.GET;
    }

    public void a(int i2) {
        this.f711i = i2;
    }

    public void b(String str) {
        this.e = str;
    }

    public void a(String str) {
        this.f = str;
    }
}
