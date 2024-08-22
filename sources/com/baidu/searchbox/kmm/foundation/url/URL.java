package com.baidu.searchbox.kmm.foundation.url;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0013\u0010\n\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/kmm/foundation/url/URL;", "", "uri", "", "(Ljava/lang/String;)V", "host", "getHost", "()Ljava/lang/String;", "path", "getPath", "query", "getQuery", "url", "Landroid/net/Uri;", "getUrl$com_baidu_searchbox_kmm_foundation_url", "()Landroid/net/Uri;", "setUrl$com_baidu_searchbox_kmm_foundation_url", "(Landroid/net/Uri;)V", "com.baidu.searchbox.kmm.foundation.url"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: URL.kt */
public final class URL {
    private Uri url;

    public final Uri getUrl$com_baidu_searchbox_kmm_foundation_url() {
        return this.url;
    }

    public final void setUrl$com_baidu_searchbox_kmm_foundation_url(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<set-?>");
        this.url = uri;
    }

    public final String getHost() {
        return this.url.getHost();
    }

    public final String getPath() {
        return this.url.getPath();
    }

    public final String getQuery() {
        return this.url.getQuery();
    }

    public URL(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Uri parse = Uri.parse(uri);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(uri)");
        this.url = parse;
    }
}
