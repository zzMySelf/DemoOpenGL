package com.baidu.wallet.lightapp.business;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.VerSig;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public final class c {

    public interface a {
        void a(String[] strArr);
    }

    public static class b extends FilterInputStream {
        public final HttpURLConnection a;

        public b(HttpURLConnection httpURLConnection) {
            super(c.b(httpURLConnection));
            this.a = httpURLConnection;
        }

        public void close() throws IOException {
            super.close();
            this.a.disconnect();
        }
    }

    public static String[] c(String str, String[] strArr, Context context) throws IOException {
        LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "START: load cache");
        return a(str, strArr, context, true, false);
    }

    public static String[] d(String str, String[] strArr, Context context) throws IOException {
        LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "START: load network");
        return a(str, strArr, context, false, true);
    }

    public static String b(String str) {
        String name = new File(URI.create(str).getPath()).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf > 0 ? name.substring(0, lastIndexOf) : name;
    }

    public static boolean b(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            return true;
        }
        for (CharSequence isEmpty : charSequenceArr) {
            if (!TextUtils.isEmpty(isEmpty)) {
                return false;
            }
        }
        return true;
    }

    public static void a(final String str, final Context context, final String[] strArr, final a aVar) {
        new Thread() {
            public void run() {
                super.run();
                LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "ZipFileLoader load: " + str);
                String[] strArr = new String[0];
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    strArr = c.c(str, strArr, context);
                    LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "END: cache duration: " + (SystemClock.uptimeMillis() - uptimeMillis));
                } catch (IOException e) {
                    LogUtil.e(BeanConstants.WEB_VIEW_CACHE_TAG, "EXCEPTION on load from cache", e);
                    Tracker.send(LightAppStatEvent.OFFLINECACHE_DOWNLOAD_JSHOOK_FILE_FAILED, (Collection<String>) Arrays.asList(new String[]{str, "EXCEPTION on load from cache", e.toString()}), context);
                }
                if (c.b((CharSequence[]) strArr)) {
                    long uptimeMillis2 = SystemClock.uptimeMillis();
                    try {
                        String str = str;
                        String[] strArr2 = strArr;
                        Context context = context;
                        strArr = c.b(str, strArr2, context, c.b(str) + File.separatorChar);
                        LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "END: local duration: " + (SystemClock.uptimeMillis() - uptimeMillis2));
                    } catch (IOException e2) {
                        LogUtil.e(BeanConstants.WEB_VIEW_CACHE_TAG, "EXCEPTION on load from local", e2);
                        if (!(e2 instanceof FileNotFoundException)) {
                            Tracker.send(LightAppStatEvent.OFFLINECACHE_DOWNLOAD_JSHOOK_FILE_FAILED, (Collection<String>) Arrays.asList(new String[]{str, "EXCEPTION on load from local", e2.toString()}), context);
                        }
                    }
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(strArr);
                        LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "RESULT: load from local, is empty: " + c.b((CharSequence[]) strArr));
                    }
                    try {
                        long uptimeMillis3 = SystemClock.uptimeMillis();
                        String[] unused = c.d(str, strArr, context);
                        LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "END: network duration: " + (SystemClock.uptimeMillis() - uptimeMillis3));
                    } catch (IOException e3) {
                        LogUtil.e(BeanConstants.WEB_VIEW_CACHE_TAG, "EXCEPTION on load from network", e3);
                        Tracker.send(LightAppStatEvent.OFFLINECACHE_DOWNLOAD_JSHOOK_FILE_FAILED, (Collection<String>) Arrays.asList(new String[]{str, "EXCEPTION on load from network", e3.toString()}), context);
                    }
                } else {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(strArr);
                        LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "RESULT: load from cache, is empty: " + c.b((CharSequence[]) strArr));
                    }
                }
            }
        }.start();
    }

    public static String[] b(String str, String[] strArr, Context context, String str2) throws IOException {
        if (strArr == null) {
            return new String[0];
        }
        String[] strArr2 = new String[strArr.length];
        LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "START: load local");
        String str3 = null;
        boolean z = false;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            byte[] a2 = a(DxmApplicationContextImpl.getApplicationContext(context).getAssets().open(str2 + strArr[i2] + ".sig"), true);
            byte[] a3 = a(DxmApplicationContextImpl.getApplicationContext(context).getAssets().open(str2 + strArr[i2]), true);
            if (VerSig.verify(a2, a3, "SHA-1")) {
                strArr2[i2] = new String(a3);
                LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, strArr[i2] + " verify passed");
            } else {
                LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, strArr[i2] + " verify failed");
                if (TextUtils.isEmpty(str3)) {
                    str3 = strArr[i2];
                } else {
                    str3 = str3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + strArr[i2];
                }
                z = true;
            }
        }
        if (!z) {
            return strArr2;
        }
        String[] strArr3 = new String[0];
        a(str3, str, context);
        return strArr3;
    }

    public static void a(String str, String str2, Context context) {
        if (!TextUtils.isEmpty(str)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("url", str2);
            linkedHashMap.put("files", str);
            Tracker.send(LightAppStatEvent.JS_FILE_VERIFY_FAILED, (Map<String, String>) linkedHashMap, context);
        }
    }

    public static byte[] a(InputStream inputStream, boolean z) throws IOException {
        if (inputStream != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } finally {
                    if (z) {
                        inputStream.close();
                    }
                    byteArrayOutputStream.close();
                }
            }
            return byteArrayOutputStream.toByteArray();
        }
        throw new IOException("The input stream is null!");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.util.zip.ZipInputStream] */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.util.zip.ZipInputStream] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0132  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] a(java.lang.String r11, java.lang.String[] r12, android.content.Context r13, boolean r14, boolean r15) throws java.io.IOException {
        /*
            java.lang.String r0 = "WebViewCacheManager"
            r1 = 0
            if (r12 != 0) goto L_0x0008
            java.lang.String[] r11 = new java.lang.String[r1]
            return r11
        L_0x0008:
            int r2 = r12.length
            java.lang.String[] r3 = new java.lang.String[r2]
            r4 = 0
            java.net.URL r5 = new java.net.URL     // Catch:{ all -> 0x012f }
            r5.<init>(r11)     // Catch:{ all -> 0x012f }
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ all -> 0x012f }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ all -> 0x012f }
            r6 = 1
            r5.setUseCaches(r6)     // Catch:{ all -> 0x012f }
            a((boolean) r14, (boolean) r15, (java.net.HttpURLConnection) r5)     // Catch:{ all -> 0x012f }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x012f }
            r15.<init>()     // Catch:{ all -> 0x012f }
            java.lang.String r7 = "status code: "
            r15.append(r7)     // Catch:{ all -> 0x012f }
            int r7 = r5.getResponseCode()     // Catch:{ all -> 0x012f }
            r15.append(r7)     // Catch:{ all -> 0x012f }
            java.lang.String r7 = ", msg: "
            r15.append(r7)     // Catch:{ all -> 0x012f }
            java.lang.String r7 = r5.getResponseMessage()     // Catch:{ all -> 0x012f }
            r15.append(r7)     // Catch:{ all -> 0x012f }
            java.lang.String r15 = r15.toString()     // Catch:{ all -> 0x012f }
            com.baidu.wallet.core.utils.LogUtil.i(r0, r15)     // Catch:{ all -> 0x012f }
            java.util.List r15 = java.util.Arrays.asList(r12)     // Catch:{ all -> 0x012f }
            int r7 = r12.length     // Catch:{ all -> 0x012f }
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ all -> 0x012f }
            int r8 = r5.getResponseCode()     // Catch:{ all -> 0x012f }
            r9 = 200(0xc8, float:2.8E-43)
            if (r8 != r9) goto L_0x0108
            java.util.zip.ZipInputStream r14 = new java.util.zip.ZipInputStream     // Catch:{ all -> 0x012f }
            com.baidu.wallet.lightapp.business.c$b r8 = new com.baidu.wallet.lightapp.business.c$b     // Catch:{ all -> 0x012f }
            r8.<init>(r5)     // Catch:{ all -> 0x012f }
            r14.<init>(r8)     // Catch:{ all -> 0x012f }
        L_0x005b:
            java.util.zip.ZipEntry r5 = r14.getNextEntry()     // Catch:{ all -> 0x0105 }
            if (r5 == 0) goto L_0x009a
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x0105 }
            int r8 = r15.indexOf(r5)     // Catch:{ all -> 0x0105 }
            if (r8 < 0) goto L_0x0076
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x0105 }
            byte[] r10 = a(r14, r1)     // Catch:{ all -> 0x0105 }
            r9.<init>(r10)     // Catch:{ all -> 0x0105 }
            r3[r8] = r9     // Catch:{ all -> 0x0105 }
        L_0x0076:
            java.lang.String r8 = ".sig"
            boolean r8 = r5.endsWith(r8)     // Catch:{ all -> 0x0105 }
            if (r8 == 0) goto L_0x005b
            int r8 = r5.length()     // Catch:{ all -> 0x0105 }
            int r8 = r8 + -4
            java.lang.String r5 = r5.substring(r1, r8)     // Catch:{ all -> 0x0105 }
            int r5 = r15.indexOf(r5)     // Catch:{ all -> 0x0105 }
            if (r5 < 0) goto L_0x005b
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x0105 }
            byte[] r9 = a(r14, r1)     // Catch:{ all -> 0x0105 }
            r8.<init>(r9)     // Catch:{ all -> 0x0105 }
            r7[r5] = r8     // Catch:{ all -> 0x0105 }
            goto L_0x005b
        L_0x009a:
            r15 = 0
            r5 = 0
        L_0x009c:
            if (r15 >= r2) goto L_0x00fb
            r8 = r7[r15]     // Catch:{ all -> 0x0105 }
            r9 = r3[r15]     // Catch:{ all -> 0x0105 }
            java.lang.String r10 = "SHA-1"
            boolean r8 = com.baidu.wallet.core.utils.VerSig.verify((java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10)     // Catch:{ all -> 0x0105 }
            if (r8 == 0) goto L_0x00c1
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0105 }
            r8.<init>()     // Catch:{ all -> 0x0105 }
            r9 = r12[r15]     // Catch:{ all -> 0x0105 }
            r8.append(r9)     // Catch:{ all -> 0x0105 }
            java.lang.String r9 = " verify passed"
            r8.append(r9)     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0105 }
            com.baidu.wallet.core.utils.LogUtil.i(r0, r8)     // Catch:{ all -> 0x0105 }
            goto L_0x00f8
        L_0x00c1:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0105 }
            r5.<init>()     // Catch:{ all -> 0x0105 }
            r8 = r12[r15]     // Catch:{ all -> 0x0105 }
            r5.append(r8)     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = " verify failed"
            r5.append(r8)     // Catch:{ all -> 0x0105 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0105 }
            com.baidu.wallet.core.utils.LogUtil.i(r0, r5)     // Catch:{ all -> 0x0105 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0105 }
            if (r5 == 0) goto L_0x00e1
            r4 = r12[r15]     // Catch:{ all -> 0x0105 }
        L_0x00df:
            r5 = 1
            goto L_0x00f8
        L_0x00e1:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0105 }
            r5.<init>()     // Catch:{ all -> 0x0105 }
            r5.append(r4)     // Catch:{ all -> 0x0105 }
            java.lang.String r4 = ", "
            r5.append(r4)     // Catch:{ all -> 0x0105 }
            r4 = r12[r15]     // Catch:{ all -> 0x0105 }
            r5.append(r4)     // Catch:{ all -> 0x0105 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0105 }
            goto L_0x00df
        L_0x00f8:
            int r15 = r15 + 1
            goto L_0x009c
        L_0x00fb:
            if (r5 == 0) goto L_0x0103
            java.lang.String[] r12 = new java.lang.String[r1]     // Catch:{ all -> 0x0105 }
            a((java.lang.String) r4, (java.lang.String) r11, (android.content.Context) r13)     // Catch:{ all -> 0x0105 }
            r3 = r12
        L_0x0103:
            r4 = r14
            goto L_0x0129
        L_0x0105:
            r11 = move-exception
            r4 = r14
            goto L_0x0130
        L_0x0108:
            if (r14 != 0) goto L_0x0129
            java.lang.String r12 = "offlinecache_download_jshook_file_failed"
            r14 = 3
            java.lang.String[] r14 = new java.lang.String[r14]     // Catch:{ all -> 0x012f }
            r14[r1] = r11     // Catch:{ all -> 0x012f }
            java.lang.String r11 = r5.getResponseMessage()     // Catch:{ all -> 0x012f }
            r14[r6] = r11     // Catch:{ all -> 0x012f }
            r11 = 2
            int r15 = r5.getResponseCode()     // Catch:{ all -> 0x012f }
            java.lang.String r15 = java.lang.String.valueOf(r15)     // Catch:{ all -> 0x012f }
            r14[r11] = r15     // Catch:{ all -> 0x012f }
            java.util.List r11 = java.util.Arrays.asList(r14)     // Catch:{ all -> 0x012f }
            com.baidu.wallet.analytics.Tracker.send((java.lang.String) r12, (java.util.Collection<java.lang.String>) r11, (android.content.Context) r13)     // Catch:{ all -> 0x012f }
        L_0x0129:
            if (r4 == 0) goto L_0x012e
            r4.close()
        L_0x012e:
            return r3
        L_0x012f:
            r11 = move-exception
        L_0x0130:
            if (r4 == 0) goto L_0x0135
            r4.close()
        L_0x0135:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.business.c.a(java.lang.String, java.lang.String[], android.content.Context, boolean, boolean):java.lang.String[]");
    }

    public static InputStream b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    public static void a(boolean z, boolean z2, HttpURLConnection httpURLConnection) {
        if (!z || !z2) {
            if (z) {
                httpURLConnection.addRequestProperty("Cache-Control", "only-if-cached");
                httpURLConnection.addRequestProperty("Cache-Control", "max-stale=" + 31536000);
            }
            if (z2) {
                httpURLConnection.addRequestProperty("Cache-Control", "no-cache");
            }
        }
    }
}
