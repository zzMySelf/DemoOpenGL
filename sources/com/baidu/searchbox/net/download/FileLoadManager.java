package com.baidu.searchbox.net.download;

import android.text.TextUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.GetRequest;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;

public class FileLoadManager {
    private static final boolean DEBUG = false;

    public static long downloadStream(String dir, String name, String url) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(url)) {
            return 0;
        }
        return downloadStream(new File(dir, name), url);
    }

    public static long downloadStream(File file, String url) {
        if (TextUtils.isEmpty(url) || file == null) {
            return 0;
        }
        long size = 0;
        InputStream is = null;
        FileOutputStream os = null;
        try {
            Response response = ((GetRequest.GetRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(url)).build().executeSync();
            if (response != null) {
                if (response.code() == 200) {
                    is = response.body().byteStream();
                    if (is != null) {
                        os = new FileOutputStream(file);
                        size = FileUtils.copyStream(is, os);
                    }
                } else {
                    response.body().close();
                }
            }
        } catch (Exception e2) {
        } catch (Throwable th2) {
            Closeables.closeSafely((Closeable) null);
            Closeables.closeSafely((Closeable) null);
            throw th2;
        }
        Closeables.closeSafely((Closeable) is);
        Closeables.closeSafely((Closeable) os);
        return size;
    }

    public static long downloadStream(File file, String url, int connectionTimeout, int readTimeout) {
        if (TextUtils.isEmpty(url) || file == null) {
            return 0;
        }
        long size = 0;
        InputStream is = null;
        FileOutputStream os = null;
        try {
            Response response = ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(url)).connectionTimeout(connectionTimeout)).readTimeout(readTimeout)).build().executeSync();
            if (response != null) {
                if (response.code() == 200) {
                    is = response.body().byteStream();
                    if (is != null) {
                        os = new FileOutputStream(file);
                        size = FileUtils.copyStream(is, os);
                    }
                } else {
                    response.body().close();
                }
            }
        } catch (IOException | IllegalArgumentException e2) {
        } catch (Throwable th2) {
            Closeables.closeSafely((Closeable) null);
            Closeables.closeSafely((Closeable) null);
            throw th2;
        }
        Closeables.closeSafely((Closeable) is);
        Closeables.closeSafely((Closeable) os);
        return size;
    }

    public static long downloadStream(File file, String url, int connectionTimeout, int readTimeout, String userAgent) {
        if (TextUtils.isEmpty(url) || file == null) {
            return 0;
        }
        long size = 0;
        InputStream is = null;
        FileOutputStream os = null;
        try {
            GetRequest.GetRequestBuilder requestBuilder = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest();
            if (!TextUtils.isEmpty(userAgent)) {
                requestBuilder.userAgent(userAgent);
            }
            Response response = ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) requestBuilder.url(url)).connectionTimeout(connectionTimeout)).readTimeout(readTimeout)).build().executeSync();
            if (response != null) {
                if (response.code() == 200) {
                    is = response.body().byteStream();
                    if (is != null) {
                        os = new FileOutputStream(file);
                        size = FileUtils.copyStream(is, os);
                    }
                } else {
                    response.body().close();
                }
            }
        } catch (IOException | IllegalArgumentException e2) {
        } catch (Throwable th2) {
            Closeables.closeSafely((Closeable) null);
            Closeables.closeSafely((Closeable) null);
            throw th2;
        }
        Closeables.closeSafely((Closeable) is);
        Closeables.closeSafely((Closeable) os);
        return size;
    }
}
