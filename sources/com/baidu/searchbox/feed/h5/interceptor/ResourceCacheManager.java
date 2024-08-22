package com.baidu.searchbox.feed.h5.interceptor;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.feed.h5.H5Runtime;
import com.baidu.searchbox.feed.h5.HybridConstants;
import com.baidu.searchbox.feed.h5.IH5Context;
import com.baidu.searchbox.feed.h5.cache.HybridFrescoCache;
import com.baidu.searchbox.feed.h5.utils.HybridCacheUtils;
import com.baidu.searchbox.feed.h5.utils.HybridUtils;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.DefaultResponseCallback;
import com.baidu.searchbox.http.request.GetRequest;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URLDecoder;
import okhttp3.Response;
import okhttp3.ResponseBody;

class ResourceCacheManager {
    private static final String NETWORK_ERROR = "network error";
    private static final String TAG = "hybrid_sdk_ResourceCacheManager";
    private Context mContext = H5Runtime.getAppContext();
    private Resource mResource;

    ResourceCacheManager(Resource resource) {
        this.mResource = resource;
    }

    /* access modifiers changed from: package-private */
    public InputStream getInputStreamFromCache() {
        InputStream is = loadInputStreamFromCache(this.mResource);
        if (is != null || !this.mResource.needCache() || !NetWorkUtils.isNetworkConnected()) {
            return is;
        }
        PipedOutputStream out = new PipedOutputStream();
        try {
            InputStream is2 = new PipedInputStream(out);
            cacheResources(this.mResource, out);
            if (this.mResource.getOutStreamContainer() == null) {
                return is2;
            }
            this.mResource.getOutStreamContainer().add(out);
            return is2;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private InputStream loadInputStreamFromCache(Resource resource) {
        File cacheFile;
        if (resource == null || TextUtils.isEmpty(resource.getCacheKey())) {
            return null;
        }
        if (resource.isSuperIntercept()) {
            cacheFile = getFileByLocalFilePath(resource);
        } else if (resource.isImage()) {
            cacheFile = getFileFromFrescoCache(resource);
        } else if (resource.isHybridEle()) {
            cacheFile = getFileFromHybridEleMapper(resource);
        } else if (resource.isText()) {
            cacheFile = getLocalTextFile(resource);
        } else {
            cacheFile = null;
        }
        if (cacheFile == null) {
            return null;
        }
        try {
            return new FileInputStream(cacheFile);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static boolean isValidCrc(String crc) {
        if (TextUtils.isEmpty(crc)) {
            return false;
        }
        try {
            Long.parseLong(crc);
            return true;
        } catch (NumberFormatException e2) {
            return false;
        }
    }

    private void cacheResources(Resource resource, PipedOutputStream out) {
        if (resource.isImage()) {
            cacheImageWithFresco(resource, out);
        } else {
            cacheText(resource, out, HybridConstants.RES_JS_SUFFIX);
        }
    }

    private void cacheText(Resource resource, PipedOutputStream out, String suffix) {
        final String[] errorDesc = {null};
        final String[] errorMsg = {null};
        String url = resource.getRemoteUrl();
        final String cacheKey = resource.getCacheKey();
        final String str = suffix;
        final PipedOutputStream pipedOutputStream = out;
        final String str2 = url;
        final int[] iArr = new int[1];
        ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) HttpManager.getDefault(this.mContext).getRequest().url(url)).enableStat(true)).requestFrom(1)).requestSubFrom(201)).build().executeAsync(new DefaultResponseCallback() {
            public void onSuccess(Response response, int statusCode) {
                IH5Context h5Context;
                int i2;
                String str;
                String str2;
                if (response == null || statusCode != 200) {
                    errorDesc[0] = "network error";
                    String[] strArr = errorMsg;
                    String str3 = "";
                    if (response != null) {
                        str3 = response.code() + str3;
                    }
                    strArr[0] = str3;
                } else {
                    try {
                        ResponseBody body = response.body();
                        if (body == null) {
                            Closeables.closeSafely((Closeable) pipedOutputStream);
                            if (!TextUtils.isEmpty(errorDesc[0]) || !TextUtils.isEmpty(errorMsg[0])) {
                                H5Runtime.getH5Context().notifyError(iArr[0], errorDesc[0], errorMsg[0], "landing", "333");
                                return;
                            }
                            return;
                        }
                        String content = body.string();
                        HybridCacheUtils.saveHybridCache(HybridUtils.makeCacheId(cacheKey, str), content);
                        PipedOutputStream pipedOutputStream = pipedOutputStream;
                        if (pipedOutputStream != null) {
                            pipedOutputStream.write(content.getBytes());
                        }
                    } catch (OutOfMemoryError oom) {
                        errorDesc[0] = "ResourceCacheManager#cacheText() oom happened, url : " + str2;
                        errorMsg[0] = Log.getStackTraceString(oom);
                        iArr[0] = 18;
                        Closeables.closeSafely((Closeable) pipedOutputStream);
                        if (!TextUtils.isEmpty(errorDesc[0]) || !TextUtils.isEmpty(errorMsg[0])) {
                            h5Context = H5Runtime.getH5Context();
                            i2 = iArr[0];
                            str = errorDesc[0];
                            str2 = errorMsg[0];
                        } else {
                            return;
                        }
                    } catch (Exception e2) {
                        errorDesc[0] = e2.getMessage();
                        errorMsg[0] = Log.getStackTraceString(e2);
                        iArr[0] = 17;
                        e2.printStackTrace();
                        Closeables.closeSafely((Closeable) pipedOutputStream);
                        if (!TextUtils.isEmpty(errorDesc[0]) || !TextUtils.isEmpty(errorMsg[0])) {
                            h5Context = H5Runtime.getH5Context();
                            i2 = iArr[0];
                            str = errorDesc[0];
                            str2 = errorMsg[0];
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        Closeables.closeSafely((Closeable) pipedOutputStream);
                        if (!TextUtils.isEmpty(errorDesc[0]) || !TextUtils.isEmpty(errorMsg[0])) {
                            H5Runtime.getH5Context().notifyError(iArr[0], errorDesc[0], errorMsg[0], "landing", "333");
                        }
                        throw th2;
                    }
                }
                Closeables.closeSafely((Closeable) pipedOutputStream);
                if (!TextUtils.isEmpty(errorDesc[0]) || !TextUtils.isEmpty(errorMsg[0])) {
                    h5Context = H5Runtime.getH5Context();
                    i2 = iArr[0];
                    str = errorDesc[0];
                    str2 = errorMsg[0];
                    h5Context.notifyError(i2, str, str2, "landing", "333");
                }
            }

            public void onFail(Exception exception) {
                Closeables.closeSafely((Closeable) pipedOutputStream);
                errorDesc[0] = exception.getMessage();
                errorMsg[0] = Log.getStackTraceString(exception);
                H5Runtime.getH5Context().notifyError(17, errorDesc[0], errorMsg[0], "landing", "333");
            }
        });
    }

