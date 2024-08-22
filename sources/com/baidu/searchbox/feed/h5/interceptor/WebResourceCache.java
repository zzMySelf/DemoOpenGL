package com.baidu.searchbox.feed.h5.interceptor;

import android.text.TextUtils;
import com.baidu.searchbox.feed.h5.template.TplResMapper;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.io.InputStream;
import java.io.PipedOutputStream;
import java.util.List;
import okhttp3.HttpUrl;

public class WebResourceCache {
    public static WebResourceResponse getWebResponse(String urlStr, List<? super PipedOutputStream> streamContainer) {
        return getWebResponse(urlStr, (String) null, streamContainer, (TplResMapper) null);
    }

    public static WebResourceResponse getWebResponse(String urlStr, String nid, List<? super PipedOutputStream> streamContainer, TplResMapper elementMapper) {
        Resource resource;
        if (!checkUrlValid(urlStr) || (resource = Resource.buildResource(urlStr, streamContainer, elementMapper)) == null || !resource.isShouldIntercept()) {
            return null;
        }
        resource.setNid(nid);
        InputStream is = new ResourceCacheManager(resource).getInputStreamFromCache();
        if (is != null) {
            return new WebResourceResponse(getMimeTypeFromUrl(resource.getExtension()), "UTF-8", is);
        }
        return null;
    }

    private static boolean checkUrlValid(String urlStr) {
        return !TextUtils.isEmpty(urlStr) && HttpUrl.parse(urlStr) != null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getMimeTypeFromUrl(java.lang.String r2) {
        /*
            int r0 = r2.hashCode()
            switch(r0) {
                case 3401: goto L_0x0027;
                case 52301: goto L_0x001d;
                case 3655064: goto L_0x0012;
                case 1417254381: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0032
        L_0x0008:
            java.lang.String r0 = ".image"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 3
            goto L_0x0033
        L_0x0012:
            java.lang.String r0 = "woff"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 2
            goto L_0x0033
        L_0x001d:
            java.lang.String r0 = "3ga"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 0
            goto L_0x0033
        L_0x0027:
            java.lang.String r0 = "js"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 1
            goto L_0x0033
        L_0x0032:
            r0 = -1
        L_0x0033:
            switch(r0) {
                case 0: goto L_0x0052;
                case 1: goto L_0x004e;
                case 2: goto L_0x004b;
                case 3: goto L_0x0048;
                default: goto L_0x0036;
            }
        L_0x0036:
            com.baidu.webkit.sdk.MimeTypeMap r0 = com.baidu.webkit.sdk.MimeTypeMap.getSingleton()
            java.lang.String r0 = r0.getMimeTypeFromExtension(r2)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0055
            java.lang.String r0 = "text/html"
            goto L_0x0055
        L_0x0048:
            java.lang.String r0 = "image/*"
            return r0
        L_0x004b:
            java.lang.String r0 = "application/x-font-woff"
            return r0
        L_0x004e:
            java.lang.String r0 = "text/javascript"
            return r0
        L_0x0052:
            java.lang.String r0 = "audio/3gpp"
            return r0
        L_0x0055:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.h5.interceptor.WebResourceCache.getMimeTypeFromUrl(java.lang.String):java.lang.String");
    }
}
