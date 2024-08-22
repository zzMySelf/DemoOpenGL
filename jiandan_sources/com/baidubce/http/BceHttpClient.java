package com.baidubce.http;

import android.annotation.SuppressLint;
import com.baidubce.BceClientConfiguration;
import com.baidubce.BceClientException;
import com.baidubce.auth.Signer;
import com.baidubce.callback.BceProgressCallback;
import com.baidubce.internal.InternalRequest;
import com.baidubce.model.AbstractBceRequest;
import com.baidubce.util.CheckUtils;
import com.baidubce.util.HttpUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

@SuppressLint({"NewApi"})
public class BceHttpClient {
    public static final HttpClientFactory httpClientFactory = new HttpClientFactory();
    public final BceClientConfiguration config;
    public long diffMillis;
    public OkHttpClient httpClient;
    public final Signer signer;

    public BceHttpClient(BceClientConfiguration bceClientConfiguration, Signer signer2) {
        this(bceClientConfiguration, httpClientFactory.createHttpClient(bceClientConfiguration), signer2);
    }

    public <T extends AbstractBceRequest> OkHttpClient addResponseProgressCallback(final T t, final BceProgressCallback<T> bceProgressCallback) {
        return this.httpClient.newBuilder().addNetworkInterceptor(new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Response proceed = chain.proceed(chain.request());
                return proceed.newBuilder().body(new BceServiceResponseBody(proceed.body(), t, bceProgressCallback)).build();
            }
        }).build();
    }

    public <T extends AbstractBceRequest> Request createHttpRequest(InternalRequest<T> internalRequest, BceProgressCallback<T> bceProgressCallback) {
        String aSCIIString = internalRequest.getUri().toASCIIString();
        String canonicalQueryString = HttpUtils.getCanonicalQueryString(internalRequest.getParameters(), false);
        if (canonicalQueryString.length() > 0) {
            aSCIIString = aSCIIString + "?" + canonicalQueryString;
        }
        Request.Builder url = new Request.Builder().url(aSCIIString);
        if (internalRequest.getHttpMethod() == HttpMethodName.GET) {
            url.get();
        } else if (internalRequest.getHttpMethod() == HttpMethodName.PUT) {
            if (internalRequest.getContent() != null) {
                url.put(new BceServiceRequestBody(internalRequest, bceProgressCallback));
            } else {
                url.put(RequestBody.create((MediaType) null, new byte[0]));
            }
        } else if (internalRequest.getHttpMethod() == HttpMethodName.POST) {
            if (internalRequest.getContent() != null) {
                url.post(new BceServiceRequestBody(internalRequest, bceProgressCallback));
            } else {
                url.post(RequestBody.create((MediaType) null, new byte[0]));
            }
        } else if (internalRequest.getHttpMethod() == HttpMethodName.DELETE) {
            url.delete();
        } else if (internalRequest.getHttpMethod() == HttpMethodName.HEAD) {
            url.head();
        } else {
            throw new BceClientException("Unknown HTTP method name: " + internalRequest.getHttpMethod());
        }
        for (Map.Entry next : internalRequest.getHeaders().entrySet()) {
            if (!((String) next.getKey()).equalsIgnoreCase("Content-Length") && !((String) next.getKey()).equalsIgnoreCase("Host")) {
                url.addHeader((String) next.getKey(), (String) next.getValue());
            }
        }
        return url.build();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.baidubce.internal.InternalRequest, com.baidubce.internal.InternalRequest<M>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends com.baidubce.model.AbstractBceResponse, M extends com.baidubce.model.AbstractBceRequest> T execute(com.baidubce.internal.InternalRequest<M> r2, java.lang.Class<T> r3, com.baidubce.http.handler.HttpResponseHandler[] r4) {
        /*
            r1 = this;
            r0 = 0
            com.baidubce.model.AbstractBceResponse r2 = r1.execute(r2, r3, r4, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidubce.http.BceHttpClient.execute(com.baidubce.internal.InternalRequest, java.lang.Class, com.baidubce.http.handler.HttpResponseHandler[]):com.baidubce.model.AbstractBceResponse");
    }

    public long getDelayBeforeNextRetryInMillis(InternalRequest internalRequest, BceClientException bceClientException, int i2, RetryPolicy retryPolicy) {
        int i3 = i2 - 1;
        if (i3 >= retryPolicy.getMaxErrorRetry()) {
            return -1;
        }
        return Math.min(retryPolicy.getMaxDelayInMillis(), retryPolicy.getDelayBeforeNextRetryInMillis(bceClientException, i3));
    }

    public BceHttpClient(BceClientConfiguration bceClientConfiguration, OkHttpClient okHttpClient, Signer signer2) {
        this.diffMillis = 0;
        CheckUtils.isNotNull(bceClientConfiguration, "config should not be null.");
        CheckUtils.isNotNull(signer2, "signer should not be null.");
        this.config = bceClientConfiguration;
        this.httpClient = okHttpClient;
        this.signer = signer2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x016b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends com.baidubce.model.AbstractBceResponse, M extends com.baidubce.model.AbstractBceRequest> T execute(com.baidubce.internal.InternalRequest<M> r17, java.lang.Class<T> r18, com.baidubce.http.handler.HttpResponseHandler[] r19, com.baidubce.callback.BceProgressCallback<M> r20) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = r19
            java.lang.String r0 = "User-Agent"
            com.baidubce.BceClientConfiguration r4 = r1.config
            java.lang.String r4 = r4.getUserAgent()
            r2.addHeader(r0, r4)
            java.lang.String r0 = "Accept-Encoding"
            com.baidubce.BceClientConfiguration r4 = r1.config
            java.lang.String r4 = r4.getAcceptEncoding()
            r2.addHeader(r0, r4)
            com.baidubce.BceClientConfiguration r0 = r1.config
            com.baidubce.auth.BceCredentials r0 = r0.getCredentials()
            com.baidubce.auth.BceCredentials r4 = r17.getCredentials()
            if (r4 == 0) goto L_0x002c
            com.baidubce.auth.BceCredentials r0 = r17.getCredentials()
        L_0x002c:
            r4 = r0
            java.lang.String r0 = ""
            r5 = 1
            r6 = 0
            r5 = r0
            r9 = r6
            r8 = 1
        L_0x0035:
            java.util.Calendar r0 = java.util.Calendar.getInstance()     // Catch:{ SocketTimeoutException -> 0x0102, BceServiceException -> 0x00d7, BceClientException -> 0x00d2, Exception -> 0x00c7 }
            long r9 = r0.getTimeInMillis()     // Catch:{ SocketTimeoutException -> 0x0102, BceServiceException -> 0x00d7, BceClientException -> 0x00d2, Exception -> 0x00c7 }
            java.util.Date r0 = new java.util.Date     // Catch:{ SocketTimeoutException -> 0x0102, BceServiceException -> 0x00d7, BceClientException -> 0x00d2, Exception -> 0x00c7 }
            long r11 = r1.diffMillis     // Catch:{ SocketTimeoutException -> 0x0102, BceServiceException -> 0x00d7, BceClientException -> 0x00d2, Exception -> 0x00c7 }
            long r11 = r11 + r9
            r0.<init>(r11)     // Catch:{ SocketTimeoutException -> 0x0102, BceServiceException -> 0x00d7, BceClientException -> 0x00d2, Exception -> 0x00c7 }
            com.baidubce.auth.SignOptions r11 = r17.getSignOptions()     // Catch:{ SocketTimeoutException -> 0x0102, BceServiceException -> 0x00d7, BceClientException -> 0x00d2, Exception -> 0x00c7 }
            if (r11 != 0) goto L_0x004e
            com.baidubce.auth.SignOptions r11 = com.baidubce.auth.SignOptions.DEFAULT     // Catch:{ SocketTimeoutException -> 0x0102, BceServiceException -> 0x00d7, BceClientException -> 0x00d2, Exception -> 0x00c7 }
            goto L_0x0052
        L_0x004e:
            com.baidubce.auth.SignOptions r11 = r17.getSignOptions()     // Catch:{ SocketTimeoutException -> 0x0102, BceServiceException -> 0x00d7, BceClientException -> 0x00d2, Exception -> 0x00c7 }
        L_0x0052:
            r11.setTimestamp(r0)     // Catch:{ SocketTimeoutException -> 0x0102, BceServiceException -> 0x00d7, BceClientException -> 0x00d2, Exception -> 0x00c7 }
            r2.setSignOptions(r11)     // Catch:{ SocketTimeoutException -> 0x0102, BceServiceException -> 0x00d7, BceClientException -> 0x00d2, Exception -> 0x00c7 }
            long r11 = r1.diffMillis     // Catch:{ SocketTimeoutException -> 0x0102, BceServiceException -> 0x00d7, BceClientException -> 0x00d2, Exception -> 0x00c7 }
            int r13 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r13 == 0) goto L_0x0067
            java.lang.String r11 = "x-bce-date"
            java.lang.String r0 = com.baidubce.util.DateUtils.alternateIso8601DateFormat(r0)     // Catch:{ SocketTimeoutException -> 0x0102, BceServiceException -> 0x00d7, BceClientException -> 0x00d2, Exception -> 0x00c7 }
            r2.addHeader(r11, r0)     // Catch:{ SocketTimeoutException -> 0x0102, BceServiceException -> 0x00d7, BceClientException -> 0x00d2, Exception -> 0x00c7 }
        L_0x0067:
            if (r4 == 0) goto L_0x006e
            com.baidubce.auth.Signer r0 = r1.signer     // Catch:{ SocketTimeoutException -> 0x0102, BceServiceException -> 0x00d7, BceClientException -> 0x00d2, Exception -> 0x00c7 }
            r0.sign(r2, r4)     // Catch:{ SocketTimeoutException -> 0x0102, BceServiceException -> 0x00d7, BceClientException -> 0x00d2, Exception -> 0x00c7 }
        L_0x006e:
            okhttp3.OkHttpClient r0 = r1.httpClient     // Catch:{ SocketTimeoutException -> 0x0102, BceServiceException -> 0x00d7, BceClientException -> 0x00d2, Exception -> 0x00c7 }
            r11 = r20
            okhttp3.Request r12 = r1.createHttpRequest(r2, r11)     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            com.baidubce.model.AbstractBceRequest r13 = r17.getRequest()     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            boolean r13 = r13 instanceof com.baidubce.services.bos.model.GetObjectRequest     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            if (r13 == 0) goto L_0x0095
            com.baidubce.model.AbstractBceRequest r0 = r17.getRequest()     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            com.baidubce.model.AbstractBceRequest r13 = r17.getRequest()     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            com.baidubce.services.bos.model.GetObjectRequest r13 = (com.baidubce.services.bos.model.GetObjectRequest) r13     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            com.baidubce.services.bos.callback.BosProgressCallback r13 = r13.getProgressCallback()     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            okhttp3.OkHttpClient r0 = r1.addResponseProgressCallback(r0, r13)     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            java.lang.String r13 = "getObject"
            com.baidubce.util.BLog.debug(r13)     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
        L_0x0095:
            okhttp3.Call r0 = r0.newCall(r12)     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            okhttp3.Response r0 = r0.execute()     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            com.baidubce.http.BceHttpResponse r12 = new com.baidubce.http.BceHttpResponse     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            r12.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            java.lang.String r0 = "Date"
            java.lang.String r5 = r12.getHeader(r0)     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            java.lang.Object r0 = r18.newInstance()     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            com.baidubce.model.AbstractBceResponse r0 = (com.baidubce.model.AbstractBceResponse) r0     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            int r13 = r3.length     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            r14 = 0
        L_0x00b0:
            if (r14 >= r13) goto L_0x00be
            r15 = r3[r14]     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            boolean r15 = r15.handle(r12, r0)     // Catch:{ SocketTimeoutException -> 0x00c5, BceServiceException -> 0x00c3, BceClientException -> 0x00c1, Exception -> 0x00bf }
            if (r15 == 0) goto L_0x00bb
            goto L_0x00be
        L_0x00bb:
            int r14 = r14 + 1
            goto L_0x00b0
        L_0x00be:
            return r0
        L_0x00bf:
            r0 = move-exception
            goto L_0x00ca
        L_0x00c1:
            r0 = move-exception
            goto L_0x00d5
        L_0x00c3:
            r0 = move-exception
            goto L_0x00da
        L_0x00c5:
            r0 = move-exception
            goto L_0x0105
        L_0x00c7:
            r0 = move-exception
            r11 = r20
        L_0x00ca:
            com.baidubce.BceClientException r12 = new com.baidubce.BceClientException
            java.lang.String r13 = "Unable to execute HTTP request"
            r12.<init>(r13, r0)
            goto L_0x011e
        L_0x00d2:
            r0 = move-exception
            r11 = r20
        L_0x00d5:
            r12 = r0
            goto L_0x011e
        L_0x00d7:
            r0 = move-exception
            r11 = r20
        L_0x00da:
            r12 = r0
            com.baidubce.ErrorCode r0 = com.baidubce.ErrorCode.REQUEST_TIME_TOO_SKEWED
            java.lang.String r13 = r12.getErrorCode()
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x011e
            java.util.Date r0 = com.baidubce.util.DateUtils.parseRfc822Date(r5)
            java.lang.String r13 = ""
            boolean r13 = r5.equals(r13)
            if (r13 != 0) goto L_0x011e
            if (r0 == 0) goto L_0x011e
            monitor-enter(r16)
            long r13 = r0.getTime()     // Catch:{ all -> 0x00ff }
            long r13 = r13 - r9
            r1.diffMillis = r13     // Catch:{ all -> 0x00ff }
            monitor-exit(r16)     // Catch:{ all -> 0x00ff }
            goto L_0x011e
        L_0x00ff:
            r0 = move-exception
            monitor-exit(r16)     // Catch:{ all -> 0x00ff }
            throw r0
        L_0x0102:
            r0 = move-exception
            r11 = r20
        L_0x0105:
            okhttp3.OkHttpClient r12 = r1.httpClient
            okhttp3.Dispatcher r12 = r12.dispatcher()
            r12.cancelAll()
            okhttp3.OkHttpClient r12 = r1.httpClient
            okhttp3.ConnectionPool r12 = r12.connectionPool()
            r12.evictAll()
            com.baidubce.BceClientException r12 = new com.baidubce.BceClientException
            java.lang.String r13 = "Unable to execute HTTP request"
            r12.<init>(r13, r0)
        L_0x011e:
            java.lang.String r0 = "Unable to execute HTTP request"
            com.baidubce.util.BLog.warn(r0)
            com.baidubce.BceClientConfiguration r0 = r1.config
            com.baidubce.http.RetryPolicy r0 = r0.getRetryPolicy()
            long r13 = r1.getDelayBeforeNextRetryInMillis(r2, r12, r8, r0)
            int r0 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x016b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r12 = "Retriable error detected, will retry in "
            r0.append(r12)
            r0.append(r13)
            java.lang.String r12 = " ms, attempt number: "
            r0.append(r12)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            com.baidubce.util.BLog.warn(r0)
            java.lang.Thread.sleep(r13)     // Catch:{ InterruptedException -> 0x0161 }
            com.baidubce.internal.RestartableInputStream r0 = r17.getContent()
            if (r0 == 0) goto L_0x015d
            com.baidubce.internal.RestartableInputStream r0 = r17.getContent()
            r0.restart()
        L_0x015d:
            int r8 = r8 + 1
            goto L_0x0035
        L_0x0161:
            r0 = move-exception
            r2 = r0
            com.baidubce.BceClientException r0 = new com.baidubce.BceClientException
            java.lang.String r3 = "Delay interrupted"
            r0.<init>(r3, r2)
            throw r0
        L_0x016b:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidubce.http.BceHttpClient.execute(com.baidubce.internal.InternalRequest, java.lang.Class, com.baidubce.http.handler.HttpResponseHandler[], com.baidubce.callback.BceProgressCallback):com.baidubce.model.AbstractBceResponse");
    }

    public class BceServiceRequestBody<T extends AbstractBceRequest> extends RequestBody {
        public BceProgressCallback<T> callback;
        public long length;
        public MediaType mediaType;
        public T request;
        public InputStream restartableInputStream;

        public BceServiceRequestBody(InternalRequest<T> internalRequest, BceProgressCallback<T> bceProgressCallback) {
            if (internalRequest.getContent() != null) {
                this.mediaType = MediaType.parse(internalRequest.getHeaders().get("Content-Type"));
                this.restartableInputStream = internalRequest.getContent();
                this.length = getContentLength(internalRequest);
                this.callback = bceProgressCallback;
                this.request = internalRequest.getRequest();
            }
        }

        private long getContentLength(InternalRequest<T> internalRequest) {
            String str = internalRequest.getHeaders().get("Content-Length");
            if (str != null) {
                return Long.parseLong(str);
            }
            return 0;
        }

        public long contentLength() throws IOException {
            return this.length;
        }

        public MediaType contentType() {
            return this.mediaType;
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            long contentLength = contentLength();
            Source source = Okio.source(this.restartableInputStream);
            long j = 0;
            while (j < contentLength) {
                long read = source.read(bufferedSink.buffer(), Math.min(contentLength - j, BceHttpClient.this.config.getUploadSegmentPart()));
                if (read == -1) {
                    break;
                }
                long j2 = j + read;
                bufferedSink.flush();
                BceProgressCallback<T> bceProgressCallback = this.callback;
                if (bceProgressCallback != null) {
                    bceProgressCallback.onProgress(this.request, j2, contentLength);
                }
                j = j2;
            }
            if (source != null) {
                source.close();
            }
        }

        public BceServiceRequestBody(InternalRequest<T> internalRequest) {
            if (internalRequest.getContent() != null) {
                this.mediaType = MediaType.parse(internalRequest.getHeaders().get("Content-Type"));
                this.restartableInputStream = internalRequest.getContent();
                this.length = getContentLength(internalRequest);
                this.callback = null;
                this.request = internalRequest.getRequest();
            }
        }
    }
}
