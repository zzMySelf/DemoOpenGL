package com.baidu.swan.webcompat.impl;

import android.net.Uri;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118FX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/baidu/swan/webcompat/impl/FilePathInfo;", "", "root", "Ljava/io/File;", "(Ljava/io/File;)V", "filesPath", "", "getFilesPath", "()Ljava/lang/String;", "filesPath$delegate", "Lkotlin/Lazy;", "filesUrl", "getFilesUrl", "filesUrl$delegate", "getRoot", "()Ljava/io/File;", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "uri$delegate", "lib-swan-webcompat-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FilePathInfo.kt */
public final class FilePathInfo {
    private final Lazy filesPath$delegate = LazyKt.lazy(new FilePathInfo$filesPath$2(this));
    private final Lazy filesUrl$delegate = LazyKt.lazy(new FilePathInfo$filesUrl$2(this));
    private final File root;
    private final Lazy uri$delegate = LazyKt.lazy(new FilePathInfo$uri$2(this));

    public FilePathInfo(File root2) {
        Intrinsics.checkNotNullParameter(root2, "root");
        this.root = root2;
    }

    public final File getRoot() {
        return this.root;
    }

    public final Uri getUri() {
        Object value = this.uri$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-uri>(...)");
        return (Uri) value;
    }

    public final String getFilesUrl() {
        return (String) this.filesUrl$delegate.getValue();
    }

    public final String getFilesPath() {
        return (String) this.filesPath$delegate.getValue();
    }
}
