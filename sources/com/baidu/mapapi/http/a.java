package com.baidu.mapapi.http;

import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;

/* compiled from: AsyncHttpClient */
class a extends AsyncHttpClient.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HttpClient.ProtoResultCallback f14068a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f14069b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AsyncHttpClient f14070c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    a(AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback, String str) {
        super((a) null);
        this.f14070c = asyncHttpClient;
        this.f14068a = protoResultCallback;
        this.f14069b = str;
    }

    public void a() {
        HttpClient httpClient = new HttpClient("GET", this.f14068a);
        httpClient.setMaxTimeOut(this.f14070c.f14058a);
        httpClient.setReadTimeOut(this.f14070c.f14059b);
        httpClient.request(this.f14069b);
    }
}
