package com.baidu.searchbox.live.goods.detail.impl.net;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.live.goods.detail.interfaces.net.INetWork;
import com.baidu.searchbox.live.goods.detail.interfaces.net.NetResponse;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J&\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J \u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019H\u0016J \u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\u001e\u0010\u001d\u001a\u00020\u00102\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019H\u0016J\u001e\u0010\u001e\u001a\u00020\u00102\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0012\u0010!\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016J(\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/live/goods/detail/impl/net/GoodsDetailNetworkImpl;", "Lcom/baidu/searchbox/live/goods/detail/interfaces/net/INetWork;", "()V", "bdTraceId", "", "connectTimeOut", "", "extra", "", "", "headers", "Ljava/util/HashMap;", "readTimeOut", "retryCount", "url", "cancel", "", "download", "key", "localPath", "callback", "Lcom/baidu/searchbox/live/goods/detail/interfaces/net/DownLoadCallback;", "getSync", "Lcom/baidu/searchbox/live/goods/detail/interfaces/net/NetResponse;", "params", "", "postSync", "setConnectTimeout", "timeout", "setExtra", "setHeaderData", "setReadTimeout", "setRetryCount", "setUrl", "transformMap", "lib-goods-detail-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GoodsDetailNetworkImpl.kt */
public final class GoodsDetailNetworkImpl implements INetWork {
    private String bdTraceId;
    private int connectTimeOut = -1;
    private Map<String, ? extends Object> extra;
    private HashMap<String, String> headers;
    private int readTimeOut = -1;
    private int retryCount = -1;
    private String url;

    public void setUrl(String url2) {
        this.url = url2;
    }

    public void setConnectTimeout(int timeout) {
        this.connectTimeOut = timeout;
    }

    public void setReadTimeout(int timeout) {
        this.readTimeOut = timeout;
    }

    public void setExtra(Map<String, Object> extra2) {
        this.extra = extra2;
    }

    public void setRetryCount(int retryCount2) {
        this.retryCount = retryCount2;
    }

    public void setHeaderData(HashMap<String, String> headers2) {
        this.headers = headers2;
    }

    public NetResponse postSync(Map<String, Object> params) {
        PostFormRequest.PostFormRequestBuilder builder = HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest();
        builder.url(this.url);
        if (params != null) {
            try {
                PostFormRequest.PostFormRequestBuilder postFormRequestBuilder = (PostFormRequest.PostFormRequestBuilder) builder.params(transformMap(params));
            } catch (Exception e2) {
            }
        }
        String str = null;
        try {
            Map<String, ? extends Object> map = this.extra;
            Object value = map != null ? MapsKt.getValue(map, "enableStat") : null;
            Boolean statEnable = value instanceof Boolean ? (Boolean) value : null;
            if (statEnable != null) {
                PostFormRequest.PostFormRequestBuilder postFormRequestBuilder2 = (PostFormRequest.PostFormRequestBuilder) builder.enableStat(statEnable.booleanValue());
            }
            Map<String, ? extends Object> map2 = this.extra;
            Object value2 = map2 != null ? MapsKt.getValue(map2, "requestFrom") : null;
            Integer requestFrom = value2 instanceof Integer ? (Integer) value2 : null;
            if (requestFrom != null) {
                PostFormRequest.PostFormRequestBuilder postFormRequestBuilder3 = (PostFormRequest.PostFormRequestBuilder) builder.requestFrom(requestFrom.intValue());
            }
            Map<String, ? extends Object> map3 = this.extra;
            Object value3 = map3 != null ? MapsKt.getValue(map3, "requestSubFrom") : null;
            Integer requestSubFrom = value3 instanceof Integer ? (Integer) value3 : null;
            if (requestSubFrom != null) {
                PostFormRequest.PostFormRequestBuilder postFormRequestBuilder4 = (PostFormRequest.PostFormRequestBuilder) builder.requestSubFrom(requestSubFrom.intValue());
            }
            HashMap it = this.headers;
            if (it != null) {
                PostFormRequest.PostFormRequestBuilder postFormRequestBuilder5 = (PostFormRequest.PostFormRequestBuilder) builder.addHeaders(it);
            }
            int i2 = this.connectTimeOut;
            if (i2 > 0) {
                builder.connectionTimeout(i2);
            }
            int i3 = this.readTimeOut;
            if (i3 > 0) {
                builder.readTimeout(i3);
            }
            builder.cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(true, false));
        } catch (Exception e3) {
        }
        try {
            PostFormRequest request = builder.build();
            this.bdTraceId = request.getBdTraceId();
            Response res = request.executeSync();
            if (res == null) {
                return null;
            }
            Response it2 = res;
            NetResponse netResponse = new NetResponse();
            NetResponse $this$postSync_u24lambda_u2d14_u24lambda_u2d13 = netResponse;
            $this$postSync_u24lambda_u2d14_u24lambda_u2d13.traceid = this.bdTraceId;
            $this$postSync_u24lambda_u2d14_u24lambda_u2d13.responseCode = it2.code();
            try {
                ResponseBody body = it2.body();
                if (body != null) {
                    str = body.string();
                }
                $this$postSync_u24lambda_u2d14_u24lambda_u2d13.decodedResponseStr = str;
                return netResponse;
            } catch (Exception e4) {
                NetResponse netResponse2 = new NetResponse();
                NetResponse $this$postSync_u24lambda_u2d14_u24lambda_u2d13_u24lambda_u2d12 = netResponse2;
                $this$postSync_u24lambda_u2d14_u24lambda_u2d13_u24lambda_u2d12.netErrorCode = -10;
                $this$postSync_u24lambda_u2d14_u24lambda_u2d13_u24lambda_u2d12.exception = e4.getMessage();
                return netResponse2;
            }
        } catch (SocketTimeoutException e5) {
            NetResponse netResponse3 = new NetResponse();
            NetResponse $this$postSync_u24lambda_u2d5 = netResponse3;
            $this$postSync_u24lambda_u2d5.netErrorCode = -13;
            $this$postSync_u24lambda_u2d5.exception = e5.getMessage();
            $this$postSync_u24lambda_u2d5.traceid = this.bdTraceId;
            return netResponse3;
        } catch (ConnectException e6) {
            NetResponse netResponse4 = new NetResponse();
            NetResponse $this$postSync_u24lambda_u2d6 = netResponse4;
            $this$postSync_u24lambda_u2d6.netErrorCode = -22;
            $this$postSync_u24lambda_u2d6.exception = e6.getMessage();
            $this$postSync_u24lambda_u2d6.traceid = this.bdTraceId;
            return netResponse4;
        } catch (SocketException e7) {
            NetResponse netResponse5 = new NetResponse();
            NetResponse $this$postSync_u24lambda_u2d7 = netResponse5;
            $this$postSync_u24lambda_u2d7.netErrorCode = -12;
            $this$postSync_u24lambda_u2d7.exception = e7.getMessage();
            $this$postSync_u24lambda_u2d7.traceid = this.bdTraceId;
            return netResponse5;
        } catch (SSLException e8) {
            NetResponse netResponse6 = new NetResponse();
            NetResponse $this$postSync_u24lambda_u2d8 = netResponse6;
            $this$postSync_u24lambda_u2d8.netErrorCode = -20;
            $this$postSync_u24lambda_u2d8.exception = e8.getMessage();
            $this$postSync_u24lambda_u2d8.traceid = this.bdTraceId;
            return netResponse6;
        } catch (UnknownHostException e9) {
            NetResponse netResponse7 = new NetResponse();
            NetResponse $this$postSync_u24lambda_u2d9 = netResponse7;
            $this$postSync_u24lambda_u2d9.netErrorCode = -21;
            $this$postSync_u24lambda_u2d9.exception = e9.getMessage();
            $this$postSync_u24lambda_u2d9.traceid = this.bdTraceId;
            return netResponse7;
        } catch (IOException e10) {
            NetResponse netResponse8 = new NetResponse();
            NetResponse $this$postSync_u24lambda_u2d10 = netResponse8;
            $this$postSync_u24lambda_u2d10.netErrorCode = -19;
            $this$postSync_u24lambda_u2d10.exception = e10.getMessage();
            $this$postSync_u24lambda_u2d10.traceid = this.bdTraceId;
            return netResponse8;
        } catch (Throwable e11) {
            NetResponse netResponse9 = new NetResponse();
            NetResponse $this$postSync_u24lambda_u2d11 = netResponse9;
            $this$postSync_u24lambda_u2d11.netErrorCode = -10;
            $this$postSync_u24lambda_u2d11.exception = e11.getMessage();
            $this$postSync_u24lambda_u2d11.traceid = this.bdTraceId;
            return netResponse9;
        }
    }

    public NetResponse getSync(Map<String, Object> params) {
        GetRequest.GetRequestBuilder builder = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest();
        builder.url(this.url);
        builder.tag(this);
        if (params != null) {
            try {
                builder.addUrlParams(transformMap(params));
            } catch (Exception e2) {
                Unit unit = Unit.INSTANCE;
            }
        }
        try {
            HashMap it = this.headers;
            if (it != null) {
                GetRequest.GetRequestBuilder getRequestBuilder = (GetRequest.GetRequestBuilder) builder.addHeaders(it);
            }
            int i2 = this.connectTimeOut;
            if (i2 > 0) {
                builder.connectionTimeout(i2);
            }
            int i3 = this.readTimeOut;
            if (i3 > 0) {
                builder.readTimeout(i3);
            }
            builder.cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(true, false));
        } catch (Exception e3) {
        }
        try {
            GetRequest request = builder.build();
            this.bdTraceId = request.getBdTraceId();
            Response res = request.executeSync();
            String str = null;
            if (res == null) {
                return null;
            }
            Response it2 = res;
            try {
                NetResponse netResponse = new NetResponse();
                NetResponse $this$getSync_u24lambda_u2d25_u24lambda_u2d24 = netResponse;
                $this$getSync_u24lambda_u2d25_u24lambda_u2d24.responseCode = it2.code();
                ResponseBody body = it2.body();
                if (body != null) {
                    str = body.string();
                }
                $this$getSync_u24lambda_u2d25_u24lambda_u2d24.decodedResponseStr = str;
                $this$getSync_u24lambda_u2d25_u24lambda_u2d24.traceid = this.bdTraceId;
                return netResponse;
            } catch (SocketTimeoutException e4) {
                NetResponse netResponse2 = new NetResponse();
                NetResponse $this$getSync_u24lambda_u2d26 = netResponse2;
                $this$getSync_u24lambda_u2d26.netErrorCode = -13;
                $this$getSync_u24lambda_u2d26.exception = e4.getMessage();
                $this$getSync_u24lambda_u2d26.traceid = this.bdTraceId;
                return netResponse2;
            } catch (SSLException e5) {
                NetResponse netResponse3 = new NetResponse();
                NetResponse $this$getSync_u24lambda_u2d27 = netResponse3;
                $this$getSync_u24lambda_u2d27.netErrorCode = -20;
                $this$getSync_u24lambda_u2d27.exception = e5.getMessage();
                $this$getSync_u24lambda_u2d27.traceid = this.bdTraceId;
                return netResponse3;
            } catch (Throwable e6) {
                NetResponse netResponse4 = new NetResponse();
                NetResponse $this$getSync_u24lambda_u2d28 = netResponse4;
                $this$getSync_u24lambda_u2d28.netErrorCode = -10;
                $this$getSync_u24lambda_u2d28.exception = e6.getMessage();
                $this$getSync_u24lambda_u2d28.traceid = this.bdTraceId;
                return netResponse4;
            }
        } catch (SocketTimeoutException e7) {
            NetResponse netResponse5 = new NetResponse();
            NetResponse $this$getSync_u24lambda_u2d17 = netResponse5;
            $this$getSync_u24lambda_u2d17.netErrorCode = -13;
            $this$getSync_u24lambda_u2d17.exception = e7.getMessage();
            $this$getSync_u24lambda_u2d17.traceid = this.bdTraceId;
            return netResponse5;
        } catch (ConnectException e8) {
            NetResponse netResponse6 = new NetResponse();
            NetResponse $this$getSync_u24lambda_u2d18 = netResponse6;
            $this$getSync_u24lambda_u2d18.netErrorCode = -22;
            $this$getSync_u24lambda_u2d18.exception = e8.getMessage();
            $this$getSync_u24lambda_u2d18.traceid = this.bdTraceId;
            return netResponse6;
        } catch (SocketException e9) {
            NetResponse netResponse7 = new NetResponse();
            NetResponse $this$getSync_u24lambda_u2d19 = netResponse7;
            $this$getSync_u24lambda_u2d19.netErrorCode = -12;
            $this$getSync_u24lambda_u2d19.exception = e9.getMessage();
            $this$getSync_u24lambda_u2d19.traceid = this.bdTraceId;
            return netResponse7;
        } catch (SSLException e10) {
            NetResponse netResponse8 = new NetResponse();
            NetResponse $this$getSync_u24lambda_u2d20 = netResponse8;
            $this$getSync_u24lambda_u2d20.netErrorCode = -20;
            $this$getSync_u24lambda_u2d20.exception = e10.getMessage();
            $this$getSync_u24lambda_u2d20.traceid = this.bdTraceId;
            return netResponse8;
        } catch (UnknownHostException e11) {
            NetResponse netResponse9 = new NetResponse();
            NetResponse $this$getSync_u24lambda_u2d21 = netResponse9;
            $this$getSync_u24lambda_u2d21.netErrorCode = -21;
            $this$getSync_u24lambda_u2d21.exception = e11.getMessage();
            $this$getSync_u24lambda_u2d21.traceid = this.bdTraceId;
            return netResponse9;
        } catch (IOException e12) {
            NetResponse netResponse10 = new NetResponse();
            NetResponse $this$getSync_u24lambda_u2d22 = netResponse10;
            $this$getSync_u24lambda_u2d22.netErrorCode = -19;
            $this$getSync_u24lambda_u2d22.exception = e12.getMessage();
            $this$getSync_u24lambda_u2d22.traceid = this.bdTraceId;
            return netResponse10;
        } catch (Throwable e13) {
            NetResponse netResponse11 = new NetResponse();
            NetResponse $this$getSync_u24lambda_u2d23 = netResponse11;
            $this$getSync_u24lambda_u2d23.netErrorCode = -10;
            $this$getSync_u24lambda_u2d23.exception = e13.getMessage();
            $this$getSync_u24lambda_u2d23.traceid = this.bdTraceId;
            return netResponse11;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0191 A[Catch:{ Exception -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x019d A[Catch:{ Exception -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x011f A[Catch:{ Exception -> 0x0132, all -> 0x012c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void download(java.lang.Object r25, java.lang.String r26, com.baidu.searchbox.live.goods.detail.interfaces.net.DownLoadCallback r27) {
        /*
            r24 = this;
            r1 = r24
            r8 = r25
            r9 = r27
            android.content.Context r0 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            com.baidu.searchbox.http.HttpManager r0 = com.baidu.searchbox.http.HttpManager.getDefault(r0)
            com.baidu.searchbox.http.request.GetRequest$GetRequestBuilder r10 = r0.getRequest()
            java.lang.String r0 = r1.url
            r10.url(r0)
            r10.tag(r1)
            r2 = 0
            r3 = 1
            r11 = 0
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r1.headers     // Catch:{ Exception -> 0x0059 }
            if (r0 == 0) goto L_0x002d
            r4 = 0
            r5 = r0
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0059 }
            com.baidu.searchbox.http.request.HttpRequestBuilder r5 = r10.addHeaders(r5)     // Catch:{ Exception -> 0x0059 }
            com.baidu.searchbox.http.request.GetRequest$GetRequestBuilder r5 = (com.baidu.searchbox.http.request.GetRequest.GetRequestBuilder) r5     // Catch:{ Exception -> 0x0059 }
        L_0x002d:
            int r0 = r1.connectTimeOut     // Catch:{ Exception -> 0x0059 }
            if (r0 <= 0) goto L_0x0034
            r10.connectionTimeout(r0)     // Catch:{ Exception -> 0x0059 }
        L_0x0034:
            int r0 = r1.readTimeOut     // Catch:{ Exception -> 0x0059 }
            if (r0 <= 0) goto L_0x003b
            r10.readTimeout(r0)     // Catch:{ Exception -> 0x0059 }
        L_0x003b:
            java.lang.String r0 = r1.url     // Catch:{ Exception -> 0x0059 }
            if (r0 == 0) goto L_0x004a
            java.lang.String r4 = "https://"
            r5 = 2
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r4, r11, r5, r2)     // Catch:{ Exception -> 0x0059 }
            if (r0 != r3) goto L_0x004a
            r0 = r3
            goto L_0x004b
        L_0x004a:
            r0 = r11
        L_0x004b:
            if (r0 == 0) goto L_0x005a
            com.baidu.searchbox.feed.IFeedContext r4 = com.baidu.searchbox.feed.FeedRuntime.getFeedContext()     // Catch:{ Exception -> 0x0059 }
            com.baidu.searchbox.http.cookie.CookieManager r4 = r4.newCookieManagerInstance(r3, r11)     // Catch:{ Exception -> 0x0059 }
            r10.cookieManager(r4)     // Catch:{ Exception -> 0x0059 }
            goto L_0x005a
        L_0x0059:
            r0 = move-exception
        L_0x005a:
            r4 = 0
            r5 = -10
            com.baidu.searchbox.http.request.GetRequest r0 = r10.build()     // Catch:{ SocketTimeoutException -> 0x0228, ConnectException -> 0x0218, SocketException -> 0x0208, SSLException -> 0x01f8, UnknownHostException -> 0x01e8, IOException -> 0x01d8, all -> 0x01ca }
            okhttp3.Response r0 = r0.executeSync()     // Catch:{ SocketTimeoutException -> 0x0228, ConnectException -> 0x0218, SocketException -> 0x0208, SSLException -> 0x01f8, UnknownHostException -> 0x01e8, IOException -> 0x01d8, all -> 0x01ca }
            r13 = r0
            if (r13 == 0) goto L_0x0070
            boolean r0 = r13.isSuccessful()
            if (r0 != r3) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r3 = r11
        L_0x0071:
            if (r3 == 0) goto L_0x01b7
            if (r13 == 0) goto L_0x007f
            okhttp3.ResponseBody r0 = r13.body()
            if (r0 == 0) goto L_0x007f
            java.io.InputStream r2 = r0.byteStream()
        L_0x007f:
            r14 = r2
            r2 = 0
            if (r14 == 0) goto L_0x01a3
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0174, all -> 0x016f }
            r15 = r26
            r0.<init>(r15)     // Catch:{ Exception -> 0x016d }
            java.io.File r3 = r0.getParentFile()     // Catch:{ Exception -> 0x016d }
            r16 = r3
            boolean r3 = r16.exists()     // Catch:{ Exception -> 0x016d }
            if (r3 != 0) goto L_0x009a
            r16.mkdirs()     // Catch:{ Exception -> 0x016d }
        L_0x009a:
            boolean r3 = r0.exists()     // Catch:{ Exception -> 0x016d }
            if (r3 == 0) goto L_0x00a3
            r0.delete()     // Catch:{ Exception -> 0x016d }
        L_0x00a3:
            boolean r3 = r0.createNewFile()     // Catch:{ Exception -> 0x016d }
            if (r3 == 0) goto L_0x014d
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x016d }
            r3.<init>(r0)     // Catch:{ Exception -> 0x016d }
            r6 = r3
            r2 = 2048(0x800, float:2.87E-42)
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x0147, all -> 0x0140 }
            r7 = r2
            r2 = 0
            r3 = 0
            if (r13 == 0) goto L_0x00cd
            okhttp3.ResponseBody r17 = r13.body()     // Catch:{ Exception -> 0x00c9, all -> 0x00c4 }
            if (r17 == 0) goto L_0x00cd
            long r17 = r17.contentLength()     // Catch:{ Exception -> 0x00c9, all -> 0x00c4 }
            goto L_0x00cf
        L_0x00c4:
            r0 = move-exception
            r3 = r0
            r2 = r6
            goto L_0x018b
        L_0x00c9:
            r0 = move-exception
            r2 = r6
            goto L_0x0177
        L_0x00cd:
            r17 = r3
        L_0x00cf:
            int r3 = (r17 > r3 ? 1 : (r17 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x011f
            r3 = 0
        L_0x00d5:
            int r5 = r14.read(r7)     // Catch:{ Exception -> 0x0147, all -> 0x0140 }
            r19 = r5
            r20 = 0
            r2 = r19
            r12 = -1
            if (r5 == r12) goto L_0x0109
            r6.write(r7, r11, r2)     // Catch:{ Exception -> 0x0147, all -> 0x0140 }
            long r11 = (long) r2
            long r11 = r11 + r3
            if (r9 == 0) goto L_0x00fa
            r21 = r2
            r2 = r27
            r3 = r25
            r4 = r11
            r22 = r6
            r23 = r7
            r6 = r17
            r2.onFileUpdateProgress(r3, r4, r6)     // Catch:{ Exception -> 0x0132, all -> 0x012c }
            goto L_0x0100
        L_0x00fa:
            r21 = r2
            r22 = r6
            r23 = r7
        L_0x0100:
            r3 = r11
            r2 = r21
            r6 = r22
            r7 = r23
            r11 = 0
            goto L_0x00d5
        L_0x0109:
            r21 = r2
            r22 = r6
            r23 = r7
            r22.flush()     // Catch:{ Exception -> 0x0132, all -> 0x012c }
            if (r9 == 0) goto L_0x013d
            int r2 = r13.code()     // Catch:{ Exception -> 0x0132, all -> 0x012c }
            java.lang.String r5 = ""
            r6 = 0
            r9.onFileDownloaded(r8, r2, r6, r5)     // Catch:{ Exception -> 0x0132, all -> 0x012c }
            goto L_0x013d
        L_0x011f:
            r22 = r6
            r23 = r7
            if (r9 == 0) goto L_0x013d
            if (r13 == 0) goto L_0x0136
            int r3 = r13.code()     // Catch:{ Exception -> 0x0132, all -> 0x012c }
            goto L_0x0137
        L_0x012c:
            r0 = move-exception
            r3 = r0
            r2 = r22
            goto L_0x018b
        L_0x0132:
            r0 = move-exception
            r2 = r22
            goto L_0x0177
        L_0x0136:
            r3 = 0
        L_0x0137:
            java.lang.String r4 = "no content length"
            r9.onFileDownloaded(r8, r3, r5, r4)     // Catch:{ Exception -> 0x0132, all -> 0x012c }
        L_0x013d:
            r2 = r22
            goto L_0x015f
        L_0x0140:
            r0 = move-exception
            r22 = r6
            r3 = r0
            r2 = r22
            goto L_0x018b
        L_0x0147:
            r0 = move-exception
            r22 = r6
            r2 = r22
            goto L_0x0177
        L_0x014d:
            if (r9 == 0) goto L_0x015f
            if (r13 == 0) goto L_0x0156
            int r3 = r13.code()     // Catch:{ Exception -> 0x016d }
            goto L_0x0157
        L_0x0156:
            r3 = 0
        L_0x0157:
            java.lang.String r4 = "mkdir fail"
            r5 = -19
            r9.onFileDownloaded(r8, r3, r5, r4)     // Catch:{ Exception -> 0x016d }
        L_0x015f:
            r14.close()     // Catch:{ Exception -> 0x0169 }
            if (r2 == 0) goto L_0x01a2
            r2.close()     // Catch:{ Exception -> 0x0169 }
            goto L_0x01a2
        L_0x0169:
            r0 = move-exception
            goto L_0x01a2
        L_0x016b:
            r0 = move-exception
            goto L_0x0172
        L_0x016d:
            r0 = move-exception
            goto L_0x0177
        L_0x016f:
            r0 = move-exception
            r15 = r26
        L_0x0172:
            r3 = r0
            goto L_0x018b
        L_0x0174:
            r0 = move-exception
            r15 = r26
        L_0x0177:
            if (r9 == 0) goto L_0x0197
            if (r13 == 0) goto L_0x0180
            int r11 = r13.code()     // Catch:{ all -> 0x016b }
            goto L_0x0181
        L_0x0180:
            r11 = 0
        L_0x0181:
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x016b }
            r4 = -19
            r9.onFileDownloaded(r8, r11, r4, r3)     // Catch:{ all -> 0x016b }
            goto L_0x0197
        L_0x018b:
            r14.close()     // Catch:{ Exception -> 0x0195 }
            if (r2 == 0) goto L_0x0196
            r2.close()     // Catch:{ Exception -> 0x0195 }
            goto L_0x0196
        L_0x0195:
            r0 = move-exception
        L_0x0196:
            throw r3
        L_0x0197:
            r14.close()     // Catch:{ Exception -> 0x01a1 }
            if (r2 == 0) goto L_0x01a2
            r2.close()     // Catch:{ Exception -> 0x01a1 }
            goto L_0x01a2
        L_0x01a1:
            r0 = move-exception
        L_0x01a2:
            goto L_0x01c9
        L_0x01a3:
            r15 = r26
            if (r9 == 0) goto L_0x01c9
            if (r13 == 0) goto L_0x01ae
            int r11 = r13.code()
            goto L_0x01af
        L_0x01ae:
            r11 = 0
        L_0x01af:
            java.lang.String r0 = "no response data"
            r9.onFileDownloaded(r8, r11, r5, r0)
            goto L_0x01c9
        L_0x01b7:
            r15 = r26
            if (r9 == 0) goto L_0x01c9
            if (r13 == 0) goto L_0x01c2
            int r11 = r13.code()
            goto L_0x01c3
        L_0x01c2:
            r11 = 0
        L_0x01c3:
            java.lang.String r0 = "http error"
            r9.onFileDownloaded(r8, r11, r5, r0)
        L_0x01c9:
            return
        L_0x01ca:
            r0 = move-exception
            r15 = r26
            if (r9 == 0) goto L_0x01d7
            java.lang.String r2 = r0.getMessage()
            r3 = 0
            r9.onFileDownloaded(r8, r3, r5, r2)
        L_0x01d7:
            return
        L_0x01d8:
            r0 = move-exception
            r15 = r26
            if (r9 == 0) goto L_0x01e7
            java.lang.String r2 = r0.getMessage()
            r3 = -19
            r5 = 0
            r9.onFileDownloaded(r8, r5, r3, r2)
        L_0x01e7:
            return
        L_0x01e8:
            r0 = move-exception
            r15 = r26
            if (r9 == 0) goto L_0x01f7
            r2 = -21
            java.lang.String r3 = r0.getMessage()
            r5 = 0
            r9.onFileDownloaded(r8, r5, r2, r3)
        L_0x01f7:
            return
        L_0x01f8:
            r0 = move-exception
            r15 = r26
            if (r9 == 0) goto L_0x0207
            r2 = -20
            java.lang.String r3 = r0.getMessage()
            r5 = 0
            r9.onFileDownloaded(r8, r5, r2, r3)
        L_0x0207:
            return
        L_0x0208:
            r0 = move-exception
            r15 = r26
            if (r9 == 0) goto L_0x0217
            r2 = -12
            java.lang.String r3 = r0.getMessage()
            r5 = 0
            r9.onFileDownloaded(r8, r5, r2, r3)
        L_0x0217:
            return
        L_0x0218:
            r0 = move-exception
            r15 = r26
            if (r9 == 0) goto L_0x0227
            r2 = -22
            java.lang.String r3 = r0.getMessage()
            r5 = 0
            r9.onFileDownloaded(r8, r5, r2, r3)
        L_0x0227:
            return
        L_0x0228:
            r0 = move-exception
            r15 = r26
            if (r9 == 0) goto L_0x0237
            r2 = -13
            java.lang.String r3 = r0.getMessage()
            r5 = 0
            r9.onFileDownloaded(r8, r5, r2, r3)
        L_0x0237:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.live.goods.detail.impl.net.GoodsDetailNetworkImpl.download(java.lang.Object, java.lang.String, com.baidu.searchbox.live.goods.detail.interfaces.net.DownLoadCallback):void");
    }

    public void cancel() {
        HttpManager.getDefault(AppRuntime.getAppContext()).cancelTag(this);
    }

    private final Map<String, String> transformMap(Map<String, ? extends Object> params) {
        Map ret = new HashMap();
        for (Map.Entry it : params.entrySet()) {
            if ((((CharSequence) it.getKey()).length() > 0) && (it.getValue() instanceof String)) {
                ret.put(it.getKey(), (String) it.getValue());
            }
        }
        return ret;
    }
}
