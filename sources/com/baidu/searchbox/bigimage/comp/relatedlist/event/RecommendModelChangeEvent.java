package com.baidu.searchbox.bigimage.comp.relatedlist.event;

import com.baidu.searchbox.bigimage.comp.page.model.ImagePageParams;
import com.baidu.searchbox.bigimage.comp.relatedlist.repo.ComposedList;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/relatedlist/event/RecommendModelChangeEvent;", "", "model", "Lcom/baidu/searchbox/bigimage/comp/relatedlist/repo/ComposedList;", "params", "Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Lcom/baidu/searchbox/bigimage/comp/relatedlist/repo/ComposedList;Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "getModel", "()Lcom/baidu/searchbox/bigimage/comp/relatedlist/repo/ComposedList;", "getParams", "()Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecommendModelChangeEvent.kt */
public final class RecommendModelChangeEvent {
    private final ComposedList model;
    private final ImagePageParams params;
    private final UniqueId token;

    public RecommendModelChangeEvent(ComposedList model2, ImagePageParams params2, UniqueId token2) {
        Intrinsics.checkNotNullParameter(model2, "model");
        Intrinsics.checkNotNullParameter(params2, "params");
        Intrinsics.checkNotNullParameter(token2, "token");
        this.model = model2;
        this.params = params2;
        this.token = token2;
    }

    public final ComposedList getModel() {
        return this.model;
    }

    public final ImagePageParams getParams() {
        return this.params;
    }

    public final UniqueId getToken() {
        return this.token;
    }
}
