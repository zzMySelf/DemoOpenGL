package com.baidu.swan.apps.network.interceptor;

import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.network.IProgressListener;
import com.baidu.swan.apps.network.ProgressResponseBody;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

public class DownloadProgressInterceptor implements Interceptor {
    public static final String EXCEPTION_NULL_PROGRESS = "DownloadProgressInterceptor.mIProgressCallback == null";
    public static final int PROGRESS_100 = 100;
    public static final int UNKNOWN_LENGTH = -1;
    public static final int ZERO = 0;
    /* access modifiers changed from: private */
    public IProgressCallback mIProgressCallback;
    final IProgressListener progressListener = new IProgressListener() {
        public void onProgress(long bytesRead, long contentLength, boolean done) {
            if (DownloadProgressInterceptor.this.mIProgressCallback == null) {
                if (SwanAppLibConfig.DEBUG) {
                    throw new RuntimeException("DownloadProgressInterceptor.mIProgressCallback == null");
                }
            } else if (contentLength == -1 && bytesRead != 0) {
                DownloadProgressInterceptor.this.mIProgressCallback.onSuccess(0, bytesRead, contentLength);
            } else if (contentLength > 52428800) {
                DownloadProgressInterceptor.this.mIProgressCallback.onSizeFail(contentLength);
            } else if (contentLength <= 0 || bytesRead > contentLength || bytesRead == 0) {
                DownloadProgressInterceptor.this.mIProgressCallback.onFail(bytesRead, contentLength);
            } else {
                int progress = (int) Math.floor((double) ((100 * bytesRead) / contentLength));
                if (progress <= 100) {
                    DownloadProgressInterceptor.this.mIProgressCallback.onSuccess(progress, bytesRead, contentLength);
                }
            }
        }
    };

    public interface IProgressCallback {
        void onFail(long j2, long j3);

        void onSizeFail(long j2);

        void onSuccess(int i2, long j2, long j3);
    }

    public void setProgressListener(IProgressCallback iProgressCallback) {
        this.mIProgressCallback = iProgressCallback;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder().body(new ProgressResponseBody(originalResponse.body(), this.progressListener)).build();
    }
}
