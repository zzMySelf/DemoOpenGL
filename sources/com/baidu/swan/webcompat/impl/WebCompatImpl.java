package com.baidu.swan.webcompat.impl;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import androidx.webkit.WebViewAssetLoader;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.webcompat.ioc.IWebCompat;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0016J\b\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010*\u001a\u00020\u000bH\u0002J\u0012\u0010/\u001a\u0004\u0018\u00010,2\u0006\u0010*\u001a\u00020\u0004H\u0016J7\u00100\u001a\u0004\u0018\u0001H1\"\u0004\b\u0000\u001012\b\u00102\u001a\u0004\u0018\u00010,2\u0016\u00103\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\u0006\u0012\u0004\u0018\u0001H104H\u0016¢\u0006\u0002\u00105J\u0014\u00106\u001a\u00020\u000b*\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0002J\f\u00108\u001a\u00020\u000b*\u00020\u000bH\u0002R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048VX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8VX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001a\u0010\u0012R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b#\u0010\t\u001a\u0004\b\"\u0010\rR\u001b\u0010$\u001a\u00020%8BX\u0002¢\u0006\f\n\u0004\b(\u0010\t\u001a\u0004\b&\u0010'¨\u0006:"}, d2 = {"Lcom/baidu/swan/webcompat/impl/WebCompatImpl;", "Lcom/baidu/swan/webcompat/ioc/IWebCompat;", "()V", "baseUri", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getBaseUri", "()Landroid/net/Uri;", "baseUri$delegate", "Lkotlin/Lazy;", "baseUriString", "", "getBaseUriString", "()Ljava/lang/String;", "baseUriString$delegate", "externalFilePathInfo", "Lcom/baidu/swan/webcompat/impl/FilePathInfo;", "getExternalFilePathInfo", "()Lcom/baidu/swan/webcompat/impl/FilePathInfo;", "externalFilePathInfo$delegate", "externalStorageFilesPathHandler", "Lcom/baidu/swan/webcompat/impl/ExternalStoragePathHandler;", "getExternalStorageFilesPathHandler", "()Lcom/baidu/swan/webcompat/impl/ExternalStoragePathHandler;", "externalStorageFilesPathHandler$delegate", "internalFilePathInfo", "getInternalFilePathInfo", "internalFilePathInfo$delegate", "internalStorageFilesPathHandler", "Landroidx/webkit/WebViewAssetLoader$InternalStoragePathHandler;", "getInternalStorageFilesPathHandler", "()Landroidx/webkit/WebViewAssetLoader$InternalStoragePathHandler;", "internalStorageFilesPathHandler$delegate", "localAssetDomain", "getLocalAssetDomain", "localAssetDomain$delegate", "localAssetLoader", "Landroidx/webkit/WebViewAssetLoader;", "getLocalAssetLoader", "()Landroidx/webkit/WebViewAssetLoader;", "localAssetLoader$delegate", "getWebCompatUrl", "url", "handleIcon", "Landroid/webkit/WebResourceResponse;", "isExternalFilesUrl", "", "shouldInterceptRequest", "transformResponse", "Target", "response", "transform", "Lkotlin/Function1;", "(Landroid/webkit/WebResourceResponse;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "hashString", "algorithm", "pathForHandler", "Companion", "lib-swan-webcompat-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebCompatImpl.kt */
public final class WebCompatImpl implements IWebCompat {
    public static final String ASSET_FILES_PATH = "android_asset";
    public static final String ASSET_ROOT_URL = "file:///android_asset/";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String LOCAL_EXTERNAL_FILES_PATH = "external_files";
    public static final String LOCAL_FILES_PATH = "files";
    public static final String LOCAL_INTERNAL_FILES_PATH = "internal_files";
    public static final String RES_FILES_PATH = "android_res";
    public static final String RES_ICON_PATH = "favicon.ico";
    public static final String RES_ROOT_URL = "file:///android_res/";
    public static final String TAG = "WebCompatImpl";
    private final Lazy baseUri$delegate = LazyKt.lazy(new WebCompatImpl$baseUri$2(this));
    private final Lazy baseUriString$delegate = LazyKt.lazy(new WebCompatImpl$baseUriString$2(this));
    private final Lazy externalFilePathInfo$delegate = LazyKt.lazy(WebCompatImpl$externalFilePathInfo$2.INSTANCE);
    private final Lazy externalStorageFilesPathHandler$delegate = LazyKt.lazy(new WebCompatImpl$externalStorageFilesPathHandler$2(this));
    private final Lazy internalFilePathInfo$delegate = LazyKt.lazy(WebCompatImpl$internalFilePathInfo$2.INSTANCE);
    private final Lazy internalStorageFilesPathHandler$delegate = LazyKt.lazy(new WebCompatImpl$internalStorageFilesPathHandler$2(this));
    private final Lazy localAssetDomain$delegate = LazyKt.lazy(WebCompatImpl$localAssetDomain$2.INSTANCE);
    private final Lazy localAssetLoader$delegate = LazyKt.lazy(new WebCompatImpl$localAssetLoader$2(this));

    /* access modifiers changed from: private */
    public final FilePathInfo getInternalFilePathInfo() {
        return (FilePathInfo) this.internalFilePathInfo$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final FilePathInfo getExternalFilePathInfo() {
        return (FilePathInfo) this.externalFilePathInfo$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getLocalAssetDomain() {
        return (String) this.localAssetDomain$delegate.getValue();
    }

    public Uri getBaseUri() {
        return (Uri) this.baseUri$delegate.getValue();
    }

    public String getBaseUriString() {
        return (String) this.baseUriString$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final WebViewAssetLoader.InternalStoragePathHandler getInternalStorageFilesPathHandler() {
        return (WebViewAssetLoader.InternalStoragePathHandler) this.internalStorageFilesPathHandler$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ExternalStoragePathHandler getExternalStorageFilesPathHandler() {
        return (ExternalStoragePathHandler) this.externalStorageFilesPathHandler$delegate.getValue();
    }

    private final WebViewAssetLoader getLocalAssetLoader() {
        return (WebViewAssetLoader) this.localAssetLoader$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String pathForHandler(String $this$pathForHandler) {
        StringBuilder it = new StringBuilder($this$pathForHandler);
        if (!StringsKt.startsWith$default((CharSequence) it, (CharSequence) "/", false, 2, (Object) null)) {
            it.insert(0, "/");
        }
        if (!StringsKt.endsWith$default((CharSequence) it, (CharSequence) "/", false, 2, (Object) null)) {
            it.append("/");
        }
        String sb = it.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder(this).let …  it.toString()\n        }");
        return sb;
    }

    private static final String getWebCompatUrl$urlTransform(String $url, WebCompatImpl this$0, String prefix, String compatPath) {
        String str;
        if (prefix.length() > $url.length()) {
            return $url;
        }
        String substring = $url.substring(prefix.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        String str2 = substring;
        SwanAppLog.i(TAG, "getWebCompatUrl urlTransform path0=" + str2);
        int headerSlashCount = 0;
        WebCompatImpl webCompatImpl = this$0;
        CharSequence $this$forEach$iv = str2;
        if ($this$forEach$iv.length() > 0 && '/' == $this$forEach$iv.charAt(0)) {
            headerSlashCount = 0 + 1;
        }
        SwanAppLog.i(TAG, "getWebCompatUrl urlTransform headerSlashCount=" + headerSlashCount);
        if (headerSlashCount > 0) {
            str = str2.substring(headerSlashCount);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
        } else {
            str = str2;
        }
        String str3 = str;
        SwanAppLog.i(TAG, "getWebCompatUrl urlTransform path1=" + str3);
        String builder = this$0.getBaseUri().buildUpon().appendPath(compatPath).appendEncodedPath(str3).toString();
        Intrinsics.checkNotNullExpressionValue(builder, "baseUri.buildUpon()\n    …              .toString()");
        return builder;
    }

    private static final String getWebCompatUrl$externalUrlTransform(WebCompatImpl this$0, String $url) {
        FilePathInfo it = this$0.getExternalFilePathInfo();
        if (it != null) {
            String filesUrl = it.getFilesUrl();
            Intrinsics.checkNotNullExpressionValue(filesUrl, "it.filesUrl");
            String webCompatUrl$urlTransform = getWebCompatUrl$urlTransform($url, this$0, filesUrl, LOCAL_EXTERNAL_FILES_PATH);
            if (webCompatUrl$urlTransform != null) {
                return webCompatUrl$urlTransform;
            }
        }
        return $url;
    }

    public String getWebCompatUrl(String url) {
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        String filesUrl = getInternalFilePathInfo().getFilesUrl();
        Intrinsics.checkNotNullExpressionValue(filesUrl, "internalFilePathInfo.filesUrl");
        if (StringsKt.startsWith(url, filesUrl, true)) {
            String filesUrl2 = getInternalFilePathInfo().getFilesUrl();
            Intrinsics.checkNotNullExpressionValue(filesUrl2, "internalFilePathInfo.filesUrl");
            str = getWebCompatUrl$urlTransform(url, this, filesUrl2, LOCAL_INTERNAL_FILES_PATH);
        } else if (StringsKt.startsWith(url, "files", true)) {
            str = getWebCompatUrl$urlTransform(url, this, "files", LOCAL_INTERNAL_FILES_PATH);
        } else if (StringsKt.startsWith(url, "file:///android_asset/", true)) {
            str = getWebCompatUrl$urlTransform(url, this, "file:///android_asset/", ASSET_FILES_PATH);
        } else if (StringsKt.startsWith(url, RES_ROOT_URL, true)) {
            str = getWebCompatUrl$urlTransform(url, this, RES_ROOT_URL, RES_FILES_PATH);
        } else if (isExternalFilesUrl(url)) {
            str = getWebCompatUrl$externalUrlTransform(this, url);
        } else {
            str = url;
        }
        String $this$getWebCompatUrl_u24lambda_u2d4 = str;
        SwanAppLog.i(TAG, "getWebCompatUrl: ret update = " + (true ^ Intrinsics.areEqual((Object) $this$getWebCompatUrl_u24lambda_u2d4, (Object) url)) + "\n > from url = " + url + "\n > to   url = " + $this$getWebCompatUrl_u24lambda_u2d4);
        return str;
    }

    private final boolean isExternalFilesUrl(String url) {
        FilePathInfo it = getExternalFilePathInfo();
        if (it == null) {
            return false;
        }
        String filesUrl = it.getFilesUrl();
        Intrinsics.checkNotNullExpressionValue(filesUrl, "it.filesUrl");
        return StringsKt.startsWith(url, filesUrl, true);
    }

    public WebResourceResponse shouldInterceptRequest(Uri url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (Intrinsics.areEqual((Object) getBaseUri() + "/favicon.ico", (Object) url.toString())) {
            return handleIcon();
        }
        WebResourceResponse $this$shouldInterceptRequest_u24lambda_u2d6 = getLocalAssetLoader().shouldInterceptRequest(url);
        SwanAppLog.i(TAG, "shouldInterceptRequest response=" + $this$shouldInterceptRequest_u24lambda_u2d6 + " for url=" + url);
        return $this$shouldInterceptRequest_u24lambda_u2d6;
    }

    public <Target> Target transformResponse(WebResourceResponse response, Function1<? super WebResourceResponse, ? extends Target> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        return transform.invoke(response);
    }

    private final String hashString(String $this$hashString, String algorithm) {
        MessageDigest instance = MessageDigest.getInstance(algorithm);
        byte[] bytes = $this$hashString.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] $this$fold$iv = instance.digest(bytes);
        Intrinsics.checkNotNullExpressionValue($this$fold$iv, "getInstance(algorithm).digest(toByteArray())");
        String str = "";
        int length = $this$fold$iv.length;
        for (int i2 = 0; i2 < length; i2++) {
            StringBuilder append = new StringBuilder().append(str);
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf($this$fold$iv[i2])}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            str = append.append(format).toString();
        }
        return str;
    }

    private final WebResourceResponse handleIcon() {
        return new WebResourceResponse((String) null, (String) null, 404, "404", (Map) null, (InputStream) null);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/swan/webcompat/impl/WebCompatImpl$Companion;", "", "()V", "ASSET_FILES_PATH", "", "ASSET_ROOT_URL", "LOCAL_EXTERNAL_FILES_PATH", "LOCAL_FILES_PATH", "LOCAL_INTERNAL_FILES_PATH", "RES_FILES_PATH", "RES_ICON_PATH", "RES_ROOT_URL", "TAG", "lib-swan-webcompat-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebCompatImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