    private void cacheImageWithFresco(Resource resource, PipedOutputStream out) {
        HybridFrescoCache.cacheImage(resource, out);
    }

    private static File getFileByLocalFilePath(Resource resource) {
        if (resource == null) {
            return null;
        }
        String filePath = resource.getSuperInterceptFilePath();
        if (TextUtils.isEmpty(filePath)) {
            return null;
        }
        try {
            filePath = URLDecoder.decode(filePath, "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        File cacheFile = new File(filePath);
        if (cacheFile.exists()) {
            return cacheFile;
        }
        return null;
    }

    private static File getFileFromFrescoCache(Resource resource) {
        FileBinaryResource binaryResource;
        if (resource == null || TextUtils.isEmpty(resource.getCacheKey())) {
            return null;
        }
        String url = resource.getCacheKey();
        if (HybridFrescoCache.inFrescoCache(url) && (binaryResource = (FileBinaryResource) Fresco.getImagePipelineFactory().getMainFileCache().getResource(new SimpleCacheKey(url))) != null) {
            return binaryResource.getFile();
        }
        return null;
    }

    private static File getFileFromHybridEleMapper(Resource resource) {
        String url = resource.getCacheKey();
        if (resource.getElementMapper() == null || !resource.getElementMapper().isReady()) {
            return null;
        }
        return resource.getElementMapper().getNodeFile(url);
    }

    private static File getLocalTextFile(Resource resource) {
        File localFile = HybridCacheUtils.getExistCacheFile(HybridUtils.makeCacheId(resource.getCacheKey(), HybridConstants.RES_JS_SUFFIX));
        if (localFile == null) {
            return null;
        }
        if (!isValidCrc(resource.getCrc()) || TextUtils.equals(HybridUtils.getCrc(FileUtils.readFileData(localFile)), resource.getCrc())) {
            return localFile;
        }
        HybridCacheUtils.removeCacheSync(HybridUtils.makeCacheId(resource.getCacheKey(), HybridConstants.RES_JS_SUFFIX));
        return null;
    }
}
