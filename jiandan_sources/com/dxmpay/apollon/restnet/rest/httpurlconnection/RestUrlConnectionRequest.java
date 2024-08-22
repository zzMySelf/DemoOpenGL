package com.dxmpay.apollon.restnet.rest.httpurlconnection;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.m.n.a;
import com.dxmpay.apollon.restnet.RestMultipartEntity;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.http.HttpDefines$HttpMethod;
import com.dxmpay.apollon.restnet.rest.RestHttpNetwork;
import com.dxmpay.apollon.restnet.rest.d;
import com.dxmpay.apollon.restnet.rest.e;
import com.dxmpay.wallet.core.utils.LogUtil;
import fe.i.qw.th.ad.qw;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import kotlin.text.Typography;

public class RestUrlConnectionRequest implements d {

    /* renamed from: ad  reason: collision with root package name */
    public final RestHttpNetwork f4035ad;

    /* renamed from: de  reason: collision with root package name */
    public final qw f4036de = new qw();

    /* renamed from: fe  reason: collision with root package name */
    public String f4037fe;

    /* renamed from: i  reason: collision with root package name */
    public RestMultipartEntity f4038i;

    /* renamed from: o  reason: collision with root package name */
    public int f4039o = -1;
    public long qw = 0;

    /* renamed from: rg  reason: collision with root package name */
    public HttpDefines$HttpMethod f4040rg;

    /* renamed from: th  reason: collision with root package name */
    public String f4041th;

    /* renamed from: uk  reason: collision with root package name */
    public List<RestNameValuePair> f4042uk;

    /* renamed from: yj  reason: collision with root package name */
    public String f4043yj;

    public RestUrlConnectionRequest(RestHttpNetwork restHttpNetwork, String str, HttpDefines$HttpMethod httpDefines$HttpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2) {
        this.f4035ad = restHttpNetwork;
        this.f4037fe = str2;
        this.f4040rg = httpDefines$HttpMethod;
        this.f4041th = str;
        this.f4042uk = list;
        this.f4038i = restMultipartEntity;
    }

    public qw a() {
        return this.f4036de;
    }

    public List<RestNameValuePair> ad() {
        return this.f4042uk;
    }

    public String b() {
        return this.f4041th;
    }

    public e c() throws Exception {
        if (!Thread.currentThread().isInterrupted()) {
            return this.f4035ad.performRequest(this);
        }
        return null;
    }

    public String d() {
        return this.f4037fe;
    }

    public RestMultipartEntity de() {
        return this.f4038i;
    }

    public void e() {
        this.f4035ad.close();
    }

    public String f() {
        return this.f4043yj;
    }

    public HttpDefines$HttpMethod fe() {
        return this.f4040rg;
    }

    public long g() {
        return this.qw;
    }

    public String getProcessedParams() {
        List<RestNameValuePair> list = this.f4042uk;
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (RestNameValuePair next : this.f4042uk) {
            String name = next.getName();
            String value = next.getValue();
            if (!TextUtils.isEmpty(name)) {
                if (value == null) {
                    value = "";
                }
                try {
                    sb.append(URLEncoder.encode(name, this.f4037fe));
                    sb.append(a.h);
                    sb.append(URLEncoder.encode(value, this.f4037fe));
                    sb.append(Typography.amp);
                } catch (UnsupportedEncodingException e) {
                    LogUtil.e("RestUrlConnectionRequest", e.getMessage(), e);
                }
            }
        }
        if (sb.length() > 1) {
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        return sb.toString();
    }

    public String h() {
        return Uri.parse(this.f4041th).getPath();
    }

    public void qw(String str) {
        this.f4041th = str;
    }

    public int rg() {
        return this.f4039o;
    }

    public boolean th() {
        return fe() == HttpDefines$HttpMethod.POST;
    }

    public boolean yj() {
        return fe() == HttpDefines$HttpMethod.GET;
    }

    public void a(int i2) {
        this.f4039o = i2;
    }

    public void a(String str) {
        this.f4043yj = str;
    }

    public void a(long j) {
        this.qw = j;
    }
}
