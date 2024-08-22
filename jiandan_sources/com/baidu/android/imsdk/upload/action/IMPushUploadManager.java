package com.baidu.android.imsdk.upload.action;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.upload.action.IMPushUploadConstants;
import com.baidu.android.imsdk.upload.action.logpb.BIMLogPb;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.google.common.net.HttpHeaders;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import okio.Sink;

public class IMPushUploadManager {
    public static final long PING_INTERVAL_MS = 1000;
    public static final int TIME_OUT_S = 30;
    public static IMPushUploadManager sInstance;
    public Context mContext;
    public OkHttpClient mOkHttpClient = createOkHttpClient();

    public class GzipRequestInterceptor implements Interceptor {
        public GzipRequestInterceptor() {
        }

        private RequestBody gzip(final RequestBody requestBody) {
            return new RequestBody() {
                public long contentLength() {
                    return -1;
                }

                public MediaType contentType() {
                    return requestBody.contentType();
                }

                public void writeTo(BufferedSink bufferedSink) {
                    BufferedSink buffer = Okio.buffer((Sink) new GzipSink(bufferedSink));
                    try {
                        requestBody.writeTo(buffer);
                        buffer.close();
                    } catch (IOException unused) {
                    }
                }
            };
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            try {
                Request request = chain.request();
                if (request.body() != null) {
                    if (request.header("Content-Encoding") == null) {
                        return chain.proceed(request.newBuilder().header("Content-Encoding", "gzip").method(request.method(), gzip(request.body())).build());
                    }
                }
                return chain.proceed(request);
            } catch (Exception e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    public IMPushUploadManager(Context context) {
        this.mContext = context;
    }

    private RequestBody convertRequestBody(byte[] bArr, String str) {
        return RequestBody.create(MediaType.parse("application/proto"), createLogRequestContent(bArr, str));
    }

    private byte[] createLogRequestContent(byte[] bArr, String str) {
        BIMLogPb.LogRequest.AuthInfo.Builder newBuilder = BIMLogPb.LogRequest.AuthInfo.newBuilder();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        BIMLogPb.LogRequest.AuthInfo build = newBuilder.setToken(str).build();
        long currentTimeMillis = System.currentTimeMillis();
        return BIMLogPb.LogRequest.newBuilder().setVersion(1).setServiceName(IMPushUploadConstants.Service.BAIDU_APP).setAuthInfo(build).setRequestTimestampMs(currentTimeMillis).setSign(IMPushUploadConstants.sign(this.mContext, IMPushUploadConstants.Service.BAIDU_APP, currentTimeMillis)).setPayload(ByteString.copyFrom(bArr)).build().toByteArray();
    }

    private OkHttpClient createOkHttpClient() {
        return new OkHttpClient.Builder().protocols(Arrays.asList(new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1})).pingInterval(1000, TimeUnit.MILLISECONDS).addInterceptor(new GzipRequestInterceptor()).connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).connectionPool(new ConnectionPool()).build();
    }

    public static IMPushUploadManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new IMPushUploadManager(context);
        }
        return sInstance;
    }

    private Request getOkHttpRequest(byte[] bArr, String str, String str2) {
        return new Request.Builder().addHeader(HttpHeaders.CONNECTION, "Keep-Alive").addHeader("Content-Type", "application/proto").addHeader(IMPushUploadConstants.BIM_LOG_ID, str2).url(IMPushUploadConstants.ONLINE_URL).post(convertRequestBody(bArr, str)).build();
    }

    /* access modifiers changed from: private */
    public String[] parseResponse(byte[] bArr) {
        try {
            BIMLogPb.LogResponse parseFrom = BIMLogPb.LogResponse.parseFrom(bArr);
            if (((long) this.mOkHttpClient.pingIntervalMillis()) != parseFrom.getPingIntervalMs()) {
                this.mOkHttpClient.newBuilder().pingInterval(parseFrom.getPingIntervalMs(), TimeUnit.MILLISECONDS);
                this.mOkHttpClient = this.mOkHttpClient.newBuilder().pingInterval(parseFrom.getPingIntervalMs(), TimeUnit.MILLISECONDS).build();
            }
            "parseResponse errorCode :" + parseFrom.getErrorCode() + ", errorMsg ：" + parseFrom.getErrorMsg();
            return new String[]{String.valueOf(parseFrom.getErrorCode()), parseFrom.getErrorMsg()};
        } catch (InvalidProtocolBufferException unused) {
            return new String[]{String.valueOf(-1), "parseResponse exception"};
        }
    }

    public void requestUpload(Map<String, String> map, byte[] bArr, String str, final IMPushUploadResponseListener iMPushUploadResponseListener) {
        final String str2 = "" + ((int) ((Math.random() * 100000.0d) + 1000.0d));
        Request okHttpRequest = getOkHttpRequest(bArr, str, str2);
        if (this.mOkHttpClient == null) {
            this.mOkHttpClient = createOkHttpClient();
        }
        this.mOkHttpClient.newCall(okHttpRequest).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                String str = "Request error :" + iOException.toString();
                if (iOException instanceof SocketException) {
                    str = "Request SocketException :" + iOException.toString();
                }
                IMPushUploadResponseListener iMPushUploadResponseListener = iMPushUploadResponseListener;
                if (iMPushUploadResponseListener != null) {
                    iMPushUploadResponseListener.uploadResponse(-1, str);
                }
            }

            public void onResponse(Call call, Response response) {
                IMPushUploadResponseListener iMPushUploadResponseListener;
                String str = NewBindCardEntry.BING_CARD_SUCCESS_MSG;
                int i2 = 0;
                try {
                    if (response.body() != null) {
                        String[] access$000 = IMPushUploadManager.this.parseResponse(response.body().bytes());
                        i2 = Integer.valueOf(access$000[0]).intValue();
                        str = access$000[1];
                    }
                    "onResponse response = " + i2 + " body = " + str + ", logId :" + str2;
                    iMPushUploadResponseListener = iMPushUploadResponseListener;
                    if (iMPushUploadResponseListener == null) {
                        return;
                    }
                } catch (IOException unused) {
                    iMPushUploadResponseListener = iMPushUploadResponseListener;
                    if (iMPushUploadResponseListener == null) {
                        return;
                    }
                } catch (Throwable th2) {
                    IMPushUploadResponseListener iMPushUploadResponseListener2 = iMPushUploadResponseListener;
                    if (iMPushUploadResponseListener2 != null) {
                        iMPushUploadResponseListener2.uploadResponse(0, str);
                    }
                    throw th2;
                }
                iMPushUploadResponseListener.uploadResponse(i2, str);
            }
        });
    }
}
