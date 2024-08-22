package com.baidu.searchbox.search.webvideo.callback;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/search/webvideo/callback/SearchVideoH5CollectionEvent;", "", "url", "", "collocted", "", "(Ljava/lang/String;Z)V", "isCollocted", "()Z", "setCollocted", "(Z)V", "pageUrl", "getPageUrl", "()Ljava/lang/String;", "setPageUrl", "(Ljava/lang/String;)V", "lib_search_video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchVideoH5CollectionEvent.kt */
public final class SearchVideoH5CollectionEvent {
    private boolean isCollocted;
    private String pageUrl;

    public SearchVideoH5CollectionEvent(String url, boolean collocted) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.pageUrl = url;
        this.isCollocted = collocted;
    }

    public final String getPageUrl() {
        return this.pageUrl;
    }

    public final void setPageUrl(String str) {
        this.pageUrl = str;
    }

    public final boolean isCollocted() {
        return this.isCollocted;
    }

    public final void setCollocted(boolean z) {
        this.isCollocted = z;
    }
}
