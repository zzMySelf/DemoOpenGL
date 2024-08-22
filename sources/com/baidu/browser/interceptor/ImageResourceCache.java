package com.baidu.browser.interceptor;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.webkit.sdk.MimeTypeMap;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.io.InputStream;
import java.io.PipedOutputStream;
import java.util.List;
import okhttp3.HttpUrl;

public class ImageResourceCache {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "ImageResourceCache";

    public static WebResourceResponse getWebResponse(String urlStr, List<? super PipedOutputStream> streamContainer) {
        if (TextUtils.isEmpty(urlStr) || HttpUrl.parse(urlStr) == null) {
            if (DEBUG) {
                Log.d(TAG, "图片拦截失败，原因：url为空");
            }
            return null;
        }
        ImageResource resource = ImageResource.buildResource(urlStr, streamContainer);
        if (resource == null || !resource.isShouldIntercept()) {
            if (DEBUG) {
                Log.d(TAG, "图片拦截失败，原因：无拦截标识，无需拦截" + urlStr);
            }
            return null;
        }
        InputStream is = new ImageResourceCacheManager(resource).getInputStreamFromCache();
        if (is != null) {
            return new WebResourceResponse(MimeTypeMap.getSingleton().getMimeTypeFromExtension(resource.getExtension()), "UTF-8", is);
        }
        if (!DEBUG) {
            return null;
        }
        Log.d(TAG, "图片拦截失败，原因：InputStream为null");
        return null;
    }
}
